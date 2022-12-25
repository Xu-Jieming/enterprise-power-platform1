package com.epp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.ApiResult;
import com.epp.pojo.Log;

public interface LogService {

    public ApiResult selectAll();

    public ApiResult selectAll(Page<Log> page);

    public ApiResult selectByPrimaryKey(Integer logId);

    public ApiResult deleteByPrimaryKey(Integer logId);

    public ApiResult update(Log Log);

    public ApiResult insert(Log Log);
}
