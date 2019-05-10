package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Couponsgroup;

public interface CouponsgroupService {
	
	   Couponsgroup getById(Long id);
	    
	    List<Couponsgroup> getByCinemaCodes(String  cinemacodes);

	    Couponsgroup getByGroupCode(String  groupcode);
	int changeStatus(Integer status,Long id);
}
