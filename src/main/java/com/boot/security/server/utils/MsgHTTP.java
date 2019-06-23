package com.boot.security.server.utils;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boot.security.server.model.MsgResponse;
import com.google.gson.Gson;

/**
 * 会员充值发送短信验证码
 * 三体的短信验证码通道
 * @author zpj
 * @date 2018/5/28 13:35
 */
public class MsgHTTP {
    private static Logger logger = LoggerFactory.getLogger(MsgHTTP.class);
    /** 发送短信API地址 */
    private static final String SEND_MSG_API_URL = "http://sms.smspaas.com/mt.php";

    /**
     * 创建签名
     * (appKey+appId+ mobile)生成MD5转小写字母
     * @param mobile 手机号
     * @return
     */
    private static String createSign(String APP_ID, String APP_KEY, String mobile, String vars,String MODEL_ID) {
        SortedMap<String, Object> args = new TreeMap<String, Object>();
        args.put("appId", APP_ID);
        args.put("modeId", MODEL_ID);
        if(vars!=null&&vars!=""){
        	args.put("vars", vars);
        }
        args.put("mobile", mobile);

        StringBuilder sb = new StringBuilder();
        Boolean flag = false;
        for (Map.Entry<String, Object> kv : args.entrySet()) {
            if (flag) {
                sb.append("&");
            }
            flag = true;
            sb.append(kv.getKey()).append("=").append(kv.getValue());
        }

        String sign = MD5Util.MD5Encode(APP_KEY + APP_ID + mobile, "UTF-8").toLowerCase();
        return ("?" + sb + "&sign=" + sign).replaceAll(" ", "%20");
    }

    /**
     * 发送短信
     * @param mobile 手机号
     * @param vars 短信模板变量
     * @return
     */
    public static boolean sendMessage(String APP_ID, String APP_KEY, String MODEL_ID,String mobile, String vars) {
        try {
            String url = SEND_MSG_API_URL + createSign(APP_ID, APP_KEY, mobile, vars, MODEL_ID);
            String param = createSign(APP_ID, APP_KEY, mobile, vars, MODEL_ID);
            String response = HttpHelper.sendPost(url, param);
            logger.info("发送验证码短信返回:"+mobile+":"+ response);
            MsgResponse mr =  new Gson().fromJson(response, MsgResponse.class);
            if(mr.getCode()==0){
            	return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
    	sendMessage("11231", "b42ae564a9", "15268553143", null, "214484");
	}
}
