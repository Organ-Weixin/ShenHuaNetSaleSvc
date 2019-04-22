package com.boot.security.server.api.ctms.reply;

public class CTMSQueryCardReply extends CTMSBaseReply {

	private String cardNumber;
	private String gradeType;
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getGradeType() {
		return gradeType;
	}
	public void setGradeType(String gradeType) {
		this.gradeType = gradeType;
	}
	
}
