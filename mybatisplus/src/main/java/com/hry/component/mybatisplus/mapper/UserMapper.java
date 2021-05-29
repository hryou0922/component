package com.hry.component.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hry.component.mybatisplus.model.User;
import com.hry.component.mybatisplus.qry.UserQry;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/26 17:49
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 自定义sql 查询条件
     *   @Results的基本用法:
     *      当数据库字段名与实体类对应的属性名不一致时，可以使用@Results映射来将其对应起来。column为数据库字段名，porperty为实体类属性名，jdbcType为数据库字段数据类型，id为是否为主键
     *      名字相同的可以省略
     *
     * @param page
     * @param wrapper
     * @return
     */
    @Select("SELECT * from user a LEFT JOIN user_address b on a.id = b.id ${ew.customSqlSegment}")
//    @Results(id = "userRst", value = {
//            @Result(column = "id", property = "id", jdbcType= JdbcType.BIGINT),
//            @Result(column = "name", property = "name", jdbcType= JdbcType.VARCHAR),
//            @Result(column = "age", property = "age", jdbcType= JdbcType.INTEGER)
//        //    @Result(column = "email", property = "email", jdbcType= JdbcType.VARCHAR),
//       //     @Result(column = "id", property = "userAddress", javaType = UserAddress.class, one = @One(resultMap="addressResultMap")),
//    })
    // 这个注解为 @Select 或者 @SelectProvider 注解指定 XML 映射中 <resultMap> 元素的 id。这使得注解的 select 可以复用已在 XML 中定义的 ResultMap。
    // 如果标注的 select 注解中存在 @Results 或者 @ConstructorArgs 注解，这两个注解将被此注解覆盖。
    @ResultMap(value = "BaseResultMap")
    Page<User> searchPageWithSql(Page<User> page, @Param(Constants.WRAPPER) Wrapper wrapper);

    /**
     * 传入page类，查询条件为当前表
     *  查询条件使用：  ${ew.customSqlSegment}
     *
     * @param page
     * @param wrapper
     * @return
     */
     Page<User> searchPage(Page<User> page, @Param(Constants.WRAPPER) Wrapper wrapper);

    /**
     * 传入Page类，支持分页， 查询条件自定义
     *
     * @param page
     * @param req 这里使用mybatis-plus，不同于mybatis，这里必须定义 @Param，且在对应的mapper.xml文件时，引用必须带 req.前缀
     * @return
     */
    Page<User> searchPageWithQry(Page<User> page,@Param("req") UserQry req);
}
