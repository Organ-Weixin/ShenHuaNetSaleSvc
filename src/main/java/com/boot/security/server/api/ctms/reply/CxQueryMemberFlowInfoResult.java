package com.boot.security.server.api.ctms.reply;

import java.util.List; 

public class CxQueryMemberFlowInfoResult {
	private ResBean QueryMemberFlowInfoResult;

	public ResBean getQueryMemberFlowInfoResult() {
		return QueryMemberFlowInfoResult;
	}

	public void setQueryMemberFlowInfoResult(ResBean queryMemberFlowInfoResult) {
		QueryMemberFlowInfoResult = queryMemberFlowInfoResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String Message;
		private TransFlowVOsBean TransFlowVOs;
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
		public TransFlowVOsBean getTransFlowVOs() {
			return TransFlowVOs;
		}
		public void setTransFlowVOs(TransFlowVOsBean transFlowVOs) {
			TransFlowVOs = transFlowVOs;
		}
		public static class TransFlowVOsBean{
			private List<TransFlowVOBean> TransFlowVO;

			public List<TransFlowVOBean> getTransFlowVO() {
				return TransFlowVO;
			}

			public void setTransFlowVO(List<TransFlowVOBean> transFlowVO) {
				TransFlowVO = transFlowVO;
			}
			public static class TransFlowVOBean{
				private String MobileNum;
				private String CardNum;
				private String OrderCode;
				private String TransactionNo;
				private String FlowNum;
				private String TransactionTime;
				private String MerchantName;
				private String ChannelType;
				private String FlowType;
				private Float TransactionAmount;
				public String getMobileNum() {
					return MobileNum;
				}
				public void setMobileNum(String mobileNum) {
					MobileNum = mobileNum;
				}
				public String getCardNum() {
					return CardNum;
				}
				public void setCardNum(String cardNum) {
					CardNum = cardNum;
				}
				public String getOrderCode() {
					return OrderCode;
				}
				public void setOrderCode(String orderCode) {
					OrderCode = orderCode;
				}
				public String getTransactionNo() {
					return TransactionNo;
				}
				public void setTransactionNo(String transactionNo) {
					TransactionNo = transactionNo;
				}
				public String getFlowNum() {
					return FlowNum;
				}
				public void setFlowNum(String flowNum) {
					FlowNum = flowNum;
				}
				public String getTransactionTime() {
					return TransactionTime;
				}
				public void setTransactionTime(String transactionTime) {
					TransactionTime = transactionTime;
				}
				public String getMerchantName() {
					return MerchantName;
				}
				public void setMerchantName(String merchantName) {
					MerchantName = merchantName;
				}
				public String getChannelType() {
					return ChannelType;
				}
				public void setChannelType(String channelType) {
					ChannelType = channelType;
				}
				public String getFlowType() {
					return FlowType;
				}
				public void setFlowType(String flowType) {
					FlowType = flowType;
				}
				public Float getTransactionAmount() {
					return TransactionAmount;
				}
				public void setTransactionAmount(Float transactionAmount) {
					TransactionAmount = transactionAmount;
				}
				
			}
		}
	}

}
