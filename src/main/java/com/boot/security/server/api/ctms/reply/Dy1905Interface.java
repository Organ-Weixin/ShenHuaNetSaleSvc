package com.boot.security.server.api.ctms.reply;

import java.lang.management.LockInfo;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.boot.security.server.api.core.ModelMapper;
import com.boot.security.server.api.ctms.reply.CxQueryPlanInfoByDatePeriodResult.ResBean.CinemaPlansBean.CinemaPlanBean;
import com.boot.security.server.api.ctms.reply.Dy1905GetCinemaAllSessionResult.ResBean.SessionsBean.SessionBean;
import com.boot.security.server.api.ctms.reply.Dy1905GetCinemaResult.ResBean.CinemasBean.CinemaBean;
import com.boot.security.server.api.ctms.reply.Dy1905GetFeatureFilmResult.ResBean.FilmsBean.FilmBean;
import com.boot.security.server.api.ctms.reply.Dy1905GetOrderStatusResult.ResBean.SeatsBean.SeatBean;
import com.boot.security.server.api.ctms.reply.Dy1905GetScreenResult.ResBean.ScreensBean.ScreenBean;
import com.boot.security.server.api.ctms.reply.Dy1905GetScreenSeatResult.ResBean.ScreenSeatsBean.ScreenSeatBean;
import com.boot.security.server.api.ctms.reply.Dy1905GetSessionSeatResult.ResBean.SessionSeatsBean.SessionSeatBean;
import com.boot.security.server.api.ctms.reply.Dy1905LockSeatCustomResult.ResBean.SeatInfosBean.SeatInfoBean;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.LoveFlagEnum;
import com.boot.security.server.model.OrderStatusEnum;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.SessionSeat;
import com.boot.security.server.model.SessionSeatStatusEnum;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.StatusEnum;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.YesOrNoEnum;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.ScreenseatinfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.utils.HttpHelper;
import com.boot.security.server.utils.MD5Util;
import com.boot.security.server.utils.SpringUtil;
import com.boot.security.server.utils.XmlToJsonUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.oristartech.tsp.ws.soap.DoubleDefaultAdapter;
import com.oristartech.tsp.ws.soap.IntegerDefaultAdapter;
public class Dy1905Interface implements ICTMSInterface {
	
	CinemaServiceImpl cinemaService = SpringUtil.getBean(CinemaServiceImpl.class);
	ScreeninfoServiceImpl screeninfoService = SpringUtil.getBean(ScreeninfoServiceImpl.class);
	ScreenseatinfoServiceImpl screenseatinfoService = SpringUtil.getBean(ScreenseatinfoServiceImpl.class);
	SessioninfoServiceImpl sessioninfoService = SpringUtil.getBean(SessioninfoServiceImpl.class);
	FilminfoServiceImpl filminfoService = SpringUtil.getBean(FilminfoServiceImpl.class);
	/*
	 *
	 * */
	//@Override
	public CTMSQueryCinemaReply QueryCinema(Usercinemaview userCinema) throws Exception {
		CTMSQueryCinemaReply reply = new CTMSQueryCinemaReply();
		if (userCinema.getCinemaId()==null)
        {
            if (!QueryCinemaId(userCinema))
            {
                reply.GetDy1905CinemaNotValidReply();
                return reply;
            }
        }
		String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + userCinema.getCinemaId() + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("pAppCode",userCinema.getDefaultUserName());
		param.put("pCinemaID",userCinema.getCinemaId());
		param.put("pVerifyInfo",pVerifyInfo);
		String getScreenResult = HttpHelper.httpClientPost(userCinema.getUrl()+"/GetScreen",param,"UTF-8");
		System.out.println(getScreenResult);
		Gson gson = new Gson();
		Dy1905GetScreenResult Dy1905Reply=gson.fromJson(XmlToJsonUtil.xmltoJson(getScreenResult,"GetScreenResult"), Dy1905GetScreenResult.class);
		System.out.println(Dy1905Reply.getGetScreenResult().getResultCode());
		if (Dy1905Reply.getGetScreenResult().getResultCode().equals("0"))
        {
			//更新影院信息
			Cinema cinema = cinemaService.getByCinemaCode(userCinema.getCinemaCode());
			cinema.setScreenCount(Dy1905Reply.getGetScreenResult().getScreens().getScreen().size());
			cinemaService.update(cinema);
			//更新影厅信息
			List<Screeninfo> newScreens = new ArrayList<Screeninfo>();
			List<ScreenBean> dyscreens=Dy1905Reply.getGetScreenResult().getScreens().getScreen();
			for(ScreenBean dyscreen:dyscreens)
			{
				Screeninfo screen=new Screeninfo();//先读取本地
				Dy1905ModelMapper.MapToEntity(dyscreen,screen);
				screen.setCCode(userCinema.getCinemaCode());
				newScreens.add(screen);
			}
			//先删除旧影影厅
			screeninfoService.deleteByCinemaCode(userCinema.getCinemaCode());
			//插入影厅信息
			for(Screeninfo screen:newScreens){
				screeninfoService.save(screen);
			}
			reply.Status = StatusEnum.Success;
        }
		else
        {
            reply.Status = StatusEnum.Failure;
        }
		reply.ErrorCode = Dy1905Reply.getGetScreenResult().getResultCode();
		return reply;
	}
	/*
	 *	查询影厅中的座位信息
	 * */
	@Override
	public CTMSQuerySeatReply QuerySeat(Usercinemaview userCinema, Screeninfo screen) throws Exception {
		CTMSQuerySeatReply reply = new CTMSQuerySeatReply();
		String pVerifyInfo=MD5Util.MD5Encode(userCinema.getDefaultUserName()+userCinema.getCinemaId()+screen.getScreenId()+userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("pAppCode",userCinema.getDefaultUserName());
		param.put("pCinemaID", userCinema.getCinemaId());
		param.put("pScreenID", screen.getScreenId());
		param.put("pVerifyInfo",pVerifyInfo);
		String getScreenSeatResult = HttpHelper.httpClientPost(userCinema.getUrl()+"/GetScreenSeat", param,"UTF-8");
		System.out.println(getScreenSeatResult);
		Gson gson = new Gson();
		Dy1905GetScreenSeatResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(getScreenSeatResult,"GetScreenSeatResult"),Dy1905GetScreenSeatResult.class);
		if(Dy1905Reply.getGetScreenSeatResult().getResultCode().equals("0")){
			//更新影厅信息
			Screeninfo screeninfo = new Screeninfo();
			screeninfo.setCCode(userCinema.getCinemaCode());
			screeninfo.setSCode(screen.getSCode());
			screeninfo.setSeatCount(Dy1905Reply.getGetScreenSeatResult().getScreenSeats().getScreenSeat().size());
			screeninfoService.update(screeninfo);
			List<Screenseatinfo> newScreenSeat = new ArrayList<Screenseatinfo>();
			List<ScreenSeatBean> dy1905ScreenSeats = Dy1905Reply.getGetScreenSeatResult().getScreenSeats().getScreenSeat();
			System.out.println(userCinema.getCinemaCode()+"=================="+screen.getSCode());
			////////////////////////
			for(ScreenSeatBean dy1905ScreenSeat :dy1905ScreenSeats){
				Screenseatinfo screenSeat = new Screenseatinfo();
				Dy1905ModelMapper.MapToEntity(dy1905ScreenSeat,screenSeat);
				screenSeat.setCinemaCode(userCinema.getCinemaCode());
				screenSeat.setScreenCode(screen.getSCode());
				screenSeat.setStatus("Available");
				screenSeat.setLoveFlag(LoveFlagEnum.Normal.getFlagCode());
				newScreenSeat.add(screenSeat);
			}
			Map<String, List<Screenseatinfo>> groupSeats = newScreenSeat.stream()
					.collect(Collectors.groupingBy(Screenseatinfo::getGroupCode));
			for (Map.Entry<String, List<Screenseatinfo>> entry : groupSeats.entrySet()) {
				if (entry.getValue().size() == 2) {
					Screenseatinfo firstSeat = entry.getValue().get(0);
					Screenseatinfo SecondSeat = entry.getValue().get(1);
					if (firstSeat.getXCoord() < SecondSeat.getXCoord()) {
						firstSeat.setLoveFlag(LoveFlagEnum.LEFT.getFlagCode());
						SecondSeat.setLoveFlag(LoveFlagEnum.RIGHT.getFlagCode());
					} else {
						firstSeat.setLoveFlag(LoveFlagEnum.RIGHT.getFlagCode());
						SecondSeat.setLoveFlag(LoveFlagEnum.LEFT.getFlagCode());
					}
				}
			}
			newScreenSeat.forEach(seat -> seat.setGroupCode("0000000000000001"));	
			//删除旧座位
			screenseatinfoService.deleteByScreenCode(userCinema.getCinemaCode(), screen.getSCode());
			//插入座位信息
			for(Screenseatinfo screenseat :newScreenSeat){
				screenseatinfoService.save(screenseat);
			}
			reply.Status = StatusEnum.Success;
		}else{
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = Dy1905Reply.getGetScreenSeatResult().getResultCode();
		return reply;
	}
	/*
	 * 	查询即将放映的影片
	 * */
	@Override
	public CTMSQueryFilmReply QueryFilm(Usercinemaview userCinema, Date StartDate, Date EndDate) throws Exception {
		CTMSQueryFilmReply reply = new CTMSQueryFilmReply();
		String pVerifyInfo=MD5Util.MD5Encode(userCinema.getDefaultUserName()+userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("pAppCode",userCinema.getDefaultUserName());
		param.put("pVerifyInfo",pVerifyInfo);
		String getFeatureFilmResult = HttpHelper.httpClientPost(userCinema.getUrl()+"/GetFeatureFilm", param,"UTF-8");
		System.out.println(getFeatureFilmResult);
		Gson gson = new Gson();
		Dy1905GetFeatureFilmResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(getFeatureFilmResult,"GetFeatureFilmResult"),Dy1905GetFeatureFilmResult.class);
		if(Dy1905Reply.getGetFeatureFilmResult().getResultCode().equals("0")){
			QuerySession(userCinema, StartDate, EndDate);
			List<Filminfo> newFilm = new ArrayList<Filminfo>();
			Map<String,Object> params = new HashMap();
			params.put("CCode", userCinema.getCinemaCode());
			if(StartDate!=null){
				params.put("StartTime", new SimpleDateFormat("yyyy-MM-dd").format(StartDate));
			}
			if(EndDate!=null){
				params.put("EndTime", new SimpleDateFormat("yyyy-MM-dd").format(EndDate));
			}
			List<Sessioninfo> sessionInfoList = sessioninfoService.getFilms(params);
			System.out.println("排期中的影片数量"+sessionInfoList.size());
			if(sessionInfoList.size()>0){
				sessionInfoList = sessionInfoList.stream().distinct().collect(Collectors.toList());
				//获取排期中的影片信息
				for(Sessioninfo sessioninfo : sessionInfoList){
					Filminfo film = filminfoService.getByFilmCode(sessioninfo.getFilmCode());
					List<FilmBean> dy1905Films = Dy1905Reply.getGetFeatureFilmResult().getFilms().getFilm().stream()
											.filter((FilmBean filmbean)->filmbean.getFilmNo().equals(sessioninfo.getFilmCode()))
											.collect(Collectors.toList());
					System.out.println("匹配排期中的影片"+dy1905Films.size());
					if(film==null){
						film = new Filminfo();
						film.setFilmCode(sessioninfo.getFilmCode());
						film.setFilmName(sessioninfo.getFilmName());
						film.setDuration(String.valueOf(sessioninfo.getDuration()));
						System.out.println("排期中影片类型"+sessioninfo.getDimensional());
						System.out.println("影片类型"+film.getVersion());
						filminfoService.save(film);
					}else{
						film = new Filminfo();
						film.setFilmCode(sessioninfo.getFilmCode());
						film.setFilmName(sessioninfo.getFilmName());
						film.setDuration(String.valueOf(sessioninfo.getDuration()));
						film.setVersion(sessioninfo.getDimensional());
						System.out.println("排期中影片类型"+sessioninfo.getDimensional());
						System.out.println("影片类型"+film.getVersion());
						filminfoService.update(film);
					}
					newFilm.add(film);
				}
			}
				reply.setFilms(newFilm);
				reply.Status = StatusEnum.Success;
			}else{
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = Dy1905Reply.getGetFeatureFilmResult().getResultCode();
		return reply;
	}
	/*
	 * 	查询排期
	 * */
	@Override
	public CTMSQuerySessionReply QuerySession(Usercinemaview userCinema, Date StartDate,Date EndDate)
			throws Exception {
		CTMSQuerySessionReply reply = new CTMSQuerySessionReply();
		String pVerifyInfo=MD5Util.MD5Encode(userCinema.getDefaultUserName()+userCinema.getCinemaId()+userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		Map<String,String> param = new LinkedHashMap();
		param.put("pAppCode",userCinema.getDefaultUserName());
		param.put("pCinemaID",userCinema.getCinemaId());
		param.put("pVerifyInfo",pVerifyInfo);
		String getCinemaSession = HttpHelper.httpClientPost(userCinema.getUrl()+"/GetCinemaAllSession", param,"UTF-8");
		System.out.println("排期返回结果：");
		System.out.println(getCinemaSession);
		Gson gson = new GsonBuilder().setDateFormat("HH:mm").create();
		Dy1905GetCinemaAllSessionResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(getCinemaSession,"GetCinemaSessionResult"), Dy1905GetCinemaAllSessionResult.class);
		System.out.println("返回结果已转换XML");
		if(Dy1905Reply.getGetCinemaSessionResult().getResultCode().equals("0")){
			List<SessionBean> dy1905Sessions = Dy1905Reply.getGetCinemaSessionResult().getSessions().getSession();
			if(dy1905Sessions.size()>0){
				List<Sessioninfo> newSessions = new ArrayList();
				for (SessionBean cinemaplan : dy1905Sessions) {
					Sessioninfo session = new Sessioninfo();// 先创建实例
					Dy1905ModelMapper.MaptoEntity(cinemaplan,session);
					session.setCCode(userCinema.getCinemaCode());
					session.setUserID(userCinema.getUserId());
					newSessions.add(session);
				}
			//删除旧的放映信息
			Map<String,Object> params = new HashMap();
			params.put("CCode", userCinema.getCinemaCode());
			params.put("UserId", userCinema.getUserId());
			if(StartDate!=null){
				params.put("StartTime", new SimpleDateFormat("yyyy-MM-dd").format(StartDate));
			}
			if(EndDate!=null){
				params.put("EndTime", new SimpleDateFormat("yyyy-MM-dd").format(EndDate));
			}
			sessioninfoService.deleteByCinemaCode(params);
			//添加新的放映信息
			for(Sessioninfo sessioninfo :newSessions){
				sessioninfoService.save(sessioninfo);
			}
		}
			reply.Status = StatusEnum.Success;
		}else{
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = Dy1905Reply.getGetCinemaSessionResult().getResultCode();
		return reply;
	}
	/*
	 * 查询放映计划中的座位售出状态
	 * */
	@Override
	public CTMSQuerySessionSeatReply QuerySessionSeat(Usercinemaview userCinema, String SessionCode,
			SessionSeatStatusEnum Status) throws Exception {
		CTMSQuerySessionSeatReply reply = new CTMSQuerySessionSeatReply();
		String pVerifyInfo=MD5Util.MD5Encode(userCinema.getDefaultUserName()+SessionCode+userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("pAppCode",userCinema.getDefaultUserName());
		param.put("pSessionID", SessionCode);
		param.put("pVerifyInfo",pVerifyInfo);
		String getSessionSeatResult = HttpHelper.httpClientPost(userCinema.getUrl()+"/GetSessionSeat/v2", param,"UTF-8");
		System.out.println(getSessionSeatResult);
		Gson gson = new Gson();
		Dy1905GetSessionSeatResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(getSessionSeatResult,"GetSessionSeatResult"),Dy1905GetSessionSeatResult.class);
		List<SessionSeatBean> Dy1905SessionSeatList = new ArrayList<SessionSeatBean>();
		List<SessionSeat> SessionSeatList = new ArrayList<SessionSeat>();
		if(Status==null&&Dy1905Reply.getGetSessionSeatResult().getResultCode().equals("0")){
			Dy1905SessionSeatList = Dy1905Reply.getGetSessionSeatResult().getSessionSeats().getSessionSeat();
			for(SessionSeatBean Dy1905SessionSeat :Dy1905SessionSeatList){
				SessionSeat sessionSeats = new SessionSeat();
				sessionSeats.setSeatCode(Dy1905SessionSeat.getSeatNo());
				sessionSeats.setRowNum(Dy1905SessionSeat.getSeatRow());
				sessionSeats.setColumnNum(Dy1905SessionSeat.getSeatCol());
				sessionSeats.setStatus(SessionSeatStatusEnum.All);
				SessionSeatList.add(sessionSeats);
			}
			reply.setSessionSeats(SessionSeatList);
			reply.Status = StatusEnum.Success;
		}else{
		switch(Status.getStatusCode()){
			//所有  ：1 --> 直接返回全部
			case "All":
				if(Dy1905Reply.getGetSessionSeatResult().getResultCode().equals("0")){
					Dy1905SessionSeatList = Dy1905Reply.getGetSessionSeatResult().getSessionSeats().getSessionSeat();
					for(SessionSeatBean Dy1905SessionSeat :Dy1905SessionSeatList){
						SessionSeat sessionSeats = new SessionSeat();
						sessionSeats.setSeatCode(Dy1905SessionSeat.getSeatNo());
						sessionSeats.setRowNum(Dy1905SessionSeat.getSeatRow());
						sessionSeats.setColumnNum(Dy1905SessionSeat.getSeatCol());
						sessionSeats.setStatus(SessionSeatStatusEnum.All);
						SessionSeatList.add(sessionSeats);
					}
					reply.setSessionSeats(SessionSeatList);
					System.out.println();
					reply.Status = StatusEnum.Success;
				}else{
					reply.Status = StatusEnum.Failure;
				}
				break;
				//可售出  ：2 --> 0
			case "Available":
				if(Dy1905Reply.getGetSessionSeatResult().getResultCode().equals("0")){
					Dy1905SessionSeatList = Dy1905Reply.getGetSessionSeatResult().getSessionSeats().getSessionSeat().stream()
					.filter((SessionSeatBean sessionSeat)->sessionSeat.getSeatStatus().equals("0")).collect(Collectors.toList());
					for(SessionSeatBean Dy1905SessionSeat :Dy1905SessionSeatList){
						SessionSeat sessionSeats = new SessionSeat();
						sessionSeats.setSeatCode(Dy1905SessionSeat.getSeatNo());
						sessionSeats.setRowNum(Dy1905SessionSeat.getSeatRow());
						sessionSeats.setColumnNum(Dy1905SessionSeat.getSeatCol());
						sessionSeats.setStatus(SessionSeatStatusEnum.Available);
						SessionSeatList.add(sessionSeats);
					}
					reply.setSessionSeats(SessionSeatList);
					System.out.println();
					reply.Status = StatusEnum.Success;
				}else{
					reply.Status = StatusEnum.Failure;
				}
				break;
				//已锁定  ：3 --> 3
			case "Locked":
				if(Dy1905Reply.getGetSessionSeatResult().getResultCode().equals("0")){
					Dy1905SessionSeatList = Dy1905Reply.getGetSessionSeatResult().getSessionSeats().getSessionSeat().stream()
					.filter((SessionSeatBean sessionSeat)->sessionSeat.getSeatStatus().equals("3")).collect(Collectors.toList());
					for(SessionSeatBean Dy1905SessionSeat :Dy1905SessionSeatList){
						SessionSeat sessionSeats = new SessionSeat();
						sessionSeats.setSeatCode(Dy1905SessionSeat.getSeatNo());
						sessionSeats.setRowNum(Dy1905SessionSeat.getSeatRow());
						sessionSeats.setColumnNum(Dy1905SessionSeat.getSeatCol());
						sessionSeats.setStatus(SessionSeatStatusEnum.Locked);
						SessionSeatList.add(sessionSeats);
					}
					reply.setSessionSeats(SessionSeatList);
					System.out.println();
					reply.Status = StatusEnum.Success;
				}else{
					reply.Status = StatusEnum.Failure;
				}
				break;
				//已售出  ：4 --> 1
			case "Sold":
				if(Dy1905Reply.getGetSessionSeatResult().getResultCode().equals("0")){
					Dy1905SessionSeatList = Dy1905Reply.getGetSessionSeatResult().getSessionSeats().getSessionSeat().stream()
					.filter((SessionSeatBean sessionSeat)->sessionSeat.getSeatStatus().equals("1")).collect(Collectors.toList());
					for(SessionSeatBean Dy1905SessionSeat :Dy1905SessionSeatList){
						SessionSeat sessionSeats = new SessionSeat();
						sessionSeats.setSeatCode(Dy1905SessionSeat.getSeatNo());
						sessionSeats.setRowNum(Dy1905SessionSeat.getSeatRow());
						sessionSeats.setColumnNum(Dy1905SessionSeat.getSeatCol());
						sessionSeats.setStatus(SessionSeatStatusEnum.Sold);
						SessionSeatList.add(sessionSeats);
					}
					reply.setSessionSeats(SessionSeatList);
					System.out.println();
					reply.Status = StatusEnum.Success;
				}else{
					reply.Status = StatusEnum.Failure;
				}
				break;
				//已预定  ：5 --> 没有此状态，返回全部
			case "Booked":
				if(Dy1905Reply.getGetSessionSeatResult().getResultCode().equals("0")){
					Dy1905SessionSeatList = Dy1905Reply.getGetSessionSeatResult().getSessionSeats().getSessionSeat();
					for(SessionSeatBean Dy1905SessionSeat :Dy1905SessionSeatList){
						SessionSeat sessionSeats = new SessionSeat();
						sessionSeats.setSeatCode(Dy1905SessionSeat.getSeatNo());
						sessionSeats.setRowNum(Dy1905SessionSeat.getSeatRow());
						sessionSeats.setColumnNum(Dy1905SessionSeat.getSeatCol());
						sessionSeats.setStatus(SessionSeatStatusEnum.Booked);
						SessionSeatList.add(sessionSeats);
					}
					reply.setSessionSeats(SessionSeatList);
					System.out.println();
					reply.Status = StatusEnum.Success;
				}else{
					reply.Status = StatusEnum.Failure;
				}
				break;	
				//不可用  ：6 --> -1
			case "Unavailable":
				if(Dy1905Reply.getGetSessionSeatResult().getResultCode().equals("0")){
					Dy1905SessionSeatList = Dy1905Reply.getGetSessionSeatResult().getSessionSeats().getSessionSeat().stream()
					.filter((SessionSeatBean sessionSeat)->sessionSeat.getSeatStatus().equals("-1")).collect(Collectors.toList());
					for(SessionSeatBean Dy1905SessionSeat :Dy1905SessionSeatList){
						SessionSeat sessionSeats = new SessionSeat();
						sessionSeats.setSeatCode(Dy1905SessionSeat.getSeatNo());
						sessionSeats.setRowNum(Dy1905SessionSeat.getSeatRow());
						sessionSeats.setColumnNum(Dy1905SessionSeat.getSeatCol());
						sessionSeats.setStatus(SessionSeatStatusEnum.Unavailable);
						SessionSeatList.add(sessionSeats);
					}
					reply.setSessionSeats(SessionSeatList);
					System.out.println();
					reply.Status = StatusEnum.Success;
				}else{
					reply.Status = StatusEnum.Failure;
				}
				break;
			case "Illegal":
				Dy1905SessionSeatList = new ArrayList();
				reply.Status = StatusEnum.Failure;
				break;	
				//非法座位状态  ：0 -->其他状态码
			default:
				Dy1905SessionSeatList = null;
				Status = SessionSeatStatusEnum.Illegal;
				reply.Status = StatusEnum.Failure;
				break;	
		}
		}
		System.out.println("返回给中间件信息"+reply.getSessionSeats().size());
		reply.ErrorCode = Dy1905Reply.getGetSessionSeatResult().getResultCode();
		return reply;
	}
	/*
	 * 锁座
	 * */
	@Override
	public CTMSLockSeatReply LockSeat(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSLockSeatReply reply = new CTMSLockSeatReply();
		Map<String,String> param = new LinkedHashMap<String,String>();
		List<Orderseatdetails> OrderseatdetailsList = order.getOrderSeatDetails();
		param.put("pAppCode",userCinema.getDefaultUserName());
		param.put("pSessionID", order.getOrderBaseInfo().getSessionCode());
		///订单编号由自己生成   20字符（数字字母组合）
		String OrderID = String.valueOf(new Date().getTime());
		for (int i = 0; i < 7; i++) {
            // 得到随机字母
            char c = (char) ((Math.random() * 26) + 97);
            // 拼接成字符串
            OrderID += (c + "");
        }
		param.put("pOrderID",OrderID);
		//循环取出所有的订单编号，结算价，服务费
		String SeatCode = null;
		String TicketPrice = null;
		String Fee = null;
		SeatCode = OrderseatdetailsList.get(0).getSeatCode();
		TicketPrice = String.valueOf(OrderseatdetailsList.get(0).getSalePrice());
		Fee = String.valueOf(OrderseatdetailsList.get(0).getFee());
		if(OrderseatdetailsList.size()>1){
			for(int i=1;i<OrderseatdetailsList.size();i++){
				SeatCode += ","+OrderseatdetailsList.get(i).getSeatCode();
				TicketPrice += ","+OrderseatdetailsList.get(i).getSalePrice();
				Fee += ","+OrderseatdetailsList.get(i).getFee();
			}
		}
			System.out.println(SeatCode+"-----------"+TicketPrice+"------------"+Fee);
				param.put("pSeatNo", SeatCode);
				param.put("pTicketPrice", TicketPrice);
				param.put("pFee", Fee);
		String pVerifyInfo=MD5Util.MD5Encode(userCinema.getDefaultUserName()+order.getOrderBaseInfo().getSessionCode()+OrderID
				+SeatCode+TicketPrice+Fee+userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		param.put("pVerifyInfo",pVerifyInfo);
		System.out.println(userCinema.getDefaultUserName()+"----"+order.getOrderBaseInfo().getSessionCode()+"----"
				+OrderID+"----"+SeatCode+"----"+TicketPrice+"----"+Fee+"----"+pVerifyInfo);
		String checkSeatStateResult = HttpHelper.httpClientPost(userCinema.getUrl()+"/LockSeatCustom", param,"UTF-8");
		System.out.println(checkSeatStateResult);
		////////////////////////////////////////////////
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd")
				.registerTypeAdapter(Integer.class, new IntegerDefaultAdapter())
				.registerTypeAdapter(Double.class, new DoubleDefaultAdapter()).create();
		Dy1905LockSeatCustomResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(checkSeatStateResult,"RealCheckSeatStateResult"),Dy1905LockSeatCustomResult.class);
		List<LockInfo> newLockSeat = new ArrayList();
		Orders orderBaseInfo = new Orders();
		if(Dy1905Reply.getRealCheckSeatStateResult().getResultCode().equals("0")){
			List<SeatInfoBean> dy1905LockSeat = Dy1905Reply.getRealCheckSeatStateResult().getSeatInfos().getSeatInfo();
			orderBaseInfo.setLockOrderCode(Dy1905Reply.getRealCheckSeatStateResult().getOrderNo());
			for(int i=0;i<dy1905LockSeat.size();i++){
				order.getOrderSeatDetails().get(i).setSeatCode(dy1905LockSeat.get(i).getSeatNo());
				order.getOrderSeatDetails().get(i).setPrice(Double.valueOf(dy1905LockSeat.get(i).getTicketPrice()));
				order.getOrderSeatDetails().get(i).setXCoord(Integer.parseInt(dy1905LockSeat.get(i).getSeatRow()));
				order.getOrderSeatDetails().get(i).setYCoord(Integer.parseInt(dy1905LockSeat.get(i).getSeatCol()));
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date(dy1905LockSeat.get(i).getAutoUnlockDatetime() * 1000)));  
				orderBaseInfo.setAutoUnlockDatetime(date);
			}
			order.setOrderBaseInfo(orderBaseInfo);;
			System.out.println("锁座编码"+order.getOrderBaseInfo().getLockOrderCode());
			reply.Status = StatusEnum.Success;
		}else{
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = Dy1905Reply.getRealCheckSeatStateResult().getResultCode();
		return reply;
	}
	/*
	 * 解锁座位
	 * */
	@Override
	public CTMSReleaseSeatReply ReleaseSeat(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSReleaseSeatReply reply = new CTMSReleaseSeatReply();
		//String OrderId = "4561178914eqwew";
		String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + order.getOrderBaseInfo().getLockOrderCode() + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("pAppCode",userCinema.getDefaultUserName());
		param.put("pOrderID",order.getOrderBaseInfo().getLockOrderCode());
		param.put("pVerifyInfo",pVerifyInfo);
		String unLockOrderResult = HttpHelper.httpClientPost(userCinema.getUrl() +"/UnLockSeat",param,"UTF-8");
		System.out.println(unLockOrderResult);
		Gson gson = new Gson();
		Dy1905UnLockSeatResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(unLockOrderResult,"UnLockOrderResult"),Dy1905UnLockSeatResult.class);
		if(Dy1905Reply.getUnLockOrderResult().getResultCode().equals("0")){
			reply.Status = StatusEnum.Success;
		}else{
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = Dy1905Reply.getUnLockOrderResult().getResultCode();
		return reply;
	}
	/*
	 * 提交订单
	 * */
	@Override
	public CTMSSubmitOrderReply SubmitOrder(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSSubmitOrderReply reply = new CTMSSubmitOrderReply();
		List<Orderseatdetails> OrderseatdetailsList = order.getOrderSeatDetails();
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("pAppCode",userCinema.getDefaultUserName());
		param.put("pOrderID",order.getOrderBaseInfo().getLockOrderCode());
		//循环遍历出座位号、结算价、服务费
		String SeatCode = null;
		String TicketPrice = null;
		String Fee = null;
		SeatCode = OrderseatdetailsList.get(0).getSeatCode();
		TicketPrice = String.valueOf(OrderseatdetailsList.get(0).getSalePrice());
		Fee = String.valueOf(OrderseatdetailsList.get(0).getFee());
		if(OrderseatdetailsList.size()>1){
			for(int i=1;i<OrderseatdetailsList.size();i++){
				SeatCode += ","+OrderseatdetailsList.get(i).getSeatCode();
				TicketPrice += ","+OrderseatdetailsList.get(i).getSalePrice();
				Fee += ","+OrderseatdetailsList.get(i).getFee();
			}
		}
				param.put("pSeatNo", SeatCode);
				param.put("pTicketPrice", TicketPrice);
				param.put("pFee", Fee);
		String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + order.getOrderBaseInfo().getLockOrderCode() + SeatCode + TicketPrice + Fee + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		param.put("pVerifyInfo",pVerifyInfo);
		String sellTicketResult = HttpHelper.httpClientPost(userCinema.getUrl() +"/SellTicketCustom/v2",param,"UTF-8");
		System.out.println("订单结果"+sellTicketResult);
		Gson gson = new Gson();
		Dy1905SellTicketCustomResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(sellTicketResult, "SellTicketResult"),Dy1905SellTicketCustomResult.class);
		if(Dy1905Reply.getSellTicketResult().getResultCode().equals("0")){
			order.getOrderBaseInfo().setSubmitOrderCode(Dy1905Reply.getSellTicketResult().getOrderNo());
			order.getOrderBaseInfo().setPrintNo(Dy1905Reply.getSellTicketResult().getPrintNo());
			order.getOrderBaseInfo().setVerifyCode(Dy1905Reply.getSellTicketResult().getVerifyCode());
			System.out.println("订单编码"+order.getOrderBaseInfo().getSubmitOrderCode()+"-----打印编码"+order.getOrderBaseInfo().getPrintNo()+
					"-----验证码"+order.getOrderBaseInfo().getVerifyCode());
			reply.Status = StatusEnum.Success;
		}else{
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = Dy1905Reply.getSellTicketResult().getResultCode();
		return reply;
	}
	/*
	 * 查询出票状态
	 * */
	@Override
	public CTMSQueryPrintReply QueryPrint(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSQueryPrintReply reply = new CTMSQueryPrintReply();
		CTMSQueryTicketReply QueryTicketReply = QueryTicket(userCinema, order);
		reply.Status = QueryTicketReply.Status;
		reply.ErrorCode = QueryTicketReply.ErrorCode;
		return reply;
	}
	/*
	 * 退票
	 * */
	@Override
	public CTMSRefundTicketReply RefundTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSRefundTicketReply reply = new CTMSRefundTicketReply();
		String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + order.getOrderBaseInfo().getLockOrderCode() + order.getOrderBaseInfo().getPrintNo() + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("pAppCode",userCinema.getDefaultUserName());
		param.put("pOrderID",order.getOrderBaseInfo().getLockOrderCode());
		param.put("pPrintNo", order.getOrderBaseInfo().getPrintNo());
		param.put("pVerifyInfo",pVerifyInfo);
		String realCheckSeatStateResult = HttpHelper.httpClientPost(userCinema.getUrl() +"/RefundTicket",param,"UTF-8");
		System.out.println(realCheckSeatStateResult);
		Gson gson = new Gson();
		Dy1905RefundTicketResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(realCheckSeatStateResult, "RealCheckSeatStateResult"), Dy1905RefundTicketResult.class);
		if(Dy1905Reply.getRealCheckSeatStateResult().getResultCode().equals("0")){
			order.getOrderBaseInfo().setSubmitOrderCode(Dy1905Reply.getRealCheckSeatStateResult().getOrderNo());
			order.getOrderBaseInfo().setRefundTime(new Date());
			System.out.println("订单编码"+order.getOrderBaseInfo().getSubmitOrderCode());
			reply.Status = StatusEnum.Success;
		}else{
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = Dy1905Reply.getRealCheckSeatStateResult().getResultCode();
		return reply;
	}
	/*
	 * 查询订单信息
	 * */
	@Override
	public CTMSQueryOrderReply QueryOrder(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSQueryOrderReply reply = new CTMSQueryOrderReply();
		CTMSQueryTicketReply QueryTicketReply = QueryTicket(userCinema, order);
		reply.Status = QueryTicketReply.Status;
		reply.ErrorCode = QueryTicketReply.ErrorCode;
		return reply;
	}
	/*
	 * 查询影票信息
	 * */
	@Override
	public CTMSQueryTicketReply QueryTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSQueryTicketReply reply = new CTMSQueryTicketReply();
		String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + order.getOrderBaseInfo().getLockOrderCode() + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("pAppCode",userCinema.getDefaultUserName());
		param.put("pOrderID",order.getOrderBaseInfo().getLockOrderCode());
		param.put("pVerifyInfo",pVerifyInfo);
		String getOrderStatusResult = HttpHelper.httpClientPost(userCinema.getUrl() +"/GetOrderStatus",param,"UTF-8");
		System.out.println(getOrderStatusResult);
		Gson gson = new Gson();
		Dy1905GetOrderStatusResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(getOrderStatusResult, "GetOrderStatusResult"), Dy1905GetOrderStatusResult.class);
		Orders orderBaseInfo = new Orders();
		if("0".equals(Dy1905Reply.getGetOrderStatusResult().getResultCode())&&
				("0".equals(Dy1905Reply.getGetOrderStatusResult().getOrderStatus())||
				"1".equals(Dy1905Reply.getGetOrderStatusResult().getOrderStatus())||
				"6".equals(Dy1905Reply.getGetOrderStatusResult().getOrderStatus()))
			){
			orderBaseInfo.setPrintStatus(Integer.valueOf(Dy1905Reply.getGetOrderStatusResult().getPrintStatus()));
			if("1".equals(Dy1905Reply.getGetOrderStatusResult().getPrintStatus())){
				orderBaseInfo.setOrderStatus(OrderStatusEnum.Complete.getStatusCode());
				System.out.println("订单已打印");
			}
			//退票状态
			if("1".equals(Dy1905Reply.getGetOrderStatusResult().getRefundStatus())){
				orderBaseInfo.setOrderStatus(OrderStatusEnum.Refund.getStatusCode());
				System.out.println("订单已退票");
			}
			//订单状态
			if("0".equals(Dy1905Reply.getGetOrderStatusResult().getOrderStatus())){
				orderBaseInfo.setOrderStatus(OrderStatusEnum.Locked.getStatusCode());
			}else if("1".equals(Dy1905Reply.getGetOrderStatusResult().getOrderStatus())&&"0".equals(Dy1905Reply.getGetOrderStatusResult().getRefundStatus())){
				orderBaseInfo.setOrderStatus(OrderStatusEnum.Complete.getStatusCode());
			}else if("6".equals(Dy1905Reply.getGetOrderStatusResult().getOrderStatus())){
				orderBaseInfo.setOrderStatus(OrderStatusEnum.Released.getStatusCode());
			}
			if(Dy1905Reply.getGetOrderStatusResult().getSeats()!=null&&Dy1905Reply.getGetOrderStatusResult().getSeats().getSeat()!=null
				&&Dy1905Reply.getGetOrderStatusResult().getSeats().getSeat().size()>0){
				List<SeatBean> seatList = Dy1905Reply.getGetOrderStatusResult().getSeats().getSeat();
				for(int i=1;i<seatList.size();i++){
					order.getOrderSeatDetails().get(i-1).setSeatCode(seatList.get(i-1).getSeatCode());
					order.getOrderSeatDetails().get(i-1).setFilmTicketCode(seatList.get(i-1).getFilmTicketCode());
					order.getOrderBaseInfo().setTotalFee(Double.valueOf(Dy1905Reply.getGetOrderStatusResult().getSeats().getSeat().get(i-1).getCinemaFee())+Double.valueOf(Dy1905Reply.getGetOrderStatusResult().getSeats().getSeat().get(i).getCinemaFee()));
				}
				System.out.println("保存的订单座位数量"+order.getOrderSeatDetails().size());
			}
			order.setOrderBaseInfo(orderBaseInfo);
			reply.Status = StatusEnum.Success;
		}else if("0".equals(Dy1905Reply.getGetOrderStatusResult().getResultCode())&&"2".equals(Dy1905Reply.getGetOrderStatusResult().getOrderStatus())){
			reply.Status = StatusEnum.Failure;
			reply.ErrorMessage = "未知状态(由于网络问题导致的,需要第三方持续查询此订单,直至获取到0,1,6状态为止)";
		}
		else{
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = Dy1905Reply.getGetOrderStatusResult().getResultCode();
		return reply;
	}
	/*
	 * 确认出票
	 * */
	@Override
	public CTMSFetchTicketReply FetchTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSFetchTicketReply reply = new CTMSFetchTicketReply();
		String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + order.getOrderBaseInfo().getSubmitOrderCode() + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("pAppCode",userCinema.getDefaultUserName());
		param.put("pOrderID", order.getOrderBaseInfo().getSubmitOrderCode());
		param.put("pVerifyInfo",pVerifyInfo);
		String updatePrintStatus = HttpHelper.httpClientPost(userCinema.getUrl() +"/UpdatePrintStatus",param,"UTF-8");
		Gson gson = new Gson();
		Dy1905UpdatePrintStatusResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(updatePrintStatus,"UpdatePrintStatus"), Dy1905UpdatePrintStatusResult.class);
		if(Dy1905Reply.getUpdatePrintStatus().getResultCode().equals("0")){
			reply.Status = StatusEnum.Success;
		}else{
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = Dy1905Reply.getUpdatePrintStatus().getResultCode();
		return reply;
	}
	
	//Usercinemaview userCinema
		private static boolean QueryCinemaId(Usercinemaview userCinema) throws Exception
	    {
			String pVerifyInfo=MD5Util.MD5Encode(userCinema.getDefaultUserName()+userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
			Map<String,String> param = new LinkedHashMap<String,String>();
			param.put("pAppCode",userCinema.getDefaultUserName());
			param.put("pVerifyInfo",pVerifyInfo);
			System.out.println("用户名："+userCinema.getDefaultUserName()+"---密码："+userCinema.getDefaultPassword()+"---请求地址："+userCinema.getUrl());
			String getCinemaResult = HttpHelper.httpClientPost(userCinema.getUrl()+"/GetCinema", param,"UTF-8");
			System.out.println(getCinemaResult);
			Gson gson = new Gson();
			Dy1905GetCinemaResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(getCinemaResult,"GetCinemaResult"), Dy1905GetCinemaResult.class);
			System.out.println(Dy1905Reply.getGetCinemaResult().getResultCode());
			if (Dy1905Reply.getGetCinemaResult().getResultCode().equals("0"))
	        {
				List<CinemaBean>  dy1905Cinema= (List<CinemaBean>) Dy1905Reply.getGetCinemaResult().getCinemas().getCinema()
						.stream().filter((CinemaBean cinema)->cinema.getCinemaCode().equals(userCinema.getCinemaCode()))
						.collect(Collectors.toList());
				if (dy1905Cinema!=null)
	            {
					//CinemaServiceImpl _cinemaService=new CinemaServiceImpl();//静态方法内不能直接调用再实例化一次
					CinemaServiceImpl cinemaService = SpringUtil.getBean(CinemaServiceImpl.class);
					 Cinema cinema = cinemaService.getByCinemaCode(userCinema.getCinemaCode());
						cinema.setName(dy1905Cinema.get(0).getCinemaName());
						cinema.setCinemaId(dy1905Cinema.get(0).getCinemaNo());
		                cinemaService.update(cinema);
		                userCinema.setCinemaId(dy1905Cinema.get(0).getCinemaNo());
		                return true;
	            }else
	            {
	                return false;
	            }
	        }
			else{
				return false;
			}
	    }
	@Test
	public void test() throws Exception{
		Dy1905Interface d= new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		//userCinema.setCinemaId("194");
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setUrl("http://netsale.1905.com/Api");
		//userCinema.setCinemaCode("33097601");
		//33097601
		/*userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sd = sdf.format(date);
		Date StartDate = sdf.parse(sd);*/
		//System.out.println(d.QueryFilm(userCinema, null, null));
		//userCinema.setCinemaId("194");
		/*Screeninfo screen = new Screeninfo();
		screen.setScreenId("1078");*/
		//System.out.println(d.QuerySeat(userCinema, screen));
		//System.out.println(d.QueryCinema(userCinema));
		System.out.println(d.QuerySession(userCinema, null, null));
		//System.out.println(d.LockSeat(userCinema, null));
		//System.out.println(d.ReleaseSeat(userCinema, null));
		//System.out.println(d.QuerySessionSeat(userCinema, "2992797", null));
	}
	
	@Test
	public void test2(){
		OrderView order = new OrderView();
		Orders od= new Orders();
		order.setOrderBaseInfo(od);
		String SeatCode = null;
		String TicketPrice = null;
		String Fee = null;
		Map<String,String> param = new LinkedHashMap<String,String>();
		List<Orderseatdetails> OrderseatdetailsList = new ArrayList();
		Orderseatdetails seat = new Orderseatdetails();
		seat.setSeatCode("123");
		seat.setSalePrice(Double.valueOf("30.00"));
		seat.setFee(Double.valueOf("5.00"));
		Orderseatdetails seat1 = new Orderseatdetails();
		seat1.setSeatCode("456");
		seat1.setSalePrice(Double.valueOf("50.00"));
		seat1.setFee(Double.valueOf("10.00"));
		Orderseatdetails seat2 = new Orderseatdetails();
		seat2.setSeatCode("789");
		seat2.setSalePrice(Double.valueOf("80.00"));
		seat2.setFee(Double.valueOf("15.00"));
		OrderseatdetailsList.add(seat);
		OrderseatdetailsList.add(seat1);
		OrderseatdetailsList.add(seat2);
		System.out.println(OrderseatdetailsList.size());
			SeatCode = OrderseatdetailsList.get(0).getSeatCode();
			TicketPrice = String.valueOf(OrderseatdetailsList.get(0).getSalePrice());
			Fee = String.valueOf(OrderseatdetailsList.get(0).getFee());
			if(OrderseatdetailsList.size()>1){
				for(int i=1;i<OrderseatdetailsList.size();i++){
					SeatCode += ","+OrderseatdetailsList.get(i).getSeatCode();
					TicketPrice += ","+OrderseatdetailsList.get(i).getSalePrice();
					Fee += ","+OrderseatdetailsList.get(i).getFee();
				}
			}
			System.out.println(SeatCode+"-----------"+TicketPrice+"------------"+Fee);
			param.put("pSeatNo", SeatCode);
			param.put("pTicketPrice", TicketPrice);
			param.put("pFee", Fee);
			System.out.println(param);
	}
	/*
	 * 锁定座位测试方法
	 * */
	public CTMSLockSeatReply Lockasas(Usercinemaview userCinema,OrderView order){
		Map<String,String> param = new LinkedHashMap<String,String>();
		String SeatCode = "115366";
		Double TicketPrice = 50.00;
		Double Fee = 10.00;
		String SessionID = "3045669"; 
		String OrderID = "20190404qwer";
		String pVerifyInfo=MD5Util.MD5Encode(userCinema.getDefaultUserName()+SessionID+OrderID
				+SeatCode+TicketPrice+Fee+userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		param.put("pAppCode",userCinema.getDefaultUserName());
		param.put("pSessionID", SessionID);
		param.put("pOrderID", OrderID);
		param.put("pSeatNo", SeatCode);
		param.put("pTicketPrice", String.valueOf(TicketPrice));
		param.put("pFee", String.valueOf(Fee));
		param.put("pVerifyInfo",pVerifyInfo);
		String checkSeatStateResult = HttpHelper.httpClientPost("http://netsale.1905.com/Api/LockSeatCustom", param,"UTF-8");
		System.out.println(checkSeatStateResult);
		return null;
	}
	@Test
	public void LockTest() throws Exception{
		Dy1905Interface d= new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		OrderView order = new OrderView();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		Orders od = new Orders();
		od.setSessionCode("3045669");
		order.setOrderBaseInfo(od);
		List<Orderseatdetails> osList = new ArrayList<Orderseatdetails>();
		Orderseatdetails os = new Orderseatdetails();
		Orderseatdetails os1 = new Orderseatdetails();
		Orderseatdetails os2 = new Orderseatdetails();
		os.setSeatCode("115384");
		os.setSalePrice(50.00);
		os.setFee(10.00);
		os1.setSeatCode("115385");
		os1.setSalePrice(50.00);
		os1.setFee(10.00);
		os2.setSeatCode("115386");
		os2.setSalePrice(50.00);
		os2.setFee(10.00);
		osList.add(os);
		osList.add(os1);
		osList.add(os2);
		order.setOrderSeatDetails(osList);
		for(int i=0;i<osList.size();i++){
			System.out.println(osList.get(i));
		}
		System.out.println(d.LockSeat(userCinema, order));
	}
}
