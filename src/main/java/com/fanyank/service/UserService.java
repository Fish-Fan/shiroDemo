package com.fanyank.service;

import com.fanyank.mapper.UserMapper;
import com.fanyank.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by yanfeng-mac on 2017/5/6.
 */
@Component
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
