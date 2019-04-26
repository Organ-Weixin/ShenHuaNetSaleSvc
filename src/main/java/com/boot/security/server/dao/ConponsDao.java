package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Conpons;

@Mapper
public interface ConponsDao {

    @Select("select * from conpons t where t.id = #{id}")
    Conpons getById(Long id);

    @Delete("delete from conpons where id = #{id}")
    int delete(Long id);

    int update(Conpons conpons);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into conpons(Id, TypeCode, TypeName, CinemaCode, GroupCode, OpenID, Price, ConponCode, SnackCode, ValidityDate, ReceivedDate, Status, UseDate, Created, Updated, Deleted, Title, Remark) values(#{Id}, #{TypeCode}, #{TypeName}, #{CinemaCode}, #{GroupCode}, #{OpenID}, #{Price}, #{ConponCode}, #{SnackCode}, #{ValidityDate}, #{ReceivedDate}, #{Status}, #{UseDate}, #{Created}, #{Updated}, #{Deleted}, #{Title}, #{Remark})")
    int save(Conpons conpons);
    
    int count(@Param("params") Map<String, Object> params);

    List<Conpons> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
