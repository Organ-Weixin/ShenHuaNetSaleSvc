package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class Dy1905MemberTypeListResult {
	private ResBean MemberTypeListResult;

	public ResBean getMemberTypeListResult() {
		return MemberTypeListResult;
	}

	public void setMemberTypeListResult(ResBean memberTypeListResult) {
		MemberTypeListResult = memberTypeListResult;
	}
	public class ResBean{
		private String ResultCode;
		private String ResultMsg;
		private TypesBean Types;
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
		public TypesBean getTypes() {
			return Types;
		}
		public void setTypes(TypesBean types) {
			Types = types;
		}
		public class TypesBean{
			private List<TypeBean> Type;

			public List<TypeBean> getType() {
				return Type;
			}

			public void setType(List<TypeBean> type) {
				Type = type;
			}
			public class TypeBean{
				private String TypeNo;
				private String TypeName;
				private LevelsBean Levels;
				public String getTypeNo() {
					return TypeNo;
				}
				public void setTypeNo(String typeNo) {
					TypeNo = typeNo;
				}
				public String getTypeName() {
					return TypeName;
				}
				public void setTypeName(String typeName) {
					TypeName = typeName;
				}
				public LevelsBean getLevels() {
					return Levels;
				}
				public void setLevels(LevelsBean levels) {
					Levels = levels;
				}
				public class LevelsBean{
					private List<LevelBean> Level;

					public List<LevelBean> getLevel() {
						return Level;
					}

					public void setLevel(List<LevelBean> level) {
						Level = level;
					}
					public class LevelBean{
						private String LevelNo;
						private String LevelName;
						private String DiscountRate;
						private Double InitalalAmount;
						private Double RechargeAmount;
						private String Rechargeable;
						private String Levelup;
						private String ScoreRatio;
						private String ValidityMonths;
						private Double ActiveFee;
						private Double RenewalAmount;
						private String RenewalMonths;
						private UseCinemasBean UseCinemas;
						public String getLevelNo() {
							return LevelNo;
						}
						public void setLevelNo(String levelNo) {
							LevelNo = levelNo;
						}
						public String getLevelName() {
							return LevelName;
						}
						public void setLevelName(String levelName) {
							LevelName = levelName;
						}
						public String getDiscountRate() {
							return DiscountRate;
						}
						public void setDiscountRate(String discountRate) {
							DiscountRate = discountRate;
						}
						public Double getInitalalAmount() {
							return InitalalAmount;
						}
						public void setInitalalAmount(Double initalalAmount) {
							InitalalAmount = initalalAmount;
						}
						public Double getRechargeAmount() {
							return RechargeAmount;
						}
						public void setRechargeAmount(Double rechargeAmount) {
							RechargeAmount = rechargeAmount;
						}
						public String getRechargeable() {
							return Rechargeable;
						}
						public void setRechargeable(String rechargeable) {
							Rechargeable = rechargeable;
						}
						public String getLevelup() {
							return Levelup;
						}
						public void setLevelup(String levelup) {
							Levelup = levelup;
						}
						public String getScoreRatio() {
							return ScoreRatio;
						}
						public void setScoreRatio(String scoreRatio) {
							ScoreRatio = scoreRatio;
						}
						public String getValidityMonths() {
							return ValidityMonths;
						}
						public void setValidityMonths(String validityMonths) {
							ValidityMonths = validityMonths;
						}
						public Double getActiveFee() {
							return ActiveFee;
						}
						public void setActiveFee(Double activeFee) {
							ActiveFee = activeFee;
						}
						public Double getRenewalAmount() {
							return RenewalAmount;
						}
						public void setRenewalAmount(Double renewalAmount) {
							RenewalAmount = renewalAmount;
						}
						public String getRenewalMonths() {
							return RenewalMonths;
						}
						public void setRenewalMonths(String renewalMonths) {
							RenewalMonths = renewalMonths;
						}
						public UseCinemasBean getUseCinemas() {
							return UseCinemas;
						}
						public void setUseCinemas(UseCinemasBean useCinemas) {
							UseCinemas = useCinemas;
						}
						public class UseCinemasBean{
							private String CinemaId;

							public String getCinemaId() {
								return CinemaId;
							}

							public void setCinemaId(String cinemaId) {
								CinemaId = cinemaId;
							}
						}
					}
				}
			}
		}
	}
}
