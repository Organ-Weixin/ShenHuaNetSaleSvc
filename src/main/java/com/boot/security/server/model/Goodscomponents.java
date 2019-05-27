package com.boot.security.server.model;

public class Goodscomponents {

	private Long Id;
	private String CinemaCode;
	private String PackageCode;
	private String PackageName;
	private String PackagePic;
	private String GoodsCode;
	private String GoodsName;
	private Integer GoodsCount;
	private Double GoodsStandardPrice;
	private Double GoodsSettlePrice;
	private Double PackageStandardPrice;
	private Double PackageSettlePrice;
	private String RecommendCode;
	private Integer Status;
	private Integer Sort;
	private String UnitName;
		
	private String RecommendName;	//后台需要
	private String cinemaName;

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public String getPackageCode() {
		return PackageCode;
	}
	public void setPackageCode(String packageCode) {
		PackageCode = packageCode;
	}
	public String getPackageName() {
		return PackageName;
	}
	public void setPackageName(String packageName) {
		PackageName = packageName;
	}
	public String getPackagePic() {
		return PackagePic;
	}
	public void setPackagePic(String packagePic) {
		PackagePic = packagePic;
	}
	public String getGoodsCode() {
		return GoodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		GoodsCode = goodsCode;
	}
	public String getGoodsName() {
		return GoodsName;
	}
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	public Integer getGoodsCount() {
		return GoodsCount;
	}
	public void setGoodsCount(Integer goodsCount) {
		GoodsCount = goodsCount;
	}
	public Double getGoodsStandardPrice() {
		return GoodsStandardPrice;
	}
	public void setGoodsStandardPrice(Double goodsStandardPrice) {
		GoodsStandardPrice = goodsStandardPrice;
	}
	public Double getGoodsSettlePrice() {
		return GoodsSettlePrice;
	}
	public void setGoodsSettlePrice(Double goodsSettlePrice) {
		GoodsSettlePrice = goodsSettlePrice;
	}
	public Double getPackageStandardPrice() {
		return PackageStandardPrice;
	}
	public void setPackageStandardPrice(Double packageStandardPrice) {
		PackageStandardPrice = packageStandardPrice;
	}
	public Double getPackageSettlePrice() {
		return PackageSettlePrice;
	}
	public void setPackageSettlePrice(Double packageSettlePrice) {
		PackageSettlePrice = packageSettlePrice;
	}
	public String getRecommendCode() {
		return RecommendCode;
	}
	public void setRecommendCode(String recommendCode) {
		RecommendCode = recommendCode;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	public Integer getSort() {
		return Sort;
	}
	public void setSort(Integer sort) {
		Sort = sort;
	}
	public String getUnitName() {
		return UnitName;
	}
	public void setUnitName(String unitName) {
		UnitName = unitName;
	}
	public String getRecommendName() {
		return RecommendName;
	}
	public void setRecommendName(String recommendName) {
		RecommendName = recommendName;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	
}
