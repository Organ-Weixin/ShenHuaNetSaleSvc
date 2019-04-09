package com.boot.security.server.api.core;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.boot.security.server.api.core.LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat;
import com.boot.security.server.api.core.QueryCinemaListReply.QueryCinemaListReplyCinemas.QueryCinemaListReplyCinema;
import com.boot.security.server.api.core.QueryCinemaReply.QueryCinemaReplyCinema.QueryCinemaReplyScreen;
import com.boot.security.server.api.core.QueryFilmReply.QueryFilmReplyFilms.QueryFilmReplyFilm;
import com.boot.security.server.api.core.QuerySeatReply.QuerySeatReplyCinema.QuerySeatReplyScreen.QuerySeatReplySeat;
import com.boot.security.server.api.core.QuerySessionReply.QuerySessionReplySessions.QuerySessionReplySession;
import com.boot.security.server.api.core.QuerySessionReply.QuerySessionReplySessions.QuerySessionReplySession.QuerySessionReplyFilms;
import com.boot.security.server.api.core.QuerySessionReply.QuerySessionReplySessions.QuerySessionReplySession.QuerySessionReplyFilms.QuerySessionReplyFilm;
import com.boot.security.server.api.core.ReleaseSeatReply.ReleaseSeatReplyOrder.ReleaseSeatReplySeat;
import com.boot.security.server.api.core.QuerySessionReply.QuerySessionReplySessions.QuerySessionReplySession.QuerySessionReplyPrice;
import com.boot.security.server.api.core.SubmitOrderQueryXml.SubmitOrderQueryXmlOrder.SubmitOrderQueryXmlSeat;
import com.boot.security.server.model.CinemaTypeEnum;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.OrderStatusEnum;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.Usercinemaview;

public class ModelMapper {
	public static QueryCinemaListReplyCinema MapFrom(QueryCinemaListReplyCinema cinema, Usercinemaview userCinema)
    {
        cinema.setCode(userCinema.getCinemaCode());
        cinema.setName(userCinema.getCinemaName());
        cinema.setAddress(userCinema.getCinemaAddress());
        cinema.setType(userCinema.getCinemaType());
        return cinema;
    }
	public static QueryCinemaReplyScreen MapFrom(QueryCinemaReplyScreen screen, Screeninfo screenInfo)
    {
        screen.setCode(screenInfo.getSCode());
        screen.setName(screenInfo.getSName());
        screen.setSeatCount(screenInfo.getSeatCount()==null?0:screenInfo.getSeatCount());
        screen.setType(screenInfo.getType());
        return screen;
    }
	public static QuerySeatReplySeat MapFrom(QuerySeatReplySeat seat, Screenseatinfo seatInfo)
    {
        seat.setCode(seatInfo.getSeatCode());
        seat.setGroupCode(seatInfo.getGroupCode());
        seat.setRowNum(seatInfo.getRowNum());
        seat.setColumnNum(seatInfo.getColumnNum());
        seat.setXCoord(seatInfo.getXCoord());
        seat.setYCoord(seatInfo.getYCoord());
        seat.setStatus(seatInfo.getStatus());
        seat.setLoveFlag(seatInfo.getLoveFlag());
        return seat;
    }
	public static QueryFilmReplyFilm MapFrom(QueryFilmReplyFilm film, Filminfo entity)
    {
        film.setCast(entity.getFilmCode());
        film.setName(entity.getFilmName());
        film.setVersion(entity.getVersion());
        film.setDuration(entity.getDuration());
        film.setPublishDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(entity.getPublishDate()));
        film.setPublisher(entity.getPublisher());
        film.setProducer(entity.getProducer());
        film.setDirector(entity.getDirector());
        film.setCast(entity.getCast());
        film.setIntroduction(entity.getIntroduction());
        return film;
    }
	public static QuerySessionReplySession MapFrom(QuerySessionReplySession session, Sessioninfo entity)
    {
        session.setScreenCode(entity.getScreenCode());
        session.setCode(entity.getSCode());
        session.setFeatureNo(entity.getFeatureNo());
        session.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(entity.getStartTime()));
        session.setPlaythroughFlag(entity.getPlaythroughFlag());

        session.Films =session.new QuerySessionReplyFilms();
        QuerySessionReplyFilm film =session.Films.new QuerySessionReplyFilm();
        film.setCode(entity.getFilmCode());
        film.setName(entity.getFilmName());
        film.setDimensional(entity.getDimensional());
        film.setDuration(entity.getDuration().toString());
        film.setSequence(entity.getSequence().toString());
        film.setLanguage(entity.getLanguage());
        session.Films.getFilm().add(film);

        session.Price = session.new QuerySessionReplyPrice();
        session.Price.setStandardPrice(new DecimalFormat("#.00").format(entity.getStandardPrice()));
        session.Price.setLowestPrice(new DecimalFormat("#.00").format(entity.getLowestPrice()));
        session.Price.setListingPrice(entity.getStandardPrice()==null?"0":new DecimalFormat("#.00").format(entity.getStandardPrice()));
        return session;
    }
	
	public static OrderView MapFrom(OrderView order, Usercinemaview userCinema,
            LockSeatQueryXml queryXmlObj, Sessioninfo sessionInfo)
        {
            //订单基本信息
		Orders orderBaseInfo = new Orders();
            orderBaseInfo.setCinemaCode(userCinema.getCinemaCode());
            orderBaseInfo.setUserId(userCinema.getUserId());
            orderBaseInfo.setSessionCode(sessionInfo.getSCode());
            orderBaseInfo.setScreenCode(sessionInfo.getScreenCode());
            orderBaseInfo.setSessionTime(sessionInfo.getStartTime());
            orderBaseInfo.setFilmCode(sessionInfo.getFilmCode());
            orderBaseInfo.setFilmName(sessionInfo.getFilmName());
            orderBaseInfo.setTicketCount(queryXmlObj.Order.Count);
            orderBaseInfo.setTotalPrice(queryXmlObj.Order.Seat.stream().mapToDouble(LockSeatQueryXmlSeat::getPrice).sum());
            orderBaseInfo.setTotalFee(queryXmlObj.Order.Seat.stream().mapToDouble(LockSeatQueryXmlSeat::getFee).sum());
            orderBaseInfo.setOrderStatus(OrderStatusEnum.Created.getStatusCode());
            orderBaseInfo.setCreated(new Date());
            if (userCinema.getCinemaType() == CinemaTypeEnum.ManTianXing.getTypeCode())
            {
                //数据库中会员及非会员支付类型以逗号分隔存于PayType字段中，会员在前
                if (queryXmlObj.Order.PayType == "1")
                {
                    orderBaseInfo.setIsMemberPay(1);
                    orderBaseInfo.setPayType(userCinema.getPayType().split(",")[0]);
                }
                else
                {
                    orderBaseInfo.setIsMemberPay(0);
                    orderBaseInfo.setPayType(userCinema.getPayType().split(",")[1]);
                }
            }
            order.setOrderBaseInfo(orderBaseInfo);
            List<Orderseatdetails> seats=null;
            for(LockSeatQueryXmlSeat xmlseat:queryXmlObj.Order.Seat){
            	Orderseatdetails seat=new Orderseatdetails();
            	seat.setSeatCode(xmlseat.getSeatCode());
            	seat.setPrice(xmlseat.getPrice());
            	seat.setFee(xmlseat.getFee());
            	seat.setCreated(new Date());
            	seats.add(seat);
            }
            order.setOrderSeatDetails(seats);
            return order;
        }
	
	public static OrderView MapFrom(OrderView order, SubmitOrderQueryXml queryXmlObj)
    {
        order.getOrderBaseInfo().setTotalPrice(queryXmlObj.Order.Seat.stream().mapToDouble(SubmitOrderQueryXmlSeat::getPrice).sum());
        order.getOrderBaseInfo().setTotalSalePrice(queryXmlObj.Order.Seat.stream().mapToDouble(SubmitOrderQueryXmlSeat::getRealPrice).sum());
        order.getOrderBaseInfo().setTotalFee(queryXmlObj.Order.Seat.stream().mapToDouble(SubmitOrderQueryXmlSeat::getFee).sum());
        order.getOrderBaseInfo().setMobilePhone(queryXmlObj.Order.MobilePhone);
        if (order.getOrderBaseInfo().getIsMemberPay()==1)
        {
            order.getOrderBaseInfo().setPaySeqNo(queryXmlObj.Order.PaySeqNo);
        }
        for(Orderseatdetails seat :order.getOrderSeatDetails()){
        	SubmitOrderQueryXmlSeat seatinfo = (SubmitOrderQueryXmlSeat) queryXmlObj.Order.Seat.stream().filter((SubmitOrderQueryXmlSeat s) -> s.getSeatCode()==seat.getSeatCode()).collect(Collectors.toList());
        	if(seatinfo!=null){
        		seat.setPrice(seatinfo.getPrice());
        		seat.setSalePrice(seatinfo.getRealPrice());
        		seat.setFee(seatinfo.getFee());
        	}
        }
        return order;
    }
}
