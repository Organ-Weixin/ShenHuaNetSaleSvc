package com.boot.security.server.apicontroller.reply;

import com.boot.security.server.model.ErrorCodeEnum;
import com.boot.security.server.model.StatusEnum;

public class BaseReply { 
	public BaseReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.Exception.getCode();
        ErrorMessage = ErrorCodeEnum.Exception.getMessage();
    }
	
	/// <summary>
    /// 从影院票务系统返回中获取错误信息
    /// </summary>
    /// <param name="CTMSReply"></param>
    public void GetErrorFromNetSaleReply(com.boot.security.server.api.core.BaseReply NetSaleReply)
    {
        Status = NetSaleReply.Status;
        ErrorCode = NetSaleReply.ErrorCode;
        ErrorMessage = NetSaleReply.ErrorMessage;
    }
    
  /// <summary>
    /// 成功返回
    /// </summary>
    public void SetSuccessReply()
    {
        Status = StatusEnum.Success.getStatusCode();
        ErrorCode = ErrorCodeEnum.Success.getCode();
        ErrorMessage = ErrorCodeEnum.Success.getMessage();
    }
  /// <summary>
    /// 参数缺失返回内容
    /// </summary>
    public void SetNecessaryParamMissReply(String ParamName)
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.NecessaryParamMiss.getCode();
        ErrorMessage = ParamName+ErrorCodeEnum.NecessaryParamMiss.getMessage();
    }
  /// <summary>
    /// 设置用户名/密码错误时的返回内容
    /// </summary>
    public void SetUserCredentialInvalidReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.UserCredentialInvalid.getCode();
        ErrorMessage = ErrorCodeEnum.UserCredentialInvalid.getMessage();
    }
  /// <summary>
    /// 影院不存在或不可访问
    /// </summary>
    public void SetCinemaInvalidReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.CinemaInvalid.getCode();
        ErrorMessage = ErrorCodeEnum.CinemaInvalid.getMessage();
    }
    
    
  /// <summary>
    /// 影厅编码错误
    /// </summary>
    public void SetScreenInvalidReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.ScreenInvalid.getCode();
        ErrorMessage = ErrorCodeEnum.ScreenInvalid.getMessage();
    }
  /// <summary>
    /// 开始日期错误
    /// </summary>
    public void SetStartDateInvalidReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.StartDateInvalid.getCode();
        ErrorMessage = ErrorCodeEnum.StartDateInvalid.getMessage();
    }

    /// <summary>
    /// 结束日期错误
    /// </summary>
    public void SetEndDateInvalidReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.EndDateInvalid.getCode();
        ErrorMessage = ErrorCodeEnum.EndDateInvalid.getMessage();
    }

    /// <summary>
    /// 开始日期大于结束日期
    /// </summary>
    public void SetDateInvalidReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.DateInvalid.getCode();
        ErrorMessage = ErrorCodeEnum.DateInvalid.getMessage();
    }

    /// <summary>
    /// 排期不存在
    /// </summary>
    public void SetSessionInvalidReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.SessionInvalid.getCode();
        ErrorMessage = ErrorCodeEnum.SessionInvalid.getMessage();
    }

    /// <summary>
    /// 座位售出状态非法
    /// </summary>
    public void SetSessionSeatStatusInvalidReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.SessionSeatStatusInvalid.getCode();
        ErrorMessage = ErrorCodeEnum.SessionSeatStatusInvalid.getMessage();
    }

    /// <summary>
    /// XML解析失败
    /// </summary>
    /// <param name="ParamName"></param>
    public void SetXmlDeserializeFailReply(String ParamName)
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.XmlDeserializeFail.getCode();
        ErrorMessage = ParamName+ErrorCodeEnum.XmlDeserializeFail.getMessage();
    }

    /// <summary>
    /// 座位数量错误
    /// </summary>
    public void SetSeatCountInvalidReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.SeatCountInvalid.getCode();
        ErrorMessage = ErrorCodeEnum.SeatCountInvalid.getMessage();
    }

    /// <summary>
    /// 订单不存在或状态不合法
    /// </summary>
    public void SetOrderNotExistReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.OrderNotExist.getCode();
        ErrorMessage = ErrorCodeEnum.OrderNotExist.getMessage();
    }

    /// <summary>
    /// 会员卡支付的订单没有传入会员卡支付流水号
    /// </summary>
    public void SetMemberPaySeqNoNotExistReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.PaySeqNoNotExist.getCode();
        ErrorMessage = ErrorCodeEnum.PaySeqNoNotExist.getMessage();
    }
    /// <summary>
    /// 渠道订单号已存在
    /// </summary>
    public void SetChannelOrderCodeAlreadyExistReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.ChannelOrderCodeAlreadyExist.getCode();
        ErrorMessage = ErrorCodeEnum.ChannelOrderCodeAlreadyExist.getMessage();
    }
    /// <summary>
    /// 会员卡不存在
    /// </summary>
    public void SetMemberCardInvalidReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.MemberCardInvalid.getCode();
        ErrorMessage = ErrorCodeEnum.MemberCardInvalid.getMessage();
    }
    /// <summary>
    /// 会员卡充值类型非法
    /// </summary>
    public void SetCardChargeTypeInvalidReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.CardChargeTypeInvalid.getCode();
        ErrorMessage = ErrorCodeEnum.CardChargeTypeInvalid.getMessage();
    }
    /// <summary>
    /// 会员卡等级不存在
    /// </summary>
    public void SetCardLevelInvalidReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.CardLevelInvalid.getCode();
        ErrorMessage = ErrorCodeEnum.CardLevelInvalid.getMessage();
    }
    public void SetFilmCodeNotExistReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.FilmCodeNotExist.getCode();
        ErrorMessage = ErrorCodeEnum.FilmCodeNotExist.getMessage();
    }
    public void SetCinemaPaySettingInvalidReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.CinemaPaySettingInvalid.getCode();
        ErrorMessage = ErrorCodeEnum.CinemaPaySettingInvalid.getMessage();
    }
    public void SetCouponsNotExistOrUsedReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.CouponsNotExistOrUsed.getCode();
        ErrorMessage = ErrorCodeEnum.CouponsNotExistOrUsed.getMessage();
    }
  /// <summary>
    /// 影院小程序APPID不存在或不合法
    /// </summary>
    public void SetCinemaMiniProgramAccountNotExistReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.CinemaMiniProgramAccountNotExist.getCode();
        ErrorMessage = ErrorCodeEnum.CinemaMiniProgramAccountNotExist.getMessage();
    }
    /// <summary>
    /// 用户OpenID不存在或不合法
    /// </summary>
    public void SetOpenIDNotExistReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.OpenIDNotExist.getCode();
        ErrorMessage = ErrorCodeEnum.OpenIDNotExist.getMessage();
    }
    /// <summary>
    /// 用户手机验证码不匹配
    /// </summary>
    public void SetVerifyCodeNotMatchReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.VerifyCodeNotMatch.getCode();
        ErrorMessage = ErrorCodeEnum.VerifyCodeNotMatch.getMessage();
    }
    /// <summary>
    /// 短信发送失败
    /// </summary>
    public void SetSentMessageFailureReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.SentMessageFailure.getCode();
        ErrorMessage = ErrorCodeEnum.SentMessageFailure.getMessage();
    }
    /// <summary>
    /// 发放放映厅奖品失败
    /// </summary>
    public void SetSendGiftFailureReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.SendGiftFailure.getCode();
        ErrorMessage = ErrorCodeEnum.SendGiftFailure.getMessage();
    }
    /// <summary>
    /// 超出放映厅此奖品发放上限
    /// </summary>
    public void SetOverrunGiftReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.OverrunGift.getCode();
        ErrorMessage = ErrorCodeEnum.OverrunGift.getMessage();
    }
    /// <summary>
    /// 优惠劵数量不足
    /// </summary>
    public void SetCouponsInadequateReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.CouponsInadequate.getCode();
        ErrorMessage = ErrorCodeEnum.CouponsInadequate.getMessage();
    }
    /// <summary>
    /// 优惠劵发放失败
    /// </summary>
    public void SetCouponsSendFailureReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.CouponsSendFailure.getCode();
        ErrorMessage = ErrorCodeEnum.CouponsSendFailure.getMessage();
    }
    
    public String Status;

    public String ErrorCode;

    public String ErrorMessage;
}
