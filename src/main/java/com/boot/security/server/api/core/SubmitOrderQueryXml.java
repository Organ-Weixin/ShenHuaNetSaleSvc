package com.boot.security.server.api.core;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//设置生成的xml的根节点的名称
@XmlRootElement(name="SubmitOrder")
public class SubmitOrderQueryXml {
	
	private String CinemaCode;
	
	private SubmitOrderQueryXmlOrder Order;
	@XmlElement(name="CinemaCode")
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	@XmlElement(name="Order")
	public SubmitOrderQueryXmlOrder getOrder() {
		return Order;
	}
	public void setOrder(SubmitOrderQueryXmlOrder order) {
		Order = order;
	}
	public static class SubmitOrderQueryXmlOrder{
		
		private String PaySeqNo;
		
		private String OrderCode;
		
		private String SessionCode;
		
		private int Count;
		
		private String MobilePhone;
		
		private List<SubmitOrderQueryXmlSeat> Seat;
		@XmlElement(name="PaySeqNo")
		public String getPaySeqNo() {
			return PaySeqNo;
		}
		public void setPaySeqNo(String paySeqNo) {
			PaySeqNo = paySeqNo;
		}
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
		@XmlElement(name="MobilePhone")
		public String getMobilePhone() {
			return MobilePhone;
		}
		public void setMobilePhone(String mobilePhone) {
			MobilePhone = mobilePhone;
		}
		@XmlElement(name="Seat")
		public List<SubmitOrderQueryXmlSeat> getSeat() {
			return Seat;
		}
		public void setSeat(List<SubmitOrderQueryXmlSeat> seat) {
			Seat = seat;
		}
		public static class SubmitOrderQueryXmlSeat{
			
			private String SeatCode;
			
			private Double Price;
			
			private Double RealPrice;
			
			private Double Fee;
			
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
			@XmlElement(name="RealPrice")
			public Double getRealPrice() {
				return RealPrice;
			}
			public void setRealPrice(Double realPrice) {
				RealPrice = realPrice;
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
