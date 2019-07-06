package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class CardChargeRecordReply extends BaseReply{
	private int ChargeCount;
	private List<ChargeRecord> data;
	
	public int getChargeCount() {
		return ChargeCount;
	}
	public void setChargeCount(int chargeCount) {
		ChargeCount = chargeCount;
	}
	public List<ChargeRecord> getData() {
		return data;
	}
	public void setData(List<ChargeRecord> data) {
		this.data = data;
	}

	public static class ChargeRecord {
		private String CardNo;
		private String RechargeAmount;
		private String ChargeStatus;
		private String ChargeTime;
		
		public String getCardNo() {
			return CardNo;
		}
		public void setCardNo(String cardNo) {
			CardNo = cardNo;
		}
		public String getRechargeAmount() {
			return RechargeAmount;
		}
		public void setRechargeAmount(String rechargeAmount) {
			RechargeAmount = rechargeAmount;
		}
		public String getChargeStatus() {
			return ChargeStatus;
		}
		public void setChargeStatus(String chargeStatus) {
			ChargeStatus = chargeStatus;
		}
		public String getChargeTime() {
			return ChargeTime;
		}
		public void setChargeTime(String chargeTime) {
			ChargeTime = chargeTime;
		}
		
	}
}
