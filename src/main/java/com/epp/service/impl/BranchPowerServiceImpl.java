package com.epp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.mapper.BranchPowerMapper;
import com.epp.mapper.BranchSetMapper;
import com.epp.mapper.HourlyPowerMapper;
import com.epp.pojo.*;
import com.epp.pojo.BranchPower;
import com.epp.pojo.BranchPower;
import com.epp.service.BranchPowerService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/13:49
 * @Description:
 */
@Service
public class BranchPowerServiceImpl implements BranchPowerService {

    @Autowired
    private BranchPowerMapper mapper;

    @Autowired
    private HourlyPowerMapper hourlyPowerMapper;

    @Autowired
    private BranchSetMapper branchSetMapper;

    private  Calendar ca = Calendar.getInstance();

    private  int day =ca.get(Calendar.DAY_OF_MONTH);//一年中的第几天
    private  int month =ca.get(Calendar.MONTH)+1;//第几个月, Attention ! must add one 
    private  int year =ca.get(Calendar.YEAR);//年份数值

    @Override
    public ApiResult selectAll() {
        List<BranchPower> powerList = mapper.selectAll();
        if(powerList != null){
            return ApiResultHandler.buildApiResult(200, "所有支路用能查询成功", powerList);
        }
        return ApiResultHandler.buildApiResult(400, "所有支路用能查询失败", null);

    }

    @Override
    public ApiResult selectAll(Page<BranchPower> page) {
        IPage<BranchPower> powerList = mapper.selectAll(page,year,month, day);
        if(powerList != null){
            return ApiResultHandler.buildApiResult(200, "分页查询所有支路用能成功", powerList);
        }
        return ApiResultHandler.buildApiResult(400, "分页查询所有支路用能失败", null);

    }



    @Override
    public ApiResult selectByPrimaryKey(Integer branchPowerId) {
        BranchPower power = mapper.selectByPrimaryKey(branchPowerId);
        if(power != null){
            return ApiResultHandler.buildApiResult(200, "支路用能查询成功", power);
        }
        return ApiResultHandler.buildApiResult(400, "支路用能查询失败", null);

    }

    @Override
    public BranchPower selectByEntity(HourlyPower hourlyPower) {

        int enterpriseId = hourlyPower.getEnterpriseId();
        int thisYear = hourlyPower.getYear();
        int thisMonth = hourlyPower.getMonth();
        int thisDay = hourlyPower.getDay();

        BranchPower power = mapper.selectByEntity(enterpriseId,thisYear,thisMonth,thisDay);

        return power;
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
    public ApiResult update(Integer enterpriseId) {

        BranchPower branchPower = mapper.selectByEntity(enterpriseId,year,month,day);//一个企业的一天只有一个


        BranchSet branchSet = branchSetMapper.selectByEnterpriseId(enterpriseId);//获取当前的支路设定
//        branchPower.setBranchId(branchSet.getBranchId());这些都是固定的，在insert的时候已经弄好了，要修改的是电能
//        branchPower.setEnterpriseId(enterpriseId);
//        branchPower.setTime(year,month,day);因为更改的都是当天的，所以不用更改当天的时间


        List<HourlyPower> powerList = hourlyPowerMapper.selectByEntity(enterpriseId,year,month,day);
        //获取当天的分时用能，一定是当天的，修改的东西也是当天的电能
        for(HourlyPower power: powerList) {

            if (power.getBranchSet() == 1 && branchSet.getFirstBranchSet() == 1) {//如果分时用能支路和支路设定符合，那么就将四个时间段的电量叠加起来
                double firstBranchPower = power.getFirstPeriodPower() + power.getDoublePeriodPower() + power.getThirdPeriodPower() + power.getForthPeriodPower();
                branchPower.setFirstBranchPower(firstBranchPower);

            }  if (power.getBranchSet() == 2 && branchSet.getSecondBranchSet() == 1) {
                double secondBranchPower = power.getFirstPeriodPower() + power.getDoublePeriodPower() + power.getThirdPeriodPower() + power.getForthPeriodPower();
                branchPower.setSecondBranchPower(secondBranchPower);

            }  if (power.getBranchSet() == 3 && branchSet.getThirdBranchSet() == 1) {
                double thirdBranchPower = power.getFirstPeriodPower() + power.getDoublePeriodPower() + power.getThirdPeriodPower() + power.getForthPeriodPower();
                branchPower.setThirdBranchPower(thirdBranchPower);

            }  if (power.getBranchSet() == 4 && branchSet.getForthBranchSet() == 1) {
                double forthBranchPower = power.getFirstPeriodPower() + power.getDoublePeriodPower() + power.getThirdPeriodPower() + power.getForthPeriodPower();
                branchPower.setForthBranchPower(forthBranchPower);
            }
        }


        int updateBranchPower = mapper.updateByPrimaryKey(branchPower);
        if(updateBranchPower != 0){
            return ApiResultHandler.buildApiResult(200, "修改成功", updateBranchPower);
        }
        return ApiResultHandler.buildApiResult(400, "修改失败", null);

    }

    @Override
    public ApiResult insert(Integer enterpriseId) {

        BranchSet branchSet = branchSetMapper.selectByEnterpriseId(enterpriseId);//获取当前的支路设定


        BranchPower branchPower = new BranchPower();
        branchPower.setEnterpriseId(enterpriseId);
        branchPower.setBranchId(branchSet.getBranchId());
        branchPower.setTime(year,month,day);
        List<HourlyPower> powerList = hourlyPowerMapper.selectByEntity(enterpriseId,year,month,day);
        //获取当天的分时用能，一定是当天的，修改的东西也是当天的电能
        for(HourlyPower power: powerList) {
            if (branchSet.getFirstBranchSet() == 1) {//如果分时用能支路和支路设定符合，那么就将四个时间段的电量叠加起来
                branchPower.setFirstBranchPower(0.0);

            } if (branchSet.getSecondBranchSet() == 1) {
                branchPower.setSecondBranchPower(0.0);

            } if ( branchSet.getThirdBranchSet() == 1) {
                branchPower.setThirdBranchPower(0.0);

            }  if (branchSet.getForthBranchSet() == 1) {
                branchPower.setForthBranchPower(0.0);
            }
        }

        int insertBranchPower = mapper.insert(branchPower);
        if(insertBranchPower != 0){
            return ApiResultHandler.buildApiResult(200, "添加成功", insertBranchPower);
        }
        return ApiResultHandler.buildApiResult(400, "添加失败", null);

    }
}
