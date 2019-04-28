package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class Goodsorderdetails extends BaseEntity<Long> {

	private Long Id;
	private Integer OrderId;
	private String GoodsCode;
	private String GoodsName;
	private BigDecimal StandardPrice;
	private BigDecimal SettlePrice;
	private BigDecimal ChannelFee;
	private Integer GoodsCount;
	private BigDecimal SubTotalAmount;
	private Date Created;
	private Date Updated;
	private Integer IsPackage;
	private String GoodsDetail;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public Integer getOrderId() {
		return OrderId;
	}
	public void setOrderId(Integer OrderId) {
		this.OrderId = OrderId;
	}
	public String getGoodsCode() {
		return GoodsCode;
	}
	public void setGoodsCode(String GoodsCode) {
		this.GoodsCode = GoodsCode;
	}
	public String getGoodsName() {
		return GoodsName;
	}
	public void setGoodsName(String GoodsName) {
		this.GoodsName = GoodsName;
	}
	public BigDecimal getStandardPrice() {
		return StandardPrice;
	}
	public void setStandardPrice(BigDecimal StandardPrice) {
		this.StandardPrice = StandardPrice;
	}
	public BigDecimal getSettlePrice() {
		return SettlePrice;
	}
	public void setSettlePrice(BigDecimal SettlePrice) {
		this.SettlePrice = SettlePrice;
	}
	public BigDecimal getChannelFee() {
		return ChannelFee;
	}
	public void setChannelFee(BigDecimal ChannelFee) {
		this.ChannelFee = ChannelFee;
	}
	public Integer getGoodsCount() {
		return GoodsCount;
	}
	public void setGoodsCount(Integer GoodsCount) {
		this.GoodsCount = GoodsCount;
	}
	public BigDecimal getSubTotalAmount() {
		return SubTotalAmount;
	}
	public void setSubTotalAmount(BigDecimal SubTotalAmount) {
		this.SubTotalAmount = SubTotalAmount;
	}
	public Date getCreated() {
		return Created;
	}
	public void setCreated(Date Created) {
		this.Created = Created;
	}
	public Date getUpdated() {
		return Updated;
	}
	public void setUpdated(Date Updated) {
		this.Updated = Updated;
	}
	public Integer getIsPackage() {
		return IsPackage;
	}
	public void setIsPackage(Integer IsPackage) {
		this.IsPackage = IsPackage;
	}
	public String getGoodsDetail() {
		return GoodsDetail;
	}
	public void setGoodsDetail(String GoodsDetail) {
		this.GoodsDetail = GoodsDetail;
	}

}
