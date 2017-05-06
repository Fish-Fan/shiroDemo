package com.fanyank.mapper;

import com.fanyank.pojo.Role;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/5/6.
 */
public interface RoleMapper {
    public List<Role> findRoleList(Integer id);
}
