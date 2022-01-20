package com.kehd.redisdemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class JedisDemo
{
    private Jedis jedis;

    @BeforeEach
    void jedisInit() {
        jedis = new Jedis("192.168.170.230", 6379);
        jedis.auth("Infra5_Gep0int");
        jedis.select(1);
    }

    @AfterEach
    void jedisClose() {
        if (jedis != null) {
            jedis.close();
        }
    }


    @Test
    void jedisWrite() {
        //String
        jedis.set("test", "testvalue"); //jedis.setex("test", 60, "testvalue");
        //hash
        Map<String,String> map = new HashMap<String,String>(){
            {
                put("张三", "1");
            }
        };
        jedis.hmset("testhash", map);
        //list
        jedis.rpush("testlist", "a", "b", "c");
        jedis.lpush("testlist", "e", "f", "g");
        //set
        jedis.sadd("testset", "aa", "bb");
        //zset
        jedis.zadd("testzset", 1, "aa");
        jedis.zadd("testzset", 3, "bb");
        jedis.zadd("testzset", 2, "cc");

    }

    @Test
    void jedisRead() {
        System.out.println(jedis.get("test"));
        System.out.println(jedis.hgetAll("testhash"));
        System.out.println(jedis.lrange("testlist", 0, 10));
        System.out.println(jedis.smembers("testset"));
        System.out.println(jedis.zrange("testzset", 0, -1));
    }

    @Test
    @DisplayName(value = "jedis测试pineline")
    void pipelineTest(){
        long start = System.currentTimeMillis();
        Pipeline pipelined = jedis.pipelined();
        for (int i = 0; i < 100000; i++) {
            pipelined.set("jedis测试pineline_" + i, "aaa");
        }
        //pipelined.sync();
        //没有返回值
        List<Object> list = pipelined.syncAndReturnAll();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
    }

}
