package com.boot.security.server.apicontroller.reply;

public class QueryUserNumberReply extends BaseReply{
	private QueryUserNumberReplyUserNumber data;

	public QueryUserNumberReplyUserNumber getData() {
		return data;
	}

	public void setData(QueryUserNumberReplyUserNumber data) {
		this.data = data;
	}
	public static class QueryUserNumberReplyUserNumber{
		private Integer TicketCount;
		private Integer GoodsCount;
		private Integer CouponsCount;
		private Integer GiftCount;
		private Integer WantedFilmCount;
		private Integer LookedFilmCount;
		public Integer getTicketCount() {
			return TicketCount;
		}
		public void setTicketCount(Integer ticketCount) {
			TicketCount = ticketCount;
		}
		public Integer getGoodsCount() {
			return GoodsCount;
		}
		public void setGoodsCount(Integer goodsCount) {
			GoodsCount = goodsCount;
		}
		public Integer getCouponsCount() {
			return CouponsCount;
		}
		public void setCouponsCount(Integer couponsCount) {
			CouponsCount = couponsCount;
		}
		public Integer getGiftCount() {
			return GiftCount;
		}
		public void setGiftCount(Integer giftCount) {
			GiftCount = giftCount;
		}
		public Integer getWantedFilmCount() {
			return WantedFilmCount;
		}
		public void setWantedFilmCount(Integer wantedFilmCount) {
			WantedFilmCount = wantedFilmCount;
		}
		public Integer getLookedFilmCount() {
			return LookedFilmCount;
		}
		public void setLookedFilmCount(Integer lookedFilmCount) {
			LookedFilmCount = lookedFilmCount;
		}
		
	}
}
