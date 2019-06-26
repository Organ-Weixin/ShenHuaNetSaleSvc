package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class Couponsgroup {

	private Long Id;
	private String GroupCode;
	private Integer CouponsType;
	private String CouponsName;
	private Date EffectiveDate;
	private Date ExpireDate;
	private Integer ReductionType;
	private Double ThresholdAmount;
	private Double ReductionPrice;
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
	private Date CreateDate;
	private Date UpdateDate;
	private Integer IsShareWithMemberCard;
	private String OperationRemark;

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
	public Integer getReductionType() {
		return ReductionType;
	}
	public void setReductionType(Integer ReductionType) {
		this.ReductionType = ReductionType;
	}
	public Double getThresholdAmount() {
		return ThresholdAmount;
	}
	public void setThresholdAmount(Double thresholdAmount) {
		ThresholdAmount = thresholdAmount;
	}
	public Double getReductionPrice() {
		return ReductionPrice;
	}
	public void setReductionPrice(Double ReductionPrice) {
		this.ReductionPrice = ReductionPrice;
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
	public Integer getIsShareWithMemberCard() {
		return IsShareWithMemberCard;
	}
	public void setIsShareWithMemberCard(Integer isShareWithMemberCard) {
		IsShareWithMemberCard = isShareWithMemberCard;
	}
	public String getOperationRemark() {
		return OperationRemark;
	}
	public void setOperationRemark(String operationRemark) {
		OperationRemark = operationRemark;
	}
	
	
}
