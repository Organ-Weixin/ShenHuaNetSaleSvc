package com.boot.security.server.api.ctms.reply;

import java.util.Date;

import com.boot.security.server.model.CardChargeTypeEnum;
import com.boot.security.server.model.GoodsOrderView;
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
    //会员卡登录
    CTMSLoginCardReply LoginCard(Usercinemaview userCinema, String CardNo, String CardPassword) throws Exception;
    //查询会员卡
    CTMSQueryCardReply QueryCard(Usercinemaview userCinema, String CardNo, String CardPassword) throws Exception;
    //查询会员卡折扣
    CTMSQueryDiscountReply QueryDiscount(Usercinemaview userCinema, String TicketCount, String CardNo,String CardPassword, String LevelCode, String SessionCode, String SessionTime, String FilmCode,String ScreenType, String ListingPrice, String LowestPrice) throws Exception;
    //会员卡支付
    CTMSCardPayReply CardPay(Usercinemaview userCinema, String CardNo, String CardPassword, float PayAmount,float GoodsPayAmount, String SessionCode, String FilmCode, String TicketNum) throws Exception;
    //会员卡支付撤销
    CTMSCardPayBackReply CardPayBack(Usercinemaview userCinema, String CardNo, String CardPassword, String TradeNo, float PayBackAmount) throws Exception;
    //会员卡消费记录
    CTMSQueryCardTradeRecordReply QueryCardTradeRecord(Usercinemaview userCinema, String CardNo, String CardPassword, String StartDate, String EndDate, String PageSize, String PageNum) throws Exception;
    //会员卡充值
    CTMSCardChargeReply CardCharge(Usercinemaview userCinema, String CardNo, String CardPassword, CardChargeTypeEnum ChargeType, float ChargeAmount) throws Exception;
    //查询会员卡等级
    CTMSQueryCardLevelReply QueryCardLevel(Usercinemaview userCinema) throws Exception;
    //会员卡注册
    CTMSCardRegisterReply CardRegister(Usercinemaview userCinema, String CardPassword, String LevelCode, String InitialAmount, String CardUserName, String MobilePhone, String IDNumber, String Sex) throws Exception;
    //查询影院卖品
    CTMSQueryGoodsReply QueryGoods(Usercinemaview userCinema) throws Exception;
    //创建卖品订单
    CTMSCreateGoodsOrderReply CreateGoodsOrder(Usercinemaview userCinema,GoodsOrderView order) throws Exception;
    //提交卖品订单
    CTMSSubmitGoodsOrderReply SubmitGoodsOrder(Usercinemaview userCinema,GoodsOrderView order) throws Exception;
    //查询卖品订单
    CTMSQueryGoodsOrderReply QueryGoodsOrder(Usercinemaview userCinema,GoodsOrderView order) throws Exception;
    //退卖品
    CTMSRefundGoodsReply RefundGoods(Usercinemaview userCinema,GoodsOrderView order) throws Exception;
    //混合下单（票+卖品）
    CTMSSubmitMixOrderReply SubmitMixOrder(Usercinemaview userCinema,OrderView order, GoodsOrderView goodsorder) throws Exception;
}
