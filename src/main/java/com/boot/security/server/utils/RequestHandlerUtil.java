package com.boot.security.server.utils;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.protocol.HttpContext;

public class RequestHandlerUtil {
	/**
    '签名工具类
     ============================================================================/// <summary>
    'api说明：
    'init();
    '初始化函数，默认给一些参数赋值。
    'setKey(key_)'设置商户密钥
    'createMd5Sign(signParams);字典生成Md5签名
    'genPackage(packageParams);获取package包
    'createSHA1Sign(signParams);创建签名SHA1
    'parseXML();输出xml
     * 
     * ============================================================================
     */
	//页面 this
	protected HttpContext httpContext;
	//哈希值
	protected Hashtable<String,String> parameters;
	public HttpContext getHttpContext() {
		return httpContext;
	}
	public void setHttpContext(HttpContext httpContext) {
		this.httpContext = httpContext;
	}
	public Hashtable<String,String> getParameters() {
		return parameters;
	}
	public void setParameters(Hashtable<String,String> parameters) {
		this.parameters = parameters;
	}
	public RequestHandlerUtil(HttpContext httpContext){
		parameters = new Hashtable<String,String>();
		this.httpContext = httpContext;
	}
	/** 初始化函数 */
    public void init(){
    	
    }
	/** 设置参数值 */
	public void setParameter(String parameter, String parameterValue)
    {
        if (parameter != null && parameter != "")
        {
            if (parameters.contains(parameter))
            {
                parameters.remove(parameter);
            }

            parameters.putIfAbsent(parameter, parameterValue);
        }
    }
	/**
	* 获取支付所需签名
	* @param ticket
	* @param timeStamp
	* @param card_id
	* @param code
	* @return
	* @throws Exception
	*/
	public  String getPayCustomSign(Map<String, String> bizObj,String key) throws Exception {
	    String bizString = FormatBizQueryParaMap(bizObj, false);
	    return sign(bizString, key);
	}
	/**
	* 字典排序
	* @param paraMap
	* @param urlencode
	* @return
	* @throws Exception
	*/
	public  String FormatBizQueryParaMap(Map<String, String> paraMap,
	  boolean urlencode) throws Exception {
	    String buff = "";
	    try {
	      List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(paraMap.entrySet());
	      Collections.sort(infoIds,
	          new Comparator<Map.Entry<String, String>>() {
	      public int compare(Map.Entry<String, String> o1,
	         Map.Entry<String, String> o2) {
	         return (o1.getKey()).toString().compareTo(
	                  o2.getKey());
	            }
	          });
	      for (int i = 0; i < infoIds.size(); i++) {
	        Map.Entry<String, String> item = infoIds.get(i);
	        if (item.getKey() != "") {
	          String key = item.getKey();
	          String val = item.getValue();
	          if (urlencode) {
	            val = URLEncoder.encode(val, "utf-8");
	          }
	          buff += key + "=" + val + "&";
	        }
	      }
	      if (buff.isEmpty() == false) {
	        buff = buff.substring(0, buff.length() - 1);
	      }
	    } catch (Exception e) {
	      throw new Exception(e.getMessage());
	    }
	    return buff;
	}
	//支付所需签名处调用此方法
	public  String sign(String content, String key)
	  throws Exception{
	    String signStr = "";
	    signStr = content + "&key=" + key;
	    return MD5Util.MD5Encode(signStr, "GBK");
	}
	//转为XML格式
	public  String ArrayToXml(Map<String, String> arr) {
	    String xml = "<xml>";
	    Iterator<Entry<String, String>> iter = arr.entrySet().iterator();
	    while (iter.hasNext()) {
	      Entry<String, String> entry = iter.next();
	      String key = entry.getKey();
	      String val = entry.getValue();
	      if (IsNumeric(val)) {
	        xml += "<" + key + ">" + val + "</" + key + ">";
	      } else
	        xml += "<" + key + "><![CDATA[" + val + "]]></" + key + ">";
	    }
	    xml += "</xml>";
	    return xml;
	}
	public  boolean IsNumeric(String str) {
	    if (str.matches("\\d *")) {
	      return true;
	    } else {
	      return false;
	    }
	}
	
}
