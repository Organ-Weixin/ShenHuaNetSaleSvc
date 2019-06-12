package com.boot.security.server.apicontroller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
		DecimalFormat df= new DecimalFormat("0.00");
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		QueryDiscountReply reply = new NetSaleSvcCore().QueryDiscount(Username, Password, CinemaCode, order.getOrderBaseInfo().getTicketCount().toString(), CardNo, CardPassword, LevelCode,session.getSCode(),sf.format(session.getStartTime()),session.getFilmCode(), ScreenType,df.format(session.getListingPrice()),df.format(session.getLowestPrice()));
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
		Double ticketCouponsPrice=0D;//影票优惠总金额
		Double goodsCouponsPrice=0D;//卖品优惠总金额
		Double realPayAmount=0D;//实际购票订单支付金额
		Double realGoodsPayAmount=0D;//实际卖品支付金额
		OrderView order = orderService.getOrderWidthLockOrderCode(CinemaCode, LockOrderCode);
		GoodsOrderView goodsOrder = goodsOrderService.getWithLocalOrderCode(CinemaCode,LocalOrderCode);
		//region 优惠券价格计算
		if(!CouponsCodes.equals(null)&&!CouponsCodes.equals("null")&&!CouponsCodes.equals("")){
			String[] CouponsCodesArr=CouponsCodes.split(",");
			for(int i=0;i<CouponsCodesArr.length;i++){//为了设置到对应的座位上，这里用i循环
				String CouponsCode=CouponsCodesArr[i];
				if(!CouponsCode.equals("")&&!CouponsCode.equals(null)){
					CouponsView couponsview = _couponsService.getWithCouponsCode(CouponsCode);
					if(couponsview.getCoupons()!=null){
	                    boolean ifCanUse=CouponsUtil.CouponsCanUse(couponsview,CinemaCode);
						//如果减免类型是影片 并且传入的影片编码不为空，说明是购票订单
						if(ifCanUse && couponsview.getCouponsgroup().getReductionType()==1&&!FilmCode.equals(null)&&!FilmCode.equals("null")){
							if(!couponsview.getCouponsgroup().getFilmCodes().equals(null)&&!couponsview.getCouponsgroup().getFilmCodes().equals("")){
								if(couponsview.getCouponsgroup().getFilmCodes().indexOf(FilmCode)>-1){
									//当前优惠券可以使用，把券码和优惠价格更新到订单详细表
									order.getOrderSeatDetails().get(i).setConponCode(couponsview.getCoupons().getCouponsCode());
									order.getOrderSeatDetails().get(i).setConponPrice(couponsview.getCouponsgroup().getReductionPrice());
								}else{
									order.getOrderSeatDetails().get(i).setConponPrice(0D);//当前影片不在可优惠的影片列表
								}
							}else{
								//所有影片可用
								order.getOrderSeatDetails().get(i).setConponCode(couponsview.getCoupons().getCouponsCode());
								order.getOrderSeatDetails().get(i).setConponPrice(couponsview.getCouponsgroup().getReductionPrice());
							}
						}
						//如果减免类型是卖品
						if(ifCanUse && couponsview.getCouponsgroup().getReductionType()==2&&goodsOrder!=null){
							if(!couponsview.getCouponsgroup().getGoodsCodes().equals(null)&&!couponsview.getCouponsgroup().getGoodsCodes().equals("")){
								//循环判断每个卖品是不是在可使用优惠的卖品里面
								for(Goodsorderdetails goodsdetail:goodsOrder.getOrderGoodsDetails()){
									if(couponsview.getCouponsgroup().getGoodsCodes().indexOf(goodsdetail.getGoodsCode())==-1){
										ifCanUse=false;
										goodsOrder.getOrderBaseInfo().setCouponsPrice(0D);
										break;
									}else{
										continue;
									}
								}
							}
							//如果到最后还是可以使用
							if(ifCanUse){
								//当前优惠券可以使用,把优惠券更新到卖品订单表
								goodsOrder.getOrderBaseInfo().setCouponsCode(couponsview.getCoupons().getCouponsCode());
								goodsOrder.getOrderBaseInfo().setCouponsPrice(couponsview.getCouponsgroup().getReductionPrice());
							}else{
								goodsOrder.getOrderBaseInfo().setCouponsPrice(0D);//优惠券不可使用
							}
						}else{
							//如果不满足影票优惠券并且购票订单存在，也不满足卖品优惠券并且卖品订单存在，则不用处理
						}
					}else{
					   //找不到优惠券，不用处理
					}
				}
			}
		}
		//endregion

		if(order!=null){
			//region 购票价格计算（得到最终上报价，最终销售价，最终服务费）
			Double SubmitPrice;// 最终上报价格
			Double SalePrice;// 最终销售价格
			Double TicketFee;// 最终服务费
			int TicketCount = order.getOrderBaseInfo().getTicketCount();// 总票数
			Userinfo UserInfo = _userInfoService.getByUserCredential(Username,Password);
			Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
			Sessioninfo sessioninfo = _sessioninfoService.getBySessionCode(order.getOrderBaseInfo().getUserId(),
					order.getOrderBaseInfo().getCinemaCode(), order.getOrderBaseInfo().getSessionCode());
			List<Priceplan> priceplans = _priceplanService.getByCode(order.getOrderBaseInfo().getUserId(),
					order.getOrderBaseInfo().getCinemaCode(), order.getOrderBaseInfo().getFilmCode(),
					order.getOrderBaseInfo().getSessionCode());
			// 得到价格计划
			Priceplan priceplan = new Priceplan();
			if (priceplans.size() > 1) {
				priceplan = priceplans.stream().filter((Priceplan s) -> s.getType() == 1).collect(Collectors.toList())
						.get(0);
			} else if (priceplans.size() == 1) {
				priceplan = priceplans.get(0);
			}
			Double priceplanMemberPrice = null == priceplan.getMemberPrice() ? sessioninfo.getStandardPrice() : priceplan.getMemberPrice();
			//如果座位表中已有销售价，说明已设置会员卡折扣价
			if(order.getOrderSeatDetails().get(0).getSalePrice()!=null&&order.getOrderSeatDetails().get(0).getSalePrice()!=0){
				priceplanMemberPrice=order.getOrderSeatDetails().get(0).getSalePrice();
			}
			Double priceplanFee = null == priceplan.getTicketFee() ? 0 : priceplan.getTicketFee();
			Double priceplanAddFee = null == priceplan.getAddFee() ? 0 : priceplan.getAddFee();
			Double priceplanCinemaAllowance = null == priceplan.getCinemaAllowance() ? 0 : priceplan.getCinemaAllowance();
			Double basisSubmitPrice;//基础上报价格=标准价/最低价
			//System.out.println("====="+userCinema.getIsUseLowestPriceReport());
			if(userCinema.getIsUseLowestPriceReport()==null){
				userCinema.setIsUseLowestPriceReport(0);
			}
			if(userCinema.getIsUseLowestPriceReport()==1){
				basisSubmitPrice=sessioninfo.getLowestPrice();
			}else{
				basisSubmitPrice=sessioninfo.getStandardPrice();
			}
			//System.out.println("-----"+userCinema.getIsUseLowestPriceReport());
			if(userCinema.getCinemaType()==CinemaTypeEnum.ChenXing.getTypeCode()){
				//如果是辰星系统
				// 上报价=场次标准价+场次服务费+场次增值服务费
				SubmitPrice = basisSubmitPrice + sessioninfo.getTicketFee()+sessioninfo.getAddFee();
				// 服务费=场次服务费+场次增值服务费-场次影院补贴
				TicketFee = sessioninfo.getTicketFee() + sessioninfo.getAddFee() - sessioninfo.getCinemaAllowance();
				// 销售价=真实标准价+服务费
				SalePrice = priceplanMemberPrice + TicketFee;
			}else
			{
				//其他系统
				//上报价=场次标准价+服务费（后台设置影院服务费）
				SubmitPrice=basisSubmitPrice+priceplanFee;
				// 服务费=价格设置表服务费+价格设置表增值服务费-价格设置表影院补贴
			    TicketFee = priceplanFee + priceplanAddFee - priceplanCinemaAllowance;
			    // 销售价=真实标准价+服务费
			 	SalePrice = priceplanMemberPrice + TicketFee;
			}
			//endregion
			
			//总优惠金额=所有座位的优惠金额相加
			for(int i=0; i<order.getOrderSeatDetails().size(); i++){
				if(order.getOrderSeatDetails().get(i).getConponCode()==null||order.getOrderSeatDetails().get(i).getConponCode()==""){
					order.getOrderSeatDetails().get(i).setConponPrice(0.00);
				}
			}
			ticketCouponsPrice = order.getOrderSeatDetails().stream().mapToDouble(Orderseatdetails::getConponPrice).sum();
			
			// 更新订单信息
			// 总上报金额=上报价*总票数
			order.getOrderBaseInfo().setTotalPrice(SubmitPrice * TicketCount);
			order.getOrderBaseInfo().setTotalFee(TicketFee * TicketCount);
			order.getOrderBaseInfo().setTotalSalePrice(SalePrice * TicketCount);
			order.getOrderBaseInfo().setTotalConponPrice(ticketCouponsPrice);
			//更新订单
			orderService.Update(order);
		}
		if(goodsOrder!=null){
			goodsCouponsPrice=goodsOrder.getOrderBaseInfo().getCouponsPrice();
			//更新卖品订单主表
			goodsOrderService.UpdateOrderBaseInfo(goodsOrder.getOrderBaseInfo());
		}
		//实际购票金额=原始金额-优惠券优惠金额
		realPayAmount=order.getOrderBaseInfo().getTotalSalePrice()-ticketCouponsPrice;
		realGoodsPayAmount=goodsOrder.getOrderBaseInfo().getTotalSettlePrice() - goodsCouponsPrice;
		
		CardPayReply reply = new NetSaleSvcCore().CardPay(Username, Password, CinemaCode, CardNo, CardPassword,String.valueOf(realPayAmount),String.valueOf(realGoodsPayAmount), SessionCode, FilmCode, TicketNum);
		
		//region 更新订单支付状态
		if(order!=null){
			if(reply.Status.equals("Success")){
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Payed.getStatusCode());
				order.getOrderBaseInfo().setPayFlag(1);
				order.getOrderBaseInfo().setPayTime(new Date());
				order.getOrderBaseInfo().setOrderTradeNo(reply.getTradeNo());
				order.getOrderBaseInfo().setCardNo(CardNo);
				order.getOrderBaseInfo().setOrderPayType(OrderPayTypeEnum.MemberCardPay.getTypeCode());
				order.getOrderBaseInfo().setUpdated(new Date());
			}else{
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.PayFail.getStatusCode());
			}
			orderService.update(order.getOrderBaseInfo());
		}
		if(goodsOrder!=null){
			if(reply.Status.equals("Success")){
				goodsOrder.getOrderBaseInfo().setCardNo(CardNo);
				goodsOrder.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Payed.getStatusCode());
				goodsOrder.getOrderBaseInfo().setOrderPayFlag(1);
				goodsOrder.getOrderBaseInfo().setOrderPayTime(new Date());
				goodsOrder.getOrderBaseInfo().setOrderTradeNo(reply.getTradeNo());
				goodsOrder.getOrderBaseInfo().setOrderPayType(OrderPayTypeEnum.MemberCardPay.getTypeCode());
				goodsOrder.getOrderBaseInfo().setUpdated(new Date());
			}else{
				goodsOrder.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.PayFail.getStatusCode());
			}
			goodsOrderService.update(goodsOrder.getOrderBaseInfo());
		}
		//endregion
		return reply;
	}
	//endregion
	
	//region 1905会员卡购票
	@GetMapping("/SellTicketCustomMember/{Username}/{Password}/{CinemaCode}/{LockOrderCode}/{CardNo}/{CardPassword}")
	@ApiOperation(value = "会员卡购票（1905）")
	public SellTicketCustomMemberReply SellTicketCustomMember(@PathVariable String Username,@PathVariable String Password,
			@PathVariable String CinemaCode,@PathVariable String LockOrderCode,@PathVariable String CardNo,@PathVariable String CardPassword) throws Exception{
		return new Dy1905Interface().SellTicketCustomMember(Username, Password, CinemaCode, LockOrderCode, CardNo, CardPassword);
	}
	//endregion
	
	//region 1905会员卡混合支付
	@GetMapping("/MemberCardPay/{Username}/{Password}/{CinemaCode}/{LockOrderCode}/{LocalOrderCode}/{CardNo}/{CardPassword}")
	@ApiOperation(value = "会员卡混合支付（1905）")
	public MemberCardPayReply MemberCardPay(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String LockOrderCode,@PathVariable String LocalOrderCode,@PathVariable String CardNo,@PathVariable String CardPassword) throws Exception{
		return new Dy1905Interface().MemberCardPay(Username, Password, CinemaCode, LockOrderCode, LocalOrderCode, CardNo, CardPassword);
	}
	//endregion
	
	//region 会员卡支付撤销
	@GetMapping("/CardPayBack/{Username}/{Password}/{CinemaCode}/{CardNo}/{CardPassword}/{TradeNo}/{PayBackAmount}")
	@ApiOperation(value = "会员卡支付撤销")
	public CardPayBackReply CardPayBack(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String TradeNo,@PathVariable String PayBackAmount){
		CardPayBackReply reply = new NetSaleSvcCore().CardPayBack(Username, Password, CinemaCode, CardNo, CardPassword, TradeNo, PayBackAmount);
		Orders orders = orderService.getByOrderTradeNo(CinemaCode, TradeNo);
		Goodsorders goodsorders = goodsOrderService.getByOrderTradeNo(CinemaCode, TradeNo);
		if(orders!=null){
			if(reply.Status.equals("Success")){
				orders.setOrderStatus(OrderStatusEnum.PayBack.getStatusCode());
				orderService.update(orders);
			}
		}
		if(goodsorders!=null){
			if(reply.Status.equals("Success")){
				goodsorders.setOrderStatus(GoodsOrderStatusEnum.PayBack.getStatusCode());
				goodsOrderService.update(goodsorders);
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
	@GetMapping("/CardCharge/{Username}/{Password}/{CinemaCode}/{CardNo}/{CardPassword}/{ChargeType}/{RuleCode}/{ChargeAmount}")
	@ApiOperation(value = "会员卡充值")
	public CardChargeReply CardCharge(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String CardNo,@PathVariable String CardPassword,@PathVariable String ChargeType,
			@PathVariable String RuleCode,@PathVariable String ChargeAmount){
		CardChargeReply cardChargeReply = new CardChargeReply();
		if(RuleCode==null||RuleCode==""){
			cardChargeReply.SetCardChargeTypeInvalidReply();
			return cardChargeReply;
		}
		Choosemembercardcreditrule choosemembercardcreditrule = _choosemembercardcreditruleService.getByRuleCode(CinemaCode, RuleCode);
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
			Choosemembercardcreditrule choosemembercardcreditrule = _choosemembercardcreditruleService.getByRuleCode(CinemaCode, RuleCode);
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
	@GetMapping("/PrePayCardCharge/{Username}/{Password}/{CinemaCode}/{OpenID}/{RuleCode}/{ChargeAmount}")
	@ApiOperation(value = "预支付会员卡充值(准备支付参数)")
	public PrePayParametersReply PrePayCardCharge(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OpenID,@PathVariable String RuleCode,@PathVariable String ChargeAmount) throws IOException{
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
		Choosemembercardcreditrule choosemembercardcreditrule = _choosemembercardcreditruleService.getByRuleCode(CinemaCode, RuleCode);
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
	@GetMapping("/PrePayCardRegister/{Username}/{Password}/{CinemaCode}/{OpenID}/{RuleCode}/{InitialAmount}")
	@ApiOperation(value = "预支付会员卡注册(准备支付参数)")
	public PrePayParametersReply PrePayCardRegister(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OpenID,@PathVariable String RuleCode,@PathVariable String InitialAmount) throws IOException{
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
		Choosemembercardcreditrule choosemembercardcreditrule = _choosemembercardcreditruleService.getByRuleCode(CinemaCode, RuleCode);
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
	        	levelReply.setStatus(membercardlevel.getStatus());
	        	//会员卡类别规则
	        	Choosemembercardcreditrule choosemembercardcreditrule =  _choosemembercardcreditruleService.getOpenTypeByLevelCode(CinemaCode, membercardlevel.getLevelCode());
	        	if(choosemembercardcreditrule!=null&&choosemembercardcreditrule.getRuleCode()!=null&&choosemembercardcreditrule.getRuleCode()!=""){
	        		Membercardcreditrule membercardcreditrule = _membercardcreditruleService.getByRuleCode(choosemembercardcreditrule.getRuleCode());
	        		if(membercardcreditrule!=null){
	        			levelReply.setCredit(membercardcreditrule.getCredit());
	        			levelReply.setEffectiveDays(membercardcreditrule.getEffectiveDays());
	        			levelReply.setRuleCode(membercardcreditrule.getRuleCode());
	        			levelReply.setRuleName(membercardcreditrule.getRuleName());
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
