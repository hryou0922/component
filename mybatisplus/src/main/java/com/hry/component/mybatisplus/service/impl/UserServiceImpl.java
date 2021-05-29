package com.hry.component.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hry.component.mybatisplus.mapper.UserMapper;
import com.hry.component.mybatisplus.model.User;
import com.hry.component.mybatisplus.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/27 15:43
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
