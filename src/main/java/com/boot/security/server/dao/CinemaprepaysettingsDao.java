package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Cinemaprepaysettings;

@Mapper
public interface CinemaprepaysettingsDao {

    @Select("select * from cinemaprepaysettings t where t.id = #{id}")
    Cinemaprepaysettings getById(Long id);

    @Delete("delete from cinemaprepaysettings where id = #{id}")
    int delete(Long id);

    int update(Cinemaprepaysettings cinemaprepaysettings);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into cinemaprepaysettings(Id, CinemaCode, CinemaName, IsPrePay, SurplusPayment, LowestPrePayment) values(#{Id}, #{CinemaCode}, #{CinemaName}, #{IsPrePay}, #{SurplusPayment}, #{LowestPrePayment})")
    int save(Cinemaprepaysettings cinemaprepaysettings);
    
    int count(@Param("params") Map<String, Object> params);

    List<Cinemaprepaysettings> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
