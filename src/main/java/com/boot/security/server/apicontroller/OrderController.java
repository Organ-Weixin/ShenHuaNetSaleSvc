package com.boot.security.server.apicontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

import com.boot.security.server.api.core.LockSeatReply;
import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.QueryOrderReply;
import com.boot.security.server.api.core.QueryPrintReply;
import com.boot.security.server.api.core.QueryTicketReply;
import com.boot.security.server.api.core.RefundTicketReply;
import com.boot.security.server.api.core.ReleaseSeatReply;
import com.boot.security.server.api.core.SubmitMixOrderReply;
import com.boot.security.server.api.core.SubmitOrderReply;
import com.boot.security.server.apicontroller.reply.ModelMapper;
import com.boot.security.server.apicontroller.reply.NetSaleQueryJson;
import com.boot.security.server.apicontroller.reply.PrePayMixOrderQueryJson;
import com.boot.security.server.apicontroller.reply.PrePayMixOrderQueryJson.PrePayMixOrderQueryJsonGoods;
import com.boot.security.server.apicontroller.reply.PrePayMixOrderQueryJson.PrePayMixOrderQueryJsonSeat;
import com.boot.security.server.apicontroller.reply.PrePayOrderQueryJson;
import com.boot.security.server.apicontroller.reply.PrePayOrderQueryJson.PrePayOrderQueryJsonSeat;
import com.boot.security.server.apicontroller.reply.PrePayParametersReply;
import com.boot.security.server.apicontroller.reply.PrePayParametersReply.PrePayParametersReplyParameter;
import com.boot.security.server.apicontroller.reply.QueryLocalOrderReply;
import com.boot.security.server.apicontroller.reply.QueryLocalOrderReply.QueryLocalOrder;
import com.boot.security.server.apicontroller.reply.QueryLocalOrderReply.QueryLocalOrder.Seats;
import com.boot.security.server.apicontroller.reply.QueryNonPayOrdersReply;
import com.boot.security.server.apicontroller.reply.QueryNonPayOrdersReply.NonPayOrders;
import com.boot.security.server.apicontroller.reply.QueryNonPayOrdersReply.NonPayOrders.NonPayOrder;
import com.boot.security.server.apicontroller.reply.QueryUserOrdersReply;
import com.boot.security.server.apicontroller.reply.RefundPaymentReply;
import com.boot.security.server.apicontroller.reply.QueryUserOrdersReply.UserOrders;
import com.boot.security.server.apicontroller.reply.QueryUserOrdersReply.UserOrders.OrderList;
import com.boot.security.server.apicontroller.reply.RefundPaymentReply.RefundPaymentReplyOrder;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.apicontroller.reply.PrePayGoodsOrderQueryJson.PrePayGoodsOrderQueryJsonGoods;
import com.boot.security.server.model.Cinemapaymentsettings;
import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.CouponsStatusEnum;
import com.boot.security.server.model.CouponsView;
import com.boot.security.server.model.GoodsOrderStatusEnum;
import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodsorderdetails;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.OrderPayTypeEnum;
import com.boot.security.server.model.OrderStatusEnum;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Priceplan;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemapaymentsettingsServiceImpl;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.GoodsOrderServiceImpl;
import com.boot.security.server.service.impl.OrderServiceImpl;
import com.boot.security.server.service.impl.PriceplanServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.service.impl.TicketusersServiceImpl;
import com.boot.security.server.service.impl.UserCinemaViewServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.boot.security.server.utils.HttpHelper;
import com.boot.security.server.utils.MD5Util;
import com.boot.security.server.utils.StrUtil;
import com.boot.security.server.utils.WxPayUtil;
import com.boot.security.server.utils.XmlHelper;
import com.google.gson.JsonSyntaxException;

import freemarker.template.utility.StringUtil;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/Order")
public class OrderController {
	@Autowired
	private UserInfoServiceImpl _userInfoService;
	@Autowired
	private UserCinemaViewServiceImpl _userCinemaViewService;
	@Autowired
	private ScreeninfoServiceImpl _screeninfoService;
	@Autowired
	private OrderServiceImpl _orderService;
	@Autowired
	CinemapaymentsettingsServiceImpl _cinemapaymentsettingsService;
	@Autowired
	CouponsServiceImpl _couponsService;
	@Autowired
	SessioninfoServiceImpl _sessioninfoService;
	@Autowired
	PriceplanServiceImpl _priceplanService;
	@Autowired
	TicketusersServiceImpl _ticketUserService;
	@Autowired
	private GoodsOrderServiceImpl _goodsOrderService;
	@Autowired
	private HttpServletRequest request;

	// region 锁座
	// @PostMapping("/LockSeat")
	@RequestMapping(value = "/LockSeat", method = RequestMethod.POST)
	@ApiOperation(value = "锁座")
	public LockSeatReply LockSeat(@RequestBody NetSaleQueryJson QueryJson){
		try {
			LockSeatReply lockSeatReply =NetSaleSvcCore.getInstance().LockSeat(QueryJson.getUserName(),QueryJson.getPassword(),QueryJson.getQueryXml());
			//锁座时新增订单需要传入OpenID,之后修改订单就不需要再操作
			if(lockSeatReply.Status.equals("Success")){
				Orders orderbase=_orderService.getOrderBaseByLockOrderCode(lockSeatReply.getOrder().getOrderCode());
				orderbase.setOpenID(QueryJson.getOpenID());
				_orderService.UpdateOrderBaseInfo(orderbase);
			}
			
			return lockSeatReply;
		} catch (JsonSyntaxException e) {
			
			return new LockSeatReply();
		} catch (Exception e) {
			
			return new LockSeatReply();
		}
	}
	//endregion
	
	//region 解锁座位
	@PostMapping("/ReleaseSeat")
	@ApiOperation(value = "解锁座位")
	public ReleaseSeatReply ReleaseSeat(@RequestBody NetSaleQueryJson QueryJson){
		try {
			ReleaseSeatReply releaseSeatReply = NetSaleSvcCore.getInstance().ReleaseSeat(QueryJson.getUserName(), QueryJson.getPassword(), QueryJson.getQueryXml());
//			System.out.println("解锁成功+++++"+new Gson().toJson(releaseSeatReply));
			return releaseSeatReply;
		} catch (Exception e) {
			e.printStackTrace();
			return new ReleaseSeatReply();
		}
	}
	//endregion
	
	//region 提交订单
	@PostMapping("/SubmitOrder")
	@ApiOperation(value = "提交订单")
	public SubmitOrderReply SubmitOrder(@RequestBody NetSaleQueryJson QueryJson){
		try {
			SubmitOrderReply submitOrderReply = NetSaleSvcCore.getInstance().SubmitOrder(QueryJson.getUserName(), QueryJson.getPassword(), QueryJson.getQueryXml());
//			System.out.println("提交成功+++++"+new Gson().toJson(submitOrderReply));
			return submitOrderReply;
		} catch (Exception e) {
			e.printStackTrace();
			return new SubmitOrderReply();
		}
	}
	//endregion
	
	//region 提交混合订单(票 + 卖品)
	@PostMapping("/SubmitMixOrder")
	@ApiOperation(value = "提交混合订单")
	public SubmitMixOrderReply SubmitMixOrder(@RequestBody NetSaleQueryJson QueryJson){
		try {
			SubmitMixOrderReply reply = NetSaleSvcCore.getInstance().SubmitMixOrder(QueryJson.getUserName(), QueryJson.getPassword(), QueryJson.getQueryXml());

			return reply;
		} catch (Exception e) {
			e.printStackTrace();
			return new SubmitMixOrderReply();
		}
	}
	//endregion
		
	//region 查询订单
	@GetMapping("/QueryOrder/{UserName}/{Password}/{CinemaCode}/{OrderCode}")
	@ApiOperation(value = "查询订单")
	public QueryOrderReply QueryOrder(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OrderCode){
		QueryOrderReply orderReply = NetSaleSvcCore.getInstance().QueryOrder(UserName, Password, CinemaCode, OrderCode);
//		System.out.println("查询订单----"+new Gson().toJson(orderReply));
		return orderReply;
	}
	//endregion
	
	//region 查询本地订单
	@GetMapping("/QueryLocalOrder/{UserName}/{Password}/{CinemaCode}/{LockOrderCode}")
	@ApiOperation(value = "查询本地订单")
	public QueryLocalOrderReply QueryLocalOrder(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String LockOrderCode){
		QueryLocalOrderReply orderReply = new QueryLocalOrderReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(orderReply, UserName, Password, CinemaCode, LockOrderCode)) {
			return orderReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			orderReply.SetUserCredentialInvalidReply();
			return orderReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
		if (userCinema == null) {
			orderReply.SetCinemaInvalidReply();
			return orderReply;
		}
		// 验证订单是否存在
		OrderView order = _orderService.getOrderWidthLockOrderCode(CinemaCode, LockOrderCode);
		if (order == null) {
			orderReply.SetOrderNotExistReply();
			return orderReply;
		} else {
			QueryLocalOrder orderResult = new QueryLocalOrder();
			orderResult.setOrderId(order.getOrderBaseInfo().getId());
			orderResult.setCinemaCode(order.getOrderBaseInfo().getCinemaCode()); 
			orderResult.setSessionCode(order.getOrderBaseInfo().getSessionCode());
			orderResult.setFilmCode(order.getOrderBaseInfo().getFilmCode());
			orderResult.setTicketCount(order.getOrderBaseInfo().getTicketCount());
			orderResult.setTotalPrice(order.getOrderBaseInfo().getTotalPrice());
			orderResult.setTotalFee(order.getOrderBaseInfo().getTotalFee());
			orderResult.setTotalSalePrice(order.getOrderBaseInfo().getTotalSalePrice());
			orderResult.setMobilePhone(order.getOrderBaseInfo().getMobilePhone());
			orderResult.setLockTime(order.getOrderBaseInfo().getLockTime()==null?"":new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderBaseInfo().getLockTime()));
			orderResult.setAutoUnlockDatetime(order.getOrderBaseInfo().getAutoUnlockDatetime()==null?"":new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderBaseInfo().getAutoUnlockDatetime()));
			orderResult.setLockOrderCode(order.getOrderBaseInfo().getLockOrderCode());
			orderResult.setCreated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderBaseInfo().getCreated()));
			orderResult.setTotalLoveSeatDifferences(order.getOrderBaseInfo().getTotalLoveSeatDifferences());
			orderResult.setFeePayType(order.getOrderBaseInfo().getFeePayType()==null?"":order.getOrderBaseInfo().getFeePayType().toString());
			orderResult.setTotalGuestPayFee(order.getOrderBaseInfo().getTotalGuestPayFee());
			orderResult.setTotalConponPrice(order.getOrderBaseInfo().getTotalConponPrice());
			orderResult.setOpenID(order.getOrderBaseInfo().getOpenID());
			
			List<Seats> seats = new ArrayList<Seats>();	//座位信息
			for(Orderseatdetails orderseat : order.getOrderSeatDetails()){
				Seats seatinfo = new Seats();
				seatinfo.setSeatCode(orderseat.getSeatCode());
				seatinfo.setRowNum(orderseat.getRowNum());
				seatinfo.setColumnNum(orderseat.getColumnNum());
				seatinfo.setPrice(orderseat.getPrice());
				seatinfo.setSalePrice(orderseat.getSalePrice());
				seatinfo.setFee(orderseat.getFee());
				seatinfo.setConponCode(orderseat.getConponCode());
				seatinfo.setConponPrice(orderseat.getConponPrice());
				seats.add(seatinfo);
			}
			orderResult.setSeats(seats);
			
			orderReply.setData(orderResult);
			orderReply.SetSuccessReply();
		}
		return orderReply;
	}
	//endregion
	
	//region 查询未支付订单
	@GetMapping("/QueryNonPayOrders/{UserName}/{Password}/{CinemaCode}/{OpenID}")
	@ApiOperation(value = "用户未支付订单列表")
	public QueryNonPayOrdersReply QueryNonPayOrders(@PathVariable String UserName, @PathVariable String Password, @PathVariable String CinemaCode, @PathVariable String OpenID,
			@PathVariable String startDate, @PathVariable String endDate, @PathVariable String CurrentPage, @PathVariable String PageSize) throws Exception {
		
		QueryNonPayOrdersReply reply = new QueryNonPayOrdersReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(reply, UserName, Password, CinemaCode, OpenID)) {
			return reply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
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
		// 验证用户是否存在
		Ticketusers ticketUser=_ticketUserService.getByopenids(OpenID);
		if(ticketUser==null){
			reply.SetOpenIDNotExistReply();
			return reply;
		}
		List<Orders> orderlist = _orderService.getNonPayOrders(UserInfo.getId(),CinemaCode,OpenID);
		NonPayOrders nonPayOrders = new NonPayOrders();
		if(orderlist == null || orderlist.size()==0){
			nonPayOrders.setOrderCount(0);
		} else {
			nonPayOrders.setOrderCount(orderlist.size());
			List<NonPayOrder> orderinfoList = new ArrayList<NonPayOrder>();
			for(Orders order : orderlist){
				NonPayOrder orderinfo = new NonPayOrder();
				orderinfo.setOrderId(order.getId());
				orderinfo.setCinemaCode(order.getCinemaCode());
				orderinfo.setSessionCode(order.getSessionCode());
				orderinfo.setScreenCode(order.getScreenCode());
				
				Screeninfo screeninfo = _screeninfoService.getByScreenCode(order.getCinemaCode(),order.getScreenCode());	
				orderinfo.setScreenName(screeninfo==null?"":screeninfo.getSName());
				orderinfo.setSessionTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getSessionTime()));
				orderinfo.setFilmCode(order.getFilmCode());
				orderinfo.setFilmName(order.getFilmName());
				orderinfo.setTicketCount(order.getTicketCount());
				orderinfo.setTotalPrice(order.getTotalPrice());
				orderinfo.setTotalFee(order.getTotalFee());
				orderinfo.setTotalSalePrice(order.getTotalSalePrice());
				orderinfo.setOrderStatus(OrderStatusEnum.CastToEnum(order.getOrderStatus()).getStatusName());
				orderinfo.setMobilePhone(order.getMobilePhone());
				orderinfo.setLockTime(order.getLockTime()==null?"":new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getLockTime()));
				orderinfo.setAutoUnlockDatetime(order.getAutoUnlockDatetime()==null?"":new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getAutoUnlockDatetime()));
				orderinfo.setLockOrderCode(order.getLockOrderCode());
				
				orderinfoList.add(orderinfo);
			}
			nonPayOrders.setOrders(orderinfoList);
		}
		reply.setData(nonPayOrders);
		reply.SetSuccessReply();
		return reply;
	}
	//endregion
	
	//region 查询影票信息
	@GetMapping("/QueryTicket/{UserName}/{Password}/{CinemaCode}/{PrintNo}/{VerifyCode}")
	@ApiOperation(value = "查询影票信息")
	public QueryTicketReply QueryTicket(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String PrintNo,@PathVariable String VerifyCode){
		QueryTicketReply reply = NetSaleSvcCore.getInstance().QueryTicket(UserName, Password, CinemaCode, PrintNo, VerifyCode);
//		System.out.println("查询影片----"+new Gson().toJson(reply));
		return reply;
	}
	//endregion
	
	//region 查询出票状态
	@GetMapping("/QueryPrint/{UserName}/{Password}/{CinemaCode}/{PrintNo}/{VerifyCode}")
	@ApiOperation(value = "查询出票状态")
	public QueryPrintReply QueryPrint(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String PrintNo,@PathVariable String VerifyCode){
		QueryPrintReply reply = NetSaleSvcCore.getInstance().QueryPrint(UserName, Password, CinemaCode, PrintNo, VerifyCode);
//		System.out.println("查询出票状态----"+new Gson().toJson(reply));
		return reply;
	}
	//endregion
	
	//region 退票
	@GetMapping("/RefundTicket/{UserName}/{Password}/{CinemaCode}/{PrintNo}/{VerifyCode}")
	@ApiOperation(value = "退票")
	public RefundTicketReply RefundTicket(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String PrintNo,@PathVariable String VerifyCode){
		RefundTicketReply reply = NetSaleSvcCore.getInstance().RefundTicket(UserName, Password, CinemaCode, PrintNo, VerifyCode);
//		System.out.println("退票----"+new Gson().toJson(reply));
		return reply;
	}
	//endregion
	
	//region 用户购票订单列表
	@GetMapping("/QueryUserOrders/{UserName}/{Password}/{CinemaCode}/{OpenID}/{startDate}/{endDate}/{CurrentPage}/{PageSize}")
	@ApiOperation(value = "用户购票订单列表")
	public QueryUserOrdersReply QueryUserOrders(@PathVariable String UserName, @PathVariable String Password, @PathVariable String CinemaCode, @PathVariable String OpenID,
			@PathVariable String startDate, @PathVariable String endDate, @PathVariable String CurrentPage, @PathVariable String PageSize) throws Exception {
		
		QueryUserOrdersReply reply = new QueryUserOrdersReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(reply, UserName, Password, CinemaCode, OpenID,startDate,endDate,CurrentPage,PageSize)) {
			return reply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
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
		// 验证日期是否正确
		Date Start = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		Date End = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		if(Start.getTime() > End.getTime()){
			reply.SetStartDateInvalidReply();
			return reply;
		}
		List<Orders> orderlist = _orderService.getOrdersByCreated(UserInfo.getId(), CinemaCode, Start, End);
		UserOrders userOrders = new UserOrders();
		if(orderlist == null || orderlist.size()==0){
			userOrders.setOrderCount(0);
		} else {
			userOrders.setOrderCount(orderlist.size());
			List<OrderList> orderinfoList = new ArrayList<OrderList>();
			for(Orders order : orderlist){
				OrderList orderinfo = new OrderList();
				orderinfo.setOrderId(order.getId());
				orderinfo.setCinemaCode(order.getCinemaCode());
				orderinfo.setSessionCode(order.getSessionCode());
				orderinfo.setScreenCode(order.getScreenCode());
				
				Screeninfo screeninfo = _screeninfoService.getByScreenCode(order.getCinemaCode(),order.getScreenCode());	
				orderinfo.setScreenName(screeninfo==null?"":screeninfo.getSName());
				orderinfo.setSessionTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getSessionTime()));
				orderinfo.setFilmCode(order.getFilmCode());
				orderinfo.setFilmName(order.getFilmName());
				orderinfo.setTicketCount(order.getTicketCount());
				orderinfo.setTotalPrice(order.getTotalPrice());
				orderinfo.setTotalFee(order.getTotalFee());
				orderinfo.setTotalSalePrice(order.getTotalSalePrice());
				orderinfo.setOrderStatus(OrderStatusEnum.CastToEnum(order.getOrderStatus()).getStatusName());
				orderinfo.setMobilePhone(order.getMobilePhone());
				orderinfo.setLockTime(order.getLockTime()==null?"":new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getLockTime()));
				orderinfo.setAutoUnlockDatetime(order.getAutoUnlockDatetime()==null?"":new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getAutoUnlockDatetime()));
				orderinfo.setLockOrderCode(order.getLockOrderCode());
				orderinfo.setSubmitTime(order.getSubmitTime()==null?"":new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getSubmitTime()));
				orderinfo.setSubmitOrderCode(order.getSubmitOrderCode());
				orderinfo.setPrintNo(order.getPrintNo());
				orderinfo.setVerifyCode(order.getVerifyCode());
				if(order.getPrintStatus()==null || order.getPrintStatus()==0){
					orderinfo.setPrintStatus("No");
				} else {
					orderinfo.setPrintStatus("Yes");
				}
				
				orderinfo.setPrintTime(order.getPrintTime()==null?"":new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getPrintTime()));
				orderinfo.setRefundTime(order.getRefundTime()==null?"":new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getRefundTime()));
				orderinfoList.add(orderinfo);
			}
			userOrders.setOrders(orderinfoList);
		}
		reply.setData(userOrders);
		reply.SetSuccessReply();
		return reply;
	}
	//endregion
	
	//region 微信预支付订单（准备微信支付参数）
	@RequestMapping(value="/PrePayOrder",method = RequestMethod.POST)
	@ApiOperation(value = "预支付订单")
	public PrePayParametersReply PrePayOrder(@RequestBody PrePayOrderQueryJson QueryJson) throws IOException{
		PrePayParametersReply prePayParametersReply=new PrePayParametersReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(prePayParametersReply, QueryJson.getUserName(), QueryJson.getPassword(), QueryJson.getCinemaCode(), QueryJson.getOrderCode(),QueryJson.getSeats())) {
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
		OrderView order = _orderService.getOrderWidthLockOrderCode(QueryJson.getCinemaCode(), QueryJson.getOrderCode());
		if (order == null || (order.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.Locked.getStatusCode()
				&& order.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.PayFail.getStatusCode())) {
			prePayParametersReply.SetOrderNotExistReply();
			return prePayParametersReply;
		}
		// 验证座位数量
		if (QueryJson.getSeats().size() != order.getOrderBaseInfo().getTicketCount()) {
			prePayParametersReply.SetSeatCountInvalidReply();
			return prePayParametersReply;
		}
		// 验证优惠券是否使用
		for (PrePayOrderQueryJsonSeat seat : QueryJson.getSeats()) {
			if (!seat.getCouponsCode().isEmpty()&&!seat.getCouponsCode().equals("")) {
				Coupons coupons = _couponsService.getByCouponsCode(seat.getCouponsCode());
				if (coupons.getStatus() != 1)// 不是已领取状态
				{
					prePayParametersReply.SetCouponsNotExistOrUsedReply();
					return prePayParametersReply;
				}
			}
		}
		// 价格计算
		Double SubmitPrice;// 最终上报价格
		Double SalePrice;// 最终销售价格
		Double TicketFee;// 最终服务费
		int TicketCount = order.getOrderBaseInfo().getTicketCount();// 总票数

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
		Double priceplanPrice = null == priceplan.getPrice() ? sessioninfo.getStandardPrice() : priceplan.getPrice();
		Double priceplanFee = null == priceplan.getTicketFee() ? 0 : priceplan.getTicketFee();
		Double priceplanAddFee = null == priceplan.getAddFee() ? 0 : priceplan.getAddFee();
		Double priceplanCinemaAllowance = null == priceplan.getCinemaAllowance() ? 0 : priceplan.getCinemaAllowance();
		// 上报价=场次标准价+场次服务费
		SubmitPrice = sessioninfo.getStandardPrice() + sessioninfo.getTicketFee();
		// 服务费=场次服务费+场次增值服务费-场次影院补贴+价格设置表服务费+价格设置表增值服务费-价格设置表影院补贴
		TicketFee = sessioninfo.getTicketFee() + sessioninfo.getAddFee() - sessioninfo.getCinemaAllowance()
				+ priceplanFee + priceplanAddFee - priceplanCinemaAllowance;
		// 销售价=真实标准价+服务费
		SalePrice = priceplanPrice + TicketFee;
		// 循环处理每一个座位
		//region 更新优惠券和价格到订单详细
		for (Orderseatdetails seat : order.getOrderSeatDetails()) {
			String CouponsCode = QueryJson.getSeats().stream()
					.filter((PrePayOrderQueryJsonSeat s) -> s.getSeatCode().equals(seat.getSeatCode()))
					.collect(Collectors.toList()).get(0).getCouponsCode();
			if(!CouponsCode.equals("")&&!CouponsCode.equals(null)){
				CouponsView couponsview = _couponsService.getWithCouponsCode(CouponsCode);
				if(couponsview.getCoupons()!=null){
					boolean ifCanUse = true;
					//优惠券状态不对
					if(couponsview.getCoupons().getStatus()!=CouponsStatusEnum.Fetched.getStatusCode()){
						ifCanUse=false;
					}
					// 不在有效期范围内
					if (couponsview.getCoupons().getEffectiveDate().getTime() > new Date().getTime()
							|| couponsview.getCoupons().getExpireDate().getTime() <= new Date().getTime()) {
						ifCanUse = false;
					}
					if (couponsview.getCouponsgroup().getCanUsePeriodType() == 2) {
						Calendar c = Calendar.getInstance();
						c.setTime(new Date());
						int weekday = c.get(Calendar.DAY_OF_WEEK);// 1周日，2周一，7周六
						//不在指定周几
						if (!couponsview.getCouponsgroup().getWeekDays().contains(String.valueOf(weekday))) {
							ifCanUse = false;
						}
						String[] timeperiods=couponsview.getCouponsgroup().getTimePeriod().split(",");
						SimpleDateFormat dateFormater = new SimpleDateFormat("HHmm");
						boolean ifintimeperiod=false;
						for(String timeperiod:timeperiods){
							int stime= Integer.parseInt(timeperiod.split("-")[0].replace(":",""));
							int etime= Integer.parseInt(timeperiod.split("-")[1].replace(":",""));
							int date= Integer.parseInt(dateFormater.format(new Date()));
							if(date>stime&&date<etime){
								ifintimeperiod = true;
								break;
							}else
							{
								continue;
							}
						}
						//不在所有的可用时间段内
						if(!ifintimeperiod){
							ifCanUse = false;
							}
					}
					//如果是部分门店可用，并且当前订单的影院不在可用门店里面
					if(couponsview.getCouponsgroup().getCanUseCinemaType()==2){
						if(couponsview.getCouponsgroup().getCinemaCodes().indexOf(order.getOrderBaseInfo().getCinemaCode())==-1){
							ifCanUse = false;
						}
					}
					//如果减免类型是影片
					if(ifCanUse && couponsview.getCouponsgroup().getReductionType()==1){
						if(couponsview.getCouponsgroup().getFilmCodes().indexOf(order.getOrderBaseInfo().getFilmCode())>-1){
							//当前优惠券可以使用，把券码和优惠价格更新到订单详细表
							seat.setConponCode(couponsview.getCoupons().getCouponsCode());
							seat.setConponPrice(couponsview.getCouponsgroup().getReductionPrice());
						}
					}else{
						seat.setConponPrice(0D);//如果优惠券类型是卖品，更新优惠金额为0
					}
				}else{
					seat.setConponPrice(0D);//找不到优惠券，更新优惠金额为0
				}
			}
		}
		//endregion
		//总优惠金额=所有座位的优惠金额相加
		for(int i=0; i<order.getOrderSeatDetails().size(); i++){
			if(order.getOrderSeatDetails().get(i).getConponCode()==null||order.getOrderSeatDetails().get(i).getConponCode()==""){
				order.getOrderSeatDetails().get(i).setConponPrice(0.00);
			}
		}
		Double TotalConponPrice = order.getOrderSeatDetails().stream().mapToDouble(Orderseatdetails::getConponPrice).sum();
		// 更新订单信息
		// 总上报金额=上报价*总票数
		order.getOrderBaseInfo().setTotalPrice(SubmitPrice * TicketCount);
		order.getOrderBaseInfo().setTotalFee(TicketFee * TicketCount);
		order.getOrderBaseInfo().setTotalSalePrice(SalePrice * TicketCount);
		order.getOrderBaseInfo().setTotalConponPrice(TotalConponPrice);
		//更新订单
		_orderService.Update(order);
		//region 准备支付参数
		Calendar cal=Calendar.getInstance();
		cal.setTime(order.getOrderBaseInfo().getSessionTime());
		String WxpayAppId = cinemapaymentsettings.getWxpayAppId();
		String strbody = cinemapaymentsettings.getCinemaName() + "-"
				+ StringUtil.leftPad(String.valueOf(cal.get(Calendar.MONTH)+1), 2, "0")
				+ "月" + StringUtil.leftPad(String.valueOf(cal.get(Calendar.DATE)), 2, "0")
				+ "日" + new SimpleDateFormat("HH:mm").format(order.getOrderBaseInfo().getSessionTime()) + " "
				+ order.getOrderBaseInfo().getFilmName() + " 电影票（" + order.getOrderBaseInfo().getTicketCount() + "张）";
		String WxpayMchId = cinemapaymentsettings.getWxpayMchId();
		String WxpayKey = cinemapaymentsettings.getWxpayKey();
		String NotifyUrl = "https://xc.80piao.com:8443/Api/Order/WxPayNotify";// 暂时
		String OpenId = order.getOrderBaseInfo().getOpenID();
		String TradeNo = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + QueryJson.getCinemaCode()
				+ order.getOrderBaseInfo().getId();
		String ExpireDate = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(order.getOrderBaseInfo().getAutoUnlockDatetime());
		Double TotalPrice = order.getOrderBaseInfo().getTotalSalePrice();// 暂时的
		String TotalFee = String.valueOf(Double.valueOf(TotalPrice*100).intValue());// 商品金额，以分为单位
		//endregion
		return WxPayUtil.WxPayPrePay(request, prePayParametersReply, WxpayAppId, WxpayMchId, WxpayKey, strbody,
				NotifyUrl, OpenId, TradeNo, ExpireDate, TotalFee);
	}
	// endregion

	// region 异步接收微信支付返回
	public void WxPayNotify() throws Exception {
		// 读取返回内容
		Map<String, String> returnmap = WxPayUtil.WxPayNotify(request);
		if (returnmap.get("isWXsign").equals("True")) {
			// 得到订单Id
			Long OrderID = Long.parseLong(returnmap.get("out_trade_no").substring("yyyyMMddHHmmss".length() + 8));
			OrderView order = _orderService.getOrderWidthId(OrderID);
			if (returnmap.get("return_code").equals("SUCCESS") && returnmap.get("result_code").equals("SUCCESS")) {
				// 更新订单主表
				if (order.getOrderBaseInfo().getPayFlag() != 1) {
					order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Payed.getStatusCode());
					order.getOrderBaseInfo().setUpdated(new Date());
					order.getOrderBaseInfo().setOrderPayType(OrderPayTypeEnum.WxPay.getTypeCode());
					order.getOrderBaseInfo().setPayFlag(1);
					order.getOrderBaseInfo().setPayTime(new Date());
					order.getOrderBaseInfo().setOrderTradeNo(returnmap.get("transaction_id"));
					_orderService.UpdateOrderBaseInfo(order.getOrderBaseInfo());
				}
				// 更新优惠券已使用
				for (Orderseatdetails seat : order.getOrderSeatDetails()) {
					if (!seat.getConponCode().equals("")) {
						CouponsView couponsview=_couponsService.getWithCouponsCode(seat.getConponCode());
						couponsview.getCoupons().setStatus(CouponsStatusEnum.Used.getStatusCode());
						couponsview.getCoupons().setUsedDate(new Date());
						//使用数量+1
						couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()+1);
						//更新优惠券及优惠券分组表
						_couponsService.update(couponsview);
					}
				}
			} else {
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.PayFail.getStatusCode());
				order.getOrderBaseInfo().setUpdated(new Date());
				order.getOrderBaseInfo().setErrorMessage(returnmap.get("err_code_des"));
				_orderService.UpdateOrderBaseInfo(order.getOrderBaseInfo());
			}
		}
	}
	// endregion
	
	//region 退款
	@GetMapping("/RefundPayment/{UserName}/{Password}/{CinemaCode}/{LockOrderCode}")
	@ApiOperation(value = "退款")
	public RefundPaymentReply RefundPayment(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String LockOrderCode) throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException, IOException{
		RefundPaymentReply refundpaymentReply=new RefundPaymentReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(refundpaymentReply, UserName, Password, CinemaCode, LockOrderCode)) {
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
		Orders order=_orderService.getOrderBaseByLockOrderCode(LockOrderCode);
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
			Double RefundPrice = order.getTotalSalePrice();// 暂时的
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
				refundpaymentReply.setData(new RefundPaymentReplyOrder());
				refundpaymentReply.getData().setOrderCode(order.getLockOrderCode());
				refundpaymentReply.getData().setOrderStatus(OrderStatusEnum.CastToEnum(order.getOrderStatus()).getStatusName());
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
	
	//region 联合预支付（购票+卖品）
	@RequestMapping(value="/PrePayMixOrder",method = RequestMethod.POST)
	@ApiOperation(value = "预支付联合订单")
	public PrePayParametersReply PrePayMixOrder(@RequestBody PrePayMixOrderQueryJson QueryJson) throws IOException{
		PrePayParametersReply prePayParametersReply=new PrePayParametersReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(prePayParametersReply, QueryJson.getUserName(), QueryJson.getPassword(), QueryJson.getCinemaCode(), QueryJson.getOrderCode(),QueryJson.getSeats(),QueryJson.getGoodsList())) {
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
		OrderView order = _orderService.getOrderWidthLockOrderCode(QueryJson.getCinemaCode(), QueryJson.getOrderCode());
		if (order == null || (order.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.Locked.getStatusCode()
				&& order.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.PayFail.getStatusCode())) {
			prePayParametersReply.SetOrderNotExistReply();
			return prePayParametersReply;
		}
		//验证卖品订单是否存在
		GoodsOrderView goodsorder = _goodsOrderService.getWithLocalOrderCode(QueryJson.getCinemaCode(),QueryJson.getOrderCode());
		if (goodsorder == null || (goodsorder.getOrderBaseInfo().getOrderStatus() != GoodsOrderStatusEnum.Created.getStatusCode()
				&& goodsorder.getOrderBaseInfo().getOrderStatus() != GoodsOrderStatusEnum.PayFail.getStatusCode())) {
			prePayParametersReply.SetOrderNotExistReply();
			return prePayParametersReply;
		}
		// 验证座位数量
		if (QueryJson.getSeats().size() != order.getOrderBaseInfo().getTicketCount()) {
			prePayParametersReply.SetSeatCountInvalidReply();
			return prePayParametersReply;
		}
		// 验证卖品数量
		int GoodsCount=QueryJson.getGoodsList().stream().mapToInt(PrePayMixOrderQueryJsonGoods::getGoodsCount).sum();
		if (GoodsCount != goodsorder.getOrderBaseInfo().getGoodsCount()) {
			prePayParametersReply.SetGoodsCountInvalidReply();
			return prePayParametersReply;
		}
		//验证优惠券是否使用(卖品)
		if(!QueryJson.getCouponsCode().isEmpty()){
			Coupons coupons = _couponsService.getByCouponsCode(QueryJson.getCouponsCode());
			if (coupons.getStatus() != 1)// 不是已领取状态
			{
				prePayParametersReply.SetCouponsNotExistOrUsedReply();
				return prePayParametersReply;
			}
		}
		// 验证优惠券是否使用（购票）
		for (PrePayMixOrderQueryJsonSeat seat : QueryJson.getSeats()) {
			if (!seat.getCouponsCode().isEmpty()) {
				Coupons coupons = _couponsService.getByCouponsCode(seat.getCouponsCode());
				if (coupons.getStatus() != 1)// 不是已领取状态
				{
					prePayParametersReply.SetCouponsNotExistOrUsedReply();
					return prePayParametersReply;
				}
			}
		}
		
		//region 重新计算票价
		Double SubmitPrice;// 最终上报价格
		Double SalePrice;// 最终销售价格
		Double TicketFee;// 最终服务费
		int TicketCount = order.getOrderBaseInfo().getTicketCount();// 总票数

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
		Double priceplanPrice = null == priceplan.getPrice() ? sessioninfo.getStandardPrice() : priceplan.getPrice();
		Double priceplanFee = null == priceplan.getTicketFee() ? 0 : priceplan.getTicketFee();
		Double priceplanAddFee = null == priceplan.getAddFee() ? 0 : priceplan.getAddFee();
		Double priceplanCinemaAllowance = null == priceplan.getCinemaAllowance() ? 0 : priceplan.getCinemaAllowance();
		// 上报价=场次标准价+场次服务费
		SubmitPrice = sessioninfo.getStandardPrice() + sessioninfo.getTicketFee();
		// 服务费=场次服务费+场次增值服务费-场次影院补贴+价格设置表服务费+价格设置表增值服务费-价格设置表影院补贴
		TicketFee = sessioninfo.getTicketFee() + sessioninfo.getAddFee() - sessioninfo.getCinemaAllowance()
				+ priceplanFee + priceplanAddFee - priceplanCinemaAllowance;
		// 销售价=真实标准价+服务费
		SalePrice = priceplanPrice + TicketFee;
		// 循环处理每一个座位
		//region 更新优惠券和价格到订单详细
		for (Orderseatdetails seat : order.getOrderSeatDetails()) {
			String CouponsCode = QueryJson.getSeats().stream()
					.filter((PrePayMixOrderQueryJsonSeat s) -> s.getSeatCode().equals(seat.getSeatCode()))
					.collect(Collectors.toList()).get(0).getCouponsCode();
			CouponsView couponsview = _couponsService.getWithCouponsCode(CouponsCode);
			if(couponsview.getCoupons()!=null){
				boolean ifCanUse=CouponsCanUse(couponsview,order.getOrderBaseInfo().getCinemaCode());
				//如果减免类型是影片
				if(ifCanUse && couponsview.getCouponsgroup().getReductionType()==1){
					if(couponsview.getCouponsgroup().getFilmCodes().indexOf(order.getOrderBaseInfo().getFilmCode())>-1){
						//当前优惠券可以使用，把券码和优惠价格更新到订单详细表
						seat.setConponCode(couponsview.getCoupons().getCouponsCode());
						seat.setConponPrice(couponsview.getCouponsgroup().getReductionPrice());
					}
				}else{
					seat.setConponPrice(0D);//如果优惠券类型是卖品，更新优惠金额为0
				}
			}else{
				seat.setConponPrice(0D);//找不到优惠券，更新优惠金额为0
			}
		}
		//endregion
		//总优惠金额=所有座位的优惠金额相加
		Double TotalConponPrice=order.getOrderSeatDetails().stream().mapToDouble(Orderseatdetails::getConponPrice).sum();
		// 更新订单信息
		// 总上报金额=上报价*总票数
		order.getOrderBaseInfo().setTotalPrice(SubmitPrice * TicketCount);
		order.getOrderBaseInfo().setTotalFee(TicketFee * TicketCount);
		order.getOrderBaseInfo().setTotalSalePrice(SalePrice * TicketCount);
		order.getOrderBaseInfo().setTotalConponPrice(TotalConponPrice);
		//更新订单
		_orderService.Update(order);
		//endregion
		
		//region 重新计算卖品价格
		String CouponsCode = QueryJson.getCouponsCode();
		CouponsView couponsview = _couponsService.getWithCouponsCode(CouponsCode);
		if(couponsview.getCoupons()!=null){
			boolean ifCanUse=CouponsCanUse(couponsview,goodsorder.getOrderBaseInfo().getCinemaCode());
			//如果减免类型是卖品
			if(ifCanUse && couponsview.getCouponsgroup().getReductionType()==2){
				//循环判断每个卖品是不是在可使用优惠的卖品里面
				for(Goodsorderdetails goodsdetail:goodsorder.getOrderGoodsDetails()){
					if(couponsview.getCouponsgroup().getGoodsCodes().indexOf(goodsdetail.getGoodsCode())==-1){
						ifCanUse=false;
						break;
					}else{
						continue;
					}
				}
				//如果到最后还是可以使用
				if(ifCanUse){
					//当前优惠券可以使用,把优惠券更新到卖品订单表
					goodsorder.getOrderBaseInfo().setCouponsCode(couponsview.getCoupons().getCouponsCode());
					goodsorder.getOrderBaseInfo().setCouponsPrice(couponsview.getCouponsgroup().getReductionPrice());
				}
			}else{
				goodsorder.getOrderBaseInfo().setCouponsPrice(0D);//如果优惠券类型不是卖品，更新优惠金额为0
			}
		}else{
			goodsorder.getOrderBaseInfo().setCouponsPrice(0D);//找不到优惠券，更新优惠金额为0
		}
		//更新卖品订单主表
		_goodsOrderService.UpdateOrderBaseInfo(goodsorder.getOrderBaseInfo());
		//endregion
		
		//region 准备支付参数
		Double TotalGoodsOrderPrice = goodsorder.getOrderBaseInfo().getTotalSettlePrice()-goodsorder.getOrderBaseInfo().getCouponsPrice();
		
		Calendar cal=Calendar.getInstance();
		cal.setTime(order.getOrderBaseInfo().getSessionTime());
		String WxpayAppId = cinemapaymentsettings.getWxpayAppId();
		String strbody = cinemapaymentsettings.getCinemaName() + "-"
				+ StringUtil.leftPad(String.valueOf(cal.get(Calendar.MONTH)+1), 2, "0")
				+ "月" + StringUtil.leftPad(String.valueOf(cal.get(Calendar.DATE)), 2, "0")
				+ "日" + new SimpleDateFormat("HH:mm").format(order.getOrderBaseInfo().getSessionTime()) + " "
				+ order.getOrderBaseInfo().getFilmName() + " 电影票（" + order.getOrderBaseInfo().getTicketCount() + "张）,"
		        + "卖品订单总额（" + TotalGoodsOrderPrice + "元）"; 
		String WxpayMchId = cinemapaymentsettings.getWxpayMchId();
		String WxpayKey = cinemapaymentsettings.getWxpayKey();
		String NotifyUrl = "https://xc.80piao.com:8443/Api/Order/WxPayMixNotify";//联合预支付的异步通知
		String OpenId = order.getOrderBaseInfo().getOpenID();
		String TradeNo = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + QueryJson.getCinemaCode()
				+ order.getOrderBaseInfo().getId();
		String ExpireDate = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(order.getOrderBaseInfo().getAutoUnlockDatetime());
		Double TotalPrice = order.getOrderBaseInfo().getTotalSalePrice()+TotalGoodsOrderPrice;// 总支付金额=总购票金额+总卖品金额
		String TotalFee = String.valueOf(Double.valueOf(TotalPrice*100).intValue());// 商品金额，以分为单位
		//endregion
		return WxPayUtil.WxPayPrePay(request, prePayParametersReply, WxpayAppId, WxpayMchId, WxpayKey, strbody,
				NotifyUrl, OpenId, TradeNo, ExpireDate, TotalFee);
	}
	//endregion
	
	//region 联合预支付微信异步返回
	public void WxPayMixNotify() throws Exception {
		// 读取返回内容
		Map<String, String> returnmap = WxPayUtil.WxPayNotify(request);
		if (returnmap.get("isWXsign").equals("True")) {
			
			//region 更新购票订单
			// 得到订单Id
			Long OrderID = Long.parseLong(returnmap.get("out_trade_no").substring("yyyyMMddHHmmss".length() + 8));
			OrderView order = _orderService.getOrderWidthId(OrderID);
			if (returnmap.get("return_code").equals("SUCCESS") && returnmap.get("result_code").equals("SUCCESS")) {
				// 更新购票订单主表
				if (order.getOrderBaseInfo().getPayFlag() != 1) {
					order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Payed.getStatusCode());
					order.getOrderBaseInfo().setUpdated(new Date());
					order.getOrderBaseInfo().setOrderPayType(OrderPayTypeEnum.WxPay.getTypeCode());
					order.getOrderBaseInfo().setPayFlag(1);
					order.getOrderBaseInfo().setPayTime(new Date());
					order.getOrderBaseInfo().setOrderTradeNo(returnmap.get("transaction_id"));
					_orderService.UpdateOrderBaseInfo(order.getOrderBaseInfo());
				}
				// 更新优惠券已使用
				for (Orderseatdetails seat : order.getOrderSeatDetails()) {
					if (!seat.getConponCode().equals("")) {
						CouponsView couponsview=_couponsService.getWithCouponsCode(seat.getConponCode());
						couponsview.getCoupons().setStatus(CouponsStatusEnum.Used.getStatusCode());
						couponsview.getCoupons().setUsedDate(new Date());
						//使用数量+1
						couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()+1);
						//更新优惠券及优惠券分组表
						_couponsService.update(couponsview);
					}
				}
			} else {
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.PayFail.getStatusCode());
				order.getOrderBaseInfo().setUpdated(new Date());
				order.getOrderBaseInfo().setErrorMessage(returnmap.get("err_code_des"));
				_orderService.UpdateOrderBaseInfo(order.getOrderBaseInfo());
			}
			//endregion
			
			//region 更新卖品订单
			//购票订单的锁座订单号和卖品的本地订单号是一样的，所以用它来查询关联的卖品订单
			Goodsorders goodsorder = _goodsOrderService.getByLocalOrderCode(order.getOrderBaseInfo().getLockOrderCode());
			if (returnmap.get("return_code").equals("SUCCESS") && returnmap.get("result_code").equals("SUCCESS")) {
				// 更新订单主表
				if (goodsorder.getOrderPayFlag() != 1) {
					goodsorder.setOrderStatus(OrderStatusEnum.Payed.getStatusCode());
					goodsorder.setUpdated(new Date());
					goodsorder.setOrderPayType(OrderPayTypeEnum.WxPay.getTypeCode());
					goodsorder.setOrderPayFlag(1);
					goodsorder.setOrderPayTime(new Date());
					goodsorder.setOrderTradeNo(returnmap.get("transaction_id"));
					_goodsOrderService.UpdateOrderBaseInfo(goodsorder);
				}
				// 更新优惠券已使用
				if (!goodsorder.getCouponsCode().equals("")) {
					CouponsView couponsview=_couponsService.getWithCouponsCode(goodsorder.getCouponsCode());
					couponsview.getCoupons().setStatus(CouponsStatusEnum.Used.getStatusCode());
					couponsview.getCoupons().setUsedDate(new Date());
					//使用数量+1
					couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()+1);
					//更新优惠券及优惠券分组表
					_couponsService.update(couponsview);
				}
			} else {
				goodsorder.setOrderStatus(OrderStatusEnum.PayFail.getStatusCode());
				goodsorder.setUpdated(new Date());
				goodsorder.setErrorMessage(returnmap.get("err_code_des"));
				_goodsOrderService.UpdateOrderBaseInfo(goodsorder);
			}
			//endregion
		}
	}
	//endregion
	
	//region 联合支付退款
	@GetMapping("/RefundMixPayment/{UserName}/{Password}/{CinemaCode}/{LockOrderCode}")
	@ApiOperation(value = "联合支付退款")
	public RefundPaymentReply RefundMixPayment(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String LockOrderCode) throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException, IOException{
		RefundPaymentReply refundpaymentReply=new RefundPaymentReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(refundpaymentReply, UserName, Password, CinemaCode, LockOrderCode)) {
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
		Orders order=_orderService.getOrderBaseByLockOrderCode(LockOrderCode);
		Goodsorders goodsorder = _goodsOrderService.getByLocalOrderCode(LockOrderCode);
		if(order==null||goodsorder==null){
			refundpaymentReply.SetOrderNotExistReply();
			return refundpaymentReply;
		}else{
			//如果订单存在，开始退款
			String WxpayAppId = cinemapaymentsettings.getWxpayAppId();
			String WxpayMchId=cinemapaymentsettings.getWxpayMchId();
			String WxpayKey=cinemapaymentsettings.getWxpayKey();
			String TradeNo=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + CinemaCode
			+ order.getId();
			Double TotalGoodsOrderPrice = goodsorder.getTotalSettlePrice()-goodsorder.getCouponsPrice();
			Double RefundPrice = order.getTotalSalePrice()+TotalGoodsOrderPrice;//退款总金额=购票金额+卖品金额
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
				refundpaymentReply.setData(new RefundPaymentReplyOrder());
				refundpaymentReply.getData().setOrderCode(order.getLockOrderCode());
				refundpaymentReply.getData().setOrderStatus(OrderStatusEnum.CastToEnum(order.getOrderStatus()).getStatusName());
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
	
	//region 判断优惠券是否可使用
	private boolean CouponsCanUse(CouponsView couponsview,String CinemaCode){
		boolean ifCanUse = true;
		//优惠券状态不对
		if(couponsview.getCoupons().getStatus()!=CouponsStatusEnum.Fetched.getStatusCode()){
			ifCanUse=false;
		}
		// 不在有效期范围内
		if (couponsview.getCoupons().getEffectiveDate().getTime() > new Date().getTime()
				|| couponsview.getCoupons().getExpireDate().getTime() <= new Date().getTime()) {
			ifCanUse = false;
		}
		if (couponsview.getCouponsgroup().getCanUsePeriodType() == 2) {
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			int weekday = c.get(Calendar.DAY_OF_WEEK);// 1周日，2周一，7周六
			//不在指定周几
			if (!couponsview.getCouponsgroup().getWeekDays().contains(String.valueOf(weekday))) {
				ifCanUse = false;
			}
			String[] timeperiods=couponsview.getCouponsgroup().getTimePeriod().split(",");
			SimpleDateFormat dateFormater = new SimpleDateFormat("HHmm");
			boolean ifintimeperiod=false;
			for(String timeperiod:timeperiods){
				int stime= Integer.parseInt(timeperiod.split("-")[0].replace(":",""));
				int etime= Integer.parseInt(timeperiod.split("-")[1].replace(":",""));
				int date= Integer.parseInt(dateFormater.format(new Date()));
				if(date>stime&&date<etime){
					ifintimeperiod = true;
					break;
				}else
				{
					continue;
				}
			}
			//不在所有的可用时间段内
			if(!ifintimeperiod){
				ifCanUse = false;
				}
		}
		//如果是部分门店可用，并且当前订单的影院不在可用门店里面
		if(couponsview.getCouponsgroup().getCanUseCinemaType()==2){
			if(couponsview.getCouponsgroup().getCinemaCodes().indexOf(CinemaCode)==-1){
				ifCanUse = false;
			}
		}
		return ifCanUse;
	}
	//endregion
}
