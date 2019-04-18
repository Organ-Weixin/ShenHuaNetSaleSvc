package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class CxQueryMemberLevelResult {
	private ResBean QueryMemberLevelResult;

	public ResBean getQueryMemberLevelResult() {
		return QueryMemberLevelResult;
	}

	public void setQueryMemberLevelResult(ResBean queryMemberLevelResult) {
		QueryMemberLevelResult = queryMemberLevelResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String Message;
		private MemberLevelsBean MemberLevels;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public String getMessage() {
			return Message;
		}
		public void setMessage(String message) {
			Message = message;
		}
		public MemberLevelsBean getMemberLevels() {
			return MemberLevels;
		}
		public void setMemberLevels(MemberLevelsBean memberLevels) {
			MemberLevels = memberLevels;
		}
		public static class MemberLevelsBean{
			private List<MemberLevelBean> MemberLevel;

			public List<MemberLevelBean> getMemberLevel() {
				return MemberLevel;
			}

			public void setMemberLevel(List<MemberLevelBean> memberLevel) {
				MemberLevel = memberLevel;
			}
			public static class MemberLevelBean{
				private String LevelCode;
				private String LevelName;
				private Float OpenCardCost;
				private Float ReissueCardCost;
				private Float ChangeCardCost;
				private Float CancellationCost;
				//private int EveryPurchaseDiscountNum;
				//private int SessionPurchaseDiscountNum;
				private Float Lower;
				private Float Upper;
				private String AllowConsumeType;
				private String AllowIntegralType;
				private Float TicketProportion;
				private Float GoodsProportion;
				//private Float OpenChargeCost;
				private int UpgradeNeedPoint;
				private int IsIntegralCard;
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
				public Float getOpenCardCost() {
					return OpenCardCost;
				}
				public void setOpenCardCost(Float openCardCost) {
					OpenCardCost = openCardCost;
				}
				public Float getReissueCardCost() {
					return ReissueCardCost;
				}
				public void setReissueCardCost(Float reissueCardCost) {
					ReissueCardCost = reissueCardCost;
				}
				public Float getChangeCardCost() {
					return ChangeCardCost;
				}
				public void setChangeCardCost(Float changeCardCost) {
					ChangeCardCost = changeCardCost;
				}
				public Float getCancellationCost() {
					return CancellationCost;
				}
				public void setCancellationCost(Float cancellationCost) {
					CancellationCost = cancellationCost;
				}
				public Float getLower() {
					return Lower;
				}
				public void setLower(Float lower) {
					Lower = lower;
				}
				public Float getUpper() {
					return Upper;
				}
				public void setUpper(Float upper) {
					Upper = upper;
				}
				public String getAllowConsumeType() {
					return AllowConsumeType;
				}
				public void setAllowConsumeType(String allowConsumeType) {
					AllowConsumeType = allowConsumeType;
				}
				public String getAllowIntegralType() {
					return AllowIntegralType;
				}
				public void setAllowIntegralType(String allowIntegralType) {
					AllowIntegralType = allowIntegralType;
				}
				public Float getTicketProportion() {
					return TicketProportion;
				}
				public void setTicketProportion(Float ticketProportion) {
					TicketProportion = ticketProportion;
				}
				public Float getGoodsProportion() {
					return GoodsProportion;
				}
				public void setGoodsProportion(Float goodsProportion) {
					GoodsProportion = goodsProportion;
				}
				public int getUpgradeNeedPoint() {
					return UpgradeNeedPoint;
				}
				public void setUpgradeNeedPoint(int upgradeNeedPoint) {
					UpgradeNeedPoint = upgradeNeedPoint;
				}
				public int getIsIntegralCard() {
					return IsIntegralCard;
				}
				public void setIsIntegralCard(int isIntegralCard) {
					IsIntegralCard = isIntegralCard;
				}
				
			}
		}
		
	}
	

}
