package com.boot.security.server.service;

import java.util.List;


import com.boot.security.server.model.Membercard;

public interface MemberCardService { 
	Membercard getByCardNo(String cinemacode,String cardno);
	int Save(Membercard membercard);
	int Update(Membercard membercard);
	List<Membercard> getByCinemaCodeAndMobilePhone(String cinemacode,String mobilephone);
	List<Membercard> getByCinemaCodeAndOpenId(String cinemacode,String openid);
}
