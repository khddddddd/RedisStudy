package com.kehd.redisdemo.config;

import lombok.Data;

/**
 * @Author kehd
 * @Date 2021-11-10 11:39
 * @Version 1.0
 * @Description
 */
public class BidLoginServiceProperties
{
    private String accountPwdLoginImpl;
    private String caLoginImpl;
    private String guestLoginImpl;
    private String mcertLoginImpl;
    private String qrCodeLoginImpl;
    private String ssoLoginImpl;
    private String whiteLoginImpl;
}
