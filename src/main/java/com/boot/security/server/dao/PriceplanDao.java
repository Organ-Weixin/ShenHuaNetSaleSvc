package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Priceplan;

@Mapper
public interface PriceplanDao {
	
	int count(@Param("params") Map<String, Object> params);

    List<Priceplan> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select * from priceplan t where t.id = #{id}")
    Priceplan getById(Long id);

    @Delete("delete from priceplan where id = #{id}")
    int delete(Long id);

    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into priceplan(CinemaCode, Code, UserID, Price, TicketFee, AddFee, CinemaAllowance, Type) values(#{CinemaCode}, #{Code}, #{UserID}, #{Price}, #{TicketFee}, #{AddFee}, #{CinemaAllowance}, #{Type})")
    int save(Priceplan priceplan);
    
    int updatePriceplan(Priceplan priceplan);
    
    @Select("select * from priceplan where CinemaCode=#{CinemaCode} and Code=#{Code} and UserID=#{UserID}")
    Priceplan selectPrice(Priceplan priceplan);
}
