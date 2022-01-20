package com.kehd.redisdemo;

import com.alibaba.fastjson.JSON;
import com.kehd.redisdemo.service.IGeoService;
import com.kehd.redisdemo.vo.CityInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author kehd
 * @Date 2021-10-14 14:44
 * @Version 1.0
 * @Description
 */
@SpringBootTest
public class GeoDemo
{

    private static List<CityInfo> cityInfos;

    @Autowired
    private IGeoService geoService;

    @BeforeAll
    public static void init() {
        cityInfos = new ArrayList<>();
        cityInfos.add(new CityInfo("南京", 118.78, 32.04));
        cityInfos.add(new CityInfo("苏州", 120.62, 31.32));
        cityInfos.add(new CityInfo("无锡", 120.29, 31.59));
        cityInfos.add(new CityInfo("常州", 119.95, 31.79));
        cityInfos.add(new CityInfo("南通", 	120.86, 32.01));
        cityInfos.add(new CityInfo("扬州", 119.42, 32.39));
        cityInfos.add(new CityInfo("徐州", 117.2, 34.26));
        cityInfos.add(new CityInfo("连云港", 119.16,34.59));
    }

    @Test
    @DisplayName(value="geoadd测试")
    public void testSaveCityInfoToRedis() {
        System.out.println(geoService.saveCityInfoToRedis(cityInfos));
    }

    @DisplayName(value="geopos测试")
    @Test
    public void testGetCityPos() {

        System.out.println(JSON.toJSONString(geoService.getCityPos(
                Arrays.asList("南京", "苏州").toArray(new String[2])
        )));
    }

    /**
     * 测试 getTwoCityDistance 方法
     * */
    @Test
    public void testGetTwoCityDistance() {
        System.out.println(geoService.getTwoCityDistance("南京", "徐州", Metrics.KILOMETERS).getValue());
    }

    /**
     * 测试 getPointRadius 方法
     * */
    @Test
    @DisplayName(value="georadiusbymember测试,[WITHDIST] [COUNT count] [ASC|DESC]")
    public void testGetPointRadius() {

        Point center = new Point(cityInfos.get(0).getLongitude(), cityInfos.get(0).getLatitude());
        Distance radius = new Distance(100, Metrics.KILOMETERS);
        Circle within = new Circle(center, radius);

        System.out.println(JSON.toJSONString(geoService.getPointRadius(within, null)));

        // order by 距离 limit 2, 同时返回距离中心点的距离
        RedisGeoCommands.GeoRadiusCommandArgs args =
                RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance().limit(2).sortAscending();
        System.out.println(JSON.toJSONString(geoService.getPointRadius(within, args)));
    }

    /**
     * 测试 getMemberRadius 方法
     * */
    @Test
    @DisplayName(value="georadiusbymember测试,[WITHDIST] [COUNT count] [ASC|DESC]")
    public void testGetMemberRadius() {

        Distance radius = new Distance(100, Metrics.KILOMETERS);

        System.out.println(JSON.toJSONString(geoService.getMemberRadius("苏州", radius, null)));

        // order by 距离 limit 2, 同时返回距离中心点的距离
        RedisGeoCommands.GeoRadiusCommandArgs args =
                RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance().limit(2).sortAscending();
        System.out.println(JSON.toJSONString(geoService.getMemberRadius("苏州", radius, args)));
    }

    /**
     * geohash
     * */
    @Test
    @DisplayName(value="geohash")
    public void testGetCityGeoHash() {

        System.out.println(JSON.toJSONString(geoService.getCityGeoHash(
                Arrays.asList("南京", "苏州").toArray(new String[2])
        )));
    }


}
