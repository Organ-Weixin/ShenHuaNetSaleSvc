package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.CouponsgroupDao;
import com.boot.security.server.model.Couponsgroup;
import com.boot.security.server.service.CouponsgroupService;
@Service
public class CouponsgroupServiceImpl implements CouponsgroupService{
	@Autowired
	private CouponsgroupDao couponsgroupDao;
	@Override
	public int changeStatus(Integer status, Long id) {
		return couponsgroupDao.changeStatus(status, id);
	}
	@Override
	public List<Couponsgroup> getByCinemaCode(String cinemacode) {
		return couponsgroupDao.getByCinemaCode(cinemacode);
	}
	@Override
	public Couponsgroup getById(Long id) {
		return couponsgroupDao.getById(id);
	}
	@Override
	public Couponsgroup getByGroupCode(String groupcode) {
		return couponsgroupDao.getByGroupCode(groupcode);
	}
	@Override
	public List<Couponsgroup> getPastCoupons() {
		return couponsgroupDao.getPastCoupons();
	}
	@Override
	public int updatePastCoupons(Integer status) {
		return couponsgroupDao.updatePastCoupons(status);
	}
	@Override
	public List<Couponsgroup> getCanUseByGroupCode(String cinemacode) {
		return couponsgroupDao.getCanUseByGroupCode(cinemacode);
	}
	@Override
	public List<Couponsgroup> getAllUseByGroupCode(String cinemacode) {
		return couponsgroupDao.getAllUseByGroupCode(cinemacode);
	}
	
}
