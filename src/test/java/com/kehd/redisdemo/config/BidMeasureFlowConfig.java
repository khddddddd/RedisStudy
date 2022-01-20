package com.kehd.redisdemo.config;

import lombok.Data;

import java.util.List;

/**
 * @Author kehd
 * @Date 2021-11-10 11:41
 * @Version 1.0
 * @Description
 */
public class BidMeasureFlowConfig
{
    /**
     * 办法标识
     */
    private String bidMeasureMark;
    /**
     * 办法名称
     */
    private String bidMeasureName;
    /**
     * 是否启用
     */
    private Boolean enable;
    /**
     * 评审流程标识
     */
    private String bindBidFlowGuid;
    /**
     * 评审流程名称
     */
    private String bindBidFlowName;
    /*
     * 伪双信封类型
     * */
    private String pseudoEnvelopeType;
    /**
     * 领域
     */
    private String domain;
    /**
     * 启用投标人匿名的菜单步骤节点
     */
    private List<String> anonTenderBeforeMenuGuid;
    /**
     * 只展示投标人单位自己
     */
    private Boolean useOnlyShowMineTender;
    /**
     * 评审类型
     */
    private String biddingFlowType;
    /**
     * 第一信封开标结束标记
     */
    private String firstBidEndMenuGuid;
    /**
     * 第二信封开标结束标记
     */
    private String secondBidEndMenuGuid;
    /**
     * 第一信封开标流程名称
     */
    private String firstBidFlowName;
    /**
     * 第二信封开标流程名称
     */
    private String secondBidBidFlowName;
    /**
     * 解密类型
     */
    private String bidDecryptType;
    /**
     * 允许解密时长（分钟）
     */
    private Integer allowDecryptMinute;
    /**
     * 是否启用无人值守
     */
    private Boolean useRobot;

    /**
     * 签到相关
     **/
    private String signLimit;
    private String tenderSignInWay;
    private String allowedSignInDuration;

    /**
     * 有效单位限制
     **/
    private Boolean validUnitLimit;

    /**
     * 应用服务配置
     */
    private String applicationServiceConfigs;

    private String enableWomanHost;

    /**
     * 开标纪律相关
     */
    private Boolean openBidDiscipline;
    private Boolean bidDisciplineIsUpload;
    private String bidDisciplineTypeName;
    private ApplicationServiceProperties domainAPIImpl;
}
