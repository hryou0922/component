package com.hry.component.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hry.component.mybatisplus.TestBase;
import com.hry.component.mybatisplus.model.User;
import com.hry.component.mybatisplus.qry.UserQry;
import com.hry.component.mybatisplus.utils.CommonJsonUtils;
import org.apache.commons.lang3.StringUtils;
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
public class QueryTest extends TestBase {

    @Autowired
    private UserMapper userMapper;

    // 简单查询

    @Test
    public void selectList() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectById() {
        User user = userMapper.selectById("1");
        System.out.println(CommonJsonUtils.toJsonString(user));
    }

    @Test
    public void selectBatchIds() {
        List<User> user = userMapper.selectBatchIds(Arrays.asList("1","2"));
        System.out.println(CommonJsonUtils.toJsonString(user));
    }

    @Test
    public void selectOne() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
         wrapper.le("id", "1");
       //  wrapper.le(false, "id", "1");
        User user = userMapper.selectOne(wrapper);
        System.out.println(CommonJsonUtils.toJsonString(user));
    }

    @Test
    public void selectCount() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age", "21");
        int total = userMapper.selectCount(wrapper);
        System.out.println(total);
    }

    // 复杂查询


    @Test
    public void queryN() {
        String name = null;
        Integer age = null;

        // 下面将根据 姓名和年龄查询条件创建一个 Wrapper 条件对象，查询用户大小
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt(!StringUtils.isEmpty(name), "name", name);
        wrapper.eq(null != age, "age", age);

        int total = userMapper.selectCount(wrapper);
        System.out.println(total);
    }

    @Test
    public void queryMap() {
        // map 做为查询条件

        String name = null;
        Integer age = null;
        Map<String,Object> map = new HashMap<>();
        if(StringUtils.isNotEmpty(name)) {
            map.put("name", name);
        }
        if(null != age) {
            map.put("age", age);
        }

        List<User> userList  = userMapper.selectByMap(map);
        userList.forEach(System.out::println);
    }


    @Test
    public void queryPage() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // 创建分页对象（1表示第一页；4表示每页大小为4）
        Page<User> page = new Page<>(1, 2);
        page.setSearchCount(false);
        Page<User> result = userMapper.selectPage(page, wrapper);
        System.out.println("page == result: " + (page == result));
        System.out.println("size: " + result.getSize());
        System.out.println("total: " + result.getTotal());
        for(User userBean : result.getRecords()) {
            System.out.println(userBean);
        }
    }

    @Test
    public void queryJoinPage() {
        Page<User> page = new Page<>(1, 1);
        page.setSearchCount(false);
        UserQry userQry = new UserQry();
        userQry.setId(1L);

        Page<User> result = userMapper.searchPageWithQry(page, userQry);

        System.out.println("page == result: " + (page == result));
        System.out.println("size: " + result.getSize());
        System.out.println("total: " + result.getTotal());
        for(User userBean : result.getRecords()) {
            System.out.println(userBean);
        }
    }

    @Test
    public void searchPage() {
        Page<User> page = new Page<>(1, 1);
        page.setSearchCount(false);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 由于这里涉及联表，且2张表都有id，所以必须有前缀
        wrapper.ge("a.id",1);

        Page<User> result = userMapper.searchPage(page, wrapper);

        System.out.println("page == result: " + (page == result));
        System.out.println("size: " + result.getSize());
        System.out.println("total: " + result.getTotal());
        for(User userBean : result.getRecords()) {
            System.out.println(userBean);
        }
    }

    @Test
    public void searchPageWithSql() {
        Page<User> page = new Page<>(1, 1);
        page.setSearchCount(false);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 由于这里涉及联表，且2张表都有id，所以必须有前缀
        wrapper.ge("a.id",1);

        Page<User> result = userMapper.searchPageWithSql(page, wrapper);

        System.out.println("page == result: " + (page == result));
        System.out.println("size: " + result.getSize());
        System.out.println("total: " + result.getTotal());
        for(User userBean : result.getRecords()) {
            System.out.println(userBean);
        }
    }

}
