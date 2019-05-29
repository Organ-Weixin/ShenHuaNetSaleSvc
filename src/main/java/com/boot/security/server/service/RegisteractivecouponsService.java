package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Registeractivecoupons;

public interface RegisteractivecouponsService {
	
	int save(Registeractivecoupons registeractivecoupons);
	
	int deleteByRegisterActiveCode(String registeractivecode);
	
	List<Registeractivecoupons> getByRegisterActiveCode(String registerActiveCode);
}
