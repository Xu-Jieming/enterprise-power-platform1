package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.BranchPower;

import java.util.List;

import com.epp.pojo.HourlyPower;
import org.apache.ibatis.annotations.*;


@Mapper
public interface BranchPowerMapper {
    //long countByExample(BranchPowerExample example);

    //int deleteByExample(BranchPowerExample example);

    @Delete(" delete from branch_power where branch_power_id = #{branchPowerId,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer branchPowerId);

    @Insert("insert into branch_power (branch_id,enterprise_id,first_branch_power," +
            " second_branch_power,third_branch_power,forth_branch_power," +
            "year,month,day)" +
            "values (#{branchId,jdbcType=INTEGER},#{enterpriseId,jdbcType=INTEGER},#{firstBranchPower,jdbcType=DOUBLE}," +
            "#{secondBranchPower,jdbcType=DOUBLE},#{thirdBranchPower,jdbcType=DOUBLE},#{forthBranchPower,jdbcType=DOUBLE}," +
            "#{year,jdbcType=INTEGER},#{month,jdbcType=INTEGER},#{day,jdbcType=INTEGER})")
    int insert(BranchPower record);

    //int insertSelective(BranchPower record);

    //List<BranchPower> selectByExample(BranchPowerExample example);

    @Select("select * from branch_power" +
            " where branch_power_id = #{branchPowerId,jdbcType=INTEGER}")
    BranchPower selectByPrimaryKey(Integer branchPowerId);



    /*
    * 多个参数要用Parm，否则就会出现Parameter 'enterpriseId' not found
    * */
    @Select("select * from branch_power" +
            " where enterprise_id = #{enterpriseId,jdbcType=INTEGER} and year = #{year} and month = #{month} and day = #{day}")
    BranchPower selectByEntity(@Param("enterpriseId") Integer enterpriseId,@Param("year") Integer year,@Param("month") Integer month,@Param("day") Integer day);


    @Select("select * from branch_power where year = #{year} and month = #{month} and day = #{day}")
    IPage<BranchPower> selectAll(@Param("page") Page page,@Param("year") Integer year,@Param("month") Integer month,@Param("day") Integer day);

    @Select("select * from branch_power")
    List<BranchPower> selectAll();

    @Select("select * from branch_power")
    IPage<BranchPower> selectAll(Page page);

    ////int updateByExampleSelective(@Param("record") BranchPower record,@Param("example") BranchPowerExample example);

    //int updateByExample(@Param("record") BranchPower record,@Param("example") BranchPowerExample example);

    //int updateByPrimaryKeySelective(BranchPower record);
    @Update("update branch_power set first_branch_power = #{firstBranchPower,jdbcType=DOUBLE}," +
            " second_branch_power = #{secondBranchPower,jdbcType=DOUBLE}," +
            "third_branch_power = #{thirdBranchPower,jdbcType=DOUBLE}," +
            "forth_branch_power = #{forthBranchPower,jdbcType=DOUBLE} " +
            "where enterprise_id = #{enterpriseId,jdbcType=INTEGER} and year = #{year,jdbcType=INTEGER} " +
            "and month = #{month,jdbcType=INTEGER} and day = #{day,jdbcType=INTEGER}")
    int updateByPrimaryKey(BranchPower record);
}