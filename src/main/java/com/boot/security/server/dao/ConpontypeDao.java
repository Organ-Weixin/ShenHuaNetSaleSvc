package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Conpontype;

@Mapper
public interface ConpontypeDao {

    @Select("select * from conpontype t where t.id = #{id}")
    Conpontype getById(Long id);
    
    @Select("select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03")
    List<Conpontype> getCertificatetype();

    @Select("select id,typecode,typename from conpontype where typecode = 04 or typecode = 05 or typecode = 06 or typecode = 07")
    List<Conpontype> getConpontype();
    
    @Delete("delete from conpontype where id = #{id}")
    int delete(Long id);

    int update(Conpontype conpontype);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into conpontype(Id, TypeCode, TypeName, TypeParentId, Remark, IsDel, Created, Updated) values(#{Id}, #{TypeCode}, #{TypeName}, #{TypeParentId}, #{Remark}, #{IsDel}, #{Created}, #{Updated})")
    int save(Conpontype conpontype);
    
    int count(@Param("params") Map<String, Object> params);

    List<Conpontype> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
