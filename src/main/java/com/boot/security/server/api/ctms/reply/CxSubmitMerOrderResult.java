package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class CxSubmitMerOrderResult {
	private ResBean SubmitMerOrderResult;

	public ResBean getSubmitMerOrderResult() {
		return SubmitMerOrderResult;
	}

	public void setSubmitMerOrderResult(ResBean submitMerOrderResult) {
		SubmitMerOrderResult = submitMerOrderResult;
	}
	public static class ResBean{
		private String ResultCode;//	返回结果号，详细见附录A
        private String Message;//	返回信息，详细见附录A
        private String OrderCode;
        private String PrintNo;
        private String VerifyCode;
        private SaleMerInfosBean SaleMerInfos;
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
		public String getOrderCode() {
			return OrderCode;
		}
		public void setOrderCode(String orderCode) {
			OrderCode = orderCode;
		}
		public String getPrintNo() {
			return PrintNo;
		}
		public void setPrintNo(String printNo) {
			PrintNo = printNo;
		}
		public String getVerifyCode() {
			return VerifyCode;
		}
		public void setVerifyCode(String verifyCode) {
			VerifyCode = verifyCode;
		}
		public SaleMerInfosBean getSaleMerInfos() {
			return SaleMerInfos;
		}
		public void setSaleMerInfos(SaleMerInfosBean saleMerInfos) {
			SaleMerInfos = saleMerInfos;
		}
        public static class SaleMerInfosBean{
        	private List<SaleMerInfoBean> SaleMerInfo;

			public List<SaleMerInfoBean> getSaleMerInfo() {
				return SaleMerInfo;
			}

			public void setSaleMerInfo(List<SaleMerInfoBean> saleMerInfo) {
				SaleMerInfo = saleMerInfo;
			}
			public static class SaleMerInfoBean{
				private String MerCode;
				private String MerName;
				private int SaleAmount;
				public String getMerCode() {
					return MerCode;
				}
				public void setMerCode(String merCode) {
					MerCode = merCode;
				}
				public String getMerName() {
					return MerName;
				}
				public void setMerName(String merName) {
					MerName = merName;
				}
				public int getSaleAmount() {
					return SaleAmount;
				}
				public void setSaleAmount(int saleAmount) {
					SaleAmount = saleAmount;
				}
				
			}
        	
        }
	}
	

}
