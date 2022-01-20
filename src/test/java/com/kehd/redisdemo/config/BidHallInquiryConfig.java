package com.kehd.redisdemo.config;

import lombok.Data;

import java.util.Objects;

public class BidHallInquiryConfig {
    /**
     * 启动质询
     */
    private Boolean enableInterrogate;
    /**
     * 评标是否是DB模式，控制多轮报价和质询传递的数据是否有base64文件
     */
    private boolean tpPingBiaoIsUseDB;
    /**
     * 询标系统单点登录url
     */
    private String ssoInquiryUrl;
    /**
     * 询标版本
     */
    private String inquiryVersion;
    /**
     * 询标客户端地址
     */
    private String inquiryClientPath;
    /**
     * 询标系统(评标系统/询标系统)
     */
    private String inquirySsoSystem;
    /**
     * 询标tokenKey
     */
    private String tokenKey;
    /**
     * 询标token值
     */
    private String tokenValue;
    /**
     * 询标token加密方式
     */
    private String  encryptType;

}
