package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Couponsgroup;

public interface CouponsgroupService {
	Couponsgroup getById(Long id);
	
	Couponsgroup getByGroupCode(String  groupcode);
	
	List<Couponsgroup> getByCinemaCode(String cinemacode);
	
	List<Couponsgroup> getCanUseByGroupCode(String cinemacode);
	List<Couponsgroup> getAllUseByGroupCode(String cinemacode);
	    
	int changeStatus(Integer status,Long id);
	
	List<Couponsgroup> getPastCoupons();
	
	int updatePastCoupons(Integer status);
}
