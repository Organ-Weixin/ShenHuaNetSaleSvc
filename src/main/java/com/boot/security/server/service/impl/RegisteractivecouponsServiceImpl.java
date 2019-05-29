package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.RegisteractivecouponsDao;
import com.boot.security.server.model.Registeractivecoupons;
import com.boot.security.server.service.RegisteractivecouponsService;
@Service
public class RegisteractivecouponsServiceImpl implements RegisteractivecouponsService{
	@Autowired
	private RegisteractivecouponsDao registeractivecouponsDao;
	
	@Override
	public int save(Registeractivecoupons registeractivecoupons) {
		// TODO Auto-generated method stub
		return registeractivecouponsDao.save(registeractivecoupons);
	}

	@Override
	public int deleteByRegisterActiveCode(String registeractivecode) {
		// TODO Auto-generated method stub
		return registeractivecouponsDao.deleteByRegisterActiveCode(registeractivecode);
	}

	@Override
	public List<Registeractivecoupons> getByRegisterActiveCode(String registerActiveCode) {
		// TODO Auto-generated method stub
		return registeractivecouponsDao.getByRegisterActiveCode(registerActiveCode);
	}

}
