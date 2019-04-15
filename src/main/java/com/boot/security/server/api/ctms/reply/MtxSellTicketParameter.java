package com.boot.security.server.api.ctms.reply;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//设置生成的xml的根节点的名称
@XmlRootElement(name = "MtxSellTicketParameter")
//设置根据字段还是方法生成
@XmlAccessorType(XmlAccessType.FIELD)
public class MtxSellTicketParameter implements Serializable{
	@XmlElement(name = "AppCode")
	private String AppCode;
	@XmlElement(name = "CinemaId")
	private String CinemaId;
	@XmlElement(name = "FeatureAppNo")
	private String FeatureAppNo;
	@XmlElement(name = "SerialNum")
	private String SerialNum;
	@XmlElement(name = "Printpassword")
	private String Printpassword;
	@XmlElement(name = "Balance")
	private int Balance;
	@XmlElement(name = "PayType")
	private String PayType;
	@XmlElement(name = "RecvMobilePhone")
	private String RecvMobilePhone;
	@XmlElement(name = "SendType")
	private String SendType;
	@XmlElement(name = "PayResult")
	private String PayResult;
	@XmlElement(name = "IsCmtsPay")
	private boolean IsCmtsPay;
	@XmlElement(name = "IsCmtsSendCode")
	private boolean IsCmtsSendCode;
	@XmlElement(name = "PayMobile")
	private String PayMobile;
	@XmlElement(name = "BookSign")
	private String BookSign;
	@XmlElement(name = "Payed")
	private Double Payed;
	@XmlElement(name = "SendModeID")
	private String SendModeID;
	@XmlElement(name = "PaySeqNo")
	private String PaySeqNo;
	@XmlElement(name = "TokenID")
	private String TokenID;
	@XmlElement(name = "VerifyInfo")
	private String VerifyInfo;
	public String getAppCode() {
		return AppCode;
	}
	public void setAppCode(String appCode) {
		AppCode = appCode;
	}
	public String getCinemaId() {
		return CinemaId;
	}
	public void setCinemaId(String cinemaId) {
		CinemaId = cinemaId;
	}
	public String getFeatureAppNo() {
		return FeatureAppNo;
	}
	public void setFeatureAppNo(String featureAppNo) {
		FeatureAppNo = featureAppNo;
	}
	public String getSerialNum() {
		return SerialNum;
	}
	public void setSerialNum(String serialNum) {
		SerialNum = serialNum;
	}
	public String getPrintpassword() {
		return Printpassword;
	}
	public void setPrintpassword(String printpassword) {
		Printpassword = printpassword;
	}

	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}
	public String getPayType() {
		return PayType;
	}
	public void setPayType(String payType) {
		PayType = payType;
	}
	public String getRecvMobilePhone() {
		return RecvMobilePhone;
	}
	public void setRecvMobilePhone(String recvMobilePhone) {
		RecvMobilePhone = recvMobilePhone;
	}
	public String getSendType() {
		return SendType;
	}
	public void setSendType(String sendType) {
		SendType = sendType;
	}
	public String getPayResult() {
		return PayResult;
	}
	public void setPayResult(String payResult) {
		PayResult = payResult;
	}
	
	public boolean isIsCmtsPay() {
		return IsCmtsPay;
	}
	public void setIsCmtsPay(boolean isCmtsPay) {
		IsCmtsPay = isCmtsPay;
	}
	public boolean isIsCmtsSendCode() {
		return IsCmtsSendCode;
	}
	public void setIsCmtsSendCode(boolean isCmtsSendCode) {
		IsCmtsSendCode = isCmtsSendCode;
	}
	public String getPayMobile() {
		return PayMobile;
	}
	public void setPayMobile(String payMobile) {
		PayMobile = payMobile;
	}
	public String getBookSign() {
		return BookSign;
	}
	public void setBookSign(String bookSign) {
		BookSign = bookSign;
	}

	public Double getPayed() {
		return Payed;
	}
	public void setPayed(Double payed) {
		Payed = payed;
	}
	public String getSendModeID() {
		return SendModeID;
	}
	public void setSendModeID(String sendModeID) {
		SendModeID = sendModeID;
	}
	public String getPaySeqNo() {
		return PaySeqNo;
	}
	public void setPaySeqNo(String paySeqNo) {
		PaySeqNo = paySeqNo;
	}
	public String getTokenID() {
		return TokenID;
	}
	public void setTokenID(String tokenID) {
		TokenID = tokenID;
	}
	public String getVerifyInfo() {
		return VerifyInfo;
	}
	public void setVerifyInfo(String verifyInfo) {
		VerifyInfo = verifyInfo;
	}
	
	
}
