package com.boot.security.server.apicontroller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

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
import com.boot.security.server.api.ctms.reply.CTMSQueryDiscountReply;
import com.boot.security.server.api.ctms.reply.CTMSSubmitGoodsOrderReply;
import com.boot.security.server.api.ctms.reply.CTMSSubmitOrderReply;
import com.boot.security.server.api.ctms.reply.Dy1905GetMemberCardByMobileReply;
import com.boot.security.server.api.ctms.reply.Dy1905Interface;
import com.boot.security.server.api.ctms.reply.MtxInterface;
import com.boot.security.server.api.ctms.reply.YkInterface;
import com.boot.security.server.apicontroller.reply.CardChargeRecordReply;
import com.boot.security.server.apicontroller.reply.CardChargeRecordReply.ChargeRecord;
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
import com.boot.security.server.model.Cinemamessage;
import com.boot.security.server.model.Cinemapaymentsettings;
import com.boot.security.server.model.Cinemaview;
import com.boot.security.server.model.CouponsStatusEnum;
import com.boot.security.server.model.CouponsView;
import com.boot.security.server.model.GoodsOrderStatusEnum;
import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.model.Membercardcreditrule;
import com.boot.security.server.model.Membercardlevel;
import com.boot.security.server.model.Membercardrecharge;
import com.boot.security.server.model.OrderPayTypeEnum;
import com.boot.security.server.model.OrderStatusEnum;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Priceplan;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.StatusEnum;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.ChoosemembercardcreditruleServiceImpl;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.CinemamessageServiceImpl;
import com.boot.security.server.service.impl.CinemapaymentsettingsServiceImpl;
import com.boot.security.server.service.impl.CinemaviewServiceImpl;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.GoodsOrderServiceImpl;
import com.boot.security.server.service.impl.MemberCardLevelServiceImpl;
import com.boot.security.server.service.impl.MemberCardServiceImpl;
import com.boot.security.server.service.impl.MembercardcreditruleServiceImpl;
import com.boot.security.server.service.impl.MembercardrechargeServiceImpl;
import com.boot.security.server.service.impl.OrderServiceImpl;
import com.boot.security.server.service.impl.OrderseatdetailsServiceImpl;
import com.boot.security.server.service.impl.PriceplanServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.service.impl.TicketusersServiceImpl;
import com.boot.security.server.service.impl.UserCinemaViewServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.boot.security.server.utils.DoubleUtil;
import com.boot.security.server.utils.GoodsCouponsPriceUtil;
import com.boot.security.server.utils.SendMobileMessage;
import com.boot.security.server.utils.WxPayUtil;
import com.boot.security.server.utils.XmlHelper;
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
	private CinemaviewServiceImpl cinemaviewService;
	@Autowired 
	private MemberCardServiceImpl _memberCardService;
	@Autowired
	private UserCinemaViewServiceImpl _userCinemaViewService;
	@Autowired
	private CinemapaymentsettingsServiceImpl _cinemapaymentsettingsService;
	@Autowired
	private TicketusersServiceImpl _ticketusersService;
	@Autowired
    private HttpServletRequest request;
	@Autowired
	private MemberCardLevelServiceImpl _memberCardLevelService;
	@Autowired
	private ChoosemembercardcreditruleServiceImpl _choosemembercardcreditruleService;
	@Autowired
	private MembercardcreditruleServiceImpl _membercardcreditruleService;
	@Autowired
	private MembercardrechargeServiceImpl membercardrechargeService;
	@Autowired
	private OrderServiceImpl orderService;
	@Autowired
	private GoodsOrderServiceImpl goodsOrderService;
	@Autowired
	private CouponsServiceImpl _couponsService;
	@Autowired
	private SessioninfoServiceImpl _sessioninfoService;
	@Autowired
	PriceplanServiceImpl _priceplanService;
	@Autowired
	ScreeninfoServiceImpl _screeninfoService;
	@Autowired
	private OrderseatdetailsServiceImpl _orderseatdetailsService;
	@Autowired
	private CinemamessageServiceImpl cinemamessageService;
	
	protected static Logger log = LoggerFactory.getLogger(MemberController.class);
	
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
		return reply;
	}
	//endregion
	
	//region 会员卡支付
	@GetMapping("/CardPay/{Username}/{Password}/{CinemaCode}/{LockOrderCode}/{LocalOrderCode}/{CardNo}/{CardPassword}/{PayAmount}/{GoodsPayAmount}/{SessionCode}/{FilmCode}/{TicketNum}/{CouponsCode}/{CouponsCode2}")
	@ApiOperation(value = "会员卡支付")
	public CardPayReply CardPay(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String LockOrderCode,@PathVariable String LocalOrderCode,@PathVariable String CardNo,@PathVariable String CardPassword,
			@PathVariable String PayAmount,@PathVariable String GoodsPayAmount,@PathVariable String SessionCode,
			@PathVariable String FilmCode,@PathVariable String TicketNum,@PathVariable String CouponsCode,@PathVariable String CouponsCode2){
		OrderView order = orderService.getOrderWidthLockOrderCode(CinemaCode, LockOrderCode);
		GoodsOrderView goodsOrder = goodsOrderService.getWithLocalOrderCode(CinemaCode,LocalOrderCode);
		Usercinemaview userCinema = _userCinemaViewService.getByCinemaCode(CinemaCode);
		Double realPayAmount=0D;
		Double realGoodsPayAmount=0D;
		
		//region 更新订单主表价格
		if(order!=null&&order.getOrderBaseInfo()!=null){
			Membercard membercard=_memberCardService.getByCardNo(CinemaCode,CardNo);
			Sessioninfo session=_sessioninfoService.getBySessionCode(order.getOrderBaseInfo().getUserId(), CinemaCode, SessionCode);
			Screeninfo screeninfo=_screeninfoService.getByScreenCode(CinemaCode,order.getOrderBaseInfo().getScreenCode());
			List<Priceplan> priceplans=_priceplanService.getByCode(order.getOrderBaseInfo().getUserId(), CinemaCode, FilmCode, SessionCode);
			Double priceplanMemberPrice;//价格计划里的会员价
			if(priceplans.size()>0){
				// 得到价格计划
				Priceplan priceplan = new Priceplan();
				if (priceplans.size() > 1) {
					priceplan = priceplans.stream().filter((Priceplan s) -> s.getType() == 1).collect(Collectors.toList())
							.get(0);
				} else if (priceplans.size() == 1) {
					priceplan = priceplans.get(0);
				}
				priceplanMemberPrice = null == priceplan.getMemberPrice() ? session.getStandardPrice() : priceplan.getMemberPrice();
			}else{
				priceplanMemberPrice=session.getStandardPrice();
			}
			//计算优惠价格
			order.setOrderBaseInfo(_couponsService.updateCouponsPricetoOrder(order.getOrderBaseInfo(), CouponsCode));
			//重新读取折扣价，重新计算价格
			String listingPrice = "0.00";
			String lowestPrice = "0.00";
			if(session.getListingPrice()!=null){
				listingPrice = new DecimalFormat("0.00").format(session.getListingPrice());
			}
			if(session.getLowestPrice()!=null){
				lowestPrice = new DecimalFormat("0.00").format(session.getLowestPrice());
			}
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			QueryDiscountReply discountReply=new NetSaleSvcCore().QueryDiscount(Username,Password,CinemaCode,TicketNum,CardNo, CardPassword,membercard.getLevelCode(),SessionCode,sf.format(session.getStartTime()),FilmCode,screeninfo.getType(),listingPrice,lowestPrice);
			if(discountReply.getCard().getPrice()>0){
				for(Orderseatdetails seat:order.getOrderSeatDetails()){
					//重新计算每个座位的销售价格
					seat.setSalePrice(DoubleUtil.sub(DoubleUtil.add(DoubleUtil.add(discountReply.getCard().getPrice(),seat.getFee()), seat.getAddFee()), seat.getCinemaAllowance()));
				}
				Double TotalSalePrice=order.getOrderSeatDetails().stream().mapToDouble(Orderseatdetails::getSalePrice).sum();
				//更新订单的总实际销售价格=新的实际销售价格-优惠价格
				order.getOrderBaseInfo().setTotalSalePrice(TotalSalePrice-order.getOrderBaseInfo().getCouponsPrice());
			}else{
				for(Orderseatdetails seat:order.getOrderSeatDetails()){
					//重新计算每个座位的销售价格
					seat.setSalePrice(DoubleUtil.sub(DoubleUtil.add(DoubleUtil.add(priceplanMemberPrice, seat.getFee()), seat.getAddFee()),seat.getCinemaAllowance()));
				}
				Double TotalSalePrice=order.getOrderSeatDetails().stream().mapToDouble(Orderseatdetails::getSalePrice).sum();
				//更新主表的实际销售价格-优惠券价格
				order.getOrderBaseInfo().setTotalSalePrice(DoubleUtil.sub(TotalSalePrice, order.getOrderBaseInfo().getCouponsPrice()));
			}
			//更新订单
			orderService.Update(order);
			realPayAmount=order.getOrderBaseInfo().getTotalSalePrice();
		}
		//endregion
		
		//region 更新卖品订单价格
		if(goodsOrder!=null&&goodsOrder.getOrderBaseInfo()!=null){
			//计算优惠价格
			goodsOrder.setOrderBaseInfo(_couponsService.updateCouponsPricetoGoodsOrder(goodsOrder.getOrderBaseInfo(),CouponsCode2));
			//更新订单
			goodsOrderService.UpdateOrderBaseInfo(goodsOrder.getOrderBaseInfo());
			realGoodsPayAmount=goodsOrder.getOrderBaseInfo().getTotalSettlePrice();
		}
		//endregion
		
		CardPayReply reply;
		if(userCinema.getCinemaType() == CinemaTypeEnum.ManTianXing.getTypeCode() && 
				goodsOrder != null && goodsOrder.getOrderBaseInfo() != null){	//满天星卖品会员支付
			reply = new MtxInterface().sPPay(userCinema, CardNo, CardPassword, String.valueOf(realGoodsPayAmount));
		} else {
			reply = new NetSaleSvcCore().CardPay(Username, Password, CinemaCode, CardNo, CardPassword,String.valueOf(realPayAmount),String.valueOf(realGoodsPayAmount), SessionCode, FilmCode, TicketNum);
		}
        //region 更新订单支付状态
		if(order!=null&&order.getOrderBaseInfo()!=null){
			if(reply.Status.equals("Success")){
				//更新订单
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Payed.getStatusCode());
				order.getOrderBaseInfo().setIsMemberPay(1);
				if (userCinema.getCinemaType() == CinemaTypeEnum.ManTianXing.getTypeCode()) {
					order.getOrderBaseInfo().setPayType(userCinema.getPayType().split(",")[0]);
					order.getOrderBaseInfo().setPaySeqNo(reply.getTradeNo());
				}
				order.getOrderBaseInfo().setPayFlag(1);
				order.getOrderBaseInfo().setPayTime(new Date());
				order.getOrderBaseInfo().setOrderTradeNo(reply.getTradeNo());
				order.getOrderBaseInfo().setCardNo(CardNo);
				order.getOrderBaseInfo().setCardPassword(CardPassword);
				order.getOrderBaseInfo().setOrderPayType(OrderPayTypeEnum.MemberCardPay.getTypeCode());
				order.getOrderBaseInfo().setUpdated(new Date());
				//更新优惠券已使用
				if (order.getOrderBaseInfo().getCouponsCode()!=null && !"".equals(order.getOrderBaseInfo().getCouponsCode())) {
					CouponsView couponsview=_couponsService.getWithCouponsCode(order.getOrderBaseInfo().getCouponsCode());
					if(couponsview!=null){
						couponsview.getCoupons().setStatus(CouponsStatusEnum.Used.getStatusCode());
						couponsview.getCoupons().setUsedDate(new Date());
						//使用数量+1
						couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()+1);
						couponsview.getCouponsgroup().setRemainingNumber(couponsview.getCouponsgroup().getRemainingNumber()-1);
						couponsview.getCouponsgroup().setOperationRemark("会员卡支付操作+1");
						couponsview.getCouponsgroup().setUpdateDate(new Date());
						//更新优惠券及优惠券分组表
						_couponsService.update(couponsview);
					}
				}
			}else{
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.PayFail.getStatusCode());
			}
			orderService.update(order.getOrderBaseInfo());
		}
		//endregion
		
		//region 更新卖品订单支付状态
		if(goodsOrder!=null&&goodsOrder.getOrderBaseInfo()!=null){
			if(reply.Status.equals("Success")){
				//更新卖品订单
				goodsOrder.getOrderBaseInfo().setCardNo(CardNo);
				goodsOrder.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Payed.getStatusCode());
				goodsOrder.getOrderBaseInfo().setOrderPayFlag(1);
				if (userCinema.getCinemaType() == CinemaTypeEnum.ManTianXing.getTypeCode()) {
					goodsOrder.getOrderBaseInfo().setPayType(userCinema.getPayType().split(",")[0]);
					goodsOrder.getOrderBaseInfo().setPaySeqNo(reply.getTradeNo());
				}
				goodsOrder.getOrderBaseInfo().setOrderPayTime(new Date());
				goodsOrder.getOrderBaseInfo().setOrderTradeNo(reply.getTradeNo());
				goodsOrder.getOrderBaseInfo().setOrderPayType(OrderPayTypeEnum.MemberCardPay.getTypeCode());
				goodsOrder.getOrderBaseInfo().setUpdated(new Date());
				// 更新优惠券已使用
				if (goodsOrder.getOrderBaseInfo().getCouponsCode() != null && !"".equals(goodsOrder.getOrderBaseInfo().getCouponsCode())) {
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
	@GetMapping("/SellTicketCustomMember/{Username}/{Password}/{CinemaCode}/{LockOrderCode}/{MobilePhone}/{CardNo}/{CardPassword}/{CouponsCode}")
	@ApiOperation(value = "会员卡购票（1905）")
	public SellTicketCustomMemberReply SellTicketCustomMember(@PathVariable String Username,@PathVariable String Password,
			@PathVariable String CinemaCode,@PathVariable String LockOrderCode,@PathVariable String MobilePhone,
			@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String CouponsCode) throws Exception{
		Usercinemaview userCinema = _userCinemaViewService.getByCinemaCode(CinemaCode);
		Orders order = orderService.getByLockOrderCode(CinemaCode, LockOrderCode);
		//查询会员卡折扣
		CTMSQueryDiscountReply queryDiscountReply = new Dy1905Interface().QueryDiscount(userCinema, null, CardNo, CardPassword, null, order.getSessionCode(), null, null, null, null, null);
		System.out.println("会员价="+queryDiscountReply.getPrice());
		//更新实际总价格
		if(queryDiscountReply.Status==StatusEnum.Success){
			order.setTotalSalePrice(Double.valueOf(queryDiscountReply.getPrice()*order.getTicketCount()));
			orderService.update(order);
		}
		Orders orders = orderService.getByLockOrderCode(CinemaCode, LockOrderCode);
		//region 更新购票订单优惠券及金额
		orders=_couponsService.updateCouponsPricetoOrder(orders, CouponsCode);
		orderService.update(orders);
		if(orders!=null){
			//更新订单详情中的售价
			//先把会员价更新进去
			List<Orderseatdetails> orderseatdetailsList1 = _orderseatdetailsService.getByOrderId(order.getId());
			for(Orderseatdetails orderseatdetails : orderseatdetailsList1){
				orderseatdetails.setSalePrice(Double.valueOf(queryDiscountReply.getPrice()));
				_orderseatdetailsService.update(orderseatdetails);
			}
			//判断是否存在优惠价格
			List<Orderseatdetails> orderseatdetailsList = new ArrayList<>();
			//获取订单详细
			orderseatdetailsList = _orderseatdetailsService.getByOrderId(orders.getId());
			if(orders.getCouponsPrice()!=null){
				//拆分优惠金额
				//多张票处理
				if(orderseatdetailsList.size()>1){
					//得到总价格
					Double TotalSalePrice = orderseatdetailsList.stream().collect(Collectors.summingDouble(Orderseatdetails::getSalePrice));
					//处理除最后一个价格外的价格
					Double couponsPrice = 0.00;
					String dealPrice = null;
					for(int i=0; i<orderseatdetailsList.size(); i++){
						if(i<orderseatdetailsList.size()-1){
							//先初始化要拆分的价格
							dealPrice= new DecimalFormat("0.00").format(orderseatdetailsList.get(i).getSalePrice()/TotalSalePrice*orders.getCouponsPrice());
							orderseatdetailsList.get(i).setCouponPrice(Double.parseDouble(dealPrice));
							orderseatdetailsList.get(i).setSalePrice(orderseatdetailsList.get(i).getSalePrice()-orderseatdetailsList.get(i).getCouponPrice());
							//得到拆分完的总价格
							couponsPrice +=Double.parseDouble(dealPrice);
							//格式化拆分后的价格
							new DecimalFormat("0.00").format(orderseatdetailsList.get(i).getCouponPrice());
						}else{
							//处理最后一个价格
							orderseatdetailsList.get(i).setCouponPrice(orders.getCouponsPrice()-couponsPrice);
							//处理实际销售价格
							orderseatdetailsList.get(i).setSalePrice(orderseatdetailsList.get(i).getSalePrice()-orderseatdetailsList.get(i).getCouponPrice());
						}
						//更新到订单详情
						_orderseatdetailsService.update(orderseatdetailsList.get(i));
					}
				}
				//一张票处理
				if(orderseatdetailsList.size()==1){
					//处理优惠金额
					orderseatdetailsList.get(0).setCouponPrice(orders.getCouponsPrice());
					//处理实际销售价格
					orderseatdetailsList.get(0).setSalePrice(orderseatdetailsList.get(0).getSalePrice()-orderseatdetailsList.get(0).getCouponPrice());
					//更新到订单详情
					_orderseatdetailsService.update(orderseatdetailsList.get(0));
				}
			}
			System.out.println("orders="+orders.getTotalSalePrice());
			System.out.println("orderseatdetailsList="+orderseatdetailsList.get(0).getSalePrice());
		}
		//endregion
		SellTicketCustomMemberReply reply = new Dy1905Interface().SellTicketCustomMember(Username, Password, CinemaCode, LockOrderCode, CardNo, CardPassword);
		System.out.println(new Gson().toJson(reply));
		if(reply.Status.equals("Success")){
			Orders orders2 = orderService.getByLockOrderCode(CinemaCode, LockOrderCode);
			if(orders2!=null){
				orders2.setMobilePhone(MobilePhone);
				orderService.update(orders2);
			}
			try{	//提交成功，短信发送失败
				Orders orders3 = orderService.getByOrderCode(reply.getOrderNo());
				Screeninfo screeninfo= _screeninfoService.getByScreenCode(orders3.getCinemaCode(),orders3.getScreenCode());
				Cinemamessage cinemamessage=cinemamessageService.getByMessageType("5");
				Cinema cinema = _cinemaService.getByCinemaCode(orders3.getCinemaCode());
				String batchNum=UUID.randomUUID().toString().replace("-","");

                // 将特定影院的取票码改为特定的格式
                Cinemaview cinemaview = cinemaviewService.getByCinemaCode(orders3.getCinemaCode());
                //辰星系统(取票码截取影院编码)
                String printNo = orders3.getPrintNo();
                if(cinemaview.getCinemaType() == CinemaTypeEnum.ChenXing.getTypeCode()){
	                if (printNo != null && printNo.length() > 8) {
	                	printNo = printNo.substring(8);
	                }
                } else if(cinemaview.getCinemaType() == CinemaTypeEnum.ChenXing.getTypeCode()){
                	if (printNo != null && printNo.length() > 8) {
                		printNo = printNo.substring(8);
                	}
                } else if(cinemaview.getCinemaType()==CinemaTypeEnum.DianYing1905.getTypeCode()){
                    printNo = orders3.getSubmitOrderCode();
                }
//				String smsContent=cinema.getSmsSignId() + cinemamessage.getMessageContent().replaceFirst("@FilmName", orders3.getFilmName()).replaceFirst("@ScreenName",screeninfo.getSName()).replaceFirst("@SessionTime",new SimpleDateFormat("yyyy-MM-dd HH:mm").format(orders3.getSessionTime()));
				String smsContent=cinema.getSmsSignId() + cinemamessage.getMessageContent().replaceFirst("@ticketCode", printNo).replaceFirst("@filmName", orders3.getFilmName()).replaceFirst("@ticketNumber", orders3.getTicketCount().toString()).replaceFirst("@cinemaHallName", screeninfo.getSName()).replaceFirst("@showTime", new SimpleDateFormat("MM-dd HH:mm").format(orders3.getSessionTime()));
				//String MsgConetnt="您已成功支付，订单金额"+orders.getTotalSalePrice()+"元，影片场次："+orders.getSessionTime()+" 《"+orders.getFilmName()+"》"+orders.getTicketCount()+"张。请至影城取票机领取，取票码："+orders.getPrintNo()+".热线：4008257789";
				//new SendSmsHelper().SendSms(orders.getCinemaCode(),orders.getMobilePhone(),smsContent);
				String result = SendMobileMessage.sendMessage(cinema.getSmsAccount(),cinema.getSmsPwd(), orders3.getMobilePhone(), smsContent, batchNum);
				System.out.println(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return reply;
	}
	//endregion
	
	//region 1905会员卡支付+卖品
	@GetMapping("/GoodsOrderMember/{Username}/{Password}/{CinemaCode}/{LocalOrderCode}/{MobilePhone}/{CardNo}/{CardPassword}/{CouponsCode}")
	@ApiOperation(value = "会员卡卖品（1905）")
	public GoodsOrderMemberReply GoodsOrderMember(@PathVariable String Username,@PathVariable String Password,
			@PathVariable String CinemaCode,@PathVariable String LocalOrderCode,@PathVariable String MobilePhone,
			@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String CouponsCode) throws Exception{
		Goodsorders goodsorders = goodsOrderService.getByLocalOrderCode(LocalOrderCode);
		//region 更新卖品订单优惠
		goodsorders=_couponsService.updateCouponsPricetoGoodsOrder(goodsorders,CouponsCode);
		goodsOrderService.UpdateOrderBaseInfo(goodsorders);
		//endregion
		
		GoodsOrderMemberReply reply =new Dy1905Interface().GoodsOrderMember(Username, Password, CinemaCode, LocalOrderCode, CardNo, CardPassword);
		if(reply.Status.equals("Success")){
			goodsorders = goodsOrderService.getByLocalOrderCode(LocalOrderCode);
			if(goodsorders!=null){
				goodsorders.setOrderPayFlag(1);
				goodsorders.setOrderPayType(OrderPayTypeEnum.MemberCardPay.getTypeCode());
				goodsorders.setOrderPayTime(new Date());
				goodsorders.setCardNo(CardNo);
				goodsorders.setMobilePhone(MobilePhone);
				goodsOrderService.update(goodsorders);
				try{
					Goodsorders goodsorders2 = goodsOrderService.getByOrderCode(reply.getOrderCode());
					Cinemamessage cinemamessage=cinemamessageService.getByMessageType("2");
					Cinema cinema = _cinemaService.getByCinemaCode(goodsorders2.getCinemaCode());
					String batchNum=UUID.randomUUID().toString().replace("-","");
					String smsContent=cinema.getSmsSignId() + cinemamessage.getMessageContent();
					//String MsgConetnt="您的订单已成功，取货码为"+reply.getOrder().getPickUpCode()+"，请到前台领取";
					//new SendSmsHelper().SendSms(goodsorders.getCinemaCode(),goodsorders.getMobilePhone(),smsContent);
					SendMobileMessage.sendMessage(cinema.getSmsAccount(),cinema.getSmsPwd(), goodsorders2.getMobilePhone(), smsContent, batchNum);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return reply;
	}
	//endregion
	
	//region 1905会员卡支付+购票+卖品
	@GetMapping("/MemberCardPay/{Username}/{Password}/{CinemaCode}/{LockOrderCode}/{LocalOrderCode}/{CardNo}/{CardPassword}/{CouponsCode}/{CouponsCode2}")
	@ApiOperation(value = "会员卡混合支付（1905）")
	public MemberCardPayReply MemberCardPay(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String LockOrderCode,@PathVariable String LocalOrderCode,@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String CouponsCode,@PathVariable String CouponsCode2) throws Exception{
		OrderView order = orderService.getOrderWidthLockOrderCode(CinemaCode, LockOrderCode);
		GoodsOrderView goodsOrder = goodsOrderService.getWithLocalOrderCode(CinemaCode,LocalOrderCode);
		if(order!=null&&order.getOrderBaseInfo()!=null){
			//region 更新购票订单优惠券及金额
			order.setOrderBaseInfo(_couponsService.updateCouponsPricetoOrder(order.getOrderBaseInfo(), CouponsCode));
			orderService.update(order.getOrderBaseInfo());
			//endregion
		}
		if(goodsOrder!=null&&goodsOrder.getOrderBaseInfo()!=null){
			//region 更新卖品订单优惠券及金额
			goodsOrder.setOrderBaseInfo(_couponsService.updateCouponsPricetoGoodsOrder(goodsOrder.getOrderBaseInfo(),CouponsCode));
			goodsOrderService.UpdateOrderBaseInfo(goodsOrder.getOrderBaseInfo());
			//endregion
		}
		return new Dy1905Interface().MemberCardPay(Username, Password, CinemaCode, LockOrderCode, LocalOrderCode, CardNo, CardPassword);
	}
	//endregion
	
	//region 会员卡购票（粤科）
	@GetMapping("/YkTicketmMember/{Username}/{Password}/{CinemaCode}/{LockOrderCode}/{MobilePhone}/{CardNo}/{CardPassword}/{CouponsCode}")
	@ApiOperation(value = "会员卡购票（粤科）")
	public SellTicketCustomMemberReply YkTicketmMember(@PathVariable String Username,@PathVariable String Password,	@PathVariable String CinemaCode,
			@PathVariable String LockOrderCode,@PathVariable String MobilePhone,@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String CouponsCode) throws Exception{
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
		if(order.getOrderBaseInfo() == null){
			reply.SetOrderNotExistReply();
			return reply;
		}
		//验证会员卡
		Membercard membercard = _memberCardService.getByCardNo(CinemaCode, CardNo);
		if(membercard == null){
			reply.SetMemberCardInvalidReply();
			return reply;
		}
		//region 更新购票订单优惠券及金额
		order.setOrderBaseInfo(_couponsService.updateCouponsPricetoOrder(order.getOrderBaseInfo(),CouponsCode));
		orderService.update(order.getOrderBaseInfo());
		//endregion
		
		order.getOrderBaseInfo().setMobilePhone(MobilePhone);
		order.getOrderBaseInfo().setCardNo(CardNo);
		order.getOrderBaseInfo().setCardPassword(CardPassword);
		CTMSSubmitOrderReply ykReply = new YkInterface().SubmitOrder(userCinema, order);
		if("Success".equals(ykReply.Status.getStatusCode())){
			// 更新订单信息
			order.getOrderBaseInfo().setPayTime(new Date());	//支付时间
			order.getOrderBaseInfo().setUpdated(new Date());	//添加更新时间
			order.getOrderBaseInfo().setPayFlag(1);
			orderService.Update(order);
			// 更新优惠券已使用
			if (order.getOrderBaseInfo().getCouponsCode() != null && !"".equals(order.getOrderBaseInfo().getCouponsCode())) {
				CouponsView couponsview=_couponsService.getWithCouponsCode(order.getOrderBaseInfo().getCouponsCode());
				if(couponsview!=null){
					couponsview.getCoupons().setStatus(CouponsStatusEnum.Used.getStatusCode());
					couponsview.getCoupons().setUsedDate(new Date());
					//使用数量+1
					couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()+1);
					//更新优惠券及优惠券分组表
					_couponsService.update(couponsview);
				}
			}
			
			try{	//提交成功，短信发送
				Screeninfo screeninfo = _screeninfoService.getByScreenCode(order.getOrderBaseInfo().getCinemaCode(),order.getOrderBaseInfo().getScreenCode());
				Cinemamessage cinemamessage = cinemamessageService.getByMessageType("5");
				Cinema cinema = _cinemaService.getByCinemaCode(order.getOrderBaseInfo().getCinemaCode());
				String batchNum=UUID.randomUUID().toString().replace("-","");
                // 将特定影院的取票码改为特定的格式
                Cinemaview cinemaview = cinemaviewService.getByCinemaCode(order.getOrderBaseInfo().getCinemaCode());
                //辰星系统(取票码截取影院编码)
                String printNo = order.getOrderBaseInfo().getPrintNo();
                if(cinemaview.getCinemaType() == CinemaTypeEnum.ChenXing.getTypeCode()){
                	if (printNo != null && printNo.length() > 8) {
                		printNo = printNo.substring(8);
                	}
                } else if(cinemaview.getCinemaType()==CinemaTypeEnum.DianYing1905.getTypeCode()){
                    printNo = order.getOrderBaseInfo().getSubmitOrderCode();
                }
//				String smsContent = cinema.getSmsSignId() + cinemamessage.getMessageContent().replaceFirst("@FilmName", order.getOrderBaseInfo().getFilmName()).replaceFirst("@ScreenName",screeninfo.getSName()).replaceFirst("@SessionTime",new SimpleDateFormat("yyyy-MM-dd HH:mm").format(order.getOrderBaseInfo().getSessionTime()));
                String smsContent=cinema.getSmsSignId() + cinemamessage.getMessageContent().replaceFirst("@ticketCode", printNo).replaceFirst("@filmName", order.getOrderBaseInfo().getFilmName()).replaceFirst("@ticketNumber", order.getOrderBaseInfo().getTicketCount().toString()).replaceFirst("@cinemaHallName", screeninfo.getSName()).replaceFirst("@showTime", new SimpleDateFormat("MM-dd HH:mm").format(order.getOrderBaseInfo().getSessionTime()));
                SendMobileMessage.sendMessage(cinema.getSmsAccount(),cinema.getSmsPwd(), order.getOrderBaseInfo().getMobilePhone(), smsContent, batchNum);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
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
	@GetMapping("/YkGoodsOrderMember/{Username}/{Password}/{CinemaCode}/{LocalOrderCode}/{MobilePhone}/{CardNo}/{CardPassword}/{CouponsCode}")
	@ApiOperation(value = "会员卡卖品（粤科）")
	public SubmitGoodsOrderReply YkGoodsOrderMember(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String LocalOrderCode,@PathVariable String MobilePhone,@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String CouponsCode) throws Exception{
		
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
		GoodsOrderView order =goodsOrderService.getWithLocalOrderCode(LocalOrderCode);
		new GoodsCouponsPriceUtil().getGoodsCouponsPrice(order);
		if(order.getOrderBaseInfo() == null){
			reply.SetOrderNotExistReply();
			return reply;
		}
		//验证会员卡
		Membercard membercard = _memberCardService.getByCardNo(CinemaCode, CardNo);
		if(membercard == null){
			reply.SetMemberCardInvalidReply();
			return reply;
		}
		
		//region 更新卖品订单优惠券及金额
		order.setOrderBaseInfo(_couponsService.updateCouponsPricetoGoodsOrder(order.getOrderBaseInfo(),CouponsCode));
		goodsOrderService.UpdateOrderBaseInfo(order.getOrderBaseInfo());
		//endregion
		
		order.getOrderBaseInfo().setMobilePhone(MobilePhone);
		order.getOrderBaseInfo().setCardNo(CardNo);
		order.getOrderBaseInfo().setCardPassword(CardPassword);
		CTMSSubmitGoodsOrderReply ykReply = new YkInterface().SubmitGoodsOrder(userCinema, order);
		if("Success".equals(ykReply.Status.getStatusCode())){
			// 更新订单信息
			order.getOrderBaseInfo().setOrderPayTime(new Date());	//支付时间
			order.getOrderBaseInfo().setUpdated(new Date());
			order.getOrderBaseInfo().setOrderPayFlag(1);
			goodsOrderService.Update(order);
			// 更新优惠券已使用
			if (order.getOrderBaseInfo().getCouponsCode() != null && !"".equals(order.getOrderBaseInfo().getCouponsCode())) {
				CouponsView couponsview=_couponsService.getWithCouponsCode(order.getOrderBaseInfo().getCouponsCode());
				if(couponsview!=null){
					couponsview.getCoupons().setStatus(CouponsStatusEnum.Used.getStatusCode());
					couponsview.getCoupons().setUsedDate(new Date());
					//使用数量+1
					couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()+1);
					//更新优惠券及优惠券分组表
					_couponsService.update(couponsview);
				}
			}
			
			try{	//发短信
				Cinemamessage cinemamessage = cinemamessageService.getByMessageType("2");
				Cinema cinema = _cinemaService.getByCinemaCode(order.getOrderBaseInfo().getCinemaCode());
				String batchNum = UUID.randomUUID().toString().replace("-","");
				String smsContent = cinema.getSmsSignId() + cinemamessage.getMessageContent();
				SendMobileMessage.sendMessage(cinema.getSmsAccount(),cinema.getSmsPwd(), order.getOrderBaseInfo().getMobilePhone(), smsContent, batchNum);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
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
		CardPayBackReply reply;
		Usercinemaview userCinema = _userCinemaViewService.getByCinemaCode(CinemaCode);
		OrderView order = orderService.getOrderWidthTradeNo(CinemaCode, TradeNo);
		Goodsorders goodsorders = goodsOrderService.getByOrderTradeNo(CinemaCode, TradeNo);
		if(userCinema.getCinemaType() == CinemaTypeEnum.ManTianXing.getTypeCode() && goodsorders != null ){	//满天星卖品会员支付撤销
			reply = new MtxInterface().sPPayBack(userCinema, CardNo, CardPassword, TradeNo);
		} else {
			reply = new NetSaleSvcCore().CardPayBack(Username, Password, CinemaCode, CardNo, CardPassword, TradeNo, PayBackAmount);
		}
		
		if(order!=null&&order.getOrderBaseInfo()!=null){
			if(reply.Status.equals("Success")){
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.PayBack.getStatusCode());
				order.getOrderBaseInfo().setRefundTradeNo(reply.getTradeNo());
				order.getOrderBaseInfo().setRefundTime(new Date());
				orderService.update(order.getOrderBaseInfo());
				//退优惠券
				if(order.getOrderBaseInfo().getCouponsCode()!=null && !"".equals(order.getOrderBaseInfo().getCouponsCode())){
					CouponsView couponsview = _couponsService.getWithCouponsCode(order.getOrderBaseInfo().getCouponsCode());
					if(couponsview!=null){
						couponsview.getCoupons().setStatus(CouponsStatusEnum.Fetched.getStatusCode());
						couponsview.getCoupons().setUsedDate(null);
						//使用数量-1
						couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()-1);
						couponsview.getCouponsgroup().setRemainingNumber(couponsview.getCouponsgroup().getRemainingNumber()+1);
						couponsview.getCouponsgroup().setOperationRemark("会员卡支付撤销操作-1");
						couponsview.getCouponsgroup().setUpdateDate(new Date());
						//更新优惠券及优惠券分组表
						_couponsService.update(couponsview);
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
				if(goodsorders.getCouponsCode() != null && !"".equals(goodsorders.getCouponsCode())){
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
	@GetMapping("/CardCharge/{Username}/{Password}/{CinemaCode}/{CardNo}/{CardPassword}/{ChargeType}/{LevelCode}/{RuleCode}/{ChargeAmount}/{TradeNo}")
	@ApiOperation(value = "会员卡充值")
	public CardChargeReply CardCharge(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String ChargeType,@PathVariable String LevelCode,
			@PathVariable String RuleCode,@PathVariable String ChargeAmount,@PathVariable String TradeNo) throws Exception {
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
		log.info("充值返回："+new Gson().toJson(reply));
		Membercardrecharge mem = membercardrechargeService.getByTradeNo(TradeNo);
		if(reply.Status.equals("Success")){
			Membercard membercard=_memberCardService.getByCardNo(CinemaCode, CardNo);
			QueryCardReply queryCardReply=QueryCard(Username, Password, CinemaCode, CardNo, CardPassword);
			if(queryCardReply.Status.equals("Success")){
				membercard.setBalance(Double.valueOf(queryCardReply.getCard().getBalance()));
				membercard.setScore(Integer.valueOf(queryCardReply.getCard().getScore()));
				mem.setBalance(Double.valueOf(queryCardReply.getCard().getBalance()));
			}
			_memberCardService.Update(membercard);	//更新会员卡表
			
			mem.setUserName(membercard.getUserName());
			mem.setMobilePhone(membercard.getMobilePhone());
			mem.setChargeStatus("1");	//充值成功
			mem.setUpdated(new Date());
			membercardrechargeService.update(mem);
			try {
				Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
				String batchNum=UUID.randomUUID().toString().replace("-","");
				Cinemamessage cinemamessage=cinemamessageService.getByMessageType("3");
				String smsContent=cinema.getSmsSignId() + cinemamessage.getMessageContent().replaceFirst("@ChargeAmount",ChargeAmount).replaceFirst("@BalanceAmount", membercard.getBalance().toString()).replaceFirst("@MemberScore",membercard.getScore().toString());
				//String MsgConetnt="您的充值已成功，充值金额为"+ChargeAmount+"元，余额为"+membercard.getBalance()+"元，剩余积分"+membercard.getScore()+"。";
				//new SendSmsHelper().SendSms(CinemaCode, membercard.getMobilePhone(),smsContent);
				SendMobileMessage.sendMessage(cinema.getSmsAccount(),cinema.getSmsPwd(), membercard.getMobilePhone(), smsContent, batchNum);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {	//充值失败
			if(mem != null && "1".equals(mem.getPayStatus())){
				mem.setChargeStatus("0");
				mem.setErrorMsg(reply.ErrorMessage);
				//微信支付成功，退款
				// 获取影院的支付配置
				Cinemapaymentsettings cinemapaymentsettings = _cinemapaymentsettingsService
						.getByCinemaCode(CinemaCode);
				if (cinemapaymentsettings == null || cinemapaymentsettings.getWxpayAppId().isEmpty()
						|| cinemapaymentsettings.getWxpayMchId().isEmpty()) {
					cardChargeReply.SetCinemaPaySettingInvalidReply();
					return cardChargeReply;
				}
				String WxpayAppId = cinemapaymentsettings.getWxpayAppId();
				String WxpayMchId=cinemapaymentsettings.getWxpayMchId();
				String WxpayKey=cinemapaymentsettings.getWxpayKey();
				String refundTradeNo = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				Double RefundPrice = Double.valueOf(ChargeAmount);// 退款金额
				String RefundFee = String.valueOf(Double.valueOf(RefundPrice*100).intValue());// 退款金额，以分为单位
				String OrderTradeNo = mem.getWXtradeNo();//微信支付订单号
				String WxpayRefundCert=cinemapaymentsettings.getWxpayRefundCert();
				String strRefundPaymentXml = WxPayUtil.WxPayRefund(WxpayAppId,WxpayMchId,WxpayKey,refundTradeNo,RefundFee,OrderTradeNo,CinemaCode,WxpayRefundCert);
				log.info("退款返回："+strRefundPaymentXml);
				//获取返回值 
				String strRefundPaymentXml2 = strRefundPaymentXml.replace("<![CDATA[", "").replace("]]>", "");
				Document document = XmlHelper.StringTOXml(strRefundPaymentXml2);
				String resultcode = XmlHelper.getNodeValue(document, "/xml/result_code");
				String resultMsg = XmlHelper.getNodeValue(document, "/xml/err_code_des");
				if (resultcode.equals("SUCCESS")) {
					mem.setPayStatus("3");	//退款成功
				} else {
					mem.setPayStatus("4");	//退款失败
					mem.setErrorMsg(resultMsg);
				}
				mem.setUpdated(new Date());
				membercardrechargeService.update(mem);
				
			} else {
				reply.SetOrderNotExistReply();
				return reply;
			}
			
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
			Cinemaview cinemaview = cinemaviewService.getByCinemaCode(CinemaCode);
			if(cinemaview.getCinemaType() == CinemaTypeEnum.YueKe.getTypeCode()){	//粤科的会员卡密码为6位数字
				Pattern pattern = Pattern.compile("\\d{6}");
				boolean matches = pattern.matcher(CardPassword).matches();
				if(!matches){
					cardRegisterReply.SetCardPwdNotNumReply();
					return cardRegisterReply;
				}
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
	@GetMapping("/PrePayCardCharge/{Username}/{Password}/{CinemaCode}/{OpenID}/{LevelCode}/{RuleCode}/{ChargeAmount}/{CardNo}/{CardPassword}")
	@ApiOperation(value = "预支付会员卡充值(准备支付参数)")
	public PrePayParametersReply PrePayCardCharge(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OpenID,@PathVariable String LevelCode,@PathVariable String RuleCode,@PathVariable String ChargeAmount,@PathVariable String CardNo,@PathVariable String CardPassword) throws IOException{
		PrePayParametersReply prePayParametersReply = new PrePayParametersReply();
		//校验参数
		if (!ReplyExtension.RequestInfoPrePayCardCharge(prePayParametersReply, Username, Password, CinemaCode, OpenID, ChargeAmount,CardNo))
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
        
		// 更新充值记录表
		Membercardrecharge mem = new Membercardrecharge();
		mem.setCinemaCode(CinemaCode);
		mem.setCardNo(CardNo);
		mem.setCardPassword(CardPassword);
		String out_trade_no = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + CinemaCode + (int)((Math.random()*9+1)*100000);//随机的六位数字
		mem.setTradeNo(out_trade_no);
		mem.setRechargeAmount(Double.valueOf(ChargeAmount));
		mem.setPayStatus("0");	//未支付
		mem.setChargeStatus("0");
		mem.setMidUserName(Username);
		mem.setMidPassword(Password);
		mem.setRuleCode(RuleCode);
		mem.setLevelCode(LevelCode);
		mem.setUpdated(new Date());
		membercardrechargeService.save(mem);
		
        //准备参数
        Calendar cal=Calendar.getInstance();
        String WxpayAppId = cinemapaymentsettings.getWxpayAppId();
        String strbody = cinemapaymentsettings.getCinemaName() + "-" + StringUtil.leftPad(String.valueOf(cal.get(Calendar.MONTH)+1), 2, "0")
                + "月" + StringUtil.leftPad(String.valueOf(cal.get(Calendar.DATE)), 2, "0") + "日" + new SimpleDateFormat("HH:mm").format(new Date()) + " "
                + " 会员卡充值（" + ChargeAmount + " 元）";
        String WxpayMchId = cinemapaymentsettings.getWxpayMchId();
        String WxpayKey = cinemapaymentsettings.getWxpayKey();
        String weburl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
		String notify_url = weburl+"/Api/Member/WxPayNotify";
//        String notify_url = "https://xc.80piao.com:8443/Api/Member/WxPayNotify";
        
		String time_expire =new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(new Date() .getTime() + 900000));
        Double totalPrice = Double.valueOf(ChargeAmount);
        String total_fee = String.valueOf(Double.valueOf(totalPrice*100).intValue());//以分为单位
        return WxPayUtil.WxPayPrePay(request,prePayParametersReply, WxpayAppId, WxpayMchId, WxpayKey, strbody, notify_url, OpenID, out_trade_no, time_expire, total_fee);
	}
	//endregion
	
	//region 异步接收微信支付返回(充值 )
	@RequestMapping(value = "/WxPayNotify", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public void WxPayNotify(HttpServletRequest request,HttpServletResponse response) throws Exception{
		// 读取返回内容
		Map<String, String> returnmap = WxPayUtil.WxPayNotify(request);
		String tradeNo = returnmap.get("out_trade_no");
		Membercardrecharge mem = membercardrechargeService.getByTradeNo(tradeNo);
		log.info("异步接收微信支付返回："+new Gson().toJson(returnmap));
		if (returnmap.get("isWXsign").equals("True")) {
			if ("SUCCESS".equals(returnmap.get("return_code")) && "SUCCESS".equals(returnmap.get("result_code"))) {
				log.info("--------");
				if("0".equals(mem.getPayStatus())){
					mem.setPayStatus("1");		//微信支付成功
					mem.setWXtradeNo(returnmap.get("transaction_id"));	//微信支付流水
					membercardrechargeService.update(mem);
					//会员卡充值
					CardCharge(mem.getMidUserName(), mem.getMidPassword(), mem.getCinemaCode(), mem.getCardNo(), mem.getCardPassword(), "WxPay", mem.getLevelCode(), mem.getRuleCode(), String.valueOf(mem.getRechargeAmount()),tradeNo);	
				}
			}else {
				mem.setPayStatus("2");		//微信支付失败
				mem.setErrorMsg(returnmap.get("err_code_des"));
				mem.setUpdated(new Date());
				membercardrechargeService.update(mem);	// 更新充值记录表
			}
		} else {
			mem.setPayStatus("2");
			mem.setErrorMsg(returnmap.get("err_code_des"));
			mem.setUpdated(new Date());
			membercardrechargeService.update(mem);	// 更新充值记录表
		}
		response.getWriter().write(setXML("SUCCESS", "OK")); 
	}
	public static String setXML(String return_code, String return_msg) {
		  return "<xml><return_code><![CDATA[" + return_code
		    + "]]></return_code><return_msg><![CDATA[" + return_msg
		    + "]]></return_msg></xml>";
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
        String weburl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
		String notify_url = weburl+"/Api/Member/WxPayRegisterNotify";
        //String notify_url = "https://xc.80piao.com:8443/Api/Member/WxPayNotify";
        String out_trade_no = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + CinemaCode + (int)((Math.random()*9+1)*100000);//随机的六位数字
        String time_expire =new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(new Date() .getTime() + 900000));
        Double totalPrice = Double.valueOf(InitialAmount);
        String total_fee = String.valueOf(Double.valueOf(totalPrice*100).intValue());//以分为单位
        return WxPayUtil.WxPayPrePay(request,prePayParametersReply, WxpayAppId, WxpayMchId, WxpayKey, strbody, notify_url, OpenID, out_trade_no, time_expire, total_fee);
	}
	//endregion
	
	//region 异步接收微信支付返回（注册）
	@RequestMapping(value = "/WxPayRegisterNotify", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public void WxPayRegisterNotify(HttpServletRequest request,HttpServletResponse response) throws Exception{
		// 读取返回内容
		Map<String, String> returnmap = WxPayUtil.WxPayNotify(request);
		String tradeNo = returnmap.get("out_trade_no");
		//Membercardrecharge mem = membercardrechargeService.getByTradeNo(tradeNo);
		log.info("异步接收微信支付返回："+new Gson().toJson(returnmap));
		if (returnmap.get("isWXsign").equals("True")) {
			if ("SUCCESS".equals(returnmap.get("return_code")) && "SUCCESS".equals(returnmap.get("result_code"))) {
				log.info("--------");
				/*if("0".equals(mem.getPayStatus())){
					mem.setPayStatus("1");		//微信支付成功
					mem.setWXtradeNo(returnmap.get("transaction_id"));	//微信支付流水
					membercardrechargeService.update(mem);
					//会员卡充值
					CardCharge(mem.getMidUserName(), mem.getMidPassword(), mem.getCinemaCode(), mem.getCardNo(), mem.getCardPassword(), "WxPay", mem.getLevelCode(), mem.getRuleCode(), String.valueOf(mem.getRechargeAmount()),tradeNo);	
				}*/
			}else {
				/*mem.setPayStatus("2");		//微信支付失败
				mem.setErrorMsg(returnmap.get("err_code_des"));
				mem.setUpdated(new Date());
				membercardrechargeService.update(mem);	// 更新充值记录表
*/			}
		} else {
			/*mem.setPayStatus("2");
			mem.setErrorMsg(returnmap.get("err_code_des"));
			mem.setUpdated(new Date());
			membercardrechargeService.update(mem);	// 更新充值记录表
*/		}
		response.getWriter().write(setXML("SUCCESS", "OK")); 
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
        			if(membercardlevel.getPictureUrl()==null||membercardlevel.getPictureUrl()==""){
        				membercardlevel.setPictureUrl("https://whtxcx.oss-cn-hangzhou.aliyuncs.com/images/vipimage.png");
        			}
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
	        	//如果没有卡图片
	        	if(membercardlevel.getPictureUrl()==null||membercardlevel.getPictureUrl()==""){
	        		//取服务器上的卡图片
	        		membercardlevel.setPictureUrl("https://whtxcx.oss-cn-hangzhou.aliyuncs.com/images/vipimage.png");
	        	}
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
	
	@GetMapping("/CardChargeRecord/{CinemaCode}/{Mobilephone}")
	@ApiOperation(value = "会员卡充值记录")
	public CardChargeRecordReply CardChargeRecord(@PathVariable String CinemaCode, @PathVariable String Mobilephone){
		CardChargeRecordReply reply = new CardChargeRecordReply();
		
		log.info("进入会员卡充值记录接口");
		List<Membercard> cardlist = _memberCardService.getByCinemaCodeAndMobilePhone(CinemaCode, Mobilephone);
		log.info("会员卡列表"+new Gson().toJson(cardlist));
		if(cardlist == null || cardlist.size() == 0){
			reply.setChargeCount(0);
		} else {
			for(Membercard card : cardlist){
				List<Membercardrecharge> charges = membercardrechargeService.getByCinemaAndCard(CinemaCode, card.getCardNo());
				log.info("会员卡充值记录列表"+ new Gson().toJson(charges));
				if(charges == null){
					reply.setChargeCount(0);
				} else {
					List<ChargeRecord> data = new ArrayList<ChargeRecord>();
					for(Membercardrecharge charge : charges){
						ChargeRecord cardCharge = new ChargeRecord();
						cardCharge.setCardNo(charge.getCardNo());
						cardCharge.setRechargeAmount(String.valueOf(charge.getRechargeAmount()));
						cardCharge.setChargeStatus(charge.getChargeStatus());
						cardCharge.setChargeTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(charge.getUpdated()));
						data.add(cardCharge);
					}
					reply.setChargeCount(charges.size());
					reply.setData(data);
				}
			}
		}
		
		reply.SetSuccessReply();
		return reply;
	}
	
	//region
	public static void main(String[] args) {
		System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "12345678" + (int)((Math.random()*9+1)*100000));
	}
	//endregion
}
