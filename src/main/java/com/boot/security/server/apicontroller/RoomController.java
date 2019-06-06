package com.boot.security.server.apicontroller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.apicontroller.reply.GetRoomGiftReply;
import com.boot.security.server.apicontroller.reply.GetRoomGiftReply.GetRoomGiftBean;
import com.boot.security.server.apicontroller.reply.QueryRoomGiftRecordReply.QueryRoomGiftRecord;
import com.boot.security.server.apicontroller.reply.QueryRoomGiftRecordReply;
import com.boot.security.server.apicontroller.reply.QueryRoomGiftReply;
import com.boot.security.server.apicontroller.reply.QueryScreenRoomReply;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.apicontroller.reply.RoomGiftInput;
import com.boot.security.server.apicontroller.reply.SendGiftReply;
import com.boot.security.server.apicontroller.reply.SendGiftReply.SendGiftBean;
import com.boot.security.server.apicontroller.reply.QueryRoomGiftReply.RoomGiftReply;
import com.boot.security.server.apicontroller.reply.QueryScreenRoomReply.ScreenRoom;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Couponsgroup;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Roomgift;
import com.boot.security.server.model.Roomgiftsend;
import com.boot.security.server.model.Roomgiftuser;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.CouponsgroupServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.RoomgiftServiceImpl;
import com.boot.security.server.service.impl.RoomgiftsendServiceImpl;
import com.boot.security.server.service.impl.RoomgiftuserServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.service.impl.TicketusersServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
//import com.boot.security.server.websocket.ChatRoomServer;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/Room")
public class RoomController {

	@Autowired
	private UserInfoServiceImpl _userInfoService;
	@Autowired
	private CinemaServiceImpl _cinemaService;
	@Autowired
	private ScreeninfoServiceImpl _screeninfoService;
	@Autowired
	private SessioninfoServiceImpl _sessionInfoService;
	@Autowired
	private FilminfoServiceImpl _filminfoService;
	@Autowired
	private RoomgiftServiceImpl roomgiftService;
	@Autowired
	private RoomgiftsendServiceImpl roomgiftsendService;
	@Autowired
	private RoomgiftuserServiceImpl roomgiftuserService;
	@Autowired
	private CouponsgroupServiceImpl couponsgroupService;
	@Autowired
	private TicketusersServiceImpl ticketusersService;
	
	@GetMapping("/QueryScreenRoom/{UserName}/{Password}/{CinemaCode}")
	@ApiOperation(value="获取放映厅信息")
	public QueryScreenRoomReply QueryScreenRoom(@PathVariable String UserName, @PathVariable String Password,@PathVariable String CinemaCode) throws ParseException {
		QueryScreenRoomReply reply=new QueryScreenRoomReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(reply, UserName, Password, CinemaCode)){
			return reply;
		}
		//获取用户信息(渠道)
		Userinfo UserInfo=_userInfoService.getByUserCredential(UserName, Password);
		if(UserInfo == null){
			reply.SetUserCredentialInvalidReply();
			return reply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(CinemaCode);
		if(cinema == null){
			reply.SetCinemaInvalidReply();
			return reply;
		}
		//获取当前时间的前后40分钟
		Date showdate=new Date();
		Date startDate = new Date(showdate.getTime()-1000*60*40);
		Date endDate = new Date(showdate.getTime()+1000*60*40);
		List<Sessioninfo>  sessioninfos = _sessionInfoService.getByCCodeGroupByFilm(UserInfo.getId(), CinemaCode, startDate, endDate);
		
		List<ScreenRoom> rooms = new ArrayList<ScreenRoom>();
		for(Sessioninfo sessioninfo : sessioninfos){
			ScreenRoom screenRoom = new ScreenRoom();
			screenRoom.setCinemaCode(cinema.getCode());
			screenRoom.setCinemaName(cinema.getName());
			screenRoom.setRoomCode(sessioninfo.getSCode());//排期编码作为放映厅房间号，唯一标识
			
			Screeninfo screeninfo = _screeninfoService.getByScreenCode(sessioninfo.getCCode(),sessioninfo.getScreenCode());
			screenRoom.setScreenName(screeninfo==null?"":screeninfo.getSName());
			screenRoom.setFilmName(sessioninfo.getFilmName());
			Date startTime = sessioninfo.getStartTime();
			screenRoom.setStartTime(new SimpleDateFormat("HH:mm:ss").format(startTime));
			Integer duration = sessioninfo.getDuration();
			screenRoom.setEndTime(new SimpleDateFormat("HH:mm:ss").format(new Date(startTime.getTime()+1000*60*duration)));
			
			Filminfo film = _filminfoService.getByFilmCode(sessioninfo.getFilmCode());
			screenRoom.setImage(film==null?"":film.getImage());
			rooms.add(screenRoom);
			//new ChatRoomServer().OpenRoom(screenRoom.getRoomCode(), screenRoom); //开启聊天室
		}
		reply.setData(rooms);
		reply.SetSuccessReply();
		return reply;
	}
	
	@GetMapping("/QueryRoomGift/{UserName}/{Password}/{CinemaCode}")
	@ApiOperation(value="获取放映厅可发送礼物列表")
	public QueryRoomGiftReply QueryRoomGift(@PathVariable String UserName, @PathVariable String Password,@PathVariable String CinemaCode) {
		QueryRoomGiftReply reply=new QueryRoomGiftReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(reply, UserName, Password, CinemaCode)){
			return reply;
		}
		//获取用户信息(渠道)
		Userinfo UserInfo=_userInfoService.getByUserCredential(UserName, Password);
		if(UserInfo == null){
			reply.SetUserCredentialInvalidReply();
			return reply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(CinemaCode);
		if(cinema == null){
			reply.SetCinemaInvalidReply();
			return reply;
		}
		
		List<RoomGiftReply> data = new ArrayList<RoomGiftReply>();
		//获取实物列表
		List<Roomgift> giftlist = roomgiftService.getByCinema(CinemaCode);
		for(Roomgift gift : giftlist){
			RoomGiftReply newgift = new RoomGiftReply();
			newgift.setGiftCode(gift.getGiftCode());
			newgift.setGiftName(gift.getGiftName());
			newgift.setGiftType(gift.getGiftType());
			newgift.setSendNumber(String.valueOf(gift.getSendNumber()));
			newgift.setImage(gift.getImage());
			data.add(newgift);
		}
		//获取优惠劵列表
		List<Couponsgroup> coupons = couponsgroupService.getAllUseByGroupCode(CinemaCode);
		for(Couponsgroup coupon : coupons){
			RoomGiftReply newgift2 = new RoomGiftReply();
			newgift2.setGiftCode(coupon.getGroupCode());
			newgift2.setGiftName(coupon.getCouponsName());
			newgift2.setGiftType(coupon.getGiftType());
			newgift2.setSendNumber(String.valueOf(coupon.getSendNumber()));
//			newgift2.setImage();
			data.add(newgift2);
		}
		reply.setData(data);
		reply.SetSuccessReply();
		return reply;
	}
	
	@PostMapping("/SendGift")
	@ApiOperation(value="发放奖品")
	public SendGiftReply SendGift(@RequestBody RoomGiftInput input) {
		SendGiftReply reply=new SendGiftReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(reply, input.getUserName(), input.getPassword(), input.getCinemaCode(),
				input.getRoomCode(), input.getGiftCode(),input.getGiftType(),input.getSendNumber(),input.getOpenID())){
			return reply;
		}
		//获取用户信息(渠道)
		Userinfo UserInfo=_userInfoService.getByUserCredential(input.getUserName(), input.getPassword());
		if(UserInfo == null){
			reply.SetUserCredentialInvalidReply();
			return reply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(input.getCinemaCode());
		if(cinema == null){
			reply.SetCinemaInvalidReply();
			return reply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = ticketusersService.getByopenids(input.getOpenID());
		if(ticketuser == null){
			reply.SetOpenIDNotExistReply();
			return reply;
		}
		//验证发放次数是否超出上限
		List<Roomgiftsend> sendlist = roomgiftsendService.getByRoomCode(input.getRoomCode(), input.getGiftCode());
		int sendNum = sendlist.size()+1;	//发送次数
		String giftName=null;
		String image=null;
		if("1".equals(input.getGiftType())) {
			Roomgift roomgift = roomgiftService.getByGiftCode(input.getGiftCode());
			if(roomgift == null){
				reply.SetGiftInvalidReply();
				return reply;
			}
			if(sendNum > roomgift.getGroupNumber()){
				reply.SetOverrunGiftReply();
				return reply;
			}
			giftName = roomgift.getGiftName();
			image = roomgift.getImage();
			
		} else if("2".equals(input.getGiftType())) {
			Couponsgroup coupon = couponsgroupService.getByGroupCode(input.getGiftCode());
			if(coupon == null){
				reply.SetCouponsNotExistOrUsedReply();
				return reply;
			}
			if(sendNum > coupon.getSendGroupNumber()){
				reply.SetOverrunGiftReply();
				return reply;
			}
			//更新优惠劵-已发放数量
			int suedNumber = coupon.getIssuedNumber()+input.getSendNumber();
			if(suedNumber > coupon.getCouponsNumber()){
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
		}
		
		//存入到发放奖品记录表
		Roomgiftsend newgift = new Roomgiftsend();
		newgift.setRoomCode(input.getRoomCode());
		newgift.setGiftCode(input.getGiftCode());
		newgift.setGiftName(giftName);
		newgift.setGiftType(input.getGiftType());
		newgift.setSendNumber(input.getSendNumber());
		newgift.setOpenid(input.getOpenID());
		newgift.setSendTime(new Date());
		roomgiftsendService.save(newgift);
		
		SendGiftBean gift = new SendGiftBean();
		gift.setGiftCode(input.getGiftCode());
		gift.setGiftName(giftName);
		gift.setGiftType(input.getGiftType());
		gift.setImage(image);
		reply.setData(gift);
		reply.SetSuccessReply();
		return reply;
	}
	
	@PostMapping("/GetRoomGift")
	@ApiOperation(value="用户领取奖品")
	public GetRoomGiftReply GetRoomGift(@RequestBody RoomGiftInput input) {
		GetRoomGiftReply reply=new GetRoomGiftReply();
		//校验参数
		/*if(!ReplyExtension.RequestInfoGuard(reply, UserName, Password, CinemaCode)){
			return reply;
		}*/
		//获取用户信息(渠道)
		Userinfo UserInfo=_userInfoService.getByUserCredential(input.getUserName(), input.getPassword());
		if(UserInfo == null){
			reply.SetUserCredentialInvalidReply();
			return reply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(input.getCinemaCode());
		if(cinema == null){
			reply.SetCinemaInvalidReply();
			return reply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = ticketusersService.getByopenids(input.getOpenID());
		if(ticketuser == null){
			reply.SetOpenIDNotExistReply();
			return reply;
		}
		//验证用户权限(管理员不可以抢红包)
		if("2".equals(ticketuser.getRoll())){
			reply.SetSnatchFailureReply();
			return reply;
		}
		String giftCode=input.getGiftCode();
		String giftName=null;
		String image=null;
		Date startDate = new Date();
		Date expireDate=new Date();
		if("1".equals(input.getGiftType())) {
			Roomgift roomgift = roomgiftService.getByGiftCode(giftCode);
			if(roomgift == null){
				reply.SetGiftInvalidReply();
				return reply;
			}
			giftName = roomgift.getGiftName();
			image = roomgift.getImage();
			expireDate = new Date(expireDate.getTime() + 1000*60*60*2);
			
		} else if("2".equals(input.getGiftType())) {
			Couponsgroup coupon = couponsgroupService.getByGroupCode(giftCode);
			if(coupon == null){
				reply.SetCouponsNotExistOrUsedReply();
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
		}
		//存数据库-用户领取奖品表
		Roomgiftuser roomgiftuser = new Roomgiftuser();
		roomgiftuser.setOpenID(input.getOpenID());
		roomgiftuser.setRoomCode(input.getRoomCode());
		roomgiftuser.setGiftCode(giftCode);
		roomgiftuser.setGiftName(giftName);
		roomgiftuser.setGiftType(input.getGiftType());
		roomgiftuser.setImage(image);
		roomgiftuser.setGetDate(new Date());
		roomgiftuser.setStartDate(startDate);
		roomgiftuser.setExpireDate(expireDate);
		roomgiftuserService.save(roomgiftuser);
		
		//返回
		GetRoomGiftBean data = new GetRoomGiftBean();
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
	}
	
	@PostMapping("/QueryRoomGiftRecord")
	@ApiOperation(value="放映厅房间用户领取奖品记录")
	public QueryRoomGiftRecordReply QueryRoomGiftRecord(@RequestBody RoomGiftInput input) {
		QueryRoomGiftRecordReply reply=new QueryRoomGiftRecordReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(reply, input.getUserName(), input.getPassword(), input.getCinemaCode(),
				input.getRoomCode(), input.getOpenID())){
			return reply;
		}
		//获取用户信息(渠道)
		Userinfo UserInfo=_userInfoService.getByUserCredential(input.getUserName(), input.getPassword());
		if(UserInfo == null){
			reply.SetUserCredentialInvalidReply();
			return reply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(input.getCinemaCode());
		if(cinema == null){
			reply.SetCinemaInvalidReply();
			return reply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = ticketusersService.getByopenids(input.getOpenID());
		if(ticketuser == null){
			reply.SetOpenIDNotExistReply();
			return reply;
		}
		
		List<Roomgiftuser>  roomgiftuserlist = roomgiftuserService.getByOpenidAndRoom(input.getOpenID(), input.getRoomCode());
		List<QueryRoomGiftRecord> data = new ArrayList<QueryRoomGiftRecord>();
		for(Roomgiftuser roomgiftuser : roomgiftuserlist){
			QueryRoomGiftRecord record = new QueryRoomGiftRecord();
			record.setOpenID(roomgiftuser.getOpenID());
			record.setGiftCode(roomgiftuser.getGiftCode());
			record.setGiftName(roomgiftuser.getGiftName());
			record.setGiftType(roomgiftuser.getGiftType());
			record.setImage(roomgiftuser.getImage());
			record.setGetDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(roomgiftuser.getGetDate()));
			if(roomgiftuser.getStartDate() != null){
				record.setStartDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(roomgiftuser.getStartDate()));
			}
			if(roomgiftuser.getExpireDate() != null){
				record.setExpireDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(roomgiftuser.getExpireDate()));	
			}
			
			data.add(record);
		}
		reply.setData(data);
		reply.SetSuccessReply();
		return reply;
	}
}
