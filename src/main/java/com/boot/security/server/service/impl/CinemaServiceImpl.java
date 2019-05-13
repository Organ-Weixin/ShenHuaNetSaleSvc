package com.boot.security.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.model.Cinema;
import com.boot.security.server.service.CinemaService;
import com.boot.security.server.dao.CinemaDao;

@Service
public class CinemaServiceImpl implements CinemaService {

	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private CinemaDao cinemaDao;
	
	@Override
	public int save(Cinema cinema) {
		return cinemaDao.save(cinema);
	}

	@Override
	public int update(Cinema Cinema) {
		return cinemaDao.update(Cinema);
	}

	@Override
	public int delete(Long id) {
		return cinemaDao.delete(id);
	}

	@Override
	public Cinema getByCinemaCode(String cinemacode) {
		return cinemaDao.getByCinemaCode(cinemacode);
	}

}
