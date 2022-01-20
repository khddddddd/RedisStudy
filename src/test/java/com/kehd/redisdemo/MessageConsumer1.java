package com.kehd.redisdemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author kehd
 * @Date 2021-10-21 17:54
 * @Version 1.0
 * @Description
 */
public class MessageConsumer1 implements Runnable {
    public static final String CHANNEL_KEY1 = "channel1";//频道1
    public static final String CHANNEL_KEY2 = "channel2";//频道2
    public static final String EXIT_COMMAND = "exit";//结束程序的消息

    private MyJedisPubSub myJedisPubSub = new MyJedisPubSub();//处理接收消息

    Jedis jedis = null;

    public void consumerMessage() {
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        jedis = jedisPool.getResource();
        jedis.subscribe(myJedisPubSub, CHANNEL_KEY1,CHANNEL_KEY2);//第一个参数是处理接收消息，第二个参数是订阅的消息频道(支持同时订阅多个)
        //jedis.close();
    }

    @Override
    public void run() {
        //while (true) {
            consumerMessage();
        //}
    }

    public static void main(String[] args) {
        MessageConsumer1 messageConsumer = new MessageConsumer1();
        Thread t1 = new Thread(messageConsumer, "thread1");
        Thread t2 = new Thread(messageConsumer, "thread2");
        t1.start();
        t2.start();
    }
}
