package com.boot.security.server.apicontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.apicontroller.reply.QueryActivitysReply;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.model.Activity;
import com.boot.security.server.apicontroller.reply.QueryActivitysReply.QueryActivitysReplyActivity;
import com.boot.security.server.apicontroller.reply.QueryActivitysReply.QueryActivitysReplyActivity.QueryActivity;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.ActivityServiceImpl;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/Activity")
public class CinemaActivityController {

	@Autowired
	private UserInfoServiceImpl _userinfoService;
	@Autowired
	private CinemaServiceImpl _cinemaService;
	@Autowired
	private ActivityServiceImpl _activityService;
	
	@GetMapping("/QueryActivitys/{UserName}/{Password}/{CinemaCode}")
	@ApiOperation(value = "获取图片")
	public QueryActivitysReply QueryActivitys(@PathVariable String UserName, @PathVariable String Password,@PathVariable String CinemaCode) {
		QueryActivitysReply reply = new QueryActivitysReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(reply, UserName, Password, CinemaCode)){
			return reply;
		}
		//获取用户渠道
		Userinfo UserInfo=_userinfoService.getByUserCredential(UserName, Password);
		if(UserInfo == null){
			reply.SetUserCredentialInvalidReply();
			return reply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(CinemaCode);
		if(cinema==null){
			reply.SetCinemaInvalidReply();
			return reply;
		}
		List<Activity> activityList=_activityService.getByCinemaCode(CinemaCode);
		QueryActivitysReplyActivity data=new QueryActivitysReplyActivity();
		if(activityList == null || activityList.size() == 0){
			data.setCount(0);
		} else {
			List<QueryActivity> queryActivityList = new ArrayList<QueryActivity>();
			for(Activity activity : activityList){
				QueryActivity queryActivity = new QueryActivity();
				queryActivity.setCinemaCode(activity.getCinemaCode());
				queryActivity.setTitle(activity.getTitle());
				queryActivity.setImage(activity.getImage());
				queryActivity.setLinkUrl(activity.getLinkUrl());
				queryActivityList.add(queryActivity);
			}
			data.setCount(activityList.size());
			data.setImages(queryActivityList);
		}
		reply.setData(data);
		reply.SetSuccessReply();
		return reply;
	}
}
