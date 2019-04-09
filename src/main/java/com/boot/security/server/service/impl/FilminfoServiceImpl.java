package com.boot.security.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.FilminfoDao;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.service.FilminfoService;

@Service
public class FilminfoServiceImpl implements FilminfoService{

	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	FilminfoDao filminfoDao;
	
	@Override
	public Filminfo getByFilmCode(String filmcode) {
		// TODO Auto-generated method stub
		return filminfoDao.getByFilmCode(filmcode);
	}
	
	@Override
	public int save(Filminfo filminfo) {
		return filminfoDao.save(filminfo);
	}

	@Override
	public int update(Filminfo filminfo) {
		// TODO Auto-generated method stub
		return filminfoDao.update(filminfo);
	}
	
}
