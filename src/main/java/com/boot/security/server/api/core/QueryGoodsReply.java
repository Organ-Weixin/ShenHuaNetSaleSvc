package com.boot.security.server.api.core;

import java.util.List;


public class QueryGoodsReply extends BaseReply {
	public QueryGoodsReply()
    {
        Id = ID_QueryGoodsReply;
    }
	private QueryGoodsReplyGoodss Goodss;
	public QueryGoodsReplyGoodss getGoodss() {
		return Goodss;
	}
	public void setGoodss(QueryGoodsReplyGoodss goodss) {
		Goodss = goodss;
	}
	public static class QueryGoodsReplyGoodss{
		private int Count;
		private List<QueryGoodsReplyGoods> Goods;
		public int getCount() {
			return Count;
		}
		public void setCount(int count) {
			Count = count;
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
			private Float StandardPrice;
			private Float SettlePrice;
			private String GoodsPic;
			private int StockCount;
			private String GoodsDesc;
			private String UnitName;
			private int ShowSeqNo;
			private int IsDiscount;
			private String GoodsKey;
			private String GoodsStatus;
			private int IsRecommand;
			private int IsPackage;
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
			public Float getStandardPrice() {
				return StandardPrice;
			}
			public void setStandardPrice(Float standardPrice) {
				StandardPrice = standardPrice;
			}
			public Float getSettlePrice() {
				return SettlePrice;
			}
			public void setSettlePrice(Float settlePrice) {
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
			public int getIsDiscount() {
				return IsDiscount;
			}
			public void setIsDiscount(int isDiscount) {
				IsDiscount = isDiscount;
			}
			public String getGoodsKey() {
				return GoodsKey;
			}
			public void setGoodsKey(String goodsKey) {
				GoodsKey = goodsKey;
			}
			public String getGoodsStatus() {
				return GoodsStatus;
			}
			public void setGoodsStatus(String goodsStatus) {
				GoodsStatus = goodsStatus;
			}
			public int getIsRecommand() {
				return IsRecommand;
			}
			public void setIsRecommand(int isRecommand) {
				IsRecommand = isRecommand;
			}
			public int getIsPackage() {
				return IsPackage;
			}
			public void setIsPackage(int isPackage) {
				IsPackage = isPackage;
			}
			
		}
	}

}
