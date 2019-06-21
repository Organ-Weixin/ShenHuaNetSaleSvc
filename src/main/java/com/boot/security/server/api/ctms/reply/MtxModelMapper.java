package com.boot.security.server.api.ctms.reply;

import java.text.ParseException;
import java.util.Date;

import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.LoveFlagEnum;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Sessioninfo;

public class MtxModelMapper {
	 public static Screeninfo MapToEntity(MtxGetHallResult.ResBean.HallsBean.HallBean model, Screeninfo entity)
     {
         entity.setSCode(model.getHallNo());
         entity.setSName(model.getHallName());
         entity.setType(model.getHallType());
         entity.setUpdateTime(new Date());
         return entity;
     }
	 //影厅对应的所有座位信息转为entity
	 public static Screenseatinfo MapToEntity(MtxGetHallAllSeatResult.HallAllSeatBean model,Screenseatinfo entity)
	 {
		 entity.setSeatCode(model.getSeatNo());
		 entity.setRowNum(model.getSeatRow());
		 entity.setColumnNum(model.getSeatCol());
		 entity.setXCoord(Integer.valueOf(model.getGraphRow()));
		 entity.setYCoord(Integer.valueOf(model.getGraphCol()));
		 entity.setGroupCode(model.getSeatPieceNo());
		 if("0".equals(model.getLeftCount()) && "1".equals(model.getRightCount())){
			 entity.setLoveFlag(LoveFlagEnum.LEFT.getFlagCode());	//情侣左座
		 } else if("1".equals(model.getLeftCount()) && "0".equals(model.getRightCount())){
			 entity.setLoveFlag(LoveFlagEnum.RIGHT.getFlagCode());	//情侣右座
		 } else {
			 entity.setLoveFlag(LoveFlagEnum.Normal.getFlagCode());
		 }
		 entity.setUpdateTime(new Date());
		return entity; 
	 }
	 //对应影院对应日期的排期转为entity
	 public static Sessioninfo MapToEntity(MtxGetCinemaPlanResult.ResBean.CinemaPlansBean.CinemaPlanBean model,Sessioninfo entity) throws ParseException
	 {
		 entity.setCCode(model.getPlaceNo());
		 entity.setSCode(model.getFeatureAppNo()); //排期号
		 entity.setScreenCode(model.getHallNo());
		 entity.setFeatureNo(model.getFeatureNo());
		 entity.setFilmCode(model.getFilmNo());
		 entity.setFilmName(model.getFilmName());
		 entity.setLanguage(model.getCopyLanguage());
		 entity.setLowestPrice(model.getProtectPrice());
		 entity.setStandardPrice(model.getStandPric());
		 entity.setSettlePrice(Double.valueOf(model.getAppPric()));
		 entity.setTicketFee((double) 0);
		 entity.setPlaythroughFlag("N");
		 entity.setSequence(1);
		 entity.setAddFee(0.0);
		 entity.setCinemaAllowance(0.0);
		 entity.setUpdateTime(new Date());
		 return entity;
	 }
	 
}
