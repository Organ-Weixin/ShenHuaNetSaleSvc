package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class Dy1905CardsListResult {
	private ResBean CardsListResult;

	public ResBean getCardsListResult() {
		return CardsListResult;
	}

	public void setCardsListResult(ResBean cardsListResult) {
		CardsListResult = cardsListResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String ResultMsg;
		private CardsBean Cards;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public String getResultMsg() {
			return ResultMsg;
		}
		public void setResultMsg(String resultMsg) {
			ResultMsg = resultMsg;
		}
		public CardsBean getCards() {
			return Cards;
		}
		public void setCards(CardsBean cards) {
			Cards = cards;
		}
		public static class CardsBean{
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
