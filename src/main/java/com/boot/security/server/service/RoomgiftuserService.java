package com.boot.security.server.service;

import java.util.List;


import com.boot.security.server.model.Roomgiftuser;

public interface RoomgiftuserService {

	int save(Roomgiftuser roomgiftuser);
	
	List<Roomgiftuser> getByOpenidAndRoom(String openid, String roomcode);
	
	List<Roomgiftuser> getByOpenid(String openid);
}
