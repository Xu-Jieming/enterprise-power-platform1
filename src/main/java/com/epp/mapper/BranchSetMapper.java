package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.BranchSet;
import com.epp.pojo.BranchSetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BranchSetMapper {
    //long countByExample(BranchSetExample example);

    //int deleteByExample(BranchSetExample example);

    int deleteByPrimaryKey(Integer branchId);

    int insert(BranchSet record);

    int insertSelective(BranchSet record);

    List<BranchSet> selectByExample(BranchSetExample example);

    BranchSet selectByPrimaryKey(Integer branchId);



    @Select("select * from ")
    List<> selectAll();

    @Select("select * from ")
    IPage<> selectAll(Page page);


    ////int updateByExampleSelective(@Param("record") BranchSet record, @Param("example") BranchSetExample example);

    //int updateByExample(@Param("record") BranchSet record, @Param("example") BranchSetExample example);

    int updateByPrimaryKeySelective(BranchSet record);

    int updateByPrimaryKey(BranchSet record);
}