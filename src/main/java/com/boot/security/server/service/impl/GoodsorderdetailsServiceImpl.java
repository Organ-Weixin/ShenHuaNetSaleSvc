package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.GoodsorderdetailsDao;
import com.boot.security.server.model.Goodsorderdetails;
import com.boot.security.server.service.GoodsorderdetailsService;
@Service
public class GoodsorderdetailsServiceImpl implements GoodsorderdetailsService{
	@Autowired
	private GoodsorderdetailsDao goodsorderdetailsDao;
	@Override
	public List<Goodsorderdetails> getByOrderId(Long orderid) {
		return goodsorderdetailsDao.getByOrderId(orderid);
	}
	
}
