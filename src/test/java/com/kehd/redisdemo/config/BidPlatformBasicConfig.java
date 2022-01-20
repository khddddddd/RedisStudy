package com.kehd.redisdemo.config;

import lombok.Data;

import java.util.Objects;

/**
 * @Author kehd
 * @Date 2021-11-11 8:49
 * @Version 1.0
 * @Description
 */
public class BidPlatformBasicConfig
{
    /**
     * 平台标识码
     */
    private String platformCode;
    /**
     * 平台名称
     */
    private String platformName;
    /**
     * 启用状态
     */
    private Boolean enable;
    /**
     * 应用名称
     */
    private String applicationName;
    /**
     * 应用图标
     */
    private String applicationIcon;
    /**
     * CA类型
     */
    private String bidCAType;
    /**
     * PDF控件
     */
    private String pfdViewControl;
    /**
     * PDF控件注册码
     */
    private String pfdControlRegisterKey;
    /**
     * 客服咨询电话
     */
    private String hotline;
    /**
     * 辖区代码
     **/
    private String areaCode;

    @Override
    public int hashCode() {
        return Objects
                .hash(platformCode, platformName, enable, applicationName, applicationIcon, bidCAType, pfdViewControl,
                        pfdControlRegisterKey, hotline, areaCode);
    }
}
