package com.boot.security.server.api.core;

import java.util.List;


public class QueryOrderReply extends BaseReply {
	public QueryOrderReply()
    {
        Id = ID_QueryOrderReply;
    }
	private QueryOrderReplyOrder Order;
	public QueryOrderReplyOrder getOrder() {
		return Order;
	}
	public void setOrder(QueryOrderReplyOrder order) {
		Order = order;
	}
	public class QueryOrderReplyOrder{
		private String OrderCode;
		private String CinemaCode;
		private String CinemaType;
		private String CinemaName;
		private String ScreenCode;
		private String ScreenName;
		private String SessionCode;
		private String StartTime;
		private String PlaythroughFlag;
		private String PrintNo;
		private String VerifyCode;
		private QueryOrderReplyFilms Films;
		private QueryOrderReplySeats Seats;
		public String getOrderCode() {
			return OrderCode;
		}
		public void setOrderCode(String orderCode) {
			OrderCode = orderCode;
		}
		public String getCinemaCode() {
			return CinemaCode;
		}
		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		public String getCinemaType() {
			return CinemaType;
		}
		public void setCinemaType(String cinemaType) {
			CinemaType = cinemaType;
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
		public String getSessionCode() {
			return SessionCode;
		}
		public void setSessionCode(String sessionCode) {
			SessionCode = sessionCode;
		}
		public String getStartTime() {
			return StartTime;
		}
		public void setStartTime(String startTime) {
			StartTime = startTime;
		}
		public String getPlaythroughFlag() {
			return PlaythroughFlag;
		}
		public void setPlaythroughFlag(String playthroughFlag) {
			PlaythroughFlag = playthroughFlag;
		}
		public String getPrintNo() {
			return PrintNo;
		}
		public void setPrintNo(String printNo) {
			PrintNo = printNo;
		}
		public String getVerifyCode() {
			return VerifyCode;
		}
		public void setVerifyCode(String verifyCode) {
			VerifyCode = verifyCode;
		}
		public QueryOrderReplyFilms getFilms() {
			return Films;
		}
		public void setFilms(QueryOrderReplyFilms films) {
			Films = films;
		}
		public QueryOrderReplySeats getSeats() {
			return Seats;
		}
		public void setSeats(QueryOrderReplySeats seats) {
			Seats = seats;
		}
		public class QueryOrderReplyFilms{
			private List<QueryOrderReplyFilm> Film;

			public List<QueryOrderReplyFilm> getFilm() {
				return Film;
			}

			public void setFilm(List<QueryOrderReplyFilm> film) {
				Film = film;
			}
			public class QueryOrderReplyFilm{
				private String Code;
				private String Name;
				private String Duration;
				private String Sequence;
				public String getCode() {
					return Code;
				}
				public void setCode(String code) {
					Code = code;
				}
				public String getName() {
					return Name;
				}
				public void setName(String name) {
					Name = name;
				}
				public String getDuration() {
					return Duration;
				}
				public void setDuration(String duration) {
					Duration = duration;
				}
				public String getSequence() {
					return Sequence;
				}
				public void setSequence(String sequence) {
					Sequence = sequence;
				}
				
			}
			
		}
		public class QueryOrderReplySeats{
			private List<QueryOrderReplySeat> Seat;

			public List<QueryOrderReplySeat> getSeat() {
				return Seat;
			}

			public void setSeat(List<QueryOrderReplySeat> seat) {
				Seat = seat;
			}
			public class QueryOrderReplySeat{
				private String SeatCode;
				private String RowNum;
				private String ColumnNum;
		        private String FilmTicketCode;
		        private String PrintStatus;
		        private String PrintTime;
		        private String RefundStatus;
		        private String RefundTime;
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
				public String getFilmTicketCode() {
					return FilmTicketCode;
				}
				public void setFilmTicketCode(String filmTicketCode) {
					FilmTicketCode = filmTicketCode;
				}
				public String getPrintStatus() {
					return PrintStatus;
				}
				public void setPrintStatus(String printStatus) {
					PrintStatus = printStatus;
				}
				public String getPrintTime() {
					return PrintTime;
				}
				public void setPrintTime(String printTime) {
					PrintTime = printTime;
				}
				public String getRefundStatus() {
					return RefundStatus;
				}
				public void setRefundStatus(String refundStatus) {
					RefundStatus = refundStatus;
				}
				public String getRefundTime() {
					return RefundTime;
				}
				public void setRefundTime(String refundTime) {
					RefundTime = refundTime;
				}
		        
			}
			
		}
		
	}
	

}
