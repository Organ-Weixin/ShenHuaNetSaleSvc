package com.boot.security.server.api.core;

import java.util.List;

public class QuerySessionSeatReply extends BaseReply {
	public QuerySessionSeatReply()
    {
        Id = ID_QuerySessionSeatReply;
    }
	private QuerySessionSeatReplySessionSeat SessionSeat;
	public QuerySessionSeatReplySessionSeat getSessionSeat() {
		return SessionSeat;
	}
	public void setSessionSeat(QuerySessionSeatReplySessionSeat sessionSeat) {
		SessionSeat = sessionSeat;
	}
	public class QuerySessionSeatReplySessionSeat{
		private String CinemaCode;
		private String SessionCode;
		private List<QuerySessionSeatReplySeat> Seat;
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
		public List<QuerySessionSeatReplySeat> getSeat() {
			return Seat;
		}
		public void setSeat(List<QuerySessionSeatReplySeat> seat) {
			Seat = seat;
		}
		public class QuerySessionSeatReplySeat{
			private String Code;
			private String RowNum;
			private String ColumnNum;
			private String Status;
			public String getCode() {
				return Code;
			}
			public void setCode(String code) {
				Code = code;
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
			public String getStatus() {
				return Status;
			}
			public void setStatus(String status) {
				Status = status;
			}
			
		}
	}

}
