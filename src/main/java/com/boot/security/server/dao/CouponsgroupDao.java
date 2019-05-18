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

import com.boot.security.server.model.Couponsgroup;

@Mapper
public interface CouponsgroupDao {

    @Select("select * from couponsgroup t where t.id = #{id}")
    Couponsgroup getById(Long id);

    @Delete("delete from couponsgroup where id = #{id}")
    int delete(Long id);

    int update(Couponsgroup couponsgroup);
    
    @Update("update couponsgroup set status = #{status} where id = #{id}")
    int changeStatus(@Param("status") Integer status,@Param("id") Long id);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into couponsgroup(GroupCode, CouponsType, CouponsName, ValidityType, EffectiveDate, ExpireDate, EffectiveDays, ValidityDays, CanUsePeriodType, WeekDays, TimePeriod, LimitNum, ReductionType, ReductionPrice, FilmCodes, GoodsCodes, IsShare, Remark, CanUseCinemaType, CinemaCodes, Status, CouponsNumber, IssuedNumber, FetchNumber, RemainingNumber, UsedNumber, CreateDate) values(#{GroupCode}, #{CouponsType}, #{CouponsName}, #{ValidityType}, #{EffectiveDate}, #{ExpireDate}, #{EffectiveDays}, #{ValidityDays}, #{CanUsePeriodType}, #{WeekDays}, #{TimePeriod}, #{LimitNum}, #{ReductionType}, #{ReductionPrice}, #{FilmCodes}, #{GoodsCodes}, #{IsShare}, #{Remark}, #{CanUseCinemaType}, #{CinemaCodes}, #{Status}, #{CouponsNumber}, #{IssuedNumber}, #{FetchNumber}, #{RemainingNumber}, #{UsedNumber}, Now())")
    int save(Couponsgroup couponsgroup);
    
    int count(@Param("params") Map<String, Object> params);

    List<Couponsgroup> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from couponsgroup where find_in_set(#{cinemacode},cinemacodes)")
    List<Couponsgroup> getByCinemaCode(String cinemacode);
    
    @Select("select * from couponsgroup where find_in_set(#{cinemacode},cinemacodes) and status = 1")
    List<Couponsgroup> getCanUseByGroupCode(String cinemacode);

    //查询所有启用优惠券
    @Select("select * from couponsgroup where status = 1 and (CinemaCodes is NULL or find_in_set(#{cinemacode},cinemacodes))")
    List<Couponsgroup> getAllUseByGroupCode(String cinemacode);
    
    @Select("select * from couponsgroup t where t.groupcode = #{groupcode}")
    Couponsgroup getByGroupCode(String  groupcode);
    
    @Select("select * from couponsgroup t where t.expireDate < now()")
    List<Couponsgroup> getPastCoupons();
    
    @Select("select * from couponsgroup where canusecinematype =1")
    List<Couponsgroup> getAllCinemaCanUseCoupons();
    
    @Update("update couponsgroup t set t.status = #{status}, t.updateDate = now() where t.expireDate < now()")
    int updatePastCoupons(Integer status);
}
