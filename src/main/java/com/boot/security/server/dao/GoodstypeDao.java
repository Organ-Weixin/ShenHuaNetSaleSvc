package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Goodstype;

@Mapper
public interface GoodstypeDao {

    @Select("select * from goodstype t where t.id = #{id}")
    Goodstype getById(Long id);

    @Delete("delete from goodstype where id = #{id}")
    int delete(Long id);

    int update(Goodstype goodstype);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into goodstype(Id, CinemaCode, UserId, TypeName, TypeDesc, TypePic) values(#{Id}, #{CinemaCode}, #{UserId}, #{TypeName}, #{TypeDesc}, #{TypePic})")
    int save(Goodstype goodstype);
    
    int count(@Param("params") Map<String, Object> params);

    List<Goodstype> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}