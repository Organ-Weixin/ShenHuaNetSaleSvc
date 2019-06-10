package com.boot.security.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.AdminorderviewDao;
import com.boot.security.server.model.Adminorderview;
import com.boot.security.server.service.AdminorderviewService;
@Service
public class AdminorderviewServiceImpl implements AdminorderviewService{
	@Autowired
	private AdminorderviewDao adminorderviewDao;
	@Override
	public Adminorderview getByOrderCode(String cinemacode, String ordercode) {
		return adminorderviewDao.getByOrderCode(cinemacode, ordercode);
	}

}
