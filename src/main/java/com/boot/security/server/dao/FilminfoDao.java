package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Filminfo;

@Mapper
public interface FilminfoDao {

    @Select("select * from filminfo t where t.id = #{id}")
    Filminfo getById(Long id);
    
    @Select("select * from filminfo t where t.filmcode = #{filmcode}")
    Filminfo getByFilmCode(String filmcode);

    @Delete("delete from filminfo where id = #{id}")
    int delete(Long id);

    int update(Filminfo filminfo);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into filminfo(Id, FilmCode, FilmName, Version, Duration, PublishDate, Publisher, Producer, Director, Cast, Introduction) values(#{Id}, #{FilmCode}, #{FilmName}, #{Version}, #{Duration}, #{PublishDate}, #{Publisher}, #{Producer}, #{Director}, #{Cast}, #{Introduction})")
    int save(Filminfo filminfo);
    
    int count(@Param("params") Map<String, Object> params);

    List<Filminfo> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
