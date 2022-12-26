package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.EnterpriseDailyPower;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface EnterpriseDailyPowerMapper {
    //long countByExample(EnterpriseDailyPowerExample example);

    //int deleteByExample(EnterpriseDailyPowerExample example);

    @Delete("delete from enterprise_daily_power" +
            " where enterprise_daily_power_id = #{daily_power_id,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer daily_power_id);

    @Insert("insert into enterprise_daily_power (enterprise_id,enterprise_account," +
            "first_period_power,second_period_power,third_period_power," +
            "forth_period_power,daily_period_power,year,month,day)" +
            "values (#{enterpriseId,jdbcType=INTEGER},#{enterpriseAccount,jdbcType=INTEGER}," +
            "#{firstPeriodPower,jdbcType=DOUBLE},#{secondPeriodPower,jdbcType=DOUBLE},#{thirdPeriodPower,jdbcType=DOUBLE}," +
            "#{forthPeriodPower,jdbcType=DOUBLE},#{dailyPower,jdbcType=DOUBLE},#{year,jdbcType=INTEGER},#{month,jdbcType=INTEGER}," +
            "#{day,jdbcType=INTEGER})")
    int insert(EnterpriseDailyPower record);

//    int insertSelective(EnterpriseDailyPower record);

//    List<EnterpriseDailyPower> selectByExample(EnterpriseDailyPowerExample example);

    @Select("select * from enterprise_daily_power" +
            " where enterprise_daily_power_id = #{daily_power_id,jdbcType=INTEGER}")
    EnterpriseDailyPower selectByPrimaryKey(Integer daily_power_id);

    @Select("select * from enterprise_daily_power" +
            " where enterprise_id = #{enterpriseId,jdbcType=INTEGER}")
    List<EnterpriseDailyPower> selectByEnterprise(Integer enterpriseId);


    @Select("select * from enterprise_daily_power " +
            "where enterprise_id = #{enterpriseId,jdbcType=INTEGER} " +
            "and year = #{year,jdbcType=INTEGER} and month = #{month,jdbcType=INTEGER}")
    List<EnterpriseDailyPower> selectByEnterprise(Integer enterpriseId,Integer year,Integer month);


    @Select("select * from enterprise_daily_power")
    List<EnterpriseDailyPower> selectAll();

    @Select("select * from enterprise_daily_power")
    IPage<EnterpriseDailyPower> selectAll(Page page);


    ////int updateByExampleSelective(@Param("record") EnterpriseDailyPower record,@Param("example") EnterpriseDailyPowerExample example);

    //int updateByExample(@Param("record") EnterpriseDailyPower record,@Param("example") EnterpriseDailyPowerExample example);

//    int updateByPrimaryKeySelective(EnterpriseDailyPower record);

    @Update("update enterprise_daily_power set enterprise_account = #{enterpriseAccount,jdbcType=INTEGER}," +
            "first_period_power = #{firstPeriodPower,jdbcType=DOUBLE}," +
            "second_period_power = #{secondPeriodPower,jdbcType=DOUBLE}," +
            "third_period_power = #{thirdPeriodPower,jdbcType=DOUBLE}," +
            "forth_period_power = #{forthPeriodPower,jdbcType=DOUBLE}," +
            "daily_period_power = #{dailyPower,jdbcType=DOUBLE} " +
            "where enterprise_id = #{enterpriseId,jdbcType=INTEGER} and  year = #{year,jdbcType=INTEGER} " +
            "and month = #{month,jdbcType=INTEGER} and day = #{day,jdbcType=INTEGER}")
    int updateByPrimaryKey(EnterpriseDailyPower record);
}