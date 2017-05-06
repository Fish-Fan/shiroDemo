package com.fanyank.pojo;

import java.io.Serializable;

/**
 * Created by yanfeng-mac on 2017/5/6.
 */
public class Role implements Serializable{
    private Integer id;
    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
