package com.boot.security.server.api.ctms.reply;

import java.util.List;

/**
 * 查询会员卡充值记录
 * @author sheng
 *
 */
public class YkGetCardRechargeRecordsResult {

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
		private List<CardRechargeRecords> dataList;
		
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
		public List<CardRechargeRecords> getDataList() {
			return dataList;
		}
		public void setDataList(List<CardRechargeRecords> dataList) {
			this.dataList = dataList;
		}

		public static class CardRechargeRecords {
			private String rechargeBookingId;
			private String rechargeCinemaLinkId;
			private String rechargeAmount;
			private String afterBalance;
			private String beforeBalance;
			private String getPoints;
			private String rechargeDateTime;
			
			public String getRechargeBookingId() {
				return rechargeBookingId;
			}
			public void setRechargeBookingId(String rechargeBookingId) {
				this.rechargeBookingId = rechargeBookingId;
			}
			public String getRechargeCinemaLinkId() {
				return rechargeCinemaLinkId;
			}
			public void setRechargeCinemaLinkId(String rechargeCinemaLinkId) {
				this.rechargeCinemaLinkId = rechargeCinemaLinkId;
			}
			public String getRechargeAmount() {
				return rechargeAmount;
			}
			public void setRechargeAmount(String rechargeAmount) {
				this.rechargeAmount = rechargeAmount;
			}
			public String getAfterBalance() {
				return afterBalance;
			}
			public void setAfterBalance(String afterBalance) {
				this.afterBalance = afterBalance;
			}
			public String getBeforeBalance() {
				return beforeBalance;
			}
			public void setBeforeBalance(String beforeBalance) {
				this.beforeBalance = beforeBalance;
			}
			public String getGetPoints() {
				return getPoints;
			}
			public void setGetPoints(String getPoints) {
				this.getPoints = getPoints;
			}
			public String getRechargeDateTime() {
				return rechargeDateTime;
			}
			public void setRechargeDateTime(String rechargeDateTime) {
				this.rechargeDateTime = rechargeDateTime;
			}
			
		}
	}
}
