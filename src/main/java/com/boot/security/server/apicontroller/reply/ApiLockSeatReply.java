package com.boot.security.server.apicontroller.reply;

import java.util.List;


public class ApiLockSeatReply extends BaseReply {
	private ApiLockSeatReplydata data;

	public ApiLockSeatReplydata getData() {
		return data;
	}

	public void setData(ApiLockSeatReplydata data) {
		this.data = data;
	}
	public static class ApiLockSeatReplydata{
		private ApiLockSeatReplyOrder Order;
		private ApiLockSeatReplyCoupon Coupon;
		public ApiLockSeatReplyOrder getOrder() {
			return Order;
		}
		public void setOrder(ApiLockSeatReplyOrder order) {
			Order = order;
		}
		public ApiLockSeatReplyCoupon getCoupon() {
			return Coupon;
		}
		public void setCoupon(ApiLockSeatReplyCoupon coupon) {
			Coupon = coupon;
		}
		public static class ApiLockSeatReplyOrder{
			private String OrderCode;
			private String AutoUnlockDatetime;
			private String SessionCode;
			private int Count;
			private List<ApiLockSeatReplySeat> Seat;
			public String getOrderCode() {
				return OrderCode;
			}
			public void setOrderCode(String orderCode) {
				OrderCode = orderCode;
			}
			public String getAutoUnlockDatetime() {
				return AutoUnlockDatetime;
			}
			public void setAutoUnlockDatetime(String autoUnlockDatetime) {
				AutoUnlockDatetime = autoUnlockDatetime;
			}
			public String getSessionCode() {
				return SessionCode;
			}
			public void setSessionCode(String sessionCode) {
				SessionCode = sessionCode;
			}
			public int getCount() {
				return Count;
			}
			public void setCount(int count) {
				Count = count;
			}
			public List<ApiLockSeatReplySeat> getSeat() {
				return Seat;
			}
			public void setSeat(List<ApiLockSeatReplySeat> seat) {
				Seat = seat;
			}
			public static class ApiLockSeatReplySeat{
				private String SeatCode;

				public String getSeatCode() {
					return SeatCode;
				}

				public void setSeatCode(String seatCode) {
					SeatCode = seatCode;
				}
				
			}
		}
		public static class ApiLockSeatReplyCoupon{
			private List<ApiLockSeatReplyCoupons> Coupons;

			public List<ApiLockSeatReplyCoupons> getCoupons() {
				return Coupons;
			}

			public void setCoupons(List<ApiLockSeatReplyCoupons> coupons) {
				Coupons = coupons;
			}
			public static class ApiLockSeatReplyCoupons{
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
