package com.boot.security.server.api.core;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.boot.security.server.api.core.CreateGoodsOrderQueryXml.CreateGoodsOrderQueryXmlGoodsList.CreateGoodsOrderQueryXmlGoods;
import com.boot.security.server.api.core.QueryCinemaListReply.QueryCinemaListReplyCinemas.QueryCinemaListReplyCinema;
import com.boot.security.server.api.core.QueryCinemaReply.QueryCinemaReplyCinema.QueryCinemaReplyScreen;
import com.boot.security.server.api.core.QueryFilmReply.QueryFilmReplyFilms.QueryFilmReplyFilm;
import com.boot.security.server.api.core.QueryGoodsReply.QueryGoodsReplyGoodss.QueryGoodsReplyGoods;
import com.boot.security.server.api.core.QuerySeatReply.QuerySeatReplyCinema.QuerySeatReplyScreen.QuerySeatReplySeat;
import com.boot.security.server.api.core.QuerySessionReply.QuerySessionReplySessions.QuerySessionReplySession;
import com.boot.security.server.api.core.QuerySessionReply.QuerySessionReplySessions.QuerySessionReplySession.QuerySessionReplyFilms.QuerySessionReplyFilm;
import com.boot.security.server.model.CinemaTypeEnum;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Goods;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.LoveFlagEnum;
import com.boot.security.server.model.OrderPayTypeEnum;
import com.boot.security.server.model.OrderStatusEnum;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.Usercinemaview;

public class ModelMapper {
	public static QueryCinemaListReplyCinema MapFrom(QueryCinemaListReplyCinema cinema, Usercinemaview userCinema) {
		cinema.setCode(userCinema.getCinemaCode());
		cinema.setName(userCinema.getCinemaName());
		cinema.setAddress(userCinema.getCinemaAddress());
		cinema.setType(userCinema.getCinemaType());
		return cinema;
	}

	public static QueryCinemaReplyScreen MapFrom(QueryCinemaReplyScreen screen, Screeninfo screenInfo) {
		screen.setCode(screenInfo.getSCode());
		screen.setName(screenInfo.getSName());
		screen.setSeatCount(screenInfo.getSeatCount() == null ? 0 : screenInfo.getSeatCount());
		screen.setType(screenInfo.getType());
		return screen;
	}

	public static QuerySeatReplySeat MapFrom(QuerySeatReplySeat seat, Screenseatinfo seatInfo) {
		seat.setCode(seatInfo.getSeatCode());
		seat.setGroupCode(seatInfo.getGroupCode());
		seat.setRowNum(seatInfo.getRowNum());
		seat.setColumnNum(seatInfo.getColumnNum());
		seat.setXCoord(seatInfo.getXCoord());
		seat.setYCoord(seatInfo.getYCoord());
		seat.setStatus(seatInfo.getStatus());
		seat.setLoveFlag(LoveFlagEnum.CastToEnum(seatInfo.getLoveFlag()).toString());
		return seat;
	}

	public static QueryFilmReplyFilm MapFrom(QueryFilmReplyFilm film, Filminfo entity) {
		film.setCode(entity.getFilmCode());
		film.setName(entity.getFilmName());
		film.setVersion(entity.getVersion());
		film.setDuration(entity.getDuration());
		if (entity.getPublishDate() != null) {
			film.setPublishDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(entity.getPublishDate()));
		}
		film.setPublisher(entity.getPublisher());
		film.setProducer(entity.getProducer());
		film.setDirector(entity.getDirector());
		film.setCast(entity.getCast());
		film.setIntroduction(entity.getIntroduction());
		return film;
	}

	public static QuerySessionReplySession MapFrom(QuerySessionReplySession session, Sessioninfo entity) {
		session.setScreenCode(entity.getScreenCode());
		session.setCode(entity.getSCode());
		session.setFeatureNo(entity.getFeatureNo());
		session.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(entity.getStartTime()));
		session.setPlaythroughFlag(entity.getPlaythroughFlag());
		// session.setPlaythroughFlag(StatusEnum.valueOf(entity.getPlaythroughFlag()));

		session.setFilms(session.new QuerySessionReplyFilms());
		session.getFilms().Film = new ArrayList<QuerySessionReplyFilm>();
		QuerySessionReplyFilm film = session.getFilms().new QuerySessionReplyFilm();
		film.setCode(entity.getFilmCode());
		film.setName(entity.getFilmName());
		film.setDimensional(entity.getDimensional());
		film.setDuration(String.valueOf(entity.getDuration()));
		film.setSequence(String.valueOf(entity.getSequence()));
		film.setLanguage(entity.getLanguage());
		session.getFilms().Film.add(film);

		session.setPrice(session.new QuerySessionReplyPrice());
		session.getPrice().setStandardPrice(new DecimalFormat("#.00").format(entity.getStandardPrice()));
		session.getPrice().setLowestPrice(new DecimalFormat("#.00").format(entity.getLowestPrice()));
		session.getPrice().setListingPrice(
				entity.getStandardPrice() == null ? "0" : new DecimalFormat("#.00").format(entity.getStandardPrice()));
		return session;
	}

	public static Orders MapFrom(Orders order, Usercinemaview userCinema, LockSeatQueryXml queryXmlObj,
			Sessioninfo sessionInfo) {
		// 订单基本信息
		order.setCinemaCode(userCinema.getCinemaCode());
		order.setUserId(userCinema.getUserId());
		order.setMinimumFare(sessionInfo.getLowestPrice());//在订单里保存一下场次最低价
		order.setSessionCode(sessionInfo.getSCode());
		order.setScreenCode(sessionInfo.getScreenCode());
		order.setSessionTime(sessionInfo.getStartTime());
		order.setFilmCode(sessionInfo.getFilmCode());
		order.setFilmName(sessionInfo.getFilmName());
		order.setTicketCount(queryXmlObj.getOrder().getCount());
		order.setOrderStatus(OrderStatusEnum.Created.getStatusCode());
		order.setCreated(new Date());
		order.setDeleted(0); // 订单删除标识
		order.setIsMemberPay(Integer.valueOf(queryXmlObj.getOrder().getPayType()));
		if (userCinema.getCinemaType() == CinemaTypeEnum.ManTianXing.getTypeCode()) {
			// 数据库中会员及非会员支付类型以逗号分隔存于PayType字段中，会员在前
			if ("1".equals(queryXmlObj.getOrder().getPayType())) {
				order.setIsMemberPay(1);
				order.setPayType(userCinema.getPayType().split(",")[0]);
			} else {
				order.setIsMemberPay(0);
				order.setPayType(userCinema.getPayType().split(",")[1]);
			}
		}
		return order;
	}

	public static OrderView MapFrom(OrderView order, SubmitOrderQueryXml queryXmlObj) {
		order.getOrderBaseInfo().setMobilePhone(queryXmlObj.getOrder().getMobilePhone());
		order.getOrderBaseInfo().setUpdated(new Date());
		if (order.getOrderBaseInfo().getIsMemberPay() == 1) {
			order.getOrderBaseInfo().setPaySeqNo(queryXmlObj.getOrder().getPaySeqNo());
		}
		return order;
	}

	//混合下单-购票部分
	public static OrderView MapFrom(OrderView order, SubmitMixOrderQueryXml queryXmlObj) {
		order.getOrderBaseInfo().setMobilePhone(queryXmlObj.getMobilePhone());
		order.getOrderBaseInfo().setUpdated(new Date());
		if (order.getOrderBaseInfo().getIsMemberPay() == 1) {
			order.getOrderBaseInfo().setPaySeqNo(queryXmlObj.getPaySeqNo());
		}
		return order;
	}
	
	public static QueryGoodsReplyGoods MapFrom(QueryGoodsReplyGoods goods, Goods entity) {
		goods.setCinemaCode(entity.getCinemaCode());
		goods.setGoodsCode(entity.getGoodsCode());
		goods.setGoodsDesc(entity.getGoodsDesc());
		goods.setGoodsId(entity.getId());
		goods.setGoodsKey(entity.getGoodsKey());
		goods.setGoodsName(entity.getGoodsName());
		goods.setGoodsPic(entity.getGoodsPic());
		if(entity.getGoodsStatus()!=null){
			goods.setGoodsStatus(entity.getGoodsStatus() == 1 ? "Up" : "Down");
		}
		if(entity.getGoodsType()!=null){
			goods.setGoodsType(entity.getGoodsType().toString());
		}
		goods.setIsDiscount(entity.getIsDiscount());
		goods.setIsPackage(entity.getIsPackage());
		goods.setIsRecommand(entity.getIsRecommand());
		if(entity.getSettlePrice()!=null){
			goods.setSettlePrice(entity.getSettlePrice().floatValue());
		}
		if(entity.getShowSeqNo()!=null){
			goods.setShowSeqNo(entity.getShowSeqNo());
		}
		if(entity.getStandardPrice()!=null){
			goods.setStandardPrice(entity.getStandardPrice().floatValue());
		}
		goods.setStockCount(entity.getStockCount());
		goods.setUnitName(entity.getUnitName());
		goods.setUserId(entity.getUserId().longValue());
		return goods;
	}

	public static Goodsorders MapFrom(Goodsorders order, Usercinemaview userCinema,
			CreateGoodsOrderQueryXml queryXmlObj) {
		// 订单基本信息
		order.setCinemaCode(userCinema.getCinemaCode());
		order.setUserId(userCinema.getUserId());
		order.setLocalOrderCode(UUID.randomUUID().toString().replace("-", ""));
		order.setTotalPrice(0D);//先设0，外层循环修改
		order.setTotalFee(0D);//先设0，外层循环修改
		order.setCreated(new Date());
		order.setGoodsCount(queryXmlObj.getGoodsList().getGoods().stream()
				.mapToInt(CreateGoodsOrderQueryXmlGoods::getGoodsCount).sum());
		order.setOrderStatus(OrderStatusEnum.Created.getStatusCode());
		if (userCinema.getCinemaType() == CinemaTypeEnum.ManTianXing.getTypeCode()) {
			// 数据库中会员及非会员支付类型以逗号分隔存于PayType字段中，会员在前
			if ("1".equals(queryXmlObj.getPayType())) {
				order.setPayType(userCinema.getPayType().split(",")[0]);
			} else {
				order.setPayType(userCinema.getPayType().split(",")[1]);
			}
		}
		return order;
	}
	
	public static Goodsorders MapFrom(Goodsorders order, SubmitGoodsOrderQueryXml queryXmlObj) {
		order.setMobilePhone(queryXmlObj.getMobilePhone());
		order.setUpdated(new Date());
		if (order.getOrderPayType() != null && OrderPayTypeEnum.MemberCardPay.getTypeCode() == order.getOrderPayType()) {
			order.setPaySeqNo(queryXmlObj.getPaySeqNo());
		}
		return order;
	}
	
	//混合下单-卖品部分
	public static Goodsorders MapFrom(Goodsorders order, SubmitMixOrderQueryXml queryXmlObj) {
		order.setMobilePhone(queryXmlObj.getMobilePhone());
		order.setCardNo(queryXmlObj.getCardNo());
		order.setCardPassword(queryXmlObj.getCardPassword());
		order.setUpdated(new Date());
		if (order.getOrderPayType() != null && OrderPayTypeEnum.MemberCardPay.getTypeCode() == order.getOrderPayType()) {
			order.setPaySeqNo(queryXmlObj.getPaySeqNo());
		}
		return order;
	}
}
