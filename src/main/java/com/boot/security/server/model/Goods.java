package com.boot.security.server.model;

import java.util.Date;

public class Goods {

	private Long Id;
	private String CinemaCode;
	private Long UserId;
	private String GoodsCode;
	private String GoodsName;
	private String GoodsType;
	private Double StandardPrice;
	private Double SettlePrice;
	private String GoodsPic;
	private Integer StockCount;
	private String GoodsDesc;
	private String UnitName;
	private Integer ShowSeqNo;
	private Integer IsDiscount;
	private String GoodsKey;
	private Integer GoodsStatus;
	private Integer IsRecommand;
	private Integer IsPackage;
	private Date Updated;
	
	private String CinemaName;	//后台需要
	private String TypeName;
	private String RecommendCode;

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
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long UserId) {
		this.UserId = UserId;
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
	public String getGoodsType() {
		return GoodsType;
	}
	public void setGoodsType(String GoodsType) {
		this.GoodsType = GoodsType;
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
	public String getGoodsPic() {
		return GoodsPic;
	}
	public void setGoodsPic(String GoodsPic) {
		this.GoodsPic = GoodsPic;
	}
	public Integer getStockCount() {
		return StockCount;
	}
	public void setStockCount(Integer StockCount) {
		this.StockCount = StockCount;
	}
	public String getGoodsDesc() {
		return GoodsDesc;
	}
	public void setGoodsDesc(String GoodsDesc) {
		this.GoodsDesc = GoodsDesc;
	}
	public String getUnitName() {
		return UnitName;
	}
	public void setUnitName(String UnitName) {
		this.UnitName = UnitName;
	}
	public Integer getShowSeqNo() {
		return ShowSeqNo;
	}
	public void setShowSeqNo(Integer ShowSeqNo) {
		this.ShowSeqNo = ShowSeqNo;
	}
	public Integer getIsDiscount() {
		return IsDiscount;
	}
	public void setIsDiscount(Integer IsDiscount) {
		this.IsDiscount = IsDiscount;
	}
	public String getGoodsKey() {
		return GoodsKey;
	}
	public void setGoodsKey(String GoodsKey) {
		this.GoodsKey = GoodsKey;
	}
	public Integer getGoodsStatus() {
		return GoodsStatus;
	}
	public void setGoodsStatus(Integer GoodsStatus) {
		this.GoodsStatus = GoodsStatus;
	}
	public Integer getIsRecommand() {
		return IsRecommand;
	}
	public void setIsRecommand(Integer IsRecommand) {
		this.IsRecommand = IsRecommand;
	}
	public Integer getIsPackage() {
		return IsPackage;
	}
	public void setIsPackage(Integer IsPackage) {
		this.IsPackage = IsPackage;
	}
	public String getCinemaName() {
		return CinemaName;
	}
	public void setCinemaName(String cinemaName) {
		CinemaName = cinemaName;
	}
	public Date getUpdated() {
		return Updated;
	}
	public void setUpdated(Date updated) {
		Updated = updated;
	}
	public String getTypeName() {
		return TypeName;
	}
	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
	public String getRecommendCode() {
		return RecommendCode;
	}
	public void setRecommendCode(String recommendCode) {
		RecommendCode = recommendCode;
	}
	
}
