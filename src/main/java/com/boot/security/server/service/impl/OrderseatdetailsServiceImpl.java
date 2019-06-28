package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.OrderseatdetailsDao;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.service.OrderseatdetailsService;
@Service
public class OrderseatdetailsServiceImpl implements OrderseatdetailsService{
	@Autowired
	private OrderseatdetailsDao orderseatdetailsDao;
	
	@Override
	public List<Orderseatdetails> getByOrderId(Long orderid) {
		return orderseatdetailsDao.getByOrderId(orderid);
	}

	@Override
	public int update(Orderseatdetails orderseatdetails) {
		return orderseatdetailsDao.update(orderseatdetails);
	}

	@Override
	public Orderseatdetails getById(Long id) {
		return orderseatdetailsDao.getById(id);
	}

}
