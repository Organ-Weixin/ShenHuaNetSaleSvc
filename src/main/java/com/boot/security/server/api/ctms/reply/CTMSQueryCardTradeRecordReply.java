package com.boot.security.server.api.ctms.reply;

import java.util.List;

import com.boot.security.server.model.CardTradeRecord;

public class CTMSQueryCardTradeRecordReply extends CTMSBaseReply {
	private List<CardTradeRecord> CardTradeRecords;

	public List<CardTradeRecord> getCardTradeRecords() {
		return CardTradeRecords;
	}

	public void setCardTradeRecords(List<CardTradeRecord> cardTradeRecords) {
		CardTradeRecords = cardTradeRecords;
	}
}
