package com.boot.security.server.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.ScreenseatinfoDao;
import com.boot.security.server.dao.SessioninfoDao;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.service.SessioninfoService;

@Service
public class SessioninfoServiceImpl implements SessioninfoService {

	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private SessioninfoDao sessioninfoDao;

	@Override
	public List<Sessioninfo> getByCinemaCodeAndDate(Long userid,String cinemacode, Date StartDate, Date EndDate) {
		return sessioninfoDao.getByCinemaCodeAndDate(userid,cinemacode, StartDate, EndDate);
	}

	@Override
	public int deleteByCinemaCodeAndDate(Long userid,String cinemacode, Date StartDate, Date EndDate) {
		return sessioninfoDao.deleteByCinemaCodeAndDate(userid,cinemacode, StartDate, EndDate);
	}
	
	@Override
	public int save(Sessioninfo session) {
		return sessioninfoDao.save(session);
	}

	@Override
	public Sessioninfo getBySessionCode(Long userid, String cinemacode, String sessioncode) {
		return sessioninfoDao.getBySessionCode(userid, cinemacode, sessioncode);
	}

}
