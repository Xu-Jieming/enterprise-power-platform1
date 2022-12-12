package com.epp.mapper;

import com.epp.pojo.TiredRates;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/11/20:40
 * @Description:表的命名是tired_rates
 */
@Mapper
public interface TiredRatesMapper {

    @Update("update tired_rates set first_tiered_rates= #{firstTieredRates},first_rate_interval= #{firstRateInterval}," +
            " first_rate_content= #{firstRateContent},second_tiered_rates= #{secondTieredRates},second_rate_interval= #{secondRateInterval}," +
            "second_rate_content= #{secondRateContent},third_tiered_rates= #{thirdTieredRates},third_rate_interval= #{thirdRateInterval}," +
            "third_rate_content= #{thirdRateContent}")
    public int update(TiredRates tiredRates);


}
