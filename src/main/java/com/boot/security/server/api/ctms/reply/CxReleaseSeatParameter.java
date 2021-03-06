package com.boot.security.server.api.ctms.reply;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//设置生成的xml的根节点的名称
@XmlRootElement(name="ReleaseSeatParameter")
//设置根据字段还是方法生成
@XmlAccessorType(XmlAccessType.FIELD)
public class CxReleaseSeatParameter implements Serializable {
	//xml节点的名称
    @XmlElement(name="AppCode")
    private String AppCode;
    @XmlElement(name="CinemaCode")
	private String CinemaCode;
    @XmlElement(name="OrderCode")
    private String OrderCode;
    @XmlElement(name="FeatureAppNo")
	private String FeatureAppNo;
    @XmlElement(name="SeatInfos")
	private CxReleaseSeatXmlSeatInfos SeatInfos;
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
	public CxReleaseSeatXmlSeatInfos getSeatInfos() {
		return SeatInfos;
	}
	public void setSeatInfos(CxReleaseSeatXmlSeatInfos seatInfos) {
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
	public static class CxReleaseSeatXmlSeatInfos{
		@XmlElement(name="SeatCode")
		private List<String> SeatCode;

		public List<String> getSeatCode() {
			return SeatCode;
		}

		public void setSeatCode(List<String> seatCode) {
			SeatCode = seatCode;
		}
		
	}
    

}
