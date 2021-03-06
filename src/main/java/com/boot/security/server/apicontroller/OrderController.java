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
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.boot.security.server.api.core.CardPayBackReply;
import com.boot.security.server.api.core.LockSeatReply;
import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.QueryPrintReply;
import com.boot.security.server.api.core.QueryTicketReply;
import com.boot.security.server.api.core.RefundTicketReply;
import com.boot.security.server.api.core.ReleaseSeatReply;
import com.boot.security.server.api.core.SubmitMixOrderReply;
import com.boot.security.server.api.core.SubmitOrderReply;
import com.boot.security.server.apicontroller.reply.NetSaleQueryJson;
import com.boot.security.server.apicontroller.reply.PrePayMixOrderQueryJson;
import com.boot.security.server.apicontroller.reply.PrePayMixOrderQueryJson.PrePayMixOrderQueryJsonGoods;
import com.boot.security.server.apicontroller.reply.PrePayOrderQueryJson;
import com.boot.security.server.apicontroller.reply.PrePayParametersReply;
import com.boot.security.server.apicontroller.reply.QueryLocalOrderReply;
import com.boot.security.server.apicontroller.reply.QueryLocalOrderReply.QueryLocalOrder;
import com.boot.security.server.apicontroller.reply.QueryLocalOrderReply.QueryLocalOrder.Seats;
import com.boot.security.server.apicontroller.reply.QueryNonPayOrdersReply;
import com.boot.security.server.apicontroller.reply.QueryNonPayOrdersReply.NonPayOrders;
import com.boot.security.server.apicontroller.reply.QueryNonPayOrdersReply.NonPayOrders.NonPayOrder;
import com.boot.security.server.apicontroller.reply.QueryTicketOrderReply;
import com.boot.security.server.apicontroller.reply.QueryTicketOrderReply.QueryTicketOrderReplyOrder;
import com.boot.security.server.apicontroller.reply.QueryUserOrdersReply;
import com.boot.security.server.apicontroller.reply.QueryUserOrdersReply.UserOrders;
import com.boot.security.server.apicontroller.reply.QueryUserOrdersReply.UserOrders.OrderList;
import com.boot.security.server.apicontroller.reply.RefundPaymentReply;
import com.boot.security.server.apicontroller.reply.RefundPaymentReply.RefundPaymentReplyOrder;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.model.Adminorderview;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.CinemaTypeEnum;
import com.boot.security.server.model.Cinemamessage;
import com.boot.security.server.model.Cinemapaymentsettings;
import com.boot.security.server.model.Cinemaview;
import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.CouponsStatusEnum;
import com.boot.security.server.model.CouponsView;
import com.boot.security.server.model.Couponsgroup;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.GoodsOrderStatusEnum;
import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.OrderPayTypeEnum;
import com.boot.security.server.model.OrderStatusEnum;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.AdminorderviewServiceImpl;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.CinemamessageServiceImpl;
import com.boot.security.server.service.impl.CinemapaymentsettingsServiceImpl;
import com.boot.security.server.service.impl.CinemaviewServiceImpl;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.CouponsgroupServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.GoodsOrderServiceImpl;
import com.boot.security.server.service.impl.OrderServiceImpl;
import com.boot.security.server.service.impl.PriceplanServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.service.impl.TicketusersServiceImpl;
import com.boot.security.server.service.impl.UserCinemaViewServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.boot.security.server.utils.DoubleUtil;
import com.boot.security.server.utils.FileUploadUtils;
import com.boot.security.server.utils.SendMobileMessage;
import com.boot.security.server.utils.SendSmsHelper;
import com.boot.security.server.utils.WxPayUtil;
import com.boot.security.server.utils.XmlHelper;
import com.google.gson.Gson;
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
	CouponsgroupServiceImpl couponsgroupService;
	@Autowired
	SessioninfoServiceImpl _sessioninfoService;
	@Autowired
	PriceplanServiceImpl _priceplanService;
	@Autowired
	TicketusersServiceImpl _ticketUserService;
	@Autowired
	CinemaServiceImpl cinemaService;
	@Autowired
	FilminfoServiceImpl filminfoService;
	@Autowired
	AdminorderviewServiceImpl adminorderviewService;
	@Autowired
	ScreeninfoServiceImpl screeninfoService;
	@Autowired
	private GoodsOrderServiceImpl _goodsOrderService;
	@Autowired
	private CinemaviewServiceImpl cinemaviewService;
	@Autowired
	private OrderServiceImpl orderService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private CinemamessageServiceImpl cinemamessageService;
	protected static Logger log = LoggerFactory.getLogger(OrderController.class);

	// region 锁座
	// @PostMapping("/LockSeat")
	@RequestMapping(value = "/LockSeat", method = RequestMethod.POST)
	@ApiOperation(value = "锁座")
	public LockSeatReply LockSeat(@RequestBody NetSaleQueryJson QueryJson){

		log.info("/Api/Order/LockSeat :"+QueryJson);

		try {
			LockSeatReply lockSeatReply =NetSaleSvcCore.getInstance().LockSeat(QueryJson.getUserName(),QueryJson.getPassword(),QueryJson.getQueryXml());
			if(QueryJson.getOpenID()==null||QueryJson.getOpenID().equals("")){
				return lockSeatReply;
			}
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
			e.printStackTrace();
			return new LockSeatReply();
		}
	}
	//endregion
	
	//region 解锁座位
	@PostMapping("/ReleaseSeat")
	@ApiOperation(value = "解锁座位")
	public ReleaseSeatReply ReleaseSeat(@RequestBody NetSaleQueryJson QueryJson){

		log.info("/Api/Order/ReleaseSeat :"+QueryJson);

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

		log.info("/Api/Order/SubmitOrder :"+QueryJson);

		try {
			SubmitOrderReply submitOrderReply = NetSaleSvcCore.getInstance().SubmitOrder(QueryJson.getUserName(), QueryJson.getPassword(), QueryJson.getQueryXml());
//			System.out.println("提交成功+++++"+new Gson().toJson(submitOrderReply));
			if(submitOrderReply.Status.equals("Success")){
				try{	//提交成功，短信发送失败
					Orders orders=_orderService.getByOrderCode(submitOrderReply.getOrder().getOrderCode());
					Screeninfo screeninfo=screeninfoService.getByScreenCode(orders.getCinemaCode(),orders.getScreenCode());
					Cinemamessage cinemamessage=cinemamessageService.getByMessageType("5");
					Cinema cinema = cinemaService.getByCinemaCode(orders.getCinemaCode());
					String batchNum=UUID.randomUUID().toString().replace("-","");
					// 将特定影院的取票码改为特定的格式
                    Cinemaview cinemaview = cinemaviewService.getByCinemaCode(orders.getCinemaCode());
                    //辰星系统(取票码截取影院编码)
                    String printNo = orders.getPrintNo();
                    if(cinemaview.getCinemaType() == CinemaTypeEnum.ChenXing.getTypeCode()){
    	                if (printNo != null && printNo.length() > 8) {
    	                	printNo = printNo.substring(8);
    	                }
                    } else if(cinemaview.getCinemaType()==CinemaTypeEnum.DianYing1905.getTypeCode()){
                        printNo = orders.getSubmitOrderCode();
                    }
                    // 发送购票成功短信通知
					String smsContent=cinema.getSmsSignId() + cinemamessage.getMessageContent().replaceFirst("@ticketCode", printNo).replaceFirst("@filmName", orders.getFilmName()).replaceFirst("@ticketNumber", orders.getTicketCount().toString()).replaceFirst("@cinemaHallName", screeninfo.getSName()).replaceFirst("@showTime", new SimpleDateFormat("MM-dd HH:mm").format(orders.getSessionTime()));
					//String MsgConetnt="您已成功支付，订单金额"+orders.getTotalSalePrice()+"元，影片场次："+orders.getSessionTime()+" 《"+orders.getFilmName()+"》"+orders.getTicketCount()+"张。请至影城取票机领取，取票码："+orders.getPrintNo()+".热线：4008257789";
					//new SendSmsHelper().SendSms(orders.getCinemaCode(),orders.getMobilePhone(),smsContent);
					SendMobileMessage.sendMessage(cinema.getSmsAccount(),cinema.getSmsPwd(), orders.getMobilePhone(), smsContent, batchNum);
				} catch (Exception e) {
					//e.printStackTrace();
				}
			}
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

		log.info("/Api/Order/SubmitMixOrder :"+QueryJson);

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
	/*@GetMapping("/QueryOrder/{UserName}/{Password}/{CinemaCode}/{OrderCode}")
	@ApiOperation(value = "查询订单")
	public QueryOrderReply QueryOrder(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OrderCode){
		QueryOrderReply orderReply = NetSaleSvcCore.getInstance().QueryOrder(UserName, Password, CinemaCode, OrderCode);
//		System.out.println("查询订单----"+new Gson().toJson(orderReply));
		return orderReply;
	}*/
	//endregion
	
	//region 查询订单
	@GetMapping("/QueryTicketOrder/{UserName}/{Password}/{CinemaCode}/{OrderCode}")
	@ApiOperation(value = "查询订单")
	public QueryTicketOrderReply QueryTicketOrder(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OrderCode){

		log.info("/Api/Order/QueryTicketOrder :"+UserName+"|"+Password+"|"+CinemaCode);

		QueryTicketOrderReply ticketOrderReply = new QueryTicketOrderReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(ticketOrderReply, UserName, Password, CinemaCode, OrderCode)) {
			return ticketOrderReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			ticketOrderReply.SetUserCredentialInvalidReply();
			return ticketOrderReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
		if (userCinema == null) {
			ticketOrderReply.SetCinemaInvalidReply();
			return ticketOrderReply;
		}
		// 验证订单是否存在
		Orders orders = _orderService.getByCinemaCodeAndOrderCode(CinemaCode, OrderCode);
		if(orders == null){
			ticketOrderReply.SetOrderNotExistReply();
			return ticketOrderReply;
		}
		QueryTicketOrderReplyOrder data = new QueryTicketOrderReplyOrder();
		//影院信息
		Cinema cinema = cinemaService.getByCinemaCode(CinemaCode);
		if(cinema!=null){
			data.setCinemaCode(cinema.getCode());
			data.setCinemaName(cinema.getName());
			data.setCinemaAddress(cinema.getAddress());
			data.setCinemaPhone(cinema.getCinemaPhone());
		}
		//影片信息
		Filminfo filminfo = filminfoService.getByFilmCode(orders.getFilmCode());
		if(filminfo!=null){
			data.setFilmCode(filminfo.getFilmCode());
			data.setFilmName(filminfo.getFilmName());
			data.setFilmImage(filminfo.getImage());
			data.setFilmType(filminfo.getType());
		}
		//排期信息
		List<Adminorderview> adminorderviewList = adminorderviewService.getByOrderCode(CinemaCode, OrderCode);
		if(adminorderviewList.size()>0){
			if(filminfo!=null && filminfo.getDuration()!=null && !"".equals(filminfo.getDuration())){
				String endtime = String.valueOf(adminorderviewList.get(0).getSessiontime().getTime()+Integer.valueOf(filminfo.getDuration())*60*1000);
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				data.setShowTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(adminorderviewList.get(0).getSessiontime())+"-"+sdf.format(new Date(Long.parseLong(endtime))));
			}
			data.setScreenCode(orders.getScreenCode());
			Screeninfo screeninfo = screeninfoService.getByScreenCode(CinemaCode, orders.getScreenCode());
			if(screeninfo!=null){
				data.setScreenName(screeninfo.getSName());
			}
			List<String> seatList = new ArrayList<>();
			for(Adminorderview adminorderview:adminorderviewList){
				seatList.add(adminorderview.getSeat());
			}
			data.setSeat(seatList);
		}
		data.setCount(orders.getTicketCount());
		if(orders.getPayTime()!=null){
			data.setPayTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orders.getPayTime()));
		}
		//订单信息
		data.setPrintType(orders.getPrintStatus());
		data.setVerifyCode(orders.getVerifyCode());
		if(orders.getCouponsPrice()==null){
			orders.setCouponsPrice(0.00);
		}
		data.setOrderStatus(orders.getOrderStatus());
		data.setRealAmount(orders.getTotalSalePrice());
		data.setOrderCode(orders.getSubmitOrderCode());
		data.setMobilePhone(orders.getMobilePhone());
		data.setOrderPayType(orders.getOrderPayType());
		//二维码
		Cinemaview cinemaview = cinemaviewService.getByCinemaCode(CinemaCode);
		//辰星系统(取票码截取影院编码)
		if(cinemaview.getCinemaType()==CinemaTypeEnum.ChenXing.getTypeCode()){
			if(orders.getPrintNo()!=null&&orders.getPrintNo().length()>8){
				data.setPrintNo(orders.getPrintNo().substring(8,orders.getPrintNo().length()));
			}
		}else if(cinemaview.getCinemaType()==CinemaTypeEnum.DianYing1905.getTypeCode()){
			data.setPrintNo(orders.getPrintNo());
		}else if(cinemaview.getCinemaType() == CinemaTypeEnum.YueKe.getTypeCode() ||
				cinemaview.getCinemaType() == CinemaTypeEnum.ManTianXing.getTypeCode()){
			data.setPrintNo(orders.getPrintNo());
		}
		if(orders.getEwmPic() == null || "".equals(orders.getEwmPic())){
			String ewmpic = FileUploadUtils.generateEwm(data.getPrintNo());
			orders.setEwmPic(ewmpic);
			_orderService.update(orders);
		}
		data.setEwmPicture(orders.getEwmPic());
		ticketOrderReply.setData(data);
		ticketOrderReply.SetSuccessReply();
		return ticketOrderReply;
	}
	//endregion
	
	//region 查询本地订单
	@GetMapping("/QueryLocalOrder/{UserName}/{Password}/{CinemaCode}/{LockOrderCode}")
	@ApiOperation(value = "查询本地订单")
	public QueryLocalOrderReply QueryLocalOrder(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String LockOrderCode){

		log.info("/Api/Order/QueryLocalOrder :"+UserName+"|"+Password+"|"+CinemaCode);

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
			orderResult.setOpenID(order.getOrderBaseInfo().getOpenID());
			orderResult.setTotalAddFee(order.getOrderBaseInfo().getTotalAddFee());
			orderResult.setTotalCinemaAllowance(order.getOrderBaseInfo().getTotalCinemaAllowance());
			List<Seats> seats = new ArrayList<Seats>();	//座位信息
			for(Orderseatdetails orderseat : order.getOrderSeatDetails()){
				Seats seatinfo = new Seats();
				seatinfo.setSeatCode(orderseat.getSeatCode());
				seatinfo.setRowNum(orderseat.getRowNum());
				seatinfo.setColumnNum(orderseat.getColumnNum());
				seatinfo.setPrice(orderseat.getPrice());
				seatinfo.setSalePrice(orderseat.getSalePrice());
				seatinfo.setFee(orderseat.getFee());
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

		log.info("/Api/Order/QueryNonPayOrders :"+UserName+"|"+Password+"|"+CinemaCode+"|"+OpenID+"|"+startDate+"|"+endDate+"|"+CurrentPage+"|"+PageSize);

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

		log.info("/Api/Order/QueryTicket :"+UserName+"|"+Password+"|"+CinemaCode+"|"+PrintNo+"|"+VerifyCode);

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

		log.info("/Api/Order/QueryPrint :"+UserName+"|"+Password+"|"+CinemaCode+"|"+VerifyCode+"|"+PrintNo);

		QueryPrintReply reply = NetSaleSvcCore.getInstance().QueryPrint(UserName, Password, CinemaCode, PrintNo, VerifyCode);
//		System.out.println("查询出票状态----"+new Gson().toJson(reply));
		return reply;
	}
	//endregion
	
	//region 退票
	@GetMapping("/RefundTicket/{UserName}/{Password}/{CinemaCode}/{OrderCode}")
	@ApiOperation(value = "退票")
	public RefundTicketReply RefundTicket(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String OrderCode) throws Exception{

		log.info("/Api/Order/RefundTicket :"+UserName+"|"+Password+"|"+CinemaCode+"|"+OrderCode);

		RefundTicketReply reply = new RefundTicketReply();
		//验证影院退票规则
		//先获取影片开始时间
		Orders orders = orderService.getByOrderCode(OrderCode);
		if(orders == null){
			reply.SetOrderNotExistReply();
			return reply;
		}
		//验证影院信息
		Cinema cinema = cinemaService.getByCinemaCode(CinemaCode);
		if(cinema!=null){
			//无退票时间
			if(cinema.getOverRefundTime()==null){
				cinema.setOverRefundTime(0);
			}
			//在退票时间内
			if(orders.getSessionTime().getTime()-new Date().getTime()>cinema.getOverRefundTime()*60*1000){
				//退票接口
				reply = NetSaleSvcCore.getInstance().RefundTicket(UserName, Password, CinemaCode, orders.getPrintNo(),orders.getVerifyCode());
				log.info("\nreply:" + reply.Status+"=="+reply.ErrorMessage + "\n");
				//退票成功进行处理
				if (reply.Status.equalsIgnoreCase("Success")) {
					orders = orderService.getByPrintNo(CinemaCode, orders.getPrintNo(),orders.getVerifyCode());	//订单状态已改变，重新查询订单
					//退优惠券
					if(orders.getCouponsCode()!=null&&orders.getCouponsCode()!=""){
						Coupons coupons = _couponsService.getByCouponsCode(orders.getCouponsCode());
						if(coupons!=null){
							//更新每张券的状态
							coupons.setUsedDate(null);
							coupons.setStatus(CouponsStatusEnum.Fetched.getStatusCode());
							coupons.setUpdateTime(new Date());


                            _couponsService.update(coupons);
                            log.info("\n\n\n\n\n\n\nreply:" + reply.Status+"=="+reply.ErrorMessage + "\n");
//							System.out.println("退还优惠券结果"+_couponsService.update(coupons));
							//更新优惠券组的库存、使用数量
							Couponsgroup couponsgroup = couponsgroupService.getByGroupCode(coupons.getCouponsCode());
							if(couponsgroup!=null){
								//库存+1
								couponsgroup.setRemainingNumber(couponsgroup.getRemainingNumber()+1);
								//已使用数量-1
								couponsgroup.setUsedNumber(couponsgroup.getUsedNumber()-1);
								couponsgroup.setUpdateDate(new Date());
								couponsgroupService.update(couponsgroup);
//								System.out.println("优惠券组库存"+couponsgroupService.update(couponsgroup));
							}
						}
					}
					//获取影院的退票手续费
					//无退票手续费
					if(cinema.getRefundFee()==null){
						cinema.setRefundFee(0.00);
					}
					String MsgConetnt="";
					Cinemamessage cinemamessage=cinemamessageService.getByMessageType("4");
					//先判断支付类型
					//微信支付
					if(orders.getOrderPayType()==OrderPayTypeEnum.WxPay.getTypeCode()){
						//计算退票手续费,得到退款总金额
						orders.setTotalRefundPrice(DoubleUtil.sub(orders.getTotalSalePrice(),cinema.getRefundFee()));
						_orderService.update(orders);//更新一下退款金额到数据库
						//调用微信退款接口
						RefundPaymentReply paymentReply = RefundPayment(UserName, Password, CinemaCode, orders.getLockOrderCode());
						if(paymentReply.Status.equals("Success")){
							try{
								//发短信
								String batchNum=UUID.randomUUID().toString().replace("-","");
								MsgConetnt=cinema.getSmsSignId() +cinemamessage.getMessageContent().replaceFirst("@PayBackAmount", orders.getTotalRefundPrice().toString()).replaceFirst("@TelephoneNumber",cinema.getContactMobile());
								//MsgConetnt="您的退票已成功，退票金额"+orders.getTotalSalePrice()+"元将在3个工作日内返回支付账号，咨询：4008257789";
								//new SendSmsHelper().SendSms(CinemaCode,orders.getMobilePhone(),MsgConetnt);
								SendMobileMessage.sendMessage(cinema.getSmsAccount(),cinema.getSmsPwd(), orders.getMobilePhone(), MsgConetnt, batchNum);
							}catch (Exception e) {
								e.printStackTrace();
							}
						}
						log.info("微信退款结果"+new Gson().toJson(paymentReply));
					}
					//会员卡支付
					if(orders.getOrderPayType()==OrderPayTypeEnum.MemberCardPay.getTypeCode()){
						//判断票务系统
						Cinemaview cinemaview = cinemaviewService.getByCinemaCode(CinemaCode);
						//辰星系统调用会员卡支付撤销
						if(cinemaview.getCinemaType()==CinemaTypeEnum.ChenXing.getTypeCode()||cinemaview.getCinemaType()==CinemaTypeEnum.ManTianXing.getTypeCode()){
							orders.setTotalRefundPrice(orders.getTotalSalePrice());
							_orderService.update(orders);//更新一下退款金额到数据库
							CardPayBackReply paybackReply=new NetSaleSvcCore().CardPayBack(UserName, Password, CinemaCode, orders.getCardNo(), orders.getCardPassword(), orders.getOrderTradeNo(), String.valueOf(orders.getTotalRefundPrice()));
							if(paybackReply.Status.equals("Success")){
								try {
									//发短信
									MsgConetnt =cinema.getSmsSignId() + cinemamessage.getMessageContent().replaceFirst("@PayBackAmount", orders.getTotalRefundPrice().toString()).replaceFirst("@TelephoneNumber",cinema.getContactMobile());
									//MsgConetnt="您的退票已成功，退票金额"+backPayAmount+"元将在3个工作日内返回支付账号，咨询：4008257789";
									new SendSmsHelper().SendSms(CinemaCode,orders.getMobilePhone(),MsgConetnt);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}else{
				reply.Status = "Failure";
				reply.ErrorCode = "";
				reply.ErrorMessage = "开场前"+cinema.getOverRefundTime()+"分钟不可退票";
			}
		}
		return reply;
	}
	//endregion
	
	//region 用户购票订单列表
	@GetMapping("/QueryUserOrders/{UserName}/{Password}/{CinemaCode}/{OpenID}/{startDate}/{endDate}/{CurrentPage}/{PageSize}")
	@ApiOperation(value = "用户购票订单列表")
	public QueryUserOrdersReply QueryUserOrders(@PathVariable String UserName, @PathVariable String Password, @PathVariable String CinemaCode, @PathVariable String OpenID,
			@PathVariable String startDate, @PathVariable String endDate, @PathVariable String CurrentPage, @PathVariable String PageSize) throws Exception {

		log.info("/Api/Order/QueryUserOrders :"+UserName+"|"+Password+"|"+CinemaCode+"|"+OpenID+"|"+startDate+"|"+endDate+"|"+CurrentPage+"|"+PageSize);

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

		log.info("/Api/Order/QueryUserOrders :"+QueryJson);

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
		Orders orderbase = _orderService.getByLockOrderCode(QueryJson.getCinemaCode(), QueryJson.getOrderCode());
		if (orderbase == null || (orderbase.getOrderStatus() != OrderStatusEnum.Locked.getStatusCode()
				&& orderbase.getOrderStatus() != OrderStatusEnum.PayFail.getStatusCode())) {
			prePayParametersReply.SetOrderNotExistReply();
			return prePayParametersReply;
		}
		// 验证座位数量
		if (QueryJson.getSeats().size() != orderbase.getTicketCount()) {
			prePayParametersReply.SetSeatCountInvalidReply();
			return prePayParametersReply;
		}
		
		//判断更新优惠价到订单
		orderbase=_couponsService.updateCouponsPricetoOrder(orderbase, QueryJson.getCouponsCode());
		
		//更新订单
		orderService.update(orderbase);

		//region 准备支付参数
		Calendar cal=Calendar.getInstance();
		cal.setTime(orderbase.getSessionTime());
		String WxpayAppId = cinemapaymentsettings.getWxpayAppId();
		String strbody = cinemapaymentsettings.getCinemaName() + "-"
				+ StringUtil.leftPad(String.valueOf(cal.get(Calendar.MONTH)+1), 2, "0")
				+ "月" + StringUtil.leftPad(String.valueOf(cal.get(Calendar.DATE)), 2, "0")
				+ "日" + new SimpleDateFormat("HH:mm").format(orderbase.getSessionTime()) + " "
				+ orderbase.getFilmName() + " 电影票（" + orderbase.getTicketCount() + "张）";
		String WxpayMchId = cinemapaymentsettings.getWxpayMchId();
		String WxpayKey = cinemapaymentsettings.getWxpayKey();
		String weburl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
		String NotifyUrl = weburl+"/Api/Order/WxPayNotify";
//		String NotifyUrl = "https://xc.80piao.com:8443/Api/Order/WxPayNotify";// 暂时,本地测试用
		String OpenId = orderbase.getOpenID();
		String TradeNo = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + QueryJson.getCinemaCode()
				+ orderbase.getId();
		String ExpireDate = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(orderbase.getAutoUnlockDatetime());
		Double TotalPrice = DoubleUtil.sub(orderbase.getTotalSalePrice(),orderbase.getCouponsPrice());//总的销售金额-优惠金额
		String TotalFee = String.valueOf(Double.valueOf(TotalPrice*100).intValue());// 商品金额，以分为单位
		prePayParametersReply = WxPayUtil.WxPayPrePay(request, prePayParametersReply, WxpayAppId, WxpayMchId, WxpayKey, strbody,
                NotifyUrl, OpenId, TradeNo, ExpireDate, TotalFee);
		log.info("预支付返回："+new Gson().toJson(prePayParametersReply));
        return prePayParametersReply;
	}
	// endregion

	// region 异步接收微信支付返回
	@RequestMapping(value = "/WxPayNotify", produces = "application/json;charset=UTF-8")
	// @RequestDescription("支付回调地址")
	@ResponseBody
	public void WxPayNotify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		// 读取返回内容
		Map<String, String> returnmap = WxPayUtil.WxPayNotify(request);
		log.info("微信回调返回："+new Gson().toJson(returnmap));
		// 得到订单Id
		Long OrderID = Long.parseLong(returnmap.get("out_trade_no").substring("yyyyMMddHHmmss".length() + 8));
		OrderView order = _orderService.getOrderWidthId(OrderID);
		if (returnmap.get("isWXsign").equals("True")) {
			if (returnmap.get("return_code").equals("SUCCESS") && returnmap.get("result_code").equals("SUCCESS")) {
				// 更新订单主表
				if(order.getOrderBaseInfo().getPayFlag()==null){
					order.getOrderBaseInfo().setPayFlag(0);
				}
				if (order.getOrderBaseInfo().getPayFlag() == 0) {
					order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Payed.getStatusCode());
					order.getOrderBaseInfo().setUpdated(new Date());
					order.getOrderBaseInfo().setOrderPayType(OrderPayTypeEnum.WxPay.getTypeCode());
					order.getOrderBaseInfo().setPayFlag(1);
					order.getOrderBaseInfo().setPayTime(new Date());
					order.getOrderBaseInfo().setOrderTradeNo(returnmap.get("transaction_id"));
					log.info("==========="+new Gson().toJson(order.getOrderBaseInfo()));
					
					// 更新优惠券已使用
					if (order.getOrderBaseInfo().getCouponsCode()!=null&&!order.getOrderBaseInfo().getCouponsCode().equals("")) {
						CouponsView couponsview=_couponsService.getWithCouponsCode(order.getOrderBaseInfo().getCouponsCode());
						if(couponsview!=null){
							couponsview.getCoupons().setStatus(CouponsStatusEnum.Used.getStatusCode());
							couponsview.getCoupons().setUsedDate(new Date());
							//使用数量+1
							couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()+1);
							couponsview.getCouponsgroup().setOperationRemark("购票订单支付回调操作+1");
							couponsview.getCouponsgroup().setUpdateDate(new Date());
							//更新优惠券及优惠券分组表
							_couponsService.update(couponsview);
							//更新订单的实际销售金额=减去优惠券的实际金额
							order.getOrderBaseInfo().setTotalSalePrice(DoubleUtil.sub(order.getOrderBaseInfo().getTotalSalePrice(), order.getOrderBaseInfo().getCouponsPrice()));
						}
					}
				}
			} else {
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.PayFail.getStatusCode());
				order.getOrderBaseInfo().setUpdated(new Date());
				order.getOrderBaseInfo().setErrorMessage(returnmap.get("err_code_des"));
			}
		}
		_orderService.update(order.getOrderBaseInfo());
		response.getWriter().write(setXML("SUCCESS", "OK")); 
	}
	
	public static String setXML(String return_code, String return_msg) {
		  return "<xml><return_code><![CDATA[" + return_code
		    + "]]></return_code><return_msg><![CDATA[" + return_msg
		    + "]]></return_msg></xml>";
	}
	// endregion
	
	//region 退款
	@GetMapping("/RefundPayment/{UserName}/{Password}/{CinemaCode}/{LockOrderCode}")
	@ApiOperation(value = "退款")
	public RefundPaymentReply RefundPayment(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String LockOrderCode) throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException, IOException{

		log.info("/Api/Order/RefundPayment :"+UserName+"|"+Password+"|"+CinemaCode+"|"+LockOrderCode);

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
		OrderView order=_orderService.getOrderWidthLockOrderCode(CinemaCode,LockOrderCode);
		if(order==null){
			refundpaymentReply.SetOrderNotExistReply();
			return refundpaymentReply;
		}else{
			//如果订单存在，开始退款
			String WxpayAppId = cinemapaymentsettings.getWxpayAppId();
			String WxpayMchId=cinemapaymentsettings.getWxpayMchId();
			String WxpayKey=cinemapaymentsettings.getWxpayKey();
			String TradeNo=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + CinemaCode
			+ order.getOrderBaseInfo().getId();
			if(order.getOrderBaseInfo().getCouponsPrice()==null){
				order.getOrderBaseInfo().setCouponsPrice(0.00);
			}
			Double RefundPrice = order.getOrderBaseInfo().getTotalRefundPrice();// 退款金额
			String RefundFee = String.valueOf(Double.valueOf(RefundPrice*100).intValue());// 退款金额，以分为单位
			Double TotalSalePrice = order.getOrderBaseInfo().getTotalSalePrice();// 订单金额
			String TotalFee=String.valueOf(Double.valueOf(TotalSalePrice*100).intValue());
			String OrderTradeNo=order.getOrderBaseInfo().getOrderTradeNo();//微信支付订单号
			String WxpayRefundCert=cinemapaymentsettings.getWxpayRefundCert();
			String strRefundPaymentXml = WxPayUtil.WxPayRefund(WxpayAppId,WxpayMchId,WxpayKey,TradeNo,RefundFee,TotalFee,OrderTradeNo,CinemaCode,WxpayRefundCert);
			log.info("退款返回："+strRefundPaymentXml);
			//获取返回值 
			String strRefundPaymentXml2 = strRefundPaymentXml.replace("<![CDATA[", "").replace("]]>", "");
			Document document = XmlHelper.StringTOXml(strRefundPaymentXml2);
			String resultcodeValue = XmlHelper.getNodeValue(document, "/xml/result_code");
			String resultMsg = XmlHelper.getNodeValue(document, "/xml/err_code_des");
			String refundidValue=XmlHelper.getNodeValue(document,"/xml/refund_id");
			if (resultcodeValue.equals("SUCCESS")) {
				//更新订单信息（退款）
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.PayBack.getStatusCode());
				order.getOrderBaseInfo().setRefundTradeNo(refundidValue);
				order.getOrderBaseInfo().setRefundTime(new Date());
				_orderService.update(order.getOrderBaseInfo());
				//退优惠券
				if(order.getOrderBaseInfo().getCouponsCode()!=null&&order.getOrderBaseInfo().getCouponsCode()!=""){
					CouponsView couponsview = _couponsService.getWithCouponsCode(order.getOrderBaseInfo().getCouponsCode());
					if(couponsview.getCoupons() !=null && couponsview.getCoupons().getStatus() == 2){
						couponsview.getCoupons().setStatus(CouponsStatusEnum.Fetched.getStatusCode());
						//couponsview.getCoupons().setUsedDate(null);
						//库存+1
						couponsview.getCouponsgroup().setRemainingNumber(couponsview.getCouponsgroup().getRemainingNumber()+1);
						//使用数量-1
						couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()-1);
						couponsview.getCouponsgroup().setOperationRemark("购票订单退款操作-1");
						couponsview.getCouponsgroup().setUpdateDate(new Date());
						//更新优惠券及优惠券分组表
						_couponsService.update(couponsview);
					}
				}
				//准备返回
				refundpaymentReply.setData(new RefundPaymentReplyOrder());
				refundpaymentReply.getData().setOrderCode(order.getOrderBaseInfo().getLockOrderCode());
				refundpaymentReply.getData().setOrderStatus(OrderStatusEnum.CastToEnum(order.getOrderBaseInfo().getOrderStatus()).getStatusName());
				refundpaymentReply.getData().setRefundTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				refundpaymentReply.getData().setRefundTradeNo(refundidValue);
				refundpaymentReply.SetSuccessReply();
			}else{
				refundpaymentReply.Status = "Failure";
				refundpaymentReply.ErrorCode = resultcodeValue;
				refundpaymentReply.ErrorMessage = resultMsg;
			}
		}
		return refundpaymentReply;
	}
	//endregion
		
	//region 联合预支付（购票+卖品）
	@RequestMapping(value="/PrePayMixOrder",method = RequestMethod.POST)
	@ApiOperation(value = "预支付联合订单")
	public PrePayParametersReply PrePayMixOrder(@RequestBody PrePayMixOrderQueryJson QueryJson) throws IOException{

		log.info("/Api/Order/PrePayMixOrder :"+QueryJson);

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
		//判断更新优惠价到订单
		order.setOrderBaseInfo(_couponsService.updateCouponsPricetoOrder(order.getOrderBaseInfo(), QueryJson.getCouponsCode()));
		//更新订单
		orderService.update(order.getOrderBaseInfo());
		
		//判断更新优惠价到卖品订单
		goodsorder.setOrderBaseInfo(_couponsService.updateCouponsPricetoGoodsOrder(goodsorder.getOrderBaseInfo(),QueryJson.getCouponsCode2()));
        //更新卖品订单
		_goodsOrderService.UpdateOrderBaseInfo(goodsorder.getOrderBaseInfo());

		//region 准备支付参数
		Calendar cal=Calendar.getInstance();
		cal.setTime(order.getOrderBaseInfo().getSessionTime());
		String WxpayAppId = cinemapaymentsettings.getWxpayAppId();
		String strbody = cinemapaymentsettings.getCinemaName() + "-"
				+ StringUtil.leftPad(String.valueOf(cal.get(Calendar.MONTH)+1), 2, "0")
				+ "月" + StringUtil.leftPad(String.valueOf(cal.get(Calendar.DATE)), 2, "0")
				+ "日" + new SimpleDateFormat("HH:mm").format(order.getOrderBaseInfo().getSessionTime()) + " "
				+ order.getOrderBaseInfo().getFilmName() + " 电影票（" + order.getOrderBaseInfo().getTicketCount() + "张）,"
		        + "卖品订单总额（" + goodsorder.getOrderBaseInfo().getTotalSettlePrice() + "元）"; 
		String WxpayMchId = cinemapaymentsettings.getWxpayMchId();
		String WxpayKey = cinemapaymentsettings.getWxpayKey();
		String weburl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
		String NotifyUrl = weburl+"/Api/Order/WxPayMixNotify";//联合预支付的异步通知
		String OpenId = order.getOrderBaseInfo().getOpenID();
		String TradeNo = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + QueryJson.getCinemaCode()
				+ order.getOrderBaseInfo().getId();
		String ExpireDate = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(order.getOrderBaseInfo().getAutoUnlockDatetime());
		Double TotalPrice = order.getOrderBaseInfo().getTotalSalePrice()+goodsorder.getOrderBaseInfo().getTotalSettlePrice();// 总支付金额=总购票金额+总卖品金额
		String TotalFee = String.valueOf(Double.valueOf(TotalPrice*100).intValue());// 商品金额，以分为单位
		//endregion
		return WxPayUtil.WxPayPrePay(request, prePayParametersReply, WxpayAppId, WxpayMchId, WxpayKey, strbody,
				NotifyUrl, OpenId, TradeNo, ExpireDate, TotalFee);
	}
	//endregion
	
	//region 联合预支付微信异步返回
	@RequestMapping(value = "/WxPayMixNotify", produces = "application/json;charset=UTF-8")
	// @RequestDescription("支付回调地址")
	@ResponseBody
	public void WxPayMixNotify(HttpServletRequest request) throws Exception {

		log.info("/Api/Order/WxPayMixNotify :");

		// 读取返回内容
		Map<String, String> returnmap = WxPayUtil.WxPayNotify(request);
		if (returnmap.get("isWXsign").equals("True")) {
			//region 更新购票订单
			// 得到订单Id
			Long OrderID = Long.parseLong(returnmap.get("out_trade_no").substring("yyyyMMddHHmmss".length() + 8));
			OrderView order = _orderService.getOrderWidthId(OrderID);
			if (returnmap.get("return_code").equals("SUCCESS") && returnmap.get("result_code").equals("SUCCESS")) {
				// 更新购票订单主表
				if(order.getOrderBaseInfo().getPayFlag()==null){
					order.getOrderBaseInfo().setPayFlag(0);
				}
				if (order.getOrderBaseInfo().getPayFlag() == 0) {
					order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Payed.getStatusCode());
					order.getOrderBaseInfo().setUpdated(new Date());
					order.getOrderBaseInfo().setOrderPayType(OrderPayTypeEnum.WxPay.getTypeCode());
					order.getOrderBaseInfo().setPayFlag(1);
					order.getOrderBaseInfo().setPayTime(new Date());
					order.getOrderBaseInfo().setOrderTradeNo(returnmap.get("transaction_id"));
					_orderService.update(order.getOrderBaseInfo());
				}
				// 更新优惠券已使用
				if (order.getOrderBaseInfo().getCouponsCode()!=null&&!order.getOrderBaseInfo().getCouponsCode().equals("")) {
					CouponsView couponsview=_couponsService.getWithCouponsCode(order.getOrderBaseInfo().getCouponsCode());
					if(couponsview!=null){
						couponsview.getCoupons().setStatus(CouponsStatusEnum.Used.getStatusCode());
						couponsview.getCoupons().setUsedDate(new Date());
						//使用数量+1
						couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()+1);
						couponsview.getCouponsgroup().setOperationRemark("联合支付回调操作+1");
						couponsview.getCouponsgroup().setUpdateDate(new Date());
						//更新优惠券及优惠券分组表
						_couponsService.update(couponsview);
					}
				}
			} else {
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.PayFail.getStatusCode());
				order.getOrderBaseInfo().setUpdated(new Date());
				order.getOrderBaseInfo().setErrorMessage(returnmap.get("err_code_des"));
				_orderService.update(order.getOrderBaseInfo());
			}
			//endregion
			
			//region 更新卖品订单
			//购票订单的锁座订单号和卖品的本地订单号是一样的，所以用它来查询关联的卖品订单
			Goodsorders goodsorder = _goodsOrderService.getByLocalOrderCode(order.getOrderBaseInfo().getLockOrderCode());
			if (returnmap.get("return_code").equals("SUCCESS") && returnmap.get("result_code").equals("SUCCESS")) {
				// 更新订单主表
				if(goodsorder.getOrderPayFlag()==null){
					goodsorder.setOrderPayFlag(0);
				}
				if (goodsorder.getOrderPayFlag()==0) {
					goodsorder.setOrderStatus(OrderStatusEnum.Payed.getStatusCode());
					goodsorder.setUpdated(new Date());
					goodsorder.setOrderPayType(OrderPayTypeEnum.WxPay.getTypeCode());
					goodsorder.setOrderPayFlag(1);
					goodsorder.setOrderPayTime(new Date());
					goodsorder.setOrderTradeNo(returnmap.get("transaction_id"));
					_goodsOrderService.UpdateOrderBaseInfo(goodsorder);
				}
				// 更新优惠券已使用
				if (goodsorder.getCouponsCode()!=null&&!goodsorder.getCouponsCode().equals("")) {
					CouponsView couponsview=_couponsService.getWithCouponsCode(goodsorder.getCouponsCode());
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
	/*@GetMapping("/RefundMixPayment/{UserName}/{Password}/{CinemaCode}/{LockOrderCode}")
	@ApiOperation(value = "联合支付退款")
	public RefundPaymentReply RefundMixPayment(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String LockOrderCode) throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException, IOException{

		log.info("/Api/Order/RefundMixPayment :"+UserName+"|"+Password+"|"+CinemaCode+"|"+LockOrderCode);

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
		OrderView order=_orderService.getOrderWidthLockOrderCode(CinemaCode,LockOrderCode);
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
			+ order.getOrderBaseInfo().getId();
			Double TotalGoodsOrderPrice = DoubleUtil.sub(goodsorder.getTotalSettlePrice(),goodsorder.getCouponsPrice());
			Double RefundPrice =DoubleUtil.add(order.getOrderBaseInfo().getTotalSalePrice(),TotalGoodsOrderPrice);//退款总金额=购票金额+卖品金额
			String RefundFee = String.valueOf(Double.valueOf(RefundPrice*100).intValue());// 退款金额，以分为单位
			String OrderTradeNo=order.getOrderBaseInfo().getOrderTradeNo();//微信支付订单号
			String WxpayRefundCert=cinemapaymentsettings.getWxpayRefundCert();
			
			String strRefundPaymentXml = WxPayUtil.WxPayRefund(WxpayAppId,WxpayMchId,WxpayKey,TradeNo,RefundFee,OrderTradeNo,CinemaCode,WxpayRefundCert);
			//获取返回值 
			String strRefundPaymentXml2 = strRefundPaymentXml.replace("<![CDATA[", "").replace("]]>", "");
			Document document = XmlHelper.StringTOXml(strRefundPaymentXml2);
			String resultcodeValue = XmlHelper.getNodeValue(document, "/xml/result_code");
			String refundidValue=XmlHelper.getNodeValue(document,"/xml/refund_id");
			if (resultcodeValue.equals("SUCCESS")) {
				//更新订单信息
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.PayBack.getStatusCode());
				order.getOrderBaseInfo().setRefundTradeNo(refundidValue);
				order.getOrderBaseInfo().setRefundTime(new Date());
				_orderService.update(order.getOrderBaseInfo());
				//退购票优惠券
				if(order.getOrderBaseInfo().getCouponsCode()!=null&&!order.getOrderBaseInfo().getCouponsCode().equals("")){
					CouponsView couponsview = _couponsService.getWithCouponsCode(order.getOrderBaseInfo().getCouponsCode());
					if(couponsview!=null){
						couponsview.getCoupons().setStatus(CouponsStatusEnum.Fetched.getStatusCode());
						couponsview.getCoupons().setUsedDate(null);
						//使用数量-1
						couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()-1);
						couponsview.getCouponsgroup().setOperationRemark("联合支付订单退款操作-1");
						couponsview.getCouponsgroup().setUpdateDate(new Date());
						//更新优惠券及优惠券分组表
						_couponsService.update(couponsview);
					}
				}
				//更新卖品订单
				goodsorder.setOrderStatus(GoodsOrderStatusEnum.PayBack.getStatusCode());
				goodsorder.setRefundTradeNo(refundidValue);
				goodsorder.setRefundTime(new Date());
				_goodsOrderService.update(goodsorder);
				//退卖品优惠券
				if(goodsorder.getCouponsCode()!=null&&!goodsorder.getCouponsCode().equals("")){
					CouponsView couponsview = _couponsService.getWithCouponsCode(goodsorder.getCouponsCode());
					if(couponsview!=null){
						couponsview.getCoupons().setStatus(CouponsStatusEnum.Fetched.getStatusCode());
						couponsview.getCoupons().setUsedDate(null);
						//使用数量-1
						couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()-1);
						couponsview.getCouponsgroup().setOperationRemark("联合支付卖品订单退款操作-1");
						couponsview.getCouponsgroup().setUpdateDate(new Date());
						//更新优惠券及优惠券分组表
						_couponsService.update(couponsview);
					}
				}
				//准备返回参数
				refundpaymentReply.setData(new RefundPaymentReplyOrder());
				refundpaymentReply.getData().setOrderCode(order.getOrderBaseInfo().getLockOrderCode());
				refundpaymentReply.getData().setOrderStatus(OrderStatusEnum.CastToEnum(order.getOrderBaseInfo().getOrderStatus()).getStatusName());
				refundpaymentReply.getData().setRefundTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				refundpaymentReply.getData().setRefundTradeNo(refundidValue);
				refundpaymentReply.SetSuccessReply();
			}else{
				refundpaymentReply.Status = "Failure";
				refundpaymentReply.ErrorCode = resultcodeValue;
			}
		}
		return refundpaymentReply;
	}*/
	//endregion
	
}
