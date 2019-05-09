package com.boot.security.server.apicontroller.reply;

import java.util.List;

/*获取用户优惠券(分页)*/
public class QueryUserConponsPagedReply extends BaseReply{
	private QueryUserConponsPagedBeans data;
	public QueryUserConponsPagedBeans getData() {
		return data;
	}
	public void setData(QueryUserConponsPagedBeans data) {
		this.data = data;
	}

	public  class QueryUserConponsPagedBeans{
		private int ConponCount;//优惠券数量
		private List<QueryUserConponsPagedBean> Conpons;//优惠券
		public int getConponCount() {
			return ConponCount;
		}
		public void setConponCount(int conponCount) {
			ConponCount = conponCount;
		}
		public List<QueryUserConponsPagedBean> getConpons() {
			return Conpons;
		}
		public void setConpons(List<QueryUserConponsPagedBean> conpons) {
			Conpons = conpons;
		}
		public class QueryUserConponsPagedBean{
			private Long ConponId;
			private String CinemaCode;
			private String TypeCode;
			private String GroupCode;
			private String OpenID;
			private String Price;
			private String ConponCode;
			private String SnackCode;
			private String ValidityDate;
			private String Status;
			private String UseDate;
			private String ReceivedDate;
			private String Deleted;
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
			public String getValidityDate() {
				return ValidityDate;
			}
			public void setValidityDate(String validityDate) {
				ValidityDate = validityDate;
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
			public String getDeleted() {
				return Deleted;
			}
			public void setDeleted(String deleted) {
				Deleted = deleted;
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
