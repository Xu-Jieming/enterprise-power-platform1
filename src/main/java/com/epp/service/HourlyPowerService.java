package com.epp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.Admin;
import com.epp.pojo.ApiResult;
import com.epp.pojo.HourlyPower;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/11:39
 * @Description:
 */
public interface HourlyPowerService {

    public ApiResult selectAll();

    public ApiResult selectAll(Page<HourlyPower> page);

    public ApiResult selectByPrimaryKey(Integer hourlyId);

    public ApiResult deleteByPrimaryKey(Integer hourlyId);

    public ApiResult update(HourlyPower hourlyPower);

    public ApiResult insert(HourlyPower hourlyPower,Integer enterpriseId);




}
