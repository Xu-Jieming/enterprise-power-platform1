package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.Forewarn;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface ForewarnMapper {
    //long countByExample(ForewarnExample example);

    //int deleteByExample(ForewarnExample example);

    @Delete("delete from forewarn where forewarn_id = #{forewarnId,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer forewarnId);

    @Insert("insert into forewarn (enterprise_id,warning_time,warning_power,warning_frequency,created) " +
            " values (#{enterpriseId,jdbcType=INTEGER},#{warningTime,jdbcType=VARCHAR},#{warningPower,jdbcType=DOUBLE}," +
            " #{warningFrequency,jdbcType=INTEGER},#{created,jdbcType=DATE})")
    int insert(Forewarn record);

//    int insertSelective(Forewarn record);

//    List<Forewarn> selectByExample(ForewarnExample example);

    @Select("select * from forewarn " +
            " where forewarn_id = #{forewarnId,jdbcType=INTEGER}")
    Forewarn selectByPrimaryKey(Integer forewarnId);


    @Select("select * from forewarn")
    List<Forewarn> selectAll();

    @Select("select * from forewarn")
    IPage<Forewarn> selectAll(Page page);


    ////int updateByExampleSelective(@Param("record") Forewarn record,@Param("example") ForewarnExample example);

    //int updateByExample(@Param("record") Forewarn record,@Param("example") ForewarnExample example);

//    int updateByPrimaryKeySelective(Forewarn record);

    @Update("update forewarn " +
            "set enterprise_id = #{enterpriseId,jdbcType=INTEGER}," +
            "warning_time = #{warningTime,jdbcType=VARCHAR}," +
            "warning_power = #{warningPower,jdbcType=DOUBLE}," +
            "warning_frequency = #{warningFrequency,jdbcType=INTEGER}," +
            "created = #{created,jdbcType=DATE} " +
            "where forewarn_id = #{forewarnId,jdbcType=INTEGER}")
    int updateByPrimaryKey(Forewarn record);
}