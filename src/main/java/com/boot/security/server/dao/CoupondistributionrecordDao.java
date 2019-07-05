package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Coupondistributionrecord;

@Mapper
public interface CoupondistributionrecordDao {

    @Select("select * from coupondistributionrecord t where t.id = #{id}")
    Coupondistributionrecord getById(Long id);

    @Delete("delete from coupondistributionrecord where id = #{id}")
    int delete(Long id);

    int update(Coupondistributionrecord coupondistributionrecord);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into coupondistributionrecord(Id,CinemaCode, GroupCode, CustomerType, OpenID, Issuer, IssuedNumber, IssuedTime, Status) values(#{Id},#{CinemaCode},#{GroupCode}, #{CustomerType}, #{OpenID}, #{Issuer}, #{IssuedNumber}, now(), #{Status})")
    int save(Coupondistributionrecord coupondistributionrecord);
    
    int count(@Param("params") Map<String, Object> params);

    List<Coupondistributionrecord> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
