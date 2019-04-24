package com.boot.security.server.apicontroller.reply;

public class NetSaleQueryJson {
	private String UserName;
	private String Password;
	private String OpenID;
	private String QueryXml;
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
	public String getOpenID() {
		return OpenID;
	}
	public void setOpenID(String openID) {
		OpenID = openID;
	}
	public String getQueryXml() {
		return QueryXml;
	}
	public void setQueryXml(String queryXml) {
		QueryXml = queryXml;
	}
	

}
