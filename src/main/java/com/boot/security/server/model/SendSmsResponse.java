package com.boot.security.server.model;
/**
 * 接收飞鸽传书平台短信接口返回数据
 * @author sheng
 *
 */
public class SendSmsResponse {

	private int Code;
	private String Message;
	private String SendId;
	private int InvalidCount;
	private int SuccessCount;
	private int BlackCount;
	
	public int getCode() {
		return Code;
	}
	public void setCode(int code) {
		Code = code;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getSendId() {
		return SendId;
	}
	public void setSendId(String sendId) {
		SendId = sendId;
	}
	public int getInvalidCount() {
		return InvalidCount;
	}
	public void setInvalidCount(int invalidCount) {
		InvalidCount = invalidCount;
	}
	public int getSuccessCount() {
		return SuccessCount;
	}
	public void setSuccessCount(int successCount) {
		SuccessCount = successCount;
	}
	public int getBlackCount() {
		return BlackCount;
	}
	public void setBlackCount(int blackCount) {
		BlackCount = blackCount;
	}
	
}
