package com.boot.security.server.service;

import com.boot.security.server.model.Coupons;

public interface CouponsService {
	Coupons getByCouponsCode(String couponscode);
	int update(Coupons coupons);

}
