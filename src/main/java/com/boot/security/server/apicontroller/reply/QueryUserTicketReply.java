package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryUserTicketReply extends BaseReply{
	private QueryUserTicketReplyUser data;

	public QueryUserTicketReplyUser getData() {
		return data;
	}

	public void setData(QueryUserTicketReplyUser data) {
		this.data = data;
	}
	
	public static class QueryUserTicketReplyUser{
		private Integer TicketCount;
		private List<QueryUserTicketReplyUserTicket> Ticket;
		
		public Integer getTicketCount() {
			return TicketCount;
		}
		public void setTicketCount(Integer ticketCount) {
			TicketCount = ticketCount;
		}
		public List<QueryUserTicketReplyUserTicket> getTicket() {
			return Ticket;
		}
		public void setTicket(List<QueryUserTicketReplyUserTicket> ticket) {
			Ticket = ticket;
		}
		public static class QueryUserTicketReplyUserTicket{
			private String CinemaName;
			private String OrderCode;
			private String FilmCode;
			private String FilmName;
			private String LookedTime;
			private Integer OrderStatus;
			private Integer PrintStatus;
			
			public String getCinemaName() {
				return CinemaName;
			}
			public void setCinemaName(String cinemaName) {
				CinemaName = cinemaName;
			}
			public String getOrderCode() {
				return OrderCode;
			}
			public void setOrderCode(String orderCode) {
				OrderCode = orderCode;
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
			public String getLookedTime() {
				return LookedTime;
			}
			public void setLookedTime(String lookedTime) {
				LookedTime = lookedTime;
			}
			public Integer getOrderStatus() {
				return OrderStatus;
			}
			public void setOrderStatus(Integer orderStatus) {
				OrderStatus = orderStatus;
			}
			public Integer getPrintStatus() {
				return PrintStatus;
			}
			public void setPrintStatus(Integer printStatus) {
				PrintStatus = printStatus;
			}
		}
		
	}
}
