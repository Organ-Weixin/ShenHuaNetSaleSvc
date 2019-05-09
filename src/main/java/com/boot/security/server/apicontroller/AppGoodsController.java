package com.boot.security.server.apicontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.api.core.CreateGoodsOrderReply;
import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.QueryGoodsOrderReply;
import com.boot.security.server.api.core.QueryGoodsReply;
import com.boot.security.server.api.core.RefundGoodsReply;
import com.boot.security.server.api.core.SubmitGoodsOrderReply;
import com.boot.security.server.apicontroller.reply.NetSaleQueryJson;
import com.google.gson.JsonSyntaxException;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/Goods")
public class AppGoodsController {

	@GetMapping("/QueryGoods/{UserName}/{Password}/{CinemaCode}")
	@ApiOperation(value = "查询影院卖品信息")
	public QueryGoodsReply QueryGoods(@PathVariable String UserName, @PathVariable String Password, @PathVariable String CinemaCode){
		QueryGoodsReply reply = NetSaleSvcCore.getInstance().QueryGoods(UserName, Password, CinemaCode);
		
		return reply;
	}
	
	@PostMapping("/CreateGoodsOrder")
	@ApiOperation(value = "创建卖品订单")
	public CreateGoodsOrderReply CreateGoodsOrder(@RequestBody NetSaleQueryJson QueryJson){
		try {
			CreateGoodsOrderReply reply = NetSaleSvcCore.getInstance().CreateGoodsOrder(QueryJson.getUserName(), QueryJson.getPassword(), QueryJson.getQueryXml());
		
			return reply;
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			return new CreateGoodsOrderReply();
		} catch (Exception e) {
			e.printStackTrace();
			return new CreateGoodsOrderReply();
		}
		
	}
	
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
	
	@GetMapping("/QueryGoodsOrder/{UserName}/{Password}/{CinemaCode}/{OrderCode}")
	@ApiOperation(value = "查询卖品订单")
	public QueryGoodsOrderReply QueryGoodsOrder(@PathVariable String UserName, @PathVariable String Password, 
			@PathVariable String CinemaCode, @PathVariable String OrderCode){
		QueryGoodsOrderReply reply = NetSaleSvcCore.getInstance().QueryGoodsOrder(UserName, Password, CinemaCode, OrderCode);
		
		return reply;
	}
	
	@GetMapping("/RefundGoods/{UserName}/{Password}/{CinemaCode}/{OrderCode}/{PaySeqNo}")
	@ApiOperation(value = "退订卖品")
	public RefundGoodsReply RefundGoods(@PathVariable String UserName, @PathVariable String Password, 
			@PathVariable String CinemaCode, @PathVariable String OrderCode,@PathVariable String PaySeqNo){
		RefundGoodsReply reply = NetSaleSvcCore.getInstance().RefundGoods(UserName, Password, CinemaCode, OrderCode, PaySeqNo);
		
		return reply;
	}
}
