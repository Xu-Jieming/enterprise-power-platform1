package com.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.AlipayConfig;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.FileItem;
import java.util.Base64;
import java.util.ArrayList;
import java.util.List;

public class AlipayTradePagePay {

    public static void main(String[] args) throws AlipayApiException {
        String privateKey = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQChnhbwkWX4jzuVI3R6o93AQ+uhvl0I66aBmvH8RSSzAxUBQujJVtOaJDQTvAQEJeDzI5S7AZyk8rxme7ErpLr0ka5c2flzvcT++Plp/fZBhXlVxzYF3cktVNF+jf4ZGn3H7QYDXZgSWCCotkD6SBXBEjAM2jHSGNslx+La8wU9qACh1Kh+Ldd8dRPryQxsKv4yG8+LoYi1jV1K58NlW4aiOIlNdu0VaFNKuVQaUxflrqw3cpHBElM1zMVYnq4Z//Gi3Ou3tN5zENZ4Qih3dIH5uWMvWUrg5uMlQBm+bbTNtdw/57x5GLmE0JYmMum0RLsFprU13IngUnaiACT9yut3AgMBAAECggEBAIJ9E+R0YLKJYwANOlRyze4YaL2U56T2Lt/h7JNUeEcYq/LyxOUa94oyxOFSIqP+uVtWVRWQPZtoaPkN0YR9Yn1oyjEpxSDQDagX+bi8VgGc9NRvHY0q/u1c2DCoEIrQOtIa64n4HXpiMSxGyrvJS9cxCh62ZRdO/lHIy78gDBE0tZNMbFvXYlml0AOznef6SO8laxAAYumZrC0ejoyv+ZDOHnpU25n3WFBg6kNdK61pAwxmD1gJLLOkwiNDYQ98J5ZO1ksXx8PxZ11Q3RhvzRMhyHfu6QVSlN5KnJq0IUwwIqJc0BVbc1CTq6Lj4L5/nl+yznf21S/FErMM2VsSxvECgYEAz/Cc6/vWi5jTC1gwRdYRUFjPszmFMtE9qXnak6ibQUZmYvMkeYPQpaEukG/IZxWtDdrCCgzA6BnoW+Y8lHryC6Xk1OtP8OB5iRZiKKqjonySbdDWaA9fVBmEG405lUccFTT1xNZ+UglqmGwAwYIIb+Xprwu2tnKiEfyYVoNkOGMCgYEAxvis8cFcz5XWJAyeBaW090/2iM1UGqA8v4Bg5VT4+zARM949QGDW/0z5iHADjygEP48HYkHqTnk2AGwsamcXdn0MnmizhcxLIrKZ9jbmbIrPhwFVadtQYAt+tcKpGOVo3uHYCITj4ZCh8+dE+o/g/Fq1VyjL5okq96nyHUzCKt0CgYEAvmdKqWM+/zB+/0JPYYM082d/OFORPgkO92KW3OJk146JLk4JtiMXKLLAmo1g6dOVVLxdNSqccWtXst7N1gAGJthPAxA9cQl7ACY415f4ok6DHn899Kcu2SlMKJZWhfRJKLoH2ae2n5PzwYIT5x0UcLIMGrcVJVcuRF4ReBZz7JUCgYEAu8S7uN3oj0Hwt05s5hluASImHw3eO85R5crqJiIdYTcIVPF6zkFVQ9LJfddvlG6IK873geOAkZPTwWxUMgmd28TA3tEh8bdMhK8VmoROycnpdJdumppMbIcMicztNUBxyjxJWijGwPxzya/LqcWT5bJYhatLWQDDWru3b60bY8UCgYEAyL3kLcp3MFDAm4Pn5X9JURska5dtRVqoqgmxa1kmC3UnnwT6TD0CXTRXQugeJCkMvapyi/8caQrj5Dj2eYFprq2x5zgeLt+DOYh0MMVLAAvgclR6niQ3h+DpJLtBKnpwDUEMdK97/JJDTywTD+5+hf6KJRbH7xXXjzdWDnENHig=";
        String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA3Dq1Tjv18p6Tx7o6Up5gdGGhAIO8Ao4AakYfaG8QSvu3rbVU37cFdSiNSGAG+cjYadVzGU7jVq78PWb0QeNowy2hJ7hHEgHw0aWL4pIpvjGURHQMdhgKnGI7mh8KVm9yfq+3A9cK/Ch3PSg0MopWhBvCXhs5l7voCl+HilZUQFNyS/DAP7UrtG3rwoNpTM8Z1t3RaqfK2WG1xQzrXFhJyWiBye1MuQRUa3B0ySGiqdbxDxrAlONZP8b0V2md3IgvSS51gd6hsElImhwxuAI+E49nCB8IBFpsmhQqKIzTFkcfjMhpYnCFCis4aLR+b3rdQZqweZptSnzzeaHz891dcwIDAQAB";
        AlipayConfig alipayConfig = new AlipayConfig();
        alipayConfig.setServerUrl("https://openapi.alipaydev.com/gateway.do");
        alipayConfig.setAppId("2021000122603615");
        alipayConfig.setPrivateKey(privateKey);
        alipayConfig.setFormat("json");
        alipayConfig.setAlipayPublicKey(alipayPublicKey);
        alipayConfig.setCharset("UTF8");
        alipayConfig.setSignType("RSA2");
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        model.setOutTradeNo("201925220000001");
        model.setTotalAmount("88.88");
        model.setSubject("当前企业消费");
        model.setProductCode("FAST_INSTANT_TRADE_PAY");
        request.setBizModel(model);
        AlipayTradePagePayResponse response = alipayClient.pageExecute(request);
        System.out.println(response.getBody());
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }
}
