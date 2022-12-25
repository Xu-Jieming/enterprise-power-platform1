package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.Enterprise;

import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface EnterpriseMapper {
    //long countByExample(EnterpriseExample example);

    //int deleteByExample(EnterpriseExample example);

    @Delete("    delete from enterprise where enterprise_id = #{enterpriseId,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer enterpriseId);

    @Insert("    insert into enterprise (name, email, tel, " +
            "      account, introdution)" +
            "    values (#{name,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{tel,jdbcType=INTEGER}, " +
            "      #{account,jdbcType=INTEGER}, #{introdution,jdbcType=VARCHAR})")
    int insert(Enterprise record);

//    int insertSelective(Enterprise record);

//    List<Enterprise> selectByExample(EnterpriseExample example);

    @Select("    select from enterprise" +
            "    where enterprise_id = #{enterpriseId,jdbcType=INTEGER}")
    Enterprise selectByPrimaryKey(Integer enterpriseId);

    @Select("    select from enterprise" +
            "    where account = #{account,jdbcType=INTEGER}")
    Enterprise selectByAccount(Integer account);
    

    @Select("select * from enterprise")
    List<Enterprise> selectAll();

    @Select("select * from enterprise")
    IPage<Enterprise> selectAll(Page page);


    ////int updateByExampleSelective(@Param("record") Enterprise record, @Param("example") EnterpriseExample example);

    //int updateByExample(@Param("record") Enterprise record, @Param("example") EnterpriseExample example);

//    int updateByPrimaryKeySelective(Enterprise record);

    @Update("    update enterprise" +
            "    set name = #{name,jdbcType=VARCHAR}," +
            "      email = #{email,jdbcType=VARCHAR}," +
            "      tel = #{tel,jdbcType=INTEGER}," +
            "      account = #{account,jdbcType=INTEGER}" +
            "    where enterprise_id = #{enterpriseId,jdbcType=INTEGER}")
    int updateByPrimaryKey(Enterprise record);
}