package com.boot.security.server.apicontroller.reply;

import java.util.List;


public class PrePayMixOrderQueryJson {
	private String UserName;
	private String Password;
	private String CinemaCode;
	private String OrderCode;//购票卖品用同一个订单号
	private String CouponsCode;//卡券码
	private Double ReductionPrice;//减免金额 
	private String CouponsCode2;//卡券码
	private Double ReductionPrice2;//减免金额
	private List<PrePayMixOrderQueryJsonSeat> Seats;
	private List<PrePayMixOrderQueryJsonGoods> GoodsList;
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
	
	public String getCouponsCode2() {
		return CouponsCode2;
	}
	public void setCouponsCode2(String couponsCode2) {
		CouponsCode2 = couponsCode2;
	}
	public Double getReductionPrice2() {
		return ReductionPrice2;
	}
	public void setReductionPrice2(Double reductionPrice2) {
		ReductionPrice2 = reductionPrice2;
	}
	public List<PrePayMixOrderQueryJsonSeat> getSeats() {
		return Seats;
	}
	public void setSeats(List<PrePayMixOrderQueryJsonSeat> seats) {
		Seats = seats;
	}
	public List<PrePayMixOrderQueryJsonGoods> getGoodsList() {
		return GoodsList;
	}
	public void setGoodsList(List<PrePayMixOrderQueryJsonGoods> goodsList) {
		GoodsList = goodsList;
	}
	public static class PrePayMixOrderQueryJsonSeat{
		private String SeatCode;
		public String getSeatCode() {
			return SeatCode;
		}
		public void setSeatCode(String seatCode) {
			SeatCode = seatCode;
		}
	}
	public static class PrePayMixOrderQueryJsonGoods{
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
