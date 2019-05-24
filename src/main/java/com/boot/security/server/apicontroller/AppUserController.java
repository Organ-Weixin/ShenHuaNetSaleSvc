package com.boot.security.server.apicontroller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.apicontroller.reply.Jscode2sessionReply;
import com.boot.security.server.apicontroller.reply.MobilePhoneRegisterReply;
import com.boot.security.server.apicontroller.reply.MobilePhoneRegisterReply.MobilePhoneRegisterBean;
import com.boot.security.server.apicontroller.reply.QueryRoomGiftRecordReply.QueryRoomGiftRecord;
import com.boot.security.server.apicontroller.reply.ModelMapper;
import com.boot.security.server.apicontroller.reply.QueryCinemaGoodsReply;
import com.boot.security.server.apicontroller.reply.QueryCinemaTicketReply;
import com.boot.security.server.apicontroller.reply.QueryCinemaTicketReply.QueryCinemaTicket.CinemaTicket;
import com.boot.security.server.apicontroller.reply.QueryMovieSeenReply;
import com.boot.security.server.apicontroller.reply.QueryCinemaGoodsReply.QueryCinemaGoodsReplyGoods.QueryCinemaGoods;
import com.boot.security.server.apicontroller.reply.QueryMovieSeenReply.QueryMovieSeenReplySeen.QueryMovieSeen;
import com.boot.security.server.apicontroller.reply.QueryRoomGiftRecordReply;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.apicontroller.reply.RoomGiftInput;
import com.boot.security.server.apicontroller.reply.SendVerifyCodeReply;
import com.boot.security.server.apicontroller.reply.SendVerifyCodeReply.SendVerifyCodeBean;
import com.boot.security.server.apicontroller.reply.UserLoginInput;
import com.boot.security.server.apicontroller.reply.UserLoginReply;
import com.boot.security.server.apicontroller.reply.UserLoginReply.UserLoginResult;
import com.boot.security.server.apicontroller.reply.UserPhoneInput;
import com.boot.security.server.apicontroller.reply.UserWXResult;
import com.boot.security.server.dao.AdminorderviewDao;
import com.boot.security.server.dao.GoodsorderdetailsviewDao;
import com.boot.security.server.model.Adminorderview;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.CinemaMiniProgramAccounts;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.Roomgiftuser;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.StatusEnum;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.modelView.Goodsorderdetailsview;
import com.boot.security.server.service.impl.CinemaMiniProgramAccountsServiceImpl;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.GoodsOrderServiceImpl;
import com.boot.security.server.service.impl.RoomgiftuserServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.TicketusersServiceImpl;
import com.boot.security.server.service.impl.UserCinemaViewServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.boot.security.server.utils.AESHelper;
import com.boot.security.server.utils.HttpHelper;
import com.boot.security.server.utils.SendSmsHelper;
import com.google.gson.Gson;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/User")
public class AppUserController {
	
	@Autowired
	private UserInfoServiceImpl _userInfoService;
	@Autowired
	private UserCinemaViewServiceImpl _userCinemaViewService;
	@Autowired
	private CinemaMiniProgramAccountsServiceImpl _miniProgramAccountsService;
	@Autowired
	private TicketusersServiceImpl _ticketusersService;
	@Autowired
	private CinemaServiceImpl _cinemaService;
	@Autowired
	private RoomgiftuserServiceImpl roomgiftuserService;
	@Autowired
	private FilminfoServiceImpl _filminfoServiceImpl;
	@Autowired
	private  AdminorderviewDao adminorderviewDao;
	@Autowired
	private  GoodsorderdetailsviewDao goodsorderdetailsviewDao;
	@PostMapping("/UserLogin")
	@ApiOperation(value = "用户登陆")
	public UserLoginReply UserLogin(@RequestBody UserLoginInput userinput){
		UserLoginReply userReply = new UserLoginReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(userReply, userinput.getUserName(), userinput.getPassword(), 
				userinput.getCinemaCode(), userinput.getCode(), userinput.getEncryptedData(), userinput.getIv())) {
			return userReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(userinput.getUserName(), userinput.getPassword());
		if (UserInfo == null) {
			userReply.SetUserCredentialInvalidReply();
			return userReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),userinput.getCinemaCode());
		if (userCinema == null) {
			userReply.SetCinemaInvalidReply();
			return userReply;
		}
		//验证并获取AppID和AppSecret
		CinemaMiniProgramAccounts miniProgramAccount = _miniProgramAccountsService.getByCinemaCode(userinput.getCinemaCode());
		if(miniProgramAccount == null){
			userReply.SetCinemaMiniProgramAccountNotExistReply();
			return userReply;
		}
		//获取sessionKey和openid
        Map<String,Object> param = new LinkedHashMap<String,Object>();
		param.put("appid", miniProgramAccount.getAppId());
		param.put("secret", miniProgramAccount.getAppSecret());
		param.put("js_code", userinput.getCode());
		param.put("grant_type", "authorization_code");
		
		String url="https://api.weixin.qq.com/sns/jscode2session";
		String returnStr = HttpHelper.sendPostByUrlConnection(url, param, "UTF-8");
        System.out.println("用户登陆返回："+returnStr);
        Jscode2sessionReply jscode2sessionReply = new Gson().fromJson(returnStr, Jscode2sessionReply.class);
        if(jscode2sessionReply.getSession_key() == null){
        	userReply.Status = StatusEnum.Failure.getStatusCode();
        	userReply.ErrorCode = jscode2sessionReply.getErrcode();
        	userReply.ErrorMessage = jscode2sessionReply.getErrmsg();
        	return userReply;
        }
        //解密微信小程序的登陆加密数据
        String wxuserStr = AESHelper.AesDecrypt(userinput.getEncryptedData(), jscode2sessionReply.getSession_key(), userinput.getIv());
        System.out.println("解密------"+wxuserStr);
        UserWXResult wxuser = new Gson().fromJson(wxuserStr, UserWXResult.class);
        
        //更新到数据库
        Ticketusers ticketuser = _ticketusersService.getByopenids(jscode2sessionReply.getOpenid());
        if(ticketuser == null){
        	ticketuser = new Ticketusers();
        	ticketuser.setCinemaCode(userinput.getCinemaCode());
        	ticketuser.setOpenID(jscode2sessionReply.getOpenid());
        	ModelMapper.MapToEntity(wxuser, ticketuser);
        	_ticketusersService.save(ticketuser);
        } else {
        	ModelMapper.MapToEntity(wxuser, ticketuser);
        	_ticketusersService.update(ticketuser);
        }
        //返回
        UserLoginResult data = new UserLoginResult();
        data.setTicketUserId(ticketuser.getId());
        data.setCinemaCode(ticketuser.getCinemaCode());
        data.setMobilePhone(ticketuser.getMobilePhone());
        data.setOpenID(ticketuser.getOpenID());
        data.setNickName(ticketuser.getNickName());
        data.setSex(String.valueOf(ticketuser.getSex()));
        data.setCountry(ticketuser.getCountry());
        data.setProvince(ticketuser.getProvince());
        data.setCity(ticketuser.getCity());
        data.setHeadlmgUrl(ticketuser.getHeadImgUrl());
        data.setLanguage(ticketuser.getLanguage());
        data.setTotalScore(ticketuser.getTotalScore());
        data.setIsActive(String.valueOf(ticketuser.getIsActive()));
        data.setRoll(ticketuser.getRoll());
        data.setCreated(ticketuser.getCreated()==null?"":new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ticketuser.getCreated()));
        
        userReply.setData(data);
        userReply.SetSuccessReply();
		return userReply;
	}
	
	@GetMapping("/QueryUser/{UserName}/{Password}/{CinemaCode}/{OpenID}")
	@ApiOperation(value = "查询用户信息")
	public UserLoginReply QueryUser(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,@PathVariable String OpenID){
		UserLoginReply userReply = new UserLoginReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(userReply, UserName, Password, CinemaCode, OpenID)) {
			return userReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			userReply.SetUserCredentialInvalidReply();
			return userReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(), CinemaCode);
		if (userCinema == null) {
			userReply.SetCinemaInvalidReply();
			return userReply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = _ticketusersService.getByopenids(OpenID);
		if(ticketuser == null){
			userReply.SetOpenIDNotExistReply();
			return userReply;
		}
		//返回
		UserLoginResult data = new UserLoginResult();
		data.setTicketUserId(ticketuser.getId());
        data.setCinemaCode(ticketuser.getCinemaCode());
        data.setMobilePhone(ticketuser.getMobilePhone());
        data.setOpenID(ticketuser.getOpenID());
        data.setNickName(ticketuser.getNickName());
        data.setSex(String.valueOf(ticketuser.getSex()));
        data.setCountry(ticketuser.getCountry());
        data.setProvince(ticketuser.getProvince());
        data.setCity(ticketuser.getCity());
        data.setHeadlmgUrl(ticketuser.getHeadImgUrl());
        data.setLanguage(ticketuser.getLanguage());
        data.setTotalScore(ticketuser.getTotalScore());
        data.setIsActive(String.valueOf(ticketuser.getIsActive()));
        data.setRoll(ticketuser.getRoll());
        data.setCreated(ticketuser.getCreated()==null?"":new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ticketuser.getCreated()));
        
        userReply.setData(data);
        userReply.SetSuccessReply();
		return userReply;
	}
	
	@PostMapping("/MobilePhoneRegister")
	@ApiOperation(value = "用户手机号注册(手工填写手机号)")
	public MobilePhoneRegisterReply MobilePhoneRegister(@RequestBody UserPhoneInput input){
		MobilePhoneRegisterReply reply = new MobilePhoneRegisterReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(reply, input.getUserName(), input.getPassword(), 
				input.getCinemaCode(), input.getOpenID(),input.getMobilePhone(),input.getVerifyCode())) {
			return reply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(input.getUserName(), input.getPassword());
		if (UserInfo == null) {
			reply.SetUserCredentialInvalidReply();
			return reply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(), input.getCinemaCode());
		if (userCinema == null) {
			reply.SetCinemaInvalidReply();
			return reply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = _ticketusersService.getByopenids(input.getOpenID());
		if(ticketuser == null){
			reply.SetOpenIDNotExistReply();
			return reply;
		}
		//验证用户的验证码是否正确
		if(!input.getVerifyCode().equals(ticketuser.getVerifyCode())){
			reply.SetVerifyCodeNotMatchReply();
			return reply;
		}
		//更新用户手机号为传入手机号
		ticketuser.setMobilePhone(input.getMobilePhone());
		_ticketusersService.update(ticketuser);
		
		//返回
		MobilePhoneRegisterBean mobleinfo = new MobilePhoneRegisterBean();
		mobleinfo.setCinemaCode(ticketuser.getCinemaCode());
		mobleinfo.setOpenID(ticketuser.getOpenID());
		mobleinfo.setMobilePhone(ticketuser.getMobilePhone());
		mobleinfo.setVerifyCode(ticketuser.getVerifyCode());
		reply.setData(mobleinfo);
		reply.SetSuccessReply();
		return reply;
	}
	
	@PostMapping("/SendVerifyCode")
	@ApiOperation(value = "发送验证码")
	public SendVerifyCodeReply SendVerifyCode(@RequestBody UserPhoneInput input){
		SendVerifyCodeReply reply = new SendVerifyCodeReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(reply, input.getUserName(), input.getPassword(), 
				input.getCinemaCode(), input.getOpenID(),input.getMobilePhone())) {
			return reply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(input.getUserName(), input.getPassword());
		if (UserInfo == null) {
			reply.SetUserCredentialInvalidReply();
			return reply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(), input.getCinemaCode());
		if (userCinema == null) {
			reply.SetCinemaInvalidReply();
			return reply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = _ticketusersService.getByopenids(input.getOpenID());
		if(ticketuser == null){
			reply.SetOpenIDNotExistReply();
			return reply;
		}
		//生成4位验证码并更新到数据库
		StringBuffer str = new StringBuffer();
		for(int i=0;i<4;i++){
			int num=(int) (Math.random()*10);
			str.append(String.valueOf(num));
		}
		ticketuser.setVerifyCode(str.toString());
		_ticketusersService.update(ticketuser);
		
		//发送验证码到用户手机号
        String smsContent = "手机号"+input.getMobilePhone()+"用户,您的验证码为"+ ticketuser.getVerifyCode()+"。仅用于小程序手机号码验证，请尽快使用。";
        String sendResult = SendSmsHelper.SendSms(input.getMobilePhone(), smsContent);
        if(!"Success".equals(sendResult)){
        	reply.SetSentMessageFailureReply();
        	return reply;
        }
		//返回
		SendVerifyCodeBean sendverify = new SendVerifyCodeBean();
		sendverify.setMobilePhone(ticketuser.getMobilePhone());
		sendverify.setVerifyCode(ticketuser.getVerifyCode());
		reply.setData(sendverify);
		reply.SetSuccessReply();
		return reply;
	}
	
	@PostMapping("/QueryGiftRecord")
	@ApiOperation(value="放映厅房间用户领取奖品记录")
	public QueryRoomGiftRecordReply QueryGiftRecord(@RequestBody RoomGiftInput input) {
		QueryRoomGiftRecordReply reply=new QueryRoomGiftRecordReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(reply, input.getUserName(), input.getPassword(), input.getCinemaCode(),	input.getOpenID())){
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
		Ticketusers ticketuser = _ticketusersService.getByopenids(input.getOpenID());
		if(ticketuser == null){
			reply.SetOpenIDNotExistReply();
			return reply;
		}
		List<Roomgiftuser>  roomgiftuserlist = roomgiftuserService.getByOpenid(input.getOpenID(),input.getCinemaCode());
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
	@GetMapping("/QueryCinemaTicket/{UserName}/{Password}/{CinemaCode}/{OpenID}")
	@ApiOperation(value = "查询用户购买的电影票记录")
	public QueryCinemaTicketReply QueryCinemaTicket(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OpenID){
		QueryCinemaTicketReply queryCinemaTicketReply=new QueryCinemaTicketReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(queryCinemaTicketReply, UserName, Password, CinemaCode,OpenID)) {
			return queryCinemaTicketReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			queryCinemaTicketReply.SetUserCredentialInvalidReply();
			return queryCinemaTicketReply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(CinemaCode);
		if(cinema == null){
			queryCinemaTicketReply.SetCinemaInvalidReply();
			return queryCinemaTicketReply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = _ticketusersService.getByopenids(OpenID);
		if(ticketuser == null){
			queryCinemaTicketReply.SetOpenIDNotExistReply();
			return queryCinemaTicketReply;
		}
		List<Adminorderview> adminorderviewList=adminorderviewDao.getByCinemaCode(CinemaCode);
		queryCinemaTicketReply.setData(queryCinemaTicketReply.new QueryCinemaTicket());
		if(adminorderviewList==null||adminorderviewList.size()==0){
			queryCinemaTicketReply.getData().setCount(0);
		}else{
			queryCinemaTicketReply.getData().setCount(adminorderviewList.size());
			queryCinemaTicketReply.getData().setTicket(new ArrayList<CinemaTicket>());
			for(Adminorderview adminorderview:adminorderviewList){
				CinemaTicket cinemaTicket =queryCinemaTicketReply.getData().new  CinemaTicket();
				cinemaTicket.setFilmName(adminorderview.getFilmname());
				cinemaTicket.setSessionDateTime(adminorderview.getSessiontime());
				cinemaTicket.setCinemaName(adminorderview.getCinemaname());
				cinemaTicket.setSeatName(adminorderview.getSeat());
				cinemaTicket.setScreenName(adminorderview.getScreencode());
				cinemaTicket.setPrintNo(adminorderview.getPrintno());
				cinemaTicket.setOrderCode(adminorderview.getSubmitordercode());
				cinemaTicket.setCreated(adminorderview.getCreated());
				cinemaTicket.setMobilePhone(adminorderview.getMobilephone());
				List<Filminfo> filminfo=_filminfoServiceImpl.getFilmByFilmName(adminorderview.getFilmname());
				for(Filminfo filmi:filminfo){
					CinemaTicket cinematicket =queryCinemaTicketReply.getData().new  CinemaTicket();
					cinematicket.setVersion(filmi.getVersion());
					cinemaTicket.setImage(filmi.getImage());
					queryCinemaTicketReply.getData().getTicket().add(cinematicket);
					System.out.println("55555555555=:"+filmi.getVersion());
				}
				cinemaTicket.setAddress(cinema.getAddress());
				cinemaTicket.setCinemaPhone(cinema.getCinemaPhone());
				if(adminorderview.getSaleprice()!=null){
				cinemaTicket.setPrice(String.valueOf(adminorderview.getSaleprice()));
				}
				if(adminorderview.getOrderstatus()!=null){
				cinemaTicket.setStatus(String.valueOf(adminorderview.getOrderstatus()));
				}
				cinemaTicket.setMobilePhone(adminorderview.getMobilephone());
				cinemaTicket.setTicketInfoCode(adminorderview.getTicketinfocode());
				queryCinemaTicketReply.getData().getTicket().add(cinemaTicket);

			}
		}
		queryCinemaTicketReply.SetSuccessReply();
		return queryCinemaTicketReply;
	}
	@GetMapping("/QueryCinemaGoods/{UserName}/{Password}/{CinemaCode}/{OpenID}")
	@ApiOperation(value = "查询用户购买的小食记录")
	public QueryCinemaGoodsReply QueryCinemaGoods(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OpenID){
		QueryCinemaGoodsReply queryCinemaGoodsReply=new QueryCinemaGoodsReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(queryCinemaGoodsReply, UserName, Password, CinemaCode, OpenID)) {
			return queryCinemaGoodsReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			queryCinemaGoodsReply.SetUserCredentialInvalidReply();
			return queryCinemaGoodsReply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(CinemaCode);
		if(cinema == null){
			queryCinemaGoodsReply.SetCinemaInvalidReply();
			return queryCinemaGoodsReply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = _ticketusersService.getByopenids(OpenID);
		if(ticketuser == null){
			queryCinemaGoodsReply.SetOpenIDNotExistReply();
			return queryCinemaGoodsReply;
		}
		List<Goodsorderdetailsview> goodsorderdetailsviewList=goodsorderdetailsviewDao.getByCinemaCode(CinemaCode);
		queryCinemaGoodsReply.setData(queryCinemaGoodsReply.new QueryCinemaGoodsReplyGoods());
		if(goodsorderdetailsviewList==null||goodsorderdetailsviewList.size()==0){
			queryCinemaGoodsReply.getData().setCount(0);
		}else{
			queryCinemaGoodsReply.getData().setCount(goodsorderdetailsviewList.size());
			queryCinemaGoodsReply.getData().setGood(new ArrayList<QueryCinemaGoods>());
			for(Goodsorderdetailsview goodview:goodsorderdetailsviewList){
				QueryCinemaGoods queryCinemaGoods=queryCinemaGoodsReply.getData().new QueryCinemaGoods();
			queryCinemaGoods.setGoodsName(goodview.getGoodsName());
			if(goodview.getGoodsCount()!=null){
			queryCinemaGoods.setGoodsCount(String.valueOf(goodview.getGoodsCount()));	
			}
			queryCinemaGoods.setPickUpCode(goodview.getPickUpCode());
			queryCinemaGoods.setCinemaName(goodview.getCinemaName());
			queryCinemaGoods.setAddress(cinema.getAddress());
			queryCinemaGoods.setCinemaPhone(cinema.getCinemaPhone());
			if(goodview.getSubTotalSettleAmount()!=null){
			queryCinemaGoods.setSubTotalSettleAmount(String.valueOf(goodview.getSubTotalSettleAmount()));
			}
			queryCinemaGoods.setCreated(goodview.getCreated());
			queryCinemaGoods.setMobilePhone(goodview.getMobilePhone());
			if(goodview.getOrderStatus()!=null){
			queryCinemaGoods.setStatus(String.valueOf(goodview.getOrderStatus()));
			}
			queryCinemaGoods.setOrderCode(goodview.getOrderCode());
			queryCinemaGoodsReply.getData().getGood().add(queryCinemaGoods);
			}
		}
		queryCinemaGoodsReply.SetSuccessReply();
		return queryCinemaGoodsReply;
	}
	//QueryMovieSeenReply
	@GetMapping("/QueryMovieSeen/{UserName}/{Password}/{CinemaCode}/{OpenID}")
	@ApiOperation(value = "查询用户看过的电影记录")
	public QueryMovieSeenReply QueryMovieSeen(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OpenID){
		QueryMovieSeenReply queryMovieSeenReply=new QueryMovieSeenReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(queryMovieSeenReply, UserName, Password, CinemaCode, OpenID)) {
			return queryMovieSeenReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			queryMovieSeenReply.SetUserCredentialInvalidReply();
			return queryMovieSeenReply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(CinemaCode);
		if(cinema == null){
			queryMovieSeenReply.SetCinemaInvalidReply();
			return queryMovieSeenReply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = _ticketusersService.getByopenids(OpenID);
		if(ticketuser == null){
			queryMovieSeenReply.SetOpenIDNotExistReply();
			return queryMovieSeenReply;
		}
		List<Adminorderview> adminorderviewList=adminorderviewDao.getByCinemaCode(CinemaCode);
		queryMovieSeenReply.setData(queryMovieSeenReply.new QueryMovieSeenReplySeen());
		if(adminorderviewList==null||adminorderviewList.size()==0){
			queryMovieSeenReply.getData().setCount(0);
		}else{
			queryMovieSeenReply.getData().setCount(adminorderviewList.size());
			queryMovieSeenReply.getData().setSeen(new ArrayList<QueryMovieSeen>());
			for(Adminorderview adminorderview:adminorderviewList){
				QueryMovieSeen queryMovieSeen=queryMovieSeenReply.getData().new QueryMovieSeen();
				queryMovieSeen.setFilmName(adminorderview.getFilmname());
				List<Filminfo> filminfoList=_filminfoServiceImpl.getFilmByFilmName(adminorderview.getFilmname());
				for(Filminfo filminfo:filminfoList){
					QueryMovieSeen querymovieseen=queryMovieSeenReply.getData().new QueryMovieSeen();
					querymovieseen.setCast(filminfo.getCast());
					querymovieseen.setPublishDate(filminfo.getPublishDate());
					querymovieseen.setArea(filminfo.getArea());
					querymovieseen.setImage(filminfo.getImage());
					queryMovieSeenReply.getData().getSeen().add(querymovieseen);
				}
				queryMovieSeenReply.getData().getSeen().add(queryMovieSeen);
			}
		}
		queryMovieSeenReply.SetSuccessReply();
		return queryMovieSeenReply;
	}
	
}
