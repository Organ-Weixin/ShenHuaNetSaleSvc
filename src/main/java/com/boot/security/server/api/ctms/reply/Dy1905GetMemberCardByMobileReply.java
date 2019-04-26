package com.boot.security.server.api.ctms.reply;

import java.util.List;

import com.boot.security.server.apicontroller.reply.BaseReply;



public class Dy1905GetMemberCardByMobileReply extends BaseReply{
	private GetMemberCardByMobileReplyMemberCard data;

	public GetMemberCardByMobileReplyMemberCard getData() {
		return data;
	}

	public void setData(GetMemberCardByMobileReplyMemberCard data) {
		this.data = data;
	}
	public class GetMemberCardByMobileReplyMemberCard{
		private GetMemberCardByMobileReplyCard Cards;

		public GetMemberCardByMobileReplyCard getCards() {
			return Cards;
		}

		public void setCards(GetMemberCardByMobileReplyCard cards) {
			Cards = cards;
		}
		public class GetMemberCardByMobileReplyCard{
			private List<String> CardNo;

			public List<String> getCardNo() {
				return CardNo;
			}

			public void setCardNo(List<String> cardNo) {
				CardNo = cardNo;
			}
			
		}
	}
}
