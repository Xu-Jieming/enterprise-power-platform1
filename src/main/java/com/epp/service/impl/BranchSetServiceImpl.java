package com.epp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.mapper.BranchSetMapper;
import com.epp.pojo.ApiResult;
import com.epp.pojo.BranchSet;

import com.epp.service.BranchSetService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @Author: Xu jieming
 * @Date: 2022/12/25/15:23
 * @Description: 
 */
@Service
public class BranchSetServiceImpl implements BranchSetService {
    @Autowired
    private BranchSetMapper mapper;

    @Override
    public ApiResult selectAll() {
        List<BranchSet> powerList = mapper.selectAll();
        if(powerList != null){
            return ApiResultHandler.buildApiResult(200, "所有企业用能查询成功", powerList);
        }
        return ApiResultHandler.buildApiResult(400, "所有企业用能查询失败", null);

    }

    @Override
    public ApiResult selectAll(Page<BranchSet> page) {
        IPage<BranchSet> powerList = mapper.selectAll(page);
        if(powerList != null){
            return ApiResultHandler.buildApiResult(200, "分页查询所有企业用能成功", powerList);
        }
        return ApiResultHandler.buildApiResult(400, "分页查询所有企业用能失败", null);

    }

    @Override
    public ApiResult selectByEnterpriseId(Integer enterpriseId) {
        BranchSet power = mapper.selectByEnterpriseId(enterpriseId);
        if(power != null){
            return ApiResultHandler.buildApiResult(200, "企业用能查询成功", power);
        }
        return ApiResultHandler.buildApiResult(400, "企业用能查询失败", null);

    }

    @Override
    public ApiResult deleteByPrimaryKey(Integer branchSetId) {

        return ApiResultHandler.buildApiResult(400, "删除失败", null);

    }

    @Override
    public ApiResult update(BranchSet branchSet) {
        int updateBranchSet = mapper.updateByPrimaryKey(branchSet);
        if(updateBranchSet != 0){
            return ApiResultHandler.buildApiResult(200, "修改成功", updateBranchSet);
        }
        return ApiResultHandler.buildApiResult(400, "修改失败", null);

    }

    @Override
    public ApiResult insert(Integer enterpriseId) {

        BranchSet branchSet = new BranchSet();
        branchSet.setEnterpriseId(enterpriseId);
        int insertBranchSet = mapper.insert(branchSet);
        if(insertBranchSet != 0){
            return ApiResultHandler.buildApiResult(200, "添加成功", insertBranchSet);
        }
        return ApiResultHandler.buildApiResult(400, "添加失败", null);

    }
}
