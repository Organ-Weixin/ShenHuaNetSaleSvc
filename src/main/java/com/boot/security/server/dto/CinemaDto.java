package com.boot.security.server.dto;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.boot.security.server.dao.CinemaDao;
import com.boot.security.server.model.Cinema;
public class CinemaDto implements CinemaDao{
	@Autowired
	CinemaDao CinemaD;
	@Override
	public Cinema getById(Long id) {
		// TODO Auto-generated method stub
		return CinemaD.getById(id);
	}

	@Override
	public Cinema getByCinemaCode(String cinemacode) {
		// TODO Auto-generated method stub
		return CinemaD.getByCinemaCode(cinemacode);
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return CinemaD.delete(id);
	}

	@Override
	public int update(Cinema cinema) {
		// TODO Auto-generated method stub
		return CinemaD.update(cinema);
	}

	@Override
	public int save(Cinema cinema) {
		// TODO Auto-generated method stub
		return CinemaD.save(cinema);
	}

	@Override
	public int count(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return CinemaD.count(params);
	}

	@Override
	public List<Cinema> list(Map<String, Object> params, Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return CinemaD.list(params, offset, limit);
	}
	
}
