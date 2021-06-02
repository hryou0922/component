package com.hry.component.mybatisplus.configuration;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/27 14:59
 */
@Configuration
public class MybatisConfig {

    /**
     * 分页插件。如果你不配置，分页插件将不生效
     */
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 指定数据库方言为 MYSQL
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    /**
     * 乐观锁
     * @return
     */
    @Bean
    public MybatisPlusInterceptor optimisticLockerInnerInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 乐观锁插件
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }

    /**
     * 动态表拦截器
     * @return
     */
    @Bean
    public MybatisPlusInterceptor dynamicTableNameInnerInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 动态表名插件
        DynamicTableNameInnerInterceptor dynamicTabNameInterceptor = new DynamicTableNameInnerInterceptor();
        Map<String, TableNameHandler> tableNameHandlerMap = new HashMap<>();
        // 这里指定要访问的表
        tableNameHandlerMap.put("log", new TableNameHandler() {
            @Override
            public String dynamicTableName(String sql, String tableName) {
                // 实际应用时，这里可以考虑使用当前时间作为要查询的表的后缀
                String[] tableSuffix = {"202105", "202106", "202107"};
                return tableName + "_" + tableSuffix[(int)(Math.random() * tableSuffix.length)];
            }
        });
        dynamicTabNameInterceptor.setTableNameHandlerMap(tableNameHandlerMap);
        interceptor.addInnerInterceptor(dynamicTabNameInterceptor);
        return interceptor;
    }


}
