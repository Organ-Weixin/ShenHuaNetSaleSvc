package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Couponsgroup;

@Mapper
public interface CouponsgroupDao {

    @Select("select * from couponsgroup t where t.id = #{id}")
    Couponsgroup getById(Long id);

    @Delete("delete from couponsgroup where id = #{id}")
    int delete(Long id);

    int update(Couponsgroup couponsgroup);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into couponsgroup(Id, GroupCode, CouponsType, CouponsName, ValidityType, EffectiveDays, ValidityDays, CanUsePeriodType, WeekDays, TimePeriod, LimitNum, ReductionType, ReductionPrice, FilmCodes, GoodsCodes, IsShare, Remark, CanUseCinemaType, CinemaCodes, Status, CouponsNumber, FetchNumber, RemainingNumber, UsedNumber, CreateDate, UpdateDate) values(#{Id}, #{GroupCode}, #{CinemaCode}, #{CouponsType}, #{CouponsName}, #{ValidityType}, #{EffectiveDays}, #{ValidityDays}, #{CanUsePeriodType}, #{WeekDays}, #{TimePeriod}, #{LimitNum}, #{ReductionType}, #{ReductionPrice}, #{FilmCodes}, #{GoodsCodes}, #{IsShare}, #{Remark}, #{CanUseCinemaType}, #{Status}, #{CouponsNumber}, #{FetchNumber}, #{RemainingNumber}, #{UsedNumber}, #{CreateDate}, #{UpdateDate})")
    int save(Couponsgroup couponsgroup);
    
    int count(@Param("params") Map<String, Object> params);

    List<Couponsgroup> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
