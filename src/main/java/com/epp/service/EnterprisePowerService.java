package com.epp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.ApiResult;
import com.epp.pojo.EnterprisePower;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/13:59
 * @Description:
 */
public interface EnterprisePowerService {
    public ApiResult selectAll();

    public ApiResult selectAll(Page<EnterprisePower> page);

    public ApiResult selectByPrimaryKey(Integer enterprisePowerId);

    public ApiResult deleteByPrimaryKey(Integer enterprisePowerId);

    public ApiResult update(EnterprisePower enterprisePower);

    public ApiResult insert(EnterprisePower enterprisePower);
}
