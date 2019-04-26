package com.boot.security.server.apicontroller.reply;

import java.text.SimpleDateFormat;

import com.boot.security.server.apicontroller.reply.QueryMemberCardByPhoneReply.QueryMemberCardByPhoneReplyMemberCardByPhone;
import com.boot.security.server.apicontroller.reply.QueryMemberCardByPhoneReply.QueryMemberCardByPhoneReplyMemberCardByPhone.QueryMemberCardByPhoneReplyPhone;
import com.boot.security.server.apicontroller.reply.QueryScreenInfoReply.QueryScreensReplyScreenInfo;
import com.boot.security.server.apicontroller.reply.QueryScreenSeatsReply.QueryScreenSeatsReplyScreenSeats;
import com.boot.security.server.apicontroller.reply.QueryScreensReply.QueryScreensReplyScreens.QueryScreensReplyScreen;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;

public class ModelMapper {
	public static QueryScreensReplyScreen MapFrom(QueryScreensReplyScreen screen, Screeninfo entity)
    {
        screen.setScreenId(entity.getId());
        screen.setCinemaCode(entity.getCCode());
        screen.setScreenCode(entity.getSCode());
        screen.setScreenName(entity.getSName());
        if(entity.getSeatCount()!=null){
        	screen.setSeatCount(entity.getSeatCount());
        }
        screen.setType(entity.getType());
        return screen;
    }
	public static QueryScreensReplyScreenInfo MapFrom(QueryScreensReplyScreenInfo screeninfo, Screeninfo entity){
		screeninfo.setScreenId(entity.getId());
		screeninfo.setCinemaCode(entity.getCCode());
		screeninfo.setScreenCode(entity.getSCode());
		screeninfo.setScreenName(entity.getSName());
		if(entity.getSeatCount()!=null){
			screeninfo.setSeatCount(entity.getSeatCount());
		}
		screeninfo.setType(entity.getType());
		return screeninfo;
	}
	public static QueryScreenSeatsReplyScreenSeats.QueryScreenSeatsReplyScreenSeat MapFrom(QueryScreenSeatsReplyScreenSeats.QueryScreenSeatsReplyScreenSeat screenSeat, Screenseatinfo entity){
		screenSeat.setSeatId(entity.getId());
		screenSeat.setCinemaCode(entity.getCinemaCode());
		screenSeat.setScreenCode(entity.getScreenCode());
		screenSeat.setSeatCode(entity.getSeatCode());
		screenSeat.setGroupCode(entity.getGroupCode());
		screenSeat.setRowNum(entity.getRowNum());
		screenSeat.setColumnNum(entity.getColumnNum());
		screenSeat.setXCoord(entity.getXCoord());
		screenSeat.setYCoord(entity.getYCoord());
		screenSeat.setStatus(entity.getStatus());
		screenSeat.setLoveFlag(entity.getLoveFlag());
		if(entity.getType()!=null){
			screenSeat.setType(entity.getType());
		}
		return screenSeat;
	}
	public static QueryMemberCardByPhoneReplyMemberCardByPhone.QueryMemberCardByPhoneReplyPhone MapFrom(QueryMemberCardByPhoneReplyMemberCardByPhone.QueryMemberCardByPhoneReplyPhone membercard, Membercard entity){
		
		membercard.setMemberPhoneId(entity.getId());
		membercard.setCinemaCode(entity.getCinemaCode());
		membercard.setOpenID(String.valueOf(entity.getOpenId()));
		membercard.setMobilePhone(entity.getMobilePhone());
		membercard.setCardNo(entity.getCardNo());
		membercard.setCardPassword(entity.getCardPassword());
		membercard.setBalance(Float.valueOf(String.valueOf(entity.getBalance())));
		if(entity.getScore()!=null){
			membercard.setScore(entity.getScore());
		}
		membercard.setLevelCode(entity.getLevelCode());
		membercard.setLevelName(entity.getLevelName());
		membercard.setUserName(entity.getUserName());
		if(entity.getSex()!=null){
			if(entity.getSex().equals("0")){
				membercard.setSex("女");
			}
			if(entity.getSex().equals("1")){
				membercard.setSex("男");
			}
		}
		if(entity.getCreditNum()!=null){
			membercard.setCreditNum(entity.getCreditNum());
		}
		if(entity.getBirthday()!=null){
			membercard.setBirthday(new SimpleDateFormat("yyyy-MM-dd").format(entity.getBirthday()));
		}
		membercard.setExpireDate(new SimpleDateFormat("yyyy-MM-dd").format(entity.getExpireDate()));
		if(entity.getStatus().equals("0")){
			membercard.setStatus("未绑定");
		}
		if(entity.getStatus().equals("1")){
			membercard.setStatus("已绑定");
		}
		return membercard;
	}
}
