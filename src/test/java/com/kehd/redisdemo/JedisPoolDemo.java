package com.kehd.redisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author kehd
 * @Date 2021-10-21 11:31
 * @Version 1.0
 * @Description
 */
@SpringBootTest
public class JedisPoolDemo
{

    @Test
    void jedisPoolTetst() {
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set("test", "1");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (jedis != null) {
                //此处的关闭并不是你关闭jedis连接，而是将Jedis return给资源池
                jedis.close();
            }
        }
    }
}
