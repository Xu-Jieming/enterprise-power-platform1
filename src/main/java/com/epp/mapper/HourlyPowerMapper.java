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

    @Insert("    insert into hourly_power (branch_id, enterprise_id, first_period_power, " +
            "      double_period_power, third_period_power, forth_period_power, " +
            "      branch_set, day, month, " +
            "      year)" +
            "    values (#{branchId,jdbcType=INTEGER}, #{enterpriseId,jdbcType=INTEGER}, #{firstPeriodPower,jdbcType=DOUBLE}, " +
            "      #{doublePeriodPower,jdbcType=DOUBLE}, #{thirdPeriodPower,jdbcType=DOUBLE}, #{forthPeriodPower,jdbcType=DOUBLE}, " +
            "      #{branchSet,jdbcType=INTEGER}, #{day,jdbcType=INTEGER}, #{month,jdbcType=INTEGER}, " +
            "      #{year,jdbcType=INTEGER})")
    int insert(HourlyPower record);

    //int insertSelective(HourlyPower record);

    //List<HourlyPower> selectByExample(HourlyPowerExample example);

    @Select("    select from hourly_power" +
            "    where hour_id = #{hourId,jdbcType=INTEGER}")
    HourlyPower selectByPrimaryKey(Integer hourId);

    @Select("select * from hourly_power")
    List<HourlyPower> selectAll();

    @Select("select * from hourly_power")
    IPage<HourlyPower> selectAll(Page page);



    ////int updateByExampleSelective(@Param("record") HourlyPower record, @Param("example") HourlyPowerExample example);

    //int updateByExample(@Param("record") HourlyPower record, @Param("example") HourlyPowerExample example);

    //int updateByPrimaryKeySelective(HourlyPower record);

    @Update("    update hourly_power" +
            "    set branch_id = #{branchId,jdbcType=INTEGER}," +
            "      enterprise_id = #{enterpriseId,jdbcType=INTEGER}," +
            "      first_period_power = #{firstPeriodPower,jdbcType=DOUBLE}," +
            "      double_period_power = #{doublePeriodPower,jdbcType=DOUBLE}," +
            "      third_period_power = #{thirdPeriodPower,jdbcType=DOUBLE}," +
            "      forth_period_power = #{forthPeriodPower,jdbcType=DOUBLE}," +
            "      branch_set = #{branchSet,jdbcType=INTEGER}," +
            "      day = #{day,jdbcType=INTEGER}," +
            "      month = #{month,jdbcType=INTEGER}," +
            "      year = #{year,jdbcType=INTEGER}" +
            "    where hour_id = #{hourId,jdbcType=INTEGER}")
    int updateByPrimaryKey(HourlyPower record);
}