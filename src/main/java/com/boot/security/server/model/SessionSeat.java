package com.boot.security.server.model;

public class SessionSeat {
	private String SeatCode;
	private String RowNum;
	private String ColumnNum;
	private String Status;
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
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	

}
