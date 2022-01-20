package com.kehd.redisdemo.config;

/**
 * @Author kehd
 * @Date 2021-11-10 11:43
 * @Version 1.0
 * @Description
 */
public class BidThirdRemoteConfig
{
    /**
     * 评标接口服务
     */
    private WebServiceTransfer3rdConfig bidService;
    /**
     * 交易接口服务
     */
    private WebServiceTransfer3rdConfig tradeService;
    /**
     * 标证通服务
     */
    private BidAppCertConfig appCertConfig;
    /**
     * 支撑服务配置
     */
    private BidSupportServiceConfig supportServiceConfig;
    /**
     * 区块链服务配置
     */
    private BidHallChainConfig chainConfig;
    /**
     * 质询服务配置
     */
    private BidHallInquiryConfig inquiryConfig;
    /**
     * 多伦报价配置
     */
    private BidHallQuoteConfig quoteConfig;
    /**
     * 安全运维配置
     */
    private BidPrepare4SecurityConfig prepare4SecurityConfig;

    private BidStreamPushConfig streamPushConfig;
}
