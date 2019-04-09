package com.boot.security.server.model;

import java.util.List;

public class OrderView {
	private Orders orderBaseInfo;
	private List<Orderseatdetails> orderSeatDetails;
	public Orders getOrderBaseInfo() {
		return orderBaseInfo;
	}
	public void setOrderBaseInfo(Orders orderBaseInfo) {
		this.orderBaseInfo = orderBaseInfo;
	}
	public List<Orderseatdetails> getOrderSeatDetails() {
		return orderSeatDetails;
	}
	public void setOrderSeatDetails(List<Orderseatdetails> orderSeatDetails) {
		this.orderSeatDetails = orderSeatDetails;
	}
	

}
