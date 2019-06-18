package com.boot.security.server;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.boot.security.server.api.core.CreateGoodsOrderQueryXml;
import com.boot.security.server.api.core.LockSeatQueryXml;
import com.boot.security.server.api.core.LockSeatQueryXml.LockSeatQueryXmlOrder;
import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.ReleaseSeatQueryXml;
import com.boot.security.server.api.core.ReleaseSeatQueryXml.ReleaseSeatQueryXmlOrder;
import com.boot.security.server.api.core.SubmitGoodsOrderQueryXml.SubmitGoodsOrderQueryXmlGoodsList;
import com.boot.security.server.api.core.SubmitGoodsOrderQueryXml.SubmitGoodsOrderQueryXmlGoodsList.SubmitGoodsOrderQueryXmlGoods;
import com.boot.security.server.api.core.SubmitMixOrderQueryXml.SubmitMixOrderQueryXmlGoods;
import com.boot.security.server.api.core.SubmitMixOrderQueryXml.SubmitMixOrderQueryXmlSeat;
import com.boot.security.server.api.core.SubmitMixOrderQueryXml;
import com.boot.security.server.api.core.SubmitGoodsOrderQueryXml;
import com.boot.security.server.api.core.SubmitOrderQueryXml;
import com.boot.security.server.api.core.CreateGoodsOrderQueryXml.CreateGoodsOrderQueryXmlGoodsList;
import com.boot.security.server.api.core.CreateGoodsOrderQueryXml.CreateGoodsOrderQueryXmlGoodsList.CreateGoodsOrderQueryXmlGoods;
import com.boot.security.server.api.core.SubmitOrderQueryXml.SubmitOrderQueryXmlOrder;
import com.boot.security.server.api.core.SubmitOrderQueryXml.SubmitOrderQueryXmlOrder.SubmitOrderQueryXmlSeat;
import com.boot.security.server.api.ctms.reply.Dy1905Interface;
import com.boot.security.server.apicontroller.reply.NetSaleQueryJson;
import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodsorderdetails;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.SessionSeatStatusEnum;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.utils.GoodsCouponsPriceUtil;
import com.boot.security.server.utils.HttpHelper;
import com.boot.security.server.utils.JaxbXmlUtil;
import com.boot.security.server.utils.MD5Util;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;


@SpringBootTest
@RunWith(SpringRunner.class)
public class SecurityApplicationTest {
	@Test
	public void test() throws Exception{
		
	}
	@Test
	public void QueryCinemaAndScreenTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaCode("33097601");
		//userCinema.setCinemaCode("33096401");
		di.QueryCinema(userCinema);
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
		/*userCinema.setCinemaCode("33096401");
		userCinema.setCinemaId("199");*/
		userCinema.setUserId(12l);
		System.out.println(di.QuerySession(userCinema, new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-29"), new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-31")));
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
		System.out.println(new Gson().toJson(di.QuerySessionSeat(userCinema, "3289511", SessionSeatStatusEnum.All)));
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
		//userCinema.setCinemaId("199");
		userCinema.setCinemaId("194");
		di.QuerySession(userCinema, new Date(), null);
	}
	@Test
	public void LockSeat() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		OrderView order = new OrderView();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaCode("33097601");
		userCinema.setCinemaId("194");
		Orders od = new Orders();
		od.setSessionCode("3264726");
		List<Orderseatdetails> osList = new ArrayList<Orderseatdetails>();
		Orderseatdetails os = new Orderseatdetails();
		Orderseatdetails os1 = new Orderseatdetails();
		Orderseatdetails os2 = new Orderseatdetails();
		os.setSeatCode("115803");
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
		//di.LockSeat(userCinema, order);
		System.out.println(new Gson().toJson(di.LockSeat(userCinema, order)));
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
		od.setLockOrderCode("1556088082673lsbbuyr");
		order.setOrderBaseInfo(od);
		di.ReleaseSeat(userCinema, order);
		System.out.println(new Gson().toJson(di.ReleaseSeat(userCinema, order)));
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
	//退票
	@Test
	public void RefundTicketTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		OrderView order = new OrderView();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		Orders od = new Orders();
		od.setLockOrderCode("1560130113321cwyeogn");
		od.setPrintNo("1906100928344951");
		od.setVerifyCode("0000000000344951");
		order.setOrderBaseInfo(od);
		System.out.println(new Gson().toJson(di.RefundTicket(userCinema, order)));
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
	@Test
	public void CardRegisterTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaId("194");
		userCinema.setCinemaCode("33097601");
		di.CardRegister(userCinema, "mimanicai", "4", "100", "刘钰栋", "15268553143", "41061119971208453X", "1");
	}
	@Test
	public void LoginCardTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaId("194");
		userCinema.setCinemaCode("33097601");
		//e042074543 mimanicai
		System.out.println(new Gson().toJson(di.LoginCard(userCinema, "e010213071", "123456")));
	}
	@Test
	public void QueryCardTest() throws Exception{
		//e042036648 e042060347 e042057263 e042021205
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaId("194");
		userCinema.setCinemaCode("33097601");
		System.out.println(new Gson().toJson(di.QueryCard(userCinema, "e042060347", "mima123")));
	}
	@Test
	public void QueryDiscountTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaId("194");
		userCinema.setCinemaCode("33097601");
		System.out.println(new Gson().toJson(di.QueryDiscount(userCinema, null, "e042208925", "mima123", null, "3338309", null, null, null, null, null)));;
	}
	@Test
	public void CardPayTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaId("194");
		userCinema.setCinemaCode("33097601");
		System.out.println(new Gson().toJson(di.CardPay(userCinema, "e042062039", "mima123", 5, 5, null, null, null)));
	}
	@Test
	public void CardChargeTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaId("194");
		userCinema.setCinemaCode("33097601");
		di.CardCharge(userCinema, "e042062039", "mima123", null, 100.00f);
	}
	@Test
	public void MemberTypeListTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaId("194");
		userCinema.setCinemaCode("33097601");
		di.QueryCardLevel(userCinema);
	}
	@Test
	public void GetMemberCardByMobileTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaId("194");
		di.GetMemberCardByMobile(userCinema, "15268553143");
		System.out.println(new Gson().toJson(di.GetMemberCardByMobile(userCinema, "15268553143")));
	}
	//会员卡购票
	@Test
	public void SellTicketCustomMember() throws Exception{
		//{"OrderNo":"1559982969683bkjzyud","PrintNo":"1906081636109240","VerifyCode":"0000000000109240","Status":"Success","ErrorCode":"0"}
		//{"OrderNo":"1559984329627mxsfsop","PrintNo":"1906081658501283","VerifyCode":"0000000000501283","Status":"Success","ErrorCode":"0"}
		Dy1905Interface di = new Dy1905Interface();
		System.out.println(new Gson().toJson(di.SellTicketCustomMember("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33097601", "1560429019270yjixwcf", "e042208925", "mima123")));
	}
	@Test
	public void GoodsList() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaCode("33097601");
		userCinema.setCinemaId("194");
		userCinema.setUserId(12l);
		System.out.println(new Gson().toJson(di.QueryGoods(userCinema)));
	}
	@Test
	public void SubmitGoodsOrder() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaId("194");
		userCinema.setCinemaCode("33097601");
		Goodsorderdetails sorderdetails = new Goodsorderdetails();
		sorderdetails.setGoodsCode("S20180706598148");
		sorderdetails.setGoodsCount(1);
		sorderdetails.setSettlePrice(25.00);
		Goodsorderdetails sorderdetails2 = new Goodsorderdetails();
		sorderdetails2.setGoodsCode("S20180706251906");
		sorderdetails2.setGoodsCount(2);
		sorderdetails2.setSettlePrice(14.00);
		List<Goodsorderdetails> orderGoodsDetails = new ArrayList<Goodsorderdetails>();
		orderGoodsDetails.add(sorderdetails);
		orderGoodsDetails.add(sorderdetails2);
		Goodsorders orderBaseInfo = new Goodsorders();
		orderBaseInfo.setLocalOrderCode("00ssa4f3jsie45dfs24fe66586f0d429");
		orderBaseInfo.setMobilePhone("15268553143");
		orderBaseInfo.setTotalPrice(5.00);
		orderBaseInfo.setTotalSettlePrice(5.00);
		orderBaseInfo.setCardNo("e042208925");
		orderBaseInfo.setCardPassword("mima123");
		orderBaseInfo.setDeliveryType(1);
		orderBaseInfo.setDeliveryAddress("8号厅");
		orderBaseInfo.setDeliveryTime("九点半");
		orderBaseInfo.setDeliveryMark("测试订单，直接忽略。。。");
		GoodsOrderView order = new GoodsOrderView();
		order.setOrderBaseInfo(orderBaseInfo);
		order.setOrderGoodsDetails(orderGoodsDetails);
		System.out.println(new Gson().toJson(di.SubmitGoodsOrder(userCinema, order)));
	}
	@Test
	public void QueryGoodsOrder() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaId("194");
		Goodsorders orderBaseInfo = new Goodsorders();
		orderBaseInfo.setOrderCode("96f93b9f91734c13824f");
		GoodsOrderView order = new GoodsOrderView();
		order.setOrderBaseInfo(orderBaseInfo);
		di.QueryGoodsOrder(userCinema, order);
	}
	@Test
	public void RefundGoods() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaId("194");
		Goodsorders orderBaseInfo = new Goodsorders();
		orderBaseInfo.setOrderCode("123032f3jsie45dfs24f");
		GoodsOrderView order = new GoodsOrderView();
		order.setOrderBaseInfo(orderBaseInfo);
		System.out.println(new Gson().toJson(di.RefundGoods(userCinema, order)));
	}
	@Test
	public void SubmitMixOrder() throws Exception{
		//1559450073869bpwoutm
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		userCinema.setCinemaId("194");
		OrderView order = new OrderView();
		/*Orders od = new Orders();
		od.setSessionCode("3264726");
		List<Orderseatdetails> osList = new ArrayList<Orderseatdetails>();
		Orderseatdetails os = new Orderseatdetails();
		Orderseatdetails os1 = new Orderseatdetails();
		Orderseatdetails os2 = new Orderseatdetails();
		os.setSeatCode("115802");
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
		order.setOrderBaseInfo(od);*/
		Orders od = new Orders();
		od.setSessionCode("3264726");
		List<Orderseatdetails> osList = new ArrayList<Orderseatdetails>();
		od.setLockOrderCode("1559450676646ugvxqqa");
		Orderseatdetails os = new Orderseatdetails();
		Orderseatdetails os1 = new Orderseatdetails();
		Orderseatdetails os2 = new Orderseatdetails();
		os.setSeatCode("115803");
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
		
		Goodsorderdetails sorderdetails = new Goodsorderdetails();
		sorderdetails.setGoodsCode("S20180706598148");
		sorderdetails.setGoodsCount(1);
		sorderdetails.setSettlePrice(25.00);
		Goodsorderdetails sorderdetails2 = new Goodsorderdetails();
		sorderdetails2.setGoodsCode("S20180706251906");
		sorderdetails2.setGoodsCount(1);
		sorderdetails2.setSettlePrice(5.00);
		List<Goodsorderdetails> orderGoodsDetails = new ArrayList<Goodsorderdetails>();
		//orderGoodsDetails.add(sorderdetails);
		orderGoodsDetails.add(sorderdetails2);
		Goodsorders orderBaseInfo = new Goodsorders();
		orderBaseInfo.setLocalOrderCode("1555200091410560twbqwnt");
		orderBaseInfo.setMobilePhone("15268553143");
		orderBaseInfo.setTotalPrice(5.00);
		orderBaseInfo.setTotalSettlePrice(5.00);
		orderBaseInfo.setCardNo("e042555392");
		orderBaseInfo.setCardPassword("mimanicai");
		orderBaseInfo.setDeliveryType(2);
		orderBaseInfo.setDeliveryAddress("8号厅");
		orderBaseInfo.setDeliveryTime("九点半");
		orderBaseInfo.setDeliveryMark("测试订单，直接忽略。。。");
		GoodsOrderView goodsorder = new GoodsOrderView();
		goodsorder.setOrderBaseInfo(orderBaseInfo);
		goodsorder.setOrderGoodsDetails(orderGoodsDetails);
		System.out.println(new Gson().toJson(di.SubmitMixOrder(userCinema, order, goodsorder)));
	}
	
	//影票提交订单<?xml version="1.0"?><SellTicketResult xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">    <ResultCode>0</ResultCode>    <OrderNo>1559450676646ugvxqqa</OrderNo>    <PrintNo>1906021244384380</PrintNo>    <VerifyCode>0000000000384380</VerifyCode></SellTicketResult>
	////////////////////////////////////////中间件/////////////////////////////////////////////
	@Test
	public void QueryCinemaListTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryCinemaList("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41");
	}
	@Test
	public void QueryCinemaTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryCinema("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33097601");
	}
	@Test
	public void QuerySeatTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QuerySeat("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33097601", "0000000000000006");
	}
	@Test
	public void QueryFilmTestMid() throws ParseException{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryFilm("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33096401","2019-05-19 00：00：00", "2019-05-30 00:00:00");
	}
	@Test
	public void QuerySessionTestMid() throws ParseException{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		System.out.println(new Gson().toJson(ns.QuerySession("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33097601", "2019-05-20 00:00:00",  "2019-06-21 00:00:00")));
	}
	@Test
	public void QuerySessionSeatTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		System.out.println(new Gson().toJson(ns.QuerySessionSeat("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33097601", "3289511", "Sold")));
	}
	@Test
	public void LockSeatTestMid() throws Exception{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat seatxml1 = new LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat();
		seatxml1.setSeatCode("115455");
		seatxml1.setPrice(30.00);
		seatxml1.setFee(5.00);
		seatxml1.setAddFee(0.00);
		seatxml1.setCinemaAllowance(0.00);
		LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat seatxml2 = new LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat();
		seatxml2.setSeatCode("115806");
		seatxml2.setPrice(30.00);
		seatxml2.setFee(5.00);
		seatxml2.setAddFee(0.00);
		seatxml2.setCinemaAllowance(0.00);
		LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat seatxml3 = new LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat();
		seatxml3.setSeatCode("118057");
		seatxml3.setPrice(50.00);
		seatxml3.setFee(10.00);
		seatxml3.setAddFee(0.00);
		seatxml3.setCinemaAllowance(0.00);
		List<LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat>  seat = new ArrayList<LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat>();
		seat.add(seatxml1);
		//seat.add(seatxml2);
		//seat.add(seatxml3);
		//1068
		LockSeatQueryXmlOrder order = new LockSeatQueryXmlOrder();
		order.setPayType("0");
		//order.setSessionCode("3097406");
		order.setSessionCode("3338309");
		order.setCount(seat.size());
		order.setSeat(seat);
		LockSeatQueryXml xml = new LockSeatQueryXml();
		xml.setCinemaCode("33097601");
		xml.setOrder(order);
		String QueryXml = JaxbXmlUtil.convertToXml(xml);
		System.out.println(new Gson().toJson(ns.LockSeat("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", QueryXml)));
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
		List<ReleaseSeatQueryXml.ReleaseSeatQueryXmlOrder.ReleaseSeatQueryXmlSeat>  seat = new ArrayList<ReleaseSeatQueryXml.ReleaseSeatQueryXmlOrder.ReleaseSeatQueryXmlSeat>();
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
		List<SubmitOrderQueryXmlSeat> seat = new ArrayList<SubmitOrderQueryXmlSeat>();
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
		System.out.println(new Gson().toJson(ns.RefundTicket("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33111001",
				"3311100170341631", "0333411161300117")));
	}
	@Test
	public void QueryPrintTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryPrint("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33097601", "1906082106577458", "0000000000577458");
	}
	@Test
	public void QueryOrderTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryOrder("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33097601", "1555297230333kxrrbvt");
	}
	@Test
	public void QueryTicketTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryTicket("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33097601", "1904151448046444", "0000000000046444");
	}
	@Test
	public void FetchTicketTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.FetchTicket("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33097601", "1904151100307664", "0000000000307664");
	}
	@Test
	public void CardRegisterTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		System.out.println(new Gson().toJson(ns.CardRegister("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "62549174", "mima123", "5", "0", "杨佳龙", "13675688522", "410611199712080000", "1")));;
	}
	@Test
	public void LoginCardTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		System.out.println(new Gson().toJson(ns.LoginCard("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33111001", "13839698641", "mima123")));
	}
	//会员卡余额查询
	@Test
	public void QueryCardTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		//ns.QueryCard("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33097601", "e042208925", "mima123");
		System.out.println(new Gson().toJson(ns.QueryCard("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33097601", "e061359965", "hbblta")));
	}
	@Test
	public void QueryDiscountTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		System.out.println(new Gson().toJson(ns.QueryDiscount("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "62549174", "1", "15268553143", "123456", "3", "2423201905010013", "2019-05-01 23:20:00", "002759758356", "3d", "45", "20")));
	}
	/*@Test
	public void CardPayTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.CardPay("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33097601", "e042282308", "mima123", "30", "3093945", "2490", "1");
	}*/
	@Test
	public void CardChargeTestMid(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		System.out.println(ns.CardCharge("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33111001", "18758724013", "hbblta", "AliPay", "200"));
	}
	@Test
	public void QueryCardLevelTest(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryCardLevel("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "34140901");
	}
	@Test
	public void QueryGoodsMid(){
		System.out.println(new Gson().toJson(new NetSaleSvcCore().QueryGoods("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33097601")));
	}
	@Test
	public void CreateGoodsOrderMid() throws JsonSyntaxException, Exception{
		CreateGoodsOrderQueryXmlGoods good = new CreateGoodsOrderQueryXmlGoods();
		good.setGoodsCode("S20180706598148");
		good.setGoodsCount(1);
		good.setStandardPrice(25.00);
		good.setGoodsChannelFee(0.00);
		CreateGoodsOrderQueryXmlGoods good2 = new CreateGoodsOrderQueryXmlGoods();
		good2.setGoodsCode("5b2b8948-e6a7-4734-ac00-afd3d06d13f3");
		good2.setGoodsCount(1);
		good2.setStandardPrice(8.00);
		good2.setGoodsChannelFee(0.00);
		List<CreateGoodsOrderQueryXmlGoods> goods = new ArrayList<CreateGoodsOrderQueryXmlGoods>();
		//goods.add(good);
		goods.add(good2);
		CreateGoodsOrderQueryXmlGoodsList goodsList = new CreateGoodsOrderQueryXmlGoodsList();
		goodsList.setGoods(goods);
		CreateGoodsOrderQueryXml xml = new CreateGoodsOrderQueryXml();
		xml.setCinemaCode("33111001");
		xml.setGoodsList(goodsList);
		String QueryXml = JaxbXmlUtil.convertToXml(xml);
		System.out.println(new Gson().toJson(new NetSaleSvcCore().CreateGoodsOrder("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41",QueryXml)));
	}
	@Test
	public void SubmitGoodsOrderMid() throws Exception{
		SubmitGoodsOrderQueryXmlGoods good = new SubmitGoodsOrderQueryXmlGoods();
		good.setGoodsChannelFee(0.00);
		good.setGoodsCode("S20180706598148");
		good.setGoodsCount(1);
		good.setSettlePrice(25.00);
		good.setStandardPrice(25.00);
		SubmitGoodsOrderQueryXmlGoods good2 = new SubmitGoodsOrderQueryXmlGoods();
		good2.setGoodsChannelFee(0.00);
		good2.setGoodsCode("5b2b8948-e6a7-4734-ac00-afd3d06d13f3");
		good2.setGoodsCount(1);
		good2.setSettlePrice(8.00);
		good2.setStandardPrice(8.00);
		List<SubmitGoodsOrderQueryXmlGoods> goods = new ArrayList<SubmitGoodsOrderQueryXmlGoods>();
		//goods.add(good);
		goods.add(good2);
		SubmitGoodsOrderQueryXmlGoodsList goodsList = new SubmitGoodsOrderQueryXmlGoodsList();
		goodsList.setGoods(goods);
		SubmitGoodsOrderQueryXml xml = new SubmitGoodsOrderQueryXml();
		xml.setCinemaCode("33111001");
		xml.setOrderCode("1683190609000232");
		xml.setMobilePhone("15268553143");
		//xml.setCardNo("e042060347");
		//xml.setCardPassword("mima123");
		xml.setGoodsList(goodsList);
		String QueryXml = JaxbXmlUtil.convertToXml(xml);
		System.out.println(new Gson().toJson(new NetSaleSvcCore().SubmitGoodsOrder("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", QueryXml)));
	}
	//"OrderCode":"56b0ad2b9a1246a5b2b2","PickUpCode":"1905051735193387"
	@Test
	public void QueryGoodsOrderMid(){
		System.out.println(new Gson().toJson(new NetSaleSvcCore().QueryGoodsOrder("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33097601", "96f93b9f91734c13824f")));
	}
	@Test
	public void RefundGoodsMid(){
		System.out.println(new Gson().toJson(new NetSaleSvcCore().RefundGoods("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33097601", "e7962cfcf6b147a3bf50", "")));
	}
	@Test
	public void SubmitMixOrderMid() throws JsonSyntaxException, Exception{
		SubmitMixOrderQueryXmlSeat seat = new SubmitMixOrderQueryXmlSeat();
		seat.setSeatCode("115803");
		seat.setPrice(30.00);
		seat.setRealPrice(30.00);
		seat.setFee(5.00);
		seat.setAddFee(0.00);
		seat.setCinemaAllowance(0.00);
		List<SubmitMixOrderQueryXmlSeat> seatList = new ArrayList<SubmitMixOrderQueryXmlSeat>();
		seatList.add(seat);
		SubmitMixOrderQueryXmlGoods goods = new SubmitMixOrderQueryXmlGoods();
		goods.setGoodsCode("S20180706251906");
		goods.setGoodsCount(1);
		goods.setSettlePrice(7.00);
		goods.setStandardPrice(7.00);
		goods.setGoodsChannelFee(0.00);
		List<SubmitMixOrderQueryXmlGoods> goodsList = new ArrayList<SubmitMixOrderQueryXmlGoods>();
		goodsList.add(goods);
		SubmitMixOrderQueryXml xml = new SubmitMixOrderQueryXml();
		xml.setGoods(goodsList);
		xml.setSeat(seatList);
		xml.setCinemaCode("33097601");
		xml.setSessionCode("3264726");
		xml.setPayType("0");
		xml.setPaySeqNo("");
		xml.setMobilePhone("15268553143");
		xml.setOrderCode("1559525852743hobtwxx");
		xml.setGoodsOrderCode("1559525852743hobtwxx");
		xml.setCardNo("e042060347");
		xml.setCardPassword("mima123");
		xml.setSeatCount(seatList.size());
		String QueryXml = JaxbXmlUtil.convertToXml(xml);
		System.out.println(new Gson().toJson(new NetSaleSvcCore().SubmitMixOrder("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", QueryXml)));
	}
	
	@Test
	public void goods(){
		GoodsOrderView goodsOrderView = new GoodsCouponsPriceUtil().getGoodsCouponsPrice("83efebd10d7646eabbd4227688af961e");
		for(Goodsorderdetails goodsorderdetails:goodsOrderView.getOrderGoodsDetails()){
			System.out.println(goodsorderdetails.getCouponPrice());
		}
	}
	
	@Test
	public void LockSeatTestCon(){
		 try {    		
			String url = "http://localhost:"+8080+"/Api/Order/LockSeat";
			 
			LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat seatxml1 = new LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat();
			seatxml1.setSeatCode("115150");
			seatxml1.setPrice(50.00);
			seatxml1.setFee(10.00);
			seatxml1.setAddFee(0.00);
			seatxml1.setCinemaAllowance(0.00);
			List<LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat>  seat = new ArrayList<LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat>();
			seat.add(seatxml1);
			LockSeatQueryXmlOrder order = new LockSeatQueryXmlOrder();
			order.setPayType("0");
			order.setSessionCode("3094007");
			order.setCount(seat.size());
			order.setSeat(seat);
			LockSeatQueryXml xml = new LockSeatQueryXml();
			xml.setCinemaCode("33097601");
			xml.setOrder(order);
			String QueryXml = JaxbXmlUtil.convertToXml(xml); 
			
			 NetSaleQueryJson QueryJson = new NetSaleQueryJson();
			 QueryJson.setUserName("MiniProgram");
			 QueryJson.setPassword("6BF477EBCC446F54E6512AFC0E976C41");
			 QueryJson.setQueryXml(QueryXml);
			 System.out.println(new Gson().toJson(new TestRestTemplate().postForObject(url, QueryJson, String.class)));  
		 }
		 catch (Exception e) {	
			 e.printStackTrace();	
		 }
	}
	
}
