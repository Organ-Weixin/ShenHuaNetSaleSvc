package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryGoodsTypeReply extends BaseReply {
	private QueryGoodsTypeReplyTypes data;

	public QueryGoodsTypeReplyTypes getData() {
		return data;
	}

	public void setData(QueryGoodsTypeReplyTypes data) {
		this.data = data;
	}
	public static class QueryGoodsTypeReplyTypes{
		private int TypeCount;
		private List<QueryGoodsTypeReplyType> Type;
		public int getTypeCount() {
			return TypeCount;
		}
		public void setTypeCount(int typeCount) {
			TypeCount = typeCount;
		}
		public List<QueryGoodsTypeReplyType> getType() {
			return Type;
		}
		public void setType(List<QueryGoodsTypeReplyType> type) {
			Type = type;
		}
		public static class QueryGoodsTypeReplyType{
			private Long TypeId;
			private String CinemaCode;
			private Long UserId;
			private String TypeCode;
			private String TypeName;
			private String TypeDesc;
			private String TypePic;
			public Long getTypeId() {
				return TypeId;
			}
			public void setTypeId(Long typeId) {
				TypeId = typeId;
			}
			public String getCinemaCode() {
				return CinemaCode;
			}
			public void setCinemaCode(String cinemaCode) {
				CinemaCode = cinemaCode;
			}
			public Long getUserId() {
				return UserId;
			}
			public void setUserId(Long userId) {
				UserId = userId;
			}
			public String getTypeCode() {
				return TypeCode;
			}
			public void setTypeCode(String typeCode) {
				TypeCode = typeCode;
			}
			public String getTypeName() {
				return TypeName;
			}
			public void setTypeName(String typeName) {
				TypeName = typeName;
			}
			public String getTypeDesc() {
				return TypeDesc;
			}
			public void setTypeDesc(String typeDesc) {
				TypeDesc = typeDesc;
			}
			public String getTypePic() {
				return TypePic;
			}
			public void setTypePic(String typePic) {
				TypePic = typePic;
			}
			
		}
		
	}

}
