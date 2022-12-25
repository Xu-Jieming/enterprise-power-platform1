package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.EnterprisePower;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface EnterprisePowerMapper {
    //long countByExample(EnterprisePowerExample example);

    //int deleteByExample(EnterprisePowerExample example);

    @Delete("    delete from enterprise_power" +
            "    where enterprise_power_id = #{enterprisePowerId,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer enterprisePowerId);

    @Insert("    insert into enterprise_power (enterprise_id, enterprise_account, " +
            "      first_period_power, second_period_power, third_period_power, " +
            "      forth_period_power, year, month, " +
            "      day)" +
            "    values (#{enterpriseId,jdbcType=INTEGER}, #{enterpriseAccount,jdbcType=INTEGER}, " +
            "      #{firstPeriodPower,jdbcType=VARCHAR}, #{secondPeriodPower,jdbcType=VARCHAR}, #{thirdPeriodPower,jdbcType=VARCHAR}, " +
            "      #{forthPeriodPower,jdbcType=VARCHAR}, #{year,jdbcType=INTEGER}, #{month,jdbcType=INTEGER}, " +
            "      #{day,jdbcType=INTEGER})")
    int insert(EnterprisePower record);

//    int insertSelective(EnterprisePower record);

//    List<EnterprisePower> selectByExample(EnterprisePowerExample example);

    @Select("    select from enterprise_power" +
            "    where enterprise_power_id = #{enterprisePowerId,jdbcType=INTEGER}")
    EnterprisePower selectByPrimaryKey(Integer enterprisePowerId);


    @Select("select * from enterprise_power")
    List<EnterprisePower> selectAll();

    @Select("select * from enterprise_power")
    IPage<EnterprisePower> selectAll(Page page);


    ////int updateByExampleSelective(@Param("record") EnterprisePower record, @Param("example") EnterprisePowerExample example);

    //int updateByExample(@Param("record") EnterprisePower record, @Param("example") EnterprisePowerExample example);

//    int updateByPrimaryKeySelective(EnterprisePower record);

    @Update("    update enterprise_power" +
            "    set enterprise_id = #{enterpriseId,jdbcType=INTEGER}," +
            "      enterprise_account = #{enterpriseAccount,jdbcType=INTEGER}," +
            "      first_period_power = #{firstPeriodPower,jdbcType=VARCHAR}," +
            "      second_period_power = #{secondPeriodPower,jdbcType=VARCHAR}," +
            "      third_period_power = #{thirdPeriodPower,jdbcType=VARCHAR}," +
            "      forth_period_power = #{forthPeriodPower,jdbcType=VARCHAR}," +
            "      year = #{year,jdbcType=INTEGER}," +
            "      month = #{month,jdbcType=INTEGER}," +
            "      day = #{day,jdbcType=INTEGER}" +
            "    where enterprise_power_id = #{enterprisePowerId,jdbcType=INTEGER}")
    int updateByPrimaryKey(EnterprisePower record);
}