package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.EnterprisePower;
import com.epp.pojo.EnterprisePowerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EnterprisePowerMapper {
    //long countByExample(EnterprisePowerExample example);

    //int deleteByExample(EnterprisePowerExample example);

    int deleteByPrimaryKey(Integer enterprisePowerId);

    int insert(EnterprisePower record);

    int insertSelective(EnterprisePower record);

    List<EnterprisePower> selectByExample(EnterprisePowerExample example);

    EnterprisePower selectByPrimaryKey(Integer enterprisePowerId);


    @Select("select * from ")
    List<> selectAll();

    @Select("select * from ")
    IPage<> selectAll(Page page);


    ////int updateByExampleSelective(@Param("record") EnterprisePower record, @Param("example") EnterprisePowerExample example);

    //int updateByExample(@Param("record") EnterprisePower record, @Param("example") EnterprisePowerExample example);

    int updateByPrimaryKeySelective(EnterprisePower record);

    int updateByPrimaryKey(EnterprisePower record);
}