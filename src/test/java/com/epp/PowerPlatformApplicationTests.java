package com.epp;

import com.epp.mapper.BranchSetMapper;
import com.epp.pojo.*;
import com.epp.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;


@SpringBootTest
class PowerPlatformApplicationTests {


    private Calendar ca = Calendar.getInstance();

    private  int day =ca.get(Calendar.DAY_OF_MONTH);//一年中的第几天
    private  int month =ca.get(Calendar.MONTH);//第几个月
    private  int year =ca.get(Calendar.YEAR);//年份数值

    @Autowired
    private EnterpriseService enterpriseService;


    @Autowired
    private AdminService adminService;

    @Autowired
    private BranchPowerService branchPowerService;

    @Autowired
    private BranchSetMapper branchSetMapper;

    @Autowired
    private HourlyPowerService hourlyPowerService;

    @Autowired
    private EnterpriseDailyPowerService enterpriseDailyPowerService;

    @Autowired
    private EnterprisePowerService enterprisePowerService;

    @Autowired
    private EnterprisePaymentService enterprisePaymentService;

    @Test
    void contextLoads() {
    }


    @Test
    public void enterpriseSelectLoads(){
        //ApiResult enterprise = enterpriseService.selectByPrimaryKey(1);
        //System.out.println(enterprise);

    }

    @Test
    void insertPower(){
        hourlyPowerService.insert(1);
        branchPowerService.insert(1);
        enterpriseDailyPowerService.insert(1);
        enterprisePowerService.insert(1);
        enterprisePaymentService.insert(1);
    }
    
    
    @Test
    void outputCalendar(){
        System.out.println(day);
    }


    @Test
    void updatePower(){
        ApiResult hourlyPower = hourlyPowerService.selectByEntity(1,2022,12,25);

    }
}
