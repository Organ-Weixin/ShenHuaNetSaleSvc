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

import com.boot.security.server.model.Sessioninfo;

@Mapper
public interface SessioninfoDao {
	
	 @Select("select * from sessioninfo t where t.id = #{id}")
	 Sessioninfo getById(Long id);
	 
	 @Select("select * from sessioninfo t where t.userid=#{userid} and t.ccode = #{cinemacode} and t.scode=#{sessioncode}")
	 Sessioninfo getBySessionCode(@Param("userid")Long userid,@Param("cinemacode")String cinemacode,@Param("sessioncode")String sessioncode);
	 
	 @Select("select * from sessioninfo t where t.userid=#{userid} and t.ccode = #{cinemacode} and t.starttime>=#{StartDate} and t.starttime<=#{EndDate}")
	 List<Sessioninfo> getByCinemaCodeAndDate(@Param("userid")Long userid,@Param("cinemacode")String cinemacode,@Param("StartDate")Date StartDate,@Param("EndDate")Date EndDate);
	 
	 @Delete("delete from sessioninfo t where t.userid=#{userid} and t.ccode = #{cinemacode} and t.starttime>=#{StartDate} and t.starttime<=#{EndDate}")
	 int deleteByCinemaCodeAndDate(@Param("userid")Long userid,@Param("cinemacode")String cinemacode,@Param("StartDate")Date StartDate,@Param("EndDate")Date EndDate);
	 
	//通过影院编码、开始时间查询排期
	@Select("select * from sessioninfo where CCode = #{ccode} and Date(StartTime) > #{StartTime}")
	List<Sessioninfo> getByCCode(@Param("ccode")String ccode,@Param("StartTime")Date StartTime);
	
	//通过影院编码、开始时间删除排期
	@Delete("delete from sessioninfo where CCode = #{ccode} and Date(StartTime) > #{StartTime}")
	int delete(@Param("ccode")String ccode,@Param("StartTime")Date StartTime);
	
	//通过影院编码、开始时间、结束时间获取影片信息
	List<Sessioninfo> getFilms(@Param("CCode")String CCode,@Param("StartTime")Date StartTime,@Param("EndTime")Date EndTime);
	
	//通过影院编码、排期编码、用户id查询影片信息
	@Select("select * from sessioninfo t where t.ccode = #{cinemacode} and t.scode = #{sessioncode} and t.userID = #{userid}")
	Sessioninfo getByCinemaCodeAndSessionCodeAndUserId(@Param("cinemacode")String cinemacode,@Param("sessioncode")String sessioncode,@Param("userid")Long userid);
    
    int update(Sessioninfo sessioninfo);
    //增加
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into sessioninfo(Id, CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(#{Id}, #{CCode}, #{SCode}, #{ScreenCode}, #{StartTime}, #{FilmCode}, #{FilmName}, #{Duration}, #{Language}, #{UpdateTime}, #{StandardPrice}, #{LowestPrice}, #{SettlePrice}, #{TicketFee}, #{IsAvalible}, #{PlaythroughFlag}, #{Dimensional}, #{Sequence}, #{UserID}, #{ListingPrice}, #{FeatureNo}, #{SessionId}, #{SessionKey}, #{InternalUpdateTime})")
    int save(Sessioninfo sessioninfo);
    
    int count(@Param("params") Map<String, Object> params);

    List<Sessioninfo> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
