package com.boot.security.server.service;

import com.boot.security.server.model.Adminorderview;

public interface AdminorderviewService {
	
	Adminorderview getByOrderCode(String cinemacode,String ordercode);
}
