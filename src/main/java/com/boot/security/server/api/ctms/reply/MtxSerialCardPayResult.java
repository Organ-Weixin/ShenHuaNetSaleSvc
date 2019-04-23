package com.boot.security.server.api.ctms.reply;

public class MtxSerialCardPayResult {
	//serialCardPay会员卡支付（流水号必传）、预算接口
	private String resultCode;//返回码
	private String resultMsg;//返回描述
	private String groundTradeNo;//地面交易号
	private String tradeResultStatus;//交易结果状态
	private String deductMoney;//扣费金额
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
	public String getGroundTradeNo() {
		return groundTradeNo;
	}
	public void setGroundTradeNo(String groundTradeNo) {
		this.groundTradeNo = groundTradeNo;
	}
	public String getTradeResultStatus() {
		return tradeResultStatus;
	}
	public void setTradeResultStatus(String tradeResultStatus) {
		this.tradeResultStatus = tradeResultStatus;
	}
	public String getDeductMoney() {
		return deductMoney;
	}
	public void setDeductMoney(String deductMoney) {
		this.deductMoney = deductMoney;
	}
	
}
