package com.epp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.Admin;
import com.epp.pojo.ApiResult;
import com.epp.pojo.HourlyPower;

import java.util.List;

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

    public ApiResult selectByEnterpriseId(Integer enterpriseId);

    public ApiResult selectByEntity(Integer enterpriseId,Integer year,Integer month, Integer day);

    public ApiResult deleteByPrimaryKey(Integer hourlyId);

    public ApiResult update(List<HourlyPower> hourlyPowerList,Integer enterpriseId,Integer year,Integer month, Integer day);

    public ApiResult insert(Integer enterpriseId,Integer year,Integer month, Integer day);




}
