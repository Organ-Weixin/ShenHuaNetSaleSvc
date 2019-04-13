package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Orderseatdetails;

@Mapper
public interface OrderseatdetailsDao {

    @Select("select * from orderseatdetails t where t.id = #{id}")
    Orderseatdetails getById(Long id);
    
    @Select("select * from orderseatdetails t where t.orderid = #{orderid}")
    List<Orderseatdetails> getByOrderId(Long orderid);

    @Delete("delete from orderseatdetails where id = #{id}")
    int delete(Long id);

    int update(Orderseatdetails orderseatdetails);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into orderseatdetails(Id, OrderId, SeatCode, RowNum, ColumnNum, XCoord, YCoord, Price, SalePrice, Fee, AddFee,CinemaAllowance,FilmTicketCode, TicketInfoCode, PrintFlag, SeatId, Created, Updated, Deleted) values(#{Id}, #{OrderId}, #{SeatCode}, #{RowNum}, #{ColumnNum}, #{XCoord}, #{YCoord}, #{Price}, #{SalePrice}, #{Fee}, #{AddFee},#{CinemaAllowance},#{FilmTicketCode}, #{TicketInfoCode}, #{PrintFlag}, #{SeatId}, #{Created}, #{Updated}, #{Deleted})")
    int save(Orderseatdetails orderseatdetails);
    
    int count(@Param("params") Map<String, Object> params);

    List<Orderseatdetails> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
