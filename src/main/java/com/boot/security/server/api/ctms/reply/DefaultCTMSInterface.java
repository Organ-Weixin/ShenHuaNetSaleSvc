package com.boot.security.server.api.ctms.reply;

import java.util.Date;

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

}
