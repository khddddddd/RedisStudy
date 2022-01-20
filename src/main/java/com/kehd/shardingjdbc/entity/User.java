package com.kehd.shardingjdbc.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author kehd
 * @Date 2021-11-5 17:08
 * @Version 1.0
 * @Description
 */
@Data
public class User
{
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private Integer cityId;
    private Date createTime;
    private Integer sex;
}
