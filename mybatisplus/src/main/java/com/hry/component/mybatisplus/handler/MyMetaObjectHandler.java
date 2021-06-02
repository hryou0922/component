package com.hry.component.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 完成自动填充功能
 * @author: huangrongyou@yixin.im
 * @date: 2021/6/1 16:10
 */
@Component//将对象交给spring容器管理
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        // 这里的fieldName 必须 和model里的成员变量名称相同
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date() );
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date() );
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
    }

}
