package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Membercardlevel;

@Mapper
public interface MembercardlevelDao { 

    @Select("select * from membercardlevel t where t.id = #{id}")
    Membercardlevel getById(Long id);
    
    @Select("select * from membercardlevel t where t.cinemacode = #{cinemacode}")
    List<Membercardlevel> getByCinemaCode(String cinemacode);
    
    @Select("select * from  membercardlevel t where t.cinemacode = #{cinemacode} and t.levelcode = #{levelcode}")
    Membercardlevel getByCinemaCodeAndLevelCode(@Param("cinemacode") String cinemacode,@Param("levelcode") String levelcode);

    @Delete("delete from membercardlevel where id = #{id}")
    int delete(Long id);
    
    @Delete("delete from membercardlevel where cinemacode = #{cinemacode}")
    int deleteByCinemaCode(String cinemacode);

    int update(Membercardlevel membercardlevel);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into membercardlevel(CinemaCode, LevelCode, LevelName,CardCostFee,MemberFee) values(#{CinemaCode}, #{LevelCode}, #{LevelName},#{CardCostFee},#{MemberFee})")
    int save(Membercardlevel membercardlevel);
    
    int count(@Param("params") Map<String, Object> params);

    List<Membercardlevel> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
