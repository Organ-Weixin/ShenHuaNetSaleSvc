package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryScreenSeatsReply extends BaseReply{
	private QueryScreenSeatsReplyScreenSeats data;

	public QueryScreenSeatsReplyScreenSeats getData() {
		return data;
	}

	public void setData(QueryScreenSeatsReplyScreenSeats data) {
		this.data = data;
	}
	public class QueryScreenSeatsReplyScreenSeats{
		private int SeatCount;
		private List<QueryScreenSeatsReplyScreenSeat> Seats;
		public int getSeatCount() {
			return SeatCount;
		}
		public void setSeatCount(int seatCount) {
			SeatCount = seatCount;
		}
		public List<QueryScreenSeatsReplyScreenSeat> getSeats() {
			return Seats;
		}
		public void setSeats(List<QueryScreenSeatsReplyScreenSeat> seats) {
			Seats = seats;
		}
		public class QueryScreenSeatsReplyScreenSeat{
			private Long SeatId;
			private String CinemaCode;
			private String ScreenCode;
			private String SeatCode;
			private String GroupCode;
			private String RowNum;
			private String ColumnNum;
			private int XCoord;
			private int YCoord;
			private String Status;
			private String LoveFlag;
			private String Type;
			public Long getSeatId() {
				return SeatId;
			}
			public void setSeatId(Long seatId) {
				SeatId = seatId;
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
			public String getSeatCode() {
				return SeatCode;
			}
			public void setSeatCode(String seatCode) {
				SeatCode = seatCode;
			}
			public String getGroupCode() {
				return GroupCode;
			}
			public void setGroupCode(String groupCode) {
				GroupCode = groupCode;
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
			public int getXCoord() {
				return XCoord;
			}
			public void setXCoord(int xCoord) {
				XCoord = xCoord;
			}
			public int getYCoord() {
				return YCoord;
			}
			public void setYCoord(int yCoord) {
				YCoord = yCoord;
			}
			public String getStatus() {
				return Status;
			}
			public void setStatus(String status) {
				Status = status;
			}
			public String getLoveFlag() {
				return LoveFlag;
			}
			public void setLoveFlag(String loveFlag) {
				LoveFlag = loveFlag;
			}
			public String getType() {
				return Type;
			}
			public void setType(String type) {
				Type = type;
			}
			
		}
	}
}
