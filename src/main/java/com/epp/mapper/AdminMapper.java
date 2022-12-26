package com.epp.mapper;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
   ////long countByExample(AdminExample example);

    ////int deleteByExample(AdminExample example);

    @Delete("delete from admin where admin_id = #{adminId,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer adminId);


    @Delete("delete from admin where account = #{account,jdbcType=INTEGER}")
    int deleteByAccount(Integer account);

    @Options(useGeneratedKeys = true,keyProperty = "adminId")
    @Insert(" insert into admin (admin_name,account,pwd,role,enterprise_id)" +
            " values (#{adminName,jdbcType=VARCHAR},#{account,jdbcType=INTEGER},#{pwd,jdbcType=VARCHAR}," +
            " #{role,jdbcType=INTEGER},#{enterpriseId,jdbcType=INTEGER})")
    int insert(Admin record);

    //int insertSelective(Admin record);

    //List<Admin> selectByExample(AdminExample example);

    @Select("select * from admin where admin_id = #{adminId,jdbcType=INTEGER}")
    Admin selectByPrimaryKey(Integer adminId);

    @Select("select * from admin where account = #{account,jdbcType=INTEGER}")
    Admin selectByAccount(Integer account);

    @Select(" select * from admin ")
    List<Admin> selectAll();

    @Select(" select * from admin ")
    IPage<Admin> selectAll(Page page);

    //////int updateByExampleSelective(@Param("record") Admin record,@Param("example") AdminExample example);

    ////int updateByExample(@Param("record") Admin record,@Param("example") AdminExample example);

    //int updateByPrimaryKeySelective(Admin record);

    @Update("update admin set admin_name = #{adminName,jdbcType=VARCHAR}," +
            " account = #{account,jdbcType=INTEGER}," +
            " pwd = #{pwd,jdbcType=VARCHAR}," +
            " role = #{role,jdbcType=INTEGER}," +
            " enterprise_id = #{enterpriseId,jdbcType=INTEGER}" +
            " where admin_id = #{adminId,jdbcType=INTEGER}")
    int updateByPrimaryKey(Admin record);
}