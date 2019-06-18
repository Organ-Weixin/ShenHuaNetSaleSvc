package com.boot.security.server.api.ctms.reply;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.boot.security.server.api.ctms.reply.Dy1905GetCinemaAllSessionResult.ResBean.SessionsBean.SessionBean;
import com.boot.security.server.api.ctms.reply.Dy1905GetCinemaAllSessionResult.ResBean.SessionsBean.SessionBean.FilmsBean.SessionFilmBean;
import com.boot.security.server.api.ctms.reply.Dy1905GetCinemaResult.ResBean.CinemasBean.CinemaBean;
import com.boot.security.server.api.ctms.reply.Dy1905GetFeatureFilmResult.ResBean.FilmsBean.FilmBean;
import com.boot.security.server.api.ctms.reply.Dy1905GetOrderStatusResult.ResBean.SeatsBean.SeatBean;
import com.boot.security.server.api.ctms.reply.Dy1905GetScreenResult.ResBean.ScreensBean.ScreenBean;
import com.boot.security.server.api.ctms.reply.Dy1905GetScreenSeatResult.ResBean.ScreenSeatsBean.ScreenSeatBean;
import com.boot.security.server.api.ctms.reply.Dy1905GetSessionSeatResult.ResBean.SessionSeatsBean.SessionSeatBean;
import com.boot.security.server.api.ctms.reply.Dy1905GoodsListResult.ResBean.GoodsBean.GoodBean;
import com.boot.security.server.api.ctms.reply.Dy1905LockSeatCustomResult.ResBean.SeatInfosBean.SeatInfoBean;
import com.boot.security.server.api.ctms.reply.Dy1905MakeMemberCardResult.ResBean.CardInfoBean;
import com.boot.security.server.api.ctms.reply.Dy1905MemberTypeListResult.ResBean.TypesBean.TypeBean.LevelsBean.LevelBean;
import com.boot.security.server.apicontroller.reply.GoodsOrderMemberReply;
import com.boot.security.server.apicontroller.reply.MemberCardPayReply;
import com.boot.security.server.apicontroller.reply.SellTicketCustomMemberReply;
import com.boot.security.server.model.CardChargeTypeEnum;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.CinemaMiniProgramAccounts;
import com.boot.security.server.model.CouponsStatusEnum;
import com.boot.security.server.model.CouponsView;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Goods;
import com.boot.security.server.model.GoodsOrderStatusEnum;
import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodsorderdetails;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.LoveFlagEnum;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.model.Membercardlevel;
import com.boot.security.server.model.OrderPayTypeEnum;
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
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaMiniProgramAccountsServiceImpl;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.GoodsOrderServiceImpl;
import com.boot.security.server.service.impl.GoodsServiceImpl;
import com.boot.security.server.service.impl.GoodsorderdetailsServiceImpl;
import com.boot.security.server.service.impl.MemberCardLevelServiceImpl;
import com.boot.security.server.service.impl.MemberCardServiceImpl;
import com.boot.security.server.service.impl.OrderServiceImpl;
import com.boot.security.server.service.impl.OrderseatdetailsServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.ScreenseatinfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.service.impl.UserCinemaViewServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.boot.security.server.utils.GoodsCouponsPriceUtil;
import com.boot.security.server.utils.HttpHelper;
import com.boot.security.server.utils.MD5Util;
import com.boot.security.server.utils.SpringUtil;
import com.boot.security.server.utils.XmlToJsonUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oristartech.tsp.ws.soap.DoubleDefaultAdapter;
import com.oristartech.tsp.ws.soap.IntegerDefaultAdapter;
public class Dy1905Interface implements ICTMSInterface {
	
	CinemaServiceImpl cinemaService = SpringUtil.getBean(CinemaServiceImpl.class);
	ScreeninfoServiceImpl screeninfoService = SpringUtil.getBean(ScreeninfoServiceImpl.class);
	ScreenseatinfoServiceImpl screenseatinfoService = SpringUtil.getBean(ScreenseatinfoServiceImpl.class);
	SessioninfoServiceImpl sessioninfoService = SpringUtil.getBean(SessioninfoServiceImpl.class);
	FilminfoServiceImpl filminfoService = SpringUtil.getBean(FilminfoServiceImpl.class);
	MemberCardServiceImpl memberCardService = SpringUtil.getBean(MemberCardServiceImpl.class);
	MemberCardLevelServiceImpl memberCardLevelService = SpringUtil.getBean(MemberCardLevelServiceImpl.class);
	GoodsServiceImpl goodsService = SpringUtil.getBean(GoodsServiceImpl.class);
	GoodsOrderServiceImpl goodsOrderService = SpringUtil.getBean(GoodsOrderServiceImpl.class);
	GoodsorderdetailsServiceImpl goodsorderdetailsService = SpringUtil.getBean(GoodsorderdetailsServiceImpl.class);
	UserCinemaViewServiceImpl userCinemaViewService = SpringUtil.getBean(UserCinemaViewServiceImpl.class);
	OrderServiceImpl orderService = SpringUtil.getBean(OrderServiceImpl.class);
	OrderseatdetailsServiceImpl orderseatdetailsService = SpringUtil.getBean(OrderseatdetailsServiceImpl.class);
	UserInfoServiceImpl userInfoService = SpringUtil.getBean(UserInfoServiceImpl.class);
	CinemaMiniProgramAccountsServiceImpl cinemaMiniProgramAccountsService = SpringUtil.getBean(CinemaMiniProgramAccountsServiceImpl.class);
	CouponsServiceImpl _couponsService = SpringUtil.getBean(CouponsServiceImpl.class);
	/*
	 * 查询影院信息（完成）
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
		Gson gson = new Gson();
		Dy1905GetScreenResult Dy1905Reply=gson.fromJson(XmlToJsonUtil.xmltoJson(getScreenResult,"GetScreenResult"), Dy1905GetScreenResult.class);
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
	 *	查询影厅中的座位信息（完成）
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
	 * 	查询即将放映的影片（完成）
	 * */
	@Override
	public CTMSQueryFilmReply QueryFilm(Usercinemaview userCinema, Date StartDate, Date EndDate) throws Exception {
		CTMSQueryFilmReply reply = new CTMSQueryFilmReply();
		String pVerifyInfo=MD5Util.MD5Encode(userCinema.getDefaultUserName()+userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("pAppCode",userCinema.getDefaultUserName());
		param.put("pVerifyInfo",pVerifyInfo);
		String getFeatureFilmResult = HttpHelper.httpClientPost(userCinema.getUrl()+"/GetFeatureFilm", param,"UTF-8");
		Gson gson = new Gson();
		Dy1905GetFeatureFilmResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(getFeatureFilmResult,"GetFeatureFilmResult"),Dy1905GetFeatureFilmResult.class);
		if(Dy1905Reply.getGetFeatureFilmResult().getResultCode().equals("0")){
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("CCode", userCinema.getCinemaCode());
			if(StartDate!=null){
				params.put("StartTime", new SimpleDateFormat("yyyy-MM-dd").format(StartDate));
			}
			if(EndDate!=null){
				params.put("EndTime", new SimpleDateFormat("yyyy-MM-dd").format(EndDate));
			}
			List<FilmBean> filmReplyList = Dy1905Reply.getGetFeatureFilmResult().getFilms().getFilm();
			List<Filminfo> filminfoList = new ArrayList<Filminfo>();
			for(FilmBean filmReply:filmReplyList){
				Filminfo filminfo = filminfoService.getByFilmCode(filmReply.getFilmCode());
				if(filminfo==null){
					filminfo = new Filminfo();
					filminfo.setFilmCode(filmReply.getFilmCode());
					filminfo.setFilmName(filmReply.getFilmName());
					filminfo.setVersion(filmReply.getFilmType());
					filminfo.setLanguage(filmReply.getLanguage());
					filminfoService.save(filminfo);
				}else{
					filminfo = new Filminfo();
					filminfo.setFilmCode(filmReply.getFilmCode());
					filminfo.setFilmName(filmReply.getFilmName());
					filminfo.setVersion(filmReply.getFilmType());
					filminfo.setLanguage(filmReply.getLanguage());
					filminfoService.update(filminfo);
				}
				filminfoList.add(filminfo);
			}
				reply.setFilms(filminfoList);
				
				reply.Status = StatusEnum.Success;
			}else{
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = Dy1905Reply.getGetFeatureFilmResult().getResultCode();
		return reply;
	}
	/*
	 * 	查询排期（完成）
	 * */
	@Override
	public CTMSQuerySessionReply QuerySession(Usercinemaview userCinema, Date StartDate,Date EndDate)
			throws Exception {
		CTMSQuerySessionReply reply = new CTMSQuerySessionReply();
		String pVerifyInfo=MD5Util.MD5Encode(userCinema.getDefaultUserName()+userCinema.getCinemaId()+userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("pAppCode",userCinema.getDefaultUserName());
		param.put("pCinemaID",userCinema.getCinemaId());
		param.put("pVerifyInfo",pVerifyInfo);
		String getCinemaSession = HttpHelper.httpClientPost(userCinema.getUrl()+"/GetCinemaAllSession", param,"UTF-8");
		Gson gson = new GsonBuilder().setDateFormat("HH:mm").create();
		Dy1905GetCinemaAllSessionResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(getCinemaSession,"GetCinemaSessionResult"), Dy1905GetCinemaAllSessionResult.class);
		QueryFilm(userCinema, StartDate, EndDate);
		String getFeatureFilmResult = HttpHelper.httpClientPost(userCinema.getUrl()+"/GetFeatureFilm", param,"UTF-8");
		Gson filmgson = new Gson();
		Dy1905GetFeatureFilmResult Dy1905FilmReply = filmgson.fromJson(XmlToJsonUtil.xmltoJson(getFeatureFilmResult,"GetFeatureFilmResult"),Dy1905GetFeatureFilmResult.class);
		if(Dy1905Reply.getGetCinemaSessionResult().getResultCode().equals("0")){
			List<SessionBean> dy1905Sessions = Dy1905Reply.getGetCinemaSessionResult().getSessions().getSession();
			List<FilmBean> filmReplyList = Dy1905FilmReply.getGetFeatureFilmResult().getFilms().getFilm();
			for(int i=0;i<dy1905Sessions.size();i++){
				List<SessionFilmBean> sessionFilmReplyList = Dy1905Reply.getGetCinemaSessionResult().getSessions().getSession().get(i).getFilms().getFilm();
				for(int m=0; m<sessionFilmReplyList.size(); m++){
					for(int n=0; n<filmReplyList.size(); n++){
						if(sessionFilmReplyList.get(m).getFilmNo().equals(filmReplyList.get(n).getFilmNo())){
							sessionFilmReplyList.get(m).setFilmNo(filmReplyList.get(n).getFilmCode());
						}
					}
				}
			}
			if(dy1905Sessions.size()>0){
				List<Sessioninfo> newSessions = new ArrayList<Sessioninfo>();
				for (SessionBean cinemaplan : dy1905Sessions) {
					if((cinemaplan.getSessionDate().getTime()+cinemaplan.getStartTime().getTime())>=StartDate.getTime()&&(cinemaplan.getSessionDate().getTime()+cinemaplan.getStartTime().getTime())<=(EndDate.getTime()+24*60*60*1000)){
						Screeninfo screen = screeninfoService.getByScreenId(userCinema.getCinemaCode(), cinemaplan.getScreenNo());
						Sessioninfo session = new Sessioninfo();// 先创建实例
						Dy1905ModelMapper.MaptoEntity(cinemaplan,session);
						session.setScreenCode(screen.getSCode());
						session.setCCode(userCinema.getCinemaCode());
						session.setUserID(userCinema.getUserId());
						newSessions.add(session);
					}
				}
			//删除旧的放映信息
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("CCode", userCinema.getCinemaCode());
			params.put("UserId", userCinema.getUserId());
			if(StartDate!=null){
				params.put("StartTime", new SimpleDateFormat("yyyy-MM-dd").format(StartDate));
			}
			if(EndDate!=null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String sd = sdf.format(new Date(Long.parseLong(String.valueOf(EndDate.getTime()+24*60*60*1000))));
				params.put("EndTime", new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyy-MM-dd").parse(sd)));
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
	 * 查询放映计划中的座位售出状态（完成）
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
				if(Dy1905SessionSeat.getSeatStatus().equals("0")){
					sessionSeats.setStatus(SessionSeatStatusEnum.Available);
				}
				if(Dy1905SessionSeat.getSeatStatus().equals("-1")){
					sessionSeats.setStatus(SessionSeatStatusEnum.Unavailable);
				}
				if(Dy1905SessionSeat.getSeatStatus().equals("1")){
					sessionSeats.setStatus(SessionSeatStatusEnum.Sold);
				}
				if(Dy1905SessionSeat.getSeatStatus().equals("3")){
					sessionSeats.setStatus(SessionSeatStatusEnum.Locked);
				}
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
						if(Dy1905SessionSeat.getSeatStatus().equals("0")){
							sessionSeats.setStatus(SessionSeatStatusEnum.Available);
						}
						if(Dy1905SessionSeat.getSeatStatus().equals("-1")){
							sessionSeats.setStatus(SessionSeatStatusEnum.Unavailable);
						}
						if(Dy1905SessionSeat.getSeatStatus().equals("1")){
							sessionSeats.setStatus(SessionSeatStatusEnum.Sold);
						}
						if(Dy1905SessionSeat.getSeatStatus().equals("3")){
							sessionSeats.setStatus(SessionSeatStatusEnum.Locked);
						}
						SessionSeatList.add(sessionSeats);
					}
					reply.setSessionSeats(SessionSeatList);
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
					reply.Status = StatusEnum.Success;
				}else{
					reply.Status = StatusEnum.Failure;
				}
				break;
			case "Illegal":
				Dy1905SessionSeatList = new ArrayList<SessionSeatBean>();
				reply.Status = StatusEnum.Failure;
				break;	
				//非法座位状态  ：0 -->其他状态码
			default:
				Dy1905SessionSeatList = new ArrayList<SessionSeatBean>();
				Status = SessionSeatStatusEnum.Illegal;
				reply.Status = StatusEnum.Failure;
				break;	
		}
		}
		reply.ErrorCode = Dy1905Reply.getGetSessionSeatResult().getResultCode();
		return reply;
	}
	/*
	 * 锁座（完成）
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
				param.put("pSeatNo", SeatCode);
				param.put("pTicketPrice", TicketPrice);
				param.put("pFee", Fee);
		String pVerifyInfo=MD5Util.MD5Encode(userCinema.getDefaultUserName()+order.getOrderBaseInfo().getSessionCode()+OrderID
				+SeatCode+TicketPrice+Fee+userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		param.put("pVerifyInfo",pVerifyInfo);
		String checkSeatStateResult = HttpHelper.httpClientPost(userCinema.getUrl()+"/LockSeatCustom", param,"UTF-8");
		System.out.println("锁座订单"+checkSeatStateResult);
		////////////////////////////////////////////////
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd")
				.registerTypeAdapter(Integer.class, new IntegerDefaultAdapter())
				.registerTypeAdapter(Double.class, new DoubleDefaultAdapter()).create();
		Dy1905LockSeatCustomResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(checkSeatStateResult,"RealCheckSeatStateResult"),Dy1905LockSeatCustomResult.class);
		if(Dy1905Reply.getRealCheckSeatStateResult().getResultCode().equals("0")){
			List<SeatInfoBean> dy1905LockSeat = Dy1905Reply.getRealCheckSeatStateResult().getSeatInfos().getSeatInfo();
			order.getOrderBaseInfo().setLockOrderCode(Dy1905Reply.getRealCheckSeatStateResult().getOrderNo());
			order.getOrderBaseInfo().setTicketCount(dy1905LockSeat.size());
			order.getOrderBaseInfo().setScreenCode(order.getOrderBaseInfo().getScreenCode());
			order.getOrderBaseInfo().setLockTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
			for(int i=0;i<dy1905LockSeat.size();i++){
				order.getOrderSeatDetails().get(i).setSeatCode(dy1905LockSeat.get(i).getSeatNo());
				order.getOrderSeatDetails().get(i).setPrice(Double.valueOf(dy1905LockSeat.get(i).getTicketPrice()));
				order.getOrderSeatDetails().get(i).setXCoord(Integer.parseInt(dy1905LockSeat.get(i).getSeatRow()));
				order.getOrderSeatDetails().get(i).setYCoord(Integer.parseInt(dy1905LockSeat.get(i).getSeatCol()));
				Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(dy1905LockSeat.get(i).getAutoUnlockDatetime() * 1000)));  
				order.getOrderBaseInfo().setAutoUnlockDatetime(date);
			}
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Locked.getStatusCode());
			reply.Status = StatusEnum.Success;
		}else{
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = Dy1905Reply.getRealCheckSeatStateResult().getResultCode();
		return reply;
	}
	/*
	 * 解锁座位（完成）
	 * */
	@Override
	public CTMSReleaseSeatReply ReleaseSeat(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSReleaseSeatReply reply = new CTMSReleaseSeatReply();
		String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + order.getOrderBaseInfo().getLockOrderCode() + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("pAppCode",userCinema.getDefaultUserName());
		param.put("pOrderID",order.getOrderBaseInfo().getLockOrderCode());
		param.put("pVerifyInfo",pVerifyInfo);
		String unLockOrderResult = HttpHelper.httpClientPost(userCinema.getUrl() +"/UnLockSeat",param,"UTF-8");
		System.out.println("解锁座位"+unLockOrderResult);
		Gson gson = new Gson();
		Dy1905UnLockSeatResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(unLockOrderResult,"UnLockOrderResult"),Dy1905UnLockSeatResult.class);
		if(Dy1905Reply.getUnLockOrderResult().getResultCode().equals("0")){
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Released.getStatusCode());
			reply.Status = StatusEnum.Success;
		}else{
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.ReleaseFail.getStatusCode());
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = Dy1905Reply.getUnLockOrderResult().getResultCode();
		return reply;
	}
	/*
	 * 提交订单（完成）
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
		Gson gson = new Gson();
		Dy1905SellTicketCustomResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(sellTicketResult, "SellTicketResult"),Dy1905SellTicketCustomResult.class);
		if(Dy1905Reply.getSellTicketResult().getResultCode().equals("0")){
			order.getOrderBaseInfo().setSubmitOrderCode(Dy1905Reply.getSellTicketResult().getOrderNo());
			order.getOrderBaseInfo().setPrintNo(Dy1905Reply.getSellTicketResult().getPrintNo());
			order.getOrderBaseInfo().setVerifyCode(Dy1905Reply.getSellTicketResult().getVerifyCode());
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Complete.getStatusCode());
			order.getOrderBaseInfo().setSubmitTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
			reply.Status = StatusEnum.Success;
		}else{
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.SubmitFail.getStatusCode());
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = Dy1905Reply.getSellTicketResult().getResultCode();
		return reply;
	}
	/*
	 * 查询出票状态（完成）
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
	 * 退票（完成）
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
		Gson gson = new Gson();
		Dy1905RefundTicketResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(realCheckSeatStateResult, "RealCheckSeatStateResult"), Dy1905RefundTicketResult.class);
		if(Dy1905Reply.getRealCheckSeatStateResult().getResultCode().equals("0")){
			//order.getOrderBaseInfo().setSubmitOrderCode(Dy1905Reply.getRealCheckSeatStateResult().getOrderNo());
			order.getOrderBaseInfo().setRefundTime(new Date());
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Refund.getStatusCode());
			reply.Status = StatusEnum.Success;
		}else{
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = Dy1905Reply.getRealCheckSeatStateResult().getResultCode();
		return reply;
	}
	/*
	 * 查询订单信息（完成）
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
	 * 查询影票信息（完成）
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
		Gson gson = new Gson();
		Dy1905GetOrderStatusResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(getOrderStatusResult, "GetOrderStatusResult"), Dy1905GetOrderStatusResult.class);
		if("0".equals(Dy1905Reply.getGetOrderStatusResult().getResultCode())&&
				("0".equals(Dy1905Reply.getGetOrderStatusResult().getOrderStatus())||
				"1".equals(Dy1905Reply.getGetOrderStatusResult().getOrderStatus())||
				"6".equals(Dy1905Reply.getGetOrderStatusResult().getOrderStatus()))
			){
			order.getOrderBaseInfo().setPrintStatus(Integer.valueOf(Dy1905Reply.getGetOrderStatusResult().getPrintStatus()));
			if("1".equals(Dy1905Reply.getGetOrderStatusResult().getPrintStatus())){
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Complete.getStatusCode());
			}
			//退票状态
			if("1".equals(Dy1905Reply.getGetOrderStatusResult().getRefundStatus())){
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Refund.getStatusCode());
			}
			//订单状态
			if("0".equals(Dy1905Reply.getGetOrderStatusResult().getOrderStatus())){
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Locked.getStatusCode());
			}else if("1".equals(Dy1905Reply.getGetOrderStatusResult().getOrderStatus())
					&&"0".equals(Dy1905Reply.getGetOrderStatusResult().getRefundStatus())
					&&"1".equals(Dy1905Reply.getGetOrderStatusResult().getPrintStatus())){
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Complete.getStatusCode());
			}else if("6".equals(Dy1905Reply.getGetOrderStatusResult().getOrderStatus())){
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Released.getStatusCode());
			}
			if(Dy1905Reply.getGetOrderStatusResult().getSeats()!=null&&Dy1905Reply.getGetOrderStatusResult().getSeats().getSeat()!=null
				&&Dy1905Reply.getGetOrderStatusResult().getSeats().getSeat().size()>0){
				List<SeatBean> seatList = Dy1905Reply.getGetOrderStatusResult().getSeats().getSeat();
				for(int i=1;i<seatList.size();i++){
					order.getOrderSeatDetails().get(i-1).setSeatCode(seatList.get(i-1).getSeatCode());
					order.getOrderSeatDetails().get(i-1).setFilmTicketCode(seatList.get(i-1).getFilmTicketCode());
					order.getOrderBaseInfo().setTotalFee(Double.valueOf(Dy1905Reply.getGetOrderStatusResult().getSeats().getSeat().get(i-1).getCinemaFee())+Double.valueOf(Dy1905Reply.getGetOrderStatusResult().getSeats().getSeat().get(i).getCinemaFee()));
				}
			}
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
	 * 确认出票（完成）
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
		if(Dy1905Reply.getUpdatePrintStatusResult().getResultCode().equals("0")){
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Complete.getStatusCode());
			order.getOrderBaseInfo().setPrintStatus(1);
			order.getOrderBaseInfo().setPrintTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
			reply.Status = StatusEnum.Success;
		}else{
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = Dy1905Reply.getUpdatePrintStatusResult().getResultCode();
		return reply;
	}
	
	//Usercinemaview userCinema
		private static boolean QueryCinemaId(Usercinemaview userCinema) throws Exception
	    {
			String pVerifyInfo=MD5Util.MD5Encode(userCinema.getDefaultUserName()+userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
			Map<String,String> param = new LinkedHashMap<String,String>();
			param.put("pAppCode",userCinema.getDefaultUserName());
			param.put("pVerifyInfo",pVerifyInfo);
			String getCinemaResult = HttpHelper.httpClientPost(userCinema.getUrl()+"/GetCinema", param,"UTF-8");
			Gson gson = new Gson();
			Dy1905GetCinemaResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(getCinemaResult,"GetCinemaResult"), Dy1905GetCinemaResult.class);
			if (Dy1905Reply.getGetCinemaResult().getResultCode().equals("0"))
	        {
				List<CinemaBean>  dy1905Cinema= (List<CinemaBean>) Dy1905Reply.getGetCinemaResult().getCinemas().getCinema()
						.stream().filter((CinemaBean cinema)->cinema.getCinemaCode().equals(userCinema.getCinemaCode()))
						.collect(Collectors.toList());
				if (dy1905Cinema!=null)
	            {
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
		
		/*
		 * 会员卡接口
		 * */
		
		
		/*
		 *  登陆会员卡（完成）
		 * */
		@Override
		public CTMSLoginCardReply LoginCard(Usercinemaview userCinema, String CardNo, String CardPassword)
				throws Exception {
			CTMSLoginCardReply reply = new CTMSLoginCardReply();
			CTMSQueryCardReply queryCardReply = QueryCard(userCinema, CardNo, CardPassword);
			reply.Status = queryCardReply.Status;
			reply.ErrorCode = queryCardReply.ErrorCode;
			reply.ErrorMessage = queryCardReply.ErrorMessage;
			return reply;
		}
		
		/*
		 *  查询会员卡（完成）
		 * */
		@Override
		public CTMSQueryCardReply QueryCard(Usercinemaview userCinema, String CardNo, String CardPassword)
				throws Exception {
			CTMSQueryCardReply reply = new CTMSQueryCardReply();
			String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + userCinema.getCinemaId() + CardNo + CardPassword + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
			Map<String,String> param = new LinkedHashMap<String,String>();
			param.put("pAppCode", userCinema.getDefaultUserName());
			param.put("pCinemaID", userCinema.getCinemaId());
			param.put("pCardNo", CardNo);
			param.put("pCardPwd", CardPassword);
			param.put("pVerifyInfo", pVerifyInfo);
			String MemberInfoResult = HttpHelper.httpClientPost(userCinema.getUrl() +"/MemberInfo",param,"UTF-8");
			Gson gson = new Gson();
			Dy1905MemberInfoResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(MemberInfoResult,"MemberInfoResult"), Dy1905MemberInfoResult.class);
			com.boot.security.server.api.ctms.reply.Dy1905MemberInfoResult.ResBean.CardInfoBean cardInfo = Dy1905Reply.getMemberInfoResult().getCardInfo();
			if(Dy1905Reply.getMemberInfoResult().getResultCode().equals("0")){
				Membercard membercard = memberCardService.getByCardNo(userCinema.getCinemaCode(), CardNo);
				Cinema cinema = cinemaService.getByCinemaCode(userCinema.getCinemaCode());
				String cinemacodes = "";
				//门店通用
				if(cinema!=null&&cinema.getIsGeneralStore()!=null){
					if(cinema.getIsGeneralStore().equals("1")){
						CinemaMiniProgramAccounts cinemaMiniProgramAccounts = cinemaMiniProgramAccountsService.getByCinemaCode(userCinema.getCinemaCode());
				    	if(cinemaMiniProgramAccounts!=null){
				    		List<CinemaMiniProgramAccounts> cinemaMiniProgramAccountsList = cinemaMiniProgramAccountsService.getByAppId(cinemaMiniProgramAccounts.getAppId());
				    		if(cinemaMiniProgramAccountsList.size()>0){
				    			for(int i=0; i<cinemaMiniProgramAccountsList.size(); i++){
				    				cinemacodes +=cinemaMiniProgramAccountsList.get(i).getCinemaCode()+",";
				    			}
				    		}
				    	}
					}
				}
				if(membercard==null){
					membercard = new Membercard();
					membercard.setCinemaCodes(cinemacodes.substring(0,cinemacodes.length()-1));
					membercard.setCinemaCode(userCinema.getCinemaCode());
					membercard.setCardPassword(CardPassword);
					membercard.setMobilePhone(cardInfo.getMobile());
					membercard.setLevelCode(cardInfo.getCardLevelNo());
					membercard.setLevelName(cardInfo.getCardLevel());
					membercard.setUserName(cardInfo.getUsername());
					membercard.setCardNo(cardInfo.getCardNo());
					membercard.setBalance(cardInfo.getBalance());
					Date ExpireDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.valueOf(cardInfo.getExpireDate()) * 1000)));  
					membercard.setExpireDate(ExpireDate);
					membercard.setCreateTime(new Date());
					membercard.setUpdated(new Date());
					memberCardService.Save(membercard);
				}else{
					membercard.setCinemaCode(userCinema.getCinemaCode());
					membercard.setCardPassword(CardPassword);
					membercard.setMobilePhone(cardInfo.getMobile());
					membercard.setLevelCode(cardInfo.getCardLevelNo());
					membercard.setLevelName(cardInfo.getCardLevel());
					membercard.setUserName(cardInfo.getUsername());
					membercard.setCardNo(cardInfo.getCardNo());
					membercard.setBalance(cardInfo.getBalance());
					Date ExpireDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.valueOf(cardInfo.getExpireDate()) * 1000)));  
					membercard.setExpireDate(ExpireDate);
					membercard.setCreateTime(new Date());
					membercard.setUpdated(new Date());
					memberCardService.Update(membercard);
				}
				reply.Status = StatusEnum.Success;
			}else{
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = Dy1905Reply.getMemberInfoResult().getResultCode();
			reply.ErrorMessage = Dy1905Reply.getMemberInfoResult().getResultMsg();
			return reply;
		}
		/*
		 * 查询会员卡折扣（完成）
		 * */
		@Override
		public CTMSQueryDiscountReply QueryDiscount(Usercinemaview userCinema, String TicketCount, String CardNo,
				String CardPassword, String LevelCode, String SessionCode, String SessionTime, String FilmCode,
				String ScreenType, String ListingPrice, String LowestPrice) throws Exception {
			CTMSQueryDiscountReply reply = new CTMSQueryDiscountReply();
			String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + SessionCode + CardNo + CardPassword + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
			Map<String,String> param = new LinkedHashMap<String,String>();
			param.put("pAppCode", userCinema.getDefaultUserName());
			param.put("pSessionID", SessionCode);
			param.put("pCardNo", CardNo);
			param.put("pCardPwd", CardPassword);
			param.put("pVerifyInfo", pVerifyInfo);
			String MemberPriceResult = HttpHelper.httpClientPost(userCinema.getUrl() +"/MemberPrice",param,"UTF-8");
			System.out.println(MemberPriceResult);
			Gson gson = new Gson();
			Dy1905MemberPriceResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(MemberPriceResult,"MemberPriceResult"), Dy1905MemberPriceResult.class);
			if(Dy1905Reply.getMemberPriceResult().getResultCode().equals("0")){
				reply.setCinemaCode(userCinema.getCinemaCode());
				reply.setDiscountType(1);
				reply.setPrice(Float.valueOf(Dy1905Reply.getMemberPriceResult().getSessionInfo().getMemberPrice()));
				reply.Status = StatusEnum.Success;
			}else{
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = Dy1905Reply.getMemberPriceResult().getResultCode();
			reply.ErrorMessage = Dy1905Reply.getMemberPriceResult().getResultMsg();
			return reply;
		}
		
		/*
		 * 会员卡支付（完成）
		 * */
		@Override
		public CTMSCardPayReply CardPay(Usercinemaview userCinema, String CardNo, String CardPassword, float PayAmount,float GoodsPayAmount,
				String SessionCode, String FilmCode, String TicketNum) throws Exception {
			/*CTMSCardPayReply reply = new CTMSCardPayReply();
			String OrderID = String.valueOf(new Date().getTime());
			for (int i = 0; i < 5; i++) {
	            // 得到随机字母
	            char c = (char) ((Math.random() * 26) + 97);
	            // 拼接成字符串
	            OrderID += (c + "");
	        }
			String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + userCinema.getCinemaId() + CardNo + CardPassword 
					+ (PayAmount+GoodsPayAmount) + OrderID + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
			Map<String,String> param = new LinkedHashMap<String,String>();
			param.put("pAppCode", userCinema.getDefaultUserName());
			param.put("pCinemaID", userCinema.getCinemaId());
			param.put("pCardNo", CardNo);
			param.put("pCardPwd", CardPassword);
			param.put("pBalance", String.valueOf(PayAmount+GoodsPayAmount));
			param.put("pOrderID", OrderID);
			param.put("pVerifyInfo", pVerifyInfo);
			String MemberCardDeductResult = HttpHelper.httpClientPost(userCinema.getUrl() +"/MemberCardDeduct",param,"UTF-8");
			Gson gson = new Gson();
			Dy1905MemberCardDeductResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(MemberCardDeductResult,"CardsListResult"), Dy1905MemberCardDeductResult.class);
			if(Dy1905Reply.getMemberCardDeductResult().getResultCode().equals("0")){
				reply.setTradeNo(OrderID);
				reply.setDeductAmount(Float.valueOf(Dy1905Reply.getMemberCardDeductResult().getCardInfo().getBalance()));
				reply.Status = StatusEnum.Success;
			}else{
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = Dy1905Reply.getMemberCardDeductResult().getResultCode();
			reply.ErrorMessage = Dy1905Reply.getMemberCardDeductResult().getResultMsg();*/
			return null;
		}
		/*
		 * 会员卡购票
		 * */
		public SellTicketCustomMemberReply SellTicketCustomMember(String Username,String Password,String CinemaCode,String LockOrderCode,String CardNo,String CardPassword) throws Exception{
			SellTicketCustomMemberReply reply = new SellTicketCustomMemberReply();
			// 获取用户信息
			Userinfo UserInfo = userInfoService.getByUserCredential(Username, Password);
			if (UserInfo == null) {
				reply.SetUserCredentialInvalidReply();
				return reply;
			}
			// 验证影院是否存在且可访问
			Usercinemaview userCinema = userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
			if (userCinema == null) {
				reply.SetCinemaInvalidReply();
				return reply;
			}
			//验证订单是否存在
			OrderView order = orderService.getOrderWidthLockOrderCode(CinemaCode, LockOrderCode);
			if(order == null){
				reply.SetOrderNotExistReply();
				return reply;
			}
			Sessioninfo sessioninfo = sessioninfoService.getBySessionCode(userCinema.getUserId(), CinemaCode, order.getOrderBaseInfo().getSessionCode());
			if(sessioninfo == null){
				reply.SetSessionInvalidReply();
				return reply;
			}
			//获取会员卡等级
			Membercard membercard = memberCardService.getByCardNo(CinemaCode, CardNo);
			if(membercard == null){
				reply.SetMemberCardInvalidReply();
				return reply;
			}
			//验证会员卡
			String UseMonthCard;
			if(membercard.getLevelCode().equals("4")){
				UseMonthCard = "1";
			}else{
				UseMonthCard = "0";
			}
			Map<String,String> param = new LinkedHashMap<String,String>();
			param.put("pAppCode", userCinema.getDefaultUserName());
			param.put("pOrderID", LockOrderCode);
			//循环遍历出座位号、会员卡支付价、服务费
			String SeatCode = null;
			String MemberPrice = null;
			String Fee = null;
			SeatCode = order.getOrderSeatDetails().get(0).getSeatCode();
			if(order.getOrderSeatDetails().get(0).getConponPrice()==null){
				order.getOrderSeatDetails().get(0).setConponPrice(0.00);
			}
			//计算实际支付价格
			MemberPrice = String.valueOf(order.getOrderSeatDetails().get(0).getSalePrice()-order.getOrderSeatDetails().get(0).getConponPrice());
			Fee = String.valueOf(order.getOrderSeatDetails().get(0).getFee());
			if(order.getOrderSeatDetails().size()>1){
				for(int i=1;i<order.getOrderSeatDetails().size();i++){
					SeatCode += ","+order.getOrderSeatDetails().get(i).getSeatCode();
					if(order.getOrderSeatDetails().get(i).getConponPrice()==null){
						order.getOrderSeatDetails().get(i).setConponPrice(0.00);
					}
					MemberPrice += ","+(order.getOrderSeatDetails().get(i).getSalePrice()-order.getOrderSeatDetails().get(i).getConponPrice());
					Fee += ","+order.getOrderSeatDetails().get(i).getFee();
				}
			}
			param.put("pSeatNo", SeatCode);
			param.put("pMemberPrice", MemberPrice);
			param.put("pFee", Fee);
			param.put("pLowestPrice", String.valueOf(sessioninfo.getLowestPrice()));
			param.put("pCardNo", CardNo);
			param.put("pCardPwd", CardPassword);
			param.put("pUseMonthCard", UseMonthCard);
			String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + LockOrderCode + SeatCode + MemberPrice + Fee 
					+ sessioninfo.getLowestPrice() + CardNo + CardPassword + UseMonthCard + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
			param.put("pVerifyInfo", pVerifyInfo);
			String SellTicketCustomMemberResult = HttpHelper.httpClientPost(userCinema.getUrl() +"/SellTicketCustom/member",param,"UTF-8");
			Gson gson = new Gson();
			Dy1905SellTicketCustomMemberResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(SellTicketCustomMemberResult,"SellTicketResult"), Dy1905SellTicketCustomMemberResult.class);
			if(Dy1905Reply.getSellTicketResult().getResultCode().equals("0")){
				reply.setOrderNo(Dy1905Reply.getSellTicketResult().getOrderNo());
				reply.setPrintNo(Dy1905Reply.getSellTicketResult().getPrintNo());
				reply.setVerifyCode(Dy1905Reply.getSellTicketResult().getVerifyCode());
				reply.SetSuccessReply();
				//更新订单表
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Complete.getStatusCode());
				order.getOrderBaseInfo().setUpdated(new Date());
				order.getOrderBaseInfo().setSubmitTime(new Date());
				order.getOrderBaseInfo().setPayTime(new Date());
				order.getOrderBaseInfo().setOrderPayType(OrderPayTypeEnum.MemberCardPay.getTypeCode());
				order.getOrderBaseInfo().setCardNo(CardNo);
				order.getOrderBaseInfo().setCardPassword(CardPassword);
				order.getOrderBaseInfo().setErrorMessage(Dy1905Reply.getSellTicketResult().getResultMsg());
				order.getOrderBaseInfo().setSubmitOrderCode(Dy1905Reply.getSellTicketResult().getOrderNo());
				order.getOrderBaseInfo().setPrintNo(Dy1905Reply.getSellTicketResult().getPrintNo());
				order.getOrderBaseInfo().setVerifyCode(Dy1905Reply.getSellTicketResult().getVerifyCode());
				order.getOrderBaseInfo().setTotalPrice(order.getOrderSeatDetails().get(0).getPrice()*order.getOrderBaseInfo().getTicketCount());
				order.getOrderBaseInfo().setTotalFee(order.getOrderSeatDetails().get(0).getFee()*order.getOrderBaseInfo().getTicketCount());
				order.getOrderBaseInfo().setTotalSalePrice(order.getOrderSeatDetails().get(0).getSalePrice()*order.getOrderBaseInfo().getTicketCount());
				// 更新优惠券已使用
				for (Orderseatdetails seat : order.getOrderSeatDetails()) {
					if (seat.getConponCode()!=null&&seat.getConponCode()!="") {
						CouponsView couponsview=_couponsService.getWithCouponsCode(seat.getConponCode());
						if(couponsview!=null){
							couponsview.getCoupons().setStatus(CouponsStatusEnum.Used.getStatusCode());
							couponsview.getCoupons().setUsedDate(new Date());
							//使用数量+1
							couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()+1);
							//更新优惠券及优惠券分组表
							_couponsService.update(couponsview);
						}
					}
				}
			}else{
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.SubmitFail.getStatusCode());
				order.getOrderBaseInfo().setErrorMessage(Dy1905Reply.getSellTicketResult().getResultMsg());
			}
			orderService.update(order.getOrderBaseInfo());
			reply.ErrorCode = Dy1905Reply.getSellTicketResult().getResultCode();
			reply.ErrorMessage = Dy1905Reply.getSellTicketResult().getResultMsg();
			return reply;
		}
		/*
		 * 会员卡混合支付
		 * */
		public MemberCardPayReply MemberCardPay(String Username,String Password,String CinemaCode,String LockOrderCode,String LocalOrderCode,
				String CardNo,String CardPassword) throws Exception{
			MemberCardPayReply reply = new MemberCardPayReply();
			//会员卡支付卖品
			// 获取用户信息
			Userinfo UserInfo = userInfoService.getByUserCredential(Username, Password);
			if (UserInfo == null) {
				reply.SetUserCredentialInvalidReply();
				return reply;
			}
			// 验证影院是否存在且可访问
			Usercinemaview userCinema = userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
			if (userCinema == null) {
				reply.SetCinemaInvalidReply();
				return reply;
			}
			Goodsorders orderBaseInfo = goodsOrderService.getByLocalOrderCode(LocalOrderCode);
			if(orderBaseInfo==null){
				reply.SetOrderNotExistReply();
				return reply;
			}
			List<Goodsorderdetails> orderGoodsDetailsList = goodsorderdetailsService.getByOrderId(orderBaseInfo.getId());
			GoodsOrderView order = new GoodsOrderView();
			order.setOrderBaseInfo(orderBaseInfo);
			order.setOrderGoodsDetails(orderGoodsDetailsList);
			GoodsOrderMemberReply goodsReply = GoodsOrderMember(Username,Password,CinemaCode,LocalOrderCode,CardNo,CardPassword);
			if(goodsReply.Status!="Success"){
				reply.Status.equals(goodsReply.Status);
				reply.ErrorCode = goodsReply.ErrorCode;
				reply.ErrorMessage = goodsReply.ErrorMessage;
				return reply;
			}
			//会员卡购票
			SellTicketCustomMemberReply ticketReply = SellTicketCustomMember(Username, Password, CinemaCode, LockOrderCode, CardNo, CardPassword);
			if(!ticketReply.Status.equals("Success")){
				reply.Status.equals(ticketReply.Status);
				reply.ErrorCode = ticketReply.ErrorCode;
				reply.ErrorMessage = ticketReply.ErrorMessage;
				boolean result = true;
				for(int i=0; i<3; i++){
					if(RefundGoods(userCinema, order).Status == StatusEnum.Success){
						break;
					}else{
						result = false;
					}
				}
				if(!result){
					reply.ErrorMessage = "卖品出现异常";
				}
				return reply;
			}
			reply.SetSuccessReply();
			reply.setOrderNo(ticketReply.getOrderNo());
			reply.setVerifyCode(ticketReply.getVerifyCode());
			reply.setPrintNo(ticketReply.getPrintNo());
			reply.setPickNo(goodsReply.getOrderNo());
			return reply;
		}
		/*
		 * 会员卡支付撤销（无）
		 * */
		@Override
		public CTMSCardPayBackReply CardPayBack(Usercinemaview userCinema, String CardNo, String CardPassword,
				String TradeNo, float PayBackAmount) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		/*
		 * 会员卡消费记录（无）
		 * */
		@Override
		public CTMSQueryCardTradeRecordReply QueryCardTradeRecord(Usercinemaview userCinema, String CardNo,
				String CardPassword, String StartDate, String EndDate, String PageSize, String PageNum)
				throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		/*
		 * 会员卡充值（完成）
		 * */
		@Override
		public CTMSCardChargeReply CardCharge(Usercinemaview userCinema, String CardNo, String CardPassword,
				CardChargeTypeEnum ChargeType, float ChargeAmount) throws Exception {
			CTMSCardChargeReply reply = new CTMSCardChargeReply();
			//充值订单号（网售商生成，不得重复，防止重复提交多次充值）
			String OrderID = String.valueOf(new Date().getTime());
			for (int i = 0; i < 5; i++) {
	            // 得到随机字母
	            char c = (char) ((Math.random() * 26) + 97);
	            // 拼接成字符串
	            OrderID += (c + "");
	        }
			String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + userCinema.getCinemaId() + CardNo + OrderID + ChargeAmount + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
			Map<String,String> param = new LinkedHashMap<String,String>();
			param.put("pAppCode", userCinema.getDefaultUserName());
			param.put("pCinemaID", userCinema.getCinemaId());
			param.put("pCardNo", CardNo);
			param.put("pOrderID", OrderID);
			param.put("pBalance", String.valueOf(ChargeAmount));
			param.put("pVerifyInfo", pVerifyInfo);
			String RechargeMemberCardResult = HttpHelper.httpClientPost(userCinema.getUrl() +"/RechargeMemberCard",param,"UTF-8");
			Gson gson = new Gson();
			Dy1905RechargeMemberCardResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(RechargeMemberCardResult,"RechargeMemberCardResult"), Dy1905RechargeMemberCardResult.class);
			if(Dy1905Reply.getRechargeMemberCardResult().getResultCode().equals("0")){
				reply.Status = StatusEnum.Success;
			}else{
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = Dy1905Reply.getRechargeMemberCardResult().getResultCode();
			reply.ErrorMessage = Dy1905Reply.getRechargeMemberCardResult().getResultMsg();
			return reply;
		}
		
		/*
		 * 查询会员卡等级（完成）
		 * */
		@Override
		public CTMSQueryCardLevelReply QueryCardLevel(Usercinemaview userCinema) throws Exception {
			CTMSQueryCardLevelReply reply = new CTMSQueryCardLevelReply();
			String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + userCinema.getCinemaId() + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
			Map<String,String> param = new LinkedHashMap<String,String>();
			param.put("pAppCode", userCinema.getDefaultUserName());
			param.put("pCinemaID", userCinema.getCinemaId());
			param.put("pVerifyInfo", pVerifyInfo);
			String MemberTypeListResult = HttpHelper.httpClientPost(userCinema.getUrl() +"/MemberTypeList",param,"UTF-8");
			Gson gson = new Gson();
			Dy1905MemberTypeListResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(MemberTypeListResult,"MemberTypeListResult"), Dy1905MemberTypeListResult.class);
			List<LevelBean> Dy1905Level = Dy1905Reply.getMemberTypeListResult().getTypes().getType().get(0).getLevels().getLevel();
			if(Dy1905Reply.getMemberTypeListResult().getResultCode().equals("0")){
				for(LevelBean Level :Dy1905Level){
					Membercardlevel membercardlevel = memberCardLevelService.getByCinemaCodeAndLevelCode(userCinema.getCinemaCode(), Level.getLevelNo());
					if(membercardlevel!=null){
						membercardlevel = new Membercardlevel();
						membercardlevel.setCinemaCode(userCinema.getCinemaCode());
						Dy1905ModelMapper.MaptoEntity(Level, membercardlevel);
						memberCardLevelService.update(membercardlevel);
					}else{
						membercardlevel = new Membercardlevel();
						membercardlevel.setCinemaCode(userCinema.getCinemaCode());
						membercardlevel.setStatus(0);
						Dy1905ModelMapper.MaptoEntity(Level, membercardlevel);
						memberCardLevelService.Save(membercardlevel);
					}
				}
				reply.Status = StatusEnum.Success;
			}else{
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = Dy1905Reply.getMemberTypeListResult().getResultCode();
			reply.ErrorMessage = Dy1905Reply.getMemberTypeListResult().getResultMsg();
			return reply;
		}
		/*
		 * 会员卡注册（完成）
		 * */
		@Override
		public CTMSCardRegisterReply CardRegister(Usercinemaview userCinema, String CardPassword, String LevelCode,
				String InitialAmount, String CardUserName, String MobilePhone, String IDNumber, String Sex)
				throws Exception {
			CTMSCardRegisterReply reply = new CTMSCardRegisterReply();
			String OrderID = String.valueOf(new Date().getTime());
			for (int i = 0; i < 5; i++) {
	            // 得到随机字母
	            char c = (char) ((Math.random() * 26) + 97);
	            // 拼接成字符串
	            OrderID += (c + "");
	        }
			String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + OrderID + userCinema.getCinemaId()
			+ CardUserName + CardPassword + MobilePhone + LevelCode + IDNumber + InitialAmount + Sex 
			+ userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
			Map<String,String> param = new LinkedHashMap<String,String>();
			param.put("pAppCode", userCinema.getDefaultUserName());
			///开卡订单ID(新增参数，用于开卡订单查询接口)
			param.put("pOrderID",OrderID);
			param.put("pCinemaID", userCinema.getCinemaId());
			param.put("pCardUser", CardUserName);
			param.put("pCardPwd", CardPassword);
			param.put("pMobile", MobilePhone);
			param.put("pCardLevelID", LevelCode);
			param.put("pIdentityCard", IDNumber);
			param.put("pBalance", InitialAmount);
			param.put("pGender", Sex);
			param.put("pVerifyInfo", pVerifyInfo);
			String MakeMemberCardResult = HttpHelper.httpClientPost(userCinema.getUrl() +"/MakeMemberCard",param,"UTF-8");
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
					.registerTypeAdapter(Integer.class, new IntegerDefaultAdapter())
					.registerTypeAdapter(Double.class, new DoubleDefaultAdapter()).create();
			Dy1905MakeMemberCardResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(MakeMemberCardResult,"MakeMemberCardResult"), Dy1905MakeMemberCardResult.class);
			QueryCardLevel(userCinema);
			Membercardlevel membercardlevel = memberCardLevelService.getByCinemaCodeAndLevelCode(userCinema.getCinemaCode(), LevelCode);
			CardInfoBean cardInfo = Dy1905Reply.getMakeMemberCardResult().getCardInfo();
			if(Dy1905Reply.getMakeMemberCardResult().getResultCode().equals("0")){
				Cinema cinema = cinemaService.getByCinemaCode(userCinema.getCinemaCode());
				String cinemacodes = "";
				if(cinema!=null&&cinema.getIsGeneralStore()==1){
					CinemaMiniProgramAccounts cinemaMiniProgramAccounts = cinemaMiniProgramAccountsService.getByCinemaCode(userCinema.getCinemaCode());
			    	if(cinemaMiniProgramAccounts!=null){
			    		List<CinemaMiniProgramAccounts> cinemaMiniProgramAccountsList = cinemaMiniProgramAccountsService.getByAppId(cinemaMiniProgramAccounts.getAppId());
			    		if(cinemaMiniProgramAccountsList.size()>0){
			    			for(int i=0; i<cinemaMiniProgramAccountsList.size(); i++){
			    				cinemacodes +=cinemaMiniProgramAccountsList.get(i).getCinemaCode()+",";
			    			}
			    		}
			    	}
				}
				Membercard membercard = new Membercard();
				membercard.setCinemaCode(userCinema.getCinemaCode());
				membercard.setCinemaCodes(cinemacodes);
				membercard.setCardPassword(CardPassword);
				membercard.setMobilePhone(MobilePhone);
				membercard.setLevelCode(LevelCode);
				membercard.setLevelName(membercardlevel.getLevelName());
				membercard.setUserName(CardUserName);
				membercard.setSex(Sex);
				membercard.setCreditNum(IDNumber);
				membercard.setStatus(0);
				Dy1905ModelMapper.MaptoEntity(cardInfo, membercard);
				memberCardService.Save(membercard);
				reply.setCardNo(cardInfo.getCardNo());
				reply.setBalance(Float.valueOf(String.valueOf(cardInfo.getBalance())));
				Date ExpireDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.valueOf(cardInfo.getExpireDate()) * 1000)));
				reply.setExpireDate(ExpireDate);
				Date CreateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.valueOf(cardInfo.getCreateTime()) * 1000)));  
				reply.setCreateTime(CreateTime);
				reply.Status = StatusEnum.Success;
			}else{
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = Dy1905Reply.getMakeMemberCardResult().getResultCode();
			reply.ErrorMessage = Dy1905Reply.getMakeMemberCardResult().getResultMsg();
			return reply;
		}
		
		/*
		 *  手机号查询会员卡
		 * */
		public Dy1905GetMemberCardByMobileReply GetMemberCardByMobile(Usercinemaview userCinema,String MobilePhone)throws Exception {
			Dy1905GetMemberCardByMobileReply reply = new Dy1905GetMemberCardByMobileReply();
			String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + userCinema.getCinemaId() + MobilePhone + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
			Map<String,String> param = new LinkedHashMap<String,String>();
			param.put("pAppCode", userCinema.getDefaultUserName());
			param.put("pCinemaID", userCinema.getCinemaId());
			param.put("pMobile", MobilePhone);
			param.put("pVerifyInfo", pVerifyInfo);
			String CardsListResult = HttpHelper.httpClientPost(userCinema.getUrl() +"/GetMemberCardByMobile",param,"UTF-8");
			System.out.println(CardsListResult);
			Gson gson = new Gson();
			Dy1905CardsListResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(CardsListResult,"CardsListResult"), Dy1905CardsListResult.class);
			if(Dy1905Reply.getCardsListResult().getResultCode().equals("0")&&Dy1905Reply.getCardsListResult().getCards()!=null){
				List<String> Cards = Dy1905Reply.getCardsListResult().getCards().getCardNo();
				reply.setData(reply.new GetMemberCardByMobileReplyMemberCard());
				reply.getData().setCards(reply.getData().new GetMemberCardByMobileReplyCard());
				reply.getData().getCards().setCardNo(Cards);
				reply.Status = "Success";
			}else{
				reply.Status = "Failure";
			}
			reply.ErrorCode = Dy1905Reply.getCardsListResult().getResultCode();
			reply.ErrorMessage = Dy1905Reply.getCardsListResult().getResultMsg();
			return reply;
		}
		
		/*
		 * 卖品
		 * */
		/*
		 * 卖品列表
		 * */
		@Override
		public CTMSQueryGoodsReply QueryGoods(Usercinemaview userCinema) throws Exception {
			CTMSQueryGoodsReply reply = new CTMSQueryGoodsReply();
			String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + userCinema.getCinemaId() + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
			Map<String,String> param = new LinkedHashMap<String,String>();
			param.put("pAppCode",userCinema.getDefaultUserName());
			param.put("pCinemaID",userCinema.getCinemaId());
			param.put("pVerifyInfo",pVerifyInfo);
			String GoodsListResult = HttpHelper.httpClientPost(userCinema.getUrl()+"/GoodsList",param,"UTF-8");
			System.out.println(GoodsListResult);
			Gson gson = new Gson();
			Dy1905GoodsListResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(GoodsListResult,"GoodsListResult"), Dy1905GoodsListResult.class);
			if(Dy1905Reply.getGoodsListResult().getResultCode().equals("0")){
				List<GoodBean> dy1905goodList =  Dy1905Reply.getGoodsListResult().getGoods().getGood();
				List<Goods> goodsList = goodsService.getByCinemaCode(userCinema.getUserId(), userCinema.getCinemaCode());
				for(Goods goods : goodsList){
					boolean flag = true;
					for(GoodBean goodsResult : dy1905goodList){
						if(goods.getGoodsCode().equals(goodsResult.getSerial())){
							flag = false;
							break;
						}
					}
					if(flag){
						//删除本地有的而查出来没有的
						goodsService.deleteByCinemaCodeAndGoodsCode(userCinema.getCinemaCode(), goods.getGoodsCode());
					}
				}
				for(GoodBean dy1905good : dy1905goodList){
					Goods goods = goodsService.getByCinemaCodeAndGoodsCode(userCinema.getCinemaCode(), dy1905good.getSerial());
					if(goods==null){
						goods = new Goods();
						goods.setGoodsType("1");
						goods.setCinemaCode(userCinema.getCinemaCode());
						goods.setUserId(userCinema.getUserId());
						goods.setIsDiscount(0);
						goods.setGoodsStatus(1);
						goods.setIsPackage(0);
						goods.setIsRecommand(0);
						Dy1905ModelMapper.MaptoEntity(dy1905good, goods);
						goodsService.save(goods);
					}else{
						Dy1905ModelMapper.MaptoEntity(dy1905good, goods);
						goodsService.update(goods);
					}
				}
				reply.Status = StatusEnum.Success;
			}else{
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = Dy1905Reply.getGoodsListResult().getResultCode();
			reply.ErrorMessage = Dy1905Reply.getGoodsListResult().getResultMsg();
			return reply;
		}
		/*
		 * 创建卖品订单
		 * */
		@Override
		public CTMSCreateGoodsOrderReply CreateGoodsOrder(Usercinemaview userCinema, GoodsOrderView order)
				throws Exception {
			CTMSCreateGoodsOrderReply reply = new CTMSCreateGoodsOrderReply();
			reply.setOrderCode(order.getOrderBaseInfo().getLocalOrderCode());
			reply.Status = StatusEnum.Success;
			return reply;
		}
		/*
		 * 提交卖品订单
		 * */
		@Override
		public CTMSSubmitGoodsOrderReply SubmitGoodsOrder(Usercinemaview userCinema, GoodsOrderView order)
				throws Exception {
			CTMSSubmitGoodsOrderReply reply = new CTMSSubmitGoodsOrderReply();
			GoodsOrderView orders = new GoodsCouponsPriceUtil().getGoodsCouponsPrice(order.getOrderBaseInfo().getLocalOrderCode());
			List<Goodsorderdetails> orderGoodsDetails = orders.getOrderGoodsDetails();
			Map<String,String> param = new LinkedHashMap<String,String>();
			//循环遍历出卖品编码、卖品数量、卖品价格
			String GoodsCode = null;
			String GoodsCount = null;
			String GoodsPrice = null;
			GoodsCode = orderGoodsDetails.get(0).getGoodsCode();
			GoodsCount = String.valueOf(orderGoodsDetails.get(0).getGoodsCount());
			GoodsPrice = String.valueOf(orderGoodsDetails.get(0).getSubTotalSettleAmount()-orderGoodsDetails.get(0).getCouponPrice());
			if(orderGoodsDetails.size()>1){
				for(int i=1;i<orderGoodsDetails.size();i++){
					GoodsCode += ","+orderGoodsDetails.get(i).getGoodsCode();
					GoodsCount += ","+orderGoodsDetails.get(i).getGoodsCount();
					GoodsPrice += ","+(orderGoodsDetails.get(i).getSubTotalSettleAmount()-orderGoodsDetails.get(i).getCouponPrice());
				}
			}
			//实际支付金额
			Double payPrice = orders.getOrderBaseInfo().getTotalSettlePrice();
			if(orders.getOrderBaseInfo().getCouponsPrice()!=null){
				payPrice = orders.getOrderBaseInfo().getTotalSettlePrice() - orders.getOrderBaseInfo().getCouponsPrice();
			}
			String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + userCinema.getCinemaId() 
			+ orders.getOrderBaseInfo().getLocalOrderCode().substring(0,20)
			+ GoodsCode + GoodsCount + GoodsPrice + orders.getOrderBaseInfo().getMobilePhone() + String.valueOf(new Date().getTime()).substring(0,10)
			+ orders.getOrderBaseInfo().getTotalSettlePrice() + payPrice
			+ orders.getOrderBaseInfo().getDeliveryType() + orders.getOrderBaseInfo().getDeliveryAddress()
			+ orders.getOrderBaseInfo().getDeliveryTime() + orders.getOrderBaseInfo().getDeliveryMark()
			+ userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
			param.put("pAppCode",userCinema.getDefaultUserName());
			param.put("pCinemaID",userCinema.getCinemaId());
			param.put("pNetOrder",orders.getOrderBaseInfo().getLocalOrderCode().substring(0,20));
			param.put("pGoodsSerial",GoodsCode);
			param.put("pGoodsCount",GoodsCount);
			param.put("pGoodsPrice",GoodsPrice);
			param.put("pTel",orders.getOrderBaseInfo().getMobilePhone());
			param.put("pOrderTime",String.valueOf(new Date().getTime()).substring(0,10));
			param.put("pTotalPrice",String.valueOf(orders.getOrderBaseInfo().getTotalSettlePrice()));
			param.put("pPayPrice",String.valueOf(payPrice));
			param.put("pDeliveryType",String.valueOf(orders.getOrderBaseInfo().getDeliveryType()));
			param.put("pSeat",orders.getOrderBaseInfo().getDeliveryAddress());
			param.put("pDeliveryTime",orders.getOrderBaseInfo().getDeliveryTime());
			param.put("pMark",orders.getOrderBaseInfo().getDeliveryMark());
			param.put("pVerifyInfo",pVerifyInfo);
			String GoodsOrderResult = HttpHelper.httpClientPost(userCinema.getUrl()+"/GoodsOrder",param,"UTF-8");
			Gson gson = new Gson();
			Dy1905GoodsOrderResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(GoodsOrderResult,"GoodsOrderResult"), Dy1905GoodsOrderResult.class);
			if(Dy1905Reply.getGoodsOrderResult().getResultCode().equals("0")){
				orders.getOrderBaseInfo().setOrderCode(orders.getOrderBaseInfo().getLocalOrderCode().substring(0,20));
				orders.getOrderBaseInfo().setPickUpCode(Dy1905Reply.getGoodsOrderResult().getOrderNo());
				orders.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Complete.getStatusCode());
				reply.setPickNo(Dy1905Reply.getGoodsOrderResult().getOrderNo());
				reply.Status = StatusEnum.Success;
			}else{
				orders.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.SubmitFail.getStatusCode());
				orders.getOrderBaseInfo().setErrorMessage(Dy1905Reply.getGoodsOrderResult().getResultMsg());
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = Dy1905Reply.getGoodsOrderResult().getResultCode();
			reply.ErrorMessage = Dy1905Reply.getGoodsOrderResult().getResultMsg();
			return reply;
		}
		/*
		 * 提交卖品订单+会员支付
		 * */
		public GoodsOrderMemberReply GoodsOrderMember(String Username,String Password,String CinemaCode,String LocalOrderCode,String CardNo,String CardPassword)
				throws Exception {
			GoodsOrderMemberReply reply = new GoodsOrderMemberReply();
			// 获取用户信息
			Userinfo UserInfo = userInfoService.getByUserCredential(Username, Password);
			if (UserInfo == null) {
				reply.SetUserCredentialInvalidReply();
				return reply;
			}
			// 验证影院是否存在且可访问
			Usercinemaview userCinema = userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),CinemaCode);
			if (userCinema == null) {
				reply.SetCinemaInvalidReply();
				return reply;
			}
			//验证订单是否存在
			GoodsOrderView order = new GoodsCouponsPriceUtil().getGoodsCouponsPrice(LocalOrderCode);
			if(order == null){
				reply.SetOrderNotExistReply();
				return reply;
			}
			//获取会员卡等级
			Membercard membercard = memberCardService.getByCardNo(CinemaCode, CardNo);
			if(membercard == null){
				reply.SetMemberCardInvalidReply();
				return reply;
			}
			List<Goodsorderdetails> orderGoodsDetails = order.getOrderGoodsDetails();
			Map<String,String> param = new LinkedHashMap<String,String>();
			//循环遍历出卖品编码、卖品数量、卖品价格
			String GoodsCode = null;
			String GoodsCount = null;
			String GoodsPrice = null;
			GoodsCode = orderGoodsDetails.get(0).getGoodsCode();
			GoodsCount = String.valueOf(orderGoodsDetails.get(0).getGoodsCount());
			GoodsPrice = String.valueOf(orderGoodsDetails.get(0).getSubTotalSettleAmount()-orderGoodsDetails.get(0).getCouponPrice());
			if(orderGoodsDetails.size()>1){
				for(int i=1;i<orderGoodsDetails.size();i++){
					GoodsCode += ","+orderGoodsDetails.get(i).getGoodsCode();
					GoodsCount += ","+orderGoodsDetails.get(i).getGoodsCount();
					GoodsPrice += ","+(orderGoodsDetails.get(i).getSubTotalSettleAmount()-orderGoodsDetails.get(i).getCouponPrice());
				}
			}
			//实际支付金额
			Double payPrice = order.getOrderBaseInfo().getTotalSettlePrice();
			if(order.getOrderBaseInfo().getCouponsPrice()!=null){
				payPrice = order.getOrderBaseInfo().getTotalSettlePrice() - order.getOrderBaseInfo().getCouponsPrice();
			}
			String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + userCinema.getCinemaId() 
			+ order.getOrderBaseInfo().getLocalOrderCode().substring(0,20)
			+ GoodsCode + GoodsCount + GoodsPrice + order.getOrderBaseInfo().getMobilePhone() + String.valueOf(new Date().getTime()).substring(0,10)
			+ order.getOrderBaseInfo().getTotalSettlePrice() + payPrice
			+ CardNo + CardPassword 
			+ order.getOrderBaseInfo().getDeliveryType() + order.getOrderBaseInfo().getDeliveryAddress()
			+ order.getOrderBaseInfo().getDeliveryTime() + order.getOrderBaseInfo().getDeliveryMark()
			+ userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
			param.put("pAppCode",userCinema.getDefaultUserName());
			param.put("pCinemaID",userCinema.getCinemaId());
			param.put("pNetOrder",order.getOrderBaseInfo().getLocalOrderCode().substring(0,20));
			param.put("pGoodsSerial",GoodsCode);
			param.put("pGoodsCount",GoodsCount);
			param.put("pGoodsPrice",GoodsPrice);
			param.put("pTel",order.getOrderBaseInfo().getMobilePhone());
			param.put("pOrderTime",String.valueOf(new Date().getTime()).substring(0,10));
			param.put("pTotalPrice",String.valueOf(order.getOrderBaseInfo().getTotalSettlePrice()));
			param.put("pPayPrice",String.valueOf(payPrice));
			param.put("pCardNo",CardNo);
			param.put("pCardPwd",CardPassword);
			param.put("pDeliveryType",String.valueOf(order.getOrderBaseInfo().getDeliveryType()));
			param.put("pSeat",order.getOrderBaseInfo().getDeliveryAddress());
			param.put("pDeliveryTime",order.getOrderBaseInfo().getDeliveryTime());
			param.put("pMark",order.getOrderBaseInfo().getDeliveryMark());
			param.put("pVerifyInfo",pVerifyInfo);
			String GoodsOrderResult = HttpHelper.httpClientPost(userCinema.getUrl()+"/GoodsOrder",param,"UTF-8");
			Gson gson = new Gson();
			Dy1905GoodsOrderResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(GoodsOrderResult,"GoodsOrderResult"), Dy1905GoodsOrderResult.class);
			if(Dy1905Reply.getGoodsOrderResult().getResultCode().equals("0")){
				//更新订单状态
				order.getOrderBaseInfo().setOrderCode(order.getOrderBaseInfo().getLocalOrderCode().substring(0,20));
				reply.setOrderCode(order.getOrderBaseInfo().getLocalOrderCode().substring(0,20));
				reply.setPickUpCode(order.getOrderBaseInfo().getLocalOrderCode().substring(0,20));
				order.getOrderBaseInfo().setOrderTradeNo(Dy1905Reply.getGoodsOrderResult().getOrderNo());
				order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Complete.getStatusCode());
				reply.setOrderNo(Dy1905Reply.getGoodsOrderResult().getOrderNo());
				// 更新优惠券已使用
				if (null!=order.getOrderBaseInfo().getCouponsCode()&&""!=order.getOrderBaseInfo().getCouponsCode()) {
					CouponsView couponsview=_couponsService.getWithCouponsCode(order.getOrderBaseInfo().getCouponsCode());
					if(couponsview!=null){
						couponsview.getCoupons().setStatus(CouponsStatusEnum.Used.getStatusCode());
						couponsview.getCoupons().setUsedDate(new Date());
						//使用数量+1
						couponsview.getCouponsgroup().setUsedNumber(couponsview.getCouponsgroup().getUsedNumber()+1);
						//更新优惠券及优惠券分组表
						_couponsService.update(couponsview);
					}
				}
				reply.SetSuccessReply();
			}else{
				order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.SubmitFail.getStatusCode());
				order.getOrderBaseInfo().setErrorMessage(Dy1905Reply.getGoodsOrderResult().getResultMsg());
			}
			goodsOrderService.update(order.getOrderBaseInfo());
			reply.ErrorCode = Dy1905Reply.getGoodsOrderResult().getResultCode();
			reply.ErrorMessage = Dy1905Reply.getGoodsOrderResult().getResultMsg();
			return reply;
		}
		/*
		 * 获取卖品订单的状态信息
		 * */
		@Override
		public CTMSQueryGoodsOrderReply QueryGoodsOrder(Usercinemaview userCinema, GoodsOrderView order)
				throws Exception {
			CTMSQueryGoodsOrderReply reply = new CTMSQueryGoodsOrderReply();
			Map<String,String> param = new LinkedHashMap<String,String>();
			String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + userCinema.getCinemaId() + order.getOrderBaseInfo().getOrderCode() + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
			param.put("pAppCode",userCinema.getDefaultUserName());
			param.put("pCinemaID",userCinema.getCinemaId());
			param.put("pNetOrder",order.getOrderBaseInfo().getOrderCode());
			param.put("pVerifyInfo",pVerifyInfo);
			String GetGoodsOrderStatusResult = HttpHelper.httpClientPost(userCinema.getUrl()+"/GetGoodsOrderStatus",param,"UTF-8");
			System.out.println(GetGoodsOrderStatusResult);
			Gson gson = new Gson();
			Dy1905GetGoodsOrderStatusResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(GetGoodsOrderStatusResult,"GetGoodsOrderStatusResult"), Dy1905GetGoodsOrderStatusResult.class);
			if(Dy1905Reply.getGetGoodsOrderStatusResult().getResultCode().equals("0")){
				order.getOrderBaseInfo().setPickUpCode(Dy1905Reply.getGetGoodsOrderStatusResult().getOrderNo());
				if(Dy1905Reply.getGetGoodsOrderStatusResult().getStatus().equals("0")){
					order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Created.getStatusCode());
				}
				if(Dy1905Reply.getGetGoodsOrderStatusResult().getStatus().equals("1")){
					order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Complete.getStatusCode());
				}
				if(Dy1905Reply.getGetGoodsOrderStatusResult().getStatus().equals("2")){
					order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Created.getStatusCode());
				}
				if(Dy1905Reply.getGetGoodsOrderStatusResult().getStatus().equals("4")){
					order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Fetched.getStatusCode());
				}
				if(Dy1905Reply.getGetGoodsOrderStatusResult().getRefundStatus().equals("1")){
					order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Refund.getStatusCode());
				}
				reply.Status = StatusEnum.Success;
			}else{
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = Dy1905Reply.getGetGoodsOrderStatusResult().getResultCode();
			return reply;
		}
		/*
		 * 卖品退货
		 * */
		@Override
		public CTMSRefundGoodsReply RefundGoods(Usercinemaview userCinema, GoodsOrderView order) throws Exception {
			CTMSRefundGoodsReply reply = new CTMSRefundGoodsReply();
			Map<String,String> param = new LinkedHashMap<String,String>();
			String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + userCinema.getCinemaId() + order.getOrderBaseInfo().getOrderCode() + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
			param.put("pAppCode",userCinema.getDefaultUserName());
			param.put("pCinemaID",userCinema.getCinemaId());
			param.put("pNetOrder",order.getOrderBaseInfo().getOrderCode());
			param.put("pVerifyInfo",pVerifyInfo);
			String RefundGoodsResult = HttpHelper.httpClientPost(userCinema.getUrl()+"/RefundGoods",param,"UTF-8");
			Gson gson = new Gson();
			Dy1905RefundGoodsResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(RefundGoodsResult,"RefundGoodsResult"), Dy1905RefundGoodsResult.class);
			if(Dy1905Reply.getRefundGoodsResult().getResultCode().equals("0")){
				order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Refund.getStatusCode());
				order.getOrderBaseInfo().setRefundTime(new Date());
				reply.Status = StatusEnum.Success;
			}else{
				order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.RefundFail.getStatusCode());
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = Dy1905Reply.getRefundGoodsResult().getResultCode();
			return reply;
		}
		/*
		 * 混合下单
		 * */
		@Override
		public CTMSSubmitMixOrderReply SubmitMixOrder(Usercinemaview userCinema, OrderView order,
				GoodsOrderView goodsorder) throws Exception {
			CTMSSubmitMixOrderReply reply = new CTMSSubmitMixOrderReply();
			//锁座，创建影票订单
			CTMSLockSeatReply lockReply = LockSeat(userCinema, order);
			if(!lockReply.Status.equals("Success")){
				reply.Status = lockReply.Status;
				reply.ErrorCode = lockReply.ErrorCode;
				reply.ErrorMessage = lockReply.ErrorMessage;
				return reply;
			}
			//创建卖品订单
			CTMSCreateGoodsOrderReply creatGoodsOrder = CreateGoodsOrder(userCinema, goodsorder);
			if(!creatGoodsOrder.Status.equals("Success")){
				reply.Status = creatGoodsOrder.Status;
				reply.ErrorCode = creatGoodsOrder.ErrorCode;
				reply.ErrorMessage = creatGoodsOrder.ErrorMessage;
				return reply;
			}
			//提交影票订单
			CTMSSubmitOrderReply orderReply = SubmitOrder(userCinema, order);
			if(!orderReply.Status.equals("Success")){
				reply.Status = orderReply.Status;
				reply.ErrorCode = orderReply.ErrorCode;
				reply.ErrorMessage = orderReply.ErrorMessage;
				return reply;
			}
			//提交卖品订单
			CTMSSubmitGoodsOrderReply goodsOrderReply = SubmitGoodsOrder(userCinema, goodsorder);
			if(!goodsOrderReply.Status.equals("Success")){
				reply.Status = orderReply.Status;
				reply.ErrorCode = orderReply.ErrorCode;
				reply.ErrorMessage = orderReply.ErrorMessage;
				return reply;
			}
			//影票成功卖品失败--退票
			if(orderReply.Status.equals("Success")&&!goodsOrderReply.Status.equals("Success")){
				for(int i=0; i<3; i++){
					CTMSRefundTicketReply refundReply = RefundTicket(userCinema, order);
					if(refundReply.Status.equals("Success")){
						break;
					}
				}
				reply.Status = goodsOrderReply.Status;
				reply.ErrorCode = goodsOrderReply.ErrorCode;
				reply.ErrorMessage = goodsOrderReply.ErrorMessage;
				return reply;
			}else{
				//都成功
				reply.Status = orderReply.Status;
			}
			reply.ErrorCode = orderReply.ErrorCode;
			reply.ErrorMessage = orderReply.ErrorMessage;
			return reply;
		}
		public static void main(String[] args) {
			String pVerifyInfo = MD5Util.MD5Encode("1000000035" + "1560429019270yjixwcf" + "66a16ca61f729e0c846983f8c0f4fd53","UTF-8").toLowerCase();
			System.out.println(pVerifyInfo);
		}
}
