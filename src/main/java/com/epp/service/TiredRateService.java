package com.epp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.ApiResult;
import com.epp.pojo.Enterprise;
import com.epp.pojo.TiredRate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/11/20:34
 * @Description:
 */
public interface TiredRateService {

    public ApiResult selectAll();

    public ApiResult selectAll(Page<TiredRate> page);

    public ApiResult selectByPrimaryKey(Integer tiredRateId);

    public ApiResult deleteByPrimaryKey(Integer tiredRateId);

    public ApiResult update(TiredRate tiredRate);

    public ApiResult insert(TiredRate tiredRate);

    public TiredRate selectByDate(Integer year,Integer month);
}
