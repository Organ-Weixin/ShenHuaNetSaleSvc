package com.boot.security.server.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodsorders;

public interface GoodsOrderService {
	@Transactional(propagation = Propagation.REQUIRED)
	int Insert(GoodsOrderView orderview);
	@Transactional(propagation = Propagation.REQUIRED)
	int Update(GoodsOrderView orderview);
	Goodsorders getByLocalOrderCode(String cinemacode,String localordercode);
	GoodsOrderView getWithLocalOrderCode(String cinemacode,String localordercode);
	GoodsOrderView getWithOrderCode(String cinemacode,String ordercode);
	int UpdateOrderBaseInfo(Goodsorders orderbase);
}
