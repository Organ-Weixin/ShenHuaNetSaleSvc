package com.boot.security.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.UsercinemaviewDao;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.service.UserCinemaViewService;

@Service
public class UserCinemaViewServiceImpl implements UserCinemaViewService {
	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private UsercinemaviewDao usercinemaviewDao;
	@Override
	public List<Usercinemaview> GetUserCinemaViewsByUserId(Long UserId) {
		return usercinemaviewDao.GetUserCinemaViewsByUserId(UserId);
	}
	
	@Override
	public Usercinemaview GetUserCinemaViewsByUserIdAndCinemaCode(Long UserId, String CinemaCode) {
		return usercinemaviewDao.GetUserCinemaViewsByUserIdAndCinemaCode(UserId, CinemaCode);
	}
	
	@Override
	public Usercinemaview getByCinemaCode(String cinemaCode) {
		return usercinemaviewDao.GetByCinemaCode(cinemaCode);
	}

}
