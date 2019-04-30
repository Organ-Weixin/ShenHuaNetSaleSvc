package com.boot.security.server.api.core;

public class CreateGoodsOrderReply extends BaseReply {
	public CreateGoodsOrderReply()
    {
        Id = ID_CreateGoodsOrderReply;
    }
	private CreateGoodsOrderReplyOrder Order;
	public CreateGoodsOrderReplyOrder getOrder() {
		return Order;
	}
	public void setOrder(CreateGoodsOrderReplyOrder order) {
		Order = order;
	}
	public static class CreateGoodsOrderReplyOrder{
		private String OrderCode;
		private String OrderStatus;
		private String OrderTime;
		public String getOrderCode() {
			return OrderCode;
		}
		public void setOrderCode(String orderCode) {
			OrderCode = orderCode;
		}
		public String getOrderStatus() {
			return OrderStatus;
		}
		public void setOrderStatus(String orderStatus) {
			OrderStatus = orderStatus;
		}
		public String getOrderTime() {
			return OrderTime;
		}
		public void setOrderTime(String orderTime) {
			OrderTime = orderTime;
		}
		
	}
	
	

}
