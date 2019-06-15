package com.boot.security.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.CouponsDao;
import com.boot.security.server.dao.CouponsgroupDao;
import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.CouponsView;
import com.boot.security.server.service.CouponsService;

@Service
public class CouponsServiceImpl implements CouponsService{

	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private CouponsDao couponsdao;
	@Autowired
	private CouponsgroupDao couponsgroupdao;
	
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
	public List<Coupons> getByGroupCode(String groupcode) {
		return couponsdao.getByGroupCode(groupcode);
	}

	@Override
	public List<Coupons> getCanUseByGroupCode(String groupcode) {
		return couponsdao.getCanUseByGroupCode(groupcode);
	}

	@Override
	public CouponsView getWithCouponsCode(String couponscode) {
		// TODO Auto-generated method stub
		CouponsView couponsview=new CouponsView();
		couponsview.setCoupons(couponsdao.getByCouponsCode(couponscode));
		couponsview.setCouponsgroup(couponsgroupdao.getByGroupCode(couponsview.getCoupons().getGroupCode()));
		return couponsview;
	}

	@Override
	public int update(CouponsView couponsview) {
		// TODO Auto-generated method stub
		couponsdao.update(couponsview.getCoupons());
		couponsgroupdao.update(couponsview.getCouponsgroup());
		return 1;//暂时
	}

	@Override
	public int changeStatus(String couponscode) {
		// TODO Auto-generated method stub
		return couponsdao.changeStatus(couponscode);
	}

	@Override
	public int changePast(Integer status) {
		// TODO Auto-generated method stub
		return couponsdao.changePast(status);
	}

	@Override
	public List<Coupons> getUserCoupons(String openid, Integer status) {
		// TODO Auto-generated method stub
		return couponsdao.getUserCoupons(openid, status);
	}

	@Override
	public List<Coupons> getByGroupCodeAndOpenId(String groupcode, String openid, Integer status) {
		// TODO Auto-generated method stub
		return couponsdao.getByGroupCodeAndOpenId(groupcode, openid, status);
	}

	@Override
	public int save(Coupons Coupons) {
		// TODO Auto-generated method stub
		return couponsdao.save(Coupons);
	}
}
