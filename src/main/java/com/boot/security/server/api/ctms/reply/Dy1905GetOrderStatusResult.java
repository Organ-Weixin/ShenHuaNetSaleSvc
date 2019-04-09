package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class Dy1905GetOrderStatusResult {
	private ResBean GetOrderStatusResult;

	public ResBean getGetOrderStatusResult() {
		return GetOrderStatusResult;
	}

	public void setGetOrderStatusResult(ResBean getOrderStatusResult) {
		GetOrderStatusResult = getOrderStatusResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String OrderNo;
		private String PrintNo;
		private String PrintStatus;
		private String RefundStatus;
		private String VerifyCode;
		private String OrderStatus;
		private String OnlineSaleCode;
		private String CinemaCode;
		private String ScreenCode;
		private String SessionCode;
		private String FilmCode;
		private SeatsBean Seats;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public String getOrderNo() {
			return OrderNo;
		}
		public void setOrderNo(String orderNo) {
			OrderNo = orderNo;
		}
		public String getPrintNo() {
			return PrintNo;
		}
		public void setPrintNo(String printNo) {
			PrintNo = printNo;
		}
		public String getPrintStatus() {
			return PrintStatus;
		}
		public void setPrintStatus(String printStatus) {
			PrintStatus = printStatus;
		}
		public String getRefundStatus() {
			return RefundStatus;
		}
		public void setRefundStatus(String refundStatus) {
			RefundStatus = refundStatus;
		}
		public String getVerifyCode() {
			return VerifyCode;
		}
		public void setVerifyCode(String verifyCode) {
			VerifyCode = verifyCode;
		}
		public String getOrderStatus() {
			return OrderStatus;
		}
		public void setOrderStatus(String orderStatus) {
			OrderStatus = orderStatus;
		}
		public String getOnlineSaleCode() {
			return OnlineSaleCode;
		}
		public void setOnlineSaleCode(String onlineSaleCode) {
			OnlineSaleCode = onlineSaleCode;
		}
		public String getCinemaCode() {
			return CinemaCode;
		}
		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		public String getScreenCode() {
			return ScreenCode;
		}
		public void setScreenCode(String screenCode) {
			ScreenCode = screenCode;
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
		public SeatsBean getSeats() {
			return Seats;
		}
		public void setSeats(SeatsBean seats) {
			Seats = seats;
		}
		public static class SeatsBean{
			private List<SeatBean> Seat;

			public List<SeatBean> getSeat() {
				return Seat;
			}

			public void setSeat(List<SeatBean> seat) {
				Seat = seat;
			}
			public static class SeatBean{
				private String SeatNo;
				private String SeatCode;
				private String FilmTicketCode;
				private String CinemaFee;
				public String getSeatNo() {
					return SeatNo;
				}
				public void setSeatNo(String seatNo) {
					SeatNo = seatNo;
				}
				public String getSeatCode() {
					return SeatCode;
				}
				public void setSeatCode(String seatCode) {
					SeatCode = seatCode;
				}
				public String getFilmTicketCode() {
					return FilmTicketCode;
				}
				public void setFilmTicketCode(String filmTicketCode) {
					FilmTicketCode = filmTicketCode;
				}
				public String getCinemaFee() {
					return CinemaFee;
				}
				public void setCinemaFee(String cinemaFee) {
					CinemaFee = cinemaFee;
				}
				
			}
		}
	}
}
