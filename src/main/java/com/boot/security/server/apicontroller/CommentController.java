package com.boot.security.server.apicontroller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.boot.security.server.apicontroller.reply.ModelMapper;
import com.boot.security.server.apicontroller.reply.QueryFilmCommentsReply;
import com.boot.security.server.apicontroller.reply.QueryFilmCommentsReply.QueryFilmCommentsBean.QueryFilmCommentBean;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.apicontroller.reply.SubmitFilmCommentReply;
import com.boot.security.server.apicontroller.reply.SubmitFilmCommentReply.SubmitFilmCommentReplysubmit;
import com.boot.security.server.apicontroller.reply.SubmitFilmCommentReplyJson;
import com.boot.security.server.apicontroller.reply.MobilePhoneRegisterReply.MobilePhoneRegisterBean;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Filmcomments;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.FilmcommentsServiceImpl;
import com.boot.security.server.service.impl.TicketusersServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/Comment")
public class CommentController {
	@Autowired
	private UserInfoServiceImpl _userInfoService;
	@Autowired
	private CinemaServiceImpl _cinemaService;
	@Autowired
	private FilmcommentsServiceImpl _filmcommentsService;
	@Autowired
	private TicketusersServiceImpl _ticketusersService;
	
	@GetMapping("/QueryFilmComments/{UserName}/{Password}/{CinemaCode}/{FilmCode}")
	@ApiOperation(value = "获取影片评论信息")
	public QueryFilmCommentsReply QueryFilmComments(@PathVariable String UserName, @PathVariable String Password,@PathVariable String CinemaCode, @PathVariable String FilmCode) {
		QueryFilmCommentsReply queryFilmCommentsReply = new QueryFilmCommentsReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(queryFilmCommentsReply, UserName, Password, CinemaCode, FilmCode)){
			return queryFilmCommentsReply;
		}
		//获取用户渠道
		Userinfo UserInfo=_userInfoService.getByUserCredential(UserName, Password);
		if(UserInfo == null){
			queryFilmCommentsReply.SetUserCredentialInvalidReply();
			return queryFilmCommentsReply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(CinemaCode);
		if(cinema==null){
			queryFilmCommentsReply.SetCinemaInvalidReply();
			return queryFilmCommentsReply;
		}
		List<Filmcomments> filmcomments1=_filmcommentsService.getByFilmCode(FilmCode);
		Ticketusers ticketusers1=_ticketusersService.getByCinemaCode(CinemaCode);
		queryFilmCommentsReply.setData(queryFilmCommentsReply.new QueryFilmCommentsBean());
		if(filmcomments1==null || filmcomments1.size()==0){
			queryFilmCommentsReply.getData().setCommentCount(0);
		}else{
			queryFilmCommentsReply.getData().setCommentCount(filmcomments1.size());
			queryFilmCommentsReply.getData().setComments(new ArrayList<QueryFilmCommentBean>());
			for(Filmcomments filmcomments:filmcomments1){
				QueryFilmCommentBean queryFilmCommentBean=queryFilmCommentsReply.getData().new QueryFilmCommentBean();
				ModelMapper.MapForm(queryFilmCommentBean, filmcomments);
					queryFilmCommentBean.setNickName(ticketusers1.getNickName());
//					System.out.println("1111"+ticketusers1.getNickName());
					queryFilmCommentBean.setHeadImgUrl(ticketusers1.getHeadImgUrl());
//					System.out.println("2222"+ticketusers1.getHeadImgUrl());
				queryFilmCommentsReply.getData().getComments().add(queryFilmCommentBean);
				}
		}
		queryFilmCommentsReply.SetSuccessReply();
		return queryFilmCommentsReply;
	}
	@SuppressWarnings("null")
	@PostMapping("/SubmitFilmComment")
	@ApiOperation(value="提交影片评论")
	public SubmitFilmCommentReply SubmitFilmComment(@RequestBody  SubmitFilmCommentReplyJson sJson){
		SubmitFilmCommentReply submitFilmCommentReply=new SubmitFilmCommentReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(submitFilmCommentReply, sJson.getUserName(), sJson.getPassword(), sJson.getFilmCode(), sJson.getFilmName(), sJson.getScore(), sJson.getCommentContent(), sJson.getOpenID()))
		{
			return submitFilmCommentReply;
		}
		//获取用户信息
		Userinfo UserInfo=_userInfoService.getByUserCredential(sJson.getUserName(), sJson.getPassword());
		if(UserInfo==null){
			submitFilmCommentReply.SetUserCredentialInvalidReply();
			return submitFilmCommentReply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketuser = _ticketusersService.getByopenids(sJson.getOpenID());
		if(ticketuser == null){
			submitFilmCommentReply.SetOpenIDNotExistReply();
			return submitFilmCommentReply;
		}
		Filmcomments filmcomments=new Filmcomments();
			filmcomments.setFilmCode(sJson.getFilmCode());
			filmcomments.setFilmName(sJson.getFilmName());
			filmcomments.setScore(sJson.getScore());
			filmcomments.setCommentContent(sJson.getCommentContent());
			filmcomments.setOpenID(sJson.getOpenID());
			filmcomments.setCreated(new Date());
			_filmcommentsService.save(filmcomments);
			//返回
			SubmitFilmCommentReplysubmit replysubmit=new  SubmitFilmCommentReplysubmit();
			replysubmit.setFilmCode(filmcomments.getFilmCode());
			replysubmit.setFilmName(filmcomments.getFilmName());
			replysubmit.setScore(filmcomments.getScore());
			replysubmit.setCommentContent(filmcomments.getCommentContent());
			replysubmit.setOpenID(filmcomments.getOpenID());
			replysubmit.setCreated(filmcomments.getCreated());
			submitFilmCommentReply.setData(replysubmit);
        submitFilmCommentReply.SetSuccessReply();
		return submitFilmCommentReply;
		
	}
	
	
}
