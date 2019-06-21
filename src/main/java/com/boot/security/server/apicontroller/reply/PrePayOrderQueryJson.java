package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class PrePayOrderQueryJson {
	private String UserName;
	private String Password;
	private String CinemaCode;
	private String OrderCode;
	private String CouponsCode;//卡券码
	private Double ReductionPrice;//减免金额
	private List<PrePayOrderQueryJsonSeat> Seats;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	public String getCouponsCode() {
		return CouponsCode;
	}
	public void setCouponsCode(String couponsCode) {
		CouponsCode = couponsCode;
	}
	public Double getReductionPrice() {
		return ReductionPrice;
	}
	public void setReductionPrice(Double reductionPrice) {
		ReductionPrice = reductionPrice;
	}
	public List<PrePayOrderQueryJsonSeat> getSeats() {
		return Seats;
	}
	public void setSeats(List<PrePayOrderQueryJsonSeat> seats) {
		Seats = seats;
	}
	public static class PrePayOrderQueryJsonSeat{
		private String SeatCode;
		public String getSeatCode() {
			return SeatCode;
		}
		public void setSeatCode(String seatCode) {
			SeatCode = seatCode;
		}
	}

}
