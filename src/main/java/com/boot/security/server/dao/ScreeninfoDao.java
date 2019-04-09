package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Screeninfo;

@Mapper
public interface ScreeninfoDao {

	//查询影厅
    @Select("select * from screeninfo t where t.id = #{id}")
    Screeninfo getById(Long id);
    
    @Select("select * from screeninfo t where t.ccode = #{cinemacode} and t.scode=#{screencode}")
    Screeninfo getByScreenCode(String cinemacode,String screencode);
    
    @Select("select * from screeninfo t where t.ccode = #{cinemacode}")
    List<Screeninfo> getByCinemaCode(String cinemacode);

    @Delete("delete from screeninfo where id = #{id}")
    int delete(Long id);
    
    @Delete("delete from screeninfo where ccode = #{cinemacode}")
    int deleteByCinemaCode(String cinemacode);

    int update(Screeninfo screeninfo);
    
 
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into screeninfo(CCode, SCode, SName, UpdateTime, SeatCount, Type, ScreenId) values(#{CCode}, #{SCode}, #{SName}, #{UpdateTime}, #{SeatCount}, #{Type}, #{ScreenId})")
    int save(Screeninfo screeninfo);
    
    int count(@Param("params") Map<String, Object> params);

    List<Screeninfo> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
