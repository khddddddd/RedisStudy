package com.kehd.redisdemo.service.impl;

import com.kehd.redisdemo.dao.UserDao;
import com.kehd.redisdemo.service.IUserService;
import com.kehd.redisdemo.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author kehd
 * @Date 2021-10-14 19:14
 * @Version 1.0
 * @Description
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserDao userDao;

    /**
     * 插入用户，最后MyBatis会回填id，取结果id缓存用户
     *
     * @param user
     * @return
     */
    @Override
    @Transactional
    @CachePut(value = "redisdemopro", key = "'user:'+#result.id")
    public User insertUser(User user) {
        userDao.insertUser(user);
        return user;
    }

    /***
     *获取id，取参数id缓存用户
     * @param id
     * @return
     */
    @Override
    @Transactional
    @Cacheable(value = "redisdemopro", key = "'user:'+#id")
    public User getUser(int id) {
        System.out.println("getUser执行了");
        return userDao.getUser(id);
    }

    /***
     * 命中率低，所以不采用缓存
     * @param nickname
     * @param password
     * @return
     */
    @Override
    @Transactional
    public List<User> findUsers(String nickname, String password) {
        return userDao.findUsers(nickname, password);
    }

    /***
     * 更新数据后，更新缓存，如果condition配置项使结果返回为null，不缓存
     * @param id
     * @param nickname
     * @param password
     * @param role
     * @return
     */
    @Override
    @Transactional
    @CachePut(value = "redisdemopro", condition = "#result!= 'null'", key = "'user:'+#id")
    public User update(int id, String nickname, String password, String role) {
        //此处调用getUser方法，该方法缓存注解失效
        //所以这里还会执行sql，将查询到数据最新数据
        User user = this.getUser(id);
        if (user == null) {
            return null;
        }
        user.setNickname(nickname);
        user.setPassword(password);
        user.setRole(role);
        userDao.update(user);
        return user;
    }

    /***
     * 移除缓存
     * @param id
     * @return
     */
    @Override
    @Transactional
    @CacheEvict(value = "redisdemopro", key = "'user:'+#id", beforeInvocation = false)
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }
}
