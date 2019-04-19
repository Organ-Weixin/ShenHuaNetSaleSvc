package com.boot.security.server.api.ctms.reply;

import java.util.Date;

import com.boot.security.server.model.CardChargeTypeEnum;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.SessionSeatStatusEnum;
import com.boot.security.server.model.Usercinemaview;

public class DefaultCTMSInterface implements ICTMSInterface {
	
	private static final String CinemaInterfaceMiss = "影院接口获取失败!";

	//查询影院基本信息
	@Override
	public CTMSQueryCinemaReply QueryCinema(Usercinemaview userCinema) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//查询影厅座位信息
	@Override
	public CTMSQuerySeatReply QuerySeat(Usercinemaview userCinema, Screeninfo screen) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//查询影片信息
	@Override
	public CTMSQueryFilmReply QueryFilm(Usercinemaview userCinema, Date StartDate, Date EndDate) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//查询放映计划信息
	@Override
	public CTMSQuerySessionReply QuerySession(Usercinemaview userCinema, Date StartDate, Date EndDate) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//查询放映计划座位状态
	@Override
	public CTMSQuerySessionSeatReply QuerySessionSeat(Usercinemaview userCinema, String SessionCode,
			SessionSeatStatusEnum Status) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//锁定座位
	@Override
	public CTMSLockSeatReply LockSeat(Usercinemaview userCinema, OrderView order) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//解锁座位
	@Override
	public CTMSReleaseSeatReply ReleaseSeat(Usercinemaview userCinema, OrderView order) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//提交订单
	@Override
	public CTMSSubmitOrderReply SubmitOrder(Usercinemaview userCinema, OrderView order) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//查询出票状态
	@Override
	public CTMSQueryPrintReply QueryPrint(Usercinemaview userCinema, OrderView order) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//退票
	@Override
	public CTMSRefundTicketReply RefundTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//查询订单信息
	@Override
	public CTMSQueryOrderReply QueryOrder(Usercinemaview userCinema, OrderView order) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//查询影票信息
	@Override
	public CTMSQueryTicketReply QueryTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//确认出票
	@Override
	public CTMSFetchTicketReply FetchTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//登录会员卡
	@Override
	public CTMSLoginCardReply LoginCard(Usercinemaview userCinema, String CardNo, String CardPassword)
			throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//查询会员卡
	@Override
	public CTMSQueryCardReply QueryCard(Usercinemaview userCinema, String CardNo, String CardPassword)
			throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//查询会员卡折扣
	@Override
	public CTMSQueryDiscountReply QueryDiscount(Usercinemaview userCinema, String TicketCount, String CardNo,
			String CardPassword, String LevelCode, String SessionCode, String SessionTime, String FilmCode,
			String ScreenType, String ListingPrice, String LowestPrice) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//会员卡支付
	@Override
	public CTMSCardPayReply CardPay(Usercinemaview userCinema, String CardNo, String CardPassword, float PayAmount,
			String SessionCode, String FilmCode, String TicketNum) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//会员卡支付撤销
	@Override
	public CTMSCardPayBackReply CardPayBack(Usercinemaview userCinema, String CardNo, String CardPassword,
			String TradeNo, float PayBackAmount) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//查询会员卡交易记录
	@Override
	public CTMSQueryCardTradeRecordReply QueryCardTradeRecord(Usercinemaview userCinema, String CardNo,
			String CardPassword, String StartDate, String EndDate, String PageSize, String PageNum) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//会员卡充值
	@Override
	public CTMSCardChargeReply CardCharge(Usercinemaview userCinema, String CardNo, String CardPassword,
			CardChargeTypeEnum ChargeType, float ChargeAmount) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//查询会员卡等级
	@Override
	public CTMSQueryCardLevelReply QueryCardLevel(Usercinemaview userCinema) throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

	//会员卡注册
	@Override
	public CTMSCardRegisterReply CardRegister(Usercinemaview userCinema, String CardPassword, String LevelCode,
			String InitialAmount, String CardUserName, String MobilePhone, String IDNumber, String Sex)
			throws Exception {
		throw new Exception(CinemaInterfaceMiss);
	}

}
