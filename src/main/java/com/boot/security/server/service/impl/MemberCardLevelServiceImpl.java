package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.MembercardlevelDao;
import com.boot.security.server.model.Membercardlevel;
import com.boot.security.server.service.MemberCardLevelService;
 
@Service
public class MemberCardLevelServiceImpl implements MemberCardLevelService {

	@Autowired
	private MembercardlevelDao membercardlevelDao;
	
	@Override
	public int Save(Membercardlevel membercardlevel) {
		// TODO Auto-generated method stub
		return membercardlevelDao.save(membercardlevel);
	}

	@Override
	public int update(Membercardlevel membercardlevel) {
		// TODO Auto-generated method stub
		return membercardlevelDao.update(membercardlevel);
	}
	
	@Override
	public int deleteByCinemaCode(String cinemacode) {
		// TODO Auto-generated method stub
		return membercardlevelDao.deleteByCinemaCode(cinemacode);
	}

	@Override
	public List<Membercardlevel> getByCinemaCode(String cinemacode) {
		// TODO Auto-generated method stub
		return membercardlevelDao.getByCinemaCode(cinemacode);
	}

	@Override
	public Membercardlevel getByCinemaCodeAndLevelCode(String cinemacode, String levelcode) {
		// TODO Auto-generated method stub
		return membercardlevelDao.getByCinemaCodeAndLevelCode(cinemacode, levelcode);
	}

	@Override
	public int changeStatus(Integer status, Long id) {
		// TODO Auto-generated method stub
		return membercardlevelDao.changeStatus(status, id);
	}

	@Override
	public List<Membercardlevel> getCanUseByCinemaCode(String cinemacode) {
		// TODO Auto-generated method stub
		return membercardlevelDao.getCanUseByCinemaCode(cinemacode);
	}

	@Override
	public int updateIsOnlineOpenCard(Integer isonlineopencard, String cinemacode, String levelcode) {
		// TODO Auto-generated method stub
		return membercardlevelDao.updateIsOnlineOpenCard(isonlineopencard, cinemacode, levelcode);
	}

	@Override
	public int initIsOnlineOpenCard(String cinemacode) {
		// TODO Auto-generated method stub
		return membercardlevelDao.initIsOnlineOpenCard(cinemacode);
	}

	@Override
	public Membercardlevel getCanOnlineOpenCard(String cinemacode) {
		// TODO Auto-generated method stub
		return membercardlevelDao.getCanOnlineOpenCard(cinemacode);
	}

}
