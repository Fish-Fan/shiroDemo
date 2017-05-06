package com.fanyank.service;

import javax.inject.Named;

import com.fanyank.mapper.RoleMapper;
import com.fanyank.mapper.UserMapper;
import com.fanyank.pojo.Role;
import com.fanyank.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/5/6.
 */
@Named
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;


    /**
     * 权限认证方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User shiroUser = (User) principalCollection.getPrimaryPrincipal();

        User user = userMapper.findByTel(shiroUser.getTel());
        if(user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            List<Role> roleList = roleMapper.findRoleList(user.getId());

            for(Role role : roleList) {
                info.addRole(role.getRoleName());
            }

            return info;
        }
        return null;
    }

    /**
     * 登录方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String tel = token.getUsername();
        User user = userMapper.findByTel(tel);

        System.out.println(user);

        if(user != null) {
            if(User.USER_STATE_DISABLE.equals(user.getState())) {
                throw new LockedAccountException("该账号已被禁用");
            }
            return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        }
        throw new UnknownAccountException("账号或密码错误");
    }
}
