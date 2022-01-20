package com.kehd.shardingjdbc.dao;

import com.kehd.shardingjdbc.entity.Address;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author kehd
 * @Date 2021-11-5 17:10
 * @Version 1.0
 * @Description
 */
@Mapper
public interface AddressMapper {
    /**
     * 保存
     */
    void save(Address address);

    /**
     * 查询
     * @param id
     * @return
     */
    Address get(Long id);
}

