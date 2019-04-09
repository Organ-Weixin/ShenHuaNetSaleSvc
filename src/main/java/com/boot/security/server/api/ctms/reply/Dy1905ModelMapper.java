package com.boot.security.server.api.ctms.reply;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.boot.security.server.api.ctms.reply.Dy1905GetCinemaSessionResult.ResBean.SessionsBean.SessionBean.FilmsBean.FilmBean;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.Sessioninfo;

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
    ///座位信息转为entity
    public static Screenseatinfo MapToEntity(Dy1905GetScreenSeatResult.ResBean.ScreenSeatsBean.ScreenSeatBean model,Screenseatinfo entity){
    	///SeatCode GroupCode RowNum  ColumnNum XCoord YCoord Status LoveFlag Type UpdateTime SeatId
    	entity.setGroupCode(model.getSeatPieceNo());
    	entity.setSeatCode(model.getSeatNo());
    	entity.setRowNum(model.getSeatRow());
    	entity.setColumnNum(model.getSeatCol());
    	entity.setXCoord(Integer.valueOf(model.getGraphRow()));
    	entity.setYCoord(Integer.valueOf(model.getGraphCol()));
    	entity.setUpdateTime(new Date());
    	return entity;
    }
    ///影片信息转entity
    public static Filminfo MaptoEntity(Dy1905GetFeatureFilmResult.ResBean.FilmsBean.FilmBean model,Filminfo entity){
    	entity.setFilmCode(model.getFilmCode());
    	entity.setFilmName(model.getFilmName());
    	return entity;
    }
    ///影院放映计划信息转entity
    public static Sessioninfo MaptoEntity(Dy1905GetCinemaSessionResult.ResBean.SessionsBean.SessionBean model,FilmBean model2, Sessioninfo entity) throws Exception{
    	//CCode影院编码   SCode排期编码	 ScreenCode影厅编码  	StartTime开始时间  	FilmCode影片编码		FilmName影片名称
    	//Duration时长	Language语言		UpdateTime修改时间	StandardPrice标准价格	LowestPrice最低价	SettlePrice结算价
    	//TicketFee票面价	IsAvalible是否可用	PlaythroughFlag连场标志		Dimensional纬度		Sequence顺序		UserID
    	entity.setCCode(model.getCinemaNo());
    	entity.setSCode(model.getSessionNo());
    	entity.setScreenCode(model.getScreenNo());
    	entity.setStartTime(model.getStartTime());
    	entity.setFilmCode(model2.getFilmNo());
    	entity.setFilmName(model2.getFilmName());
    	String totalTime = model.getTotalTime().toString();
    	entity.setDuration(Integer.parseInt(totalTime));
    	entity.setLanguage(String.valueOf(model2.getLanguage()));
    	entity.setStandardPrice(Double.parseDouble(model.getStandardPrice()));
    	entity.setSettlePrice(Double.parseDouble(model.getSettlementPrice()));
    	entity.setTicketFee(Double.parseDouble(model.getFee()));
    	entity.setIsAvalible(model.getStatus());
    	entity.setPlaythroughFlag(model.getConsecutive());
    	return entity;
    }
}
