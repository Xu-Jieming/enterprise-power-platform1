package com.epp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.mapper.EnterpriseDailyPowerMapper;
import com.epp.mapper.EnterprisePowerMapper;
import com.epp.mapper.HourlyPowerMapper;
import com.epp.mapper.TiredRateMapper;
import com.epp.pojo.*;
import com.epp.service.EnterprisePowerService;
import com.epp.service.EnterprisePowerService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/14:08
 * @Description:
 */
@Service
public class EnterprisePowerServiceImpl implements EnterprisePowerService {
    
    @Autowired
    private EnterprisePowerMapper mapper;

    @Autowired
    private EnterpriseDailyPowerMapper dailyMapper;


    @Autowired
    private TiredRateMapper tiredRateMapper;


    private Calendar ca = Calendar.getInstance();

    private int month =ca.get(Calendar.MONTH)+1;//第几个月, Attention ! must add one 
    private int year =ca.get(Calendar.YEAR);//年份数值
    private int day = ca.get(Calendar.DAY_OF_MONTH);



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
    public ApiResult selectByPrimaryKey(Integer dailyPowerId) {
        EnterprisePower power = mapper.selectByPrimaryKey(dailyPowerId);
        if(power != null){
            return ApiResultHandler.buildApiResult(200, "企业用能查询成功", power);
        }
        return ApiResultHandler.buildApiResult(400, "企业用能查询失败", null);

    }

    @Override
    public ApiResult selectByEnterprise(Integer enterpriseId) {
        List<EnterprisePower> powerList = mapper.selectByEnterprise(enterpriseId);
        if(powerList != null){
            return ApiResultHandler.buildApiResult(200, "企业用能查询成功", powerList);
        }
        return ApiResultHandler.buildApiResult(400, "企业用能查询失败", null);
    }

    @Override
    public ApiResult selectByEntity(Integer enterpriseId) {

        EnterprisePower powerList = mapper.selectByEntity(enterpriseId,year,month);
        if(powerList != null){
            return ApiResultHandler.buildApiResult(200, "企业用能查询成功", powerList);
        }
        return ApiResultHandler.buildApiResult(400, "企业用能查询失败", null);
    }


    @Override
    public ApiResult deleteByPrimaryKey(Integer dailyPowerId) {
        int deleteId = mapper.deleteByPrimaryKey(dailyPowerId);
        if(deleteId != 0){
            return ApiResultHandler.buildApiResult(200, "删除成功", deleteId);
        }
        return ApiResultHandler.buildApiResult(400, "删除失败", null);

    }

    @Override
    public ApiResult update(Integer enterpriseId) {

        EnterprisePower monthlyPower = mapper.selectByEntity(enterpriseId,year,month);

        //int thisMonth = monthlyPower.getMonth();
        //int thisYear = monthlyPower.getYear();
        TiredRate tiredRates = tiredRateMapper.selectByTime(year,month);
        double sum = 0;
        //获取整个月的量
        List<EnterpriseDailyPower> powerList =  dailyMapper.selectByMonth(enterpriseId,year, month);
        System.out.println(powerList);
        for(EnterpriseDailyPower power:powerList){
            sum += power.getDailyPeriodPower();
        }

        monthlyPower.setSumPower(sum);//先把总量给放进去
        //然后把这个月的阶梯收费给算出来
        if(sum <= tiredRates.getSecondRateInterval()){
            monthlyPower.setFirstRatePower(sum);
        }else if(sum <= tiredRates.getThirdRateInterval()){
            monthlyPower.setFirstRatePower(tiredRates.getSecondRateInterval());//如果大于第一个区间，那就将第二个区间的左边设为第一个值
            monthlyPower.setSecondRatePower(sum - tiredRates.getSecondRateInterval());
        }else if(sum > tiredRates.getThirdRateInterval()){
            monthlyPower.setFirstRatePower(tiredRates.getSecondRateInterval());//如果大于第一个区间，那就将第二个区间的左边设为第一个值
            monthlyPower.setSecondRatePower(tiredRates.getThirdRateInterval()-tiredRates.getSecondRateInterval());
            monthlyPower.setThirdRatePower(sum - tiredRates.getThirdRateInterval());
        }


        int updateEnterprisePower = mapper.updateByPrimaryKey(monthlyPower);
        if(updateEnterprisePower != 0){
            return ApiResultHandler.buildApiResult(200, "修改成功", updateEnterprisePower);
        }
        return ApiResultHandler.buildApiResult(400, "修改失败", null);

    }

    @Override
    public ApiResult insert(Integer enterpriseId) {

        EnterprisePower monthlyPower = new EnterprisePower();

        monthlyPower.setEnterpriseId(enterpriseId);
        monthlyPower.setTime(year,month);


        int insertEnterprisePower = mapper.insert(monthlyPower);
        if(insertEnterprisePower != 0){
            return ApiResultHandler.buildApiResult(200, "添加成功", insertEnterprisePower);
        }
        return ApiResultHandler.buildApiResult(400, "添加失败", null);

    }
}
