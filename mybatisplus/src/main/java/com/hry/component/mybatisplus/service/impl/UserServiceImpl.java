package com.hry.component.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hry.component.mybatisplus.mapper.UserMapper;
import com.hry.component.mybatisplus.model.User;
import com.hry.component.mybatisplus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/27 15:43
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int batchAddUserForTransaction(List<User> users) {
        for(User user : users){
            userMapper.insert(user);
        }
//        try {
//            Thread.sleep(16000 * 1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        throw new RuntimeException("2");
         return users.size();
    }
}
