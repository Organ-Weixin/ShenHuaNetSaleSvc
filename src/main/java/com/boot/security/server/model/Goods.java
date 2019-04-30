package com.boot.security.server.model;

public class Goods extends BaseEntity<Long> {

	private Long Id;
	private String CinemaCode;
	private Long UserId;
	private String GoodsCode;
	private String GoodsName;
	private Integer GoodsType;
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
	public Integer getGoodsType() {
		return GoodsType;
	}
	public void setGoodsType(Integer GoodsType) {
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

}
