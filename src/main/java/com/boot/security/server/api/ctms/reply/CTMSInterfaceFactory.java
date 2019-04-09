package com.boot.security.server.api.ctms.reply;

import com.boot.security.server.model.Usercinemaview;

/// <summary>
/// 影院票务管理接口工厂
/// </summary>
public class CTMSInterfaceFactory {
	/// <summary>
    /// 根据影院系统类型创建相应接口
    /// </summary>
	public static ICTMSInterface Create(Usercinemaview userCinema)
    {
        switch (userCinema.getCinemaType())
        {
            case 2:
                return new CxInterface();
            default:
                return new DefaultCTMSInterface();
        }
    }

}
