package com.boot.security.server.api.ctms.reply;

import java.util.List;

import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Orderseatdetails;

public class CTMSQueryTicketReply extends CTMSBaseReply {
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