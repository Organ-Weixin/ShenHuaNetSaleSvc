package com.boot.security.server.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.CinemaviewDao;
import com.boot.security.server.model.Cinemaview;
import com.boot.security.server.service.CinemaviewService;

@Service
public class CinemaviewServiceImpl implements CinemaviewService{
	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private CinemaviewDao  cinemaviewDao;
	@Override
	public Cinemaview getById(Long id) {
		return cinemaviewDao.getById(id);
	}
	@Override
	public int delete(Long id) {
		return cinemaviewDao.delete(id);
	}
	@Override
	public int update(Cinemaview cinemaview) {
		return cinemaviewDao.update(cinemaview);
	}
	@Override
	public int save(Cinemaview cinemaview) {
		return cinemaviewDao.save(cinemaview);
	}
	@Override
	public int count(Map<String, Object> params) {
		return cinemaviewDao.count(params);
	}
	@Override
	public List<Cinemaview> list(Map<String, Object> params, Integer offset, Integer limit) {
		return cinemaviewDao.list(params, offset, limit);
	}
	@Override
	public Cinemaview getByCinemaCode(String cinemacode) {
		return cinemaviewDao.getByCinemaCode(cinemacode);
	}
}
