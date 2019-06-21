package com.boot.security.server.websocket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.boot.security.server.apicontroller.reply.BaseReply;
import com.boot.security.server.apicontroller.reply.QueryScreenRoomReply.ScreenRoom;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.CouponsStatusEnum;
import com.boot.security.server.model.Couponsgroup;
import com.boot.security.server.model.DXChatMessage;
import com.boot.security.server.model.LockerPool;
import com.boot.security.server.model.Roomgift;
import com.boot.security.server.model.Roomgiftsend;
import com.boot.security.server.model.Roomgiftuser;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.service.CinemaService;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.CouponsgroupServiceImpl;
import com.boot.security.server.service.impl.RoomgiftServiceImpl;
import com.boot.security.server.service.impl.RoomgiftsendServiceImpl;
import com.boot.security.server.service.impl.RoomgiftuserServiceImpl;
import com.boot.security.server.service.impl.TicketusersServiceImpl;

import net.sf.json.JSONObject;

import com.boot.security.server.apicontroller.reply.RoomGiftReply;
import com.boot.security.server.apicontroller.reply.RoomGiftReply.RoomGiftResult;





@Component
@ServerEndpoint(value="/webSocket/chat/{roll}/{roomName}/{phoneOrOpenid}")
public class ChatRoomServer {

	private static final Map<String, Set<Session>> rooms = new ConcurrentHashMap();
    private static final Map<String, Session> phoneOrOpenidSession = new ConcurrentHashMap();  //用于定点发送消息
    private final Logger log = LoggerFactory.getLogger(getClass());
//    private Roomgift roomGift;
//    private DXChatRoomGiftSendRecords giftSendRecords;
    public static final Lock addRoomLock = new ReentrantLock();
    

	private static RoomgiftServiceImpl roomGiftService;
    @Autowired
	public void setRoomgiftService(RoomgiftServiceImpl roomGiftService) {
		ChatRoomServer.roomGiftService = roomGiftService;
    }
    private static RoomgiftsendServiceImpl roomgiftsendService;
    @Autowired
	public void setRoomgiftsendService(RoomgiftsendServiceImpl roomgiftsendService) {
		ChatRoomServer.roomgiftsendService = roomgiftsendService;
    }
    private static CouponsgroupServiceImpl couponsgroupService;
    @Autowired
	public void setCouponsgroupService(CouponsgroupServiceImpl couponsgroupService) {
		ChatRoomServer.couponsgroupService = couponsgroupService;
    }
    private static CouponsServiceImpl couponsService;
    @Autowired
	public void setCouponsService(CouponsServiceImpl couponsService) {
		ChatRoomServer.couponsService = couponsService;
    }
    private static RoomgiftuserServiceImpl roomgiftuserService;
    @Autowired
	public void setRoomgiftuserService(RoomgiftuserServiceImpl roomgiftuserService) {
		ChatRoomServer.roomgiftuserService = roomgiftuserService;
    }


    @OnOpen
    public void connect(@PathParam("roll") String roll, @PathParam("roomName") String roomName,
                        @PathParam("phoneOrOpenid") String phoneOrOpenid, Session session) throws Exception {
    	Roomgift roomGift = roomGiftService.getById(2L);
        // 将session按照房间名来存储，将各个房间的用户隔离
    	DXChatMessage chatMessage = new DXChatMessage();
        if (!rooms.containsKey(roomName)) { //房间暂未开启
            chatMessage.setRole(roll);
            chatMessage.setHeader("");
            chatMessage.setNickname("");
            chatMessage.setMessageType("-2");
            chatMessage.setContent("");
            chatMessage.setPrizeId("");
            chatMessage.setPhoneOrOpenid("");
            log.info("房间已结束");
            session.getBasicRemote().sendText(chatMessage.toString());
            return;
        } else {
            // 判断是否处于电影开始前20分钟和开始后40分钟之间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            String infoStr[] = roomName.split("_");
            String startTimeStr = infoStr[3];
            String endTimeStr = infoStr[4];
            Date sTime = sdf.parse(startTimeStr);
            Date eTime = sdf.parse(endTimeStr);
            Date now = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sTime);
            calendar.add(Calendar.MINUTE,-20);
            Date beginTime = calendar.getTime();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(eTime);
            calendar2.add(Calendar.MINUTE,20);
            Date endTime = calendar2.getTime();//房间结束时间
            if(now.getTime()<beginTime.getTime()){ //未开启
                chatMessage.setRole(roll);
                chatMessage.setHeader("");
                chatMessage.setNickname("");
                chatMessage.setMessageType("-1");
                chatMessage.setContent("");
                chatMessage.setPrizeId("");
                log.info("房间未开启");
                session.getBasicRemote().sendText(chatMessage.toString());
            }else if(now.getTime()>endTime.getTime()){
                chatMessage.setRole(roll);
                chatMessage.setHeader("");
                chatMessage.setNickname("");
                chatMessage.setMessageType("-2");
                chatMessage.setContent("");
                chatMessage.setPrizeId("");
                log.info("房间已结束");
                session.getBasicRemote().sendText(chatMessage.toString());
            }else{
				  try {
					  addRoomLock.lock();
	                    //直接添加用户到相应的房间
	                    rooms.get(roomName).add(session);
	                    if(phoneOrOpenidSession.containsKey(phoneOrOpenid+roomName)){
	                        chatMessage.setRole(roll);
	                        chatMessage.setHeader("");
	                        chatMessage.setNickname("");
	                        chatMessage.setMessageType("0");
	                        chatMessage.setContent("");
	                        chatMessage.setPrizeId("");
	                        sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
	                        phoneOrOpenidSession.put(phoneOrOpenid+roomName,session);
	                    }else{
	                        phoneOrOpenidSession.put(phoneOrOpenid+roomName,session);
	                    }
	                    log.info(phoneOrOpenid+"加入了"+roomName+"号房间"+";size:"+phoneOrOpenidSession.size());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					addRoomLock.unlock();
				}	
            }
        }
    }

    @OnClose
    public void disConnect(@PathParam("roomName") String roomName,@PathParam("phoneOrOpenid") String phoneOrOpenid, Session session) {
        if(rooms.containsKey(roomName)&&rooms.get(roomName).contains(session)){
            rooms.get(roomName).remove(session);
            log.info(phoneOrOpenid+"退出了"+roomName+"号房间");
        }
    }


    @OnMessage
    public void receiveMsg(@PathParam("roll") String roll,@PathParam("roomName") String roomName,@PathParam("phoneOrOpenid") String phoneOrOpenid, String msg, Session session) throws Exception {
    	DXChatMessage chatMessage = new DXChatMessage();
    	Map<String,String> map = JSONObject.fromObject(msg);
        String header = map.get("header");
        String nickName = map.get("nickName");
        String messageType = map.get("messageType");
        String messageContent = map.get("messageContent");
//        messageContent= WordFilterUtil.filterText(messageContent, '*').getFilteredContent();	//过滤敏感词
        String prizeId = map.get("prizeId");
        String[] prizeInfo = prizeId.split("_");
        if(messageType.equals("2")){ //发送奖品
            if(roll.equals("2")){	//验证是否是管理员
                //记录奖品发送数量
                if(messageContent.equals("1")){	//发放实物
                	Roomgift roomGift = roomGiftService.getById(Long.parseLong(prizeInfo[0]));
                    List<Roomgiftsend> list = roomgiftsendService.getByRoomCode("1",prizeInfo[0],roomName);//查出聊天室发放的该礼物数量
                    if(list!=null&&list.size()>= roomGift.getGroupNumber()){
                        chatMessage.setRole(roll);
                        chatMessage.setHeader(header);
                        chatMessage.setNickname(nickName);
                        chatMessage.setMessageType("-11");//表示当前聊天室已经超过规定组数
                        chatMessage.setContent("");
                        chatMessage.setPrizeId("");
                        chatMessage.setPhoneOrOpenid("");
                        session.getBasicRemote().sendText(chatMessage.toString());
                        return;
                    }
                    Roomgiftsend giftSendRecords = new Roomgiftsend();
                    giftSendRecords.setGiftName(roomGift.getGiftName()); //奖品名
                    giftSendRecords.setSendNumber(roomGift.getSendNumber()); //发送数量
                    giftSendRecords.setGiftCode("");
                    giftSendRecords.setGiftCode(prizeInfo[0]);
                    giftSendRecords.setRoomCode(roomName);
                    giftSendRecords.setOpenid(phoneOrOpenid);
                    giftSendRecords.setTimestamp(prizeInfo[1]);
                    giftSendRecords.setGiftType("1");
                    roomgiftsendService.save(giftSendRecords);
                }else if(messageContent.equals("2")){
                    Couponsgroup couponsgroup=couponsgroupService.getById(Long.parseLong(prizeInfo[0]));
                	List<Coupons> list=couponsService.getByGroupCode(couponsgroup.getGroupCode());
                	log.info(list.size()+"========");
                	//这里的限制 走不通 原逻辑是每个房间可设置最多发放几组（可自己按照此思路解决）
//                	if(list!=null&&list.size()>=(couponsgroup.getCouponsNumber()-couponsgroup.getIssuedNumber())){
//                        chatMessage.setHeader(header);
//                        chatMessage.setRole(roll);
//                        chatMessage.setNickname(nickName);
//                        chatMessage.setMessageType("-11");//表示当前聊天室已经超过可用优惠券数
//                        chatMessage.setContent("");
//                        chatMessage.setPrizeId("");
//                        chatMessage.setPhoneOrOpenid("");
//                        log.info("达到最大数量限制");
//                        session.getBasicRemote().sendText(chatMessage.toString());
//                        return;
//                    }
                    //couponsgroup.setSendNumber(couponsgroup.getSendNumber());
                    //couponsgroup.setIssuedNumber(couponsgroup.getIssuedNumber()==null?1:couponsgroup.getIssuedNumber()+couponsgroup.getSendNumber());
                    couponsgroupService.update(couponsgroup);
                    //生成优惠券
                    /*for(int i=0;i<couponsgroup.getCouponsNumber();i++){
                		Coupons coupons = new Coupons();
                		//优惠券编码--13位时间戳加5位随机数
                		String couponsCode = String.valueOf(new Date().getTime());
                		couponsCode+=(int)((Math.random()*9+1)*10000);
                		coupons.setCouponsCode(couponsCode);
                    	coupons.setCouponsName(couponsgroup.getCouponsName());
                    	coupons.setEffectiveDate(couponsgroup.getEffectiveDate());
                    	coupons.setExpireDate(couponsgroup.getExpireDate());
                    	coupons.setGroupCode(couponsgroup.getGroupCode());
                    	coupons.setStatus(CouponsStatusEnum.Created.getStatusCode());
                    	couponsService.save(coupons);
                	}*/
                    
                    /*Roomgiftsend giftSendRecords = new Roomgiftsend();
                    giftSendRecords.setGiftName(couponsgroup.getCouponsName()); //奖品名
                    giftSendRecords.setSendNumber(couponsgroup.getSendNumber()); //发送数量       //少了一个券包，少了一层
                    //giftSendRecords.setMemo(couponsgroup.getCouponsName());
                    giftSendRecords.setGiftCode(prizeInfo[0]);
                    giftSendRecords.setRoomCode(roomName);
                    giftSendRecords.setOpenid(phoneOrOpenid);
                    giftSendRecords.setTimestamp(prizeInfo[1]);
                    giftSendRecords.setGiftType("2");
                    roomgiftsendService.save(giftSendRecords);
                    log.info("555555");*/
                }
            }else{
                log.info("普通用户不能发送奖品");
                return;
            }
        }else if(messageType.equals("21")){ //领取奖品
            Integer type = Integer.parseInt(messageContent);//领取奖品类型 ，1是实物，2是优惠券
            String cinemaCode = roomName.substring(0,roomName.indexOf("_"));
//            Cinema cinema = cinemaService.getByCinemaCode(cinemaCode);
//            if(cinema!=null){
//                if(dxCinema.getMaxGetNumber()!=null&&cinema.getMaxGetNumber()>0){
//                    List<DXChatUserGift> getList = dxChatUserGiftService.getMonthNumber(phoneOrOpenid,Long.parseLong(prizeInfo[0]),type);
//                    if(getList!=null&&getList.size()>=cinema.getMaxGetNumber()){
//                        chatMessage.setRole(roll);
//                        chatMessage.setHeader(header);
//                        chatMessage.setNickname(nickName);
//                        chatMessage.setContent("礼物被抢光了");
//                        chatMessage.setMessageType("-3");
//                        chatMessage.setPrizeId(prizeInfo[0]);
//                        sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
//                        return;
//                    }
//                }
//            }
            synchronized (LockerPool.getSingleton().getLocker(prizeId)){
            	List<Roomgiftuser> list=roomgiftuserService.getByOpenidAndRoomAndtime(type.toString(),phoneOrOpenid,roomName,prizeInfo[1]);
                //List<DXChatUserGift> list = dxChatUserGiftService.getByPhoneAndRoom(type,Long.parseLong(prizeInfo[0]),roomName,prizeInfo[1]);
                if(type==1){  //领取实物
                	Roomgift roomGift = roomGiftService.getById(Long.parseLong(prizeInfo[0]));
                    if(list!=null&&list.size()>=roomGift.getSendNumber()){ //已领取完
                        chatMessage.setRole(roll);
                        chatMessage.setHeader(header);
                        chatMessage.setNickname(nickName);
                        chatMessage.setMessageType("-3");
                        chatMessage.setContent("礼物被抢光了");
                        chatMessage.setPrizeId(prizeInfo[0]);
                        sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
                    }else{ //发放奖品
                        String[] roomStr = roomName.split("_");
                        String endStr = roomStr[4]; //yyyy-MM-dd-HH-mm-ss
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
                        Date endTime = sdf.parse(endStr);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(endTime);
                        calendar.add(Calendar.MINUTE,30);
                        Date overTime = calendar.getTime();
                        Roomgiftuser roomgift = new Roomgiftuser();
                        roomgift.setGiftCode(prizeInfo[0]);
                        roomgift.setOpenID(phoneOrOpenid);
                        //roomgift.setMemo(chatRoomGift.getMemo());
                        roomgift.setRoomCode(roomName);
                        roomgift.setTimestamp(prizeInfo[1]);
                        roomgift.setOpenID(roomgift.getOpenID());
                        roomgift.setExpireDate(overTime);
                        roomgift.setGiftType("1");
                        //roomgift.save(dxChatUserGift);
                        roomgiftuserService.save(roomgift);

                        chatMessage.setRole(roll);
                        chatMessage.setHeader(header);
                        chatMessage.setNickname(nickName);
                        chatMessage.setMessageType("3");
                        chatMessage.setContent("恭喜你获得了"+roomgift.getGiftName());
                        chatMessage.setPrizeId(prizeId);
                        sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
                        Roomgiftsend sendRecords = roomgiftsendService.getByGiftAndRoomAndTimestamp("1",prizeInfo[0],roomName,prizeInfo[1]);
                        chatMessage.setMessageType("22");
                        chatMessage.setContent(String.valueOf(roomGift.getSendNumber()-list.size()-1));
                        log.info(chatMessage.getContent()+"======"+list.size());
                        sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
                    }
                }else if(type==2){
                	Couponsgroup couponsgroup=couponsgroupService.getById(Long.parseLong(prizeInfo[0]));
                    if(list!=null&&list.size()>=(couponsgroup.getCouponsNumber()-couponsgroup.getIssuedNumber())){ //已领取完
                        chatMessage.setHeader(header);
                        chatMessage.setRole(roll);
                        chatMessage.setNickname(nickName);
                        chatMessage.setMessageType("-3");
                        chatMessage.setContent("礼物被抢光了");
                        chatMessage.setPrizeId(prizeInfo[0]);
                        sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
                    }else{ //领优惠券
                    	 Roomgiftuser roomgift = new Roomgiftuser();
                         roomgift.setGiftCode(prizeInfo[0]);
                         roomgift.setOpenID(phoneOrOpenid);
                         //roomgift.setMemo(chatRoomGift.getMemo());
                         roomgift.setRoomCode(roomName);
                         roomgift.setTimestamp(prizeInfo[1]);
                         roomgift.setOpenID(roomgift.getOpenID());
                         //roomgift.setExpireDate(overTime);
                         roomgift.setGiftType("2");
                         //roomgift.save(dxChatUserGift);
                         roomgiftuserService.save(roomgift);

                        List<Coupons> couponsList=couponsService.getByGroupCode(couponsgroup.getGroupCode());
                        for(Coupons coupons :couponsList){
                			coupons.setOpenID(phoneOrOpenid);
                			coupons.setStatus(CouponsStatusEnum.Fetched.getStatusCode());
                			couponsService.update(coupons);
                        }
                    	//已发放数量
            			couponsgroup.setIssuedNumber(couponsgroup.getCouponsNumber());
            			//已领取数量
            			couponsgroup.setFetchNumber(couponsgroup.getCouponsNumber());
            			//剩余数量
            			couponsgroup.setRemainingNumber(0);
            			couponsgroup.setUpdateDate(new Date());
            			couponsgroupService.update(couponsgroup);
                        
                        chatMessage.setRole(roll);
                        chatMessage.setHeader(header);
                        chatMessage.setNickname(nickName);
                        chatMessage.setMessageType("3");
                        chatMessage.setContent("恭喜你获得了"+couponsgroup.getCouponsName());
                        chatMessage.setPrizeId(prizeId);
                        sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
                        Roomgiftsend sendRecords = roomgiftsendService.getByGiftAndRoomAndTimestamp("2",prizeInfo[0],roomName,prizeInfo[1]);
                        chatMessage.setMessageType("22");
                        //chatMessage.setContent(String.valueOf(couponsgroup.getSendNumber()-list.size()-1));
                        sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
                    }
                }
                return;
            }
        }
        chatMessage.setRole(roll);
        chatMessage.setHeader(header);
        chatMessage.setNickname(nickName);
        chatMessage.setMessageType(messageType);
        chatMessage.setContent(messageContent);
        chatMessage.setPrizeId(prizeId);
        chatMessage.setPhoneOrOpenid(phoneOrOpenid);
        if(messageType.equals("5")){
            sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
        }else{
            sendMessagetoRoom(roomName, chatMessage.toString());
        }

    }


    @OnError
    public void error(Session session, Throwable t) {
        log.error("websocket发生错误："+t.toString());
    }

    public  void sendMessagetoRoom(String roomName, String msg) throws Exception {
        for (Session session : rooms.get(roomName)) {
            session.getBasicRemote().sendText(msg);
            log.info("发送给"+session.getId()+msg);
        }
    }

    //关闭房间
    public void removeRoomName(String roomName) throws Exception {
        //移除房间号
        if(rooms.containsKey(roomName)){
            DXChatMessage chatMessage = new DXChatMessage();
            chatMessage.setRole("1");
            chatMessage.setHeader("");
            chatMessage.setNickname("");
            chatMessage.setMessageType("-2");
            chatMessage.setContent("");
            chatMessage.setPrizeId("");
            sendMessagetoRoom(roomName, chatMessage.toString());
            rooms.remove(roomName);
            for(String str:phoneOrOpenidSession.keySet()){
                if(str.contains(roomName)){
                    phoneOrOpenidSession.remove(str);
                }
            }
            log.info("关闭房间:"+roomName);
        }
    }

    //创建房间
    public void OpenRoomName(String roomName, Sessioninfo sessioninfo) {
        if(!rooms.containsKey(roomName)){ //房间不存在时
            Set<Session> room = new HashSet<>();
            // 开启房间
            log.info("开启房间:"+roomName);
            Calendar calendar = Calendar.getInstance();
            new Thread(){
                public void run() {
                    Date endTime = sessioninfo.getStartTime();
                    Date now = new Date();
                    Long endMillisecond = endTime.getTime()+40*60*1000; //场次结束后40分钟关闭
                    Long nowMillisecond = now.getTime();
                    Long remainMillisecond = (endMillisecond-nowMillisecond)/1000;
                    log.info("距离聊天室关闭剩余"+remainMillisecond/60+"分钟");
                    while(remainMillisecond>0) {
                        remainMillisecond--;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            try {
                                new ChatRoomServer().removeRoomName(roomName);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                            e.printStackTrace();
                            this.interrupt();
                            log.info("聊天室倒计时出现异常,线程终止");
                        }
                    }
                    try{
                        new ChatRoomServer().removeRoomName(roomName);  //关闭房间
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        this.interrupt();
                        log.info("线程终止");
                    }
                }

            }.start();
            rooms.put(roomName, room);
        }
    }

    //获取当前房间列表
    public static List<String> getRoomByCinema(String cinemaCode){
        if(StringUtils.isNotBlank(cinemaCode)){
            List<String> list = new ArrayList<>(rooms.size());
            for(String roomName:rooms.keySet()){
                if(roomName.startsWith(cinemaCode+"_")){
                    list.add(roomName);
                }
            }
            return list;
        }
        return null;
    }
    //获取所有房间列表
    public static List<String> getAllRoom(){
        List<String> list = new ArrayList<>(rooms.size());
        for(String roomName:rooms.keySet()){
            list.add(roomName);
        }
        return list;
    }

    //发送消息给指定用户
    public void sendMessage(String phoneOrOpenid,String msg) throws Exception{
        Session session = phoneOrOpenidSession.get(phoneOrOpenid);
        if(session.isOpen()){
            session.getBasicRemote().sendText(msg);
        }
    }

}



//@Component
//@ServerEndpoint(value="/webSocket/chat/{roll}/{roomName}/{phoneOrOpenid}")
//public class ChatRoomServer {
//
//	private static final Map<String, Set<Session>> rooms = new ConcurrentHashMap();
//    private static final Map<String, Session> phoneOrOpenidSession = new ConcurrentHashMap();  //用于定点发送消息
//    private final Logger log = LoggerFactory.getLogger(getClass());
////    private Roomgift roomGift;
////    private DXChatRoomGiftSendRecords giftSendRecords;
//    public static final Lock addRoomLock = new ReentrantLock();
//    
//
//    private static ApplicationContext applicationContext;
// 
//	public static void setApplicationContext(ApplicationContext context) {
//	    applicationContext = context;
//	}
//    
////    @Autowired
////    private RoomgiftServiceImpl roomGiftService;
////    @Autowired
////    private RoomgiftsendServiceImpl roomgiftsendService;
////    @Autowired
////    private CouponsgroupServiceImpl CouponsgroupService;
////    @Autowired
////    private CouponsServiceImpl CouponsService;
////    @Autowired
////    private RoomgiftuserServiceImpl roomgiftuserService;
//
//
//    @OnOpen
//    public void connect(@PathParam("roll") String roll, @PathParam("roomName") String roomName,
//                        @PathParam("phoneOrOpenid") String phoneOrOpenid, Session session) throws Exception {
//        // 将session按照房间名来存储，将各个房间的用户隔离
//    	DXChatMessage chatMessage = new DXChatMessage();
//        if (!rooms.containsKey(roomName)) { //房间暂未开启
//            chatMessage.setRole(roll);
//            chatMessage.setHeader("");
//            chatMessage.setNickname("");
//            chatMessage.setMessageType("-2");
//            chatMessage.setContent("");
//            chatMessage.setPrizeId("");
//            chatMessage.setPhoneOrOpenid("");
//            log.info("房间已结束");
//            session.getBasicRemote().sendText(chatMessage.toString());
//            return;
//        } else {
//            // 判断是否处于电影开始前20分钟和开始后40分钟之间
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
//            String infoStr[] = roomName.split("_");
//            String startTimeStr = infoStr[3];
//            String endTimeStr = infoStr[4];
//            Date sTime = sdf.parse(startTimeStr);
//            Date eTime = sdf.parse(endTimeStr);
//            Date now = new Date();
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(sTime);
//            calendar.add(Calendar.MINUTE,-20);
//            Date beginTime = calendar.getTime();
//            Calendar calendar2 = Calendar.getInstance();
//            calendar2.setTime(eTime);
//            calendar2.add(Calendar.MINUTE,20);
//            Date endTime = calendar2.getTime();//房间结束时间
//            if(now.getTime()<beginTime.getTime()){ //未开启
//                chatMessage.setRole(roll);
//                chatMessage.setHeader("");
//                chatMessage.setNickname("");
//                chatMessage.setMessageType("-1");
//                chatMessage.setContent("");
//                chatMessage.setPrizeId("");
//                log.info("房间未开启");
//                session.getBasicRemote().sendText(chatMessage.toString());
//            }else if(now.getTime()>endTime.getTime()){
//                chatMessage.setRole(roll);
//                chatMessage.setHeader("");
//                chatMessage.setNickname("");
//                chatMessage.setMessageType("-2");
//                chatMessage.setContent("");
//                chatMessage.setPrizeId("");
//                log.info("房间已结束");
//                session.getBasicRemote().sendText(chatMessage.toString());
//            }else{
//				  try {
//					  addRoomLock.lock();
//	                    //直接添加用户到相应的房间
//	                    rooms.get(roomName).add(session);
//	                    if(phoneOrOpenidSession.containsKey(phoneOrOpenid+roomName)){
//	                        chatMessage.setRole(roll);
//	                        chatMessage.setHeader("");
//	                        chatMessage.setNickname("");
//	                        chatMessage.setMessageType("0");
//	                        chatMessage.setContent("");
//	                        chatMessage.setPrizeId("");
//	                        sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
//	                        phoneOrOpenidSession.put(phoneOrOpenid+roomName,session);
//	                    }else{
//	                        phoneOrOpenidSession.put(phoneOrOpenid+roomName,session);
//	                    }
//	                    log.info(phoneOrOpenid+"加入了"+roomName+"号房间"+";size:"+phoneOrOpenidSession.size());
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					addRoomLock.unlock();
//				}	
//            }
//        }
//    }
//
//    @OnClose
//    public void disConnect(@PathParam("roomName") String roomName,@PathParam("phoneOrOpenid") String phoneOrOpenid, Session session) {
//        if(rooms.containsKey(roomName)&&rooms.get(roomName).contains(session)){
//            rooms.get(roomName).remove(session);
//            log.info(phoneOrOpenid+"退出了"+roomName+"号房间");
//        }
//    }
//
//
//    @OnMessage
//    public void receiveMsg(@PathParam("roll") String roll,@PathParam("roomName") String roomName,@PathParam("phoneOrOpenid") String phoneOrOpenid, String msg, Session session) throws Exception {
//    	DXChatMessage chatMessage = new DXChatMessage();
//    	Map<String,String> map = JSONObject.fromObject(msg);
//        String header = map.get("header");
//        String nickName = map.get("nickName");
//        String messageType = map.get("messageType");
//        String messageContent = map.get("messageContent");
////        messageContent= WordFilterUtil.filterText(messageContent, '*').getFilteredContent();	//过滤敏感词
//        String prizeId = map.get("prizeId");
//        String[] prizeInfo = prizeId.split("_");
//        if(messageType.equals("2")){ //发送奖品
//            if(roll.equals("2")){	//验证是否是管理员
//                //记录奖品发送数量
//                if(messageContent.equals("1")){	//发放实物
//                	RoomgiftServiceImpl rImpl = applicationContext.getBean(RoomgiftServiceImpl.class);
//                	Roomgift roomGift = rImpl.getById(Long.parseLong(prizeInfo[0]));
//                    List<Roomgiftsend> list = applicationContext.getBean(RoomgiftsendServiceImpl.class).getByRoomCode("1",prizeInfo[0],roomName);//查出聊天室发放的该礼物数量
//                    if(list!=null&&list.size()>= roomGift.getGroupNumber()){
//                        chatMessage.setRole(roll);
//                        chatMessage.setHeader(header);
//                        chatMessage.setNickname(nickName);
//                        chatMessage.setMessageType("-11");//表示当前聊天室已经超过规定组数
//                        chatMessage.setContent("");
//                        chatMessage.setPrizeId("");
//                        chatMessage.setPhoneOrOpenid("");
//                        session.getBasicRemote().sendText(chatMessage.toString());
//                        return;
//                    }
//                    Roomgiftsend giftSendRecords = new Roomgiftsend();
//                    giftSendRecords.setGiftName(roomGift.getGiftName()); //奖品名
//                    giftSendRecords.setSendNumber(roomGift.getSendNumber()); //发送数量
//                    giftSendRecords.setGiftCode("");
//                    giftSendRecords.setGiftCode(prizeInfo[0]);
//                    giftSendRecords.setRoomCode(roomName);
//                    giftSendRecords.setOpenid(phoneOrOpenid);
//                    giftSendRecords.setTimestamp(prizeInfo[1]);
//                    giftSendRecords.setGiftType("1");
//                    applicationContext.getBean(RoomgiftsendServiceImpl.class).save(giftSendRecords);
//                }else if(messageContent.equals("2")){
//                    Couponsgroup couponsgroup=applicationContext.getBean(CouponsgroupServiceImpl.class).getById(Long.parseLong(prizeInfo[0]));
//                	List<Coupons> list=applicationContext.getBean(CouponsServiceImpl.class).getByGroupCode(couponsgroup.getGroupCode());
//                	log.info(list.size()+"========");
//                	//这里的限制 走不通 原逻辑是每个房间可设置最多发放几组（可自己按照此思路解决）
////                	if(list!=null&&list.size()>=(couponsgroup.getCouponsNumber()-couponsgroup.getIssuedNumber())){
////                        chatMessage.setHeader(header);
////                        chatMessage.setRole(roll);
////                        chatMessage.setNickname(nickName);
////                        chatMessage.setMessageType("-11");//表示当前聊天室已经超过可用优惠券数
////                        chatMessage.setContent("");
////                        chatMessage.setPrizeId("");
////                        chatMessage.setPhoneOrOpenid("");
////                        log.info("达到最大数量限制");
////                        session.getBasicRemote().sendText(chatMessage.toString());
////                        return;
////                    }
//                    couponsgroup.setSendNumber(couponsgroup.getSendNumber());
//                    couponsgroup.setIssuedNumber(couponsgroup.getIssuedNumber()==null?1:couponsgroup.getIssuedNumber()+couponsgroup.getSendNumber());
//                    applicationContext.getBean(CouponsgroupServiceImpl.class).update(couponsgroup);
//                    //生成优惠券
//                    for(int i=0;i<couponsgroup.getCouponsNumber();i++){
//                		Coupons coupons = new Coupons();
//                		//优惠券编码--13位时间戳加5位随机数
//                		String couponsCode = String.valueOf(new Date().getTime());
//                		couponsCode+=(int)((Math.random()*9+1)*10000);
//                		coupons.setCouponsCode(couponsCode);
//                    	coupons.setCouponsName(couponsgroup.getCouponsName());
//                    	coupons.setEffectiveDate(couponsgroup.getEffectiveDate());
//                    	coupons.setExpireDate(couponsgroup.getExpireDate());
//                    	coupons.setGroupCode(couponsgroup.getGroupCode());
//                    	coupons.setStatus(CouponsStatusEnum.Created.getStatusCode());
//                    	applicationContext.getBean(CouponsServiceImpl.class).save(coupons);
//                	}
//                    
//                    Roomgiftsend giftSendRecords = new Roomgiftsend();
//                    giftSendRecords.setGiftName(couponsgroup.getCouponsName()); //奖品名
//                    giftSendRecords.setSendNumber(couponsgroup.getSendNumber()); //发送数量       //少了一个券包，少了一层
//                    //giftSendRecords.setMemo(couponsgroup.getCouponsName());
//                    giftSendRecords.setGiftCode(prizeInfo[0]);
//                    giftSendRecords.setRoomCode(roomName);
//                    giftSendRecords.setOpenid(phoneOrOpenid);
//                    giftSendRecords.setTimestamp(prizeInfo[1]);
//                    giftSendRecords.setGiftType("2");
//                    applicationContext.getBean(RoomgiftsendServiceImpl.class).save(giftSendRecords);
//                    log.info("555555");
//                }
//            }else{
//                log.info("普通用户不能发送奖品");
//                return;
//            }
//        }else if(messageType.equals("21")){ //领取奖品
//            Integer type = Integer.parseInt(messageContent);//领取奖品类型 ，1是实物，2是优惠券
//            String cinemaCode = roomName.substring(0,roomName.indexOf("_"));
////            Cinema cinema = cinemaService.getByCinemaCode(cinemaCode);
////            if(cinema!=null){
////                if(dxCinema.getMaxGetNumber()!=null&&cinema.getMaxGetNumber()>0){
////                    List<DXChatUserGift> getList = dxChatUserGiftService.getMonthNumber(phoneOrOpenid,Long.parseLong(prizeInfo[0]),type);
////                    if(getList!=null&&getList.size()>=cinema.getMaxGetNumber()){
////                        chatMessage.setRole(roll);
////                        chatMessage.setHeader(header);
////                        chatMessage.setNickname(nickName);
////                        chatMessage.setContent("礼物被抢光了");
////                        chatMessage.setMessageType("-3");
////                        chatMessage.setPrizeId(prizeInfo[0]);
////                        sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
////                        return;
////                    }
////                }
////            }
//            synchronized (LockerPool.getSingleton().getLocker(prizeId)){
//            	List<Roomgiftuser> list=applicationContext.getBean(RoomgiftuserServiceImpl.class).getByOpenidAndRoomAndtime(type.toString(),phoneOrOpenid,roomName,prizeInfo[1]);
//                //List<DXChatUserGift> list = dxChatUserGiftService.getByPhoneAndRoom(type,Long.parseLong(prizeInfo[0]),roomName,prizeInfo[1]);
//                if(type==1){  //领取实物
//                	Roomgift roomGift = applicationContext.getBean(RoomgiftServiceImpl.class).getById(Long.parseLong(prizeInfo[0]));
//                    if(list!=null&&list.size()>=roomGift.getSendNumber()){ //已领取完
//                        chatMessage.setRole(roll);
//                        chatMessage.setHeader(header);
//                        chatMessage.setNickname(nickName);
//                        chatMessage.setMessageType("-3");
//                        chatMessage.setContent("礼物被抢光了");
//                        chatMessage.setPrizeId(prizeInfo[0]);
//                        sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
//                    }else{ //发放奖品
//                        String[] roomStr = roomName.split("_");
//                        String endStr = roomStr[4]; //yyyy-MM-dd-HH-mm-ss
//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
//                        Date endTime = sdf.parse(endStr);
//                        Calendar calendar = Calendar.getInstance();
//                        calendar.setTime(endTime);
//                        calendar.add(Calendar.MINUTE,30);
//                        Date overTime = calendar.getTime();
//                        Roomgiftuser roomgift = new Roomgiftuser();
//                        roomgift.setGiftCode(prizeInfo[0]);
//                        roomgift.setOpenID(phoneOrOpenid);
//                        //roomgift.setMemo(chatRoomGift.getMemo());
//                        roomgift.setRoomCode(roomName);
//                        roomgift.setTimestamp(prizeInfo[1]);
//                        roomgift.setOpenID(roomgift.getOpenID());
//                        roomgift.setExpireDate(overTime);
//                        roomgift.setGiftType("1");
//                        //roomgift.save(dxChatUserGift);
//                        applicationContext.getBean(RoomgiftuserServiceImpl.class).save(roomgift);
//
//                        chatMessage.setRole(roll);
//                        chatMessage.setHeader(header);
//                        chatMessage.setNickname(nickName);
//                        chatMessage.setMessageType("3");
//                        chatMessage.setContent("恭喜你获得了"+roomgift.getGiftName());
//                        chatMessage.setPrizeId(prizeId);
//                        sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
//                        Roomgiftsend sendRecords = applicationContext.getBean(RoomgiftsendServiceImpl.class).getByGiftAndRoomAndTimestamp("1",prizeInfo[0],roomName,prizeInfo[1]);
//                        chatMessage.setMessageType("22");
//                        chatMessage.setContent(String.valueOf(roomGift.getSendNumber()-list.size()-1));
//                        log.info(chatMessage.getContent()+"======"+list.size());
//                        sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
//                    }
//                }else if(type==2){
//                	Couponsgroup couponsgroup=applicationContext.getBean(CouponsgroupServiceImpl.class).getById(Long.parseLong(prizeInfo[0]));
//                    if(list!=null&&list.size()>=(couponsgroup.getCouponsNumber()-couponsgroup.getIssuedNumber())){ //已领取完
//                        chatMessage.setHeader(header);
//                        chatMessage.setRole(roll);
//                        chatMessage.setNickname(nickName);
//                        chatMessage.setMessageType("-3");
//                        chatMessage.setContent("礼物被抢光了");
//                        chatMessage.setPrizeId(prizeInfo[0]);
//                        sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
//                    }else{ //领优惠券
//                    	 Roomgiftuser roomgift = new Roomgiftuser();
//                         roomgift.setGiftCode(prizeInfo[0]);
//                         roomgift.setOpenID(phoneOrOpenid);
//                         //roomgift.setMemo(chatRoomGift.getMemo());
//                         roomgift.setRoomCode(roomName);
//                         roomgift.setTimestamp(prizeInfo[1]);
//                         roomgift.setOpenID(roomgift.getOpenID());
//                         //roomgift.setExpireDate(overTime);
//                         roomgift.setGiftType("2");
//                         //roomgift.save(dxChatUserGift);
//                         applicationContext.getBean(RoomgiftuserServiceImpl.class).save(roomgift);
//
//                        List<Coupons> couponsList=applicationContext.getBean(CouponsServiceImpl.class).getByGroupCode(couponsgroup.getGroupCode());
//                        for(Coupons coupons :couponsList){
//                        	if(couponsgroup.getValidityType()==2){
//                				Calendar c = Calendar.getInstance();
//                				c.add(Calendar.DAY_OF_MONTH, couponsgroup.getEffectiveDays());
//                				coupons.setEffectiveDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime())));
//                				c.add(Calendar.DAY_OF_MONTH, couponsgroup.getValidityDays());
//                				coupons.setExpireDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime())));
//                    		}
//                			coupons.setReceiveDate(new Date());
//                			coupons.setOpenID(phoneOrOpenid);
//                			coupons.setStatus(CouponsStatusEnum.Fetched.getStatusCode());
//                			applicationContext.getBean(CouponsServiceImpl.class).update(coupons);
//                        }
//                    	//已发放数量
//            			couponsgroup.setIssuedNumber(couponsgroup.getCouponsNumber());
//            			//已领取数量
//            			couponsgroup.setFetchNumber(couponsgroup.getCouponsNumber());
//            			//剩余数量
//            			couponsgroup.setRemainingNumber(0);
//            			couponsgroup.setUpdateDate(new Date());
//            			applicationContext.getBean(CouponsgroupServiceImpl.class).update(couponsgroup);
//                        
//                        chatMessage.setRole(roll);
//                        chatMessage.setHeader(header);
//                        chatMessage.setNickname(nickName);
//                        chatMessage.setMessageType("3");
//                        chatMessage.setContent("恭喜你获得了"+couponsgroup.getCouponsName());
//                        chatMessage.setPrizeId(prizeId);
//                        sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
//                        Roomgiftsend sendRecords = applicationContext.getBean(RoomgiftsendServiceImpl.class).getByGiftAndRoomAndTimestamp("2",prizeInfo[0],roomName,prizeInfo[1]);
//                        chatMessage.setMessageType("22");
//                        chatMessage.setContent(String.valueOf(couponsgroup.getSendNumber()-list.size()-1));
//                        sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
//                    }
//                }
//                return;
//            }
//        }
//        chatMessage.setRole(roll);
//        chatMessage.setHeader(header);
//        chatMessage.setNickname(nickName);
//        chatMessage.setMessageType(messageType);
//        chatMessage.setContent(messageContent);
//        chatMessage.setPrizeId(prizeId);
//        chatMessage.setPhoneOrOpenid(phoneOrOpenid);
//        if(messageType.equals("5")){
//            sendMessage(phoneOrOpenid+roomName,chatMessage.toString());
//        }else{
//            sendMessagetoRoom(roomName, chatMessage.toString());
//        }
//
//    }
//
//
//    @OnError
//    public void error(Session session, Throwable t) {
//        log.error("websocket发生错误："+t.toString());
//    }
//
//    public  void sendMessagetoRoom(String roomName, String msg) throws Exception {
//        for (Session session : rooms.get(roomName)) {
//            session.getBasicRemote().sendText(msg);
//            log.info("发送给"+session.getId()+msg);
//        }
//    }
//
//    //关闭房间
//    public void removeRoomName(String roomName) throws Exception {
//        //移除房间号
//        if(rooms.containsKey(roomName)){
//            DXChatMessage chatMessage = new DXChatMessage();
//            chatMessage.setRole("1");
//            chatMessage.setHeader("");
//            chatMessage.setNickname("");
//            chatMessage.setMessageType("-2");
//            chatMessage.setContent("");
//            chatMessage.setPrizeId("");
//            sendMessagetoRoom(roomName, chatMessage.toString());
//            rooms.remove(roomName);
//            for(String str:phoneOrOpenidSession.keySet()){
//                if(str.contains(roomName)){
//                    phoneOrOpenidSession.remove(str);
//                }
//            }
//            log.info("关闭房间:"+roomName);
//        }
//    }
//
//    //创建房间
//    public void OpenRoomName(String roomName, Sessioninfo sessioninfo) {
//        if(!rooms.containsKey(roomName)){ //房间不存在时
//            Set<Session> room = new HashSet<>();
//            // 开启房间
//            log.info("开启房间:"+roomName);
//            Calendar calendar = Calendar.getInstance();
//            new Thread(){
//                public void run() {
//                    Date endTime = sessioninfo.getStartTime();
//                    Date now = new Date();
//                    Long endMillisecond = endTime.getTime()+40*60*1000; //场次结束后40分钟关闭
//                    Long nowMillisecond = now.getTime();
//                    Long remainMillisecond = (endMillisecond-nowMillisecond)/1000;
//                    log.info("距离聊天室关闭剩余"+remainMillisecond/60+"分钟");
//                    while(remainMillisecond>0) {
//                        remainMillisecond--;
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            try {
//                                new ChatRoomServer().removeRoomName(roomName);
//                            } catch (Exception e1) {
//                                e1.printStackTrace();
//                            }
//                            e.printStackTrace();
//                            this.interrupt();
//                            log.info("聊天室倒计时出现异常,线程终止");
//                        }
//                    }
//                    try{
//                        new ChatRoomServer().removeRoomName(roomName);  //关闭房间
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }finally {
//                        this.interrupt();
//                        log.info("线程终止");
//                    }
//                }
//
//            }.start();
//            rooms.put(roomName, room);
//        }
//    }
//
//    //获取当前房间列表
//    public static List<String> getRoomByCinema(String cinemaCode){
//        if(StringUtils.isNotBlank(cinemaCode)){
//            List<String> list = new ArrayList<>(rooms.size());
//            for(String roomName:rooms.keySet()){
//                if(roomName.startsWith(cinemaCode+"_")){
//                    list.add(roomName);
//                }
//            }
//            return list;
//        }
//        return null;
//    }
//    //获取所有房间列表
//    public static List<String> getAllRoom(){
//        List<String> list = new ArrayList<>(rooms.size());
//        for(String roomName:rooms.keySet()){
//            list.add(roomName);
//        }
//        return list;
//    }
//
//    //发送消息给指定用户
//    public void sendMessage(String phoneOrOpenid,String msg) throws Exception{
//        Session session = phoneOrOpenidSession.get(phoneOrOpenid);
//        if(session.isOpen()){
//            session.getBasicRemote().sendText(msg);
//        }
//    }
//}
