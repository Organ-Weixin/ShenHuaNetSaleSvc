package com.boot.security.server.api.ctms.reply;

import java.util.Date;

import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.SessionSeatStatusEnum;
import com.boot.security.server.model.Usercinemaview;

public interface ICTMSInterface {
    /// 查询影院基本信息
    CTMSQueryCinemaReply QueryCinema(Usercinemaview userCinema) throws Exception;
    //查询影厅座位信息
    CTMSQuerySeatReply QuerySeat(Usercinemaview userCinema, Screeninfo screen) throws Exception;
    //查询影片信息
    CTMSQueryFilmReply QueryFilm(Usercinemaview userCinema, Date StartDate, Date EndDate) throws Exception;
    //查询放映计划信息
    CTMSQuerySessionReply QuerySession(Usercinemaview userCinema, Date StartDate, Date EndDate) throws Exception;
    //查询放映计划座位状态
    CTMSQuerySessionSeatReply QuerySessionSeat(Usercinemaview userCinema,String SessionCode, SessionSeatStatusEnum Status) throws Exception;
    //锁定座位
    CTMSLockSeatReply LockSeat(Usercinemaview userCinema, OrderView order) throws Exception;
    //解锁座位
    CTMSReleaseSeatReply ReleaseSeat(Usercinemaview userCinema, OrderView order) throws Exception;
    //提交订单
    CTMSSubmitOrderReply SubmitOrder(Usercinemaview userCinema, OrderView order) throws Exception;
    //查询出票状态
    CTMSQueryPrintReply QueryPrint(Usercinemaview userCinema, OrderView order) throws Exception;
    //退票
    CTMSRefundTicketReply RefundTicket(Usercinemaview userCinema, OrderView order) throws Exception;
    //查询订单信息
    CTMSQueryOrderReply QueryOrder(Usercinemaview userCinema, OrderView order) throws Exception;
    //查询影票信息
    CTMSQueryTicketReply QueryTicket(Usercinemaview userCinema, OrderView order) throws Exception;
    //确认出票
    CTMSFetchTicketReply FetchTicket(Usercinemaview userCinema, OrderView order) throws Exception;
}
