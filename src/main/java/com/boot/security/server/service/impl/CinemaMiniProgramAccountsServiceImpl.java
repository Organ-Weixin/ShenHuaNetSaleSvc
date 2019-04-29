package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.CinemaMiniProgramAccountsDao;
import com.boot.security.server.model.CinemaMiniProgramAccounts;
import com.boot.security.server.service.CinemaMiniProgramAccountsService;

@Service
public class CinemaMiniProgramAccountsServiceImpl implements CinemaMiniProgramAccountsService {

	@Autowired
	private CinemaMiniProgramAccountsDao cinemaMiniProgramAccountsDao;
	
	@Override
	public List<CinemaMiniProgramAccounts> getByAppId(String appid) {
		
		return cinemaMiniProgramAccountsDao.getByAppId(appid);
	}

}
