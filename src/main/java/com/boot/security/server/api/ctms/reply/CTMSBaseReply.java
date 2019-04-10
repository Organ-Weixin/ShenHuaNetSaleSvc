package com.boot.security.server.api.ctms.reply;

import com.boot.security.server.model.StatusEnum;

public class CTMSBaseReply {
	/// <summary>
    /// 返回状态
    /// </summary>
    public StatusEnum Status;

    /// <summary>
    /// 返回错误代码
    /// </summary>
    public String ErrorCode;

    /// <summary>
    /// 返回错误信息
    /// </summary>
    public String ErrorMessage;
    
    /// <summary>
    /// 鼎新获取影院Id时返回错误信息
    /// </summary>
    public void GetDingXinCinemaNotValidReply()
    {
        Status = StatusEnum.Failure;
        ErrorCode = "-1";
        ErrorMessage = "鼎新系统不存在该影院或鼎新未对当前合作伙伴开通该影院的权限";
    }
    /// <summary>
    /// 电影1905获取影院Id时返回错误信息
    /// </summary>
    public void GetDy1905CinemaNotValidReply()
    {
        Status = StatusEnum.Failure;
        ErrorCode = "-1";
        ErrorMessage = "电影1905不存在该影院或电影1905未对当前合作伙伴开通该影院的权限";
    }
    /// <summary>
    /// 凤凰佳影获取影院Id时返回错误信息
    /// </summary>
    public void GetYkCinemaNotValidReply()
    {
        Status = StatusEnum.Failure;
        ErrorCode = "-1";
        ErrorMessage = "凤凰佳影不存在该影院或凤凰佳影未对当前合作伙伴开通该影院的权限";
    }
}
