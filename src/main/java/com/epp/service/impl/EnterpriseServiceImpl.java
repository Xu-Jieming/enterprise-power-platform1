package com.epp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.mapper.EnterpriseMapper;
import com.epp.pojo.ApiResult;
import com.epp.pojo.Enterprise;
import com.epp.pojo.Enterprise;
import com.epp.service.EnterpriseService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/14:55
 * @Description:
 */
@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseMapper mapper;

    @Override
    public ApiResult selectAll() {
        List<Enterprise> powerList = mapper.selectAll();
        if(powerList != null){
            return ApiResultHandler.buildApiResult(200, "所有企业用能查询成功", powerList);
        }
        return ApiResultHandler.buildApiResult(400, "所有企业用能查询失败", null);

    }

    @Override
    public ApiResult selectAll(Page<Enterprise> page) {
        IPage<Enterprise> powerList = mapper.selectAll(page);
        if(powerList != null){
            return ApiResultHandler.buildApiResult(200, "分页查询所有企业用能成功", powerList);
        }
        return ApiResultHandler.buildApiResult(400, "分页查询所有企业用能失败", null);

    }

    @Override
    public ApiResult selectByPrimaryKey(Integer enterpriseId) {
        Enterprise power = mapper.selectByPrimaryKey(enterpriseId);
        if(power != null){
            return ApiResultHandler.buildApiResult(200, "企业用能查询成功", power);
        }
        return ApiResultHandler.buildApiResult(400, "企业用能查询失败", null);

    }

    @Override
    public ApiResult selectByAccount(Integer account) {
        Enterprise power = mapper.selectByAccount(account);
        if(power != null){
            return ApiResultHandler.buildApiResult(200, "企业用能查询成功", power);
        }
        return ApiResultHandler.buildApiResult(400, "企业用能查询失败", null);

    }
    

    @Override
    public ApiResult deleteByPrimaryKey(Integer enterpriseId) {
        int deleteId = mapper.deleteByPrimaryKey(enterpriseId);
        if(deleteId != 0){
            return ApiResultHandler.buildApiResult(200, "删除成功", deleteId);
        }
        return ApiResultHandler.buildApiResult(400, "删除失败", null);

    }

    @Override
    public ApiResult update(Enterprise branchPower) {
        int updateEnterprise = mapper.updateByPrimaryKey(branchPower);
        if(updateEnterprise != 0){
            return ApiResultHandler.buildApiResult(200, "修改成功", updateEnterprise);
        }
        return ApiResultHandler.buildApiResult(400, "修改失败", null);

    }

    @Override
    public ApiResult insert(Enterprise branchPower) {
        int insertEnterprise = mapper.insert(branchPower);
        if(insertEnterprise != 0){
            return ApiResultHandler.buildApiResult(200, "添加成功", insertEnterprise);
        }
        return ApiResultHandler.buildApiResult(400, "添加失败", null);

    }
}
