package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryUserAvailableCouponsReply extends BaseReply {
	private QueryUserAvailableCouponsReplydata data;

	public QueryUserAvailableCouponsReplydata getData() {
		return data;
	}

	public void setData(QueryUserAvailableCouponsReplydata data) {
		this.data = data;
	}
	public static class QueryUserAvailableCouponsReplydata{
		private List<QueryUserAvailableCouponsReplyCoupons> CouponsList;

		public List<QueryUserAvailableCouponsReplyCoupons> getCouponsList() {
			return CouponsList;
		}

		public void setCouponsList(List<QueryUserAvailableCouponsReplyCoupons> couponsList) {
			CouponsList = couponsList;
		}
		public static class QueryUserAvailableCouponsReplyCoupons{
			private String CouponsCode;
			private int CouponsType;
			private String CouponsName;
			private Double ReductionPrice;
			public String getCouponsCode() {
				return CouponsCode;
			}
			public void setCouponsCode(String couponsCode) {
				CouponsCode = couponsCode;
			}
			public int getCouponsType() {
				return CouponsType;
			}
			public void setCouponsType(int couponsType) {
				CouponsType = couponsType;
			}
			public String getCouponsName() {
				return CouponsName;
			}
			public void setCouponsName(String couponsName) {
				CouponsName = couponsName;
			}
			public Double getReductionPrice() {
				return ReductionPrice;
			}
			public void setReductionPrice(Double reductionPrice) {
				ReductionPrice = reductionPrice;
			}
			
		}
	}

}
