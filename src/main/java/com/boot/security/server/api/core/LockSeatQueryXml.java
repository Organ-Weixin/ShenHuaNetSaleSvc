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
public class LockSeatQueryXml{
	private String CinemaCode;
	private LockSeatQueryXmlOrder Order;
	@XmlElement(name="CinemaCode")
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	@XmlElement(name="Order")
	public LockSeatQueryXmlOrder getOrder() {
		return Order;
	}
	public void setOrder(LockSeatQueryXmlOrder order) {
		Order = order;
	}
	public static class LockSeatQueryXmlOrder{

		private String SessionCode;

		private int Count;

		private String PayType;

		private List<LockSeatQueryXmlSeat> Seat;

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
		@XmlElement(name="PayType")
		public String getPayType() {
			return PayType;
		}
		public void setPayType(String payType) {
			PayType = payType;
		}
		@XmlElement(name="Seat")
		public List<LockSeatQueryXmlSeat> getSeat() {
			return Seat;
		}
		public void setSeat(List<LockSeatQueryXmlSeat> seat) {
			Seat = seat;
		}
		public static class LockSeatQueryXmlSeat{

			private String SeatCode;

			private Double Price;

			private Double Fee;
			//辰星系统需要这两个
			private Double AddFee;
			private Double CinemaAllowance;
			
			@XmlElement(name="AddFee")
			public Double getAddFee() {
				return AddFee;
			}
			public void setAddFee(Double addFee) {
				AddFee = addFee;
			}
			@XmlElement(name="CinemaAllowance")
			public Double getCinemaAllowance() {
				return CinemaAllowance;
			}
			public void setCinemaAllowance(Double cinemaAllowance) {
				CinemaAllowance = cinemaAllowance;
			}
			@XmlElement(name="SeatCode")
			public String getSeatCode() {
				return SeatCode;
			}
			public void setSeatCode(String seatCode) {
				SeatCode = seatCode;
			}
			@XmlElement(name="Price")
			public Double getPrice() {
				return Price;
			}
			public void setPrice(Double price) {
				Price = price;
			}
			@XmlElement(name="Fee")
			public Double getFee() {
				return Fee;
			}
			public void setFee(Double fee) {
				Fee = fee;
			}
			
		}
	}
    

}
