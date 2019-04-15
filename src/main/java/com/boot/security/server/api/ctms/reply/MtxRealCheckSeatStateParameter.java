package com.boot.security.server.api.ctms.reply;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.boot.security.server.utils.JaxbXmlUtil;


//设置生成的xml的根节点的名称
@XmlRootElement(name = "RealCheckSeatStateParameter")
// 设置根据字段还是方法生成
@XmlAccessorType(XmlAccessType.FIELD)
public class MtxRealCheckSeatStateParameter implements Serializable {
	@XmlElement(name = "AppCode")
	private String AppCode;
	@XmlElement(name = "CinemaId")
	private String CinemaId;
	@XmlElement(name = "FeatureAppNo")
	private String FeatureAppNo;
	@XmlElement(name = "SerialNum")
	private String SerialNum;

	@XmlElement(name = "PayType")
	private String PayType;
	@XmlElement(name = "RecvpMobilePhone")
	private String RecvMobilePhone;
	@XmlElement(name = "TokenID")
	private String TokenID;
	@XmlElement(name = "Token")
	private String Token;
	  @XmlElement(name = "VerifyInfo")
		private String VerifyInfo;
	@XmlElement(name = "SeatInfos")
	private List<MtxRealCheckSeatStateXmlSeatInfos> SeatInfos;

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public String getVerifyInfo() {
		return VerifyInfo;
	}

	public void setVerifyInfo(String verifyInfo) {
		VerifyInfo = verifyInfo;
	}

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

	public String getTokenID() {
		return TokenID;
	}

	public void setTokenID(String tokenID) {
		TokenID = tokenID;
	}




	public List<MtxRealCheckSeatStateXmlSeatInfos> getSeatInfos() {
		return SeatInfos;
	}

	public void setSeatInfos(List<MtxRealCheckSeatStateXmlSeatInfos> seatInfos) {
		SeatInfos = seatInfos;
	}


	public static class MtxRealCheckSeatStateXmlSeatInfos {
		@XmlElement(name = "SeatInfo")
		private MtxRealCheckSeatStateXmlSeatInfo SeatInfo;
		
		public MtxRealCheckSeatStateXmlSeatInfo getSeatInfo() {
			return SeatInfo;
		}

		public void setSeatInfo(MtxRealCheckSeatStateXmlSeatInfo seatInfo) {
			SeatInfo = seatInfo;
		}

		public static class MtxRealCheckSeatStateXmlSeatInfo {
		
			private String SeatNo;
			
			private Double TicketPrice;
			//手续费（此处手续费不生效，默认0）
		
			private Double Handlingfee;
			public String getSeatNo() {
				return SeatNo;
			}
			public void setSeatNo(String seatNo) {
				SeatNo = seatNo;
			}
			public Double getTicketPrice() {
				return TicketPrice;
			}
			public void setTicketPrice(Double ticketPrice) {
				TicketPrice = ticketPrice;
			}
			public Double getHandlingfee() {
				return Handlingfee;
			}
			public void setHandlingfee(Double handlingfee) {
				Handlingfee = handlingfee;
			}
		
		
			

		}
	}

}
