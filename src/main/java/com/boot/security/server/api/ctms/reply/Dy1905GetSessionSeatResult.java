package com.boot.security.server.api.ctms.reply;

import java.util.List;

import com.boot.security.server.model.SessionSeatStatusEnum;

public class Dy1905GetSessionSeatResult {
	private ResBean GetSessionSeatResult;

	public ResBean getGetSessionSeatResult() {
		return GetSessionSeatResult;
	}

	public void setGetSessionSeatResult(ResBean getSessionSeatResult) {
		GetSessionSeatResult = getSessionSeatResult;
	}
	public static class ResBean{
		private String ResultCode;
		private SessionSeatsBean SessionSeats;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public SessionSeatsBean getSessionSeats() {
			return SessionSeats;
		}
		public void setSessionSeats(SessionSeatsBean sessionSeats) {
			SessionSeats = sessionSeats;
		}
		public static class SessionSeatsBean{
			private List<SessionSeatBean> SessionSeat;

			public List<SessionSeatBean> getSessionSeat() {
				return SessionSeat;
			}

			public void setSessionSeat(List<SessionSeatBean> sessionSeat) {
				SessionSeat = sessionSeat;
			}
			public static class SessionSeatBean{
				private String SeatNo;
				private String SeatRow;
				private String SeatCol;
				private String GraphRow;
				private String GraphCol;
				private String SeatpieceNo;
				private String BindNo;
				private String SeatTypeNo;
				private String SeatTypeDesc;
				private String SeatStatus;
				public String getSeatNo() {
					return SeatNo;
				}
				public void setSeatNo(String seatNo) {
					SeatNo = seatNo;
				}
				public String getSeatRow() {
					return SeatRow;
				}
				public void setSeatRow(String seatRow) {
					SeatRow = seatRow;
				}
				public String getSeatCol() {
					return SeatCol;
				}
				public void setSeatCol(String seatCol) {
					SeatCol = seatCol;
				}
				public String getGraphRow() {
					return GraphRow;
				}
				public void setGraphRow(String graphRow) {
					GraphRow = graphRow;
				}
				public String getGraphCol() {
					return GraphCol;
				}
				public void setGraphCol(String graphCol) {
					GraphCol = graphCol;
				}
				public String getSeatpieceNo() {
					return SeatpieceNo;
				}
				public void setSeatpieceNo(String seatpieceNo) {
					SeatpieceNo = seatpieceNo;
				}
				public String getBindNo() {
					return BindNo;
				}
				public void setBindNo(String bindNo) {
					BindNo = bindNo;
				}
				public String getSeatTypeNo() {
					return SeatTypeNo;
				}
				public void setSeatTypeNo(String seatTypeNo) {
					SeatTypeNo = seatTypeNo;
				}
				public String getSeatTypeDesc() {
					return SeatTypeDesc;
				}
				public void setSeatTypeDesc(String seatTypeDesc) {
					SeatTypeDesc = seatTypeDesc;
				}
				public String getSeatStatus() {
					return SeatStatus;
				}
				public void setSeatStatus(String seatStatus) {
					SeatStatus = seatStatus;
				}
				
			}
		}
	}
}
