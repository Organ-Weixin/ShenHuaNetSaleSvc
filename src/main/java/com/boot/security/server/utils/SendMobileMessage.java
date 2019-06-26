package com.boot.security.server.utils;


import org.apache.commons.lang.StringUtils;

/**
 * 批量发送短信(支持单条发送)
 * phone以"," 拼接
 * message短信内容
 * batchNum批次号可为空,不允许重复！正式启用接口时可以考虑使用账户名+自然数若干位作为batch_num.
 * 建议对该参数做日志，可与厂商校验提交问题
 * return 0表示发送成功,其他表示发送失败
 */
public class SendMobileMessage {
    public static final String SENDURL="https://api.zhuanxinyun.com/api/v2/sendSms.json";
    //public static final String APPKEY = "V5EmranR0DzKKyBdxzFdeSpnu9C60FnN";
    //public static final String APPSECRET = "b2c867409f289f044da02ca7ea2cc8071125";


    public static String sendMessage(String APPKEY, String APPSECRET, String phone, String message) {
        return "该方法已作废,为了防止原来其他地方报错,重载该方法";
    }
    public static String sendMessage(String APPKEY, String APPSECRET, String phone, String message,String batchNum) {
        try{
            String content = "【神画电影】"+message;
            String params = "appKey="+APPKEY+"&appSecret="+APPSECRET+"&phones="+phone+"&content="+content;
            if(StringUtils.isNotBlank(batchNum)){
                params=params+"&batchNum="+batchNum;
            }
            //String re = HttpUtils.sendPost(SENDURL,params);
            String re = HttpHelper.sendPost(SENDURL, params);
            /*Map<String,String> reMap = (Map) JsonUtils.deserializeJson(re);
            if(reMap.get("errorCode").equals("000000")){ //发送成功
                return "0";
            }*/
            return "0";
            //return reMap.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "-1";
    }

    public static boolean isMobile(String mobiles) {
        if(!"".equals(mobiles)&&mobiles.length()==11){
            return true;
        }else{
            return false;
        }
    }

}
