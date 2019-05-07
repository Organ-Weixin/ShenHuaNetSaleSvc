package com.boot.security.server.model;

import java.util.Date;

public class Goodsorderdetails extends BaseEntity<Long> {

	private Long Id;
	private Long OrderId;
	private String GoodsCode;
	private String GoodsName;
	private Double StandardPrice;
	private Double SettlePrice;
	private Double ChannelFee;
	private Integer GoodsCount;
	private Double SubTotalAmount;
	private Double SubTotalSettleAmount;
	private Date Created;
	private Date Updated;
	private Integer IsPackage;
	private String GoodsDetail;
	private Integer ShowSeqNo;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public Long getOrderId() {
		return OrderId;
	}
	public void setOrderId(Long OrderId) {
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
	public Double getStandardPrice() {
		return StandardPrice;
	}
	public void setStandardPrice(Double StandardPrice) {
		this.StandardPrice = StandardPrice;
	}
	public Double getSettlePrice() {
		return SettlePrice;
	}
	public void setSettlePrice(Double SettlePrice) {
		this.SettlePrice = SettlePrice;
	}
	public Double getChannelFee() {
		return ChannelFee;
	}
	public void setChannelFee(Double ChannelFee) {
		this.ChannelFee = ChannelFee;
	}
	public Integer getGoodsCount() {
		return GoodsCount;
	}
	public void setGoodsCount(Integer GoodsCount) {
		this.GoodsCount = GoodsCount;
	}
	public Double getSubTotalAmount() {
		return SubTotalAmount;
	}
	public void setSubTotalAmount(Double SubTotalAmount) {
		this.SubTotalAmount = SubTotalAmount;
	}
	
	public Double getSubTotalSettleAmount() {
		return SubTotalSettleAmount;
	}
	public void setSubTotalSettleAmount(Double subTotalSettleAmount) {
		SubTotalSettleAmount = subTotalSettleAmount;
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
	public Integer getShowSeqNo() {
		return ShowSeqNo;
	}
	public void setShowSeqNo(Integer showSeqNo) {
		ShowSeqNo = showSeqNo;
	}
	

}
