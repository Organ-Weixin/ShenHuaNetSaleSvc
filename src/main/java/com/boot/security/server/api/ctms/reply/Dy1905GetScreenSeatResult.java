package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class Dy1905GetScreenSeatResult {
	private ResBean GetScreenSeatResult;

	public ResBean getGetScreenSeatResult() {
		return GetScreenSeatResult;
	}

	public void setGetScreenSeatResult(ResBean getScreenSeatResult) {
		GetScreenSeatResult = getScreenSeatResult;
	}
	
	public static class ResBean{
		private String ResultCode;
		private ScreenSeatsBean ScreenSeats;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public ScreenSeatsBean getScreenSeats() {
			return ScreenSeats;
		}
		public void setScreenSeats(ScreenSeatsBean screenSeats) {
			ScreenSeats = screenSeats;
		}
		
		public static class ScreenSeatsBean{
			private List<ScreenSeatBean> ScreenSeat;

			public List<ScreenSeatBean> getScreenSeat() {
				return ScreenSeat;
			}

			public void setScreenSeat(List<ScreenSeatBean> screenSeat) {
				ScreenSeat = screenSeat;
			}
			public static class ScreenSeatBean{
				private String SeatNo;
				private String SeatCode;
				private String SeatRow;
				private String SeatCol;
				private String GraphRow;
				private String GraphCol;
				private String SeatPieceNo;
				private String BindNo;
				private String SeatTypeNo;
				private String SeatTypeDesc;
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
				public String getSeatPieceNo() {
					return SeatPieceNo;
				}
				public void setSeatPieceNo(String seatPieceNo) {
					SeatPieceNo = seatPieceNo;
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
				
			}
		}
	}
}
