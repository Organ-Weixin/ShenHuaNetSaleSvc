package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Registercollectionrecord;

@Mapper
public interface RegistercollectionrecordDao {

    @Select("select * from registercollectionrecord t where t.id = #{id}")
    Registercollectionrecord getById(Long id);

    @Delete("delete from registercollectionrecord where id = #{id}")
    int delete(Long id);

    int update(Registercollectionrecord registercollectionrecord);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into registercollectionrecord(Id, OpenID, RegisterActiveCode, CreateTime) values(#{Id}, #{OpenID}, #{RegisterActiveCode}, now())")
    int save(Registercollectionrecord registercollectionrecord);
    
    int count(@Param("params") Map<String, Object> params);

    List<Registercollectionrecord> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from registercollectionrecord t where t.openid = #{openid}")
    List<Registercollectionrecord> getByOpenID(@Param("openid")String openid);
}
