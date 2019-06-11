package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.TicketuserfilmDao;
import com.boot.security.server.model.Ticketuserfilm;
import com.boot.security.server.service.TicketuserfilmService;
@Service
public class TicketuserfilmServiceImpl implements TicketuserfilmService{
	@Autowired
	private TicketuserfilmDao ticketuserfilmDao;
	
	@Override
	public int save(Ticketuserfilm ticketuserfilm) {
		// TODO Auto-generated method stub
		return ticketuserfilmDao.save(ticketuserfilm);
	}
	
	@Override
	public List<Ticketuserfilm> getByOpenId(String openid) {
		// TODO Auto-generated method stub
		return ticketuserfilmDao.getByOpenId(openid);
	}

	@Override
	public int deleteByFilmCode(String openid, String filmcode) {
		// TODO Auto-generated method stub
		return ticketuserfilmDao.deleteByFilmCode(openid, filmcode);
	}

	@Override
	public Ticketuserfilm getByFilmCode(String openid, String filmcode) {
		// TODO Auto-generated method stub
		return ticketuserfilmDao.getByFilmCode(openid, filmcode);
	}

	@Override
	public int update(Ticketuserfilm ticketuserfilm) {
		// TODO Auto-generated method stub
		return ticketuserfilmDao.update(ticketuserfilm);
	}

}
