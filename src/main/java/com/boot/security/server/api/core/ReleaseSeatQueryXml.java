package com.boot.security.server.api.core;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//设置生成的xml的根节点的名称
@XmlRootElement(name="ReleaseSeat")
public class ReleaseSeatQueryXml {
	private String CinemaCode;
	private ReleaseSeatQueryXmlOrder Order;
	@XmlElement(name="CinemaCode")
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	@XmlElement(name="Order")
	public ReleaseSeatQueryXmlOrder getOrder() {
		return Order;
	}
	public void setOrder(ReleaseSeatQueryXmlOrder order) {
		Order = order;
	}
	public static class ReleaseSeatQueryXmlOrder{
		private String OrderCode;
		
		private String SessionCode;
		
		private int Count;
		
		private List<ReleaseSeatQueryXmlSeat> Seat;
		@XmlElement(name="OrderCode")
		public String getOrderCode() {
			return OrderCode;
		}
		public void setOrderCode(String orderCode) {
			OrderCode = orderCode;
		}
		@XmlElement(name="SessionCode")
		public String getSessionCode() {
			return SessionCode;
		}
		public void setSessionCode(String sessionCode) {
			SessionCode = sessionCode;
		}
		@XmlElement(name="Count")
		public int getCount() {
			return Count;
		}
		public void setCount(int count) {
			Count = count;
		}
		@XmlElement(name="Seat")
		public List<ReleaseSeatQueryXmlSeat> getSeat() {
			return Seat;
		}
		public void setSeat(List<ReleaseSeatQueryXmlSeat> seat) {
			Seat = seat;
		}
		public static class ReleaseSeatQueryXmlSeat{
			
			private String SeatCode;

			@XmlElement(name="SeatCode")
			public String getSeatCode() {
				return SeatCode;
			}
			public void setSeatCode(String seatCode) {
				SeatCode = seatCode;
			}
			
		}
		
	}
	

}
