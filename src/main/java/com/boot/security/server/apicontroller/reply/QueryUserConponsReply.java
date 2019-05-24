package com.boot.security.server.apicontroller.reply;

import java.util.Date;
import java.util.List;

public class QueryUserConponsReply extends BaseReply{
	private QueryUserConponsBeans data;
	public QueryUserConponsBeans getData() {
		return data;
	}
	public void setData(QueryUserConponsBeans data) {
		this.data = data;
	}
	public class QueryUserConponsBeans{
		private int ConponCount;//优惠券数量
		private List<QueryUserConponsBean> Conpons;
		public int getConponCount() {
			return ConponCount;
		}
		public void setConponCount(int conponCount) {
			ConponCount = conponCount;
		}
		public List<QueryUserConponsBean> getConpons() {
			return Conpons;
		}
		public void setConpons(List<QueryUserConponsBean> conpons) {
			Conpons = conpons;
		}
		public class QueryUserConponsBean{
			private Long ConponId;
			private String CinemaCode;
			private String TypeCode;
			private String GroupCode;
			private String OpenID;
			private String Price;
			private String ConponCode;
			private String SnackCode;
			private String EffectiveDate;
			private String ExpireDate; 
			private String Status;
			private String UseDate;
			private String ReceivedDate;
			private String Title;
			private String Remark;
			public Long getConponId() {
				return ConponId;
			}
			public void setConponId(Long conponId) {
				ConponId = conponId;
			}
			public String getCinemaCode() {
				return CinemaCode;
			}
			public void setCinemaCode(String cinemaCode) {
				CinemaCode = cinemaCode;
			}
			public String getTypeCode() {
				return TypeCode;
			}
			public void setTypeCode(String typeCode) {
				TypeCode = typeCode;
			}
			public String getGroupCode() {
				return GroupCode;
			}
			public void setGroupCode(String groupCode) {
				GroupCode = groupCode;
			}
			public String getOpenID() {
				return OpenID;
			}
			public void setOpenID(String openID) {
				OpenID = openID;
			}
			public String getPrice() {
				return Price;
			}
			public void setPrice(String price) {
				Price = price;
			}
			public String getConponCode() {
				return ConponCode;
			}
			public void setConponCode(String conponCode) {
				ConponCode = conponCode;
			}
			public String getSnackCode() {
				return SnackCode;
			}
			public void setSnackCode(String snackCode) {
				SnackCode = snackCode;
			}
			public String getEffectiveDate() {
				return EffectiveDate;
			}
			public void setEffectiveDate(String effectiveDate) {
				EffectiveDate = effectiveDate;
			}
			public String getExpireDate() {
				return ExpireDate;
			}
			public void setExpireDate(String expireDate) {
				ExpireDate = expireDate;
			}
			public String getStatus() {
				return Status;
			}
			public void setStatus(String status) {
				Status = status;
			}
			public String getUseDate() {
				return UseDate;
			}
			public void setUseDate(String useDate) {
				UseDate = useDate;
			}
			public String getReceivedDate() {
				return ReceivedDate;
			}
			public void setReceivedDate(String receivedDate) {
				ReceivedDate = receivedDate;
			}
			public String getTitle() {
				return Title;
			}
			public void setTitle(String title) {
				Title = title;
			}
			public String getRemark() {
				return Remark;
			}
			public void setRemark(String remark) {
				Remark = remark;
			}
		}
	}
}
