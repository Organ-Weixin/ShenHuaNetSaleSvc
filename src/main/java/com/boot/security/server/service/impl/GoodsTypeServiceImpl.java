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
		return goodstypeDao.getByCinemaCode(cinemacode);
	}

	@Override
	public Goodstype getByTypeCode(String cinemacode, String typecode) {
		return goodstypeDao.getByTypeCode(cinemacode, typecode);
	}

	@Override
	public int save(Goodstype goodstype) {
		return goodstypeDao.save(goodstype);
	}

}
