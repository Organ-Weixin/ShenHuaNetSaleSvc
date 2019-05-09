package com.boot.security.server.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Ticketusers;

@Mapper
public interface TicketusersDao {

    int update(Ticketusers ticketusers);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into ticketusers(CinemaCode, MobilePhone, OpenID, VerifyCode, IsActive, Created, NickName, Sex, Country, Province, City, HeadImgUrl, TotalScore, Language) values(#{CinemaCode}, #{MobilePhone}, #{OpenID}, #{VerifyCode}, #{IsActive}, #{Created}, #{NickName}, #{Sex}, #{Country}, #{Province}, #{City}, #{HeadImgUrl}, #{TotalScore}, #{Language})")
    int save(Ticketusers ticketusers);
    
    @Select("select * from Ticketusers where CinemaCode=#{cinemacode} and OpenID = #{openid}")
    Ticketusers getByOpenId(@Param("openid") String openid,@Param("cinemacode") String cinemacode);
    
    @Select("select * from ticketusers t where t.cinemacode = #{cinemacode}")
    Ticketusers getByCinemaCode(String cinemacode);
    
    @Select("select * from ticketusers t where t.openid = #{openid}")
    Ticketusers getByopenids(String openid);
}
