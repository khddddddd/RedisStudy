package com.kehd.redisdemo.config;

import lombok.Data;

/**
 * @Author kehd
 * @Date 2021-11-10 11:38
 * @Version 1.0
 * @Description
 */
public class BidLoginModeConfig
{
    /**
     * 启用帐号密码登录
     */
    private Boolean enablePwdLogin;
    /**
     * 启用CA登录
     */
    private Boolean enableCALogin;
    /**
     * 启用二维码登录
     */
    private Boolean enableQRLogin;
    /**
     * 启用标证通登录
     */
    private Boolean enableBztLogin;
    /**
     * 启用单点登录
     */
    private Boolean enableSSOLogin;
    /**
     * 兼容CA大小写
     */
    private Boolean autoCALowerCase;
    /**
     * 登录角色名称
     */
    private String loginRoleName;
    /**
     * 是否启用远程账号
     */
    private Boolean enableRemoteAccount;

    /**
     * 登录角色名称
     */
    private String remoteAccountRole;

    /**
     * 启用本地登录
     */
    private Boolean enableLocalLogin;
}
