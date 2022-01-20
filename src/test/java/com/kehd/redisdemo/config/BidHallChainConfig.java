package com.kehd.redisdemo.config;

import lombok.Data;

public class BidHallChainConfig {
    /**
     * 数据是否上链
     */
    private boolean bidUseChainBlock;
    /**
     * 易采虹接口地址
     */
    private String epCaiHongServiceUrl;
    /**
     * 易采虹服务平台标识码
     */
    private String epCaiHongServiceKey;
    /**
     * 易采虹服务token值
     */
    private String epCaiHongServiceSecret;

}
