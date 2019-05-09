package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Filmcomments;

@Mapper
public interface FilmcommentsDao {

    @Select("select * from filmcomments t where t.id = #{id}")
    Filmcomments getById(Long id);
    
    @Select("select * from filmcomments t where t.filmcode = #{filmcode}")
    List<Filmcomments> getByFilmCode(String filmcode);
    
    @Select("select * from filmcomments t where t.openid = #{openid}")
    Filmcomments getByOpenId(String openid);
    
    @Delete("delete from filmcomments where id = #{id}")
    int delete(Long id);

    int update(Filmcomments filmcomments);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into filmcomments(Id, FilmCode, FilmName, Score, CommentContent, OpenID, Created) values(#{Id}, #{FilmCode}, #{FilmName}, #{Score}, #{CommentContent}, #{OpenID}, #{Created})")
    int save(Filmcomments filmcomments);
    
    int count(@Param("params") Map<String, Object> params);

    List<Filmcomments> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
