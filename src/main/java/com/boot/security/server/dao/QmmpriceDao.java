package com.boot.security.server.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Qmmprice;

@Mapper
public interface QmmpriceDao {
	int count(@Param("params") Map<String, Object> params);

    List<Qmmprice> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select * from qmmprice t where t.id = #{id}")
    Qmmprice getById(Long id);

    int update(Qmmprice qmmprice);
    
    @Delete("delete from qmmprice where id = #{id}")
    int delete(Long id);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into qmmprice(cinemaCode, cinemaName, cinemaId, screenName, filmId, filmName, dataType, dataName, showId, showTime, price, settlePrice, minPrice, updated) values(#{cinemaCode}, #{cinemaName}, #{cinemaId}, #{screenName}, #{filmId}, #{filmName}, #{dataType}, #{dataName}, #{showId}, #{showTime}, #{price}, #{settlePrice}, #{minPrice}, #{updated})")
    int save(Qmmprice qmmprice);
    
    //根据趣满满场次id查询
    @Select("select * from qmmprice t where t.showId = #{showId}")
    Qmmprice getByShowId(String showId);
    
    @Select("select * from qmmprice t where t.cinemacode = #{cinemacode} and t.screenName = #{screenname} and t.showtime = #{showtime}")
    List<Qmmprice> getByCinemaCodeAndScreenName(@Param("cinemacode") String cinemacode,@Param("screenname") String screenname,@Param("showtime") String showtime);
    
    @Select("select * from qmmprice t where t.cinemacode = #{cinemacode} and t.screenName = #{screenname} and t.showtime = #{showtime} and t.dataType = #{datatype}")
    Qmmprice getByCinemaCodeAnddatatype(@Param("cinemacode") String cinemacode,@Param("screenname") String screenname,@Param("showtime") String showtime,@Param("datatype") String datatype);
    
    //查询所有第三方平台
    @Select("select * from qmmprice group by dataType")
    List<Qmmprice> getDataType();
}
