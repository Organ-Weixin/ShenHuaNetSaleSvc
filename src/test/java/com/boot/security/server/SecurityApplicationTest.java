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
		userCinema.setCinemaCode("33097601");
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
		od.setSessionCode("3088273");
		List<Orderseatdetails> osList = new ArrayList<Orderseatdetails>();
		Orderseatdetails os = new Orderseatdetails();
		Orderseatdetails os1 = new Orderseatdetails();
		Orderseatdetails os2 = new Orderseatdetails();
		os.setSeatCode("118167");
		os.setSalePrice(50.00);
		os.setFee(10.00);
		os1.setSeatCode("118168");
		os1.setSalePrice(50.00);
		os1.setFee(10.00);
		os2.setSeatCode("118169");
		os2.setSalePrice(50.00);
		os2.setFee(10.00);
		osList.add(os);
		osList.add(os1);
		osList.add(os2);
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
		od.setSessionCode("3075138");
		List<Orderseatdetails> osList = new ArrayList<Orderseatdetails>();
		od.setLockOrderCode("1554965861291maisxuq");
		Orderseatdetails os = new Orderseatdetails();
		Orderseatdetails os1 = new Orderseatdetails();
		Orderseatdetails os2 = new Orderseatdetails();
		os.setSeatCode("115155");
		os.setSalePrice(50.00);
		os.setFee(10.00);
		os1.setSeatCode("115156");
		os1.setSalePrice(50.00);
		os1.setFee(10.00);
		os2.setSeatCode("115157");
		os2.setSalePrice(50.00);
		os2.setFee(10.00);
		osList.add(os);
		osList.add(os1);
		osList.add(os2);
		order.setOrderSeatDetails(osList);
		order.setOrderBaseInfo(od);
		di.SubmitOrder(userCinema, order);
		//订单编码1554965861291maisxuq-----打印编码1904111457421404-----验证码0000000000421404
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
		od.setLockOrderCode("1554965861291maisxuq");
		od.setPrintNo("1904111457421404");
		od.setVerifyCode("0000000000421404");
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
	public void QueryCinemaListTest(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryCinemaList("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41");
	}
	@Test
	public void QueryCinemaTest(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryCinema("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33096401");
	}
	@Test
	public void QuerySeatTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QuerySeat("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33096401", "0000000000000001");
	}
	@Test
	public void QueryFilmTest() throws ParseException{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryFilm("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33096401","2019-04-12 00：00：00", "2019-04-20 00:00:00");
	}
	@Test
	public void QuerySessionTestMid() throws ParseException{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QuerySession("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33096401", "2019-04-12 00：00：00",  "2019-04-20 00:00:00");
	}
	@Test
	public void QuerySessionSeatTest(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QuerySessionSeat("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33096401", "3097406", "Available");
	}
	@Test
	public void LockSeatTest() throws Exception{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat seatxml1 = new LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat();
		seatxml1.setSeatCode("");
		seatxml1.setPrice(50.00);
		seatxml1.setFee(10.00);
		seatxml1.setAddFee(null);
		seatxml1.setCinemaAllowance(null);
		LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat seatxml2 = new LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat();
		seatxml2.setSeatCode("118049");
		seatxml2.setPrice(50.00);
		seatxml2.setFee(10.00);
		seatxml2.setAddFee(null);
		seatxml2.setCinemaAllowance(null);
		LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat seatxml3 = new LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat();
		seatxml3.setSeatCode("118050");
		seatxml3.setPrice(50.00);
		seatxml3.setFee(10.00);
		seatxml3.setAddFee(null);
		seatxml3.setCinemaAllowance(null);
		List<LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat>  seat = new ArrayList();
		seat.add(seatxml1);
		seat.add(seatxml2);
		seat.add(seatxml3);
		//1068
		LockSeatQueryXmlOrder order = new LockSeatQueryXmlOrder();
		order.setPayType("118051");
		order.setSessionCode("3097406");
		order.setCount(3);
		order.setSeat(seat);
		LockSeatQueryXml xml = new LockSeatQueryXml();
		xml.setCinemaCode("33096401");
		xml.setOrder(order);
		String QueryXml = JaxbXmlUtil.convertToXml(xml);
		ns.LockSeat("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", QueryXml);
	}
}
