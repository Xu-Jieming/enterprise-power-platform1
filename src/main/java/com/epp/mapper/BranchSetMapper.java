package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.BranchSet;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface BranchSetMapper {
    //long countByExample(BranchSetExample example);

    //int deleteByExample(BranchSetExample example);

    @Delete("    delete from branch_set" +
            "    where branch_id = #{branchId,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer branchId);


    @Insert("    insert into branch_set (enterprise_id, first_branch_set, second_branch_set, " +
            "      third_branch_set, forth_branch_set)" +
            "    values (#{enterpriseId,jdbcType=INTEGER}, #{firstBranchSet,jdbcType=INTEGER}, #{secondBranchSet,jdbcType=INTEGER}, " +
            "      #{thirdBranchSet,jdbcType=INTEGER}, #{forthBranchSet,jdbcType=INTEGER})")
    int insert(BranchSet record);

//    int insertSelective(BranchSet record);

//    List<BranchSet> selectByExample(BranchSetExample example);


    @Select("    select from branch_set" +
            "    where enterprise_id = #{enterpriseId,jdbcType=INTEGER}")
    BranchSet selectByEnterpriseId(Integer enterpriseId);


    @Select("select * from branch_set")
    List<BranchSet> selectAll();

    @Select("select * from branch_set")
    IPage<BranchSet> selectAll(Page page);


    ////int updateByExampleSelective(@Param("record") BranchSet record, @Param("example") BranchSetExample example);

    //int updateByExample(@Param("record") BranchSet record, @Param("example") BranchSetExample example);

//    int updateByPrimaryKeySelective(BranchSet record);

    @Update("    update branch_set" +
            "    set enterprise_id = #{enterpriseId,jdbcType=INTEGER}," +
            "      first_branch_set = #{firstBranchSet,jdbcType=INTEGER}," +
            "      second_branch_set = #{secondBranchSet,jdbcType=INTEGER}," +
            "      third_branch_set = #{thirdBranchSet,jdbcType=INTEGER}," +
            "      forth_branch_set = #{forthBranchSet,jdbcType=INTEGER}" +
            "    where branch_id = #{branchId,jdbcType=INTEGER}")
    int updateByPrimaryKey(BranchSet record);
}