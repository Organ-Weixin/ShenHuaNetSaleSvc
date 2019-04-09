package com.boot.security.server.utils;

import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class MD5Util {
	/**
     * @author zbb
     * @Description：辰星接口sign签名 校验信息=MD5（转换成小写（应用编码+参数1+参数2+…..+验证密钥））
     * @param characterEncoding 编码格式
     * @param parameters 请求参数 map形式
     * @param key 验证密钥
     * @return
     */
    public static String getCxSign(Map parameters,String key){
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(v);
            }
        }
        sb.append(key);
//        System.out.println(sb.toString().toLowerCase());
        String sign = MD5Util.MD5Encode(sb.toString().toLowerCase(),"UTF-8");
        return sign;
    }
    
    /**
     * @author zbb
     * @Description：辰星接口sign签名 校验信息=MD5（转换成小写（应用编码+参数1+参数2+…..+验证密钥））
     * @param characterEncoding 编码格式
     * @param parameters 请求参数 字符串形式
     * @param key 验证密钥
     * @return
     */
    public static String getCxSign(String parameters,String key){
        StringBuffer sb = new StringBuffer();
        sb.append(parameters);
        sb.append(key);
        System.out.println(sb.toString().toLowerCase());
        String sign = MD5Util.MD5Encode(sb.toString().toLowerCase(),"UTF-8");
        return sign;
    }

    /**
     * @autho gw 趣满满签名
     * @Description：sign签名
     * @param characterEncoding 编码格式
     * @param parameters 请求参数
     * @param key 商户支付密钥
     * @return
     */
    public static String getQmmSign(SortedMap parameters,String key){
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + v);
            }
        }
        sb.append(key);
//        System.out.println(sb.toString());
        String sign = MD5Util.MD5Encode(sb.toString(),"UTF-8");
        return sign;
    }

	/**
     * @author hcq
     * @Description：sign签名
     * @param characterEncoding 编码格式
     * @param parameters 请求参数
     * @param key 商户支付密钥
     * @return
     */
    public static String createSign(SortedMap parameters,String key){
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key="+key);
        String sign = MD5Util.MD5Encode(sb.toString(),"UTF-8").toUpperCase();
        return sign;
    }
    public static void main(String[]args){
    	SortedMap<String, String> map = new TreeMap<String, String>();
    	map.put("appid", "wxd930ea5d5a258f4f");
    	map.put("mch_id", "10000100");
    	map.put("device_info", "1000");
    	map.put("body", "test");
    	map.put("nonce_str", "ibuaiVcKdpRxkhJA");
    	System.out.println(createSign(map,"192006250b4c09247ec02edce69f6a2d"));
    }
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}

	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
}