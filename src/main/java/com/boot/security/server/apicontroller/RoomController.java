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

import com.boot.security.server.apicontroller.reply.QueryScreenRoomReply;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.apicontroller.reply.QueryScreenRoomReply.ScreenRoom;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/Room")
public class RoomController {

	@Autowired
	private UserInfoServiceImpl _userInfoService;
	@Autowired
	private CinemaServiceImpl _cinemaService;
	@Autowired
	private ScreeninfoServiceImpl _screeninfoService;
	@Autowired
	private SessioninfoServiceImpl _sessionInfoService;
	@Autowired
	private FilminfoServiceImpl _filminfoService;
	
	@GetMapping("/QueryScreenRoom/{UserName}/{Password}/{CinemaCode}")
	@ApiOperation(value="获取放映厅信息")
	public QueryScreenRoomReply QueryScreenRoom(@PathVariable String UserName, @PathVariable String Password,@PathVariable String CinemaCode) throws ParseException {
		QueryScreenRoomReply reply=new QueryScreenRoomReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(reply, UserName, Password, CinemaCode)){
			return reply;
		}
		//获取用户信息(渠道)
		Userinfo UserInfo=_userInfoService.getByUserCredential(UserName, Password);
		if(UserInfo == null){
			reply.SetUserCredentialInvalidReply();
			return reply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(CinemaCode);
		if(cinema == null){
			reply.SetCinemaInvalidReply();
			return reply;
		}
		//获取当前时间的前后40分钟
		Date showdate=new Date();
		Date startDate = new Date(showdate.getTime()-1000*60*40);
		Date endDate = new Date(showdate.getTime()+1000*60*40);
		List<Sessioninfo>  sessioninfos = _sessionInfoService.getByCCodeGroupByFilm(UserInfo.getId(), CinemaCode, startDate, endDate);
		
		List<ScreenRoom> rooms = new ArrayList<ScreenRoom>();
		for(Sessioninfo sessioninfo : sessioninfos){
			ScreenRoom screenRoom = new ScreenRoom();
			screenRoom.setCinemaCode(cinema.getCode());
			screenRoom.setCinemaName(cinema.getName());
			
			Screeninfo screeninfo = _screeninfoService.getByScreenCode(sessioninfo.getCCode(),sessioninfo.getScreenCode());
			screenRoom.setScreenName(screeninfo==null?"":screeninfo.getSName());
			screenRoom.setFilmName(sessioninfo.getFilmName());
			Date startTime = sessioninfo.getStartTime();
			screenRoom.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTime));
			Integer duration = sessioninfo.getDuration();
			screenRoom.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(startTime.getTime()+1000*60*duration)));
			
			Filminfo film = _filminfoService.getByFilmCode(sessioninfo.getFilmCode());
			screenRoom.setImage(film==null?"":film.getImage());
			rooms.add(screenRoom);
		}
		reply.setData(rooms);
		reply.SetSuccessReply();
		return reply;
	}
}
