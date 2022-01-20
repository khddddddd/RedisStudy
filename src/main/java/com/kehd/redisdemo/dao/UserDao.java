package com.kehd.redisdemo.dao;

import com.kehd.redisdemo.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author kehd
 * @Date 2021-10-14 18:44
 * @Version 1.0
 * @Description
 */
@Mapper
public interface UserDao
{
    //获取单个用户
    User getUser(int id);
    //保存用户
    int insertUser(User user);

    //查询用户。指定MyBatis的参数名称
    List<User> findUsers(@Param("nickname") String nickname, @Param("password") String password);
    //修改用户
    int update(User user);

    //删除用户
    int deleteUser(int id);
}
