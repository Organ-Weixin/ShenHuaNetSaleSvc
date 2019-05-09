package com.boot.security.server.api.ctms.reply;

import java.math.BigDecimal;
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
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.util.Base64Utils;

import com.alibaba.fastjson.JSONObject;
import com.boot.security.server.api.ctms.reply.YkConfirmOrderResult.DataBean.OrderBean;
import com.boot.security.server.api.ctms.reply.YkConfirmOrderResult.DataBean.OrderBean.Tickets;
import com.boot.security.server.api.ctms.reply.YkGetCardConsumeRecordsResult.DataBean.ConsumeRecords;
import com.boot.security.server.api.ctms.reply.YkGetCardGradeListResult.DataBean.CardBean;
import com.boot.security.server.api.ctms.reply.YkGetCardRechargeRecordsResult.DataBean.CardRechargeRecords;
import com.boot.security.server.api.ctms.reply.YkGetCinemasResult.DataBean.YkCinema;
import com.boot.security.server.api.ctms.reply.YkGetCinemasResult.DataBean.YkCinema.Halls;
import com.boot.security.server.api.ctms.reply.YkGetGoodsResult.DataBean.GoodsBean.GoodsResult;
import com.boot.security.server.api.ctms.reply.YkGetScheduleSoldSeatsResult.DataBean.SoldSeats.SectionList;
import com.boot.security.server.api.ctms.reply.YkGetScheduleSoldSeatsResult.DataBean.SoldSeats.SectionList.SeatsBean;
import com.boot.security.server.api.ctms.reply.YkGetSchedulesResult.dataBean.ScheduleBean;
import com.boot.security.server.api.ctms.reply.YkGetSeatsResult.DataBean.CinemaBean.SeatPlan;
import com.boot.security.server.api.ctms.reply.YkGetSeatsResult.DataBean.CinemaBean.SeatPlan.Sections;
import com.boot.security.server.api.ctms.reply.YkGetSeatsResult.DataBean.CinemaBean.SeatPlan.Sections.Seats;
import com.boot.security.server.api.ctms.reply.YkQueryPriceResult.DataBean.CardPrice;
import com.boot.security.server.api.ctms.reply.YkQueryPriceResult.DataBean.CardPrice.TicketsPrice;
import com.boot.security.server.api.ctms.reply.YkqueryBalanceResult.DataBean.BalanceBean;
import com.boot.security.server.model.CardChargeTypeEnum;
import com.boot.security.server.model.CardTradeRecord;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Goods;
import com.boot.security.server.model.GoodsOrderStatusEnum;
import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodsorderdetails;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.model.Membercardlevel;
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
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.GoodsServiceImpl;
import com.boot.security.server.service.impl.MemberCardLevelServiceImpl;
import com.boot.security.server.service.impl.MemberCardServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.ScreenseatinfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.utils.HttpHelper;
import com.boot.security.server.utils.MD5Util;
import com.boot.security.server.utils.SpringUtil;
import com.google.gson.Gson;

import cn.cmts.main.webservice.WebService;

public class YkInterface implements ICTMSInterface {
	CinemaServiceImpl _cinemaService = SpringUtil.getBean(CinemaServiceImpl.class);
	ScreeninfoServiceImpl _screeninfoService = SpringUtil.getBean(ScreeninfoServiceImpl.class);
	SessioninfoServiceImpl _sessioninfoService = SpringUtil.getBean(SessioninfoServiceImpl.class);
	ScreenseatinfoServiceImpl _screenseatinfoService = SpringUtil.getBean(ScreenseatinfoServiceImpl.class);
	FilminfoServiceImpl _filminfoService = SpringUtil.getBean(FilminfoServiceImpl.class);
	MemberCardServiceImpl memberCardService = SpringUtil.getBean(MemberCardServiceImpl.class);
	MemberCardLevelServiceImpl memberCardLevelService = SpringUtil.getBean(MemberCardLevelServiceImpl.class);
	GoodsServiceImpl goodsService = SpringUtil.getBean(GoodsServiceImpl.class);
	/*
	 * 查询影院信息
	 */
	@Override
	public CTMSQueryCinemaReply QueryCinema(Usercinemaview userCinema) throws Exception {
		CTMSQueryCinemaReply reply = new CTMSQueryCinemaReply();
		
		Map<String,String> param = new LinkedHashMap<String,String>();
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
		
		Map<String,String> param = new LinkedHashMap<String,String>();
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
				_filminfoService.save(film);
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
	 *、粤科的营业日：是指影院的实际营业时间，即：当天的 06:00:00 到第二天的 05:59:59； 
	 *	示例：showDateTime =2016-01-06 02:00 的营业日为 2016-01-05
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
		// 将结束时间减上1天以便符合粤科接口规范
		Date end = EndDate;
		calendar.setTime(end);
		calendar.add(calendar.DATE, -1);
		end = calendar.getTime();

		Map<String, String> param = new LinkedHashMap<String,String>();
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
				Date newStartDate = new Date(StartDate .getTime() - 1000*60*60*18);	//开始日期前一天的6:00:00
				Date newEndDate = new Date(EndDate .getTime() + 1000*60*60*6);		//结束日期后一天的6:00:00
				_sessioninfoService.deleteByCinemaCodeAndDate(userCinema.getUserId(), userCinema.getCinemaCode(), newStartDate, newEndDate);
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
			
			Map<String,String> param = new LinkedHashMap<String,String>();
			param.put("api", "ykse.partner.seat.getScheduleSoldSeats");
			param.put("channelCode",userCinema.getDefaultUserName());
			param.put("data", data);
			param.put("timestamp",String.valueOf(System.currentTimeMillis()));
			param.put("v", "1.0");
			
			String sign = createSign(userCinema.getDefaultPassword(), param);
			String getScheduleSoldSeats = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
					userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
//			System.out.println("座位状态返回："+getScheduleSoldSeats);
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
		
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.seat.lockSeats");
		param.put("channelCode",userCinema.getDefaultUserName());
		param.put("data",data);
		param.put("timestamp",String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String getLockSeatsResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
		
//		System.out.println("锁座返回："+getLockSeatsResult);
		Gson gson = new Gson();
		YkLockSeatsResult lockSeatsResult = gson.fromJson(getLockSeatsResult, YkLockSeatsResult.class);
		
		Orders newOrder = order.getOrderBaseInfo();
		if ("0".equals(lockSeatsResult.getRetCode())) {
			if("SUCCESS".equals(lockSeatsResult.getData().getBizCode())){
				Date nowDate = new Date();
				newOrder.setLockOrderCode(lockSeatsResult.getData().getData().getLockOrderId());
				newOrder.setLockTime(nowDate);
				newOrder.setAutoUnlockDatetime(new Date(nowDate.getTime()+10*60*1000));		//粤科没有自动解锁时间返回，此处默认锁定10分钟			
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
//						order.getOrderSeatDetails().get(i).setFee(Double.valueOf(ticketsList.get(i).getServiceFee()));	//服务费
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
//		System.out.println("退票返回："+refundOrderResult);
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
//		System.out.println("查询订单返回："+getOrderInfoResult);
		Gson gson = new Gson();
		YkGetOrderInfoResult ykResult = gson.fromJson(getOrderInfoResult, YkGetOrderInfoResult.class);
		
		if("0".equals(ykResult.getRetCode())){
			if("SUCCESS".equals(ykResult.getData().getBizCode())){
				order.getOrderBaseInfo().setScreenCode(ykResult.getData().getData().getHallId());	//影厅编码
				order.getOrderBaseInfo().setFilmCode(ykResult.getData().getData().getFilmCode());	//影片编码
				order.getOrderBaseInfo().setFilmName(ykResult.getData().getData().getShortName());	//影片名称
				order.getOrderBaseInfo().setSessionTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(ykResult.getData().getData().getShowDateTime()));	//放映时间
				List<com.boot.security.server.api.ctms.reply.YkGetOrderInfoResult.DataBean.OrderInfo.Tickets> ticketList = ykResult.getData().getData().getTickets();
				if(ticketList != null && ticketList.size()>0){
					for(int i=0;i<ticketList.size();i++){
						if(ticketList.get(i).getTicketNo().equals(order.getOrderSeatDetails().get(i).getFilmTicketCode())){	//票号相同
							order.getOrderSeatDetails().get(i).setRowNum(ticketList.get(i).getRowId());		//行号
							order.getOrderSeatDetails().get(i).setColumnNum(ticketList.get(i).getColumnId());	//列号
							
							if("Y".equals(ticketList.get(i).getPrintStatus())){	//打票状态：Y 已打票 N 未打票
								order.getOrderSeatDetails().get(i).setPrintFlag(1);
								order.getOrderBaseInfo().setPrintStatus(1);
							} else {
								order.getOrderSeatDetails().get(i).setPrintFlag(0);
								order.getOrderBaseInfo().setPrintStatus(0);
							}
							//退票状态：Y 已退票
							if("Y".equals(ticketList.get(i).getRefundStatus())){
								order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Refund.getStatusCode());
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
//		System.out.println("影票信息返回："+getTicketInfoResult);
		Gson gson = new Gson();
		YkGetTicketInfoResult ykResult = gson.fromJson(getTicketInfoResult, YkGetTicketInfoResult.class);
		
		if("0".equals(ykResult.getRetCode())){
			if("SUCCESS".equals(ykResult.getData().getBizCode())){
				order.getOrderBaseInfo().setPrintpassword(ykResult.getData().getData().getPrintId());	//打印编号
				order.getOrderBaseInfo().setSessionTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(ykResult.getData().getData().getShowDateTime()));
				order.getOrderBaseInfo().setScreenCode(ykResult.getData().getData().getHallId());
				order.getOrderBaseInfo().setFilmCode(ykResult.getData().getData().getFilmCode());
				order.getOrderBaseInfo().setFilmName(ykResult.getData().getData().getShortName());
				order.getOrderBaseInfo().setCreated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(ykResult.getData().getData().getCreateDateTime()));
				List<com.boot.security.server.api.ctms.reply.YkGetTicketInfoResult.DataBean.TicketBean.Tickets> tickets = ykResult.getData().getData().getTickets();
				for(int i=0;i<tickets.size();i++){
					if(tickets.get(i).getTicketNo().equals(order.getOrderSeatDetails().get(i).getFilmTicketCode())){
						order.getOrderSeatDetails().get(i).setTicketInfoCode(tickets.get(i).getInfoCode());	//二维码
						order.getOrderSeatDetails().get(i).setPrice(Double.valueOf(tickets.get(i).getTicketPrice()));
						order.getOrderSeatDetails().get(i).setFee(Double.valueOf(tickets.get(i).getTicketFee()));
						if("Y".equals(tickets.get(i).getPrintStatus())){	//打票状态：已打票
							order.getOrderSeatDetails().get(i).setPrintFlag(1);
							order.getOrderBaseInfo().setPrintStatus(1);
						} else {
							order.getOrderSeatDetails().get(i).setPrintFlag(0);
							order.getOrderBaseInfo().setPrintStatus(0);
						}
						//退票状态：已退票
						if("Y".equals(tickets.get(i).getRefundStatus())){	
							order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Refund.getStatusCode());
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
	/*
	 * 敏感数据加密（如会员卡密码）
	 * password 明文
	 * key		密钥
	 * return 	密文
	 */
	private static String MD5AESPassword(String password,String key) throws Exception{
		/*final String hexDigits[] = { "0", "1", "2", "3", "4", "5","6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
		StringBuffer strbuf = new StringBuffer();
		Random rand = new Random();
		for(int i=0;i<hexDigits.length;i++){
			strbuf.append(hexDigits[rand.nextInt(hexDigits.length)]);	//随机生成 16 个字节的加密向量 iv
		}*/
		// Base64 编码 iv,截取前 22 个字节(即不要‘==’)
//		String ivBase64 = Base64Utils.encodeToString(strbuf.toString().getBytes("UTF-8")).substring(0, 22);
		String ivBase64 = Base64Utils.encodeToString("YKSE1234YKSE1234".getBytes("UTF-8")).substring(0, 22);
		//对密钥 key 使用 md5(32)进行加密，并转换成小写，然后截取前 16 位字节得到 md5key
		byte[] keyBytes = WebService.getMD5ofStr(key).toLowerCase().substring(0, 16).getBytes("UTF-8");
		
		//对 明文数据 使用 md5(32)进行加密，并转换成小写得到 plaintextHash
		String plaintextHash=WebService.getMD5ofStr(password).toLowerCase();
		//将 明文数据 与 plaintextHash 按前后顺序合并得到 mergePlaintext
		byte[] plainTextbytes = plainTextPadding((password + plaintextHash).getBytes("UTF-8"));
		//获取随机向量
//      String iv = RandomUtils.randomCharsAndDigits(16);
        String iv = "YKSE1234YKSE1234";
        byte[] ivbytes = iv.getBytes("UTF-8");
		//对 mergePlaintext使用AES加密（密钥使用 md5key），然后再使用Base64编码得到 ciphertext
		String ciphertext = Base64Utils.encodeToString(encrypt(plainTextbytes, keyBytes, ivbytes));
		
		return ivBase64+ciphertext;
	}
	
	private static byte[] encrypt(byte[] plainText, byte[] key, byte[] initialVector) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        plainText = cipher.doFinal(plainText);
        return plainText;
    }
	
	//补0
	private static byte[] plainTextPadding(byte[] plainText) {
        byte[] paddingText;
        int padding = 16 - plainText.length % 16;
        if (padding > 0) {
            paddingText = new byte[plainText.length + padding];
            System.arraycopy(plainText, 0, paddingText, 0, plainText.length);
            for (int i = plainText.length; i < paddingText.length; i++) {
                paddingText[i] = 0x00;
            }
        } else {
            paddingText = plainText;
        }
        return paddingText;
    }
	/**
     * AES解密
     *
     * @param encryptedText 密文
     * @param key           密钥
     * @return 明文
	 * @throws Exception 
     */
    public static String decrypt(String encryptedText, String key) throws Exception {
        try {
            //截取前22加密向量并且用Base64解码
            byte[] ivbytes = Base64Utils.decodeFromString(encryptedText.substring(0, 22) + "==");
            System.out.println(ivbytes);
            //获得加密数据
            byte[] cipheredBytes = Base64Utils.decodeFromString(encryptedText.substring(22));
            System.out.println(new String(cipheredBytes));
            //对key进行md5加密并转小写，然后获取md5key的字节码
            byte[] keyBytes = WebService.getMD5ofStr(key).toLowerCase().getBytes("UTF-8");
            System.out.println(keyBytes);
            //数据解密
            String decryptStr = new String(decrypt(cipheredBytes, keyBytes, ivbytes), "UTF-8").trim();
            String plainText = decryptStr.substring(0, decryptStr.length() - 32);
            String md5 = decryptStr.substring(decryptStr.length() - 32);
            //数据验证
            if (!WebService.getMD5ofStr(plainText).toLowerCase().equals(md5.toLowerCase())) {
                System.out.println("加密数据校验失败");
            }
            return plainText;
        } catch (Exception e) {
//        	System.out.println(e.toString());
            throw e;
        }
    }
    private static byte[] decrypt(byte[] cipherText, byte[] key, byte[] initialVector) throws Exception {
        SecretKeySpec secretKeySpecy = new SecretKeySpec(key, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");//"算法/模式/补码方式"
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpecy, ivParameterSpec);
        cipherText = cipher.doFinal(cipherText);
        return cipherText;
    }
		 
	public static void main(String[] args) throws Exception {
		//Dy1905GetCinemaResult result=QueryCinemaId();
		//System.out.println(result.getGetCinemaResult().getCinemas().getCinema().get(0).getCinemaName());
		
		
	}

	/*
	 * 会员卡登录
	 */
	@Override
	public CTMSLoginCardReply LoginCard(Usercinemaview userCinema, String CardNo, String CardPassword)
			throws Exception {
		CTMSLoginCardReply reply = new CTMSLoginCardReply();
		
		//调用查询会员卡余额接口
		String cardPassword = MD5AESPassword(CardPassword,userCinema.getDefaultPassword());	//使用加密的会员卡 的密码
		JSONObject  input=new JSONObject();
		input.put("cinemaLinkId", userCinema.getCinemaId());
		input.put("cardNumber", CardNo);
		input.put("cardPassword", cardPassword);
		String data=input.toJSONString();

		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.card.queryBalance");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", data);
		param.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String queryBalanceResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
		System.out.println("会员卡余额返回："+queryBalanceResult);
		Gson gson = new Gson();
		YkqueryBalanceResult ykResult = gson.fromJson(queryBalanceResult, YkqueryBalanceResult.class);
		
		if("0".equals(ykResult.getRetCode())){
			if("SUCCESS".equals(ykResult.getData().getBizCode())){
				BalanceBean balance = ykResult.getData().getData();
				if (balance != null){
					Membercard memercard = memberCardService.getByCardNo(userCinema.getCinemaCode(), CardNo);
					if(memercard != null){	//修改
						memercard.setBalance(Double.valueOf(balance.getBalance()));
						memercard.setScore((int) Math.round(Double.valueOf(balance.getAccumulationPoints())));
						memercard.setUpdated(new Date());
						memberCardService.Update(memercard);
						
					} else {	//新增
						memercard = new Membercard();
						memercard.setCinemaCode(userCinema.getCinemaCode());
						memercard.setCardNo(balance.getCardNumber());
						memercard.setCardPassword(CardPassword);	//暂存明文
						memercard.setBalance(Double.valueOf(balance.getBalance()));
						memercard.setScore((int) Math.round(Double.valueOf(balance.getAccumulationPoints())));
						memercard.setCreateTime(new Date());
						memercard.setStatus(0);
						memberCardService.Save(memercard);
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
	 * 查询会员卡信息
	  */
	@Override
	public CTMSQueryCardReply QueryCard(Usercinemaview userCinema, String CardNo, String CardPassword) throws Exception {
		CTMSQueryCardReply reply = new CTMSQueryCardReply();
		
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.card.getCardDetail");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", "{\"cardNumber\":\""+CardNo+"\",\"cinemaLinkId\":\""+userCinema.getCinemaId()+"\"}");
		param.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String getCardDetailResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
		System.out.println("会员卡信息返回："+getCardDetailResult);
		Gson gson = new Gson();
		YkGetCardDetailResult ykResult = gson.fromJson(getCardDetailResult, YkGetCardDetailResult.class);
		
		if("0".equals(ykResult.getRetCode())){
			if("SUCCESS".equals(ykResult.getData().getBizCode())){
				com.boot.security.server.api.ctms.reply.YkGetCardDetailResult.DataBean.CardBean card = ykResult.getData().getData();
				if(card != null){
					Membercard memercard = memberCardService.getByCardNo(userCinema.getCinemaCode(), CardNo);
					if(memercard != null){	//修改
						YkModelMapper.MapToEntity(card, memercard);
						memercard.setUpdated(new Date());
						memberCardService.Update(memercard);
						
					} else {	//新增
						memercard = new Membercard();
						YkModelMapper.MapToEntity(card, memercard);
						memercard.setCinemaCode(userCinema.getCinemaCode());
						memercard.setCardNo(card.getCardNumber());
						memercard.setCreateTime(new Date());
						memercard.setStatus(0);
						memberCardService.Save(memercard);
					}
					reply.setGradeType(card.getGradeType());	//卡类型，充值接口使用
				}
				LoginCard(userCinema,  CardNo,  CardPassword);	//调用查询卡余额接口,查余额、积分
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
	 * 得到会员卡的折扣价
	 */
	@Override
	public CTMSQueryDiscountReply QueryDiscount(Usercinemaview userCinema, String TicketCount, String CardNo,
			String CardPassword, String LevelCode, String SessionCode, String SessionTime, String FilmCode,
			String ScreenType, String ListingPrice, String LowestPrice) throws Exception {
		CTMSQueryDiscountReply reply = new CTMSQueryDiscountReply();
		
		Sessioninfo sessioninfo=_sessioninfoService.getBySessionCode(userCinema.getUserId(), userCinema.getCinemaCode(), SessionCode);
		List<Screenseatinfo> groupscreenseats=_screenseatinfoService.getGroupByGroupCode(userCinema.getCinemaCode(), sessioninfo.getScreenCode());
		JSONObject  input=new JSONObject();
		input.put("cinemaLinkId", userCinema.getCinemaId());
		input.put("cardNumber", CardNo);
		input.put("sectionId", groupscreenseats.get(0).getGroupCode()); 
		input.put("scheduleId", sessioninfo.getSessionId());
		input.put("scheduleKey", sessioninfo.getSessionKey());
		String data=input.toJSONString();

		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.card.queryPrice");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", data);
		param.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String queryPriceResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
		System.out.println("会员卡票价返回："+queryPriceResult);
		Gson gson = new Gson();
		YkQueryPriceResult ykResult = gson.fromJson(queryPriceResult, YkQueryPriceResult.class);
		
		if("0".equals(ykResult.getRetCode())){
			if("SUCCESS".equals(ykResult.getData().getBizCode())){
				CardPrice cardPrice = ykResult.getData().getData();
				if(cardPrice.getTickets() != null){
					for(TicketsPrice ticket:cardPrice.getTickets()){
						if("成人票".equals(ticket.getTicketType())){	//暂时取成人票的会员价
							reply.setCinemaCode(userCinema.getCinemaCode());
							reply.setPrice(Float.valueOf(ticket.getPrice()));
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
	 * 会员卡支付(凤凰佳影此接口单独调用)
	 * */
	@Override
	public CTMSCardPayReply CardPay(Usercinemaview userCinema, String CardNo, String CardPassword, float PayAmount,
			String SessionCode, String FilmCode, String TicketNum) throws Exception {
		
		return null;
	}

	/*
	 * 会员卡支付撤销(凤凰佳影此接口单独调用)
	 */
	@Override
	public CTMSCardPayBackReply CardPayBack(Usercinemaview userCinema, String CardNo, String CardPassword,
			String TradeNo, float PayBackAmount) throws Exception {
		
		return null;
	}

	/*
	 * 查询会员卡交易记录
	 * 粤科分消费记录、充值记录
	 */
	@Override
	public CTMSQueryCardTradeRecordReply QueryCardTradeRecord(Usercinemaview userCinema, String CardNo,
			String CardPassword, String StartDate, String EndDate, String PageSize, String PageNum) throws Exception {
		CTMSQueryCardTradeRecordReply reply = new CTMSQueryCardTradeRecordReply();
		List<CardTradeRecord> totalRecord = new ArrayList<CardTradeRecord>();
		
		//1.查询会员卡余额消费记录
		JSONObject  input=new JSONObject();
		input.put("cinemaLinkId", userCinema.getCinemaId());
		input.put("cardNumber", CardNo);
		input.put("startDate", StartDate); 
		input.put("endDate", EndDate);
		String data=input.toJSONString();
		
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.card.getCardConsumeRecords");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", data);
		param.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String getCardConsumeRecordsResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
		System.out.println("会员卡消费记录返回："+getCardConsumeRecordsResult);
		Gson gson = new Gson();
		YkGetCardConsumeRecordsResult ykConsumeResult = gson.fromJson(getCardConsumeRecordsResult, YkGetCardConsumeRecordsResult.class);
		if("0".equals(ykConsumeResult.getRetCode())){
			if("SUCCESS".equals(ykConsumeResult.getData().getBizCode())){
				for(ConsumeRecords consumeRecord:ykConsumeResult.getData().getDataList()){
					CardTradeRecord cardTradeRecord = new CardTradeRecord();
					cardTradeRecord.setTradeNo(consumeRecord.getBookingId());	//交易号
					cardTradeRecord.setTradeType("消费");
					if(consumeRecord.getConsumeDateTime() != null){
						cardTradeRecord.setTradeTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(consumeRecord.getConsumeDateTime()));
					}
					cardTradeRecord.setTradePrice(Float.valueOf(consumeRecord.getConsumeAmount()));
					cardTradeRecord.setCinemaName(userCinema.getCinemaName());
					totalRecord.add(cardTradeRecord);
				}
				reply.Status = StatusEnum.Success;
			} else {
				reply.Status = StatusEnum.Failure;
				reply.ErrorCode = ykConsumeResult.getData().getBizCode();
				reply.ErrorMessage=ykConsumeResult.getData().getBizMsg();
				return reply;
			}
			
		} else {
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = ykConsumeResult.getRetCode();
			reply.ErrorMessage = ykConsumeResult.getRetMsg();
			return reply;
		}
		
		//2.查询会员卡充值记录 
		Map<String,String> param2 = new LinkedHashMap<String,String>();
		param2.put("api", "ykse.partner.card.getCardRechargeRecords");
		param2.put("channelCode", userCinema.getDefaultUserName());
		param2.put("data", data);
		param2.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param2.put("v", "1.0");
		
		String sign2 = createSign(userCinema.getDefaultPassword(), param2);
		String getCardRechargeRecordsResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param2), sign2), null, "UTF-8");
		System.out.println("会员卡充值记录返回："+getCardRechargeRecordsResult);
		
		YkGetCardRechargeRecordsResult ykRechargeResult = gson.fromJson(getCardRechargeRecordsResult, YkGetCardRechargeRecordsResult.class);
		if("0".equals(ykRechargeResult.getRetCode())){
			if("SUCCESS".equals(ykRechargeResult.getData().getBizCode())){
				for(CardRechargeRecords cardRechargeRecord : ykRechargeResult.getData().getDataList()){
					CardTradeRecord cardTradeRecord2 = new CardTradeRecord();
					cardTradeRecord2.setTradeNo(cardRechargeRecord.getRechargeBookingId());	//交易号
					cardTradeRecord2.setTradeType("充值");
					if(cardRechargeRecord.getRechargeDateTime() != null){
						cardTradeRecord2.setTradeTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(cardRechargeRecord.getRechargeDateTime()));
					}
					cardTradeRecord2.setTradePrice(Float.valueOf(cardRechargeRecord.getRechargeAmount()));
					cardTradeRecord2.setCinemaName(userCinema.getCinemaName());
					totalRecord.add(cardTradeRecord2);
				}
				reply.Status = StatusEnum.Success;
			} else {
				reply.Status = StatusEnum.Failure;
				reply.ErrorCode = ykRechargeResult.getData().getBizCode();
				reply.ErrorMessage=ykRechargeResult.getData().getBizMsg();
				return reply;
			}
		} else {
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = ykRechargeResult.getRetCode();
			reply.ErrorMessage = ykRechargeResult.getRetMsg();
			return reply;
		}
		
		reply.setCardTradeRecords(totalRecord);
		return reply;
	}

	/*
	 * 会员卡充值
	 */
	@Override
	public CTMSCardChargeReply CardCharge(Usercinemaview userCinema, String CardNo, String CardPassword,
			CardChargeTypeEnum ChargeType, float ChargeAmount) throws Exception {
		CTMSCardChargeReply reply = new CTMSCardChargeReply();
		
		CTMSQueryCardReply querycard = QueryCard(userCinema, CardNo, CardPassword); //调用查询会员卡接口
		if(StatusEnum.Failure.equals(querycard.Status)){
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = querycard.ErrorCode;
			reply.ErrorMessage = querycard.ErrorMessage;
			return reply;
		}
		String gradeType = querycard.getGradeType();
		if("V".equals(gradeType) || "T".equals(gradeType)){ //只有等级类型为储值卡和次数卡的会员卡，才能充值
			
			JSONObject  input=new JSONObject();
			input.put("cinemaLinkId", userCinema.getCinemaId());
			input.put("cardNumber", CardNo);
			input.put("outTradeNo", new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())); 
			input.put("rechargeAmount", String.valueOf(ChargeAmount));
			input.put("description ", "充值");
			String data=input.toJSONString();
			
			Map<String,String> param = new LinkedHashMap<String,String>();
			param.put("api", "ykse.partner.card.recharge");
			param.put("channelCode", userCinema.getDefaultUserName());
			param.put("data", data);
			param.put("timestamp", String.valueOf(System.currentTimeMillis()));
			param.put("v", "1.0");
			
			String sign = createSign(userCinema.getDefaultPassword(), param);
			String rechargeResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
					userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
			System.out.println("会员卡充值返回："+rechargeResult);
			Gson gson = new Gson();
			YkRechargeResult ykResult = gson.fromJson(rechargeResult, YkRechargeResult.class);
			
			if("0".equals(ykResult.getRetCode())){
				if("SUCCESS".equals(ykResult.getData().getBizCode())){
					Membercard memercard = memberCardService.getByCardNo(userCinema.getCinemaCode(), CardNo);
					memercard.setBalance(Double.valueOf(ykResult.getData().getData().getBalance()));
					memercard.setUpdated(new Date());
					memberCardService.Update(memercard);
					
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
		} else {
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = "-1";
			reply.ErrorMessage = "等级类型不是储值卡或次数卡的会员卡，不能充值！";
		}
		
		return reply;
	}

	/*
	 * 查询会员卡等级
	 */
	@Override
	public CTMSQueryCardLevelReply QueryCardLevel(Usercinemaview userCinema) throws Exception {
		CTMSQueryCardLevelReply reply = new CTMSQueryCardLevelReply();
		
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.card.getCardGradeList");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", "{\"cinemaLinkId\":\""+userCinema.getCinemaId()+"\"}");
		param.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String getCardGradeListResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
		System.out.println("查询会员卡等级返回："+getCardGradeListResult);
		Gson gson = new Gson();
		YkGetCardGradeListResult ykResult = gson.fromJson(getCardGradeListResult, YkGetCardGradeListResult.class);
		
		if("0".equals(ykResult.getRetCode())){
			if("SUCCESS".equals(ykResult.getData().getBizCode())){
				List<CardBean> cardlist = ykResult.getData().getDataList().stream().filter(
						(CardBean cc)-> userCinema.getCinemaId().equals(cc.getCinemaLinkId())).collect(Collectors.toList());
				List<Membercardlevel> newcardlevel = new ArrayList<Membercardlevel>();
				for(CardBean card:cardlist){
					Membercardlevel cardlevel = new Membercardlevel();
					cardlevel.setLevelCode(card.getGradeId());
					cardlevel.setLevelName(card.getGradeDesc());
					cardlevel.setCinemaCode(userCinema.getCinemaCode());
					cardlevel.setCardCostFee(Double.valueOf(card.getCardCostFee()));
					cardlevel.setMemberFee(Double.valueOf(card.getMemberFee()));
					newcardlevel.add(cardlevel);
				}
				//删除旧的
				memberCardLevelService.deleteByCinemaCode(userCinema.getCinemaCode());
				//新增
				for(Membercardlevel card : newcardlevel){
					memberCardLevelService.Save(card);
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
	 * 注册会员卡
	 */
	@Override
	public CTMSCardRegisterReply CardRegister(Usercinemaview userCinema, String CardPassword, String LevelCode,
			String InitialAmount, String CardUserName, String MobilePhone, String IDNumber, String Sex)	throws Exception {
		CTMSCardRegisterReply reply = new CTMSCardRegisterReply();
		
		String cardPassword = MD5AESPassword(CardPassword,userCinema.getDefaultPassword());	//使用加密的会员卡 的密码
		Membercardlevel cardlevel =  memberCardLevelService.getByCinemaCodeAndLevelCode(userCinema.getCinemaCode(), LevelCode);
		JSONObject  input=new JSONObject();
		input.put("cinemaLinkId", userCinema.getCinemaId());
		input.put("gradeId", LevelCode);
		input.put("outTradeNo", new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())); //该值全局唯一,长度必须大于 等于 16 位且小于等 于 32 位 
		input.put("cardPassword", cardPassword);
		input.put("cardCostFee", cardlevel.getCardCostFee().toString());
		input.put("memberFee", cardlevel.getMemberFee().toString());
		input.put("firstRechargeAmount", InitialAmount);//该接口的“首次充值”功能当前版本还没实现，所以接口的 firstRechargeAmount 参数在当前版本请设置为 0。
		input.put("mobile", MobilePhone);
		input.put("cardUserName", CardUserName);
		input.put("idCard", IDNumber);
//		input.put("address", "1");
//		input.put("birthdata", "1990-09-09");
		input.put("email", "123@123.com");	//中间件没传邮箱，先写一个固定值
		String data=input.toJSONString();

		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.card.registerCard");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", data);
		param.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String registerCardResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
		System.out.println("注册会员卡返回："+registerCardResult);
		
		Gson gson = new Gson();
		YkRegisterCardResult ykResult = gson.fromJson(registerCardResult, YkRegisterCardResult.class);
		if("0".equals(ykResult.getRetCode())){
			if("SUCCESS".equals(ykResult.getData().getBizCode())){
				//插入数据库
				Membercard membercard = new Membercard();
				membercard.setCinemaCode(userCinema.getCinemaCode());
				membercard.setCardNo(ykResult.getData().getData().getCardNumber());
				membercard.setCardPassword(CardPassword);	//暂存明文
				membercard.setMobilePhone(MobilePhone);
				membercard.setLevelCode(LevelCode);
				membercard.setBalance(Double.valueOf(ykResult.getData().getData().getBalance()));
				membercard.setUserName(CardUserName);
				membercard.setSex(Sex);
				membercard.setCreditNum(IDNumber);
				membercard.setCreateTime(new Date());
				membercard.setStatus(0);
				memberCardService.Save(membercard);
				
				reply.setCardNo(ykResult.getData().getData().getCardNumber());
				reply.setBalance(Float.valueOf(ykResult.getData().getData().getBalance()));
				reply.setCreateTime(new Date());
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
	 *  查询卖品列表
	 */
	@Override
	public CTMSQueryGoodsReply QueryGoods(Usercinemaview userCinema) throws Exception {
		CTMSQueryGoodsReply reply = new CTMSQueryGoodsReply();
		
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.goods.getGoods");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", "{\"cinemaLinkId\":\""+userCinema.getCinemaId()+"\"}");
		param.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String getGoodsResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
//		System.out.println("查询卖品返回："+getGoodsResult);
		
		Gson gson = new Gson();
		YkGetGoodsResult ykResult = gson.fromJson(getGoodsResult, YkGetGoodsResult.class);
		if("0".equals(ykResult.getRetCode())){
			if("SUCCESS".equals(ykResult.getData().getBizCode())){
				List<Goods> goodslist = new ArrayList<Goods>();
				for(GoodsResult goods : ykResult.getData().getData().getGoodsList()){
					Goods newGoods = new Goods();
					newGoods.setCinemaCode(userCinema.getCinemaCode());
					newGoods.setUserId(userCinema.getUserId());
					newGoods.setIsRecommand(0); 	//接口无返回，默认0
					newGoods.setStockCount(0);		//接口无返回，默认0
					newGoods.setShowSeqNo(0);		//接口无返回，默认0
					newGoods.setGoodsStatus(0); 	//接口无返回，默认0
					YkModelMapper.MapToEntity(goods, newGoods);
					goodslist.add(newGoods);
				}
				//删除旧的
				goodsService.deleteByCinemaCode(userCinema.getUserId(),userCinema.getCinemaCode());
				//插入新的
				for(Goods goodsinfo : goodslist){
					goodsService.save(goodsinfo);	
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
	 * 创建卖品订单
	 * 凤凰佳影无此接口，直接返回成功
	 */
	@Override
	public CTMSCreateGoodsOrderReply CreateGoodsOrder(Usercinemaview userCinema, GoodsOrderView order)
			throws Exception {
		CTMSCreateGoodsOrderReply reply = new CTMSCreateGoodsOrderReply();
		reply.setOrderCode(order.getOrderBaseInfo().getLocalOrderCode());
		reply.Status = StatusEnum.Success;
		
		return reply;
	}

	/*
	 * 确认卖品订单
	 */
	@Override
	public CTMSSubmitGoodsOrderReply SubmitGoodsOrder(Usercinemaview userCinema, GoodsOrderView order)
			throws Exception {
		CTMSSubmitGoodsOrderReply reply = new CTMSSubmitGoodsOrderReply();
		
		List<Map<String,String>> goodslist = new ArrayList<Map<String,String>>();
		for(Goodsorderdetails goodsorderdetails : order.getOrderGoodsDetails()){
			Map<String,String> goodsmap = new LinkedHashMap<String,String>();
			goodsmap.put("goodsId", goodsorderdetails.getGoodsCode());
			goodsmap.put("salePrice", goodsorderdetails.getSettlePrice().toString());
			goodsmap.put("count", goodsorderdetails.getGoodsCount().toString());
			goodsmap.put("isPackage", "false");
			if(order.getOrderBaseInfo().getCardNo() != null){	//是否使用会员卡折扣 
				goodsmap.put("isCardDiscount", "true");
			}
			goodslist.add(goodsmap);
		}
		JSONObject  input=new JSONObject();
		input.put("cinemaLinkId", userCinema.getCinemaId());
		input.put("thirdOrderId", order.getOrderBaseInfo().getLocalOrderCode());
		input.put("goodsList", goodslist);
		input.put("mobile", order.getOrderBaseInfo().getMobilePhone());
		if(order.getOrderBaseInfo().getCardNo() != null){	//是否使用会员卡折扣 
			
			Map<String,String> payCardInfo = new LinkedHashMap<String,String>();
			payCardInfo.put("cinemaLinkId", userCinema.getCinemaId());
			payCardInfo.put("cardNumber", order.getOrderBaseInfo().getCardNo());
			payCardInfo.put("cardPassword", MD5AESPassword(order.getOrderBaseInfo().getCardPassword(),userCinema.getDefaultPassword()));
			
			Map<String,Object> payment = new LinkedHashMap<String,Object>();
			payment.put("paymentMethod", "MemberCard");
			payment.put("payCardInfo", payCardInfo);
			
			List<Map<String,Object>> paymentList = new ArrayList<>();
			paymentList.add(payment);
			input.put("paymentList", paymentList);
		}
		String data=input.toJSONString();

		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.order.confirmGoodsOrder");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", data);
		param.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String confirmGoodsOrderResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
//		System.out.println("确认卖品订单返回："+confirmGoodsOrderResult);
		
		Gson gson = new Gson();
		YkConfirmGoodsOrderResult ykResult = gson.fromJson(confirmGoodsOrderResult, YkConfirmGoodsOrderResult.class);
		if("0".equals(ykResult.getRetCode())){
			if("SUCCESS".equals(ykResult.getData().getBizCode())){
				order.getOrderBaseInfo().setOrderCode(ykResult.getData().getData().getGoodsOrderId());
				order.getOrderBaseInfo().setPickUpCode(ykResult.getData().getData().getPickUpCode());
				order.getOrderBaseInfo().setTotalPrice(Double.valueOf(ykResult.getData().getData().getTotalGoodsPrice()));
				order.getOrderBaseInfo().setTotalFee(Double.valueOf(ykResult.getData().getData().getTotalGoodsFee()));
				if("goods_success".equals(ykResult.getData().getData().getOrderStatus())){
					order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Complete.getStatusCode());
					order.getOrderBaseInfo().setSubmitTime(new Date());
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
	 * 查询卖品订单
	 */
	@Override
	public CTMSQueryGoodsOrderReply QueryGoodsOrder(Usercinemaview userCinema, GoodsOrderView order) throws Exception {
		CTMSQueryGoodsOrderReply reply = new CTMSQueryGoodsOrderReply();
		
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.order.getGoodsOrderInfo");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", "{\"cinemaLinkId\":\""+userCinema.getCinemaId()+"\",\"goodsOrderId\":\""+order.getOrderBaseInfo().getOrderCode()+"\"}");
		param.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String getGoodsOrderInfoResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
//		System.out.println("查询卖品订单返回："+getGoodsOrderInfoResult);
		
		Gson gson = new Gson();
		YkGetGoodsOrderInfoResult ykResult = gson.fromJson(getGoodsOrderInfoResult, YkGetGoodsOrderInfoResult.class);
		if("0".equals(ykResult.getRetCode())){
			if("SUCCESS".equals(ykResult.getData().getBizCode())){
				order.getOrderBaseInfo().setTotalPrice(Double.valueOf(ykResult.getData().getData().getTotalGoodsPrice()));
				order.getOrderBaseInfo().setTotalFee(Double.valueOf(ykResult.getData().getData().getTotalGoodsFee()));
				if("Y".equals(ykResult.getData().getData().getPickupStatus())){	//卖品取货状态 
					order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Fetched.getStatusCode());
					order.getOrderBaseInfo().setPickUpTime(new Date());
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
	 * 退卖品
	 */
	@Override
	public CTMSRefundGoodsReply RefundGoods(Usercinemaview userCinema, GoodsOrderView order) throws Exception {
		CTMSRefundGoodsReply reply = new CTMSRefundGoodsReply();
		
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.partner.order.refundGoodsOrder");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", "{\"cinemaLinkId\":\""+userCinema.getCinemaId()+"\",\"goodsOrderId\":\""+order.getOrderBaseInfo().getOrderCode()+"\"}");
		param.put("timestamp", String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String refundGoodsOrderResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route/",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
//		System.out.println("退卖品订单返回："+refundGoodsOrderResult);
		
		Gson gson = new Gson();
		YkRefundGoodsOrderResult ykResult = gson.fromJson(refundGoodsOrderResult, YkRefundGoodsOrderResult.class);
		if("0".equals(ykResult.getRetCode())){
			if("SUCCESS".equals(ykResult.getData().getBizCode())){
				order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Refund.getStatusCode());
				order.getOrderBaseInfo().setRefundTime(new Date());
				
				reply.Status = StatusEnum.Success;
			} else {
				order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.RefundFail.getStatusCode());
				order.getOrderBaseInfo().setErrorMessage(ykResult.getData().getBizMsg());
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = ykResult.getData().getBizCode();
			reply.ErrorMessage=ykResult.getData().getBizMsg();
		} else {
			order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.RefundFail.getStatusCode());
			order.getOrderBaseInfo().setErrorMessage(ykResult.getRetMsg());
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = ykResult.getRetCode();
			reply.ErrorMessage = ykResult.getRetMsg();
		}
		
		return reply;
	}
	
}
