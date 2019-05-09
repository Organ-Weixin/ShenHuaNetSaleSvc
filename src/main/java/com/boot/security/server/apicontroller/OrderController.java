package com.boot.security.server.apicontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.regex.Pattern;

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
import com.boot.security.server.api.core.SubmitOrderReply;
import com.boot.security.server.apicontroller.reply.ModelMapper;
import com.boot.security.server.apicontroller.reply.NetSaleQueryJson;
import com.boot.security.server.apicontroller.reply.PrePayOrderQueryJson;
import com.boot.security.server.apicontroller.reply.PrePayOrderQueryJson.PrePayOrderQueryJsonSeat;
import com.boot.security.server.apicontroller.reply.PrePayParametersReply;
import com.boot.security.server.apicontroller.reply.PrePayParametersReply.PrePayParametersReplyParameter;
import com.boot.security.server.apicontroller.reply.QueryLocalOrderReply;
import com.boot.security.server.apicontroller.reply.QueryLocalOrderReply.QueryLocalOrder;
import com.boot.security.server.apicontroller.reply.QueryLocalOrderReply.QueryLocalOrder.Seats;
import com.boot.security.server.apicontroller.reply.QueryUserOrdersReply;
import com.boot.security.server.apicontroller.reply.QueryUserOrdersReply.UserOrders;
import com.boot.security.server.apicontroller.reply.QueryUserOrdersReply.UserOrders.OrderList;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.model.Cinemapaymentsettings;
import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.CouponsStatusEnum;
import com.boot.security.server.model.OrderPayTypeEnum;
import com.boot.security.server.model.OrderStatusEnum;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemapaymentsettingsServiceImpl;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.OrderServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.UserCinemaViewServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.boot.security.server.utils.HttpHelper;
import com.boot.security.server.utils.MD5Util;
import com.boot.security.server.utils.StrUtil;
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
    private HttpServletRequest request;
	
	//region 锁座
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
	
	//region 查询影片
	@GetMapping("/QueryTicket/{UserName}/{Password}/{CinemaCode}/{PrintNo}/{VerifyCode}")
	@ApiOperation(value = "查询影片")
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
				orderinfo.setOrderStatus(order.getOrderStatus());
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
	public PrePayParametersReply PrePayOrder(@RequestBody PrePayOrderQueryJson QueryJson) throws UnknownHostException{
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
		//获取影院的支付配置
        Cinemapaymentsettings cinemapaymentsettings = _cinemapaymentsettingsService.getByCinemaCode(QueryJson.getCinemaCode());
        if (cinemapaymentsettings == null || cinemapaymentsettings.getWxpayAppId().isEmpty() || cinemapaymentsettings.getWxpayMchId().isEmpty())
        {
            prePayParametersReply.SetCinemaPaySettingInvalidReply();
            return prePayParametersReply;
        }
        //验证订单是否存在
        OrderView order = _orderService.getOrderWidthLockOrderCode(QueryJson.getCinemaCode(), QueryJson.getOrderCode());
        if (order == null || (order.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.Locked.getStatusCode() && order.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.PayFail.getStatusCode()))
        {
            prePayParametersReply.SetOrderNotExistReply();
            return prePayParametersReply;
        }
        //验证座位数量
        if (QueryJson.getSeats().size() != order.getOrderBaseInfo().getTicketCount())
        {
            prePayParametersReply.SetSeatCountInvalidReply();
            return prePayParametersReply;
        }
        //验证优惠券是否使用
        for(PrePayOrderQueryJsonSeat seat: QueryJson.getSeats())
        {
            if(!seat.getCouponsCode().isEmpty())
            {
                Coupons coupons = _couponsService.getByCouponsCode(seat.getCouponsCode());
                if(coupons.getStatus()!=1)//不是已领取状态
                {
                    prePayParametersReply.SetCouponsNotExistOrUsedReply();
                    return prePayParametersReply;
                }
            }
        }
        //更新订单信息
        ModelMapper.MapFrom(order, QueryJson);
        _orderService.Update(order);
        //准备参数
        String nonce_str=MD5Util.MD5Encode(String.valueOf(new Random().nextInt(1000)),"UTF-8");
        Map<String, String> map = new HashMap<String, String>();
        map.put("appid",cinemapaymentsettings.getWxpayAppId());
        String strbody = cinemapaymentsettings.getCinemaName() + "-" + StringUtil.leftPad(String.valueOf(order.getOrderBaseInfo().getSessionTime().getMonth()+1), 2, "0")
                + "月" + StringUtil.leftPad(String.valueOf(order.getOrderBaseInfo().getSessionTime().getDay()), 2, "0") + "日" + new SimpleDateFormat("HH:mm").format(order.getOrderBaseInfo().getSessionTime()) + " " + order.getOrderBaseInfo().getFilmName()
                + " 电影票（" + order.getOrderBaseInfo().getTicketCount() + "张）";
        map.put("body",strbody);//商品信息
        map.put("mch_id",cinemapaymentsettings.getWxpayMchId());
        map.put("nonce_str",nonce_str.toLowerCase());
        map.put("notify_url","https://xc.80piao.com:8443/Api/Order/WxPayNotify");//暂时
        map.put("openid",order.getOrderBaseInfo().getOpenID());
        map.put("out_trade_no",new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+QueryJson.getCinemaCode()+order.getOrderBaseInfo().getId());//商家交易号
        map.put("spbill_create_ip",StrUtil.getIpAddress(request));
        map.put("time_expire",new SimpleDateFormat("yyyyMMddHHmmss").format(order.getOrderBaseInfo().getAutoUnlockDatetime()));
        Double totalPrice=order.getOrderBaseInfo().getTotalSalePrice();//暂时的
        map.put("total_fee",String.valueOf(totalPrice*100));//商品金额，以分为单位
        map.put("trade_type","JSAPI");
        String sign=getSign(map,"key",cinemapaymentsettings.getWxpayKey());
        map.put("sign",sign);
        //把参数组装成xml
        String data=getXml(map);
        String UnifiedOrderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        String strPrepayXml=HttpHelper.sendPostByHttpUrlConnection(UnifiedOrderUrl, data,"UTF-8");
        //获取prepay_id
        String strPrePayXml2=strPrepayXml.replace("<![CDATA[", "").replace("]]>", "");
        Document document=XmlHelper.StringTOXml(strPrePayXml2);
        String returncodeValue=XmlHelper.getNodeValue(document,"/xml/return_code");
        String prepayidValue=XmlHelper.getNodeValue(document,"/xml/prepay_id");
        if(returncodeValue.equals("SUCCESS")){
        	//再定义一个map准备签名paysign
        	String timeStamp=String.valueOf(System.currentTimeMillis());
        	Map<String, String> map2 = new HashMap<String, String>();
        	map2.put("appId",cinemapaymentsettings.getWxpayAppId());
        	map2.put("timeStamp",timeStamp);
        	map2.put("nonceStr",nonce_str);
        	map2.put("package","prepay_id="+prepayidValue);
        	map2.put("signType","MD5");
        	String paySign=getSign(map2,"key",cinemapaymentsettings.getWxpayKey());
        	prePayParametersReply.setData(new PrePayParametersReplyParameter());
        	prePayParametersReply.getData().setTimeStamp(timeStamp);
        	prePayParametersReply.getData().setNonceStr(nonce_str);
        	prePayParametersReply.getData().setPackages("prepay_id="+prepayidValue);
        	prePayParametersReply.getData().setSignType("MD5");
        	prePayParametersReply.getData().setPaySign(paySign);
        }
        prePayParametersReply.SetSuccessReply();
		return prePayParametersReply;
	}
	//endregion
	
	//region 异步接收微信支付返回
	public void WxPayNotify() throws Exception{
		// 读取返回内容
		StringBuffer resultBuffer = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));
		String temp;
		while ((temp = br.readLine()) != null) {
			resultBuffer.append(temp);
		}
		//为了得到影院配置
		Document document=XmlHelper.StringTOXml(resultBuffer.toString());
		String outtradenoValue=XmlHelper.getNodeValue(document,"/xml/out_trade_no");
		String replysign=XmlHelper.getNodeValue(document,"/xml/sign");
		String return_code=XmlHelper.getNodeValue(document,"/xml/return_code");
		String result_code=XmlHelper.getNodeValue(document,"/xml/result_code");
		String transaction_id=XmlHelper.getNodeValue(document,"/xml/transaction_id");
		String err_code_des=XmlHelper.getNodeValue(document,"/xml/err_code_des");
		String CinemaCode = outtradenoValue.substring("yyyyMMddHHmmss".length(),22);
		Cinemapaymentsettings cinemapaymentsettings = _cinemapaymentsettingsService.getByCinemaCode(CinemaCode);
		
		Map<String, String> map=XmlHelper.xmlToMap(resultBuffer.toString());
		Map<String, String> signMap=new TreeMap<String, String>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if(entry.getKey()!="sign"){
				signMap.put(entry.getKey(), entry.getValue());
			}
        }
		String sign=getSign(signMap,"key",cinemapaymentsettings.getWxpayKey());
		if(sign.equals(replysign)){//判断签名
			//得到订单Id
			Long OrderID = Long.parseLong(outtradenoValue.substring("yyyyMMddHHmmss".length() + 8));
			OrderView order=_orderService.getOrderWidthId(OrderID);
			if(return_code.equals("SUCCESS")&& result_code.equals("SUCCESS")){
				//更新订单主表
				if (order.getOrderBaseInfo().getPayFlag()!=1)
                {
					order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Payed.getStatusCode());
					order.getOrderBaseInfo().setUpdated(new Date());
					order.getOrderBaseInfo().setOrderPayType(OrderPayTypeEnum.WxPay.getTypeCode());
					order.getOrderBaseInfo().setPayFlag(1);
					order.getOrderBaseInfo().setPayTime(new Date());
					order.getOrderBaseInfo().setOrderTradeNo(transaction_id);
					_orderService.UpdateOrderBaseInfo(order.getOrderBaseInfo());
                }
				//更新优惠券已使用
                for(Orderseatdetails seat:order.getOrderSeatDetails())
                {
                    if(!seat.getConponCode().equals(""))
                    {
                    	Coupons coupons=_couponsService.getByCouponsCode(seat.getConponCode());
                    	coupons.setStatus(CouponsStatusEnum.Used.getStatusCode());
                    	coupons.setUsedDate(new Date());
                    	_couponsService.update(coupons);
                    }
                }
			}else
			{
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.PayFail.getStatusCode());
				order.getOrderBaseInfo().setUpdated(new Date());
				order.getOrderBaseInfo().setErrorMessage(err_code_des);
                _orderService.UpdateOrderBaseInfo(order.getOrderBaseInfo());
			}
		}
	}
	//endregion
	
	//region 得到签名
	private String getSign(Map<String, String> map,String key,String value){
		StringBuilder sb=new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
        	sb.append(entry.getKey() + "=" + entry.getValue() + "&");
          }
        sb.append(key + "="+ value);
        String sign=MD5Util.MD5Encode(sb.toString(),"UTF-8").toUpperCase();
        return sign;
	}
	//endregion
	
	//region 组装Xml
	private String getXml(Map<String, String> map){
		StringBuilder sb=new StringBuilder();
        sb.append("<xml>");
        for (Map.Entry<String, String> entry : map.entrySet()) {
        	if(Pattern.compile("^[0-9.]$").matcher(entry.getValue()).find()){
        		sb.append("<" + entry.getKey() + ">" + entry.getValue() + "</" + entry.getKey() + ">");
        	}
        	else{
        		sb.append("<" + entry.getKey() + "><![CDATA[" + entry.getValue() + "]]></" + entry.getKey() + ">");
        	}
        }
        sb.append("</xml>");
        String data=sb.toString();
        return data;
	}
	//endregion
}
