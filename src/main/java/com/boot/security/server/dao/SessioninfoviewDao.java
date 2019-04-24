package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Sessioninfoview;

@Mapper
public interface SessioninfoviewDao {

    @Select("select * from sessioninfoview t where t.id = #{id}")
    Sessioninfoview getById(Long id);

    @Delete("delete from sessioninfoview where id = #{id}")
    int delete(Long id);

    int update(Sessioninfoview sessioninfoview);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into sessioninfoview(Id, SCode, CCode, ScreenCode, Name, Company, FilmCode, FilmName, SName, StartTime, Duration, Language, StandardPrice, LowestPrice, Price) values(#{Id}, #{SCode}, #{CCode}, #{ScreenCode}, #{Name}, #{Company}, #{FilmCode}, #{FilmName}, #{SName}, #{StartTime}, #{Duration}, #{Language}, #{StandardPrice}, #{LowestPrice}, #{Price})")
    int save(Sessioninfoview sessioninfoview);
    
    int count(@Param("params") Map<String, Object> params);

    List<Sessioninfoview> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
