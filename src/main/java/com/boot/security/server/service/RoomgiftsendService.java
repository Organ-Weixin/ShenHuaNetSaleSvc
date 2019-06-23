package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Roomgiftsend;

public interface RoomgiftsendService {
	
	int save(Roomgiftsend roomgiftsend);

	List<Roomgiftsend> getByRoomCode(String gifttype,String roomcode,String giftcode);
	
	Roomgiftsend getByGiftAndRoomAndTimestamp(String gifttype,String giftcode,String roomcode,String timestamp);
}
