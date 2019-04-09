package com.boot.security.server.api.ctms.reply;

public class Dy1905UnLockSeatResult {
	private ResBean UnLockOrderResult;

	public ResBean getUnLockOrderResult() {
		return UnLockOrderResult;
	}

	public void setUnLockOrderResult(ResBean unLockOrderResult) {
		UnLockOrderResult = unLockOrderResult;
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
