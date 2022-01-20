package com.kehd.redisdemo.config;

/**
 * @Author kehd
 * @Date 2021-11-10 13:50
 * @Version 1.0
 * @Description
 */
public class WebServiceTransfer3rdConfig
{
    /**
     * 服务地址
     */
    private String serviceUrl;
    /**
     * token加密方式
     */
    private String algorithm;
    /**
     * token码
     */
    private String tokenKey;
    /**
     * token值
     */
    private String tokenValue;
    /**
     * 连接超时时间
     */
    private Long connectTimeout;
    /**
     * 接收超时时间
     */
    private Long receiveTimeout;
    /**
     * 改版大厅业务登录接口参数
     */
    private String pingBiaoLoginSM4Key;
}
