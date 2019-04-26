package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Snacks;

@Mapper
public interface SnacksDao {

    @Select("select * from snacks t where t.id = #{id}")
    Snacks getById(Long id);

    @Delete("delete from snacks where id = #{id}")
    int delete(Long id);

    int update(Snacks snacks);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into snacks(Id, CinemaCode, SnackCode, TypeCode, SnackName, Remark, StandardPrice, SalePrice, Status, Stock, ExpDate, IsDel, IsRecommand, Image) values(#{Id}, #{CinemaCode}, #{SnackCode}, #{TypeCode}, #{SnackName}, #{Remark}, #{StandardPrice}, #{SalePrice}, #{Status}, #{Stock}, #{ExpDate}, #{IsDel}, #{IsRecommand}, #{Image})")
    int save(Snacks snacks);
    
    int count(@Param("params") Map<String, Object> params);

    List<Snacks> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from snacks where cinemacode = #{cinemacode} and isdel = 0")
    List<Snacks> getByCinemaCode(String cinemacode);
}
