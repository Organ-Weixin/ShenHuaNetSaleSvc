package com.boot.security.server.api.ctms.reply;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//设置生成的xml的根节点的名称
@XmlRootElement(name="SubmitOrderParameter")
public class CxSubmitOrderParameter{
    private String AppCode;
    private String CinemaCode;
    private String OrderCode;
    private String FeatureAppNo;
    private String MobilePhone;
	private CxSubmitOrderXmlSeatInfos SeatInfos;
	private CxSubmitOrderXmlSaleMerInfos SaleMerInfos;
    private String Compress;
    private String VerifyInfo;
    
    @XmlElement(name="AppCode")
	public String getAppCode() {
		return AppCode;
	}
	public void setAppCode(String appCode) {
		AppCode = appCode;
	}
	@XmlElement(name="CinemaCode")
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	@XmlElement(name="OrderCode")
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	@XmlElement(name="FeatureAppNo")
	public String getFeatureAppNo() {
		return FeatureAppNo;
	}
	public void setFeatureAppNo(String featureAppNo) {
		FeatureAppNo = featureAppNo;
	}
	@XmlElement(name="MobilePhone")
	public String getMobilePhone() {
		return MobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		MobilePhone = mobilePhone;
	}
	@XmlElement(name="SeatInfos")
	public CxSubmitOrderXmlSeatInfos getSeatInfos() {
		return SeatInfos;
	}
	public void setSeatInfos(CxSubmitOrderXmlSeatInfos seatInfos) {
		SeatInfos = seatInfos;
	}
	@XmlElement(name="SaleMerInfos")
	public CxSubmitOrderXmlSaleMerInfos getSaleMerInfos() {
		return SaleMerInfos;
	}
	public void setSaleMerInfos(CxSubmitOrderXmlSaleMerInfos saleMerInfos) {
		SaleMerInfos = saleMerInfos;
	}
	@XmlElement(name="Compress")
	public String getCompress() {
		return Compress;
	}
	public void setCompress(String compress) {
		Compress = compress;
	}
	@XmlElement(name="VerifyInfo")
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
	public static class CxSubmitOrderXmlSaleMerInfos{
		@XmlElement(name="SaleMerInfo")
		private List<CxSubmitOrderXmlSaleMerInfo> SaleMerInfo;

		public List<CxSubmitOrderXmlSaleMerInfo> getSaleMerInfo() {
			return SaleMerInfo;
		}

		public void setSaleMerInfo(List<CxSubmitOrderXmlSaleMerInfo> saleMerInfo) {
			SaleMerInfo = saleMerInfo;
		}
		public static class CxSubmitOrderXmlSaleMerInfo{
			@XmlElement(name="MerCode")
			private String MerCode;
			@XmlElement(name="MerName")
			private String MerName;
			@XmlElement(name="MerPrice")
			private String MerPrice;
			@XmlElement(name="SaleAmount")
			private String SaleAmount;
			@XmlElement(name="MerExtend")
			private String MerExtend;
			@XmlElement(name="SeqNo")
			private String SeqNo;
			public String getMerCode() {
				return MerCode;
			}
			public void setMerCode(String merCode) {
				MerCode = merCode;
			}
			public String getMerName() {
				return MerName;
			}
			public void setMerName(String merName) {
				MerName = merName;
			}
			public String getMerPrice() {
				return MerPrice;
			}
			public void setMerPrice(String merPrice) {
				MerPrice = merPrice;
			}
			public String getSaleAmount() {
				return SaleAmount;
			}
			public void setSaleAmount(String saleAmount) {
				SaleAmount = saleAmount;
			}
			public String getMerExtend() {
				return MerExtend;
			}
			public void setMerExtend(String merExtend) {
				MerExtend = merExtend;
			}
			public String getSeqNo() {
				return SeqNo;
			}
			public void setSeqNo(String seqNo) {
				SeqNo = seqNo;
			}
			
		}
		
	}
    

}
