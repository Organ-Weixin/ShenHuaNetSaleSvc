package com.boot.security.server.websocket;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.security.server.apicontroller.reply.BaseReply;
import com.boot.security.server.apicontroller.reply.QueryScreenRoomReply.ScreenRoom;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.Couponsgroup;
import com.boot.security.server.model.Roomgift;
import com.boot.security.server.model.Roomgiftsend;
import com.boot.security.server.model.Roomgiftuser;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.CouponsgroupServiceImpl;
import com.boot.security.server.service.impl.RoomgiftServiceImpl;
import com.boot.security.server.service.impl.RoomgiftsendServiceImpl;
import com.boot.security.server.service.impl.RoomgiftuserServiceImpl;
import com.boot.security.server.service.impl.TicketusersServiceImpl;
import com.boot.security.server.apicontroller.reply.RoomGiftReply;
import com.boot.security.server.apicontroller.reply.RoomGiftReply.RoomGiftResult;

@Component
@ServerEndpoint(value="/webSocket/chat/{cinemaCode}/{roomCode}/{giftCode}/{giftType}/{actionType}/{openid}", configurator = WebSocketCfg.class)
public class ChatRoomServer {

	private static final Map<String, Set<Session>> rooms = new ConcurrentHashMap<String, Set<Session>>();
	private static final Map<String, Session> OpenidSession = new ConcurrentHashMap<String, Session>();  //用于定点发送消息
	private final Logger log = LoggerFactory.getLogger(getClass());
	private static String ADD_ROOM_LOCK = "ADD_ROOM_LOCK";
	
	@Autowired
	private CinemaServiceImpl _cinemaService;
	@Autowired
	private TicketusersServiceImpl ticketusersService;
	@Autowired
	private RoomgiftServiceImpl roomgiftService;
	@Autowired
	private RoomgiftsendServiceImpl roomgiftsendService;
	@Autowired
	private RoomgiftuserServiceImpl roomgiftuserService;
	@Autowired
    private CouponsServiceImpl couponsService;
	@Autowired
	private CouponsgroupServiceImpl couponsgroupService;
	
	@OnOpen
    public BaseReply connect(@PathParam("roomCode") String roomCode,@PathParam("openid") String openid, Session session){
		BaseReply reply = new BaseReply();
		if (!rooms.containsKey(roomCode)) { //房间暂未开启
			reply.ErrorMessage = "房间暂未开启";
			return reply;
		} else {
			synchronized (ADD_ROOM_LOCK){
                //直接添加用户到相应的房间
                rooms.get(roomCode).add(session);
                if(OpenidSession.containsKey(openid+roomCode)){
                    
                	OpenidSession.put(openid+roomCode,session);
                }else{
                	OpenidSession.put(openid+roomCode,session);
                }
            }
			System.out.println(openid+"加入了"+roomCode+"号房间"+";size:"+OpenidSession.size());
			
			reply.SetSuccessReply();
			return reply;
		}
	}
	
	@OnClose
    public void disConnect(@PathParam("roomCode") String roomCode,@PathParam("openid") String openid, Session session) {
        if(rooms.containsKey(roomCode) && rooms.get(roomCode).contains(session)){
            rooms.get(roomCode).remove(session);
            System.out.println(openid+"退出了"+roomCode+"号房间");
        }
    }
	
	@OnMessage
    public RoomGiftReply receiveMsg(@PathParam("cinemaCode") String cinemaCode,@PathParam("roomCode") String roomCode,@PathParam("giftCode") String giftCode,
    		@PathParam("giftType") String giftType,	@PathParam("actionType") String actionType,@PathParam("openid") String openid, Session session) throws Exception {
		RoomGiftReply reply = new RoomGiftReply();
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(cinemaCode);
		if(cinema == null){
			reply.SetCinemaInvalidReply();
			return reply;
		}
		//验证用户OpenId
		Ticketusers ticketuser = ticketusersService.getByopenids(openid);
		if(ticketuser == null){
			reply.SetOpenIDNotExistReply();
			return reply;
		}
		
		if("1".equals(actionType)){	//发放奖品
			if("2".equals(ticketuser.getRoll())){
				//验证发放次数是否超出上限
				List<Roomgiftsend> sendlist = roomgiftsendService.getByRoomCode(roomCode, giftCode);
				int sendNum = sendlist.size()+1;	//发送次数
				int sendNumber = 0;					//每次发放数量
				String giftName=null;
				String image=null;
				if("1".equals(giftType)) {	//实物
					Roomgift roomgift = roomgiftService.getByGiftCode(giftCode);
					if(roomgift == null){
						reply.SetGiftInvalidReply();
						return reply;
					}
					if(sendNum > roomgift.getGroupNumber()){	//超出最大发放组数
						reply.SetOverrunGiftReply();
						return reply;
					}
					giftName = roomgift.getGiftName();
					sendNumber = roomgift.getSendNumber();
					image = roomgift.getImage();
					
				} else if("2".equals(giftType)) {	//优惠劵
					Couponsgroup coupon = couponsgroupService.getByGroupCode(giftCode);
					if(coupon == null){
						reply.SetCouponsNotExistOrUsedReply();
						return reply;
					}
					if(sendNum > coupon.getSendGroupNumber()){	//超出最大发放组数
						reply.SetOverrunGiftReply();
						return reply;
					}
					//更新优惠劵-已发放数量
					int suedNumber = coupon.getIssuedNumber()+coupon.getSendNumber();
					if(suedNumber > coupon.getCouponsNumber()){	//	优惠劵库存不足
						reply.SetCouponsInadequateReply();
						return reply;
					}
					coupon.setIssuedNumber(suedNumber);
					int num = couponsgroupService.update(coupon);
					if(num == 0){
						reply.SetCouponsSendFailureReply();
						return reply;
					}
					giftName = coupon.getCouponsName();
					sendNumber = coupon.getSendNumber();
				}
				
				//存入到发放奖品记录表
				Roomgiftsend newgift = new Roomgiftsend();
				newgift.setRoomCode(roomCode);
				newgift.setGiftCode(giftCode);
				newgift.setGiftName(giftName);
				newgift.setGiftType(giftType);
				newgift.setSendNumber(sendNumber);
				newgift.setOpenid(openid);
				newgift.setSendTime(new Date());
				roomgiftsendService.save(newgift);
				
				//返回
				RoomGiftResult gift = new RoomGiftResult();
				gift.setOpenID(openid);
				gift.setGiftCode(giftCode);
				gift.setGiftName(giftName);
				gift.setGiftType(giftType);
				gift.setImage(image);
				reply.setData(gift);
				reply.SetSuccessReply();
				return reply;
			} else {
				reply.ErrorMessage = "普通用户不能发送奖品";
				return reply;
			}
		} else if("2".equals(actionType)){	//领取奖品
			synchronized (this){
				if("1".equals(ticketuser.getRoll())){
					List<Roomgiftuser> list = roomgiftuserService.getByRoomGift(roomCode, giftCode);//用户领取记录
					String giftName=null;
					String image=null;
					Date startDate = new Date();
					Date expireDate=new Date();
					if("1".equals(giftType)) {	//实物
						Roomgift roomgift = roomgiftService.getByGiftCode(giftCode);
						if(list != null && list.size() >= roomgift.getSendNumber()){
							reply.ErrorMessage = "奖品被抢光了";
							return reply;
						}
						giftName = roomgift.getGiftName();
						image = roomgift.getImage();
						expireDate = new Date(expireDate.getTime() + 1000*60*60*2);
						
					} else if("2".equals(giftType)) {	//优惠劵
						Couponsgroup coupon = couponsgroupService.getByGroupCode(giftCode);
						if(list != null && list.size() >= coupon.getSendNumber()){
							reply.ErrorMessage = "奖品被抢光了";
							return reply;
						}
						startDate = coupon.getEffectiveDate();
						expireDate = coupon.getExpireDate();
						if(coupon.getValidityType()==2){
							Calendar c = Calendar.getInstance();
							c.setTime(startDate);
							c.add(Calendar.DAY_OF_MONTH, coupon.getEffectiveDays());
							startDate = c.getTime();
							
							c.setTime(expireDate);
							c.add(Calendar.DAY_OF_MONTH, coupon.getValidityDays());
							expireDate = c.getTime();
			    		}
						giftName = coupon.getCouponsName();
						List<Coupons> couponslist = couponsService.getCanUseByGroupCode(giftCode);
						Coupons cou = couponslist.get(0);
						cou.setEffectiveDate(startDate);
						cou.setExpireDate(expireDate);
						cou.setStatus(1);
						cou.setOpenID(openid);
						cou.setReceiveDate(new Date());
						couponsService.update(cou);	//更新到优惠劵记录表
						
					}
					//存数据库-用户领取奖品表
					Roomgiftuser roomgiftuser = new Roomgiftuser();
					roomgiftuser.setOpenID(openid);
					roomgiftuser.setRoomCode(roomCode);
					roomgiftuser.setGiftCode(giftCode);
					roomgiftuser.setGiftName(giftName);
					roomgiftuser.setGiftType(giftType);
					roomgiftuser.setImage(image);
					roomgiftuser.setGetDate(new Date());
					roomgiftuser.setStartDate(startDate);
					roomgiftuser.setExpireDate(expireDate);
					roomgiftuserService.save(roomgiftuser);
					
					//返回
					RoomGiftResult data = new RoomGiftResult();
					data.setOpenID(roomgiftuser.getOpenID());
					data.setGiftCode(roomgiftuser.getGiftCode());
					data.setGiftName(roomgiftuser.getGiftName());
					data.setImage(roomgiftuser.getImage());
					data.setGetDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(roomgiftuser.getGetDate()));
					if(roomgiftuser.getStartDate() != null){
						data.setStartDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(roomgiftuser.getStartDate()));
					}
					if(roomgiftuser.getExpireDate() != null){
						data.setExpireDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(roomgiftuser.getExpireDate()));	
					}
					reply.setData(data);
					reply.SetSuccessReply();
					return reply;
					
				} else {
					reply.ErrorMessage = "管理员不能领取奖品";
					return reply;
				}
			}
		} else if("3".equals(actionType)){	//发消息时，giftcode传的是消息内容
			sendMessagetoRoom(roomCode,giftCode);
			reply.SetSuccessReply();
			return reply;
		}else {
			reply.ErrorMessage = "操作类型actionType 传值不对";
			return reply;
		}
		
		
	}
	
	@OnError
    public void error(Session session, Throwable t) {
        log.error("websocket发生错误："+t.toString());
    }
	
	
    public  void sendMessagetoRoom(String roomCode, String msg) throws Exception {
        for (Session session : rooms.get(roomCode)) {
            session.getBasicRemote().sendText(msg);
            System.out.println("发送给"+session.getId()+msg);
        }
    }
    
	//创建房间
    public void OpenRoom(String roomCode,ScreenRoom screenRoom){
    	if(!rooms.containsKey(roomCode)){ //房间不存在时
            Set<Session> room = new HashSet<>();
            // 开启房间
            new Thread(){
            	public void run() {
            		try {
						removeRoom(roomCode);	//关闭房间
					} catch (Exception e) {
						e.printStackTrace();
					} 
            	}
            }.start();
            rooms.put(roomCode, room);
    	}
    	
    }
    
    //关闭房间
    public void removeRoom(String roomCode) throws Exception {
        //移除房间号
        if(rooms.containsKey(roomCode)){
        	rooms.remove(roomCode);
        	for(String str : OpenidSession.keySet()){
                if(str.contains(roomCode)){
                	OpenidSession.remove(str);
                }
            }
        }
    }
}
