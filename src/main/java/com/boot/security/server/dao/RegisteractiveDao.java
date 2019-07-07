package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Registeractive;

@Mapper
public interface RegisteractiveDao {

    @Select("select * from registeractive t where t.id = #{id}")
    Registeractive getById(Long id);

    @Delete("delete from registeractive where id = #{id}")
    int delete(Long id);

    int update(Registeractive registeractive);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into registeractive(Id, CinemaCode, RegisterActiveCode, CreatedTime, ActivePictureUrl, UpdatedTime, Status) values(#{Id}, #{CinemaCode}, #{RegisterActiveCode}, #{CreatedTime}, #{ActivePictureUrl}, #{UpdatedTime}, #{Status})")
    int save(Registeractive registeractive);
    
    int count(@Param("params") Map<String, Object> params);

    List<Registeractive> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from registeractive t where t.cinemacode = #{cinemacode}")
    Registeractive getByCinemaCode(String cinemacode);
    
    @Select("select * from registeractive t where t.cinemacode=#{cinemacode} and t.status =1")
    List<Registeractive> getCanUseRegisterActive(String cinemaCode);
}
