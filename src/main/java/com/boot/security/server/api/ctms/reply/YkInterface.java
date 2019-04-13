package com.boot.security.server.api.ctms.reply;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.alibaba.fastjson.JSONObject;
import com.boot.security.server.api.ctms.reply.YkConfirmOrderResult.DataBean.OrderBean;
import com.boot.security.server.api.ctms.reply.YkConfirmOrderResult.DataBean.OrderBean.Tickets;
import com.boot.security.server.api.ctms.reply.YkGetCinemasResult.DataBean.YkCinema;
import com.boot.security.server.api.ctms.reply.YkGetCinemasResult.DataBean.YkCinema.Halls;
import com.boot.security.server.api.ctms.reply.YkGetScheduleSoldSeatsResult.DataBean.SoldSeats.SectionList;
import com.boot.security.server.api.ctms.reply.YkGetScheduleSoldSeatsResult.DataBean.SoldSeats.SectionList.SeatsBean;
import com.boot.security.server.api.ctms.reply.YkGetSchedulesResult.dataBean.ScheduleBean;
import com.boot.security.server.api.ctms.reply.YkGetSeatsResult.DataBean.CinemaBean.SeatPlan;
import com.boot.security.server.api.ctms.reply.YkGetSeatsResult.DataBean.CinemaBean.SeatPlan.Sections;
import com.boot.security.server.api.ctms.reply.YkGetSeatsResult.DataBean.CinemaBean.SeatPlan.Sections.Seats;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Filminfo;
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
import com.google.gson.Gson;

public class YkInterface implements ICTMSInterface {
	CinemaServiceImpl _cinemaService = SpringUtil.getBean(CinemaServiceImpl.class);
	ScreeninfoServiceImpl _screeninfoService = SpringUtil.getBean(ScreeninfoServiceImpl.class);
	SessioninfoServiceImpl _sessioninfoService = SpringUtil.getBean(SessioninfoServiceImpl.class);
	ScreenseatinfoServiceImpl _screenseatinfoService = SpringUtil.getBean(ScreenseatinfoServiceImpl.class);
	FilminfoServiceImpl _filminfoService = SpringUtil.getBean(FilminfoServiceImpl.class);

	/*
	 * 查询影院信息
	 */
	@Override
	public CTMSQueryCinemaReply QueryCinema(Usercinemaview userCinema) throws Exception {
		CTMSQueryCinemaReply reply = new CTMSQueryCinemaReply();
		
		Map<String,String> param = new LinkedHashMap();
		param.put("api", "ykse.partner.cinema.getCinemas");
		param.put("channelCode",userCinema.getDefaultUserName());
		param.put("timestamp",String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String getCinemasResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",userCinema.getDefaultPassword(), FormatParam(param), sign),null,"UTF-8");
		System.out.println("Yk影院返回："+getCinemasResult);
		Gson gson = new Gson();
		YkGetCinemasResult CinemaListResult = gson.fromJson(getCinemasResult, YkGetCinemasResult.class);
		if ("0".equals(CinemaListResult.getRetCode())) {
			if("SUCCESS".equals(CinemaListResult.getData().getBizCode())){
//				List<FHJYCinema> cinemaList=CinemaListResult.getData().getDataList().stream().
//						filter((FHJYCinema cinema)->cinema.getCinemaId().equals(userCinema.getCinemaCode())).collect(Collectors.toList());
				List<YkCinema> cinemaList = CinemaListResult.getData().getDataList();
				for(YkCinema fCinema : cinemaList){
					//更新或添加影院信息
	            	Cinema cinema = _cinemaService.getByCinemaCode(fCinema.getCinemaId());
	                cinema.setName(fCinema.getName());
	                cinema.setAddress(fCinema.getCity());
	                cinema.setScreenCount(fCinema.getHallCount());
	                cinema.setCinemaId(fCinema.getCinemaLinkId());	//影院内部编码
	                _cinemaService.update(cinema);
	            
	                //更新影厅信息
	                List<Screeninfo> newScreens = new ArrayList<Screeninfo>();
	                List<Halls> screens=fCinema.getHalls();
	                for(Halls hall:screens){
	                	Screeninfo screen=new Screeninfo();//先读取本地
	                	YkModelMapper.ScreenMapToEntity(hall, screen);
	                	screen.setCCode(fCinema.getCinemaId());
	                	newScreens.add(screen);
	                }
	                //先删除旧影影厅
	    			_screeninfoService.deleteByCinemaCode(fCinema.getCinemaId());
	    			//插入影厅信息
	    			for(Screeninfo screen:newScreens){
	    				_screeninfoService.save(screen);
	    			}
				}
				reply.Status = StatusEnum.Success;
			} else {
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode=CinemaListResult.getData().getBizCode();
			reply.ErrorMessage=CinemaListResult.getData().getBizMsg();
			
		} else {
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode=CinemaListResult.getRetCode();
			reply.ErrorMessage=CinemaListResult.getRetMsg();
		}

		return reply;
	
	}
	
	/*
	 * 查询影厅座位信息
	 * 请求示例：http://ykse.vicp.cc:28080/route?api=ykse.partner.seat.getSeats&v=1.0&channelCode=API_APP_IOS_TEST&timestamp=1453445830715&data={"cinemaLinkId":"681","hallId":"14"}&sign=622af9a ddc970acae9ac3ce195d070c7
	 * 
	 */
	@Override
	public CTMSQuerySeatReply QuerySeat(Usercinemaview userCinema, Screeninfo screen) throws Exception {
		CTMSQuerySeatReply reply = new CTMSQuerySeatReply();
		
		Map<String,String> param = new LinkedHashMap();
		param.put("api", "ykse.partner.seat.getSeats");
		param.put("channelCode",userCinema.getDefaultUserName());
		param.put("data", "{\"cinemaLinkId\":\""+userCinema.getCinemaId()+"\",\"hallId\":\""+screen.getSCode()+"\"}");
		param.put("timestamp",String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String getSeatsResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
//		System.out.println("影厅座位返回："+getSeatsResult);
		Gson gson = new Gson();
		YkGetSeatsResult seatsResult = gson.fromJson(getSeatsResult, YkGetSeatsResult.class);
		if ("0".equals(seatsResult.getRetCode())) {
			if("SUCCESS".equals(seatsResult.getData().getBizCode())){
				List<Screenseatinfo> newScreen = new ArrayList<Screenseatinfo>();
				List<SeatPlan> seatPlan=seatsResult.getData().getData().getSeatPlanList();
				for(int i=0;i<seatPlan.size();i++){
					List<Sections> screenseats =seatPlan.get(i).getSections();
					for(int j=0;j<screenseats.size();j++){
						List<Seats> seats = screenseats.get(j).getSeats();
						for(Seats seat:seats){
							Screenseatinfo screenseat=new Screenseatinfo();
							screenseat.setCinemaCode(userCinema.getCinemaCode());
							screenseat.setScreenCode(screen.getSCode());
							screenseat.setGroupCode(screenseats.get(j).getSectionId());
							YkModelMapper.SeatMapToEntity(seat, screenseat);
							newScreen.add(screenseat);
						}
					}
				}
				//删除旧影厅座位
				_screenseatinfoService.deleteByScreenCode(userCinema.getCinemaCode(), screen.getSCode());
				//插入新影厅座位信息
				for(Screenseatinfo screenseat:newScreen){
					_screenseatinfoService.save(screenseat);
				}
				
				reply.Status = StatusEnum.Success;
			} else {
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode=seatsResult.getData().getBizCode();
			reply.ErrorMessage=seatsResult.getData().getBizMsg();
			
		} else {
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode=seatsResult.getRetCode();
			reply.ErrorMessage=seatsResult.getRetMsg();
		}
		
		return reply;
	}

	/*
	 * 查询影片信息---凤凰佳影（粤科）无此接口，调用查询排期列表
	 *
	 */
	@Override
	public CTMSQueryFilmReply QueryFilm(Usercinemaview userCinema, Date StartDate, Date EndDate) throws Exception {
		CTMSQueryFilmReply reply = new CTMSQueryFilmReply();
		
		QuerySession(userCinema,StartDate,EndDate);	//调用查询排期列表,然后从数据库读取
		//根据影片名称分组，去除影片重复数据
		List<Sessioninfo> sessions = _sessioninfoService.getByCCodeGroupByFilm(userCinema.getUserId(), userCinema.getCinemaCode(), StartDate, EndDate);
		
		List<Filminfo> films = new ArrayList<Filminfo>();
		for(Sessioninfo sessioninfo : sessions){
			String filmName = sessioninfo.getFilmName();
			List<Filminfo>  filmlist = _filminfoService.getFilmByFilmName(filmName);
			if(filmlist == null || filmlist.size() == 0){
				Filminfo film = new Filminfo();
				film.setFilmCode(sessioninfo.getFilmCode());
				film.setFilmName(sessioninfo.getFilmName());
				film.setVersion(sessioninfo.getDimensional());
				film.setDuration(sessioninfo.getDuration().toString());
				film.setPublishDate(sessioninfo.getStartTime());	//公映日期排期没有，用放映时间
//				_filminfoService.save(film);
				films.add(film);
			} else if(filmlist.size()>1){
				for(Filminfo ffilminfo : filmlist){
					if(ffilminfo.getPublishDate() !=null || ffilminfo.getPublisher() !=null ||ffilminfo.getProducer() !=null ||
							ffilminfo.getDirector() !=null ||ffilminfo.getCast() !=null ||ffilminfo.getIntroduction() !=null){

						films.add(ffilminfo);
						break;
					} else {
						
						films.add(ffilminfo);
						break;
					}
				}
			}else {
				films.add(filmlist.get(0));
			}
		}
		
		reply.setFilms(films);
		reply.Status = StatusEnum.Success;
		
		return reply;
	}

	/*
	 * 查询排期列表
	 *
	 */
	@Override
	public CTMSQuerySessionReply QuerySession(Usercinemaview userCinema, Date StartDate, Date EndDate) throws Exception {
		CTMSQuerySessionReply reply = new CTMSQuerySessionReply();

		Calendar calendar = new GregorianCalendar();
		// 将开始时间减1天以便能获取到当前早上6点之前的场次
		Date start = StartDate;
		calendar.setTime(start);
		calendar.add(calendar.DATE, -1);
		start = calendar.getTime();
		// 将结束时间加上1天以便符合粤科接口规范
		Date end = EndDate;
		calendar.setTime(end);
		calendar.add(calendar.DATE, 1);
		end = calendar.getTime();

		Map<String, String> param = new LinkedHashMap();
		param.put("api", "ykse.partner.schedule.getSchedules");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data",
				"{\"cinemaLinkId\":\"" + userCinema.getCinemaId() + "\",\"endDate\":\""
						+ (new java.text.SimpleDateFormat("yyyy-MM-dd")).format(end) + "\",\"startDate\":\""
						+ (new java.text.SimpleDateFormat("yyyy-MM-dd")).format(start) + "\",\"priceQueryType\":\"\"}");
		param.put("timestamp", String.valueOf(Calendar.getInstance().getTimeInMillis()));
		param.put("v", "1.0");
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String getSchedulesResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
		Gson gson = new Gson();
		YkGetSchedulesResult ykReply=gson.fromJson(getSchedulesResult, YkGetSchedulesResult.class);
		System.out.println("排期返回："+getSchedulesResult);
		if ("0".equals(ykReply.getRetCode())){
			if("SUCCESS".equals(ykReply.getData().getBizCode())){
				//更新排期
				List<Sessioninfo> newSessions = new ArrayList<Sessioninfo>();
				List<ScheduleBean> scheduleBeans=ykReply.getData().getDataList();
				
				for(ScheduleBean scheduleBean:scheduleBeans)
				{
					Sessioninfo session=new Sessioninfo();//实例化
					YkModelMapper.MapToEntity(scheduleBean,session);
					session.setCCode(userCinema.getCinemaCode());
					session.setUserID(userCinema.getUserId());
					newSessions.add(session);
				}
				//删除原有的排期
				_sessioninfoService.deleteByCinemaCodeAndDate(userCinema.getUserId(), userCinema.getCinemaCode(), StartDate, EndDate);
				//插入排期信息
				for(Sessioninfo session:newSessions){
					_sessioninfoService.save(session);
				}
				reply.Status = StatusEnum.Success;
			} else {
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = ykReply.getData().getBizCode();
			reply.ErrorMessage = ykReply.getData().getBizMsg();
			
		} else {
            reply.Status = StatusEnum.Failure;
            reply.ErrorCode = ykReply.getRetCode();
			reply.ErrorMessage = ykReply.getRetMsg();
        }
		
		return reply;
	}

	/*
	 * 查询放映计划座位售出状态接口
	 * 凤凰佳影接口请求示例：
	 * http://ykse.vicp.cc:28080/route?api=ykse.partner.seat.getScheduleSoldSeats&v=1.0&channelCod e=API_APP_IOS_TEST&timestamp=1453445985545&data={"cinemaLinkId":"681",
	 * "scheduleKey": "41572E3107BBF9275F7422DFDC896B21","sectionId":"0000000000000001","scheduleId":"7054"}&sign=bf49d8266770bafee30f254e26a70b6f
	 */
	
	@Override
	public CTMSQuerySessionSeatReply QuerySessionSeat(Usercinemaview userCinema, String SessionCode,SessionSeatStatusEnum Status) throws Exception {
		CTMSQuerySessionSeatReply reply=new CTMSQuerySessionSeatReply();
		
		Sessioninfo sessioninfo=_sessioninfoService.getBySessionCode(userCinema.getUserId(), userCinema.getCinemaCode(), SessionCode);
		List<Screenseatinfo> screenseats=_screenseatinfoService.getByCinemaCodeAndScreenCode(userCinema.getCinemaCode(), sessioninfo.getScreenCode());
		
		List<SessionSeat> seatlist = new ArrayList<SessionSeat>();
		for(Screenseatinfo screenseatinfo:screenseats){		//读取影厅内所有座位存放本地
			SessionSeat seatinfo=new SessionSeat();
			seatinfo.setSeatCode(screenseatinfo.getSeatCode());
			seatinfo.setRowNum(screenseatinfo.getRowNum());
			seatinfo.setColumnNum(screenseatinfo.getColumnNum());
			seatinfo.setStatus(SessionSeatStatusEnum.valueOf(screenseatinfo.getStatus()));
			seatlist.add(seatinfo);
		}
		
		List<Screenseatinfo> groupscreenseats=_screenseatinfoService.getGroupByGroupCode(userCinema.getCinemaCode(), sessioninfo.getScreenCode());
		for(int i=0;i<groupscreenseats.size();i++){
			String sectionId = groupscreenseats.get(i).getGroupCode();  //场区编码
			
			JSONObject  input=new JSONObject();
			input.put("cinemaLinkId", userCinema.getCinemaId());
			input.put("scheduleKey",sessioninfo.getSessionKey());
			input.put("sectionId",sectionId);
			input.put("scheduleId",sessioninfo.getSessionId());
			String data=input.toJSONString();
			
			Map<String,String> param = new LinkedHashMap();
			param.put("api", "ykse.partner.seat.getScheduleSoldSeats");
			param.put("channelCode",userCinema.getDefaultUserName());
			param.put("data", data);
			param.put("timestamp",String.valueOf(System.currentTimeMillis()));
			param.put("v", "1.0");
			
			String sign = createSign(userCinema.getDefaultPassword(), param);
			String getScheduleSoldSeats = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
					userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
			System.out.println("座位状态返回："+getScheduleSoldSeats);
			Gson gson = new Gson();
			YkGetScheduleSoldSeatsResult scheduleSoldSeatsResult = gson.fromJson(getScheduleSoldSeats, YkGetScheduleSoldSeatsResult.class);
			
			if ("0".equals(scheduleSoldSeatsResult.getRetCode()) && "SUCCESS".equals(scheduleSoldSeatsResult.getData().getBizCode())) {
				List<SectionList> sectionList = scheduleSoldSeatsResult.getData().getData().getSectionList();
				for(int j=0;j<sectionList.size();j++){
					List<SeatsBean> seats = sectionList.get(j).getSeats();
					for(SeatsBean seat:seats){
						String seatId = seat.getSeatId();
						
						seatlist.stream().filter((SessionSeat ss)->ss.getSeatCode().equals(seatId))
						.collect(Collectors.toList()).get(0).setStatus(SessionSeatStatusEnum.Sold);
					}
				}
				List<SessionSeat>  newseatlist=  seatlist;
				if (!Status.equals(SessionSeatStatusEnum.All)) {
					newseatlist = newseatlist.stream().filter((SessionSeat ss)->Status.equals(ss.getStatus())).collect(Collectors.toList());
					
                }
				reply.setSessionSeats(newseatlist);
				reply.Status = StatusEnum.Success;
			} else {
				reply.Status = StatusEnum.Failure;
			}
			
			reply.ErrorCode = scheduleSoldSeatsResult.getData().getBizCode();
			reply.ErrorMessage = scheduleSoldSeatsResult.getData().getBizMsg();
		}
		System.out.println("Yk座位状态:"+new Gson().toJson(reply));
		return reply;
	}

	/*
	 * 锁定座位
	 * 
	 */
	@PostConstruct
	@Override
	public CTMSLockSeatReply LockSeat(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSLockSeatReply reply = new CTMSLockSeatReply();
		
		List<String> seatIdList = new ArrayList<String>();
		for(int i=0;i<order.getOrderSeatDetails().size();i++){
			seatIdList.add(order.getOrderSeatDetails().get(i).getSeatCode());
		}
		Sessioninfo sessioninfo = _sessioninfoService.getBySessionCode(userCinema.getUserId(), userCinema.getCinemaCode(), order.getOrderBaseInfo().getSessionCode());
		JSONObject  input=new JSONObject();
		input.put("cinemaLinkId", userCinema.getCinemaId());
		input.put("outLockId", creatOutLockId());
		input.put("scheduleId", sessioninfo.getSessionId());
		input.put("scheduleKey", sessioninfo.getSessionKey());
		input.put("seatIdList", seatIdList);
		String data=input.toJSONString();
		
		Map<String,String> param = new LinkedHashMap();
		param.put("api", "ykse.partner.seat.lockSeats");
		param.put("channelCode",userCinema.getDefaultUserName());
		param.put("data",data);
		param.put("timestamp",String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String getLockSeatsResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
		
		System.out.println("锁座返回："+getLockSeatsResult);
		Gson gson = new Gson();
		YkLockSeatsResult lockSeatsResult = gson.fromJson(getLockSeatsResult, YkLockSeatsResult.class);
		
		Orders newOrder = order.getOrderBaseInfo();
		if ("0".equals(lockSeatsResult.getRetCode())) {
			if("SUCCESS".equals(lockSeatsResult.getData().getBizCode())){
				Date nowDate = new Date();
				newOrder.setLockOrderCode(lockSeatsResult.getData().getData().getLockOrderId());
				newOrder.setAutoUnlockDatetime(new Date(nowDate.getTime()+10*60*1000));		//粤科没有自动解锁时间返回，此处默认锁定10分钟
				newOrder.setLockTime(nowDate);
				newOrder.setOrderStatus(OrderStatusEnum.Locked.getStatusCode());
				
				reply.Status = StatusEnum.Success;
			} else {
				newOrder.setOrderStatus(OrderStatusEnum.LockFail.getStatusCode());
				newOrder.setErrorMessage(lockSeatsResult.getData().getBizMsg());
				
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = lockSeatsResult.getData().getBizCode();
			reply.ErrorMessage = lockSeatsResult.getData().getBizMsg();
		} else {
			newOrder.setOrderStatus(OrderStatusEnum.LockFail.getStatusCode());
			newOrder.setErrorMessage(lockSeatsResult.getRetMsg());
			
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = lockSeatsResult.getRetCode();
			reply.ErrorMessage = lockSeatsResult.getRetMsg();
		}
		order.setOrderBaseInfo(newOrder);
		
		return reply;
	}

	/*
	 * 释放座位：如果锁定座位后放弃支付，需要调用该接口将锁定的座位释放
	 */
	@Override
	public CTMSReleaseSeatReply ReleaseSeat(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSReleaseSeatReply reply = new CTMSReleaseSeatReply();
		
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.seat.releaseSeats");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", "{\"cinemaLinkId\":\""+userCinema.getCinemaId()+"\",\"lockOrderId\":\""+order.getOrderBaseInfo().getLockOrderCode()+"\"}");
		param.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String releaseSeatsResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
//		System.out.println("解锁返回："+releaseSeatsResult);
		Gson gson = new Gson();
		YkReleaseSeatsResult ykResult = gson.fromJson(releaseSeatsResult, YkReleaseSeatsResult.class);
		
		if("0".equals(ykResult.getRetCode())){
			if("SUCCESS".equals(ykResult.getData().getBizCode())){
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Released.getStatusCode());
				
				reply.Status = StatusEnum.Success;
			} else {
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.ReleaseFail.getStatusCode());
				order.getOrderBaseInfo().setErrorMessage(ykResult.getData().getBizMsg());
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = ykResult.getData().getBizCode();
			reply.ErrorMessage = ykResult.getData().getBizMsg();
			
		} else {
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.ReleaseFail.getStatusCode());
			order.getOrderBaseInfo().setErrorMessage(ykResult.getRetMsg());
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = ykResult.getRetCode();
			reply.ErrorMessage = ykResult.getRetMsg();
		}
		
		return reply;
	}

	/*
	 * 凤凰佳影-确认订单接口：该接口仅供单买选座票时使用，如果同时购买卖品和选座票请使用混合订单接口
	 */
	@Override
	public CTMSSubmitOrderReply SubmitOrder(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSSubmitOrderReply reply = new CTMSSubmitOrderReply();
		
		Sessioninfo sessioninfo = _sessioninfoService.getBySessionCode(userCinema.getUserId(), userCinema.getCinemaCode(), order.getOrderBaseInfo().getSessionCode());
		List<Map<String,String>> ticketList = new ArrayList<Map<String,String>>();
		List<Orderseatdetails> orderseatdetails = order.getOrderSeatDetails();	//订单详情列表
		for(Orderseatdetails orderseat : orderseatdetails){
			Map<String,String> orderMap = new LinkedHashMap<String,String>();
			orderMap.put("seatId", orderseat.getSeatCode());
			orderMap.put("ticketPrice", String.valueOf(orderseat.getPrice()));
			orderMap.put("ticketFee", String.valueOf(orderseat.getFee()));
			ticketList.add(orderMap);
		}
		
		JSONObject  input=new JSONObject();
		input.put("cinemaLinkId", userCinema.getCinemaId());
		input.put("lockOrderId", order.getOrderBaseInfo().getLockOrderCode());
		input.put("scheduleId", sessioninfo.getSessionId());
		input.put("scheduleKey", sessioninfo.getSessionKey());
		input.put("ticketList", ticketList);
		input.put("mobile", order.getOrderBaseInfo().getMobilePhone());
		String data=input.toJSONString();
		
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.order.confirmOrder");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", data);
		param.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String confirmOrderResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
//		System.out.println("确认订单返回："+confirmOrderResult);
		Gson gson = new Gson();
		YkConfirmOrderResult ykResult = gson.fromJson(confirmOrderResult, YkConfirmOrderResult.class);
		
		if("0".equals(ykResult.getRetCode())){
			if("SUCCESS".equals(ykResult.getData().getBizCode())){
				OrderBean orderBean = ykResult.getData().getData();
				order.getOrderBaseInfo().setSubmitOrderCode(orderBean.getOrderId());	//平台订单号
				order.getOrderBaseInfo().setPrintNo(orderBean.getConfirmationId());		//取票号
				order.getOrderBaseInfo().setPrintpassword(orderBean.getBookingId());	//影院订单号，存为打印编号
				String str = creatOutLockId();
				order.getOrderBaseInfo().setVerifyCode(str.substring(str.length()-6));	//取票验证码，随机生成的6位数字
				List<Tickets> ticketsList = orderBean.getTickets();
				for(int i=0;i<ticketsList.size();i++){
					if(ticketsList.get(i).getSeatId().equals(order.getOrderSeatDetails().get(i).getSeatCode())){
						order.getOrderSeatDetails().get(i).setFilmTicketCode(ticketsList.get(i).getTicketNo());  //票号
						order.getOrderSeatDetails().get(i).setSeatId(ticketsList.get(i).getSeatCode());		//座位编码，用于上报 专资办使用
						order.getOrderSeatDetails().get(i).setRowNum(ticketsList.get(i).getRowId());	//行号
						order.getOrderSeatDetails().get(i).setColumnNum(ticketsList.get(i).getColumnId());	//列号
						order.getOrderSeatDetails().get(i).setFee(Double.valueOf(ticketsList.get(i).getServiceFee()));	//服务费
					}
				}
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Complete.getStatusCode());	//订单状态
				order.getOrderBaseInfo().setSubmitTime(new Date());					//订单提交时间
				reply.Status = StatusEnum.Success;
			} else {
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.SubmitFail.getStatusCode());
				order.getOrderBaseInfo().setErrorMessage(ykResult.getData().getBizMsg());
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = ykResult.getData().getBizCode();
			reply.ErrorMessage = ykResult.getData().getBizMsg();
			
		} else {
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.SubmitFail.getStatusCode());
			order.getOrderBaseInfo().setErrorMessage(ykResult.getRetMsg());
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = ykResult.getRetCode();
			reply.ErrorMessage = ykResult.getRetMsg();
		}
		
		return reply;
	}

	/*
	 * 查询出票状态
	 */
	@Override
	public CTMSQueryPrintReply QueryPrint(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSQueryPrintReply reply = new CTMSQueryPrintReply();
		
		/*Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.ticket.getOrderPrintStatus");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", "{\"cinemaLinkId\":\""+userCinema.getCinemaId()+"\",\"printId\":\""+order.getOrderBaseInfo().getPrintNo()+"\"}");
		param.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String getOrderPrintStatusResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
		System.out.println("取票状态返回："+getOrderPrintStatusResult);
		System.out.println(order.getOrderBaseInfo().getPrintNo());
		Gson gson = new Gson();
		YkGetOrderPrintStatusResult ykResult = gson.fromJson(getOrderPrintStatusResult, YkGetOrderPrintStatusResult.class);
		
		if("0".equals(ykResult.getRetCode()) && "SUCCESS".equals(ykResult.getData().getBizCode())){
			
			order.getOrderBaseInfo().setPrintStatus(0);
			reply.Status = StatusEnum.Success;
			
		} else {
			order.getOrderBaseInfo().setPrintStatus(1);
			order.getOrderBaseInfo().setPrintTime(new Date());
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = ykResult.getData().getBizCode();
		reply.ErrorMessage=ykResult.getData().getBizMsg();*/
		
		CTMSQueryTicketReply queryTicketReply = QueryTicket(userCinema, order);
		
		reply.Status = queryTicketReply.Status;
		reply.ErrorCode = queryTicketReply.ErrorCode;
		reply.ErrorMessage = queryTicketReply.ErrorMessage;
		
		return reply;
	}

	/*
	 * 退单/退票
	 */
	@Override
	public CTMSRefundTicketReply RefundTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSRefundTicketReply reply = new CTMSRefundTicketReply();
		
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.order.refundOrder");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", "{\"cinemaLinkId\":\""+userCinema.getCinemaId()+"\",\"orderId\":\""+order.getOrderBaseInfo().getSubmitOrderCode()+"\"}");
		param.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String refundOrderResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
		System.out.println("退票返回："+refundOrderResult);
		Gson gson = new Gson();
		YkRefundOrderResult ykResult = gson.fromJson(refundOrderResult, YkRefundOrderResult.class);
		
		if("0".equals(ykResult.getRetCode())){
			if("SUCCESS".equals(ykResult.getData().getBizCode())){
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Refund.getStatusCode());
				order.getOrderBaseInfo().setRefundTime(new Date());		//退票时间
				
				reply.Status = StatusEnum.Success;
			} else {
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = ykResult.getData().getBizCode();
			reply.ErrorMessage=ykResult.getData().getBizMsg();
		} else {
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = ykResult.getRetCode();
			reply.ErrorMessage = ykResult.getRetMsg();
		}
		
		return reply;
	}

	/*
	 * 查询选座票订单
	 */
	@Override
	public CTMSQueryOrderReply QueryOrder(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSQueryOrderReply reply = new CTMSQueryOrderReply();
		
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.order.getOrderInfo");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", "{\"cinemaLinkId\":\""+userCinema.getCinemaId()+"\",\"lockOrderId\":\""+order.getOrderBaseInfo().getLockOrderCode()+"\"}");
		param.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String getOrderInfoResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
		System.out.println("查询订单返回："+getOrderInfoResult);
		Gson gson = new Gson();
		YkGetOrderInfoResult ykResult = gson.fromJson(getOrderInfoResult, YkGetOrderInfoResult.class);
		
		if("0".equals(ykResult.getRetCode())){
			if("SUCCESS".equals(ykResult.getData().getBizCode())){
				order.getOrderBaseInfo().setScreenCode(ykResult.getData().getData().getHallId());	//影厅编码
				order.getOrderBaseInfo().setFilmCode(ykResult.getData().getData().getFilmCode());	//影片编码
				order.getOrderBaseInfo().setFilmName(ykResult.getData().getData().getShortName());	//影片名称
				order.getOrderBaseInfo().setSessionTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(ykResult.getData().getData().getShowDateTime()));	//放映时间
				List<com.boot.security.server.api.ctms.reply.YkGetOrderInfoResult.DataBean.OrderInfo.Tickets> ticketList = ykResult.getData().getData().getTickets();
				if(ticketList != null && ticketList.size()>0){
					for(int i=0;i<ticketList.size();i++){
						if(ticketList.get(i).getTicketNo().equals(order.getOrderSeatDetails().get(i).getFilmTicketCode())){	//票号相同
							order.getOrderSeatDetails().get(i).setRowNum(ticketList.get(i).getRowId());		//行号
							order.getOrderSeatDetails().get(i).setColumnNum(ticketList.get(i).getColumnId());	//列号
							
							if("Y".equals(ticketList.get(i).getPrintStatus())){	//打票状态：Y 已打票 N 未打票
								order.getOrderSeatDetails().get(i).setPrintFlag(1);
								order.getOrderBaseInfo().setPrintTime(new Date());	//粤科没有返回打印时间
							} else {
								order.getOrderSeatDetails().get(i).setPrintFlag(0);
							}
							//退票状态：Y 已退票
							if("Y".equals(ticketList.get(i).getRefundStatus())){
								order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Refund.getStatusCode());
								order.getOrderBaseInfo().setRefundTime(new Date());
							}
						}
					}
				}
				
				reply.Status = StatusEnum.Success;
			} else {
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = ykResult.getData().getBizCode();
			reply.ErrorMessage=ykResult.getData().getBizMsg();
			
		} else {
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = ykResult.getRetCode();
			reply.ErrorMessage = ykResult.getRetMsg();
		}
		
		return reply;
	}

	/*
	 * 查询取票信息
	 */
	@Override
	public CTMSQueryTicketReply QueryTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSQueryTicketReply reply = new CTMSQueryTicketReply();
		
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.order.getTicketInfo");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", "{\"cinemaLinkId\":\""+userCinema.getCinemaId()+"\",\"confirmationId\":\""+order.getOrderBaseInfo().getPrintNo()+"\"}");
		param.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String getTicketInfoResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
		System.out.println("影票信息返回："+getTicketInfoResult);
		Gson gson = new Gson();
		YkGetTicketInfoResult ykResult = gson.fromJson(getTicketInfoResult, YkGetTicketInfoResult.class);
		
		if("0".equals(ykResult.getRetCode())){
			if("SUCCESS".equals(ykResult.getData().getBizCode())){
				order.getOrderBaseInfo().setPrintpassword(ykResult.getData().getData().getPrintId());	//打印编号
				order.getOrderBaseInfo().setSessionTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(ykResult.getData().getData().getShowDateTime()));
				order.getOrderBaseInfo().setScreenCode(ykResult.getData().getData().getHallId());
				order.getOrderBaseInfo().setFilmCode(ykResult.getData().getData().getFilmCode());
				order.getOrderBaseInfo().setFilmName(ykResult.getData().getData().getShortName());
				order.getOrderBaseInfo().setCreated(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(ykResult.getData().getData().getCreateDateTime()));
				List<com.boot.security.server.api.ctms.reply.YkGetTicketInfoResult.DataBean.TicketBean.Tickets> tickets = ykResult.getData().getData().getTickets();
				for(int i=0;i<tickets.size();i++){
					if(tickets.get(i).getTicketNo().equals(order.getOrderSeatDetails().get(i).getFilmTicketCode())){
						order.getOrderSeatDetails().get(i).setTicketInfoCode(tickets.get(i).getInfoCode());	//二维码
						order.getOrderSeatDetails().get(i).setPrice(Double.valueOf(tickets.get(i).getTicketPrice()));
						order.getOrderSeatDetails().get(i).setFee(Double.valueOf(tickets.get(i).getTicketFee()));
						if("Y".equals(tickets.get(i).getPrintStatus())){	//打票状态：已打票
							order.getOrderSeatDetails().get(i).setPrintFlag(1);
							order.getOrderBaseInfo().setPrintStatus(1);
							order.getOrderBaseInfo().setPrintTime(new Date());
						} else {
							order.getOrderSeatDetails().get(i).setPrintFlag(0);
							order.getOrderBaseInfo().setPrintStatus(0);
						}
						//退票状态：已退票
						if("Y".equals(tickets.get(i).getRefundStatus())){	
							order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Refund.getStatusCode());
							order.getOrderBaseInfo().setRefundTime(new Date());
						}
					}
				}
				reply.Status = StatusEnum.Success;
			} else {
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = ykResult.getData().getBizCode();
			reply.ErrorMessage = ykResult.getData().getBizMsg();
		} else {
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = ykResult.getRetCode();
			reply.ErrorMessage = ykResult.getRetMsg();
		}
		
		return reply;
	}

	/*
	 * 确认出票
	 */
	@Override
	public CTMSFetchTicketReply FetchTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSFetchTicketReply reply = new CTMSFetchTicketReply();
		
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.ticket.printTicket");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", "{\"cinemaLinkId\":\""+userCinema.getCinemaId()+"\",\"printId\":\""+order.getOrderBaseInfo().getPrintpassword()+"\"}");
		param.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String printTicketResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
//		System.out.println("确认出票返回："+printTicketResult);
		Gson gson = new Gson();
		YkPrintTicketResult ykResult = gson.fromJson(printTicketResult, YkPrintTicketResult.class);
		
		if("0".equals(ykResult.getRetCode())){
			if("SUCCESS".equals(ykResult.getData().getBizCode())){
				order.getOrderBaseInfo().setPrintStatus(1);
				order.getOrderBaseInfo().setPrintTime(new Date());
				
				reply.Status = StatusEnum.Success;
			} else {
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = ykResult.getData().getBizCode();
			reply.ErrorMessage=ykResult.getData().getBizMsg();
		} else {
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = ykResult.getRetCode();
			reply.ErrorMessage = ykResult.getRetMsg();
		}
		
		return reply;
	}

	/*
	 * 签名算法
	 */
	private static String createSign(String pKeyInfo, Map<String, String> param) {
		StringBuffer queryParams = new StringBuffer();
		for (Map.Entry<String, String> entry : param.entrySet()) {
			String value = entry.getValue();
			if (value != null) {
				queryParams.append(entry.getKey() + entry.getValue());
			}
		}
		return MD5Util.MD5Encode(queryParams.toString() + pKeyInfo, "UTF-8").toLowerCase();
	}
	
	/*
	 * 拼接请求url
	 */
	private static String createVisitUrl(String url, String path, String authCode, String queryParams, String sign) {
		if (url.endsWith("//")) {
			url = url.substring(0, url.length() - 1);
		}
		return url + path + "?" + queryParams + "&sign=" + sign;
	}
	
	private static String FormatParam(Map<String, String> param) {
		StringBuffer queryParams = new StringBuffer();
		for (Map.Entry<String, String> entry : param.entrySet()) {
			String value = entry.getValue();
			if (value != null)
				if (entry.getKey() == "data") {
					queryParams.append(entry.getKey() + "=" + URLEncoder.encode(entry.getValue()) + "&");
				} else {
					queryParams.append(entry.getKey() + "=" + entry.getValue() + "&");
				}
		}
		if (queryParams.length() > 0)
			queryParams.deleteCharAt(queryParams.length() - 1);// remove last'&'
		return queryParams.toString();
	}
	
	/*
	 * 生成第三方锁座流水号：长度不 超 20 位，建议用：时间戳 +6 位随机值组
	 */
	private static String creatOutLockId(){
		String timestamp=String.valueOf(System.currentTimeMillis());
		StringBuffer str = new StringBuffer();
		for(int i=0;i<6;i++){
			int num=(int) (Math.random()*10);
			str.append(String.valueOf(num));
		}
		
		return timestamp+str;
	}
	
	public static void main(String[] args) throws Exception {
		//Dy1905GetCinemaResult result=QueryCinemaId();
		//System.out.println(result.getGetCinemaResult().getCinemas().getCinema().get(0).getCinemaName());
		
		
		if (StatusEnum.Success.getStatusCode().equals("Success")) {
			System.out.println(111);
		} else {
			System.out.println(222);
		}
	}
}
