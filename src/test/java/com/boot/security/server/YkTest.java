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
		String CinemaCode = "99999959";
		String SessionCode = "4531904146V20JXJ";
		
		System.out.println(new Gson().toJson(ns.QueryCinemaList(Username,Password)));	//影院列表
		System.out.println(new Gson().toJson(ns.QueryCinema(Username, Password, CinemaCode)));	//影院基础信息
//		System.out.println(new Gson().toJson(ns.QuerySeat(Username, Password, CinemaCode, "0000000000000005"))); //查询影厅座位信息
//		System.out.println(new Gson().toJson(ns.QuerySession(Username, Password, CinemaCode, "2019-04-14","2019-04-15")));//查排期
//		System.out.println(new Gson().toJson(ns.QueryFilm(Username, Password, CinemaCode, "2019-04-14",	"2019-04-15"))); //查询影片信息		
//		System.out.println(new Gson().toJson(ns.QuerySessionSeat(Username, Password, CinemaCode, SessionCode, "Available")));//查询放映计划座位售出状态
		
		
		/*LockSeatQueryXmlSeat seat1 = new LockSeatQueryXmlSeat();
		seat1.setSeatCode("0000000000000001-9-01");
		
		List<LockSeatQueryXmlSeat> Seats = new ArrayList<LockSeatQueryXmlSeat>();
		Seats.add(seat1);
		
		LockSeatQueryXmlOrder order = new LockSeatQueryXmlOrder();
		order.setSessionCode("002190410BRXFP24");
		order.setSeat(Seats);
		
		
		LockSeatQueryXml xml=new LockSeatQueryXml();
		xml.setCinemaCode("33010301");
		xml.setOrder(order);
		String QueryXml=xml.toString();*/
//		String QueryXml = "{\"LockSeat\":{\"CinemaCode\": \"33010301\",\"Order\": {\"SessionCode\":\"002190410BRXFP24\",Seat\":[{\"SeatCode\":\"0000000000000001-9-01\"}]}}}";
		LockSeatQueryXmlSeat seat1 = new LockSeatQueryXmlSeat();
		seat1.setSeatCode("0000000000000001-1-01");
		seat1.setPrice(50.0);
		seat1.setAddFee(0.0);
		seat1.setCinemaAllowance(0.0);
		seat1.setFee(5.0);
		LockSeatQueryXmlSeat seat2 = new LockSeatQueryXmlSeat();
		seat2.setSeatCode("0000000000000001-1-02");
		seat2.setPrice(50.0);
		seat2.setAddFee(0.0);
		seat2.setCinemaAllowance(0.0);
		seat2.setFee(5.0);
		
		List<LockSeatQueryXmlSeat> Seats = new ArrayList<LockSeatQueryXmlSeat>();
		Seats.add(seat1);
//		Seats.add(seat2);
		
		LockSeatQueryXmlOrder order = new LockSeatQueryXmlOrder();
		order.setSessionCode("4531904146V20JXJ");
		order.setPayType("0");
		order.setCount(1);
		order.setSeat(Seats);
		
		LockSeatQueryXml xml = new LockSeatQueryXml();
		xml.setCinemaCode("33010501");
		xml.setOrder(order);
		
		String QueryXml = JaxbXmlUtil.convertToXml(xml);
//		System.out.println(new Gson().toJson(ns.LockSeat(Username, Password, QueryXml)));	//锁座
		
		
		
		SubmitOrderQueryXmlSeat subSeat1 = new SubmitOrderQueryXmlSeat();
		subSeat1.setSeatCode("0000000000000001-1-01");
		subSeat1.setAddFee(0.0);
		subSeat1.setCinemaAllowance(0.0);
		subSeat1.setFee(5.0);
		subSeat1.setPrice(40.0);
		subSeat1.setRealPrice(46.0);
		
		List<SubmitOrderQueryXmlSeat> Seat = new ArrayList<SubmitOrderQueryXmlSeat>();
		Seat.add(subSeat1);
		
		SubmitOrderQueryXmlOrder order1 = new SubmitOrderQueryXmlOrder();
		order1.setCount(1);
		order1.setMobilePhone("13959557890");
		order1.setOrderCode("20190413XXX453000005694700");
		order1.setSessionCode("4531904146V20JXJ");
		order1.setSeat(Seat);
		
		SubmitOrderQueryXml submitXml = new SubmitOrderQueryXml();
		submitXml.setCinemaCode("33010501");
		submitXml.setOrder(order1);
		
		String subQueryXml = JaxbXmlUtil.convertToXml(submitXml);
//		System.out.println(new Gson().toJson(ns.SubmitOrder(Username,Password, subQueryXml)));	//提交订单
		
//		System.out.println(new Gson().toJson(ns.QueryPrint(Username, Password, CinemaCode, "2019041411582231","410335")));	//查询出票状态
//		System.out.println(new Gson().toJson(ns.QueryOrder(Username, Password, CinemaCode, "20190413XXX453000005694700")));	//查订单
//		System.out.println(new Gson().toJson(ns.QueryTicket(Username, Password, CinemaCode, "2019041411582231","410335"))); //查询影票
//		System.out.println(new Gson().toJson(ns.FetchTicket(Username, Password, CinemaCode, "2019041411582231","410335"))); //确认出票
//		System.out.println(new Gson().toJson(ns.RefundTicket(Username, Password, CinemaCode, "2019041411582231","410335")));//退票
	}
	
	@Test
	public void test1() throws Exception{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		
		String Username = "MiniProgram";
		String Password = "6BF477EBCC446F54E6512AFC0E976C41";
		String CinemaCode = "33010501";
		
		ReleaseSeatQueryXmlSeat seat2 = new ReleaseSeatQueryXmlSeat();
		seat2.setSeatCode("0000000000000001-1-02");
		/*seat2.setPrice(50.0);
		seat2.setAddFee(0.0);
		seat2.setCinemaAllowance(0.0);
		seat2.setFee(5.0);*/
		
		List<ReleaseSeatQueryXmlSeat> Seats = new ArrayList<ReleaseSeatQueryXmlSeat>();
//		Seats.add(seat1);
		Seats.add(seat2);
		
		ReleaseSeatQueryXmlOrder order = new ReleaseSeatQueryXmlOrder();
		order.setOrderCode("20190413XXX453000005193300");
		order.setSessionCode("4531904146V20JXJ");
//		order.setPayType("0");
		order.setCount(1);
		order.setSeat(Seats);
		
		ReleaseSeatQueryXml releaseXml = new ReleaseSeatQueryXml();
		releaseXml.setCinemaCode("33010501");
		releaseXml.setOrder(order);
		
		String QueryXml = JaxbXmlUtil.convertToXml(releaseXml);
		System.out.println(new Gson().toJson(ns.ReleaseSeat(Username,Password, QueryXml))); //解锁座位
	}
	
	public static void main(String[] args) throws Exception {

		
	}
}
