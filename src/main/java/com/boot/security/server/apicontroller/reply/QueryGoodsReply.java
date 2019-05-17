package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryGoodsReply extends BaseReply {
	private QueryGoodsReplyGoodss data;

	public QueryGoodsReplyGoodss getData() {
		return data;
	}

	public void setData(QueryGoodsReplyGoodss data) {
		this.data = data;
	}
	public static class QueryGoodsReplyGoodss{
		private int GoodsCount;
		private List<QueryGoodsReplyGoods> Goods;
		public int getGoodsCount() {
			return GoodsCount;
		}
		public void setGoodsCount(int goodsCount) {
			GoodsCount = goodsCount;
		}
		public List<QueryGoodsReplyGoods> getGoods() {
			return Goods;
		}
		public void setGoods(List<QueryGoodsReplyGoods> goods) {
			Goods = goods;
		}
		public static class QueryGoodsReplyGoods{
			private Long GoodsId;
			private String CinemaCode;
			private Long UserId;
			private String GoodsCode;
			private String GoodsName;
			private String GoodsType;
			private Double StandardPrice;
			private Double SettlePrice;
			private String GoodsPic;
			private int StockCount;
			private String GoodsDesc;
			private String UnitName;
			private int ShowSeqNo;
			private String IsDiscount;
			private String GoodsStatus;
			private String IsRecommand;
			private String IsPackage;
			public Long getGoodsId() {
				return GoodsId;
			}
			public void setGoodsId(Long goodsId) {
				GoodsId = goodsId;
			}
			public String getCinemaCode() {
				return CinemaCode;
			}
			public void setCinemaCode(String cinemaCode) {
				CinemaCode = cinemaCode;
			}
			public Long getUserId() {
				return UserId;
			}
			public void setUserId(Long userId) {
				UserId = userId;
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
			public String getGoodsType() {
				return GoodsType;
			}
			public void setGoodsType(String goodsType) {
				GoodsType = goodsType;
			}
			public Double getStandardPrice() {
				return StandardPrice;
			}
			public void setStandardPrice(Double standardPrice) {
				StandardPrice = standardPrice;
			}
			public Double getSettlePrice() {
				return SettlePrice;
			}
			public void setSettlePrice(Double settlePrice) {
				SettlePrice = settlePrice;
			}
			public String getGoodsPic() {
				return GoodsPic;
			}
			public void setGoodsPic(String goodsPic) {
				GoodsPic = goodsPic;
			}
			public int getStockCount() {
				return StockCount;
			}
			public void setStockCount(int stockCount) {
				StockCount = stockCount;
			}
			public String getGoodsDesc() {
				return GoodsDesc;
			}
			public void setGoodsDesc(String goodsDesc) {
				GoodsDesc = goodsDesc;
			}
			public String getUnitName() {
				return UnitName;
			}
			public void setUnitName(String unitName) {
				UnitName = unitName;
			}
			public int getShowSeqNo() {
				return ShowSeqNo;
			}
			public void setShowSeqNo(int showSeqNo) {
				ShowSeqNo = showSeqNo;
			}
			public String getIsDiscount() {
				return IsDiscount;
			}
			public void setIsDiscount(String isDiscount) {
				IsDiscount = isDiscount;
			}
			public String getGoodsStatus() {
				return GoodsStatus;
			}
			public void setGoodsStatus(String goodsStatus) {
				GoodsStatus = goodsStatus;
			}
			public String getIsRecommand() {
				return IsRecommand;
			}
			public void setIsRecommand(String isRecommand) {
				IsRecommand = isRecommand;
			}
			public String getIsPackage() {
				return IsPackage;
			}
			public void setIsPackage(String isPackage) {
				IsPackage = isPackage;
			}
		}
	}

}
