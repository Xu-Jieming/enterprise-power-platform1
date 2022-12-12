package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.EnterprisePowerConsumption;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/11/20:56
 * @Description:表的命名是enterprise_power_consumption
 */
public interface EnterprisePowerConsumptionMapper {
    @Select("select * from enterprise_power_consumption")
    public List<EnterprisePowerConsumption> findAll();

    @Select("select * from enterprise_power_consumption")
    public IPage<EnterprisePowerConsumption> findAll(Page page);

    @Select("select enterprise_name,first_rate_power,second_rate_power,third_rate_power," +
            "first_rate_payment,second_rate_payment,third_rate_payment where enterprise_id = #{enterpriseId}")
    public EnterprisePowerConsumption findByEnterpriseId(Integer enterpriseId);

    @Select("select enterprise_name,first_rate_power,second_rate_power,third_rate_power," +
            "first_rate_payment,second_rate_payment,third_rate_payment where enterprise_id = #{enterpriseId}")
    public IPage<EnterprisePowerConsumption> findByEnterpriseName(@Param("page")Page page ,@Param("enterpriseName") String enterpriseName);


    @Delete("delete from  enterprise_power_consumption where enterprise_id = #{enterpriseId}")
    public int deleteById(Integer enterpriseId);


    @Update("update enterprise_power_consumption set first_rate_power = #{firstRatePower} ," +
            "second_rate_power = #{secondRatePower} ,third_rate_power = #{thirdRatePower} ," +
            "first_rate_payment = #{firstRatePayment} ,second_rate_payment = #{secondRatePayment} ,third_rate_payment = #{thirdRatePayment} ")
    public int update (EnterprisePowerConsumption enterprisePowerConsumption);

    @Insert("Insert into enterprise_power_consumption (first_rate_power,second_rate_power,third_rate_power," +
            "first_rate_payment,second_rate_payment,third_rate_payment ) values (#{firstRatePower} ," +
            "  #{secondRatePower} , #{thirdRatePower} , #{firstRatePayment} , #{secondRatePayment} , #{thirdRatePayment})")
    public int add (EnterprisePowerConsumption enterprisePowerConsumption);


}
