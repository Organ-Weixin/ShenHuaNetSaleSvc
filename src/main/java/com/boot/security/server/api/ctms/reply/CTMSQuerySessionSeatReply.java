package com.boot.security.server.api.ctms.reply;

import java.util.List;

import com.boot.security.server.model.SessionSeat;

public class CTMSQuerySessionSeatReply extends CTMSBaseReply {
	private List<SessionSeat> SessionSeats;

	public List<SessionSeat> getSessionSeats() {
		return SessionSeats;
	}

	public void setSessionSeats(List<SessionSeat> sessionSeats) {
		SessionSeats = sessionSeats;
	}
}
