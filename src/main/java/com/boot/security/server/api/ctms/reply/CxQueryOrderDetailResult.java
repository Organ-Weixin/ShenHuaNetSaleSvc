package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class CxQueryOrderDetailResult {
	private ResBean QueryOrderDetailResult;

	public ResBean getQueryOrderDetailResult() {
		return QueryOrderDetailResult;
	}

	public void setQueryOrderDetailResult(ResBean queryOrderDetailResult) {
		QueryOrderDetailResult = queryOrderDetailResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String Message;
		private String OrderCode;
		private String PrintNo;
		private String VerifyCode;
		private String OrderStatus;
		private String OrderTime;
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
		public String getOrderStatus() {
			return OrderStatus;
		}
		public void setOrderStatus(String orderStatus) {
			OrderStatus = orderStatus;
		}
		public String getOrderTime() {
			return OrderTime;
		}
		public void setOrderTime(String orderTime) {
			OrderTime = orderTime;
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
				private String MerUid;
				private String MerName;
				private String MerDetail;
				private int MerAmount;
				private Float MerPrice;
				private String IsReturn;
				public String getMerUid() {
					return MerUid;
				}
				public void setMerUid(String merUid) {
					MerUid = merUid;
				}
				public String getMerName() {
					return MerName;
				}
				public void setMerName(String merName) {
					MerName = merName;
				}
				public String getMerDetail() {
					return MerDetail;
				}
				public void setMerDetail(String merDetail) {
					MerDetail = merDetail;
				}
				public int getMerAmount() {
					return MerAmount;
				}
				public void setMerAmount(int merAmount) {
					MerAmount = merAmount;
				}
				public Float getMerPrice() {
					return MerPrice;
				}
				public void setMerPrice(Float merPrice) {
					MerPrice = merPrice;
				}
				public String getIsReturn() {
					return IsReturn;
				}
				public void setIsReturn(String isReturn) {
					IsReturn = isReturn;
				}
				
			}
		}
		
	}
	

}
