package com.boot.security.server.api.core;

import java.util.List;

public class QueryTicketReply extends BaseReply {
	public QueryTicketReply()
    {
        Id = ID_QueryTicketReply;
    }
	public QueryTicketReplyTickets Tickets;
	public QueryTicketReplyTickets getTickets() {
		return Tickets;
	}
	public void setTickets(QueryTicketReplyTickets tickets) {
		Tickets = tickets;
	}
	public class QueryTicketReplyTickets{
		public int Count;
		public List<QueryTicketReplyTicket> Ticket;
		public int getCount() {
			return Count;
		}
		public void setCount(int count) {
			Count = count;
		}
		public List<QueryTicketReplyTicket> getTicket() {
			return Ticket;
		}
		public void setTicket(List<QueryTicketReplyTicket> ticket) {
			Ticket = ticket;
		}
		public class QueryTicketReplyTicket{
			public String PrintNo;
			public String TicketInfoCode;
			public String CinemaCode;
			public String CinemaName;
			public String ScreenCode;
			public String ScreenName;
			public String FilmCode;
			public String FilmName;
			public String SessionCode;
			public String SessionDateTime;
			public String TicketCode;
			public String SeatCode;
			public String SeatName;
			public String Price;
			public String Service;
			public String PrintFlag;
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
			public String getSessionCode() {
				return SessionCode;
			}
			public void setSessionCode(String sessionCode) {
				SessionCode = sessionCode;
			}
			public String getSessionDateTime() {
				return SessionDateTime;
			}
			public void setSessionDateTime(String sessionDateTime) {
				SessionDateTime = sessionDateTime;
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
			public String getPrice() {
				return Price;
			}
			public void setPrice(String price) {
				Price = price;
			}
			public String getService() {
				return Service;
			}
			public void setService(String service) {
				Service = service;
			}
			public String getPrintFlag() {
				return PrintFlag;
			}
			public void setPrintFlag(String printFlag) {
				PrintFlag = printFlag;
			}
			
		}
	}

}
