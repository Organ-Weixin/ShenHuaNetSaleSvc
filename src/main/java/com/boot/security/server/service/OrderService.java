package com.boot.security.server.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;

public interface OrderService {
	@Transactional(propagation = Propagation.REQUIRED)
	int Insert(OrderView orderview);
	@Transactional(propagation = Propagation.REQUIRED)
	OrderView getOrderWidthLockOrderCode(String cinemacode,String lockordercode);
	@Transactional(propagation = Propagation.REQUIRED)
	OrderView getOrderWidthOrderCode(String cinemacode,String ordercode);
	int UpdateOrderBaseInfo(Orders orderbase);
	@Transactional(propagation = Propagation.REQUIRED)
	int Update(OrderView orderview);
	@Transactional(propagation = Propagation.REQUIRED)
	OrderView getOrderWidthPrintNo(String cinemacode,String printno,String verifycode);

}
