package com.epp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.mapper.EnterprisePaymentMapper;
import com.epp.pojo.ApiResult;
import com.epp.pojo.EnterprisePayment;
import com.epp.pojo.EnterprisePayment;
import com.epp.service.EnterprisePaymentService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EnterprisePaymentServiceImpl implements EnterprisePaymentService {
    @Autowired
    private EnterprisePaymentMapper mapper;
    
    @Override
    public ApiResult selectAll() {
        List<EnterprisePayment> enterprisePaymentList = mapper.selectAll();
        if(enterprisePaymentList != null){
            return ApiResultHandler.buildApiResult(200, "所有企业费用查询成功", enterprisePaymentList);
        }
        return ApiResultHandler.buildApiResult(400, "所有企业费用查询失败", null);

    }

    @Override
    public ApiResult selectAll(Page<EnterprisePayment> page) {
        IPage<EnterprisePayment> enterprisePaymentList = mapper.selectAll(page);
        if(enterprisePaymentList != null){
            return ApiResultHandler.buildApiResult(200, "分页查询所有企业费用成功", enterprisePaymentList);
        }
        return ApiResultHandler.buildApiResult(400, "分页查询所有企业费用失败", null);

    }

    @Override
    public ApiResult selectByPrimaryKey(Integer enterprisePaymentId) {
        EnterprisePayment enterprisePayment = mapper.selectByPrimaryKey(enterprisePaymentId);
        if(enterprisePayment != null){
            return ApiResultHandler.buildApiResult(200, "企业费用查询成功", enterprisePayment);
        }
        return ApiResultHandler.buildApiResult(400, "企业费用查询失败", null);

    }


    @Override
    public ApiResult deleteByPrimaryKey(Integer enterprisePaymentId) {
        int deleteId = mapper.deleteByPrimaryKey(enterprisePaymentId);
        if(deleteId != 0){
            return ApiResultHandler.buildApiResult(200, "删除成功", deleteId);
        }
        return ApiResultHandler.buildApiResult(400, "删除失败", null);

    }

    @Override
    public ApiResult update(EnterprisePayment enterprisePayment) {
        int updateEnterprisePayment = mapper.updateByPrimaryKey(enterprisePayment);
        if(updateEnterprisePayment != 0){
            return ApiResultHandler.buildApiResult(200, "修改成功", updateEnterprisePayment);
        }
        return ApiResultHandler.buildApiResult(400, "修改失败", null);

    }

    @Override
    public ApiResult insert(EnterprisePayment enterprisePayment) {
        int insertEnterprisePayment = mapper.insert(enterprisePayment);
        if(insertEnterprisePayment != 0){
            return ApiResultHandler.buildApiResult(200, "添加成功", insertEnterprisePayment);
        }
        return ApiResultHandler.buildApiResult(400, "添加失败", null);

    }
}
