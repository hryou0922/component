package com.hry.component.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hry.component.mybatisplus.TestBase;
import com.hry.component.mybatisplus.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/26 17:50
 */
public class InsertUpdateDeleteTest extends TestBase {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        // 主键如果不设置，则设置自动值
        // user.setId(1234l);
        user.setName("test");

        int result = userMapper.insert(user);
        System.out.println("result=" + result);
    }

    @Test
    public void insertN() throws InterruptedException {
        int num = 100;

        while(num-- > 0) {
            try {
                User user = new User();
                // 主键如果不设置，则设置自动值
                // user.setId(1234l);
                user.setName("test");

                int result = userMapper.insert(user);
                System.out.println("result=" + result);

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                Thread.sleep(1000);
            }
        }
    }


    @Test
    public void updateById() {
        User user = new User();
        // 主键如果不设置，则设置自动值
        user.setId(1234l);
        user.setName("test");
        int result = userMapper.updateById(user);
        System.out.println("result=" + result);
    }

    @Test
    public void update() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.ge("age", "123");

        User user = new User();
        // 主键如果不设置，则设置自动值
        user.setId(1234l);
        user.setName("test");
        int result = userMapper.update(user, updateWrapper);
        System.out.println("result=" + result);
    }

    @Test
    public void updateVersion() {
        long id = 1L;
        User oldUser = userMapper.selectById(id);
        if(oldUser == null){
            System.out.println("无法找到id为="+id+"的记录!");
            return;
        }

        User user = new User();
        user.setId(id);
        user.setName("test");
        // 如果要触发乐观锁，必须要有@version注释的字段且有值，否则不会有乐观锁
        user.setVersion(oldUser.getVersion());
        // user.setVersion(123);

        // 如果更新成功，则返回1，否则返回0，如果返回0，则需要业务端进行重试更新操作
        int result = userMapper.updateById(user);
        System.out.println("result=" + result);
    }

    @Test
    public void deleteById() {
        int result = userMapper.deleteById(999);
        System.out.println("result=" + result);
    }

    @Test
    public void deleteByMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("age", "12");
        int result = userMapper.deleteByMap(map);
        System.out.println("result=" + result);
    }

    @Test
    public void delete() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.le("age", 30); // 小于等于30

        int result = userMapper.delete(wrapper);
        System.out.println("result=" + result);
    }

    @Test
    public void deleteBatchIds() {
        List<Integer> ids = Arrays.asList(2, 4, 6, 7);
        int result = userMapper.deleteBatchIds(ids);
        System.out.println("result=" + result);
    }


}
