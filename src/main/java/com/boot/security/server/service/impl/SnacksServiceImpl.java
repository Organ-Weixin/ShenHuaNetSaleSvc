package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.SnacksDao;
import com.boot.security.server.model.Snacks;
import com.boot.security.server.service.SnacksService;
@Service
public class SnacksServiceImpl implements SnacksService{
	@Autowired
	private SnacksDao snacksDao;

	@Override
	public List<Snacks> getByCinemaCode(String cinemacode) {
		// TODO Auto-generated method stub
		return snacksDao.getByCinemaCode(cinemacode);
	}
	
}
