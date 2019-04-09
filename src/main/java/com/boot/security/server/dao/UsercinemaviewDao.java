package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Usercinemaview;

@Mapper
public interface UsercinemaviewDao {

    @Select("select * from usercinemaview t where t.id = #{id}")
    Usercinemaview getById(Long id);
    
    @Select("select * from usercinemaview t where t.userid = #{userid}")
    List<Usercinemaview> GetUserCinemaViewsByUserId(Long userid);
    
    @Select("select * from usercinemaview t where t.userid = #{userid} and t.cinemacode=#{cinemacode}")
    Usercinemaview GetUserCinemaViewsByUserIdAndCinemaCode(Long userid,String cinemacode);

    @Delete("delete from usercinemaview where id = #{id}")
    int delete(Long id);

    int update(Usercinemaview usercinemaview);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into usercinemaview(Id, UserId, ExpDate, UserName, Password, PayType, Fee, CinemaCode, CinemaName, CinemaAddress, CinemaId, CinemaOpen, CinemaType, Url, MemberUrl, DefaultUserName, DefaultPassword) values(#{Id}, #{UserId}, #{ExpDate}, #{UserName}, #{Password}, #{PayType}, #{Fee}, #{CinemaCode}, #{CinemaName}, #{CinemaAddress}, #{CinemaId}, #{CinemaOpen}, #{CinemaType}, #{Url}, #{MemberUrl}, #{DefaultUserName}, #{DefaultPassword})")
    int save(Usercinemaview usercinemaview);
    
    int count(@Param("params") Map<String, Object> params);

    List<Usercinemaview> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
