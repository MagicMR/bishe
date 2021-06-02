package com.magicshroom.bishe.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.magicshroom.bishe.bean.Order;
import com.magicshroom.bishe.bean.Payment;
import com.magicshroom.bishe.service.OrderService;
import com.magicshroom.bishe.service.PaymentService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.Serializable;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    private List<Order> allProduct=null;

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/pay")
    public Map<String,Object> pay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<>();

        String allProduct = request.getParameter("allProduct");
        int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
        String decode = URLDecoder.decode(allProduct);
        this.allProduct = new ArrayList<Order>(JSONArray.parseArray(decode,Order.class));

        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
        String tradeNo1 = sdf.format(new Date());
        String tradeNo2 = totalPrice+"";
        String tradeNo3 = Math.round(Math.random()*10000)+"";

        map.put("payUrl","http://localhost/index.jsp");
        map.put("outTradeNo",tradeNo1+tradeNo2+tradeNo3);
        return map;
    }
    @RequestMapping("payOk")
    public ModelAndView payOk(HttpServletRequest request, HttpServletResponse response){
        String out_trade_no = request.getParameter("out_trade_no");
        String trade_no = request.getParameter("trade_no");
        String total_amount = request.getParameter("total_amount");
//      保存记录
        String userId = this.allProduct.get(0).getUserId();
        Payment payment=new Payment();
        payment.setPayOutTradeNo(out_trade_no);
        payment.setPayTradeNo(trade_no);
        payment.setPayAmount(total_amount);
        payment.setPayUserId(userId);
        paymentService.addPayment(payment);
        orderService.addOrderList(this.allProduct,trade_no);
//        重定向到支付成功页面
        RedirectView rv=null;
        rv = new RedirectView("http://localhost:8080/payOk", true, false, true);
        Map<String,Object> map=new HashMap<>();
        map.put("out_trade_no",out_trade_no);
        map.put("trade_no",trade_no);
        map.put("total_amount",total_amount);
        String str = JSON.toJSONString(this.allProduct);
        map.put("allProduct",str);
        return new ModelAndView(rv,map);
    }
}
