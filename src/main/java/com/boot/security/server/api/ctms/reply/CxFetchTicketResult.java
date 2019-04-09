package com.boot.security.server.api.ctms.reply;

public class CxFetchTicketResult {
	private ResBean FetchTicketResult;

	public ResBean getFetchTicketResult() {
		return FetchTicketResult;
	}

	public void setFetchTicketResult(ResBean fetchTicketResult) {
		FetchTicketResult = fetchTicketResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String Message;
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
		
	}
	

}
