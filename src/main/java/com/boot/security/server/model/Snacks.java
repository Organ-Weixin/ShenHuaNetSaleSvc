package com.boot.security.server.model;

import java.util.Date;

public class Snacks extends BaseEntity<Long> {

	private Long Id;
	private String CinemaCode;
	private String SnackCode;
	private String TypeCode;
	private String SnackName;
	private String Remark;
	private Double StandardPrice;
	private Double SalePrice;
	private Integer Status;
	private Integer Stock;
	private Date ExpDate;
	private Integer IsDel;
	private Integer IsRecommand;
	private String Image;

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
	public String getSnackCode() {
		return SnackCode;
	}
	public void setSnackCode(String SnackCode) {
		this.SnackCode = SnackCode;
	}
	public String getTypeCode() {
		return TypeCode;
	}
	public void setTypeCode(String TypeCode) {
		this.TypeCode = TypeCode;
	}
	public String getSnackName() {
		return SnackName;
	}
	public void setSnackName(String SnackName) {
		this.SnackName = SnackName;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String Remark) {
		this.Remark = Remark;
	}
	public Double getStandardPrice() {
		return StandardPrice;
	}
	public void setStandardPrice(Double StandardPrice) {
		this.StandardPrice = StandardPrice;
	}
	public Double getSalePrice() {
		return SalePrice;
	}
	public void setSalePrice(Double SalePrice) {
		this.SalePrice = SalePrice;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer Status) {
		this.Status = Status;
	}
	public Integer getStock() {
		return Stock;
	}
	public void setStock(Integer Stock) {
		this.Stock = Stock;
	}
	public Date getExpDate() {
		return ExpDate;
	}
	public void setExpDate(Date ExpDate) {
		this.ExpDate = ExpDate;
	}
	public Integer getIsDel() {
		return IsDel;
	}
	public void setIsDel(Integer IsDel) {
		this.IsDel = IsDel;
	}
	public Integer getIsRecommand() {
		return IsRecommand;
	}
	public void setIsRecommand(Integer IsRecommand) {
		this.IsRecommand = IsRecommand;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String Image) {
		this.Image = Image;
	}

}
