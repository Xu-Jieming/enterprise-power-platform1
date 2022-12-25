package com.epp.service.impl;

import com.epp.mapper.TiredRateMapper;
import com.epp.pojo.ApiResult;
import com.epp.pojo.TiredRate;
import com.epp.service.TiredRateService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/11/20:37
 * @Description:
 */

@Service
@Service
public class TiredRateServiceImpl implements TiredRateService {

    @Autowired
    public TiredRateMapper tiredRatesMapper;

    @Override
    public ApiResult update(TiredRate tiredRates) {

/*        int updateTiredRates = tiredRatesMapper.update(tiredRates);
        if(updateTiredRates != 0){
            return ApiResultHandler.buildApiResult(200, "费率修改成功", updateTiredRates);
        }
        return ApiResultHandler.buildApiResult(400, "费率修改失败", null);
    }*/

        return ApiResultHandler.buildApiResult(400, "费率修改失败", null);
    }
}