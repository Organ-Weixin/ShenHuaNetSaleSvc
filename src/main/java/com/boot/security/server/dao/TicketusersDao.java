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

import com.boot.security.server.model.Ticketusers;

@Mapper
public interface TicketusersDao {
	

    @Select("select * from ticketusers t where t.id = #{id}")
    Ticketusers getById(Long id);
    
    int update(Ticketusers ticketusers);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into ticketusers(CinemaCode, MobilePhone, OpenID, VerifyCode, IsActive, IsRegister, IsMember, RegisterTime, Created, NickName, Sex, Birthday, Country, Province, City, HeadImgUrl, TotalScore, Language, Roll) values(#{CinemaCode}, #{MobilePhone}, #{OpenID}, #{VerifyCode}, #{IsActive}, #{IsRegister}, #{IsMember}, #{RegisterTime}, #{Created}, #{NickName}, #{Sex}, #{Birthday}, #{Country}, #{Province}, #{City}, #{HeadImgUrl}, #{TotalScore}, #{Language}, #{Roll})")
    int save(Ticketusers ticketusers);
    
    @Select("select * from Ticketusers where CinemaCode=#{cinemacode} and OpenID = #{openid}")
    Ticketusers getByOpenId(@Param("openid") String openid,@Param("cinemacode") String cinemacode);
    
    @Select("select * from ticketusers t where t.cinemacode = #{cinemacode}")
    Ticketusers getByCinemaCode(String cinemacode);
    
    @Select("select * from ticketusers t where t.openid = #{openid}")
    Ticketusers getByopenids(String openid);

    @Delete("delete from ticketusers where id = #{id}")
    int delete(Long id);
    
    int count(@Param("params") Map<String, Object> params);

    List<Ticketusers> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    List<Ticketusers> getTicketusers(@Param("params") Map<String, Object> params);
    
    @Select("select * from ticketusers t where t.openid is not null and t.openid !='' ")
    List<Ticketusers> getAllList();
    
    @Update("update ticketusers set isactive #{isactive} where openid ={openid}")
    int updateIsActive(@Param("isactive")Integer isactive, @Param("openid")String openid);
}
