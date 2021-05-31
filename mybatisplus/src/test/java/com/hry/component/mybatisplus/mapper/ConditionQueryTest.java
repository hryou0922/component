package com.hry.component.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hry.component.mybatisplus.TestBase;
import com.hry.component.mybatisplus.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/29 19:29
 */
public class ConditionQueryTest extends TestBase {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void allEq() {
        Map<String,Object> map = new HashMap<>();
        map.put("name", "男");
        map.put("age", null);

        // name=男 and age is null
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.allEq(map);
        List<User> userBeanList = userMapper.selectList(wrapper);
        System.out.println("result size=" + userBeanList.size());

        System.out.println("================= 分割线 =================");

        // name=男
        wrapper = new QueryWrapper<>();
        wrapper.allEq(map, false);
        userBeanList = userMapper.selectList(wrapper);
        System.out.println("result size=" + userBeanList.size());
    }

    @Test
    public void gtLt() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("id", 100);
        wrapper.lt("id", 105);
        List<User> userBeanList = userMapper.selectList(wrapper);
        for(User userBean : userBeanList) {
            System.out.println(userBean);
        }

        System.out.println("================== 分割线 ===================");
        wrapper = new QueryWrapper<>();
        wrapper.ge("id", 100);
        wrapper.le("id", 105);
        userBeanList = userMapper.selectList(wrapper);
        for(User userBean : userBeanList) {
            System.out.println(userBean);
        }
    }


    @Test
    public void between() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("id", 100, 105);
        List<User> userBeanList = userMapper.selectList(wrapper);
        for(User userBean : userBeanList) {
            System.out.println(userBean);
        }

        System.out.println("================== 分割线 ===================");
        wrapper = new QueryWrapper<>();
        wrapper.notBetween("age", 21, 90);
        userBeanList = userMapper.selectList(wrapper);
        for(User userBean : userBeanList) {
            System.out.println(userBean);
        }
    }

}
