package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Goods;

public interface GoodsService {
	List<Goods> getByCinemaCode(Long userid,String cinemacode);

}
