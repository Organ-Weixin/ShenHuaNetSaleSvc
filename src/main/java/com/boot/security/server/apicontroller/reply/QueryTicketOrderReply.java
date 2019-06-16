package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryTicketOrderReply extends BaseReply{
	private QueryTicketOrderReplyOrder data;

	public QueryTicketOrderReplyOrder getData() {
		return data;
	}

	public void setData(QueryTicketOrderReplyOrder data) {
		this.data = data;
	}
	public static class QueryTicketOrderReplyOrder{
		private String CinemaCode;
		private String CinemaName;
		private String CinemaAddress;
		private String CinemaPhone;
		private String FilmCode;
		private String FilmName;
		private String FilmType;
		private String FilmImage;
		private String ShowTime;
		private String ScreenCode;
		private String ScreenName;
		private Integer Count;
		private String PrintNo;
		private Integer PrintType;
		private String VerifyCode;
		private Double RealAmount;
		private String OrderCode;
		private String PayTime;
		private Integer OrderPayType;
		private String MobilePhone;
		private List<String> Seat;
		public String getCinemaCode() {
			return CinemaCode;
		}
		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		public String getCinemaName() {
			return CinemaName;
		}
		public void setCinemaName(String cinemaName) {
			CinemaName = cinemaName;
		}
		public String getCinemaAddress() {
			return CinemaAddress;
		}
		public void setCinemaAddress(String cinemaAddress) {
			CinemaAddress = cinemaAddress;
		}
		public String getCinemaPhone() {
			return CinemaPhone;
		}
		public void setCinemaPhone(String cinemaPhone) {
			CinemaPhone = cinemaPhone;
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
		public String getFilmType() {
			return FilmType;
		}
		public void setFilmType(String filmType) {
			FilmType = filmType;
		}
		public String getFilmImage() {
			return FilmImage;
		}
		public void setFilmImage(String filmImage) {
			FilmImage = filmImage;
		}
		public String getShowTime() {
			return ShowTime;
		}
		public void setShowTime(String showTime) {
			ShowTime = showTime;
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
		public Integer getCount() {
			return Count;
		}
		public void setCount(Integer count) {
			Count = count;
		}
		public String getPrintNo() {
			return PrintNo;
		}
		public void setPrintNo(String printNo) {
			PrintNo = printNo;
		}
		public Integer getPrintType() {
			return PrintType;
		}
		public void setPrintType(Integer printType) {
			PrintType = printType;
		}
		public String getVerifyCode() {
			return VerifyCode;
		}
		public void setVerifyCode(String verifyCode) {
			VerifyCode = verifyCode;
		}
		public Double getRealAmount() {
			return RealAmount;
		}
		public void setRealAmount(Double realAmount) {
			RealAmount = realAmount;
		}
		public String getOrderCode() {
			return OrderCode;
		}
		public void setOrderCode(String orderCode) {
			OrderCode = orderCode;
		}
		public String getPayTime() {
			return PayTime;
		}
		public void setPayTime(String payTime) {
			PayTime = payTime;
		}
		public String getMobilePhone() {
			return MobilePhone;
		}
		public Integer getOrderPayType() {
			return OrderPayType;
		}
		public void setOrderPayType(Integer orderPayType) {
			OrderPayType = orderPayType;
		}
		public void setMobilePhone(String mobilePhone) {
			MobilePhone = mobilePhone;
		}
		public List<String> getSeat() {
			return Seat;
		}
		public void setSeat(List<String> seat) {
			Seat = seat;
		}
		
	}
}
