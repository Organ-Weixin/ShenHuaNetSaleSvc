package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Conpongroup;
import com.boot.security.server.model.SysUser;

@Mapper
public interface ConpongroupDao {

    @Select("select * from conpongroup t where t.id = #{id}")
    Conpongroup getById(Long id);
    
    @Delete("delete from conpongroup where id = #{id}")
    int delete(Long id);

    int update(Conpongroup conpongroup);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into conpongroup(Id, CinemaCode, TypeCode, GroupCode, GroupName, Price, ConponNumber, SnackOrFilmCode, ValidityDate, Created, Updated, Remark) values(#{Id}, #{CinemaCode}, #{TypeCode}, #{GroupCode}, #{GroupName}, #{Price}, #{ConponNumber}, #{SnackOrFilmCode}, #{ValidityDate}, #{Created}, #{Updated}, #{Remark})")
    int save(Conpongroup conpongroup);
    
    int count(@Param("params") Map<String, Object> params);

    List<Conpongroup> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
