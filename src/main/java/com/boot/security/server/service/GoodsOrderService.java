package com.boot.security.server.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodsorders;

public interface GoodsOrderService {
	Goodsorders getById(Long Id);
	@Transactional(propagation = Propagation.REQUIRED)
	int Insert(GoodsOrderView orderview);
	@Transactional(propagation = Propagation.REQUIRED)
	int Update(GoodsOrderView orderview);
	Goodsorders getByLocalOrderCode(String localordercode);
	Goodsorders getByOrderCode(String ordercode);
	GoodsOrderView getWithLocalOrderCode(String localordercode);
	GoodsOrderView getWithLocalOrderCode(String cinemacode,String localordercode);
	GoodsOrderView getWithOrderCode(String cinemacode,String ordercode);
	int UpdateOrderBaseInfo(Goodsorders orderbase);
    List<Goodsorders> getByCinemaCode(String cinemacode);
    List<Goodsorders> getByCinemaCodeAndOpenID(String cinemacode,String openid);
    List<Goodsorders> getByOpenID(String openid,String time);
    int update(Goodsorders goodsorders);
    Goodsorders getByOrderTradeNo(String cinemacode,String ordertradeno);
    
}
