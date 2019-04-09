package com.boot.security.server.api.core;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//设置生成的xml的根节点的名称
@XmlRootElement(name="SubmitOrder")
//设置根据字段还是方法生成
@XmlAccessorType(XmlAccessType.FIELD)
public class SubmitOrderQueryXml {
	@XmlAttribute(name="CinemaCode")
	public String CinemaCode;
	@XmlElement(name="Order")
	public SubmitOrderQueryXmlOrder Order;
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public SubmitOrderQueryXmlOrder getOrder() {
		return Order;
	}
	public void setOrder(SubmitOrderQueryXmlOrder order) {
		Order = order;
	}
	public static class SubmitOrderQueryXmlOrder{
		@XmlAttribute(name="PaySeqNo")
		public String PaySeqNo;
		@XmlAttribute(name="OrderCode")
		public String OrderCode;
		@XmlAttribute(name="SessionCode")
		public String SessionCode;
		@XmlAttribute(name="Count")
		public int Count;
		@XmlAttribute(name="MobilePhone")
		public String MobilePhone;
		@XmlElement(name="Seat")
		public List<SubmitOrderQueryXmlSeat> Seat;
		public String getPaySeqNo() {
			return PaySeqNo;
		}
		public void setPaySeqNo(String paySeqNo) {
			PaySeqNo = paySeqNo;
		}
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
		public String getMobilePhone() {
			return MobilePhone;
		}
		public void setMobilePhone(String mobilePhone) {
			MobilePhone = mobilePhone;
		}
		public List<SubmitOrderQueryXmlSeat> getSeat() {
			return Seat;
		}
		public void setSeat(List<SubmitOrderQueryXmlSeat> seat) {
			Seat = seat;
		}
		public static class SubmitOrderQueryXmlSeat{
			@XmlAttribute(name="SeatCode")
			 public String SeatCode;
			@XmlAttribute(name="Price")
			 public Double Price;
			@XmlAttribute(name="RealPrice")
			 public Double RealPrice;
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
			public Double getRealPrice() {
				return RealPrice;
			}
			public void setRealPrice(Double realPrice) {
				RealPrice = realPrice;
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
