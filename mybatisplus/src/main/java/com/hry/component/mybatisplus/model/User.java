package com.hry.component.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.hry.component.mybatisplus.utils.CommonJsonUtils;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/26 17:25
 */
@TableName
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @Version
    private Integer version;

    @TableField(exist = false)
    private UserAddress userAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return CommonJsonUtils.toJsonString(this);
    }
}
