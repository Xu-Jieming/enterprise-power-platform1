package com.epp.controller;

import com.epp.mapper.BranchPowerMapper;
import com.epp.mapper.BranchSetMapper;
import com.epp.mapper.EnterpriseDailyPowerMapper;
import com.epp.mapper.HourlyPowerMapper;
import com.epp.pojo.ApiResult;
import com.epp.pojo.Enterprise;
import com.epp.pojo.HourlyPower;
import com.epp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/27/14:44
 * @Description:
 */
@Controller
@CrossOrigin
@ResponseBody
public class HourlyPowerController {

    private Calendar ca = Calendar.getInstance();

    private  int day =ca.get(Calendar.DAY_OF_MONTH);//一年中的第几天
    private  int month =ca.get(Calendar.MONTH)+1;//第几个月, Attention ! must add one
    private  int year =ca.get(Calendar.YEAR);//年份数值
    private  int dayOfWeek = ca.get(Calendar.DAY_OF_WEEK);
    @Autowired
    private BranchPowerService branchPowerService;

    @Autowired
    private HourlyPowerService hourlyPowerService;

    @Autowired
    private EnterpriseDailyPowerService enterpriseDailyPowerService;

    @Autowired
    private EnterprisePowerService enterprisePowerService;

    @Autowired
    private EnterprisePaymentService enterprisePaymentService;

    @Autowired
    HourlyPowerMapper hourlyPowerMapper;

    @Autowired
    BranchPowerMapper branchPowerMapper;

    @Autowired
    EnterpriseDailyPowerMapper dailyPowerMapper;

    @Autowired
    private EnterpriseAccountService accountService;


    @GetMapping("/hourlyPower")
    public ApiResult selectAll(){
        //System.out.println("查询全部");
        return hourlyPowerService.selectAll();
    }

    @GetMapping("/hourlyPower/{enterpriseId}")
    public ApiResult selectByEnterpriseId(@PathVariable("enterpriseId") Integer enterpriseId){
        //System.out.println("查询全部");
        return hourlyPowerService.selectByEnterpriseId(enterpriseId);
    }


    @PutMapping("/hourlyPower")
    public ApiResult updatePower(@RequestBody Enterprise enterprise){
        int enterpriseId = enterprise.getEnterpriseId();
        ApiResult result  = null;
        List<HourlyPower> hourlyPowerList = hourlyPowerMapper.selectByEntity(enterpriseId, year,month, day);//如果数据库里面有数据
        Random random = new Random();
        if(dayOfWeek == 1 || dayOfWeek== 7){
            //这里放置周末期间random数据，下面是例子
            for(HourlyPower hourlyPower : hourlyPowerList){
                //这里添加修改hourlyPower的语句
                hourlyPower.setFirstPeriodPower(random.nextDouble()*50);
                hourlyPower.setSecondPeriodPower(random.nextDouble()*100);
                hourlyPower.setThirdPeriodPower(random.nextDouble()*110);
                hourlyPower.setForthPeriodPower(random.nextDouble()*50);
            }
        }else{
            //这里放工作日期间random数据，下面是例子
            for(HourlyPower hourlyPower : hourlyPowerList){
                //这里添加修改hourlyPower的语句
                hourlyPower.setFirstPeriodPower(random.nextDouble()*100);
                hourlyPower.setSecondPeriodPower(random.nextDouble()*150);
                hourlyPower.setThirdPeriodPower(random.nextDouble()*200);
                hourlyPower.setForthPeriodPower(random.nextDouble()*100);
            }
        }
        hourlyPowerService.update(hourlyPowerList,enterpriseId, year,month, day);
        branchPowerService.update(enterpriseId, year,month, day);
        enterpriseDailyPowerService.update(enterpriseId, year,month, day);
        enterprisePowerService.update(enterpriseId, year,month);
        enterprisePaymentService.update(enterpriseId, year,month);

        return  result;
    }

    @PostMapping("/hourlyPower")
    public ApiResult insertPower(@RequestBody Enterprise enterprise){
        int enterpriseId = enterprise.getEnterpriseId();
        ApiResult result = null;
        if (hourlyPowerMapper.selectByEntity(enterpriseId,year,month,day).size() == 0){
            result = hourlyPowerService.insert(enterpriseId,year,month,day);
            branchPowerService.insert(enterpriseId,year,month,day);
            enterpriseDailyPowerService.insert(enterpriseId,year,month,day);
        }else{
            result.setCode(1000);
            result.setData("当天已经创建了，不需要再次创建");
        }
        if (enterprisePowerService.selectByEntity(enterpriseId,year,month) == null){
            enterprisePowerService.insert(enterpriseId,year,month);
            enterprisePaymentService.insert(enterpriseId,year,month);
        }
        if(accountService.selectByEnterpriseId(enterpriseId) ==null){
            accountService.insert(enterpriseId);
        }
        return result;
    }



}
