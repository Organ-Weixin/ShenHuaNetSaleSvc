package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Coupons;

public interface CouponsService {
	
	  Coupons getById(Long id);
	    
	    List<Coupons> getByOpenID(String openid);

	    Coupons getByGroupCode(String groupcode);
	
	Coupons getByCouponsCode(String couponscode);
	int update(Coupons coupons);
	int deleteByGroupCode(String groupcode);

}
