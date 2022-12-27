package com.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class AlipayTemplate {

    //在支付宝创建的应用的id
    private   String app_id = "2021000122603615";

    // 商户私钥，您的PKCS8格式RSA2私钥
    private String merchant_private_key ="MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQChnhbwkWX4jzuVI3R6o93AQ+uhvl0I66aBmvH8RSSzAxUBQujJVtOaJDQTvAQEJeDzI5S7AZyk8rxme7ErpLr0ka5c2flzvcT++Plp/fZBhXlVxzYF3cktVNF+jf4ZGn3H7QYDXZgSWCCotkD6SBXBEjAM2jHSGNslx+La8wU9qACh1Kh+Ldd8dRPryQxsKv4yG8+LoYi1jV1K58NlW4aiOIlNdu0VaFNKuVQaUxflrqw3cpHBElM1zMVYnq4Z//Gi3Ou3tN5zENZ4Qih3dIH5uWMvWUrg5uMlQBm+bbTNtdw/57x5GLmE0JYmMum0RLsFprU13IngUnaiACT9yut3AgMBAAECggEBAIJ9E+R0YLKJYwANOlRyze4YaL2U56T2Lt/h7JNUeEcYq/LyxOUa94oyxOFSIqP+uVtWVRWQPZtoaPkN0YR9Yn1oyjEpxSDQDagX+bi8VgGc9NRvHY0q/u1c2DCoEIrQOtIa64n4HXpiMSxGyrvJS9cxCh62ZRdO/lHIy78gDBE0tZNMbFvXYlml0AOznef6SO8laxAAYumZrC0ejoyv+ZDOHnpU25n3WFBg6kNdK61pAwxmD1gJLLOkwiNDYQ98J5ZO1ksXx8PxZ11Q3RhvzRMhyHfu6QVSlN5KnJq0IUwwIqJc0BVbc1CTq6Lj4L5/nl+yznf21S/FErMM2VsSxvECgYEAz/Cc6/vWi5jTC1gwRdYRUFjPszmFMtE9qXnak6ibQUZmYvMkeYPQpaEukG/IZxWtDdrCCgzA6BnoW+Y8lHryC6Xk1OtP8OB5iRZiKKqjonySbdDWaA9fVBmEG405lUccFTT1xNZ+UglqmGwAwYIIb+Xprwu2tnKiEfyYVoNkOGMCgYEAxvis8cFcz5XWJAyeBaW090/2iM1UGqA8v4Bg5VT4+zARM949QGDW/0z5iHADjygEP48HYkHqTnk2AGwsamcXdn0MnmizhcxLIrKZ9jbmbIrPhwFVadtQYAt+tcKpGOVo3uHYCITj4ZCh8+dE+o/g/Fq1VyjL5okq96nyHUzCKt0CgYEAvmdKqWM+/zB+/0JPYYM082d/OFORPgkO92KW3OJk146JLk4JtiMXKLLAmo1g6dOVVLxdNSqccWtXst7N1gAGJthPAxA9cQl7ACY415f4ok6DHn899Kcu2SlMKJZWhfRJKLoH2ae2n5PzwYIT5x0UcLIMGrcVJVcuRF4ReBZz7JUCgYEAu8S7uN3oj0Hwt05s5hluASImHw3eO85R5crqJiIdYTcIVPF6zkFVQ9LJfddvlG6IK873geOAkZPTwWxUMgmd28TA3tEh8bdMhK8VmoROycnpdJdumppMbIcMicztNUBxyjxJWijGwPxzya/LqcWT5bJYhatLWQDDWru3b60bY8UCgYEAyL3kLcp3MFDAm4Pn5X9JURska5dtRVqoqgmxa1kmC3UnnwT6TD0CXTRXQugeJCkMvapyi/8caQrj5Dj2eYFprq2x5zgeLt+DOYh0MMVLAAvgclR6niQ3h+DpJLtBKnpwDUEMdK97/JJDTywTD+5+hf6KJRbH7xXXjzdWDnENHig=";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    private  String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoZ4W8JFl+I87lSN0eqPdwEProb5dCOumgZrx/EUkswMVAULoyVbTmiQ0E7wEBCXg8yOUuwGcpPK8ZnuxK6S69JGuXNn5c73E/vj5af32QYV5Vcc2Bd3JLVTRfo3+GRp9x+0GA12YElggqLZA+kgVwRIwDNox0hjbJcfi2vMFPagAodSofi3XfHUT68kMbCr+MhvPi6GItY1dSufDZVuGojiJTXbtFWhTSrlUGlMX5a6sN3KRwRJTNczFWJ6uGf/xotzrt7TecxDWeEIod3SB+bljL1lK4ObjJUAZvm20zbXcP+e8eRi5hNCWJjLptES7Baa1NdyJ4FJ2ogAk/crrdwIDAQAB";
    // 服务器[异步通知]页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 支付宝会悄悄的给我们发送一个请求，告诉我们支付成功的信息
    // 一个接收支付成功信息的东西，可以返回支付的订单号  要看返回的路径
    public static String notify_url = "http://localhost:8081/payment";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //同步通知，支付成功，一般跳转到成功页（如我的订单页面），也可以跳到一个controller。这里返回到改变订单状态的controller，方法里改变订单状态由未支付到支付，并重定向至支付成功页面
    public static String return_url = "http://localhost:8080/Dangdang/order/changeOrderState.do";

    // 签名方式
    private  String sign_type = "RSA2";

    // 字符编码格式
    private  String charset = "utf-8";

    // 支付宝网关； https://openapi.alipaydev.com/gateway.do
    private  String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    public  String pay(PayVo vo) throws AlipayApiException {

        //AlipayClient alipayClient = new DefaultAlipayClient(AlipayTemplate.gatewayUrl, AlipayTemplate.app_id, AlipayTemplate.merchant_private_key, "json", AlipayTemplate.charset, AlipayTemplate.alipay_public_key, AlipayTemplate.sign_type);
        //1、根据支付宝的配置生成一个支付客户端
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl,
                app_id, merchant_private_key, "json",
                charset, alipay_public_key, sign_type);

        //2、创建一个支付请求 //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = vo.getOut_trade_no();
        //付款金额，必填
        String total_amount = vo.getTotal_amount();
        //订单名称，必填
        String subject = vo.getSubject();
        //商品描述，可空
        String body = vo.getBody();

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String result = alipayClient.pageExecute(alipayRequest).getBody();

        return result;

    }
    public boolean rsaCheckV1(HttpServletRequest request){
        Map<String, String> params = convertRequestParamsToMap(request); // 将异步通知中收到的待验证所有参数都存放到map中
        String paramsJson = JSON.toJSONString(params);
        boolean signVerified = false;
        try {
            signVerified = AlipaySignature.rsaCheckV1(params, alipay_public_key,
                    charset, sign_type);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return signVerified;
    }
    // 将request中的参数转换成Map
    private static Map<String, String> convertRequestParamsToMap(HttpServletRequest request) {
        Map<String, String> retMap = new HashMap<String, String>();

        Set<Map.Entry<String, String[]>> entrySet = request.getParameterMap().entrySet();

        for (Map.Entry<String, String[]> entry : entrySet) {
            String name = entry.getKey();
            String[] values = entry.getValue();
            int valLen = values.length;

            if (valLen == 1) {
                retMap.put(name, values[0]);
            } else if (valLen > 1) {
                StringBuilder sb = new StringBuilder();
                for (String val : values) {
                    sb.append(",").append(val);
                }
                retMap.put(name, sb.toString().substring(1));
            } else {
                retMap.put(name, "");
            }
        }

        return retMap;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getMerchant_private_key() {
        return merchant_private_key;
    }

    public void setMerchant_private_key(String merchant_private_key) {
        this.merchant_private_key = merchant_private_key;
    }

    public String getAlipay_public_key() {
        return alipay_public_key;
    }

    public void setAlipay_public_key(String alipay_public_key) {
        this.alipay_public_key = alipay_public_key;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }
}
