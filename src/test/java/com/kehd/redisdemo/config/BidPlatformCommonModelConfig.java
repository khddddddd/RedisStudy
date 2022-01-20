package com.kehd.redisdemo.config;

import lombok.Data;

/**
 * @Author kehd
 * @Date 2021-11-10 11:40
 * @Version 1.0
 * @Description
 */
public class BidPlatformCommonModelConfig
{
    /**
     * 首界面模型
     */
    private String homePageModelGuid;
    /**
     * 主界面模型
     */
    private String mainPageModelGuid;
    /**
     * 直播模型
     */
    private String videoModelGuid;
    /**
     * 聊天模型
     */
    private String chatModelGuid;
    /**
     * 异议答复模型
     */
    private String objectionModelGuid;
}
