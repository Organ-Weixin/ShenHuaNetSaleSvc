package com.boot.security.server.apicontroller.reply;

public class CreateGoodsOrderQueryJson {
	private String UserName;
	private String Password;
	private String OpenID;
	private int DeliveryType;//送货类型
	private String DeliveryAddress;//送货地址
	private String DeliveryTime;//送货时间
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
	public int getDeliveryType() {
		return DeliveryType;
	}
	public void setDeliveryType(int deliveryType) {
		DeliveryType = deliveryType;
	}
	public String getDeliveryAddress() {
		return DeliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		DeliveryAddress = deliveryAddress;
	}
	public String getDeliveryTime() {
		return DeliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		DeliveryTime = deliveryTime;
	}
	public String getQueryXml() {
		return QueryXml;
	}
	public void setQueryXml(String queryXml) {
		QueryXml = queryXml;
	}
	
}
