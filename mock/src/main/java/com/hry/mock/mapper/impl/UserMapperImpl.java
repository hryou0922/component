package com.hry.mock.mapper.impl;

import com.hry.mock.mapper.UserMapper;
import com.hry.mock.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2020/10/21 13:45
 */
@Component
public class UserMapperImpl implements UserMapper {
    private static final Logger logger = LoggerFactory.getLogger(UserMapperImpl.class);

    @Override
    public int add(UserModel model) {
        logger.info("真正执行添加数据库用户操作");
        return 1;
    }

    @Override
    public int deleteByid(String id) {
        logger.info("真正执行删除数据库用户操作");
        return 1;
    }

    @Override
    public UserModel selectById(String id) {
        logger.info("真正执行查询数据库用户操作");
        return new UserModel("db1");
    }
}
