package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Usercinemaview;

public interface UserCinemaViewService {
	List<Usercinemaview> GetUserCinemaViewsByUserId(Long UserId);
	Usercinemaview GetUserCinemaViewsByUserIdAndCinemaCode(Long UserId,String CinemaCode);
	Usercinemaview getByCinemaCode(String cinemaCode);
}
