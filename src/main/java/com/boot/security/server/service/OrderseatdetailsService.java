package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Orderseatdetails;

public interface OrderseatdetailsService {
	
	List<Orderseatdetails> getByOrderId(Long orderid);

	int update(Orderseatdetails orderseatdetails);
}
