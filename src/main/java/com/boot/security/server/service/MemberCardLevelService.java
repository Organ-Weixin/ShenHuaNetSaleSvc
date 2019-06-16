package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Membercardlevel;

public interface MemberCardLevelService { 
	
	int Save(Membercardlevel membercardlevel);
	
	int update(Membercardlevel membercardlevel);
	
	int deleteByCinemaCode(String cinemacode);
	
	List<Membercardlevel> getByCinemaCode(String cinemacode);
	
	Membercardlevel getByCinemaCodeAndLevelCode(String cinemacode,String levelcode);
	
	int changeStatus(Integer status,Long id);
	
	List<Membercardlevel> getCanUseByCinemaCode(String cinemacode);
	
    int updateIsOnlineOpenCard(Integer isonlineopencard,String cinemacode,String levelcode);
    
    int initIsOnlineOpenCard(String cinemacode);
    
    Membercardlevel getCanOnlineOpenCard(String cinemacode);
}
