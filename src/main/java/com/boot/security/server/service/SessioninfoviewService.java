package com.boot.security.server.service;

import com.boot.security.server.modelView.Sessioninfoview;

public interface SessioninfoviewService {
	
	Sessioninfoview getByCinemaCodeAndSessionCode(String cinemacode,String sessioncode);
}
