package com.boot.security.server.model;

import java.util.Date;

public class Screeninfo extends BaseEntity<Long> {

	private Long Id;
	private String CCode;
	private String SCode;
	private String SName;
	private Date UpdateTime;
	private Integer SeatCount;
	private String Type;
	private String ScreenId;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getCCode() {
		return CCode;
	}
	public void setCCode(String CCode) {
		this.CCode = CCode;
	}
	public String getSCode() {
		return SCode;
	}
	public void setSCode(String SCode) {
		this.SCode = SCode;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String SName) {
		this.SName = SName;
	}
	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date UpdateTime) {
		this.UpdateTime = UpdateTime;
	}
	public Integer getSeatCount() {
		return SeatCount;
	}
	public void setSeatCount(Integer SeatCount) {
		this.SeatCount = SeatCount;
	}
	public String getType() {
		return Type;
	}
	public void setType(String Type) {
		this.Type = Type;
	}
	public String getScreenId() {
		return ScreenId;
	}
	public void setScreenId(String ScreenId) {
		this.ScreenId = ScreenId;
	}

}
