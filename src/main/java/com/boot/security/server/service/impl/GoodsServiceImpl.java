package com.boot.security.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.GoodsDao;
import com.boot.security.server.model.Goods;
import com.boot.security.server.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	
	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private GoodsDao goodsDao;

	@Override
	public List<Goods> getByCinemaCode(Long userid, String cinemacode) {
		return goodsDao.getByCinemaCode(userid,cinemacode);
	}

	@Override
	public Goods getByCinemaCodeAndGoodsCode(String cinemacode, String goodscode) {
		return goodsDao.getByCinemaCodeAndGoodsCode(cinemacode, goodscode);
	}

	@Override
	public int save(Goods goods) {
		return goodsDao.save(goods);
	}

	@Override
	public int update(Goods goods) {
		return goodsDao.update(goods);
	}

	@Override
	public int deleteByCinemaCode(Long userid, String cinemacode) {
		return goodsDao.deleteByCinemaCode(userid, cinemacode);
	}

	@Override
	public List<Goods> getGoodsByCinemaCode(String cinemacodes) {
		return goodsDao.getGoodsByCinemaCode(cinemacodes);
	}

	@Override
	public int deleteByCinemaCodeAndGoodsCode(String cinemacode, String goodscode) {
		return goodsDao.deleteByCinemaCodeAndGoodsCode(cinemacode, goodscode);
	}

	/*@Override
	public List<Goods> getGoodsByCinemaCode(Long id,Long roleId) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsByCinemaCode(id,roleId);
	}*/

}
