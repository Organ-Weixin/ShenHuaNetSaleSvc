package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryCardLevelReply extends BaseReply{
	private QueryCardLevelReplyCard data;

	public QueryCardLevelReplyCard getData() {
		return data;
	}

	public void setData(QueryCardLevelReplyCard data) {
		this.data = data;
	}
	public static class QueryCardLevelReplyCard{
		private String CinemaCode;
		private List<QueryCardLevelReplyCardLeve> CardLeve;
		public String getCinemaCode() {
			return CinemaCode;
		}
		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		public List<QueryCardLevelReplyCardLeve> getCardLeve() {
			return CardLeve;
		}
		public void setCardLeve(List<QueryCardLevelReplyCardLeve> cardLeve) {
			CardLeve = cardLeve;
		}
		public static class QueryCardLevelReplyCardLeve{
			private String LevelCode;
			private String LevelName;
			private String CardCostFee;
			private String MemberFee;
			private String Status;
			public String getLevelCode() {
				return LevelCode;
			}
			public void setLevelCode(String levelCode) {
				LevelCode = levelCode;
			}
			public String getLevelName() {
				return LevelName;
			}
			public void setLevelName(String levelName) {
				LevelName = levelName;
			}
			public String getCardCostFee() {
				return CardCostFee;
			}
			public void setCardCostFee(String cardCostFee) {
				CardCostFee = cardCostFee;
			}
			public String getMemberFee() {
				return MemberFee;
			}
			public void setMemberFee(String memberFee) {
				MemberFee = memberFee;
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
