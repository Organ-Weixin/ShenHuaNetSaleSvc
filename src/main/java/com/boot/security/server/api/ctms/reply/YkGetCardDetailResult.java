package com.boot.security.server.api.ctms.reply;

/**
 * 查询会员卡详细信息
 * @author sheng
 *
 */
public class YkGetCardDetailResult {

	private String api;
	private String v;
	private String retCode;
	private String retMsg;
	private DataBean data;
	
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	public String getRetCode() {
		return retCode;
	}
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	public DataBean getData() {
		return data;
	}
	public void setData(DataBean data) {
		this.data = data;
	}

	public static class DataBean {
		private String bizCode;
		private String bizMsg;
		private CardBean data;
		
		public String getBizCode() {
			return bizCode;
		}
		public void setBizCode(String bizCode) {
			this.bizCode = bizCode;
		}
		public String getBizMsg() {
			return bizMsg;
		}
		public void setBizMsg(String bizMsg) {
			this.bizMsg = bizMsg;
		}
		public CardBean getData() {
			return data;
		}
		public void setData(CardBean data) {
			this.data = data;
		}
		
		public static class CardBean {
			private String cardNumber;
			private String cinemaLinkId;
			private String gradeId;
			private String gradeDesc;
			private String gradeType;
			private String cardStatus;
			private String chargeType;
			private String minAmount;
			private Integer minReChargeTimes;
			private String validateDate;
			private String cardUserName;
			private String mobile;
			private String idCard;
			private String idType;
			private String address;
			private Boolean avaiFlag;
			private String birthdate;
			private String email;
			private String registerDate;
			private String gender;
			private Integer rechargeTimes;
			private Integer consumptionTimes;
			
			public String getCardNumber() {
				return cardNumber;
			}
			public void setCardNumber(String cardNumber) {
				this.cardNumber = cardNumber;
			}
			public String getCinemaLinkId() {
				return cinemaLinkId;
			}
			public void setCinemaLinkId(String cinemaLinkId) {
				this.cinemaLinkId = cinemaLinkId;
			}
			public String getGradeId() {
				return gradeId;
			}
			public void setGradeId(String gradeId) {
				this.gradeId = gradeId;
			}
			public String getGradeDesc() {
				return gradeDesc;
			}
			public void setGradeDesc(String gradeDesc) {
				this.gradeDesc = gradeDesc;
			}
			public String getGradeType() {
				return gradeType;
			}
			public void setGradeType(String gradeType) {
				this.gradeType = gradeType;
			}
			public String getCardStatus() {
				return cardStatus;
			}
			public void setCardStatus(String cardStatus) {
				this.cardStatus = cardStatus;
			}
			public String getChargeType() {
				return chargeType;
			}
			public void setChargeType(String chargeType) {
				this.chargeType = chargeType;
			}
			public String getMinAmount() {
				return minAmount;
			}
			public void setMinAmount(String minAmount) {
				this.minAmount = minAmount;
			}
			public Integer getMinReChargeTimes() {
				return minReChargeTimes;
			}
			public void setMinReChargeTimes(Integer minReChargeTimes) {
				this.minReChargeTimes = minReChargeTimes;
			}
			public String getValidateDate() {
				return validateDate;
			}
			public void setValidateDate(String validateDate) {
				this.validateDate = validateDate;
			}
			public String getCardUserName() {
				return cardUserName;
			}
			public void setCardUserName(String cardUserName) {
				this.cardUserName = cardUserName;
			}
			public String getMobile() {
				return mobile;
			}
			public void setMobile(String mobile) {
				this.mobile = mobile;
			}
			public String getIdCard() {
				return idCard;
			}
			public void setIdCard(String idCard) {
				this.idCard = idCard;
			}
			public String getIdType() {
				return idType;
			}
			public void setIdType(String idType) {
				this.idType = idType;
			}
			public String getAddress() {
				return address;
			}
			public void setAddress(String address) {
				this.address = address;
			}
			public Boolean getAvaiFlag() {
				return avaiFlag;
			}
			public void setAvaiFlag(Boolean avaiFlag) {
				this.avaiFlag = avaiFlag;
			}
			public String getBirthdate() {
				return birthdate;
			}
			public void setBirthdate(String birthdate) {
				this.birthdate = birthdate;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getRegisterDate() {
				return registerDate;
			}
			public void setRegisterDate(String registerDate) {
				this.registerDate = registerDate;
			}
			public String getGender() {
				return gender;
			}
			public void setGender(String gender) {
				this.gender = gender;
			}
			public Integer getRechargeTimes() {
				return rechargeTimes;
			}
			public void setRechargeTimes(Integer rechargeTimes) {
				this.rechargeTimes = rechargeTimes;
			}
			public Integer getConsumptionTimes() {
				return consumptionTimes;
			}
			public void setConsumptionTimes(Integer consumptionTimes) {
				this.consumptionTimes = consumptionTimes;
			}
			
		}
	}
}
