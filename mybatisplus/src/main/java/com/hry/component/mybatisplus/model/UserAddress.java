package com.hry.component.mybatisplus.model;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/27 18:51
 */
public class UserAddress {
    private Long id;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
