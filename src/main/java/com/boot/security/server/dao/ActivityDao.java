package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Activity;

@Mapper
public interface ActivityDao {

    @Select("select * from activity t where t.id = #{id}")
    Activity getById(Long id);

    @Delete("delete from activity where id = #{id}")
    int delete(Long id);

    int update(Activity activity);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into activity(Id, CinemaCode, Title, Image, ActivityContent, StartDate, EndDate, LinkUrl, GradeCode, ActivitySequence, Status) values(#{Id}, #{CinemaCode}, #{Title}, #{Image}, #{ActivityContent}, #{StartDate}, #{EndDate}, #{LinkUrl}, #{GradeCode}, #{ActivitySequence}, #{Status})")
    int save(Activity activity);
    
    int count(@Param("params") Map<String, Object> params);

    List<Activity> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from activity t where t.cinemacode = #{cinemacode} and t.gradecode = #{gradecode}")
    List<Activity> getByCinemaCode(@Param("cinemacode")String  cinemacode,@Param("gradecode")String gradecode);

}
