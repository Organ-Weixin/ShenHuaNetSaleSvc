package com.boot.security.server.service;

import java.util.List;


import com.boot.security.server.model.Goods;

public interface GoodsService {
	List<Goods> getByCinemaCode(Long userid,String cinemacode);
	
	Goods getByCinemaCodeAndGoodsCode(String cinemacode,String goodscode);
	
	int save(Goods goods);
	
	int update(Goods goods);
}
