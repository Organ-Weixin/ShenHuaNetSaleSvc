package com.boot.security.server.api.ctms.reply;
/**
 * 满天星卖品会员卡支付接口返回
 * @author sheng
 *
 */
public class MtxsPPayResult {

	private String resultcode;
	private String resultmsg;
	private String groundtradeno;
	private String traderesultstatus;
	private String deductmoney;
	
	public String getResultcode() {
		return resultcode;
	}
	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}
	public String getResultmsg() {
		return resultmsg;
	}
	public void setResultmsg(String resultmsg) {
		this.resultmsg = resultmsg;
	}
	public String getGroundtradeno() {
		return groundtradeno;
	}
	public void setGroundtradeno(String groundtradeno) {
		this.groundtradeno = groundtradeno;
	}
	public String getTraderesultstatus() {
		return traderesultstatus;
	}
	public void setTraderesultstatus(String traderesultstatus) {
		this.traderesultstatus = traderesultstatus;
	}
	public String getDeductmoney() {
		return deductmoney;
	}
	public void setDeductmoney(String deductmoney) {
		this.deductmoney = deductmoney;
	}
	
}
