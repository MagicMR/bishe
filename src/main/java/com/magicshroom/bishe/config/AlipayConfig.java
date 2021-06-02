package com.magicshroom.bishe.config;
// trctpi4157@sandbox.com  111111

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000117633185";

	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC1OMwxTFERuRxRZVsI37nM4CygLjmI2T/fNt516nUIrMluJ4Rj40qcTNFyRirQ6lsQ1vrDiPWBxnouEjBUUnPsF26oBVoXtYWQqpInfodNiuX6S6hjMoZuKgJPF4POYDmKzz5fU4oOSSbSXRM6mKrJIcA8p5Bj0eOkFzmuGcoVUCPD7sh9ay6bakEn/LAip10Z00efIa6eTrS9f+dCLtxrDPdED4Als0BjfLmDehUiEl2m/kcup1p2ME/rQhAGxvfjRymWoetfdqKwc2TZsWqnKBLQh3E+vtSoy6NKfqjG96V5k9hmeAeXbWdzy7oIxTT0hYtXyQjUt9F7qdn93KoHAgMBAAECggEAB4yIJP2S2vQlE9bvBd2b9cbY1QtX5jV2javRdIQBwAzCj04iG68aKoygpOv7WJyKkpcB9yc7Yt6LtGOZk8mjfpAzUdh3OkmbeL1CPVbt9/LzRYvlRcyTAP/K/NRz7yLfAsNDS+FE/PdbIKQz6tr1Mk+vnFc2kpHps6osAu6cFmsgCV/2A3x7fk8m4Z6MmYtYx6f6U97xatE8rV3ns36PrEUg7bnf62Fg/F1Ucy0veMC+cSwXW/A5q1RBDXWsg2+U8+hVcvOnfqiO8w5CLlW2fXvDRhkqBDCsKeezxC6o6LCpt0M8Gx7DyC+sqr17EcbyeU+snMBk52T9c3YX60pIYQKBgQD7aa4oDpTq7n9LGQrX4r51O/ViZg9ehKarc9/DF+f8ZbPQZysIkeK//y31jB95XDaq3GJ20hE31KFTchi9bxhnGfxuJ03HbBa3yJ1FVEpdDjkAeS3XDPBy15MtELJT7wGjwkACq1OyiUyM72SG8RvNPD8X5Fnbcy1BoOv+OidcDwKBgQC4h0N/SggPRqUVHmB558St0ir6bgcgfG6B0qq7MiERpH/cg7udiBCbnCquKdaD9dmF+dH2/ko3TYuTGXHnxl8yf6dAqM1AzaxJFvwUNnSqpgnR1qcMSG9DYXSx4EyCqm1vb/iPLjagjAXEWRDyRWvd2XT4MYLm4jUmOU6zr/86iQKBgQD2Sp8r6q0EQUQ+g3fV6fD+1BAdpzHjPDwytj881gyTe+ZdgNPtf00NHaUeaXjj4OxFEcT79eqcMRchsiJ+YXkcd56NIr/VXxQaUtOO+XYoFyjMR+oaRDjBqGIrwbGQ/BE1JbSjaMeDnXF6l4J5l3XO5vhAJZnJm9l383d9A+dPDQKBgQCRI/N3P2evfEWEouwHdsFAZzre14RLjRPukSExNHDGS7k2XXdIpSlK/D6l1sqf6NQ7iRAZUlJVxWyvOyhYwbNHKRkIxr0K57tHkgicbWi+gPLgVhH2m1LIkPMUpfQIIr0JFe1P0W2uQfSXR+cIaIo7aTuTrH3l1K8xbYn108zQ4QKBgD20dr6cX5utL/yLAW7OxO9y+tVXvU8BrZ4eJxPRanBLqPpU6Tzm4b0ZQh2vWhKxHJZHmakfsUxhQUpW39PNg7bzo6+8+YSw9DTznmbNvxS9ajgM+iicjIhuPPkXxcQd9P+05zubyhqbUK30awMSTweWxZOTvQ6vOnuuyDXPnd9x";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtTjMMUxREbkcUWVbCN+5zOAsoC45iNk/3zbedep1CKzJbieEY+NKnEzRckYq0OpbENb6w4j1gcZ6LhIwVFJz7BduqAVaF7WFkKqSJ36HTYrl+kuoYzKGbioCTxeDzmA5is8+X1OKDkkm0l0TOpiqySHAPKeQY9HjpBc5rhnKFVAjw+7IfWsum2pBJ/ywIqddGdNHnyGunk60vX/nQi7cawz3RA+AJbNAY3y5g3oVIhJdpv5HLqdadjBP60IQBsb340cplqHrX3aisHNk2bFqpygS0IdxPr7UqMujSn6oxveleZPYZngHl21nc8u6CMU09IWLV8kI1LfRe6nZ/dyqBwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//	public static String return_url = "http://localhost/return_url.jsp";
	public static String return_url = "http://localhost/alipay/return_url";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

