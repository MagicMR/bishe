package com.magicshroom.bishe.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.magicshroom.bishe.config.AlipayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping("/alipay")
public class AlipayController {

    @RequestMapping("/return_url")
    public ModelAndView returnPayInfo(HttpServletRequest request, HttpServletResponse response, RedirectAttributes ra) throws UnsupportedEncodingException {
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
//		valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        System.out.println(params.toString());

        boolean signVerified = false; //调用SDK验证签名
        try {
//		signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
            signVerified = AlipaySignature.rsaCheckV1(params, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjesYglKlFnPjGfYCEztN1XLSI3hLCth0RQU7Hyu+oXQa97Zq5lmpV7d5V0C9xG3avYXZNpRuwVnVEabnMFPR4K9D60mK3krjsfG3EFZrE2CtTw+D+yDb2jNiwKEW631nMPZT35A/dgoGSeGjN2NK2cxdFzQ0GJQ9AdZRuyoiseDuAHISSnliPuyPh0hrOMEoMVxcI5TsvOl1OhIZPy4zyThCjxDUki4Fz6slqYBSAslRKU5iLU5n8KPl7IyytK3xnU8i3oJaNz46XuSC/0JcpEG2fAikjQHedCSMh+XHl0sAtN5NfUWKHOnNSMaBDdHRsMaxorQrmOCQctKjl07ZawIDAQAB", AlipayConfig.charset, AlipayConfig.sign_type);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        //——请在这里编写您的程序（以下代码仅作参考）——
        Map<String,String> map=new HashMap<>();
        RedirectView rv = null;
        if(signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

//		out.println("trade_no:"+trade_no+"<br/>out_trade_no:"+out_trade_no+"<br/>total_amount:"+total_amount);
//            map.put("out_trade_no",out_trade_no);
//            map.put("trade_no",trade_no);
//            map.put("total_amount",total_amount);
//            ra.addAttribute("out_trade_no",out_trade_no);
//            ra.addAttribute("trade_no",trade_no);
//            ra.addAttribute("total_amount",total_amount);
//            rv = new RedirectView("http://localhost:8080/home", true, false, true);
            rv = new RedirectView("http://localhost:80/payment/payOk", true, false, true);
//        rv.addStaticAttribute("msg", java.net.URLEncoder.encode("激活成功","UTF-8"));
            rv.addStaticAttribute("out_trade_no",out_trade_no);
            rv.addStaticAttribute("trade_no",trade_no);
            rv.addStaticAttribute("total_amount",total_amount);
        }else {
            System.out.println("验签失败");
        }
//        return map;
//        return "redirect:/http://localhost:8080/home";
        return new ModelAndView(rv);

    }

    @ResponseBody
    @RequestMapping("/a")
    public void pagePay(HttpServletRequest request,HttpServletResponse response) throws AlipayApiException, UnsupportedEncodingException {

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
        //付款金额，必填
        String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
        //订单名称，必填
        String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
        //商品描述，可空
        String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        System.out.println("adsadad");
        //输出
        System.out.println(result);
    }

}
