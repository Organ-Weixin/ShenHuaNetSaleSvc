package com.boot.security.server.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.SessioninfoDao;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.service.SessioninfoService;

@Service
public class SessioninfoServiceImpl implements SessioninfoService{

	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private SessioninfoDao sessioninfoDao;

	@Override
	public List<Sessioninfo> getByCinemaCodeAndDate(Long userid, String cinemacode, Date StartDate, Date EndDate) {
		// TODO Auto-generated method stub
		return sessioninfoDao.getByCinemaCodeAndDate(userid, cinemacode, StartDate, EndDate);
	}
	
	@Override
	public int deleteByCinemaCodeAndDate(Long userid, String cinemacode, Date StartDate, Date EndDate) {
		// TODO Auto-generated method stub
		return sessioninfoDao.deleteByCinemaCodeAndDate(userid, cinemacode, StartDate, EndDate);
	}
	
	@Override
	public int save(Sessioninfo sessioninfo) {
		// TODO Auto-generated method stub
		return sessioninfoDao.save(sessioninfo);
	}
	
	@Override
	public Sessioninfo getBySessionCode(Long userid, String cinemacode, String sessioncode) {
		// TODO Auto-generated method stub
		return sessioninfoDao.getBySessionCode(userid, cinemacode, sessioncode);
	}

	@Override
	public List<Sessioninfo> getByCCode(String ccode, Date StartTime) {
		// TODO Auto-generated method stub
		return sessioninfoDao.getByCCode(ccode, StartTime);
	}

	@Override
	public Sessioninfo getByCinemaCodeAndSessionCodeAndUserId(String cinemacode, String sessioncode, Long userid) {
		// TODO Auto-generated method stub
		return sessioninfoDao.getByCinemaCodeAndSessionCodeAndUserId(cinemacode, sessioncode, userid);
	}


	@Override
	public List<Sessioninfo> getByCCodeGroupByFilm(Long userid, String cinemacode, Date StartDate, Date EndDate) {
		
		return sessioninfoDao.getByCCodeGroupByFilm(userid, cinemacode, StartDate, EndDate);
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return sessioninfoDao.delete(id);
	}

	@Override
	public int deleteByCinemaCode(Map<String, Object> params) {
		return sessioninfoDao.deleteByCinemaCode(params);
	}

	@Override
	public List<Sessioninfo> getFilms(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return sessioninfoDao.getFilms(params);
	}

	@Override
	public List<Sessioninfo> getFilmsByCinemaCode(String cinemacodes) {
		// TODO Auto-generated method stub
		return sessioninfoDao.getFilmsByCinemaCode(cinemacodes);
	}

	
	@Override
	public List<Sessioninfo> getByCinemaStartDateEndDate(String cinemacode, String StartDate, String EndDate) {
		return sessioninfoDao.getByCinemaStartDateEndDate(cinemacode, StartDate, EndDate);
	}

	@Override
	public Sessioninfo getSessionCode(String cinemacode, String sessioncode) {
		// TODO Auto-generated method stub
		return sessioninfoDao.getSessionCode(cinemacode, sessioncode);
	}


	
	
}
