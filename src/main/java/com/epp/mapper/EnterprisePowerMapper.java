package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.EnterprisePower;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EnterprisePowerMapper {
    //long countByExample(EnterprisePowerExample example);

    //int deleteByExample(EnterprisePowerExample example);

    @Delete("delete from enterprise_power" +
            " where enterprise_id = #{enterpriseId,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer enterpriseId);

    @Insert("insert into enterprise_power (enterprise_id," +
            "first_rate_power,second_rate_power,third_rate_power," +
            "sum_power,year,month)" +
            "values (#{enterpriseId,jdbcType=INTEGER}," +
            "#{firstRatePower,jdbcType=DOUBLE},#{secondRatePower,jdbcType=DOUBLE},#{thirdRatePower,jdbcType=DOUBLE}," +
            "#{sumPower,jdbcType=DOUBLE},#{year,jdbcType=INTEGER},#{month,jdbcType=INTEGER})")
    int insert(EnterprisePower record);


    @Select("select * from enterprise_power" +
            " where enterprise_id = #{enterpriseId,jdbcType=INTEGER}")
    EnterprisePower selectByPrimaryKey(Integer enterpriseId);

    @Select("select * from enterprise_power" +
            " where enterprise_id = #{enterpriseId,jdbcType=INTEGER}")
    List<EnterprisePower> selectByEnterprise(Integer enterpriseId);


    @Select("select * from enterprise_power" +
            " where enterprise_id = #{enterpriseId,jdbcType=INTEGER} and year = #{year,jdbcType=INTEGER}" +
            " and month = #{month,jdbcType=INTEGER}")
    EnterprisePower selectByEntity(@Param("enterpriseId") Integer enterpriseId,@Param("year") Integer year,@Param("month") Integer month);



    @Select("select * from enterprise_power")
    List<EnterprisePower> selectAll();

    @Select("select * from enterprise_power")
    IPage<EnterprisePower> selectAll(Page page);


    @Update(" update enterprise_power set first_rate_power = #{firstRatePower,jdbcType=DOUBLE}," +
            "second_rate_power = #{secondRatePower,jdbcType=DOUBLE}," +
            " third_rate_power = #{thirdRatePower,jdbcType=DOUBLE}," +
            " sum_power = #{sumPower,jdbcType=DOUBLE} where enterprise_id = #{enterpriseId,jdbcType=INTEGER} and year = #{year,jdbcType=INTEGER} " +
            " and month = #{month,jdbcType=INTEGER}")
    int updateByPrimaryKey(EnterprisePower record);
}