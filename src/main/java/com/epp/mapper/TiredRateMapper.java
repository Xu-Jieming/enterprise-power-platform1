package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.TiredRate;
import com.epp.pojo.TiredRateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TiredRateMapper {
    //long countByExample(TiredRateExample example);

    //int deleteByExample(TiredRateExample example);

    int deleteByPrimaryKey(Integer rateId);

    int insert(TiredRate record);

    int insertSelective(TiredRate record);

    List<TiredRate> selectByExample(TiredRateExample example);

    TiredRate selectByPrimaryKey(Integer rateId);

    @Select("select * from ")
    List<> selectAll();

    @Select("select * from ")
    IPage<> selectAll(Page page);


    ////int updateByExampleSelective(@Param("record") TiredRate record, @Param("example") TiredRateExample example);

    //int updateByExample(@Param("record") TiredRate record, @Param("example") TiredRateExample example);

    int updateByPrimaryKeySelective(TiredRate record);

    int updateByPrimaryKey(TiredRate record);
}