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
	private String AppCode;
	private String CinemaId;
	private String FeatureAppNo;
	private String SerialNum;
	private String Printpassword;
	private Double Balance;
	private String PayType;
	private String RecvMobilePhone;
	private String SendType;
	private String PayResult;
	private boolean IsCmtsPay;
	private boolean IsCmtsSendCode;
	private String PayMobile;
	private String BookSign;
	private Double Payed;
	private String SendModeID;
	private String PaySeqNo;
	private String TokenID;
	private String VerifyInfo;
	@XmlElement(name = "AppCode")
	public String getAppCode() {
		return AppCode;
	}
	public void setAppCode(String appCode) {
		AppCode = appCode;
	}
	@XmlElement(name = "CinemaId")
	public String getCinemaId() {
		return CinemaId;
	}
	public void setCinemaId(String cinemaId) {
		CinemaId = cinemaId;
	}
	@XmlElement(name = "FeatureAppNo")
	public String getFeatureAppNo() {
		return FeatureAppNo;
	}
	public void setFeatureAppNo(String featureAppNo) {
		FeatureAppNo = featureAppNo;
	}
	@XmlElement(name = "SerialNum")
	public String getSerialNum() {
		return SerialNum;
	}
	public void setSerialNum(String serialNum) {
		SerialNum = serialNum;
	}
	@XmlElement(name = "Printpassword")
	public String getPrintpassword() {
		return Printpassword;
	}
	public void setPrintpassword(String printpassword) {
		Printpassword = printpassword;
	}
	@XmlElement(name = "Balance")
	public Double getBalance() {
		return Balance;
	}
	public void setBalance(Double balance) {
		Balance = balance;
	}
	@XmlElement(name = "PayType")
	public String getPayType() {
		return PayType;
	}

	public void setPayType(String payType) {
		PayType = payType;
	}
	@XmlElement(name = "RecvMobilePhone")
	public String getRecvMobilePhone() {
		return RecvMobilePhone;
	}
	public void setRecvMobilePhone(String recvMobilePhone) {
		RecvMobilePhone = recvMobilePhone;
	}
	@XmlElement(name = "SendType")
	public String getSendType() {
		return SendType;
	}
	public void setSendType(String sendType) {
		SendType = sendType;
	}
	@XmlElement(name = "PayResult")
	public String getPayResult() {
		return PayResult;
	}
	public void setPayResult(String payResult) {
		PayResult = payResult;
	}
	@XmlElement(name = "IsCmtsPay")
	public boolean isIsCmtsPay() {
		return IsCmtsPay;
	}
	public void setIsCmtsPay(boolean isCmtsPay) {
		IsCmtsPay = isCmtsPay;
	}
	@XmlElement(name = "IsCmtsSendCode")
	public boolean isIsCmtsSendCode() {
		return IsCmtsSendCode;
	}
	public void setIsCmtsSendCode(boolean isCmtsSendCode) {
		IsCmtsSendCode = isCmtsSendCode;
	}
	@XmlElement(name = "PayMobile")
	public String getPayMobile() {
		return PayMobile;
	}
	public void setPayMobile(String payMobile) {
		PayMobile = payMobile;
	}
	@XmlElement(name = "BookSign")
	public String getBookSign() {
		return BookSign;
	}
	public void setBookSign(String bookSign) {
		BookSign = bookSign;
	}
	@XmlElement(name = "Payed")
	public Double getPayed() {
		return Payed;
	}
	public void setPayed(Double payed) {
		Payed = payed;
	}
	@XmlElement(name = "SendModeID")
	public String getSendModeID() {
		return SendModeID;
	}
	public void setSendModeID(String sendModeID) {
		SendModeID = sendModeID;
	}
	@XmlElement(name = "PaySeqNo")
	public String getPaySeqNo() {
		return PaySeqNo;
	}
	public void setPaySeqNo(String paySeqNo) {
		PaySeqNo = paySeqNo;
	}
	@XmlElement(name = "TokenID")
	public String getTokenID() {
		return TokenID;
	}
	public void setTokenID(String tokenID) {
		TokenID = tokenID;
	}
	@XmlElement(name = "VerifyInfo")
	public String getVerifyInfo() {
		return VerifyInfo;
	}
	public void setVerifyInfo(String verifyInfo) {
		VerifyInfo = verifyInfo;
	}
	
	
}
