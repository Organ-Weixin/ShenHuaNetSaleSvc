package com.boot.security.server.apicontroller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
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
import com.boot.security.server.api.core.SubmitGoodsOrderReply;
import com.boot.security.server.api.core.SubmitGoodsOrderReply.SubmitGoodsOrderReplyOrder;
import com.boot.security.server.api.ctms.reply.CTMSSubmitGoodsOrderReply;
import com.boot.security.server.api.ctms.reply.CTMSSubmitOrderReply;
import com.boot.security.server.api.ctms.reply.Dy1905GetMemberCardByMobileReply;
import com.boot.security.server.api.ctms.reply.Dy1905Interface;
import com.boot.security.server.api.ctms.reply.YkInterface;
import com.boot.security.server.apicontroller.reply.GoodsOrderMemberReply;
import com.boot.security.server.apicontroller.reply.MemberCardPayReply;
import com.boot.security.server.apicontroller.reply.MemberCardUnbindReply;
import com.boot.security.server.apicontroller.reply.ModelMapper;
import com.boot.security.server.apicontroller.reply.PrePayParametersReply;
import com.boot.security.server.apicontroller.reply.QueryCardLevelReply;
import com.boot.security.server.apicontroller.reply.QueryMemberCardByPhoneReply;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.apicontroller.reply.SellTicketCustomMemberReply;
import com.boot.security.server.apicontroller.reply.QueryCardLevelReply.QueryCardLevelReplyCard;
import com.boot.security.server.apicontroller.reply.QueryCardLevelReply.QueryCardLevelReplyCard.QueryCardLevelReplyCardLeve;
import com.boot.security.server.apicontroller.reply.QueryMemberCardByOpenIDReply.QueryMemberCardByOpenIDReplyOpenIDCard;
import com.boot.security.server.apicontroller.reply.QueryMemberCardByOpenIDReply.QueryMemberCardByOpenIDReplyOpenIDCard.QueryMemberCardByOpenIDReplyOpenIDMemberCard;
import com.boot.security.server.apicontroller.reply.QueryMemberCardByOpenIDReply;
import com.boot.security.server.apicontroller.reply.QueryMemberCardByPhoneReply.QueryMemberCardByPhoneReplyMemberCardByPhone.QueryMemberCardByPhoneReplyPhone;
import com.boot.security.server.apicontroller.reply.QueryMemberCardLevelReply.QueryMemberCardLevelReplyMemberCard;
import com.boot.security.server.apicontroller.reply.QueryMemberCardLevelReply.QueryMemberCardLevelReplyMemberCard.QueryMemberCardLevelReplyMemberCardLevel;
import com.boot.security.server.apicontroller.reply.QueryMemberCardLevelRuleReply.QueryMemberCardLevelRuleReplyMemberCard;
import com.boot.security.server.apicontroller.reply.QueryMemberCardLevelRuleReply.QueryMemberCardLevelRuleReplyMemberCard.QueryMemberCardLevelRuleReplyMemberCardRule;
import com.boot.security.server.apicontroller.reply.QueryMemberCardLevelRuleReply;
import com.boot.security.server.apicontroller.reply.QueryMemberCardLevelReply;
import com.boot.security.server.model.Choosemembercardcreditrule;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.CinemaTypeEnum;
import com.boot.security.server.model.Cinemapaymentsettings;
import com.boot.security.server.model.CouponsStatusEnum;
import com.boot.security.server.model.CouponsView;
import com.boot.security.server.model.GoodsOrderStatusEnum;
import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodsorderdetails;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.model.Membercardcreditrule;
import com.boot.security.server.model.Membercardlevel;
import com.boot.security.server.model.OrderPayTypeEnum;
import com.boot.security.server.model.OrderStatusEnum;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Priceplan;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.ChoosemembercardcreditruleServiceImpl;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.CinemapaymentsettingsServiceImpl;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.GoodsOrderServiceImpl;
import com.boot.security.server.service.impl.MemberCardLevelServiceImpl;
import com.boot.security.server.service.impl.MemberCardServiceImpl;
import com.boot.security.server.service.impl.MembercardcreditruleServiceImpl;
import com.boot.security.server.service.impl.OrderServiceImpl;
import com.boot.security.server.service.impl.OrderseatdetailsServiceImpl;
import com.boot.security.server.service.impl.PriceplanServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.service.impl.TicketusersServiceImpl;
import com.boot.security.server.service.impl.UserCinemaViewServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.boot.security.server.utils.CouponsUtil;
import com.boot.security.server.utils.GoodsCouponsPriceUtil;
import com.boot.security.server.utils.SendSmsHelper;
import com.boot.security.server.utils.WxPayUtil;
import com.google.gson.Gson;

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
	@Autowired
	private ChoosemembercardcreditruleServiceImpl _choosemembercardcreditruleService;
	@Autowired
	private MembercardcreditruleServiceImpl _membercardcreditruleService;
	@Autowired
	private OrderServiceImpl orderService;
	@Autowired
	private GoodsOrderServiceImpl goodsOrderService;
	@Autowired
	CouponsServiceImpl _couponsService;
	@Autowired
	SessioninfoServiceImpl _sessioninfoService;
	@Autowired
	OrderseatdetailsServiceImpl _orderseatdetailService;
	@Autowired
	PriceplanServiceImpl _priceplanService;
	
	//region 会员卡登陆
	@GetMapping("/LoginCard/{Username}/{Password}/{CinemaCode}/{OpenID}/{CardNo}/{CardPassword}")
	@ApiOperation(value = "会员卡登陆")
	public LoginCardReply  LoginCard(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OpenID,@PathVariable String CardNo,@PathVariable String CardPassword){
		LoginCardReply loginCardReply = new NetSaleSvcCore().LoginCard(Username, Password, CinemaCode, CardNo, CardPassword);
		if(loginCardReply.Status.equals("Success")){
			/*Membercardlevel membercardlevel = _memberCardLevelService.getByCinemaCodeAndLevelCode(loginCardReply.getCinemaCode(), loginCardReply.getCard().getLevelCode());
			if(membercardlevel==null||membercardlevel.getStatus()!=1){
				loginCardReply.setCard(null);
				loginCardReply.SetCardLevelNonsupportReply();
				return loginCardReply;
			}*/
			Membercard membercard = _memberCardService.getByCardNo(CinemaCode, CardNo);
			membercard.setOpenId(OpenID);
			membercard.setStatus(1);
			_memberCardService.Update(membercard);
			if(membercard.getBirthday()!=null){
				loginCardReply.getCard().setBirthday(new SimpleDateFormat("yyyy-MM-dd").format(membercard.getBirthday()));
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
	@GetMapping("/QueryDiscount/{Username}/{Password}/{CinemaCode}/{CardNo}/{CardPassword}/{LevelCode}/{ScreenType}/{LockOrderCode}")
	@ApiOperation(value = "查询会员卡折扣")
	public QueryDiscountReply QueryDiscount(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			  @PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String LevelCode,
			  @PathVariable String ScreenType,@PathVariable String LockOrderCode){
		OrderView order=orderService.getOrderWidthLockOrderCode(CinemaCode,LockOrderCode);
		Sessioninfo session=_sessioninfoService.getSessionCode(CinemaCode,order.getOrderBaseInfo().getSessionCode());
		String listingPrice = "0.00";
		String lowestPrice = "0.00";
		if(session.getListingPrice()!=null){
			listingPrice = new DecimalFormat("0.00").format(session.getListingPrice());
		}
		if(session.getLowestPrice()!=null){
			lowestPrice = new DecimalFormat("0.00").format(session.getLowestPrice());
		}
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		QueryDiscountReply reply = new NetSaleSvcCore().QueryDiscount(Username, Password, CinemaCode, order.getOrderBaseInfo().getTicketCount().toString(), CardNo, CardPassword, LevelCode,session.getSCode(),sf.format(session.getStartTime()),session.getFilmCode(), ScreenType, listingPrice, lowestPrice);
		if(reply.Status.equals("Success")){
			//设置为初始的实际销售价，具体服务费与优惠在支付时计算
			for(Orderseatdetails seat:order.getOrderSeatDetails()){
				if(reply.getCard().getPrice()!=0f){
					seat.setSalePrice(reply.getCard().getPrice().doubleValue());//把会员价更新到座位表
				}else{
					seat.setSalePrice(session.getStandardPrice());
				}
				_orderseatdetailService.update(seat);
			}
		}
		return reply;
	}
	//endregion
	
	//region 会员卡支付
	@GetMapping("/CardPay/{Username}/{Password}/{CinemaCode}/{LockOrderCode}/{LocalOrderCode}/{CardNo}/{CardPassword}/{PayAmount}/{GoodsPayAmount}/{SessionCode}/{FilmCode}/{TicketNum}/{CouponsCodes}")
	@ApiOperation(value = "会员卡支付")
	public CardPayReply CardPay(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String LockOrderCode,@PathVariable String LocalOrderCode,@PathVariable String CardNo,@PathVariable String CardPassword,
			@PathVariable String PayAmount,@PathVariable String GoodsPayAmount,@PathVariable String SessionCode,
			@PathVariable String FilmCode,@PathVariable String TicketNum,@PathVariable String CouponsCodes){
		Map<String,Double> map=new CouponsUtil().getCouponsPrice(CinemaCode,LockOrderCode,LocalOrderCode,CouponsCodes);
		CardPayReply reply = new NetSaleSvcCore().CardPay(Username, Password, CinemaCode, CardNo, CardPassword,String.valueOf(map.get("realPayAmount")),String.valueOf(map.get("realGoodsPayAmount")), SessionCode, FilmCode, TicketNum);
		OrderView order = orderService.getOrderWidthLockOrderCode(CinemaCode, LockOrderCode);
		GoodsOrderView goodsOrder = goodsOrderService.getWithLocalOrderCode(CinemaCode,LocalOrderCode);
		//region 更新订单支付状态
		if(order!=null&&order.getOrderBaseInfo()!=null){
			if(reply.Status.equals("Success")){
				//更新订单
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Payed.getStatusCode());
				order.getOrderBaseInfo().setPayFlag(1);
				order.getOrderBaseInfo().setPayTime(new Date());
				order.getOrderBaseInfo().setOrderTradeNo(reply.getTradeNo());
				order.getOrderBaseInfo().setCardNo(CardNo);
				order.getOrderBaseInfo().setCardPassword(CardPassword);
				order.getOrderBaseInfo().setOrderPayType(OrderPayTypeEnum.MemberCardPay.getTypeCode());
				order.getOrderBaseInfo().setUpdated(new Date());
				//更新优惠券已使用
				for (Orderseatdetails seat : order.getOrderSeatDetails()) {
					if (seat.getConponCode()!=null&&seat.getConponCode()!="") {
						CouponsView couponsview=_couponsService.getWithCouponsCode(seat.getConponCode());
						if(couponsview!=null){
							couponsview.getCoupons().setStatus(CouponsStatusEnum.Used.getStatusCode());
							couponsview.getCoupons().setUsedDate(new Date());
							//使用数量+1
							couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()+1);
							couponsview.getCouponsgroup().setRemainingNumber(couponsview.getCouponsgroup().getRemainingNumber()-1);
							//更新优惠券及优惠券分组表
							_couponsService.update(couponsview);
						}
					}
				}
			}else{
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.PayFail.getStatusCode());
			}
			orderService.update(order.getOrderBaseInfo());
		}
		if(goodsOrder!=null&&goodsOrder.getOrderBaseInfo()!=null){
			if(reply.Status.equals("Success")){
				//更新卖品订单
				goodsOrder.getOrderBaseInfo().setCardNo(CardNo);
				goodsOrder.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Payed.getStatusCode());
				goodsOrder.getOrderBaseInfo().setOrderPayFlag(1);
				goodsOrder.getOrderBaseInfo().setOrderPayTime(new Date());
				goodsOrder.getOrderBaseInfo().setOrderTradeNo(reply.getTradeNo());
				goodsOrder.getOrderBaseInfo().setOrderPayType(OrderPayTypeEnum.MemberCardPay.getTypeCode());
				goodsOrder.getOrderBaseInfo().setUpdated(new Date());
				// 更新优惠券已使用
				if (!goodsOrder.getOrderBaseInfo().getCouponsCode().equals(null)&&!goodsOrder.getOrderBaseInfo().getCouponsCode().equals("")) {
					CouponsView couponsview=_couponsService.getWithCouponsCode(goodsOrder.getOrderBaseInfo().getCouponsCode());
					if(couponsview!=null){
						couponsview.getCoupons().setStatus(CouponsStatusEnum.Used.getStatusCode());
						couponsview.getCoupons().setUsedDate(new Date());
						//使用数量+1
						couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()+1);
						//更新优惠券及优惠券分组表
						_couponsService.update(couponsview);
					}
				}
			}else{
				goodsOrder.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.PayFail.getStatusCode());
			}
			goodsOrderService.update(goodsOrder.getOrderBaseInfo());
		}
		//endregion
		return reply;
	}
	//endregion
	
	//region 1905会员卡支付+购票
	@GetMapping("/SellTicketCustomMember/{Username}/{Password}/{CinemaCode}/{LockOrderCode}/{MobilePhone}/{CardNo}/{CardPassword}/{CouponsCodes}")
	@ApiOperation(value = "会员卡购票（1905）")
	public SellTicketCustomMemberReply SellTicketCustomMember(@PathVariable String Username,@PathVariable String Password,
			@PathVariable String CinemaCode,@PathVariable String LockOrderCode,@PathVariable String MobilePhone,
			@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String CouponsCodes) throws Exception{
		//更新一下座位价格
		Map<String,Double> map=new CouponsUtil().getCouponsPrice(CinemaCode,LockOrderCode,"",CouponsCodes);
		SellTicketCustomMemberReply reply = new Dy1905Interface().SellTicketCustomMember(Username, Password, CinemaCode, LockOrderCode, CardNo, CardPassword);
		if(reply.Status.equals("Success")){
			Orders orders = orderService.getByLockOrderCode(CinemaCode, LockOrderCode);
			if(orders!=null){
				orders.setMobilePhone(MobilePhone);
				orderService.update(orders);
			}
		}
		return reply;
	}
	//endregion
	
	//region 1905会员卡支付+卖品
	@GetMapping("/GoodsOrderMember/{Username}/{Password}/{CinemaCode}/{LocalOrderCode}/{MobilePhone}/{CardNo}/{CardPassword}/{CouponsCodes}")
	@ApiOperation(value = "会员卡卖品（1905）")
	public GoodsOrderMemberReply GoodsOrderMember(@PathVariable String Username,@PathVariable String Password,
			@PathVariable String CinemaCode,@PathVariable String LocalOrderCode,@PathVariable String MobilePhone,
			@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String CouponsCodes) throws Exception{
		//更新卖品优惠
		Map<String,Double> map=new CouponsUtil().getCouponsPrice(CinemaCode,"",LocalOrderCode,CouponsCodes);
		new GoodsCouponsPriceUtil().getGoodsCouponsPrice(LocalOrderCode);
		GoodsOrderMemberReply reply =new Dy1905Interface().GoodsOrderMember(Username, Password, CinemaCode, LocalOrderCode, CardNo, CardPassword);
		if(reply.Status.equals("Success")){
			Goodsorders goodsorders = goodsOrderService.getByLocalOrderCode(LocalOrderCode);
			if(goodsorders!=null){
				goodsorders.setMobilePhone(MobilePhone);
				goodsOrderService.update(goodsorders);
			}
		}
		return reply;
	}
	//endregion
	
	//region 1905会员卡支付+购票+卖品
	@GetMapping("/MemberCardPay/{Username}/{Password}/{CinemaCode}/{LockOrderCode}/{LocalOrderCode}/{CardNo}/{CardPassword}/{CouponsCodes}")
	@ApiOperation(value = "会员卡混合支付（1905）")
	public MemberCardPayReply MemberCardPay(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String LockOrderCode,@PathVariable String LocalOrderCode,@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String CouponsCodes) throws Exception{
		//更新购票以及卖品优惠金额
		Map<String,Double> map=new CouponsUtil().getCouponsPrice(CinemaCode,LockOrderCode,LocalOrderCode,CouponsCodes);
		return new Dy1905Interface().MemberCardPay(Username, Password, CinemaCode, LockOrderCode, LocalOrderCode, CardNo, CardPassword);
	}
	//endregion
	
	//region 会员卡购票（粤科）
	@GetMapping("/YkTicketmMember/{Username}/{Password}/{CinemaCode}/{LockOrderCode}/{MobilePhone}/{CardNo}/{CardPassword}/{CouponsCodes}")
	@ApiOperation(value = "会员卡购票（粤科）")
	public SellTicketCustomMemberReply YkTicketmMember(@PathVariable String Username,@PathVariable String Password,	@PathVariable String CinemaCode,
			@PathVariable String LockOrderCode,@PathVariable String MobilePhone,@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String CouponsCodes) throws Exception{
		//更新一下座位价格
		new CouponsUtil().getCouponsPrice(CinemaCode,LockOrderCode,"",CouponsCodes);
		SellTicketCustomMemberReply reply = new SellTicketCustomMemberReply();
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			reply.SetUserCredentialInvalidReply();
			return reply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
		if (userCinema == null) {
			reply.SetCinemaInvalidReply();
			return reply;
		}
		//验证订单是否存在
		OrderView order = orderService.getOrderWidthLockOrderCode(CinemaCode, LockOrderCode);
		if(order == null){
			reply.SetOrderNotExistReply();
			return reply;
		}
		//验证会员卡
		Membercard membercard = _memberCardService.getByCardNo(CinemaCode, CardNo);
		if(membercard == null){
			reply.SetMemberCardInvalidReply();
			return reply;
		}
		
		order.getOrderBaseInfo().setMobilePhone(MobilePhone);
		order.getOrderBaseInfo().setCardNo(CardNo);
		CTMSSubmitOrderReply ykReply = new YkInterface().SubmitOrder(userCinema, order);
		System.out.println("----"+new Gson().toJson(ykReply));
		if("Success".equals(ykReply.Status.getStatusCode())){
			// 更新订单信息
			order.getOrderBaseInfo().setUpdated(new Date());//添加更新时间
			orderService.Update(order);
			
			//返回
			reply.setOrderNo(order.getOrderBaseInfo().getSubmitOrderCode());
			reply.setPrintNo(order.getOrderBaseInfo().getPrintNo());
			reply.setVerifyCode(order.getOrderBaseInfo().getVerifyCode());
		}
		reply.Status = ykReply.Status.getStatusCode();
		reply.ErrorCode = ykReply.ErrorCode;
		reply.ErrorMessage = ykReply.ErrorMessage;
		
		return reply;
	}
	//endregion
	
	//region 会员卡卖品（粤科）
	@GetMapping("/YkGoodsOrderMember/{Username}/{Password}/{CinemaCode}/{LocalOrderCode}/{MobilePhone}/{CardNo}/{CardPassword}/{CouponsCodes}")
	@ApiOperation(value = "会员卡卖品（粤科）")
	public SubmitGoodsOrderReply YkGoodsOrderMember(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String LocalOrderCode,@PathVariable String MobilePhone,@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String CouponsCodes) throws Exception{
		//更新卖品优惠
		new CouponsUtil().getCouponsPrice(CinemaCode,"",LocalOrderCode,CouponsCodes);
		SubmitGoodsOrderReply reply = new SubmitGoodsOrderReply();
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			reply.SetUserCredentialInvalidReply();
			return reply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
		if (userCinema == null) {
			reply.SetCinemaInvalidReply();
			return reply;
		}
		//验证订单是否存在
		GoodsOrderView order = goodsOrderService.getWithLocalOrderCode(CinemaCode, LocalOrderCode);
		if(order == null){
			reply.SetOrderNotExistReply();
			return reply;
		}
		//验证会员卡
		Membercard membercard = _memberCardService.getByCardNo(CinemaCode, CardNo);
		if(membercard == null){
			reply.SetMemberCardInvalidReply();
			return reply;
		}
		
		order.getOrderBaseInfo().setMobilePhone(MobilePhone);
		order.getOrderBaseInfo().setCardNo(CardNo);
		order.getOrderBaseInfo().setCardPassword(CardPassword);
		CTMSSubmitGoodsOrderReply ykReply = new YkInterface().SubmitGoodsOrder(userCinema, order);
		System.out.println("----"+new Gson().toJson(ykReply));
		if("Success".equals(ykReply.Status.getStatusCode())){
			// 更新订单信息
			order.getOrderBaseInfo().setUpdated(new Date());//添加更新时间
			goodsOrderService.Update(order);
			
			//返回
			reply.setOrder(new SubmitGoodsOrderReplyOrder());
			reply.getOrder().setOrderCode(order.getOrderBaseInfo().getOrderCode());
			reply.getOrder().setPickUpCode(order.getOrderBaseInfo().getPickUpCode());
			reply.SetSuccessReply();
		}else {
			reply.GetErrorFromCTMSReply(ykReply);
		}
		
		return reply;
	}
	//endregion
	
	//region 会员卡支付撤销
	@GetMapping("/CardPayBack/{Username}/{Password}/{CinemaCode}/{CardNo}/{CardPassword}/{TradeNo}/{PayBackAmount}")
	@ApiOperation(value = "会员卡支付撤销")
	public CardPayBackReply CardPayBack(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String TradeNo,@PathVariable String PayBackAmount){
		CardPayBackReply reply = new NetSaleSvcCore().CardPayBack(Username, Password, CinemaCode, CardNo, CardPassword, TradeNo, PayBackAmount);
		System.out.println("api:"+new Gson().toJson(reply));
		OrderView order = orderService.getOrderWidthTradeNo(CinemaCode, TradeNo);
		Goodsorders goodsorders = goodsOrderService.getByOrderTradeNo(CinemaCode, TradeNo);
		if(order!=null){
			if(reply.Status.equals("Success")){
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.PayBack.getStatusCode());
				order.getOrderBaseInfo().setRefundTradeNo(reply.getTradeNo());
				order.getOrderBaseInfo().setRefundTime(new Date());
				orderService.update(order.getOrderBaseInfo());
				//退优惠券
				for(Orderseatdetails seat:order.getOrderSeatDetails()){
					if(seat.getConponCode()!=null&&seat.getConponCode()!=""){
						CouponsView couponsview = _couponsService.getWithCouponsCode(seat.getConponCode());
						if(couponsview!=null){
							couponsview.getCoupons().setStatus(CouponsStatusEnum.Fetched.getStatusCode());
							couponsview.getCoupons().setUsedDate(null);
							//使用数量-1
							couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()-1);
							couponsview.getCouponsgroup().setRemainingNumber(couponsview.getCouponsgroup().getRemainingNumber()+1);
							//更新优惠券及优惠券分组表
							_couponsService.update(couponsview);
						}
					}
				}
			}
		}
		if(goodsorders!=null){
			if(reply.Status.equals("Success")){
				goodsorders.setOrderStatus(GoodsOrderStatusEnum.PayBack.getStatusCode());
				goodsorders.setRefundTradeNo(reply.getTradeNo());
				goodsorders.setRefundTime(new Date());
				goodsOrderService.update(goodsorders);
				//退优惠券
				if(!goodsorders.getCouponsCode().equals(null)&&!goodsorders.getCouponsCode().equals("")){
					CouponsView couponsview = _couponsService.getWithCouponsCode(goodsorders.getCouponsCode());
					if(couponsview!=null){
						couponsview.getCoupons().setStatus(CouponsStatusEnum.Fetched.getStatusCode());
						couponsview.getCoupons().setUsedDate(null);
						//使用数量-1
						couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()-1);
						//更新优惠券及优惠券分组表
						_couponsService.update(couponsview);
					}
				}
			}
		}
		return reply;
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
	@GetMapping("/CardCharge/{Username}/{Password}/{CinemaCode}/{CardNo}/{CardPassword}/{ChargeType}/{LevelCode}/{RuleCode}/{ChargeAmount}")
	@ApiOperation(value = "会员卡充值")
	public CardChargeReply CardCharge(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String ChargeType,@PathVariable String LevelCode,
			@PathVariable String RuleCode,@PathVariable String ChargeAmount){
		CardChargeReply cardChargeReply = new CardChargeReply();
		if(RuleCode==null||RuleCode==""){
			cardChargeReply.SetCardChargeTypeInvalidReply();
			return cardChargeReply;
		}
		Choosemembercardcreditrule choosemembercardcreditrule = _choosemembercardcreditruleService.getByRuleCode(CinemaCode, LevelCode, RuleCode);
		if(choosemembercardcreditrule==null){
			cardChargeReply.SetCardChargeTypeInvalidReply();
			return cardChargeReply;
		}
		if(choosemembercardcreditrule.getRuleCode()==null){
			cardChargeReply.SetCardChargeTypeInvalidReply();
			return cardChargeReply;
		}
		Membercardcreditrule membercardcreditrule = _membercardcreditruleService.getByRuleCode(choosemembercardcreditrule.getRuleCode());
		if(membercardcreditrule==null){
			cardChargeReply.SetCardChargeTypeInvalidReply();
			return cardChargeReply;
		}
		if(membercardcreditrule.getRuleCode()==null||membercardcreditrule.getStatus()!=1){
			cardChargeReply.SetCardChargeTypeInvalidReply();
			return cardChargeReply;
		}
		ChargeAmount = String.valueOf(membercardcreditrule.getCredit()+membercardcreditrule.getGivenAmount());
		CardChargeReply reply = new NetSaleSvcCore().CardCharge(Username, Password, CinemaCode, CardNo, CardPassword, ChargeType, ChargeAmount);
		if(reply.Status.equals("Success")){
			Membercard membercard=_memberCardService.getByCardNo(CinemaCode, CardNo);
			QueryCardReply queryCardReply=QueryCard(Username, Password, CinemaCode, CardNo, CardPassword);
			if(queryCardReply.Status.equals("Success")){
				membercard.setBalance(Double.valueOf(queryCardReply.getCard().getBalance()));
				membercard.setScore(Integer.valueOf(queryCardReply.getCard().getScore()));
			}
			_memberCardService.Update(membercard);
			String MsgConetnt="您的充值已成功，充值金额为"+ChargeAmount+"元，余额为"+membercard.getBalance()+"元，剩余积分"+membercard.getScore()+"。";
			new SendSmsHelper().SendSms(CinemaCode, membercard.getMobilePhone(),MsgConetnt);
		}
		return reply;
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
	@GetMapping("/CardRegister/{Username}/{Password}/{CinemaCode}/{OpenID}/{CardPassword}/{LevelCode}/{RuleCode}/{InitialAmount}/{CardUserName}/{MobilePhone}/{IDNumber}/{Sex}")
	@ApiOperation(value = "会员卡注册")
	public CardRegisterReply CardRegister(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OpenID,@PathVariable String CardPassword,@PathVariable String LevelCode,
			@PathVariable String RuleCode,@PathVariable String InitialAmount,@PathVariable String CardUserName,
			@PathVariable String MobilePhone,@PathVariable String IDNumber,@PathVariable String Sex){
			CardRegisterReply cardRegisterReply = new CardRegisterReply();
			if(RuleCode==null||RuleCode==""){
				cardRegisterReply.SetCardChargeTypeInvalidReply();
				return cardRegisterReply;
			}
			Choosemembercardcreditrule choosemembercardcreditrule = _choosemembercardcreditruleService.getByRuleCode(CinemaCode, LevelCode, RuleCode);
			if(choosemembercardcreditrule==null){
				cardRegisterReply.SetCardChargeTypeInvalidReply();
				return cardRegisterReply;
			}
			if(choosemembercardcreditrule.getRuleCode()==null){
				cardRegisterReply.SetCardChargeTypeInvalidReply();
				return cardRegisterReply;
			}
			Membercardcreditrule membercardcreditrule = _membercardcreditruleService.getByRuleCode(choosemembercardcreditrule.getRuleCode());
			if(membercardcreditrule==null){
				cardRegisterReply.SetCardChargeTypeInvalidReply();
				return cardRegisterReply;
			}
			if(membercardcreditrule.getRuleCode()==null){
				cardRegisterReply.SetCardChargeTypeInvalidReply();
				return cardRegisterReply;
			}
			InitialAmount = String.valueOf(membercardcreditrule.getCredit()+membercardcreditrule.getGivenAmount());
			cardRegisterReply = new NetSaleSvcCore().CardRegister(Username, Password, CinemaCode, CardPassword, LevelCode, InitialAmount, CardUserName, MobilePhone, IDNumber, Sex);
			if(cardRegisterReply.Status.equals("Success")){
				Membercard membercard = _memberCardService.getByCardNo(CinemaCode, cardRegisterReply.getCardNo());
				membercard.setOpenId(OpenID);
				membercard.setStatus(1);
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
	@GetMapping("/PrePayCardCharge/{Username}/{Password}/{CinemaCode}/{OpenID}/{LevelCode}/{RuleCode}/{ChargeAmount}")
	@ApiOperation(value = "预支付会员卡充值(准备支付参数)")
	public PrePayParametersReply PrePayCardCharge(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OpenID,@PathVariable String LevelCode,@PathVariable String RuleCode,@PathVariable String ChargeAmount) throws IOException{
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
        List<Membercard> membercardList = _memberCardService.getByCinemaCodeAndOpenID(CinemaCode, OpenID);
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
        if(RuleCode==null||RuleCode==""){
        	prePayParametersReply.SetCardChargeTypeInvalidReply();
			return prePayParametersReply;
		}
		Choosemembercardcreditrule choosemembercardcreditrule = _choosemembercardcreditruleService.getByRuleCode(CinemaCode, LevelCode ,RuleCode);
		if(choosemembercardcreditrule==null){
			prePayParametersReply.SetCardChargeTypeInvalidReply();
			return prePayParametersReply;
		}
		if(choosemembercardcreditrule.getRuleCode()==null){
			prePayParametersReply.SetCardChargeTypeInvalidReply();
			return prePayParametersReply;
		}
		Membercardcreditrule membercardcreditrule = _membercardcreditruleService.getByRuleCode(choosemembercardcreditrule.getRuleCode());
		if(membercardcreditrule==null){
			prePayParametersReply.SetCardChargeTypeInvalidReply();
			return prePayParametersReply;
		}
		if(membercardcreditrule.getRuleCode()==null){
			prePayParametersReply.SetCardChargeTypeInvalidReply();
			return prePayParametersReply;
		}
		ChargeAmount = String.valueOf(membercardcreditrule.getCredit()+membercardcreditrule.getGivenAmount());
        
        //准备参数
        Calendar cal=Calendar.getInstance();
        String WxpayAppId = cinemapaymentsettings.getWxpayAppId();
        String strbody = cinemapaymentsettings.getCinemaName() + "-" + StringUtil.leftPad(String.valueOf(cal.get(Calendar.MONTH)+1), 2, "0")
                + "月" + StringUtil.leftPad(String.valueOf(cal.get(Calendar.DATE)), 2, "0") + "日" + new SimpleDateFormat("HH:mm").format(new Date()) + " "
                + " 会员卡充值（" + ChargeAmount + " 元）";
        String WxpayMchId = cinemapaymentsettings.getWxpayMchId();
        String WxpayKey = cinemapaymentsettings.getWxpayKey();
        String notify_url = "https://xc.80piao.com:8443/Api/Member/WxPayNotify";//https://xc.80piao.com:8443/Api/Member/WxPayNotify
        String out_trade_no = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + CinemaCode + (int)((Math.random()*9+1)*100000);//随机的六位数字
        String time_expire =new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(new Date() .getTime() + 900000));
        Double totalPrice = Double.valueOf(ChargeAmount);
        String total_fee = String.valueOf(Double.valueOf(totalPrice*100).intValue());//以分为单位
        return WxPayUtil.WxPayPrePay(request,prePayParametersReply, WxpayAppId, WxpayMchId, WxpayKey, strbody, notify_url, OpenID, out_trade_no, time_expire, total_fee);
	}
	//endregion
	
	//region 预支付会员卡注册(准备支付参数)
	@GetMapping("/PrePayCardRegister/{Username}/{Password}/{CinemaCode}/{OpenID}/{LevelCode}/{RuleCode}/{InitialAmount}")
	@ApiOperation(value = "预支付会员卡注册(准备支付参数)")
	public PrePayParametersReply PrePayCardRegister(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OpenID,@PathVariable String LevelCode,@PathVariable String RuleCode,@PathVariable String InitialAmount) throws IOException{
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
        if(RuleCode==null||RuleCode==""){
        	prePayParametersReply.SetCardChargeTypeInvalidReply();
			return prePayParametersReply;
		}
		Choosemembercardcreditrule choosemembercardcreditrule = _choosemembercardcreditruleService.getByRuleCode(CinemaCode, LevelCode, RuleCode);
		if(choosemembercardcreditrule==null){
			prePayParametersReply.SetCardChargeTypeInvalidReply();
			return prePayParametersReply;
		}
		if(choosemembercardcreditrule.getRuleCode()==null){
			prePayParametersReply.SetCardChargeTypeInvalidReply();
			return prePayParametersReply;
		}
		Membercardcreditrule membercardcreditrule = _membercardcreditruleService.getByRuleCode(choosemembercardcreditrule.getRuleCode());
		if(membercardcreditrule==null){
			prePayParametersReply.SetCardChargeTypeInvalidReply();
			return prePayParametersReply;
		}
		if(membercardcreditrule.getRuleCode()==null){
			prePayParametersReply.SetCardChargeTypeInvalidReply();
			return prePayParametersReply;
		}
		InitialAmount = String.valueOf(membercardcreditrule.getCredit()+membercardcreditrule.getGivenAmount());
        
        //准备参数
        Calendar cal=Calendar.getInstance();
        String WxpayAppId = cinemapaymentsettings.getWxpayAppId();
        String strbody = cinemapaymentsettings.getCinemaName() + "-" + StringUtil.leftPad(String.valueOf(cal.get(Calendar.MONTH)+1), 2, "0")
        + "月" + StringUtil.leftPad(String.valueOf(cal.get(Calendar.DATE)), 2, "0") + "日" + new SimpleDateFormat("HH:mm").format(new Date()) + " "
        + " 会员卡注册初始金额（" + InitialAmount + " 元）";
        String WxpayMchId = cinemapaymentsettings.getWxpayMchId();
        String WxpayKey = cinemapaymentsettings.getWxpayKey();
        String notify_url = "https://xc.80piao.com:8443/Api/Member/WxPayNotify";
        String out_trade_no = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + CinemaCode + (int)((Math.random()*9+1)*100000);//随机的六位数字
        String time_expire =new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(new Date() .getTime() + 900000));
        Double totalPrice = Double.valueOf(InitialAmount);
        String total_fee = String.valueOf(Double.valueOf(totalPrice*100).intValue());//以分为单位
        return WxPayUtil.WxPayPrePay(request,prePayParametersReply, WxpayAppId, WxpayMchId, WxpayKey, strbody, notify_url, OpenID, out_trade_no, time_expire, total_fee);
	}
	//endregion
	
	//region 查询用户已绑定的会员卡信息(本地已绑定)
	@GetMapping("/QueryMemberCardByOpenID/{Username}/{Password}/{CinemaCode}/{OpenID}")
	@ApiOperation(value = "查询用户已绑定的会员卡信息(本地已绑定)")
	public QueryMemberCardByOpenIDReply QueryMemberCardByOpenID(@PathVariable String Username,@PathVariable String Password,
			@PathVariable String CinemaCode,@PathVariable String OpenID){
		QueryMemberCardByOpenIDReply queryMemberCardByOpenIDReply = new QueryMemberCardByOpenIDReply();
		//校验参数
		if (!ReplyExtension.RequestInfoGuard(queryMemberCardByOpenIDReply, Username, Password, CinemaCode, OpenID))
        {
            return queryMemberCardByOpenIDReply;
        }
		//获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
        	queryMemberCardByOpenIDReply.SetUserCredentialInvalidReply();
            return queryMemberCardByOpenIDReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	queryMemberCardByOpenIDReply.SetCinemaInvalidReply();
            return queryMemberCardByOpenIDReply;
        }
        List<Membercard> memberCardList = _memberCardService.getByCinemaCodeAndOpenID(CinemaCode, OpenID);
        QueryMemberCardByOpenIDReplyOpenIDCard data = new QueryMemberCardByOpenIDReplyOpenIDCard();
        data.setCinemaCode(CinemaCode);
        data.setMemberPhoneCount(memberCardList.size());
        if(memberCardList.size()>0){
        	List<QueryMemberCardByOpenIDReplyOpenIDMemberCard> cardReplyList = new ArrayList<>();
        	for(Membercard memberCard: memberCardList){
        		QueryMemberCardByOpenIDReplyOpenIDMemberCard cardReply = new QueryMemberCardByOpenIDReplyOpenIDMemberCard();
        		cardReply.setBalance(memberCard.getBalance());
        		if(memberCard.getBirthday()!=null){
        			cardReply.setBirthday(new SimpleDateFormat("yyyy-MM-dd").format(memberCard.getBirthday()));
        		}
        		cardReply.setCardNo(memberCard.getCardNo());
        		cardReply.setCardPassword(memberCard.getCardPassword());
        		cardReply.setCreditNum(memberCard.getCreditNum());
        		if(memberCard.getExpireDate()!=null){
        			cardReply.setExpireDate(new SimpleDateFormat("yyyy-MM-dd").format(memberCard.getExpireDate()));
        		}
        		cardReply.setLevelCode(memberCard.getLevelCode());
        		cardReply.setLevelName(memberCard.getLevelName());
        		//查询会员卡类别图片
        		Membercardlevel membercardlevel = _memberCardLevelService.getByCinemaCodeAndLevelCode(CinemaCode, memberCard.getLevelCode());
        		if(membercardlevel!=null){
        			cardReply.setCardPictureUrl(membercardlevel.getPictureUrl());
        		}
        		cardReply.setMobilePhone(memberCard.getMobilePhone());
        		cardReply.setOpenID(memberCard.getOpenId());
        		cardReply.setScore(memberCard.getScore());
        		cardReply.setSex(memberCard.getSex());
        		if(memberCard.getStatus()!=null){
        			cardReply.setStatus(String.valueOf(memberCard.getStatus()));
        		}
        		cardReply.setUserName(memberCard.getUserName());
        		cardReplyList.add(cardReply);
        	}
        	data.setMemberCard(cardReplyList);
        }
        queryMemberCardByOpenIDReply.setData(data);
        queryMemberCardByOpenIDReply.SetSuccessReply();
		return queryMemberCardByOpenIDReply;
	}
	//endregion
	
	//region 本地已启用会员卡类别及开卡规则
	@GetMapping("/QueryMemberCardLevel/{Username}/{Password}/{CinemaCode}")
	@ApiOperation(value = "本地已启用会员卡类别及开卡规则")
	public QueryMemberCardLevelReply QueryMemberCardLevel(@PathVariable String Username,@PathVariable String Password,
			@PathVariable String CinemaCode){
		QueryMemberCardLevelReply queryMemberCardLevelReply = new QueryMemberCardLevelReply();
		//校验参数
		if (!ReplyExtension.RequestInfoGuard(queryMemberCardLevelReply, Username, Password, CinemaCode))
        {
            return queryMemberCardLevelReply;
        }
		//获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
        	queryMemberCardLevelReply.SetUserCredentialInvalidReply();
            return queryMemberCardLevelReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	queryMemberCardLevelReply.SetCinemaInvalidReply();
            return queryMemberCardLevelReply;
        }
        List<Membercardlevel> membercardlevelList = _memberCardLevelService.getCanUseByCinemaCode(CinemaCode);
        QueryMemberCardLevelReplyMemberCard data = new QueryMemberCardLevelReplyMemberCard();
        List<QueryMemberCardLevelReplyMemberCardLevel> levelReplyList = new ArrayList<QueryMemberCardLevelReplyMemberCardLevel>();
         if(membercardlevelList.size()>0){
	        data.setCinemaCode(CinemaCode);
	        for(Membercardlevel membercardlevel: membercardlevelList){
	        	QueryMemberCardLevelReplyMemberCardLevel levelReply = new QueryMemberCardLevelReplyMemberCardLevel();
	        	levelReply.setLevelCode(membercardlevel.getLevelCode());
	        	levelReply.setLevelName(membercardlevel.getLevelName());
	        	levelReply.setCardCostFee(membercardlevel.getCardCostFee());
	        	levelReply.setMemberFee(membercardlevel.getMemberFee());
	        	levelReply.setMemberCardImage(membercardlevel.getPictureUrl());
	        	levelReply.setIsOnlineOpenCard(membercardlevel.getIsOnlineOpenCard());
	        	levelReply.setStatus(membercardlevel.getStatus());
	        	//会员卡类别规则
	        	Choosemembercardcreditrule choosemembercardcreditrule =  _choosemembercardcreditruleService.getOpenTypeByLevelCode(CinemaCode, membercardlevel.getLevelCode());
	        	if(choosemembercardcreditrule!=null&&choosemembercardcreditrule.getRuleCode()!=null&&choosemembercardcreditrule.getRuleCode()!=""){
	        		Membercardcreditrule membercardcreditrule = _membercardcreditruleService.getByRuleCode(choosemembercardcreditrule.getRuleCode());
	        		if(membercardcreditrule!=null){
	        			levelReply.setCredit(membercardcreditrule.getCredit());
	        			levelReply.setRuleCode(membercardcreditrule.getRuleCode());
	        			levelReply.setRuleName(membercardcreditrule.getRuleName());
	        			levelReply.setOfferDescription(membercardcreditrule.getOfferDescription());
	        			levelReply.setRuleDescription(membercardcreditrule.getRuleDescription());
	        			levelReply.setRuleType(membercardcreditrule.getRuleType());
	        		}
	        	}
	        	levelReplyList.add(levelReply);
	       }
	       data.setLevel(levelReplyList);
        }
        queryMemberCardLevelReply.setData(data);
        queryMemberCardLevelReply.SetSuccessReply();
		return queryMemberCardLevelReply;
	}
	//endregion
	
	//region 会员卡类别充值规则
	@GetMapping("/QueryMemberCardLevelRule/{Username}/{Password}/{CinemaCode}/{LevelCode}")
	@ApiOperation(value = "会员卡类别充值规则")
	public QueryMemberCardLevelRuleReply QueryMemberCardLevelRule(@PathVariable String Username,@PathVariable String Password,
			@PathVariable String CinemaCode,@PathVariable String LevelCode){
		QueryMemberCardLevelRuleReply queryMemberCardLevelRuleReply = new QueryMemberCardLevelRuleReply();
		//校验参数
		if (!ReplyExtension.RequestInfoGuard(queryMemberCardLevelRuleReply, Username, Password, CinemaCode, LevelCode))
        {
            return queryMemberCardLevelRuleReply;
        }
		//获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
        	queryMemberCardLevelRuleReply.SetUserCredentialInvalidReply();
            return queryMemberCardLevelRuleReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	queryMemberCardLevelRuleReply.SetCinemaInvalidReply();
            return queryMemberCardLevelRuleReply;
        }
        //验证会员卡类别是否存在且可用
        Membercardlevel membercardlevel = _memberCardLevelService.getByCinemaCodeAndLevelCode(CinemaCode, LevelCode);
        if(membercardlevel==null){
        	queryMemberCardLevelRuleReply.SetCardLevelInvalidReply();
        	return queryMemberCardLevelRuleReply;
        }else{
        	if(membercardlevel.getStatus()!=1){
        		queryMemberCardLevelRuleReply.SetCardLevelInvalidReply();
            	return queryMemberCardLevelRuleReply;
        	}
        }
    	List<Choosemembercardcreditrule> choosemembercardcreditruleList =  _choosemembercardcreditruleService.getRechargeTypeListByLevelCode(CinemaCode, membercardlevel.getLevelCode());
    	QueryMemberCardLevelRuleReplyMemberCard data = new QueryMemberCardLevelRuleReplyMemberCard();
    	data.setCinemaCode(CinemaCode);
    	data.setLevelCode(LevelCode);
    	data.setLevelName(membercardlevel.getLevelName());
    	List<QueryMemberCardLevelRuleReplyMemberCardRule> ruleReplyList = new ArrayList<QueryMemberCardLevelRuleReplyMemberCardRule>();
    	if(choosemembercardcreditruleList.size()>0){
			for(Choosemembercardcreditrule choosemembercardcreditrule : choosemembercardcreditruleList){
				Membercardcreditrule membercardcreditrule = _membercardcreditruleService.getByRuleCode(choosemembercardcreditrule.getRuleCode());
				QueryMemberCardLevelRuleReplyMemberCardRule ruleReply = new QueryMemberCardLevelRuleReplyMemberCardRule();
				ruleReply.setRuleCode(membercardcreditrule.getRuleCode());
				ruleReply.setRuleType(membercardcreditrule.getRuleType());
				ruleReply.setCredit(membercardcreditrule.getCredit());
				ruleReply.setGivenAmount(membercardcreditrule.getGivenAmount());
				ruleReplyList.add(ruleReply);
			}
			data.setRule(ruleReplyList);
		}
    	queryMemberCardLevelRuleReply.setData(data);
    	queryMemberCardLevelRuleReply.SetSuccessReply();
    	return queryMemberCardLevelRuleReply;
	}
	//endregion
	
	//region 会员卡解绑
	@GetMapping("/MemberCardUnbind/{Username}/{Password}/{CinemaCode}/{CardNo}/{CardPassword}")
	@ApiOperation(value = "会员卡解绑")
	public MemberCardUnbindReply QueryMemberCardLevelRule(@PathVariable String Username,@PathVariable String Password,
			@PathVariable String CinemaCode,@PathVariable String CardNo,@PathVariable String CardPassword){
		MemberCardUnbindReply memberCardUnbindReply = new MemberCardUnbindReply();
		//校验参数
		if (!ReplyExtension.RequestInfoGuard(memberCardUnbindReply, Username, Password, CinemaCode, CardNo, CardPassword))
        {
            return memberCardUnbindReply;
        }
		//获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
        	memberCardUnbindReply.SetUserCredentialInvalidReply();
            return memberCardUnbindReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	memberCardUnbindReply.SetCinemaInvalidReply();
            return memberCardUnbindReply;
        }
        //验证会员卡是否存在
        Membercard membercard = _memberCardService.checkMemberCard(CinemaCode, CardNo, CardPassword);
        if(membercard == null){
        	memberCardUnbindReply.SetMemberCardInvalidReply();
        	return memberCardUnbindReply;
        }
        if(_memberCardService.memberCardUnbind(membercard.getCinemaCode(), membercard.getCardNo())<=0){
        	memberCardUnbindReply.SetMemberCardInvalidReply();
        	return memberCardUnbindReply;
        }
        memberCardUnbindReply.SetSuccessReply();
    	return memberCardUnbindReply;
	}
	//endregion
	
	//region 异步接收微信支付返回(会员卡注册充值不需要更新订单表，可以为空)
	public void WxPayNotify() throws Exception{
		
	}
	//endregion
	
	//region
	public static void main(String[] args) {
		System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "12345678" + (int)((Math.random()*9+1)*100000));
	}
	//endregion
}
