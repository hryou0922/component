package com.hry.component.mybatisplus.service.impl;

import com.hry.component.mybatisplus.model.Log;
import com.hry.component.mybatisplus.mapper.LogMapper;
import com.hry.component.mybatisplus.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hry
 * @since 2021-06-01
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
