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
import com.boot.security.server.apicontroller.reply.QueryOrderSessionReply;
import com.boot.security.server.apicontroller.reply.QueryOrderSessionReply.QueryOrderSessionReplyOrderSession;
import com.boot.security.server.apicontroller.reply.QueryFilmSessionsReply.QueryFilmSessionsReplyFilmSessions.QueryFilmSessionsReplyFilm.QueryFilmSessionsReplySession.QueryFilmSessionsReplySessionPrice;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Qmmprice;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.QmmpriceServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;

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
	private FilminfoServiceImpl _filminfoService;
	@Autowired
	private ScreeninfoServiceImpl _screeninfoService;
	@Autowired
	private QmmpriceServiceImpl _qmmpriceService;
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
				List<Sessioninfo> sessionList = _sessionInfoService.getByCinemaCodeAndFilmCodeAndTime(film.getCCode(), filmcode, StartDate, EndDate);
				List<QueryFilmSessionsReplySession> sessionReplyList = new ArrayList<QueryFilmSessionsReplySession>();
				for(Sessioninfo session :sessionList){
					QueryFilmSessionsReplySession sessionReply = new QueryFilmSessionsReplySession();
					sessionReply.setFeatureNo(session.getFeatureNo());
					sessionReply.setListingPrice(session.getListingPrice());
					sessionReply.setLowestPrice(session.getLowestPrice());
					sessionReply.setPlaythroughFlag(session.getPlaythroughFlag());
					sessionReply.setScreenCode(session.getScreenCode());
					sessionReply.setSequence(session.getSequence());
					sessionReply.setSessionCode(session.getSCode());
					sessionReply.setStandardPrice(session.getStandardPrice());
					if(session.getStartTime()!=null){
						sessionReply.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(session.getStartTime()));
					}
					Screeninfo screeninfo = _screeninfoService.getByScreenCode(session.getCCode(), session.getScreenCode());
					if(screeninfo!=null){
						sessionReply.setScreenName(screeninfo.getSName());
					}
					sessionReply.setStartDate(new SimpleDateFormat("MM-dd").format(session.getStartTime()));
					sessionReply.setBeginTime(new SimpleDateFormat("HH:mm").format(session.getStartTime()));
					if(new SimpleDateFormat("yyyyMMdd").format(session.getStartTime()).equals(new SimpleDateFormat("yyyyMMdd").format(new Date()))){
						sessionReply.setIsToday(true);
					}else{
						sessionReply.setIsToday(false);
					}
					List<Qmmprice> qmmpriceList = _qmmpriceService.getByCinemaCodeAndScreenName(session.getCCode(), sessionReply.getScreenName(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(session.getStartTime()));
					List<QueryFilmSessionsReplySessionPrice> sessionPriceList = new ArrayList<QueryFilmSessionsReplySessionPrice>();
					for(Qmmprice qmmprice:qmmpriceList){
						QueryFilmSessionsReplySessionPrice sessionPrice = new QueryFilmSessionsReplySessionPrice();
						if(qmmprice!=null){
							sessionPrice.setTypeCode(qmmprice.getDataType());
							sessionPrice.setTypeName(qmmprice.getDataName());
							sessionPrice.setSettlePrice(qmmprice.getSettlePrice());
							sessionPrice.setStandardPrice(qmmprice.getPrice());
							sessionPriceList.add(sessionPrice);
						}
					}
					sessionReply.setPrice(sessionPriceList);
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
