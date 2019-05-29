package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Registeractivecoupons;

@Mapper
public interface RegisteractivecouponsDao {

    @Select("select * from registeractivecoupons t where t.id = #{id}")
    Registeractivecoupons getById(Long id);

    @Delete("delete from registeractivecoupons where id = #{id}")
    int delete(Long id);

    int update(Registeractivecoupons registeractivecoupons);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into registeractivecoupons(RegisterActiveCode, GroupCode, CouponsName, GiveNumber) values(#{RegisterActiveCode}, #{GroupCode}, #{CouponsName}, #{GiveNumber})")
    int save(Registeractivecoupons registeractivecoupons);
    
    int count(@Param("params") Map<String, Object> params);

    List<Registeractivecoupons> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Delete("delete from registeractivecoupons where registeractivecode = #{registeractivecode}")
    int deleteByRegisterActiveCode(String registeractivecode);
    
    @Select("select * from registeractivecoupons where registerActiveCode = #{registerActiveCode}")
    List<Registeractivecoupons> getByRegisterActiveCode(String registerActiveCode);
}
