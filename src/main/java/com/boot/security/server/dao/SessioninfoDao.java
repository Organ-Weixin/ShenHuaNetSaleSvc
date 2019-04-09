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
    Sessioninfo getBySessionCode(Long UserId,String cinemacode,String sessioncode);
    
    @Select("select * from sessioninfo t where t.userid=#{userid} and t.ccode = #{cinemacode} and t.starttime>=#{StartDate} and t.starttime<=#{EndDate}")
    List<Sessioninfo> getByCinemaCodeAndDate(Long userid,String cinemacode,Date StartDate,Date EndDate);

    @Delete("delete from sessioninfo where id = #{id}")
    int delete(Long id);
    
    @Delete("delete from sessioninfo t where t.userid=#{userid} and t.ccode = #{cinemacode} and t.starttime>=#{StartDate} and t.starttime<=#{EndDate}")
    int deleteByCinemaCodeAndDate(Long userid,String cinemacode,Date StartDate,Date EndDate);

    int update(Sessioninfo sessioninfo);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into sessioninfo(Id, CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(#{Id}, #{CCode}, #{SCode}, #{ScreenCode}, #{StartTime}, #{FilmCode}, #{FilmName}, #{Duration}, #{Language}, #{UpdateTime}, #{StandardPrice}, #{LowestPrice}, #{SettlePrice}, #{TicketFee}, #{IsAvalible}, #{PlaythroughFlag}, #{Dimensional}, #{Sequence}, #{UserID}, #{ListingPrice}, #{FeatureNo}, #{SessionId}, #{SessionKey}, #{InternalUpdateTime})")
    int save(Sessioninfo sessioninfo);
    
    int count(@Param("params") Map<String, Object> params);

    List<Sessioninfo> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
