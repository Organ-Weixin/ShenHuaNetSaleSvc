package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.RegistercollectionrecordDao;
import com.boot.security.server.model.Registercollectionrecord;
import com.boot.security.server.service.RegistercollectionrecordService;
@Service
public class RegistercollectionrecordServiceImpl implements RegistercollectionrecordService{
	@Autowired
	private RegistercollectionrecordDao registercollectionrecordDao;

	@Override
	public int save(Registercollectionrecord registercollectionrecord) {
		// TODO Auto-generated method stub
		return registercollectionrecordDao.save(registercollectionrecord);
	}

	@Override
	public List<Registercollectionrecord> getByOpenID(String openid) {
		// TODO Auto-generated method stub
		return registercollectionrecordDao.getByOpenID(openid);
	}
	
}
