package com.boot.security.server.api.ctms.reply;

public class Dy1905UpdatePrintStatusResult {
	private ResBean UpdatePrintStatusResult;
	
	public ResBean getUpdatePrintStatusResult() {
		return UpdatePrintStatusResult;
	}

	public void setUpdatePrintStatusResult(ResBean updatePrintStatusResult) {
		UpdatePrintStatusResult = updatePrintStatusResult;
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
