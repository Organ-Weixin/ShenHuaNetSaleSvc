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
	public int updatePastCoupons(Integer status) {
		return couponsgroupDao.updatePastCoupons(status);
	}
	@Override
	public List<Couponsgroup> getCanUseByGroupCode(String cinemacode) {
		return couponsgroupDao.getCanUseByGroupCode(cinemacode);
	}
	@Override
	public int update(Couponsgroup couponsgroup) {
		return couponsgroupDao.update(couponsgroup);
	}
	@Override
	public List<Couponsgroup> getAllUseByGroupCode(String cinemacode) {
		return couponsgroupDao.getAllUseByGroupCode(cinemacode);
	}
	@Override
	public List<Couponsgroup> getAllCinemaCanUseCoupons() {
		return couponsgroupDao.getAllCinemaCanUseCoupons();
	}
	@Override
	public int changePast(Integer status) {
		return couponsgroupDao.changePast(status);
	}
	@Override
	public Couponsgroup getByCinemaCodeAndGroupCode(String cinemacodes, String groupcode) {
		return couponsgroupDao.getByCinemaCodeAndGroupCode(cinemacodes, groupcode);
	}
	@Override
	public Couponsgroup getUserCouponsGroup(String groupcode, Integer status, String cinemacode) {
		return couponsgroupDao.getUserCouponsGroup(groupcode, status, cinemacode);
	}
	@Override
	public List<Couponsgroup> getChatRoomCouponsByCinemaCode(String cinemacode) {
		return couponsgroupDao.getChatRoomCouponsByCinemaCode(cinemacode);
	}
	@Override
	public int updateIssuedNumber(Integer issuednumber, String groupcode) {
		return couponsgroupDao.updateIssuedNumber(issuednumber, groupcode);
	}
}
