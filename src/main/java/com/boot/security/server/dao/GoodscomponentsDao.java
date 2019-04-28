package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Goodscomponents;

@Mapper
public interface GoodscomponentsDao {

    @Select("select * from goodscomponents t where t.id = #{id}")
    Goodscomponents getById(Long id);

    @Delete("delete from goodscomponents where id = #{id}")
    int delete(Long id);

    int update(Goodscomponents goodscomponents);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into goodscomponents(Id, GoodsCode, GoodsName, GoodsCount, UnitName) values(#{Id}, #{GoodsCode}, #{GoodsName}, #{GoodsCount}, #{UnitName})")
    int save(Goodscomponents goodscomponents);
    
    int count(@Param("params") Map<String, Object> params);

    List<Goodscomponents> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
