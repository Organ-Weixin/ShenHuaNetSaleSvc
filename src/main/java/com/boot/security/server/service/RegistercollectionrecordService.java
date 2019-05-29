package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Registercollectionrecord;

public interface RegistercollectionrecordService {
	
	int save(Registercollectionrecord registercollectionrecord);
	
	List<Registercollectionrecord> getByOpenID(String openid);
}
