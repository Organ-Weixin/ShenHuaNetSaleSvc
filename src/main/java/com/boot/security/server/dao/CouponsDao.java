package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Coupons;

@Mapper
public interface CouponsDao {

    @Select("select * from coupons t where t.id = #{id}")
    Coupons getById(Long id);
    
    @Select("select * from coupons t where t.couponscode = #{couponscode}")
    Coupons getByCouponsCode(String couponscode);

    @Delete("delete from coupons where id = #{id}")
    int delete(Long id);
    
    @Delete("delete from coupons where groupcode = #{groupcode}")
    int deleteByGroupCode(String groupcode);

    int update(Coupons coupons);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(#{CouponsCode}, #{CouponsName}, #{EffectiveDate}, #{ExpireDate}, #{GroupCode}, #{Status}, #{OpenID}, Now(), #{ReceiveDate}, #{UsedDate})")
    int save(Coupons coupons);
    
    int count(@Param("params") Map<String, Object> params);

    List<Coupons> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
