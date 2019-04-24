package com.boot.security.server.api.ctms.reply;
/**
 * 查询会员卡余额
 * @author sheng
 *
 */
public class YkqueryBalanceResult {

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
		private BalanceBean data;
		
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

		public BalanceBean getData() {
			return data;
		}

		public void setData(BalanceBean data) {
			this.data = data;
		}

		public static class BalanceBean {
			private String cardNumber;
			private String cinemaLinkId;
			private String balance;
			private String availableTimes;
			private String accumulationPoints;
			private String tradePoints;
			
			public String getCardNumber() {
				return cardNumber;
			}
			public void setCardNumber(String cardNumber) {
				this.cardNumber = cardNumber;
			}
			public String getCinemaLinkId() {
				return cinemaLinkId;
			}
			public void setCinemaLinkId(String cinemaLinkId) {
				this.cinemaLinkId = cinemaLinkId;
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
			public String getAccumulationPoints() {
				return accumulationPoints;
			}
			public void setAccumulationPoints(String accumulationPoints) {
				this.accumulationPoints = accumulationPoints;
			}
			public String getTradePoints() {
				return tradePoints;
			}
			public void setTradePoints(String tradePoints) {
				this.tradePoints = tradePoints;
			}
			
		}
	}
}
