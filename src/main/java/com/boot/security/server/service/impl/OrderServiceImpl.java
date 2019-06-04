package com.boot.security.server.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.OrdersDao;
import com.boot.security.server.dao.OrderseatdetailsDao;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{
	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private OrderseatdetailsDao orderseatdetailssDao;
	@Override
	public Orders getById(Long id) {
		// TODO Auto-generated method stub
		return ordersDao.getById(id);
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return ordersDao.delete(id);
	}

	@Override
	public int count(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return ordersDao.count(params);
	}

	@Override
	public List<Orders> list(Map<String, Object> params, Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return ordersDao.list(params, offset, limit);
	}

	@Override
	public List<Userinfo> queryCompany() {
		// TODO Auto-generated method stub
		return ordersDao.queryCompany();
	}

	@Override
	public List<Orders> queryOrders() {
		// TODO Auto-generated method stub
		return ordersDao.queryOrders();
	}

	@Override
	public Orders getByPrintNo(String cinemacode, String printno, String verifycode) {
		// TODO Auto-generated method stub
		return ordersDao.getByPrintNo(cinemacode, printno, verifycode);
	}
	
	@Override
	public Orders getByOrderCode(String cinemacode, String ordercode) {
		// TODO Auto-generated method stub
		return ordersDao.getByOrderCode(cinemacode, ordercode);
	}
	
	@Override
	public Orders getOrderBaseByLockOrderCode(String lockordercode) {
		// TODO Auto-generated method stub
		return ordersDao.getOrderBaseByLockOrderCode(lockordercode);
	}
	
	@Override
	public int Insert(OrderView orderview) {
		ordersDao.save(orderview.getOrderBaseInfo());
		Orders order = ordersDao.getByLockOrderCode(orderview.getOrderBaseInfo().getCinemaCode(), orderview.getOrderBaseInfo().getLockOrderCode());
		if(order != null){
			for(Orderseatdetails orderseat:orderview.getOrderSeatDetails()){
				orderseat.setOrderId(order.getId());	//将orders表成功插入的数据id作为orderseatdetails表的OrderId
				orderseatdetailssDao.save(orderseat);
			}
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
		return ordersDao.updateByLockOrderCode(orderbase);
	}

	@Override
	public int Update(OrderView orderview) {
		ordersDao.updateByLockOrderCode(orderview.getOrderBaseInfo());
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

	@Override
	public List<Orders> getOrdersByCreated(Long userid, String cinemaCode, Date startDate, Date endDate) {
		return ordersDao.getOrdersByCreated(userid, cinemaCode, startDate, endDate);
	}

	@Override
	public OrderView getOrderWidthId(Long id) {
		OrderView orderview=new OrderView();
		orderview.setOrderBaseInfo(ordersDao.getById(id));
		orderview.setOrderSeatDetails(orderseatdetailssDao.getByOrderId(orderview.getOrderBaseInfo().getId()));
		return orderview;
	}

	@Override
	public List<Orders> getNonPayOrders(Long userid, String cinemaCode, String openID) {
		return ordersDao.getNonPayOrders(userid, cinemaCode, openID);
	}

	@Override
	public List<Orders> getByOpenId(String openid, String time) {
		return ordersDao.getByOpenId(openid, time);
	}

	@Override
	public Orders getByLockOrderCode(String cinemacode, String lockordercode) {
		return ordersDao.getByLockOrderCode(cinemacode, lockordercode);
	}

	@Override
	public int update(Orders orders) {
		return ordersDao.update(orders);
	}

	@Override
	public Orders getByOrderTradeNo(String cinemacode, String ordertradeno) {
		return ordersDao.getByOrderTradeNo(cinemacode, ordertradeno);
	}

}
