package com.boot.security.server.apicontroller;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.RefundGoodsReply;
import com.boot.security.server.api.core.SubmitGoodsOrderReply;
import com.boot.security.server.apicontroller.reply.CreateGoodsOrderQueryJson;
import com.boot.security.server.apicontroller.reply.CreateGoodsOrderReply;
import com.boot.security.server.apicontroller.reply.CreateGoodsOrderReply.CreateGoodsOrderReplydata;
import com.boot.security.server.apicontroller.reply.CreateGoodsOrderReply.CreateGoodsOrderReplydata.CreateGoodsOrderReplyCoupon;
import com.boot.security.server.apicontroller.reply.CreateGoodsOrderReply.CreateGoodsOrderReplydata.CreateGoodsOrderReplyCoupon.CreateGoodsOrderReplyCoupons;
import com.boot.security.server.apicontroller.reply.CreateGoodsOrderReply.CreateGoodsOrderReplydata.CreateGoodsOrderReplyOrder;
import com.boot.security.server.apicontroller.reply.ModelMapper;
import com.boot.security.server.apicontroller.reply.NetSaleQueryJson;
import com.boot.security.server.apicontroller.reply.PrePayGoodsOrderQueryJson;
import com.boot.security.server.apicontroller.reply.PrePayGoodsOrderQueryJson.PrePayGoodsOrderQueryJsonGoods;
import com.boot.security.server.apicontroller.reply.PrePayParametersReply;
import com.boot.security.server.apicontroller.reply.QueryComponentsReply;
import com.boot.security.server.apicontroller.reply.QueryComponentsReply.ComponetsReply;
import com.boot.security.server.apicontroller.reply.QueryGoodsOrderReply;
import com.boot.security.server.apicontroller.reply.QueryGoodsOrderReply.QueryGoodsOrderReplyOrder;
import com.boot.security.server.apicontroller.reply.QueryGoodsReply;
import com.boot.security.server.apicontroller.reply.QueryGoodsReply.QueryGoodsReplyGoodss;
import com.boot.security.server.apicontroller.reply.QueryGoodsReply.QueryGoodsReplyGoodss.QueryGoodsReplyGoods;
import com.boot.security.server.apicontroller.reply.QueryGoodsTypeReply;
import com.boot.security.server.apicontroller.reply.QueryGoodsTypeReply.QueryGoodsTypeReplyTypes;
import com.boot.security.server.apicontroller.reply.QueryGoodsTypeReply.QueryGoodsTypeReplyTypes.QueryGoodsTypeReplyType;
import com.boot.security.server.apicontroller.reply.QueryLocalGoodsOrderReply.QueryLocalGoodsOrderReplyOrder;
import com.boot.security.server.apicontroller.reply.RefundPaymentReply.RefundPaymentReplyOrder;
import com.boot.security.server.apicontroller.reply.QueryLocalGoodsOrderReply;
import com.boot.security.server.apicontroller.reply.RefundPaymentReply;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.apicontroller.reply.SmsNoticeReply;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.CinemaTypeEnum;
import com.boot.security.server.model.Cinemapaymentsettings;
import com.boot.security.server.model.Cinemaview;
import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.CouponsStatusEnum;
import com.boot.security.server.model.CouponsView;
import com.boot.security.server.model.Goods;
import com.boot.security.server.model.GoodsOrderStatusEnum;
import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodscomponents;
import com.boot.security.server.model.Goodsorderdetails;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.Goodstype;
import com.boot.security.server.model.OrderPayTypeEnum;
import com.boot.security.server.model.OrderStatusEnum;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.CinemapaymentsettingsServiceImpl;
import com.boot.security.server.service.impl.CinemaviewServiceImpl;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.GoodsOrderServiceImpl;
import com.boot.security.server.service.impl.GoodsServiceImpl;
import com.boot.security.server.service.impl.GoodsTypeServiceImpl;
import com.boot.security.server.service.impl.GoodscomponentsServiceImpl;
import com.boot.security.server.service.impl.UserCinemaViewServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.boot.security.server.utils.CouponsUtil;
import com.boot.security.server.utils.FileUploadUtils;
import com.boot.security.server.utils.SendSmsHelper;
import com.boot.security.server.utils.WxPayUtil;
import com.boot.security.server.utils.XmlHelper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import freemarker.template.utility.StringUtil;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/Goods")
public class AppGoodsController {
	@Autowired
	private UserInfoServiceImpl _userInfoService;
	@Autowired
	private CinemaServiceImpl _cinemaService;
	@Autowired
	private GoodsTypeServiceImpl _goodsTypeService;
	@Autowired
	private GoodsServiceImpl _goodsService;
	@Autowired
	private GoodsOrderServiceImpl _goodsOrderService;
	@Autowired
	private UserCinemaViewServiceImpl _userCinemaViewService;
	@Autowired
	private CinemapaymentsettingsServiceImpl _cinemapaymentsettingsService;
	@Autowired
	private GoodscomponentsServiceImpl goodscomponentsService;
	@Autowired
	private CouponsServiceImpl _couponsService;
	@Autowired
	private CinemaviewServiceImpl cinemaviewService;
	@Autowired
    private HttpServletRequest request;
	
	//region 查询影院卖品信息
	@GetMapping("/QueryGoods/{UserName}/{Password}/{CinemaCode}")
	@ApiOperation(value = "查询影院卖品信息")
	public QueryGoodsReply QueryGoods(@PathVariable String UserName, @PathVariable String Password, @PathVariable String CinemaCode){
		QueryGoodsReply queryGoodsReply = new QueryGoodsReply();
		//校验参数
        if (!ReplyExtension.RequestInfoGuard(queryGoodsReply,UserName, Password, CinemaCode))
        {
            return queryGoodsReply;
        }
        //获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
        if (UserInfo == null)
        {
        	queryGoodsReply.SetUserCredentialInvalidReply();
            return queryGoodsReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	queryGoodsReply.SetCinemaInvalidReply();
            return queryGoodsReply;
        }
        List<Goods> Goodss=_goodsService.getByCinemaCode(12L,CinemaCode);
        queryGoodsReply.setData(new QueryGoodsReplyGoodss());
        if(Goodss==null||Goodss.size()==0){
        	queryGoodsReply.getData().setGoodsCount(0);
        }else{
        	queryGoodsReply.getData().setGoodsCount(Goodss.size());
        	queryGoodsReply.getData().setGoods(new ArrayList<QueryGoodsReplyGoods>());
        	for(Goods goods:Goodss){
        		QueryGoodsReplyGoods replyGoods=new QueryGoodsReplyGoods();
        		ModelMapper.MapFrom(replyGoods,goods);
        		queryGoodsReply.getData().getGoods().add(replyGoods);
        	}
        }
        queryGoodsReply.SetSuccessReply();
        return queryGoodsReply;
	}
	//endregion
	
	//region 创建卖品订单
	@PostMapping("/CreateGoodsOrder")
	@ApiOperation(value = "创建卖品订单")
	public CreateGoodsOrderReply CreateGoodsOrder(@RequestBody CreateGoodsOrderQueryJson QueryJson){
		CreateGoodsOrderReply reply=new CreateGoodsOrderReply();
		try {
			com.boot.security.server.api.core.CreateGoodsOrderReply corereply = NetSaleSvcCore.getInstance().CreateGoodsOrder(QueryJson.getUserName(), QueryJson.getPassword(), QueryJson.getQueryXml());
			if(QueryJson.getOpenID().equals(null)||QueryJson.getOpenID().equals("")){
				return reply;
			}
			//创建卖品订单时需要保存送货信息
			if(corereply.Status.equals("Success")){
				GoodsOrderView order=_goodsOrderService.getWithLocalOrderCode(corereply.getOrder().getOrderCode());
				order.getOrderBaseInfo().setOpenID(QueryJson.getOpenID());
				order.getOrderBaseInfo().setDeliveryType(QueryJson.getDeliveryType());
				order.getOrderBaseInfo().setDeliveryAddress(QueryJson.getDeliveryAddress());
				order.getOrderBaseInfo().setDeliveryTime(QueryJson.getDeliveryTime());
				order.getOrderBaseInfo().setIsReady(QueryJson.getIsReady());
				order.getOrderBaseInfo().setDeliveryMark(QueryJson.getDeliveryMark());
				_goodsOrderService.UpdateOrderBaseInfo(order.getOrderBaseInfo());
				
				reply.setData(new CreateGoodsOrderReplydata());
				//填充返回Order
				CreateGoodsOrderReplyOrder createGoodsOrderReplyOrder=new CreateGoodsOrderReplyOrder();
				createGoodsOrderReplyOrder.setOrderCode(corereply.getOrder().getOrderCode());
				createGoodsOrderReplyOrder.setOrderStatus(corereply.getOrder().getOrderStatus());
				createGoodsOrderReplyOrder.setOrderTime(corereply.getOrder().getOrderTime());
				reply.getData().setOrder(createGoodsOrderReplyOrder);
				System.out.println(new Gson().toJson(createGoodsOrderReplyOrder));
				//填充返回coupons
				CreateGoodsOrderReplyCoupon replycoupon=new CreateGoodsOrderReplyCoupon();
				List<CreateGoodsOrderReplyCoupons> coupons=new ArrayList<CreateGoodsOrderReplyCoupons>();
				//读出用户的所有优惠券
				List<Coupons> UserCouponsList=_couponsService.getUserCoupons(QueryJson.getOpenID(),CouponsStatusEnum.Fetched.getStatusCode());
				if(UserCouponsList!=null&&UserCouponsList.size()>0){
					for(Coupons usecoupons:UserCouponsList){
						if(!usecoupons.getCouponsCode().equals("")&&!usecoupons.getCouponsCode().equals(null)){
							CouponsView couponsview = _couponsService.getWithCouponsCode(usecoupons.getCouponsCode());
							if(couponsview.getCoupons()!=null){
								boolean ifCanUse=new CouponsUtil().CouponsCanUse(couponsview,order.getOrderBaseInfo().getCinemaCode());
								if(ifCanUse && couponsview.getCouponsgroup().getReductionType()==2){
									if(!couponsview.getCouponsgroup().getGoodsCodes().equals(null)&&!couponsview.getCouponsgroup().getGoodsCodes().equals("")){
										//循环判断每个卖品是不是在可使用优惠的卖品里面
										for(Goodsorderdetails goodsdetail:order.getOrderGoodsDetails()){
											if(couponsview.getCouponsgroup().getGoodsCodes().indexOf(goodsdetail.getGoodsCode())==-1){
												ifCanUse=false;
												break;
											}else{
												continue;
											}
										}
									}
									//如果到最后还是可以使用
									if(ifCanUse){
										CreateGoodsOrderReplyCoupons replyCoupons=new CreateGoodsOrderReplyCoupons();
										replyCoupons.setCouponsCode(couponsview.getCoupons().getCouponsCode());
										replyCoupons.setCouponsName(couponsview.getCoupons().getCouponsName());
										replyCoupons.setCouponsType(couponsview.getCouponsgroup().getCouponsType());
										replyCoupons.setReductionPrice(couponsview.getCouponsgroup().getReductionPrice());
										coupons.add(replyCoupons);
									}
								}
							}
						}
					}
				}
				System.out.println(new Gson().toJson(coupons));
				replycoupon.setCoupons(coupons);
				reply.getData().setCoupon(replycoupon);
				reply.SetSuccessReply();
			}
			System.out.println(new Gson().toJson(reply));
			return reply;
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			return new CreateGoodsOrderReply();
		} catch (Exception e) {
			e.printStackTrace();
			return new CreateGoodsOrderReply();
		}
		
	}
	//endregion
	
	//region 确认卖品订单
	@PostMapping("/SubmitGoodsOrder")
	@ApiOperation(value = "确认卖品订单")
	public SubmitGoodsOrderReply SubmitGoodsOrder(@RequestBody NetSaleQueryJson QueryJson){
		try {
			SubmitGoodsOrderReply reply = NetSaleSvcCore.getInstance().SubmitGoodsOrder(QueryJson.getUserName(), QueryJson.getPassword(), QueryJson.getQueryXml());
			return reply;
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			return new SubmitGoodsOrderReply();
		} catch (Exception e) {
			e.printStackTrace();
			return new SubmitGoodsOrderReply();
		}
	}
	//endregion
	
	//region 查询订单（按订单号查询已完成）
	@GetMapping("/QueryGoodsOrder/{UserName}/{Password}/{CinemaCode}/{OrderCode}")
	@ApiOperation(value = "查询卖品订单")
	public QueryGoodsOrderReply QueryGoodsOrder(@PathVariable String UserName, @PathVariable String Password, 
			@PathVariable String CinemaCode, @PathVariable String OrderCode){
		QueryGoodsOrderReply queryGoodsOrderReply = new QueryGoodsOrderReply();
		//校验参数
        if (!ReplyExtension.RequestInfoGuard(queryGoodsOrderReply,UserName, Password, CinemaCode,OrderCode))
        {
            return queryGoodsOrderReply;
        }
      //获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
        if (UserInfo == null)
        {
        	queryGoodsOrderReply.SetUserCredentialInvalidReply();
            return queryGoodsOrderReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	queryGoodsOrderReply.SetCinemaInvalidReply();
            return queryGoodsOrderReply;
        }
        //验证订单是否存在
        GoodsOrderView orders=_goodsOrderService.getWithOrderCode(CinemaCode,OrderCode);
        if(orders==null){
        	queryGoodsOrderReply.SetOrderNotExistReply();
        	return queryGoodsOrderReply;
        }else
        {
        	QueryGoodsOrderReplyOrder order=new QueryGoodsOrderReplyOrder();
        	ModelMapper.MapFrom(order,orders);
        	//二维码
    		Cinemaview cinemaview = cinemaviewService.getByCinemaCode(CinemaCode);
    		//辰星系统(取票码截取影院编码)
    		if(cinemaview.getCinemaType()==CinemaTypeEnum.ChenXing.getTypeCode()){
    			if(orders.getOrderBaseInfo().getPickUpCode()!=null){
    				order.setEwmPicture(new FileUploadUtils().generateEwm(orders.getOrderBaseInfo().getPickUpCode().substring(8,orders.getOrderBaseInfo().getPickUpCode().length())));
    			}
    		}
    		if(cinemaview.getCinemaType()==CinemaTypeEnum.DianYing1905.getTypeCode()){
    			if(orders.getOrderBaseInfo().getOrderCode()!=null){
    				order.setEwmPicture(new FileUploadUtils().generateEwm(orders.getOrderBaseInfo().getOrderCode()));
    			}
    		}
        	queryGoodsOrderReply.setData(order);
        	queryGoodsOrderReply.SetSuccessReply();
        }
        return queryGoodsOrderReply;
	}
	//endregion
	
	//region 查询订单（按本地订单号查询）
	@GetMapping("/QueryLocalGoodsOrder/{UserName}/{Password}/{CinemaCode}/{LocalOrderCode}")
	@ApiOperation(value = "查询本地卖品订单")
	public QueryLocalGoodsOrderReply QueryLocalGoodsOrder(@PathVariable String UserName, @PathVariable String Password, 
			@PathVariable String CinemaCode, @PathVariable String LocalOrderCode){
		QueryLocalGoodsOrderReply queryLocalGoodsOrderReply = new QueryLocalGoodsOrderReply();
		//校验参数
        if (!ReplyExtension.RequestInfoGuard(queryLocalGoodsOrderReply,UserName, Password, CinemaCode,LocalOrderCode))
        {
            return queryLocalGoodsOrderReply;
        }
      //获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
        if (UserInfo == null)
        {
        	queryLocalGoodsOrderReply.SetUserCredentialInvalidReply();
            return queryLocalGoodsOrderReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	queryLocalGoodsOrderReply.SetCinemaInvalidReply();
            return queryLocalGoodsOrderReply;
        }
        //验证订单是否存在
        GoodsOrderView orders=_goodsOrderService.getWithLocalOrderCode(CinemaCode, LocalOrderCode);
        if(orders==null){
        	queryLocalGoodsOrderReply.SetOrderNotExistReply();
        	return queryLocalGoodsOrderReply;
        }else
        {
        	QueryLocalGoodsOrderReplyOrder order=new QueryLocalGoodsOrderReplyOrder();
        	ModelMapper.MapFrom(order,orders);
        	//二维码
    		Cinemaview cinemaview = cinemaviewService.getByCinemaCode(CinemaCode);
    		//辰星系统(取票码截取影院编码)
    		if(cinemaview.getCinemaType()==CinemaTypeEnum.ChenXing.getTypeCode()){
    			if(orders.getOrderBaseInfo().getPickUpCode()!=null){
    				order.setEwmPicture(new FileUploadUtils().generateEwm(orders.getOrderBaseInfo().getPickUpCode().substring(8,orders.getOrderBaseInfo().getPickUpCode().length())));
    			}
    		}
    		if(cinemaview.getCinemaType()==CinemaTypeEnum.DianYing1905.getTypeCode()){
    			if(orders.getOrderBaseInfo().getOrderCode()!=null){
    				order.setEwmPicture(new FileUploadUtils().generateEwm(orders.getOrderBaseInfo().getOrderCode()));
    			}
    		}
        	queryLocalGoodsOrderReply.setData(order);
        	queryLocalGoodsOrderReply.SetSuccessReply();
        }
        return queryLocalGoodsOrderReply;
	}
	//endregion
	
	//region 退订卖品
	@GetMapping("/RefundGoods/{UserName}/{Password}/{CinemaCode}/{OrderCode}/{PaySeqNo}")
	@ApiOperation(value = "退订卖品")
	public RefundGoodsReply RefundGoods(@PathVariable String UserName, @PathVariable String Password, 
			@PathVariable String CinemaCode, @PathVariable String OrderCode,@PathVariable String PaySeqNo){
		RefundGoodsReply reply = NetSaleSvcCore.getInstance().RefundGoods(UserName, Password, CinemaCode, OrderCode, PaySeqNo);
		
		return reply;
	}
	//endregion
	
	//region 查询卖品类型
	@GetMapping("/QueryGoodsType/{UserName}/{Password}/{CinemaCode}")
	@ApiOperation(value = "查询卖品类型")
	public QueryGoodsTypeReply QueryGoodsType(@PathVariable String UserName, @PathVariable String Password, 
			@PathVariable String CinemaCode){
		QueryGoodsTypeReply queryGoodsTypeReply=new QueryGoodsTypeReply();
		//校验参数
        if (!ReplyExtension.RequestInfoGuard(queryGoodsTypeReply,UserName, Password, CinemaCode))
        {
            return queryGoodsTypeReply;
        }
      //获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
        if (UserInfo == null)
        {
        	queryGoodsTypeReply.SetUserCredentialInvalidReply();
            return queryGoodsTypeReply;
        }
      //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	queryGoodsTypeReply.SetCinemaInvalidReply();
            return queryGoodsTypeReply;
        }
        List<Goodstype> goodsTypes=_goodsTypeService.getByCinemaCode(CinemaCode);
        queryGoodsTypeReply.setData(new QueryGoodsTypeReplyTypes());
        if(goodsTypes==null||goodsTypes.size()==0){
        	queryGoodsTypeReply.getData().setTypeCount(0);
        }else{
        	queryGoodsTypeReply.getData().setTypeCount(goodsTypes.size());
        	queryGoodsTypeReply.getData().setType(new ArrayList<QueryGoodsTypeReplyType>());
        	for(Goodstype goodstype:goodsTypes){
        		QueryGoodsTypeReplyType replyType=new QueryGoodsTypeReplyType();
        		ModelMapper.MapFrom(replyType,goodstype);
        		queryGoodsTypeReply.getData().getType().add(replyType);
        	}
        }
        queryGoodsTypeReply.SetSuccessReply();
        return queryGoodsTypeReply;
	}
	//endregion
	
	//region 查询推荐套餐
	@GetMapping("/QueryComponents/{username}/{password}/{cinemaCode}/{seatNum}")
	@ApiOperation(value = "查询推荐套餐")
	public QueryComponentsReply QueryComponents(@PathVariable String username, @PathVariable String password, 
			@PathVariable String cinemaCode, @PathVariable String seatNum){
		QueryComponentsReply reply=new QueryComponentsReply();
		//校验参数
        if (!ReplyExtension.RequestInfoGuard(reply,username, password, cinemaCode, seatNum)) {
            return reply;
        }
        //获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(username, password);
        if (UserInfo == null) {
        	reply.SetUserCredentialInvalidReply();
            return reply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(cinemaCode);
        if (cinema == null) {
        	reply.SetCinemaInvalidReply();
            return reply;
        }
        
        //返回
        List<ComponetsReply> data = new ArrayList<ComponetsReply>();
        if(Integer.valueOf(seatNum)>3){
        	seatNum = "3";
        }
        List<Goodscomponents> componentslist = goodscomponentsService.getByRecommendCode(cinemaCode, seatNum);
        for(Goodscomponents component : componentslist){
        	ComponetsReply newComponent = new ComponetsReply();
        	newComponent.setPackageCode(component.getPackageCode());
        	newComponent.setPackageName(component.getPackageName());
        	newComponent.setPackagePic(component.getPackagePic());
        	newComponent.setPackageStandarPrice(component.getPackageStandardPrice());
        	newComponent.setPackageSettlePrice(component.getPackageSettlePrice());
        	data.add(newComponent);
        }
        reply.setData(data);
        reply.SetSuccessReply();
        
        return reply;
	}
	//endregion
	
	//region 微信预支付卖品订单（准备微信支付参数）
	@RequestMapping(value="/PrePayGoodsOrder",method = RequestMethod.POST)
	@ApiOperation(value = "预支付订单")
	public PrePayParametersReply PrePayGoodsOrder(@RequestBody PrePayGoodsOrderQueryJson QueryJson) throws IOException{
		PrePayParametersReply prePayParametersReply=new PrePayParametersReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard2(prePayParametersReply, QueryJson.getUserName(), QueryJson.getPassword(), QueryJson.getCinemaCode(), QueryJson.getOrderCode(), QueryJson.getGoodsList())) {
			return prePayParametersReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(QueryJson.getUserName(), QueryJson.getPassword());
		if (UserInfo == null) {
			prePayParametersReply.SetUserCredentialInvalidReply();
			return prePayParametersReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),QueryJson.getCinemaCode());
		if (userCinema == null) {
			prePayParametersReply.SetCinemaInvalidReply();
			return prePayParametersReply;
		}
		// 获取影院的支付配置
		Cinemapaymentsettings cinemapaymentsettings = _cinemapaymentsettingsService
				.getByCinemaCode(QueryJson.getCinemaCode());
		if (cinemapaymentsettings == null || cinemapaymentsettings.getWxpayAppId().isEmpty()
				|| cinemapaymentsettings.getWxpayMchId().isEmpty()) {
			prePayParametersReply.SetCinemaPaySettingInvalidReply();
			return prePayParametersReply;
		}
		// 验证订单是否存在
		GoodsOrderView order = _goodsOrderService.getWithLocalOrderCode(QueryJson.getCinemaCode(),QueryJson.getOrderCode());
		if (order == null || (order.getOrderBaseInfo().getOrderStatus() != GoodsOrderStatusEnum.Created.getStatusCode()
				&& order.getOrderBaseInfo().getOrderStatus() != GoodsOrderStatusEnum.PayFail.getStatusCode())) {
			prePayParametersReply.SetOrderNotExistReply();
			return prePayParametersReply;
		}
		// 验证卖品数量
		int GoodsCount=QueryJson.getGoodsList().stream().mapToInt(PrePayGoodsOrderQueryJsonGoods::getGoodsCount).sum();
		if (GoodsCount != order.getOrderBaseInfo().getGoodsCount()) {
			prePayParametersReply.SetGoodsCountInvalidReply();
			return prePayParametersReply;
		}
		// 验证优惠券是否使用
		if (null!=QueryJson.getCouponsCode()&&""!=QueryJson.getCouponsCode()) {
			Coupons coupons = _couponsService.getByCouponsCode(QueryJson.getCouponsCode());
			if (coupons.getStatus() != CouponsStatusEnum.Fetched.getStatusCode())// 不是已领取状态
			{
				prePayParametersReply.SetCouponsNotExistOrUsedReply();
				return prePayParametersReply;
			}
		}
		//得到优惠券组
		String CouponsCodes=QueryJson.getCouponsCode();
		//更新优惠券价格
		Map<String,Double> map=new CouponsUtil().getCouponsPrice(QueryJson.getCinemaCode(),"",QueryJson.getOrderCode(), CouponsCodes);
		//region 准备支付参数
		//总支付金额=总结算金额-优惠金额
		Double TotalPrice;
		if(order.getOrderBaseInfo().getCouponsPrice()!=null){
			TotalPrice = order.getOrderBaseInfo().getTotalSettlePrice()-order.getOrderBaseInfo().getCouponsPrice();
		}else{
			TotalPrice = order.getOrderBaseInfo().getTotalSettlePrice();
		}
		Calendar cal=Calendar.getInstance();
		String WxpayAppId = cinemapaymentsettings.getWxpayAppId();
		String strbody = cinemapaymentsettings.getCinemaName() + "-"
				+ StringUtil.leftPad(String.valueOf(cal.get(Calendar.MONTH)+1), 2, "0")
				+ "月" + StringUtil.leftPad(String.valueOf(cal.get(Calendar.DATE)), 2, "0")
				+ "日" + new SimpleDateFormat("HH:mm").format(new Date()) + " "
				+ "卖品订单总额（" + TotalPrice + "元）";
		String WxpayMchId = cinemapaymentsettings.getWxpayMchId();
		String WxpayKey = cinemapaymentsettings.getWxpayKey();
		String NotifyUrl = "https://xc.80piao.com:8443/Api/Goods/WxPayNotify";// 暂时
		String OpenId = order.getOrderBaseInfo().getOpenID();
		String TradeNo = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + QueryJson.getCinemaCode()
				+ order.getOrderBaseInfo().getId();
		String ExpireDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(new Date() .getTime() + 900000));
		String TotalFee = String.valueOf(Double.valueOf(TotalPrice*100).intValue());// 商品金额，以分为单位
		//endregion
		return WxPayUtil.WxPayPrePay(request, prePayParametersReply, WxpayAppId, WxpayMchId, WxpayKey, strbody,
				NotifyUrl, OpenId, TradeNo, ExpireDate, TotalFee);
	}
	// endregion
	
	//region 异步接收微信支付返回
	@RequestMapping(value = "/WxPayNotify", produces = "application/json;charset=UTF-8")
	// @RequestDescription("支付回调地址")
	@ResponseBody
	public void WxPayNotify(HttpServletRequest request) throws Exception {
		// 读取返回内容
		Map<String, String> returnmap = WxPayUtil.WxPayNotify(request);
		if (returnmap.get("isWXsign").equals("True")) {
			// 得到订单Id
			Long OrderID = Long.parseLong(returnmap.get("out_trade_no").substring("yyyyMMddHHmmss".length() + 8));
			Goodsorders order = _goodsOrderService.getById(OrderID);
			if (returnmap.get("return_code").equals("SUCCESS") && returnmap.get("result_code").equals("SUCCESS")) {
				// 更新订单主表
				if(order.getOrderPayFlag()==null){
					order.setOrderPayFlag(0);
				}
				if (order.getOrderPayFlag()==0) {
					order.setOrderStatus(GoodsOrderStatusEnum.Payed.getStatusCode());
					order.setUpdated(new Date());
					order.setOrderPayType(OrderPayTypeEnum.WxPay.getTypeCode());
					order.setOrderPayFlag(1);
					order.setOrderPayTime(new Date());
					order.setOrderTradeNo(returnmap.get("transaction_id"));
					_goodsOrderService.UpdateOrderBaseInfo(order);
				}
				// 更新优惠券已使用
				if (!order.getCouponsCode().equals(null)&&!order.getCouponsCode().equals("")) {
					CouponsView couponsview=_couponsService.getWithCouponsCode(order.getCouponsCode());
					if(couponsview!=null){
						couponsview.getCoupons().setStatus(CouponsStatusEnum.Used.getStatusCode());
						couponsview.getCoupons().setUsedDate(new Date());
						//使用数量+1
						couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()+1);
						//更新优惠券及优惠券分组表
						_couponsService.update(couponsview);
					}
				}
			} else {
				order.setOrderStatus(OrderStatusEnum.PayFail.getStatusCode());
				order.setUpdated(new Date());
				order.setErrorMessage(returnmap.get("err_code_des"));
				_goodsOrderService.UpdateOrderBaseInfo(order);
			}
		}
	}
	//endregion
	
	//region 卖品备餐通知
	@GetMapping("/SmsNotice/{UserName}/{Password}/{CinemaCode}/{OrderCode}")
	@ApiOperation(value = "卖品备餐通知")
	public SmsNoticeReply SmsNotice(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,@PathVariable String OrderCode){
		SmsNoticeReply smsNoticeReply=new SmsNoticeReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(smsNoticeReply, UserName, Password, CinemaCode, OrderCode)) {
			return smsNoticeReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			smsNoticeReply.SetUserCredentialInvalidReply();
			return smsNoticeReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
		if (userCinema == null) {
			smsNoticeReply.SetCinemaInvalidReply();
			return smsNoticeReply;
		}
		//验证订单是否存在
		Goodsorders order=_goodsOrderService.getByOrderCode(OrderCode);
		if(order==null){
			smsNoticeReply.SetOrderNotExistReply();
			return smsNoticeReply;
		}
		String MsgConetnt="您的卖品已送到影厅门口，请及时领取。";
		String SendResult = new SendSmsHelper().SendSms(order.getCinemaCode(),order.getMobilePhone(), MsgConetnt);
		if(SendResult.equals("Success")){
			smsNoticeReply.SetSuccessReply();
		}
		return smsNoticeReply;
	}
	//endregion
	
	//region 卖品订单退款
	@GetMapping("/RefundPayment/{UserName}/{Password}/{CinemaCode}/{LocalOrderCode}")
	@ApiOperation(value = "退款")
	public RefundPaymentReply RefundPayment(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String LocalOrderCode) throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException, IOException{
		RefundPaymentReply refundpaymentReply=new RefundPaymentReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard2(refundpaymentReply, UserName, Password, CinemaCode, LocalOrderCode)) {
			return refundpaymentReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			refundpaymentReply.SetUserCredentialInvalidReply();
			return refundpaymentReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
		if (userCinema == null) {
			refundpaymentReply.SetCinemaInvalidReply();
			return refundpaymentReply;
		}
		// 获取影院的支付配置
		Cinemapaymentsettings cinemapaymentsettings = _cinemapaymentsettingsService
				.getByCinemaCode(CinemaCode);
		if (cinemapaymentsettings == null || cinemapaymentsettings.getWxpayAppId().isEmpty()
				|| cinemapaymentsettings.getWxpayMchId().isEmpty()) {
			refundpaymentReply.SetCinemaPaySettingInvalidReply();
			return refundpaymentReply;
		}
		//验证订单是否存在
		Goodsorders order=_goodsOrderService.getByLocalOrderCode(LocalOrderCode);
		if(order==null){
			refundpaymentReply.SetOrderNotExistReply();
			return refundpaymentReply;
		}else{
			//如果订单存在，开始退款
			String WxpayAppId = cinemapaymentsettings.getWxpayAppId();
			String WxpayMchId=cinemapaymentsettings.getWxpayMchId();
			String WxpayKey=cinemapaymentsettings.getWxpayKey();
			String TradeNo=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + CinemaCode
			+ order.getId();
			Double RefundPrice = order.getTotalSettlePrice()+order.getTotalFee();// 结算价+服务费
			String RefundFee = String.valueOf(Double.valueOf(RefundPrice*100).intValue());// 退款金额，以分为单位
			String OrderTradeNo=order.getOrderTradeNo();//微信支付订单号
			String WxpayRefundCert=cinemapaymentsettings.getWxpayRefundCert();
			
			String strRefundPaymentXml = WxPayUtil.WxPayRefund(WxpayAppId,WxpayMchId,WxpayKey,TradeNo,RefundFee,OrderTradeNo,CinemaCode,WxpayRefundCert);
			//获取返回值 
			String strRefundPaymentXml2 = strRefundPaymentXml.replace("<![CDATA[", "").replace("]]>", "");
			Document document = XmlHelper.StringTOXml(strRefundPaymentXml2);
			String resultcodeValue = XmlHelper.getNodeValue(document, "/xml/result_code");
			String refundidValue=XmlHelper.getNodeValue(document,"/xml/refund_id");
			if (resultcodeValue.equals("SUCCESS")) {
				//更新卖品订单
				order.setOrderStatus(GoodsOrderStatusEnum.PayBack.getStatusCode());
				order.setRefundTradeNo(refundidValue);
				order.setRefundTime(new Date());
				_goodsOrderService.update(order);
				//退优惠券
				if(!order.getCouponsCode().equals(null)&&!order.getCouponsCode().equals("")){
					CouponsView couponsview = _couponsService.getWithCouponsCode(order.getCouponsCode());
					if(couponsview!=null){
						couponsview.getCoupons().setStatus(CouponsStatusEnum.Fetched.getStatusCode());
						couponsview.getCoupons().setUsedDate(null);
						//使用数量-1
						couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()-1);
						//更新优惠券及优惠券分组表
						_couponsService.update(couponsview);
					}
				}
				//准备返回参数
				refundpaymentReply.setData(new RefundPaymentReplyOrder());
				refundpaymentReply.getData().setOrderCode(order.getLocalOrderCode());
				refundpaymentReply.getData().setOrderStatus(GoodsOrderStatusEnum.CastToEnum(order.getOrderStatus()).getStatusName());
				refundpaymentReply.getData().setRefundTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				refundpaymentReply.getData().setRefundTradeNo(refundidValue);
				refundpaymentReply.SetSuccessReply();
			}else{
				refundpaymentReply.Status = "Failure";
				refundpaymentReply.ErrorCode = resultcodeValue;
			}
		}
		return refundpaymentReply;
	}
	
	//endregion
	
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int weekday = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(weekday);
	}
}
