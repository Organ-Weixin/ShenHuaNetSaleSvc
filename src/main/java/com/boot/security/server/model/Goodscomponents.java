package com.boot.security.server.model;



public class Goodscomponents extends BaseEntity<Long> {

	private Long Id;
	private String GoodsCode;
	private String GoodsName;
	private Integer GoodsCount;
	private String UnitName;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
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
