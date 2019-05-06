package com.boot.security.server.model;

public class Goodscomponents extends BaseEntity<Long> {
	private Long Id;
	private String PackageCode;// 套餐编码=卖品编码
	private String GoodsCode;// 套餐卖品编码
	private String GoodsName;// 套餐卖品名称
	private Integer GoodsCount;// 套餐卖品库存
	private String UnitName;// 套餐卖品单位名称

	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public String getPackageCode() {
		return PackageCode;
	}

	public void setPackageCode(String packageCode) {
		PackageCode = packageCode;
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

	public Integer getGoodsCount() {
		return GoodsCount;
	}

	public void setGoodsCount(Integer GoodsCount) {
		this.GoodsCount = GoodsCount;
	}

	public String getUnitName() {
		return UnitName;
	}

	public void setUnitName(String UnitName) {
		this.UnitName = UnitName;
	}

}
