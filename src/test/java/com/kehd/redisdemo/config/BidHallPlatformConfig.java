package com.kehd.redisdemo.config;

import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * @Author kehd
 * @Date 2021-11-10 11:28
 * @Version 1.0
 * @Description
 */

public class BidHallPlatformConfig extends BidPlatformBasicConfig
{
    /**
     * 选配件
     */
    private BidPlatformActivityConfig activityConfig;
    /**
     * 登录配置
     */
    private BidSystemLoginConfig sysLoginConfig;
    /**
     * 平台通用模型配置
     */
    private BidPlatformCommonModelConfig platformCommonModelConfig;
    /**
     * 评标办法配置
     */
    private List<BidMeasureFlowConfig> bidMeasureFlowConfigs;

    private BidThirdRemoteConfig thirdServerConfig;

    private ApplicationServiceProperties domainAPIImpl;



    @Override
    public int hashCode() {
        return Objects
                .hash(super.hashCode(), activityConfig, sysLoginConfig, platformCommonModelConfig, bidMeasureFlowConfigs, thirdServerConfig);
    }
}
