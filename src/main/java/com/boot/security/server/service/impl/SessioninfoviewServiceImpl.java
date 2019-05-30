package com.boot.security.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.SessioninfoviewDao;
import com.boot.security.server.modelView.Sessioninfoview;
import com.boot.security.server.service.SessioninfoviewService;
@Service
public class SessioninfoviewServiceImpl implements SessioninfoviewService{
	@Autowired
	private SessioninfoviewDao sessioninfoviewDao;
	@Override
	public Sessioninfoview getByCinemaCodeAndSessionCode(String cinemacode, String sessioncode) {
		// TODO Auto-generated method stub
		return sessioninfoviewDao.getByCinemaCodeAndSessionCode(cinemacode, sessioncode);
	}

}
