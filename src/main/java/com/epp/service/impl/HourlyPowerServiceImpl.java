package com.epp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.mapper.HourlyPowerMapper;
import com.epp.pojo.Admin;
import com.epp.pojo.ApiResult;
import com.epp.pojo.HourlyPower;
import com.epp.service.HourlyPowerService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/11:54
 * @Description:
 */
public class HourlyPowerServiceImpl implements HourlyPowerService {

    @Autowired
    private HourlyPowerMapper mapper;

    @Autowired


    Calendar ca = Calendar.getInstance();

    @Override
    public ApiResult<HourlyPower> selectAll() {
        List<HourlyPower> powerList = mapper.selectAll();
        if(powerList != null){
            return ApiResultHandler.buildApiResult(200, "所有分时用能查询成功", powerList);
        }
        return ApiResultHandler.buildApiResult(400, "所有分时用能查询失败", null);

    }

    @Override
    public ApiResult selectAll(Page<HourlyPower> page) {
        IPage<HourlyPower> powerList = mapper.selectAll(page);
        if(powerList != null){
            return ApiResultHandler.buildApiResult(200, "分页查询所有分时用能成功", powerList);
        }
        return ApiResultHandler.buildApiResult(400, "分页查询所有分时用能失败", null);
    }

    @Override
    public ApiResult selectByPrimaryKey(Integer hourlyId) {
        HourlyPower power = mapper.selectByPrimaryKey(hourlyId);
        if(power != null){
            return ApiResultHandler.buildApiResult(200, "分时用能查询成功", power);
        }
        return ApiResultHandler.buildApiResult(400, "分时用能查询失败", null);
    }

    @Override
    public ApiResult deleteByPrimaryKey(Integer hourlyId) {
        int deleteId = mapper.deleteByPrimaryKey(hourlyId);
        if(deleteId != 0){
            return ApiResultHandler.buildApiResult(200, "删除成功", deleteId);
        }
        return ApiResultHandler.buildApiResult(400, "删除失败", null);
    }

    @Override
    public ApiResult update(HourlyPower hourlyPower) {
        int updateHourlyPower = mapper.updateByPrimaryKey(hourlyPower);
        if(updateHourlyPower != 0){
            return ApiResultHandler.buildApiResult(200, "修改成功", updateHourlyPower);
        }
        return ApiResultHandler.buildApiResult(400, "修改失败", null);
    }

    @Override
    public ApiResult insert(HourlyPower hourlyPower,Integer enterpriseId) {

        int day =ca.get(Calendar.DAY_OF_YEAR);//一年中的第几天
        int month =ca.get(Calendar.MONTH);//第几个月
        int year =ca.get(Calendar.YEAR);//年份数值
        hourlyPower.setTime(year,month,day);

        hourlyPower.setEnterpriseId(enterpriseId);

        int insertHourlyPower = mapper.insert(hourlyPower);
        if(insertHourlyPower != 0){
            return ApiResultHandler.buildApiResult(200, "添加成功", insertHourlyPower);
        }
        return ApiResultHandler.buildApiResult(400, "添加失败", null);
    }
}
