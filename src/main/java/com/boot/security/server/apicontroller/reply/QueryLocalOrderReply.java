package com.boot.security.server.apicontroller.reply;

import java.util.List;
/**
 * 查询本地订单
 * @author sheng
 *
 */
public class QueryLocalOrderReply extends BaseReply {
	private QueryLocalOrder data;
	
	public QueryLocalOrder getData() {
		return data;
	}
	public void setData(QueryLocalOrder data) {
		this.data = data;
	}

	public static class QueryLocalOrder {
		private Long OrderId;
		private String CinemaCode;
		private String SessionCode;
		private String FilmCode;
		private Integer TicketCount;
		private Double TotalPrice;
		private Double TotalFee;
		private Double TotalSalePrice;
		private String MobilePhone;
		private String LockTime;
		private String AutoUnlockDatetime;
		private String LockOrderCode;
		private String Created;
		private Double TotalLoveSeatDifferences;	//情侣座总差价
		private String FeePayType;					//服务费支付类型
		private Double TotalGuestPayFee;
		private String OpenID;
		private List<Seats> Seats;
		
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
		public String getFilmCode() {
			return FilmCode;
		}
		public void setFilmCode(String filmCode) {
			FilmCode = filmCode;
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
		public String getCreated() {
			return Created;
		}
		public void setCreated(String created) {
			Created = created;
		}
		public Double getTotalLoveSeatDifferences() {
			return TotalLoveSeatDifferences;
		}
		public void setTotalLoveSeatDifferences(Double totalLoveSeatDifferences) {
			TotalLoveSeatDifferences = totalLoveSeatDifferences;
		}
		public String getFeePayType() {
			return FeePayType;
		}
		public void setFeePayType(String feePayType) {
			FeePayType = feePayType;
		}
		public Double getTotalGuestPayFee() {
			return TotalGuestPayFee;
		}
		public void setTotalGuestPayFee(Double totalGuestPayFee) {
			TotalGuestPayFee = totalGuestPayFee;
		}
		public String getOpenID() {
			return OpenID;
		}
		public void setOpenID(String openID) {
			OpenID = openID;
		}
		public List<Seats> getSeats() {
			return Seats;
		}
		public void setSeats(List<Seats> seats) {
			Seats = seats;
		}

		public static class Seats {
			private String SeatCode;
			private String RowNum;
			private String ColumnNum;
			private Double Price;
			private Double SalePrice;
			private Double Fee;
			private String ConponCode;	//优惠劵
			private Double ConponPrice; //优惠价
			
			public String getSeatCode() {
				return SeatCode;
			}
			public void setSeatCode(String seatCode) {
				SeatCode = seatCode;
			}
			public String getRowNum() {
				return RowNum;
			}
			public void setRowNum(String rowNum) {
				RowNum = rowNum;
			}
			public String getColumnNum() {
				return ColumnNum;
			}
			public void setColumnNum(String columnNum) {
				ColumnNum = columnNum;
			}
			public Double getPrice() {
				return Price;
			}
			public void setPrice(Double price) {
				Price = price;
			}
			public Double getSalePrice() {
				return SalePrice;
			}
			public void setSalePrice(Double salePrice) {
				SalePrice = salePrice;
			}
			public Double getFee() {
				return Fee;
			}
			public void setFee(Double fee) {
				Fee = fee;
			}
			public String getConponCode() {
				return ConponCode;
			}
			public void setConponCode(String conponCode) {
				ConponCode = conponCode;
			}
			public Double getConponPrice() {
				return ConponPrice;
			}
			public void setConponPrice(Double conponPrice) {
				ConponPrice = conponPrice;
			}
			
		}
		
	}

}
