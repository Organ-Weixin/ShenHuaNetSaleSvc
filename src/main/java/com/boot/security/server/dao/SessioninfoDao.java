package com.boot.security.server.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Priceplan;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.Userinfo;

@Mapper
public interface SessioninfoDao {
	
	 @Select("select * from sessioninfo t where t.id = #{id}")
	 Sessioninfo getById(Long id);
	 
	 @Select("select * from sessioninfo t where t.userid=#{userid} and t.ccode = #{cinemacode} and t.scode=#{sessioncode}")
	 Sessioninfo getBySessionCode(@Param("userid")Long userid,@Param("cinemacode")String cinemacode,@Param("sessioncode")String sessioncode);
	 
	 @Select("select * from sessioninfo t where t.userid=#{userid} and t.ccode = #{cinemacode} and t.starttime>=#{StartDate} and t.starttime<=#{EndDate}")
	 List<Sessioninfo> getByCinemaCodeAndDate(@Param("userid")Long userid,@Param("cinemacode")String cinemacode,@Param("StartDate")Date StartDate,@Param("EndDate")Date EndDate);
	 
	 @Delete("delete from sessioninfo where userid=#{userid} and ccode = #{cinemacode} and starttime>=#{StartDate} and starttime<=#{EndDate}")
	 int deleteByCinemaCodeAndDate(@Param("userid")Long userid,@Param("cinemacode")String cinemacode,@Param("StartDate")Date StartDate,@Param("EndDate")Date EndDate);
	 
	//通过影院编码、开始时间查询排期
	@Select("select * from sessioninfo where CCode = #{ccode} and Date(StartTime) > #{StartTime}")
	List<Sessioninfo> getByCCode(@Param("ccode")String ccode,@Param("StartTime")Date StartTime);
	
	//通过影院编码、日期、删除排期
	int deleteByCinemaCode(@Param("params")Map<String, Object> params);
	
	//通过影院编码获取影片信息
	List<Sessioninfo> getFilms(@Param("params")Map<String, Object> params);
	
	//通过影院编码、排期编码、用户id查询影片信息
	@Select("select * from sessioninfo t where t.ccode = #{cinemacode} and t.scode = #{sessioncode} and t.userID = #{userid}")
	Sessioninfo getByCinemaCodeAndSessionCodeAndUserId(@Param("cinemacode")String cinemacode,@Param("sessioncode")String sessioncode,@Param("userid")Long userid);
	
	//分组查询，去除重复数据
    @Select("select * from sessioninfo t where t.UserID=#{userId} and t.CCode = #{cinemacode} and t.StartTime>=#{StartDate} and t.StartTime<=#{EndDate} GROUP BY FilmName")
    List<Sessioninfo> getByCCodeGroupByFilm(@Param("userId") Long userId,@Param("cinemacode") String cinemacode,@Param("StartDate") Date StartDate,@Param("EndDate") Date EndDate);
    
    int update(Sessioninfo sessioninfo);

    @Delete("delete from sessioninfo where id = #{id}")
    int delete(Long id);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(#{CCode}, #{SCode}, #{ScreenCode}, #{StartTime}, #{FilmCode}, #{FilmName}, #{Duration}, #{Language}, #{UpdateTime}, #{StandardPrice}, #{LowestPrice}, #{SettlePrice}, #{TicketFee}, #{IsAvalible}, #{PlaythroughFlag}, #{Dimensional}, #{Sequence}, #{UserID}, #{ListingPrice}, #{FeatureNo}, #{SessionId}, #{SessionKey}, #{InternalUpdateTime})")
    int save(Sessioninfo sessioninfo);
    
    int count(@Param("params") Map<String, Object> params);
    
    int countSession(@Param("params") Map<String, Object> params);

    List<Sessioninfo> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from priceplan where CinemaCode=#{CinemaCode} and Code=#{Code} and UserID=#{UserID}")
    Priceplan selectPrice(Priceplan priceplan);
    
    //新增价格数据
    @Insert("insert into priceplan (CinemaCode,Code,UserID,Price,Type) values (#{CinemaCode},#{Code},#{UserID},#{Price},#{Type})")
    int addPriceplan(Priceplan priceplan);
    int updatePriceplan(Priceplan priceplan);
    
    //获取渠道
    @Select("select * from userinfo where IsDel='0'")
    List<Userinfo> getCompany();
}
