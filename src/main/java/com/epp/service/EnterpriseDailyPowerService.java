package com.epp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.ApiResult;
import com.epp.pojo.EnterpriseDailyPower;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/13:59
 * @Description:
 */
public interface EnterpriseDailyPowerService {
    public ApiResult selectAll();

    public ApiResult selectAll(Page<EnterpriseDailyPower> page);

    public ApiResult selectByPrimaryKey(Integer enterprisePowerId);

    public ApiResult selectByEnterprise(Integer enterprisePowerId);

    public ApiResult deleteByPrimaryKey(Integer enterprisePowerId);

    public ApiResult update(Integer enterpriseId,Integer year,Integer month, Integer day);

    public ApiResult insert(Integer enterpriseId,Integer year,Integer month, Integer day);
}
