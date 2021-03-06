package com.boot.security.server.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.regex.Pattern;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;

import com.boot.security.server.apicontroller.reply.PrePayParametersReply;
import com.boot.security.server.apicontroller.reply.PrePayParametersReply.PrePayParametersReplyParameter;
import com.boot.security.server.model.Cinemapaymentsettings;
import com.boot.security.server.service.impl.CinemapaymentsettingsServiceImpl;

public class WxPayUtil {
	//连接超时时间，默认10秒
    private static int socketTimeout = 10000;
    //传输超时时间，默认30秒
    private static int connectTimeout = 30000;
    //请求器的配置
    private static RequestConfig requestConfig;
	//HTTP请求器
    private static CloseableHttpClient httpClient;

	//region 准备支付参数
	public static PrePayParametersReply WxPayPrePay(HttpServletRequest request, PrePayParametersReply reply,
			String WxpayAppId, String WxpayMchId, String WxpayKey, String strbody, String NotifyUrl, String OpenId,
			String TradeNo, String ExpireDate, String TotalFee) throws IOException {
		String nonce_str = MD5Util.MD5Encode(String.valueOf(new Random().nextInt(1000)), "UTF-8");
		//System.out.println(StrUtil.getIpAddress(request));
		Map<String, String> map = new TreeMap<String, String>();
		map.put("appid", WxpayAppId);//小程序appid
		map.put("body", strbody);// 商品信息
		map.put("mch_id", WxpayMchId);
		map.put("nonce_str", nonce_str.toLowerCase());
		map.put("notify_url", NotifyUrl);
		map.put("openid", OpenId);
		map.put("out_trade_no", TradeNo);// 商家交易号
		map.put("spbill_create_ip",StrUtil.getMyIP());//StrUtil.getIpAddress(request)
		map.put("time_expire", ExpireDate);
		map.put("total_fee", TotalFee);
		map.put("trade_type", "JSAPI");
		String sign = getSign(map, "key", WxpayKey, "UTF-8");
		map.put("sign", sign);
		// 把参数组装成xml
		String data = getXml(map);
		System.out.println(data);
		String UnifiedOrderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		String strPrepayXml = HttpHelper.sendPostByHttpUrlConnection(UnifiedOrderUrl, data, "UTF-8");
		// 获取prepay_id
		String strPrePayXml2 = strPrepayXml.replace("<![CDATA[", "").replace("]]>", "");
		System.out.println("============="+strPrePayXml2);
		Document document = XmlHelper.StringTOXml(strPrePayXml2);
		String resultcodeValue = XmlHelper.getNodeValue(document, "/xml/result_code");
		String errcodeValue=XmlHelper.getNodeValue(document, "/xml/err_code");
//		String errcodedesValue = XmlHelper.getNodeValue(document, "/xml/err_code_des");
		String returnMsg = XmlHelper.getNodeValue(document, "/xml/return_msg");
		System.out.println("返回");
		String prepayidValue = XmlHelper.getNodeValue(document, "/xml/prepay_id");
		if (resultcodeValue.equals("SUCCESS")) {
			// 再定义一个map准备签名paysign
			String timeStamp = String.valueOf(System.currentTimeMillis());
			Map<String, String> map2 = new TreeMap<String, String>();
			map2.put("appId", WxpayAppId);
			map2.put("timeStamp", timeStamp);
			map2.put("nonceStr", nonce_str);
			map2.put("package", "prepay_id=" + prepayidValue);
			map2.put("signType", "MD5");
			String paySign = getSign(map2, "key", WxpayKey, "UTF-8");
			reply.setData(new PrePayParametersReplyParameter());
			reply.getData().setTimeStamp(timeStamp);
			reply.getData().setNonceStr(nonce_str);
			reply.getData().setPackages("prepay_id=" + prepayidValue);
			reply.getData().setSignType("MD5");
			reply.getData().setPaySign(paySign);
			reply.SetSuccessReply();
		} else {
			reply.Status = "Failure";
			reply.ErrorCode = errcodeValue;
			reply.ErrorMessage = returnMsg;
		}
		return reply;
	}
	//endregion
	
	//region 处理回调
	public static Map<String, String> WxPayNotify(HttpServletRequest request) throws Exception{
		StringBuffer resultBuffer = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String temp;
		while ((temp = br.readLine()) != null) {
			resultBuffer.append(temp);
		}
		br.close();
		System.out.println("-------------"+resultBuffer.toString());
		//为了得到影院配置
		Document document=XmlHelper.StringTOXml(resultBuffer.toString());
		String outtradenoValue=XmlHelper.getNodeValue(document,"/xml/out_trade_no");
		String replysign=XmlHelper.getNodeValue(document,"/xml/sign");
		String return_code=XmlHelper.getNodeValue(document,"/xml/return_code");
		String result_code=XmlHelper.getNodeValue(document,"/xml/result_code");
		String transaction_id=XmlHelper.getNodeValue(document,"/xml/transaction_id");
		String err_code_des=XmlHelper.getNodeValue(document,"/xml/err_code_des");
		String CinemaCode = outtradenoValue.substring("yyyyMMddHHmmss".length(),22);
		
		Map<String, String> map=XmlHelper.xmlToMap(resultBuffer.toString());
		Map<String, String> signMap=new TreeMap<String, String>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if(entry.getKey()!="sign"){
				signMap.put(entry.getKey(), entry.getValue());
			}
        }
		//静态方法调用非静态方法要在静态方法里面New
		CinemapaymentsettingsServiceImpl _cinemapaymentsettingsService = SpringUtil.getBean(CinemapaymentsettingsServiceImpl.class);
		Cinemapaymentsettings cinemapaymentsettings = _cinemapaymentsettingsService.getByCinemaCode(CinemaCode);
		
		//微信服务器编码方式gb2312
		String sign=getSign(signMap,"key",cinemapaymentsettings.getWxpayKey(),"gb2312");
		
		Map<String, String> returnmap=new HashMap<String, String>();
		returnmap.put("isWXsign",sign.equals(replysign)?"True":"false");//判断签名
		returnmap.put("out_trade_no",outtradenoValue);
		returnmap.put("return_code",return_code);
		returnmap.put("result_code",result_code);
		returnmap.put("transaction_id",transaction_id);
		returnmap.put("err_code_des",err_code_des);
		return returnmap;
	}
	//endregion

	// region 得到签名
	private static String getSign(Map<String, String> map, String key, String value, String charset) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sb.append(entry.getKey() + "=" + entry.getValue() + "&");
		}
		sb.append(key + "=" + value);
		//System.out.println(sb);
		String sign = MD5Util.MD5Encode(sb.toString(), charset).toUpperCase();
		return sign;
	}
	// endregion

	// region 组装Xml
	private static String getXml(Map<String, String> map) {
		StringBuilder sb = new StringBuilder();
		sb.append("<xml>");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (Pattern.compile("^[0-9.]$").matcher(entry.getValue()).find()) {
				sb.append("<" + entry.getKey() + ">" + entry.getValue() + "</" + entry.getKey() + ">");
			} else {
				sb.append("<" + entry.getKey() + "><![CDATA[" + entry.getValue() + "]]></" + entry.getKey() + ">");
			}
		}
		sb.append("</xml>");
		String data = sb.toString();
		return data;
	}
	// endregion

	//region 退款
	public static String WxPayRefund(String WxpayAppId,String WxpayMchId,String WxpayKey,String TradeNo,String RefundFee,String TotalFee,String OrderTradeNo,String CinemaCode,String WxpayRefundCert) throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException, IOException{
		String nonce_str = MD5Util.MD5Encode(String.valueOf(new Random().nextInt(1000)), "UTF-8");
		Map<String, String> map = new TreeMap<String, String>();
		map.put("appid", WxpayAppId);
		map.put("mch_id",WxpayMchId);
		map.put("nonce_str",nonce_str.toLowerCase());
		map.put("op_user_id",WxpayMchId);
		map.put("out_refund_no",TradeNo);//商家退款单号
		//map.put("out_trade_no","");
		map.put("refund_fee",RefundFee);//
		map.put("total_fee",TotalFee);//
		map.put("transaction_id",OrderTradeNo);
		String sign = getSign(map, "key", WxpayKey, "UTF-8");
		map.put("sign",sign);
		// 把参数组装成xml
		String data = getXml(map);
		System.out.println(data);
		String url = "https://api.mch.weixin.qq.com/secapi/pay/refund";//微信退款接口地址
		//初始化证书
		initCert(WxpayMchId,CinemaCode,WxpayRefundCert);
		String strRefundPaymentXml = httpsRequest(url,data);
		return strRefundPaymentXml;
	}
	//endregion
	
	//region 初始化微信退款证书
	public static void initCert(String WxpayMchId, String CinemaCode,String WxpayRefundCert) throws IOException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {
        //本地或者服务器的证书位置（证书在微信支付申请成功发来的通知邮件中）
		//String cert=ResourceUtils.getURL("classpath:").getPath()+File.separator+"static/cert/"+CinemaCode+"/"+WxpayRefundCert;
		String cert=new File(System.getProperty("catalina.home")).getAbsolutePath()+File.separator+"webapps/cert/"+CinemaCode+"/"+WxpayRefundCert;
		//System.out.println("退款证书："+cert);
		//私钥（在安装证书时设置）
		String password = WxpayMchId;
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        //加载本地的证书进行https加密传输
        FileInputStream instream = new FileInputStream(new File(cert));
        try {
            keyStore.load(instream, password.toCharArray());  //加载证书密码，默认为商户ID
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            instream.close();
        }
        // Trust own CA and all self-signed certs
        SSLContext sslcontext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, password.toCharArray())//加载证书密码，默认为商户ID
                .build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[]{"TLSv1"},
                null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .build();
        //根据默认超时限制初始化requestConfig
        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
    }
	//endregion
	
	//region 微信退款请求
	public static String httpsRequest(String url, String data) throws IOException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {
		
        String result = null;
        HttpPost httpPost = new HttpPost(url);
        //System.out.println("传输内容："+data);
        //得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
        StringEntity postEntity = new StringEntity(data, "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.setEntity(postEntity);
 
        //设置请求器的配置
        httpPost.setConfig(requestConfig);
        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
            //System.out.println("result:"+result);
        } catch (Exception e) {
        } finally {
            httpPost.abort();
        }
        return result;
    }
	//endregion
}
