package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryComponentsReply extends BaseReply {

	private List<ComponetsReply> data;
	
	public List<ComponetsReply> getData() {
		return data;
	}
	public void setData(List<ComponetsReply> data) {
		this.data = data;
	}

	public static class ComponetsReply {
		private String packageCode;
		private String packageName;
		private String packagePic;
		private double packageStandarPrice;
		private double packageSettlePrice;
		
		public String getPackageCode() {
			return packageCode;
		}
		public void setPackageCode(String packageCode) {
			this.packageCode = packageCode;
		}
		public String getPackageName() {
			return packageName;
		}
		public void setPackageName(String packageName) {
			this.packageName = packageName;
		}
		public String getPackagePic() {
			return packagePic;
		}
		public void setPackagePic(String packagePic) {
			this.packagePic = packagePic;
		}
		public double getPackageStandarPrice() {
			return packageStandarPrice;
		}
		public void setPackageStandarPrice(double packageStandarPrice) {
			this.packageStandarPrice = packageStandarPrice;
		}
		public double getPackageSettlePrice() {
			return packageSettlePrice;
		}
		public void setPackageSettlePrice(double packageSettlePrice) {
			this.packageSettlePrice = packageSettlePrice;
		}
		
	}
}
