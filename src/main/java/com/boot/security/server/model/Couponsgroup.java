package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class Couponsgroup {

	private Long Id;
	private String GroupCode;
	private Integer CouponsType;
	private String CouponsName;
	private Integer ValidityType;
	private Date EffectiveDate;
	private Date ExpireDate;
	private Integer EffectiveDays;
	private Integer ValidityDays;
	private Integer CanUsePeriodType;
	private String WeekDays;
	private String TimePeriod;
	private Integer LimitNum;
	private Integer ReductionType;
	private Double ReductionPrice;
	private String FilmCodes;
	private String GoodsCodes;
	private Integer IsShare;
	private String Remark;
	private Integer CanUseCinemaType;
	private String CinemaCodes;
	private Integer Status;
	private Integer CouponsNumber;
	private Integer IssuedNumber;
	private Integer FetchNumber;
	private Integer RemainingNumber;
	private Integer UsedNumber;
	private Integer SendGroupNumber;
	private Integer SendNumber;
	private String GiftType = "2";
	private Date CreateDate;
	private Date UpdateDate;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getGroupCode() {
		return GroupCode;
	}
	public void setGroupCode(String GroupCode) {
		this.GroupCode = GroupCode;
	}
	public Integer getCouponsType() {
		return CouponsType;
	}
	public void setCouponsType(Integer CouponsType) {
		this.CouponsType = CouponsType;
	}
	public String getCouponsName() {
		return CouponsName;
	}
	public void setCouponsName(String CouponsName) {
		this.CouponsName = CouponsName;
	}
	public Integer getValidityType() {
		return ValidityType;
	}
	public void setValidityType(Integer ValidityType) {
		this.ValidityType = ValidityType;
	}
	public Date getEffectiveDate() {
		return EffectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		EffectiveDate = effectiveDate;
	}
	public Date getExpireDate() {
		return ExpireDate;
	}
	public void setExpireDate(Date expireDate) {
		ExpireDate = expireDate;
	}
	public Integer getEffectiveDays() {
		return EffectiveDays;
	}
	public void setEffectiveDays(Integer EffectiveDays) {
		this.EffectiveDays = EffectiveDays;
	}
	public Integer getValidityDays() {
		return ValidityDays;
	}
	public void setValidityDays(Integer ValidityDays) {
		this.ValidityDays = ValidityDays;
	}
	public Integer getCanUsePeriodType() {
		return CanUsePeriodType;
	}
	public void setCanUsePeriodType(Integer CanUsePeriodType) {
		this.CanUsePeriodType = CanUsePeriodType;
	}
	public String getWeekDays() {
		return WeekDays;
	}
	public void setWeekDays(String WeekDays) {
		this.WeekDays = WeekDays;
	}
	public String getTimePeriod() {
		return TimePeriod;
	}
	public void setTimePeriod(String TimePeriod) {
		this.TimePeriod = TimePeriod;
	}
	public Integer getLimitNum() {
		return LimitNum;
	}
	public void setLimitNum(Integer LimitNum) {
		this.LimitNum = LimitNum;
	}
	public Integer getReductionType() {
		return ReductionType;
	}
	public void setReductionType(Integer ReductionType) {
		this.ReductionType = ReductionType;
	}
	public Double getReductionPrice() {
		return ReductionPrice;
	}
	public void setReductionPrice(Double ReductionPrice) {
		this.ReductionPrice = ReductionPrice;
	}
	public String getFilmCodes() {
		return FilmCodes;
	}
	public void setFilmCodes(String FilmCodes) {
		this.FilmCodes = FilmCodes;
	}
	public String getGoodsCodes() {
		return GoodsCodes;
	}
	public void setGoodsCodes(String GoodsCodes) {
		this.GoodsCodes = GoodsCodes;
	}
	public Integer getIsShare() {
		return IsShare;
	}
	public void setIsShare(Integer IsShare) {
		this.IsShare = IsShare;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String Remark) {
		this.Remark = Remark;
	}
	public Integer getCanUseCinemaType() {
		return CanUseCinemaType;
	}
	public void setCanUseCinemaType(Integer CanUseCinemaType) {
		this.CanUseCinemaType = CanUseCinemaType;
	}
	public String getCinemaCodes() {
		return CinemaCodes;
	}
	public void setCinemaCodes(String CinemaCodes) {
		this.CinemaCodes = CinemaCodes;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer Status) {
		this.Status = Status;
	}
	public Integer getCouponsNumber() {
		return CouponsNumber;
	}
	public void setCouponsNumber(Integer CouponsNumber) {
		this.CouponsNumber = CouponsNumber;
	}
	public Integer getIssuedNumber() {
		return IssuedNumber;
	}
	public void setIssuedNumber(Integer issuedNumber) {
		IssuedNumber = issuedNumber;
	}
	public Integer getFetchNumber() {
		return FetchNumber;
	}
	public void setFetchNumber(Integer FetchNumber) {
		this.FetchNumber = FetchNumber;
	}
	public Integer getRemainingNumber() {
		return RemainingNumber;
	}
	public void setRemainingNumber(Integer RemainingNumber) {
		this.RemainingNumber = RemainingNumber;
	}
	public Integer getUsedNumber() {
		return UsedNumber;
	}
	public void setUsedNumber(Integer UsedNumber) {
		this.UsedNumber = UsedNumber;
	}
	
	public Integer getSendGroupNumber() {
		return SendGroupNumber;
	}
	public void setSendGroupNumber(Integer sendGroupNumber) {
		SendGroupNumber = sendGroupNumber;
	}
	public Integer getSendNumber() {
		return SendNumber;
	}
	public void setSendNumber(Integer sendNumber) {
		SendNumber = sendNumber;
	}
	public String getGiftType() {
		return GiftType;
	}
	public void setGiftType(String giftType) {
		GiftType = giftType;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date CreateDate) {
		this.CreateDate = CreateDate;
	}
	public Date getUpdateDate() {
		return UpdateDate;
	}
	public void setUpdateDate(Date UpdateDate) {
		this.UpdateDate = UpdateDate;
	}

}
