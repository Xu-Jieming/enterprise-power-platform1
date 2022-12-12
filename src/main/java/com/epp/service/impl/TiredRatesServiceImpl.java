package com.epp.service.impl;

import com.epp.mapper.TiredRatesMapper;
import com.epp.pojo.ApiResult;
import com.epp.pojo.TiredRates;
import com.epp.service.TiredRatesService;
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
public class TiredRatesServiceImpl implements TiredRatesService {

    @Autowired
    public TiredRatesMapper tiredRatesMapper;

    @Override
    public ApiResult update(TiredRates tiredRates) {
        int updateTiredRates = tiredRatesMapper.update(tiredRates);
        if(updateTiredRates != 0){
            return ApiResultHandler.buildApiResult(200, "费率修改成功", updateTiredRates);
        }
        return ApiResultHandler.buildApiResult(400, "费率修改失败", null);
    }


}
