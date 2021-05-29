package com.hry.component.mybatisplus.model;

import com.hry.component.mybatisplus.utils.CommonJsonUtils;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/26 17:25
 */
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;

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

    @Override
    public String toString() {
        return CommonJsonUtils.toJsonString(this);
    }
}
