package com.boot.security.server.apicontroller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.QuerySessionSeatReply;
import com.boot.security.server.apicontroller.reply.ModelMapper;
import com.boot.security.server.apicontroller.reply.QueryOrderSessionReply;
import com.boot.security.server.apicontroller.reply.QueryOrderSessionReply.QueryOrderSessionReplyOrderSession;
import com.boot.security.server.apicontroller.reply.QuerySessionsReply;
import com.boot.security.server.apicontroller.reply.QuerySessionsReply.QuerySessionsReplySessions.QuerySessionsReplySession;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.dao.SessioninfoDao;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.google.gson.Gson;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/Session")
public class SessionController {
	@Autowired
	private UserInfoServiceImpl _userInfoService;
	@Autowired
	private CinemaServiceImpl _cinemaService;
	@Autowired
	private SessioninfoServiceImpl _sessionInfoService;
	@Autowired
	private SessioninfoDao  sessioninfoDao;
	@GetMapping("/QuerySessions/{UserName}/{Password}/{CinemaCode}/{StartDate}/{EndDate}")
	@ApiOperation(value="获取影片场次信息")
	public QuerySessionsReply QuerySessions(@PathVariable String UserName, @PathVariable String Password,@PathVariable String CinemaCode,@PathVariable String StartDate,@PathVariable String EndDate) throws ParseException 
	{
		QuerySessionsReply querySessionsReply=new QuerySessionsReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(querySessionsReply, UserName, Password, CinemaCode, StartDate, EndDate))
		{
			return querySessionsReply;
		}
		//获取用户信息(渠道)
		Userinfo UserInfo=_userInfoService.getByUserCredential(UserName, Password);
		if(UserInfo == null){
			querySessionsReply.SetUserCredentialInvalidReply();
			return querySessionsReply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(CinemaCode);
		if(cinema == null){
			querySessionsReply.SetCinemaInvalidReply();
			return querySessionsReply;
		}
		//验证排期是否存在
		List<Sessioninfo> sessionfo=_sessionInfoService.getByCinemaStartDateEndDate(CinemaCode, StartDate, EndDate);
		if(sessionfo == null){
			querySessionsReply.SetSessionInvalidReply();
			return querySessionsReply;
		}
		//验证开始时间和结束时间是否正确
		Date Start=new SimpleDateFormat("yyyy-MM-dd").parse(StartDate);
		Date End=new SimpleDateFormat("yyyy-MM-dd").parse(EndDate);
		if(Start == null){
			querySessionsReply.SetStartDateInvalidReply();
			return querySessionsReply;
		}
		if(End == null){
			querySessionsReply.SetEndDateInvalidReply();
			return querySessionsReply;
		}
		if(Start.getTime() > End.getTime()){
			querySessionsReply.SetDateInvalidReply();
			return querySessionsReply;
		}
		List<Sessioninfo> sessionList=sessioninfoDao.getByCinemaStartDateEndDate(CinemaCode, StartDate, EndDate);
		querySessionsReply.setSessions(querySessionsReply.new QuerySessionsReplySessions());
		if(sessionList != null && sessionList.size() > 0){
			querySessionsReply.getSessions().setSession(new ArrayList<QuerySessionsReplySession>());
			for(Sessioninfo sessioninfo:sessionList){
				QuerySessionsReplySession replySession=querySessionsReply.getSessions().new QuerySessionsReplySession();
				ModelMapper.MapFrom(replySession, sessioninfo);
				querySessionsReply.getSessions().setCinemaCode(CinemaCode);
				querySessionsReply.getSessions().getSession().add(replySession);
			}
		}
		querySessionsReply.SetSuccessReply();
		return querySessionsReply;
	
	}
//	获取订单场次信息
	@GetMapping("/QueryOrderSession/{UserName}/{Password}/{CinemaCode}/{SessionCode}")
	@ApiOperation(value = "获取订单场次信息")
	public QueryOrderSessionReply QueryOrderSession(@PathVariable String UserName, @PathVariable String Password,
			@PathVariable String CinemaCode, @PathVariable String SessionCode) {
		QueryOrderSessionReply queryOrderSessionReply = new QueryOrderSessionReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(queryOrderSessionReply, UserName, Password, CinemaCode, SessionCode)) {
			return queryOrderSessionReply;
		}
		// 获取用户信息(渠道)
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			queryOrderSessionReply.SetUserCredentialInvalidReply();
			return queryOrderSessionReply;
		}
		// 验证影院是否存在且可访问
		Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
		if (cinema == null) {
			queryOrderSessionReply.SetCinemaInvalidReply();
			return queryOrderSessionReply;
		}
		// 验证场次是否存在
		Sessioninfo sessionfo = _sessionInfoService.getSessionCode(CinemaCode, SessionCode);
		if (sessionfo == null) {
			queryOrderSessionReply.SetSessionInvalidReply();
			return queryOrderSessionReply;
		}
		queryOrderSessionReply.setData(queryOrderSessionReply.new QueryOrderSessionReplyOrderSession());
			QueryOrderSessionReplyOrderSession orderSession = queryOrderSessionReply.new QueryOrderSessionReplyOrderSession();
			ModelMapper.MapFrom1(orderSession, sessionfo);
//			System.out.println("获取订单场次信息返回"+new Gson().toJson(orderSession));
			queryOrderSessionReply.setData(orderSession);
		queryOrderSessionReply.SetSuccessReply();
		return queryOrderSessionReply;
	}

	@GetMapping("/QuerySessionSeat/{UserName}/{Password}/{CinemaCode}/{SessionCode}/{Status}")
	@ApiOperation(value = "获取场次座位信息")
	public QuerySessionSeatReply QuerySessionSeat(@PathVariable String UserName, @PathVariable String Password,@PathVariable String CinemaCode,@PathVariable String SessionCode,@PathVariable String Status){
		return NetSaleSvcCore.getInstance().QuerySessionSeat(UserName, Password, CinemaCode, SessionCode, Status);
	}
	
	
}
