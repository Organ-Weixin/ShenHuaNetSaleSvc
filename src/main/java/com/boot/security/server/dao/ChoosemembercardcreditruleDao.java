package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Choosemembercardcreditrule;

@Mapper
public interface ChoosemembercardcreditruleDao {

    @Select("select * from choosemembercardcreditrule t where t.id = #{id}")
    Choosemembercardcreditrule getById(Long id);

    @Delete("delete from choosemembercardcreditrule where id = #{id}")
    int delete(Long id);

    int update(Choosemembercardcreditrule choosemembercardcreditrule);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into choosemembercardcreditrule(Id, CinemaCode, LevelCode, RuleCode, RuleType) values(#{Id}, #{CinemaCode}, #{LevelCode}, #{RuleCode}, #{RuleType})")
    int save(Choosemembercardcreditrule choosemembercardcreditrule);
    
    int count(@Param("params") Map<String, Object> params);

    List<Choosemembercardcreditrule> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from choosemembercardcreditrule t where t.cinemacode = #{cinemacode} and (t.levelcode = #{levelcode} or find_in_set(#{levelcode},t.levelcode)) and t.ruleType =1")
    Choosemembercardcreditrule getOpenTypeByLevelCode(@Param("cinemacode") String cinemacode,@Param("levelcode") String levelcode);
    
    @Select("select * from choosemembercardcreditrule t where t.cinemacode = #{cinemacode} and (t.levelcode = #{levelcode} or find_in_set(#{levelcode},t.levelcode)) and t.ruleType =2")
    List<Choosemembercardcreditrule> getRechargeTypeListByLevelCode(@Param("cinemacode") String cinemacode,@Param("levelcode") String levelcode);
    
    @Select("select * from choosemembercardcreditrule t where t.cinemacode = #{cinemacode} and (t.levelcode = #{levelcode} or find_in_set(#{levelcode},t.levelcode))")
    List<Choosemembercardcreditrule> getByLevelCode(@Param("cinemacode") String cinemacode,@Param("levelcode") String levelcode);
    
    @Delete("delete from choosemembercardcreditrule where cinemacode = #{cinemacode} and levelcode =#{levelcode}")
    int deleteByLevelCode(@Param("cinemacode") String cinemacode,@Param("levelcode") String levelcode);
    
    @Select("select * from choosemembercardcreditrule t where t.cinemacode =#{cinemacode} and t.levelcode =#{levelcode} and rulecode = #{rulecode}")
    Choosemembercardcreditrule getByRuleCode(@Param("cinemacode") String cinemacode,@Param("levelcode")String levelcode,@Param("rulecode") String rulecode);
}
