package com.boot.security.server.apicontroller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.api.core.CardChargeReply;
import com.boot.security.server.api.core.CardPayBackReply;
import com.boot.security.server.api.core.CardPayReply;
import com.boot.security.server.api.core.CardRegisterReply;
import com.boot.security.server.api.core.LoginCardReply;
import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.QueryCardReply;
import com.boot.security.server.api.core.QueryCardTradeRecordReply;
import com.boot.security.server.api.core.QueryDiscountReply;
import com.boot.security.server.api.ctms.reply.Dy1905GetMemberCardByMobileReply;
import com.boot.security.server.api.ctms.reply.Dy1905Interface;
import com.boot.security.server.apicontroller.reply.ModelMapper;
import com.boot.security.server.apicontroller.reply.PrePayParametersReply;
import com.boot.security.server.apicontroller.reply.QueryCardLevelReply;
import com.boot.security.server.apicontroller.reply.QueryMemberCardByPhoneReply;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.apicontroller.reply.QueryCardLevelReply.QueryCardLevelReplyCard;
import com.boot.security.server.apicontroller.reply.QueryCardLevelReply.QueryCardLevelReplyCard.QueryCardLevelReplyCardLeve;
import com.boot.security.server.apicontroller.reply.QueryMemberCardByPhoneReply.QueryMemberCardByPhoneReplyMemberCardByPhone.QueryMemberCardByPhoneReplyPhone;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Cinemapaymentsettings;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.model.Membercardlevel;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.CinemapaymentsettingsServiceImpl;
import com.boot.security.server.service.impl.MemberCardLevelServiceImpl;
import com.boot.security.server.service.impl.MemberCardServiceImpl;
import com.boot.security.server.service.impl.TicketusersServiceImpl;
import com.boot.security.server.service.impl.UserCinemaViewServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.boot.security.server.utils.WxPayUtil;

import freemarker.template.utility.StringUtil;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/Member")
public class MemberController {
	
	@Autowired
	private UserInfoServiceImpl _userInfoService;
	@Autowired
	private CinemaServiceImpl _cinemaService;
	@Autowired 
	MemberCardServiceImpl _memberCardService;
	@Autowired
	UserCinemaViewServiceImpl _userCinemaViewService;
	@Autowired
	CinemapaymentsettingsServiceImpl _cinemapaymentsettingsService;
	@Autowired
	TicketusersServiceImpl _ticketusersService;
	@Autowired
    private HttpServletRequest request;
	@Autowired
	private MemberCardLevelServiceImpl _memberCardLevelService;
	
	//region 会员卡登陆
	@GetMapping("/LoginCard/{Username}/{Password}/{CinemaCode}/{OpenID}/{CardNo}/{CardPassword}")
	@ApiOperation(value = "会员卡登陆")
	public LoginCardReply  LoginCard(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OpenID,@PathVariable String CardNo,@PathVariable String CardPassword){
		LoginCardReply loginCardReply = new NetSaleSvcCore().LoginCard(Username, Password, CinemaCode, CardNo, CardPassword);
		if(loginCardReply.Status.equals("Success")){
			Membercard membercard = _memberCardService.getByCardNo(CinemaCode, CardNo);
			membercard.setOpenId(OpenID);
			membercard.setStatus(1);
			_memberCardService.Update(membercard);
			if(membercard.getBirthday()!=null){
				loginCardReply.getCard().setBirthday(new SimpleDateFormat("yyyy年MM月dd日").format(membercard.getBirthday()));
			}
		}
		return loginCardReply;
	}
	//endregion
	
	//region 查询会员卡
	@GetMapping("/QueryCard/{Username}/{Password}/{CinemaCode}/{CardNo}/{CardPassword}")
	@ApiOperation(value = "查询会员卡")
	public QueryCardReply QueryCard(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String CardNo,@PathVariable String CardPassword){
		return new NetSaleSvcCore().QueryCard(Username, Password, CinemaCode, CardNo, CardPassword);
	}
	//endregion
	
	//region 查询会员卡折扣
	@GetMapping("/QueryDiscount/{Username}/{Password}/{CinemaCode}/{TicketCount}/{CardNo}/{CardPassword}/{LevelCode}/{SessionCode}/{SessionTime}/{FilmCode}/{ScreenType}/{ListingPrice}/{LowestPrice}")
	@ApiOperation(value = "查询会员卡折扣")
	public QueryDiscountReply QueryDiscount(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String TicketCount,@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String LevelCode,
			@PathVariable String SessionCode,@PathVariable String SessionTime,@PathVariable String FilmCode,@PathVariable String ScreenType,
			@PathVariable String ListingPrice,@PathVariable String LowestPrice){
		return new NetSaleSvcCore().QueryDiscount(Username, Password, CinemaCode, TicketCount, CardNo, CardPassword, LevelCode, SessionCode, SessionTime, FilmCode, ScreenType, ListingPrice, LowestPrice);
	}
	//endregion
	
	//region 会员卡支付
	@GetMapping("/CardPay/{Username}/{Password}/{CinemaCode}/{CardNo}/{CardPassword}/{PayAmount}/{SessionCode}/{FilmCode}/{TicketNum}")
	@ApiOperation(value = "会员卡支付")
	public CardPayReply CardPay(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String PayAmount,@PathVariable String SessionCode,
			@PathVariable String FilmCode,@PathVariable String TicketNum){
		return new NetSaleSvcCore().CardPay(Username, Password, CinemaCode, CardNo, CardPassword, PayAmount, SessionCode, FilmCode, TicketNum);
	}
	//endregion
	
	//region 会员卡支付撤销
	@GetMapping("/CardPayBack/{Username}/{Password}/{CinemaCode}/{CardNo}/{CardPassword}/{TradeNo}/{PayBackAmount}")
	@ApiOperation(value = "会员卡支付撤销")
	public CardPayBackReply CardPayBack(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String TradeNo,@PathVariable String PayBackAmount){
		return new NetSaleSvcCore().CardPayBack(Username, Password, CinemaCode, CardNo, CardPassword, TradeNo, PayBackAmount);
	}
	//endregion
	
	//region 会员卡消费记录
	@GetMapping("/QueryCardTradeRecord/{Username}/{Password}/{CinemaCode}/{CardNo}/{CardPassword}/{StartDate}/{EndDate}/{PageSize}/{PageNum}")
	@ApiOperation(value = "会员卡消费记录")
	public QueryCardTradeRecordReply QueryCardTradeRecord(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String StartDate,@PathVariable String EndDate,
			@PathVariable String PageSize,@PathVariable String PageNum) throws ParseException{
		return new NetSaleSvcCore().QueryCardTradeRecord(Username, Password, CinemaCode, CardNo, CardPassword, StartDate, EndDate, PageSize, PageNum);
	}
	//endregion
	
	//region 会员卡充值
	@GetMapping("/CardCharge/{Username}/{Password}/{CinemaCode}/{CardNo}/{CardPassword}/{ChargeType}/{ChargeAmount}")
	@ApiOperation(value = "会员卡充值")
	public CardChargeReply CardCharge(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String ChargeType,@PathVariable String ChargeAmount){
		return new NetSaleSvcCore().CardCharge(Username, Password, CinemaCode, CardNo, CardPassword, ChargeType, ChargeAmount);
	}
	//endregion
	
	//region 查询会员卡等级
	@GetMapping("/QueryCardLevel/{Username}/{Password}/{CinemaCode}")
	@ApiOperation(value = "查询会员卡等级")
	public QueryCardLevelReply QueryCardLevel(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode){
		QueryCardLevelReply queryCardLevelReply = new QueryCardLevelReply();
		//验证参数
		if (!ReplyExtension.RequestInfoGuard(queryCardLevelReply, Username, Password, CinemaCode))
        {
            return queryCardLevelReply;
        }
		//获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
        	queryCardLevelReply.SetUserCredentialInvalidReply();
            return queryCardLevelReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	queryCardLevelReply.SetCinemaInvalidReply();
            return queryCardLevelReply;
        }
        QueryCardLevelReplyCard data = new QueryCardLevelReplyCard();
        List<QueryCardLevelReplyCardLeve> cardReplyList = new ArrayList<>();
        List<Membercardlevel> memberCardList = _memberCardLevelService.getByCinemaCode(CinemaCode);
        if(memberCardList.size()>0){
        	for(Membercardlevel memberCard : memberCardList){
            	QueryCardLevelReplyCardLeve cardReply = new QueryCardLevelReplyCardLeve();
            	cardReply.setLevelCode(memberCard.getLevelCode());
            	cardReply.setLevelName(memberCard.getLevelName());
            	if(memberCard.getCardCostFee()!=null){
            		cardReply.setCardCostFee(String.valueOf(memberCard.getCardCostFee()));
            	}
            	if(memberCard.getMemberFee()!=null){
            		cardReply.setMemberFee(String.valueOf(memberCard.getMemberFee()));
            	}
            	if(memberCard.getStatus()!=null){
            		cardReply.setStatus(String.valueOf(memberCard.getStatus()));
            	}
            	cardReplyList.add(cardReply);
            }
            data.setCardLeve(cardReplyList);
            data.setCinemaCode(CinemaCode);
        }
        	queryCardLevelReply.setData(data);
        	queryCardLevelReply.SetSuccessReply();
		return queryCardLevelReply;
	}
	//endregion
	
	//region 会员卡注册
	@GetMapping("/CardRegister/{Username}/{Password}/{OpenID}/{CinemaCode}/{CardPassword}/{LevelCode}/{InitialAmount}/{CardUserName}/{MobilePhone}/{IDNumber}/{Sex}")
	@ApiOperation(value = "会员卡注册")
	public CardRegisterReply CardRegister(@PathVariable String Username,@PathVariable String Password,String OpenID,@PathVariable String CinemaCode,
			@PathVariable String CardPassword,@PathVariable String LevelCode,@PathVariable String InitialAmount,@PathVariable String CardUserName,
			@PathVariable String MobilePhone,@PathVariable String IDNumber,@PathVariable String Sex){
			CardRegisterReply cardRegisterReply = new NetSaleSvcCore().CardRegister(Username, Password, CinemaCode, CardPassword, LevelCode, InitialAmount, CardUserName, MobilePhone, IDNumber, Sex);
			if(cardRegisterReply.Status.equals("Success")){
				Membercard membercard = _memberCardService.getByCardNo(CinemaCode, cardRegisterReply.getCardNo());
				membercard.setOpenId(OpenID);
				_memberCardService.Update(membercard);
			}
		return cardRegisterReply; 
	}
	//endregion
	
	//region 根据手机号码查询会员卡信息(本地已绑定)
	@GetMapping("/QueryMemberCardByPhone/{Username}/{Password}/{CinemaCode}/{MobilePhone}")
	@ApiOperation(value = "根据手机号码查询会员卡信息(本地已绑定)")
	public QueryMemberCardByPhoneReply QueryMemberCardByPhone(@PathVariable String Username,@PathVariable String Password,
			@PathVariable String CinemaCode,@PathVariable String MobilePhone){
		QueryMemberCardByPhoneReply queryMemberCardByPhoneReply = new QueryMemberCardByPhoneReply();
		//校验参数
		if (!ReplyExtension.RequestInfoGuard(queryMemberCardByPhoneReply, Username, Password, CinemaCode, MobilePhone))
        {
            return queryMemberCardByPhoneReply;
        }
		//获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
        	queryMemberCardByPhoneReply.SetUserCredentialInvalidReply();
            return queryMemberCardByPhoneReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	queryMemberCardByPhoneReply.SetCinemaInvalidReply();
            return queryMemberCardByPhoneReply;
        }
        List<Membercard> membercards = _memberCardService.getByCinemaCodeAndMobilePhone(CinemaCode, MobilePhone);
        queryMemberCardByPhoneReply.setData(queryMemberCardByPhoneReply.new QueryMemberCardByPhoneReplyMemberCardByPhone());
        if(membercards==null || membercards.size()==0){
        	queryMemberCardByPhoneReply.getData().setMemberPhoneCount(0);
        }else{
        	queryMemberCardByPhoneReply.getData().setMemberPhoneCount(membercards.size());
        	queryMemberCardByPhoneReply.getData().setMemberPhones(new ArrayList<QueryMemberCardByPhoneReplyPhone>());
        	for(Membercard membercard :membercards){
        		QueryMemberCardByPhoneReplyPhone replymember = queryMemberCardByPhoneReply.getData().new QueryMemberCardByPhoneReplyPhone();
        		ModelMapper.MapFrom(replymember, membercard);
        		queryMemberCardByPhoneReply.getData().getMemberPhones().add(replymember);
        	}
        }
        queryMemberCardByPhoneReply.SetSuccessReply();
		return queryMemberCardByPhoneReply;
	}
	//endregion
	
	//region 根据手机号码查询会员卡信息(1905接口)
	@GetMapping("/GetMemberCardByMobile/{Username}/{Password}/{CinemaCode}/{MobilePhone}")
	@ApiOperation(value = "根据手机号码查询会员卡信息(1905接口)")
	public Dy1905GetMemberCardByMobileReply GetMemberCardByMobile(@PathVariable String Username,@PathVariable String Password,
			@PathVariable String CinemaCode,@PathVariable String MobilePhone) throws Exception{
		Dy1905GetMemberCardByMobileReply getMemberCardByMobileReply = new Dy1905GetMemberCardByMobileReply();
		//校验参数
		if (!ReplyExtension.RequestInfoGuard(getMemberCardByMobileReply, Username, Password, CinemaCode, MobilePhone))
		{
		     return getMemberCardByMobileReply;
		}
		//获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
        	getMemberCardByMobileReply.SetUserCredentialInvalidReply();
            return getMemberCardByMobileReply;
        }
        //验证影院是否存在且可访问
     	Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
     	if(userCinema == null){
     		getMemberCardByMobileReply.SetCinemaInvalidReply();
            return getMemberCardByMobileReply;
     	}
		return new Dy1905Interface().GetMemberCardByMobile(userCinema, MobilePhone);
	}
	//endregion
	
	//region 预支付会员卡充值(准备支付参数)
	@GetMapping("/PrePayCardCharge/{Username}/{Password}/{CinemaCode}/{OpenID}/{ChargeAmount}")
	@ApiOperation(value = "预支付会员卡充值(准备支付参数)")
	public PrePayParametersReply PrePayCardCharge(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OpenID,@PathVariable String ChargeAmount){
		PrePayParametersReply prePayParametersReply = new PrePayParametersReply();
		//校验参数
		if (!ReplyExtension.RequestInfoPrePayCardCharge(prePayParametersReply, Username, Password, CinemaCode, OpenID, ChargeAmount))
        {
            return prePayParametersReply;
        }
		//获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
        	prePayParametersReply.SetUserCredentialInvalidReply();
            return prePayParametersReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	prePayParametersReply.SetCinemaInvalidReply();
            return prePayParametersReply;
        }
        //验证此用户是否存在会员卡
        List<Membercard> membercardList = _memberCardService.getByCinemaCodeAndOpenId(CinemaCode, OpenID);
        if(membercardList.size()<=0){
        	prePayParametersReply.SetMemberCardInvalidReply();
        	return prePayParametersReply;
        }
        //获取影院的支付配置
        Cinemapaymentsettings cinemapaymentsettings = _cinemapaymentsettingsService.getByCinemaCode(CinemaCode);
        if(cinemapaymentsettings == null){
        	prePayParametersReply.SetCinemaPaySettingInvalidReply();
        	return prePayParametersReply;
        }
        //准备参数
        String WxpayAppId = cinemapaymentsettings.getWxpayAppId();
        String strbody = cinemapaymentsettings.getCinemaName() + "-" + StringUtil.leftPad(String.valueOf(new Date().getMonth()+1), 2, "0")
                + "月" + StringUtil.leftPad(String.valueOf(new Date().getDay()), 2, "0") + "日" + new SimpleDateFormat("HH:mm").format(new Date()) + " "
                + " 会员卡充值（" + ChargeAmount + " 元）";
        String WxpayMchId = cinemapaymentsettings.getWxpayMchId();
        String WxpayKey = cinemapaymentsettings.getWxpayKey();
        String notify_url = "https://xc.80piao.com:8443/Api/Member/WxPayNotify";
        String out_trade_no = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + CinemaCode + ((Math.random()*9+1)*100000);//随机的六位数字
        String time_expire =new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(new Date() .getTime() + 900000));
        Double totalPrice = Double.valueOf(ChargeAmount);
        String total_fee = String.valueOf(totalPrice * 100);//以分为单位
        return WxPayUtil.WxPayPrePay(request,prePayParametersReply, WxpayAppId, WxpayMchId, WxpayKey, strbody, notify_url, OpenID, out_trade_no, time_expire, total_fee);
	}
	//endregion
	
	//region 预支付会员卡注册(准备支付参数)
	@GetMapping("/PrePayCardCharge/{Username}/{Password}/{CinemaCode}/{OpenID}/{InitialAmount}")
	@ApiOperation(value = "预支付会员卡注册(准备支付参数)")
	public PrePayParametersReply PrePayCardRegister(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OpenID,@PathVariable String InitialAmount){
		PrePayParametersReply prePayParametersReply = new PrePayParametersReply();
		//校验参数
		if (!ReplyExtension.RequestInfoPrePayCardRegister(prePayParametersReply, Username, Password, CinemaCode, OpenID, InitialAmount))
        {
            return prePayParametersReply;
        }
		//获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
        	prePayParametersReply.SetUserCredentialInvalidReply();
            return prePayParametersReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	prePayParametersReply.SetCinemaInvalidReply();
            return prePayParametersReply;
        }
        //验证用户OpenID是否存在
        Ticketusers ticketuser = _ticketusersService.getByopenids(OpenID);
        if (ticketuser == null)
        {
            prePayParametersReply.SetOpenIDNotExistReply();
            return prePayParametersReply;
        }
      //获取影院的支付配置
        Cinemapaymentsettings cinemapaymentsettings = _cinemapaymentsettingsService.getByCinemaCode(CinemaCode);
        if(cinemapaymentsettings == null){
        	prePayParametersReply.SetCinemaPaySettingInvalidReply();
        	return prePayParametersReply;
        }
        //准备参数
        String WxpayAppId = cinemapaymentsettings.getWxpayAppId();
        String strbody = cinemapaymentsettings.getCinemaName() + "-" + StringUtil.leftPad(String.valueOf(new Date().getMonth()+1), 2, "0")
        + "月" + StringUtil.leftPad(String.valueOf(new Date().getDay()), 2, "0") + "日" + new SimpleDateFormat("HH:mm").format(new Date()) + " "
        + " 会员卡注册初始金额（" + InitialAmount + " 元）";
        String WxpayMchId = cinemapaymentsettings.getWxpayMchId();
        String WxpayKey = cinemapaymentsettings.getWxpayKey();
        String notify_url = "https://xc.80piao.com:8443/Api/Member/WxPayNotify";
        String out_trade_no = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + CinemaCode + ((Math.random()*9+1)*100000);//随机的六位数字
        String time_expire =new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(new Date() .getTime() + 900000));
        Double totalPrice = Double.valueOf(InitialAmount);
        String total_fee = String.valueOf(totalPrice * 100);//以分为单位
        return WxPayUtil.WxPayPrePay(request,prePayParametersReply, WxpayAppId, WxpayMchId, WxpayKey, strbody, notify_url, OpenID, out_trade_no, time_expire, total_fee);
	}
	//endregion
	
	//region 异步接收微信支付返回(会员卡注册充值不需要更新订单表，可以为空)
	public void WxPayNotify() throws Exception{
		
	}
	//endregion
}
