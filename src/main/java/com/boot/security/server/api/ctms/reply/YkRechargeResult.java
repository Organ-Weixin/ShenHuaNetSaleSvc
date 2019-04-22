package com.boot.security.server.api.ctms.reply;

/**
 * 会员卡充值
 * @author sheng
 *
 */
public class YkRechargeResult {

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

	public static class DataBean {
		private String bizCode;
		private String bizMsg;
		private RechargeBean data;
		
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
		public RechargeBean getData() {
			return data;
		}
		public void setData(RechargeBean data) {
			this.data = data;
		}
		
		public static class RechargeBean {
			private String outTradeNo;
			private String cardOrderId;
			private String balance;
			private String availableTimes;
			
			public String getOutTradeNo() {
				return outTradeNo;
			}
			public void setOutTradeNo(String outTradeNo) {
				this.outTradeNo = outTradeNo;
			}
			public String getCardOrderId() {
				return cardOrderId;
			}
			public void setCardOrderId(String cardOrderId) {
				this.cardOrderId = cardOrderId;
			}
			public String getBalance() {
				return balance;
			}
			public void setBalance(String balance) {
				this.balance = balance;
			}
			public String getAvailableTimes() {
				return availableTimes;
			}
			public void setAvailableTimes(String availableTimes) {
				this.availableTimes = availableTimes;
			}
			
		}
	}
}
