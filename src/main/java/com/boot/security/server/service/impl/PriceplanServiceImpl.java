package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.PriceplanDao;
import com.boot.security.server.model.Priceplan;
import com.boot.security.server.service.priceplanService;

@Service
public class PriceplanServiceImpl implements priceplanService {
	@Autowired
	private PriceplanDao priceplanDao;

	@Override
	public List<Priceplan> getByCode(Long userid, String cinemacode, String filmcode,String sessioncode) {
		// TODO Auto-generated method stub
		return priceplanDao.getByCode(userid, cinemacode, filmcode, sessioncode);
	}

}
