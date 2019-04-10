package com.boot.security.server.api.ctms.reply;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.Sessioninfo;

public class YkModelMapper {

	//排期信息
	public static Sessioninfo MapToEntity(YkGetSchedulesResult.dataBean.ScheduleBean model, Sessioninfo entity) throws ParseException {
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
        entity.setSettlePrice(Double.parseDouble(model.getSettlePrice()));
        entity.setTicketFee(Double.parseDouble(model.getTicketFee()));
        entity.setIsAvalible(1);
        entity.setPlaythroughFlag(model.getThroughStatus());
        entity.setSequence(1);
        entity.setUpdateTime(new Date());
        //粤科新增字段(内部排期号)
        entity.setSessionId(model.getScheduleId());
        entity.setSessionKey(model.getScheduleKey());
        return entity;
    }
	
	//影厅信息转为entity
	public static Screeninfo ScreenMapToEntity(YkGetCinemasResult.DataBean.YkCinema.Halls model,Screeninfo entity){
		entity.setSName(model.getName());
		entity.setSCode(model.getHallId());
		entity.setSeatCount(model.getSeatCount());
		entity.setType(model.getType());
		entity.setUpdateTime(new Date());
		return entity;
	}
	
	//座位信息转为entify
	public static Screenseatinfo SeatMapToEntity(YkGetSeatsResult.DataBean.CinemaBean.SeatPlan.Sections.Seats model,Screenseatinfo entity){
		entity.setSeatCode(model.getSeatId());
		entity.setRowNum(model.getRowId());
		entity.setColumnNum(model.getColumnId());
		entity.setXCoord(model.getX());
		entity.setYCoord(model.getY());
		entity.setUpdateTime(new Date());
		entity.setType(model.getType());
		if("L".equals(model.getType()) || "R".equals(model.getType())){
			entity.setLoveFlag(model.getType());
		} else {
			entity.setLoveFlag("N");
		}
		
		if("Y".equals(model.getDamage())){	//座位状态：已损坏
			entity.setStatus("Unavailable");
		} else {
			entity.setStatus("Available");
		}
		
		return entity;
	}
	
}
