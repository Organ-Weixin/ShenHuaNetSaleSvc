package com.boot.security.server.api.ctms.reply;
/**
 * 卖品会员卡支付撤销接口
 * @author sheng
 *
 */
public class MtxsPPayBack {

	private String resultcode;
	private String resultmsg;
	private String beforeintegral;
	private String beforemoney;
	private String nowintegral;
	private String nowmoney;
	private String price;
	private String traceno;
	private String traceprice;
	
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
	public String getBeforeintegral() {
		return beforeintegral;
	}
	public void setBeforeintegral(String beforeintegral) {
		this.beforeintegral = beforeintegral;
	}
	public String getBeforemoney() {
		return beforemoney;
	}
	public void setBeforemoney(String beforemoney) {
		this.beforemoney = beforemoney;
	}
	public String getNowintegral() {
		return nowintegral;
	}
	public void setNowintegral(String nowintegral) {
		this.nowintegral = nowintegral;
	}
	public String getNowmoney() {
		return nowmoney;
	}
	public void setNowmoney(String nowmoney) {
		this.nowmoney = nowmoney;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTraceno() {
		return traceno;
	}
	public void setTraceno(String traceno) {
		this.traceno = traceno;
	}
	public String getTraceprice() {
		return traceprice;
	}
	public void setTraceprice(String traceprice) {
		this.traceprice = traceprice;
	}
	
}
