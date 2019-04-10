package com.boot.security.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.ScreenseatinfoDao;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.service.ScreenseatinfoService;
@Service
public class ScreenseatinfoServiceImpl implements ScreenseatinfoService{
	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private ScreenseatinfoDao screenseatinfoDao;

	@Override
	public int deleteByScreenCode(String cinemacode, String screencode) {
		return screenseatinfoDao.deleteByScreenCode(cinemacode, screencode);
	}

	@Override
	public int save(Screenseatinfo screenseatinfo) {
		return screenseatinfoDao.save(screenseatinfo);
	}
	
	@Override
	public List<Screenseatinfo> getByCinemaCodeAndScreenCode(String cinemacode, String screencode) {
		// TODO Auto-generated method stub
		return screenseatinfoDao.getByCinemaCodeAndScreenCode(cinemacode, screencode);
	}

	@Override
	public List<Screenseatinfo> getBySeatCodes(String cinemacode, String screencode, String seatcodes) {
		// TODO Auto-generated method stub
		return screenseatinfoDao.getBySeatCodes(cinemacode, screencode, seatcodes);
	}

	@Override
	public List<Screenseatinfo> queryLoveSeats(String cinemacode, String screencode) {
		return screenseatinfoDao.queryLoveSeats(cinemacode, screencode);
	}


	@Override
	public int deleteByCinemaCodeAndScreenCode(String cinemacode, String screencode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Screenseatinfo> getGroupByGroupCode(String cinemacode, String screencode) {
		
		return screenseatinfoDao.getGroupByGroupCode(cinemacode, screencode);
	}

}
