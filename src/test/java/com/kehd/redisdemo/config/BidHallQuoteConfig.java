package com.kehd.redisdemo.config;

import lombok.Data;

import java.util.Objects;

public class BidHallQuoteConfig {
    /**
     * 启用多伦报价功能
     */
    private boolean enableQuote;
    /**
     * 评标是否是DB模式，控制多轮报价和质询传递的数据是否有base64文件
     */
    private boolean tpPingBiaoIsUseDB;
    /**
     * 启用新版多伦报价
     */
    private boolean enableNewQuote;
    /**
     * 启用多伦报价上传附件功能
     */
    private boolean enableQuoteUpload;
    /**
     * 启用多伦报价签到
     */
    private boolean enableQuoteSign;
    /**
     * 文件大小
     */
    private String quoteUploadFileSize;
    /**
     * 文件数量
     */
    private String quoteUploadFileNum;
    /**
     * 文件后缀
     */
    private String quoteUploadFileSuffix;
}
