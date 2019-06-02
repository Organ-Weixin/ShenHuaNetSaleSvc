package com.boot.security.server.apicontroller.reply;

public class BindCouponsReply extends BaseReply{
	private BindCouponsReplyBind data;

	public BindCouponsReplyBind getData() {
		return data;
	}

	public void setData(BindCouponsReplyBind data) {
		this.data = data;
	}
	public static class BindCouponsReplyBind{
		private String CouponCode;
		private String CouponName;
		private Integer CouponStatus;
		public String getCouponName() {
			return CouponName;
		}
		public void setCouponName(String couponName) {
			CouponName = couponName;
		}
		public String getCouponCode() {
			return CouponCode;
		}
		public void setCouponCode(String couponCode) {
			CouponCode = couponCode;
		}
		public Integer getCouponStatus() {
			return CouponStatus;
		}
		public void setCouponStatus(Integer couponStatus) {
			CouponStatus = couponStatus;
		}
		
	}
}
