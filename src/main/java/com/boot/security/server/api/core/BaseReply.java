package com.boot.security.server.api.core;

import com.boot.security.server.api.ctms.reply.CTMSBaseReply;
import com.boot.security.server.model.ErrorCodeEnum;
import com.boot.security.server.model.StatusEnum;

public class BaseReply { 
	public static String ID_QueryCinemaListReply = "ID_QueryCinemaListReply";
	public static String ID_QueryCinemaReply = "ID_QueryCinemaReply";
	public static String ID_QuerySeatReply="ID_QuerySeatReply";
	public static String ID_QueryFilmReply="ID_QueryFilmReply";
	public static String ID_QuerySessionReply="ID_QuerySessionReply";
	public static String ID_QuerySessionSeatReply="ID_QuerySessionSeatReply";
	public static String ID_LockSeatReply="ID_LockSeatReply";
	public static String ID_ReleaseSeatReply="ID_ReleaseSeatReply";
	public static String ID_SubmitOrderReply="ID_SubmitOrderReply";
	public static String ID_QueryPrintReply="ID_QueryPrintReply";
	public static String ID_RefundTicketReply="ID_RefundTicketReply";
	public static String ID_QueryOrderReply="ID_QueryOrderReply";
	public static String ID_QueryTicketReply="ID_QueryTicketReply";
	public static String ID_FetchTicketReply="ID_FetchTicketReply";
	public static String ID_LoginCardReply="ID_LoginCardReply";
	public static String ID_QueryCardReply="ID_QueryCardReply";
	public static String ID_QueryDiscountReply="ID_QueryDiscountReply";
	public static String ID_CardPayReply="ID_CardPayReply";
	public static String ID_CardPayBackReply="ID_CardPayBackReply";
	public static String ID_QueryCardTradeRecordReply="ID_QueryCardTradeRecordReply";
	public static String ID_CardChargeReply="ID_CardChargeReply";
	public static String ID_QueryCardLevelReply="ID_QueryCardLevelReply";
	public static String ID_CardRegisterReply="ID_CardRegisterReply";
	public static String ID_QueryGoodsReply="ID_QueryGoodsReply";
	public static String ID_CreateGoodsOrderReply="ID_CreateGoodsOrderReply";
	public static String ID_SubmitGoodsOrderReply="ID_SubmitGoodsOrderReply";
	public static String ID_QueryGoodsOrderReply="ID_QueryGoodsOrderReply";
	public static String ID_RefundGoodsReply="ID_RefundGoodsReply";
	
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
    public void GetErrorFromCTMSReply(CTMSBaseReply CTMSReply)
    {
        Status = CTMSReply.Status.getStatusCode();
        ErrorCode = CTMSReply.ErrorCode;
        ErrorMessage = CTMSReply.ErrorMessage;
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
    //卖品数量非法
    public void SetGoodsCountInvalidReply()
    {
        Status = StatusEnum.Failure.getStatusCode();
        ErrorCode = ErrorCodeEnum.GoodsCountInvalid.getCode();
        ErrorMessage = ErrorCodeEnum.GoodsCountInvalid.getMessage();
    }
	
    public String Status;

    public String ErrorCode;

    public String ErrorMessage;

    public String Id;
}
