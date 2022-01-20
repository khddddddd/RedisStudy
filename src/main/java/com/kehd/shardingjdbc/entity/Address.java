package com.kehd.shardingjdbc.entity;

import lombok.Data;

/**
 * @Author kehd
 * @Date 2021-11-5 17:08
 * @Version 1.0
 * @Description
 */
@Data
public class Address
{
        private Long id;
        private String code;
        private String name;
        private String pid;
        private Integer type;
        private Integer lit;
}
