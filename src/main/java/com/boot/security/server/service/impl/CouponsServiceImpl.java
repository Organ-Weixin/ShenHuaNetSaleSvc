package com.boot.security.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.CouponsDao;
import com.boot.security.server.model.Coupons;
import com.boot.security.server.service.CouponsService;

@Service
public class CouponsServiceImpl implements CouponsService{

	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private CouponsDao couponsdao;
	
	@Override
	public Coupons getByCouponsCode(String couponscode) {
		
		return couponsdao.getByCouponsCode(couponscode);
	}

	@Override
	public int update(Coupons coupons) {
		
		return couponsdao.update(coupons);
	}

}
