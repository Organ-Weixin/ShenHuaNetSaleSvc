package com.boot.security.server.apicontroller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.api.core.LockSeatReply;
import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.QueryOrderReply;
import com.boot.security.server.api.core.QueryPrintReply;
import com.boot.security.server.api.core.QueryTicketReply;
import com.boot.security.server.api.core.RefundTicketReply;
import com.boot.security.server.api.core.ReleaseSeatReply;
import com.boot.security.server.api.core.SubmitOrderReply;
import com.boot.security.server.apicontroller.reply.NetSaleQueryJson;
import com.boot.security.server.apicontroller.reply.QueryLocalOrderReply;
import com.boot.security.server.apicontroller.reply.QueryLocalOrderReply.QueryLocalOrder;
import com.boot.security.server.apicontroller.reply.QueryLocalOrderReply.QueryLocalOrder.Seats;
import com.boot.security.server.apicontroller.reply.QueryUserOrdersReply;
import com.boot.security.server.apicontroller.reply.QueryUserOrdersReply.UserOrders;
import com.boot.security.server.apicontroller.reply.QueryUserOrdersReply.UserOrders.OrderList;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.OrderServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.UserCinemaViewServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

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
	
//	@PostMapping("/LockSeat")
	@RequestMapping(value="/LockSeat",method = RequestMethod.POST)
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
	
	@GetMapping("/QueryOrder/{UserName}/{Password}/{CinemaCode}/{OrderCode}")
	@ApiOperation(value = "查询订单")
	public QueryOrderReply QueryOrder(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OrderCode){
		QueryOrderReply orderReply = NetSaleSvcCore.getInstance().QueryOrder(UserName, Password, CinemaCode, OrderCode);
//		System.out.println("查询订单----"+new Gson().toJson(orderReply));
		return orderReply;
	}
	
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
			orderResult.setLockTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(order.getOrderBaseInfo().getLockTime()));
			orderResult.setAutoUnlockDatetime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(order.getOrderBaseInfo().getAutoUnlockDatetime()));
			orderResult.setLockOrderCode(order.getOrderBaseInfo().getLockOrderCode());
			orderResult.setCreated(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(order.getOrderBaseInfo().getCreated()));
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
	
	@GetMapping("/QueryTicket/{UserName}/{Password}/{CinemaCode}/{PrintNo}/{VerifyCode}")
	@ApiOperation(value = "查询影片")
	public QueryTicketReply QueryTicket(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String PrintNo,@PathVariable String VerifyCode){
		QueryTicketReply reply = NetSaleSvcCore.getInstance().QueryTicket(UserName, Password, CinemaCode, PrintNo, VerifyCode);
//		System.out.println("查询影片----"+new Gson().toJson(reply));
		return reply;
	}
	
	@GetMapping("/QueryPrint/{UserName}/{Password}/{CinemaCode}/{PrintNo}/{VerifyCode}")
	@ApiOperation(value = "查询出票状态")
	public QueryPrintReply QueryPrint(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String PrintNo,@PathVariable String VerifyCode){
		QueryPrintReply reply = NetSaleSvcCore.getInstance().QueryPrint(UserName, Password, CinemaCode, PrintNo, VerifyCode);
//		System.out.println("查询出票状态----"+new Gson().toJson(reply));
		return reply;
	}
	
	@GetMapping("/RefundTicket/{UserName}/{Password}/{CinemaCode}/{PrintNo}/{VerifyCode}")
	@ApiOperation(value = "退票")
	public RefundTicketReply RefundTicket(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String PrintNo,@PathVariable String VerifyCode){
		RefundTicketReply reply = NetSaleSvcCore.getInstance().RefundTicket(UserName, Password, CinemaCode, PrintNo, VerifyCode);
//		System.out.println("退票----"+new Gson().toJson(reply));
		return reply;
	}
	
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
				orderinfo.setOrderStatus(order.getOrderStatus());
				orderinfo.setMobilePhone(order.getMobilePhone());
				orderinfo.setLockTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getLockTime()));
				orderinfo.setAutoUnlockDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getAutoUnlockDatetime()));
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
}
