package com.boot.security.server.api.core;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boot.security.server.api.core.CreateGoodsOrderQueryXml.CreateGoodsOrderQueryXmlGoodsList;
import com.boot.security.server.api.core.CreateGoodsOrderQueryXml.CreateGoodsOrderQueryXmlGoodsList.CreateGoodsOrderQueryXmlGoods;
import com.boot.security.server.api.core.CreateGoodsOrderReply.CreateGoodsOrderReplyOrder;
import com.boot.security.server.api.core.LockSeatReply.LockSeatReplyOrder.LockSeatReplySeat;
import com.boot.security.server.api.core.QueryCardLevelReply.QueryCardLevelReplyLevels.QueryCardLevelReplyLevel;
import com.boot.security.server.api.core.QueryCardTradeRecordReply.QueryCardTradeRecordReplyTradeRecord.QueryCardTradeRecordReplyRecord;
import com.boot.security.server.api.core.QueryCinemaListReply.QueryCinemaListReplyCinemas.QueryCinemaListReplyCinema;
import com.boot.security.server.api.core.QueryCinemaReply.QueryCinemaReplyCinema.QueryCinemaReplyScreen;
import com.boot.security.server.api.core.QueryFilmReply.QueryFilmReplyFilms.QueryFilmReplyFilm;
import com.boot.security.server.api.core.QueryGoodsOrderReply.QueryGoodsOrderReplyGoodsList;
import com.boot.security.server.api.core.QueryGoodsOrderReply.QueryGoodsOrderReplyGoodsList.QueryGoodsOrderReplyGoods;
import com.boot.security.server.api.core.QueryGoodsReply.QueryGoodsReplyGoodss;
import com.boot.security.server.api.core.QueryGoodsReply.QueryGoodsReplyGoodss.QueryGoodsReplyGoods;
import com.boot.security.server.api.core.QueryOrderReply.QueryOrderReplyOrder.QueryOrderReplyFilms;
import com.boot.security.server.api.core.QueryOrderReply.QueryOrderReplyOrder.QueryOrderReplyFilms.QueryOrderReplyFilm;
import com.boot.security.server.api.core.QueryOrderReply.QueryOrderReplyOrder.QueryOrderReplySeats;
import com.boot.security.server.api.core.QueryOrderReply.QueryOrderReplyOrder.QueryOrderReplySeats.QueryOrderReplySeat;
import com.boot.security.server.api.core.QuerySeatReply.QuerySeatReplyCinema.QuerySeatReplyScreen.QuerySeatReplySeat;
import com.boot.security.server.api.core.QuerySessionReply.QuerySessionReplySessions.QuerySessionReplySession;
import com.boot.security.server.api.core.QuerySessionSeatReply.QuerySessionSeatReplySessionSeat.QuerySessionSeatReplySeat;
import com.boot.security.server.api.core.QueryTicketReply.QueryTicketReplyTickets;
import com.boot.security.server.api.core.QueryTicketReply.QueryTicketReplyTickets.QueryTicketReplyTicket;
import com.boot.security.server.api.core.RefundGoodsReply.RefundGoodsReplyOrder;
import com.boot.security.server.api.core.ReleaseSeatReply.ReleaseSeatReplyOrder.ReleaseSeatReplySeat;
import com.boot.security.server.api.core.SubmitGoodsOrderQueryXml.SubmitGoodsOrderQueryXmlGoodsList.SubmitGoodsOrderQueryXmlGoods;
import com.boot.security.server.api.core.SubmitGoodsOrderReply.SubmitGoodsOrderReplyOrder;
import com.boot.security.server.api.core.SubmitMixOrderQueryXml.SubmitMixOrderQueryXmlGoods;
import com.boot.security.server.api.core.SubmitMixOrderReply.SubmitGoodsOrder;
import com.boot.security.server.api.core.SubmitMixOrderReply.SubmitTicketsOrder;
import com.boot.security.server.api.core.SubmitMixOrderReply.SubmitTicketsOrder.SubmitOrderSeat;
import com.boot.security.server.api.core.SubmitOrderReply.SubmitOrderReplyOrder.SubmitOrderReplySeat;
import com.boot.security.server.api.ctms.reply.CTMSCardChargeReply;
import com.boot.security.server.api.ctms.reply.CTMSCardPayBackReply;
import com.boot.security.server.api.ctms.reply.CTMSCardPayReply;
import com.boot.security.server.api.ctms.reply.CTMSCardRegisterReply;
import com.boot.security.server.api.ctms.reply.CTMSCreateGoodsOrderReply;
import com.boot.security.server.api.ctms.reply.CTMSFetchTicketReply;
import com.boot.security.server.api.ctms.reply.CTMSInterfaceFactory;
import com.boot.security.server.api.ctms.reply.CTMSLockSeatReply;
import com.boot.security.server.api.ctms.reply.CTMSLoginCardReply;
import com.boot.security.server.api.ctms.reply.CTMSQueryCardLevelReply;
import com.boot.security.server.api.ctms.reply.CTMSQueryCardReply;
import com.boot.security.server.api.ctms.reply.CTMSQueryCardTradeRecordReply;
import com.boot.security.server.api.ctms.reply.CTMSQueryCinemaReply;
import com.boot.security.server.api.ctms.reply.CTMSQueryDiscountReply;
import com.boot.security.server.api.ctms.reply.CTMSQueryFilmReply;
import com.boot.security.server.api.ctms.reply.CTMSQueryGoodsOrderReply;
import com.boot.security.server.api.ctms.reply.CTMSQueryGoodsReply;
import com.boot.security.server.api.ctms.reply.CTMSQueryOrderReply;
import com.boot.security.server.api.ctms.reply.CTMSQueryPrintReply;
import com.boot.security.server.api.ctms.reply.CTMSQuerySeatReply;
import com.boot.security.server.api.ctms.reply.CTMSQuerySessionReply;
import com.boot.security.server.api.ctms.reply.CTMSQuerySessionSeatReply;
import com.boot.security.server.api.ctms.reply.CTMSQueryTicketReply;
import com.boot.security.server.api.ctms.reply.CTMSRefundGoodsReply;
import com.boot.security.server.api.ctms.reply.CTMSRefundTicketReply;
import com.boot.security.server.api.ctms.reply.CTMSReleaseSeatReply;
import com.boot.security.server.api.ctms.reply.CTMSSubmitGoodsOrderReply;
import com.boot.security.server.api.ctms.reply.CTMSSubmitMixOrderReply;
import com.boot.security.server.api.ctms.reply.CTMSSubmitOrderReply;
import com.boot.security.server.api.ctms.reply.ICTMSInterface;
import com.boot.security.server.model.CardChargeTypeEnum;
import com.boot.security.server.model.CardTradeRecord;
import com.boot.security.server.model.CinemaTypeEnum;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Goods;
import com.boot.security.server.model.GoodsOrderStatusEnum;
import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodsorderdetails;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.model.Membercardlevel;
import com.boot.security.server.model.OrderPayTypeEnum;
import com.boot.security.server.model.OrderStatusEnum;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.SessionSeat;
import com.boot.security.server.model.SessionSeatStatusEnum;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.StatusEnum;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.GoodsOrderServiceImpl;
import com.boot.security.server.service.impl.GoodsServiceImpl;
import com.boot.security.server.service.impl.MemberCardLevelServiceImpl;
import com.boot.security.server.service.impl.MemberCardServiceImpl;
import com.boot.security.server.service.impl.OrderServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.ScreenseatinfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.service.impl.UserCinemaViewServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.boot.security.server.utils.JaxbXmlUtil;
import com.boot.security.server.utils.SpringUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class NetSaleSvcCore { 
	 private ICTMSInterface _CTMSInterface;
	 UserInfoServiceImpl _userInfoService = SpringUtil.getBean(UserInfoServiceImpl.class);
	 ScreeninfoServiceImpl _screenInfoService = SpringUtil.getBean(ScreeninfoServiceImpl.class);
	 UserCinemaViewServiceImpl _userCinemaViewService = SpringUtil.getBean(UserCinemaViewServiceImpl.class);
	 ScreenseatinfoServiceImpl _seatInfoService = SpringUtil.getBean(ScreenseatinfoServiceImpl.class);
	 SessioninfoServiceImpl _sessionInfoService = SpringUtil.getBean(SessioninfoServiceImpl.class);
	 OrderServiceImpl _orderService = SpringUtil.getBean(OrderServiceImpl.class);
	 MemberCardServiceImpl _membercardService=SpringUtil.getBean(MemberCardServiceImpl.class);
	 MemberCardLevelServiceImpl _memberCardLevelService=SpringUtil.getBean(MemberCardLevelServiceImpl.class);
	 GoodsServiceImpl _goodsService=SpringUtil.getBean(GoodsServiceImpl.class);
	 GoodsOrderServiceImpl _goodsOrderService=SpringUtil.getBean(GoodsOrderServiceImpl.class);
	 protected static Logger log = LoggerFactory.getLogger(NetSaleSvcCore.class);
	 
	 public NetSaleSvcCore(){
		 
	 }

	private static volatile NetSaleSvcCore _instance;

	public static NetSaleSvcCore getInstance() {
		if (_instance != null) {
			return _instance;
		} else {
			_instance = new NetSaleSvcCore();
		}
		return _instance;
	}
	
	// region 查询可访问的影院列表(完成)
	public QueryCinemaListReply QueryCinemaList(String Username, String Password) {
		QueryCinemaListReply queryCinemaListReply = new QueryCinemaListReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(queryCinemaListReply, Username, Password)) {
			return queryCinemaListReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			queryCinemaListReply.SetUserCredentialInvalidReply();
			return queryCinemaListReply;
		}
		return QueryCinemaList(queryCinemaListReply, UserInfo);
	}

	private QueryCinemaListReply QueryCinemaList(QueryCinemaListReply reply, Userinfo UserInfo) {
		List<Usercinemaview> cinemaList = _userCinemaViewService.GetUserCinemaViewsByUserId(UserInfo.getId());

		reply.setCinemas(reply.new QueryCinemaListReplyCinemas());// 实例化内部类
		if (cinemaList == null || cinemaList.size() == 0) {
			reply.getCinemas().setCinemaCount(0);
		} else {
			reply.getCinemas().setCinemaCount(cinemaList.size());
			reply.getCinemas().setCinema(new ArrayList<QueryCinemaListReplyCinema>());
			for (Usercinemaview cinema : cinemaList) {
				QueryCinemaListReplyCinema replycinema = reply.getCinemas().new QueryCinemaListReplyCinema();
				ModelMapper.MapFrom(replycinema, cinema);
				reply.getCinemas().getCinema().add(replycinema);
			}
		}
		reply.SetSuccessReply();
		return reply;
	}
	// endregion

	// region 查询影院信息(完成)
	public QueryCinemaReply QueryCinema(String Username, String Password, String CinemaCode) {
		QueryCinemaReply queryCinemaReply = new QueryCinemaReply();
		if (!ReplyExtension.RequestInfoGuard(queryCinemaReply, Username, Password, CinemaCode)) {
			return queryCinemaReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			queryCinemaReply.SetUserCredentialInvalidReply();
			return queryCinemaReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),
				CinemaCode);
		if (userCinema == null) {
			queryCinemaReply.SetCinemaInvalidReply();
			return queryCinemaReply;
		}
		return QueryCinema(queryCinemaReply, userCinema);
	}

	private QueryCinemaReply QueryCinema(QueryCinemaReply reply, Usercinemaview userCinema) {
		_CTMSInterface = CTMSInterfaceFactory.Create(userCinema);

		// 从影院票务管理系统更新影院基本信息
		CTMSQueryCinemaReply CTMSReply = null;
		try {
			CTMSReply = _CTMSInterface.QueryCinema(userCinema);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (StatusEnum.Success.equals(CTMSReply.Status)) {
			log.info("===================");
			// 获取影院影厅列表
			reply.setCinema(reply.new QueryCinemaReplyCinema());
			reply.getCinema().setCode(userCinema.getCinemaCode());
			reply.getCinema().setName(userCinema.getCinemaName());
			reply.getCinema().setAddress(userCinema.getCinemaAddress());

			List<Screeninfo> ScreenList = _screenInfoService.getByCinemaCode(userCinema.getCinemaCode());
			if (ScreenList == null || ScreenList.size() == 0) {
				reply.getCinema().setScreenCount(0);
			} else {
				reply.getCinema().setScreenCount(ScreenList.size());
				reply.getCinema().setScreen(new ArrayList<QueryCinemaReplyScreen>());
				for (Screeninfo screen : ScreenList) {
					QueryCinemaReplyScreen replyscreen = reply.getCinema().new QueryCinemaReplyScreen();
					ModelMapper.MapFrom(replyscreen, screen);
					reply.getCinema().getScreen().add(replyscreen);
				}
			}
			reply.SetSuccessReply();
		} else {
			reply.GetErrorFromCTMSReply(CTMSReply);
		}
		return reply;
	}
	// endregion

	// region 查询影厅座位信息(完成)
	public QuerySeatReply QuerySeat(String Username, String Password, String CinemaCode, String ScreenCode) {
		QuerySeatReply querySeatReply = new QuerySeatReply();
		if (!ReplyExtension.RequestInfoGuard(querySeatReply, Username, Password, CinemaCode, ScreenCode)) {
			return querySeatReply;
		}

		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			querySeatReply.SetUserCredentialInvalidReply();
			return querySeatReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),
				CinemaCode);
		if (userCinema == null) {
			querySeatReply.SetCinemaInvalidReply();
			return querySeatReply;
		}
		// 验证影厅是否存在
		Screeninfo screenInfo = _screenInfoService.getByScreenCode(CinemaCode, ScreenCode);
		if (screenInfo == null) {
			querySeatReply.SetScreenInvalidReply();
			return querySeatReply;
		}
		return QuerySeat(querySeatReply, userCinema, screenInfo);
	}

	private QuerySeatReply QuerySeat(QuerySeatReply reply, Usercinemaview userCinema, Screeninfo screen) {
		_CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
		// 从影院票务管理系统更新影厅座位信息
		CTMSQuerySeatReply CTMSReply = null;
		try {
			CTMSReply = _CTMSInterface.QuerySeat(userCinema, screen);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (StatusEnum.Success.equals(CTMSReply.Status)) {
			// 获取影厅座位列表
			reply.setCinema(reply.new QuerySeatReplyCinema());
			reply.getCinema().setCode(userCinema.getCinemaCode());;
			reply.getCinema().setScreen(reply.getCinema().new QuerySeatReplyScreen());
			reply.getCinema().getScreen().setCode(screen.getSCode());

			List<Screenseatinfo> seatList = _seatInfoService.getByCinemaCodeAndScreenCode(userCinema.getCinemaCode(),
					screen.getSCode());

			if (seatList != null && seatList.size() > 0) {
				reply.getCinema().getScreen().setSeat(new ArrayList<QuerySeatReplySeat>());
				for (Screenseatinfo seat : seatList) {
					QuerySeatReplySeat replyseat = reply.getCinema().getScreen().new QuerySeatReplySeat();
					ModelMapper.MapFrom(replyseat, seat);
					reply.getCinema().getScreen().getSeat().add(replyseat);
				}
			}
			reply.SetSuccessReply();
		} else {
			reply.GetErrorFromCTMSReply(CTMSReply);
		}
		return reply;
	}
	// endregion

	// region 查询影片信息(完成)
	public QueryFilmReply QueryFilm(String Username, String Password, String CinemaCode, String StartDate,
			String EndDate) throws ParseException {
		QueryFilmReply queryFilmReply = new QueryFilmReply();
		if (!ReplyExtension.RequestInfoGuard(queryFilmReply, Username, Password, CinemaCode, StartDate, EndDate)) {
			return queryFilmReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			queryFilmReply.SetUserCredentialInvalidReply();
			return queryFilmReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),
				CinemaCode);
		if (userCinema == null) {
			queryFilmReply.SetCinemaInvalidReply();
			return queryFilmReply;
		}
		// 验证日期是否正确
		Date Start = new Date();
		Date End = new Date();
		if(StartDate!=null){
			Start = new SimpleDateFormat("yyyy-MM-dd").parse(StartDate);
		}else{
			queryFilmReply.SetStartDateInvalidReply();
			return queryFilmReply;
		}
		if(EndDate!=null){
			End = new SimpleDateFormat("yyyy-MM-dd").parse(EndDate);
		}else{
			queryFilmReply.SetEndDateInvalidReply();
			return queryFilmReply;
		}
		if(Start.getTime() > End.getTime()){
			queryFilmReply.SetDateInvalidReply();
			return queryFilmReply;
		}

		return QueryFilm(queryFilmReply, userCinema, Start, End);
	}

	private QueryFilmReply QueryFilm(QueryFilmReply reply, Usercinemaview userCinema, Date StartDate, Date EndDate) {
		_CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
		// 从影院票务管理系统更新影厅座位信息
		CTMSQueryFilmReply CTMSReply = null;
		try {
			CTMSReply = _CTMSInterface.QueryFilm(userCinema, StartDate, EndDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (StatusEnum.Success.equals(CTMSReply.Status)) {
			List<Filminfo> FilmEntities = CTMSReply.getFilms();
			reply.setFilms(reply.new QueryFilmReplyFilms());
			reply.getFilms().setFilm(new ArrayList<QueryFilmReplyFilm>());
			reply.getFilms().setCount(FilmEntities.size());
			for (Filminfo film : FilmEntities) {
				QueryFilmReplyFilm replyfilm = reply.getFilms().new QueryFilmReplyFilm();
				ModelMapper.MapFrom(replyfilm, film);
				reply.getFilms().getFilm().add(replyfilm);
			}
			reply.SetSuccessReply();
		} else {
			reply.GetErrorFromCTMSReply(CTMSReply);
		}

		return reply;
	}
	// endregion

	// region 查询放映计划(完成)
	public QuerySessionReply QuerySession(String Username, String Password, String CinemaCode, String StartDate,
			String EndDate) throws ParseException {
		QuerySessionReply querySessionReply = new QuerySessionReply();
		if (!ReplyExtension.RequestInfoGuard(querySessionReply, Username, Password, CinemaCode, StartDate, EndDate)) {
			return querySessionReply;
		}

		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			querySessionReply.SetUserCredentialInvalidReply();
			return querySessionReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),
				CinemaCode);
		if (userCinema == null) {
			querySessionReply.SetCinemaInvalidReply();
			return querySessionReply;
		}
		// 验证日期是否正确
		Date Start = new Date();
		Date End = new Date();
		if(StartDate!=null){
			Start = new SimpleDateFormat("yyyy-MM-dd").parse(StartDate);
		}else{
			querySessionReply.SetStartDateInvalidReply();
			return querySessionReply;
		}
		if(EndDate!=null){
			End = new SimpleDateFormat("yyyy-MM-dd").parse(EndDate);
		}else{
			querySessionReply.SetEndDateInvalidReply();
			return querySessionReply;
		}
		if(Start.getTime() > End.getTime()){
			querySessionReply.SetDateInvalidReply();
			return querySessionReply;
		}
		/*Date Start = new SimpleDateFormat("yyyy-MM-dd").parse(StartDate);
		Date End = new SimpleDateFormat("yyyy-MM-dd").parse(EndDate);
		if (Start == null) {
			querySessionReply.SetStartDateInvalidReply();
			return querySessionReply;
		}
		if (End == null) {
			querySessionReply.SetEndDateInvalidReply();
			return querySessionReply;
		}
		if (Start.getTime() > End.getTime()) {
			querySessionReply.SetDateInvalidReply();
			return querySessionReply;
		}*/

		return QuerySession(querySessionReply, userCinema, Start, End);
	}

	private QuerySessionReply QuerySession(QuerySessionReply reply, Usercinemaview userCinema, Date StartDate,
			Date EndDate) {
		_CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
		CTMSQuerySessionReply CTMSReply = null;
		try {
			CTMSReply = _CTMSInterface.QuerySession(userCinema, StartDate, EndDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (StatusEnum.Success.equals(CTMSReply.Status)) {
			List<Sessioninfo> sessionList = _sessionInfoService.getByCinemaCodeAndDate(userCinema.getUserId(),
					userCinema.getCinemaCode(), StartDate, EndDate);

			reply.setSessions(reply.new QuerySessionReplySessions());
			reply.getSessions().setCinemaCode(userCinema.getCinemaCode());;
			if (sessionList != null && sessionList.size() > 0) {
				reply.getSessions().setSession(new ArrayList<QuerySessionReplySession>());
				for (Sessioninfo session : sessionList) {
					QuerySessionReplySession replysession = reply.getSessions().new QuerySessionReplySession();
					ModelMapper.MapFrom(replysession, session);
					reply.getSessions().getSession().add(replysession);
				}
			}
			reply.SetSuccessReply();
		} else {
			reply.GetErrorFromCTMSReply(CTMSReply);
		}
		return reply;
	}
	// endregion

	// region 查询放映计划座位售出状态(完成)
	public QuerySessionSeatReply QuerySessionSeat(String Username, String Password, String CinemaCode,
			String SessionCode, String Status) {
		QuerySessionSeatReply querySessionSeatReply = new QuerySessionSeatReply();
		if (!ReplyExtension.RequestInfoGuard(querySessionSeatReply, Username, Password, CinemaCode, SessionCode,
				Status)) {
			return querySessionSeatReply;
		}

		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			querySessionSeatReply.SetUserCredentialInvalidReply();
			return querySessionSeatReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),
				CinemaCode);
		if (userCinema == null) {
			querySessionSeatReply.SetCinemaInvalidReply();
			return querySessionSeatReply;
		}
		// 验证排期是否存在
		Sessioninfo sessionInfo = _sessionInfoService.getBySessionCode(UserInfo.getId(), CinemaCode, SessionCode);
		if (sessionInfo == null) {
			querySessionSeatReply.SetSessionInvalidReply();
			return querySessionSeatReply;
		}
		// 验证座位售出状态
		SessionSeatStatusEnum StatusEnum = SessionSeatStatusEnum.valueOf(Status);
		if (SessionSeatStatusEnum.Illegal.equals(StatusEnum)) {
			querySessionSeatReply.SetSessionSeatStatusInvalidReply();
			return querySessionSeatReply;
		}

		return QuerySessionSeat(querySessionSeatReply, userCinema, SessionCode, StatusEnum);
	}

	private QuerySessionSeatReply QuerySessionSeat(QuerySessionSeatReply reply, Usercinemaview userCinema,
			String SessionCode, SessionSeatStatusEnum Status) {
		_CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
		CTMSQuerySessionSeatReply CTMSReply = null;
		try {
			CTMSReply = _CTMSInterface.QuerySessionSeat(userCinema, SessionCode, Status);
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (StatusEnum.Success.equals(CTMSReply.Status)) {
			reply.setSessionSeat(reply.new QuerySessionSeatReplySessionSeat());
			reply.getSessionSeat().setCinemaCode(userCinema.getCinemaCode());
			reply.getSessionSeat().setSessionCode(SessionCode);
			 reply.getSessionSeat().setSeat(new ArrayList<QuerySessionSeatReplySeat>());
			for (SessionSeat seat : CTMSReply.getSessionSeats()) {
				QuerySessionSeatReplySeat replyseat = reply.getSessionSeat().new QuerySessionSeatReplySeat();
				replyseat.setCode(seat.getSeatCode());
				replyseat.setRowNum(seat.getRowNum());
				replyseat.setColumnNum(seat.getColumnNum());
				replyseat.setStatus(seat.getStatus().getStatusCode());
				reply.getSessionSeat().getSeat().add(replyseat);
			}
			reply.SetSuccessReply();
		} else {
			reply.GetErrorFromCTMSReply(CTMSReply);
		}
		return reply;
	}
	// endregion

	// region 锁座(完成)
	public LockSeatReply LockSeat(String Username, String Password, String QueryXml)
			throws JsonSyntaxException, Exception {
		LockSeatReply lockSeatReply = new LockSeatReply();

		if (!ReplyExtension.RequestInfoGuard(lockSeatReply, Username, Password, QueryXml)) {
			return lockSeatReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			lockSeatReply.SetUserCredentialInvalidReply();
			return lockSeatReply;
		}
		// 验证锁座参数
		LockSeatQueryXml QueryXmlObj=JaxbXmlUtil.convertToJavaBean(QueryXml, LockSeatQueryXml.class);
		if (QueryXmlObj.getOrder() == null || QueryXmlObj.getOrder().getSeat() == null) {
			lockSeatReply.SetXmlDeserializeFailReply(QueryXml);
			return lockSeatReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),
				QueryXmlObj.getCinemaCode());
		if (userCinema == null) {
			lockSeatReply.SetCinemaInvalidReply();
			return lockSeatReply;
		}
		// 验证排期是否存在
		Sessioninfo sessionInfo = _sessionInfoService.getBySessionCode(UserInfo.getId(), QueryXmlObj.getCinemaCode(),
				QueryXmlObj.getOrder().getSessionCode());
		if (sessionInfo == null) {
			lockSeatReply.SetSessionInvalidReply();
			return lockSeatReply;
		}
		// 验证座位数量
		if (QueryXmlObj.getOrder().getCount() != QueryXmlObj.getOrder().getSeat().size()) {
			lockSeatReply.SetSeatCountInvalidReply();
			return lockSeatReply;
		}
		// 将请求参数转为订单
		OrderView order = new OrderView();
		order = ModelMapper.MapFrom(order, userCinema, QueryXmlObj, sessionInfo);
		// 得到当前提交的seatcode
		List<String> seatcodeslist = order.getOrderSeatDetails().stream().map(Orderseatdetails::getSeatCode)
				.collect(Collectors.toList());
		String seatcodes = String.join(",", seatcodeslist);
		log.info("====="+seatcodes);
		//List<Screenseatinfo> seatInfos = _seatInfoService.getBySeatCodes(userCinema.getCinemaCode(),sessionInfo.getScreenCode(), seatcodes);
		//log.info(seatInfos.toString());
		for (Orderseatdetails seat : order.getOrderSeatDetails()) {
			//List<Screenseatinfo> seatinfo = seatInfos.stream().filter((Screenseatinfo s) -> seat.getSeatCode().equals(s.getSeatCode())).collect(Collectors.toList());
			Screenseatinfo seatinfo=_seatInfoService.getBySeatCode(userCinema.getCinemaCode(),sessionInfo.getScreenCode(),seat.getSeatCode());
			if (seatinfo != null) {
				seat.setRowNum(seatinfo.getRowNum());
				seat.setColumnNum(seatinfo.getColumnNum());
				// 因为vista这个奇葩要用到坐标来锁座，所以把坐标也保存到订单座位
				seat.setXCoord(seatinfo.getXCoord());
				seat.setYCoord(seatinfo.getYCoord());
			}
		}
		return LockSeat(lockSeatReply, userCinema, order);
	}

	private LockSeatReply LockSeat(LockSeatReply reply, Usercinemaview userCinema, OrderView order) {
		_CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
		CTMSLockSeatReply CTMSReply = null;
		try {
			CTMSReply = _CTMSInterface.LockSeat(userCinema, order);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (StatusEnum.Success.equals(CTMSReply.Status)) {
			reply.setOrder(reply.new LockSeatReplyOrder());
			reply.getOrder().setOrderCode(order.getOrderBaseInfo().getLockOrderCode());
			if(order.getOrderBaseInfo().getAutoUnlockDatetime()!=null){
				reply.getOrder().setAutoUnlockDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(order.getOrderBaseInfo().getAutoUnlockDatetime()));
			}
			reply.getOrder().setSessionCode(order.getOrderBaseInfo().getSessionCode());
			reply.getOrder().setCount(order.getOrderBaseInfo().getTicketCount());
			List<LockSeatReplySeat> replySeats = new ArrayList<LockSeatReplySeat>();
			for (Orderseatdetails seat : order.getOrderSeatDetails()) {
				LockSeatReplySeat replyseat = reply.getOrder().new LockSeatReplySeat();
				replyseat.setSeatCode(seat.getSeatCode());
				replySeats.add(replyseat);
			}
			reply.getOrder().setSeat(replySeats);
			reply.SetSuccessReply();
		} else {
			reply.GetErrorFromCTMSReply(CTMSReply);
		}
		// 将订单保存到数据库
		_orderService.Insert(order);
		return reply;
	}
	// endregion

	// region 解锁座位（完成）
	public ReleaseSeatReply ReleaseSeat(String Username, String Password, String QueryXml)
			throws JsonSyntaxException, Exception {
		ReleaseSeatReply releaseSeatReply = new ReleaseSeatReply();

		if (!ReplyExtension.RequestInfoGuard(releaseSeatReply, Username, Password, QueryXml)) {
			return releaseSeatReply;
		}

		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			releaseSeatReply.SetUserCredentialInvalidReply();
			return releaseSeatReply;
		}
		// 验证锁座参数
		ReleaseSeatQueryXml QueryXmlObj=JaxbXmlUtil.convertToJavaBean(QueryXml, ReleaseSeatQueryXml.class);
		if (QueryXmlObj.getOrder() == null || QueryXmlObj.getOrder().getSeat() == null) {
			releaseSeatReply.SetXmlDeserializeFailReply(QueryXml);
			return releaseSeatReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),
				QueryXmlObj.getCinemaCode());
		if (userCinema == null) {
			releaseSeatReply.SetCinemaInvalidReply();
			return releaseSeatReply;
		}
		// 验证座位数量
		if (QueryXmlObj.getOrder().getCount() != QueryXmlObj.getOrder().getSeat().size()) {
			releaseSeatReply.SetSeatCountInvalidReply();
			return releaseSeatReply;
		}
		// 验证订单是否存在
		OrderView order = null;
		if (!QueryXmlObj.getOrder().getOrderCode().isEmpty()) {
			order = _orderService.getOrderWidthLockOrderCode(QueryXmlObj.getCinemaCode(), QueryXmlObj.getOrder().getOrderCode());
		}
		if (order == null || (order.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.Locked.getStatusCode()
				&& order.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.SubmitFail.getStatusCode()
				&& order.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.ReleaseFail.getStatusCode())) {
			releaseSeatReply.SetOrderNotExistReply();
			return releaseSeatReply;
		}

		return ReleaseSeat(releaseSeatReply, userCinema, order);
	}

	private ReleaseSeatReply ReleaseSeat(ReleaseSeatReply reply, Usercinemaview userCinema, OrderView order) {
		_CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
		CTMSReleaseSeatReply CTMSReply = null;
		try {
			CTMSReply = _CTMSInterface.ReleaseSeat(userCinema, order);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (StatusEnum.Success.equals(CTMSReply.Status)) {
			reply.setOrder(reply.new ReleaseSeatReplyOrder());
			reply.getOrder().setOrderCode(order.getOrderBaseInfo().getLockOrderCode());
			reply.getOrder().setSessionCode(order.getOrderBaseInfo().getSessionCode());
			reply.getOrder().setCount(order.getOrderBaseInfo().getTicketCount());
			List<ReleaseSeatReplySeat> replySeats = new ArrayList<ReleaseSeatReplySeat>();
			for (Orderseatdetails seat : order.getOrderSeatDetails()) {
				ReleaseSeatReplySeat replyseat = reply.getOrder().new ReleaseSeatReplySeat();
				replyseat.setSeatCode(seat.getSeatCode());
				replySeats.add(replyseat);
			}
			reply.getOrder().setSeat(replySeats);
			reply.SetSuccessReply();
		} else {
			reply.GetErrorFromCTMSReply(CTMSReply);
		}
		// 只更新订单信息，不更新订单座位信息
		order.getOrderBaseInfo().setUpdated(new Date());//添加更新时间
		_orderService.UpdateOrderBaseInfo(order.getOrderBaseInfo());
		return reply;
	}
	// endregion

	// region 提交订单(完成)
	public SubmitOrderReply SubmitOrder(String Username, String Password, String QueryXml)
			throws JsonSyntaxException, Exception {
		SubmitOrderReply submitOrderReply = new SubmitOrderReply();

		if (!ReplyExtension.RequestInfoGuard(submitOrderReply, Username, Password, QueryXml)) {
			return submitOrderReply;
		}

		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			submitOrderReply.SetUserCredentialInvalidReply();
			return submitOrderReply;
		}
		// 验证锁座参数
		SubmitOrderQueryXml QueryXmlObj=JaxbXmlUtil.convertToJavaBean(QueryXml, SubmitOrderQueryXml.class);
		if (QueryXmlObj.getOrder() == null || QueryXmlObj.getOrder().getSeat() == null) {
			submitOrderReply.SetXmlDeserializeFailReply(QueryXml);
			return submitOrderReply;
		}
		// 验证是否传递手机号
		if (QueryXmlObj.getOrder().getMobilePhone().isEmpty()) {
			submitOrderReply.SetNecessaryParamMissReply("MobilePhone");
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),
				QueryXmlObj.getCinemaCode());
		if (userCinema == null) {
			submitOrderReply.SetCinemaInvalidReply();
			return submitOrderReply;
		}
		// 验证订单是否存在
		OrderView order = null;
		if (!QueryXmlObj.getOrder().getOrderCode().isEmpty()) {
			order = _orderService.getOrderWidthLockOrderCode(QueryXmlObj.getCinemaCode(), QueryXmlObj.getOrder().getOrderCode());
		}
		if (order == null || (order.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.Locked.getStatusCode()
				&& order.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.SubmitFail.getStatusCode()
				&& order.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.Payed.getStatusCode())) {
			submitOrderReply.SetOrderNotExistReply();
			return submitOrderReply;
		}
		// 验证座位数量
		if (QueryXmlObj.getOrder().getCount() != QueryXmlObj.getOrder().getSeat().size()
				|| QueryXmlObj.getOrder().getCount() != order.getOrderBaseInfo().getTicketCount()) {
			submitOrderReply.SetSeatCountInvalidReply();
			return submitOrderReply;
		}

		// 更新订单信息
		order = ModelMapper.MapFrom(order, QueryXmlObj);

		// TODO:满天星的订单属于会员卡支付的话暂时要求传入会员卡交易流水号
		if (userCinema.getCinemaType() == CinemaTypeEnum.ManTianXing.getTypeCode()
				&& order.getOrderBaseInfo().getIsMemberPay() == 1 && order.getOrderBaseInfo().getPaySeqNo().isEmpty()) {
			submitOrderReply.SetMemberPaySeqNoNotExistReply();
			return submitOrderReply;
		}

		return SubmitOrder(submitOrderReply, userCinema, order);
	}

	private SubmitOrderReply SubmitOrder(SubmitOrderReply reply, Usercinemaview userCinema, OrderView order) {
		try {
			_CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
			CTMSSubmitOrderReply CTMSReply = null;
			CTMSReply = _CTMSInterface.SubmitOrder(userCinema, order);

			if (StatusEnum.Success.equals(CTMSReply.Status)) {
				reply.setOrder(reply.new SubmitOrderReplyOrder());
				reply.getOrder().setCinemaType(userCinema.getCinemaType());
				reply.getOrder().setOrderCode(order.getOrderBaseInfo().getSubmitOrderCode());
				reply.getOrder().setSessionCode(order.getOrderBaseInfo().getSessionCode());
				reply.getOrder().setCount(order.getOrderBaseInfo().getTicketCount());
				reply.getOrder().setPrintNo(order.getOrderBaseInfo().getPrintNo());
				reply.getOrder().setVerifyCode(order.getOrderBaseInfo().getVerifyCode());

				List<SubmitOrderReplySeat> replySeats = new ArrayList<SubmitOrderReplySeat>();
				for (Orderseatdetails seat : order.getOrderSeatDetails()) {
					SubmitOrderReplySeat replyseat = reply.getOrder().new SubmitOrderReplySeat();
					replyseat.setSeatCode(seat.getSeatCode());
					replyseat.setFilmTicketCode(seat.getFilmTicketCode());
					replySeats.add(replyseat);
				}
				reply.getOrder().setSeat(replySeats);
				reply.SetSuccessReply();
			} else {
				reply.GetErrorFromCTMSReply(CTMSReply);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 更新订单信息
			order.getOrderBaseInfo().setUpdated(new Date());//添加更新时间
			_orderService.Update(order);
		}

		return reply;
	}
	// endregion

	// region 查询出票状态(完成)
	public QueryPrintReply QueryPrint(String Username, String Password, String CinemaCode, String PrintNo,
			String VerifyCode) {
		QueryPrintReply queryPrintReply = new QueryPrintReply();

		if (!ReplyExtension.RequestInfoGuard(queryPrintReply, Username, Password, CinemaCode, PrintNo, VerifyCode)) {
			return queryPrintReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			queryPrintReply.SetUserCredentialInvalidReply();
			return queryPrintReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),
				CinemaCode);
		if (userCinema == null) {
			queryPrintReply.SetCinemaInvalidReply();
			return queryPrintReply;
		}
		// 验证订单是否存在
		OrderView order = _orderService.getOrderWidthPrintNo(CinemaCode, PrintNo, VerifyCode);
		if (order == null) {
			queryPrintReply.SetOrderNotExistReply();
			return queryPrintReply;
		}

		return QueryPrint(queryPrintReply, userCinema, order);
	}

	private QueryPrintReply QueryPrint(QueryPrintReply reply, Usercinemaview userCinema, OrderView order) {
		_CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
		CTMSQueryPrintReply CTMSReply = null;
		try {
			CTMSReply = _CTMSInterface.QueryPrint(userCinema, order);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (StatusEnum.Success.equals(CTMSReply.Status)) {
			reply.setOrder(reply.new QueryPrintReplyOrder());
			reply.getOrder().setOrderCode(order.getOrderBaseInfo().getSubmitOrderCode());
			reply.getOrder().setPrintNo(order.getOrderBaseInfo().getPrintNo());
			reply.getOrder().setVerifyCode(order.getOrderBaseInfo().getVerifyCode());
			reply.getOrder().setStatus(order.getOrderBaseInfo().getPrintStatus() == 1?"Yes":"No");
			reply.getOrder().setPrintTime(order.getOrderBaseInfo().getPrintTime() == null ? ""
					: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderBaseInfo().getPrintTime()));
			reply.SetSuccessReply();
		} else {
			reply.GetErrorFromCTMSReply(CTMSReply);
		}

		// 更新订单信息
		order.getOrderBaseInfo().setUpdated(new Date());//添加更新时间
		_orderService.UpdateOrderBaseInfo(order.getOrderBaseInfo());
		return reply;
	}
	// endregion

	// region 退票（完成）
	public RefundTicketReply RefundTicket(String Username, String Password, String CinemaCode, String PrintNo,
			String VerifyCode) {
		RefundTicketReply refundTicketReply = new RefundTicketReply();

		if (!ReplyExtension.RequestInfoGuard(refundTicketReply, Username, Password, CinemaCode, PrintNo, VerifyCode)) {
			return refundTicketReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			refundTicketReply.SetUserCredentialInvalidReply();
			return refundTicketReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),
				CinemaCode);
		if (userCinema == null) {
			refundTicketReply.SetCinemaInvalidReply();
			return refundTicketReply;
		}
		// 验证订单是否存在
		OrderView order = _orderService.getOrderWidthPrintNo(CinemaCode, PrintNo, VerifyCode);
		if (order == null || order.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.Complete.getStatusCode()) {
			refundTicketReply.SetOrderNotExistReply();
			return refundTicketReply;
		}

		return RefundTicket(refundTicketReply, userCinema, order);
	}

	private RefundTicketReply RefundTicket(RefundTicketReply reply, Usercinemaview userCinema, OrderView order) {
		try {
			_CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
			CTMSRefundTicketReply CTMSReply = null;
			CTMSReply = _CTMSInterface.RefundTicket(userCinema, order);

			if (StatusEnum.Success.equals(CTMSReply.Status)) {
				reply.setOrder(reply.new RefundTicketReplyOrder());
				reply.getOrder().setOrderCode(order.getOrderBaseInfo().getSubmitOrderCode());
				reply.getOrder().setPrintNo(order.getOrderBaseInfo().getPrintNo());
				reply.getOrder().setVerifyCode(order.getOrderBaseInfo().getVerifyCode());
				reply.getOrder().setStatus(order.getOrderBaseInfo().getOrderStatus() == 9? "Yes" : "No");
				reply.getOrder().setRefundTime(reply.getOrder().getStatus() == "Yes"
						? order.getOrderBaseInfo().getRefundTime() == null ? ""
								: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
										.format(order.getOrderBaseInfo().getRefundTime())
						: "");
				reply.SetSuccessReply();
			} else {
				reply.GetErrorFromCTMSReply(CTMSReply);
			}
		} catch (Exception ex) {

		} finally {
			// 更新订单信息
			order.getOrderBaseInfo().setUpdated(new Date());//添加更新时间
			_orderService.UpdateOrderBaseInfo(order.getOrderBaseInfo());
		}
		return reply;
	}
	// endregion

	// region 查询订单信息（完成）
	public QueryOrderReply QueryOrder(String Username, String Password, String CinemaCode, String OrderCode) {
		QueryOrderReply queryOrderReply = new QueryOrderReply();
		if (!ReplyExtension.RequestInfoGuard(queryOrderReply, Username, Password, CinemaCode, OrderCode)) {
			return queryOrderReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			queryOrderReply.SetUserCredentialInvalidReply();
			return queryOrderReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),
				CinemaCode);
		if (userCinema == null) {
			queryOrderReply.SetCinemaInvalidReply();
			return queryOrderReply;
		}
		// 验证订单是否存在
		OrderView order = _orderService.getOrderWidthOrderCode(CinemaCode, OrderCode);
		if (order == null) {
			queryOrderReply.SetOrderNotExistReply();
			return queryOrderReply;
		}
		return QueryOrder(queryOrderReply, userCinema, order);
	}

	private QueryOrderReply QueryOrder(QueryOrderReply reply, Usercinemaview userCinema, OrderView order) {
		_CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
		CTMSQueryOrderReply CTMSReply = null;
		try {
			CTMSReply = _CTMSInterface.QueryOrder(userCinema, order);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (StatusEnum.Success.equals(CTMSReply.Status)) {
			reply.setOrder(reply.new QueryOrderReplyOrder());
			reply.getOrder().setOrderCode(order.getOrderBaseInfo().getSubmitOrderCode());
			reply.getOrder().setCinemaCode(userCinema.getCinemaCode());
			reply.getOrder().setCinemaType(userCinema.getCinemaType().toString());
			reply.getOrder().setCinemaName(userCinema.getCinemaName());
			Screeninfo screenInfo = _screenInfoService.getByScreenCode(userCinema.getCinemaCode(),
					order.getOrderBaseInfo().getScreenCode());
			reply.getOrder().setScreenCode(order.getOrderBaseInfo().getScreenCode());
			reply.getOrder().setScreenName(screenInfo == null ? ""
					: screenInfo.getSName() == null ? "" : screenInfo.getSName());
			Sessioninfo sessionInfo = _sessionInfoService.getBySessionCode(userCinema.getUserId(),
					userCinema.getCinemaCode(), order.getOrderBaseInfo().getSessionCode());
			reply.getOrder().setSessionCode(order.getOrderBaseInfo().getSessionCode());
			reply.getOrder().setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(order.getOrderBaseInfo().getSessionTime()));
			reply.getOrder().setPlaythroughFlag(sessionInfo == null ? "No"
					: sessionInfo.getPlaythroughFlag() == null ? "No" : sessionInfo.getPlaythroughFlag());
			reply.getOrder().setPrintNo(order.getOrderBaseInfo().getPrintNo());
			reply.getOrder().setVerifyCode(order.getOrderBaseInfo().getVerifyCode());

			QueryOrderReplyFilms films = reply.getOrder().new QueryOrderReplyFilms();
			List<QueryOrderReplyFilm> filmlist = new ArrayList<QueryOrderReplyFilm>();

			QueryOrderReplyFilm film = films.new QueryOrderReplyFilm();
			film.setCode(order.getOrderBaseInfo().getFilmCode());
			film.setName(order.getOrderBaseInfo().getFilmName());
			film.setDuration(sessionInfo == null ? "0"
					: sessionInfo.getDuration() == null ? "0" : sessionInfo.getDuration().toString());
			film.setSequence(sessionInfo == null ? "1"
					: sessionInfo.getSequence() == null ? "1" : sessionInfo.getSequence().toString());

			filmlist.add(film);
			films.setFilm(filmlist);
			reply.getOrder().setFilms(films);

			QueryOrderReplySeats seats = reply.getOrder().new QueryOrderReplySeats();
			List<QueryOrderReplySeat> seatlist = new ArrayList<QueryOrderReplySeat>();
			for (Orderseatdetails orderseat : order.getOrderSeatDetails()) {
				QueryOrderReplySeat replyseat = seats.new QueryOrderReplySeat();
				replyseat.setSeatCode(orderseat.getSeatCode());
				replyseat.setRowNum(orderseat.getRowNum());
				replyseat.setColumnNum(orderseat.getColumnNum());
				replyseat.setFilmTicketCode(orderseat.getFilmTicketCode());
				replyseat.setPrintStatus(order.getOrderBaseInfo().getPrintStatus()==1?"Yes":"No");
				replyseat.setPrintTime(order.getOrderBaseInfo().getPrintTime() == null ? ""
						: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderBaseInfo().getPrintTime()));
				replyseat.setRefundStatus(order.getOrderBaseInfo().getOrderStatus()==9? "Yes" : "No");
				replyseat.setRefundTime(order.getOrderBaseInfo().getRefundTime() == null ? ""
						: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderBaseInfo().getRefundTime()));
				seatlist.add(replyseat);
			}
			seats.setSeat(seatlist);
			reply.getOrder().setSeats(seats);
			reply.SetSuccessReply();
		} else {
			reply.GetErrorFromCTMSReply(CTMSReply);
		}

		// 更新订单信息
		order.getOrderBaseInfo().setUpdated(new Date());//添加更新时间
		_orderService.Update(order);
		return reply;
	}
	// endregion
	
	//region 查询影票信息(完成)
	public QueryTicketReply QueryTicket(String Username, String Password, String CinemaCode,
            String PrintNo, String VerifyCode)
        {
            QueryTicketReply queryTicketReply = new QueryTicketReply();
            if (!ReplyExtension.RequestInfoGuard(queryTicketReply,Username, Password, CinemaCode, PrintNo, VerifyCode))
            {
                return queryTicketReply;
            }
            //获取用户信息
            Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
            if (UserInfo == null)
            {
                queryTicketReply.SetUserCredentialInvalidReply();
                return queryTicketReply;
            }
            //验证影院是否存在且可访问
            Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(), CinemaCode);
            if (userCinema == null)
            {
                queryTicketReply.SetCinemaInvalidReply();
                return queryTicketReply;
            }
            //验证订单是否存在
            OrderView order = _orderService.getOrderWidthPrintNo(CinemaCode, PrintNo, VerifyCode);
            if (order == null)
            {
                queryTicketReply.SetOrderNotExistReply();
                return queryTicketReply;
            }

            return QueryTicket(queryTicketReply, userCinema, order);
        }
	private QueryTicketReply QueryTicket(QueryTicketReply reply, Usercinemaview userCinema, OrderView order)
    {
        _CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
        CTMSQueryTicketReply CTMSReply=null;
        try {
			CTMSReply = _CTMSInterface.QueryTicket(userCinema, order);
		} catch (Exception e) {
			e.printStackTrace();
		}

        if (StatusEnum.Success.equals(CTMSReply.Status))
        {
            Screeninfo screenInfo = _screenInfoService.getByScreenCode(userCinema.getCinemaCode(), order.getOrderBaseInfo().getScreenCode());
            QueryTicketReplyTickets tickets=reply.new QueryTicketReplyTickets();
            List<QueryTicketReplyTicket> ticketlist=new ArrayList<QueryTicketReplyTicket>();
            for(Orderseatdetails orderseat:order.getOrderSeatDetails()){
            	QueryTicketReplyTicket ticket=tickets.new QueryTicketReplyTicket();
            	ticket.setPrintNo(order.getOrderBaseInfo().getPrintNo());
            	ticket.setTicketInfoCode(orderseat.getTicketInfoCode());
            	ticket.setCinemaCode(userCinema.getCinemaCode());
            	ticket.setCinemaName(userCinema.getCinemaName());
            	ticket.setScreenCode(order.getOrderBaseInfo().getScreenCode());
            	ticket.setScreenName(screenInfo.getSName());
            	ticket.setFilmCode(order.getOrderBaseInfo().getFilmCode());
            	ticket.setFilmName(order.getOrderBaseInfo().getFilmName());
            	ticket.setSessionCode(order.getOrderBaseInfo().getSessionCode());
            	ticket.setSessionDateTime(order.getOrderBaseInfo().getSessionTime()==null?"":new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderBaseInfo().getSessionTime()));
            	ticket.setTicketCode(orderseat.getFilmTicketCode());
            	ticket.setSeatCode(orderseat.getSeatCode());
            	ticket.setSeatName(orderseat.getRowNum()+"排"+orderseat.getColumnNum()+"座");
            	ticket.setPrice(new DecimalFormat("#.00").format(orderseat.getPrice()));
            	ticket.setService(new DecimalFormat("#.00").format(orderseat.getFee()));
            	ticket.setPrintFlag(orderseat.getPrintFlag()==null?"0":String.valueOf(orderseat.getPrintFlag()));
            	ticketlist.add(ticket);
            }
            tickets.setCount(ticketlist.size());
            tickets.setTicket(ticketlist);
            reply.setTickets(tickets);
            reply.SetSuccessReply();
        }
        else
        {
            reply.GetErrorFromCTMSReply(CTMSReply);
        }

        //更新订单信息
        order.getOrderBaseInfo().setUpdated(new Date());//添加更新时间
        _orderService.Update(order);

        return reply;
    }
	//endregion
	
	//region 确认出票(完成)
	public FetchTicketReply FetchTicket(String Username, String Password, String CinemaCode,
            String PrintNo, String VerifyCode)
        {
            FetchTicketReply fetchTicketReply = new FetchTicketReply();

            if (!ReplyExtension.RequestInfoGuard(fetchTicketReply,Username, Password, CinemaCode, PrintNo, VerifyCode))
            {
                return fetchTicketReply;
            }
            //获取用户信息
            Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
            if (UserInfo == null)
            {
                fetchTicketReply.SetUserCredentialInvalidReply();
                return fetchTicketReply;
            }
            //验证影院是否存在且可访问
            Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(), CinemaCode);
            if (userCinema == null)
            {
                fetchTicketReply.SetCinemaInvalidReply();
                return fetchTicketReply;
            }
            //验证订单是否存在
            OrderView order = _orderService.getOrderWidthPrintNo(CinemaCode, PrintNo, VerifyCode);
            if (order == null)
            {
                fetchTicketReply.SetOrderNotExistReply();
                return fetchTicketReply;
            }

            return FetchTicket(fetchTicketReply, userCinema, order);
        }
	private FetchTicketReply FetchTicket(FetchTicketReply reply, Usercinemaview userCinema, OrderView order)
    {
        _CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
        CTMSFetchTicketReply CTMSReply=null;
        try {
			CTMSReply = _CTMSInterface.FetchTicket(userCinema, order);
		} catch (Exception e) {
			e.printStackTrace();
		}

        if (StatusEnum.Success.equals(CTMSReply.Status))
        {
            reply.SetSuccessReply();
        }
        else
        {
            reply.GetErrorFromCTMSReply(CTMSReply);
        }

        //更新订单信息
        order.getOrderBaseInfo().setUpdated(new Date());//添加更新时间
        _orderService.UpdateOrderBaseInfo(order.getOrderBaseInfo());
        return reply;
    }
	//endregion
	
	//region 登录会员卡(完成)
	public LoginCardReply LoginCard(String Username, String Password, String CinemaCode, String CardNo, String CardPassword)
    {
        LoginCardReply loginCardReply = new LoginCardReply();
        if (!ReplyExtension.RequestInfoGuard(loginCardReply,Username, Password, CinemaCode, CardNo, CardPassword))
        {
            return loginCardReply;
        }
        //获取用户信息
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
            loginCardReply.SetUserCredentialInvalidReply();
            return loginCardReply;
        }
        //验证影院是否存在且可访问
        Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
        if (userCinema == null)
        {
            loginCardReply.SetCinemaInvalidReply();
            return loginCardReply;
        }
        return LoginCard(loginCardReply, userCinema, CardNo, CardPassword);
    }
	private LoginCardReply LoginCard(LoginCardReply reply, Usercinemaview userCinema, String CardNo, String CardPassword)
    {
        _CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
        CTMSLoginCardReply CTMSReply=null;
        try {
			CTMSReply = _CTMSInterface.LoginCard(userCinema, CardNo, CardPassword);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        if (CTMSReply.Status == StatusEnum.Success)
        {
            Membercard membercard = _membercardService.getByCardNo(userCinema.getCinemaCode(), CardNo);

            reply.setCinemaCode(userCinema.getCinemaCode());
            reply.setCard(reply.new LoginCardReplyCard());
            if (membercard != null)
            {
                reply.getCard().setCardNo(membercard.getCardNo());
                reply.getCard().setCardPassword(membercard.getCardPassword());
                reply.getCard().setMobilePhone(membercard.getMobilePhone());
                reply.getCard().setLevelCode(membercard.getLevelCode());
                reply.getCard().setLevelName(membercard.getLevelName());
            }
            reply.SetSuccessReply();
        }
        else
        {
            reply.GetErrorFromCTMSReply(CTMSReply);
        }
        return reply;
    }
	//endregion
	
	//region 查询会员卡(完成)
	public QueryCardReply QueryCard(String Username, String Password, String CinemaCode, String CardNo, String CardPassword)
    {
        QueryCardReply queryCardReply = new QueryCardReply();
        if (!ReplyExtension.RequestInfoGuard(queryCardReply,Username, Password, CinemaCode, CardNo, CardPassword))
        {
            return queryCardReply;
        }
        //获取用户信息
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
            queryCardReply.SetUserCredentialInvalidReply();
            return queryCardReply;
        }
        //验证影院是否存在且可访问
        Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(), CinemaCode);
        if (userCinema == null)
        {
            queryCardReply.SetCinemaInvalidReply();
            return queryCardReply;
        }
        return QueryCard(queryCardReply, userCinema, CardNo, CardPassword);
    }
	private QueryCardReply QueryCard(QueryCardReply reply, Usercinemaview userCinema, String CardNo, String CardPassword)
    {
        _CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
        CTMSQueryCardReply CTMSReply=null;
        try {
			CTMSReply = _CTMSInterface.QueryCard(userCinema, CardNo, CardPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
        if (CTMSReply.Status == StatusEnum.Success)
        {
            Membercard membercard = _membercardService.getByCardNo(userCinema.getCinemaCode(), CardNo);

            reply.setCinemaCode(userCinema.getCinemaCode());
            reply.setCard(reply.new QueryCardReplyCard());
            if (membercard != null)
            {
                reply.getCard().setCardNo(membercard.getCardNo());
                reply.getCard().setCardPassword(membercard.getCardPassword());
                reply.getCard().setMobilePhone(membercard.getMobilePhone());
                reply.getCard().setLevelCode(membercard.getLevelCode());
                reply.getCard().setLevelName(membercard.getLevelName());
                if(membercard.getScore()==null||membercard.getScore().equals("0")){
                	membercard.setScore(0);
                }
                reply.getCard().setScore(String.valueOf(membercard.getScore()));
                reply.getCard().setBalance(new DecimalFormat("#0.00").format(membercard.getBalance()));
                reply.getCard().setUserName(membercard.getUserName());
                reply.getCard().setSex(membercard.getSex());
                reply.getCard().setCreditNum(membercard.getCreditNum());
                if(membercard.getBirthday()!=null){
                	reply.getCard().setBirthday(new SimpleDateFormat("yyyy-MM-dd").format(membercard.getBirthday()));
                }
            }
            reply.SetSuccessReply();
        }
        else
        {
            reply.GetErrorFromCTMSReply(CTMSReply);
        }
        return reply;
    }
	//endregion
	
	//region 得到会员卡折扣（完成）
	public QueryDiscountReply QueryDiscount(String Username, String Password,String CinemaCode, String TicketCount, String CardNo,
			String CardPassword, String LevelCode, String SessionCode, String SessionTime, String FilmCode,
			String ScreenType, String ListingPrice, String LowestPrice)
    {
        QueryDiscountReply queryDiscountReply = new QueryDiscountReply();
        if (!ReplyExtension.RequestInfoGuard(queryDiscountReply,Username,Password,CinemaCode,TicketCount,CardNo,CardPassword,LevelCode,SessionCode,SessionTime,FilmCode,
ScreenType,ListingPrice,LowestPrice))
        {
            return queryDiscountReply;
        }
        //获取用户信息
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
            queryDiscountReply.SetUserCredentialInvalidReply();
            return queryDiscountReply;
        }
        //验证影院是否存在且可访问
        Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
        if (userCinema == null)
        {
            queryDiscountReply.SetCinemaInvalidReply();
            return queryDiscountReply;
        }
        //验证会员卡是否存在
        Membercard memberCard = _membercardService.getByCardNo(CinemaCode,CardNo);
        if (memberCard == null)
        {
            queryDiscountReply.SetMemberCardInvalidReply();
            return queryDiscountReply;
        }
        //验证排期是否存在
        Sessioninfo sessionInfo = _sessionInfoService.getByCinemaCodeAndSessionCodeAndUserId(CinemaCode, SessionCode, UserInfo.getId());
        if (sessionInfo == null)
        {
            queryDiscountReply.SetSessionInvalidReply();
            return queryDiscountReply;
        }
        return QueryDiscount(queryDiscountReply,userCinema,TicketCount,CardNo,CardPassword,LevelCode,SessionCode,SessionTime,FilmCode,ScreenType,ListingPrice,LowestPrice);
    }
	private QueryDiscountReply QueryDiscount(QueryDiscountReply reply, Usercinemaview userCinema,String TicketCount, String CardNo,
			String CardPassword, String LevelCode, String SessionCode, String SessionTime, String FilmCode,
			String ScreenType, String ListingPrice, String LowestPrice)
    {
        _CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
        CTMSQueryDiscountReply CTMSReply=null;
        try {
			CTMSReply = _CTMSInterface.QueryDiscount(userCinema,TicketCount,CardNo,CardPassword,LevelCode,SessionCode,SessionTime,FilmCode,ScreenType,ListingPrice,LowestPrice);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (CTMSReply.Status == StatusEnum.Success)
        {
            reply.setCinemaCode(userCinema.getCinemaCode());
            reply.setCard(reply.new QueryDiscountReplyCard());
            reply.getCard().setDiscountType(String.valueOf(CTMSReply.getDiscountType()));
            reply.getCard().setPrice(CTMSReply.getPrice());
            reply.getCard().setCinemaPayAmount(CTMSReply.getCinemaPayAmount());
            reply.SetSuccessReply();
        }
        else
        {
            reply.GetErrorFromCTMSReply(CTMSReply);
        }
        return reply;
    }
	//endregion
	
	//region 会员卡支付（完成）
	public CardPayReply CardPay(String Username, String Password,String CinemaCode, String CardNo, String CardPassword, String PayAmount, String SessionCode, String FilmCode, String TicketNum)
    {
        CardPayReply cardPayReply = new CardPayReply();
        if (!ReplyExtension.RequestInfoGuard(cardPayReply,Username, Password,CinemaCode,CardNo,CardPassword,PayAmount,SessionCode,FilmCode,TicketNum))
        {
            return cardPayReply;
        }
        //获取用户信息
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
            cardPayReply.SetUserCredentialInvalidReply();
            return cardPayReply;
        }
        
        //验证影院是否存在且可访问
        Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
        if (userCinema == null)
        {
            cardPayReply.SetCinemaInvalidReply();
            return cardPayReply;
        }
        //验证会员卡是否已存在
        Membercard memberCard = _membercardService.getByCardNo(CinemaCode,CardNo);
        if (memberCard == null)
        {
            cardPayReply.SetMemberCardInvalidReply();
            return cardPayReply;
        }
        //验证排期是否存在
        Sessioninfo session = _sessionInfoService.getByCinemaCodeAndSessionCodeAndUserId(CinemaCode, SessionCode,userCinema.getUserId());
        if (session == null)
        {
            cardPayReply.SetSessionInvalidReply();
            return cardPayReply;
        }
        return CardPay(cardPayReply, userCinema, CardNo,CardPassword,PayAmount,SessionCode,FilmCode,TicketNum);
    }
	private CardPayReply CardPay(CardPayReply reply, Usercinemaview userCinema, String CardNo, String CardPassword, String PayAmount, String SessionCode, String FilmCode, String TicketNum)
    {
        _CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
        CTMSCardPayReply CTMSReply=null;
        try {
			CTMSReply = _CTMSInterface.CardPay(userCinema, CardNo,CardPassword,Float.parseFloat(PayAmount),SessionCode,FilmCode,TicketNum);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (CTMSReply.Status == StatusEnum.Success)
        {
            reply.setTradeNo(CTMSReply.getTradeNo());
            reply.setDeductAmount(CTMSReply.getDeductAmount());
            reply.SetSuccessReply();
        }
        else
        {
            reply.GetErrorFromCTMSReply(CTMSReply);
        }
        return reply;
    }
	//endregion
	
	//region 会员卡支付撤销(完成)
	public CardPayBackReply CardPayBack(String Username, String Password, String CinemaCode, String CardNo, String CardPassword, String TradeNo, String PayBackAmount)
    {
        CardPayBackReply cardPayBackReply = new CardPayBackReply();
        if (!ReplyExtension.RequestInfoGuard(cardPayBackReply,Username, Password, CinemaCode, CardNo, CardPassword, TradeNo, PayBackAmount))
        {
            return cardPayBackReply;
        }
        //获取用户信息
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
            cardPayBackReply.SetUserCredentialInvalidReply();
            return cardPayBackReply;
        }
        //验证影院是否存在且可访问
        Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
        if (userCinema == null)
        {
            cardPayBackReply.SetCinemaInvalidReply();
            return cardPayBackReply;
        }
        //验证会员卡是否已存在
        Membercard memberCard = _membercardService.getByCardNo(CinemaCode, CardNo);
        if (memberCard == null)
        {
            cardPayBackReply.SetMemberCardInvalidReply();
            return cardPayBackReply;
        }
        return CardPayBack(cardPayBackReply, userCinema, CardNo, CardPassword, TradeNo, PayBackAmount);
    }
	private CardPayBackReply CardPayBack(CardPayBackReply reply, Usercinemaview userCinema, String CardNo, String CardPassword, String TradeNo, String PayBackAmount)
    {
        _CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
        CTMSCardPayBackReply CTMSReply=null;
        try {
			CTMSReply = _CTMSInterface.CardPayBack(userCinema, CardNo, CardPassword, TradeNo,Float.parseFloat(PayBackAmount));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (CTMSReply.Status == StatusEnum.Success)
        {
            reply.setTradeNo(CTMSReply.getTradeNo());
            reply.SetSuccessReply();
        }
        else
        {
            reply.GetErrorFromCTMSReply(CTMSReply);
        }
        return reply;
    }
	//endregion
	
	//region 查询会员卡交易记录(完成)
	public QueryCardTradeRecordReply QueryCardTradeRecord(String Username, String Password, String CinemaCode, String CardNo, String CardPassword, String StartDate, String EndDate, String PageSize, String PageNum) throws ParseException
    {
        QueryCardTradeRecordReply queryCardTradeRecordReply = new QueryCardTradeRecordReply();
        if (!ReplyExtension.RequestInfoGuard(queryCardTradeRecordReply,Username, Password, CinemaCode, CardNo, CardPassword, StartDate, EndDate, PageSize, PageNum))
        {
            return queryCardTradeRecordReply;
        }
        //获取用户信息
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
            queryCardTradeRecordReply.SetUserCredentialInvalidReply();
            return queryCardTradeRecordReply;
        }
        //验证影院是否存在且可访问
        Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
        if (userCinema == null)
        {
            queryCardTradeRecordReply.SetCinemaInvalidReply();
            return queryCardTradeRecordReply;
        }
        //验证会员卡是否已存在
        Membercard memberCard = _membercardService.getByCardNo(CinemaCode, CardNo);
        if (memberCard == null)
        {
            queryCardTradeRecordReply.SetMemberCardInvalidReply();
            return queryCardTradeRecordReply;
        }
        //验证日期是否正确
        Date Start = new SimpleDateFormat("yyyy-MM-dd").parse(StartDate);
		Date End = new SimpleDateFormat("yyyy-MM-dd").parse(EndDate);
        if (Start == null)
        {
            queryCardTradeRecordReply.SetStartDateInvalidReply();
            return queryCardTradeRecordReply;
        }
        if (End==null)
        {
            queryCardTradeRecordReply.SetEndDateInvalidReply();
            return queryCardTradeRecordReply;
        }
        if (Start.getTime() > End.getTime())
        {
            queryCardTradeRecordReply.SetDateInvalidReply();
            return queryCardTradeRecordReply;
        }
        return QueryCardTradeRecord(queryCardTradeRecordReply, userCinema, CardNo, CardPassword, Start, End, PageSize, PageNum);
    }
	private QueryCardTradeRecordReply QueryCardTradeRecord(QueryCardTradeRecordReply reply, Usercinemaview userCinema, String CardNo, String CardPassword, Date StartDate, Date EndDate, String PageSize, String PageNum)
    {
        _CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
        CTMSQueryCardTradeRecordReply CTMSReply=null;
        try {
			CTMSReply = _CTMSInterface.QueryCardTradeRecord(userCinema, CardNo, CardPassword,new SimpleDateFormat("yyyy-MM-dd").format(StartDate), new SimpleDateFormat("yyyy-MM-dd").format(EndDate), PageSize, PageNum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (CTMSReply.Status == StatusEnum.Success)
        {
            reply.setTradeRecord(reply.new QueryCardTradeRecordReplyTradeRecord());
            reply.getTradeRecord().setCinemaCode(userCinema.getCinemaCode());
            reply.getTradeRecord().setCardNo(CardNo);
            List<QueryCardTradeRecordReplyRecord> records=new ArrayList<QueryCardTradeRecordReplyRecord>();
            for(CardTradeRecord traderecord:CTMSReply.getCardTradeRecords()){
            	QueryCardTradeRecordReplyRecord record=reply.getTradeRecord().new QueryCardTradeRecordReplyRecord();
            	record.setTradeNo(traderecord.getTradeNo());
            	record.setTradeType(traderecord.getTradeType());
            	record.setTradeTime(traderecord.getTradeTime());
            	record.setTradePrice(traderecord.getTradePrice());
            	record.setCinemaName(traderecord.getCinemaName());
            	records.add(record);
            }
            reply.getTradeRecord().setRecord(records);
            reply.SetSuccessReply();
        }
        else
        {
            reply.GetErrorFromCTMSReply(CTMSReply);
        }
        return reply;
    }
	//endregion
	
	//region 会员卡充值(完成)
	public CardChargeReply CardCharge(String Username, String Password, String CinemaCode, String CardNo, String CardPassword, String ChargeType, String ChargeAmount)
    {
        CardChargeReply cardChargeReply = new CardChargeReply();
        if (!ReplyExtension.RequestInfoGuard(cardChargeReply,Username, Password, CinemaCode, CardNo, CardPassword, ChargeType, ChargeAmount))
        {
            return cardChargeReply;
        }
        //获取用户信息
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
            cardChargeReply.SetUserCredentialInvalidReply();
            return cardChargeReply;
        }
        //验证影院是否存在且可访问
        Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
        if (userCinema == null)
        {
            cardChargeReply.SetCinemaInvalidReply();
            return cardChargeReply;
        }
        //验证会员卡是否已存在
        Membercard memberCard = _membercardService.getByCardNo(CinemaCode, CardNo);
        if (memberCard == null)
        {
            cardChargeReply.SetMemberCardInvalidReply();
            return cardChargeReply;
        }
        //验证充值类型
        CardChargeTypeEnum chargeType= CardChargeTypeEnum.valueOf(ChargeType);
        if (chargeType.getTypeCode() == CardChargeTypeEnum.Illegal.getTypeCode())
        {
            cardChargeReply.SetCardChargeTypeInvalidReply();
            return cardChargeReply;
        }
        return CardCharge(cardChargeReply, userCinema, CardNo, CardPassword, chargeType, Float.parseFloat(ChargeAmount));
    }
	private CardChargeReply CardCharge(CardChargeReply reply, Usercinemaview userCinema, String CardNo, String CardPassword, CardChargeTypeEnum ChargeType, float ChargeAmount)
    {
        _CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
        CTMSCardChargeReply CTMSReply=null;
        try {
			CTMSReply = _CTMSInterface.CardCharge(userCinema, CardNo, CardPassword, ChargeType, ChargeAmount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (CTMSReply.Status == StatusEnum.Success)
        {
            reply.SetSuccessReply();
        }
        else
        {
            reply.GetErrorFromCTMSReply(CTMSReply);
        }
        return reply;
    }
	//endregion
	
	//region 会员卡等级（完成）
	public QueryCardLevelReply QueryCardLevel(String Username, String Password, String CinemaCode)
    {
        QueryCardLevelReply queryCardLevelReply = new QueryCardLevelReply();
        if (!ReplyExtension.RequestInfoGuard(queryCardLevelReply,Username, Password, CinemaCode))
        {
            return queryCardLevelReply;
        }
        //获取用户信息
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
            queryCardLevelReply.SetUserCredentialInvalidReply();
            return queryCardLevelReply;
        }
        //验证影院是否存在且可访问
        Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
        if (userCinema == null)
        {
            queryCardLevelReply.SetCinemaInvalidReply();
            return queryCardLevelReply;
        }
        return QueryCardLevel(queryCardLevelReply, userCinema);
    }
	private QueryCardLevelReply QueryCardLevel(QueryCardLevelReply reply, Usercinemaview userCinema)
    {
        _CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
        CTMSQueryCardLevelReply CTMSReply=null;
        try {
			CTMSReply = _CTMSInterface.QueryCardLevel(userCinema);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (CTMSReply.Status == StatusEnum.Success)
        {
            List<Membercardlevel> cardLevels = _memberCardLevelService.getByCinemaCode(userCinema.getCinemaCode());

            reply.setCinemaCode(userCinema.getCinemaCode());
            reply.setLevels(reply.new QueryCardLevelReplyLevels());
            if (cardLevels != null && cardLevels.size() > 0)
            {
            	List<QueryCardLevelReplyLevel> levels=new ArrayList<QueryCardLevelReplyLevel>();
            	for(Membercardlevel cardlevel:cardLevels){
            		QueryCardLevelReplyLevel level=reply.getLevels().new QueryCardLevelReplyLevel();
            		level.setLevelCode(cardlevel.getLevelCode());
            		level.setLevelName(cardlevel.getLevelName());
            		levels.add(level);
            	}
                reply.getLevels().setLevel(levels);
            }
            reply.SetSuccessReply();
        }
        else
        {
            reply.GetErrorFromCTMSReply(CTMSReply);
        }
        return reply;
    }
	//endregion
	
	//region 会员卡注册（完成）
	public CardRegisterReply CardRegister(String Username, String Password, String CinemaCode, String CardPassword, String LevelCode, String InitialAmount, String CardUserName, String MobilePhone, String IDNumber, String Sex)
    {
        CardRegisterReply cardRegisterReply = new CardRegisterReply();
        if (!ReplyExtension.RequestInfoGuard(cardRegisterReply,Username, Password, CinemaCode, CardPassword, LevelCode, InitialAmount, CardUserName, MobilePhone, IDNumber, Sex))
        {
            return cardRegisterReply;
        }
        //获取用户信息
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
            cardRegisterReply.SetUserCredentialInvalidReply();
            return cardRegisterReply;
        }
        //验证影院是否存在且可访问
        Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
        if (userCinema == null)
        {
            cardRegisterReply.SetCinemaInvalidReply();
            return cardRegisterReply;
        }
        //验证会员卡等级是否存在
        //Membercard cardlevel = _membercardService.getByCardNo(CinemaCode, LevelCode);
        Membercardlevel cardlevel =  _memberCardLevelService.getByCinemaCodeAndLevelCode(CinemaCode, LevelCode);
        if (cardlevel == null)
        {
            cardRegisterReply.SetCardLevelInvalidReply();
            return cardRegisterReply;
        }
        return CardRegister(cardRegisterReply, userCinema, CardPassword, LevelCode, InitialAmount, CardUserName, MobilePhone, IDNumber, Sex);
    }
	private CardRegisterReply CardRegister(CardRegisterReply reply, Usercinemaview userCinema, String CardPassword, String LevelCode, String InitialAmount, String CardUserName, String MobilePhone, String IDNumber, String Sex)
    {
        _CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
        CTMSCardRegisterReply CTMSReply=null;
        try {
			CTMSReply = _CTMSInterface.CardRegister(userCinema, CardPassword, LevelCode, InitialAmount, CardUserName, MobilePhone, IDNumber, Sex);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (CTMSReply.Status == StatusEnum.Success)
        {
            reply.setCardNo(CTMSReply.getCardNo());
            reply.setBalance(CTMSReply.getBalance());
            reply.setExpireDate(CTMSReply.getExpireDate());
            //reply.setCreateTime(CTMSReply.getCreateTime());
            reply.setCreateTime(new Date());
            reply.SetSuccessReply();
        }
        else
        {
            reply.GetErrorFromCTMSReply(CTMSReply);
        }
        return reply;
    }
	//endregion
	
	//region 查询影院卖品(完成)
	public QueryGoodsReply QueryGoods(String Username, String Password, String CinemaCode){
		QueryGoodsReply queryGoodsReply=new QueryGoodsReply();
		if (!ReplyExtension.RequestInfoGuard(queryGoodsReply,Username, Password, CinemaCode))
        {
            return queryGoodsReply;
        }
		//获取用户信息
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
        	queryGoodsReply.SetUserCredentialInvalidReply();
            return queryGoodsReply;
        }
        //验证影院是否存在且可访问
        Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
        if (userCinema == null)
        {
        	queryGoodsReply.SetCinemaInvalidReply();
            return queryGoodsReply;
        }
        return QueryGoods(queryGoodsReply,userCinema);
	}
	private QueryGoodsReply QueryGoods(QueryGoodsReply reply,Usercinemaview userCinema){
		_CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
        CTMSQueryGoodsReply CTMSReply=null;
        try {
			CTMSReply = _CTMSInterface.QueryGoods(userCinema);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (StatusEnum.Success.equals(CTMSReply.Status)) {
			List<Goods> goodsList = _goodsService.getByCinemaCode(userCinema.getUserId(),userCinema.getCinemaCode());
			if(goodsList!=null&& goodsList.size()>0){
				QueryGoodsReplyGoodss goodss=new QueryGoodsReplyGoodss();
				goodss.setCount(goodsList.size());
				List<QueryGoodsReplyGoods> replygoodslist=new ArrayList<QueryGoodsReplyGoods>();
				for(Goods goods:goodsList){
					QueryGoodsReplyGoods replygoods=new QueryGoodsReplyGoods();
					ModelMapper.MapFrom(replygoods, goods);
					replygoodslist.add(replygoods);
				}
				goodss.setGoods(replygoodslist);
				reply.setGoodss(goodss);
			}
			reply.SetSuccessReply();
		} else {
			reply.GetErrorFromCTMSReply(CTMSReply);
		}
		return reply;
	}
	//endregion
	
	//region 创建卖品订单(完成)
	public CreateGoodsOrderReply CreateGoodsOrder(String Username, String Password, String QueryXml) throws JsonSyntaxException, Exception{
		CreateGoodsOrderReply createGoodsOrderReply=new CreateGoodsOrderReply();
		if (!ReplyExtension.RequestInfoGuard(createGoodsOrderReply, Username, Password, QueryXml)) {
			return createGoodsOrderReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			createGoodsOrderReply.SetUserCredentialInvalidReply();
			return createGoodsOrderReply;
		}
		// 验证xml参数
		CreateGoodsOrderQueryXml QueryXmlObj=JaxbXmlUtil.convertToJavaBean(QueryXml, CreateGoodsOrderQueryXml.class);
		if (QueryXmlObj.getGoodsList() == null || QueryXmlObj.getGoodsList().getGoods()==null) {
			createGoodsOrderReply.SetXmlDeserializeFailReply(QueryXml);
			return createGoodsOrderReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),
				QueryXmlObj.getCinemaCode());
		if (userCinema == null) {
			createGoodsOrderReply.SetCinemaInvalidReply();
			return createGoodsOrderReply;
		}
		// 验证卖品数量
		if (QueryXmlObj.getGoodsList().getGoods().size()<=0) {
			createGoodsOrderReply.SetGoodsCountInvalidReply();
			return createGoodsOrderReply;
		}
		// 将请求参数转为订单
		GoodsOrderView order=new GoodsOrderView();
		Goodsorders orderBaseInfo=new Goodsorders();
		orderBaseInfo = ModelMapper.MapFrom(orderBaseInfo, userCinema, QueryXmlObj);
		order.setOrderBaseInfo(orderBaseInfo);
		List<Goodsorderdetails> goodsDetails = new ArrayList<Goodsorderdetails>();
		for(CreateGoodsOrderQueryXmlGoods xmlgoods:QueryXmlObj.getGoodsList().getGoods()){
			Goods localGoods=_goodsService.getByCinemaCodeAndGoodsCode(QueryXmlObj.getCinemaCode(), xmlgoods.getGoodsCode());
			Goodsorderdetails goods=new Goodsorderdetails();
			goods.setGoodsCode(localGoods.getGoodsCode());
			goods.setGoodsName(localGoods.getGoodsName());
			goods.setStandardPrice(localGoods.getStandardPrice());
			goods.setSettlePrice(localGoods.getSettlePrice());
			goods.setChannelFee(xmlgoods.getGoodsChannelFee());
			goods.setGoodsCount(xmlgoods.getGoodsCount());
			goods.setSubTotalAmount(localGoods.getStandardPrice()*xmlgoods.getGoodsCount());
			goods.setSubTotalSettleAmount(localGoods.getSettlePrice()*xmlgoods.getGoodsCount());
			goods.setCreated(new Date());
			goods.setIsPackage(localGoods.getIsPackage());
			goods.setGoodsDetail(localGoods.getGoodsDesc());
			goods.setShowSeqNo(localGoods.getShowSeqNo());
			goodsDetails.add(goods);
		}
		order.setOrderGoodsDetails(goodsDetails);
		order.getOrderBaseInfo().setTotalPrice(order.getOrderGoodsDetails().stream().mapToDouble(Goodsorderdetails::getSubTotalAmount).sum());
		order.getOrderBaseInfo().setTotalSettlePrice(order.getOrderGoodsDetails().stream().mapToDouble(Goodsorderdetails::getSubTotalSettleAmount).sum());
		order.getOrderBaseInfo().setTotalFee(order.getOrderGoodsDetails().stream().mapToDouble(Goodsorderdetails::getChannelFee).sum());
		return CreateGoodsOrder(createGoodsOrderReply, userCinema, order);
	}
	private CreateGoodsOrderReply CreateGoodsOrder(CreateGoodsOrderReply reply,Usercinemaview userCinema,GoodsOrderView order){
		_CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
		CTMSCreateGoodsOrderReply CTMSReply = null;
		try {
			CTMSReply = _CTMSInterface.CreateGoodsOrder(userCinema, order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (StatusEnum.Success.equals(CTMSReply.Status)) {
			//更新本地订单号
			order.getOrderBaseInfo().setLocalOrderCode(CTMSReply.getOrderCode());
			reply.setOrder(new CreateGoodsOrderReplyOrder());
			reply.getOrder().setOrderCode(CTMSReply.getOrderCode());
			reply.getOrder().setOrderStatus(order.getOrderBaseInfo().getOrderStatus().toString());
			reply.getOrder().setOrderTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderBaseInfo().getCreated()));
			reply.SetSuccessReply();
		} else {
			reply.GetErrorFromCTMSReply(CTMSReply);
		}
		// 将订单保存到数据库
		_goodsOrderService.Insert(order);
		return reply;
	}
	//endregion
	
	//region 确认卖品订单（完成）
	public SubmitGoodsOrderReply SubmitGoodsOrder(String Username, String Password, String QueryXml) throws JsonSyntaxException, Exception{
		SubmitGoodsOrderReply submitGoodsOrderReply=new SubmitGoodsOrderReply();
		if (!ReplyExtension.RequestInfoGuard(submitGoodsOrderReply, Username, Password, QueryXml)) {
			return submitGoodsOrderReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			submitGoodsOrderReply.SetUserCredentialInvalidReply();
			return submitGoodsOrderReply;
		}
		// 验证提交卖品参数
		SubmitGoodsOrderQueryXml QueryXmlObj=JaxbXmlUtil.convertToJavaBean(QueryXml, SubmitGoodsOrderQueryXml.class);
		if (QueryXmlObj.getGoodsList() == null || QueryXmlObj.getGoodsList().getGoods() == null) {
			submitGoodsOrderReply.SetXmlDeserializeFailReply(QueryXml);
			return submitGoodsOrderReply;
		}
		// 验证是否传递手机号
		if (QueryXmlObj.getMobilePhone().isEmpty()) {
			submitGoodsOrderReply.SetNecessaryParamMissReply("MobilePhone");
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),
				QueryXmlObj.getCinemaCode());
		if (userCinema == null) {
			submitGoodsOrderReply.SetCinemaInvalidReply();
			return submitGoodsOrderReply;
		}
		// 验证订单是否存在
		GoodsOrderView order = null;
		if (!QueryXmlObj.getOrderCode().isEmpty()) {
			order = _goodsOrderService.getWithLocalOrderCode(QueryXmlObj.getCinemaCode(), QueryXmlObj.getOrderCode());
		}
		if (order == null || (order.getOrderBaseInfo().getOrderStatus() != GoodsOrderStatusEnum.Created.getStatusCode()
				&& order.getOrderBaseInfo().getOrderStatus() != GoodsOrderStatusEnum.SubmitFail.getStatusCode()
				&& order.getOrderBaseInfo().getOrderStatus() != GoodsOrderStatusEnum.Payed.getStatusCode())) {
			submitGoodsOrderReply.SetOrderNotExistReply();
			return submitGoodsOrderReply;
		}
		// 验证卖品数量
		if (QueryXmlObj.getGoodsList().getGoods().size()<=0
				|| QueryXmlObj.getGoodsList().getGoods().stream().mapToDouble(SubmitGoodsOrderQueryXmlGoods::getGoodsCount).sum() != order.getOrderBaseInfo().getGoodsCount()) {
			submitGoodsOrderReply.SetGoodsCountInvalidReply();
			return submitGoodsOrderReply;
		}
		// 更新订单信息
		Goodsorders orderBaseInfo=order.getOrderBaseInfo();
		orderBaseInfo = ModelMapper.MapFrom(orderBaseInfo, QueryXmlObj);
		for (Goodsorderdetails goodsdetail : order.getOrderGoodsDetails()) {
			List<SubmitGoodsOrderQueryXmlGoods> xmlgoods = QueryXmlObj.getGoodsList().getGoods().stream()
					.filter((SubmitGoodsOrderQueryXmlGoods s) -> goodsdetail.getGoodsCode().equals(s.getGoodsCode()))
					.collect(Collectors.toList());
			if(xmlgoods!=null){
				goodsdetail.setStandardPrice(xmlgoods.get(0).getStandardPrice());
				goodsdetail.setSettlePrice(xmlgoods.get(0).getSettlePrice());
				goodsdetail.setChannelFee(xmlgoods.get(0).getGoodsChannelFee());
				goodsdetail.setGoodsCount(xmlgoods.get(0).getGoodsCount());
			}
		}
		//把总金额更新到主表
		orderBaseInfo.setTotalPrice(order.getOrderGoodsDetails().stream().mapToDouble(Goodsorderdetails::getStandardPrice).sum());
		orderBaseInfo.setTotalSettlePrice(order.getOrderGoodsDetails().stream().mapToDouble(Goodsorderdetails::getSettlePrice).sum());
		orderBaseInfo.setTotalFee(order.getOrderGoodsDetails().stream().mapToDouble(Goodsorderdetails::getChannelFee).sum());
		
		// TODO:满天星的订单属于会员卡支付的话暂时要求传入会员卡交易流水号
		if (userCinema.getCinemaType() == CinemaTypeEnum.ManTianXing.getTypeCode()
				&& order.getOrderBaseInfo().getOrderPayType()==OrderPayTypeEnum.MemberCardPay.getTypeCode() && order.getOrderBaseInfo().getPaySeqNo().isEmpty()) {
			submitGoodsOrderReply.SetMemberPaySeqNoNotExistReply();
			return submitGoodsOrderReply;
		}
		return SubmitGoodsOrder(submitGoodsOrderReply,userCinema, order);
	}
	private SubmitGoodsOrderReply SubmitGoodsOrder(SubmitGoodsOrderReply reply,Usercinemaview userCinema, GoodsOrderView order){
		try {
			_CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
			CTMSSubmitGoodsOrderReply CTMSReply = null;
			CTMSReply = _CTMSInterface.SubmitGoodsOrder(userCinema, order);
			if (StatusEnum.Success.equals(CTMSReply.Status)) {
				reply.setOrder(new SubmitGoodsOrderReplyOrder());
				reply.getOrder().setOrderCode(order.getOrderBaseInfo().getOrderCode());
				reply.getOrder().setPickUpCode(order.getOrderBaseInfo().getPickUpCode());
				reply.getOrder().setVerifyCode(order.getOrderBaseInfo().getVerifyCode());
				
				reply.SetSuccessReply();
			}else {
				reply.GetErrorFromCTMSReply(CTMSReply);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 更新订单信息
			order.getOrderBaseInfo().setUpdated(new Date());//添加更新时间
			_goodsOrderService.Update(order);
		}
		return reply;
	}
	//endregion
	
	//region 查询卖品订单(完成)
	public QueryGoodsOrderReply QueryGoodsOrder(String Username, String Password, String CinemaCode, String OrderCode){
		QueryGoodsOrderReply queryGoodsOrderReply=new QueryGoodsOrderReply();
		if (!ReplyExtension.RequestInfoGuard(queryGoodsOrderReply, Username, Password, CinemaCode, OrderCode)) {
			return queryGoodsOrderReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			queryGoodsOrderReply.SetUserCredentialInvalidReply();
			return queryGoodsOrderReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),
				CinemaCode);
		if (userCinema == null) {
			queryGoodsOrderReply.SetCinemaInvalidReply();
			return queryGoodsOrderReply;
		}
		// 验证订单是否存在
		GoodsOrderView order = _goodsOrderService.getWithOrderCode(CinemaCode, OrderCode);
		if (order.getOrderBaseInfo() == null) {
			queryGoodsOrderReply.SetOrderNotExistReply();
			return queryGoodsOrderReply;
		}
		return QueryGoodsOrder(queryGoodsOrderReply, userCinema, order);
	}
	private QueryGoodsOrderReply QueryGoodsOrder(QueryGoodsOrderReply reply,Usercinemaview userCinema, GoodsOrderView order){
		try {
			_CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
			CTMSQueryGoodsOrderReply CTMSReply = null;
			CTMSReply = _CTMSInterface.QueryGoodsOrder(userCinema, order);
			if (StatusEnum.Success.equals(CTMSReply.Status)) {
				reply.setOrderCode(order.getOrderBaseInfo().getOrderCode());
				reply.setPickUpCode(order.getOrderBaseInfo().getPickUpCode());
				reply.setVerifyCode(order.getOrderBaseInfo().getVerifyCode());
				reply.setOrderStatus(order.getOrderBaseInfo().getOrderStatus().toString());
				reply.setOrderTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderBaseInfo().getCreated()));
				reply.setGoodsList(new QueryGoodsOrderReplyGoodsList());
				List<QueryGoodsOrderReplyGoods> goodslist=new ArrayList<QueryGoodsOrderReplyGoods>();
				for (Goodsorderdetails goodsdetail : order.getOrderGoodsDetails()) {
					QueryGoodsOrderReplyGoods replygoods = new QueryGoodsOrderReplyGoods();
					replygoods.setGoodsCode(goodsdetail.getGoodsCode());
					replygoods.setGoodsName(goodsdetail.getGoodsName());
					replygoods.setStandardPrice(goodsdetail.getStandardPrice());
					replygoods.setSettlePrice(goodsdetail.getSettlePrice());
					replygoods.setChannelFee(goodsdetail.getChannelFee());
					replygoods.setGoodsCount(goodsdetail.getGoodsCount());
					replygoods.setCreated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(goodsdetail.getCreated()));
					replygoods.setIsPackage(goodsdetail.getIsPackage()==1?"Yes":"No");
					replygoods.setGoodsDetail(goodsdetail.getGoodsDetail());
					goodslist.add(replygoods);
				}
				reply.getGoodsList().setGoods(goodslist);
				reply.SetSuccessReply();
			} else {
				reply.GetErrorFromCTMSReply(CTMSReply);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 更新订单信息
		order.getOrderBaseInfo().setUpdated(new Date());//添加更新时间
		_goodsOrderService.Update(order);
		return reply;
	}
	//endregion
	
	//region 退订卖品(完成)
	public RefundGoodsReply RefundGoods(String Username, String Password, String CinemaCode, String OrderCode,String PaySeqNo){
		RefundGoodsReply refundGoodsReply=new RefundGoodsReply();
		if (!ReplyExtension.RequestInfoGuard(refundGoodsReply, Username, Password, CinemaCode, OrderCode, PaySeqNo)) {
			return refundGoodsReply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			refundGoodsReply.SetUserCredentialInvalidReply();
			return refundGoodsReply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),
				CinemaCode);
		if (userCinema == null) {
			refundGoodsReply.SetCinemaInvalidReply();
			return refundGoodsReply;
		}
		// 验证订单是否存在
		GoodsOrderView order = _goodsOrderService.getWithOrderCode(CinemaCode,OrderCode);
		if (order == null || (order.getOrderBaseInfo().getOrderStatus() != GoodsOrderStatusEnum.Complete.getStatusCode()
				&& order.getOrderBaseInfo().getOrderStatus() != GoodsOrderStatusEnum.RefundFail.getStatusCode())) {
			refundGoodsReply.SetOrderNotExistReply();
			return refundGoodsReply;
		}
		return RefundGoods(refundGoodsReply, userCinema, order);
	}
	private RefundGoodsReply RefundGoods(RefundGoodsReply reply,Usercinemaview userCinema, GoodsOrderView order){
		try {
			_CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
			CTMSRefundGoodsReply CTMSReply = null;
			CTMSReply = _CTMSInterface.RefundGoods(userCinema, order);

			if (StatusEnum.Success.equals(CTMSReply.Status)) {
				reply.setOrder(new RefundGoodsReplyOrder());
				reply.getOrder().setOrderCode(order.getOrderBaseInfo().getOrderCode());
				reply.getOrder().setRefundStatus(order.getOrderBaseInfo().getOrderStatus() == 8? "Yes" : "No");
				reply.getOrder().setRefundTime(reply.getOrder().getRefundStatus() == "Yes"
						? order.getOrderBaseInfo().getRefundTime() == null ? ""
								: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
										.format(order.getOrderBaseInfo().getRefundTime())
						: "");
				reply.SetSuccessReply();
			} else {
				reply.GetErrorFromCTMSReply(CTMSReply);
			}
		} catch (Exception ex) {

		} finally {
			// 更新订单信息
			order.getOrderBaseInfo().setUpdated(new Date());//添加更新时间
			_goodsOrderService.UpdateOrderBaseInfo(order.getOrderBaseInfo());
		}
		return reply;
	}
	//endregion
	
	// region 混合下单（票 + 卖品）
	public SubmitMixOrderReply SubmitMixOrder(String Username, String Password, String QueryXml) throws JsonSyntaxException, Exception {
		SubmitMixOrderReply submitMixOrderReply = new SubmitMixOrderReply();
		//验证参数
		if (!ReplyExtension.RequestInfoGuard(submitMixOrderReply, Username, Password, QueryXml)) {
			return submitMixOrderReply;
		}

		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
		if (UserInfo == null) {
			submitMixOrderReply.SetUserCredentialInvalidReply();
			return submitMixOrderReply;
		}
		// 验证锁座参数，卖品参数
		SubmitMixOrderQueryXml QueryXmlObj = new Gson().fromJson(QueryXml, SubmitMixOrderQueryXml.class);
		if (QueryXmlObj.getOrderCode() == null || QueryXmlObj.getSeat() == null || 
				QueryXmlObj.getGoodsOrderCode() == null || QueryXmlObj.getGoods() == null) {
			submitMixOrderReply.SetXmlDeserializeFailReply(QueryXml);
			return submitMixOrderReply;
		}
		// 验证是否传递手机号
		if (QueryXmlObj.getMobilePhone() == null) {
			submitMixOrderReply.SetNecessaryParamMissReply("MobilePhone");
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),
				QueryXmlObj.getCinemaCode());
		if (userCinema == null) {
			submitMixOrderReply.SetCinemaInvalidReply();
			return submitMixOrderReply;
		}
		// 验证购票订单是否存在
		OrderView order = _orderService.getOrderWidthLockOrderCode(QueryXmlObj.getCinemaCode(), QueryXmlObj.getOrderCode());
		if (order == null || (order.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.Locked.getStatusCode()
				&& order.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.SubmitFail.getStatusCode()
				&& order.getOrderBaseInfo().getOrderStatus() != OrderStatusEnum.Payed.getStatusCode())) {
			submitMixOrderReply.SetOrderNotExistReply();
			return submitMixOrderReply;
		}
		// 验证座位数量
		if(QueryXmlObj.getSeatCount() != QueryXmlObj.getSeat().size() || 
				QueryXmlObj.getSeatCount() != order.getOrderBaseInfo().getTicketCount()){
			submitMixOrderReply.SetSeatCountInvalidReply();
			return submitMixOrderReply;
		}
		// 更新订单信息
		order = ModelMapper.MapFrom(order, QueryXmlObj);

		//创建卖品订单
		CreateGoodsOrderQueryXml createGoodsOrderQueryXml = new CreateGoodsOrderQueryXml();
		createGoodsOrderQueryXml.setCinemaCode(QueryXmlObj.getCinemaCode());
		createGoodsOrderQueryXml.setPayType(QueryXmlObj.getPayType());
		List<SubmitMixOrderQueryXmlGoods> mixGoods = QueryXmlObj.getGoods();
		CreateGoodsOrderQueryXmlGoodsList goodsList = new CreateGoodsOrderQueryXmlGoodsList();
		List<CreateGoodsOrderQueryXmlGoods> goods = new ArrayList<CreateGoodsOrderQueryXmlGoods>();
		for(SubmitMixOrderQueryXmlGoods mixGood:mixGoods){
			CreateGoodsOrderQueryXmlGoods good = new CreateGoodsOrderQueryXmlGoods();
			good.setGoodsCode(mixGood.getGoodsCode());
			good.setGoodsChannelFee(mixGood.getGoodsChannelFee());
			good.setGoodsCount(mixGood.getGoodsCount());
			good.setStandardPrice(mixGood.getStandardPrice());
			goods.add(good);
		}
		goodsList.setGoods(goods);
		createGoodsOrderQueryXml.setGoodsList(goodsList);
		CreateGoodsOrder(Username, Password, createGoodsOrderQueryXml.toString());
		//验证卖品订单
		GoodsOrderView goodsorder = _goodsOrderService.getWithLocalOrderCode(QueryXmlObj.getCinemaCode(), QueryXmlObj.getGoodsOrderCode());
		if (goodsorder == null || (goodsorder.getOrderBaseInfo().getOrderStatus() != GoodsOrderStatusEnum.Created.getStatusCode()
				&& goodsorder.getOrderBaseInfo().getOrderStatus() != GoodsOrderStatusEnum.SubmitFail.getStatusCode()
				&& goodsorder.getOrderBaseInfo().getOrderStatus() != GoodsOrderStatusEnum.Payed.getStatusCode())) {
			submitMixOrderReply.SetOrderNotExistReply();
			return submitMixOrderReply;
		}
		// 验证卖品数量
		if (QueryXmlObj.getGoods().size()<=0
				|| QueryXmlObj.getGoods().stream().mapToDouble(SubmitMixOrderQueryXmlGoods::getGoodsCount).sum() != goodsorder.getOrderBaseInfo().getGoodsCount()) {
			submitMixOrderReply.SetGoodsCountInvalidReply();
			return submitMixOrderReply;
		}
		// 更新卖品订单信息
		ModelMapper.MapFrom(goodsorder.getOrderBaseInfo(), QueryXmlObj);
		for (Goodsorderdetails goodsdetail : goodsorder.getOrderGoodsDetails()) {
			List<SubmitMixOrderQueryXmlGoods> xmlgoods = QueryXmlObj.getGoods().stream()
					.filter((SubmitMixOrderQueryXmlGoods s) -> goodsdetail.getGoodsCode().equals(s.getGoodsCode())).collect(Collectors.toList());
			if(xmlgoods!=null){
				goodsdetail.setStandardPrice(xmlgoods.get(0).getStandardPrice());
				goodsdetail.setSettlePrice(xmlgoods.get(0).getSettlePrice());
				goodsdetail.setChannelFee(xmlgoods.get(0).getGoodsChannelFee());
				goodsdetail.setGoodsCount(xmlgoods.get(0).getGoodsCount());
			}
		}
		//把总金额更新到主表
		goodsorder.getOrderBaseInfo().setTotalPrice(goodsorder.getOrderGoodsDetails().stream().mapToDouble(Goodsorderdetails::getStandardPrice).sum());
		goodsorder.getOrderBaseInfo().setTotalSettlePrice(goodsorder.getOrderGoodsDetails().stream().mapToDouble(Goodsorderdetails::getSettlePrice).sum());
		goodsorder.getOrderBaseInfo().setTotalFee(goodsorder.getOrderGoodsDetails().stream().mapToDouble(Goodsorderdetails::getChannelFee).sum());

		// TODO:满天星的订单属于会员卡支付的话暂时要求传入会员卡交易流水号
		if (userCinema.getCinemaType() == CinemaTypeEnum.ManTianXing.getTypeCode()
				&& order.getOrderBaseInfo().getIsMemberPay() == 1 && order.getOrderBaseInfo().getPaySeqNo().isEmpty()) {
			submitMixOrderReply.SetMemberPaySeqNoNotExistReply();
			return submitMixOrderReply;
		}
		
		return SubmitMixOrder(submitMixOrderReply, userCinema, order, goodsorder);
	}
	
	private SubmitMixOrderReply SubmitMixOrder(SubmitMixOrderReply reply,Usercinemaview userCinema,OrderView order, GoodsOrderView goodsorder){
		try {
			_CTMSInterface = CTMSInterfaceFactory.Create(userCinema);
			CTMSSubmitMixOrderReply CTMSReply = null;
			CTMSReply = _CTMSInterface.SubmitMixOrder(userCinema, order, goodsorder);

			if (StatusEnum.Success.equals(CTMSReply.Status)) {
				SubmitTicketsOrder ticketsOrder = new SubmitTicketsOrder();	//购票信息
				ticketsOrder.setCinemaType(userCinema.getCinemaType());
				ticketsOrder.setOrderCode(order.getOrderBaseInfo().getSubmitOrderCode());
				ticketsOrder.setSessionCode(order.getOrderBaseInfo().getSessionCode());
				ticketsOrder.setPrintNo(order.getOrderBaseInfo().getPrintNo());
				ticketsOrder.setTicketCount(order.getOrderBaseInfo().getTicketCount());;
				ticketsOrder.setVerifyCode(order.getOrderBaseInfo().getVerifyCode());
				
				List<SubmitOrderSeat> Seats = new ArrayList<SubmitOrderSeat>();
				for(Orderseatdetails details : order.getOrderSeatDetails()){
					SubmitOrderSeat seat = new SubmitOrderSeat();
					seat.setSeatCode(details.getSeatCode());
					seat.setFilmTicketCode(details.getFilmTicketCode());
					Seats.add(seat);
				}
				ticketsOrder.setSeat(Seats);
				
				SubmitGoodsOrder goodsOrder = new SubmitGoodsOrder();	//卖品信息
				goodsOrder.setGoodsOrderCode(goodsorder.getOrderBaseInfo().getOrderCode());
				goodsOrder.setPickUpCode(goodsorder.getOrderBaseInfo().getPickUpCode());
				goodsOrder.setVerifyCode(goodsorder.getOrderBaseInfo().getVerifyCode());
				
				reply.setTicketsOrder(ticketsOrder);
				reply.setGoodsOrder(goodsOrder);
				reply.SetSuccessReply();
				
			} else {
				reply.GetErrorFromCTMSReply(CTMSReply);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 更新购票订单信息
			order.getOrderBaseInfo().setUpdated(new Date());//添加更新时间
			_orderService.Update(order);
			// 更新卖品订单信息
			goodsorder.getOrderBaseInfo().setUpdated(new Date());//添加更新时间
			_goodsOrderService.Update(goodsorder);
		}
		
		return reply;
	}

}
