package com.hry.component.mybatisplus.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hry.component.mybatisplus.TestBase;
import com.hry.component.mybatisplus.model.Log;
import com.hry.component.mybatisplus.model.User;
import com.hry.component.mybatisplus.utils.CommonJsonUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2021/6/1 15:26
 */
public class LogTest  extends TestBase {
    @Autowired
    private LogMapper logMapper;

    @Test
    public void selectById() {
        Log log = logMapper.selectById("1");
        System.out.println(CommonJsonUtils.toJsonString(log));
    }

    @Test
    public void searchPageWithSql() {
        Page<User> page = new Page<>(1, 1);
        page.setSearchCount(false);

        Page<Log> logList = logMapper.searchPageWithSql(page);
        System.out.println(CommonJsonUtils.toJsonString(logList));
    }
}
