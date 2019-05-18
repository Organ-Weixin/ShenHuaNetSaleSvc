package com.boot.security.server.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.RoomgiftDao;
import com.boot.security.server.model.Roomgift;
import com.boot.security.server.service.RoomgiftService;

@Service
public class RoomgiftServiceImpl implements RoomgiftService {

	@Autowired
	private RoomgiftDao roomgiftdao;
	
	@Override
	public Roomgift getById(Long id) {
		return roomgiftdao.getById(id);
	}

	@Override
	public int delete(Long id) {
		return roomgiftdao.delete(id);
	}

	@Override
	public int update(Roomgift roomgift) {
		return roomgiftdao.update(roomgift);
	}

	@Override
	public int save(Roomgift roomgift) {
		return roomgiftdao.save(roomgift);
	}

	@Override
	public int count(Map<String, Object> params) {
		return roomgiftdao.count(params);
	}

	@Override
	public List<Roomgift> list(Map<String, Object> params, Integer offset, Integer limit) {
		return roomgiftdao.list(params, offset, limit);
	}

	@Override
	public List<Roomgift> getByCinema(String cinemacode) {
		return roomgiftdao.getByCinema(cinemacode);
	}

	@Override
	public Roomgift getByGiftCode(String giftcode) {
		return roomgiftdao.getByGiftCode(giftcode);
	}

}
