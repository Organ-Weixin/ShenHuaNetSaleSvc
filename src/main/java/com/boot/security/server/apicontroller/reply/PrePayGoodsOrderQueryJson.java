package com.boot.security.server.apicontroller.reply;

import java.util.List;


public class PrePayGoodsOrderQueryJson {
	private String UserName;
	private String Password;
	private String CinemaCode;
	private String OrderCode;
	private String CouponsCode;//卡券码
	private Double ReductionPrice;//减免金额
	private List<PrePayGoodsOrderQueryJsonGoods> GoodsList;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	
	public String getCouponsCode() {
		return CouponsCode;
	}
	public void setCouponsCode(String couponsCode) {
		CouponsCode = couponsCode;
	}
	public Double getReductionPrice() {
		return ReductionPrice;
	}
	public void setReductionPrice(Double reductionPrice) {
		ReductionPrice = reductionPrice;
	}
	public List<PrePayGoodsOrderQueryJsonGoods> getGoodsList() {
		return GoodsList;
	}
	public void setGoodsList(List<PrePayGoodsOrderQueryJsonGoods> goodsList) {
		GoodsList = goodsList;
	}
	public static class PrePayGoodsOrderQueryJsonGoods{
		private String GoodsCode;
		private int GoodsCount;
		public String getGoodsCode() {
			return GoodsCode;
		}
		public void setGoodsCode(String goodsCode) {
			GoodsCode = goodsCode;
		}
		public int getGoodsCount() {
			return GoodsCount;
		}
		public void setGoodsCount(int goodsCount) {
			GoodsCount = goodsCount;
		}
		
	}
	

}
