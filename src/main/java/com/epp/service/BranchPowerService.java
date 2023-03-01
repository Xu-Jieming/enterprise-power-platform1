package com.epp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.ApiResult;
import com.epp.pojo.BranchPower;
import com.epp.pojo.HourlyPower;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/13:48
 * @Description:
 */
public interface BranchPowerService {
    public ApiResult selectAll();

    public ApiResult selectAll(Page<BranchPower> page);

    public ApiResult selectByPrimaryKey(Integer branchPowerId);

    public BranchPower selectByEntity(HourlyPower hourlyPower);

    public ApiResult deleteByPrimaryKey(Integer branchPowerId);

    public ApiResult update(Integer enterpriseId,Integer year,Integer month, Integer day);

    public ApiResult insert(Integer enterpriseId,Integer year,Integer month, Integer day);
}
