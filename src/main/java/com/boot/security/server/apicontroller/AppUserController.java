package com.boot.security.server.apicontroller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boot.security.server.apicontroller.reply.CheckUserFilmOrdersReply;
import com.boot.security.server.apicontroller.reply.Jscode2sessionReply;
import com.boot.security.server.apicontroller.reply.MobilePhoneRegisterReply;
import com.boot.security.server.apicontroller.reply.MobilePhoneRegisterReply.MobilePhoneRegisterBean;
import com.boot.security.server.apicontroller.reply.ModelMapper;
import com.boot.security.server.apicontroller.reply.QueryCinemaGoodsReply;
import com.boot.security.server.apicontroller.reply.QueryCinemaGoodsReply.QueryCinemaGoodsReplyGoods.QueryCinemaGoods;
import com.boot.security.server.apicontroller.reply.QueryRoomGiftRecordReply;
import com.boot.security.server.apicontroller.reply.QueryRoomGiftRecordReply.QueryRoomGiftRecord;
import com.boot.security.server.apicontroller.reply.QueryUserFilmReply;
import com.boot.security.server.apicontroller.reply.QueryUserFilmReply.QueryUserFilmReplyUserFilm;
import com.boot.security.server.apicontroller.reply.QueryUserFilmReply.QueryUserFilmReplyUserFilm.QueryUserFilmReplyFilm;
import com.boot.security.server.apicontroller.reply.QueryUserInfoReply;
import com.boot.security.server.apicontroller.reply.QueryUserInfoReply.QueryUserInfoReplyUserInfo;
import com.boot.security.server.apicontroller.reply.QueryUserLookedFilmsReply;
import com.boot.security.server.apicontroller.reply.QueryUserLookedFilmsReply.QueryUserLookedFilmsReplyUser;
import com.boot.security.server.apicontroller.reply.QueryUserLookedFilmsReply.QueryUserLookedFilmsReplyUser.QueryUserLookedFilmsReplyUserLookedFilms;
import com.boot.security.server.apicontroller.reply.QueryUserNumberReply;
import com.boot.security.server.apicontroller.reply.QueryUserNumberReply.QueryUserNumberReplyUserNumber;
import com.boot.security.server.apicontroller.reply.QueryUserTicketReply;
import com.boot.security.server.apicontroller.reply.QueryUserTicketReply.QueryUserTicketReplyUser;
import com.boot.security.server.apicontroller.reply.QueryUserTicketReply.QueryUserTicketReplyUser.QueryUserTicketReplyUserTicket;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.apicontroller.reply.RoomGiftInput;
import com.boot.security.server.apicontroller.reply.SendVerifyCodeReply;
import com.boot.security.server.apicontroller.reply.SendVerifyCodeReply.SendVerifyCodeBean;
import com.boot.security.server.apicontroller.reply.UpdateHeadUrlReply;
import com.boot.security.server.apicontroller.reply.UpdateHeadUrlReply.UpdateHeadUrlReplyHeadUrl;
import com.boot.security.server.apicontroller.reply.UpdateUserInfoReply;
import com.boot.security.server.apicontroller.reply.UpdateUserWantedFilmReply;
import com.boot.security.server.apicontroller.reply.UserInfo;
import com.boot.security.server.apicontroller.reply.UserLoginInput;
import com.boot.security.server.apicontroller.reply.UserLoginReply;
import com.boot.security.server.apicontroller.reply.UserLoginReply.UserLoginResult;
import com.boot.security.server.apicontroller.reply.UserPhoneInput;
import com.boot.security.server.apicontroller.reply.UserWXResult;
import com.boot.security.server.dao.GoodsorderdetailsDao;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.CinemaMiniProgramAccounts;
import com.boot.security.server.model.Cinemamessage;
import com.boot.security.server.model.CouponGroupStatusEnum;
import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.CouponsStatusEnum;
import com.boot.security.server.model.Couponsgroup;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Goodsorderdetails;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.OrderStatusEnum;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Registeractive;
import com.boot.security.server.model.Registeractivecoupons;
import com.boot.security.server.model.Registercollectionrecord;
import com.boot.security.server.model.Roomgiftuser;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.StatusEnum;
import com.boot.security.server.model.Ticketuserfilm;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.model.UserFilmStatusEnum;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaMiniProgramAccountsServiceImpl;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.CinemamessageServiceImpl;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.CouponsgroupServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.GoodsOrderServiceImpl;
import com.boot.security.server.service.impl.OrderServiceImpl;
import com.boot.security.server.service.impl.RegisteractiveServiceImpl;
import com.boot.security.server.service.impl.RegisteractivecouponsServiceImpl;
import com.boot.security.server.service.impl.RegistercollectionrecordServiceImpl;
import com.boot.security.server.service.impl.RoomgiftuserServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.service.impl.TicketuserfilmServiceImpl;
import com.boot.security.server.service.impl.TicketusersServiceImpl;
import com.boot.security.server.service.impl.UserCinemaViewServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.boot.security.server.utils.AESHelper;
import com.boot.security.server.utils.FileUploadUtils;
import com.boot.security.server.utils.HttpHelper;
import com.boot.security.server.utils.PropertyHolder;
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
	private GoodsOrderServiceImpl _goodsOrderService;
	@Autowired
	private GoodsorderdetailsDao goodsorderdetailsDao;
	@Autowired
	private RegisteractiveServiceImpl registeractiveService;
	@Autowired
	private RegisteractivecouponsServiceImpl registeractivecouponsService;
	@Autowired
	private CouponsgroupServiceImpl couponsgroupService;
	@Autowired
	private CouponsServiceImpl couponsService;
	@Autowired
	private RegistercollectionrecordServiceImpl registercollectionrecordService;
	@Autowired
	private TicketuserfilmServiceImpl ticketuserfilmService;
	@Autowired
	private OrderServiceImpl orderService;
	@Autowired
	private SessioninfoServiceImpl sessioninfoService;
	@Autowired
	private CinemamessageServiceImpl cinemamessageService;
	
	@PostMapping("/UserLogin")
	@ApiOperation(value = "用户登陆")
	public UserLoginReply UserLogin(@RequestBody UserLoginInput userinput) throws ParseException{
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
        } /*else {
        	ModelMapper.MapToEntity(wxuser, ticketuser);
        	_ticketusersService.update(ticketuser);
        }*/
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
        //登陆送优惠券
        if(ticketuser.getOpenID()!=null){
        	//查询用户是否存在领取记录
        	List<Registercollectionrecord> registercollectionrecordList = registercollectionrecordService.getByOpenID(ticketuser.getOpenID());
        	if(registercollectionrecordList.size()<=0){
        		//不存在领取记录：获取所有影院的注册送规则
        		List<Registeractive> registeractiveList = registeractiveService.getCanUseRegisterActive();
            	if(registeractiveList.size()>0){
            		int result =0;
            		for(Registeractive registeractive:registeractiveList){
            			//根据规则编码找到所赠送的优惠券组编码及赠送数量
            			List<Registeractivecoupons> registeractivecouponsList = registeractivecouponsService.getByRegisterActiveCode(registeractive.getRegisterActiveCode());
            			if(registeractivecouponsList.size()>0){
            				for(Registeractivecoupons registeractivecoupons:registeractivecouponsList){
            					//根据优惠券组编码获取所有未使用的优惠券
            					Couponsgroup couponsgroup = couponsgroupService.getByGroupCode(registeractivecoupons.getGroupCode());
            					//判断优惠券可发放数量是否大于赠送数量
            					if(couponsgroup!=null){
                					if((couponsgroup.getCouponsNumber()-couponsgroup.getIssuedNumber())>registeractivecoupons.getGiveNumber()){
                						//是：生成优惠券记录
                						for(int i=0; i<registeractivecoupons.getGiveNumber(); i++){
                							Coupons coupons = new Coupons();
                							//优惠券编码--13位时间戳加5位随机数
                							String couponsCode = String.valueOf(new Date().getTime());
                				    		couponsCode+=(int)((Math.random()*9+1)*10000);
                							coupons.setCouponsCode(couponsCode);
                							coupons.setCouponsName(couponsgroup.getCouponsName());
                							coupons.setGroupCode(couponsgroup.getGroupCode());
                							coupons.setStatus(CouponsStatusEnum.Fetched.getStatusCode());
                							coupons.setOpenID(ticketuser.getOpenID());
                							System.out.println("用户手机号="+ticketuser.getMobilePhone());
                							coupons.setMobilePhone(ticketuser.getMobilePhone());
                							coupons.setCreateDate(new Date());
            								result = couponsService.save(coupons);
                						}
                					}
                					//优惠券生成成功更新优惠券组信息
                					if(result>0){
                						//已发放数量
        				    			couponsgroup.setIssuedNumber(couponsgroup.getIssuedNumber()+registeractivecoupons.getGiveNumber());
        				    			//已领取数量
        				    			couponsgroup.setFetchNumber(couponsgroup.getFetchNumber()+registeractivecoupons.getGiveNumber());
        				    			//剩余数量
        				    			couponsgroup.setRemainingNumber(couponsgroup.getRemainingNumber()-registeractivecoupons.getGiveNumber());
        				    			couponsgroup.setUpdateDate(new Date());
        				    			couponsgroupService.update(couponsgroup);
                					}
            					}
            				}
            				if(result>0){
            					//添加用户领取记录
            					Registercollectionrecord registercollectionrecord = new Registercollectionrecord();
	            				registercollectionrecord.setOpenID(ticketuser.getOpenID());
	            				registercollectionrecord.setRegisterActiveCode(registeractive.getRegisterActiveCode());
	            				registercollectionrecordService.save(registercollectionrecord);
            				}
            			}
            		}
            	}
        	}
        }
        
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
		Cinemamessage cinemamessage=cinemamessageService.getByCinemaCodeAndMessageType(userCinema.getCinemaCode(),"1");
		String smsContent=cinemamessage.getMessageContent().replaceFirst("@VerifyCode",ticketuser.getVerifyCode());
		//String smsContent = ""+ ticketuser.getVerifyCode()+"（万画筒小程序购票平台验证码，一分钟内有效）";
        String sendResult = new SendSmsHelper().SendSms(input.getCinemaCode(), input.getMobilePhone(), smsContent);
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
	
	@GetMapping("/QueryUserResourceNumber/{UserName}/{Password}/{CinemaCode}/{OpenID}")
	@ApiOperation(value = "用户资源数量")
	public QueryUserNumberReply QueryUserNumber(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OpenID){
		QueryUserNumberReply queryUserNumberReply = new QueryUserNumberReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(queryUserNumberReply, UserName, Password, CinemaCode,OpenID)) {
			return queryUserNumberReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			queryUserNumberReply.SetUserCredentialInvalidReply();
			return queryUserNumberReply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(CinemaCode);
		if(cinema == null){
			queryUserNumberReply.SetCinemaInvalidReply();
			return queryUserNumberReply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = _ticketusersService.getByopenids(OpenID);
		if(ticketuser == null){
			queryUserNumberReply.SetOpenIDNotExistReply();
			return queryUserNumberReply;
		}
		QueryUserNumberReplyUserNumber data = new QueryUserNumberReplyUserNumber();
		//影票数量
		List<Orders> ordersList = orderService.getUserOrders(CinemaCode, OpenID, OrderStatusEnum.Complete.getStatusCode(), 1);
		Integer ticketCount = 0;
		if(ordersList.size()>0){
			ticketCount = ordersList.stream().collect(Collectors.summingInt(Orders::getTicketCount));
		}
		data.setTicketCount(ticketCount);
		//卖品数量
		List<Goodsorders> goodsordersList = _goodsOrderService.getUserGoodsOrders(CinemaCode, OpenID, OrderStatusEnum.Complete.getStatusCode());
		Integer goodsCount = 0;
		if(goodsordersList.size()>0){
			goodsCount = goodsordersList.stream().collect(Collectors.summingInt(Goodsorders::getGoodsCount));
		}
		data.setGoodsCount(goodsCount);
		//优惠券数量
		List<Coupons> couponsList = couponsService.getUserCoupons(OpenID, CouponsStatusEnum.Fetched.getStatusCode());
		int couponsCount = 0;
		if(couponsList.size()>0){
			for(Coupons coupons:couponsList){
				Couponsgroup couponsgroup = couponsgroupService.getUserCouponsGroup(coupons.getGroupCode(), CouponGroupStatusEnum.Enabled.getStatusCode(), CinemaCode);
				if(couponsgroup!=null){
					List<Coupons> couponsReList = couponsService.getByGroupCodeAndOpenId(couponsgroup.getGroupCode(), OpenID, CouponsStatusEnum.Fetched.getStatusCode());
					couponsCount +=couponsReList.size();
				}
			}
			data.setCouponsCount(couponsCount);
		}
		//礼品数量
		List<Roomgiftuser> roomgiftuserList = roomgiftuserService.getByOpenid(OpenID, CinemaCode);
		data.setGiftCount(roomgiftuserList.size());
		//想看的电影数量
		List<Ticketuserfilm> ticketuserfilmList = ticketuserfilmService.getByOpenId(OpenID, 1);
		data.setWantedFilmCount(ticketuserfilmList.size());
		//看过的电影数量
		String time = String.valueOf(new Date().getTime()+2*60*60*1000);
		String sessiontime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.parseLong(time)));
		List<Orders> ordersFilmList = orderService.getByOpenIdAndStatus(OpenID, OrderStatusEnum.Complete.getStatusCode(), sessiontime);
		data.setLookedFilmCount(ordersFilmList.size());
		queryUserNumberReply.setData(data);
		queryUserNumberReply.SetSuccessReply();
		return queryUserNumberReply;
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
	@GetMapping("/QueryUserTicket/{UserName}/{Password}/{CinemaCode}/{OpenID}")
	@ApiOperation(value = "查询用户购买的电影票")
	public QueryUserTicketReply QueryUserTicket(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OpenID){
		QueryUserTicketReply queryUserTicketReply = new QueryUserTicketReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(queryUserTicketReply, UserName, Password, CinemaCode, OpenID)) {
			return queryUserTicketReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			queryUserTicketReply.SetUserCredentialInvalidReply();
			return queryUserTicketReply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(CinemaCode);
		if(cinema == null){
			queryUserTicketReply.SetCinemaInvalidReply();
			return queryUserTicketReply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = _ticketusersService.getByopenids(OpenID);
		if(ticketuser == null){
			queryUserTicketReply.SetOpenIDNotExistReply();
			return queryUserTicketReply;
		}   
		//拼接符合条件的状态
		StringBuffer orderstatus = new StringBuffer();
		orderstatus.append(OrderStatusEnum.Submited.getStatusCode()+",");
		orderstatus.append(OrderStatusEnum.Complete.getStatusCode()+",");
		orderstatus.append(OrderStatusEnum.Refund.getStatusCode()+",");
		orderstatus.append(OrderStatusEnum.PayBack.getStatusCode());
		List<Orders> ordersList = orderService.getUserAllOrders(CinemaCode, OpenID, orderstatus.toString());
		QueryUserTicketReplyUser data = new QueryUserTicketReplyUser();
		data.setTicketCount(ordersList.size());
		if(ordersList.size()>0){
			List<QueryUserTicketReplyUserTicket> ticketList = new ArrayList<QueryUserTicketReplyUserTicket>();
			for(Orders orders : ordersList){
				//添加到实体类返回
				QueryUserTicketReplyUserTicket ticket = new QueryUserTicketReplyUserTicket();
				String lookedTime = null;
				ticket.setCinemaName(cinema.getName());
				ticket.setFilmCode(orders.getFilmCode());
				ticket.setFilmName(orders.getFilmName());
				Sessioninfo sessioninfo = sessioninfoService.getBySessionCode(UserInfo.getId(), CinemaCode, orders.getSessionCode());
				if(sessioninfo!=null){
					String time = String.valueOf(sessioninfo.getStartTime().getTime()+Integer.valueOf(sessioninfo.getDuration())*60*1000);
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
					lookedTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(sessioninfo.getStartTime())+"-"+sdf.format(new Date(Long.parseLong(time)));
				}
				ticket.setLookedTime(lookedTime);
				ticket.setOrderCode(orders.getSubmitOrderCode());
				ticket.setOrderStatus(orders.getOrderStatus());
				ticket.setPrintStatus(orders.getPrintStatus());
				ticketList.add(ticket);
			}
			data.setTicket(ticketList);
		}
		queryUserTicketReply.setData(data);
		queryUserTicketReply.SetSuccessReply();
		return queryUserTicketReply;
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
		List<Goodsorders> goodsordersList=_goodsOrderService.getByCinemaCodeAndOpenID(cinema.getCode(), ticketuser.getOpenID());
		queryCinemaGoodsReply.setData(queryCinemaGoodsReply.new QueryCinemaGoodsReplyGoods());
		if(goodsordersList==null||goodsordersList.size()==0){
			queryCinemaGoodsReply.getData().setCount(0);
		}else{
			queryCinemaGoodsReply.getData().setCount(goodsordersList.size());
			queryCinemaGoodsReply.getData().setGood(new ArrayList<QueryCinemaGoods>());
			for(Goodsorders goodsorders:goodsordersList){
				QueryCinemaGoods queryCinemaGoods=queryCinemaGoodsReply.getData().new QueryCinemaGoods();
				
				List<Goodsorderdetails> goodsorderdetailsList=goodsorderdetailsDao.getByOrderId(goodsorders.getId());
				for(Goodsorderdetails goodsorderdetails:goodsorderdetailsList){
					queryCinemaGoods.setGoodsName(goodsorderdetails.getGoodsName());
				}
				queryCinemaGoods.setGoodsCount(goodsorders.getGoodsCount());
				queryCinemaGoods.setPickUpCode(goodsorders.getPickUpCode());
				queryCinemaGoods.setCinemaName(cinema.getName());
				queryCinemaGoods.setAddress(cinema.getAddress());
				queryCinemaGoods.setCinemaPhone(cinema.getCinemaPhone());
				queryCinemaGoods.setSubTotalSettleAmount(goodsorders.getTotalSettlePrice());
				queryCinemaGoods.setOrderCode(goodsorders.getOrderCode());
				queryCinemaGoods.setCreated(goodsorders.getCreated());
				queryCinemaGoods.setMobilePhone(goodsorders.getMobilePhone());
				if(goodsorders.getOrderStatus()!=null){
				queryCinemaGoods.setStatus(String.valueOf(goodsorders.getOrderStatus()));
				}
				queryCinemaGoodsReply.getData().getGood().add(queryCinemaGoods);
			}
			}
		queryCinemaGoodsReply.SetSuccessReply();
		return queryCinemaGoodsReply;
		}
	
	@GetMapping("/UpdateUserWantedFilm/{UserName}/{Password}/{OpenID}/{FilmCode}/{Status}")
	@ApiOperation(value = "更新用户想看的电影")
	public UpdateUserWantedFilmReply UpdateUserWantedFilm(@PathVariable String UserName,@PathVariable String Password,@PathVariable String OpenID,
			@PathVariable String FilmCode,@PathVariable String Status){
		UpdateUserWantedFilmReply updateUserWantedFilmReply = new UpdateUserWantedFilmReply();
		if (!ReplyExtension.RequestInfoGuard(updateUserWantedFilmReply, UserName, Password, OpenID, FilmCode, Status)) {
			return updateUserWantedFilmReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			updateUserWantedFilmReply.SetUserCredentialInvalidReply();
			return updateUserWantedFilmReply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = _ticketusersService.getByopenids(OpenID);
		if(ticketuser == null){
			updateUserWantedFilmReply.SetOpenIDNotExistReply();
			return updateUserWantedFilmReply;
		}
		//添加想看的电影
		if(Status.equals("1")){
			//验证影片是否存在
			Filminfo filminfo = _filminfoServiceImpl.getByFilmCode(FilmCode);
			if(filminfo == null){
				updateUserWantedFilmReply.SetFilmCodeNotExistReply();
				return updateUserWantedFilmReply;
			}
			//验证是否存在记录
			Ticketuserfilm ticketuserfilm = ticketuserfilmService.getByFilmCode(OpenID, FilmCode);
			if(ticketuserfilm != null){
				updateUserWantedFilmReply.SetSuccessReply();
				return updateUserWantedFilmReply;
			}else{
				ticketuserfilm = new Ticketuserfilm();
				ticketuserfilm.setOpenId(OpenID);
				ticketuserfilm.setFilmCode(FilmCode);
				ticketuserfilm.setStatus(Integer.valueOf(Status));
				int result = ticketuserfilmService.save(ticketuserfilm);
				if(result>0){
					updateUserWantedFilmReply.SetSuccessReply();
				}
			}
		}
		//取消想看的电影
		if(Status.equals("0")){
			int result = ticketuserfilmService.deleteByFilmCode(OpenID, FilmCode);
			if(result>0){
				updateUserWantedFilmReply.SetSuccessReply();
			}
		}
		return updateUserWantedFilmReply;
	}
	
	@GetMapping("/QueryUserFilm/{UserName}/{Password}/{OpenID}")
	@ApiOperation(value = "用户想看的电影")
	public QueryUserFilmReply QueryUserFilm(@PathVariable String UserName,@PathVariable String Password,@PathVariable String OpenID){
		QueryUserFilmReply queryUserFilmReply = new QueryUserFilmReply();
		if (!ReplyExtension.RequestInfoGuard(queryUserFilmReply, UserName, Password, OpenID)) {
			return queryUserFilmReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			queryUserFilmReply.SetUserCredentialInvalidReply();
			return queryUserFilmReply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = _ticketusersService.getByopenids(OpenID);
		if(ticketuser == null){
			queryUserFilmReply.SetOpenIDNotExistReply();
			return queryUserFilmReply;
		}
		QueryUserFilmReplyUserFilm data = new QueryUserFilmReplyUserFilm();
		List<Ticketuserfilm> ticketuserfilmList = ticketuserfilmService.getByOpenId(OpenID, UserFilmStatusEnum.Wanted.getStatusCode());
		int count = 0;
		if(ticketuserfilmList.size()>0){
			List<QueryUserFilmReplyFilm> filmReplyList = new ArrayList<QueryUserFilmReplyFilm>();
			for(Ticketuserfilm ticketuserfilm:ticketuserfilmList){
				Filminfo filminfo = _filminfoServiceImpl.getByFilmCode(ticketuserfilm.getFilmCode());
				QueryUserFilmReplyFilm filmReply = new QueryUserFilmReplyFilm();
				if(filminfo!=null){
					count ++;
					filmReply.setFilmName(filminfo.getFilmName());
					filmReply.setArea(filminfo.getArea());
					filmReply.setCast(filminfo.getCast());
					filmReply.setFilmImage(filminfo.getImage());
					filmReply.setPublishDate(new SimpleDateFormat("yyyy-MM-dd").format(filminfo.getPublishDate()));
					filmReplyList.add(filmReply);
				}
			}
			data.setCount(count);
			data.setFilm(filmReplyList);
		}
		queryUserFilmReply.setData(data);
		queryUserFilmReply.SetSuccessReply();
		return queryUserFilmReply;
	}
	
	@GetMapping("/CheckUserFilmOrders/{UserName}/{Password}/{OpenID}/{FilmCode}")
	@ApiOperation(value = "验证用户是否看过此电影")
	public CheckUserFilmOrdersReply CheckUserFilmOrders(@PathVariable String UserName,@PathVariable String Password,
			@PathVariable String OpenID,@PathVariable String FilmCode){
		CheckUserFilmOrdersReply checkUserFilmOrdersReply = new CheckUserFilmOrdersReply();
		//校验参数
		if (!ReplyExtension.RequestInfoGuard(checkUserFilmOrdersReply, UserName, Password, OpenID, FilmCode)) {
			return checkUserFilmOrdersReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			checkUserFilmOrdersReply.SetUserCredentialInvalidReply();
			return checkUserFilmOrdersReply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = _ticketusersService.getByopenids(OpenID);
		if(ticketuser == null){
			checkUserFilmOrdersReply.SetOpenIDNotExistReply();
			return checkUserFilmOrdersReply;
		}
		String time = (String.valueOf(new Date().getTime()+2*60*60*1000));
		String sessiontime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.parseLong(time)));
		List<Orders> ordersList = orderService.checkUserOrders(OpenID, OrderStatusEnum.Complete.getStatusCode(), FilmCode, sessiontime);
		if(ordersList.size()>0){
			checkUserFilmOrdersReply.setResult(1);
		}else{
			checkUserFilmOrdersReply.setResult(0);
			checkUserFilmOrdersReply.setResultMessage("您还没有看过该影片哦");
		}
		checkUserFilmOrdersReply.SetSuccessReply();
		return checkUserFilmOrdersReply;
	}
	
	@GetMapping("/QueryUserLookedFilms/{UserName}/{Password}/{OpenID}")
	@ApiOperation(value = "用户看过的电影")
	public QueryUserLookedFilmsReply QueryUserLookedFilms(@PathVariable String UserName,@PathVariable String Password,@PathVariable String OpenID){
		QueryUserLookedFilmsReply queryUserLookedFilmsReply = new QueryUserLookedFilmsReply();
		//校验参数
		if (!ReplyExtension.RequestInfoGuard(queryUserLookedFilmsReply, UserName, Password, OpenID)) {
			return queryUserLookedFilmsReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			queryUserLookedFilmsReply.SetUserCredentialInvalidReply();
			return queryUserLookedFilmsReply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = _ticketusersService.getByopenids(OpenID);
		if(ticketuser == null){
			queryUserLookedFilmsReply.SetOpenIDNotExistReply();
			return queryUserLookedFilmsReply;
		}
		//先获取用户已完成并且已出票的订单
		List<Orders> ordersList = orderService.getUserCompleteOrders(OpenID, OrderStatusEnum.Complete.getStatusCode(), 1);
		QueryUserLookedFilmsReplyUser data = new QueryUserLookedFilmsReplyUser();
		if(ordersList.size()>0){
			List<QueryUserLookedFilmsReplyUserLookedFilms> userLookedFilmsList = new ArrayList<QueryUserLookedFilmsReplyUserLookedFilms>();
			for(Orders orders : ordersList){
				//获取所有影片信息
				Filminfo filminfo = _filminfoServiceImpl.getByFilmCode(orders.getFilmCode());
				QueryUserLookedFilmsReplyUserLookedFilms userLookedFilms = new QueryUserLookedFilmsReplyUserLookedFilms();
				if(filminfo!=null){
					userLookedFilms.setArea(filminfo.getArea());
					userLookedFilms.setCast(filminfo.getCast());
					userLookedFilms.setFilmImage(filminfo.getImage());
					userLookedFilms.setFilmName(filminfo.getFilmName());
					if(filminfo.getPublishDate()!=null){
						userLookedFilms.setPublishDate(new SimpleDateFormat("yyyy-MM-dd").format(filminfo.getPublishDate()));
					}
				}
				userLookedFilmsList.add(userLookedFilms);
			}
			data.setFilm(userLookedFilmsList);
		}
		data.setCount(ordersList.size());
		queryUserLookedFilmsReply.setData(data);
		queryUserLookedFilmsReply.SetSuccessReply();
		return queryUserLookedFilmsReply;
	}
	
	@GetMapping("/QueryUserInfo/{UserName}/{Password}/{OpenID}")
	@ApiOperation(value = "获取用户信息")
	public QueryUserInfoReply QueryUserInfo(@PathVariable String UserName,@PathVariable String Password,@PathVariable String OpenID){
		QueryUserInfoReply queryUserInfoReply = new QueryUserInfoReply();
		//校验参数
		if (!ReplyExtension.RequestInfoGuard(queryUserInfoReply, UserName, Password, OpenID)) {
			return queryUserInfoReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			queryUserInfoReply.SetUserCredentialInvalidReply();
			return queryUserInfoReply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = _ticketusersService.getByopenids(OpenID);
		if(ticketuser == null){
			queryUserInfoReply.SetOpenIDNotExistReply();
			return queryUserInfoReply;
		}
		QueryUserInfoReplyUserInfo data = new QueryUserInfoReplyUserInfo();
		if(ticketuser.getBirthday()!=null){
			data.setBirthday(new SimpleDateFormat("yyyy-MM-dd").format(ticketuser.getBirthday()));
		}
		if(ticketuser.getMobilePhone()!=null){
			data.setMobilePhone(ticketuser.getMobilePhone());
		}
		data.setHeadUrl(ticketuser.getHeadImgUrl());
		data.setNickName(ticketuser.getNickName());
		data.setSex(ticketuser.getSex());
		queryUserInfoReply.setData(data);
		queryUserInfoReply.SetSuccessReply();
		return queryUserInfoReply;
	}
	
	@PostMapping("/UpdateUserInfo")
	@ApiOperation(value = "修改用户信息")
	public UpdateUserInfoReply UpdateUserInfo(@RequestBody UserInfo userinfo) throws ParseException{
		UpdateUserInfoReply updateUserInfoReply = new UpdateUserInfoReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(updateUserInfoReply, userinfo.getUserName(), userinfo.getPassword(), userinfo.getOpenID())) {
			return updateUserInfoReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(userinfo.getUserName(), userinfo.getPassword());
		if (UserInfo == null) {
			updateUserInfoReply.SetUserCredentialInvalidReply();
			return updateUserInfoReply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = _ticketusersService.getByopenids(userinfo.getOpenID());
		if(ticketuser == null){
			updateUserInfoReply.SetOpenIDNotExistReply();
			return updateUserInfoReply;
		}
		//更新用户信息
		if(!userinfo.getBirthday().equals(null)&&!userinfo.getBirthday().equals("")){
			ticketuser.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(userinfo.getBirthday()));
		}
		if(!userinfo.getNickName().equals(null)&&!userinfo.getNickName().equals("")){
			ticketuser.setNickName(userinfo.getNickName());
		}
		if(!userinfo.getSex().equals(null)&&!userinfo.getSex().equals("")){
			ticketuser.setSex(Integer.valueOf(userinfo.getSex()));
		}
		if(!userinfo.getMobilePhone().equals(null)&&!userinfo.getMobilePhone().equals("")){
			ticketuser.setMobilePhone(userinfo.getMobilePhone());
		}
		int result = _ticketusersService.update(ticketuser);
		if(result>0){
			updateUserInfoReply.SetSuccessReply();
		}
		return updateUserInfoReply;
	}
	
	//region 修改头像
    @RequestMapping(value = "/UpdateHeadUrl", method = {RequestMethod.POST})
    @ResponseBody
    public UpdateHeadUrlReply filmImage(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response,UserInfo userinfo) throws Exception {
    	UpdateHeadUrlReply updateHeadUrlReply = new UpdateHeadUrlReply();
    	//校验参数
    	if (!ReplyExtension.RequestInfoGuard(updateHeadUrlReply, userinfo.getUserName(), userinfo.getPassword(), userinfo.getOpenID())) {
			return updateHeadUrlReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(userinfo.getUserName(), userinfo.getPassword());
		if (UserInfo == null) {
			updateHeadUrlReply.SetUserCredentialInvalidReply();
			return updateHeadUrlReply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = _ticketusersService.getByopenids(userinfo.getOpenID());
		if(ticketuser == null){
			updateHeadUrlReply.SetOpenIDNotExistReply();
			return updateHeadUrlReply;
		}
    	Map<String,Object> map2=new HashMap<>();
        Map<String,Object> map=new HashMap<>();
    	String suffix="";
        String saveroot="";
        String returnroot="";
        String path="";
        String fileName="";
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        System.out.println("file="+file);
        try{
            if(file!=null){
                String originalName = file.getOriginalFilename();
                suffix=originalName.substring(originalName.lastIndexOf(".")+1);//文件后缀
                returnroot=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/upload";
                //上线路径
        		saveroot=PropertyHolder.get().getServerPath()+"/upload";
                path=new SimpleDateFormat("yyyyMM").format(new Date());
                fileName=new Date().getTime()+new Random().nextInt(1000)+"." +suffix;//新的文件名
                File files =new File(saveroot+ File.separator +path+ File.separator);
                File targetFile = new File(files, fileName);
                if(!targetFile.getParentFile().exists()){
                	targetFile.getParentFile().mkdirs();
                }
                file.transferTo(targetFile);
                System.out.println(targetFile);
                
                //上传到OSS服务器
        		if(true){
        			String BUCKET="whtxcx";
        			String BUCKETPATH ="upload";
        			String filePath="/" +path+ "/"+fileName;
        			String mess = FileUploadUtils.uploadOss(saveroot,filePath,BUCKET,BUCKETPATH);
        			System.out.println(mess);
        			if(!"".equals(mess)){
        				map.put("code",-1);
        		        map.put("msg","图片上传出错："+mess);
        			}
        			map2.put("src","https://"+BUCKET+".oss-cn-hangzhou.aliyuncs.com/"+BUCKETPATH+"/"+path+"/"+fileName); 
        		}else{
        			map2.put("src",returnroot +"/" + path + "/" +fileName); 
        		}
            }
        }catch (Exception e){
        }finally{
	        try {
	            if(out!=null){
	                out.close();
	            }
	            if(fileInput!=null){
	                fileInput.close();
	            }
	        } catch (IOException e) {
	        }
        }
        UpdateHeadUrlReplyHeadUrl data = new UpdateHeadUrlReplyHeadUrl();
        //更新到数据库
        ticketuser.setHeadImgUrl(String.valueOf(map2.get("src")));
        int result = _ticketusersService.update(ticketuser);
		if(result>0){
			data.setHeadUrl(String.valueOf(map2.get("src")));
		}
		System.out.println("map="+new Gson().toJson(map));
		System.out.println("map2="+new Gson().toJson(map2));
        updateHeadUrlReply.setData(data);
        updateHeadUrlReply.SetSuccessReply();
        return updateHeadUrlReply;
    }
    //endregion
    
	public static void main(String[] args) {
		String sub = "123456";
		System.out.println(sub.length());
		
	}
}
