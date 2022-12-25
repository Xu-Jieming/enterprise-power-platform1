package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.Log;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface LogMapper {
    //long countByExample(LogExample example);

    //int deleteByExample(LogExample example);

    @Delete("    delete from log where log_id = #{logId,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer logId);

    @Insert("insert into log (action, created, data,  " +
            "      enterprise_id, admin_id) " +
            "    values (#{action,jdbcType=VARCHAR}, #{created,jdbcType=DATE}, #{data,jdbcType=VARCHAR},  " +
            "      #{enterpriseId,jdbcType=INTEGER}, #{adminId,jdbcType=INTEGER})")
    int insert(Log record);

//    int insertSelective(Log record);

//    List<Log> selectByExample(LogExample example);

    @Select(" select  " +
            "    from log " +
            "    where log_id = #{logId,jdbcType=INTEGER}")
    Log selectByPrimaryKey(Integer logId);


    @Select("select * from log")
    List<Log> selectAll();

    @Select("select * from log")
    IPage<Log> selectAll(Page page);


    ////int updateByExampleSelective(@Param("record") Log record, @Param("example") LogExample example);

    //int updateByExample(@Param("record") Log record, @Param("example") LogExample example);

//    int updateByPrimaryKeySelective(Log record);

    @Update(" update log " +
            "    set action = #{action,jdbcType=VARCHAR}, " +
            "      created = #{created,jdbcType=DATE}, " +
            "      data = #{data,jdbcType=VARCHAR}, " +
            "      enterprise_id = #{enterpriseId,jdbcType=INTEGER}, " +
            "      admin_id = #{adminId,jdbcType=INTEGER} " +
            "    where log_id = #{logId,jdbcType=INTEGER}")
    int updateByPrimaryKey(Log record);
}