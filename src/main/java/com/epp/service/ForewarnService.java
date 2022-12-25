package com.epp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.ApiResult;
import com.epp.pojo.Forewarn;

public interface ForewarnService {
    public ApiResult selectAll();

    public ApiResult selectAll(Page<Forewarn> page);

    public ApiResult selectByPrimaryKey(Integer forewarnId);

    public ApiResult deleteByPrimaryKey(Integer forewarnId);

    public ApiResult update(Forewarn Forewarn);

    public ApiResult insert(Forewarn Forewarn);
}
