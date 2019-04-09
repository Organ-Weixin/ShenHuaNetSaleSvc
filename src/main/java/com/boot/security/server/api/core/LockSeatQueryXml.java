package com.boot.security.server.api.core;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//设置生成的xml的根节点的名称
@XmlRootElement(name="LockSeat")
//设置根据字段还是方法生成
@XmlAccessorType(XmlAccessType.FIELD)
public class LockSeatQueryXml implements Serializable {
	@XmlAttribute(name="CinemaCode")
	public String CinemaCode;
	//xml节点的名称
    @XmlElement(name="Order")
	public LockSeatQueryXmlOrder Order;
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public LockSeatQueryXmlOrder getOrder() {
		return Order;
	}
	public void setOrder(LockSeatQueryXmlOrder order) {
		Order = order;
	}
	public static class LockSeatQueryXmlOrder{
		@XmlAttribute(name="SessionCode")
		public String SessionCode;
		@XmlAttribute(name="Count")
		public int Count;
		@XmlAttribute(name="PayType")
		public String PayType;
		@XmlElement(name="Seat")
		public List<LockSeatQueryXmlSeat> Seat;
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
		public String getPayType() {
			return PayType;
		}
		public void setPayType(String payType) {
			PayType = payType;
		}
		public List<LockSeatQueryXmlSeat> getSeat() {
			return Seat;
		}
		public void setSeat(List<LockSeatQueryXmlSeat> seat) {
			Seat = seat;
		}
		public static class LockSeatQueryXmlSeat{
			@XmlAttribute(name="SeatCode")
			public String SeatCode;
			@XmlAttribute(name="Price")
			public Double Price;
			@XmlAttribute(name="Fee")
			public Double Fee;
			public String getSeatCode() {
				return SeatCode;
			}
			public void setSeatCode(String seatCode) {
				SeatCode = seatCode;
			}
			public Double getPrice() {
				return Price;
			}
			public void setPrice(Double price) {
				Price = price;
			}
			public Double getFee() {
				return Fee;
			}
			public void setFee(Double fee) {
				Fee = fee;
			}
			
		}
	}
    

}
