package com.boot.security.server.api.core;

import java.util.Date;
import java.util.List;

public class QueryCardTradeRecordReply extends BaseReply {
	public QueryCardTradeRecordReply()
    {
        Id = ID_QueryCardTradeRecordReply;
    }
	public QueryCardTradeRecordReplyTradeRecord TradeRecord;
	public QueryCardTradeRecordReplyTradeRecord getTradeRecord() {
		return TradeRecord;
	}
	public void setTradeRecord(QueryCardTradeRecordReplyTradeRecord tradeRecord) {
		TradeRecord = tradeRecord;
	}
	public class QueryCardTradeRecordReplyTradeRecord{
		public String CinemaCode;
		public String CardNo;
		public List<QueryCardTradeRecordReplyRecord> Record;
		public String getCinemaCode() {
			return CinemaCode;
		}
		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		public String getCardNo() {
			return CardNo;
		}
		public void setCardNo(String cardNo) {
			CardNo = cardNo;
		}
		public List<QueryCardTradeRecordReplyRecord> getRecord() {
			return Record;
		}
		public void setRecord(List<QueryCardTradeRecordReplyRecord> record) {
			Record = record;
		}
		public class QueryCardTradeRecordReplyRecord{
			public String TradeNo;
			public String TradeType;
			public Date TradeTime;
			public Float TradePrice;
			public String CinemaName;
			public String getTradeNo() {
				return TradeNo;
			}
			public void setTradeNo(String tradeNo) {
				TradeNo = tradeNo;
			}
			public String getTradeType() {
				return TradeType;
			}
			public void setTradeType(String tradeType) {
				TradeType = tradeType;
			}
			public Date getTradeTime() {
				return TradeTime;
			}
			public void setTradeTime(Date tradeTime) {
				TradeTime = tradeTime;
			}
			public Float getTradePrice() {
				return TradePrice;
			}
			public void setTradePrice(Float tradePrice) {
				TradePrice = tradePrice;
			}
			public String getCinemaName() {
				return CinemaName;
			}
			public void setCinemaName(String cinemaName) {
				CinemaName = cinemaName;
			}
			
		}
	}

}
