package com.hry.mock.service;

import com.hry.mock.model.UserModel;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2020/10/21 13:47
 */
public interface IUserService {

    int add(UserModel model);

    int deleteByid(String id);

    UserModel selectById(String id);
}
