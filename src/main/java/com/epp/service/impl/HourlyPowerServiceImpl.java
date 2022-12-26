package com.epp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.mapper.BranchSetMapper;
import com.epp.mapper.HourlyPowerMapper;
import com.epp.pojo.Admin;
import com.epp.pojo.ApiResult;
import com.epp.pojo.BranchSet;
import com.epp.pojo.HourlyPower;
import com.epp.service.HourlyPowerService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/11:54
 * @Description:
 */
@Service
public class HourlyPowerServiceImpl implements HourlyPowerService {

    @Autowired
    private HourlyPowerMapper mapper;

    @Autowired
    private BranchSetMapper branchSetMapper;

    private Calendar ca = Calendar.getInstance();

    private int day =ca.get(Calendar.DAY_OF_MONTH);//一年中的第几天
    private int month =ca.get(Calendar.MONTH);//第几个月
    private int year =ca.get(Calendar.YEAR);//年份数值

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
    public ApiResult selectByEnterpriseId(Integer enterpriseId) {
        HourlyPower power = mapper.selectByPrimaryKey(enterpriseId);
        if(power != null){
            return ApiResultHandler.buildApiResult(200, "分时用能查询成功", power);
        }
        return ApiResultHandler.buildApiResult(400, "分时用能查询失败", null);
    }


    @Override
    public ApiResult selectByEntity(Integer enterpriseId,Integer year,Integer month, Integer day) {

        List<HourlyPower> powerList = mapper.selectByEntity(enterpriseId, year,month, day);
        if(powerList != null){
            return ApiResultHandler.buildApiResult(200, "根据年月日分时用能查询成功", powerList);
        }
        return ApiResultHandler.buildApiResult(400, "根据年月日分时用能查询失败", null);
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

//        hourlyPower.setTime(year,month,day);

        int enterpriseId = hourlyPower.getEnterpriseId();

        int updateHourlyPower = mapper.updateByPrimaryKey(hourlyPower);

        BranchSet branchSet = branchSetMapper.selectByEnterpriseId(enterpriseId);//获取当前的支路设定

        if(hourlyPower.getBranchSet() == 1 && branchSet.getFirstBranchSet() != 1) {

            return ApiResultHandler.buildApiResult(1000, "第一支路没有开启", updateHourlyPower);

        }else if(hourlyPower.getBranchSet() == 2 && branchSet.getSecondBranchSet() != 1){

            return ApiResultHandler.buildApiResult(1000, "第二支路没有开启", updateHourlyPower);

        }else if(hourlyPower.getBranchSet() == 3 && branchSet.getThirdBranchSet() != 1){

            return ApiResultHandler.buildApiResult(1000, "第三支路没有开启", updateHourlyPower);

        }else if(hourlyPower.getBranchSet() == 4 && branchSet.getForthBranchSet() != 1){

            return ApiResultHandler.buildApiResult(1000, "第四支路没有开启", updateHourlyPower);

        }

        if(updateHourlyPower != 0){
            return ApiResultHandler.buildApiResult(200, "修改成功", updateHourlyPower);
        }
        return ApiResultHandler.buildApiResult(400, "修改失败", null);
    }

    @Override
    public ApiResult insert(Integer enterpriseId) {

        int insertHourlyPower = 0;

        HourlyPower hourlyPower = new HourlyPower();
        hourlyPower.setTime(year,month,day);
        hourlyPower.setEnterpriseId(enterpriseId);

        BranchSet branchSet = branchSetMapper.selectByEnterpriseId(enterpriseId);//获取当前的支路设定
        hourlyPower.setBranchId(branchSet.getBranchId());

        if( branchSet.getFirstBranchSet() == 1) {
            hourlyPower.setBranchSet(1);
            insertHourlyPower = mapper.insert(hourlyPower);

        } if( branchSet.getSecondBranchSet() == 1){

            hourlyPower.setBranchSet(2);
            insertHourlyPower = mapper.insert(hourlyPower);

        } if(branchSet.getThirdBranchSet() == 1){
            hourlyPower.setBranchSet(3);
            insertHourlyPower = mapper.insert(hourlyPower);

        } if(branchSet.getForthBranchSet() == 1){
            hourlyPower.setBranchSet(4);
            insertHourlyPower = mapper.insert(hourlyPower);

        }



        if(insertHourlyPower != 0){
            return ApiResultHandler.buildApiResult(200, "添加成功", insertHourlyPower);
        }
        return ApiResultHandler.buildApiResult(400, "添加失败", null);
    }
}
