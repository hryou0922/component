package com.hry.mock.mapper;

import com.hry.mock.model.UserModel;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2020/10/21 13:44
 */
public interface UserMapper {
    /**
     * 添加记录
     * @param model
     * @return
     */
    int add(UserModel model);

    /**
     * 根据id进行删除
     * @param id
     * @return
     */
    int deleteByid(String id);

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    UserModel selectById(String id);
}
