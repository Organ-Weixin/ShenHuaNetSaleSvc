package com.boot.security.server.api.core;

public class QueryDiscountReply extends BaseReply {
	public QueryDiscountReply() 
    {
        Id = ID_QueryDiscountReply;
    }
	private String CinemaCode;
	private QueryDiscountReplyCard Card;
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public QueryDiscountReplyCard getCard() {
		return Card;
	}
	public void setCard(QueryDiscountReplyCard card) {
		Card = card;
	}
	public class QueryDiscountReplyCard{
		private String DiscountType;
		private Float Price;
		private Float CinemaPayAmount;
		public String getDiscountType() {
			return DiscountType;
		}
		public void setDiscountType(String discountType) {
			DiscountType = discountType;
		}
		public Float getPrice() {
			return Price;
		}
		public void setPrice(Float price) {
			Price = price;
		}
		public Float getCinemaPayAmount() {
			return CinemaPayAmount;
		}
		public void setCinemaPayAmount(Float cinemaPayAmount) {
			CinemaPayAmount = cinemaPayAmount;
		}
		
	}

}
