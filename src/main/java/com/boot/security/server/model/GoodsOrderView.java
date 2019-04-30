package com.boot.security.server.model;

import java.util.List;

public class GoodsOrderView {
	private Goodsorders orderBaseInfo;
	private List<Goodsorderdetails> orderGoodsDetails;
	public Goodsorders getOrderBaseInfo() {
		return orderBaseInfo;
	}
	public void setOrderBaseInfo(Goodsorders orderBaseInfo) {
		this.orderBaseInfo = orderBaseInfo;
	}
	public List<Goodsorderdetails> getOrderGoodsDetails() {
		return orderGoodsDetails;
	}
	public void setOrderGoodsDetails(List<Goodsorderdetails> orderGoodsDetails) {
		this.orderGoodsDetails = orderGoodsDetails;
	}
	

}
