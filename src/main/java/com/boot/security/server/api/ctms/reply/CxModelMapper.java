package com.boot.security.server.api.ctms.reply;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.boot.security.server.api.ctms.reply.CxQueryPlanInfoByDatePeriodResult.ResBean.CinemaPlansBean.CinemaPlanBean.FilmsBean.FilmBean;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Goods;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.utils.FilmCodeUtil;

public class CxModelMapper {
    /// 影厅信息转为entity
    public static Screeninfo MapToEntity(CxQueryCinemaInfoResult.ResBean.CinemaBean.ScreensBean.ScreenVOBean model, Screeninfo entity)
    {
        entity.setSCode(model.getScreenCode());
        entity.setSName(model.getScreenName());
        entity.setSeatCount(Integer.parseInt(model.getSeatCount()));
        entity.setType(model.getType());
        //entity.setScreenId();辰星返回的是标准的影厅编码，所以不需要内部影厅编号
        entity.setUpdateTime(new Date());
        return entity;
    }
    public static Screenseatinfo MapToEntity(CxQuerySeatInfoResult.ResBean.ScreenSitesBean.ScreenSiteBean model, Screenseatinfo entity)
    {
        entity.setSeatCode(model.getSeatCode());
        entity.setGroupCode(model.getGroupCode());
        entity.setRowNum(model.getRowNum());
        entity.setColumnNum(model.getColumnNum());
        entity.setXCoord(model.getXCoord());
        entity.setYCoord(model.getYCoord());
        entity.setStatus(model.getStatus());
        entity.setUpdateTime(new Date());
        return entity;
    }
    public static Filminfo MapToEntity(CxQueryFilmInfoByDatePeriodResult.ResBean.FilmInfoVOsBean.FilmInfoVOBean model, Filminfo entity) throws ParseException
    {
        entity.setFilmCode(model.getFilmCode());
        entity.setFilmName(model.getFilmName());
        entity.setVersion(model.getVersion());
        entity.setDuration(model.getDuration().toString());
        if(model.getPublishDate()!=null){
        	entity.setPublishDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getPublishDate()));
        }
        entity.setPublisher(model.getPublisher());
        entity.setProducer(model.getProducer());
        entity.setDirector(model.getDirector());
        entity.setCast(model.getCast());
        entity.setIntroduction(model.getIntroduction());
        return entity;
    }
    public static Sessioninfo MapToEntity(CxQueryPlanInfoByDatePeriodResult.ResBean.CinemaPlansBean.CinemaPlanBean model, Sessioninfo entity) throws Exception
    {
        entity.setScreenCode(model.getScreenCode());
        entity.setSCode(model.getFeatureAppNo());
        entity.setStartTime(model.getStartTime());

        FilmBean filmInfo=model.getFilms().getFilm();
        if(filmInfo!=null){
        	entity.setFilmCode(filmInfo.getFilmCode());
        	entity.setFilmName(filmInfo.getFilmName());
        	entity.setDuration(filmInfo.getDuration());
        	entity.setLanguage(filmInfo.getLang());
        	entity.setDimensional(FilmCodeUtil.GetFilmDimensional(filmInfo.getFilmCode()));
        	entity.setSequence(filmInfo.getSequence());
        }
        entity.setStandardPrice(model.getPrice().getStandardPrice());
        entity.setLowestPrice(model.getPrice().getLowestPrice());
        entity.setIsAvalible(1);
        entity.setPlaythroughFlag(model.getPlaythroughFlag());
        entity.setListingPrice(model.getPrice().getListingPrice());
        entity.setSettlePrice((double) 0);
        entity.setTicketFee((double) 0);
        entity.setMarketingCode(model.getMarketingCode());
        entity.setMarketingName(model.getMarketingName());
        entity.setAddFee(model.getPrice().getServiceAddFee());
        entity.setCinemaAllowance(model.getPrice().getCinemaAllowance());
        return entity;
    }
    
    public static Goods MapToEntity(CxQueryMerchandiseResult.ResBean.MersBean.MerBean model,Goods entity){
    	entity.setGoodsCode(model.getMerUid());
    	entity.setGoodsName(model.getMerName());
    	entity.setGoodsType(String.valueOf(model.getMerTypeId()));
    	entity.setStandardPrice(model.getListingPrice().doubleValue());
    	entity.setSettlePrice(model.getSettlePrice().doubleValue());
    	entity.setStockCount(9999);
    	entity.setGoodsDesc(model.getMerDesc());
    	entity.setShowSeqNo(model.getShowSeqNo());
    	entity.setIsDiscount(0);
    	entity.setGoodsStatus(0);
    	entity.setIsRecommand(0);
    	entity.setIsPackage(0);
    	entity.setUpdated(new Date());
    	return entity;
    }
}
