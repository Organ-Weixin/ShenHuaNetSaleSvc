package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class CxQueryMerchandiseResult {
	private ResBean QueryMerchandiseResult;

	public ResBean getQueryMerchandiseResult() {
		return QueryMerchandiseResult;
	}

	public void setQueryMerchandiseResult(ResBean queryMerchandiseResult) {
		QueryMerchandiseResult = queryMerchandiseResult;
	}
	public static class ResBean{
		private String ResultCode;//	返回结果号，详细见附录A
        private String Message;//	返回信息，详细见附录A
        private Integer TotalCount;//商品总记录数
        private MersBean Mers;
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
		public Integer getTotalCount() {
			return TotalCount;
		}
		public void setTotalCount(Integer totalCount) {
			TotalCount = totalCount;
		}
		public MersBean getMers() {
			return Mers;
		}
		public void setMers(MersBean mers) {
			Mers = mers;
		}
		public static class MersBean{
			private List<MerBean> Mer;

			public List<MerBean> getMer() {
				return Mer;
			}

			public void setMer(List<MerBean> mer) {
				Mer = mer;
			}
			public static class MerBean{
				private String MerUid;
				private String MerName;
				private Float ListingPrice;
				private Float SettlePrice;
				private String MerDesc;
				private int ShowSeqNo;
				private int MerTypeId;
				private String MerClassUid;
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
				public Float getListingPrice() {
					return ListingPrice;
				}
				public void setListingPrice(Float listingPrice) {
					ListingPrice = listingPrice;
				}
				public Float getSettlePrice() {
					return SettlePrice;
				}
				public void setSettlePrice(Float settlePrice) {
					SettlePrice = settlePrice;
				}
				public String getMerDesc() {
					return MerDesc;
				}
				public void setMerDesc(String merDesc) {
					MerDesc = merDesc;
				}
				public int getShowSeqNo() {
					return ShowSeqNo;
				}
				public void setShowSeqNo(int showSeqNo) {
					ShowSeqNo = showSeqNo;
				}
				public int getMerTypeId() {
					return MerTypeId;
				}
				public void setMerTypeId(int merTypeId) {
					MerTypeId = merTypeId;
				}
				public String getMerClassUid() {
					return MerClassUid;
				}
				public void setMerClassUid(String merClassUid) {
					MerClassUid = merClassUid;
				}
				
			}
			
		}
        
	}

}
