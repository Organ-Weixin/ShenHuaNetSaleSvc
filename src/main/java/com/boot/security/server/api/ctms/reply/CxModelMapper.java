package com.boot.security.server.api.ctms.reply;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.boot.security.server.model.Screeninfo;

public class CxModelMapper {
	/// <summary>
    /// 影厅信息转为entity
    /// </summary>
    public static Screeninfo MapToEntity(CxQueryCinemaInfoResult.ResBean.CinemaBean.ScreensBean.ScreenVOBean model, Screeninfo entity)
    {
        entity.setSCode(model.getScreenCode());
        entity.setSName(model.getScreenName());
        entity.setSeatCount(Integer.parseInt(model.getSeatCount()));
        entity.setType(model.getType());
        //entity.setScreenId();辰星返回的是标准的影厅编码，所以不需要内部影厅编号
        entity.setUpdateTime(new Date());

        return entity;
    }
}
