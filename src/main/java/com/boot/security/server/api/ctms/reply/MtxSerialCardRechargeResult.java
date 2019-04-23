package com.boot.security.server.api.ctms.reply;

public class MtxSerialCardRechargeResult { //返回json
	//serialCardRecharge会员卡充值接口（流水号必传）

		private String resultCode;//返回码
		private String resultMsg;//返回描述
		private String balance;//账户余额
		private String score;//账户积分
		public String getResultCode() {
			return resultCode;
		}
		public void setResultCode(String resultCode) {
			this.resultCode = resultCode;
		}
		public String getResultMsg() {
			return resultMsg;
		}
		public void setResultMsg(String resultMsg) {
			this.resultMsg = resultMsg;
		}
		public String getBalance() {
			return balance;
		}
		public void setBalance(String balance) {
			this.balance = balance;
		}
		public String getScore() {
			return score;
		}
		public void setScore(String score) {
			this.score = score;
		}
		
	}

