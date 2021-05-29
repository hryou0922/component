package com.hry.component.mybatisplus.service;

import com.hry.component.mybatisplus.TestBase;
import com.hry.component.mybatisplus.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
}
