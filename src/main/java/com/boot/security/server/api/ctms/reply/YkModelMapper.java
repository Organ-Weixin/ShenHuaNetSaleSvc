package com.boot.security.server.api.ctms.reply;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.boot.security.server.api.ctms.reply.YkGetGoodsResult.DataBean.GoodsBean.GoodsResult;
import com.boot.security.server.apicontroller.reply.UserWXResult;
import com.boot.security.server.model.Goods;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.Ticketusers;

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
        entity.setSettlePrice(Double.parseDouble(model.getSettlePrice()==null?"0":model.getSettlePrice()));
        entity.setTicketFee(Double.parseDouble(model.getTicketFee()));
        entity.setAddFee(1.0);	//增值服务费,接口没返回，默认0
        entity.setCinemaAllowance(1.0);	//影院补贴,接口没返回，默认0
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
	
	//会员卡信息转为entity
	public static Membercard MapToEntity(com.boot.security.server.api.ctms.reply.YkGetCardDetailResult.DataBean.CardBean model,Membercard entity) throws Exception{
		entity.setMobilePhone(model.getMobile());
		entity.setLevelCode(model.getGradeId());
		entity.setLevelName(model.getGradeDesc());
		entity.setUserName(model.getCardUserName());
//		memercard.setSex();
		entity.setCreditNum(model.getIdCard()); //证件号码
//		memercard.setStatus();
		if(model.getBirthdate() != null){
			entity.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(model.getBirthdate()));
		}
		if(model.getValidateDate()!=null){ //有效期
			entity.setExpireDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getValidateDate()));
		}
		
		return entity;
	}
		
	//卖品信息转为entity
	public static Goods MapToEntity(GoodsResult model,Goods entity){
		entity.setGoodsCode(model.getGoodsId());
		entity.setGoodsName(model.getName());
		entity.setStandardPrice(new Double(model.getSalePrice()));
		entity.setSettlePrice(new Double(model.getSettlePrice()));
		entity.setGoodsPic(model.getGoodsPicUrl());
		entity.setGoodsDesc(model.getDesc());
		entity.setIsRecommand(0); 	//接口无返回，默认0
		entity.setStockCount(0);	//接口无返回，默认0
		entity.setShowSeqNo(0);		//接口无返回，默认0
		if("Y".equals(model.getIsDiscount())){	//是否享受会员卡优惠
			entity.setIsDiscount(1);
		} else {
			entity.setIsDiscount(0);
		}
		
		if(model.getIsPackage()){			//是否套餐
			entity.setIsPackage(1);
		} else {
			entity.setIsPackage(0);
		}
		return entity;
	}
	
	//用户登陆信息转为entity
	public static Ticketusers MapToEntity(UserWXResult model,Ticketusers entity){
		entity.setNickName(model.getNickName());
		entity.setSex(model.getGender());
		entity.setCountry(model.getCountry());
		entity.setProvince(model.getProvince());
		entity.setCity(model.getCity());
		entity.setHeadImgUrl(model.getAvatarUrl());
		entity.setLanguage(model.getLanguage());
		if(model.getOpenId() == null ){
			entity.setIsActive(0);
		} else {
			entity.setIsActive(1);
			entity.setCreated(new Date());
		}
		
		return entity;
	}
		
}
