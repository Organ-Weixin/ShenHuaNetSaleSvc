package com.boot.security.server.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.GoodscomponentsDao;
import com.boot.security.server.model.Goodscomponents;
import com.boot.security.server.service.GoodscomponentsService;

@Service
public class GoodscomponentsServiceImpl implements GoodscomponentsService{
	
	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private GoodscomponentsDao goodscomponentsDao;
	@Override
	public Goodscomponents getById(Long id) {
		return goodscomponentsDao.getById(id);
	}
	@Override
	public int delete(Long id) {
		return goodscomponentsDao.delete(id);
	}
	@Override
	public int deleteByGoodsCode(String goodscode) {
		return goodscomponentsDao.deleteByGoodsCode(goodscode);
	}
	@Override
	public int update(Goodscomponents goodscomponents) {
		return goodscomponentsDao.update(goodscomponents);
	}
	@Override
	public int save(Goodscomponents goodscomponents) {
		return goodscomponentsDao.save(goodscomponents);
	}
	@Override
	public int count(Map<String, Object> params) {
		return goodscomponentsDao.count(params);
	}
	@Override
	public List<Goodscomponents> list(Map<String, Object> params, Integer offset, Integer limit) {
		return goodscomponentsDao.list(params, offset, limit);
	}
	@Override
	public Goodscomponents getByGoodsCode(String goodscode) {
		return goodscomponentsDao.getByGoodsCode(goodscode);
	}
	@Override
	public List<Goodscomponents> getByRecommendCode(String cinemacode, String recommendcode) {
		return goodscomponentsDao.getByRecommendCode(cinemacode, recommendcode);
	}
	@Override
	public List<Goodscomponents> getByPackageCode(String cinemacode, String packagecode) {
		return goodscomponentsDao.getByPackageCode(cinemacode, packagecode);
	}
	@Override
	public int deleteByPackageCode(String cinemacode, String packagecode) {
		return goodscomponentsDao.deleteByPackageCode(cinemacode, packagecode);
	}
	
}
