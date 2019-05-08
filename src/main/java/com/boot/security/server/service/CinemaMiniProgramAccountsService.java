package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.CinemaMiniProgramAccounts;

public interface CinemaMiniProgramAccountsService {

	List<CinemaMiniProgramAccounts> getByAppId(String appid);
	
	CinemaMiniProgramAccounts getByCinemaCode(String cinemacode);
}
