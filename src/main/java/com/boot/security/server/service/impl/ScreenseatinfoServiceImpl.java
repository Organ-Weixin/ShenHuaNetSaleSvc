package com.boot.security.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.ScreeninfoDao;
import com.boot.security.server.dao.ScreenseatinfoDao;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.service.ScreenseatinfoService;

@Service
public class ScreenseatinfoServiceImpl implements ScreenseatinfoService {
	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private ScreenseatinfoDao screenseatinfoDao;

	@Override
	public int deleteByCinemaCodeAndScreenCode(String cinemacode, String ScreenCode) {
		return screenseatinfoDao.delete(cinemacode, ScreenCode);
	}
	@Override
	public int save(Screenseatinfo seat) {
		return screenseatinfoDao.save(seat);
	}
	@Override
	public List<Screenseatinfo> getByCinemaCodeAndScreenCode(String cinemacode, String screencode) {
		return screenseatinfoDao.getByCinemaCodeAndScreenCode(cinemacode, screencode);
	}
	@Override
	public List<Screenseatinfo> getBySeatCodes(String cinemacode, String screencode, String seatcodes) {
		return screenseatinfoDao.getBySeatCodes(cinemacode, screencode, seatcodes);
	}
}
