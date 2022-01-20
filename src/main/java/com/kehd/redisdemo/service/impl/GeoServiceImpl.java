package com.kehd.redisdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.kehd.redisdemo.service.IGeoService;
import com.kehd.redisdemo.vo.CityInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;

/**
 * @Author kehd
 * @Date 2021-10-14 14:39
 * @Version 1.0
 * @Description
 */
@Service
@Slf4j
public class GeoServiceImpl implements IGeoService
{
    private final String GEO_KEY = "cities";

    @Autowired
    private StringRedisTemplate redisTemplate;

    /***
     * 对应geoadd命令
     * @param cityInfos {@link CityInfo}
     * @return
     */
    @Override
    public Long saveCityInfoToRedis(Collection<CityInfo> cityInfos) {
        log.info("start to save city info: {}.", JSON.toJSONString(cityInfos));

        GeoOperations<String, String> ops = redisTemplate.opsForGeo();
        Set<RedisGeoCommands.GeoLocation<String>> locations = new HashSet<>();
        cityInfos.forEach(ci -> locations.add(new RedisGeoCommands.GeoLocation<String>(
                ci.getCity(), new Point(ci.getLongitude(), ci.getLatitude())
        )));

        log.info("done to save city info.");

        return ops.add(GEO_KEY, locations);
    }

    /***
     * 对应geoops命令
     * @param cities 给定城市 key
     * @return
     */
    @Override
    public List<Point> getCityPos(String[] cities) {
        GeoOperations<String, String> ops = redisTemplate.opsForGeo();

        return ops.position(GEO_KEY, cities);
    }


    @Override
    public Distance getTwoCityDistance(String city1, String city2, Metric metric) {
        GeoOperations<String, String> ops = redisTemplate.opsForGeo();

        return metric == null ?
                ops.distance(GEO_KEY, city1, city2) : ops.distance(GEO_KEY, city1, city2, metric);
    }

    @Override
    public GeoResults<RedisGeoCommands.GeoLocation<String>> getPointRadius(Circle
            within, RedisGeoCommands.GeoRadiusCommandArgs args) {
        GeoOperations<String, String> ops = redisTemplate.opsForGeo();

        return args == null ?
                ops.radius(GEO_KEY, within) : ops.radius(GEO_KEY, within, args);
    }

    /***
     * georadiusbymember
     * @param member
     * @param distance
     * @param args
     * @return
     */
    @Override
    public GeoResults<RedisGeoCommands.GeoLocation<String>> getMemberRadius(String member, Distance
            distance, RedisGeoCommands.GeoRadiusCommandArgs args) {

        GeoOperations<String, String> ops = redisTemplate.opsForGeo();

        return args == null ?
                ops.radius(GEO_KEY, member, distance) : ops.radius(GEO_KEY, member, distance, args);
    }

    /***
     * geohash
     * @param cities 给定城市 key
     * @return
     */
    @Override
    public List<String> getCityGeoHash(String[] cities) {
        GeoOperations<String, String> ops = redisTemplate.opsForGeo();

        return ops.hash(GEO_KEY, cities);
    }
}

