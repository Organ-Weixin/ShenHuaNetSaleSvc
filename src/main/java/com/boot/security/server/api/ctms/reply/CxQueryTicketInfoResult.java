package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class CxQueryTicketInfoResult {
	private ResBean QueryTicketInfoResult;

	public ResBean getQueryTicketInfoResult() {
		return QueryTicketInfoResult;
	}

	public void setQueryTicketInfoResult(ResBean queryTicketInfoResult) {
		QueryTicketInfoResult = queryTicketInfoResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String Message;
		private TicketsBean Tickets;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public String getMessage() {
			return Message;
		}
		public void setMessage(String message) {
			Message = message;
		}
		public TicketsBean getTickets() {
			return Tickets;
		}
		public void setTickets(TicketsBean tickets) {
			Tickets = tickets;
		}
		public static class TicketsBean{
			private List<TicketBean> Ticket;

			public List<TicketBean> getTicket() {
				return Ticket;
			}

			public void setTicket(List<TicketBean> ticket) {
				Ticket = ticket;
			}
			public static class TicketBean{
				private String PrintNo;
				private String TicketInfoCode;
				private String CinemaCode;
				private String CinemaName;
				private String ScreenCode;
				private String ScreenName;
				private String FilmCode;
				private String FilmName;
				private String FeatureAppNo;
				private String StartTime;
				private String TicketCode;
				private String SeatCode;
				private String SeatName;
				private Float Price;
				private Float Service;
				private int PrintFlag;
				public String getPrintNo() {
					return PrintNo;
				}
				public void setPrintNo(String printNo) {
					PrintNo = printNo;
				}
				public String getTicketInfoCode() {
					return TicketInfoCode;
				}
				public void setTicketInfoCode(String ticketInfoCode) {
					TicketInfoCode = ticketInfoCode;
				}
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
				public String getFeatureAppNo() {
					return FeatureAppNo;
				}
				public void setFeatureAppNo(String featureAppNo) {
					FeatureAppNo = featureAppNo;
				}
				public String getStartTime() {
					return StartTime;
				}
				public void setStartTime(String startTime) {
					StartTime = startTime;
				}
				public String getTicketCode() {
					return TicketCode;
				}
				public void setTicketCode(String ticketCode) {
					TicketCode = ticketCode;
				}
				public String getSeatCode() {
					return SeatCode;
				}
				public void setSeatCode(String seatCode) {
					SeatCode = seatCode;
				}
				public String getSeatName() {
					return SeatName;
				}
				public void setSeatName(String seatName) {
					SeatName = seatName;
				}
				public Float getPrice() {
					return Price;
				}
				public void setPrice(Float price) {
					Price = price;
				}
				public Float getService() {
					return Service;
				}
				public void setService(Float service) {
					Service = service;
				}
				public int getPrintFlag() {
					return PrintFlag;
				}
				public void setPrintFlag(int printFlag) {
					PrintFlag = printFlag;
				}
				
			}
		}
	}

}
