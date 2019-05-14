package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Userinfo;

@Mapper
public interface UserinfoDao {

    @Select("select * from userinfo t where t.id = #{id}")
    Userinfo getById(Long id);
    
    @Select("select * from userinfo t where t.username = #{username} and t.password = #{password}")
    Userinfo getByUserCredential(@Param("username")String username,@Param("password")String password);

    @Delete("delete from userinfo where id = #{id}")
    int delete(Long id);

    int update(Userinfo userinfo);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into userinfo(Id, UserName, Password, Company, Address, Tel, Advance, IsDel, BeginDate, EndDate) values(#{Id}, #{UserName}, #{Password}, #{Company}, #{Address}, #{Tel}, #{Advance}, #{IsDel}, #{BeginDate}, #{EndDate})")
    int save(Userinfo userinfo);
    
    @Select("select * from userinfo where userName=#{userName}")
	Userinfo selcectByUserName(String userName);
    
    int count(@Param("params") Map<String, Object> params);

    List<Userinfo> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    //获取渠道
    @Select("select * from userinfo where IsDel='0'")
    List<Userinfo> getCompany();
}
