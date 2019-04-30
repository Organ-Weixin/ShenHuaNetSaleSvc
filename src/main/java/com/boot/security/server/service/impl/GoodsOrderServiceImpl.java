package com.boot.security.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.GoodsorderdetailsDao;
import com.boot.security.server.dao.GoodsordersDao;
import com.boot.security.server.dao.OrdersDao;
import com.boot.security.server.dao.OrderseatdetailsDao;
import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodsorderdetails;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.service.GoodsOrderService;

@Service
public class GoodsOrderServiceImpl implements GoodsOrderService {
	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private GoodsordersDao ordersDao;
	@Autowired
	private GoodsorderdetailsDao orderdetailsDao;
	@Override
	public int Insert(GoodsOrderView orderview) {
		ordersDao.save(orderview.getOrderBaseInfo());
		//重新读出主订单
		Goodsorders order = ordersDao.getByLocalOrderCode(orderview.getOrderBaseInfo().getCinemaCode(), orderview.getOrderBaseInfo().getLocalOrderCode());
		if(order != null){
			for(Goodsorderdetails orderdetail:orderview.getOrderGoodsDetails()){
				orderdetail.setOrderId(order.getId());	//将orders表成功插入的数据id作为orderdetails表的OrderId
				orderdetailsDao.save(orderdetail);
			}
		}
		return 1;//暂时的
	}
	@Override
	public Goodsorders getByLocalOrderCode(String cinemacode, String localordercode) {
		// TODO Auto-generated method stub
		return ordersDao.getByLocalOrderCode(cinemacode, localordercode);
	}
	@Override
	public GoodsOrderView getWithLocalOrderCode(String cinemacode, String localordercode) {
		// TODO Auto-generated method stub
		GoodsOrderView orderview=new GoodsOrderView();
		orderview.setOrderBaseInfo(ordersDao.getByLocalOrderCode(cinemacode, localordercode));
		orderview.setOrderGoodsDetails(orderdetailsDao.getByOrderId(orderview.getOrderBaseInfo().getId()));
		return orderview;
	}
	@Override
	public int Update(GoodsOrderView orderview) {
		ordersDao.update(orderview.getOrderBaseInfo());
		for(Goodsorderdetails orderdetail:orderview.getOrderGoodsDetails()){
			orderdetailsDao.update(orderdetail);
		}
		return 1;//暂时
	}
	@Override
	public GoodsOrderView getWithOrderCode(String cinemacode, String ordercode) {
		GoodsOrderView orderview=new GoodsOrderView();
		orderview.setOrderBaseInfo(ordersDao.getByOrderCode(cinemacode, ordercode));
		orderview.setOrderGoodsDetails(orderdetailsDao.getByOrderId(orderview.getOrderBaseInfo().getId()));
		return orderview;

	}
	@Override
	public int UpdateOrderBaseInfo(Goodsorders orderbase) {
		// TODO Auto-generated method stub
		return ordersDao.update(orderbase);
	}

}
