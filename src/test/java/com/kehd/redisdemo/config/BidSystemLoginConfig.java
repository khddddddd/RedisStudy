package com.kehd.redisdemo.config;

/**
 * @Author kehd
 * @Date 2021-11-10 11:36
 * @Version 1.0
 * @Description
 */
public class BidSystemLoginConfig
{
    /**
     * 代理登录
     */
    private BidLoginModeConfig agentLoginConfig;
    /**
     * 投标人登录
     */
    private BidLoginModeConfig tenderLoginConfig;
    /**
     * 招标人登录
     */
    private BidLoginModeConfig bidderLoginConfig;
    /**
     * 监管人员登录
     */
    private BidLoginModeConfig supervisorLoginConfig;
    /**
     * 公正人员登录
     */
    private BidLoginModeConfig notaryLoginConfig;
    /**
     * 中心人员登录
     */
    private BidLoginModeConfig staffLoginConfig;
    /**
     * 允许游客登录
     */
    private Boolean allowGuestLogin;
    /**
     * 开启CA用户登录签名认证
     */
    private Boolean enableCaVerifySignature;
    /**
     * CA识别异常提示信息
     */
    private String findCAErrorTipText;
    /**
     * 背景动画效果显示
     */
    private String backgroundAnimation;
    /**
     * 浏览器登录限制
     **/
    private String browserLimit;

    /**
     * 是否启用本地登录
     */
    private Boolean localLogin;

    //********** MAC和IP登录限制 ********** start
    /**
     * 默认展示登录弹窗
     **/
    private Boolean defaultPopupLogin;
    /**
     * 是否启用MAC登录限制
     */
    private Boolean useMacLimit;
    /**
     * 是否启用IP登录限制
     */
    private Boolean useIPLimit;
    /**
     * MAC和IP登录限制的配置
     */
    private String configMACIPData;
    //********** MAC和IP登录限制 ********** end

    //********** 具体登录实现方式 ********** start
    private BidLoginServiceProperties serviceProperties;
}
