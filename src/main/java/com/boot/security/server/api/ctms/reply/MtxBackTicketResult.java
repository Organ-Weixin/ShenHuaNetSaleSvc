package com.boot.security.server.api.ctms.reply;

public class MtxBackTicketResult {
	//退票
	private ResBean BackTicketResult;


	public ResBean getBackTicketResult() {
		return BackTicketResult;
	}
	public void setBackTicketResult(ResBean backTicketResult) {
		BackTicketResult = backTicketResult;
	}


	public static class ResBean{
		private String ResultCode;

		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		
	}
}
