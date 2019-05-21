package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Miniprogramlinkurl;

@Mapper
public interface MiniprogramlinkurlDao {

    @Select("select * from miniprogramlinkurl t where t.id = #{id}")
    Miniprogramlinkurl getById(Long id);

    @Delete("delete from miniprogramlinkurl where id = #{id}")
    int delete(Long id);

    int update(Miniprogramlinkurl miniprogramlinkurl);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into miniprogramlinkurl(Id, LinkName, LinkUrl) values(#{Id}, #{LinkName}, #{LinkUrl})")
    int save(Miniprogramlinkurl miniprogramlinkurl);
    
    int count(@Param("params") Map<String, Object> params);

    List<Miniprogramlinkurl> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
