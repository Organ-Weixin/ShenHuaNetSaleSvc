package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Adminorderview;

public interface AdminorderviewService {
	
	List<Adminorderview> getByOrderCode(String cinemacode,String ordercode);
}
