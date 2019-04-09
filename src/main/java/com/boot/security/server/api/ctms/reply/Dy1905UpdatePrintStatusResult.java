package com.boot.security.server.api.ctms.reply;

public class Dy1905UpdatePrintStatusResult {
	private ResBean UpdatePrintStatus;

	public ResBean getUpdatePrintStatus() {
		return UpdatePrintStatus;
	}

	public void setUpdatePrintStatus(ResBean updatePrintStatus) {
		UpdatePrintStatus = updatePrintStatus;
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
