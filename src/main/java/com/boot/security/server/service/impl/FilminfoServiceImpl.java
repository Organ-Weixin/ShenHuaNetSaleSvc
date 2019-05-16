package com.boot.security.server.service.impl;

import java.util.List;
import java.util.Map;

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

	@Override
	public List<Filminfo> getFilmByFilmName(String filmName) {
		// TODO Auto-generated method stub
		return filminfoDao.getFilmByFilmName(filmName);
	}

	@Override
	public Filminfo getById(Long id) {
		// TODO Auto-generated method stub
		return filminfoDao.getById(id);
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return filminfoDao.delete(id);
	}

	@Override
	public int count(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return filminfoDao.count(params);
	}

	@Override
	public List<Filminfo> list(Map<String, Object> params, Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return filminfoDao.list(params, offset, limit);
	}
	
}
