package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.ActorconfigurationDao;
import com.boot.security.server.model.Actorconfiguration;
import com.boot.security.server.service.ActorconfigurationService;
@Service
public class ActorconfigurationServiceImpl implements ActorconfigurationService{
	@Autowired
	private ActorconfigurationDao actorconfigurationDao;
	
	@Override
	public List<Actorconfiguration> getByFilmCodeAndType(String filmcode, String type) {
		return actorconfigurationDao.getByFilmCodeAndType(filmcode, type);
	}

}
