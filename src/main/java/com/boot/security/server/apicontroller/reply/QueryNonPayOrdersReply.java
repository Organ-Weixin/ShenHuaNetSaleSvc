package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryNonPayOrdersReply extends BaseReply {
	private NonPayOrders data;

	public NonPayOrders getData() {
		return data;
	}

	public void setData(NonPayOrders data) {
		this.data = data;
	}

	public static class NonPayOrders {
		private Integer OrderCount;
		private List<NonPayOrder> Orders;

		public Integer getOrderCount() {
			return OrderCount;
		}

		public void setOrderCount(Integer orderCount) {
			OrderCount = orderCount;
		}

		public List<NonPayOrder> getOrders() {
			return Orders;
		}

		public void setOrders(List<NonPayOrder> orders) {
			Orders = orders;
		}

		public static class NonPayOrder {
			private Long OrderId;
			private String CinemaCode;
			private String SessionCode;
			private String ScreenCode;
			private String ScreenName;
			private String SessionTime;
			private String FilmCode;
			private String FilmName;
			private Integer TicketCount;
			private Double TotalPrice;
			private Double TotalFee;
			private Double TotalSalePrice;
			private String OrderStatus;
			private String MobilePhone;
			private String LockTime;
			private String AutoUnlockDatetime;
			private String LockOrderCode;
			public Long getOrderId() {
				return OrderId;
			}

			public void setOrderId(Long orderId) {
				OrderId = orderId;
			}

			public String getCinemaCode() {
				return CinemaCode;
			}

			public void setCinemaCode(String cinemaCode) {
				CinemaCode = cinemaCode;
			}

			public String getSessionCode() {
				return SessionCode;
			}

			public void setSessionCode(String sessionCode) {
				SessionCode = sessionCode;
			}

			public String getScreenCode() {
				return ScreenCode;
			}

			public void setScreenCode(String screenCode) {
				ScreenCode = screenCode;
			}

			public String getScreenName() {
				return ScreenName;
			}

			public void setScreenName(String screenName) {
				ScreenName = screenName;
			}

			public String getSessionTime() {
				return SessionTime;
			}

			public void setSessionTime(String sessionTime) {
				SessionTime = sessionTime;
			}

			public String getFilmCode() {
				return FilmCode;
			}

			public void setFilmCode(String filmCode) {
				FilmCode = filmCode;
			}

			public String getFilmName() {
				return FilmName;
			}

			public void setFilmName(String filmName) {
				FilmName = filmName;
			}

			public Integer getTicketCount() {
				return TicketCount;
			}

			public void setTicketCount(Integer ticketCount) {
				TicketCount = ticketCount;
			}

			public Double getTotalPrice() {
				return TotalPrice;
			}

			public void setTotalPrice(Double totalPrice) {
				TotalPrice = totalPrice;
			}

			public Double getTotalFee() {
				return TotalFee;
			}

			public void setTotalFee(Double totalFee) {
				TotalFee = totalFee;
			}

			public Double getTotalSalePrice() {
				return TotalSalePrice;
			}

			public void setTotalSalePrice(Double totalSalePrice) {
				TotalSalePrice = totalSalePrice;
			}

			public String getOrderStatus() {
				return OrderStatus;
			}

			public void setOrderStatus(String orderStatus) {
				OrderStatus = orderStatus;
			}

			public String getMobilePhone() {
				return MobilePhone;
			}

			public void setMobilePhone(String mobilePhone) {
				MobilePhone = mobilePhone;
			}

			public String getLockTime() {
				return LockTime;
			}

			public void setLockTime(String lockTime) {
				LockTime = lockTime;
			}

			public String getAutoUnlockDatetime() {
				return AutoUnlockDatetime;
			}

			public void setAutoUnlockDatetime(String autoUnlockDatetime) {
				AutoUnlockDatetime = autoUnlockDatetime;
			}

			public String getLockOrderCode() {
				return LockOrderCode;
			}

			public void setLockOrderCode(String lockOrderCode) {
				LockOrderCode = lockOrderCode;
			}
		}
	}

}
