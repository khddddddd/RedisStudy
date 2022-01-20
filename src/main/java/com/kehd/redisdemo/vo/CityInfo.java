package com.kehd.redisdemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author kehd
 * @Date 2021-10-14 14:37
 * @Version 1.0
 * @Description
 */
@Data
@AllArgsConstructor
public class CityInfo
{
    /** 城市 */
    private String city;

    /** 经度 */
    private Double longitude;

    /** 纬度 */
    private Double latitude;
}
