package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    
    @Update("update coupons set status = #{status} where expiredate < now()")
    int changePast(Integer status);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(#{CouponsCode}, #{CouponsName}, #{EffectiveDate}, #{ExpireDate}, #{GroupCode}, #{Status}, #{OpenID}, Now(), #{ReceiveDate}, #{UsedDate})")
    int save(Coupons coupons);
    
    int count(@Param("params") Map<String, Object> params);

    List<Coupons> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from coupons t where t.openid = #{openid} ORDER BY  status asc,receivedate desc")
    List<Coupons> getByOpenID(String openid);
    
    @Select("select * from coupons t where t.groupcode = #{groupcode}")
    List<Coupons> getByGroupCode(String groupcode);
    
    @Select("select * from coupons t where t.groupcode = #{groupcode} and t.status = 0")
    List<Coupons> getCanUseByGroupCode(String groupcode);
    
    @Update("update coupons t set t.status = 3 where t.couponscode = #{couponscode}")
    int changeStatus(@Param("couponscode")String couponscode);
    
    @Select("select * from coupons t where t.openid = #{openid} and t.status = #{status}")
    List<Coupons> getUserCoupons(@Param("openid")String openid,@Param("status")Integer status);
}
