package com.boot.security.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.DirectorDao;
import com.boot.security.server.model.Director;
import com.boot.security.server.service.DirectorService;

@Service
public class DirectorServiceImpl implements DirectorService{

	@Autowired
	private DirectorDao directordao;
	
	@Override
	public Director getById(Long id) {
		return directordao.getById(id);
	}

	@Override
	public Director getByName(String name) {
		return directordao.getByName(name);
	}

	@Override
	public int save(Director director) {
		return directordao.save(director);
	}

}
