package com.boot.security.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.UserinfoDao;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private UserinfoDao userinfoDao;
	@Override
	public Userinfo getByUserCredential(String username, String password) {
		return userinfoDao.getByUserCredential(username, password);
	}
	
}
