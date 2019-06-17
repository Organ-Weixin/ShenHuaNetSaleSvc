package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class CreateGoodsOrderReply extends BaseReply{
	private CreateGoodsOrderReplydata data;

	public CreateGoodsOrderReplydata getData() {
		return data;
	}

	public void setData(CreateGoodsOrderReplydata data) {
		this.data = data;
	}
	public static class CreateGoodsOrderReplydata{
		private CreateGoodsOrderReplyOrder Order;
		private CreateGoodsOrderReplyCoupon Coupon;
		public CreateGoodsOrderReplyOrder getOrder() {
			return Order;
		}
		public void setOrder(CreateGoodsOrderReplyOrder order) {
			Order = order;
		}
		public CreateGoodsOrderReplyCoupon getCoupon() {
			return Coupon;
		}
		public void setCoupon(CreateGoodsOrderReplyCoupon coupon) {
			Coupon = coupon;
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
		public static class CreateGoodsOrderReplyCoupon{
			private List<CreateGoodsOrderReplyCoupons> Coupons;

			public List<CreateGoodsOrderReplyCoupons> getCoupons() {
				return Coupons;
			}

			public void setCoupons(List<CreateGoodsOrderReplyCoupons> coupons) {
				Coupons = coupons;
			}
			public static class CreateGoodsOrderReplyCoupons{
				private String CouponsCode;
				private int CouponsType;
				private String CouponsName;
				private Double ReductionPrice;
				public String getCouponsCode() {
					return CouponsCode;
				}
				public void setCouponsCode(String couponsCode) {
					CouponsCode = couponsCode;
				}
				public int getCouponsType() {
					return CouponsType;
				}
				public void setCouponsType(int couponsType) {
					CouponsType = couponsType;
				}
				public String getCouponsName() {
					return CouponsName;
				}
				public void setCouponsName(String couponsName) {
					CouponsName = couponsName;
				}
				public Double getReductionPrice() {
					return ReductionPrice;
				}
				public void setReductionPrice(Double reductionPrice) {
					ReductionPrice = reductionPrice;
				}
			}
		}
		
	}

}
