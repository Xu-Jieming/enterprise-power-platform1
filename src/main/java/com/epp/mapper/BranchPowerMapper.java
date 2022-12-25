package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.BranchPower;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BranchPowerMapper {
    //long countByExample(BranchPowerExample example);

    //int deleteByExample(BranchPowerExample example);

    int deleteByPrimaryKey(Integer branchPowerId);

    int insert(BranchPower record);

    int insertSelective(BranchPower record);

    List<BranchPower> selectByExample(BranchPowerExample example);

    BranchPower selectByPrimaryKey(Integer branchPowerId);


    @Select("select * from ")
    List<> selectAll();

    @Select("select * from ")
    IPage<> selectAll(Page page);

    ////int updateByExampleSelective(@Param("record") BranchPower record, @Param("example") BranchPowerExample example);

    //int updateByExample(@Param("record") BranchPower record, @Param("example") BranchPowerExample example);

    int updateByPrimaryKeySelective(BranchPower record);

    int updateByPrimaryKey(BranchPower record);
}