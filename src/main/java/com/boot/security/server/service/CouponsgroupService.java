package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Couponsgroup;

public interface CouponsgroupService {
	Couponsgroup getById(Long id);
	
	Couponsgroup getByGroupCode(String  groupcode);
	
	List<Couponsgroup> getByCinemaCode(String cinemacode);
	    
	Couponsgroup getByCinemaCodeAndGroupCode(String cinemacodes,String groupcode);
	

	List<Couponsgroup> getCanUseByGroupCode(String cinemacode);
	
	List<Couponsgroup> getAllUseByGroupCode(String cinemacode);
	
	List<Couponsgroup> getAllCinemaCanUseCoupons();
	    
	int changeStatus(Integer status,Long id);
	
	int updatePastCoupons(Integer status);
	
	int update(Couponsgroup couponsgroup);
	
	int changePast(Integer status);
}
