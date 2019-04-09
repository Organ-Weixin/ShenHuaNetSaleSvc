package com.boot.security.server.api.ctms.reply;

import java.util.Date;

import com.boot.security.server.model.Screeninfo;

public class Dy1905ModelMapper {
    /// 影厅信息转为entity
    public static Screeninfo MapToEntity(Dy1905GetScreenResult.ResBean.ScreensBean.ScreenBean model, Screeninfo entity)
    {
        entity.setSCode(model.getScreenCode());
        entity.setSName(model.getScreenName());
        entity.setScreenId(model.getScreenNo());
        entity.setType(model.getScreenType());
        entity.setUpdateTime(new Date());
        return entity;
    }
}
