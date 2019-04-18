package com.boot.security.server.api.ctms.reply;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.SessionSeat;
import com.boot.security.server.model.SessionSeatStatusEnum;
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
		 entity.setPlaythroughFlag("No");
		 
		 Date startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(model.getFeatureDate() + " " + model.getFeatureTime());
		 Date endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(model.getFeatureDate() + " " + model.getTotalTime());
		 entity.setStartTime(startTime);
		 entity.setDuration((int)(endTime.getTime()-startTime.getTime())/1000/60);	
		 entity.setDimensional("3D");
		 entity.setSequence(1);
		 entity.setAddFee(0.0);
		 entity.setCinemaAllowance(0.0);
		 entity.setUpdateTime(new Date());
		 return entity;
	 }

	 
	 
}
