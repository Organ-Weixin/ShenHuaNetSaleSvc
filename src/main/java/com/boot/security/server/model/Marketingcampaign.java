package com.boot.security.server.model;

import java.util.Date;

public class Marketingcampaign extends BaseEntity<Long> {

	private Long Id;
	private String ActivityName;
	private Integer ActivityType;
	private Integer TicketsType;
	private Integer AppointmentNumber;
	private String AppointTime;
	private Integer RestrictionType;
	private Integer RestrictionNumber;
	private String CinemaCodes;
	private Integer CinemaCodesType;
	private String ScreenCodes;
	private Integer ScreenCodesType;
	private Integer FilmCodesType;
	private String FilmCodes;
	private Double CouponPrice;
	private Double FixedAmount;
	private Date StartDate;
	private Date EndDate;
	private Integer SumNumber;
	private Integer RemainingNumber;
	private String StartTime;
	private String EndTime;
	private Integer IsSuperposition;
	private Integer IsUseCoupon;
	private Integer Status;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getActivityName() {
		return ActivityName;
	}
	public void setActivityName(String activityName) {
		ActivityName = activityName;
	}
	public Integer getActivityType() {
		return ActivityType;
	}
	public void setActivityType(Integer activityType) {
		ActivityType = activityType;
	}
	public Integer getTicketsType() {
		return TicketsType;
	}
	public void setTicketsType(Integer ticketsType) {
		TicketsType = ticketsType;
	}
	public Integer getAppointmentNumber() {
		return AppointmentNumber;
	}
	public void setAppointmentNumber(Integer appointmentNumber) {
		AppointmentNumber = appointmentNumber;
	}
	public String getAppointTime() {
		return AppointTime;
	}
	public void setAppointTime(String appointTime) {
		AppointTime = appointTime;
	}
	public Integer getRestrictionType() {
		return RestrictionType;
	}
	public void setRestrictionType(Integer restrictionType) {
		RestrictionType = restrictionType;
	}
	public Integer getRestrictionNumber() {
		return RestrictionNumber;
	}
	public void setRestrictionNumber(Integer restrictionNumber) {
		RestrictionNumber = restrictionNumber;
	}
	public String getCinemaCodes() {
		return CinemaCodes;
	}
	public void setCinemaCodes(String cinemaCodes) {
		CinemaCodes = cinemaCodes;
	}
	public Integer getCinemaCodesType() {
		return CinemaCodesType;
	}
	public void setCinemaCodesType(Integer cinemaCodesType) {
		CinemaCodesType = cinemaCodesType;
	}
	public String getScreenCodes() {
		return ScreenCodes;
	}
	public void setScreenCodes(String screenCodes) {
		ScreenCodes = screenCodes;
	}
	public Integer getScreenCodesType() {
		return ScreenCodesType;
	}
	public void setScreenCodesType(Integer screenCodesType) {
		ScreenCodesType = screenCodesType;
	}
	public Integer getFilmCodesType() {
		return FilmCodesType;
	}
	public void setFilmCodesType(Integer filmCodesType) {
		FilmCodesType = filmCodesType;
	}
	public String getFilmCodes() {
		return FilmCodes;
	}
	public void setFilmCodes(String filmCodes) {
		FilmCodes = filmCodes;
	}
	public Double getCouponPrice() {
		return CouponPrice;
	}
	public void setCouponPrice(Double couponPrice) {
		CouponPrice = couponPrice;
	}
	public Double getFixedAmount() {
		return FixedAmount;
	}
	public void setFixedAmount(Double fixedAmount) {
		FixedAmount = fixedAmount;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public Integer getSumNumber() {
		return SumNumber;
	}
	public void setSumNumber(Integer sumNumber) {
		SumNumber = sumNumber;
	}
	public Integer getRemainingNumber() {
		return RemainingNumber;
	}
	public void setRemainingNumber(Integer remainingNumber) {
		RemainingNumber = remainingNumber;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public Integer getIsSuperposition() {
		return IsSuperposition;
	}
	public void setIsSuperposition(Integer isSuperposition) {
		IsSuperposition = isSuperposition;
	}
	public Integer getIsUseCoupon() {
		return IsUseCoupon;
	}
	public void setIsUseCoupon(Integer isUseCoupon) {
		IsUseCoupon = isUseCoupon;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}

}
