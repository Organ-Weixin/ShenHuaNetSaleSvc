package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryScreenSeatsArrangementReply extends BaseReply{
	private DataBean data = new DataBean();
	public DataBean getData() {
		return data;
	}
	public void setData(DataBean data) {
		this.data = data;
	}
	public static class DataBean{
		private List<RowBean> Rows;

		public List<RowBean> getRows() {
			return Rows;
		}

		public void setRows(List<RowBean> rows) {
			Rows = rows;
		}
		public static class RowBean{
			private String RowNum;
			private List<SeatBean> Seats;
			public String getRowNum() {
				return RowNum;
			}
			public void setRowNum(String rowNum) {
				RowNum = rowNum;
			}
			public List<SeatBean> getSeats() {
				return Seats;
			}
			public void setSeats(List<SeatBean> seats) {
				Seats = seats;
			}
			public static class SeatBean{
				private String SeatCode;
				private String GroupCode;
				private String RowNum;
				private String ColumnNum;
				private String Status;
				private String LoveFlag;
				private String Type;
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

}
