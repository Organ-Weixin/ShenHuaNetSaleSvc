package com.boot.security.server.model;

public enum ErrorCodeEnum {
	Exception("出现异常！","-1"),
	Success("成功","0"),
	NecessaryParamMiss("参数缺失！","10000001"),
	UserCredentialInvalid("用户名或密码错误！","10000002"),
	CinemaInvalid("影院不存在或无权限访问！","10000003"),
	ScreenInvalid("影厅不存在！","10000004"),
	StartDateInvalid("开始日期非法！","10000005"),
	EndDateInvalid("结束日期非法！","10000006"),
	DateInvalid("开始日期大于结束日期！","10000007"),
	SessionInvalid("排期不存在！","10000008"),
	SessionSeatStatusInvalid("座位售出状态非法！合法取值包括：All，Available，Locked，Sold，Booked，Unavailable","10000009"),
	XmlDeserializeFail("解析失败","10000010"),
	SeatCountInvalid("座位数量与实际座位不匹配！","10000011"),
	OrderNotExist("订单不存在或状态不合法！","10000012"),
	PaySeqNoNotExist("此订单使用会员卡支付，请传入会员卡支付流水号！","10000013"),
	ChannelOrderCodeAlreadyExist("此渠道订单号已存在！","10000014"),
	MemberCardInvalid("会员卡不存在或未绑定！","10000015"),
	CardChargeTypeInvalid("会员卡充值类型不合法！合法取值包括：Cash，UnionCardPay，UnionOnlinePay，AliPay，WxPay","10000016"),
	CardLevelInvalid("会员卡等级不存在！","10000017"),
	FilmCodeNotExist("影片编码不存在或不合法！","10000018"),
	GoodsCountInvalid("卖品数量不匹配/不合法","10000019"),
	CinemaMiniProgramAccountNotExist("影院小程序APPID不存在或不合法!","10000020"),
	OpenIDNotExist("用户OpenID不存在或不合法!","10000021"),
	VerifyCodeNotMatch("用户手机验证码不匹配！","10000022"),
	SentMessageFailure("短信发送失败！","10000023"),
	CinemaPaySettingInvalid("影院支付配置不存在或不合法！","10000024"),
	CouponsNotExistOrUsed("优惠券不存在或已使用","10000025");
	
	private String Message;
	private String Code;
	ErrorCodeEnum(String Message,String Code){
		this.Message=Message;
		this.Code=Code;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	

}
