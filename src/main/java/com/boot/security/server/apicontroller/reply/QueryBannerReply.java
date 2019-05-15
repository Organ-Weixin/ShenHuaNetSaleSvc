package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryBannerReply extends BaseReply{

	private BannerData data;
	
	public BannerData getData() {
		return data;
	}
	public void setData(BannerData data) {
		this.data = data;
	}

	public static class BannerData {
		private int count;
		private List<BannerBean> Images;
		
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public List<BannerBean> getImages() {
			return Images;
		}
		public void setImages(List<BannerBean> images) {
			Images = images;
		}

		public static class BannerBean {
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
