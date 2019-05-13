package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Cinemaview;

@Mapper
public interface CinemaviewDao {

    @Select("select * from cinemaview t where t.id = #{id}")
    Cinemaview getById(Long id);

    @Delete("delete from cinemaview where id = #{id}")
    int delete(Long id);

    int update(Cinemaview cinemaview);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into cinemaview(Id, MId, Code, Name, Address, ScreenCount, ManualAdd, CinemaId, CinemaOpen, IsOpenSnacks, CinemaType) values(#{Id}, #{MId}, #{Code}, #{Name}, #{Address}, #{ScreenCount}, #{ManualAdd}, #{CinemaId}, #{CinemaOpen}, #{IsOpenSnacks}, #{CinemaType})")
    int save(Cinemaview cinemaview);
    
    int count(@Param("params") Map<String, Object> params);

    List<Cinemaview> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
