package com.boot.security.server.apicontroller.reply;

public class UpdateHeadUrlReply extends BaseReply{
	private UpdateHeadUrlReplyHeadUrl data;

	public UpdateHeadUrlReplyHeadUrl getData() {
		return data;
	}

	public void setData(UpdateHeadUrlReplyHeadUrl data) {
		this.data = data;
	}
	public static class UpdateHeadUrlReplyHeadUrl{
		private String HeadUrl;

		public String getHeadUrl() {
			return HeadUrl;
		}

		public void setHeadUrl(String headUrl) {
			HeadUrl = headUrl;
		}
		
	}
}
