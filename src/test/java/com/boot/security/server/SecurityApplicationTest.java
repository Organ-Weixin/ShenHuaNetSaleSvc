package com.boot.security.server;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.boot.security.server.api.core.LockSeatQueryXml;
import com.boot.security.server.api.core.LockSeatQueryXml.LockSeatQueryXmlOrder;
import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.ReleaseSeatQueryXml;
import com.boot.security.server.api.core.ReleaseSeatQueryXml.ReleaseSeatQueryXmlOrder;
import com.boot.security.server.api.core.SubmitOrderQueryXml;
import com.boot.security.server.api.core.SubmitOrderQueryXml.SubmitOrderQueryXmlOrder;
import com.boot.security.server.api.core.SubmitOrderQueryXml.SubmitOrderQueryXmlOrder.SubmitOrderQueryXmlSeat;
import com.boot.security.server.api.ctms.reply.Dy1905GetCinemaAllSessionResult;
import com.boot.security.server.api.ctms.reply.Dy1905Interface;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.SessionSeatStatusEnum;
import com.boot.security.server.model.StatusEnum;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.utils.JaxbXmlUtil;


@SpringBootTest
@RunWith(SpringRunner.class)
public class SecurityApplicationTest {
	@Test
	public void test() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaId("194");
		di.QuerySession(userCinema, null, null);
	}
	@Test
	public void QueryCinemaAndScreenTest() throws ParseException{
		Date date = new Date();
		String s = new SimpleDateFormat("yyyy-MM-dd").format(date);
		s+= " 01:00:00";
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s));
		/*Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setCinemaCode("33096401");
		di.QueryCinema(userCinema);*/
	}
	@Test
	public void QuerySeatTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		//userCinema.setCinemaId("199");
		userCinema.setCinemaId("194");
		Screeninfo screen = new Screeninfo();
		//screen.setScreenId("1072");
		screen.setScreenId("1078");
		//userCinema.setCinemaCode("33096401");
		userCinema.setCinemaCode("33097601");
		screen.setSCode("0000000000000009");
		di.QuerySeat(userCinema, screen);
	}
	@Test
	public void QuerySession() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaCode("33097601");
		userCinema.setCinemaId("194");
		userCinema.setUserId(12l);
		di.QuerySession(userCinema, new Date(), null);
	}
	@Test
	public void QueryFilm() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaCode("33097601");
		userCinema.setUserId(12l);
		userCinema.setCinemaId("194");
		di.QueryFilm(userCinema, new Date(), null);
	}
	@Test
	public void QuerySessionSeat() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaCode("33097601");
		userCinema.setCinemaId("194");
		di.QuerySessionSeat(userCinema, "3075111", SessionSeatStatusEnum.Available);
	}
	@Test
	public void QuerySessionTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUserId(12l);
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaCode("33096401");
		//userCinema.setCinemaId("199");
		userCinema.setCinemaId("194");
		di.QuerySession(userCinema, new Date(), null);
	}
	@Test
	public void tests() throws ParseException{
		long time1 = 1554963946;  
		String result1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time1 * 1000));  
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(result1);  
		System.out.println("10位数的时间戳（秒）--->Date:" + date);
	}
	@Test
	public void LockSeat() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		OrderView order = new OrderView();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaCode("33096401");
		userCinema.setCinemaId("199");
		Orders od = new Orders();
		od.setSessionCode("3109574");
		List<Orderseatdetails> osList = new ArrayList<Orderseatdetails>();
		Orderseatdetails os = new Orderseatdetails();
		Orderseatdetails os1 = new Orderseatdetails();
		Orderseatdetails os2 = new Orderseatdetails();
		os.setSeatCode("118052");
		os.setSalePrice(50.00);
		os.setFee(10.00);
		os1.setSeatCode("118050");
		os1.setSalePrice(50.00);
		os1.setFee(10.00);
		os2.setSeatCode("118051");
		os2.setSalePrice(50.00);
		os2.setFee(10.00);
		osList.add(os);
		//osList.add(os1);
		//osList.add(os2);
		order.setOrderSeatDetails(osList);
		order.setOrderBaseInfo(od);
		di.LockSeat(userCinema, order);
	}
	@Test
	public void ReleaseSeatTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		OrderView order = new OrderView();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		/*userCinema.setCinemaCode("33097601");
		userCinema.setCinemaId("194");*/
		Orders od = new Orders();
		od.setLockOrderCode("1554963902113udyirxy");
		order.setOrderBaseInfo(od);
		di.ReleaseSeat(userCinema, order);
	}
	@Test
	public void SubmitOrderTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		OrderView order = new OrderView();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaCode("33097601");
		userCinema.setCinemaId("194");
		Orders od = new Orders();
		od.setSessionCode("3109574");
		List<Orderseatdetails> osList = new ArrayList<Orderseatdetails>();
		od.setLockOrderCode("1555291410560twbqwnt");
		Orderseatdetails os = new Orderseatdetails();
		Orderseatdetails os1 = new Orderseatdetails();
		Orderseatdetails os2 = new Orderseatdetails();
		os.setSeatCode("118049");
		os.setSalePrice(50.00);
		os.setFee(10.00);
		os1.setSeatCode("118050");
		os1.setSalePrice(50.00);
		os1.setFee(10.00);
		os2.setSeatCode("118051");
		os2.setSalePrice(50.00);
		os2.setFee(10.00);
		osList.add(os);
		osList.add(os1);
		osList.add(os2);
		order.setOrderSeatDetails(osList);
		order.setOrderBaseInfo(od);
		di.SubmitOrder(userCinema, order);
		//订单编码1555291410560twbqwnt-----打印编码1904150923305834-----验证码0000000000305834
	}
	@Test
	public void RefundTicketTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		OrderView order = new OrderView();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		Orders od = new Orders();
		od.setLockOrderCode("1555309208124sjulhsc");
		od.setPrintNo("1904151420072408");
		od.setVerifyCode("0000000000072408");
		order.setOrderBaseInfo(od);
		di.RefundTicket(userCinema, order);
	}
	@Test
	public void QueryOrderTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		OrderView order = new OrderView();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		Orders od = new Orders();
		od.setLockOrderCode("1554965861291maisxuq");
		List<Orderseatdetails> osList = new ArrayList<Orderseatdetails>();
		Orderseatdetails os = new Orderseatdetails();
		Orderseatdetails os1 = new Orderseatdetails();
		Orderseatdetails os2 = new Orderseatdetails();
		os.setSeatCode("115158");
		os.setSalePrice(50.00);
		os.setFee(10.00);
		os1.setSeatCode("115159");
		os1.setSalePrice(50.00);
		os1.setFee(10.00);
		os2.setSeatCode("115160");
		os2.setSalePrice(50.00);
		os2.setFee(10.00);
		osList.add(os);
		osList.add(os1);
		osList.add(os2);
		order.setOrderSeatDetails(osList);
		order.setOrderBaseInfo(od);
		/*od.setPrintNo("1904111457421404");
		od.setVerifyCode("0000000000421404");*/
		//di.QueryTicket(userCinema, order);
		di.QueryPrint(userCinema, order);
	}
	@Test
	public void FetchTicketTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		OrderView order = new OrderView();
		Orders orderBaseInfo = new Orders();
		orderBaseInfo.setSubmitOrderCode("1555297230333kxrrbvt");
		order.setOrderBaseInfo(orderBaseInfo);
		di.FetchTicket(userCinema, order);
	}
	
	
	////////////////////////////////////////中间件/////////////////////////////////////////////
	@Test
	public void QueryCinemaListTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryCinemaList("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41");
	}
	@Test
	public void QueryCinemaTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryCinema("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33096401");
	}
	@Test
	public void QuerySeatTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QuerySeat("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33096401", "0000000000000001");
	}
	@Test
	public void QueryFilmTestMid() throws ParseException{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryFilm("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33096401","2019-04-12 00：00：00", "2019-04-20 00:00:00");
	}
	@Test
	public void QuerySessionTestMid() throws ParseException{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QuerySession("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33096401", "2019-01-01 00:00:00",  "2019-06-20 00:00:00");
	}
	@Test
	public void QuerySessionSeatTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QuerySessionSeat("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33096401", "3109574", "Sold");
	}
	@Test
	public void LockSeatTestMid() throws Exception{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat seatxml1 = new LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat();
		seatxml1.setSeatCode("118052");
		seatxml1.setPrice(50.00);
		seatxml1.setFee(10.00);
		seatxml1.setAddFee(0.00);
		seatxml1.setCinemaAllowance(0.00);
		LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat seatxml2 = new LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat();
		seatxml2.setSeatCode("118053");
		seatxml2.setPrice(50.00);
		seatxml2.setFee(10.00);
		seatxml2.setAddFee(0.00);
		seatxml2.setCinemaAllowance(0.00);
		LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat seatxml3 = new LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat();
		seatxml3.setSeatCode("118057");
		seatxml3.setPrice(50.00);
		seatxml3.setFee(10.00);
		seatxml3.setAddFee(0.00);
		seatxml3.setCinemaAllowance(0.00);
		List<LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat>  seat = new ArrayList();
		seat.add(seatxml1);
		seat.add(seatxml2);
		//seat.add(seatxml3);
		//1068
		LockSeatQueryXmlOrder order = new LockSeatQueryXmlOrder();
		order.setPayType("0");
		//order.setSessionCode("3097406");
		order.setSessionCode("3109574");
		order.setCount(seat.size());
		order.setSeat(seat);
		LockSeatQueryXml xml = new LockSeatQueryXml();
		xml.setCinemaCode("33096401");
		xml.setOrder(order);
		String QueryXml = JaxbXmlUtil.convertToXml(xml);
		ns.LockSeat("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", QueryXml);
	}
	@Test
	public void ReleaseSeatTestMid() throws Exception{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ReleaseSeatQueryXml.ReleaseSeatQueryXmlOrder.ReleaseSeatQueryXmlSeat seatxml1 = new ReleaseSeatQueryXml.ReleaseSeatQueryXmlOrder.ReleaseSeatQueryXmlSeat();
		seatxml1.setSeatCode("118050");
		ReleaseSeatQueryXml.ReleaseSeatQueryXmlOrder.ReleaseSeatQueryXmlSeat seatxml2 = new ReleaseSeatQueryXml.ReleaseSeatQueryXmlOrder.ReleaseSeatQueryXmlSeat();
		seatxml2.setSeatCode("118051");
		ReleaseSeatQueryXml.ReleaseSeatQueryXmlOrder.ReleaseSeatQueryXmlSeat seatxml3 = new ReleaseSeatQueryXml.ReleaseSeatQueryXmlOrder.ReleaseSeatQueryXmlSeat();
		seatxml3.setSeatCode("118052");
		List<ReleaseSeatQueryXml.ReleaseSeatQueryXmlOrder.ReleaseSeatQueryXmlSeat>  seat = new ArrayList();
		seat.add(seatxml1);
		seat.add(seatxml2);
		seat.add(seatxml3);
		//1068
		//1555156791756iplhcyp
		ReleaseSeatQueryXmlOrder order = new ReleaseSeatQueryXmlOrder();
		order.setSessionCode("3097406");
		order.setOrderCode("1555296940461ajdobyg");
		order.setCount(seat.size());
		order.setSeat(seat);
		ReleaseSeatQueryXml xml = new ReleaseSeatQueryXml();
		xml.setCinemaCode("33096401");
		xml.setOrder(order);
		String QueryXml = JaxbXmlUtil.convertToXml(xml);
		ns.ReleaseSeat("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", QueryXml);
	}
	@Test
	public void SubmitOrderTestMid() throws Exception{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		SubmitOrderQueryXmlSeat seatxml = new SubmitOrderQueryXmlSeat();
		seatxml.setSeatCode("118052");
		seatxml.setPrice(50.00);
		seatxml.setRealPrice(50.00);
		seatxml.setFee(10.00);
		SubmitOrderQueryXmlSeat seatxml2 = new SubmitOrderQueryXmlSeat();
		seatxml2.setSeatCode("118053");
		seatxml2.setPrice(50.00);
		seatxml2.setRealPrice(50.00);
		seatxml2.setFee(10.00);
		SubmitOrderQueryXmlSeat seatxml3 = new SubmitOrderQueryXmlSeat();
		seatxml3.setSeatCode("118057");
		seatxml3.setPrice(50.00);
		seatxml3.setRealPrice(50.00);
		seatxml3.setFee(10.00);
		List<SubmitOrderQueryXmlSeat> seat = new ArrayList();
		seat.add(seatxml);
		seat.add(seatxml2);
		//seat.add(seatxml3);
		SubmitOrderQueryXmlOrder order = new SubmitOrderQueryXmlOrder();
		order.setSeat(seat);
		order.setOrderCode("1555310884690qfzmvdj");
		order.setSessionCode("3109574");
		order.setCount(seat.size());
		order.setMobilePhone("15268553143");
		SubmitOrderQueryXml xml = new SubmitOrderQueryXml();
		xml.setOrder(order);
		xml.setCinemaCode("33096401");
		String QueryXml = JaxbXmlUtil.convertToXml(xml);
		ns.SubmitOrder("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", QueryXml);
		//订单编码1555297230333kxrrbvt-----打印编码1904151100307664-----验证码0000000000307664
	}
	@Test
	public void RefundTicketTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.RefundTicket("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33096401", "1904151448046444", "0000000000046444");
	}
	@Test
	public void QueryPrintTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryPrint("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33096401", "1904150942490518", "0000000000490518");
	}
	@Test
	public void QueryOrderTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryOrder("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33096401", "1555297230333kxrrbvt");
	}
	@Test
	public void QueryTicketTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryTicket("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33096401", "1904151448046444", "0000000000046444");
	}
	@Test
	public void FetchTicketTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.FetchTicket("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33096401", "1904151100307664", "0000000000307664");
	}
}
