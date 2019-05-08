package com.boot.security.server.apicontroller;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.api.ctms.reply.YkModelMapper;
import com.boot.security.server.apicontroller.reply.Jscode2sessionReply;
import com.boot.security.server.apicontroller.reply.MobilePhoneRegisterReply;
import com.boot.security.server.apicontroller.reply.MobilePhoneRegisterReply.MobilePhoneRegisterBean;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.apicontroller.reply.SendVerifyCodeReply;
import com.boot.security.server.apicontroller.reply.SendVerifyCodeReply.SendVerifyCodeBean;
import com.boot.security.server.apicontroller.reply.UserLoginInput;
import com.boot.security.server.apicontroller.reply.UserLoginReply;
import com.boot.security.server.apicontroller.reply.UserLoginReply.UserLoginResult;
import com.boot.security.server.apicontroller.reply.UserPhoneInput;
import com.boot.security.server.apicontroller.reply.UserWXResult;
import com.boot.security.server.model.CinemaMiniProgramAccounts;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaMiniProgramAccountsServiceImpl;
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
		//获取sessionKey
//        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+miniProgramAccount.getAppId()+"&secret="+miniProgramAccount.getAppSecret()+"&js_code="+userinput.getCode()+"&grant_type=authorization_code";
//        String returnStr = HttpHelper.httpClientGet(url,null,"UTF-8");
        Map<String,Object> param = new LinkedHashMap<String,Object>();
		param.put("appid", miniProgramAccount.getAppId());
		param.put("secret", miniProgramAccount.getAppSecret());
		param.put("js_code", userinput.getCode());
		param.put("grant_type", "authorization_code");
		
		String url="https://api.weixin.qq.com/sns/jscode2session";
		String returnStr = HttpHelper.sendPostByUrlConnection(url, param, "UTF-8");
        System.out.println("用户登陆返回："+returnStr);
        Jscode2sessionReply jscode2sessionReply = new Gson().fromJson(returnStr, Jscode2sessionReply.class);
        
        //解密微信小程序的登陆加密数据
//        String wxuserStr = AESHelper.AesDecrypt(userinput.getEncryptedData(), jscode2sessionReply.getSession_key(), userinput.getIv());
        String Session_key = "qG/ifbssMqCrhkmJy3DQzg==";
        String wxuserStr = AESHelper.AesDecrypt(userinput.getEncryptedData(), Session_key, userinput.getIv());
        System.out.println("解密------"+wxuserStr);
        UserWXResult wxuser = new Gson().fromJson(wxuserStr, UserWXResult.class);
        
        UserLoginResult data = new UserLoginResult();
        data.setCinemaCode(userinput.getCinemaCode());
//        data.setMobilePhone();
        data.setOpenID(jscode2sessionReply.getOpenid());
        data.setNickName(wxuser.getNickName());
        data.setSex(String.valueOf(wxuser.getGender()));
        data.setCountry(wxuser.getCountry());
        data.setProvince(wxuser.getProvince());
        data.setCity(wxuser.getCity());
//        data.setHeadlmgUrl();
//        data.setLanguage();
//        data.setTotalScore();
//        data.setCreated(new Date());
        data.setIsActive("是");
        userReply.setData(data);
        userReply.SetSuccessReply();
        
        Ticketusers ticketuser = _ticketusersService.getByOpenIdAndCode(jscode2sessionReply.getOpenid(),userinput.getCinemaCode());
        if(ticketuser == null){
        	ticketuser = new Ticketusers();
        	ticketuser.setCinemaCode(userinput.getCinemaCode());
        	ticketuser.setOpenID(jscode2sessionReply.getOpenid());
        	YkModelMapper.MapToEntity(wxuser, ticketuser);
        	_ticketusersService.save(ticketuser);
        } else {
        	_ticketusersService.update(ticketuser);
        }
        
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
		Ticketusers ticketuser = _ticketusersService.getByOpenIdAndCode(OpenID, CinemaCode);
		if(ticketuser == null){
			userReply.SetOpenIDNotExistReply();
			return userReply;
		}
		UserLoginResult data = new UserLoginResult();
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
        data.setCreated(ticketuser.getCreated()==null?"":new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ticketuser.getCreated()));
        data.setIsActive(ticketuser.getIsActive().toString());
        
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
		Ticketusers ticketuser = _ticketusersService.getByOpenIdAndCode(input.getOpenID(), input.getCinemaCode());
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
		Ticketusers ticketuser = _ticketusersService.getByOpenIdAndCode(input.getOpenID(), input.getCinemaCode());
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
}
