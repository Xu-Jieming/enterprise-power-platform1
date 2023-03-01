package com.epp;

import com.epp.mapper.BranchPowerMapper;
import com.epp.mapper.BranchSetMapper;
import com.epp.mapper.EnterpriseDailyPowerMapper;
import com.epp.mapper.HourlyPowerMapper;
import com.epp.pojo.*;
import com.epp.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;


@SpringBootTest
class PowerPlatformApplicationTests {


    private Calendar ca = Calendar.getInstance();

    private  int day =ca.get(Calendar.DAY_OF_MONTH);//一年中的第几天
    private  int month =ca.get(Calendar.MONTH)+1;//第几个月, Attention ! must add one
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

    @Autowired
    private LogService logService;


    @Autowired
    private TiredRateService tiredRateService;


    @Autowired
    private EnterpriseAccountService accountService;

    @Test
    void testLog(){
        //System.out.println(logService.selectAll());

/*        Log log = new Log();
        log.setAdminId(1);
        System.out.println(logService.insert(log));*/

    }

    @Test
    void testTiredRate(){

    }

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
        if (hourlyPowerMapper.selectByEntity(1,year,month,day).size() == 0){
            hourlyPowerService.insert(1);
            branchPowerService.insert(1);
            enterpriseDailyPowerService.insert(1);
        }
        if (enterprisePowerService.selectByEntity(1) == null){
            enterprisePowerService.insert(1);
            enterprisePaymentService.insert(1);
        }
        if(accountService.selectByEnterpriseId(1).getData() ==null){
            accountService.insert(1);
        }

    }
    
    
    @Test
    void outputCalendar(){
        System.out.println(day);
    }


    @Autowired
    HourlyPowerMapper hourlyPowerMapper;

    @Autowired
    BranchPowerMapper branchPowerMapper;

    @Autowired
    EnterpriseDailyPowerMapper dailyPowerMapper;

    @Test
    void updatePower(){
        List<HourlyPower> hourlyPowerList = hourlyPowerMapper.selectByEntity(1, 2022,12, 26);
        for(HourlyPower hourlyPower : hourlyPowerList){
            //这里添加修改hourlyPower的语句
        }
        int enterpriseId = hourlyPowerList.get(0).getEnterpriseId();
        //System.out.println(month);
        branchPowerService.update(enterpriseId);//目的仅仅是要获得修改后的hourly的企业ID，然后放进去update就可以修改了
        //System.out.println(branchPowerService.selectByEntity(hourlyPowerList.get(0)));
        //System.out.println(branchPowerMapper.selectByEntity(1,2022,12,26));
        enterpriseDailyPowerService.update(enterpriseId);
        //System.out.println(dailyPowerMapper.selectByEntity(1,2022,12,26));
        enterprisePowerService.update(enterpriseId);
        enterprisePaymentService.update(enterpriseId);
    }


    @Test
    void updateAccount(){
        Integer enterpriseId = 1;
        double  inputAccount = 200.0;
        EnterpriseAccount account = new EnterpriseAccount();
        account.setCurrentAccount(inputAccount);
        account.setEnterpriseId(enterpriseId);
        accountService.update(account);
    }







}
