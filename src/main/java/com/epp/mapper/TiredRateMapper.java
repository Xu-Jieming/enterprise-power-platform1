package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.TiredRate;
import org.apache.ibatis.annotations.*;

import java.util.List;



@Mapper
public interface TiredRateMapper {

    //long countByExample(TiredRateExample example);

    //int deleteByExample(TiredRateExample example);

    @Delete("delete from tired_rate where rate_id = #{rateId,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer rateId);

    @Insert("insert into tired_rate (first_rate_interval,second_rate_interval," +
            "third_rate_interval,first_tired_rate,second_tired_rate," +
            "third_tired_rate,year,month," +
            "comment,first_rate_content,second_rate_content," +
            "third_rate_content)" +
            "values (#{firstRateInterval,jdbcType=INTEGER},#{secondRateInterval,jdbcType=INTEGER}," +
            "#{thirdRateInterval,jdbcType=INTEGER},#{firstTiredRate,jdbcType=DOUBLE},#{secondTiredRate,jdbcType=DOUBLE}," +
            "#{thirdTiredRate,jdbcType=DOUBLE},#{year,jdbcType=INTEGER},#{month,jdbcType=INTEGER}," +
            "#{comment,jdbcType=VARCHAR},#{firstRateContent,jdbcType=VARCHAR},#{secondRateContent,jdbcType=VARCHAR}," +
            "#{thirdRateContent,jdbcType=VARCHAR})")
    int insert(TiredRate record);

//    int insertSelective(TiredRate record);

//    List<TiredRate> selectByExample(TiredRateExample example);

    @Select("select * from tired_rate" +
            " where rate_id = #{rateId,jdbcType=INTEGER}")
    TiredRate selectByPrimaryKey(Integer rateId);


    @Select("select * from tired_rate" +
            " where year = #{year,jdbcType=INTEGER} and month = #{month,jdbcType=INTEGER}")
    TiredRate selectByTime(Integer year,Integer month);


    @Select("select * from tired_rate")
    List<TiredRate> selectAll();

    @Select("select * from tired_rate")
    IPage<TiredRate> selectAll(Page page);


    ////int updateByExampleSelective(@Param("record") TiredRate record,@Param("example") TiredRateExample example);

    //int updateByExample(@Param("record") TiredRate record,@Param("example") TiredRateExample example);

//    int updateByPrimaryKeySelective(TiredRate record);

    @Update("update tired_rate" +
            "set first_rate_interval = #{firstRateInterval,jdbcType=INTEGER}," +
            "second_rate_interval = #{secondRateInterval,jdbcType=INTEGER}," +
            "third_rate_interval = #{thirdRateInterval,jdbcType=INTEGER}," +
            "first_tired_rate = #{firstTiredRate,jdbcType=DOUBLE}," +
            "second_tired_rate = #{secondTiredRate,jdbcType=DOUBLE}," +
            "third_tired_rate = #{thirdTiredRate,jdbcType=DOUBLE}," +
            "year = #{year,jdbcType=INTEGER}," +
            "month = #{month,jdbcType=INTEGER}," +
            "comment = #{comment,jdbcType=VARCHAR}," +
            "first_rate_content = #{firstRateContent,jdbcType=VARCHAR}," +
            "second_rate_content = #{secondRateContent,jdbcType=VARCHAR}," +
            "third_rate_content = #{thirdRateContent,jdbcType=VARCHAR}" +
            " where rate_id = #{rateId,jdbcType=INTEGER}")
    int updateByPrimaryKey(TiredRate record);
}