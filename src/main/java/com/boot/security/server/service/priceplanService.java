package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Priceplan;

public interface priceplanService {
	List<Priceplan> getByCode(Long userid,String cinemacode,String filmcode,String sessioncode);
}
