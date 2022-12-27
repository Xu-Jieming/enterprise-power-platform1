package com.alipay.controller;

import com.alipay.AlipayTemplate;
import com.alipay.PayVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/27/13:33
 * @Description:
 */
@CrossOrigin
@Controller
public class AlipayController {
    // 支付
    @Autowired
    private AlipayTemplate alipayTemplate;
    @RequestMapping("/pay.do")
    public void pay(HttpSession session, HttpServletResponse resp) throws Exception{
        // 获取要支付的订单状态
        PayVo payVo  = (PayVo) session.getAttribute("payVo");
        String pay = alipayTemplate.pay(payVo);
        // 响应返回的支付页面
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.print(pay);
    }

}
