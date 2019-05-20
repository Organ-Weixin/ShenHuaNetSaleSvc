package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Activityview;

@Mapper
public interface ActivityviewDao {

    @Select("select * from activityview t where t.id = #{id}")
    Activityview getById(Long id);

    @Delete("delete from activityview where id = #{id}")
    int delete(Long id);

    int update(Activityview activityview);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into activityview(Id, CinemaCode, Title, Image, ActivityContent, StartDate, EndDate, LinkUrl, GradeCode, ActivitySequence, Status, LinkName) values(#{Id}, #{CinemaCode}, #{Title}, #{Image}, #{ActivityContent}, #{StartDate}, #{EndDate}, #{LinkUrl}, #{GradeCode}, #{ActivitySequence}, #{Status}, #{LinkName})")
    int save(Activityview activityview);
    
    int count(@Param("params") Map<String, Object> params);

    List<Activityview> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
