package com.boot.security.server.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boot.security.server.apicontroller.reply.PayParametersReply;

public class WxPay {
	public static PayParametersReply PrepareParameters(PayParametersReply reply,String WxpayAppId,String WxpayMchId,String WxpayKey,String strbody, String notify_url, String OpenID,String out_trade_no,String time_expire,String total_fee)
    {
		//开始调用微信支付接口
        //微信支付统一下单接口
        String UnifiedOrderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        //时间戳
        String timeStamp = WxPayUtil.getTimestamp();
        //随机字符串 
        String nonceStr = WxPayUtil.getNoncestr();
        //创建支付应答对象
        RequestHandlerUtil packageReqHandler = new RequestHandlerUtil(null/*System.Web.HttpContext.Current*/);
        //初始化
        packageReqHandler.init();
        //设置package订单参数
        packageReqHandler.setParameter("appid", WxpayAppId);					//小程序ID
        packageReqHandler.setParameter("mch_id", WxpayMchId);					//商户号
        packageReqHandler.setParameter("nonce_str", nonceStr);
        packageReqHandler.setParameter("body", strbody);
        packageReqHandler.setParameter("out_trade_no", out_trade_no);			//商户订单号
        packageReqHandler.setParameter("total_fee", total_fee);					//标价金额		
        //packageReqHandler.setParameter("spbill_create_ip", System.Web.HttpContext.Current.Request.UserHostAddress);		//终端IP  用户的公网ip，不是商户服务器IP
        packageReqHandler.setParameter("notify_url", notify_url);				//通知地址
        packageReqHandler.setParameter("time_expire", time_expire);
        packageReqHandler.setParameter("trade_type", "JSAPI");
        //String sign = packageReqHandler.sign("key", WxpayKey);
        //packageReqHandler.setParameter("sign", sign);
        //把参数组装成xml
        Map<String,String> map = new HashMap();
        map.put("packageReqHandler", String.valueOf(packageReqHandler));
        String data = packageReqHandler.ArrayToXml(map);
		return reply;
    }
}
