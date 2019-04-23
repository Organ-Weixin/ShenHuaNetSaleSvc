package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class MtxGetCardTypeResult {
	//getCardType获取影院会员卡级别接口
	private ResBean GetCardTypeReturn;
	public ResBean getGetCardTypeReturn() {
		return GetCardTypeReturn;
	}
	public void setGetCardTypeReturn(ResBean getCardTypeReturn) {
		GetCardTypeReturn = getCardTypeReturn;
	}
//	private String MemberType;//会员级别编码
//	private String MemberTypeName;//会员级别名称
	public static class ResBean{
		private String ResultCode;//返回码
		private String ResultMsg;//返回描述
		private MemberTypesBean MemberTypes;
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
		public MemberTypesBean getMemberTypes() {
			return MemberTypes;
		}
		public void setMemberTypes(MemberTypesBean memberTypes) {
			MemberTypes = memberTypes;
		}
		public static class MemberTypesBean{
			private List<MemberTypeBean> MemberType;
			public List<MemberTypeBean> getMemberType() {
				return MemberType;
			}
			public void setMemberType(List<MemberTypeBean> memberType) {
				MemberType = memberType;
			}
			public static class MemberTypeBean{
				private String MemberType;//会员级别编码
				private String MemberTypeName;//会员级别名称
				public String getMemberType() {
					return MemberType;
				}
				public void setMemberType(String memberType) {
					MemberType = memberType;
				}
				public String getMemberTypeName() {
					return MemberTypeName;
				}
				public void setMemberTypeName(String memberTypeName) {
					MemberTypeName = memberTypeName;
				}
				
			}
		}
		
	}
}
