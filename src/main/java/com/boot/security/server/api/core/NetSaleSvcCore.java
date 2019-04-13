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

import com.boot.security.server.api.core.LockSeatReply.LockSeatReplyOrder.LockSeatReplySeat;
import com.boot.security.server.api.core.QueryCinemaListReply.QueryCinemaListReplyCinemas.QueryCinemaListReplyCinema;
import com.boot.security.server.api.core.QueryCinemaReply.QueryCinemaReplyCinema.QueryCinemaReplyScreen;
import com.boot.security.server.api.core.QueryFilmReply.QueryFilmReplyFilms.QueryFilmReplyFilm;
import com.boot.security.server.api.core.QueryOrderReply.QueryOrderReplyOrder.QueryOrderReplyFilms;
import com.boot.security.server.api.core.QueryOrderReply.QueryOrderReplyOrder.QueryOrderReplyFilms.QueryOrderReplyFilm;
import com.boot.security.server.api.core.QueryOrderReply.QueryOrderReplyOrder.QueryOrderReplySeats;
import com.boot.security.server.api.core.QueryOrderReply.QueryOrderReplyOrder.QueryOrderReplySeats.QueryOrderReplySeat;
import com.boot.security.server.api.core.QuerySeatReply.QuerySeatReplyCinema.QuerySeatReplyScreen.QuerySeatReplySeat;
import com.boot.security.server.api.core.QuerySessionReply.QuerySessionReplySessions.QuerySessionReplySession;
import com.boot.security.server.api.core.QuerySessionSeatReply.QuerySessionSeatReplySessionSeat.QuerySessionSeatReplySeat;
import com.boot.security.server.api.core.QueryTicketReply.QueryTicketReplyTickets;
import com.boot.security.server.api.core.QueryTicketReply.QueryTicketReplyTickets.QueryTicketReplyTicket;
import com.boot.security.server.api.core.ReleaseSeatReply.ReleaseSeatReplyOrder.ReleaseSeatReplySeat;
import com.boot.security.server.api.core.SubmitOrderReply.SubmitOrderReplyOrder.SubmitOrderReplySeat;
import com.boot.security.server.api.ctms.reply.CTMSFetchTicketReply;
import com.boot.security.server.api.ctms.reply.CTMSInterfaceFactory;
import com.boot.security.server.api.ctms.reply.CTMSLockSeatReply;
import com.boot.security.server.api.ctms.reply.CTMSQueryCinemaReply;
import com.boot.security.server.api.ctms.reply.CTMSQueryFilmReply;
import com.boot.security.server.api.ctms.reply.CTMSQueryOrderReply;
import com.boot.security.server.api.ctms.reply.CTMSQueryPrintReply;
import com.boot.security.server.api.ctms.reply.CTMSQuerySeatReply;
import com.boot.security.server.api.ctms.reply.CTMSQuerySessionReply;
import com.boot.security.server.api.ctms.reply.CTMSQuerySessionSeatReply;
import com.boot.security.server.api.ctms.reply.CTMSQueryTicketReply;
import com.boot.security.server.api.ctms.reply.CTMSRefundTicketReply;
import com.boot.security.server.api.ctms.reply.CTMSReleaseSeatReply;
import com.boot.security.server.api.ctms.reply.CTMSSubmitOrderReply;
import com.boot.security.server.api.ctms.reply.CxInterface;
import com.boot.security.server.api.ctms.reply.ICTMSInterface;
import com.boot.security.server.model.CinemaTypeEnum;
import com.boot.security.server.model.Filminfo;
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
import com.boot.security.server.model.YesOrNoEnum;
import com.boot.security.server.service.impl.OrderServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.ScreenseatinfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.service.impl.UserCinemaViewServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.boot.security.server.utils.JaxbXmlUtil;
import com.boot.security.server.utils.SpringUtil;
import com.boot.security.server.utils.XmlToJsonUtil;
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
	 
	 protected static Logger log = LoggerFactory.getLogger(CxInterface.class);

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

		reply.Cinemas = reply.new QueryCinemaListReplyCinemas();// 实例化内部类
		if (cinemaList == null || cinemaList.size() == 0) {
			reply.Cinemas.CinemaCount = 0;
		} else {
			reply.Cinemas.CinemaCount = cinemaList.size();
			reply.Cinemas.Cinema = new ArrayList<QueryCinemaListReplyCinema>();
			for (Usercinemaview cinema : cinemaList) {
				QueryCinemaListReplyCinema replycinema = reply.Cinemas.new QueryCinemaListReplyCinema();
				ModelMapper.MapFrom(replycinema, cinema);
				reply.Cinemas.Cinema.add(replycinema);
			}
		}
		reply.SetSuccessReply();
		System.out.println(new Gson().toJson(reply));
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
			reply.Cinema = reply.new QueryCinemaReplyCinema();
			reply.Cinema.Code = userCinema.getCinemaCode();
			reply.Cinema.Name = userCinema.getCinemaName();
			reply.Cinema.Address = userCinema.getCinemaAddress();

			List<Screeninfo> ScreenList = _screenInfoService.getByCinemaCode(userCinema.getCinemaCode());
			if (ScreenList == null || ScreenList.size() == 0) {
				reply.Cinema.ScreenCount = 0;
			} else {
				reply.Cinema.ScreenCount = ScreenList.size();
				reply.Cinema.Screen = new ArrayList<QueryCinemaReplyScreen>();
				for (Screeninfo screen : ScreenList) {
					QueryCinemaReplyScreen replyscreen = reply.Cinema.new QueryCinemaReplyScreen();
					ModelMapper.MapFrom(replyscreen, screen);
					reply.Cinema.Screen.add(replyscreen);
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
			reply.Cinema = reply.new QuerySeatReplyCinema();
			reply.Cinema.Code = userCinema.getCinemaCode();
			reply.Cinema.Screen = reply.Cinema.new QuerySeatReplyScreen();
			reply.Cinema.Screen.Code = screen.getSCode();

			List<Screenseatinfo> seatList = _seatInfoService.getByCinemaCodeAndScreenCode(userCinema.getCinemaCode(),
					screen.getSCode());

			if (seatList != null && seatList.size() > 0) {
				reply.Cinema.Screen.Seat = new ArrayList<QuerySeatReplySeat>();
				for (Screenseatinfo seat : seatList) {
					QuerySeatReplySeat replyseat = reply.Cinema.Screen.new QuerySeatReplySeat();
					ModelMapper.MapFrom(replyseat, seat);
					reply.Cinema.Screen.Seat.add(replyseat);
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
		Date Start = new SimpleDateFormat("yyyy-MM-dd").parse(StartDate);
		Date End = new SimpleDateFormat("yyyy-MM-dd").parse(EndDate);
		if (Start == null) {
			queryFilmReply.SetStartDateInvalidReply();
			return queryFilmReply;
		}
		if (End == null) {
			queryFilmReply.SetEndDateInvalidReply();
			return queryFilmReply;
		}
		if (Start.getTime() > End.getTime()) {
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
			reply.Films = reply.new QueryFilmReplyFilms();
			reply.Films.Film = new ArrayList<QueryFilmReplyFilm>();
			reply.Films.Count = FilmEntities.size();
			for (Filminfo film : FilmEntities) {
				QueryFilmReplyFilm replyfilm = reply.Films.new QueryFilmReplyFilm();
				ModelMapper.MapFrom(replyfilm, film);
				reply.Films.Film.add(replyfilm);
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
		Date Start = new SimpleDateFormat("yyyy-MM-dd").parse(StartDate);
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
		}

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

			reply.Sessions = reply.new QuerySessionReplySessions();
			reply.Sessions.CinemaCode = userCinema.getCinemaCode();
			if (sessionList != null && sessionList.size() > 0) {
				reply.Sessions.Session = new ArrayList<QuerySessionReplySession>();
				for (Sessioninfo session : sessionList) {
					QuerySessionReplySession replysession = reply.Sessions.new QuerySessionReplySession();
					ModelMapper.MapFrom(replysession, session);
					reply.Sessions.Session.add(replysession);
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
			reply.SessionSeat = reply.new QuerySessionSeatReplySessionSeat();
			reply.SessionSeat.CinemaCode = userCinema.getCinemaCode();
			reply.SessionSeat.SessionCode = SessionCode;
			 reply.SessionSeat.Seat = new ArrayList<QuerySessionSeatReplySeat>();
			for (SessionSeat seat : CTMSReply.getSessionSeats()) {
				QuerySessionSeatReplySeat replyseat = reply.SessionSeat.new QuerySessionSeatReplySeat();
				replyseat.setCode(seat.getSeatCode());
				replyseat.setRowNum(seat.getRowNum());
				replyseat.setColumnNum(seat.getColumnNum());
				replyseat.setStatus(seat.getStatus().getStatusCode());
				reply.SessionSeat.Seat.add(replyseat);
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
			reply.Order = reply.new LockSeatReplyOrder();
			reply.Order.OrderCode = order.getOrderBaseInfo().getLockOrderCode();
			reply.Order.AutoUnlockDatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(order.getOrderBaseInfo().getAutoUnlockDatetime());
			reply.Order.SessionCode = order.getOrderBaseInfo().getSessionCode();
			reply.Order.Count = order.getOrderBaseInfo().getTicketCount();
			List<LockSeatReplySeat> replySeats = new ArrayList<LockSeatReplySeat>();
			for (Orderseatdetails seat : order.getOrderSeatDetails()) {
				LockSeatReplySeat replyseat = reply.Order.new LockSeatReplySeat();
				replyseat.setSeatCode(seat.getSeatCode());
				replySeats.add(replyseat);
			}
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
			reply.Order = reply.new ReleaseSeatReplyOrder();
			reply.Order.OrderCode = order.getOrderBaseInfo().getLockOrderCode();
			reply.Order.SessionCode = order.getOrderBaseInfo().getSessionCode();
			reply.Order.Count = order.getOrderBaseInfo().getTicketCount();
			List<ReleaseSeatReplySeat> replySeats = new ArrayList<ReleaseSeatReplySeat>();
			for (Orderseatdetails seat : order.getOrderSeatDetails()) {
				ReleaseSeatReplySeat replyseat = reply.Order.new ReleaseSeatReplySeat();
				replyseat.setSeatCode(seat.getSeatCode());
				replySeats.add(replyseat);
			}
			reply.Order.Seat = replySeats;
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
				reply.Order = reply.new SubmitOrderReplyOrder();
				reply.Order.CinemaType = userCinema.getCinemaType();
				reply.Order.OrderCode = order.getOrderBaseInfo().getSubmitOrderCode();
				reply.Order.SessionCode = order.getOrderBaseInfo().getSessionCode();
				reply.Order.Count = order.getOrderBaseInfo().getTicketCount();
				reply.Order.PrintNo = order.getOrderBaseInfo().getPrintNo();
				reply.Order.VerifyCode = order.getOrderBaseInfo().getVerifyCode();

				List<SubmitOrderReplySeat> replySeats = new ArrayList<SubmitOrderReplySeat>();
				for (Orderseatdetails seat : order.getOrderSeatDetails()) {
					SubmitOrderReplySeat replyseat = reply.Order.new SubmitOrderReplySeat();
					replyseat.setSeatCode(seat.getSeatCode());
					replyseat.setFilmTicketCode(seat.getFilmTicketCode());
					replySeats.add(replyseat);
				}
				reply.Order.Seat = replySeats;
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
			reply.Order = reply.new QueryPrintReplyOrder();
			reply.Order.OrderCode = order.getOrderBaseInfo().getSubmitOrderCode();
			reply.Order.PrintNo = order.getOrderBaseInfo().getPrintNo();
			reply.Order.VerifyCode = order.getOrderBaseInfo().getVerifyCode();
			reply.Order.Status = order.getOrderBaseInfo().getPrintStatus() == 1?"Yes":"No";
			reply.Order.PrintTime = order.getOrderBaseInfo().getPrintTime() == null ? ""
					: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderBaseInfo().getPrintTime());
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
				reply.Order = reply.new RefundTicketReplyOrder();
				reply.Order.OrderCode = order.getOrderBaseInfo().getSubmitOrderCode();
				reply.Order.PrintNo = order.getOrderBaseInfo().getPrintNo();
				reply.Order.VerifyCode = order.getOrderBaseInfo().getVerifyCode();
				reply.Order.Status = order.getOrderBaseInfo().getOrderStatus() == 9? YesOrNoEnum.Yes : YesOrNoEnum.No;
				reply.Order.RefundTime = reply.Order.Status == YesOrNoEnum.Yes
						? order.getOrderBaseInfo().getRefundTime() == null ? ""
								: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
										.format(order.getOrderBaseInfo().getRefundTime())
						: "";
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
			reply.Order = reply.new QueryOrderReplyOrder();
			reply.Order.OrderCode = order.getOrderBaseInfo().getSubmitOrderCode();
			reply.Order.CinemaCode = userCinema.getCinemaCode();
			reply.Order.CinemaType = userCinema.getCinemaType().toString();
			reply.Order.CinemaName = userCinema.getCinemaName();
			Screeninfo screenInfo = _screenInfoService.getByScreenCode(userCinema.getCinemaCode(),
					order.getOrderBaseInfo().getScreenCode());
			reply.Order.ScreenCode = order.getOrderBaseInfo().getScreenCode();
			reply.Order.ScreenName = screenInfo == null ? ""
					: screenInfo.getSName() == null ? "" : screenInfo.getSName();
			Sessioninfo sessionInfo = _sessionInfoService.getBySessionCode(userCinema.getUserId(),
					userCinema.getCinemaCode(), order.getOrderBaseInfo().getSessionCode());
			reply.Order.SessionCode = order.getOrderBaseInfo().getSessionCode();
			reply.Order.StartTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(order.getOrderBaseInfo().getSessionTime());
			reply.Order.PlaythroughFlag = sessionInfo == null ? "No"
					: sessionInfo.getPlaythroughFlag() == null ? "No" : sessionInfo.getPlaythroughFlag();
			reply.Order.PrintNo = order.getOrderBaseInfo().getPrintNo();
			reply.Order.VerifyCode = order.getOrderBaseInfo().getVerifyCode();

			QueryOrderReplyFilms films = reply.Order.new QueryOrderReplyFilms();
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
			reply.Order.Films = films;

			QueryOrderReplySeats seats = reply.Order.new QueryOrderReplySeats();
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
			reply.Order.Seats = seats;

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
            	ticket.setSessionDateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderBaseInfo().getSessionTime()));
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
            reply.Tickets = tickets;
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
}
