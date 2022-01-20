package com.kehd.redisdemo.config;

import lombok.Data;

public class BidAppCertConfig {
    /**
     * 标证通对应交易平台标识
     */
    private String mCertTradePlatformCode;
    /**
     * 标证通App名称
     */
    private String mCertAppName;

    /**
     * 标证通中心服务地址
     */
    private String centerUrl;
    /**
     * 默认平台code
     */
    public String platformCode;
    /**
     * 秘钥
     */
    public String secret;
    /**
     * 地址
     */
    public String url;


}
