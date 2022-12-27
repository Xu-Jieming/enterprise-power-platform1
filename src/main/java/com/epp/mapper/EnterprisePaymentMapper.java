package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.EnterprisePayment;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface EnterprisePaymentMapper {
    //long countByExample(EnterprisePaymentExample example);

    //int deleteByExample(EnterprisePaymentExample example);

    @Delete("delete from enterprise_payment where enterprise_payment_id = #{enterprisePaymentId,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer enterprisePaymentId);

    @Insert("insert into enterprise_payment (enterprise_id,first_rate_payment,second_rate_payment" +
            ",third_rate_payment,sum_payment,year,month,status,counted) " +
            "values (#{enterpriseId,jdbcType=INTEGER},#{firstRatePayment,jdbcType=DOUBLE},#{secondRatePayment,jdbcType=DOUBLE}," +
            "#{thirdRatePayment,jdbcType=DOUBLE},#{sumPayment,jdbcType=DOUBLE},#{year,jdbcType=INTEGER}," +
            "#{month,jdbcType=INTEGER},#{status,jdbcType=INTEGER},#{counted,jdbcType=DOUBLE})")
    int insert(EnterprisePayment record);

//    int insertSelective(EnterprisePayment record);

//    List<EnterprisePayment> selectByExample(EnterprisePaymentExample example);

    @Select(" select  " +
            "from enterprise_payment " +
            " where enterprise_payment_id = #{enterprisePaymentId,jdbcType=INTEGER}")
    EnterprisePayment selectByPrimaryKey(Integer enterprisePaymentId);

    @Select("select * from enterprise_payment where enterprise_id = #{enterpriseId,jdbcType=INTEGER} and year = #{year,jdbcType=INTEGER}" +
            " and month = #{month,jdbcType=INTEGER}")
    EnterprisePayment selectByEntity(@Param("enterpriseId") Integer enterpriseId,@Param("year") Integer year,@Param("month") Integer month);

    @Select(" select * from enterprise_payment " +
            " where enterprise_id = #{enterpriseId,jdbcType=INTEGER}")
    List<EnterprisePayment> selectByEnterpriseId(Integer enterpriseId);

    @Select("select * from enterprise_payment")
    List<EnterprisePayment> selectAll();

    @Select("select * from enterprise_payment")
    IPage<EnterprisePayment> selectAll(Page page);


    ////int updateByExampleSelective(@Param("record") EnterprisePayment record,@Param("example") EnterprisePaymentExample example);

    //int updateByExample(@Param("record") EnterprisePayment record,@Param("example") EnterprisePaymentExample example);

//    int updateByPrimaryKeySelective(EnterprisePayment record);

    @Update("update enterprise_payment set first_rate_payment = #{firstRatePayment,jdbcType=DOUBLE}," +
            "second_rate_payment = #{secondRatePayment,jdbcType=DOUBLE}," +
            "third_rate_payment = #{thirdRatePayment,jdbcType=DOUBLE}," +
            "sum_payment = #{sumPayment,jdbcType=DOUBLE}," +
            "status = #{status,jdbcType=INTEGER}, " +
            "counted = #{counted,jdbcType=DOUBLE} " +
            " where enterprise_id = #{enterpriseId,jdbcType=INTEGER} and year = #{year,jdbcType=INTEGER} and month = #{month,jdbcType=INTEGER}")
    int updateByPrimaryKey(EnterprisePayment record);
}