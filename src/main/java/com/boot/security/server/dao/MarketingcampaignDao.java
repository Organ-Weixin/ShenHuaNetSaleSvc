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

import com.boot.security.server.model.Marketingcampaign;

@Mapper
public interface MarketingcampaignDao {

    @Select("select * from marketingcampaign t where t.id = #{id}")
    Marketingcampaign getById(Long id);

    @Delete("delete from marketingcampaign where id = #{id}")
    int delete(Long id);

    int update(Marketingcampaign marketingcampaign);
    
    @Update("update marketingcampaign set status = #{status} where id = #{id}")
    int changestatus(@Param("status") Integer status,@Param("id") Long id);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into marketingcampaign(ActivityName, ActivityType, TicketsType,AppointmentNumber, AppointTime, RestrictionType, RestrictionNumber, CinemaCodes, CinemaCodesType, ScreenCodes, ScreenCodesType,FilmCodesType,FilmCodes, CouponPrice,FixedAmount,StartDate, EndDate, SumNumber,RemainingNumber, IsSuperposition,IsUseCoupon, Status) values(#{ActivityName}, #{ActivityType}, #{TicketsType},#{AppointmentNumber}, #{AppointTime}, #{RestrictionType}, #{RestrictionNumber}, #{CinemaCodes}, #{CinemaCodesType}, #{ScreenCodes}, #{ScreenCodesType},#{FilmCodesType},#{FilmCodes}, #{CouponPrice},#{FixedAmount},#{StartDate}, #{EndDate}, #{SumNumber},#{RemainingNumber}, #{IsSuperposition},#{IsUseCoupon}, #{Status})")
    int save(Marketingcampaign marketingcampaign);
    
    int count(@Param("params") Map<String, Object> params);

    List<Marketingcampaign> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
