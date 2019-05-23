package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Membercardcreditrule;

@Mapper
public interface MembercardcreditruleDao {

    @Select("select * from membercardcreditrule t where t.id = #{id}")
    Membercardcreditrule getById(Long id);

    @Delete("delete from membercardcreditrule where id = #{id}")
    int delete(Long id);

    int update(Membercardcreditrule membercardcreditrule);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into membercardcreditrule(Id, CinemaCode, RuleCode, RuleName, RuleType, LevelCode, LevelName, CreateTime, Credit, RuleDescription, UpdateTime, Status) values(#{Id}, #{CinemaCode}, #{RuleCode}, #{RuleName}, #{CreateTime}, #{RuleType}, #{LevelCode}, #{LevelName}, #{Credit}, #{RuleDescription}, #{UpdateTime}, #{Status})")
    int save(Membercardcreditrule membercardcreditrule);
    
    int count(@Param("params") Map<String, Object> params);

    List<Membercardcreditrule> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
