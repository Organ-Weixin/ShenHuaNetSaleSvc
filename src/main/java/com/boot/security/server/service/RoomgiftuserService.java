package com.boot.security.server.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.boot.security.server.model.Roomgiftuser;

public interface RoomgiftuserService {

	int save(Roomgiftuser roomgiftuser);
	
	List<Roomgiftuser> getByOpenidAndRoom(String gifttype,String openid, String roomcode);
	
	List<Roomgiftuser> getByRoomGift(String roomcode, String giftcode);
	
    List<Roomgiftuser> getByOpenid(String openid,String cinemacode);
    
    List<Roomgiftuser> getByOpenidAndRoomAndtime(String gifttype,String openid,String roomcode,String timestamp);

}
