package com.boot.security.server.api.ctms.reply;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.boot.security.server.api.ctms.reply.YkGetSchedulesResult.dataBean.ScheduleBean.filmBean;
import com.boot.security.server.model.Sessioninfo;

public class YkModelMapper {
	public static Sessioninfo MapToEntity(YkGetSchedulesResult.dataBean.ScheduleBean model, Sessioninfo entity) throws ParseException
    {
        entity.setScreenCode(model.getHallId());
        entity.setSCode(model.getSessionCode());
        entity.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(model.getShowDateTime()));
        if(model.getFilm()!=null)
        {
        	entity.setFilmCode(model.getFilm().getFilmCode());
            entity.setFilmName(model.getFilm().getName());
            entity.setDuration(Integer.parseInt(model.getFilm().getDuration()));
            entity.setLanguage(model.getFilm().getLanguage());
            entity.setDimensional(model.getFilm().getDimensional());
        }
        entity.setStandardPrice(Double.parseDouble(model.getStandardPrice()));
        entity.setLowestPrice(Double.parseDouble(model.getLowestPrice()));
        entity.setIsAvalible(1);
        entity.setPlaythroughFlag(model.getThroughStatus());
        entity.setSequence(1);
        //entity.setSettlePrice(SettlePrice);
        entity.setTicketFee(Double.parseDouble(model.getTicketFee()));
        //粤科新增字段(内部排期号)
        entity.setSessionId(model.getScheduleId());
        entity.setSessionKey(model.getScheduleKey());
        return entity;
    }

}
