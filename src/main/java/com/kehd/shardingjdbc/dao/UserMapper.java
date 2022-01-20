package com.kehd.shardingjdbc.dao;

import com.kehd.shardingjdbc.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author kehd
 * @Date 2021-11-5 17:11
 * @Version 1.0
 * @Description
 */
@Mapper
public interface UserMapper {
    /**
     * 保存
     */
    void save(User user);

    /**
     * 查询
     * @param id
     * @return
     */
    User get(Long id);
}
