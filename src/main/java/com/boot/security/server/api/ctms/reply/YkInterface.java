package com.boot.security.server.api.ctms.reply;

import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.boot.security.server.api.ctms.reply.Dy1905GetScreenResult.ResBean.ScreensBean.ScreenBean;
import com.boot.security.server.api.ctms.reply.YkGetSchedulesResult.dataBean.ScheduleBean;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.SessionSeatStatusEnum;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.StatusEnum;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.utils.HttpHelper;
import com.boot.security.server.utils.MD5Util;
import com.boot.security.server.utils.XmlToJsonUtil;
import com.google.gson.Gson;

public class YkInterface implements ICTMSInterface {
	private SessioninfoServiceImpl _sessionInfoService;
	private ScreeninfoServiceImpl _screeninfoService;

	public YkInterface() {
		_sessionInfoService = new SessioninfoServiceImpl();
		_screeninfoService=new ScreeninfoServiceImpl();
	}

	public CTMSQuerySessionReply QuerySession(Usercinemaview userCinema, Date StartDate, Date EndDate) throws ParseException {
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
		if (ykReply.getRetCode() == "0" && ykReply.getData().getBizCode() == "SUCCESS"){
			//更新排期
			List<Sessioninfo> newSessions = null;
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
			_sessionInfoService.deleteByCinemaCodeAndDate(userCinema.getUserId(), userCinema.getCinemaCode(), StartDate, EndDate);
			//插入排期信息
			for(Sessioninfo session:newSessions){
				_sessionInfoService.save(session);
			}
			reply.Status = StatusEnum.Success;
		}
		else
        {
            reply.Status = StatusEnum.Failure;
        }
		reply.ErrorCode = ykReply.getRetCode();
		reply.ErrorMessage=ykReply.getRetMsg();
		return reply;
	}

	public static void main(String[] args) {
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setCinemaCode("33010301");
		userCinema.setDefaultUserName("WGLNR");
		userCinema.setDefaultPassword("3A2CA76CCCF22A3D491133529AE8B9B5");
		userCinema.setUrl("http://mcop.yuekeyun.com");
		userCinema.setCinemaId("002");
		Date StartDate = new Date();
		Date EndDate = new Date();
		//System.out.println(QuerySession(userCinema, StartDate, EndDate));
	}

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

	@Override
	public CTMSQueryCinemaReply QueryCinema(Usercinemaview userCinema) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQuerySeatReply QuerySeat(Usercinemaview userCinema, Screeninfo screen) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryFilmReply QueryFilm(Usercinemaview userCinema, Date StartDate, Date EndDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQuerySessionSeatReply QuerySessionSeat(Usercinemaview userCinema, String SessionCode,
			SessionSeatStatusEnum Status) throws Exception {
		// TODO Auto-generated method stub
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
}
