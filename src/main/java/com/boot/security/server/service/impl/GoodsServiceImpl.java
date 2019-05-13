package com.boot.security.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
		// TODO Auto-generated method stub
		return goodsDao.getByCinemaCode(userid,cinemacode);
	}

	@Override
	public Goods getByCinemaCodeAndGoodsCode(String cinemacode, String goodscode) {
		// TODO Auto-generated method stub
		return goodsDao.getByCinemaCodeAndGoodsCode(cinemacode, goodscode);
	}

	@Override
	public int save(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.save(goods);
	}

	@Override
	public int update(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.update(goods);
	}

	@Override
	public Goods getByGoodsCode(String goodscode) {
		// TODO Auto-generated method stub
		return goodsDao.getByGoodsCode(goodscode);
	}

	@Override
	public int deleteByCinemaCode(Long userid, String cinemacode) {
		// TODO Auto-generated method stub
		return goodsDao.deleteByCinemaCode(userid, cinemacode);
	}

	@Override
	public List<Goods> getGoodsByCinemaCode(String cinemacodes) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsByCinemaCode(cinemacodes);
	}

	/*@Override
	public List<Goods> getGoodsByCinemaCode(Long id,Long roleId) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsByCinemaCode(id,roleId);
	}*/

}
