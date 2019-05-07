package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Cinemapaymentsettings;

@Mapper
public interface CinemapaymentsettingsDao {

    @Select("select * from cinemapaymentsettings t where t.id = #{id}")
    Cinemapaymentsettings getById(Long id);

    @Delete("delete from cinemapaymentsettings where id = #{id}")
    int delete(Long id);

    int update(Cinemapaymentsettings cinemapaymentsettings);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into cinemapaymentsettings(Id, CinemaCode, CinemaName, IsUseWxpay, WxpayAppId, WxpayMchId, WxpayKey, WxpayRefundCert, IsUserMemberCard, IsDel) values(#{Id}, #{CinemaCode}, #{CinemaName}, #{IsUseWxpay}, #{WxpayAppId}, #{WxpayMchId}, #{WxpayKey}, #{WxpayRefundCert}, #{IsUserMemberCard}, #{IsDel})")
    int save(Cinemapaymentsettings cinemapaymentsettings);
    
    int count(@Param("params") Map<String, Object> params);

    List<Cinemapaymentsettings> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from cinemapaymentsettings t where t.cinemacode = #{cinemacode}")
    Cinemapaymentsettings getByCinemaCode(String cinemacode);
}
