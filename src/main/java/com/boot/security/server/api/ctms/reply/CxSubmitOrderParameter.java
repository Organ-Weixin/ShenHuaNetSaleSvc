package com.boot.security.server.api.ctms.reply;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


//设置生成的xml的根节点的名称
@XmlRootElement(name="SubmitOrderParameter")
//设置根据字段还是方法生成
@XmlAccessorType(XmlAccessType.FIELD)
public class CxSubmitOrderParameter implements Serializable {
	//xml节点的名称
    @XmlElement(name="AppCode")
    private String AppCode;
    @XmlElement(name="CinemaCode")
    private String CinemaCode;
    @XmlElement(name="OrderCode")
    private String OrderCode;
    @XmlElement(name="FeatureAppNo")
    private String FeatureAppNo;
    @XmlElement(name="MobilePhone")
    private String MobilePhone;
    @XmlElement(name="SeatInfos")
	private CxSubmitOrderXmlSeatInfos SeatInfos;
    @XmlElement(name="Compress")
    private String Compress;
    @XmlElement(name="VerifyInfo")
    private String VerifyInfo;
	public String getAppCode() {
		return AppCode;
	}
	public void setAppCode(String appCode) {
		AppCode = appCode;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	public String getFeatureAppNo() {
		return FeatureAppNo;
	}
	public void setFeatureAppNo(String featureAppNo) {
		FeatureAppNo = featureAppNo;
	}
	public String getMobilePhone() {
		return MobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		MobilePhone = mobilePhone;
	}
	public CxSubmitOrderXmlSeatInfos getSeatInfos() {
		return SeatInfos;
	}
	public void setSeatInfos(CxSubmitOrderXmlSeatInfos seatInfos) {
		SeatInfos = seatInfos;
	}
	public String getCompress() {
		return Compress;
	}
	public void setCompress(String compress) {
		Compress = compress;
	}
	public String getVerifyInfo() {
		return VerifyInfo;
	}
	public void setVerifyInfo(String verifyInfo) {
		VerifyInfo = verifyInfo;
	}
	public static class CxSubmitOrderXmlSeatInfos{
		@XmlElement(name="SeatInfo")
		private List<CxSubmitOrderXmlSeatInfo> SeatInfo;

		public List<CxSubmitOrderXmlSeatInfo> getSeatInfo() {
			return SeatInfo;
		}

		public void setSeatInfo(List<CxSubmitOrderXmlSeatInfo> seatInfo) {
			SeatInfo = seatInfo;
		}
		public static class CxSubmitOrderXmlSeatInfo{
			@XmlElement(name="SeatCode")
			private String SeatCode;
			@XmlElement(name="Price")
			private String Price;
			@XmlElement(name="ServiceCharge")
			private String ServiceCharge;
			@XmlElement(name="ServiceAddFee")
			private String ServiceAddFee;
			@XmlElement(name="CinemaAllowance")
			private String CinemaAllowance;
			@XmlElement(name="MarketingCode")
			private String MarketingCode;
			
			public String getSeatCode() {
				return SeatCode;
			}
			public void setSeatCode(String seatCode) {
				SeatCode = seatCode;
			}
			public String getPrice() {
				return Price;
			}
			public void setPrice(String price) {
				Price = price;
			}
			public String getServiceCharge() {
				return ServiceCharge;
			}
			public void setServiceCharge(String serviceCharge) {
				ServiceCharge = serviceCharge;
			}
			public String getServiceAddFee() {
				return ServiceAddFee;
			}
			public void setServiceAddFee(String serviceAddFee) {
				ServiceAddFee = serviceAddFee;
			}
			public String getCinemaAllowance() {
				return CinemaAllowance;
			}
			public void setCinemaAllowance(String cinemaAllowance) {
				CinemaAllowance = cinemaAllowance;
			}
			public String getMarketingCode() {
				return MarketingCode;
			}
			public void setMarketingCode(String marketingCode) {
				MarketingCode = marketingCode;
			}
			
		}
	}
    

}
