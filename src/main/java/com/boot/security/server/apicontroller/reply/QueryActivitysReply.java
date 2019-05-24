package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryActivitysReply extends BaseReply{

	private QueryActivitysReplyActivity data;
	public QueryActivitysReplyActivity getData() {
		return data;
	}
	public void setData(QueryActivitysReplyActivity data) {
		this.data = data;
	}
	public static class QueryActivitysReplyActivity {
		private int count;
		private List<QueryActivity> Images;
		
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public List<QueryActivity> getImages() {
			return Images;
		}
		public void setImages(List<QueryActivity> images) {
			Images = images;
		}
		public static class QueryActivity {
			private String CinemaCode;
			private String Title;
			private String Image;
			private String LinkUrl;
			
			public String getCinemaCode() {
				return CinemaCode;
			}
			public void setCinemaCode(String cinemaCode) {
				CinemaCode = cinemaCode;
			}
			public String getTitle() {
				return Title;
			}
			public void setTitle(String title) {
				Title = title;
			}
			public String getImage() {
				return Image;
			}
			public void setImage(String image) {
				Image = image;
			}
			public String getLinkUrl() {
				return LinkUrl;
			}
			public void setLinkUrl(String linkUrl) {
				LinkUrl = linkUrl;
			}
			
		}
	}

	
}
