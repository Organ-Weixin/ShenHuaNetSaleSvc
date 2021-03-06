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

import com.boot.security.server.model.Membercard;

@Mapper
public interface MembercardDao { 

    @Select("select * from membercard t where t.id = #{id}")
    Membercard getById(Long id);
    
    @Select("select * from membercard t where t.cinemacode = #{cinemacode} and t.cardno=#{cardno}")
    Membercard getByCardNo(@Param("cinemacode")String cinemacode,@Param("cardno")String cardno);

    @Delete("delete from membercard where id = #{id}")
    int delete(Long id);

    int update(Membercard membercard);
    
    @Update("update membercard t set t.status = 0 where t.cinemacode = #{cinemacode} and t.cardno = #{cardno}")
    int memberCardUnbind(@Param("cinemacode") String cinemacode,@Param("cardno") String cardno);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into membercard(CinemaCode, OpenId, CardNo, CardPassword, MobilePhone, LevelCode, LevelName, Score, Balance, UserName, Sex, CreditNum, Birthday, ExpireDate, CreateTime, CinemaCodes, Updated, Status, AccStatus) values(#{CinemaCode}, #{OpenId}, #{CardNo}, #{CardPassword}, #{MobilePhone}, #{LevelCode}, #{LevelName}, #{Score}, #{Balance}, #{UserName}, #{Sex}, #{CreditNum}, #{Birthday}, #{ExpireDate}, #{CreateTime}, #{CinemaCodes}, #{Updated}, #{Status}, #{AccStatus})")
    int save(Membercard membercard);
    
    int count(@Param("params") Map<String, Object> params);

    List<Membercard> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from membercard t where t.cinemacode = #{cinemacode} and (t.mobilephone = #{mobilephone} or t.cardno = #{mobilephone})")
    List<Membercard> getByCinemaCodeAndMobilePhone(@Param("cinemacode") String cinemacode,@Param("mobilephone") String mobilephone);
    
    @Select("select * from membercard where (ExpireDate >now() or ExpireDate is null) and openid is not null and find_in_set(cinemacode,#{cinemacodes})")
    List<Membercard> getByCinemaCodes(String cinemacodes);
    
    @Select("select * from membercard t where (t.cinemacode = #{cinemacode} or find_in_set(#{cinemacode},t.cinemacodes)) and t.openid = #{openid} and t.status =1")
    List<Membercard> getByCinemaCodeAndOpenID(@Param("cinemacode") String cinemacode,@Param("openid") String openid);
    
    @Select("select * from membercard t where t.cinemacode = #{cinemacode} and t.cardno = #{cardno} and t.cardpassword =#{cardpassword}")
    Membercard checkMemberCard(@Param("cinemacode") String cinemacode,@Param("cardno") String cardno,@Param("cardpassword") String cardpassword);
    
    @Update("update membercard set cinemacodes = #{cinemacode} where find_in_set(cinemacode,#{cinemacodes}) or cinemacodes =#{cinemacodes}")
    int changeMemberCinemaCode(@Param("cinemacode")String cinemacode,@Param("cinemacodes")String cinemacodes);
}
