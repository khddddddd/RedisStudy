package com.kehd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan({"com.kehd.redisdemo.dao","com.kehd.shardingjdbc.dao"})
public class RedisdemoApplication
{
    public static void main(String[] args) {
        SpringApplication.run(RedisdemoApplication.class, args);
    }

}

