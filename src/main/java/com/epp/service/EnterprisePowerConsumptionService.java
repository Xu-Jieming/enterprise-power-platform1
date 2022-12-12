package com.epp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.ApiResult;
import com.epp.pojo.EnterprisePowerConsumption;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/11/21:57
 * @Description:
 */
public interface EnterprisePowerConsumptionService {

    ApiResult<EnterprisePowerConsumption> findAll();

    ApiResult<EnterprisePowerConsumption> findAll(Page<EnterprisePowerConsumption> page);

    ApiResult findByEnterpriseId(Integer enterpriseId);

    ApiResult findByEnterpriseName(Page<EnterprisePowerConsumption> page, String enterpriseName);

    ApiResult deleteById(Integer enterpriseId);

    ApiResult update(EnterprisePowerConsumption consumption);

    ApiResult add(EnterprisePowerConsumption consumption);


}
