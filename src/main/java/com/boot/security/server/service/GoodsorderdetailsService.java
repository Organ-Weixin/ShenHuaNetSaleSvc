package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Goodsorderdetails;

public interface GoodsorderdetailsService {
	
	List<Goodsorderdetails> getByOrderId(Long orderid);
}
