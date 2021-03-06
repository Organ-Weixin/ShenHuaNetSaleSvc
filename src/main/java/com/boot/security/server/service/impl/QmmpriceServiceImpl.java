package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.QmmpriceDao;
import com.boot.security.server.model.Qmmprice;
import com.boot.security.server.service.QmmpriceService;

@Service
public class QmmpriceServiceImpl implements QmmpriceService {

	@Autowired
	private QmmpriceDao qmmpricedao;
	
	@Override
	public Qmmprice getById(Long id) {
		return qmmpricedao.getById(id);
	}

	@Override
	public int update(Qmmprice qmmprice) {
		return qmmpricedao.update(qmmprice);
	}

	@Override
	public int save(Qmmprice qmmprice) {
		return qmmpricedao.save(qmmprice);
	}

	@Override
	public Qmmprice getByShowId(String showId) {
		return qmmpricedao.getByShowId(showId);
	}

	@Override
	public List<Qmmprice> getByCinemaCodeAndScreenName(String cinemacode, String screenname, String showtime) {
		return qmmpricedao.getByCinemaCodeAndScreenName(cinemacode, screenname, showtime);
	}

	@Override
	public List<Qmmprice> selectDataType() {
		return qmmpricedao.getDataType();
	}

}
