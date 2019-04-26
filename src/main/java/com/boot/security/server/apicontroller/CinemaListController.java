package com.boot.security.server.apicontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.apicontroller.reply.QueryCinemasReply;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.apicontroller.reply.QueryCinemasReply.QueryCinemasBean;
import com.boot.security.server.apicontroller.reply.QueryCinemasReply.QueryCinemasBean.CinemasReply;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/Cinema")
public class CinemaListController {
	
	@Autowired
	private UserInfoServiceImpl _userInfoService;
	
	@Autowired
	private CinemaServiceImpl _cinemaService;

	@GetMapping("/QueryCinemas/{UserName}/{Password}/{AppId}/{CurrentPage}/{PageSize}")
	@ApiOperation(value = "获取影院")
	public QueryCinemasReply QueryCinemas(@PathVariable String UserName,@PathVariable String Password,@PathVariable String AppId,
			@PathVariable String CurrentPage,@PathVariable String PageSize){
		
		QueryCinemasReply cinemasReply = new QueryCinemasReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(cinemasReply, UserName, UserName, AppId, CurrentPage, PageSize)){
			return cinemasReply;
		}
		//获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
        if (UserInfo == null) {
        	cinemasReply.SetUserCredentialInvalidReply();
            return cinemasReply;
        }
        
       List<Cinema> cinemalist =  _cinemaService.getCinemas();
       QueryCinemasBean queryCinemasBean = new QueryCinemasBean();
       if(cinemalist == null || cinemalist.size()==0){
    	   queryCinemasBean.setCinemaCount(0);
       } else {
    	   queryCinemasBean.setCinemaCount(cinemalist.size());
    	   List<CinemasReply> cinemas = new ArrayList<CinemasReply>();
    	   for(Cinema cinema : cinemalist){
    		   CinemasReply cinemareply = new CinemasReply();
    		   cinemareply.setCinemaCode(cinema.getCode());
    		   cinemareply.setCinemaName(cinema.getName());
    		   cinemareply.setAddress(cinema.getAddress());
    		   cinemareply.setStatus(cinema.getIsOpen()==1?"开通":"关闭");
    		   cinemas.add(cinemareply);
    	   }
    	   queryCinemasBean.setCinemas(cinemas);
       }
       cinemasReply.setData(queryCinemasBean);
       cinemasReply.SetSuccessReply();
       return cinemasReply;
	}
}
