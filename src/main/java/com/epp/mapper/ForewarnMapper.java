package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.Forewarn;
import com.epp.pojo.ForewarnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ForewarnMapper {
    //long countByExample(ForewarnExample example);

    //int deleteByExample(ForewarnExample example);

    int deleteByPrimaryKey(Integer forewarnId);

    int insert(Forewarn record);

    int insertSelective(Forewarn record);

    List<Forewarn> selectByExample(ForewarnExample example);

    Forewarn selectByPrimaryKey(Integer forewarnId);


    @Select("select * from ")
    List<> selectAll();

    @Select("select * from ")
    IPage<> selectAll(Page page);


    ////int updateByExampleSelective(@Param("record") Forewarn record, @Param("example") ForewarnExample example);

    //int updateByExample(@Param("record") Forewarn record, @Param("example") ForewarnExample example);

    int updateByPrimaryKeySelective(Forewarn record);

    int updateByPrimaryKey(Forewarn record);
}