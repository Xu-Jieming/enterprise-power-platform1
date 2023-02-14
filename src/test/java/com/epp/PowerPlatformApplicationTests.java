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
import java.util.*;


@SpringBootTest
class PowerPlatformApplicationTests {


    private Calendar ca = Calendar.getInstance();

    private  int day =ca.get(Calendar.DAY_OF_MONTH);//一年中的第几天
    private  int month =ca.get(Calendar.MONTH)+1;//第几个月, Attention ! must add one
    private  int year =ca.get(Calendar.YEAR);//年份数值
    private  int week = ca.get(Calendar.DAY_OF_WEEK);//周几，1~7
    private  int dayOfWeek = ca.get(Calendar.DAY_OF_WEEK);
    private  int weekOfYear = ca.get(Calendar.WEEK_OF_YEAR);

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


    @Autowired
    HourlyPowerMapper hourlyPowerMapper;

    @Autowired
    BranchPowerMapper branchPowerMapper;

    @Autowired
    EnterpriseDailyPowerMapper dailyPowerMapper;


    @Test
    void outputCalendar(){
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.add(Calendar.MONTH, -4);//设置目前的六个月前
//        //calendar.add(Calendar.DATE, -35);//设置前45天
//        //System.out.println(calendar.getTime());
//        System.out.println(calendar.getTime());
//        System.out.println(calendar.getWeekYear());//这个可以直接获得年份
//        System.out.println(calendar.get(5));//5是日期
//        System.out.println(calendar.get(2));//2是月份-1
//        System.out.println(calendar.get(1));//1是年
//        System.out.println(calendar.get(7));//是周几，从星期天到星期六：1~7
//        System.out.println(calendar.get(6));//是今年一共过了多少天
//        System.out.println(calendar.get(11));//小时
//        System.out.println(calendar.get(12));//分钟
//        System.out.println(calendar.get(13));//秒

        Calendar rightNow = Calendar.getInstance(); // 子类对象
        int dayOfWeek = rightNow.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek);
        //calendar.add(5,28);//在日期添加28天
        //System.out.println(calendar.getTime());

/*        for(int i = 1;!(calendar.get(1) == 2023 && calendar.get(2)+1 == 2 && calendar.get(5) == 14);i++,calendar.add(5,1)){
            System.out.println(i);
        }*/


    }

    //如果是update的部分报错了，那么你需要先运行
    @Test
    void calendarAdd(){

    }


    @Test
    void testLog(){
        //System.out.println(logService.selectAll());

/*        Log log = new Log();
        log.setAdminId(1);
        System.out.println(logService.insert(log));*/

    }

    @Test
    void addTiredRate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -8);//设置目前的六个月前
        TiredRate tiredRate = new TiredRate();
        //int i = 0;
        for(;!(calendar.get(1) == 2023 && calendar.get(2)+1 == 2 && calendar.get(5) == 14);calendar.add(5,1)) {
            if (tiredRateService.selectByDate(calendar.get(1), calendar.get(2) + 1) == null) {
                tiredRate.setYear(calendar.get(1));
                tiredRate.setMonth(calendar.get(2) + 1);
                tiredRate.setFirstRateInterval(0);
                tiredRate.setSecondRateInterval(200);
                tiredRate.setThirdRateInterval(400);
                tiredRate.setFirstTiredRate(0.64);
                tiredRate.setSecondTiredRate(0.69);
                tiredRate.setThirdTiredRate(0.94);
                tiredRateService.insert(tiredRate);

            }
        }

    }

    @Test
    void contextLoads() {
    }


    @Test
    public void enterpriseSelectLoads(){
        //ApiResult enterprise = enterpriseService.selectByPrimaryKey(1);
        //System.out.println(enterprise);

    }

/*    //要先运行这个，先往数据库里面插入数据
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
        if(accountService.selectByEnterpriseId(1) == null){
            accountService.insert(1);
        }

    }*/

    //然后运行这个，才可以往数据库里面加入东西
    @Test
    void updatePower(){
        List<HourlyPower> hourlyPowerList = hourlyPowerMapper.selectByEntity(1, year,month, day);
        Random random = new Random();
        for(HourlyPower hourlyPower : hourlyPowerList){
            //这里添加修改hourlyPower的语句
            hourlyPower.setFirstPeriodPower(random.nextDouble()*150);
        }
        int enterpriseId = hourlyPowerList.get(0).getEnterpriseId();
        //System.out.println(month);
/*        branchPowerService.update(enterpriseId);//目的仅仅是要获得修改后的hourly的企业ID，然后放进去update就可以修改了
        //System.out.println(branchPowerService.selectByEntity(hourlyPowerList.get(0)));
        //System.out.println(branchPowerMapper.selectByEntity(1,2022,12,26));
        enterpriseDailyPowerService.update(enterpriseId);
        //System.out.println(dailyPowerMapper.selectByEntity(1,2022,12,26));
        enterprisePowerService.update(enterpriseId);
        enterprisePaymentService.update(enterpriseId);*/
    }


    //要添加以前的数据库信息，就用以下的代码
    //要先运行这个，先往数据库里面插入数据，如果是update部分报错了，那么就是tiredrate部分有问题，缺少相应月份的阶梯，所以要先运行前面的addtiredrate来填充数据库再来更新
    @Test
    void insertDatabase(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -8);//设置目前的8个月前
        //calendar.add(Calendar.DATE, -3);//设置前3天
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(new Date());
        calendar1.add(Calendar.MONTH, -8);//设置目前的8个月前
        //int i = 0;

        for(int enterpriseId = 1; enterpriseId <= enterpriseService.selectAll().size();enterpriseId++)//每一个企业都按照以下步骤添加，每一个i代表一个企业
        {
            //添加数据库部分
            for(;!(calendar.get(1) == 2023 && calendar.get(2)+1 == 2 && calendar.get(5) == 14);calendar.add(5,1)) {//2月14号之前的都会添加进去
                        //里面放数据库的循环体
                        if (hourlyPowerMapper.selectByEntity(enterpriseId,calendar.get(1),calendar.get(2)+1,calendar.get(5)).size() == 0){
                            hourlyPowerService.insert(enterpriseId,calendar.get(1),calendar.get(2)+1,calendar.get(5));
                            branchPowerService.insert(enterpriseId,calendar.get(1),calendar.get(2)+1,calendar.get(5));
                            enterpriseDailyPowerService.insert(enterpriseId,calendar.get(1),calendar.get(2)+1,calendar.get(5));
                        }
                        if (enterprisePowerService.selectByEntity(enterpriseId,calendar.get(1),calendar.get(2)+1) == null){
                            enterprisePowerService.insert(enterpriseId,calendar.get(1),calendar.get(2)+1);
                            enterprisePaymentService.insert(enterpriseId,calendar.get(1),calendar.get(2)+1);
                        }
                    }

            //更新数据库，往里面插入数据部分
            for(;!(calendar1.get(1) == 2023 && calendar1.get(2)+1 == 2 && calendar1.get(5) == 14);calendar1.add(5,1)) {//2月14号之前的都会添加进去

                        List<HourlyPower> hourlyPowerList = hourlyPowerMapper.selectByEntity(enterpriseId, calendar1.get(1),calendar1.get(2)+1, calendar1.get(5));//如果数据库里面有数据
                        Random random = new Random();
                        if(calendar1.get(7)== 1 || calendar1.get(7)== 7){
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
                        hourlyPowerService.update(hourlyPowerList,enterpriseId, calendar1.get(1),calendar1.get(2)+1, calendar1.get(5));
                        branchPowerService.update(enterpriseId, calendar1.get(1),calendar1.get(2)+1, calendar1.get(5));//目的仅仅是要获得修改后的hourly的企业ID，然后放进去update就可以修改了
                        enterpriseDailyPowerService.update(enterpriseId, calendar1.get(1),calendar1.get(2)+1, calendar1.get(5));
                        enterprisePowerService.update(enterpriseId, calendar1.get(1),calendar1.get(2)+1);
                        enterprisePaymentService.update(enterpriseId, calendar1.get(1),calendar1.get(2)+1);
                    }

        }



    }






    @Test
    void insertAccount(){

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
