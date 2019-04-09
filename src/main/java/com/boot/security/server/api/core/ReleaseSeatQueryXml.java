package com.boot.security.server.api.core;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//设置生成的xml的根节点的名称
@XmlRootElement(name="ReleaseSeat")
//设置根据字段还是方法生成
@XmlAccessorType(XmlAccessType.FIELD)
public class ReleaseSeatQueryXml {
	@XmlAttribute(name="CinemaCode")
	public String CinemaCode;
	@XmlElement(name="Order")
	public ReleaseSeatQueryXmlOrder Order;
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public ReleaseSeatQueryXmlOrder getOrder() {
		return Order;
	}
	public void setOrder(ReleaseSeatQueryXmlOrder order) {
		Order = order;
	}
	public static class ReleaseSeatQueryXmlOrder{
		@XmlAttribute(name="OrderCode")
		public String OrderCode;
		@XmlAttribute(name="SessionCode")
		public String SessionCode;
		@XmlAttribute(name="Count")
		public int Count;
		@XmlElement(name="Seat")
		public List<ReleaseSeatQueryXmlSeat> Seat;
		public String getOrderCode() {
			return OrderCode;
		}
		public void setOrderCode(String orderCode) {
			OrderCode = orderCode;
		}
		public String getSessionCode() {
			return SessionCode;
		}
		public void setSessionCode(String sessionCode) {
			SessionCode = sessionCode;
		}
		public int getCount() {
			return Count;
		}
		public void setCount(int count) {
			Count = count;
		}
		public List<ReleaseSeatQueryXmlSeat> getSeat() {
			return Seat;
		}
		public void setSeat(List<ReleaseSeatQueryXmlSeat> seat) {
			Seat = seat;
		}
		public static class ReleaseSeatQueryXmlSeat{
			@XmlAttribute(name="SeatCode")
			public String SeatCode;

			public String getSeatCode() {
				return SeatCode;
			}

			public void setSeatCode(String seatCode) {
				SeatCode = seatCode;
			}
			
		}
		
	}
	

}
