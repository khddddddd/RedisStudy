package com.kehd.redisdemo.service;

import com.kehd.redisdemo.vo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author kehd
 * @Date 2021-10-14 19:13
 * @Version 1.0
 * @Description
 */
public interface IUserService
{
    //获取单个用户
    User getUser(int id);
    //保存用户
    User insertUser(User user);

    //查询用户。指定MyBatis的参数名称
    List<User> findUsers( String nickname,String password);
    //修改用户
    User update(int id, String nickname, String password, String role);

    //删除用户
    int deleteUser(int id);
}
