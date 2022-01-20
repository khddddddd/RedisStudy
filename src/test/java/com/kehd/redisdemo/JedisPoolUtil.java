package com.kehd.redisdemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author kehd
 * @Date 2021-10-21 11:40
 * @Version 1.0
 * @Description
 */
public class JedisPoolUtil
{
    private static volatile JedisPool jedisPool = null;
    private final  static String HOST = "192.168.170.230";
    private final  static int PORT = 6379;
    private final static int TIMEOUT = 10000;
    private final  static String PASSWORD = "Infra5_Gep0int";
    private final  static int DB = 1;

    private JedisPoolUtil() {
    }

    //单例
    public static JedisPool getJedisPoolInstance() {
        if (null == jedisPool) {
            synchronized (JedisPoolUtil.class) {
                if (null == jedisPool) {
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    //分配多少个jedis实例
                    poolConfig.setMaxTotal(1000);
                    //最多有多少个状态为idle(空闲)的jedis实例
                    poolConfig.setMaxIdle(32);
                    //borrow一个 jedis实例最大等待时间
                    poolConfig.setMaxWaitMillis(100 * 1000);
                    //获得一个jedis实例的时候是否检查连接可用性
                    poolConfig.setTestOnBorrow(true);
                    jedisPool = new JedisPool(poolConfig, HOST, PORT,TIMEOUT,PASSWORD,DB);
                }
            }
        }
        return jedisPool;
    }
}
