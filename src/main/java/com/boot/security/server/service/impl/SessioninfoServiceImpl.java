package com.boot.security.server.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.SessioninfoDao;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.service.SessioninfoService;
@Service
public class SessioninfoServiceImpl implements SessioninfoService{
	@Autowired
	private SessioninfoDao SessioninfoDao;

	@Override
	public Sessioninfo getBySessionCode(Long userid, String cinemacode, String sessioncode) {
		// TODO Auto-generated method stub
		return SessioninfoDao.getBySessionCode(userid, cinemacode, sessioncode);
	}

	@Override
	public List<Sessioninfo> getByCinemaCodeAndDate(Long userid, String cinemacode, Date StartDate, Date EndDate) {
		// TODO Auto-generated method stub
		return SessioninfoDao.getByCinemaCodeAndDate(userid, cinemacode, StartDate, EndDate);
	}

	@Override
	public int deleteByCinemaCodeAndDate(Long userid, String cinemacode, Date StartDate, Date EndDate) {
		// TODO Auto-generated method stub
		return SessioninfoDao.deleteByCinemaCodeAndDate(userid, cinemacode, StartDate, EndDate);
	}

	@Override
	public int save(Sessioninfo sessioninfo) {
		// TODO Auto-generated method stub
		return SessioninfoDao.save(sessioninfo);
	}

	@Override
	public List<Sessioninfo> getFilms(String CCode, Date StartTime, Date EndTime) {
		// TODO Auto-generated method stub
		return SessioninfoDao.getFilms(CCode, StartTime, EndTime);
	}

	@Override
	public List<Sessioninfo> getByCCode(String ccode, Date StartTime) {
		// TODO Auto-generated method stub
		return SessioninfoDao.getByCCode(ccode, StartTime);
	}

	@Override
	public Sessioninfo getByCinemaCodeAndSessionCodeAndUserId(String cinemacode, String sessioncode, Long userid) {
		// TODO Auto-generated method stub
		return SessioninfoDao.getByCinemaCodeAndSessionCodeAndUserId(cinemacode, sessioncode, userid);
	}

	@Override
	public int delete(String ccode, Date StartTime) {
		// TODO Auto-generated method stub
		return SessioninfoDao.delete(ccode, StartTime);
	}
	
	
}
