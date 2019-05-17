package com.boot.security.server.model;

import java.util.Date;

public class Banner {

	private Long Id;
	private String CinemaCode;
	private String Title;
	private String Image;
	private Date Created;
	private Date StartDate;
	private Date EndDate;
	private String LinkUrl;
	private int Status;

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
	public String getTitle() {
		return Title;
	}
	public void setTitle(String Title) {
		this.Title = Title;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String Image) {
		this.Image = Image;
	}
	public Date getCreated() {
		return Created;
	}
	public void setCreated(Date Created) {
		this.Created = Created;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date StartDate) {
		this.StartDate = StartDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date EndDate) {
		this.EndDate = EndDate;
	}
	public String getLinkUrl() {
		return LinkUrl;
	}
	public void setLinkUrl(String LinkUrl) {
		this.LinkUrl = LinkUrl;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int Status) {
		this.Status = Status;
	}

}
