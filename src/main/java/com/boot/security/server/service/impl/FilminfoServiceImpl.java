package com.boot.security.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.FilminfoDao;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.service.FilminfoService;
@Service
public class FilminfoServiceImpl implements FilminfoService{
	@Autowired
	FilminfoDao FilminfoDao;
	
	@Override
	public int save(Filminfo filminfo) {
		return FilminfoDao.save(filminfo);
	}

	@Override
	public Filminfo getByFilmCode(String filmcode) {
		// TODO Auto-generated method stub
		return FilminfoDao.getByFilmCode(filmcode);
	}

	@Override
	public int update(Filminfo filminfo) {
		// TODO Auto-generated method stub
		return FilminfoDao.update(filminfo);
	}
	
}
