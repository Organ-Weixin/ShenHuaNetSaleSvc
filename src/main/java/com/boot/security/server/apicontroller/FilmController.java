package com.boot.security.server.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.apicontroller.reply.ModelMapper;
import com.boot.security.server.apicontroller.reply.QueryFilmReply;
import com.boot.security.server.apicontroller.reply.QueryFilmReply.QueryFilmReplyFilm;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/Film")
public class FilmController {
	@Autowired
	private UserInfoServiceImpl _userInfoService;
	@Autowired
	private CinemaServiceImpl _cinemaService;
	@Autowired
	private FilminfoServiceImpl _filmInfoService;
	
	@GetMapping("/QueryFilm/{UserName}/{Password}/{CinemaCode}/{FilmCode}")
	@ApiOperation(value = "根据影片编码获取影片信息")
	public QueryFilmReply QueryFilm(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,@PathVariable String FilmCode){
		QueryFilmReply queryFilmReply=new QueryFilmReply();
		//校验参数
        if (!ReplyExtension.RequestInfoGuard(queryFilmReply,UserName, Password, CinemaCode,FilmCode))
        {
            return queryFilmReply;
        }
        //获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
        if (UserInfo == null)
        {
        	queryFilmReply.SetUserCredentialInvalidReply();
            return queryFilmReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	queryFilmReply.SetCinemaInvalidReply();
            return queryFilmReply;
        }
        Filminfo filminfo=_filmInfoService.getByFilmCode(FilmCode);
        if(filminfo==null){
        	queryFilmReply.SetFilmCodeNotExistReply();
            return queryFilmReply;
        }
        QueryFilmReplyFilm data=new QueryFilmReply.QueryFilmReplyFilm();
        ModelMapper.MapFrom(data,filminfo);
        queryFilmReply.setData(data);
        queryFilmReply.SetSuccessReply();
        return queryFilmReply;
	}

}
