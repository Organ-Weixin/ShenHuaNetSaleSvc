package com.boot.security.server.model;

import java.util.Date;

public class Activityview extends BaseEntity<Long> {

	private Long Id;
	private String CinemaCode;
	private String Title;
	private String Image;
	private String ActivityContent;
	private Date StartDate;
	private Date EndDate;
	private String LinkUrl;
	private String GradeCode;
	private Integer ActivitySequence;
	private Integer Status;
	private String LinkName;

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	public String getActivityContent() {
		return ActivityContent;
	}
	public void setActivityContent(String ActivityContent) {
		this.ActivityContent = ActivityContent;
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
	public String getGradeCode() {
		return GradeCode;
	}
	public void setGradeCode(String GradeCode) {
		this.GradeCode = GradeCode;
	}
	public Integer getActivitySequence() {
		return ActivitySequence;
	}
	public void setActivitySequence(Integer ActivitySequence) {
		this.ActivitySequence = ActivitySequence;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer Status) {
		this.Status = Status;
	}
	public String getLinkName() {
		return LinkName;
	}
	public void setLinkName(String LinkName) {
		this.LinkName = LinkName;
	}

}
