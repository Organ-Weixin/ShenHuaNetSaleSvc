package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.RoomgiftuserDao;
import com.boot.security.server.model.Roomgiftuser;
import com.boot.security.server.service.RoomgiftuserService;

@Service
public class RoomgiftuserServiceImpl implements RoomgiftuserService {

	@Autowired
	private RoomgiftuserDao roomgiftuserDao;
	
	@Override
	public int save(Roomgiftuser roomgiftuser) {
		return roomgiftuserDao.save(roomgiftuser);
	}

	@Override
	public List<Roomgiftuser> getByOpenidAndRoom(String openid, String roomcode) {
		return roomgiftuserDao.getByOpenidAndRoom(openid, roomcode);
	}

	@Override
	public List<Roomgiftuser> getByRoomGift(String roomcode, String giftcode) {
		return roomgiftuserDao.getByRoomGift(roomcode, giftcode);
	}

	@Override
	public List<Roomgiftuser> getByOpenid(String openid, String cinemacode) {
		return roomgiftuserDao.getByOpenid(openid, cinemacode);
	}

}
