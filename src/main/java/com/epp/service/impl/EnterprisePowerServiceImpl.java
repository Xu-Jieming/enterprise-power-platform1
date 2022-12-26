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

    private int month =ca.get(Calendar.MONTH);//第几个月
    private int year =ca.get(Calendar.YEAR);//年份数值



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
    public ApiResult deleteByPrimaryKey(Integer dailyPowerId) {
        int deleteId = mapper.deleteByPrimaryKey(dailyPowerId);
        if(deleteId != 0){
            return ApiResultHandler.buildApiResult(200, "删除成功", deleteId);
        }
        return ApiResultHandler.buildApiResult(400, "删除失败", null);

    }

    @Override
    public ApiResult update(EnterprisePower dailyPower) {

        int enterpriseId = dailyPower.getEnterpriseId();
        int thisMonth = dailyPower.getMonth();
        int thisYear = dailyPower.getYear();
        TiredRate tiredRates = tiredRateMapper.selectByTime(thisYear,thisMonth);
        double sum = 0;
        //获取整个月的量
        List<EnterpriseDailyPower> powerList =  dailyMapper.selectByEnterprise(enterpriseId,thisYear, thisMonth);

        for(EnterpriseDailyPower power:powerList){
            sum += power.getDailyPower();
        }

        dailyPower.setSumPower(sum);//先把总量给放进去
        //然后把这个月的阶梯收费给算出来
        if(sum <= tiredRates.getSecondTiredRate()){
            dailyPower.setFirstRatePower(sum);
        }else if(sum <= tiredRates.getThirdTiredRate()){
            dailyPower.setFirstRatePower(tiredRates.getSecondTiredRate());//如果大于第一个区间，那就将第二个区间的左边设为第一个值
            dailyPower.setSecondRatePower(sum - tiredRates.getSecondTiredRate());
        }else if(sum > tiredRates.getThirdTiredRate()){
            dailyPower.setFirstRatePower(tiredRates.getSecondTiredRate());//如果大于第一个区间，那就将第二个区间的左边设为第一个值
            dailyPower.setSecondRatePower(tiredRates.getThirdTiredRate()-tiredRates.getSecondTiredRate());
            dailyPower.setThirdRatePower(sum - tiredRates.getThirdTiredRate());
        }


        int updateEnterprisePower = mapper.updateByPrimaryKey(dailyPower);
        if(updateEnterprisePower != 0){
            return ApiResultHandler.buildApiResult(200, "修改成功", updateEnterprisePower);
        }
        return ApiResultHandler.buildApiResult(400, "修改失败", null);

    }

    @Override
    public ApiResult insert(Integer enterpriseId) {

        EnterprisePower dailyPower = new EnterprisePower();

        dailyPower.setEnterpriseId(enterpriseId);
        dailyPower.setTime(year,month);


        int insertEnterprisePower = mapper.insert(dailyPower);
        if(insertEnterprisePower != 0){
            return ApiResultHandler.buildApiResult(200, "添加成功", insertEnterprisePower);
        }
        return ApiResultHandler.buildApiResult(400, "添加失败", null);

    }
}
