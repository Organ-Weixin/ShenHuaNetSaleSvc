package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Registeractive;

public interface RegisteractiveService {
	
	Registeractive getByCinemaCode(String cinemacode);
	
	List<Registeractive> getCanUseRegisterActive();
}
