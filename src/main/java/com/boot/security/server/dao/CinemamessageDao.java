package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Cinemamessage;

@Mapper
public interface CinemamessageDao {

    @Select("select * from cinemamessage t where t.id = #{id}")
    Cinemamessage getById(Long id);
    
    @Select("select * from cinemamessage t where t.cinemacode = #{cinemacode} and t.messagetype = #{messagetype}")
    Cinemamessage getByCinemaCodeAndMessageType(@Param("cinemacode") String cinemacode,@Param("messagetype") String messagetype);

    @Delete("delete from cinemamessage where id = #{id}")
    int delete(Long id);

    int update(Cinemamessage cinemamessage);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into cinemamessage(Id, CinemaCode, MessageType, MessageContent) values(#{Id}, #{CinemaCode}, #{MessageType}, #{MessageContent})")
    int save(Cinemamessage cinemamessage);
    
    int count(@Param("params") Map<String, Object> params);

    List<Cinemamessage> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
