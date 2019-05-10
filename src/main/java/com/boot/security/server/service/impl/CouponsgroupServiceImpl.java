package com.boot.security.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.CouponsgroupDao;
import com.boot.security.server.service.CouponsgroupService;
@Service
public class CouponsgroupServiceImpl implements CouponsgroupService{
	@Autowired
	private CouponsgroupDao couponsgroupDao;
	@Override
	public int changeStatus(Integer status, Long id) {
		// TODO Auto-generated method stub
		return couponsgroupDao.changeStatus(status, id);
	}
	
}
