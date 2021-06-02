package com.hry.component.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hry.component.mybatisplus.model.User;

import java.util.List;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/27 15:37
 */
public interface IUserService extends IService<User> {

    /**
     * 批量添加设备，用于测试事物
     * @param users
     * @return
     */
    int batchAddUserForTransaction(List<User> users);
}
