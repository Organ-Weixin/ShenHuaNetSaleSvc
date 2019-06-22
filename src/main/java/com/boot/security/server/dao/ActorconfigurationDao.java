package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Actorconfiguration;

@Mapper
public interface ActorconfigurationDao {

    @Select("select * from actorconfiguration t where t.id = #{id}")
    Actorconfiguration getById(Long id);

    @Delete("delete from actorconfiguration where id = #{id}")
    int delete(Long id);

    int update(Actorconfiguration actorconfiguration);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into actorconfiguration(Id, FilmCode, ActorId, Type) values(#{Id}, #{FilmCode}, #{ActorId}, #{Type})")
    int save(Actorconfiguration actorconfiguration);
    
    int count(@Param("params") Map<String, Object> params);

    List<Actorconfiguration> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from actorconfiguration t where t.filmcode =#{filmcode} and t.type =#{type}")
    List<Actorconfiguration> getByFilmCodeAndType(@Param("filmcode")String filmcode,@Param("type")String type);
}
