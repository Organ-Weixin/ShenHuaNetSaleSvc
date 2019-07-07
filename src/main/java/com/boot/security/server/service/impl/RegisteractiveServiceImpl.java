package com.boot.security.server.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.RegisteractiveDao;
import com.boot.security.server.model.Registeractive;
import com.boot.security.server.service.RegisteractiveService;
@Service
public class RegisteractiveServiceImpl implements RegisteractiveService{
	@Autowired
	private RegisteractiveDao registeractiveDao;

	@Override
	public Registeractive getByCinemaCode(String cinemacode){
		// TODO Auto-generated method stub
		return registeractiveDao.getByCinemaCode(cinemacode);
	}

	@Override
	public List<Registeractive> getCanUseRegisterActive(String cinemacode) {
		// TODO Auto-generated method stub
		return registeractiveDao.getCanUseRegisterActive(cinemacode);
	}
	
}
