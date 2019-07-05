package com.boot.security.server.apicontroller;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.QueryDiscountReply;
import com.boot.security.server.apicontroller.reply.BindCouponsReply;
import com.boot.security.server.apicontroller.reply.BindCouponsReply.BindCouponsReplyBind;
import com.boot.security.server.apicontroller.reply.ModelMapper;
import com.boot.security.server.apicontroller.reply.QueryUserAvailableCouponsReply;
import com.boot.security.server.apicontroller.reply.QueryUserAvailableCouponsReply.QueryUserAvailableCouponsReplydata;
import com.boot.security.server.apicontroller.reply.QueryUserAvailableCouponsReply.QueryUserAvailableCouponsReplydata.QueryUserAvailableCouponsReplyCoupons;
import com.boot.security.server.apicontroller.reply.QueryUserConponsReply;
import com.boot.security.server.apicontroller.reply.QueryUserConponsReply.QueryUserConponsBeans;
import com.boot.security.server.apicontroller.reply.QueryUserConponsReply.QueryUserConponsBeans.QueryUserConponsBean;
import com.boot.security.server.apicontroller.reply.QueryUsingConponsReply;
import com.boot.security.server.apicontroller.reply.QueryUsingConponsReply.ConponData;
import com.boot.security.server.apicontroller.reply.QueryUsingConponsReply.ConponData.ConponBean;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.CouponsStatusEnum;
import com.boot.security.server.model.CouponsView;
import com.boot.security.server.model.Couponsgroup;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.model.OrderPayTypeEnum;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Priceplan;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.CouponsgroupServiceImpl;
import com.boot.security.server.service.impl.GoodsOrderServiceImpl;
import com.boot.security.server.service.impl.MemberCardServiceImpl;
import com.boot.security.server.service.impl.OrderServiceImpl;
import com.boot.security.server.service.impl.PriceplanServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.service.impl.TicketusersServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.boot.security.server.utils.DoubleUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/Conpon") 
public class ConponController {
	@Autowired
	private UserInfoServiceImpl _userInfoService;
	@Autowired
	private CinemaServiceImpl _cinemaService;
	@Autowired
	private TicketusersServiceImpl _ticketusersService;
	@Autowired
	private CouponsServiceImpl _couponsService;
	@Autowired
	private CouponsgroupServiceImpl _couponsgroupService;
	@Autowired
	private OrderServiceImpl _orderService;
	@Autowired
	private GoodsOrderServiceImpl _goodsOrderService;
	@Autowired 
	private MemberCardServiceImpl _memberCardService;
	@Autowired
	private SessioninfoServiceImpl _sessioninfoService;
	@Autowired
	PriceplanServiceImpl _priceplanService;
	@Autowired
	ScreeninfoServiceImpl _screeninfoService;
	@Autowired
	UserInfoServiceImpl _userinfoSevice;
	
	@GetMapping("/QueryUsingConpons/{UserName}/{Password}/{CinemaCode}")
	@ApiOperation(value = "获取所有启用优惠券")
	public QueryUsingConponsReply QueryUsingConpons(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode){
		QueryUsingConponsReply reply=new QueryUsingConponsReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(reply, UserName, Password, CinemaCode)){
			return reply;
		}
		//获取用户渠道
		Userinfo UserInfo=_userInfoService.getByUserCredential(UserName, Password);
		if(UserInfo==null){
			reply.SetUserCredentialInvalidReply();
			return reply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(CinemaCode);
		if(cinema==null){
			reply.SetCinemaInvalidReply();
			return reply;
		}
		List<Couponsgroup> coupons=_couponsgroupService.getAllUseByGroupCode(CinemaCode);
		ConponData data = new ConponData();
		if(coupons == null || coupons.size() == 0){
			data.setConponCount(0);
		} else {
			List<ConponBean> conlist = new ArrayList<ConponBean>();
			for(Couponsgroup couponsgroup : coupons){
				ConponBean  conpon = new ConponBean();
				conpon.setCinemaCode(CinemaCode);
				ModelMapper.MapFrom(couponsgroup, conpon);
				conlist.add(conpon);
			}
			data.setConponCount(conlist.size());
			data.setConpons(conlist);
		}
		reply.setData(data);
		reply.SetSuccessReply();
		return reply;
	}
	
	@GetMapping("/QueryUserConpons/{UserName}/{Password}/{CinemaCode}/{OpenID}/{Status}")
	@ApiOperation(value = "获取用户优惠券(不分页)")
	public QueryUserConponsReply QueryUserConpons(@PathVariable String UserName, @PathVariable String Password,
			@PathVariable String CinemaCode, @PathVariable String OpenID, @PathVariable String Status) {
		QueryUserConponsReply queryUserConponsReply = new QueryUserConponsReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(queryUserConponsReply, UserName, Password, CinemaCode, OpenID, Status)) {
			return queryUserConponsReply;
		}
		// 获取用户渠道
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			queryUserConponsReply.SetUserCredentialInvalidReply();
			return queryUserConponsReply;
		}
		// 验证影院是否存在且可访问
		Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
		if (cinema == null) {
			queryUserConponsReply.SetCinemaInvalidReply();
			return queryUserConponsReply;
		}
		// 验证用户OpenId是否存在
		Ticketusers ticketusers = _ticketusersService.getByopenids(OpenID);
		if (ticketusers == null) {
			queryUserConponsReply.SetOpenIDNotExistReply();
			return queryUserConponsReply;
		}
		List<Coupons> coupons = _couponsService.getByOpenID(OpenID);
		QueryUserConponsBeans data = new QueryUserConponsBeans();
		if (coupons == null || coupons.size() == 0) {
			queryUserConponsReply.getData().setConponCount(0);
		} else {
			List<QueryUserConponsBean> queryUserConponsBeanss = new ArrayList<QueryUserConponsBean>();
			int sum=0;
			for (Coupons coupon : coupons) {
				QueryUserConponsBean queryUserConponsBean = new QueryUserConponsBean();
				ModelMapper.MapForm(queryUserConponsBean, coupon);
//				Couponsgroup cou = _couponsgroupService.getByCinemaCodeAndGroupCode(cinema.getCode(),coupon.getGroupCode());
				Couponsgroup cou = _couponsgroupService.getByGroupCode(coupon.getGroupCode());
				if (cou != null && cou.getCanUseCinemaType()==1) {		//所以门店通用
					sum++;
					queryUserConponsBean.setRemark(cou.getRemark());
					queryUserConponsBean.setPrice(cou.getReductionPrice());
					queryUserConponsBean.setCouonsType(cou.getCouponsType());
					queryUserConponsBean.setTitle(cou.getCouponsName());
					queryUserConponsBean.setCanUseCinemaType(cou.getCanUseCinemaType());
					queryUserConponsBean.setInitialAmount(cou.getThresholdAmount());//门槛金额
					if(cou.getEffectiveDate() != null){
						queryUserConponsBean.setEffectiveDate(new SimpleDateFormat("yyyy/MM/dd").format(cou.getEffectiveDate()));
					}
					if(cou.getExpireDate() != null){
						queryUserConponsBean.setExpireDate(new SimpleDateFormat("yyyy/MM/dd").format(cou.getExpireDate()));
					}
					queryUserConponsBean.setReductionType(cou.getReductionType());
					queryUserConponsBean.setIsShare(cou.getIsShare());
					queryUserConponsBeanss.add(queryUserConponsBean);
				} else if (cou != null && cou.getCanUseCinemaType()==2){	//部分门店可用
					if(cou.getCinemaCodes() != null && cou.getCinemaCodes().indexOf(CinemaCode) != -1){	//包含该影院
						sum++;
						queryUserConponsBean.setRemark(cou.getRemark());
						queryUserConponsBean.setPrice(cou.getReductionPrice());
						queryUserConponsBean.setCouonsType(cou.getCouponsType());
						queryUserConponsBean.setTitle(cou.getCouponsName());
						queryUserConponsBean.setCanUseCinemaType(cou.getCanUseCinemaType());
						queryUserConponsBean.setInitialAmount(cou.getThresholdAmount());//门槛金额
						if(cou.getEffectiveDate() != null){
							queryUserConponsBean.setEffectiveDate(new SimpleDateFormat("yyyy/MM/dd").format(cou.getEffectiveDate()));
						}
						if(cou.getExpireDate() != null){
							queryUserConponsBean.setExpireDate(new SimpleDateFormat("yyyy/MM/dd").format(cou.getExpireDate()));
						}
						queryUserConponsBean.setReductionType(cou.getReductionType());
						queryUserConponsBean.setIsShare(cou.getIsShare());
						queryUserConponsBeanss.add(queryUserConponsBean);
					}
				}
				
			}
			data.setConponCount(sum);
			data.setConpons(queryUserConponsBeanss);
			
		}
		queryUserConponsReply.setData(data);
		queryUserConponsReply.SetSuccessReply();
		return queryUserConponsReply;
	}
	@GetMapping("/BindCoupons/{UserName}/{Password}/{CinemaCode}/{OpenID}/{CouponsCode}")
	@ApiOperation(value = "绑定优惠券")
	public BindCouponsReply BindCoupons(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OpenID,@PathVariable String CouponsCode) throws ParseException{
		BindCouponsReply bindCouponsReply = new BindCouponsReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(bindCouponsReply, UserName, Password, CinemaCode, OpenID, CouponsCode)){
			return bindCouponsReply;
		}
		//获取用户渠道
		Userinfo UserInfo=_userInfoService.getByUserCredential(UserName, Password);
		if(UserInfo==null){
			bindCouponsReply.SetUserCredentialInvalidReply();
			return bindCouponsReply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(CinemaCode);
		if(cinema==null){
			bindCouponsReply.SetCinemaInvalidReply();
			return bindCouponsReply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketusers=_ticketusersService.getByopenids(OpenID);
		if(ticketusers==null){
			bindCouponsReply.SetOpenIDNotExistReply();
			return bindCouponsReply;
		}
		//验证优惠券是否存在且未使用
		Coupons coupons = _couponsService.getByCouponsCode(CouponsCode);
		if(coupons==null){
			bindCouponsReply.SetCouponNotAvailableReply();
			return bindCouponsReply;
		}
		//验证优惠券适用门店是否匹配
		Couponsgroup couponsgroup = _couponsgroupService.getByGroupCode(coupons.getGroupCode());
		if(couponsgroup.getCanUseCinemaType()!=1&&!couponsgroup.getCinemaCodes().contains(CinemaCode)){
			bindCouponsReply.SetCouponMismatchReply();
			return bindCouponsReply;
		}
		//验证优惠券是否有效
		if(coupons.getStatus()!=0||coupons.getOpenID()!=null){
			bindCouponsReply.SetCouponNotAvailableReply();
			return bindCouponsReply;
		}
		BindCouponsReplyBind data = new BindCouponsReplyBind();
		//进行绑定
		coupons.setStatus(CouponsStatusEnum.Fetched.getStatusCode());
		coupons.setOpenID(OpenID);
		if(_couponsService.update(coupons)>0){
			//更新优惠券数量
			couponsgroup.setIssuedNumber(couponsgroup.getIssuedNumber()+1);
			couponsgroup.setFetchNumber(couponsgroup.getFetchNumber()+1);
			couponsgroup.setRemainingNumber(couponsgroup.getRemainingNumber()-1);
			_couponsgroupService.update(couponsgroup);
			data.setCouponCode(coupons.getCouponsCode());
			data.setCouponName(coupons.getCouponsName());
			data.setCouponStatus(coupons.getStatus());
			bindCouponsReply.SetSuccessReply();
		}
		bindCouponsReply.setData(data);
		return bindCouponsReply;
	}
	
	@GetMapping("/QueryUserAvailableCoupons/{UserName}/{Password}/{CinemaCode}/{OpenID}/{OrderType}/{OrderPayType}/{CardNo}/{OrderCode}")
	@ApiOperation(value = "获取当前可用优惠券")
	public QueryUserAvailableCouponsReply QueryUserAvailableCoupons(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,@PathVariable String OpenID,
			@PathVariable String OrderType,@PathVariable String OrderPayType,@PathVariable String CardNo,@PathVariable String OrderCode) throws ParseException{
		QueryUserAvailableCouponsReply availableCouponsReply = new QueryUserAvailableCouponsReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(availableCouponsReply, UserName, Password,CinemaCode, OpenID, OrderType,OrderPayType,OrderCode)){
			return availableCouponsReply;
		}
		//获取用户渠道
		Userinfo UserInfo=_userInfoService.getByUserCredential(UserName, Password);
		if(UserInfo==null){
			availableCouponsReply.SetUserCredentialInvalidReply();
			return availableCouponsReply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(CinemaCode);
		if(cinema==null){
			availableCouponsReply.SetCinemaInvalidReply();
			return availableCouponsReply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketusers=_ticketusersService.getByopenids(OpenID);
		if(ticketusers==null){
			availableCouponsReply.SetOpenIDNotExistReply();
			return availableCouponsReply;
		}
		//验证订单类型
		if(!OrderType.equals("1")&&!OrderType.equals("2")){
			availableCouponsReply.SetOrderNotExistReply();
			return availableCouponsReply;
		}
		OrderView order=null;
		Goodsorders goodsorders=null;
		//验证订单是否存在
		if(OrderType.equals("1")){
			order=_orderService.getOrderWidthLockOrderCode(CinemaCode,OrderCode);
			if(order.getOrderBaseInfo()==null){
				availableCouponsReply.SetOrderNotExistReply();
				return availableCouponsReply;
			}
			System.out.println("OrderType"+OrderType);
			System.out.println("OrderPayType"+OrderPayType);
			System.out.println("CardNo"+CardNo);
			//如果是购票订单，同时如果是会员卡支付，则重新计算折扣价，暂时更新到订单表（不保存）
			if(OrderPayType=="2"&&CardNo!=null&&!CardNo.equals("null")){
				System.out.println("=====进入");
				//如果是会员卡支付，读取折扣价，然后再看是否满足优惠券使用条件
				//region
				Userinfo userinfo=_userinfoSevice.getById(order.getOrderBaseInfo().getUserId());
				Membercard membercard=_memberCardService.getByCardNo(CinemaCode,CardNo);
				Sessioninfo session=_sessioninfoService.getBySessionCode(order.getOrderBaseInfo().getUserId(), CinemaCode,order.getOrderBaseInfo().getSessionCode());
				Screeninfo screeninfo=_screeninfoService.getByScreenCode(CinemaCode,order.getOrderBaseInfo().getScreenCode());
				List<Priceplan> priceplans=_priceplanService.getByCode(order.getOrderBaseInfo().getUserId(), CinemaCode,order.getOrderBaseInfo().getFilmCode(),order.getOrderBaseInfo().getSessionCode());
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
				String listingPrice = "0.00";
				String lowestPrice = "0.00";
				if(session.getListingPrice()!=null){
					listingPrice = new DecimalFormat("0.00").format(session.getListingPrice());
				}
				if(session.getLowestPrice()!=null){
					lowestPrice = new DecimalFormat("0.00").format(session.getLowestPrice());
				}
				SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				QueryDiscountReply discountReply=new NetSaleSvcCore().QueryDiscount(userinfo.getUserName(),userinfo.getPassword(),CinemaCode,order.getOrderBaseInfo().getTicketCount().toString(),membercard.getCardNo(),membercard.getCardPassword(),membercard.getLevelCode(),order.getOrderBaseInfo().getSessionCode(),sf.format(session.getStartTime()),order.getOrderBaseInfo().getFilmCode(),screeninfo.getType(),listingPrice,lowestPrice);
				if(discountReply.getCard().getPrice()>0){
					System.out.println("=====会员卡价格："+discountReply.getCard().getPrice());
					for(Orderseatdetails seat:order.getOrderSeatDetails()){
						//重新计算每个座位的销售价格
						seat.setSalePrice(DoubleUtil.sub(DoubleUtil.add(DoubleUtil.add(discountReply.getCard().getPrice(),seat.getFee()), seat.getAddFee()), seat.getCinemaAllowance()));
					}
					order.getOrderBaseInfo().setTotalSalePrice(order.getOrderSeatDetails().stream().mapToDouble(Orderseatdetails::getSalePrice).sum());
					System.out.println("====getTotalSalePrice"+order.getOrderBaseInfo().getTotalSalePrice());
				}else{
					for(Orderseatdetails seat:order.getOrderSeatDetails()){
						//重新计算每个座位的销售价格
						seat.setSalePrice(DoubleUtil.sub(DoubleUtil.add(DoubleUtil.add(priceplanMemberPrice, seat.getFee()), seat.getAddFee()),seat.getCinemaAllowance()));
					}
					order.getOrderBaseInfo().setTotalSalePrice(order.getOrderSeatDetails().stream().mapToDouble(Orderseatdetails::getSalePrice).sum());
				}
				//endregion
			}
		}
		if(OrderType.equals("2")){
			goodsorders=_goodsOrderService.getByLocalOrderCode(OrderCode);
			if(goodsorders==null){
				availableCouponsReply.SetOrderNotExistReply();
				return availableCouponsReply;
			}
		}
		availableCouponsReply.setData(new QueryUserAvailableCouponsReplydata());
		//region 读出用户的所有优惠券(分组列表)
		List<Coupons> UserCouponsList=_couponsService.getUserCoupons(OpenID,CouponsStatusEnum.Fetched.getStatusCode());
		StringBuilder couponsgroups=new StringBuilder();
		if(UserCouponsList!=null&&UserCouponsList.size()>0){
			for(Coupons usecoupons:UserCouponsList){
				if(!usecoupons.getCouponsCode().equals("")&&!usecoupons.getCouponsCode().equals(null)){
					CouponsView couponsview = _couponsService.getWithCouponsCode(usecoupons.getCouponsCode());
					if(couponsview.getCoupons()!=null){
						boolean ifCanUse = true;
						//优惠券状态不对
						if(couponsview.getCoupons().getStatus()!=CouponsStatusEnum.Fetched.getStatusCode()){
							ifCanUse=false;
						}
						//如果是部分门店可用，并且当前订单的影院不在可用门店里面
						if(couponsview.getCouponsgroup().getCanUseCinemaType()==2){
							if(couponsview.getCouponsgroup().getCinemaCodes().indexOf(CinemaCode)==-1){
								ifCanUse = false;
							}
						}
						if(OrderPayType.equals(String.valueOf(OrderPayTypeEnum.MemberCardPay.getTypeCode()))){
							if(couponsview.getCouponsgroup().getIsShareWithMemberCard()!=null){
								if(couponsview.getCouponsgroup().getIsShareWithMemberCard()==0){
									ifCanUse = false;//当前是会员卡支付，并且当前优惠券不能与会员卡共用
								}
							}else{
								ifCanUse = false;//当前是会员卡支付，并且当前优惠券不能与会员卡共用
							}
						}
						//如果减免类型是影片并且是购票订单，加入返回
						if(ifCanUse && couponsview.getCouponsgroup().getReductionType()==1&& OrderType.equals("1")){
							//如果是代金券并且当前订单的销售总价大于优惠券的门槛金额才可使用
							if(couponsview.getCouponsgroup().getCouponsType()==1&&couponsview.getCouponsgroup().getThresholdAmount()<=order.getOrderBaseInfo().getTotalSalePrice()){
								couponsgroups.append(couponsview.getCouponsgroup().getGroupCode()).append(",");
							}
							//如果是其他优惠券类型，分别处理
		                }
						//如果减免类型是卖品并且是卖品订单，加入返回
						if(ifCanUse && couponsview.getCouponsgroup().getReductionType()==2&& OrderType.equals("2")){
							//如果是代金券并且当前订单的总结算金额大于优惠券的门槛金额才可使用
							if(couponsview.getCouponsgroup().getCouponsType()==1&&couponsview.getCouponsgroup().getThresholdAmount()<=goodsorders.getTotalSettlePrice()){
								couponsgroups.append(couponsview.getCouponsgroup().getGroupCode()).append(",");
							}
		                }
					}
				}
			}
		}
		List<QueryUserAvailableCouponsReplyCoupons> couponslist=new ArrayList<QueryUserAvailableCouponsReplyCoupons>();
		List<Coupons> UserCanUseCouponsList=_couponsService.getUserCouponsByGroupCodes(OpenID,CouponsStatusEnum.Fetched.getStatusCode(),couponsgroups.toString());
		for(Coupons coupons:UserCanUseCouponsList){
			CouponsView couponsview = _couponsService.getWithCouponsCode(coupons.getCouponsCode());
			QueryUserAvailableCouponsReplyCoupons replyCoupons=new QueryUserAvailableCouponsReplyCoupons();
			replyCoupons.setCouponsCode(couponsview.getCoupons().getCouponsCode());
			replyCoupons.setCouponsName(couponsview.getCoupons().getCouponsName());
			replyCoupons.setCouponsType(couponsview.getCouponsgroup().getCouponsType());
			replyCoupons.setReductionPrice(couponsview.getCouponsgroup().getReductionPrice());
			couponslist.add(replyCoupons);
		}
		//endregion
		availableCouponsReply.getData().setCouponsList(couponslist);
		availableCouponsReply.SetSuccessReply();
		return availableCouponsReply;
	}
	
	public static void main(String[] args) {
		CouponsView couponsview = new CouponsView();
		Couponsgroup couponsgroup = new Couponsgroup();
		couponsgroup.setIsShareWithMemberCard(0);
		couponsview.setCouponsgroup(couponsgroup);
		System.out.println(couponsview.getCouponsgroup().getIsShareWithMemberCard()!=null);
	}
}
