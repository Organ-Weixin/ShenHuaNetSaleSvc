package com.boot.security.server.apicontroller.reply;

import java.util.List;


public class LockSeatReply extends BaseReply {
	private LockSeatReplydata data;

	public LockSeatReplydata getData() {
		return data;
	}

	public void setData(LockSeatReplydata data) {
		this.data = data;
	}
	public static class LockSeatReplydata{
		private LockSeatReplyOrder Order;
		private LockSeatReplyCoupon Coupon;
		public LockSeatReplyOrder getOrder() {
			return Order;
		}
		public void setOrder(LockSeatReplyOrder order) {
			Order = order;
		}
		public LockSeatReplyCoupon getCoupon() {
			return Coupon;
		}
		public void setCoupon(LockSeatReplyCoupon coupon) {
			Coupon = coupon;
		}
		public static class LockSeatReplyOrder{
			private String OrderCode;
			private String AutoUnlockDatetime;
			private String SessionCode;
			private int Count;
			private List<LockSeatReplySeat> Seat;
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
			public List<LockSeatReplySeat> getSeat() {
				return Seat;
			}
			public void setSeat(List<LockSeatReplySeat> seat) {
				Seat = seat;
			}
			public static class LockSeatReplySeat{
				private String SeatCode;

				public String getSeatCode() {
					return SeatCode;
				}

				public void setSeatCode(String seatCode) {
					SeatCode = seatCode;
				}
				
			}
		}
		public static class LockSeatReplyCoupon{
			private List<LockSeatReplyCoupons> Coupons;

			public List<LockSeatReplyCoupons> getCoupons() {
				return Coupons;
			}

			public void setCoupons(List<LockSeatReplyCoupons> coupons) {
				Coupons = coupons;
			}
			public static class LockSeatReplyCoupons{
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
