package com.hry.mock.service.impl;

import com.hry.mock.mapper.UserMapper;
import com.hry.mock.model.UserModel;
import com.hry.mock.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2020/10/21 13:47
 */
@Component
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int add(UserModel model) {
        return userMapper.add(model);
    }

    @Override
    public int deleteByid(String id) {
        return userMapper.deleteByid(id);
    }

    @Override
    public UserModel selectById(String id) {
        return userMapper.selectById(id);
    }
}
