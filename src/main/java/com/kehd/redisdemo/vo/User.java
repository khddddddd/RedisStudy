package com.kehd.redisdemo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author kehd
 * @Date 2021-9-22 15:34
 * @Version 1.0
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable
{
    private Integer id;
    private String nickname;
    private String mobile;
    private String password;
    private String role;
}
