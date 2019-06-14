package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.RoomgiftsendDao;
import com.boot.security.server.model.Roomgiftsend;
import com.boot.security.server.service.RoomgiftsendService;

@Service
public class RoomgiftsendServiceImpl implements RoomgiftsendService {

	@Autowired
	private RoomgiftsendDao dao;
	
	@Override
	public int save(Roomgiftsend roomgiftsend) {
		return dao.save(roomgiftsend);
	}
	
	@Override
	public List<Roomgiftsend> getByRoomCode(String gifttype,String roomcode, String giftcode) {
		return dao.getByRoomCode(gifttype,roomcode, giftcode);
	}

	@Override
	public Roomgiftsend getByGiftAndRoomAndTimestamp(String gifttype, String giftcode, String roomcode,
			String timestamp) {
		// TODO Auto-generated method stub
		return dao.getByGiftAndRoomAndTimestamp(gifttype, giftcode, roomcode, timestamp);
	}
	
	
	
}
