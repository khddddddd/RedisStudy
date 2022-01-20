package com.kehd.redisdemo;

import com.alibaba.fastjson.JSON;
import com.kehd.redisdemo.vo.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author kehd
 * @Date 2021-9-23 20:50
 * @Version 1.0
 * @Description
 */
@SpringBootTest
public class RedisTemplateDemo
{
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    //StringRedisTemplate使用的是StringRedisSerializer
    //当你的redis数据库里面本来存的是字符串数据或者你要存取的数据就是字符串类型数据的时候，那么你就使用StringRedisTemplate即可。
    @Autowired
    private StringRedisTemplate redisTemplateString;


    @Test
    void RedisWrite() {
        redisTemplate.opsForValue().set("user", new User(1, "abc1", "13512345678", "123456", "role-user"));
        redisTemplateString.opsForValue()
                .set("user1", JSON.toJSONString(new User(1, "abc1", "13512345678", "123456", "role-user")));
        System.out.println(redisTemplate.opsForValue().get("user"));
        System.out.println(redisTemplate.opsForValue().get("user1"));
        //hash
        Map<String, Object> map = new HashMap<String, Object>()
        {
            {
                put("张三", 1);
                put("李四", "1");
            }
        };
        redisTemplate.opsForHash().putAll("testhash", map);
        Map<Object, Object> map1 = redisTemplate.opsForHash().entries("testhash");
        System.out.println(map1);
    }


    @Test
    @DisplayName(value="未使用pineline测试")
    void pineline(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            redisTemplateString.opsForValue().set("pine_test"+i,"value_"+i);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start)+"ms");
    }

    @Test
    @DisplayName(value="使用pineline测试")
    void pineline1() {
        long start = System.currentTimeMillis();
        List<Object> list = redisTemplateString.executePipelined(new RedisCallback<List<String>>()
        {
            @Override
            public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
                for (int i = 0; i < 100000; i++) {
                    connection.set(("pine_test" + i).getBytes(), ("value_" + i).getBytes());
                }
                return null;
            }
        });

        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
    }


}
