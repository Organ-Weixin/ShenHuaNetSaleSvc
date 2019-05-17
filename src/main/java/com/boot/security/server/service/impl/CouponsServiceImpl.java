package com.boot.security.server.service.impl;

import java.util.List;

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

	@Override
	public int deleteByGroupCode(String groupcode) {
		return couponsdao.deleteByGroupCode(groupcode);
	}

	@Override
	public Coupons getById(Long id) {
		return couponsdao.getById(id);
	}

	@Override
	public List<Coupons> getByOpenID(String openid) {
		return couponsdao.getByOpenID(openid);
	}

	@Override
	public Coupons getByGroupCode(String groupcode) {
		return couponsdao.getByCouponsCode(groupcode);
	}

	@Override
	public List<Coupons> getCanUseByGroupCode(String groupcode) {
		return couponsdao.getCanUseByGroupCode(groupcode);
	}

}
