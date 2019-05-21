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
import com.boot.security.server.apicontroller.reply.QueryFilmSessionsReply;
import com.boot.security.server.apicontroller.reply.QueryFilmSessionsReply.QueryFilmSessionsReplyFilmSessions;
import com.boot.security.server.apicontroller.reply.QueryFilmSessionsReply.QueryFilmSessionsReplyFilmSessions.QueryFilmSessionsReplyFilm;
import com.boot.security.server.apicontroller.reply.QueryFilmSessionsReply.QueryFilmSessionsReplyFilmSessions.QueryFilmSessionsReplyFilm.QueryFilmSessionsReplySession;
import com.boot.security.server.apicontroller.reply.QueryNewSessionsReply;
import com.boot.security.server.apicontroller.reply.QueryNewSessionsReply.QueryNewSessionsReplyNewSessions.QueryNewSessionsReplyFilm;
import com.boot.security.server.apicontroller.reply.QueryOrderSessionReply;
import com.boot.security.server.apicontroller.reply.QueryOrderSessionReply.QueryOrderSessionReplyOrderSession;
import com.boot.security.server.apicontroller.reply.QuerySessionsReply;
import com.boot.security.server.apicontroller.reply.QuerySessionsReply.QuerySessionsReplySessions.QuerySessionsReplySession;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.dao.SessioninfoDao;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
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
	@Autowired
	private FilminfoServiceImpl _filminfoService;
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
	///////
	@GetMapping("/QueryNewSessions/{UserName}/{Password}/{CinemaCode}/{StartDate}/{EndDate}")
	@ApiOperation(value="获取影片场次信息-新")
	public  QueryNewSessionsReply QueryNewSessions(@PathVariable String UserName, @PathVariable String Password,@PathVariable String CinemaCode,@PathVariable String StartDate,@PathVariable String EndDate) throws ParseException{
		QueryNewSessionsReply queryNewSessionsReply=new QueryNewSessionsReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(queryNewSessionsReply, UserName, Password, CinemaCode, StartDate, EndDate))
		{
			return queryNewSessionsReply;
		}
		// 获取用户信息(渠道)
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			queryNewSessionsReply.SetUserCredentialInvalidReply();
			return queryNewSessionsReply;
		}
		// 验证影院是否存在且可访问
		Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
		if (cinema == null) {
			queryNewSessionsReply.SetCinemaInvalidReply();
			return queryNewSessionsReply;
		}
		// 验证排期是否存在
		List<Sessioninfo> sessionfo = _sessionInfoService.getByCinemaStartDateEndDate(CinemaCode, StartDate, EndDate);
		if (sessionfo == null) {
			queryNewSessionsReply.SetSessionInvalidReply();
			return queryNewSessionsReply;
		}
		//验证开始时间和结束时间是否正确
		Date Start=new SimpleDateFormat("yyyy-MM-dd").parse(StartDate);
		Date End=new SimpleDateFormat("yyyy-MM-dd").parse(EndDate);
		if(Start == null){
			queryNewSessionsReply.SetStartDateInvalidReply();
			return queryNewSessionsReply;
		}
		if(End == null){
			queryNewSessionsReply.SetEndDateInvalidReply();
			return queryNewSessionsReply;
		}
		if(Start.getTime() > End.getTime()){
			queryNewSessionsReply.SetDateInvalidReply();
			return queryNewSessionsReply;
		}
		// 根据影片名称分组，去除影片重复数据
		/*List<Sessioninfo> sessions = _sessioninfoService.getByCCodeGroupByFilm(userCinema.getUserId(),
				userCinema.getCinemaCode(), StartDate, EndDate);*/
		List<Sessioninfo>  sessionList=sessioninfoDao.getByFilmName(CinemaCode,String.valueOf(StartDate),String.valueOf(EndDate));
		queryNewSessionsReply.setFilms(queryNewSessionsReply.new QueryNewSessionsReplyNewSessions());
		if(sessionList!=null && sessionList.size()>0){
			queryNewSessionsReply.getFilms().setFilm(new ArrayList<QueryNewSessionsReplyFilm>());
			for(Sessioninfo sessioninfo:sessionList){
				QueryNewSessionsReplyFilm replySession=queryNewSessionsReply.getFilms().new QueryNewSessionsReplyFilm();
				ModelMapper.MapFrom(replySession, sessioninfo);
				queryNewSessionsReply.getFilms().setCinemaCode(CinemaCode);
				queryNewSessionsReply.getFilms().getFilm().add(replySession);
				List<Sessioninfo> films = _sessionInfoService.getByCinemafilm(CinemaCode, sessioninfo.getFilmCode());
				
			}
		}
		queryNewSessionsReply.SetSuccessReply();
		return queryNewSessionsReply;
	}
	///////
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
	@GetMapping("/QueryFilmSessions/{UserName}/{Password}/{CinemaCode}/{StartDate}/{EndDate}")
	@ApiOperation(value = "获取场次影片信息")
	public QueryFilmSessionsReply QueryFilmSessions(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,
			@PathVariable String StartDate,@PathVariable String EndDate) throws ParseException{
		QueryFilmSessionsReply queryFilmSessionsReply = new QueryFilmSessionsReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(queryFilmSessionsReply, UserName, Password, CinemaCode, StartDate, EndDate)) {
			return queryFilmSessionsReply;
		}
		// 获取用户信息(渠道)
		Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
		if (UserInfo == null) {
			queryFilmSessionsReply.SetUserCredentialInvalidReply();
			return queryFilmSessionsReply;
		}
		// 验证影院是否存在且可访问
		Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
		if (cinema == null) {
			queryFilmSessionsReply.SetCinemaInvalidReply();
			return queryFilmSessionsReply;
		}
		//验证日期是否正确
		Date Start=new SimpleDateFormat("yyyy-MM-dd").parse(StartDate);
		Date End=new SimpleDateFormat("yyyy-MM-dd").parse(EndDate);
		if(Start.getTime() > End.getTime()){
			queryFilmSessionsReply.SetDateInvalidReply();
			return queryFilmSessionsReply;
		}
		//排期中的全部影片
		List<Sessioninfo> films = _sessionInfoService.getByFilmName(CinemaCode, StartDate, EndDate);
		QueryFilmSessionsReplyFilmSessions data = new QueryFilmSessionsReplyFilmSessions();
		if(films.size()>0){
			data.setCinemaCode(films.get(0).getCCode());
			List<QueryFilmSessionsReplyFilm> filmReplyList = new ArrayList<QueryFilmSessionsReplyFilm>();
			for(Sessioninfo film:films){
				QueryFilmSessionsReplyFilm filmReply = new QueryFilmSessionsReplyFilm();
				String filmcode = film.getFilmCode();
				filmReply.setCode(filmcode);
				filmReply.setDimensional(film.getDimensional());
				filmReply.setDuration(String.valueOf(film.getDuration()));
				filmReply.setLanguage(film.getLanguage());
				filmReply.setName(film.getFilmName());
				Filminfo filminfo = _filminfoService.getByFilmCode(filmcode);
				if(filminfo!=null){
					filmReply.setArea(filminfo.getArea());
					filmReply.setCast(filminfo.getCast());
					filmReply.setDirector(filminfo.getDirector());
					filmReply.setImage(filminfo.getImage());
					filmReply.setIntroduction(filminfo.getIntroduction());
					filmReply.setProducer(filminfo.getProducer());
					if(filminfo.getPublishDate()!=null){
						filmReply.setPublishDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(filminfo.getPublishDate()));
					}
					filmReply.setPublisher(filminfo.getPublisher());
					if(filminfo.getScore()!=null){
						filmReply.setScore(String.valueOf(filminfo.getScore()));
					}
					filmReply.setStatus(String.valueOf(filminfo.getStatus()));
					filmReply.setTrailer(filminfo.getTrailer());
					filmReply.setType(filminfo.getType());
					filmReply.setVersion(filminfo.getVersion());
				}
				List<Sessioninfo> sessionList = _sessionInfoService.getByCinemaCodeAndFilmCode(film.getCCode(), filmcode);
				List<QueryFilmSessionsReplySession> sessionReplyList = new ArrayList<QueryFilmSessionsReplySession>();
				for(Sessioninfo session :sessionList){
					QueryFilmSessionsReplySession sessionReply = new QueryFilmSessionsReplySession();
					sessionReply.setFeatureNo(session.getFeatureNo());
					if(session.getListingPrice()!=null){
						sessionReply.setListingPrice(String.valueOf(session.getListingPrice()));
					}
					if(session.getLowestPrice()!=null){
						sessionReply.setLowestPrice(String.valueOf(session.getLowestPrice()));
					}
					sessionReply.setPlaythroughFlag(session.getPlaythroughFlag());
					sessionReply.setScreenCode(session.getScreenCode());
					if(session.getSequence()!=null){
						sessionReply.setSequence(String.valueOf(session.getSequence()));
					}
					sessionReply.setSessionCode(session.getSCode());
					if(session.getStandardPrice()!=null){
						sessionReply.setStandardPrice(String.valueOf(session.getStandardPrice()));
					}
					if(session.getStartTime()!=null){
						sessionReply.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(session.getStartTime()));
					}
					sessionReply.setStartDate(new SimpleDateFormat("MM-dd").format(session.getStartTime()));
					sessionReply.setBeginTime(new SimpleDateFormat("HH:mm").format(session.getStartTime()));
					if(new SimpleDateFormat("yyyyMMdd").format(session.getStartTime()).equals(new SimpleDateFormat("yyyyMMdd").format(new Date()))){
						sessionReply.setIsToday("true");
					}else{
						sessionReply.setIsToday("false");
					}
					sessionReplyList.add(sessionReply);
				}
				filmReply.setSession(sessionReplyList);
				filmReplyList.add(filmReply);
			}
				data.setFilm(filmReplyList);
		}
		queryFilmSessionsReply.setData(data);
		queryFilmSessionsReply.SetSuccessReply();
			
		return queryFilmSessionsReply;
	}
}
