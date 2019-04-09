package com.boot.security.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.boot.security.server.dao.OrdersDao;
import com.boot.security.server.dao.OrderseatdetailsDao;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private OrderseatdetailsDao orderseatdetailssDao;

	@Override
	public int Insert(OrderView orderview) {
		ordersDao.save(orderview.getOrderBaseInfo());
		for(Orderseatdetails orderseat:orderview.getOrderSeatDetails()){
			orderseatdetailssDao.save(orderseat);
		}
		return 1;//暂时的
	}

	@Override
	public OrderView getOrderWidthLockOrderCode(String cinemacode, String lockordercode) {
		OrderView orderview=new OrderView();
		orderview.setOrderBaseInfo(ordersDao.getByLockOrderCode(cinemacode,lockordercode));
		orderview.setOrderSeatDetails(orderseatdetailssDao.getByOrderId(orderview.getOrderBaseInfo().getId()));
		return orderview;
	}

	@Override
	public int UpdateOrderBaseInfo(Orders orderbase) {
		return ordersDao.update(orderbase);
	}

	@Override
	public int Update(OrderView orderview) {
		ordersDao.update(orderview.getOrderBaseInfo());
		for(Orderseatdetails orderseat:orderview.getOrderSeatDetails()){
			orderseatdetailssDao.update(orderseat);
		}
		return 1;//暂时
	}

	@Override
	public OrderView getOrderWidthPrintNo(String cinemacode, String printno,String verifycode) {
		OrderView orderview=new OrderView();
		orderview.setOrderBaseInfo(ordersDao.getByPrintNo(cinemacode,printno,verifycode));
		orderview.setOrderSeatDetails(orderseatdetailssDao.getByOrderId(orderview.getOrderBaseInfo().getId()));
		return orderview;
	}

	@Override
	public OrderView getOrderWidthOrderCode(String cinemacode, String ordercode) {
		OrderView orderview=new OrderView();
		orderview.setOrderBaseInfo(ordersDao.getByOrderCode(cinemacode,ordercode));
		orderview.setOrderSeatDetails(orderseatdetailssDao.getByOrderId(orderview.getOrderBaseInfo().getId()));
		return orderview;
	}

}
