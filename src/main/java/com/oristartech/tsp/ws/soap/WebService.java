package com.oristartech.tsp.ws.soap;

import com.boot.security.server.api.ctms.reply.CxApplyFetchTicketParameter;
import com.boot.security.server.api.ctms.reply.CxApplyFetchTicketParameter.CxApplyFetchTicketXmlTickets;
import com.boot.security.server.api.ctms.reply.CxApplyFetchTicketParameter.CxApplyFetchTicketXmlTickets.CxApplyFetchTicketXmlTicket;
import com.boot.security.server.api.ctms.reply.CxApplyFetchTicketResult;
import com.boot.security.server.api.ctms.reply.CxCancelOrderResult;
import com.boot.security.server.api.ctms.reply.CxFetchTicketParameter;
import com.boot.security.server.api.ctms.reply.CxFetchTicketParameter.CxFetchTicketXmlTickets;
import com.boot.security.server.api.ctms.reply.CxFetchTicketParameter.CxFetchTicketXmlTickets.CxFetchTicketXmlTicket;
import com.boot.security.server.api.ctms.reply.CxFetchTicketResult;
import com.boot.security.server.api.ctms.reply.CxLockSeatParameter;
import com.boot.security.server.api.ctms.reply.CxLockSeatParameter.CxLockSeatXmlSeatInfos;
import com.boot.security.server.api.ctms.reply.CxQueryDiscountFacts.planInfoBean;
import com.boot.security.server.api.ctms.reply.CxLockSeatResult;
import com.boot.security.server.api.ctms.reply.CxMemberChargeResult;
import com.boot.security.server.api.ctms.reply.CxMemberConsumeResult;
import com.boot.security.server.api.ctms.reply.CxMemberTransactionCancelResult;
import com.boot.security.server.api.ctms.reply.CxPhoneNumRegResult;
import com.boot.security.server.api.ctms.reply.CxQueryCinemaInfoResult;
import com.boot.security.server.api.ctms.reply.CxQueryCinemaListResult;
import com.boot.security.server.api.ctms.reply.CxQueryDeliveryStatusResult;
import com.boot.security.server.api.ctms.reply.CxQueryDiscountActivityResult;
import com.boot.security.server.api.ctms.reply.CxQueryDiscountFacts;
import com.boot.security.server.api.ctms.reply.CxQueryFilmInfoByDatePeriodResult;
import com.boot.security.server.api.ctms.reply.CxQueryFilmInfoResult;
import com.boot.security.server.api.ctms.reply.CxQueryMemberFlowInfoResult;
import com.boot.security.server.api.ctms.reply.CxQueryMemberInfoResult;
import com.boot.security.server.api.ctms.reply.CxQueryMemberLevelResult;
import com.boot.security.server.api.ctms.reply.CxQueryOrderStatusResult;
import com.boot.security.server.api.ctms.reply.CxQueryPlanInfoByDatePeriodResult;
import com.boot.security.server.api.ctms.reply.CxQueryPlanSeatResult;
import com.boot.security.server.api.ctms.reply.CxQuerySeatInfoResult;
import com.boot.security.server.api.ctms.reply.CxQueryTicketInfoParameter;
import com.boot.security.server.api.ctms.reply.CxQueryTicketInfoParameter.CxQueryTicketInfoXmlTickets;
import com.boot.security.server.api.ctms.reply.CxQueryTicketInfoParameter.CxQueryTicketInfoXmlTickets.CxQueryTicketInfoXmlTicket;
import com.boot.security.server.api.ctms.reply.CxQueryTicketInfoResult;
import com.boot.security.server.api.ctms.reply.CxReleaseSeatParameter;
import com.boot.security.server.api.ctms.reply.CxReleaseSeatParameter.CxReleaseSeatXmlSeatInfos;
import com.boot.security.server.api.ctms.reply.CxReleaseSeatResult;
import com.boot.security.server.api.ctms.reply.CxSubmitOrderParameter;
import com.boot.security.server.api.ctms.reply.CxSubmitOrderParameter.CxSubmitOrderXmlSeatInfos;
import com.boot.security.server.api.ctms.reply.CxSubmitOrderParameter.CxSubmitOrderXmlSeatInfos.CxSubmitOrderXmlSeatInfo;
import com.boot.security.server.api.ctms.reply.CxSubmitOrderResult;
import com.boot.security.server.api.ctms.reply.CxVerifyMemberLoginResult;
import com.boot.security.server.model.CardChargeTypeEnum;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.utils.JaxbXmlUtil;
import com.boot.security.server.utils.MD5Util;
import com.boot.security.server.utils.XmlToJsonUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.awt.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0 辰星接口
 */
public class WebService {
	protected static Logger log = LoggerFactory.getLogger(WebService.class);

	// region 初始化接口链接，返回接口集
	/**
	 * 辰星接口 初始化接口链接，返回接口集
	 * 
	 * @return
	 */
	public static TspSoapService cinemaTss(String Url) {
		TspSoapServiceImplServiceLocator css = new TspSoapServiceImplServiceLocator();
		css.setTspSoapServiceImplPortEndpointAddress(Url);
		TspSoapServiceImplService cs = css;
		// 接口集
		TspSoapService cp;
		try {
			cp = cs.getTspSoapServiceImplPort();
			return cp;
		} catch (Exception e) {
			// log.error("cinema模块初始化失败"+e.getMessage());
		}
		return null;
	}
	// endregion

	// region 查询影院列表(不用)
	/**
	 * 根据影院公司的 应用编码和验证密钥 查询这个影院下面所有的电影院列表
	 * 
	 * @return
	 */
	public static CxQueryCinemaListResult queryCinemaList(Usercinemaview userCinema) {
		try {
			Map<String, String> param = new LinkedHashMap();
			param.put("pAppCode", userCinema.getDefaultUserName());
			param.put("pCompress", "0");
			String result = WebService.cinemaTss(userCinema.getUrl()).queryCinemaList(userCinema.getDefaultUserName(),
					"0", MD5Util.getCxSign(param, userCinema.getDefaultPassword()));
			Gson gson = new Gson();
			// log.info(result);
			String json=XmlToJsonUtil.xmltoJson(result, "QueryCinemaListResult");
			return gson.fromJson(json,
					CxQueryCinemaListResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// endregion

	// region 查询影厅(完成)
	/**
	 * 查询一个电影院的信息，包含了所有影厅的数量，座位数等
	 * 
	 * @param pCinemaCode
	 *            影院编码
	 * @return
	 */
	public static CxQueryCinemaInfoResult QueryCinemaInfo(Usercinemaview userCinema) {
		try {
			Map<String, String> param = new LinkedHashMap();
			param.put("pAppCode", userCinema.getRealUserName());
			param.put("pCinemaCode", userCinema.getCinemaCode());
			param.put("pCompress", "0");
			String result = WebService.cinemaTss(userCinema.getUrl()).queryCinemaInfo(userCinema.getRealUserName(),
					userCinema.getCinemaCode(), "0", MD5Util.getCxSign(param, userCinema.getRealPassword()));
			Gson gson = new Gson();
			// log.info(result);
			String json=XmlToJsonUtil.xmltoJson(result, "QueryCinemaInfoResult");
			log.info(json);
			return gson.fromJson(json,
					CxQueryCinemaInfoResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// endregion

	// region 查询座位(完成)
	/**
	 * 查询某个影院的某个影厅座位信息 包含编号，坐标等信息
	 * 
	 * @param pCinemaCode
	 *            影院编码
	 * @param ScreenCode
	 *            影厅编码
	 * @return
	 */
	public static CxQuerySeatInfoResult QuerySeatInfo(Usercinemaview userCinema, String ScreenCode) {
		try {
			Map<String, String> param = new LinkedHashMap();
			param.put("pAppCode", userCinema.getRealUserName());
			param.put("pCinemaCode", userCinema.getCinemaCode());
			param.put("pScreenCode", ScreenCode);
			param.put("pCompress", "0");
			String result = WebService.cinemaTss(userCinema.getUrl()).querySeatInfo(userCinema.getRealUserName(),
					userCinema.getCinemaCode(), ScreenCode, "0",
					MD5Util.getCxSign(param, userCinema.getRealPassword()));
			Gson gson = new Gson();
			// log.info("=======================================pCinemaCode:"+pCinemaCode+";ScreenCode:"+ScreenCode+result);
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "QuerySeatInfoResult"), CxQuerySeatInfoResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// endregion

	// region 查询影片信息(不用)
	public static CxQueryFilmInfoResult QueryFilmInfo(Usercinemaview userCinema, String PlanDate) {
		try {
			Map<String, String> param = new LinkedHashMap();
			param.put("pAppCode", userCinema.getRealUserName());
			param.put("pCinemaCode", userCinema.getCinemaCode());
			param.put("pPlanDate", PlanDate);
			param.put("pCompress", "0");
			String result = WebService.cinemaTss(userCinema.getUrl()).queryFilmInfo(userCinema.getRealUserName(),
					userCinema.getCinemaCode(), PlanDate, "0", MD5Util.getCxSign(param, userCinema.getRealPassword()));
			Gson gson = new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "QueryFilmInfoResult"), CxQueryFilmInfoResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// endregion

	// region 按时间段查询影片信息(完成)
	public static CxQueryFilmInfoByDatePeriodResult QueryFilmInfoByDatePeriod(Usercinemaview userCinema,
			String pPlanStartDate, String pPlanEndDate) {
		try {
			log.info("===========================查询在售影片开始时间：" + pPlanStartDate + ";结束时间：" + pPlanEndDate);
			Map<String, String> param = new LinkedHashMap();
			param.put("pAppCode", userCinema.getRealUserName());
			param.put("pCinemaCode", userCinema.getCinemaCode());
			param.put("pPlanStartDate", pPlanStartDate);
			param.put("pPlanEndDate", pPlanEndDate);
			param.put("pCompress", "0");
			String result = WebService.cinemaTss(userCinema.getUrl()).queryFilmInfoByDatePeriod(
					userCinema.getRealUserName(), userCinema.getCinemaCode(), pPlanStartDate, pPlanEndDate, "0",
					MD5Util.getCxSign(param, userCinema.getRealPassword()));
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd")
					.registerTypeAdapter(Integer.class, new IntegerDefaultAdapter())
					.registerTypeAdapter(Double.class, new DoubleDefaultAdapter()).create();
			log.info("===========================查询在售影片结果：" + result);
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "QueryFilmInfoByDatePeriodResult"),
					CxQueryFilmInfoByDatePeriodResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// endregion

	// region 按时间段查询场次信息(完成)
	public static CxQueryPlanInfoByDatePeriodResult QueryPlanInfoByDatePeriod(Usercinemaview userCinema,
			String pPlanStartDate, String pPlanEndDate) {
		try {
			log.info("===========================按日期段查询放映计划，开始时间：" + pPlanStartDate + ";结束时间：" + pPlanEndDate);
			Map<String, String> param = new LinkedHashMap();
			param.put("pAppCode", userCinema.getRealUserName());
			param.put("pCinemaCode", userCinema.getCinemaCode());
			param.put("pPlanStartDate", pPlanStartDate);
			param.put("pPlanEndDate", pPlanEndDate);
			param.put("pCompress", "0");
			String result = WebService.cinemaTss(userCinema.getUrl()).queryPlanInfoByDatePeriod(
					userCinema.getRealUserName(), userCinema.getCinemaCode(), pPlanStartDate, pPlanEndDate, "0",
					MD5Util.getCxSign(param, userCinema.getRealPassword()));
			log.info(result);
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
					.registerTypeAdapter(Integer.class, new IntegerDefaultAdapter())
					.registerTypeAdapter(Double.class, new DoubleDefaultAdapter()).create();
			// log.info("===========================按日期段查询放映计划结果:"+result);
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "QueryPlanInfoByDatePeriodResult"),
					CxQueryPlanInfoByDatePeriodResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// endregion

	// region 查询场次座位(完成)
	public static CxQueryPlanSeatResult QueryPlanSeat(Usercinemaview userCinema, String pFeatureAppNo, String pStatus) {
		try {
			Map<String, String> param = new LinkedHashMap();
			param.put("pAppCode", userCinema.getRealUserName());
			param.put("pCinemaCode", userCinema.getCinemaCode());
			param.put("pFeatureAppNo", pFeatureAppNo);
			param.put("pStatus", pStatus);
			param.put("pCompress", "0");
			// log.info(param.toString());
			// log.info(MD5Util.getCxSign(param, PayConstant.signkey));
			String result = WebService.cinemaTss(userCinema.getUrl()).queryPlanSeat(userCinema.getRealUserName(),
					userCinema.getCinemaCode(), pFeatureAppNo, pStatus, "0",
					MD5Util.getCxSign(param, userCinema.getRealPassword()));
			Gson gson = new Gson();
			log.info(result);
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "QueryPlanSeatResult"), CxQueryPlanSeatResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// endregion

	// region 锁座(完成)
	public static CxLockSeatResult LockSeat(Usercinemaview userCinema, OrderView orderview) {
		try {
			// 用来生成验证码
			Map<String, String> map = new LinkedHashMap();
			map.put("AppCode", userCinema.getRealUserName());
			map.put("CinemaCode", userCinema.getCinemaCode());
			map.put("FeatureAppNo", orderview.getOrderBaseInfo().getSessionCode());// 场次编码
			StringBuffer SeatInfos = new StringBuffer();
			orderview.getOrderSeatDetails().forEach(n -> SeatInfos.append(n.getSeatCode()));
			map.put("SeatInfos", SeatInfos.toString());
			//log.info("SeatInfos:"+SeatInfos.toString());
			map.put("Compress", "0");
			// 最后的请求参数
			CxLockSeatParameter param = new CxLockSeatParameter();
			param.setAppCode(userCinema.getRealUserName());
			param.setCinemaCode(userCinema.getCinemaCode());
			param.setFeatureAppNo(orderview.getOrderBaseInfo().getSessionCode());// 场次编码
			CxLockSeatXmlSeatInfos seatInfos = new CxLockSeatParameter.CxLockSeatXmlSeatInfos();
			List<String> seacodes = new ArrayList<String>();
			orderview.getOrderSeatDetails().forEach(n -> seacodes.add(n.getSeatCode()));
			seatInfos.setSeatCode(seacodes);
			param.setSeatInfos(seatInfos);
			param.setCompress("0");
			String VerifyInfo = MD5Util.getCxSign(map, userCinema.getRealPassword());
			param.setVerifyInfo(VerifyInfo);

			// 把请求参数转成XML
			String LockSeatXml = JaxbXmlUtil.convertToXml(param);
			log.info(LockSeatXml);
			log.info(userCinema.getUrl());
			String result = WebService.cinemaTss(userCinema.getUrl()).lockSeat(LockSeatXml);
			log.info(result);
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
					.registerTypeAdapter(Integer.class, new IntegerDefaultAdapter())
					.registerTypeAdapter(Double.class, new DoubleDefaultAdapter()).create();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "LockSeatResult"), CxLockSeatResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// endregion

	// region 释放座位(完成)
	public static CxReleaseSeatResult ReleaseSeat(Usercinemaview userCinema, OrderView orderview) {
		try {
			// 用来生成验证码
			Map<String, String> map = new LinkedHashMap();
			map.put("AppCode", userCinema.getRealUserName());
			map.put("CinemaCode", userCinema.getCinemaCode());
			map.put("OrderCode", orderview.getOrderBaseInfo().getLockOrderCode());// 锁座订单号
			map.put("FeatureAppNo", orderview.getOrderBaseInfo().getSessionCode());// 场次编码
			StringBuffer SeatInfos = new StringBuffer();
			orderview.getOrderSeatDetails().forEach(n -> SeatInfos.append(n.getSeatCode()));
			map.put("SeatInfos", SeatInfos.toString());
			map.put("Compress", "0");

			// 最后的请求参数
			CxReleaseSeatParameter param = new CxReleaseSeatParameter();
			param.setAppCode(userCinema.getRealUserName());
			param.setCinemaCode(userCinema.getCinemaCode());
			param.setOrderCode(orderview.getOrderBaseInfo().getLockOrderCode());// 锁座订单号
			param.setFeatureAppNo(orderview.getOrderBaseInfo().getSessionCode());// 场次编码
			CxReleaseSeatXmlSeatInfos seatInfos = new CxReleaseSeatParameter.CxReleaseSeatXmlSeatInfos();
			List<String> seatcodes = new ArrayList<String>();
			orderview.getOrderSeatDetails().forEach(n -> seatcodes.add(n.getSeatCode()));
			seatInfos.setSeatCode(seatcodes);
			param.setSeatInfos(seatInfos);
			param.setCompress("0");
			String VerifyInfo = MD5Util.getCxSign(map, userCinema.getRealPassword());
			param.setVerifyInfo(VerifyInfo);

			// 把请求参数转成XML
			String ReleaseSeatXml = JaxbXmlUtil.convertToXml(param);
			String result = WebService.cinemaTss(userCinema.getUrl()).releaseSeat(ReleaseSeatXml);
			log.info(result);
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
					.registerTypeAdapter(Integer.class, new IntegerDefaultAdapter())
					.registerTypeAdapter(Double.class, new DoubleDefaultAdapter()).create();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "ReleaseSeatResult"), CxReleaseSeatResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// endregion

	// region 提交订单(完成)
	public static CxSubmitOrderResult SubmitOrder(Usercinemaview userCinema, OrderView orderview) {
		try {
			// 用来生成验证码
			Map<String, String> map = new LinkedHashMap();
			map.put("AppCode", userCinema.getRealUserName());
			map.put("CinemaCode", userCinema.getCinemaCode());
			map.put("OrderCode", orderview.getOrderBaseInfo().getLockOrderCode());// 锁座订单号
			map.put("FeatureAppNo", orderview.getOrderBaseInfo().getSessionCode());// 场次编码
			map.put("MobilePhone", orderview.getOrderBaseInfo().getMobilePhone());
			StringBuffer SeatInfos = new StringBuffer();
			orderview.getOrderSeatDetails()
					.forEach(n -> SeatInfos.append(n.getSeatCode())// 座位编号
							.append(new DecimalFormat("#0.00").format(n.getPrice() + n.getFee() + n.getAddFee()))// 总票价
							.append(new DecimalFormat("#0.00").format(n.getFee()))// 网络代售服务费
							.append(new DecimalFormat("#0.00").format(n.getAddFee()))// 增值服务费
							.append(new DecimalFormat("#0.00").format(n.getCinemaAllowance()))// 影院补贴
							/*.append(orderview.getOrderBaseInfo().getMarketingCode())*/);// 活动标识
			map.put("SeatInfos", SeatInfos.toString());
			map.put("Compress", "0");
			log.info("==========================");
			log.info(SeatInfos.toString());
			log.info("==========================");

			// 最后的请求参数
			CxSubmitOrderParameter param = new CxSubmitOrderParameter();
			param.setAppCode(userCinema.getRealUserName());
			param.setCinemaCode(userCinema.getCinemaCode());
			param.setOrderCode(orderview.getOrderBaseInfo().getLockOrderCode());// 锁座订单号
			param.setFeatureAppNo(orderview.getOrderBaseInfo().getSessionCode());// 场次编码
			param.setMobilePhone(orderview.getOrderBaseInfo().getMobilePhone());
			CxSubmitOrderXmlSeatInfos seatInfos = new CxSubmitOrderParameter.CxSubmitOrderXmlSeatInfos();
			List<CxSubmitOrderXmlSeatInfo> seatInfo = new ArrayList<CxSubmitOrderXmlSeatInfo>();
			for (Orderseatdetails orderdetail : orderview.getOrderSeatDetails()) {
				CxSubmitOrderXmlSeatInfo seat = new CxSubmitOrderXmlSeatInfo();
				seat.setSeatCode(orderdetail.getSeatCode());
				seat.setPrice(new DecimalFormat("#.00").format(orderdetail.getPrice()));
				seat.setServiceCharge(new DecimalFormat("#.00").format(orderdetail.getFee()));
				seat.setServiceAddFee(new DecimalFormat("#.00").format(orderdetail.getAddFee()));
				seat.setCinemaAllowance(new DecimalFormat("#.00").format(orderdetail.getCinemaAllowance()));
				//seat.setMarketingCode(orderview.getOrderBaseInfo().getMarketingCode());
				seatInfo.add(seat);
			}
			seatInfos.setSeatInfo(seatInfo);
			param.setSeatInfos(seatInfos);
			param.setCompress("0");
			String VerifyInfo = MD5Util.getCxSign(map, userCinema.getRealPassword());
			param.setVerifyInfo(VerifyInfo);

			// 把请求参数转成XML
			String SubmitOrderXml = JaxbXmlUtil.convertToXml(param);
			String result = WebService.cinemaTss(userCinema.getUrl()).submitOrder(SubmitOrderXml);
			log.info(result);
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
					.registerTypeAdapter(Integer.class, new IntegerDefaultAdapter())
					.registerTypeAdapter(Double.class, new DoubleDefaultAdapter()).create();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "SubmitOrderResult"), CxSubmitOrderResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// endregion

	// region 查询出票状态(完成)
	/**
	 * 根据取票序号、取票验证码查询取货状态
	 * 
	 * @param pCinemaCode
	 * @param pPrintNo
	 * @param pVerifyCode
	 * @return
	 */
	public static CxQueryDeliveryStatusResult QueryDeliveryStatus(Usercinemaview userCinema, String pPrintNo,
			String pVerifyCode) {
		try {
			Map<String, String> param = new LinkedHashMap();
			param.put("pAppCode", userCinema.getRealUserName());
			param.put("pCinemaCode", userCinema.getCinemaCode());
			param.put("pPrintNo", pPrintNo);
			param.put("pVerifyCode", pVerifyCode);
			param.put("pCompress", "0");
			// log.info(param.toString());
			// log.info(MD5Util.getCxSign(param, PayConstant.signkey));
			String result = WebService.cinemaTss(userCinema.getUrl()).queryDeliveryStatus(userCinema.getRealUserName(),
					userCinema.getCinemaCode(), pPrintNo, pVerifyCode, "0",
					MD5Util.getCxSign(param, userCinema.getRealPassword()));
			Gson gson = new Gson();
			log.info(result);
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "QueryDeliveryStatusResult"),
					CxQueryDeliveryStatusResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// endregion

	// region 退票(完成)
	public static CxCancelOrderResult CancelOrder(Usercinemaview userCinema, String pPrintNo, String pVerifyCode) {
		try {
			Map<String, String> param = new LinkedHashMap();
			param.put("pAppCode", userCinema.getRealUserName());
			param.put("pCinemaCode", userCinema.getCinemaCode());
			param.put("pPrintNo", pPrintNo);
			param.put("pVerifyCode", pVerifyCode);
			param.put("pCompress", "0");
			// log.info(param.toString());
			// log.info(MD5Util.getCxSign(param, PayConstant.signkey));
			String result = WebService.cinemaTss(userCinema.getUrl()).cancelOrder(userCinema.getRealUserName(),
					userCinema.getCinemaCode(), pPrintNo, pVerifyCode, "0",
					MD5Util.getCxSign(param, userCinema.getRealPassword()));
			Gson gson = new Gson();
			log.info(result);
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "CancelOrderResult"), CxCancelOrderResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// endregion

	// region 查询订单信息(完成)
	public static CxQueryOrderStatusResult QueryOrderStatus(Usercinemaview userCinema, String pOrderCode) {
		try {
			Map<String, String> param = new LinkedHashMap();
			param.put("pAppCode", userCinema.getRealUserName());
			param.put("pCinemaCode", userCinema.getCinemaCode());
			param.put("pOrderCode", pOrderCode);
			param.put("pCompress", "0");
			// log.info(param.toString());
			// log.info(MD5Util.getCxSign(param, PayConstant.signkey));
			String result = WebService.cinemaTss(userCinema.getUrl()).queryOrderStatus(userCinema.getRealUserName(),
					userCinema.getCinemaCode(), pOrderCode, "0",
					MD5Util.getCxSign(param, userCinema.getRealPassword()));
			Gson gson = new Gson();
			log.info(result);
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "QueryOrderStatusResult"),
					CxQueryOrderStatusResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// endregion

	// region 查询影票信息(完成)
	public static CxQueryTicketInfoResult QueryTicketInfo(Usercinemaview userCinema, String PrintNo) {
		try {
			// 用来生成验证码
			Map<String, String> map = new LinkedHashMap();
			map.put("pAppCode", userCinema.getRealUserName());
			map.put("pCinemaCode", userCinema.getCinemaCode());
			map.put("PrintNo", PrintNo);
			map.put("pCompress", "0");
			// log.info(param.toString());

			// 最后的请求参数
			CxQueryTicketInfoParameter param = new CxQueryTicketInfoParameter();
			param.setAppCode(userCinema.getRealUserName());
			param.setCinemaCode(userCinema.getCinemaCode());
			CxQueryTicketInfoXmlTickets Tickets = new CxQueryTicketInfoParameter.CxQueryTicketInfoXmlTickets();
			List<CxQueryTicketInfoXmlTicket> Ticket = new ArrayList<CxQueryTicketInfoXmlTicket>();
			CxQueryTicketInfoXmlTicket ti = new CxQueryTicketInfoXmlTicket();
			ti.setPrintNo(PrintNo);
			Ticket.add(ti);
			Tickets.setTicket(Ticket);
			param.setTickets(Tickets);
			param.setCompress("0");
			String VerifyInfo = MD5Util.getCxSign(map, userCinema.getRealPassword());
			param.setVerifyInfo(VerifyInfo);

			// 把请求参数转成XML
			String QueryTicketInfoXml = JaxbXmlUtil.convertToXml(param);
			String result = WebService.cinemaTss(userCinema.getUrl()).queryTicketInfo(QueryTicketInfoXml);
			log.info(result);

			// log.info(MD5Util.getCxSign(param, PayConstant.signkey));
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
					.registerTypeAdapter(Integer.class, new IntegerDefaultAdapter())
					.registerTypeAdapter(Double.class, new DoubleDefaultAdapter()).create();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "QueryTicketInfoResult"),
					CxQueryTicketInfoResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// endregion

	// region 电影票出票请求（完成）
	public static CxApplyFetchTicketResult ApplyFetchTicket(Usercinemaview userCinema, String PrintNo,
			String VerifyCode) {
		try {
			// 用来生成验证码
			Map<String, String> map = new LinkedHashMap();
			map.put("pAppCode", userCinema.getRealUserName());
			map.put("pCinemaCode", userCinema.getCinemaCode());
			map.put("PrintNo", PrintNo);
			map.put("VerifyCodeMD5",MD5Util.MD5Encode(VerifyCode,"UTF-8"));
			map.put("pCompress", "0");
			// log.info(param.toString());

			// 最后的请求参数
			CxApplyFetchTicketParameter applyParam = new CxApplyFetchTicketParameter();
			applyParam.setAppCode(userCinema.getRealUserName());
			applyParam.setCinemaCode(userCinema.getCinemaCode());
			CxApplyFetchTicketXmlTickets Tickets = new CxApplyFetchTicketParameter.CxApplyFetchTicketXmlTickets();
			List<CxApplyFetchTicketXmlTicket> Ticket = new ArrayList<CxApplyFetchTicketXmlTicket>();
			CxApplyFetchTicketXmlTicket ti = new CxApplyFetchTicketXmlTicket();
			ti.setPrintNo(PrintNo);
			ti.setVerifyCodeMD5(MD5Util.MD5Encode(VerifyCode,"UTF-8"));
			Ticket.add(ti);
			Tickets.setTicket(Ticket);
			applyParam.setTickets(Tickets);
			applyParam.setCompress("0");
			String VerifyInfo = MD5Util.getCxSign(map, userCinema.getRealPassword());
			applyParam.setVerifyInfo(VerifyInfo);

			// 把请求参数转成XML
			String ApplyFetchTicketXml = JaxbXmlUtil.convertToXml(applyParam);
			log.info(ApplyFetchTicketXml);
			String result = WebService.cinemaTss(userCinema.getUrl()).applyFetchTicket(ApplyFetchTicketXml);
			log.info(result);

			// log.info(MD5Util.getCxSign(param, PayConstant.signkey));
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
					.registerTypeAdapter(Integer.class, new IntegerDefaultAdapter())
					.registerTypeAdapter(Double.class, new DoubleDefaultAdapter()).create();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "ApplyFetchTicketResult"),
					CxApplyFetchTicketResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// endregion
	
	//region 确认出票（完成）
	public static CxFetchTicketResult FetchTicket(Usercinemaview userCinema, String PrintNo) {
		try {
			// 用来生成验证码
			Map<String, String> map = new LinkedHashMap();
			map.put("pAppCode", userCinema.getRealUserName());
			map.put("pCinemaCode", userCinema.getCinemaCode());
			map.put("PrintNo", PrintNo);
			map.put("pCompress", "0");
			// log.info(param.toString());

			// 最后的请求参数
			CxFetchTicketParameter Param = new CxFetchTicketParameter();
			Param.setAppCode(userCinema.getRealUserName());
			Param.setCinemaCode(userCinema.getCinemaCode());
			CxFetchTicketXmlTickets Tickets = new CxFetchTicketParameter.CxFetchTicketXmlTickets();
			List<CxFetchTicketXmlTicket> Ticket = new ArrayList<CxFetchTicketXmlTicket>();
			CxFetchTicketXmlTicket ti = new CxFetchTicketXmlTicket();
			ti.setPrintNo(PrintNo);
			Ticket.add(ti);
			Tickets.setTicket(Ticket);
			Param.setTickets(Tickets);
			Param.setCompress("0");
			String VerifyInfo = MD5Util.getCxSign(map, userCinema.getRealPassword());
			Param.setVerifyInfo(VerifyInfo);

			// 把请求参数转成XML
			String FetchTicketXml = JaxbXmlUtil.convertToXml(Param);
			String result = WebService.cinemaTss(userCinema.getUrl()).fetchTicket(FetchTicketXml);
			log.info(result);

			// log.info(MD5Util.getCxSign(param, PayConstant.signkey));
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
					.registerTypeAdapter(Integer.class, new IntegerDefaultAdapter())
					.registerTypeAdapter(Double.class, new DoubleDefaultAdapter()).create();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "FetchTicketResult"),
					CxFetchTicketResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//endregion

	//region 登录会员卡
	public static CxVerifyMemberLoginResult  VerifyMemberLogin(Usercinemaview userCinema,String pLoginNum,String pLmsPassword){
		try{
			Map<String,String> param = new LinkedHashMap();
			param.put("pAppCode",userCinema.getRealUserName());
			param.put("pCinemaCode",userCinema.getCinemaCode());
			param.put("pLoginNum", pLoginNum);
			param.put("pLmsPassword",pLmsPassword );
			param.put("pCompress", "0");
//			log.info(param.toString());
//			log.info(MD5Util.getCxSign(param, PayConstant.signkey));
			String result = WebService.cinemaTss(userCinema.getUrl()).verifyMemberLogin(userCinema.getRealUserName(),userCinema.getCinemaCode(),pLoginNum,pLmsPassword,"0",MD5Util.getCxSign(param,userCinema.getRealPassword()));
			Gson gson = new Gson();
//			log.info(result);
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result,"VerifyMemberLoginResult"), CxVerifyMemberLoginResult.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//endregion
	
	//region 查询会员卡
	public static CxQueryMemberInfoResult  QueryMemberInfo(Usercinemaview userCinema,String pLoginNum,String pLmsPassword){
		try{
			Map<String,String> param = new LinkedHashMap();
			param.put("pAppCode",userCinema.getRealUserName());
			param.put("pCinemaCode",userCinema.getCinemaCode());
			param.put("pLoginNum", pLoginNum);
			param.put("pLmsPassword",pLmsPassword );
			param.put("pCompress", "0");
//			log.info(param.toString());
//			log.info(MD5Util.getCxSign(param, PayConstant.signkey));
			String result = WebService.cinemaTss(userCinema.getUrl()).queryMemberInfo(userCinema.getRealUserName(),userCinema.getCinemaCode(),pLoginNum,pLmsPassword,"0",MD5Util.getCxSign(param,userCinema.getRealPassword()));
			Gson gson = new Gson();
//			log.info(result);
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result,"QueryMemberInfoResult"), CxQueryMemberInfoResult.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//endregion
	
	//region 查询会员卡折扣
	public static CxQueryDiscountActivityResult QueryDiscountActivity(Usercinemaview userCinema,String TicketCount,String CardNo,String CardPassword,String LevelCode,String SessionCode,String SessionTime,String FilmCode,String ScreenType,String ListingPrice,String LowestPrice){
		try {
			// 用来生成验证码
			Map<String, String> map = new LinkedHashMap();
			map.put("AppCode", userCinema.getRealUserName());
			map.put("CinemaCode", userCinema.getCinemaCode());
			
			CxQueryDiscountFacts facts=new CxQueryDiscountFacts();
			facts.setCardLevelCode(LevelCode);
			List<planInfoBean> planInfos=new ArrayList<planInfoBean>();
			planInfoBean planInfo=new planInfoBean();
			planInfo.setFeatureAppNo(SessionCode);
			planInfo.setStartTime(SessionTime);
			planInfo.setFilmCode(FilmCode);
			planInfo.setHallType(ScreenType);
			planInfo.setListingPrice(Float.parseFloat(ListingPrice));
			planInfo.setLowestPrice(Float.parseFloat(LowestPrice));
			planInfos.add(planInfo);
			facts.setPlanInfos(planInfos);
			facts.setConsumeWayCode("T");
			Gson gson = new Gson();
			String pFacts = gson.toJson(facts);
			
			map.put("pFacts",pFacts);
			map.put("Compress", "0");
		
			String result = WebService.cinemaTss(userCinema.getUrl()).queryDiscountActivity(userCinema.getRealUserName(), userCinema.getCinemaCode(), pFacts,"0",MD5Util.getCxSign(map, userCinema.getRealPassword()));
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result,"QueryDiscountActivityResult"),CxQueryDiscountActivityResult.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//endregion
	
	//region 会员卡支付
	public static CxMemberConsumeResult  MemberConsume(Usercinemaview userCinema,String pLoginNum, String pLmsPassword, float pAmount, String SessionCode, String FilmCode, String TicketNum,String pTransactionNo){
		try{
			//DecimalFormat df = new DecimalFormat("0.00");df.format(disprice)
			String pOrderCode=UUID.randomUUID().toString().replace("-","");
			Map<String,Object> param = new LinkedHashMap();
			param.put("pAppCode", userCinema.getRealUserName());
			param.put("pCinemaCode",userCinema.getCinemaCode());
			param.put("pLoginNum", pLoginNum);
			param.put("pLmsPassword",MD5Util.MD5Encode(pLmsPassword,"UTF-8"));
			param.put("pChannelType", "手机APP");
			param.put("pAmount",pAmount);
			param.put("pOrderCode",pOrderCode);
			param.put("pTransactionNo",pTransactionNo);
			param.put("pTicketAmount", "");
			param.put("pGoodsAmount", "");
			param.put("pIntegralAmount", "");
			param.put("pIntegralMultiple", "");
			param.put("pGoods", "");
			param.put("pCompress", "0");
			log.info(param.toString());
			String result = WebService.cinemaTss(userCinema.getUrl()).memberConsume(userCinema.getRealUserName(),userCinema.getCinemaCode(),pLoginNum,pLmsPassword,"手机APP",pAmount,pOrderCode,pTransactionNo,null, null,null, null, null,"0",MD5Util.getCxSign(param,userCinema.getRealPassword()));
			Gson gson = new Gson();
			log.info(result);
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result,"MemberConsumeResult"),CxMemberConsumeResult.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//endregion
	
	//region 会员交易撤销
	public static CxMemberTransactionCancelResult  MemberTransactionCancel(Usercinemaview userCinema,String CardNo, String CardPassword,String pOldTransactionNo,float PayBackAmount,String pTransactionNo){
		try{
			Map<String,Object> param = new LinkedHashMap();
			param.put("pAppCode",userCinema.getRealUserName());
			param.put("pCinemaCode",userCinema.getCinemaCode());
			param.put("pOldTransactionNo",pOldTransactionNo);
			param.put("pTransactionNo",pTransactionNo);
			param.put("pChannelType", "手机APP");
			param.put("pCompress", "0");
			String result = WebService.cinemaTss(userCinema.getUrl()).memberTransactionCancel(userCinema.getRealUserName(),userCinema.getCinemaCode(),pOldTransactionNo,pTransactionNo,"手机APP","0",  MD5Util.getCxSign(param,userCinema.getRealPassword()));
			Gson gson = new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result,"MemberTransactionCancelResult"),CxMemberTransactionCancelResult.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//endregion
	
	//region 查询会员卡交易记录
	public static CxQueryMemberFlowInfoResult QueryMemberFlowInfo(Usercinemaview userCinema,String CardNo,String CardPassword,String pStartDate,String pEndDate,String pPageSize,String pPageNum){
		try{
			Map<String,Object> param = new LinkedHashMap();
			param.put("pAppCode",userCinema.getRealUserName());
			param.put("pCinemaCode",userCinema.getCinemaCode());
			param.put("pLoginNum",CardNo);
			param.put("pStartDate",pStartDate);
			param.put("pEndDate",pEndDate);
			param.put("pPageSize",pPageSize);
			param.put("pPageNum",pPageNum);
			param.put("pCompress", "0");
			String result = WebService.cinemaTss(userCinema.getUrl()).queryMemberFlowInfo(userCinema.getRealUserName(),userCinema.getCinemaCode(),CardNo, pStartDate, pEndDate, pPageSize, pPageNum,"0",MD5Util.getCxSign(param,userCinema.getRealPassword()));
			Gson gson = new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result,"QueryMemberFlowInfoResult"),CxQueryMemberFlowInfoResult.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//endregion
	
	//region 会员卡充值
	public static CxMemberChargeResult  MemberCharge(Usercinemaview userCinema,String CardNo, String CardPassword,CardChargeTypeEnum ChargeType, float ChargeAmount){
		try{
			String pOrderCode=UUID.randomUUID().toString().replace("-","");
			String pTransactionNo=UUID.randomUUID().toString();
			Map<String,Object> param = new LinkedHashMap();
			param.put("pAppCode",userCinema.getRealUserName());
			param.put("pCinemaCode",userCinema.getCinemaCode());
			param.put("pLoginNum",CardNo);
			param.put("pChargeType", ChargeType.getTypeCode());
			param.put("pChargeTypeName",ChargeType.getTypeName());
			param.put("pChannelType", "手机APP");
			param.put("pAccountType", "0");
			param.put("pChargeAmount",ChargeAmount);
			param.put("pChargeActivityId","");
			param.put("pChargeClass", "0");
			param.put("pOrderCode",pOrderCode);
			param.put("pTransactionNo",pTransactionNo);
			param.put("pCompress", "0");
			log.info(param.toString());
			String result = WebService.cinemaTss(userCinema.getUrl()).memberCharge(userCinema.getRealUserName(),userCinema.getCinemaCode(),CardNo,String.valueOf(ChargeType.getTypeCode()),ChargeType.getTypeName(), "手机APP", "0",ChargeAmount,"", "0",pOrderCode,pTransactionNo, "0", MD5Util.getCxSign(param,userCinema.getRealPassword()));
			Gson gson = new Gson();
			log.info(result);
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result,"MemberChargeResult"),CxMemberChargeResult.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//endregion
	
	//region 查询会员卡等级
	public static CxQueryMemberLevelResult QueryMemberLevel(Usercinemaview userCinema){
		try{
			Map<String,Object> param = new LinkedHashMap();
			param.put("pAppCode",userCinema.getRealUserName());
			param.put("pCinemaCode",userCinema.getCinemaCode());
			param.put("pCompress", "0");
			String result = WebService.cinemaTss(userCinema.getUrl()).queryMemberLevel(userCinema.getRealUserName(),userCinema.getCinemaCode(),"0", MD5Util.getCxSign(param,userCinema.getRealPassword()));
			Gson gson = new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result,"QueryMemberLevelResult"),CxQueryMemberLevelResult.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//endregion
	
	//region 会员卡注册
	public static CxPhoneNumRegResult  PhoneNumReg(Usercinemaview userCinema,String pLmsPassword, String LevelCode, String InitialAmount, String pName, String pMobileNum, String pCreditNum, String pSex){
		try{
			Map<String,Object> param = new LinkedHashMap();
			param.put("pAppCode",userCinema.getRealUserName());
			param.put("pCinemaCode",userCinema.getCinemaCode());
			param.put("pMobileNum", pMobileNum);
			param.put("pLmsPassword", pLmsPassword);
			param.put("pLoginPasswd", pLmsPassword);
			param.put("pName",pName);
			param.put("pSex", pSex);
			param.put("pBirthday","");
			param.put("pCreditNum",pCreditNum);
			param.put("pEmail", "");
			param.put("pOperator", "APP");
			param.put("pCompress", "0");
			String result = WebService.cinemaTss(userCinema.getUrl()).phoneNumReg(userCinema.getRealUserName(),userCinema.getCinemaCode(),pMobileNum,
					pLmsPassword,pLmsPassword,pName,pSex,"",pCreditNum,"","APP","0",MD5Util.getCxSign(param,userCinema.getRealPassword()));
			Gson gson = new Gson();
			log.info(result);
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result,"PhoneNumRegResult"),CxPhoneNumRegResult.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//endregion
	
	public static void main(String args[]) {
		try {
			System.out.println("=====================");
			// System.out.println(QueryCinemaInfo());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
