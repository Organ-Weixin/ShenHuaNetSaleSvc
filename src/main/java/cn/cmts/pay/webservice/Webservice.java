package cn.cmts.pay.webservice;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.xml.rpc.ServiceException;

import org.apache.commons.lang3.RandomStringUtils;

import com.alibaba.druid.sql.visitor.functions.Substring;
import com.boot.security.server.api.ctms.reply.CTMSQueryDiscountReply;
import com.boot.security.server.api.ctms.reply.MtxGetCardTraceRecordResult;
import com.boot.security.server.api.ctms.reply.MtxGetCardTypeResult;
import com.boot.security.server.api.ctms.reply.MtxGetDiscountResult;
import com.boot.security.server.api.ctms.reply.MtxGetHallAllSeatResult;
import com.boot.security.server.api.ctms.reply.MtxGetPlanSiteStateResult;
import com.boot.security.server.api.ctms.reply.MtxLoginCardResult;
import com.boot.security.server.api.ctms.reply.MtxQueryCardResult;
import com.boot.security.server.api.ctms.reply.MtxRegisterCardResult;
import com.boot.security.server.api.ctms.reply.MtxSerialCardPayBackResult;
import com.boot.security.server.api.ctms.reply.MtxSerialCardPayResult;
import com.boot.security.server.api.ctms.reply.MtxSerialCardRechargeResult;
import com.boot.security.server.model.CardChargeTypeEnum;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.utils.SpringUtil;
import com.boot.security.server.utils.XmlToJsonUtil;
import com.google.common.base.Joiner;
import com.google.gson.Gson;

import cn.cmts.main.webservice.WebService;

/*	
 * @version 1.0 满天星会员卡接口
 */
public class Webservice {
	
	/*	
	 * 满天星会员卡接口 初始化会员卡接口链接，返回会员卡接口集
	 * @return
	*/
	public static PayapiPortType cinemaTss(String Url) {
		PayapiLocator css = new PayapiLocator();
		css.setpayapiHttpSoap11EndpointEndpointAddress(Url);
		Payapi cs = css;
		// 接口集
		PayapiPortType cp;
		try {
			cp = cs.getpayapiHttpSoap11Endpoint();
			return cp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*registerCard 带卡号的会员卡开户接口--1
	 * 		合作商代码		影院编号  合作商流水号  卡号         芯片号         会员卡密码   手机号			证件号     校验
	 * Md5((partnerCode + placeNo + partnerId + cardNo + memoryId + passWord + mobilePhone + idNum + partnerKey)小写)小写
	 * */
	public static MtxRegisterCardResult RegisterCard(Usercinemaview userCinema, String cardNo, String CardPassword, String LevelCode,
			String InitialAmount, String CardUserName, String MobilePhone, String IDNumber, String Sex) {
		try {
			String partnerId = "";// 合作商流水号(最大20位)	
			String memoryId = RandomStringUtils.randomNumeric(20);;// 芯片号(最大长度20位)
			String score = "0";// 初始积分
			String birthday = "";// 出生日期
			String email = "";
			String address = "";
			String lifeDate = "2039-01-01";
			String traceMemo = "";
			//满天星会员卡注册的校验信息只需要这几个字段即可
			String validateKey = GenerateVerifyInfo(userCinema.getDefaultUserName(), userCinema.getCinemaCode(),
					partnerId, cardNo, memoryId, CardPassword, MobilePhone, IDNumber, userCinema.getDefaultPassword());
			String result = Webservice.cinemaTss(userCinema.getMemberUrl()).registerCard(userCinema.getDefaultUserName(),
					userCinema.getCinemaCode(), partnerId, cardNo, memoryId, CardPassword, MobilePhone, IDNumber,
					CardUserName, InitialAmount, score, LevelCode,Sex, birthday, email, address, lifeDate, traceMemo,
					validateKey);
//			System.out.println("registerCard 带卡号的会员卡开户接口返回"+result);
			Gson gson = new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "RegisterMemberReturn"), MtxRegisterCardResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*loginCard会员卡登录接口--2
	 *    合作商代码		  影院编号       合作商流水号  卡号         手机号                 会员密码        Md5
	 * Md5((partnerCode + placeNo + partnerId + cardId + mobilePhone + passWord + partnerKey)小写)小写
	 */
	public static MtxLoginCardResult LoginCard(Usercinemaview userCinema, String CardNo, String CardPassword) {
		try {
			String partnerId = "";
			String mobilePhone = "";
			String validateKey = GenerateVerifyInfo(userCinema.getDefaultUserName(), userCinema.getCinemaCode(),
					partnerId, CardNo, mobilePhone, CardPassword, userCinema.getDefaultPassword());
			String result = Webservice.cinemaTss(userCinema.getMemberUrl()).loginCard(userCinema.getDefaultUserName(),
					userCinema.getCinemaCode(), partnerId, CardNo, mobilePhone, CardPassword, validateKey);
//			System.out.println("loginCard会员卡登录接口返回" + result);
			Gson gson = new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "LoginCardReturn"), MtxLoginCardResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * queryCard 查询会员卡账户信息--3
	 *  Md5(partnerCode + placeNo + partnerId + memoryId +partnerKey)小写
	 */
	public static MtxQueryCardResult QueryCard(Usercinemaview userCinema, String CardNo, String CardPassword) {
		try {
			String partnerId = "";
			String memoryId = "*" + CardNo;
			String validateKey = GenerateVerifyInfo(userCinema.getDefaultUserName(), userCinema.getCinemaCode(),
					partnerId, memoryId, userCinema.getDefaultPassword());
			String result = Webservice.cinemaTss(userCinema.getMemberUrl()).queryCard(userCinema.getDefaultUserName(),
					userCinema.getCinemaCode(), partnerId, memoryId, validateKey);
			System.out.println("queryCard 查询会员卡账户信息返回" + result);
			Gson gson = new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "QueryCardReturn"), MtxQueryCardResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*getDiscount 折扣查询--4
	 * 	合作商代码	   持卡影院编码  合作商流水号   卡号/账户号    手机号       排期号         放映时间        放映日期     
	 *Md5((partnerCode + placeNo + partnerId + cardId + mobilePhone+featureNo+featureDate+ featureTime+ partnerKey)小写)小写 
	 * */
	public static MtxGetDiscountResult GetDiscount(Usercinemaview userCinema, String TicketCount, String CardNo,
			String CardPassword, String LevelCode, String SessionCode, String SessionTime, String FilmCode,
			String ScreenType, String ListingPrice, String LowestPrice) {
		try {
			String partnerId = "";
			String mobilePhone = "";
			String featureDate = "";
			String featureTime = "";
			featureDate = SessionTime.substring(0, 10);
			featureTime = SessionTime.substring(11, 16);
			String validateKey = GenerateVerifyInfo(userCinema.getDefaultUserName(), userCinema.getCinemaCode(),
					partnerId, CardNo, mobilePhone, SessionCode, featureDate, featureTime,
					userCinema.getDefaultPassword());
			String result = Webservice.cinemaTss(userCinema.getMemberUrl()).getDiscount(userCinema.getDefaultUserName(),
					userCinema.getCinemaCode(), partnerId, CardNo, mobilePhone, SessionCode, featureDate, featureTime,
					validateKey);
//			System.out.println("getDiscount 折扣查询返回" + result);
			Gson gson = new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "GetDiscount"), MtxGetDiscountResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*serialCardPay会员卡支付（流水号必传）、预算接口
	 *Md5((partnerCode合作商代码 + placeNo影院编号+ partnerId合作商流水号 + cardId 卡号+ mobilePhone手机号 + passWord 会员卡密码+ traceTypeNo交易类型号 + 
	 *oldPrice预算/支付 + tracePrice交易手续费 + discount折扣，范围：0~10 + featureNo排期号 + filmNo影片编号 + ticketNum票数，预算传1 + partnerKey)小写)小写 
	 */
	public static MtxSerialCardPayResult SerialCardPay(Usercinemaview userCinema, String CardNo, String CardPassword,
			float PayAmount, String SessionCode, String FilmCode, String TicketNum) {
		try {
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSS");
			String str = format.format(date);
			String partnerId = str;// 16位流水号
			String mobilePhone = "";
			String traceTypeNo = "01";// 01支付 02预算
			String tracePrice = "0";// 交易手续费
			String discount = "10";// 折扣
			String traceMemo = "";// 备注
			String validateKey = GenerateVerifyInfo(userCinema.getDefaultUserName(), userCinema.getCinemaCode(),
					partnerId, CardNo, mobilePhone, CardPassword, traceTypeNo, String.valueOf(PayAmount), tracePrice,
					discount, SessionCode, FilmCode, TicketNum, userCinema.getDefaultPassword());
			String result = Webservice.cinemaTss(userCinema.getMemberUrl()).serialCardPay(userCinema.getDefaultUserName(),
					userCinema.getCinemaCode(), partnerId, CardNo, mobilePhone, CardPassword, traceTypeNo,
					String.valueOf(PayAmount), tracePrice, discount, SessionCode, FilmCode, TicketNum, traceMemo,
					validateKey);
			// System.out.println("会员卡支付（流水号必传）、预算接口返回" + result);
			Gson gson = new Gson();
			return gson.fromJson(result, MtxSerialCardPayResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*serialCardPayBack会员卡冲费（撤销）接口（流水号必传）
	 * Md5((partnerCode + placeNo + partnerId + cardId + mobilePhone + passWord + traceType + traceNo + tracePrice + price + partnerKey)小写)小写
	 * */
	public static MtxSerialCardPayBackResult SerialCardPayBack(Usercinemaview userCinema, String CardNo,
			String CardPassword, String TradeNo, float PayBackAmount) {
		try {
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSS");
			String str = format.format(date);
			String partnerId = str;// 16位流水号
			String mobilePhone = "";
			String traceType = "02";// 冲费(撤销)
			String tracePrice = "0";// 交易手续费
			String traceMemo = "";// 备注
			String validateKey = GenerateVerifyInfo(userCinema.getDefaultUserName(), userCinema.getCinemaCode(),
					partnerId, CardNo, mobilePhone, CardPassword, traceType, TradeNo, tracePrice,
					String.valueOf(PayBackAmount), traceMemo, userCinema.getDefaultPassword());
			String result = Webservice.cinemaTss(userCinema.getMemberUrl()).serialCardPayBack(userCinema.getDefaultUserName(),
					userCinema.getCinemaCode(), partnerId, CardNo, mobilePhone, CardPassword, traceType, TradeNo,
					tracePrice, String.valueOf(PayBackAmount), traceMemo, validateKey);
//			System.out.println("serialCardPayBack会员卡冲费（撤销）接口（流水号必传）返回" + result);
			Gson gson = new Gson();
			return gson.fromJson(result, MtxSerialCardPayBackResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*getCardTraceRecord查询会员卡交易记录接口
	 * Md5((partnerCode + placeNo + cardId + mobilePhone + passWord + startDate + endDate + partnerKey)小写)小写
	 * */
	public static MtxGetCardTraceRecordResult GetCardTraceRecord(Usercinemaview userCinema, String CardNo,
			String CardPassword, String StartDate, String EndDate, String PageSize, String PageNum) {
		try {
			String mobilePhone = "";
			String validateKey = GenerateVerifyInfo(userCinema.getDefaultUserName(), userCinema.getCinemaCode(), CardNo,
					mobilePhone, CardPassword, StartDate, EndDate, userCinema.getDefaultPassword());
			String result = Webservice.cinemaTss(userCinema.getMemberUrl()).getCardTraceRecord(
					userCinema.getDefaultUserName(), userCinema.getCinemaCode(), CardNo, mobilePhone, CardPassword,
					StartDate, EndDate, validateKey);
//			System.out.println("getCardTraceRecord查询会员卡交易记录接口返回" + result);
			Gson gson = new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "GetCardTraceRecord"),
					MtxGetCardTraceRecordResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*serialCardRecharge会员卡充值接口（流水号必传）
	 * Md5((partnerCode + placeNo + partnerId + cardId + mobilePhone + passWord + price + partnerKey)小写)小写
	 * */
	public static MtxSerialCardRechargeResult SerialCardRecharge(Usercinemaview userCinema, String CardNo,
			String CardPassword, CardChargeTypeEnum ChargeType, float ChargeAmount) {
		try {
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSS");
			String str = format.format(date);
			String partnerId = str;// 16位流水号
			String mobilePhone = "";
			String traceMemo = "";// 备注
			String validateKey = GenerateVerifyInfo(userCinema.getDefaultUserName(), userCinema.getCinemaCode(),
					partnerId, CardNo, mobilePhone, CardPassword, String.valueOf(ChargeAmount), traceMemo,
					userCinema.getDefaultPassword());
			String result = Webservice.cinemaTss(userCinema.getMemberUrl()).serialCardRecharge(
					userCinema.getDefaultUserName(), userCinema.getCinemaCode(), partnerId, CardNo, mobilePhone,
					CardPassword, String.valueOf(ChargeAmount), traceMemo, validateKey);
//			System.out.println("serialCardRecharge会员卡充值接口（流水号必传）返回" + result);
			Gson gson = new Gson();
			return gson.fromJson(result, MtxSerialCardRechargeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*getCardType获取影院会员卡级别接口
	 * Md5((partnerCode + placeNo + partnerKey)小写)小写
	 **/
	public static MtxGetCardTypeResult GetCardType(Usercinemaview userCinema) {
		try {
			String validateKey = GenerateVerifyInfo(userCinema.getDefaultUserName(), userCinema.getCinemaCode(),
					userCinema.getDefaultPassword());
			String result = Webservice.cinemaTss(userCinema.getMemberUrl()).getCardType(userCinema.getDefaultUserName(),
					userCinema.getCinemaCode(), validateKey);
//			System.out.println("getCardType获取影院会员卡级别接口返回" + result);
			Gson gson = new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "GetCardTypeReturn"), MtxGetCardTypeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//满天星校验
	private static String GenerateVerifyInfo(String... items) {
		String sourceString = Joiner.on("").join(items);
		return getMD5ofStr(sourceString.toLowerCase()).substring(8, 24).toLowerCase();
	}
	//满天星MD5加密
	public static String getMD5ofStr(String strSrc) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(strSrc.getBytes("UTF8"));
			String result = "";
			byte[] temp;
			temp = md5.digest("".getBytes("UTF8"));
			for (int i = 0; i < temp.length; i++) {
				result += Integer.toHexString((0x000000ff & temp[i]) | 0xffffff00).substring(6);
			}
			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
/*		String SessionTime="2019-04-23 21:35:00";
		String featureDate=SessionTime.substring(0,10);
		String featureTime=SessionTime.substring(11,16);
		
		System.out.println("排期时间++++++++++++==="+SessionTime);
		System.out.println("排期日期=============："+featureDate);
		System.out.println("排期时间2=============："+featureTime);
		String cardNo = RandomStringUtils.randomNumeric(16);;// 卡号(最大长度16位)
	
		String memoryId = RandomStringUtils.randomNumeric(20);;// 芯片号(最大长度20位)
		System.out.println("卡号：==========="+cardNo);
		System.out.println("芯片号：==========="+memoryId);*/

		
	}
}
