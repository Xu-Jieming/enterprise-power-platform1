package com.epp.util;


import com.epp.pojo.ApiResult;

public class ApiResultHandler {

    public static ApiResult success(Object object) {
        ApiResult apiResult = new ApiResult();
        apiResult.setData(object);
        apiResult.setCode(200);
        apiResult.setMessage("请求成功");
        return apiResult;
    }

    public static ApiResult success() {
        return success(null);
    }

    public static <T> ApiResult buildApiResult(Integer code, String message, T data) {
        ApiResult apiResult = new ApiResult();

        apiResult.setCode(code);
        apiResult.setMessage(message);
        apiResult.setData(data);
        //System.out.println(apiResult.getCode());
        //System.out.println(apiResult.getData());
        //System.out.println(apiResult.getMessage());
        return apiResult;
    }
}
