package com.boot.security.server.model;

import java.util.Date;

public class Screenseatinfo extends BaseEntity<Long> {

	
	private Long Id;
	private String CinemaCode;
	private String ScreenCode;
	private String SeatCode;
	private String GroupCode;
	private String RowNum;
	private String ColumnNum;
	private Integer XCoord;
	private Integer YCoord;
	private String Status;
	private String LoveFlag;
	private String Type;
	private Date UpdateTime;
	private String SeatId;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String CinemaCode) {
		this.CinemaCode = CinemaCode;
	}
	public String getScreenCode() {
		return ScreenCode;
	}
	public void setScreenCode(String ScreenCode) {
		this.ScreenCode = ScreenCode;
	}
	public String getSeatCode() {
		return SeatCode;
	}
	public void setSeatCode(String SeatCode) {
		this.SeatCode = SeatCode;
	}
	public String getGroupCode() {
		return GroupCode;
	}
	public void setGroupCode(String GroupCode) {
		this.GroupCode = GroupCode;
	}
	public String getRowNum() {
		return RowNum;
	}
	public void setRowNum(String RowNum) {
		this.RowNum = RowNum;
	}
	public String getColumnNum() {
		return ColumnNum;
	}
	public void setColumnNum(String ColumnNum) {
		this.ColumnNum = ColumnNum;
	}
	public Integer getXCoord() {
		return XCoord;
	}
	public void setXCoord(Integer XCoord) {
		this.XCoord = XCoord;
	}
	public Integer getYCoord() {
		return YCoord;
	}
	public void setYCoord(Integer YCoord) {
		this.YCoord = YCoord;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String Status) {
		this.Status = Status;
	}
	public String getLoveFlag() {
		return LoveFlag;
	}
	public void setLoveFlag(String LoveFlag) {
		this.LoveFlag = LoveFlag;
	}
	public String getType() {
		return Type;
	}
	public void setType(String Type) {
		this.Type = Type;
	}
	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date UpdateTime) {
		this.UpdateTime = UpdateTime;
	}
	public String getSeatId() {
		return SeatId;
	}
	public void setSeatId(String SeatId) {
		this.SeatId = SeatId;
	}

}
