package com.epp.controller;

import com.epp.mapper.BranchPowerMapper;
import com.epp.mapper.BranchSetMapper;
import com.epp.mapper.EnterpriseDailyPowerMapper;
import com.epp.mapper.HourlyPowerMapper;
import com.epp.pojo.ApiResult;
import com.epp.pojo.Enterprise;
import com.epp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

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



    @PostMapping("/hourlyPower")
    public ApiResult insertPower(@RequestBody Enterprise enterprise){
        int enterpriseId = enterprise.getEnterpriseId();
        ApiResult result = null;
        if (hourlyPowerMapper.selectByEntity(enterpriseId,year,month,day).size() == 0){
            result = hourlyPowerService.insert(enterpriseId);
            branchPowerService.insert(enterpriseId);
            enterpriseDailyPowerService.insert(enterpriseId);
        }else{
            result.setCode(1000);
            result.setData("当天已经创建了，不需要再次创建");
        }
        if (enterprisePowerService.selectByEntity(enterpriseId) == null){
            enterprisePowerService.insert(enterpriseId);
            enterprisePaymentService.insert(enterpriseId);
        }
        if(accountService.selectByEnterpriseId(enterpriseId).getData() ==null){
            accountService.insert(enterpriseId);
        }
        return result;
    }

}
