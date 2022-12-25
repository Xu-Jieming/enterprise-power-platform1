package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.EnterprisePayment;
import com.epp.pojo.EnterprisePaymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EnterprisePaymentMapper {
    //long countByExample(EnterprisePaymentExample example);

    //int deleteByExample(EnterprisePaymentExample example);

    int deleteByPrimaryKey(Integer enterprisePaymentId);

    int insert(EnterprisePayment record);

    int insertSelective(EnterprisePayment record);

    List<EnterprisePayment> selectByExample(EnterprisePaymentExample example);

    EnterprisePayment selectByPrimaryKey(Integer enterprisePaymentId);

    @Select("select * from ")
    List<> selectAll();

    @Select("select * from ")
    IPage<> selectAll(Page page);


    ////int updateByExampleSelective(@Param("record") EnterprisePayment record, @Param("example") EnterprisePaymentExample example);

    //int updateByExample(@Param("record") EnterprisePayment record, @Param("example") EnterprisePaymentExample example);

    int updateByPrimaryKeySelective(EnterprisePayment record);

    int updateByPrimaryKey(EnterprisePayment record);
}