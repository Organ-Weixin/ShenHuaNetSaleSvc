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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.apicontroller.reply.BindCouponsReply;
import com.boot.security.server.apicontroller.reply.ModelMapper;
import com.boot.security.server.apicontroller.reply.QueryUserAvailableCouponsReply;
import com.boot.security.server.apicontroller.reply.QueryUserConponsReply;
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
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Goods;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.OrderPayTypeEnum;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.CouponsgroupServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.GoodsOrderServiceImpl;
import com.boot.security.server.service.impl.GoodsServiceImpl;
import com.boot.security.server.service.impl.OrderServiceImpl;
import com.boot.security.server.service.impl.TicketusersServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.google.gson.Gson;
import com.boot.security.server.apicontroller.reply.QueryUserConponsReply.QueryUserConponsBeans;
import com.boot.security.server.apicontroller.reply.BindCouponsReply.BindCouponsReplyBind;
import com.boot.security.server.apicontroller.reply.QueryUserAvailableCouponsReply.QueryUserAvailableCouponsReplydata;
import com.boot.security.server.apicontroller.reply.QueryUserAvailableCouponsReply.QueryUserAvailableCouponsReplydata.QueryUserAvailableCouponsReplyCoupons;

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
	private FilminfoServiceImpl _filminfoService;
	@Autowired
	private GoodsServiceImpl _goodsService;
	@Autowired
	private OrderServiceImpl _orderService;
	@Autowired
	private GoodsOrderServiceImpl _goodsOrderService;
	
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
				Couponsgroup cou = _couponsgroupService.getByCinemaCodeAndGroupCode(cinema.getCode(),
						coupon.getGroupCode());
						if (cou != null) {
							sum++;
							queryUserConponsBean.setCinemaCode(cou.getCinemaCodes());
							queryUserConponsBean.setRemark(cou.getRemark());
							queryUserConponsBean.setPrice(cou.getReductionPrice());
							queryUserConponsBean.setCouonsType(cou.getCouponsType());
							queryUserConponsBean.setTitle(cou.getCouponsName());
							queryUserConponsBean.setCanUseCinemaType(cou.getCanUseCinemaType());
							queryUserConponsBean.setInitialAmount(cou.getThresholdAmount());//门槛金额
							// 获取可用影院名称
							String cinemacodeList[] = cou.getCinemaCodes().split(",");
							String cinemaname = "";
							for (int j = 0; j < cinemacodeList.length; j++) {
								Cinema cine = _cinemaService.getByCinemaCode(cinemacodeList[j]);
								if (cine != null) {
									cinemaname += cine.getName() + ",";
								}
							}
							if (cinemaname.length() > 0) {
								queryUserConponsBean.setCinemaName(cinemaname.substring(0, cinemaname.length() - 1));
							}
							queryUserConponsBean.setReductionType(cou.getReductionType());
							queryUserConponsBean.setIsShare(cou.getIsShare());
							queryUserConponsBeanss.add(queryUserConponsBean);
						}
					data.setConponCount(sum);
			}
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
	
	@GetMapping("/QueryUserAvailableCoupons/{UserName}/{Password}/{CinemaCode}/{OpenID}/{OrderType}/{OrderPayType}/{OrderCode}")
	@ApiOperation(value = "获取当前可用优惠券")
	public QueryUserAvailableCouponsReply QueryUserAvailableCoupons(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,@PathVariable String OpenID,
			@PathVariable String OrderType,@PathVariable String OrderPayType,@PathVariable String OrderCode) throws ParseException{
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
		Orders orders=null;
		Goodsorders goodsorders=null;
		//验证订单是否存在
		if(OrderType.equals("1")){
			orders=_orderService.getByLockOrderCode(CinemaCode,OrderCode);
			if(orders==null){
				availableCouponsReply.SetOrderNotExistReply();
				return availableCouponsReply;
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
							if(couponsview.getCouponsgroup().getCouponsType()==1&&couponsview.getCouponsgroup().getThresholdAmount()<=orders.getTotalSalePrice()){
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
}
