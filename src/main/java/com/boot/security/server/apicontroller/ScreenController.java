package com.boot.security.server.apicontroller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.ctms.reply.CxInterface;
import com.boot.security.server.apicontroller.reply.ModelMapper;
import com.boot.security.server.apicontroller.reply.QueryScreensReply;
import com.boot.security.server.apicontroller.reply.QueryScreensReply.QueryScreensReplyScreens.QueryScreensReplyScreen;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.dao.ScreeninfoDao;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.ScreeninfoService;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.boot.security.server.utils.SpringUtil;

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

	@GetMapping("/QueryScreens/{UserName}/{Password}/{CinemaCode}")
	@ApiOperation(value = "获取影厅列表")
    public QueryScreensReply QueryScreens(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode){
		QueryScreensReply queryScreensReply=new QueryScreensReply();
		//校验参数
        if (!ReplyExtension.RequestInfoGuard(queryScreensReply,UserName, Password, CinemaCode))
        {
            return queryScreensReply;
        }
        //获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
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
		queryScreensReply.data=queryScreensReply.new QueryScreensReplyScreens();
		if(screeninfos==null||screeninfos.size()==0){
			queryScreensReply.data.ScreenCount = 0;
		}else{
			queryScreensReply.data.ScreenCount = screeninfos.size();
			queryScreensReply.data.Screen=new ArrayList<QueryScreensReplyScreen>();
			for(Screeninfo screeninfo:screeninfos){
				QueryScreensReplyScreen replyscreen=queryScreensReply.data.new QueryScreensReplyScreen();
				ModelMapper.MapFrom(replyscreen, screeninfo);
				queryScreensReply.data.Screen.add(replyscreen);
			}
		}
		queryScreensReply.SetSuccessReply();
		return queryScreensReply;
    }
}
