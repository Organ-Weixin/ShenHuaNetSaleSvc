package com.boot.security.server.api.ctms.reply;

public class MtxSerialCardPayBackResult {
	//serialCardPayBack会员卡冲费（撤销）接口（流水号必传）
	private String resultCode;//返回码
	private String resultMsg;//返回描述
	private String traceNoCenter;//地面交易号
	private String memberLevel;//会员卡级别编号
	private String memberType;//会员卡级别名称
	private String oldMoney;//交易前金额
	private String oldIntegral;//交易前积分
	private String cinemaName;//会员卡所在影院名称
	private String balance;//余额
	private String integral;//积分
	private String validDate;//有效期
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
	public String getTraceNoCenter() {
		return traceNoCenter;
	}
	public void setTraceNoCenter(String traceNoCenter) {
		this.traceNoCenter = traceNoCenter;
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getOldMoney() {
		return oldMoney;
	}
	public void setOldMoney(String oldMoney) {
		this.oldMoney = oldMoney;
	}
	public String getOldIntegral() {
		return oldIntegral;
	}
	public void setOldIntegral(String oldIntegral) {
		this.oldIntegral = oldIntegral;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getIntegral() {
		return integral;
	}
	public void setIntegral(String integral) {
		this.integral = integral;
	}
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	
}
