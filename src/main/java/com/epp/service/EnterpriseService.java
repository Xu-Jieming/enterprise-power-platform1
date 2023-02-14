package com.epp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.ApiResult;
import com.epp.pojo.Enterprise;
import com.epp.pojo.EnterpriseDailyPower;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/14:54
 * @Description:
 */
public interface EnterpriseService {

    public List<Enterprise> selectAll();

    public ApiResult selectAll(Page<Enterprise> page);

    public ApiResult selectByPrimaryKey(Integer enterpriseId);

    public ApiResult selectByAccount(Integer account);

    public ApiResult deleteByPrimaryKey(Integer enterpriseId);

    public ApiResult update(Enterprise enterprise);

    public ApiResult insert(Enterprise enterprise);
}
