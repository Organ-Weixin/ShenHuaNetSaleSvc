package com.boot.security.server.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.SendSmsResponse;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.google.gson.Gson;

/**
 * 发送短信验证码
 * @author sheng
 *
 */
public class SendSmsHelper {

/*	private static String Account="15700002025";	//接口账号
	private static String Pwd="004ea1a9c732d4c260ec38ff5";	//登录web平台 http://sms.feige.ee  在管理中心--基本资料--接口密码 或者首页 接口秘钥 如登录密码修改，接口密码会发生改变，请及时修改程序
	private static String SignId="75627";			//登录web平台 http://sms.feige.ee  在签名管理中--新增签名--获取id
*/	
	CinemaServiceImpl cinemaService = SpringUtil.getBean(CinemaServiceImpl.class);
	
	public String SendSms(String cinemaCode,String MobilePhone,String MsgConetnt){
		Cinema cinema = cinemaService.getByCinemaCode(cinemaCode);
		try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;
            
            try {
                List<BasicNameValuePair> formparams = new ArrayList<>();
                formparams.add(new BasicNameValuePair("Account",cinema.getSmsAccount()));
			    formparams.add(new BasicNameValuePair("Pwd",cinema.getSmsPwd()));//登录后台 首页显示
			    formparams.add(new BasicNameValuePair("Content",MsgConetnt));
			    formparams.add(new BasicNameValuePair("Mobile",MobilePhone));
			    formparams.add(new BasicNameValuePair("SignId",cinema.getSmsSignId()));//登录后台 添加签名获取id	
			   
                HttpPost httpPost = new HttpPost("http://api.feige.ee/SmsService/Send");
                httpPost.setEntity(new UrlEncodedFormEntity(formparams,"UTF-8"));
                client = HttpClients.createDefault();
                response = client.execute(httpPost);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                SendSmsResponse sendSmsResponse = new Gson().fromJson(result, SendSmsResponse.class);
                if(sendSmsResponse.getCode()==0 && "OK".equals(sendSmsResponse.getMessage())){
                	return "Success";
                } else {
                	return "Failure";
                }
                
            } finally {
                if (response != null) {
                    response.close();
                }
                if (client != null) {
                    client.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	
}
