package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Roomgiftsend;

public interface RoomgiftsendService {
	
	int save(Roomgiftsend roomgiftsend);

	List<Roomgiftsend> getByRoomCode(String roomcode,String giftcode);
}
