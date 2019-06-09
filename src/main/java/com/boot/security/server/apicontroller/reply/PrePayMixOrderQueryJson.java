package com.boot.security.server.apicontroller.reply;

import java.util.List;


public class PrePayMixOrderQueryJson {
	private String UserName;
	private String Password;
	private String CinemaCode;
	private String OrderCode;//购票卖品用同一个订单号
	private String CouponsCode;//卡券码 卖品是订单使用优惠券
	private Double ReductionPrice;//减免金额  卖品是订单使用优惠券
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
		private String CouponsCode;//卡券码
		private Double ReductionPrice;//减免金额
		public String getSeatCode() {
			return SeatCode;
		}
		public void setSeatCode(String seatCode) {
			SeatCode = seatCode;
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