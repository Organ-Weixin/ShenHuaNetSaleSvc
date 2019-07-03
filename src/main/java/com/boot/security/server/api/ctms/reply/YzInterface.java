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

import com.boot.security.server.api.ctms.reply.YzGetCinemas.DataBean.YzCinemas;
import com.boot.security.server.api.ctms.reply.YzGetCinemas.DataBean.YzCinemas.Halls;
import com.boot.security.server.api.ctms.reply.YzGetSchedules.dataBean.ScheduleBean;
import com.boot.security.server.api.ctms.reply.YzGetSeats.DataBean.CinemaBean.SeatPlan;
import com.boot.security.server.api.ctms.reply.YzGetSeats.DataBean.CinemaBean.SeatPlan.Sections;
import com.boot.security.server.api.ctms.reply.YzGetSeats.DataBean.CinemaBean.SeatPlan.Sections.Seats;
import com.boot.security.server.model.CardChargeTypeEnum;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.SessionSeatStatusEnum;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.StatusEnum;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.service.impl.CinemaMiniProgramAccountsServiceImpl;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.GoodsServiceImpl;
import com.boot.security.server.service.impl.GoodsTypeServiceImpl;
import com.boot.security.server.service.impl.MemberCardLevelServiceImpl;
import com.boot.security.server.service.impl.MemberCardServiceImpl;
import com.boot.security.server.service.impl.MembercardrechargeServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.ScreenseatinfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.utils.HttpHelper;
import com.boot.security.server.utils.MD5Util;
import com.boot.security.server.utils.SpringUtil;
import com.google.gson.Gson;

public class YzInterface implements ICTMSInterface {

	CinemaServiceImpl cinemaService = SpringUtil.getBean(CinemaServiceImpl.class);
	ScreeninfoServiceImpl screeninfoService = SpringUtil.getBean(ScreeninfoServiceImpl.class);
	SessioninfoServiceImpl sessioninfoService = SpringUtil.getBean(SessioninfoServiceImpl.class);
	ScreenseatinfoServiceImpl screenseatinfoService = SpringUtil.getBean(ScreenseatinfoServiceImpl.class);
	FilminfoServiceImpl _filminfoService = SpringUtil.getBean(FilminfoServiceImpl.class);
	MemberCardServiceImpl memberCardService = SpringUtil.getBean(MemberCardServiceImpl.class);
	MemberCardLevelServiceImpl memberCardLevelService = SpringUtil.getBean(MemberCardLevelServiceImpl.class);
	MembercardrechargeServiceImpl membercardrechargeService = SpringUtil.getBean(MembercardrechargeServiceImpl.class);
	GoodsServiceImpl goodsService = SpringUtil.getBean(GoodsServiceImpl.class);
	GoodsTypeServiceImpl _goodsTypeService = SpringUtil.getBean(GoodsTypeServiceImpl.class);
	CinemaMiniProgramAccountsServiceImpl _cinemaMiniProgramAccountsService = SpringUtil.getBean(CinemaMiniProgramAccountsServiceImpl.class);
	CouponsServiceImpl _couponsService = SpringUtil.getBean(CouponsServiceImpl.class);
	
	/*
	 * 查影院
	 */
	@Override
	public CTMSQueryCinemaReply QueryCinema(Usercinemaview userCinema) throws Exception {
		CTMSQueryCinemaReply reply = new CTMSQueryCinemaReply();
		
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.lark.partner.cinema.getCinemas");
		param.put("channelCode",userCinema.getDefaultUserName());
		param.put("timestamp",String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String getCinemasResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route",userCinema.getDefaultPassword(), FormatParam(param), sign),null,"UTF-8");
		
		System.out.println("Yz影院返回："+getCinemasResult);
		Gson gson = new Gson();
		YzGetCinemas CinemaListResult = gson.fromJson(getCinemasResult, YzGetCinemas.class);
		if ("0".equals(CinemaListResult.getRetCode())) {
			if("SUCCESS".equals(CinemaListResult.getData().getBizCode())){
				List<YzCinemas> cinemas = CinemaListResult.getData().getDataList().stream().
						filter((YzCinemas cinema)->userCinema.getCinemaCode().equals(cinema.getCinemaId())).collect(Collectors.toList());
				if(cinemas.size() > 0){
					//更新影院信息
	            	Cinema cinema = cinemaService.getByCinemaCode(cinemas.get(0).getCinemaId());
	                cinema.setName(cinemas.get(0).getCinemaName());
//	                cinema.setAddress(cinemas.get(0).getCity());
	                cinema.setScreenCount(cinemas.get(0).getHallCount());
	                cinema.setCinemaId(cinemas.get(0).getCinemaLinkId());	//影院内部编码
	                cinema.setOverRefundTime(Integer.valueOf(cinemas.get(0).getRefundBeforeTime()));
	                cinemaService.update(cinema);
	                
	                //更新影厅信息
	                List<Screeninfo> newScreens = new ArrayList<Screeninfo>();
	                List<Halls> screens=cinemas.get(0).getHallList();
	                for(Halls hall:screens){
	                	Screeninfo screen=new Screeninfo();//先读取本地
	                	screen.setCCode(cinemas.get(0).getCinemaId());
	                	screen.setSCode(hall.getHallCode());
	                	screen.setSName(hall.getHallName());
	                	screen.setSeatCount(hall.getSeatCount());
	                	screen.setType(hall.getHallType());
	                	screen.setUpdateTime(new Date());
	                	newScreens.add(screen);
	                }
	                //先删除旧影影厅
	    			screeninfoService.deleteByCinemaCode(cinemas.get(0).getCinemaId());
	    			//插入影厅信息
	    			for(Screeninfo screen:newScreens){
	    				screeninfoService.save(screen);
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
	 * 影厅座位
	 */
	@Override
	public CTMSQuerySeatReply QuerySeat(Usercinemaview userCinema, Screeninfo screen) throws Exception {
		CTMSQuerySeatReply reply = new CTMSQuerySeatReply();
		
		Map<String,String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.lark.partner.seat.getSeats");
		param.put("channelCode",userCinema.getDefaultUserName());
		param.put("data", "{\"cinemaLinkId\":\""+userCinema.getCinemaId()+"\",\"hallCode\":\""+screen.getSCode()+"\"}");
		param.put("timestamp",String.valueOf(System.currentTimeMillis()));
		param.put("v", "1.0");
		
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String getSeatsResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route", userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
		System.out.println("影厅座位返回："+getSeatsResult);
		Gson gson = new Gson();
		YzGetSeats yzReply = gson.fromJson(getSeatsResult, YzGetSeats.class);
		System.out.println("222"+gson.toJson(yzReply));
		if("0".equals(yzReply.getRetCode())){
			if("SUCCESS".equals(yzReply.getData().getBizCode())){
				List<Screenseatinfo> newScreen = new ArrayList<Screenseatinfo>();
				List<SeatPlan> seatPlan = yzReply.getData().getData().getSeatPlanList();
				for(int i=0;i<seatPlan.size();i++){
					List<Sections> screenseats =seatPlan.get(i).getSectionList();
					for(int j=0;j<screenseats.size();j++){
						List<Seats> seats = screenseats.get(j).getSeatList();
						for(Seats seat:seats){
							Screenseatinfo screenseat=new Screenseatinfo();
							screenseat.setCinemaCode(userCinema.getCinemaCode());
							screenseat.setScreenCode(screen.getSCode());
							screenseat.setSeatCode(seat.getSeatCode());
							screenseat.setGroupCode(screenseats.get(j).getSectionCode());
							screenseat.setRowNum(seat.getRowId());
							screenseat.setColumnNum(seat.getColumnId());
							screenseat.setXCoord(seat.getX());
							screenseat.setYCoord(seat.getY());
							if("Y".equals(seat.getDamaged())){	//已损坏
								screenseat.setStatus("Unavailable");
							} else {
								screenseat.setStatus("Available");
							}
							screenseat.setType(seat.getType());
							if("DL".equals(seat.getType())){		//情侣左座
								screenseat.setLoveFlag("L");
							} else if("DR".equals(seat.getType())){ //情侣右座
								screenseat.setLoveFlag("R");
							} else {
								screenseat.setLoveFlag("N");
							}
							screenseat.setSeatVersion(seatPlan.get(i).getSeatVersion());
							screenseat.setUpdateTime(new Date());
							newScreen.add(screenseat);
						}
					}
				}
				//删除旧影厅座位
				screenseatinfoService.deleteByScreenCode(userCinema.getCinemaCode(), screen.getSCode());
				//插入新影厅座位信息
				for(Screenseatinfo screenseat:newScreen){
					screenseatinfoService.save(screenseat);
				}
				
				reply.Status = StatusEnum.Success;
			} else {
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = yzReply.getData().getBizCode();
			reply.ErrorMessage = yzReply.getData().getBizMsg();
		} else {
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = yzReply.getRetCode();
			reply.ErrorMessage = yzReply.getRetMsg();
		}
		return reply;
	}

	/*
	 * 查影片
	 */
	@Override
	public CTMSQueryFilmReply QueryFilm(Usercinemaview userCinema, Date StartDate, Date EndDate) throws Exception {
		CTMSQueryFilmReply reply = new CTMSQueryFilmReply();
		
		QuerySession(userCinema,StartDate,EndDate);	//调用查询排期列表,然后从数据库读取
		//根据影片名称分组，去除影片重复数据
		List<Sessioninfo> sessions = sessioninfoService.getByCCodeGroupByFilm(userCinema.getUserId(), userCinema.getCinemaCode(), StartDate, EndDate);
		
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
	 * 查排期
	 */
	@Override
	public CTMSQuerySessionReply QuerySession(Usercinemaview userCinema, Date StartDate, Date EndDate) throws Exception {
		CTMSQuerySessionReply reply = new CTMSQuerySessionReply();

		Calendar calendar = new GregorianCalendar();
		// 将开始时间减1天以便能获取到当前早上6点之前的场次
		Date start = StartDate;
		calendar.setTime(start);
		calendar.add(Calendar.DATE, -1);
		start = calendar.getTime();
		// 将结束时间减上1天以便符合粤科接口规范
		Date end = EndDate;
		calendar.setTime(end);
		calendar.add(Calendar.DATE, -1);
		end = calendar.getTime();

		Map<String, String> param = new LinkedHashMap<String,String>();
		param.put("api", "ykse.lark.partner.schedule.getSchedules");
		param.put("channelCode", userCinema.getDefaultUserName());
		param.put("data", "{\"cinemaLinkId\":\"" + userCinema.getCinemaId() + "\",\"endDate\":\""
						 + (new java.text.SimpleDateFormat("yyyy-MM-dd")).format(end) + "\",\"startDate\":\""
						 + (new java.text.SimpleDateFormat("yyyy-MM-dd")).format(start) + "\"}");
		param.put("timestamp", String.valueOf(Calendar.getInstance().getTimeInMillis()));
		param.put("v", "1.0");
		String sign = createSign(userCinema.getDefaultPassword(), param);
		String getSchedulesResult = HttpHelper.httpClientGet(createVisitUrl(userCinema.getUrl(), "/route",
				userCinema.getDefaultPassword(), FormatParam(param), sign), null, "UTF-8");
		
		System.out.println("排期返回："+getSchedulesResult);
		Gson gson = new Gson();
		YzGetSchedules schedules = gson.fromJson(getSchedulesResult, YzGetSchedules.class);
		if("0".equals(schedules.getRetCode())){
			if("SUCCESS".equals(schedules.getData().getBizCode())){
				//更新排期
				List<Sessioninfo> newSessions = new ArrayList<Sessioninfo>();
				for(ScheduleBean sess : schedules.getData().getDataList()){
					Sessioninfo sessioninfo = new Sessioninfo();
					sessioninfo.setCCode(userCinema.getCinemaCode());
					sessioninfo.setSCode(sess.getSessionCode());
					sessioninfo.setScreenCode(sess.getHallCode());
					if(sess.getShowDateTime() != null){
						sessioninfo.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sess.getShowDateTime()));
					}
					if(sess.getFilm() != null){
						sessioninfo.setFilmCode(sess.getFilm().getFilmCode());
						sessioninfo.setFilmName(sess.getFilm().getName());
						sessioninfo.setDuration(sess.getFilm().getDuration());
						sessioninfo.setLanguage(sess.getFilm().getLanguage());
						sessioninfo.setDimensional(sess.getFilm().getDimensional());
					}
					sessioninfo.setUpdateTime(new Date());
					sessioninfo.setStandardPrice(Double.parseDouble(sess.getStandardPrice()));
					sessioninfo.setLowestPrice(Double.parseDouble(sess.getLowestPrice()));
					sessioninfo.setSettlePrice(0.0);		//接口没返回，默认0
					if(sess.getTicketFee() == null || "".equals(sess.getTicketFee())){
						sess.setTicketFee("0");
					}
					sessioninfo.setTicketFee(Double.parseDouble(sess.getTicketFee()));
					sessioninfo.setAddFee(0.0);				//接口没返回，默认0
					sessioninfo.setCinemaAllowance(0.0);	//接口没返回，默认0
					sessioninfo.setIsAvalible(1);
					sessioninfo.setPlaythroughFlag("N");	//接口没返回，默认N，不连场
					sessioninfo.setSequence(1);
					sessioninfo.setUserID(userCinema.getUserId());
					sessioninfo.setSessionId(sess.getScheduleId());
					sessioninfo.setSessionKey(sess.getScheduleKey());
					sessioninfo.setSeatVersion(sess.getSeatVersion());
					newSessions.add(sessioninfo);
				}
				//删除原有的排期
				Date newStartDate = new Date(StartDate .getTime() - 1000*60*60*18);	//开始日期前一天的6:00:00
				Date newEndDate = new Date(EndDate .getTime() + 1000*60*60*6);		//结束日期后一天的6:00:00
				sessioninfoService.deleteByCinemaCodeAndDate(userCinema.getUserId(), userCinema.getCinemaCode(), newStartDate, newEndDate);
				//插入排期信息
				for(Sessioninfo session:newSessions){
					sessioninfoService.save(session);
				}
				reply.Status = StatusEnum.Success;
			} else {
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = schedules.getData().getBizCode();
			reply.ErrorMessage = schedules.getData().getBizMsg();
		} else {
			reply.Status = StatusEnum.Failure;
            reply.ErrorCode = schedules.getRetCode();
			reply.ErrorMessage = schedules.getRetMsg();
		}
		return reply;
	}

	@Override
	public CTMSQuerySessionSeatReply QuerySessionSeat(Usercinemaview userCinema, String SessionCode, SessionSeatStatusEnum Status) throws Exception {
		
		return null;
	}

	@Override
	public CTMSLockSeatReply LockSeat(Usercinemaview userCinema, OrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSReleaseSeatReply ReleaseSeat(Usercinemaview userCinema, OrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSSubmitOrderReply SubmitOrder(Usercinemaview userCinema, OrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryPrintReply QueryPrint(Usercinemaview userCinema, OrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSRefundTicketReply RefundTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryOrderReply QueryOrder(Usercinemaview userCinema, OrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryTicketReply QueryTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSFetchTicketReply FetchTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSLoginCardReply LoginCard(Usercinemaview userCinema, String CardNo, String CardPassword)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryCardReply QueryCard(Usercinemaview userCinema, String CardNo, String CardPassword)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryDiscountReply QueryDiscount(Usercinemaview userCinema, String TicketCount, String CardNo,
			String CardPassword, String LevelCode, String SessionCode, String SessionTime, String FilmCode,
			String ScreenType, String ListingPrice, String LowestPrice) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSCardPayReply CardPay(Usercinemaview userCinema, String CardNo, String CardPassword, float PayAmount,
			float GoodsPayAmount, String SessionCode, String FilmCode, String TicketNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSCardPayBackReply CardPayBack(Usercinemaview userCinema, String CardNo, String CardPassword,
			String TradeNo, float PayBackAmount) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryCardTradeRecordReply QueryCardTradeRecord(Usercinemaview userCinema, String CardNo,
			String CardPassword, String StartDate, String EndDate, String PageSize, String PageNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSCardChargeReply CardCharge(Usercinemaview userCinema, String CardNo, String CardPassword,
			CardChargeTypeEnum ChargeType, float ChargeAmount) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryCardLevelReply QueryCardLevel(Usercinemaview userCinema) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSCardRegisterReply CardRegister(Usercinemaview userCinema, String CardPassword, String LevelCode,
			String InitialAmount, String CardUserName, String MobilePhone, String IDNumber, String Sex)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryGoodsReply QueryGoods(Usercinemaview userCinema) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSCreateGoodsOrderReply CreateGoodsOrder(Usercinemaview userCinema, GoodsOrderView order)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSSubmitGoodsOrderReply SubmitGoodsOrder(Usercinemaview userCinema, GoodsOrderView order)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryGoodsOrderReply QueryGoodsOrder(Usercinemaview userCinema, GoodsOrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSRefundGoodsReply RefundGoods(Usercinemaview userCinema, GoodsOrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSSubmitMixOrderReply SubmitMixOrder(Usercinemaview userCinema, OrderView order, GoodsOrderView goodsorder)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
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
}
