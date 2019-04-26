package com.boot.security.server.api.core;

import java.util.List;

public class QuerySeatReply extends BaseReply{
	public QuerySeatReply()
    {
        Id = ID_QuerySeatReply;
    }
	private QuerySeatReplyCinema Cinema;
	public QuerySeatReplyCinema getCinema() {
		return Cinema;
	}
	public void setCinema(QuerySeatReplyCinema cinema) {
		Cinema = cinema;
	}
	public class QuerySeatReplyCinema{
		private String Code;
		private QuerySeatReplyScreen Screen;
		public String getCode() {
			return Code;
		}
		public void setCode(String code) {
			Code = code;
		}
		public QuerySeatReplyScreen getScreen() {
			return Screen;
		}
		public void setScreen(QuerySeatReplyScreen screen) {
			Screen = screen;
		}
		public class QuerySeatReplyScreen{
			private String Code;
			private List<QuerySeatReplySeat> Seat;
			public String getCode() {
				return Code;
			}
			public void setCode(String code) {
				Code = code;
			}
			public List<QuerySeatReplySeat> getSeat() {
				return Seat;
			}
			public void setSeat(List<QuerySeatReplySeat> seat) {
				Seat = seat;
			}
			public class QuerySeatReplySeat{
				private String Code;
				private String GroupCode;
				private String RowNum;
				private String ColumnNum;
				private int XCoord;
				private int YCoord;
				private String Status;
				private String LoveFlag;
				public String getCode() {
					return Code;
				}
				public void setCode(String code) {
					Code = code;
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
				
			}
			
		}
		
	}

}
