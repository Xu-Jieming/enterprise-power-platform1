package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.EnterpriseAccount;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/27/1:09
 * @Description:
 */
@Mapper
public interface EnterpriseAccountMapper {

    ////long countByExample(AdminExample example);

    ////int deleteByExample(AdminExample example);

    @Delete("delete from enterprise_account where enterprise_id = #{enterpriseId,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer enterpriseId);


    @Options(useGeneratedKeys = true,keyProperty = "enterpriseId")
    @Insert(" insert into enterprise_account (current_account,enterprise_id)" +
            " values (#{currentAccount,jdbcType=DOUBLE},#{enterpriseId,jdbcType=INTEGER})")
    int insert(EnterpriseAccount record);

    //int insertSelective(EnterpriseAccount record);

    //List<EnterpriseAccount> selectByExample(AdminExample example);

    @Select("select * from enterprise_account where enterprise_id = #{enterpriseId,jdbcType=INTEGER}")
    EnterpriseAccount selectByEnterpriseId(Integer enterpriseId);


    @Select(" select * from enterprise_account ")
    List<EnterpriseAccount> selectAll();

    @Select(" select * from enterprise_account ")
    IPage<EnterpriseAccount> selectAll(Page page);

    //////int updateByExampleSelective(@Param("record") EnterpriseAccount record,@Param("example") AdminExample example);

    ////int updateByExample(@Param("record") EnterpriseAccount record,@Param("example") AdminExample example);

    //int updateByPrimaryKeySelective(EnterpriseAccount record);

    @Update("update enterprise_account set current_account = #{currentAccount,jdbcType=DOUBLE}" +
            " where enterprise_id = #{enterpriseId,jdbcType=INTEGER}")
    int updateByPrimaryKey(EnterpriseAccount record);
    
}
