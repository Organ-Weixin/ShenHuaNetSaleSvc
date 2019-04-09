package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.boot.security.server.model.Cinema;

@Mapper
public interface CinemaDao {
	//根据id查询订单数据
    @Select("select * from cinema t where t.Id= #{id}")
    Cinema getById(Long id);
    
    @Select("select * from cinema t where t.Code= #{cinemacode}")
    Cinema getByCinemaCode(String  cinemacode);

    @Delete("delete from cinema where id = #{id}")
    int delete(Long id);
    
    
    @Update("update  cinema set Name=#{Name},Address=#{Address},ScreenCount=#{ScreenCount},CinemaId=#{CinemaId} where Code=#{Code}")
    int update(Cinema cinema);
    
   @Options(useGeneratedKeys = true, keyProperty = "id")
   @Insert("insert into cinema(Code, Name, Address, CinemaId, ScreenCount) values(#{Code}, #{Name}, #{Address}, #{CinemaId}, #{ScreenCount})")
   int save(Cinema cinema); 
   
    int count(@Param("params") Map<String, Object> params);

    List<Cinema> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
