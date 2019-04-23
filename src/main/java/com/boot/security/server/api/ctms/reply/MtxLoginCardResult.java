package com.boot.security.server.api.ctms.reply;

public class MtxLoginCardResult {
//	loginCard会员卡登录接口
	private ResBean LoginCardReturn;

	public ResBean getLoginCardReturn() {
		return LoginCardReturn;
	}

	public void setLoginCardReturn(ResBean loginCardReturn) {
		LoginCardReturn = loginCardReturn;
	}
	public static class ResBean{
		private String ResultCode;// 返回码
		private String ResultMsg;//返回描述
		private String CardId;//会员卡卡号
		private String AccLevelCode;//账户级别编码
		private String AccLevelName;//账户级别名称
		private String AccStatus;//会员卡状态(0可用 1 不可用)
		private String AccBalance;//账户余额
		private String AccIntegral;//积分
		private String PlaceNo;//影院编码
		private String CinemaName;//影院名称
		private String IdNnumber;//证件号
		private String ExpirationTime;//过期时间
		private String PhoneNumber;//手机号
		private String Email;//邮箱
		private String Birthday;//出生日期
		private String MemberName;//名称
		private String ConnectName;//人名
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
		public String getAccStatus() {
			return AccStatus;
		}
		public void setAccStatus(String accStatus) {
			AccStatus = accStatus;
		}
		public String getAccBalance() {
			return AccBalance;
		}
		public void setAccBalance(String accBalance) {
			AccBalance = accBalance;
		}
		public String getAccIntegral() {
			return AccIntegral;
		}
		public void setAccIntegral(String accIntegral) {
			AccIntegral = accIntegral;
		}
		public String getPlaceNo() {
			return PlaceNo;
		}
		public void setPlaceNo(String placeNo) {
			PlaceNo = placeNo;
		}
		public String getCinemaName() {
			return CinemaName;
		}
		public void setCinemaName(String cinemaName) {
			CinemaName = cinemaName;
		}
		public String getIdNnumber() {
			return IdNnumber;
		}
		public void setIdNnumber(String idNnumber) {
			IdNnumber = idNnumber;
		}
		public String getExpirationTime() {
			return ExpirationTime;
		}
		public void setExpirationTime(String expirationTime) {
			ExpirationTime = expirationTime;
		}
		public String getPhoneNumber() {
			return PhoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			PhoneNumber = phoneNumber;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getBirthday() {
			return Birthday;
		}
		public void setBirthday(String birthday) {
			Birthday = birthday;
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
