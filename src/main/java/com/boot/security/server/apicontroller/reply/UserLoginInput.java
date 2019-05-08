package com.boot.security.server.apicontroller.reply;

public class UserLoginInput {

	private String UserName;
	private String Password;
	private String CinemaCode;
	private String Code;			//js_code
	private String EncryptedData;	//密文
	private String Iv;					//偏移向量
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getEncryptedData() {
		return EncryptedData;
	}
	public void setEncryptedData(String encryptedData) {
		EncryptedData = encryptedData;
	}
	public String getIv() {
		return Iv;
	}
	public void setIv(String iv) {
		Iv = iv;
	}
	
}
