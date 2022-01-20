package com.kehd.redisdemo.controller;

import com.kehd.redisdemo.RateLimiter;
import com.kehd.redisdemo.RedisMessageQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @Author kehd
 * @Date 2021-9-24 10:22
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/test")
public class TestController
{

    /** 公共配置 */
    private final static String SUCCESS = "success";
    private final static String MESSAGE = "testmq";
    private static final List<String> list ;

    static {
        list = Arrays.asList(new String[]{"queue1", "queue2", "queue3"});
    }


    @Autowired
    RateLimiter rateLimiter;



    @PostMapping(value = "/rateLimiter")
    public String rateLimiter(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        if (!rateLimiter.isActionAllowedSimple(userid,
                this.getClass().getSimpleName() + Thread.currentThread().getStackTrace()[1].getMethodName())) {
            return "请手速放慢点！";
        }
        return "成功！";
    }

    @PostMapping(value = "/rateLimiter2")
    public String rateLimiter2(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        if (!rateLimiter.isActionAllowed(userid,
                this.getClass().getSimpleName() + Thread.currentThread().getStackTrace()[1].getMethodName())) {
            return "请手速放慢点！";
        }
        return "成功！";
    }

}
