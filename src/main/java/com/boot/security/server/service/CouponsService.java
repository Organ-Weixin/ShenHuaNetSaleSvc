package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.CouponsView;

public interface CouponsService {
	
	Coupons getById(Long id);
	
	List<Coupons> getByOpenID(String openid);
	
	List<Coupons> getByGroupCode(String groupcode);
	
	Coupons getByCouponsCode(String couponscode);
	
	int update(Coupons coupons);
	
	int update(CouponsView couponsview);
	
	int deleteByGroupCode(String groupcode);

	List<Coupons> getCanUseByGroupCode(String groupcode);
	
	CouponsView getWithCouponsCode(String couponscode);
	
	int changeStatus(String couponscode);
	
	int changePast(Integer status);
	
	List<Coupons> getUserCoupons(String openid,Integer status);
	
	List<Coupons> getByGroupCodeAndOpenId(String groupcode,String openid,Integer status);
}
