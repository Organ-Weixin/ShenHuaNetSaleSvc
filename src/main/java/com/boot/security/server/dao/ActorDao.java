package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Actor;

@Mapper
public interface ActorDao {

    @Select("select * from actor t where t.id = #{id}")
    Actor getById(Long id);

    @Delete("delete from actor where id = #{id}")
    int delete(Long id);

    int update(Actor actor);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into actor(CreateTime, DeleteTime, ModifyTime, Valid, Version, Country, CountryIndex, Introduction, Name, Picture, Businessid) values(#{CreateTime}, #{DeleteTime}, #{ModifyTime}, #{Valid}, #{Version}, #{Country}, #{CountryIndex}, #{Introduction}, #{Name}, #{Picture}, #{Businessid})")
    int save(Actor actor);
    
    int count(@Param("params") Map<String, Object> params);

    List<Actor> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
