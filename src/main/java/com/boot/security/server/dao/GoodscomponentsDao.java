package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Goodscomponents;

@Mapper
public interface GoodscomponentsDao {

    @Select("select * from goodscomponents t where t.id = #{id}")
    Goodscomponents getById(Long id);
    
    //根据套餐编码查询
    @Select("select * from goodscomponents t where t.CinemaCode = #{cinemacode} and t.PackageCode = #{packagecode}")
    List<Goodscomponents> getByPackageCode(@Param("cinemacode") String cinemacode,@Param("packagecode") String packagecode);
    
    @Select("select * from goodscomponents t where goodscode = #{goodscode}")
    Goodscomponents getByGoodsCode(String goodscode);
    
    @Delete("delete from goodscomponents where id = #{id}")
    int delete(Long id);
    
    //根据套餐编码删除
    @Delete("delete from goodscomponents where CinemaCode = #{cinemacode} and PackageCode = #{packagecode}")
    int deleteByPackageCode(@Param("cinemacode") String cinemacode,@Param("packagecode") String packagecode);
    
    @Delete("delete from goodscomponents where goodscode = #{goodscode}")
    int deleteByGoodsCode(String goodscode);
    
    int update(Goodscomponents goodscomponents);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into goodscomponents(CinemaCode, PackageCode, PackageName, PackagePic, GoodsCode, GoodsName, GoodsCount, GoodsStandardPrice, GoodsSettlePrice, PackageStandardPrice, PackageSettlePrice, RecommendCode, Status, Sort, UnitName) values(#{CinemaCode}, #{PackageCode}, #{PackageName}, #{PackagePic}, #{GoodsCode}, #{GoodsName}, #{GoodsCount}, #{GoodsStandardPrice}, #{GoodsSettlePrice}, #{PackageStandardPrice}, #{PackageSettlePrice}, #{RecommendCode}, #{Status}, #{Sort}, #{UnitName})")
    int save(Goodscomponents goodscomponents);
    
    int count(@Param("params") Map<String, Object> params);

    List<Goodscomponents> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
