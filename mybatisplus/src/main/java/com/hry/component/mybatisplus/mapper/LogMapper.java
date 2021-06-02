package com.hry.component.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hry.component.mybatisplus.model.Log;
import com.hry.component.mybatisplus.model.User;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hry
 * @since 2021-06-01
 */
public interface LogMapper extends BaseMapper<Log> {

    /**
     * 联表查询
     * @param page
     * @return
     */
    @Select("SELECT * from log a LEFT JOIN user b on a.user_id = b.id  ")
    Page<Log> searchPageWithSql(Page<User> page);

}
