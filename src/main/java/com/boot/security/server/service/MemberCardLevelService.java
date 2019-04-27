package com.boot.security.server.service;

import java.util.List;


import com.boot.security.server.model.Membercardlevel;

public interface MemberCardLevelService { 
	int Save(Membercardlevel membercardlevel);
	int deleteByCinemaCode(String cinemacode);
	List<Membercardlevel> getByCinemaCode(String cinemacode);
	Membercardlevel getByCinemaCodeAndLevelCode(String cinemacode,String levelcode);

}
