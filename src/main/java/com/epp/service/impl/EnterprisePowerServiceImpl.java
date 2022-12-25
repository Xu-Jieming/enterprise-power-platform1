package com.epp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.mapper.EnterprisePowerMapper;
import com.epp.pojo.ApiResult;
import com.epp.pojo.EnterprisePower;
import com.epp.pojo.EnterprisePower;
import com.epp.service.EnterprisePowerService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/14:08
 * @Description:
 */
public class EnterprisePowerServiceImpl implements EnterprisePowerService {
    
    @Autowired
    private EnterprisePowerMapper mapper;

    @Override
    public ApiResult selectAll() {
        List<EnterprisePower> powerList = mapper.selectAll();
        if(powerList != null){
            return ApiResultHandler.buildApiResult(200, "所有企业用能查询成功", powerList);
        }
        return ApiResultHandler.buildApiResult(400, "所有企业用能查询失败", null);

    }

    @Override
    public ApiResult selectAll(Page<EnterprisePower> page) {
        IPage<EnterprisePower> powerList = mapper.selectAll(page);
        if(powerList != null){
            return ApiResultHandler.buildApiResult(200, "分页查询所有企业用能成功", powerList);
        }
        return ApiResultHandler.buildApiResult(400, "分页查询所有企业用能失败", null);

    }

    @Override
    public ApiResult selectByPrimaryKey(Integer branchPowerId) {
        EnterprisePower power = mapper.selectByPrimaryKey(branchPowerId);
        if(power != null){
            return ApiResultHandler.buildApiResult(200, "企业用能查询成功", power);
        }
        return ApiResultHandler.buildApiResult(400, "企业用能查询失败", null);

    }

    @Override
    public ApiResult deleteByPrimaryKey(Integer branchPowerId) {
        int deleteId = mapper.deleteByPrimaryKey(branchPowerId);
        if(deleteId != 0){
            return ApiResultHandler.buildApiResult(200, "删除成功", deleteId);
        }
        return ApiResultHandler.buildApiResult(400, "删除失败", null);

    }

    @Override
    public ApiResult update(EnterprisePower branchPower) {
        int updateEnterprisePower = mapper.updateByPrimaryKey(branchPower);
        if(updateEnterprisePower != 0){
            return ApiResultHandler.buildApiResult(200, "修改成功", updateEnterprisePower);
        }
        return ApiResultHandler.buildApiResult(400, "修改失败", null);

    }

    @Override
    public ApiResult insert(EnterprisePower branchPower) {
        int insertEnterprisePower = mapper.insert(branchPower);
        if(insertEnterprisePower != 0){
            return ApiResultHandler.buildApiResult(200, "添加成功", insertEnterprisePower);
        }
        return ApiResultHandler.buildApiResult(400, "添加失败", null);

    }
}
