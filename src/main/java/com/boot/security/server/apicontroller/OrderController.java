package com.boot.security.server.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.api.core.LockSeatReply;
import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.apicontroller.reply.NetSaleQueryJson;
import com.boot.security.server.model.Orders;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.OrderServiceImpl;
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
	private CinemaServiceImpl _cinemaService;
	@Autowired
	private OrderServiceImpl _orderService;
	
	@PostMapping("/LockSeat")
	@ApiOperation(value = "锁座")
	public LockSeatReply LockSeat(@RequestBody NetSaleQueryJson QueryJson){
		try {
			System.out.println("+++++"+new Gson().toJson(QueryJson));
			LockSeatReply lockSeatReply =NetSaleSvcCore.getInstance().LockSeat(QueryJson.getUserName(),QueryJson.getPassword(),QueryJson.getQueryXml());
			System.out.println("+++++"+new Gson().toJson(lockSeatReply));
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
}
