package com.boot.security.server.api.ctms.reply;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//设置生成的xml的根节点的名称
@XmlRootElement(name="ApplyFetchTicketParameter")
public class CxApplyFetchTicketParameter {
    private String AppCode;
    private String CinemaCode;
    private CxApplyFetchTicketXmlTickets Tickets;
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
	@XmlElement(name="Tickets")
	public CxApplyFetchTicketXmlTickets getTickets() {
		return Tickets;
	}
	public void setTickets(CxApplyFetchTicketXmlTickets tickets) {
		Tickets = tickets;
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
	public static class CxApplyFetchTicketXmlTickets{
		
		private List<CxApplyFetchTicketXmlTicket> Ticket;

		@XmlElement(name="Ticket")
		public List<CxApplyFetchTicketXmlTicket> getTicket() {
			return Ticket;
		}

		public void setTicket(List<CxApplyFetchTicketXmlTicket> ticket) {
			Ticket = ticket;
		}
		public static class CxApplyFetchTicketXmlTicket{
			private String PrintNo;
			private String VerifyCodeMD5;
			@XmlElement(name="PrintNo")
			public String getPrintNo() {
				return PrintNo;
			}
			public void setPrintNo(String printNo) {
				PrintNo = printNo;
			}
			@XmlElement(name="VerifyCodeMD5")
			public String getVerifyCodeMD5() {
				return VerifyCodeMD5;
			}
			public void setVerifyCodeMD5(String verifyCodeMD5) {
				VerifyCodeMD5 = verifyCodeMD5;
			}
			
		}
	}
    

}
