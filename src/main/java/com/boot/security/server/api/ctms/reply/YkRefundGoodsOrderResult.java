package com.boot.security.server.api.ctms.reply;

/**
 * 退卖品
 * @author sheng
 *
 */
public class YkRefundGoodsOrderResult {

	private String api;
	private String v;
	private String retCode;
	private String retMsg;
	private DataBean data;
	
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	public String getRetCode() {
		return retCode;
	}
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	public DataBean getData() {
		return data;
	}
	public void setData(DataBean data) {
		this.data = data;
	}

	public static class DataBean{
		private String bizCode;
		private String bizMsg;
		private GoodsOrderBean data;
		
		public String getBizCode() {
			return bizCode;
		}
		public void setBizCode(String bizCode) {
			this.bizCode = bizCode;
		}
		public String getBizMsg() {
			return bizMsg;
		}
		public void setBizMsg(String bizMsg) {
			this.bizMsg = bizMsg;
		}
		public GoodsOrderBean getData() {
			return data;
		}
		public void setData(GoodsOrderBean data) {
			this.data = data;
		}

		public static class GoodsOrderBean {
			private String cinemaLinkId;
			private String goodsOrderId;
			
			public String getCinemaLinkId() {
				return cinemaLinkId;
			}
			public void setCinemaLinkId(String cinemaLinkId) {
				this.cinemaLinkId = cinemaLinkId;
			}
			public String getGoodsOrderId() {
				return goodsOrderId;
			}
			public void setGoodsOrderId(String goodsOrderId) {
				this.goodsOrderId = goodsOrderId;
			}
			
		}
	}
}
