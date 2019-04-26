package com.boot.security.server;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Base64Utils;

import com.boot.security.server.api.core.LockSeatQueryXml;
import com.boot.security.server.api.core.LockSeatQueryXml.LockSeatQueryXmlOrder;
import com.boot.security.server.api.core.LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat;
import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.ReleaseSeatQueryXml;
import com.boot.security.server.api.core.ReleaseSeatQueryXml.ReleaseSeatQueryXmlOrder;
import com.boot.security.server.api.core.ReleaseSeatQueryXml.ReleaseSeatQueryXmlOrder.ReleaseSeatQueryXmlSeat;
import com.boot.security.server.api.core.SubmitOrderQueryXml;
import com.boot.security.server.api.core.SubmitOrderQueryXml.SubmitOrderQueryXmlOrder;
import com.boot.security.server.api.core.SubmitOrderQueryXml.SubmitOrderQueryXmlOrder.SubmitOrderQueryXmlSeat;
import com.boot.security.server.api.ctms.reply.YkInterface;
import com.boot.security.server.model.CardChargeTypeEnum;
import com.boot.security.server.model.OrderStatusEnum;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.service.impl.OrderServiceImpl;
import com.boot.security.server.utils.JaxbXmlUtil;
import com.boot.security.server.utils.MD5Util;
import com.boot.security.server.utils.SpringUtil;
import com.google.gson.Gson;

import cn.cmts.main.webservice.WebService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class YkTest {

	@Test
	public void test() throws Exception{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		
		String Username = "MiniProgram";
		String Password = "6BF477EBCC446F54E6512AFC0E976C41";
		String CinemaCode = "18888888";
		String SessionCode = "888190415420XZ0T";
		
//		System.out.println(new Gson().toJson(ns.QueryCinemaList(Username,Password)));	//影院列表
//		System.out.println(new Gson().toJson(ns.QueryCinema(Username, Password, CinemaCode)));	//影院基础信息
//		System.out.println(new Gson().toJson(ns.QuerySeat(Username, Password, CinemaCode, "0000000000000010"))); //查询影厅座位信息
		System.out.println(new Gson().toJson(ns.QuerySession(Username, Password, CinemaCode, "2019-04-28","2019-05-02")));//查排期
//		System.out.println(new Gson().toJson(ns.QueryFilm(Username, Password, CinemaCode, "2019-04-16",	"2019-04-17"))); //查询影片信息		
//		System.out.println(new Gson().toJson(ns.QuerySessionSeat(Username, Password, CinemaCode, SessionCode, "Sold")));//查询放映计划座位售出状态
		
		LockSeatQueryXmlSeat seat1 = new LockSeatQueryXmlSeat();
		seat1.setSeatCode("0000000000000001-1-1");
		seat1.setPrice(50.0);
		seat1.setAddFee(0.0);
		seat1.setCinemaAllowance(0.0);
		seat1.setFee(5.0);
		LockSeatQueryXmlSeat seat2 = new LockSeatQueryXmlSeat();
		seat2.setSeatCode("0000000000000001-1-2");
		seat2.setPrice(50.0);
		seat2.setAddFee(0.0);
		seat2.setCinemaAllowance(0.0);
		seat2.setFee(5.0);
		
		List<LockSeatQueryXmlSeat> Seats = new ArrayList<LockSeatQueryXmlSeat>();
		Seats.add(seat1);
		Seats.add(seat2);
		
		LockSeatQueryXmlOrder order = new LockSeatQueryXmlOrder();
		order.setSessionCode("888190416BP6024J");
		order.setPayType("0");
		order.setCount(2);
		order.setSeat(Seats);
		
		LockSeatQueryXml xml = new LockSeatQueryXml();
		xml.setCinemaCode("18888888");
		xml.setOrder(order);
		
		String QueryXml = JaxbXmlUtil.convertToXml(xml);
//		System.out.println(new Gson().toJson(ns.LockSeat(Username, Password, QueryXml)));	//锁座
		
		
		
		SubmitOrderQueryXmlSeat subSeat1 = new SubmitOrderQueryXmlSeat();
		subSeat1.setSeatCode("0000000000000001-1-1");
		subSeat1.setAddFee(0.0);
		subSeat1.setCinemaAllowance(0.0);
		subSeat1.setFee(5.0);
		subSeat1.setPrice(40.0);
		subSeat1.setRealPrice(46.0);
		SubmitOrderQueryXmlSeat subSeat2 = new SubmitOrderQueryXmlSeat();
		subSeat2.setSeatCode("0000000000000001-1-2");
		subSeat2.setAddFee(0.0);
		subSeat2.setCinemaAllowance(0.0);
		subSeat2.setFee(5.0);
		subSeat2.setPrice(40.0);
		subSeat2.setRealPrice(46.0);
		
		List<SubmitOrderQueryXmlSeat> Seat = new ArrayList<SubmitOrderQueryXmlSeat>();
		Seat.add(subSeat1);
		Seat.add(subSeat2);
		
		SubmitOrderQueryXmlOrder order1 = new SubmitOrderQueryXmlOrder();
		order1.setCount(2);
		order1.setMobilePhone("13959557890");
		order1.setOrderCode("20190415XXX888000000142100");
		order1.setSessionCode("888190416BP6024J");
		order1.setSeat(Seat);
		
		SubmitOrderQueryXml submitXml = new SubmitOrderQueryXml();
		submitXml.setCinemaCode("18888888");
		submitXml.setOrder(order1);
		
		String subQueryXml = JaxbXmlUtil.convertToXml(submitXml);
//		System.out.println(new Gson().toJson(ns.SubmitOrder(Username,Password, subQueryXml)));	//提交订单
		
//		System.out.println(new Gson().toJson(ns.QueryPrint(Username, Password, CinemaCode, "2019041681129039","573027")));	//查询出票状态
//		System.out.println(new Gson().toJson(ns.QueryOrder(Username, Password, CinemaCode, "20190415XXX888000000142100")));	//查订单
//		System.out.println(new Gson().toJson(ns.QueryTicket(Username, Password, CinemaCode, "2019041681129039","573027"))); //查询影票
//		System.out.println(new Gson().toJson(ns.FetchTicket(Username, Password, CinemaCode, "2019041681129039","573027"))); //确认出票
//		System.out.println(new Gson().toJson(ns.RefundTicket(Username, Password, CinemaCode, "2019041699719038","169932")));//退票
	}
	
	@Test
	public void test1() throws Exception{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		
		String Username = "MiniProgram";
		String Password = "6BF477EBCC446F54E6512AFC0E976C41";
		
		ReleaseSeatQueryXmlSeat seat1 = new ReleaseSeatQueryXmlSeat();
		seat1.setSeatCode("0000000000000001-1-3");
		
		ReleaseSeatQueryXmlSeat seat2 = new ReleaseSeatQueryXmlSeat();
		seat2.setSeatCode("0000000000000001-1-4");
		
		
		List<ReleaseSeatQueryXmlSeat> Seats = new ArrayList<ReleaseSeatQueryXmlSeat>();
		Seats.add(seat1);
		Seats.add(seat2);
		
		ReleaseSeatQueryXmlOrder order = new ReleaseSeatQueryXmlOrder();
		order.setOrderCode("20190415XXX888000000111900");
		order.setSessionCode("888190416BP6024J");
		order.setCount(2);
		order.setSeat(Seats);
		
		ReleaseSeatQueryXml releaseXml = new ReleaseSeatQueryXml();
		releaseXml.setCinemaCode("18888888");
		releaseXml.setOrder(order);
		
		String QueryXml = JaxbXmlUtil.convertToXml(releaseXml);
		System.out.println(new Gson().toJson(ns.ReleaseSeat(Username,Password, QueryXml))); //解锁座位
	}
	
	@Test
	public void testCard() throws Exception{
		YkInterface yy = new YkInterface();
		
		Usercinemaview usercinema = new Usercinemaview();
		usercinema.setCinemaCode("18888888");
		usercinema.setDefaultUserName("LP_TEST");
		usercinema.setDefaultPassword("80404D0C6D24E87F650FF7D1985CD762");
		usercinema.setUrl("http://mcop-dsf.yuekeyun.com");
		usercinema.setCinemaId("888");
		usercinema.setUserId(12L);
		
//		yy.CardRegister(usercinema, "123456", "1", "100", "Test_sheng", "13800000000", "1", "1");	//开卡
//		yy.QueryCardLevel(usercinema);	//查询会员卡等级
//		yy.CardCharge(usercinema, "88820000013", "123456",CardChargeTypeEnum.Cash, (float) 300.00);//充值
		
//		yy.QueryCardTradeRecord(usercinema, "88820000013","123456", "2019-04-11", "2019-04-21", "10", "1"); //交易记录
//		yy.QueryDiscount(usercinema, "1", "88820000013",	"123456", "1", "888190415F886DBT", "", "","", "", "");//会员卡折扣
		
//		yy.QueryCard(usercinema, "88820000013", "123456");//查询会员卡信息
//		yy.LoginCard(usercinema, "88820000013", "888889");//登陆会员卡
		
//		System.out.println("解密："+yy.decrypt("WUtTRTEyMzRZS1NFMTIzNAtd8hvk/Brav7lpI9s/x4tu/6gsRGHhzIiG6Uov9JfSsZlPS27/eA0tpMdFvDF1Qb", usercinema.getDefaultPassword()));
		
	}
	
	@Test
	public void testCard2() throws Exception{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		
		String Username = "MiniProgram";
		String Password = "6BF477EBCC446F54E6512AFC0E976C41";
		String cinemaCode="18888888";
		
//		System.out.println(new Gson().toJson(ns.CardRegister(Username,Password,cinemaCode, "123456", "1", "100", "Test_sheng", "13959557890", "135", "男")));	//开卡
//		System.out.println(new Gson().toJson(ns.QueryCardLevel(Username, Password, cinemaCode)));//查询会员卡等级
//		System.out.println(new Gson().toJson(ns.CardCharge(Username,Password, cinemaCode, "888201904", "123456", "AliPay", "200")));//充值
		//查询会员卡交易记录
//		System.out.println(new Gson().toJson(ns.QueryCardTradeRecord(Username, Password, cinemaCode, "888201904", "123456", "2019-04-20", "2019-04-24", "10", "1")));
		//得到会员卡折扣
		System.out.println(new Gson().toJson(ns.QueryDiscount(Username, Password,cinemaCode, "1",  "888201904", "123456", "3", "888190415F886DBT", "1", "1","1", "1", "1")));
		
//		System.out.println(new Gson().toJson(ns.QueryCard(Username, Password, cinemaCode, "888201904", "123456")));//查询会员卡
//		System.out.println(new Gson().toJson(ns.LoginCard(Username, Password, cinemaCode, "888201904", "123456")));//登陆会员卡
		
	}
	
	@Test
	public void MTXtest() throws Exception{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		
		String Username = "MiniProgram";
		String Password = "6BF477EBCC446F54E6512AFC0E976C41";
		String CinemaCode = "gzxxx";
		String SessionCode = "5137013354";
		
//		System.out.println(new Gson().toJson(ns.QueryCinemaList(Username,Password)));	//影院列表
//		System.out.println(new Gson().toJson(ns.QueryCinema(Username, Password, CinemaCode)));	//影院基础信息
//		System.out.println(new Gson().toJson(ns.QuerySeat(Username, Password, CinemaCode, "04"))); //查询影厅座位信息
//		System.out.println(new Gson().toJson(ns.QuerySession(Username, Password, CinemaCode, "2019-04-16","2019-04-17")));//查排期
//		System.out.println(new Gson().toJson(ns.QueryFilm(Username, Password, CinemaCode, "2019-04-16",	"2019-04-17"))); //查询影片信息		
//		System.out.println(new Gson().toJson(ns.QuerySessionSeat(Username, Password, CinemaCode, SessionCode, "Sold")));//查询放映计划座位售出状态
		
		LockSeatQueryXmlSeat seat1 = new LockSeatQueryXmlSeat();
		seat1.setSeatCode("04010114");
		seat1.setPrice(50.0);
		seat1.setAddFee(0.0);
		seat1.setCinemaAllowance(0.0);
		seat1.setFee(5.0);
		LockSeatQueryXmlSeat seat2 = new LockSeatQueryXmlSeat();
		seat2.setSeatCode("04010113");
		seat2.setPrice(50.0);
		seat2.setAddFee(0.0);
		seat2.setCinemaAllowance(0.0);
		seat2.setFee(5.0);
		
		List<LockSeatQueryXmlSeat> Seats = new ArrayList<LockSeatQueryXmlSeat>();
		Seats.add(seat1);
//		Seats.add(seat2);
		
		LockSeatQueryXmlOrder order = new LockSeatQueryXmlOrder();
		order.setSessionCode("5137013354");
		order.setPayType("0");
		order.setCount(1);
		order.setSeat(Seats);
		
		LockSeatQueryXml xml = new LockSeatQueryXml();
		xml.setCinemaCode("gzxxx");
		xml.setOrder(order);
		
		String QueryXml = JaxbXmlUtil.convertToXml(xml);
//		System.out.println("-------"+QueryXml);
//		System.out.println(new Gson().toJson(ns.LockSeat(Username, Password, QueryXml)));	//锁座
		
		ReleaseSeatQueryXmlSeat seat11 = new ReleaseSeatQueryXmlSeat();
		seat11.setSeatCode("04010214");
		ReleaseSeatQueryXmlSeat seat12 = new ReleaseSeatQueryXmlSeat();
		seat12.setSeatCode("04010113");	
		
		List<ReleaseSeatQueryXmlSeat> Seatslist = new ArrayList<ReleaseSeatQueryXmlSeat>();
		Seatslist.add(seat11);
//		Seatslist.add(seat12);
		
		ReleaseSeatQueryXmlOrder releaseorder = new ReleaseSeatQueryXmlOrder();
		releaseorder.setOrderCode("953903759");
		releaseorder.setSessionCode("5137013356");
		releaseorder.setCount(2);
		releaseorder.setSeat(Seatslist);
		
		ReleaseSeatQueryXml releaseXml = new ReleaseSeatQueryXml();
		releaseXml.setCinemaCode("gzxxx");
		releaseXml.setOrder(releaseorder);
		
		String relQueryXml = JaxbXmlUtil.convertToXml(releaseXml);
//		System.out.println(new Gson().toJson(ns.ReleaseSeat(Username,Password, relQueryXml))); //解锁座位
		
		SubmitOrderQueryXmlSeat subSeat1 = new SubmitOrderQueryXmlSeat();
		subSeat1.setSeatCode("04010114");
		subSeat1.setAddFee(0.0);
		subSeat1.setCinemaAllowance(0.0);
		subSeat1.setFee(5.0);
		subSeat1.setPrice(40.0);
		subSeat1.setRealPrice(46.0);
		SubmitOrderQueryXmlSeat subSeat2 = new SubmitOrderQueryXmlSeat();
		subSeat2.setSeatCode("04010113");
		subSeat2.setAddFee(0.0);
		subSeat2.setCinemaAllowance(0.0);
		subSeat2.setFee(5.0);
		subSeat2.setPrice(40.0);
		subSeat2.setRealPrice(46.0);
		
		List<SubmitOrderQueryXmlSeat> Seat31 = new ArrayList<SubmitOrderQueryXmlSeat>();
		Seat31.add(subSeat1);
//		Seat31.add(subSeat2);
		
		SubmitOrderQueryXmlOrder order11 = new SubmitOrderQueryXmlOrder();
		order11.setCount(1);
		order11.setMobilePhone("13959557890");
		order11.setOrderCode("953922590");
		order11.setSessionCode("5137013354");
		order11.setSeat(Seat31);
		
		SubmitOrderQueryXml submitXml = new SubmitOrderQueryXml();
		submitXml.setCinemaCode("gzxxx");
		submitXml.setOrder(order11);
		
		String subQueryXml = JaxbXmlUtil.convertToXml(submitXml);
		System.out.println(new Gson().toJson(ns.SubmitOrder(Username,Password, subQueryXml)));	//提交订单
		
//		System.out.println(new Gson().toJson(ns.QueryPrint(Username, Password, CinemaCode, "953911444","750543")));	//查询出票状态
//		System.out.println(new Gson().toJson(ns.QueryOrder(Username, Password, CinemaCode, "953911444")));	//查订单
//		System.out.println(new Gson().toJson(ns.QueryTicket(Username, Password, CinemaCode, "953911444","750543"))); //查询影票
//		System.out.println(new Gson().toJson(ns.FetchTicket(Username, Password, CinemaCode, "953911444","750543"))); //确认出票
//		System.out.println(new Gson().toJson(ns.RefundTicket(Username, Password, CinemaCode, "953911444","750543")));//退票
		
		/*OrderServiceImpl _orderService = SpringUtil.getBean(OrderServiceImpl.class);
		OrderView order4 = null;
		if (!submitXml.getOrder().getOrderCode().isEmpty()) {
			order4 = _orderService.getOrderWidthLockOrderCode(submitXml.getCinemaCode(), submitXml.getOrder().getOrderCode());
		}
		if (order == null || (order4.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.Locked.getStatusCode()
				&& order4.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.SubmitFail.getStatusCode()
				&& order4.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.Payed.getStatusCode())) {
			System.out.println("222222222");
		}
		System.out.println(order4.getOrderBaseInfo().getOrderStatus());
		System.out.println(order4.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.Locked.getStatusCode());
		System.out.println(order4.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.SubmitFail.getStatusCode());
		System.out.println(order4.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.Payed.getStatusCode());*/
	}
	
	
	public static void main(String[] args) throws Exception {
		Date newDate=new Date();
		
		}
	
	
	
	
    
	 
	 
	
}
