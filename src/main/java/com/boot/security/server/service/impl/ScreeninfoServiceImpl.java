package com.boot.security.server.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.ScreeninfoDao;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.service.ScreeninfoService;
@Service
public class ScreeninfoServiceImpl  implements ScreeninfoService{

	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private ScreeninfoDao screeninfoDao;
	
	@Override
	public Screeninfo getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Screeninfo screeninfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Screeninfo screeninfo) {
		// TODO Auto-generated method stub
		return screeninfoDao.save(screeninfo);
	}

	@Override
	public int count(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Screeninfo> list(Map<String, Object> params, Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Screeninfo> getByCinemaCode(String cinemacode) {
		return screeninfoDao.getByCinemaCode(cinemacode);
	}

	@Override
	public int deleteByCinemaCode(String cinemacode) {
		return screeninfoDao.deleteByCinemaCode(cinemacode);
	}

	@Override
	/*public Screeninfo getByScreenCode(String CinemaCode, String ScreenCode) {
		// TODO Auto-generated method stub
		return screeninfoDao.getByScreenCode(CinemaCode, ScreenCode);
	}*/
	public Screeninfo getByScreenCode(String cinemacode, String screencode) {
		return screeninfoDao.getByScreenCode(cinemacode, screencode);
	}
}
