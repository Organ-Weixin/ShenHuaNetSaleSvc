package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.CinemaMiniProgramAccounts;

@Mapper
public interface CinemaMiniProgramAccountsDao {
	
	@Select("select * from cinemaminiprogramaccounts t where t.id = #{id}")
	CinemaMiniProgramAccounts getById(Long id);
	
	int count(@Param("params") Map<String, Object> params);
    List<CinemaMiniProgramAccounts> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    int update(CinemaMiniProgramAccounts cinemaMiniProgramAccounts);
    
    @Delete("delete from cinemaminiprogramaccounts where id = #{id}")
    int delete(Long id);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into CinemaMiniProgramAccounts(CinemaCode, CinemaName, AppId, AppSecret, IsDel) values(#{CinemaCode}, #{CinemaName}, #{AppId}, #{AppSecret}, #{IsDel})")
    int save(CinemaMiniProgramAccounts cinemaMiniProgramAccounts);
    
    @Select("select * from CinemaMiniProgramAccounts where AppId=#{AppId} and IsDel=0")
    List<CinemaMiniProgramAccounts> getByAppId(String AppId);
    
    @Select("select * from CinemaMiniProgramAccounts where CinemaCode=#{cinemacode} and IsDel=0")
    CinemaMiniProgramAccounts getByCinemaCode(String cinemacode);
}
