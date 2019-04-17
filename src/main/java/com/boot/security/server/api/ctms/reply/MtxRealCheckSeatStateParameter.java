package com.boot.security.server.api.ctms.reply;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//设置生成的xml的根节点的名称
@XmlRootElement(name = "RealCheckSeatStateParameter")
@XmlType(propOrder = { "appCode", "cinemaId", "featureAppNo","serialNum","seatInfo","payType","recvMobilePhone","tokenID","verifyInfo"}) 
public class MtxRealCheckSeatStateParameter {
	
	private String AppCode;
	private String CinemaId;
	private String FeatureAppNo;
	private String SerialNum;
//	private MtxRealCheckSeatStateXmlSeatInfos SeatInfos;
	private List<MtxRealCheckSeatStateXmlSeatInfo> SeatInfo;
	private String PayType;
	private String RecvMobilePhone;
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

/*	@XmlElement(name = "SeatInfos")
	public MtxRealCheckSeatStateXmlSeatInfos getSeatInfos() {
		return SeatInfos;
	}
	public void setSeatInfos(MtxRealCheckSeatStateXmlSeatInfos seatInfos) {
		SeatInfos = seatInfos;
	}*/
	
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

//	public static class MtxRealCheckSeatStateXmlSeatInfos {
		
		
		
		@XmlElementWrapper(name="SeatInfos")
		@XmlElement(name = "SeatInfo")
		public List<MtxRealCheckSeatStateXmlSeatInfo> getSeatInfo() {
			return SeatInfo;
		}
		public void setSeatInfo(List<MtxRealCheckSeatStateXmlSeatInfo> seatInfo) {
			SeatInfo = seatInfo;
		}
//}
		@XmlType(propOrder = { "seatNo", "ticketPrice", "handlingfee"}) 
		public static class MtxRealCheckSeatStateXmlSeatInfo {
		
			private String SeatNo;
			
			private Double TicketPrice;
			//手续费（此处手续费不生效，默认0）
			private Double Handlingfee;
			
			@XmlElement(name = "SeatNo")
			public String getSeatNo() {
				return SeatNo;
			}
			public void setSeatNo(String seatNo) {
				SeatNo = seatNo;
			}
			
			@XmlElement(name = "TicketPrice")
			public Double getTicketPrice() {
				return TicketPrice;
			}
			public void setTicketPrice(Double ticketPrice) {
				TicketPrice = ticketPrice;
			}
			
			@XmlElement(name = "Handlingfee")
			public Double getHandlingfee() {
				return Handlingfee;
			}
			public void setHandlingfee(Double handlingfee) {
				Handlingfee = handlingfee;
			}
		
		}
	

}
