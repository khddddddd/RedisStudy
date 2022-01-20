package com.kehd.redisdemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @Author kehd
 * @Date 2021-10-21 17:40
 * @Version 1.0
 * @Description
 */
public class MessageConsumer implements Runnable {
    public static final String MESSAGE_KEY = "queue";
    Jedis jedis = null;

    public void consumerMessage() {
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        jedis = jedisPool.getResource();
        //
        List<String> brpop = jedis.brpop(0, MESSAGE_KEY);//0是timeout,返回的是一个集合，第一个是消息的key，第二个是消息的内容
        System.out.println(brpop);
        jedis.close();
    }

    @Override
    public void run() {
        while (true) {
            consumerMessage();
        }
    }

    public static void main(String[] args) {
        MessageConsumer messageConsumer = new MessageConsumer();
        Thread t1 = new Thread(messageConsumer, "thread1");
        t1.start();
    }
}

