package com.boot.security.server.api.ctms.reply;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//设置生成的xml的根节点的名称
@XmlRootElement(name="CreateMerOrderParameter")
@XmlType(propOrder = {"appCode", "cinemaCode", "saleMerInfos","compress","verifyInfo"})
public class CxCreateMerOrderParameter {
	private String AppCode;
    private String CinemaCode;
    private CxCreateMerOrderXmlSaleMerInfos SaleMerInfos;
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
	
	@XmlElement(name="SaleMerInfos")
	public CxCreateMerOrderXmlSaleMerInfos getSaleMerInfos() {
		return SaleMerInfos;
	}
	public void setSaleMerInfos(CxCreateMerOrderXmlSaleMerInfos saleMerInfos) {
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
	public static class CxCreateMerOrderXmlSaleMerInfos{
		private List<CxCreateMerOrderXmlSaleMerInfo> SaleMerInfo;

		@XmlElement(name="SaleMerInfo")
		public List<CxCreateMerOrderXmlSaleMerInfo> getSaleMerInfo() {
			return SaleMerInfo;
		}

		public void setSaleMerInfo(List<CxCreateMerOrderXmlSaleMerInfo> saleMerInfo) {
			SaleMerInfo = saleMerInfo;
		}
		@XmlType(propOrder = {"merCode", "merName", "merPrice","saleAmount","merExtend","seqNo"})
		public static class CxCreateMerOrderXmlSaleMerInfo{
			private String MerCode;
			private String MerName;
			private String MerPrice;
			private int SaleAmount;
			private String MerExtend;
			private String SeqNo;
			
			@XmlElement(name="MerCode")
			public String getMerCode() {
				return MerCode;
			}
			public void setMerCode(String merCode) {
				MerCode = merCode;
			}
			@XmlElement(name="MerName")
			public String getMerName() {
				return MerName;
			}
			public void setMerName(String merName) {
				MerName = merName;
			}
			@XmlElement(name="MerPrice")
			public String getMerPrice() {
				return MerPrice;
			}
			public void setMerPrice(String merPrice) {
				MerPrice = merPrice;
			}
			@XmlElement(name="SaleAmount")
			public int getSaleAmount() {
				return SaleAmount;
			}
			public void setSaleAmount(int saleAmount) {
				SaleAmount = saleAmount;
			}
			@XmlElement(name="MerExtend")
			public String getMerExtend() {
				return MerExtend;
			}
			public void setMerExtend(String merExtend) {
				MerExtend = merExtend;
			}
			@XmlElement(name="SeqNo")
			public String getSeqNo() {
				return SeqNo;
			}
			public void setSeqNo(String seqNo) {
				SeqNo = seqNo;
			}
		}
		
	}
    

}
