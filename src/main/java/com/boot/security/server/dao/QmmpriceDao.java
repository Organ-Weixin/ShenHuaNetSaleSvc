package com.boot.security.server.dao;


import java.util.List;
import java.util.Map;

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
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into qmmprice(cinemaCode, cinemaName, cinemaId, screenName, filmId, filmName, dataType, dataName, showId, showTime, price, settlePrice, minPrice, updated) values(#{cinemaCode}, #{cinemaName}, #{cinemaId}, #{screenName}, #{filmId}, #{filmName}, #{dataType}, #{dataName}, #{showId}, #{showTime}, #{price}, #{settlePrice}, #{minPrice}, #{updated})")
    int save(Qmmprice qmmprice);
    
    //根据趣满满场次id查询
    @Select("select * from qmmprice t where t.showId = #{showId}")
    Qmmprice getByShowId(String showId);
}
