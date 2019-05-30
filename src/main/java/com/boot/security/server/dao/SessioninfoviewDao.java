package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.modelView.Sessioninfoview;


@Mapper
public interface SessioninfoviewDao {

    @Select("select * from sessioninfoview t where t.id = #{id}")
    Sessioninfoview getById(Long id);
    
    int count(@Param("params") Map<String, Object> params);

    List<Sessioninfoview> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from sessioninfoview t where t.cinemacode = #{cinemacode} and t.scode = #{sessioncode}")
    Sessioninfoview getByCinemaCodeAndSessionCode(@Param("cinemacode")String cinemacode,@Param("sessioncode")String sessioncode);
}
