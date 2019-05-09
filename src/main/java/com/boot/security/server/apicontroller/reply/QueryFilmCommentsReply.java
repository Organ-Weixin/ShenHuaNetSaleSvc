package com.boot.security.server.apicontroller.reply;

import java.util.Date;
import java.util.List;

/*
 * 小程序-获取影片评论信息
 * */
public class QueryFilmCommentsReply extends BaseReply{
	private QueryFilmCommentsBean data;
	public QueryFilmCommentsBean getData() {
		return data;
	}
	public void setData(QueryFilmCommentsBean data) {
		this.data = data;
	}
	public  class QueryFilmCommentsBean{
		private int CommentCount;
		private List<QueryFilmCommentBean> Comments;
		public Integer getCommentCount() {
			return CommentCount;
		}
		public void setCommentCount(Integer commentCount) {
			CommentCount = commentCount;
		}
		public List<QueryFilmCommentBean> getComments() {
			return Comments;
		}
		public void setComments(List<QueryFilmCommentBean> comments) {
			Comments = comments;
		}
		public void setCommentCount(int commentCount) {
			CommentCount = commentCount;
		}
		public  class QueryFilmCommentBean{
			private Long CommentId;
			private String FilmCode;
			private String FilmName;
			private Double Score;
			private String CommentContent;
			private String OpenID;
			private Date Created;
			private String NickName;
			private String HeadImgUrl;
			public Long getCommentId() {
				return CommentId;
			}
			public void setCommentId(Long commentId) {
				CommentId = commentId;
			}
			public String getFilmCode() {
				return FilmCode;
			}
			public void setFilmCode(String filmCode) {
				FilmCode = filmCode;
			}
			public String getFilmName() {
				return FilmName;
			}
			public void setFilmName(String filmName) {
				FilmName = filmName;
			}
			public Double getScore() {
				return Score;
			}
			public void setScore(Double score) {
				Score = score;
			}
			public String getCommentContent() {
				return CommentContent;
			}
			public void setCommentContent(String commentContent) {
				CommentContent = commentContent;
			}
			public String getOpenID() {
				return OpenID;
			}
			public void setOpenID(String openID) {
				OpenID = openID;
			}
			public Date getCreated() {
				return Created;
			}
			public void setCreated(Date created) {
				Created = created;
			}
			public String getNickName() {
				return NickName;
			}
			public void setNickName(String nickName) {
				NickName = nickName;
			}
			public String getHeadImgUrl() {
				return HeadImgUrl;
			}
			public void setHeadImgUrl(String headImgUrl) {
				HeadImgUrl = headImgUrl;
			}
			
		}
	}
}
