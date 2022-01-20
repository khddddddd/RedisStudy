package com.kehd.redisdemo;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author kehd
 * @Date 2021-10-15 11:41
 * @Version 1.0
 * @Description
 */
@SpringBootTest
public class BloomFilterDemo
{
    /***
     * 使用Redisson客户端工具构造布隆过滤器
     */
    @Test
    void redissonBloomFilter() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.170.230:6379");
        config.useSingleServer().setDatabase(1);
        config.useSingleServer().setPassword("Infra5_Gep0int");
        //构造Redisson
        RedissonClient redisson = Redisson.create(config);
        RBloomFilter<String> bloomFilter = redisson.getBloomFilter("phoneList");
        //初始化布隆过滤器：预计元素为100000000L,误差率为3%
        bloomFilter.tryInit(100L, 0.03);
        //将号码10086插入到布隆过滤器中
        bloomFilter.add("10086");
        //判断下面号码是否在布隆过滤器中
        System.out.println(bloomFilter.contains("123456"));//false
        System.out.println(bloomFilter.contains("10086"));//true
    }
    /***
     * 使用Google的guava工具包实现布隆过滤器
     */
    @Test
    void guavaBloomFilter()
    {
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 100000, 0.01);
        bloomFilter.put("10086");
        System.out.println(bloomFilter.mightContain("123456"));
        System.out.println(bloomFilter.mightContain("10086"));
    }
}
