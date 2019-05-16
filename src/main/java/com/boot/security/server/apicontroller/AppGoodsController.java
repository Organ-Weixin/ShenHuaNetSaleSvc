package com.boot.security.server.apicontroller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.api.core.CreateGoodsOrderReply;
import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.QueryGoodsOrderReply;
import com.boot.security.server.api.core.RefundGoodsReply;
import com.boot.security.server.api.core.SubmitGoodsOrderReply;
import com.boot.security.server.apicontroller.reply.CreateGoodsOrderQueryJson;
import com.boot.security.server.apicontroller.reply.ModelMapper;
import com.boot.security.server.apicontroller.reply.NetSaleQueryJson;
import com.boot.security.server.apicontroller.reply.QueryGoodsReply;
import com.boot.security.server.apicontroller.reply.QueryGoodsReply.QueryGoodsReplyGoodss;
import com.boot.security.server.apicontroller.reply.QueryGoodsReply.QueryGoodsReplyGoodss.QueryGoodsReplyGoods;
import com.boot.security.server.apicontroller.reply.QueryGoodsTypeReply;
import com.boot.security.server.apicontroller.reply.QueryGoodsTypeReply.QueryGoodsTypeReplyTypes;
import com.boot.security.server.apicontroller.reply.QueryGoodsTypeReply.QueryGoodsTypeReplyTypes.QueryGoodsTypeReplyType;
import com.boot.security.server.apicontroller.reply.QueryLocalGoodsOrderReply.QueryLocalGoodsOrderReplyOrder;
import com.boot.security.server.apicontroller.reply.QueryLocalGoodsOrderReply;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Goods;
import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.Goodstype;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.GoodsOrderServiceImpl;
import com.boot.security.server.service.impl.GoodsServiceImpl;
import com.boot.security.server.service.impl.GoodsTypeServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.google.gson.JsonSyntaxException;

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
		try {
			CreateGoodsOrderReply reply = NetSaleSvcCore.getInstance().CreateGoodsOrder(QueryJson.getUserName(), QueryJson.getPassword(), QueryJson.getQueryXml());
			//创建卖品订单时需要保存送货信息
			if(reply.Status.equals("Success")){
				Goodsorders orderbase=_goodsOrderService.getByLocalOrderCode(reply.getOrder().getOrderCode());
				orderbase.setOpenID(QueryJson.getOpenID());
				orderbase.setDeliveryType(QueryJson.getDeliveryType());
				orderbase.setDeliveryAddress(QueryJson.getDeliveryAddress());
				orderbase.setDeliveryTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(QueryJson.getDeliveryTime()));
				_goodsOrderService.UpdateOrderBaseInfo(orderbase);
			}
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
	
	//region 调用接口查询已完成订单的详情（远程）
	@GetMapping("/QueryGoodsOrder/{UserName}/{Password}/{CinemaCode}/{OrderCode}")
	@ApiOperation(value = "查询卖品订单")
	public QueryGoodsOrderReply QueryGoodsOrder(@PathVariable String UserName, @PathVariable String Password, 
			@PathVariable String CinemaCode, @PathVariable String OrderCode){
		QueryGoodsOrderReply reply = NetSaleSvcCore.getInstance().QueryGoodsOrder(UserName, Password, CinemaCode, OrderCode);
		
		return reply;
	}
	//endregion
	
	//region 查询本地卖品订单（支付时获取）
	@GetMapping("/QueryLocalGoodsOrder/{UserName}/{Password}/{CinemaCode}/{LocalOrderCode}")
	@ApiOperation(value = "查询本地卖品订单")
	public QueryLocalGoodsOrderReply QueryLocalGoodsOrder(@PathVariable String UserName, @PathVariable String Password, 
			@PathVariable String CinemaCode, @PathVariable String LocalOrderCode){
		QueryLocalGoodsOrderReply queryLocalGoodsOrderReply=new QueryLocalGoodsOrderReply();
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
}
