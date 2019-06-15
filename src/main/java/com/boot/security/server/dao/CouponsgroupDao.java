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
    
    @Update("update couponsgroup set status = #{status} where expireDate < now()")
    int changePast(Integer status);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into couponsgroup(GroupCode, CouponsType, CouponsName, ValidityType, EffectiveDate, ExpireDate, EffectiveDays, ValidityDays, CanUsePeriodType, WeekDays, TimePeriod, LimitNum, ReductionType, initialAmount, ReductionPrice, FilmCodes, GoodsCodes, IsShare, Remark, CanUseCinemaType, CinemaCodes, Status, CouponsNumber, IssuedNumber, FetchNumber, RemainingNumber, UsedNumber, SendGroupNumber, SendNumber, GiftType, CreateDate, UpdateDate,IsUseChatRoom) values(#{GroupCode}, #{CouponsType}, #{CouponsName}, #{ValidityType}, #{EffectiveDate}, #{ExpireDate}, #{EffectiveDays}, #{ValidityDays}, #{CanUsePeriodType}, #{WeekDays}, #{TimePeriod}, #{LimitNum}, #{ReductionType}, #{initialAmount}, #{ReductionPrice}, #{FilmCodes}, #{GoodsCodes}, #{IsShare}, #{Remark}, #{CanUseCinemaType}, #{CinemaCodes}, #{Status}, #{CouponsNumber}, #{IssuedNumber}, #{FetchNumber}, #{RemainingNumber}, #{UsedNumber}, #{SendGroupNumber}, #{SendNumber}, #{GiftType}, #{CreateDate}, #{UpdateDate},#{IsUseChatRoom})")
    int save(Couponsgroup couponsgroup);
    
    int count(@Param("params") Map<String, Object> params);

    List<Couponsgroup> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from couponsgroup where find_in_set(#{cinemacode},cinemacodes)")
    List<Couponsgroup> getByCinemaCode(String cinemacode);
    
    @Select("select * from couponsgroup  t where  t.groupcode =#{groupcode} and (cinemacodes='' or  find_in_set(#{cinemacodes},cinemacodes))")
    Couponsgroup getByCinemaCodeAndGroupCode(@Param("cinemacodes")String cinemacodes,@Param("groupcode") String groupcode);
    
    @Select("select * from couponsgroup where find_in_set(#{cinemacode},cinemacodes) and status = 1")
    List<Couponsgroup> getCanUseByGroupCode(String cinemacode);
    //查询所有启用优惠券
    @Select("select * from couponsgroup where status = 1 and (CinemaCodes is NULL or find_in_set(#{cinemacode},cinemacodes))")
    List<Couponsgroup> getAllUseByGroupCode(String cinemacode);
    
    @Select("select * from couponsgroup t where t.groupcode = #{groupcode}")
    Couponsgroup getByGroupCode(String  groupcode);
    
    @Select("select * from couponsgroup where canusecinematype =1")
    List<Couponsgroup> getAllCinemaCanUseCoupons();
    
    @Update("update couponsgroup t set t.status = #{status}, t.updateDate = now() where t.expireDate < now()")
    int updatePastCoupons(Integer status);
    
    @Select("select * from couponsgroup t where t.groupcode = #{groupcode} and t.status = #{status} and (t.canusecinematype = 1 or find_in_set(#{cinemacode},cinemacodes))")
    Couponsgroup getUserCouponsGroup(@Param("groupcode")String groupcode,@Param("status")Integer status,@Param("cinemacode")String cinemacode);
    
    @Select("select * from couponsgroup where IsUseChatRoom=1 and (CouponsNumber-IssuedNumber)>0 and cinemacodes=#{cinemacode} and status=1")
    List<Couponsgroup> getChatRoomCouponsByCinemaCode(String cinemacode);
}
