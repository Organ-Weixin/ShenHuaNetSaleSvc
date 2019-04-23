package com.boot.security.server.api.ctms.reply;

public class MtxRegisterCardResult {
	//registerCard 带卡号的会员卡开户接口
	private ResBean RegisterMemberReturn;
	public ResBean getRegisterMemberReturn() {
		return RegisterMemberReturn;
	}
	public void setRegisterMemberReturn(ResBean registerMemberReturn) {
		RegisterMemberReturn = registerMemberReturn;
	}
	public static class ResBean{
		private String ResultCode;//返回码
		private String ResultMsg;//返回描述
		private String AccountNo;//账户号
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public String getResultMsg() {
			return ResultMsg;
		}
		public void setResultMsg(String resultMsg) {
			ResultMsg = resultMsg;
		}
		public String getAccountNo() {
			return AccountNo;
		}
		public void setAccountNo(String accountNo) {
			AccountNo = accountNo;
		}
		
	}
}
