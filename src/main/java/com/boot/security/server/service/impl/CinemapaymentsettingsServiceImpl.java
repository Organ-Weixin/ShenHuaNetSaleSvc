package com.boot.security.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.CinemapaymentsettingsDao;
import com.boot.security.server.model.Cinemapaymentsettings;
import com.boot.security.server.service.CinemapaymentsettingsService;
@Service
public class CinemapaymentsettingsServiceImpl implements CinemapaymentsettingsService{
	@Autowired
	private CinemapaymentsettingsDao cinemapaymentsettingsDao;
	@Override
	public Cinemapaymentsettings getByCinemaCode(String cinemacode) {
		// TODO Auto-generated method stub
		return cinemapaymentsettingsDao.getByCinemaCode(cinemacode);
	}

}
