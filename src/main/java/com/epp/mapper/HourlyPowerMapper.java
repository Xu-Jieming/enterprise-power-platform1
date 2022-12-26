package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.HourlyPower;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface HourlyPowerMapper {
    //long countByExample(HourlyPowerExample example);

    //int deleteByExample(HourlyPowerExample example);

    @Delete("delete from hourly_power where hour_id = #{hourId,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer hourId);

    @Insert("insert into hourly_power (branch_id,enterprise_id,first_period_power," +
            "second_period_power,third_period_power,forth_period_power," +
            "branch_set,day,month," +
            "year)" +
            "values (#{branchId,jdbcType=INTEGER},#{enterpriseId,jdbcType=INTEGER},#{firstPeriodPower,jdbcType=DOUBLE}," +
            "#{secondPeriodPower,jdbcType=DOUBLE},#{thirdPeriodPower,jdbcType=DOUBLE},#{forthPeriodPower,jdbcType=DOUBLE}," +
            "#{branchSet,jdbcType=INTEGER},#{day,jdbcType=INTEGER},#{month,jdbcType=INTEGER}," +
            "#{year,jdbcType=INTEGER})")
    int insert(HourlyPower record);

    //int insertSelective(HourlyPower record);

    //List<HourlyPower> selectByExample(HourlyPowerExample example);

    @Select("select * from hourly_power" +
            " where enterprise_id = #{enterpriseId,jdbcType=INTEGER}")
    HourlyPower selectByPrimaryKey(Integer enterpriseId);

    @Select("select * from hourly_power")
    List<HourlyPower> selectAll();

    @Select("select * from hourly_power")
    IPage<HourlyPower> selectAll(Page page);

    @Select("select * from hourly_power" +
            " where enterprise_id = #{enterpriseId} and year = #{year} and month = #{month} and day = #{day} ")
    List<HourlyPower> selectByEntity(@Param("enterpriseId") Integer enterpriseId,@Param("year") Integer year,@Param("month") Integer month,@Param("day") Integer day);

    ////int updateByExampleSelective(@Param("record") HourlyPower record,@Param("example") HourlyPowerExample example);

    //int updateByExample(@Param("record") HourlyPower record,@Param("example") HourlyPowerExample example);

    //int updateByPrimaryKeySelective(HourlyPower record);

    @Update("update hourly_power set first_period_power = #{firstPeriodPower,jdbcType=DOUBLE}," +
            "second_period_power = #{secondPeriodPower,jdbcType=DOUBLE}," +
            "third_period_power = #{thirdPeriodPower,jdbcType=DOUBLE}," +
            "forth_period_power = #{forthPeriodPower,jdbcType=DOUBLE}," +
            "where enterprise_id = #{enterpriseId,jdbcType=INTEGER} and branch_id = #{branchId,jdbcType=INTEGER} " +
            "and branch_set = #{branchSet,jdbcType=INTEGER} and year = #{year,jdbcType=INTEGER} " +
            "and month = #{month,jdbcType=INTEGER} and day = #{day,jdbcType=INTEGER}")
    int updateByPrimaryKey(HourlyPower record);
}