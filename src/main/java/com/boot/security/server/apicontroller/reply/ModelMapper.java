package com.boot.security.server.apicontroller.reply;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.boot.security.server.apicontroller.reply.PrePayOrderQueryJson.PrePayOrderQueryJsonSeat;
import com.boot.security.server.apicontroller.reply.QueryFilmReply.QueryFilmReplyFilm;
import com.boot.security.server.apicontroller.reply.QueryGoodsOrderReply.QueryGoodsOrderReplyOrder;
import com.boot.security.server.apicontroller.reply.QueryGoodsOrderReply.QueryGoodsOrderReplyOrder.QueryGoodsOrderReplyGoodsList;
import com.boot.security.server.apicontroller.reply.QueryGoodsOrderReply.QueryGoodsOrderReplyOrder.QueryGoodsOrderReplyGoodsList.QueryGoodsOrderReplyGoods;
import com.boot.security.server.apicontroller.reply.QueryGoodsReply.QueryGoodsReplyGoodss.QueryGoodsReplyGoods;
import com.boot.security.server.apicontroller.reply.QueryGoodsTypeReply.QueryGoodsTypeReplyTypes.QueryGoodsTypeReplyType;
import com.boot.security.server.apicontroller.reply.QueryLocalGoodsOrderReply.QueryLocalGoodsOrderReplyOrder;
import com.boot.security.server.apicontroller.reply.QueryLocalGoodsOrderReply.QueryLocalGoodsOrderReplyOrder.QueryLocalGoodsOrderReplyGoodsList;
import com.boot.security.server.apicontroller.reply.QueryLocalGoodsOrderReply.QueryLocalGoodsOrderReplyOrder.QueryLocalGoodsOrderReplyGoodsList.QueryLocalGoodsOrderReplyGoods;
import com.boot.security.server.apicontroller.reply.QueryMemberCardByPhoneReply.QueryMemberCardByPhoneReplyMemberCardByPhone;
import com.boot.security.server.apicontroller.reply.QueryScreenInfoReply.QueryScreensReplyScreenInfo;
import com.boot.security.server.apicontroller.reply.QueryScreenSeatsReply.QueryScreenSeatsReplyScreenSeats;
import com.boot.security.server.apicontroller.reply.QueryScreensReply.QueryScreensReplyScreens.QueryScreensReplyScreen;
import com.boot.security.server.apicontroller.reply.QueryUsingConponsReply.ConponData.ConponBean;
import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.Couponsgroup;
import com.boot.security.server.model.Filmcomments;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Goods;
import com.boot.security.server.model.GoodsOrderStatusEnum;
import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodsorderdetails;
import com.boot.security.server.model.Goodstype;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.Ticketusers;
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
        data.setStatus(entity.getStatus()==1?"通过":"未审核");
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
		if(entity.getExpireDate()!=null){
			membercard.setExpireDate(new SimpleDateFormat("yyyy-MM-dd").format(entity.getExpireDate()));
		}
		if(entity.getStatus()!=null){
			membercard.setStatus(String.valueOf(entity.getStatus()));
		}else{
			membercard.setStatus("0");
		}
		return membercard;
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

	public static QueryUserConponsReply.QueryUserConponsBeans.QueryUserConponsBean MapForm(QueryUserConponsReply.QueryUserConponsBeans.QueryUserConponsBean userConpon,Coupons entity){
		userConpon.setConponId(entity.getId());
		userConpon.setGroupCode(entity.getGroupCode());
		userConpon.setOpenID(entity.getOpenID());
		userConpon.setConponCode(entity.getCouponsCode());
		userConpon.setStatus(String.valueOf(entity.getStatus()));
		userConpon.setUseDate(String.valueOf(entity.getUsedDate()));
		return userConpon;
		
	}
	
	public static ConponBean MapFrom(Couponsgroup model, ConponBean entity) {
		entity.setGroupCode(model.getGroupCode());
		entity.setCouponsType(model.getCouponsType().toString());
		entity.setCouponsName(model.getCouponsName());
		entity.setEffectiveDate(model.getEffectiveDate()==null?"":new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(model.getEffectiveDate()));
		entity.setExpireDate(model.getExpireDate()==null?"":new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(model.getExpireDate()));
		entity.setReductionType(model.getReductionType());
		entity.setReductionPrice(model.getReductionPrice());
		entity.setIsShare(model.getIsShare());
		entity.setStatus(model.getStatus().toString());
		entity.setRemainingNumber(model.getRemainingNumber());
		entity.setRemark(model.getRemark());
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
		if(model.getOpenId() != null ){
			entity.setCreated(new Date());
			entity.setBirthday(new Date());
		}
		return entity;
	}
	
	public static QueryGoodsTypeReplyType MapFrom(QueryGoodsTypeReply.QueryGoodsTypeReplyTypes.QueryGoodsTypeReplyType type,Goodstype entity){
		type.setTypeId(entity.getId());
		type.setCinemaCode(entity.getCinemaCode());
		type.setUserId(entity.getUserId());
		type.setTypeCode(entity.getTypeCode());
		type.setTypeName(entity.getTypeName());
		type.setTypeDesc(entity.getTypeDesc());
		type.setTypePic(entity.getTypePic());
		return type;
	}
	
	public static QueryGoodsReplyGoods MapFrom(QueryGoodsReplyGoods goods,Goods entity){
		goods.setGoodsId(entity.getId());
		goods.setCinemaCode(entity.getCinemaCode());
		goods.setUserId(entity.getUserId());
		goods.setGoodsCode(entity.getGoodsCode());
		goods.setGoodsName(entity.getGoodsName());
		goods.setGoodsType(entity.getGoodsType());
		goods.setStandardPrice(entity.getStandardPrice());
		goods.setSettlePrice(entity.getSettlePrice());
		goods.setGoodsPic(entity.getGoodsPic());
		goods.setStockCount(entity.getStockCount());
		goods.setGoodsDesc(entity.getGoodsDesc());
		goods.setUnitName(entity.getUnitName());
		goods.setShowSeqNo(entity.getShowSeqNo()==null?0:entity.getShowSeqNo());
		goods.setIsDiscount(entity.getIsDiscount()==1?"是":"否");
		goods.setGoodsStatus(entity.getGoodsStatus()==1?"上架":"下架");
		goods.setIsRecommand(entity.getIsRecommand()==1?"是":"否");
		goods.setIsPackage(entity.getIsPackage()==1?"是":"否");
		return goods;
	}
	
	public static QueryLocalGoodsOrderReplyOrder MapFrom(QueryLocalGoodsOrderReplyOrder order,GoodsOrderView ov){
		if(ov.getOrderBaseInfo()!=null){
			order.setCinemaCode(ov.getOrderBaseInfo().getCinemaCode());
			order.setLocalOrderCode(ov.getOrderBaseInfo().getLocalOrderCode());
			order.setOrderStatus(GoodsOrderStatusEnum.CastToEnum(ov.getOrderBaseInfo().getOrderStatus()).getStatusName());
			order.setTotalPrice(ov.getOrderBaseInfo().getTotalPrice());
			order.setTotalSettlePrice(ov.getOrderBaseInfo().getTotalSettlePrice());
			order.setTotalFee(ov.getOrderBaseInfo().getTotalFee());
			order.setCreated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ov.getOrderBaseInfo().getCreated()));
			order.setGoodsCount(ov.getOrderBaseInfo().getGoodsCount());
			order.setDeliveryType(ov.getOrderBaseInfo().getDeliveryType());
			order.setDeliveryAddress(ov.getOrderBaseInfo().getDeliveryAddress());
			order.setDeliveryTime(ov.getOrderBaseInfo().getDeliveryTime());
			order.setOpenID(ov.getOrderBaseInfo().getOpenID());
		}
		order.setGoodsList(new QueryLocalGoodsOrderReplyGoodsList());
		order.getGoodsList().setGoods(new ArrayList<QueryLocalGoodsOrderReplyGoods>());
		for(Goodsorderdetails orderdetail:ov.getOrderGoodsDetails()){
			QueryLocalGoodsOrderReplyGoods replygoods=new QueryLocalGoodsOrderReplyGoods();
			replygoods.setGoodsCode(orderdetail.getGoodsCode());
			replygoods.setGoodsName(orderdetail.getGoodsName());
			replygoods.setStandardPrice(orderdetail.getStandardPrice());
			replygoods.setSettlePrice(orderdetail.getSettlePrice());
			replygoods.setChannelFee(orderdetail.getChannelFee());
			replygoods.setGoodsCount(orderdetail.getGoodsCount());
			replygoods.setIsPackage(orderdetail.getIsPackage()==1?"是":"否");
			replygoods.setGoodsDetail(orderdetail.getGoodsDetail());
			if(orderdetail.getShowSeqNo()!=null){
				replygoods.setShowSeqNo(orderdetail.getShowSeqNo());
			}
			order.getGoodsList().getGoods().add(replygoods);
		}
		return order;
		
	}
	
	public static QueryGoodsOrderReplyOrder MapFrom(QueryGoodsOrderReplyOrder order,GoodsOrderView ov){
		System.out.println(ov.getOrderBaseInfo().getCinemaCode());
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		order.setCinemaCode(ov.getOrderBaseInfo().getCinemaCode());
		order.setLocalOrderCode(ov.getOrderBaseInfo().getLocalOrderCode());
		order.setOrderCode(ov.getOrderBaseInfo().getOrderCode());
		order.setPickUpCode(ov.getOrderBaseInfo().getPickUpCode());
		order.setVerifyCode(ov.getOrderBaseInfo().getVerifyCode());
		order.setOrderStatus(GoodsOrderStatusEnum.CastToEnum(ov.getOrderBaseInfo().getOrderStatus()).getStatusName());
		order.setTotalPrice(ov.getOrderBaseInfo().getTotalPrice());
		order.setTotalSettlePrice(ov.getOrderBaseInfo().getTotalSettlePrice());
		order.setTotalFee(ov.getOrderBaseInfo().getTotalFee());
		if(ov.getOrderBaseInfo().getSubmitTime()!=null){
			order.setSubmitTime(dateformat.format(ov.getOrderBaseInfo().getSubmitTime()));
		}
		if(ov.getOrderBaseInfo().getCreated()!=null){
			order.setCreated(dateformat.format(ov.getOrderBaseInfo().getCreated()));
		}
		order.setMobilePhone(ov.getOrderBaseInfo().getMobilePhone());
		order.setGoodsCount(ov.getOrderBaseInfo().getGoodsCount());
		if(ov.getOrderBaseInfo().getRefundTime()!=null){
			order.setRefundTime(dateformat.format(ov.getOrderBaseInfo().getRefundTime()));
		}
		if(ov.getOrderBaseInfo().getPickUpTime()!=null){
			order.setPickUpTime(dateformat.format(ov.getOrderBaseInfo().getPickUpTime()));
		}
		if(ov.getOrderBaseInfo().getDeliveryType()!=null){
			order.setDeliveryType(ov.getOrderBaseInfo().getDeliveryType().toString());
		}
		order.setDeliveryAddress(ov.getOrderBaseInfo().getDeliveryAddress());
		order.setDeliveryTime(ov.getOrderBaseInfo().getDeliveryTime());
		if(ov.getOrderBaseInfo().getOrderPayFlag()!=null){
			order.setOrderPayFlag(ov.getOrderBaseInfo().getOrderPayFlag()==1?"已支付":"未支付");
		}
		if(ov.getOrderBaseInfo().getOrderPayType()!=null){
			order.setOrderPayType(ov.getOrderBaseInfo().getOrderPayType().toString());
		}
		if(ov.getOrderBaseInfo().getOrderPayTime()!=null){
			order.setOrderPayTime(dateformat.format(ov.getOrderBaseInfo().getOrderPayTime()));
		}
		order.setOrderTradeNo(ov.getOrderBaseInfo().getOrderTradeNo());
		order.setCardNo(ov.getOrderBaseInfo().getCardNo());
		order.setCardPassword(ov.getOrderBaseInfo().getCardPassword());
		order.setOpenID(ov.getOrderBaseInfo().getOpenID());
		order.setGoodsList(new QueryGoodsOrderReplyGoodsList());
		order.getGoodsList().setGoods(new ArrayList<QueryGoodsOrderReplyGoods>());
		for(Goodsorderdetails orderdetail:ov.getOrderGoodsDetails()){
			QueryGoodsOrderReplyGoods replygoods=new QueryGoodsOrderReplyGoods();
			replygoods.setGoodsCode(orderdetail.getGoodsCode());
			replygoods.setGoodsName(orderdetail.getGoodsName());
			replygoods.setStandardPrice(orderdetail.getStandardPrice());
			replygoods.setSettlePrice(orderdetail.getSettlePrice());
			replygoods.setChannelFee(orderdetail.getChannelFee());
			replygoods.setGoodsCount(orderdetail.getGoodsCount());
			if(orderdetail.getIsPackage()!=null){
				replygoods.setIsPackage(orderdetail.getIsPackage()==1?"是":"否");
			}
			replygoods.setGoodsDetail(orderdetail.getGoodsDetail());
			if(orderdetail.getShowSeqNo()!=null){
				replygoods.setShowSeqNo(orderdetail.getShowSeqNo());
			}
			order.getGoodsList().getGoods().add(replygoods);
		}
		return order;
		
	}
}
