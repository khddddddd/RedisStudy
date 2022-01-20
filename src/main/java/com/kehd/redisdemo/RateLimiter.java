package com.kehd.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

/**
 * 简单限流器
 *
 * @Author kehd
 * @Date 2021-9-22 14:48
 * @Version 1.0
 * @Description
 */
@Component
public class RateLimiter
{
    private final static int PERIOD = 30;
    private final static int MAXCOUNT = 5;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 简单计数器限流
     * @param userId
     * @param actionKey
     * @return
     */
    public boolean isActionAllowedSimple(String userId, String actionKey) {
        long result = 0;
        final String key = String.format("%s:%s", userId, actionKey);
        final ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        //键值不存在时，会直接置1
        result = valueOperations.increment(key);
        if (result <= 1) {
            redisTemplate.expire(key, Duration.ofSeconds(PERIOD));
        }
        return result <= MAXCOUNT;
    }

    /**
     * 滑动窗口限流
     * @param userId
     * @param actionKey
     * @return
     */
    public boolean isActionAllowed(String userId, String actionKey) {
        final String key = String.format("%s:%s", userId, actionKey);
        final long nowTs = System.currentTimeMillis();
        final ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        // 1.score和value都用毫秒时间戳
        zSetOperations.add(key, nowTs + "", +nowTs);
        // 2.移除时间窗口之前的行为记录，剩下的都是时间窗口内的
        zSetOperations.removeRangeByScore(key, 0, nowTs - PERIOD * 1000L);
        // 3.获取时间窗口内的操作次数
        final long count = zSetOperations.zCard(key);
        // 4.每次为key设置过期时间，period时间内不操作，判定为冷用户
        redisTemplate.expire(key, Duration.ofSeconds(PERIOD * 5L + 1));
        return count <= MAXCOUNT;
    }
}
