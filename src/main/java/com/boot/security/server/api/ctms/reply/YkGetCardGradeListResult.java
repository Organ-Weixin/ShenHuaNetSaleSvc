package com.boot.security.server.api.ctms.reply;

import java.util.List;

/**
 * 查询会员卡等级列表
 * @author sheng
 *
 */
public class YkGetCardGradeListResult {

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

	public static class DataBean{
		private String bizCode;
		private String bizMsg;
		private List<CardBean> dataList;
		
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
		public List<CardBean> getDataList() {
			return dataList;
		}
		public void setDataList(List<CardBean> dataList) {
			this.dataList = dataList;
		}

		public static class CardBean {
			private String cinemaLinkId;
			private String gradeId;
			private String gradeDesc;
			private String gradeType;
			private String goodsDiscount;
			private Integer maxDiscountTicketsPerDay;
			private Integer maxDiscountTicketsPerShow;
			private String minAmount;
			private String cardCostFee;
			private String memberFee;
			private String firstRecharge;
			private Integer transactValidityPeriod;
			private Boolean rechargeExtensionFlag;
			private String rechargeExtensionAmount;
			private List<hallDiscount> hallDiscounts;
			
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
			public String getGoodsDiscount() {
				return goodsDiscount;
			}
			public void setGoodsDiscount(String goodsDiscount) {
				this.goodsDiscount = goodsDiscount;
			}
			public Integer getMaxDiscountTicketsPerDay() {
				return maxDiscountTicketsPerDay;
			}
			public void setMaxDiscountTicketsPerDay(Integer maxDiscountTicketsPerDay) {
				this.maxDiscountTicketsPerDay = maxDiscountTicketsPerDay;
			}
			public Integer getMaxDiscountTicketsPerShow() {
				return maxDiscountTicketsPerShow;
			}
			public void setMaxDiscountTicketsPerShow(Integer maxDiscountTicketsPerShow) {
				this.maxDiscountTicketsPerShow = maxDiscountTicketsPerShow;
			}
			public String getMinAmount() {
				return minAmount;
			}
			public void setMinAmount(String minAmount) {
				this.minAmount = minAmount;
			}
			public String getCardCostFee() {
				return cardCostFee;
			}
			public void setCardCostFee(String cardCostFee) {
				this.cardCostFee = cardCostFee;
			}
			public String getMemberFee() {
				return memberFee;
			}
			public void setMemberFee(String memberFee) {
				this.memberFee = memberFee;
			}
			public String getFirstRecharge() {
				return firstRecharge;
			}
			public void setFirstRecharge(String firstRecharge) {
				this.firstRecharge = firstRecharge;
			}
			public Integer getTransactValidityPeriod() {
				return transactValidityPeriod;
			}
			public void setTransactValidityPeriod(Integer transactValidityPeriod) {
				this.transactValidityPeriod = transactValidityPeriod;
			}
			public Boolean getRechargeExtensionFlag() {
				return rechargeExtensionFlag;
			}
			public void setRechargeExtensionFlag(Boolean rechargeExtensionFlag) {
				this.rechargeExtensionFlag = rechargeExtensionFlag;
			}
			public String getRechargeExtensionAmount() {
				return rechargeExtensionAmount;
			}
			public void setRechargeExtensionAmount(String rechargeExtensionAmount) {
				this.rechargeExtensionAmount = rechargeExtensionAmount;
			}
			public List<hallDiscount> getHallDiscounts() {
				return hallDiscounts;
			}
			public void setHallDiscounts(List<hallDiscount> hallDiscounts) {
				this.hallDiscounts = hallDiscounts;
			}

			public static class hallDiscount {
				private String hallType;
				private String idscountType;
				private String discount;
				
				public String getHallType() {
					return hallType;
				}
				public void setHallType(String hallType) {
					this.hallType = hallType;
				}
				public String getIdscountType() {
					return idscountType;
				}
				public void setIdscountType(String idscountType) {
					this.idscountType = idscountType;
				}
				public String getDiscount() {
					return discount;
				}
				public void setDiscount(String discount) {
					this.discount = discount;
				}
				
			}
		}
	}
}
