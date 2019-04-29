package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class Dy1905GoodsListResult {
	private ResBean GoodsListResult;

	public ResBean getGoodsListResult() {
		return GoodsListResult;
	}

	public void setGoodsListResult(ResBean goodsListResult) {
		GoodsListResult = goodsListResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String ResultMsg;
		private GoodsBean Goods;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public String getResultMsg() {
			return ResultMsg;
		}
		public void setResultMsg(String resultMsg) {
			ResultMsg = resultMsg;
		}
		public GoodsBean getGoods() {
			return Goods;
		}
		public void setGoods(GoodsBean goods) {
			Goods = goods;
		}
		public static class GoodsBean{
			private List<GoodBean> Good;

			public List<GoodBean> getGood() {
				return Good;
			}

			public void setGood(List<GoodBean> good) {
				Good = good;
			}
			public static class GoodBean{
				private String Name;
				private String Serial;
				private String Price;
				private String StockCount;
				private String Type;
				private String Detail;
				private String Image;
				public String getName() {
					return Name;
				}
				public void setName(String name) {
					Name = name;
				}
				public String getSerial() {
					return Serial;
				}
				public void setSerial(String serial) {
					Serial = serial;
				}
				public String getPrice() {
					return Price;
				}
				public void setPrice(String price) {
					Price = price;
				}
				public String getStockCount() {
					return StockCount;
				}
				public void setStockCount(String stockCount) {
					StockCount = stockCount;
				}
				public String getType() {
					return Type;
				}
				public void setType(String type) {
					Type = type;
				}
				public String getDetail() {
					return Detail;
				}
				public void setDetail(String detail) {
					Detail = detail;
				}
				public String getImage() {
					return Image;
				}
				public void setImage(String image) {
					Image = image;
				}
				
			}
		}
	}
}
