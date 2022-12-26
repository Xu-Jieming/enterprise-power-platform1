package com.epp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.mapper.EnterpriseDailyPowerMapper;
import com.epp.mapper.HourlyPowerMapper;
import com.epp.pojo.ApiResult;
import com.epp.pojo.EnterpriseDailyPower;
import com.epp.pojo.EnterpriseDailyPower;
import com.epp.pojo.HourlyPower;
import com.epp.service.EnterpriseDailyPowerService;
import com.epp.service.EnterpriseService;
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
public class EnterpriseDailyPowerServiceImpl implements EnterpriseDailyPowerService {
    
    @Autowired
    private EnterpriseDailyPowerMapper mapper;

    @Autowired
    private HourlyPowerMapper hourlyPowerMapper;


//    private EnterpriseMaper enterpriseMaper;


    private final Calendar ca = Calendar.getInstance();

    private final int day =ca.get(Calendar.DAY_OF_MONTH);//一年中的第几天
    private final int month =ca.get(Calendar.MONTH);//第几个月
    private final int year =ca.get(Calendar.YEAR);//年份数值

    private double firstPeriodPower;
    private double secondPeriodPower;
    private double thirdPeriodPower;
    private double forthPeriodPower;
    private double dailyPeriodPower;



    @Override
    public ApiResult selectAll() {
        List<EnterpriseDailyPower> powerList = mapper.selectAll();
        if(powerList != null){
            return ApiResultHandler.buildApiResult(200, "所有企业用能查询成功", powerList);
        }
        return ApiResultHandler.buildApiResult(400, "所有企业用能查询失败", null);

    }

    @Override
    public ApiResult selectAll(Page<EnterpriseDailyPower> page) {
        IPage<EnterpriseDailyPower> powerList = mapper.selectAll(page);
        if(powerList != null){
            return ApiResultHandler.buildApiResult(200, "分页查询所有企业用能成功", powerList);
        }
        return ApiResultHandler.buildApiResult(400, "分页查询所有企业用能失败", null);

    }

    @Override
    public ApiResult selectByPrimaryKey(Integer dailyPowerId) {
        EnterpriseDailyPower power = mapper.selectByPrimaryKey(dailyPowerId);
        if(power != null){
            return ApiResultHandler.buildApiResult(200, "企业用能查询成功", power);
        }
        return ApiResultHandler.buildApiResult(400, "企业用能查询失败", null);

    }

    @Override
    public ApiResult selectByEnterprise(Integer enterpriseId) {
        List<EnterpriseDailyPower> powerList = mapper.selectByEnterprise(enterpriseId);
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
    public ApiResult update(EnterpriseDailyPower dailyPower) {

        int enterpriseId = dailyPower.getEnterpriseId();

        List<HourlyPower> powerList = hourlyPowerMapper.selectByEntity(enterpriseId,year,month,day);//获取当天的分时用能

        for(HourlyPower power:powerList){//将每天不同支路的不同时间段进行累加
            firstPeriodPower+=power.getFirstPeriodPower();
            secondPeriodPower+=power.getDoublePeriodPower();
            thirdPeriodPower+=power.getThirdPeriodPower();
            forthPeriodPower+=power.getForthPeriodPower();
        }
        dailyPeriodPower = firstPeriodPower + secondPeriodPower + thirdPeriodPower + forthPeriodPower;

        dailyPower.setFirstPeriodPower(firstPeriodPower);
        dailyPower.setSecondPeriodPower(secondPeriodPower);
        dailyPower.setThirdPeriodPower(thirdPeriodPower);
        dailyPower.setForthPeriodPower(forthPeriodPower);
        dailyPower.setDailyPower(dailyPeriodPower);

        int updateEnterpriseDailyPower = mapper.updateByPrimaryKey(dailyPower);
        if(updateEnterpriseDailyPower != 0){
            return ApiResultHandler.buildApiResult(200, "修改成功", updateEnterpriseDailyPower);
        }
        return ApiResultHandler.buildApiResult(400, "修改失败", null);

    }

    @Override
    public ApiResult insert(Integer enterpriseId) {

        EnterpriseDailyPower dailyPower = new EnterpriseDailyPower();

        dailyPower.setEnterpriseId(enterpriseId);
        dailyPower.setTime(year,month,day);

        int insertEnterpriseDailyPower = mapper.insert(dailyPower);
        if(insertEnterpriseDailyPower != 0){
            return ApiResultHandler.buildApiResult(200, "添加成功", insertEnterpriseDailyPower);
        }
        return ApiResultHandler.buildApiResult(400, "添加失败", null);

    }
}
