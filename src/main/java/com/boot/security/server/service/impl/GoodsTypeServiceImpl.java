package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.GoodstypeDao;
import com.boot.security.server.model.Goodstype;
import com.boot.security.server.service.GoodsTypeService;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
	@Autowired
	private GoodstypeDao goodstypeDao;

	@Override
	public List<Goodstype> getByCinemaCode(String cinemacode) {
		// TODO Auto-generated method stub
		return goodstypeDao.getByCinemaCode(cinemacode);
	}

}
