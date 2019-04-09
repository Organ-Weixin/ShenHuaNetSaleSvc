package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.UserCinema;

@Mapper
public interface UserCinemaDao {

    @Select("select * from user_cinema t where t.id = #{id}")
    UserCinema getById(Long id);

    @Delete("delete from user_cinema where id = #{id}")
    int delete(Long id);

    int update(UserCinema userCinema);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user_cinema(Id, UserId, CinemaCode, UserName, Password, Fee, CinemaFee, PayType, RealPrice, ExpDate) values(#{Id}, #{UserId}, #{CinemaCode}, #{UserName}, #{Password}, #{Fee}, #{CinemaFee}, #{PayType}, #{RealPrice}, #{ExpDate})")
    int save(UserCinema userCinema);
    
    int count(@Param("params") Map<String, Object> params);

    List<UserCinema> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
