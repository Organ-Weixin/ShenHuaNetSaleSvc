package com.boot.security.server;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
import com.boot.security.server.utils.JaxbXmlUtil;
import com.google.gson.Gson;

@SpringBootTest
@RunWith(SpringRunner.class)
public class YkTest {

	@Test
	public void test() throws Exception{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		
		String Username = "MiniProgram";
		String Password = "6BF477EBCC446F54E6512AFC0E976C41";
		String CinemaCode = "18888888";
		String SessionCode = "888190416BP6024J";
		
//		System.out.println(new Gson().toJson(ns.QueryCinemaList(Username,Password)));	//影院列表
//		System.out.println(new Gson().toJson(ns.QueryCinema(Username, Password, CinemaCode)));	//影院基础信息
//		System.out.println(new Gson().toJson(ns.QuerySeat(Username, Password, CinemaCode, "0000000000000005"))); //查询影厅座位信息
//		System.out.println(new Gson().toJson(ns.QuerySession(Username, Password, CinemaCode, "2019-04-16","2019-04-17")));//查排期
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
		System.out.println(new Gson().toJson(ns.QueryOrder(Username, Password, CinemaCode, "20190415XXX888000000142100")));	//查订单
//		System.out.println(new Gson().toJson(ns.QueryTicket(Username, Password, CinemaCode, "2019041681129039","573027"))); //查询影票
//		System.out.println(new Gson().toJson(ns.FetchTicket(Username, Password, CinemaCode, "2019041681129039","573027"))); //确认出票
		System.out.println(new Gson().toJson(ns.RefundTicket(Username, Password, CinemaCode, "2019041699719038","169932")));//退票
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
	
	public static void main(String[] args) throws Exception {

		
	}
}
