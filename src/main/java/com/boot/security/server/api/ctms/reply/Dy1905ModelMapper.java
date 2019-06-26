package com.boot.security.server.api.ctms.reply;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.boot.security.server.api.ctms.reply.Dy1905GetCinemaAllSessionResult.ResBean.SessionsBean.SessionBean.FilmsBean.SessionFilmBean;
import com.boot.security.server.model.Goods;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.model.Membercardlevel;
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
    	entity.setGroupCode(model.getBindNo());
    	entity.setSeatCode(model.getSeatNo());
    	entity.setRowNum(model.getSeatRow());
    	entity.setColumnNum(model.getSeatCol());
    	entity.setXCoord(Integer.valueOf(model.getGraphCol()));
    	entity.setYCoord(Integer.valueOf(model.getGraphRow()));
    	entity.setUpdateTime(new Date());
    	return entity;
    }
    ///影院放映计划信息转entity
    public static Sessioninfo MaptoEntity(Dy1905GetCinemaAllSessionResult.ResBean.SessionsBean.SessionBean model, Sessioninfo entity) throws Exception{
    	//CCode影院编码   SCode排期编码	 ScreenCode影厅编码  	StartTime开始时间  	FilmCode影片编码		FilmName影片名称
    	//Duration时长	Language语言		UpdateTime修改时间	StandardPrice标准价格	LowestPrice最低价	SettlePrice结算价
    	//TicketFee票面价	IsAvalible是否可用	PlaythroughFlag连场标志		Dimensional纬度		Sequence顺序		UserID
    	entity.setCCode(model.getCinemaNo());
    	entity.setSCode(model.getSessionNo());
    	//entity.setScreenCode(model.getScreenNo());
    	String dt1 = new SimpleDateFormat("yyyy-MM-dd").format(model.getSessionDate());;
        String dt2 = new SimpleDateFormat("HH:mm").format(model.getStartTime());
        String dt = dt1 +" "+dt2;
    	entity.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dt));
    	SessionFilmBean filmInfo = model.getFilms().getFilm().get(0);
    	if(filmInfo!=null){
    		entity.setFilmCode(filmInfo.getFilmNo());
    		entity.setFilmName(filmInfo.getFilmName());
    		entity.setLanguage(filmInfo.getLanguage());
    		entity.setDimensional(filmInfo.getFilmType());
    		entity.setSequence(1);
    	}
    	String totalTime = model.getTotalTime().toString();
    	entity.setDuration(Integer.parseInt(totalTime));
    	entity.setStandardPrice(model.getSettlementPrice());
    	entity.setLowestPrice(model.getLowestPrice());;
    	entity.setSettlePrice(model.getSettlementPrice());
    	entity.setTicketFee((double) 0);
    	entity.setAddFee((double) 0);
    	entity.setCinemaAllowance((double) 0);
    	entity.setIsAvalible(Integer.valueOf(model.getStatus()));
    	entity.setPlaythroughFlag(model.getConsecutive());
    	entity.setUpdateTime(new Date());
    	return entity;
    }
    
    //会员卡信息转entity
    public static Membercard MaptoEntity(Dy1905MakeMemberCardResult.ResBean.CardInfoBean model,Membercard entity) throws ParseException{
    	entity.setCardNo(model.getCardNo());
    	entity.setBalance(model.getBalance());
    	if(model.getExpireDate()!=null){
    		Date ExpireDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.valueOf(model.getExpireDate()) * 1000)));  
    		entity.setExpireDate(ExpireDate);
    	}
    	if(model.getCreateTime()!=null){
    		Date CreateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.valueOf(model.getCreateTime()) * 1000)));  
    		entity.setCreateTime(CreateTime);
    	}
    	return entity;
    }
    //会员卡等级信息转entity
    public static Membercardlevel MaptoEntity(Dy1905MemberTypeListResult.ResBean.TypesBean.TypeBean.LevelsBean.LevelBean model,Membercardlevel entity){
    	entity.setLevelCode(model.getLevelNo());
    	entity.setLevelName(model.getLevelName());
    	return entity;
    }
    //卖品信息转entity
    public static Goods MaptoEntity(Dy1905GoodsListResult.ResBean.GoodsBean.GoodBean model, Goods entity){
    	entity.setGoodsCode(model.getSerial());
    	entity.setGoodsName(model.getName());
    	if(model.getPrice()!=null){
    		entity.setStandardPrice(Double.valueOf(model.getPrice()));
    		entity.setSettlePrice(Double.valueOf(model.getPrice()));
    	}
    	entity.setStockCount(model.getStockCount() ==null?0 : Integer.valueOf(model.getStockCount()));
    	entity.setGoodsDesc(model.getDetail());
    	entity.setUpdated(new Date());
    	return entity;
    }
}
