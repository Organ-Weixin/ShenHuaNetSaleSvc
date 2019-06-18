package com.boot.security.server.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.Couponsgroup;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Roomgift;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.service.impl.CouponsgroupServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.RoomgiftServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.websocket.ChatRoomServer;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/chatRoom")
public class ChatRoomController {
	
	@Autowired
	private ScreeninfoServiceImpl screeninfoService;
	@Autowired
	private FilminfoServiceImpl filminfoService;
	@Autowired
	private RoomgiftServiceImpl roomgiftService;
	@Autowired
	private CouponsgroupServiceImpl CouponsgroupService;
	
	@PostMapping("/getRooms")
	@ApiOperation(value = "根据影院获取聊天室房间列表")
	public List<Map<String ,Object>> getRooms(@RequestParam String cinemaCode){
		List<String> list = ChatRoomServer.getRoomByCinema(cinemaCode);		//获取房间名 根据房间名解析成影片信息
//        Cinema cinema = cinemaService.getByCinemaCode(cinemaCode);
        List<Map<String ,Object>> dataMap = new ArrayList<>();
        String infoStr[]=null;
        String hallCode=null;//影厅唯一编码
        String movieCode=null;//电影唯一编码
        String startTimeStr=null;//电影开始时间年月日时分秒
        String endTimeStr=null;//电影结束时间年月日时分秒
        Screeninfo screeninfo=null;//影厅
        Filminfo filminfo;//影片
        for(String nameStr:list){
            Map<String,Object> map = new HashMap<>();
            infoStr = nameStr.split("_");
            startTimeStr = infoStr[3];
            endTimeStr = infoStr[4];
            screeninfo = screeninfoService.getByScreenCode(cinemaCode, infoStr[1]);
            
    		filminfo = filminfoService.getByFilmCode(infoStr[2]);
            map.put("moviePhoto",filminfo.getImage());
            map.put("movieName",filminfo.getFilmName());
            map.put("hallName",screeninfo.getSName());
            map.put("startTime",startTimeStr);
            map.put("endTime",endTimeStr);
            map.put("roomName",nameStr);
            dataMap.add(map);
        }
        //以下是把房间数据排序（按时间升序）
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Collections.sort(dataMap, new Comparator<Map<String, Object>>() {
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Date startTime1 = null;
                try {
                    startTime1 = sdf.parse(o1.get("startTime").toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Date startTime2 = null;
                try {
                    startTime2 = sdf.parse(o2.get("startTime").toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if(startTime1.before(startTime2)){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        for(Map<String, Object> m : dataMap){
        	m.put("startTime", String.valueOf(m.get("startTime")).substring(11, 16).replace("-", ":"));
        	m.put("endTime", String.valueOf(m.get("endTime")).substring(11, 16).replace("-", ":"));
        }
        return dataMap;
	}
	
	@PostMapping("/getCanSendGifts")
	@ApiOperation(value = "查看当前房间可发放礼物列表")
	public Map<String,Object> canSend(@RequestParam String cinemaCode){
        	//先根据cinemaCode获取实物列表
		List<Roomgift> giftList=roomgiftService.getByCinema(cinemaCode);
        	//自己定义数据格式map
		//根据cinemaCode查出优惠券列表
		List<Couponsgroup> couponslist=CouponsgroupService.getChatRoomCouponsByCinemaCode(cinemaCode);	
//      Iterator<DXPlatTicket> it = platTicketList.iterator();
//      while(it.hasNext()){
//          DXPlatTicket dpt = it.next();
//          if(dpt.getStatus()==0){
//              it.remove();
//          }else{
//              dpt.setGiftType(2);
//          }
//      }
        	//放入map里 返回给前台
		 Map<String,Object> map = new HashMap<>();
         map.put("gift",giftList);
         map.put("coupons",couponslist);
         
       
        return map;
    }
	
	@PostMapping("/getRoomTimestamp")
	@ApiOperation(value = "获取当前房间结束时间戳")
	public Map<String, Object> getTimestamp(@RequestParam String roomName) throws Exception{
		Map map = new HashMap();
		System.out.println("roomName:"+roomName);
        if(StringUtils.isNotBlank(roomName)){
            String[] infoStr = roomName.split("_");
            String endTimeStr = infoStr[3];
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            Date endTime = sdf.parse(endTimeStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endTime);
            calendar.add(Calendar.MINUTE,40);
            Long timestamp = calendar.getTimeInMillis();
            map.put("timestamp",timestamp);
            map.put("status", 1);
            map.put("code", "success");
            map.put("message", "请求成功！");
        }else{
        	map.put("timestamp",null);
            map.put("status", 0);
            map.put("code", "error");
            map.put("message", "缺少参数");
        }
        return map;
    }
	
	
	@GetMapping("/getAllRooms")
	@ApiOperation(value = "根据影院获取聊天室房间列表")
	public List<Map<String ,Object>> getRooms(){
		List<String> list = ChatRoomServer.getAllRoom();		//获取房间名 根据房间名解析成影片信息
        List<Map<String ,Object>> dataMap = new ArrayList<>();
        String infoStr[]=null;
        String hallCode=null;//影厅唯一编码
        String movieCode=null;//电影唯一编码
        String startTimeStr=null;//电影开始时间年月日时分秒
        String endTimeStr=null;//电影结束时间年月日时分秒
        Screeninfo screeninfo=null;//影厅
        Filminfo filminfo;//影片
        for(String nameStr:list){
            Map<String,Object> map = new HashMap<>();
            infoStr = nameStr.split("_");
            startTimeStr = infoStr[3];
            endTimeStr = infoStr[4];
            screeninfo = screeninfoService.getByScreenCode(infoStr[0], infoStr[1]);
            
    		filminfo = filminfoService.getByFilmCode(infoStr[2]);
            map.put("moviePhoto",filminfo.getImage());
            map.put("movieName",filminfo.getFilmName());
            map.put("hallName",screeninfo.getSName());
            map.put("startTime",startTimeStr);
            map.put("endTime",endTimeStr);
            map.put("roomName",nameStr);
            dataMap.add(map);
        }
        //以下是把房间数据排序（按时间升序）
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Collections.sort(dataMap, new Comparator<Map<String, Object>>() {
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Date startTime1 = null;
                try {
                    startTime1 = sdf.parse(o1.get("startTime").toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Date startTime2 = null;
                try {
                    startTime2 = sdf.parse(o2.get("startTime").toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if(startTime1.before(startTime2)){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        return dataMap;
	}
	
	
}
