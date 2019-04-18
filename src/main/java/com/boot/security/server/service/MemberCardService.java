package com.boot.security.server.service;

import com.boot.security.server.model.Membercard;

public interface MemberCardService {
	Membercard getByCardNo(String cinemacode,String cardno);
	int Save(Membercard membercard);
	int Update(Membercard membercard);

}
