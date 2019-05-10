package com.boot.security.server.apicontroller.reply;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.boot.security.server.api.core.LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat;
import com.boot.security.server.api.core.SubmitOrderQueryXml.SubmitOrderQueryXmlOrder.SubmitOrderQueryXmlSeat;
import com.boot.security.server.apicontroller.reply.PrePayOrderQueryJson.PrePayOrderQueryJsonSeat;
import com.boot.security.server.apicontroller.reply.QueryFilmReply.QueryFilmReplyFilm;
import com.boot.security.server.apicontroller.reply.QueryMemberCardByPhoneReply.QueryMemberCardByPhoneReplyMemberCardByPhone;
import com.boot.security.server.apicontroller.reply.QueryMemberCardByPhoneReply.QueryMemberCardByPhoneReplyMemberCardByPhone.QueryMemberCardByPhoneReplyPhone;
import com.boot.security.server.apicontroller.reply.QueryScreenInfoReply.QueryScreensReplyScreenInfo;
import com.boot.security.server.apicontroller.reply.QueryScreenSeatsReply.QueryScreenSeatsReplyScreenSeats;
import com.boot.security.server.apicontroller.reply.QueryScreensReply.QueryScreensReplyScreens.QueryScreensReplyScreen;
import com.boot.security.server.apicontroller.reply.QuerySessionsReply.QuerySessionsReplySessions.QuerySessionsReplySession.QuerySessionsReplyFilms.QuerySessionsReplyFilm;
import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.Filmcomments;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.Sessioninfo;

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
	
	public static QueryFilmReplyFilm MapFrom(QueryFilmReplyFilm data, Filminfo entity)
    {
        data.setFilmId(entity.getId());
        data.setFilmCode(entity.getFilmCode());
        data.setFilmName(entity.getFilmName());
        data.setVersion(entity.getVersion());
        data.setDuration(entity.getDuration());
        if(entity.getPublishDate()!=null){
        	data.setPublishDate(new SimpleDateFormat("yyyy-MM-dd").format(entity.getPublishDate()));
        }
        data.setPublisher(entity.getPublisher());
        data.setProducer(entity.getProducer());
        data.setDirector(entity.getDirector());
        data.setCast(entity.getCast());
        data.setIntroduction(entity.getIntroduction());
        data.setScore(entity.getScore());
        data.setArea(entity.getArea());
        data.setType(entity.getType());
        data.setLanguage(entity.getLanguage());
        data.setStatus(entity.getStatus());
        data.setImage(entity.getImage());
        data.setTrailer(entity.getTrailer());
        return data;
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
	public static QuerySessionsReply.QuerySessionsReplySessions.QuerySessionsReplySession MapFrom(QuerySessionsReply.QuerySessionsReplySessions.QuerySessionsReplySession session, Sessioninfo entity)
    {
        session.setScreenCode(Integer.valueOf(entity.getScreenCode()));
        session.setCode(entity.getSCode());
        session.setFeatureNo(entity.getFeatureNo());
        session.setStartTime(entity.getStartTime());
        session.setPlaythroughFlag(entity.getPlaythroughFlag());
		session.setFilms(session.new QuerySessionsReplyFilms());
		session.getFilms().setFilm(new ArrayList<QuerySessionsReplyFilm>());
		QuerySessionsReplyFilm film = session.getFilms().new QuerySessionsReplyFilm();
		film.setCode(entity.getFilmCode());
		film.setName(entity.getFilmName());
		film.setDimensional(entity.getDimensional());
		film.setDuration(entity.getDuration());
		film.setSequence(entity.getSequence());
		film.setLanguage(entity.getLanguage());
		session.getFilms().getFilm().add(film);
        session.setPrice(session.new QuerySessionsReplyPrices());
        session.getPrice().setStandardPrice(new DecimalFormat("#.00").format(entity.getStandardPrice()));
        session.getPrice().setLowestPrice(new DecimalFormat("#.00").format(entity.getLowestPrice()));
        session.getPrice().setListingPrice(entity.getStandardPrice()==null?"0":new DecimalFormat("#.00").format(entity.getStandardPrice()));
        return session;
    }
	public static QueryOrderSessionReply.QueryOrderSessionReplyOrderSession MapFrom1(QueryOrderSessionReply.QueryOrderSessionReplyOrderSession orderSession,Sessioninfo entity){
		orderSession.setSessionId(entity.getId());
		orderSession.setCCode(entity.getCCode());
		orderSession.setSCode(entity.getSCode());
		orderSession.setScreenCode(entity.getScreenCode());
		orderSession.setStartTime(String.valueOf(entity.getStartTime()));
		orderSession.setFilmCode(entity.getFilmCode());
		orderSession.setFilmName(entity.getFilmName());
		orderSession.setDuration(String.valueOf(entity.getDuration()));
		orderSession.setLanguage(entity.getLanguage());
		orderSession.setStandardPrice(String.valueOf(entity.getStandardPrice()));
		orderSession.setLowestPrice(String.valueOf(entity.getLowestPrice()));
		orderSession.setSettlePrice(String.valueOf(entity.getSettlePrice()));
		orderSession.setListingPrice(String.valueOf(entity.getListingPrice()));
		orderSession.setScreenType(entity.getDimensional());
		return orderSession;
	}
	
	public static QueryFilmCommentsReply.QueryFilmCommentsBean.QueryFilmCommentBean MapForm(QueryFilmCommentsReply.QueryFilmCommentsBean.QueryFilmCommentBean filmcomment,Filmcomments entity){
		filmcomment.setCommentId(entity.getId());
		filmcomment.setFilmCode(entity.getFilmCode());
		filmcomment.setFilmName(entity.getFilmName());
		filmcomment.setScore(entity.getScore());
		filmcomment.setCommentContent(entity.getCommentContent());
		filmcomment.setOpenID(entity.getOpenID());;
		filmcomment.setCreated(entity.getCreated());
		return filmcomment;
		
	}

	
	public static OrderView MapFrom(OrderView order, PrePayOrderQueryJson QueryJson)
    {
        order.getOrderBaseInfo().setTotalConponPrice(QueryJson.getSeats().stream().mapToDouble(PrePayOrderQueryJsonSeat::getReductionPrice).sum());
        for(Orderseatdetails seat:order.getOrderSeatDetails()){
        	List<PrePayOrderQueryJsonSeat> seatinfo = QueryJson.getSeats().stream()
					.filter((PrePayOrderQueryJsonSeat s) -> seat.getSeatCode().equals(s.getSeatCode()))
					.collect(Collectors.toList());
        	if(seatinfo!=null){
        		seat.setConponCode(seatinfo.get(0).getCouponsCode());
        		seat.setConponPrice(seatinfo.get(0).getReductionPrice());
        	}
        }
        return order;
    }
	public static QueryUserConponsReply.QueryUserConponsBeans.QueryUserConponsBean MapForm(QueryUserConponsReply.QueryUserConponsBeans.QueryUserConponsBean userConpon,Coupons entity){
		userConpon.setConponId(entity.getId());
		userConpon.setGroupCode(entity.getGroupCode());
		userConpon.setOpenID(entity.getOpenID());
		userConpon.setConponCode(entity.getCouponsCode());
		userConpon.setValidityDate(String.valueOf(entity.getExpireDate()));
		userConpon.setStatus(String.valueOf(entity.getStatus()));
		userConpon.setUseDate(String.valueOf(entity.getUsedDate()));
		userConpon.setReceivedDate(String.valueOf(entity.getReceiveDate()));
		return userConpon;
		
	}
}
