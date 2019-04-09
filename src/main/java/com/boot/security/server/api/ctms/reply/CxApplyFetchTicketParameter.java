package com.boot.security.server.api.ctms.reply;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//设置生成的xml的根节点的名称
@XmlRootElement(name="ApplyFetchTicketParameter")
//设置根据字段还是方法生成
@XmlAccessorType(XmlAccessType.FIELD)
public class CxApplyFetchTicketParameter implements Serializable {
	//xml节点的名称
    @XmlElement(name="AppCode")
    private String AppCode;
    @XmlElement(name="CinemaCode")
    private String CinemaCode;
    @XmlElement(name="Tickets")
    private CxApplyFetchTicketXmlTickets Tickets;
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
	public CxApplyFetchTicketXmlTickets getTickets() {
		return Tickets;
	}
	public void setTickets(CxApplyFetchTicketXmlTickets tickets) {
		Tickets = tickets;
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
	public static class CxApplyFetchTicketXmlTickets{
		@XmlElement(name="Ticket")
		private List<CxApplyFetchTicketXmlTicket> Ticket;

		public List<CxApplyFetchTicketXmlTicket> getTicket() {
			return Ticket;
		}

		public void setTicket(List<CxApplyFetchTicketXmlTicket> ticket) {
			Ticket = ticket;
		}
		public static class CxApplyFetchTicketXmlTicket{
			@XmlElement(name="PrintNo")
			private String PrintNo;
			@XmlElement(name="VerifyCodeMD5")
			private String VerifyCodeMD5;
			public String getPrintNo() {
				return PrintNo;
			}
			public void setPrintNo(String printNo) {
				PrintNo = printNo;
			}
			public String getVerifyCodeMD5() {
				return VerifyCodeMD5;
			}
			public void setVerifyCodeMD5(String verifyCodeMD5) {
				VerifyCodeMD5 = verifyCodeMD5;
			}
			
		}
	}
    

}
