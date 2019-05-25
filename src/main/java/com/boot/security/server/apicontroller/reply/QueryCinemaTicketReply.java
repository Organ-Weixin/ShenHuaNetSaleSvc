package com.boot.security.server.apicontroller.reply;

import java.util.Date;
import java.util.List;

public class QueryCinemaTicketReply extends BaseReply{
	//我的电影票
	private QueryCinemaTicket data;
	public QueryCinemaTicket getData() {
		return data;
	}
	public void setData(QueryCinemaTicket data) {
		this.data = data;
	}
	public  class QueryCinemaTicket{
		private int Count;
		private List<CinemaTicket>  Ticket;
		public int getCount() {
			return Count;
		}
		public void setCount(int count) {
			Count = count;
		}
		public List<CinemaTicket> getTicket() {
			return Ticket;
		}
		public void setTicket(List<CinemaTicket> ticket) {
			Ticket = ticket;
		}
		public   class CinemaTicket{
			private String FilmName;//影片名称//
			private Date SessionDateTime;//放映计划时间
			private String CinemaName;//影院名称
			private String TicketCount;//电影票数量
			private String Image;//电影海报
			private String Version;//影片版本（2D/3D）
			private String ScreenName;//影厅名称
			private String SeatName;//座位名称
			private String TicketInfoCode;//二维码
			private String PrintNo;//取票码
			private String Address;//影院地址
			private String CinemaPhone;//影院电话
			private String Price;//实付金额
			private String OrderCode;//订单号
			private Date Created;//购买时间
			private String MobilePhone;//手机号
			private String Status;//电影票状态
			public String getFilmName() {
				return FilmName;
			}
			public void setFilmName(String filmName) {
				FilmName = filmName;
			}
			public Date getSessionDateTime() {
				return SessionDateTime;
			}
			public void setSessionDateTime(Date sessionDateTime) {
				SessionDateTime = sessionDateTime;
			}
			public String getCinemaName() {
				return CinemaName;
			}
			public void setCinemaName(String cinemaName) {
				CinemaName = cinemaName;
			}
			public String getTicketCount() {
				return TicketCount;
			}
			public void setTicketCount(String ticketCount) {
				TicketCount = ticketCount;
			}
			public String getImage() {
				return Image;
			}
			public void setImage(String image) {
				Image = image;
			}
			public String getVersion() {
				return Version;
			}
			public void setVersion(String version) {
				Version = version;
			}
			public String getScreenName() {
				return ScreenName;
			}
			public void setScreenName(String screenName) {
				ScreenName = screenName;
			}
			public String getSeatName() {
				return SeatName;
			}
			public void setSeatName(String seatName) {
				SeatName = seatName;
			}
			public String getTicketInfoCode() {
				return TicketInfoCode;
			}
			public void setTicketInfoCode(String ticketInfoCode) {
				TicketInfoCode = ticketInfoCode;
			}
			public String getPrintNo() {
				return PrintNo;
			}
			public void setPrintNo(String printNo) {
				PrintNo = printNo;
			}
			public String getAddress() {
				return Address;
			}
			public void setAddress(String address) {
				Address = address;
			}
			public String getCinemaPhone() {
				return CinemaPhone;
			}
			public void setCinemaPhone(String cinemaPhone) {
				CinemaPhone = cinemaPhone;
			}
			public String getPrice() {
				return Price;
			}
			public void setPrice(String price) {
				Price = price;
			}
			public String getOrderCode() {
				return OrderCode;
			}
			public void setOrderCode(String orderCode) {
				OrderCode = orderCode;
			}
			public Date getCreated() {
				return Created;
			}
			public void setCreated(Date created) {
				Created = created;
			}
			public String getMobilePhone() {
				return MobilePhone;
			}
			public void setMobilePhone(String mobilePhone) {
				MobilePhone = mobilePhone;
			}
			public String getStatus() {
				return Status;
			}
			public void setStatus(String status) {
				Status = status;
			}
			
		}
	}
}
