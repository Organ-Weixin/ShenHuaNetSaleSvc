package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Ticketuserfilm;

@Mapper
public interface TicketuserfilmDao {

    @Select("select * from ticketuserfilm t where t.id = #{id}")
    Ticketuserfilm getById(Long id);

    @Delete("delete from ticketuserfilm where id = #{id}")
    int delete(Long id);

    int update(Ticketuserfilm ticketuserfilm);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into ticketuserfilm(Id, OpenId, FilmCode, Status) values(#{Id}, #{OpenId}, #{FilmCode}, #{Status})")
    int save(Ticketuserfilm ticketuserfilm);
    
    int count(@Param("params") Map<String, Object> params);

    List<Ticketuserfilm> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from ticketuserfilm t where t.openid = #{openid} and t.status = #{status}")
    List<Ticketuserfilm> getByOpenId(@Param("openid")String openid,@Param("status")Integer status);
    
    @Delete("delete from ticketuserfilm where openid = #{openid} and filmcode = #{filmcode}")
    int deleteByFilmCode(@Param("openid")String openid,@Param("filmcode")String filmcode);
    
    @Select("select * from ticketuserfilm t where t.openid = #{openid} and t.filmcode = #{filmcode}")
    Ticketuserfilm getByFilmCode(@Param("openid")String openid,@Param("filmcode")String filmcode);
}
