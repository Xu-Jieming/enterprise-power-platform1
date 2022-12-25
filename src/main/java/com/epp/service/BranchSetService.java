package com.epp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.ApiResult;
import com.epp.pojo.BranchPower;
import com.epp.pojo.BranchSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/15:08
 * @Description:
 */
public interface BranchSetService {

    public ApiResult selectAll();

    public ApiResult selectAll(Page<BranchSet> page);

    public ApiResult selectByEnterpriseId(Integer enterpriseId);

    public ApiResult deleteByPrimaryKey(Integer branchPowerId);

    public ApiResult update(BranchSet branchPower);

    public ApiResult insert(BranchSet branchPower);

}
