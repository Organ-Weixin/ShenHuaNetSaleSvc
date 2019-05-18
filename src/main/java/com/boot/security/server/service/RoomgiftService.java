package com.boot.security.server.service;

import java.util.List;
import java.util.Map;

import com.boot.security.server.model.Roomgift;

public interface RoomgiftService {

	Roomgift getById(Long id);
	int delete(Long id);
	int update(Roomgift roomgift);
	int save(Roomgift roomgift);
	int count(Map<String, Object> params);
	List<Roomgift> list(Map<String, Object> params,Integer offset, Integer limit);
	
	List<Roomgift> getByCinema(String cinemacode);
	
	Roomgift getByGiftCode(String giftcode);
	
}
