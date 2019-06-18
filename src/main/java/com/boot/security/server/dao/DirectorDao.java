package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Director;

@Mapper
public interface DirectorDao {

    @Select("select * from director t where t.id = #{id}")
    Director getById(Long id);

    @Delete("delete from director where id = #{id}")
    int delete(Long id);

    int update(Director director);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into director(CreateTime, DeleteTime, ModifyTime, Valid, Version, Country, CountryIndex, Introduction, Name, Picture) values(#{CreateTime}, #{DeleteTime}, #{ModifyTime}, #{Valid}, #{Version}, #{Country}, #{CountryIndex}, #{Introduction}, #{Name}, #{Picture})")
    int save(Director director);
    
    int count(@Param("params") Map<String, Object> params);

    List<Director> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
