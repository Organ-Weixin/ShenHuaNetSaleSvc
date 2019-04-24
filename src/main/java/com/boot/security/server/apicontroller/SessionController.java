package com.boot.security.server.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.QuerySessionSeatReply;
import com.boot.security.server.service.impl.CinemaServiceImpl;
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
	
	@GetMapping("/QuerySessionSeat/{UserName}/{Password}/{CinemaCode}/{SessionCode}/{Status}")
	@ApiOperation(value = "获取影厅列表")
	public QuerySessionSeatReply QuerySessionSeat(@PathVariable String UserName, @PathVariable String Password,@PathVariable String CinemaCode,@PathVariable String SessionCode,@PathVariable String Status){
		return NetSaleSvcCore.getInstance().QuerySessionSeat(UserName, Password, CinemaCode, SessionCode, Status);
	}
}
