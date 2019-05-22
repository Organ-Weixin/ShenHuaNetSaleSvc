package com.boot.security.server.apicontroller.reply;

import java.util.Date;
import java.util.List;

public class QueryCinemaGoodsReply extends BaseReply{
	//查询用户购买的小食记录
	private QueryCinemaGoodsReplyGoods data;
	public QueryCinemaGoodsReplyGoods getData() {
		return data;
	}
	public void setData(QueryCinemaGoodsReplyGoods data) {
		this.data = data;
	}
	public  class QueryCinemaGoodsReplyGoods{
		private int Count;
		private List<QueryCinemaGoods> Good;
		public int getCount() {
			return Count;
		}
		public void setCount(int count) {
			Count = count;
		}
		public List<QueryCinemaGoods> getGood() {
			return Good;
		}
		public void setGood(List<QueryCinemaGoods> good) {
			Good = good;
		}

		public  class QueryCinemaGoods{
			private String GoodsName;//小食名称
			private String GoodsCount;//小食数量
			private String PickUpCode;//取货码
			private String CinemaName;//影院名称
			private String Address;//影院地址
			private String SubTotalSettleAmount;//实付金额
			private String OrderCode;//订单号
			private Date Created;//购买时间
			private String MobilePhone;//手机号码
			private String Status;//小食状态
			public String getGoodsName() {
				return GoodsName;
			}
			public void setGoodsName(String goodsName) {
				GoodsName = goodsName;
			}
			public String getGoodsCount() {
				return GoodsCount;
			}
			public void setGoodsCount(String goodsCount) {
				GoodsCount = goodsCount;
			}
			public String getPickUpCode() {
				return PickUpCode;
			}
			public void setPickUpCode(String pickUpCode) {
				PickUpCode = pickUpCode;
			}
			public String getCinemaName() {
				return CinemaName;
			}
			public void setCinemaName(String cinemaName) {
				CinemaName = cinemaName;
			}
			public String getAddress() {
				return Address;
			}
			public void setAddress(String address) {
				Address = address;
			}
			public String getSubTotalSettleAmount() {
				return SubTotalSettleAmount;
			}
			public void setSubTotalSettleAmount(String subTotalSettleAmount) {
				SubTotalSettleAmount = subTotalSettleAmount;
			}
			public String getOrderCode() {
				return OrderCode;
			}
			public void setOrderCode(String orderCode) {
				OrderCode = orderCode;
			}
			public Date getCreated() {
				return Created;
			}
			public void setCreated(Date created) {
				Created = created;
			}
			public String getMobilePhone() {
				return MobilePhone;
			}
			public void setMobilePhone(String mobilePhone) {
				MobilePhone = mobilePhone;
			}
			public String getStatus() {
				return Status;
			}
			public void setStatus(String status) {
				Status = status;
			}
			

		}
	}
}
