package com.fanyank.mapper;

import com.fanyank.pojo.User;

/**
 * Created by yanfeng-mac on 2017/5/6.
 */
public interface UserMapper {
    public User findById(Integer id);

    public User findByTel(String tel);
}
