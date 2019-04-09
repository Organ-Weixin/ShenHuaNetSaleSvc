package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Middleware;

@Mapper
public interface MiddlewareDao {

    @Select("select * from middleware t where t.id = #{id}")
    Middleware getById(Long id);
    
    @Delete("delete from middleware where id = #{id}")
    int delete(Long id);
    
    int update(Middleware middleware);
    
    //@Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into middleware(Title,Url,MemberUrl,UserName,Password,Type) values(#{title},#{url},#{memberUrl},#{userName},#{password},#{type})")
    int save(Middleware middleware);
    
    int count(@Param("params") Map<String, Object> params);

    List<Middleware> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
