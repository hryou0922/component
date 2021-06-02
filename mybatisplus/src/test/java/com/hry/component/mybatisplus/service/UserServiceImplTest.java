package com.hry.component.mybatisplus.service;

import com.hry.component.mybatisplus.TestBase;
import com.hry.component.mybatisplus.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/27 15:45
 */
public class UserServiceImplTest extends TestBase {
    @Autowired
    private IUserService userService;

    @Test
    public void save(){
        User entity = new User();
        entity.setId(999L);
        entity.setName("save-" + System.currentTimeMillis());
        entity.setAge(40);
        boolean flag = userService.save(entity);
        System.out.println("flag=" + flag);
    }

    @Test
    public void batchAddUserForTransaction(){
        User entity = new User();
        entity.setName("save-" + System.currentTimeMillis());
        entity.setAge(40);

        User entity2 = new User();
        entity2.setName("save-" + System.currentTimeMillis());
        entity2.setAge(50);

        List<User> users = new ArrayList<>();
        users.add(entity);
        users.add(entity2);

        int size = userService.batchAddUserForTransaction(users);
        System.out.println("flag=" + size);
    }
}
