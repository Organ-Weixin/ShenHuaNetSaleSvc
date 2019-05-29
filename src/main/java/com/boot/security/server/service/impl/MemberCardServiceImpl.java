package com.boot.security.server.service.impl;

import java.util.List;

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
	
	@Override
	public int memberCardUnbind(String cinemacode, String cardno) {
		// TODO Auto-generated method stub
		return membercardDao.memberCardUnbind(cinemacode, cardno);
	}
	
	@Override
	public List<Membercard> getByCinemaCodeAndMobilePhone(String cinemacode, String mobilephone) {
		// TODO Auto-generated method stub
		return membercardDao.getByCinemaCodeAndMobilePhone(cinemacode, mobilephone);
	}

	@Override
	public List<Membercard> getByCinemaCodes(String cinemacodes) {
		// TODO Auto-generated method stub
		return membercardDao.getByCinemaCodes(cinemacodes);
	}

	@Override
	public List<Membercard> getByCinemaCodeAndOpenID(String cinemacode, String openid) {
		// TODO Auto-generated method stub
		return membercardDao.getByCinemaCodeAndOpenID(cinemacode, openid);
	}

	@Override
	public Membercard checkMemberCard(String cinemacode, String cardno, String cardpassword) {
		// TODO Auto-generated method stub
		return membercardDao.checkMemberCard(cinemacode, cardno, cardpassword);
	}

}
