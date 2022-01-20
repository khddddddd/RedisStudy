package com.kehd.redisdemo.config;

/**
 * @Author kehd
 * @Date 2021-11-10 11:34
 * @Version 1.0
 * @Description
 */
public class BidPlatformActivityConfig
{
    //********** 单点登录 ********** start
    /**
     * 单点登录中心系统
     */
    private String ssoTPFrameUrl;
    /**
     * 单点登录会员系统
     */
    private String ssoBidderUrl;
    /**
     * 单点登录评标系统
     */
    private String ssoBidUrl;
    //********** 单点登录 ********** end

    /**
     * 标段列表缓存超期时间
     */
    private Long cacheSectionListExpireTime;

    //********** CA驱动相关配置 ********** start
    /**
     * 新点知道地址
     */
    private String epointKnowledgeUrl;
    /**
     * 智能客服
     */
    private String intelligentRobot;
    /**
     * CA驱动下载地址
     */
    private String caDriveDownloadUrl;
    /**
     * CA地区码
     */
    private String caAreaCode;
    //********** CA驱动相关配置 ********** end

    /**
     * 开标后是否允许投标人（从未进入过标段）和游客进入标段
     */
    private Boolean allowEnterSectionWhenBidding;
    /**
     * 允许游客进入标段的最大数量
     */
    private Integer allowGuestCount;

    //********** 技术服务费 ********** start
    /**
     * 开启技术服务费
     */
    private Boolean enablePlatformServiceFee;
    /**
     * 技术服务所属区域
     */
    private String platformServiceArea;
    /**
     * 技术服务费金额
     */
    private String platformServiceFee;
    /**
     * 技术服务费缴纳提示信息
     */
    private String platformServiceFeeTip;
    /**
     * 商户号
     */
    private String merchantNumber;
    //********** 技术服务费 ********** end

    //********** 报表 ********** start
    /**
     * 启用PDF下载后打开
     */
    private Boolean enablePDFDownload;
    /**
     * 启用PDF下载后打开
     */
    private Boolean deliweboa;
    /**
     * 标证通签章模式
     */
    private String MCertSignMode;
    /**
     * H5控件
     */
    private String MCertPDFViewControl;
}
