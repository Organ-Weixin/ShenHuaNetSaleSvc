package com.boot.security.server.api.ctms.reply;
/**
 * 注册会员卡
 * @author sheng
 *
 */
public class YkRegisterCardResult {

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
		private CardBean data;
		
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
		public CardBean getData() {
			return data;
		}
		public void setData(CardBean data) {
			this.data = data;
		}

		public static class CardBean {
			private String outTrandeNo;
			private String cardOrderId;
			private String cardNumber;
			private String balance;
			
			public String getOutTrandeNo() {
				return outTrandeNo;
			}
			public void setOutTrandeNo(String outTrandeNo) {
				this.outTrandeNo = outTrandeNo;
			}
			public String getCardOrderId() {
				return cardOrderId;
			}
			public void setCardOrderId(String cardOrderId) {
				this.cardOrderId = cardOrderId;
			}
			public String getCardNumber() {
				return cardNumber;
			}
			public void setCardNumber(String cardNumber) {
				this.cardNumber = cardNumber;
			}
			public String getBalance() {
				return balance;
			}
			public void setBalance(String balance) {
				this.balance = balance;
			}
			
		}
	}
}
