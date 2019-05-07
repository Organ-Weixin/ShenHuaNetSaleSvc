package com.boot.security.server.api.ctms.reply;

import java.util.List; 

public class CxQueryDiscountActivityResult {
	private ResBean QueryDiscountActivityResult;

	public ResBean getQueryDiscountActivityResult() {
		return QueryDiscountActivityResult;
	}

	public void setQueryDiscountActivityResult(ResBean queryDiscountActivityResult) {
		QueryDiscountActivityResult = queryDiscountActivityResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String Message;
		private String Rule;
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
		public String getRule() {
			return Rule;
		}
		public void setRule(String rule) {
			Rule = rule;
		}
	}

}
