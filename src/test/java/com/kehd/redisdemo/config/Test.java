package com.kehd.redisdemo.config;

import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;
import redis.clients.jedis.Jedis;
import com.epoint.core.utils.json.JsonUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author kehd
 * @Date 2021-11-10 11:25
 * @Version 1.0
 * @Description
 */
public class Test
{

    private static final String JSONSTRING;

    static {
        Jedis jedis = new Jedis("192.168.213.130", 6379);
        jedis.auth("Infra5_Gep0int");
        jedis.select(8);
        JSONSTRING = jedis.get("PlatformPropConfig_JBZB(TEST)");
    }

    public static void main(String[] args) /*{
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 8; i++) {
            executorService.submit(new Runnable()
            {
                @SneakyThrows
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        //BidHallPlatformConfig bidHallChainConfig = JsonUtil
                                //.jsonToObject(JSONSTRING, BidHallPlatformConfig.class);

                        String  bidHallChainConfig = JsonUtil
                                .jsonToObject(JSONSTRING, String.class);
                        //BidHallPlatformConfig bidHallChainConfig1 = JSONObject.parseObject(JSONSTRING, BidHallPlatformConfig.class);

                        System.out.println(bidHallChainConfig.hashCode());
                        System.out.println(bidHallChainConfig.toString());
                        Thread.sleep(10);
                    }

                }
            });
        }
        executorService.shutdown();


    }*/

    {
        User user = new User("aaa","bbbb");

        User user1 = new User("aaa","bbbb");

        System.out.println(user.hashCode());

        System.out.println(user1.hashCode());
    }



}
