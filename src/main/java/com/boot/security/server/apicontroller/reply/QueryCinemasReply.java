package com.boot.security.server.apicontroller.reply;

import java.util.List;

/**
 * 小程序-影院信息返回
 * @author sheng
 *
 */
public class QueryCinemasReply extends BaseReply {
	private QueryCinemasBean data;
	
	public QueryCinemasBean getData() {
		return data;
	}
	public void setData(QueryCinemasBean data) {
		this.data = data;
	}

	public static class QueryCinemasBean {
		private Integer CinemaCount;
		private List<CinemasReply> Cinemas;
		
		public Integer getCinemaCount() {
			return CinemaCount;
		}
		public void setCinemaCount(Integer cinemaCount) {
			CinemaCount = cinemaCount;
		}
		public List<CinemasReply> getCinemas() {
			return Cinemas;
		}
		public void setCinemas(List<CinemasReply> cinemas) {
			Cinemas = cinemas;
		}

		public static class CinemasReply {
			private Long CinemaId;
			private String CinemaCode;
			private String CinemaName;
			private String CinemaType;
			private String ContactName;
			private String ContactMobile;
			private String TheaterChain;
			private String Address;
			private String Status;
			private String OpenSnacks;	//是否开通套餐
			private String TicketHint;
			private String CinemaLabel;
			private String CinemaPhone;
			private String IsSnackDistribution;
			
			public Long getCinemaId() {
				return CinemaId;
			}
			public void setCinemaId(Long cinemaId) {
				CinemaId = cinemaId;
			}
			public String getCinemaCode() {
				return CinemaCode;
			}
			public void setCinemaCode(String cinemaCode) {
				CinemaCode = cinemaCode;
			}
			public String getCinemaName() {
				return CinemaName;
			}
			public void setCinemaName(String cinemaName) {
				CinemaName = cinemaName;
			}
			public String getCinemaType() {
				return CinemaType;
			}
			public void setCinemaType(String cinemaType) {
				CinemaType = cinemaType;
			}
			public String getContactName() {
				return ContactName;
			}
			public void setContactName(String contactName) {
				ContactName = contactName;
			}
			public String getContactMobile() {
				return ContactMobile;
			}
			public void setContactMobile(String contactMobile) {
				ContactMobile = contactMobile;
			}
			public String getTheaterChain() {
				return TheaterChain;
			}
			public void setTheaterChain(String theaterChain) {
				TheaterChain = theaterChain;
			}
			public String getAddress() {
				return Address;
			}
			public void setAddress(String address) {
				Address = address;
			}
			public String getStatus() {
				return Status;
			}
			public void setStatus(String status) {
				Status = status;
			}
			public String getOpenSnacks() {
				return OpenSnacks;
			}
			public void setOpenSnacks(String openSnacks) {
				OpenSnacks = openSnacks;
			}
			public String getTicketHint() {
				return TicketHint;
			}
			public void setTicketHint(String ticketHint) {
				TicketHint = ticketHint;
			}
			public String getCinemaLabel() {
				return CinemaLabel;
			}
			public void setCinemaLabel(String cinemaLabel) {
				CinemaLabel = cinemaLabel;
			}
			public String getCinemaPhone() {
				return CinemaPhone;
			}
			public void setCinemaPhone(String cinemaPhone) {
				CinemaPhone = cinemaPhone;
			}
			public String getIsSnackDistribution() {
				return IsSnackDistribution;
			}
			public void setIsSnackDistribution(String isSnackDistribution) {
				IsSnackDistribution = isSnackDistribution;
			}
			
		}
	}
	
}
