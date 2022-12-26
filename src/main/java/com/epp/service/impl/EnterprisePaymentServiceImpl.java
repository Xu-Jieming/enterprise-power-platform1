package com.epp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.mapper.EnterprisePaymentMapper;
import com.epp.mapper.EnterprisePowerMapper;
import com.epp.mapper.TiredRateMapper;
import com.epp.pojo.*;
import com.epp.pojo.EnterprisePayment;
import com.epp.service.EnterprisePaymentService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class EnterprisePaymentServiceImpl implements EnterprisePaymentService {

    @Autowired
    private EnterprisePaymentMapper mapper;

    @Autowired
    private EnterprisePowerMapper powerMapper;

    @Autowired
    private TiredRateMapper tiredRateMapper;

    private Calendar ca = Calendar.getInstance();
    private int month =ca.get(Calendar.MONTH);//第几个月
    private int year =ca.get(Calendar.YEAR);//年份数值

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

        int enterpriseId = enterprisePayment.getEnterpriseId();
        int thisYear = enterprisePayment.getYear();
        int thisMonth = enterprisePayment.getMonth();

        TiredRate tiredRate = tiredRateMapper.selectByTime(thisYear,thisMonth);

        EnterprisePower enterprisePower = powerMapper.selectByEnterprise(enterpriseId,thisYear,thisMonth);//获取当月电费情况


        double firstRatePayment = enterprisePower.getFirstRatePower() * tiredRate.getFirstTiredRate();
        double secondRatePayment = enterprisePower.getSecondRatePower() * tiredRate.getSecondTiredRate();
        double thirdRatePayment = enterprisePower.getThirdRatePower() * tiredRate.getThirdTiredRate();
        enterprisePayment.setFirstRatePayment(firstRatePayment);
        enterprisePayment.setSecondRatePayment(secondRatePayment);
        enterprisePayment.setThirdRatePayment(thirdRatePayment);
        enterprisePayment.setSumRatePayment(firstRatePayment+secondRatePayment+thirdRatePayment);

        int updateEnterprisePayment = mapper.updateByPrimaryKey(enterprisePayment);
        if(updateEnterprisePayment != 0){
            return ApiResultHandler.buildApiResult(200, "修改成功", updateEnterprisePayment);
        }
        return ApiResultHandler.buildApiResult(400, "修改失败", null);

    }

    @Override
    public ApiResult insert(Integer enterpriseId) {

        EnterprisePayment enterprisePayment = new EnterprisePayment();
        enterprisePayment.setEnterpriseId(enterpriseId);
        enterprisePayment.setTime(year,month);
        enterprisePayment.setStatus(0);

        int insertEnterprisePayment = mapper.insert(enterprisePayment);
        if(insertEnterprisePayment != 0){
            return ApiResultHandler.buildApiResult(200, "空的账单添加成功", insertEnterprisePayment);
        }
        return ApiResultHandler.buildApiResult(400, "空的账单添加失败", null);

    }
}
