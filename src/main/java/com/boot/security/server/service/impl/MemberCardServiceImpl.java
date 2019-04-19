package com.boot.security.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.MembercardDao;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.service.MemberCardService;

@Service
public class MemberCardServiceImpl implements MemberCardService {

	@Autowired
	private MembercardDao membercardDao; 
	
	@Override
	public Membercard getByCardNo(String cinemacode, String cardno) {
		return membercardDao.getByCardNo(cinemacode, cardno);
	}

	@Override
	public int Save(Membercard membercard) {
		// TODO Auto-generated method stub
		return membercardDao.save(membercard);
	}

	@Override
	public int Update(Membercard membercard) {
		// TODO Auto-generated method stub
		return membercardDao.update(membercard);
	}
}