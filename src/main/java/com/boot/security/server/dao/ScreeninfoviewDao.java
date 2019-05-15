package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Screeninfoview;

@Mapper
public interface ScreeninfoviewDao {

    @Select("select * from screeninfoview t where t.id = #{id}")
    Screeninfoview getById(Long id);

    @Delete("delete from screeninfoview where id = #{id}")
    int delete(Long id);

    int update(Screeninfoview screeninfoview);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into screeninfoview(Id, CCode, CinemaName, SCode, SName, UpdateTime, SeatCount, Type) values(#{Id}, #{CCode}, #{CinemaName}, #{SCode}, #{SName}, #{UpdateTime}, #{SeatCount}, #{Type})")
    int save(Screeninfoview screeninfoview);
    
    int count(@Param("params") Map<String, Object> params);

    List<Screeninfoview> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
