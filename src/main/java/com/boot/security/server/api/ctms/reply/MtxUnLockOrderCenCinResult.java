package com.boot.security.server.api.ctms.reply;

public class MtxUnLockOrderCenCinResult {
	//实时解锁座位
	private ResBean UnLockOrderCenCinResult;
	public ResBean getUnLockOrderCenCinResult() {
		return UnLockOrderCenCinResult;
	}
	public void setUnLockOrderCenCinResult(ResBean unLockOrderCenCinResult) {
		UnLockOrderCenCinResult = unLockOrderCenCinResult;
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
