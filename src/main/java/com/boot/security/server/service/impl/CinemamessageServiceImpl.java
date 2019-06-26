package com.boot.security.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.CinemamessageDao;
import com.boot.security.server.model.Cinemamessage;
import com.boot.security.server.service.CinemamessageService;

@Service
public class CinemamessageServiceImpl implements CinemamessageService {
	@Autowired
	private CinemamessageDao cinemamessageDao;

	@Override
	public Cinemamessage getByCinemaCodeAndMessageType(String CinemaCode, String MessageType) {
		// TODO Auto-generated method stub
		return cinemamessageDao.getByCinemaCodeAndMessageType(CinemaCode, MessageType);
	}

}
