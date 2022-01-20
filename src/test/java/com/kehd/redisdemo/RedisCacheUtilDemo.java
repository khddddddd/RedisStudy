package com.kehd.redisdemo;

import com.epoint.core.utils.memory.RedisCacheUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author kehd
 * @Date 2021-10-20 17:22
 * @Version 1.0
 * @Description
 */
@SpringBootTest
public class RedisCacheUtilDemo
{
    @Test
    void test(){
        RedisCacheUtil redisCacheUtil = new RedisCacheUtil();
        redisCacheUtil.putByString("RedisCacheUtil","test",100);
    }
}
