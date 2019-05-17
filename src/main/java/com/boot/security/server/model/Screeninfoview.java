package com.boot.security.server.model;

import java.util.Date;

public class Screeninfoview extends BaseEntity<Long> {

	private Long Id;
	private String CCode;
	private String CinemaName;
	private String SCode;
	private String SName;
	private Date UpdateTime;
	private Integer SeatCount;
	private String Type;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCCode() {
		return CCode;
	}
	public void setCCode(String CCode) {
		this.CCode = CCode;
	}
	public String getCinemaName() {
		return CinemaName;
	}
	public void setCinemaName(String CinemaName) {
		this.CinemaName = CinemaName;
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

}
