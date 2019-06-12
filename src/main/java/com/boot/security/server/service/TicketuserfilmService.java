package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Ticketuserfilm;

public interface TicketuserfilmService {
	
	int save(Ticketuserfilm ticketuserfilm);
	
	int update(Ticketuserfilm ticketuserfilm);
	
	int deleteByFilmCode(String openid,String filmcode);

	List<Ticketuserfilm> getByOpenId(String openid,Integer status);
	
	Ticketuserfilm getByFilmCode(String openid,String filmcode);
}
