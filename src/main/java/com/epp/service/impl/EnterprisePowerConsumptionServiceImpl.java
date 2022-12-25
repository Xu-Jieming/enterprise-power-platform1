package com.epp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.ApiResult;
import com.epp.service.EnterprisePowerConsumptionService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/11/22:03
 * @Description:
 */
@Service
public class EnterprisePowerConsumptionServiceImpl implements EnterprisePowerConsumptionService {

/*    @Autowired
    private EnterprisePowerConsumptionMapper consumptionMapper;

    @Autowired
    private TiredRates tiredRates;

    @Override
    public ApiResult<EnterprisePowerConsumption> findAll() {
        List<EnterprisePowerConsumption> consumptionList= consumptionMapper.findAll();
        if(consumptionList != null){
            return ApiResultHandler.buildApiResult(200, "不分页查询所有企业分项用能成功", consumptionList);
        }
        return ApiResultHandler.buildApiResult(400, "不分页查询所有企业分项用能失败", null);
    }

    @Override
    public ApiResult<EnterprisePowerConsumption> findAll(Page<EnterprisePowerConsumption> page) {
        IPage<EnterprisePowerConsumption> consumptionList= consumptionMapper.findAll(page);
        if(consumptionList != null){
            return ApiResultHandler.buildApiResult(200, "分页查询所有企业分项用能成功", consumptionList);
        }
        return ApiResultHandler.buildApiResult(400, "分页查询所有企业分项用能失败", null);

    }

    @Override
    public ApiResult findByEnterpriseId(Integer enterpriseId) {
        EnterprisePowerConsumption consumption = consumptionMapper.findByEnterpriseId(enterpriseId);
        if (consumption != null) {
            return ApiResultHandler.buildApiResult(200, "文章查询成功", consumption);
        }
        return ApiResultHandler.buildApiResult(400, "文章查询失败", null);

    }

    @Override
    public ApiResult findByEnterpriseName(Page<EnterprisePowerConsumption> page, String enterpriseName) {
        IPage<EnterprisePowerConsumption> consumptionList= consumptionMapper.findByEnterpriseName(page,enterpriseName);
        if(consumptionList != null){
            return ApiResultHandler.buildApiResult(200, "根据企业名分页查询所有企业分项用能成功", consumptionList);
        }
        return ApiResultHandler.buildApiResult(400, "根据企业名分页查询所有企业分项用能失败", null);

    }

    @Override
    public ApiResult deleteById(Integer enterpriseId) {
        int deleteId = consumptionMapper.deleteById(enterpriseId);
        if(deleteId != 0){
            return ApiResultHandler.buildApiResult(200, "企业用能删除成功", deleteId);
        }
        return ApiResultHandler.buildApiResult(400, "企业用能删除失败", null);

    }

    @Override
    public ApiResult update(EnterprisePowerConsumption consumption) {
        double firstRatePayment = consumption.getFirstRatePower() * tiredRates.getFirstTieredRates();
        double secondRatePayment = consumption.getSecondRatePower() * tiredRates.getSecondTieredRates();
        double thirdRatePayment = consumption.getThirdRatePower() * tiredRates.getThirdTieredRates();
        consumption.setFirstRatePayment(firstRatePayment);
        consumption.setSecondRatePayment(secondRatePayment);
        consumption.setThirdRatePayment(thirdRatePayment);
        int updateConsumption = consumptionMapper.update(consumption);
        if(updateConsumption != 0){
            return ApiResultHandler.buildApiResult(200, "企业分项用能修改成功", updateConsumption);
        }
        return ApiResultHandler.buildApiResult(400, "企业分项用能修改失败", null);
    }

    @Override
    public ApiResult add(EnterprisePowerConsumption consumption) {


        if(consumption.getRatePower() <= tiredRates.getFirstTieredRates()){//如果电价小于等于第一阶梯
            consumption.setFirstRatePower(consumption.getRatePower());
        }else if (consumption.getRatePower() <= tiredRates.getSecondTieredRates()){//如果电价小于等于第2阶梯
            consumption.setFirstRatePower(tiredRates.getFirstTieredRates());
            consumption.setSecondRatePower(consumption.getRatePower()-tiredRates.getFirstTieredRates());
        }else {//如果电价小于等于第3阶梯
            consumption.setFirstRatePower(tiredRates.getFirstTieredRates());
            consumption.setSecondRatePower(tiredRates.getSecondTieredRates()-tiredRates.getFirstTieredRates());
            consumption.setThirdRatePower(consumption.getRatePower()-tiredRates.getSecondTieredRates());
        }

        double firstRatePayment = consumption.getFirstRatePower() * tiredRates.getFirstTieredRates();
        double secondRatePayment = consumption.getSecondRatePower() * tiredRates.getSecondTieredRates();
        double thirdRatePayment = consumption.getThirdRatePower() * tiredRates.getThirdTieredRates();
        consumption.setFirstRatePayment(firstRatePayment);
        consumption.setSecondRatePayment(secondRatePayment);
        consumption.setThirdRatePayment(thirdRatePayment);
        int addConsumption = consumptionMapper.update(consumption);
        if(addConsumption != 0){
            return ApiResultHandler.buildApiResult(200, "企业分项用能添加成功", addConsumption);
        }
        return ApiResultHandler.buildApiResult(400, "企业分项用能添加失败", null);

    }*/
}
