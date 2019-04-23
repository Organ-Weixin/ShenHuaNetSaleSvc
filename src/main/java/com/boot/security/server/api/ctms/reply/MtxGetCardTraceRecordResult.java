package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class MtxGetCardTraceRecordResult {
	//getCardTraceRecord查询会员卡交易记录接口
	private ResBean GetCardTraceRecordReturn;
	public ResBean getGetCardTraceRecordReturn() {
		return GetCardTraceRecordReturn;
	}
	public void setGetCardTraceRecordReturn(ResBean getCardTraceRecordReturn) {
		GetCardTraceRecordReturn = getCardTraceRecordReturn;
	}
	public static class ResBean{
		private String ResultCode;//返回码
		private String ResultMsg;//返回描述
		private CardTraceRecordsBean CardTraceRecords;
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
		public CardTraceRecordsBean getCardTraceRecords() {
			return CardTraceRecords;
		}
		public void setCardTraceRecords(CardTraceRecordsBean cardTraceRecords) {
			CardTraceRecords = cardTraceRecords;
		}
		public static class CardTraceRecordsBean{
			private List<CardTraceRecordBean> CardTraceRecord;
			public List<CardTraceRecordBean> getCardTraceRecord() {
				return CardTraceRecord;
			}
			public void setCardTraceRecord(List<CardTraceRecordBean> cardTraceRecord) {
				CardTraceRecord = cardTraceRecord;
			}
			public static class CardTraceRecordBean{
				private String TraceNo;//交易号
				private String  TraceTypeNo;//交易类别编号
				private String  TraceTypeName;//交易类别名称
				private String  TraceDate;//交易日期
				private String  TraceTime;//交易时间
				private String  OldPrice;//交易前余额
				private String  OldScore;//交易前积分
				private String  Price;//实际交易金额
				private String  TracePrice;//交易费用
				private String  Score;//本次交易积分
				private String  UserCode;//操作员
				private String  GiftCod;//礼品编码
				private String  FeatureDate;//排期日期
				private String  FeatureTime;//排期时间
				private String  FeatureNo;//计划号
				private String  FilmNo;//影片号
				private String  CinemaName;//交易地点
				private String  TicketNum;//票数
				private String  TraceMemo;//交易备注
				private String  AccLevelName;//会员卡级别名称
				private String  AccLevelCode;//会员卡级别编号
				public String getTraceNo() {
					return TraceNo;
				}
				public void setTraceNo(String traceNo) {
					TraceNo = traceNo;
				}
				public String getTraceTypeNo() {
					return TraceTypeNo;
				}
				public void setTraceTypeNo(String traceTypeNo) {
					TraceTypeNo = traceTypeNo;
				}
				public String getTraceTypeName() {
					return TraceTypeName;
				}
				public void setTraceTypeName(String traceTypeName) {
					TraceTypeName = traceTypeName;
				}
				public String getTraceDate() {
					return TraceDate;
				}
				public void setTraceDate(String traceDate) {
					TraceDate = traceDate;
				}
				public String getTraceTime() {
					return TraceTime;
				}
				public void setTraceTime(String traceTime) {
					TraceTime = traceTime;
				}
				public String getOldPrice() {
					return OldPrice;
				}
				public void setOldPrice(String oldPrice) {
					OldPrice = oldPrice;
				}
				public String getOldScore() {
					return OldScore;
				}
				public void setOldScore(String oldScore) {
					OldScore = oldScore;
				}
				public String getPrice() {
					return Price;
				}
				public void setPrice(String price) {
					Price = price;
				}
				public String getTracePrice() {
					return TracePrice;
				}
				public void setTracePrice(String tracePrice) {
					TracePrice = tracePrice;
				}
				public String getScore() {
					return Score;
				}
				public void setScore(String score) {
					Score = score;
				}
				public String getUserCode() {
					return UserCode;
				}
				public void setUserCode(String userCode) {
					UserCode = userCode;
				}
				public String getGiftCod() {
					return GiftCod;
				}
				public void setGiftCod(String giftCod) {
					GiftCod = giftCod;
				}
				public String getFeatureDate() {
					return FeatureDate;
				}
				public void setFeatureDate(String featureDate) {
					FeatureDate = featureDate;
				}
				public String getFeatureTime() {
					return FeatureTime;
				}
				public void setFeatureTime(String featureTime) {
					FeatureTime = featureTime;
				}
				public String getFeatureNo() {
					return FeatureNo;
				}
				public void setFeatureNo(String featureNo) {
					FeatureNo = featureNo;
				}
				public String getFilmNo() {
					return FilmNo;
				}
				public void setFilmNo(String filmNo) {
					FilmNo = filmNo;
				}
				public String getCinemaName() {
					return CinemaName;
				}
				public void setCinemaName(String cinemaName) {
					CinemaName = cinemaName;
				}
				public String getTicketNum() {
					return TicketNum;
				}
				public void setTicketNum(String ticketNum) {
					TicketNum = ticketNum;
				}
				public String getTraceMemo() {
					return TraceMemo;
				}
				public void setTraceMemo(String traceMemo) {
					TraceMemo = traceMemo;
				}
				public String getAccLevelName() {
					return AccLevelName;
				}
				public void setAccLevelName(String accLevelName) {
					AccLevelName = accLevelName;
				}
				public String getAccLevelCode() {
					return AccLevelCode;
				}
				public void setAccLevelCode(String accLevelCode) {
					AccLevelCode = accLevelCode;
				}
				
			}
		}
	}
}
