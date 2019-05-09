package com.boot.security.server.apicontroller.reply;

import java.util.Date;
/*小程序-提交影片评论信息*/
public class SubmitFilmCommentReply extends BaseReply{
	private SubmitFilmCommentReplysubmit data;

	public SubmitFilmCommentReplysubmit getData() {
		return data;
	}

	public void setData(SubmitFilmCommentReplysubmit data) {
		this.data = data;
	}
	public static class SubmitFilmCommentReplysubmit{
		private String FilmCode;
		private String FilmName;
		private Double Score;
		private String CommentContent;
		private String OpenID;
		private Date Created;
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
	
	}
}
