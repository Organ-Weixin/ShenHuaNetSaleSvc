package com.boot.security.server.apicontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.apicontroller.reply.ModelMapper;
import com.boot.security.server.apicontroller.reply.QueryScreenInfoReply;
import com.boot.security.server.apicontroller.reply.QueryScreenInfoReply.QueryScreensReplyScreenInfo;
import com.boot.security.server.apicontroller.reply.QueryScreenSeatsReply.QueryScreenSeatsReplyScreenSeats.QueryScreenSeatsReplyScreenSeat;
import com.boot.security.server.apicontroller.reply.QueryScreenSeatsReply;
import com.boot.security.server.apicontroller.reply.QueryScreensReply;
import com.boot.security.server.apicontroller.reply.QueryScreensReply.QueryScreensReplyScreens.QueryScreensReplyScreen;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.dao.ScreeninfoDao;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.ScreenseatinfoServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.google.gson.Gson;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/Screen")
public class ScreenController {
	
	@Autowired
	private UserInfoServiceImpl _userInfoService;
	@Autowired
	private CinemaServiceImpl _cinemaService;
	@Autowired
    private ScreeninfoDao screeninfoDao;
	@Autowired 
	private ScreeninfoServiceImpl _screeninfoService;
	@Autowired
	private ScreenseatinfoServiceImpl _screenseatinfoService;

	@GetMapping("/QueryScreens/{Username}/{Password}/{CinemaCode}")
	@ApiOperation(value = "获取影厅列表")
    public QueryScreensReply QueryScreens(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode){
		QueryScreensReply queryScreensReply=new QueryScreensReply();
		//校验参数
        if (!ReplyExtension.RequestInfoGuard(queryScreensReply,Username, Password, CinemaCode))
        {
            return queryScreensReply;
        }
        //获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
        	queryScreensReply.SetUserCredentialInvalidReply();
            return queryScreensReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	queryScreensReply.SetCinemaInvalidReply();
            return queryScreensReply;
        }
		List<Screeninfo> screeninfos=screeninfoDao.getByCinemaCode(CinemaCode);
		queryScreensReply.setData(queryScreensReply.new QueryScreensReplyScreens());
		if(screeninfos==null||screeninfos.size()==0){
			queryScreensReply.getData().setScreenCount(0);
		}else{
			queryScreensReply.getData().setScreenCount(screeninfos.size());
			queryScreensReply.getData().setScreen(new ArrayList<QueryScreensReplyScreen>());
			for(Screeninfo screeninfo:screeninfos){
				QueryScreensReplyScreen replyscreen=queryScreensReply.getData().new QueryScreensReplyScreen();
				ModelMapper.MapFrom(replyscreen, screeninfo);
				queryScreensReply.getData().getScreen().add(replyscreen);
			}
		}
		queryScreensReply.SetSuccessReply();
		return queryScreensReply;
    }
	
	@GetMapping("/QueryScreenInfo/{Username}/{Password}/{CinemaCode}/{ScreenCode}")
	@ApiOperation(value = "根据影厅编码获取影厅信息")
	public QueryScreenInfoReply QueryScreenInfo(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode, @PathVariable String ScreenCode){
		QueryScreenInfoReply queryScreenInfoReply = new QueryScreenInfoReply();
		//校验参数
        if (!ReplyExtension.RequestInfoGuard(queryScreenInfoReply, Username, Password, CinemaCode, ScreenCode))
        {
            return queryScreenInfoReply;
        }
        //获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
        	queryScreenInfoReply.SetUserCredentialInvalidReply();
            return queryScreenInfoReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	queryScreenInfoReply.SetCinemaInvalidReply();
            return queryScreenInfoReply;
        }
        queryScreenInfoReply.setData(queryScreenInfoReply.new QueryScreensReplyScreenInfo());
        //验证影厅编码是否正确
        Screeninfo screeninfo = _screeninfoService.getByScreenCode(CinemaCode, ScreenCode);
        if(screeninfo == null){
        	queryScreenInfoReply.SetScreenInvalidReply();
        	return queryScreenInfoReply;
        }else{
        	QueryScreensReplyScreenInfo replyscreeninfo = queryScreenInfoReply.getData();
        	ModelMapper.MapFrom(replyscreeninfo, screeninfo);
        }
        queryScreenInfoReply.SetSuccessReply();
		return queryScreenInfoReply;
	}
	
	@GetMapping("/QueryScreenSeats/{Username}/{Password}/{CinemaCode}/{ScreenCode}")
	@ApiOperation(value = "根据影厅编码获取影厅座位信息")
	public QueryScreenSeatsReply QueryScreenSeats(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode, @PathVariable String ScreenCode){
		QueryScreenSeatsReply queryScreenSeatsReply = new QueryScreenSeatsReply();
		//校验参数
        if (!ReplyExtension.RequestInfoGuard(queryScreenSeatsReply, Username, Password, CinemaCode, ScreenCode))
        {
            return queryScreenSeatsReply;
        }
        //获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
        	queryScreenSeatsReply.SetUserCredentialInvalidReply();
            return queryScreenSeatsReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	queryScreenSeatsReply.SetCinemaInvalidReply();
            return queryScreenSeatsReply;
        }
        //验证影厅是否存在且可访问
        Screeninfo screeninfo = _screeninfoService.getByScreenCode(CinemaCode, ScreenCode);
        if(screeninfo == null){
        	queryScreenSeatsReply.SetScreenInvalidReply();
        	return queryScreenSeatsReply;
        }
        List<Screenseatinfo> screenseatinfos = _screenseatinfoService.getByCinemaCodeAndScreenCode(CinemaCode, ScreenCode);
        queryScreenSeatsReply.setData(queryScreenSeatsReply.new QueryScreenSeatsReplyScreenSeats());
        if(screenseatinfos==null||screenseatinfos.size()==0){
        	queryScreenSeatsReply.getData().setSeatCount(screenseatinfos.size());
        }else{
        	queryScreenSeatsReply.getData().setSeatCount(screenseatinfos.size());
        	queryScreenSeatsReply.getData().setSeats(new ArrayList<QueryScreenSeatsReplyScreenSeat>());
        	for(Screenseatinfo screenseatinfo :screenseatinfos){
        		QueryScreenSeatsReplyScreenSeat replyscreenseat = queryScreenSeatsReply.getData().new QueryScreenSeatsReplyScreenSeat();
        		ModelMapper.MapFrom(replyscreenseat, screenseatinfo);
        		queryScreenSeatsReply.getData().getSeats().add(replyscreenseat);
        	}
        }
        queryScreenSeatsReply.SetSuccessReply();
		return queryScreenSeatsReply;
	}
	
}
