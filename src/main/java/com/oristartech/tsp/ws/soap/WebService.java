package com.oristartech.tsp.ws.soap;

import com.boot.security.server.api.ctms.reply.CxQueryCinemaInfoResult;
import com.boot.security.server.api.ctms.reply.CxQueryCinemaListResult;
import com.boot.security.server.api.ctms.reply.CxQuerySeatInfoResult;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.utils.MD5Util;
import com.boot.security.server.utils.XmlToJsonUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/*import com.wxbusiness.adapter.DoubleDefaultAdapter;
import com.wxbusiness.adapter.IntegerDefaultAdapter;
import com.wxbusiness.common.PayConstant;
import com.wxbusiness.entities.*;
import com.wxbusiness.jsons.*;
import com.wxbusiness.payutils.MD5Util;
import com.wxbusiness.service.*;
import com.wxbusiness.utils.*;*/
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
//import org.apache.struts2.components.If;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.print.DocFlavor.READER;

import java.awt.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;


/**
 * @version 1.0
 * @author zbb
 * 辰星接口
 *
 */
public class WebService {
	protected static Logger log = LoggerFactory.getLogger(WebService.class);
	/**
	 * 辰星接口
	 * 初始化接口链接，返回接口集
	 * @return
	 */
	public static TspSoapService cinemaTss(String Url){
		TspSoapServiceImplServiceLocator css = new TspSoapServiceImplServiceLocator();
		css.setTspSoapServiceImplPortEndpointAddress(Url);
		TspSoapServiceImplService cs = css;
		//接口集
		TspSoapService cp;
		try {
			cp = cs.getTspSoapServiceImplPort();
			return cp;
		} catch (Exception e) {
//			log.error("cinema模块初始化失败"+e.getMessage());
		}
		return null;
	}
	
	/**
	 * 根据影院公司的 应用编码和验证密钥 查询这个影院下面所有的电影院列表
	 * @return
	 */
	public static CxQueryCinemaListResult  queryCinemaList(Usercinemaview userCinema){
		try{
			Map<String,String> param = new LinkedHashMap();
			param.put("pAppCode",userCinema.getDefaultUserName());
			param.put("pCompress", "0");
			String result =  WebService.cinemaTss(userCinema.getUrl()).queryCinemaList(userCinema.getDefaultUserName(), "0", MD5Util.getCxSign(param,userCinema.getDefaultPassword()));
			Gson gson = new Gson();
//			log.info(result);
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result,"QueryCinemaListResult"), CxQueryCinemaListResult.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询一个电影院的信息，包含了所有影厅的数量，座位数等
	 * @param pCinemaCode 影院编码
	 * @return
	 */
	public static CxQueryCinemaInfoResult QueryCinemaInfo(Usercinemaview userCinema){
		try{
			Map<String,String> param = new LinkedHashMap();
			param.put("pAppCode", userCinema.getDefaultUserName());
			param.put("pCinemaCode",userCinema.getCinemaCode());
			param.put("pCompress", "0");
			String result = WebService.cinemaTss(userCinema.getUrl()).queryCinemaInfo(userCinema.getDefaultUserName(),userCinema.getCinemaCode(), "0", MD5Util.getCxSign(param,userCinema.getDefaultPassword()));
			Gson gson = new Gson();
//			log.info(result);
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result,"QueryCinemaInfoResult"), CxQueryCinemaInfoResult.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询影院某影厅的座位信息（静态座位信息）
	 * @param pCinemaCode 影院编码,pScreenCode 影厅编码
	 * @return
	 */
	public static CxQuerySeatInfoResult QuerySeatInfo(Usercinemaview userCinema,String pScreenCode){
		try {
			Map<String,String> param = new LinkedHashMap<>();
			param.put("pAppCode", userCinema.getDefaultPassword());
			param.put("pAppCode", userCinema.getCinemaCode());
			param.put("pScreenCode", pScreenCode);
			param.put("pCompress", "0");
			String result = WebService.cinemaTss(userCinema.getUrl()).querySeatInfo(userCinema.getDefaultPassword(), userCinema.getCinemaCode(), pScreenCode, "0", MD5Util.getCxSign(param,userCinema.getDefaultPassword()));
			Gson gson = new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result,"QuerySeatInfoResult"),CxQuerySeatInfoResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String args[]){
		try{
			Usercinemaview userCinema = new Usercinemaview();
			userCinema.setUserName("SHUSER");
			userCinema.setPassword("eff6b9856b329b3db94ccf0f8f02a483");
			System.out.println(queryCinemaList(userCinema));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}  	
