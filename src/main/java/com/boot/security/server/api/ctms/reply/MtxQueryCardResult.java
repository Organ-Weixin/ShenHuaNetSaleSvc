package com.boot.security.server.api.ctms.reply;

public class MtxQueryCardResult {
//	queryCard 查询会员卡账户信息
	private ResBean QueryCardReturn;

	public ResBean getQueryCardReturn() {
		return QueryCardReturn;
	}

	public void setQueryCardReturn(ResBean queryCardReturn) {
		QueryCardReturn = queryCardReturn;
	}
	public static class ResBean{
		private String ResultCode;// 返回码
		private String ResultMsg;//返回描述
		private String PlaceNo;//影院编码
		private String CardId;//会员卡号
		private String AccLevelCode;//账户级别编码
		private String AccLevelName;//账户级别名称
		private String Score;//账户积分
		private String AccBalance;//账户余额
		private String AccStatus;//可用标志
		private String ExpirationTime;//过期时间
		private String CinemaName;//影院名称
		private String MemberName;//名称
		private String ConnectName;//人名
		private String IdNum;//证件
		private String BirthDay;//生日
		private String MobilePhone;//手机
		private String Address;//地址
		private String Sex;//性别
		private String Married;//婚否
		private String Kind;//类别
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public String getResultMsg() {
			return ResultMsg;
		}
		public void setResultMsg(String resultMsg) {
			ResultMsg = resultMsg;
		}
		public String getPlaceNo() {
			return PlaceNo;
		}
		public void setPlaceNo(String placeNo) {
			PlaceNo = placeNo;
		}
		public String getCardId() {
			return CardId;
		}
		public void setCardId(String cardId) {
			CardId = cardId;
		}
		public String getAccLevelCode() {
			return AccLevelCode;
		}
		public void setAccLevelCode(String accLevelCode) {
			AccLevelCode = accLevelCode;
		}
		public String getAccLevelName() {
			return AccLevelName;
		}
		public void setAccLevelName(String accLevelName) {
			AccLevelName = accLevelName;
		}
		public String getScore() {
			return Score;
		}
		public void setScore(String score) {
			Score = score;
		}
		public String getAccBalance() {
			return AccBalance;
		}
		public void setAccBalance(String accBalance) {
			AccBalance = accBalance;
		}
		public String getAccStatus() {
			return AccStatus;
		}
		public void setAccStatus(String accStatus) {
			AccStatus = accStatus;
		}
		public String getExpirationTime() {
			return ExpirationTime;
		}
		public void setExpirationTime(String expirationTime) {
			ExpirationTime = expirationTime;
		}
		public String getCinemaName() {
			return CinemaName;
		}
		public void setCinemaName(String cinemaName) {
			CinemaName = cinemaName;
		}
		public String getMemberName() {
			return MemberName;
		}
		public void setMemberName(String memberName) {
			MemberName = memberName;
		}
		public String getConnectName() {
			return ConnectName;
		}
		public void setConnectName(String connectName) {
			ConnectName = connectName;
		}
		public String getIdNum() {
			return IdNum;
		}
		public void setIdNum(String idNum) {
			IdNum = idNum;
		}
		public String getBirthDay() {
			return BirthDay;
		}
		public void setBirthDay(String birthDay) {
			BirthDay = birthDay;
		}
		public String getMobilePhone() {
			return MobilePhone;
		}
		public void setMobilePhone(String mobilePhone) {
			MobilePhone = mobilePhone;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			Address = address;
		}
		public String getSex() {
			return Sex;
		}
		public void setSex(String sex) {
			Sex = sex;
		}
		public String getMarried() {
			return Married;
		}
		public void setMarried(String married) {
			Married = married;
		}
		public String getKind() {
			return Kind;
		}
		public void setKind(String kind) {
			Kind = kind;
		}
		
	}
}
