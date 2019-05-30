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
    @Insert("insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(#{CCode}, #{SCode}, #{ScreenCode}, #{StartTime}, #{FilmCode}, #{FilmName}, #{Duration}, #{Language}, #{UpdateTime}, #{StandardPrice}, #{LowestPrice}, #{SettlePrice}, #{TicketFee},#{AddFee},#{CinemaAllowance}, #{IsAvalible}, #{PlaythroughFlag}, #{Dimensional}, #{Sequence}, #{UserID}, #{ListingPrice}, #{FeatureNo}, #{SessionId}, #{SessionKey}, #{InternalUpdateTime})")
    int save(Sessioninfo sessioninfo);
    
    int count(@Param("params") Map<String, Object> params);
    
    int countSession(@Param("params") Map<String, Object> params);

    List<Sessioninfo> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from sessioninfo where find_in_set(ccode,#{cinemacodes}) and starttime >= NOW() group by filmcode")
    List<Sessioninfo> getFilmsByCinemaCode(String cinemacodes);
    
    ////////
    @Select("select * from sessioninfo t where t.ccode=#{cinemacode} and t.scode = #{sessioncode}")
	Sessioninfo getSessionCode(@Param("cinemacode")String cinemacode,@Param("sessioncode")String sessioncode);
	 
	 ////
	@Select("select * from sessioninfo t where t.ccode = #{cinemacode} and t.starttime>=#{StartDate} and t.starttime<=#{EndDate}")
    List<Sessioninfo> getByCinemaStartDateEndDate(@Param("cinemacode")String cinemacode,@Param("StartDate")String StartDate,@Param("EndDate")String EndDate);
	
	//查询第三方场次价格
    List<Sessioninfo> getByCinemafilm(@Param("cinemacode")String cinemacode, @Param("filmcode")String filmcode);

    //小程序-新分组查询电影排期
    @Select("select * from sessioninfo t where t.CCode = #{cinemacode} and t.StartTime>=#{startDate} and t.StartTime<=#{endDate} GROUP BY filmcode")
    List<Sessioninfo> getByFilmName(@Param("cinemacode") String cinemacode,@Param("startDate") String startDate,@Param("endDate") String endDate);
    
    //根据影院编码和影片编码查询排期
	@Select("select * from sessioninfo t where t.ccode = #{cinemacode} and t.filmcode=#{filmcode} order by startTime asc")
    List<Sessioninfo> getByCinemaCodeAndFilmCode(@Param("cinemacode") String cinemacode,@Param("filmcode") String filmcode);
	
	@Select("select * from sessioninfo t where t.ccode = #{cinemacode} and t.filmcode=#{filmcode} and t.starttime >= #{startdate} and t.starttime <= #{enddate}")
	List<Sessioninfo> getByCinemaCodeAndFilmCodeAndTime(@Param("cinemacode") String cinemacode,@Param("filmcode") String filmcode,@Param("startdate") String startdate,@Param("enddate") String enddate);
	
	@Select("select * from sessioninfo t where t.ccode = #{cinemacode} and t.filmcode=#{filmcode} and t.starttime >= #{startdate} and t.starttime <= #{enddate} group by substr(t.starttime,1,10)")
	List<Sessioninfo> getSessionDate(@Param("cinemacode") String cinemacode,@Param("filmcode") String filmcode,@Param("startdate") String startdate,@Param("enddate") String enddate);
	
	@Select("select * from sessioninfo t where t.ccode = #{cinemacode} and t.filmcode = #{filmcode} and substr(t.starttime,1,10) = #{sessiondate} order by t.starttime asc")
	List<Sessioninfo> getOneDaySession(@Param("cinemacode") String cinemacode,@Param("filmcode") String filmcode,@Param("sessiondate")String sessiondate);
}
