package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.HourlyPower;
import com.epp.pojo.HourlyPowerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HourlyPowerMapper {
    //long countByExample(HourlyPowerExample example);

    //int deleteByExample(HourlyPowerExample example);

    int deleteByPrimaryKey(Integer hourId);

    int insert(HourlyPower record);

    int insertSelective(HourlyPower record);

    List<HourlyPower> selectByExample(HourlyPowerExample example);

    HourlyPower selectByPrimaryKey(Integer hourId);

    @Select("select * from ")
    List<> selectAll();

    @Select("select * from ")
    IPage<> selectAll(Page page);


    ////int updateByExampleSelective(@Param("record") HourlyPower record, @Param("example") HourlyPowerExample example);

    //int updateByExample(@Param("record") HourlyPower record, @Param("example") HourlyPowerExample example);

    int updateByPrimaryKeySelective(HourlyPower record);

    int updateByPrimaryKey(HourlyPower record);
}