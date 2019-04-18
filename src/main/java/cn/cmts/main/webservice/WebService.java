package cn.cmts.main.webservice;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


import com.boot.security.server.api.ctms.reply.MtxAppPrintTicketResult;
import com.boot.security.server.api.ctms.reply.MtxBackTicketResult;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

import com.boot.security.server.api.ctms.reply.MtxGetCinemaPlanResult;
import com.boot.security.server.api.ctms.reply.MtxGetHallAllSeatResult;
import com.boot.security.server.api.ctms.reply.MtxGetHallResult;
import com.boot.security.server.api.ctms.reply.MtxGetOrderStatusResult;
import com.boot.security.server.api.ctms.reply.MtxGetPlanSiteStateResult;
import com.boot.security.server.api.ctms.reply.MtxLiveRealCheckSeatStateResult;
import com.boot.security.server.api.ctms.reply.MtxRealCheckSeatStateParameter;
import com.boot.security.server.api.ctms.reply.MtxRealCheckSeatStateParameter.MtxRealCheckSeatStateXmlSeatInfos;
import com.boot.security.server.api.ctms.reply.MtxRealCheckSeatStateParameter.MtxRealCheckSeatStateXmlSeatInfos.MtxRealCheckSeatStateXmlSeatInfo;
import com.boot.security.server.api.ctms.reply.MtxSellTicketParameter;
import com.boot.security.server.api.ctms.reply.MtxSellTicketResult;
import com.boot.security.server.api.ctms.reply.MtxUnLockOrderCenCinResult;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.SessionSeatStatusEnum;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.utils.JaxbXmlUtil;
import com.boot.security.server.utils.XmlToJsonUtil;
import com.google.common.base.Joiner;
import com.google.gson.Gson;


/*	
 * @version 1.0 满天星接口
 */
public class WebService {
	// protected static Logger log = LoggerFactory.getLogger(WebService.class);
	private static final String TokenId = "1829";
	private static final String Token = "abcdef";
//	orderView.getOrderBaseInfo().getPayType()
//	private static final String TickenC="1";
	/*	
	 * 满天星接口 初始化接口链接，返回接口集
	 * @return
	*/
	public static TicketapiPortType cinemaTss(String Url) {
		TicketapiLocator css = new TicketapiLocator();
		css.setticketapiHttpSoap11EndpointEndpointAddress(Url);
		Ticketapi cs = css;
		// 接口集
		TicketapiPortType cp;
		try {
			cp = cs.getticketapiHttpSoap11Endpoint();
			return cp;
		} catch (Exception e) {
	 }
		return null;
	}

	/*
	 * GetHall获取影院对应的影厅信息
	 * @param pCinemaCode 影院编码
	 * 	String	检验信息  转小写（MD5（转小写（pAppCode + pCinemaID + pTokenID + token+验证密钥）））
	 * @return
	 */
	public static MtxGetHallResult GetHall(Usercinemaview userCinema) {
		try {
			String pVerifyInfo = GenerateVerifyInfo(userCinema.getDefaultUserName(), userCinema.getCinemaCode(),
					TokenId, Token, userCinema.getDefaultPassword());
			String result = WebService.cinemaTss(userCinema.getUrl()).getHall(userCinema.getDefaultUserName(),
					userCinema.getCinemaCode(), TokenId, pVerifyInfo);
		System.out.println(result);
			Gson gson = new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "GetHallResult"), MtxGetHallResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 *  GetHallAllSeat获取影厅座位信息(包含情侣座)
	 * pCinemaID 电影院编号  pHallID  影厅编号
	 * 	检验信息  转小写（MD5（转小写（pAppCode + pCinemaID + pHallID + 验证密钥）））
	 * */
	public static MtxGetHallAllSeatResult GetHallAllSeat(Usercinemaview userCinema,Screeninfo screen){
			try {
				String pVerifyInfo=GenerateVerifyInfo(userCinema.getDefaultUserName(),userCinema.getCinemaCode(),screen.getSCode(),
						userCinema.getDefaultPassword());
				String result=WebService.cinemaTss(userCinema.getUrl()).getHallAllSeat(userCinema.getDefaultUserName(), userCinema.getCinemaCode(),
					screen.getSCode(),pVerifyInfo);
				System.out.println(result);
				Gson gson=new Gson();
			return gson.fromJson(result, MtxGetHallAllSeatResult.class);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;	
	}
	/*
	 * GetCinemaPlan获取对应影院对应日期的排期  应用编码 +影院编码+  获取排期日期+令牌id  +  token+验证密钥
	 *         检验信息转小写（MD5（转小写（pAppCode + pCinemaID + pPlanDate + pTokenID + token+验证密钥）））
	 */
	public static MtxGetCinemaPlanResult GetCinemaPlan(Usercinemaview userCinema, Date StartDate, Date EndDate){
			try {
				
				String pVerifyInfo=GenerateVerifyInfo(userCinema.getDefaultUserName(),userCinema.getCinemaCode(),
						TokenId,Token,userCinema.getDefaultPassword());
				String result=WebService.cinemaTss(userCinema.getUrl()).getCinemaPlan(userCinema.getDefaultUserName(),
						userCinema.getCinemaCode(),null,TokenId, pVerifyInfo);
				System.out.println(result);
				Gson gson=new Gson();
					return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "GetCinemaPlanResult"), MtxGetCinemaPlanResult.class);
			}catch (Exception e) {
				e.printStackTrace();
			}
		return null;	
	}

	 /*
	  * GetPlanSiteState获取对应排期的座位图的状态
	  * 	检验信息转小写（MD5（转小写（pAppCode+pCinemaID+ pFeatureAppNo+pTokenID+token+验证密钥）））
	  * 	座位状态	(-1不可售  0-未售，1-售出，3-预订，4-选中，6-黄金座位,7-已锁定)
	  */
	public static MtxGetPlanSiteStateResult GetPlanSiteState(Usercinemaview userCinema,String SessionCode, SessionSeatStatusEnum Status){
		try {
			String pVerifyInfo=GenerateVerifyInfo(userCinema.getDefaultUserName(),userCinema.getCinemaCode(),SessionCode,
					TokenId,Token,userCinema.getDefaultPassword());
			String result=WebService.cinemaTss(userCinema.getUrl()).getPlanSiteState(userCinema.getDefaultUserName(),
					userCinema.getCinemaCode(),SessionCode,TokenId, pVerifyInfo);
			System.out.println(result);
			Gson gson=new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "GetPlanSiteState"), MtxGetPlanSiteStateResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/* LiveRealCheckSeatState检查需要定票的座位状态情况，并定票锁定实时座位
	 * 	转小写(MD5(转小写(AppCode+ CinemaId+FeatureAppNo+SerialNum+座位数+PayType+RecvpMobilePhone+TokenID+Token+验证密钥)))
	 */
	public static MtxLiveRealCheckSeatStateResult  LiveRealCheckSeatState(Usercinemaview userCinema,OrderView orderView){
	
		try {
			MtxRealCheckSeatStateParameter param=new MtxRealCheckSeatStateParameter();
			param.setAppCode(userCinema.getDefaultUserName());
			param.setCinemaId (userCinema.getCinemaCode());
			param.setFeatureAppNo(orderView.getOrderBaseInfo().getSessionCode());
			
			Date date = new Date();
		    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		    String str = format.format(date);
//		    Date orderId = null;
		    Random rand = new Random();
		    int x = rand.nextInt(900) + 100;
//		    orderId = format.parse(str);
//			param.setSerialNum(String.valueOf(orderId.getTime()) + x);
		    param.setSerialNum(str+x);
		    orderView.getOrderBaseInfo().setSerialNum(str+x);
			MtxRealCheckSeatStateXmlSeatInfos seatInfoList=new MtxRealCheckSeatStateXmlSeatInfos();
			List<MtxRealCheckSeatStateXmlSeatInfo> seatinfos = new ArrayList<MtxRealCheckSeatStateXmlSeatInfo>();
			for(Orderseatdetails orderseatdetails :orderView.getOrderSeatDetails()){
				MtxRealCheckSeatStateXmlSeatInfo seatinfo = new MtxRealCheckSeatStateXmlSeatInfo();
				seatinfo.setSeatNo(orderseatdetails.getSeatCode());
				seatinfo.setTicketPrice(orderseatdetails.getPrice());
				seatinfo.setHandlingfee(0.0);	//手续费（此处手续费不生效，默认0）
				seatinfos.add(seatinfo);
				
			}
			seatInfoList.setSeatInfo(seatinfos);
			param.setSeatInfos(seatInfoList);
			param.setPayType(orderView.getOrderBaseInfo().getPayType());
			param.setRecvMobilePhone("15700002025");
			param.setTokenID(TokenId);
//			param.setToken(Token);
			
			//转小写（MD5（转小写（AppCode+ CinemaId + PFeatureAppNo+ SerialNum  + 座位数+ PayType+ RecvpMobilePhone+TokenID+Token +验证密钥）））
			String pVerifyInfo = GenerateVerifyInfo(userCinema.getDefaultUserName(),
					userCinema.getCinemaCode(),
					orderView.getOrderBaseInfo().getSessionCode(),
					str + x,
					String.valueOf(orderView.getOrderBaseInfo().getTicketCount()),
					orderView.getOrderBaseInfo().getPayType(),
					"15700002025",
					TokenId,
					Token,
					userCinema.getDefaultPassword());
			param.setVerifyInfo(pVerifyInfo);
			
			/*String pVerifyInfo=GenerateVerifyInfo(userCinema.getDefaultUserName(),userCinema.getCinemaCode(),
				orderView.getOrderBaseInfo().getSessionCode(),orderView.getOrderBaseInfo().getSerialNum(),
				orderView.getOrderBaseInfo().getTicketCount().toString(),orderView.getOrderBaseInfo().getPayType(),
				"15700002025",TokenId,Token,userCinema.getDefaultPassword());*/
			//把请求参数转成xml
			String LockSeatXml=JaxbXmlUtil.convertToXml(param);
			String result=WebService.cinemaTss(userCinema.getUrl()).liveRealCheckSeatState(LockSeatXml);
			System.out.println("锁座返回："+result);
			Gson gson = new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "MtxLiveRealCheckSeatStateResult"),
					MtxLiveRealCheckSeatStateResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	/*
	 *  UnLockOrderCenCin实时解锁座位
	 *  校验信息转小写（MD5（转小写（pAppCode + pCinemaID + pOrderNO +  pTokenID +token+验证密钥）））
	 */

	public static MtxUnLockOrderCenCinResult  UnLockOrderCenCin(Usercinemaview userCinema,OrderView orderView){
		try {
			String pVerifyInfo=GenerateVerifyInfo(userCinema.getDefaultUserName(),userCinema.getCinemaCode(),
					orderView.getOrderBaseInfo().getLockOrderCode(),TokenId,Token,userCinema.getDefaultPassword());
			String result=WebService.cinemaTss(userCinema.getUrl()).unLockOrderCenCin(userCinema.getDefaultUserName(),userCinema.getCinemaCode(),
					orderView.getOrderBaseInfo().getLockOrderCode(),TokenId, pVerifyInfo);
			System.out.println(result);
			Gson gson=new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "UnLockOrderCenCin"), MtxUnLockOrderCenCinResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

/*  SellTicket卖常规票(带座位票)  //提交订单
 AppCode+CinemaId+FeatureAppNo+SerialNum+Printpassword+Balance +PayType+RecvMobilePhone+SendType+ PayResult 
  +IsCmtsPay+IsCmtsSendCode+PayMobile+BookSign+Payed+SendModeID+PaySeqNo+ TokenID+token+验证密钥
  */

	public static MtxSellTicketResult SellTicket(Usercinemaview userCinema,OrderView orderView){
		try {
			MtxSellTicketParameter param=new MtxSellTicketParameter();
			param.setAppCode(userCinema.getDefaultUserName());
			param.setCinemaId(userCinema.getCinemaCode());
			param.setFeatureAppNo(orderView.getOrderBaseInfo().getSessionCode());
//			Date date = new Date();
//	        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//	        String str = format.format(date);
//	        Date orderId = null;
	        Random rand = new Random();
	        int x = rand.nextInt(900) + 100;
//	        orderId = format.parse(str);
	        param.setSerialNum(orderView.getOrderBaseInfo().getSerialNum()); //取锁座流水号
			
	        orderView.getOrderBaseInfo().setPrintpassword(userCinema.getCinemaCode()+x);
			param.setPrintpassword(orderView.getOrderBaseInfo().getPrintpassword());
			param.setBalance(0.0);//默认已全部支付
			param.setPayType(orderView.getOrderBaseInfo().getPayType());//付费类型
			param.setRecvMobilePhone(orderView.getOrderBaseInfo().getMobilePhone());//接收二维码手机号码
			param.setSendType("100");//接收二唯码的方式默认短信
			param.setPayResult("0");//默认已成功支付
			param.setIsCmtsPay(false);//false表示由合作方扣费。
			param.setIsCmtsSendCode(false);//false表示由合作方负责发送二维码。
			param.setPayMobile(orderView.getOrderBaseInfo().getMobilePhone());//支付手机号码
			param.setBookSign("0");//0全额支付1预定金方式
			param.setPayed(orderView.getOrderBaseInfo().getTotalPrice()+orderView.getOrderBaseInfo().getTotalFee());//商城已经支付的金额Payed=总票款+总手续费
			param.setSendModeID("0");//满天星发送二唯码的模板编号.不知道是什么，没这个东西
			param.setPaySeqNo(orderView.getOrderBaseInfo().getIsMemberPay() == 1?orderView.getOrderBaseInfo().getPaySeqNo():"");//影院会员卡支付交易流水号
			param.setTokenID(TokenId);
			
			String pVerifyInfo=GenerateVerifyInfo(userCinema.getDefaultUserName(),userCinema.getCinemaCode(),orderView.getOrderBaseInfo().getSessionCode(),
					orderView.getOrderBaseInfo().getSerialNum(),orderView.getOrderBaseInfo().getPrintpassword(),"0.0",orderView.getOrderBaseInfo().getPayType(),
					orderView.getOrderBaseInfo().getMobilePhone(),"100","0","false","false",orderView.getOrderBaseInfo().getMobilePhone(),
					"0",String.valueOf(orderView.getOrderBaseInfo().getTotalPrice()+orderView.getOrderBaseInfo().getTotalFee()),"0",
					orderView.getOrderBaseInfo().getIsMemberPay() == 1?orderView.getOrderBaseInfo().getPaySeqNo():"",TokenId,Token,userCinema.getDefaultPassword());
			
			param.setVerifyInfo(pVerifyInfo);
			//把请求参数转成xml
			String SellTicketXml=JaxbXmlUtil.convertToXml(param);
			String result=WebService.cinemaTss(userCinema.getUrl()).sellTicket(SellTicketXml);
		
			System.out.println("校验成功--------------");
			Gson gson=new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "SellTicket"), MtxSellTicketResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
 
	/* GetOrderStatus查询定单的售票结果  //查询出票状态=查询订单信息
	 * 转小写（MD5（转小写（pAppCode + pCinemaID + pSerialNum + pTokenID + token+验证密钥）））
	 * */
	public static MtxGetOrderStatusResult GetOrderStatus(Usercinemaview userCinema, OrderView orderView){
		try {
			String pVerifyInfo=GenerateVerifyInfo(userCinema.getDefaultUserName(),userCinema.getCinemaCode(),
					orderView.getOrderBaseInfo().getSerialNum(),TokenId,Token,userCinema.getDefaultPassword());
			String result=WebService.cinemaTss(userCinema.getUrl()).getOrderStatus(userCinema.getDefaultUserName(), userCinema.getCinemaCode(),
					orderView.getOrderBaseInfo().getSerialNum(), TokenId, pVerifyInfo);
			System.out.println(result);
			Gson gson=new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "GetOrderStatus"), MtxGetOrderStatusResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*BackTicket退票
	 * 校验信息转小写（MD5（转小写（pAppCode + pCinemaID + pOrderNO + pTokenID + token +验证密钥）））
	 * */
	public static MtxBackTicketResult BackTicket(Usercinemaview userCinema, OrderView orderView){
		try {
			String pVerifyInfo=GenerateVerifyInfo(userCinema.getDefaultUserName(),userCinema.getCinemaCode(),
					orderView.getOrderBaseInfo().getSubmitOrderCode(),TokenId,Token,userCinema.getDefaultPassword());
			String result=WebService.cinemaTss(userCinema.getUrl()).backTicket(userCinema.getDefaultUserName(),
					userCinema.getCinemaCode(),orderView.getOrderBaseInfo().getSubmitOrderCode(),"正常退票", TokenId, pVerifyInfo);
			System.out.println(result);
			Gson gson=new Gson();
		return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "BackTicket"), MtxBackTicketResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*AppPrintTicket合作商打票--查询影票信息
	 * 转小写（MD5（转小写（pAppCode + pCinemaID + pOrderNO + pValidCode+pRequestType+pTokenID+token+验证密钥）））
	 * */
	public static MtxAppPrintTicketResult AppPrintTicket(Usercinemaview userCinema, OrderView orderView,String requestType){
		try {
			String pVerifyInfo=GenerateVerifyInfo(userCinema.getDefaultUserName(),userCinema.getCinemaCode(),orderView.getOrderBaseInfo().getSubmitOrderCode(),
								orderView.getOrderBaseInfo().getVerifyCode(),requestType,TokenId,Token,userCinema.getDefaultPassword());
			
			String result=WebService.cinemaTss(userCinema.getUrl()).appPrintTicket(userCinema.getDefaultUserName(),userCinema.getCinemaCode(), 
					orderView.getOrderBaseInfo().getSubmitOrderCode(), orderView.getOrderBaseInfo().getVerifyCode(),requestType, TokenId, pVerifyInfo);
			System.out.println(result);
			Gson gson=new Gson();
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "MtxAppPrintTicketResult"), MtxAppPrintTicketResult.class);
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
	/*	票务测试接口地址：http://ticketnew.mvtapi.com:8702/ticketapi/services/ticketapi?wsdl 
			票务测试影院编码：gzxxx
			票务测试应用编码(pAppCode)：TEST
			票务测试验证密钥：12345678
			令牌id默认为1829
			令牌值 默认为abcdef */
		Usercinemaview userCinema = new Usercinemaview();
//		userCinema.setDefaultUserName("TEST");
//		userCinema.setDefaultPassword("12345678");
//		userCinema.setUrl("http://ticketnew.mvtapi.com:8702/ticketapi/services/ticketapi?wsdl");
//		userCinema.setCinemaCode("gzxxx");
	
		//测试查询影厅
	/*	Screeninfo screen = new Screeninfo();
		screen.setCCode("gzxxx");
		screen.setSCode("01");
		Sessioninfo session = new Sessioninfo();
		session.setCCode("gzxxx");
		session.setSCode("gzxxx");
		session.setScreenCode("01");
		session.setTicketFee((double) 0);
		session.setPlaythroughFlag("No");
		session.setDimensional("3D");
		session.setSequence(1);
		session.setSettlePrice((double) 30);
		session.setTicketFee((double) 0);
		session.setAddFee((double) 10);
		session.setFilmCode("051202072018");
		 Screenseatinfo screenseat=new Screenseatinfo();
		 screenseat.setCinemaCode("gzxxx");
		 screenseat.setScreenCode("01");
		 screenseat.setSeatCode("01010101");
		 screenseat.setRowNum("1");
		 screenseat.setColumnNum("1");
		 screenseat.setXCoord(1);
		 screenseat.setYCoord(1);
		 screenseat.setLoveFlag("N");
		 
		MtxGetHallResult result = GetHall(userCinema);
		MtxGetHallAllSeatResult result1=GetHallAllSeat(userCinema, screen);
		String SessionCode=null;
		SessionSeatStatusEnum Status=SessionSeatStatusEnum.Available;
		Date StartDate=new Date();
	MtxGetCinemaPlanResult result3=GetCinemaPlan(userCinema, StartDate, null);*/
		
	/*		MtxGetPlanSiteStateResult result2=GetPlanSiteState(userCinema, SessionCode, Status);*/
	
		OrderView order=new OrderView();
		userCinema.setDefaultUserName("TEST");
		userCinema.setDefaultPassword("12345678");
		userCinema.setUrl("http://ticketnew.mvtapi.com:8702/ticketapi/services/ticketapi?wsdl");
		userCinema.setCinemaCode("gzxxx");
		userCinema.setCinemaId("194");
		Orders orders=new Orders();
		orders.setSessionCode("5137012616");
		List<Orderseatdetails> orderdList=new ArrayList<Orderseatdetails>();
		Orderseatdetails or=new Orderseatdetails();
		or.setSeatCode("01010102");
		or.setSalePrice(50.00);
		or.setFee(10.00);
		orderdList.add(or);
		order.setOrderSeatDetails(orderdList);
		order.setOrderBaseInfo(orders);
		MtxLiveRealCheckSeatStateResult result=LiveRealCheckSeatState(userCinema,order);

	
	}

	
}
