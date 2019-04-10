package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Screenseatinfo;

@Mapper
public interface ScreenseatinfoDao {
	///根据影院、影厅编码获取座位信息
	@Select("select * from screenseatinfo t where t.CinemaCode = #{cinemacode} and t.ScreenCode = #{screencode}")
	List<Screenseatinfo> getByCinemaCodeAndScreenCode(@Param("cinemacode")String cinemacode,@Param("screencode")String screencode);
	
	//根据场区编码分组，去重复
	@Select("select * from screenseatinfo t where t.CinemaCode = #{cinemacode} and t.ScreenCode = #{screencode} GROUP BY GroupCode")
	List<Screenseatinfo> getGroupByGroupCode(@Param("cinemacode") String cinemacode,@Param("screencode") String screencode);
		
	////
	@Select("select * from screenseatinfo t where t.cinemacode = #{cinemacode} and t.screencode=#{screencode} and t.seatcode in(#{seatcodes})")
    List<Screenseatinfo> getBySeatCodes(@Param("cinemacode")String cinemacode,@Param("screencode")String screencode,@Param("seatcodes")String seatcodes);
	
	//查询情侣座
	@Select("select * from screenseatinfo t where t.CinemaCode = #{cinemacode} and t.ScreenCode = #{screencode} and t.LoveFlag ='Y'")
	List<Screenseatinfo> queryLoveSeats(@Param("cinemacode")String cinemacode,@Param("screencode")String screencode);
	
    @Select("select * from screenseatinfo t where t.id = #{id}")
    Screenseatinfo getById(Long id);

    @Delete("delete from screenseatinfo where id = #{id}")
    int delete(Long id);
    
    //删除座位信息
    @Delete("delete from screenseatinfo where cinemacode = #{cinemacode} and screencode = #{screencode}")
    int deleteByScreenCode(@Param("cinemacode")String cinemacode,@Param("screencode")String screencode);
    
    int update(Screenseatinfo screenseatinfo);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into screenseatinfo(CinemaCode, ScreenCode, SeatCode, GroupCode, RowNum, ColumnNum, XCoord, YCoord, Status, LoveFlag, Type, UpdateTime, SeatId) values(#{CinemaCode}, #{ScreenCode}, #{SeatCode}, #{GroupCode}, #{RowNum}, #{ColumnNum}, #{XCoord}, #{YCoord}, #{Status}, #{LoveFlag}, #{Type}, #{UpdateTime}, #{SeatId})")
    int save(Screenseatinfo screenseatinfo);
    
    int count(@Param("params") Map<String, Object> params);

    List<Screenseatinfo> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
