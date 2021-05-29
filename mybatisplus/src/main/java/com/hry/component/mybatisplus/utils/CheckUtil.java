package com.hry.component.mybatisplus.utils;

import org.springframework.util.StringUtils;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2019/7/25 15:30
 */
public class CheckUtil {
    /**
     * 不能空，否则抛出异常
     * @param name
     * @param value
     */
    public static void checkNotEmpty(String name, String value){
        if(StringUtils.isEmpty(value)){
            throw new RuntimeException(name + " can't be null!");
        }
    }

    /**
     * 不能为null，否则抛出异常
     * @param name
     * @param value
     */
    public static void checkNotNull(String name, Object value){
        if(value == null){
            throw new RuntimeException(name + " can't be null!");
        }
    }

    /**
     * 值不能为空，且 范围在 min - max 之间，边界值被包含
     * @param value
     * @param min 含
     * @param max 含
     */
    public static void checkIntegerRange(String name, Integer value, int min, int max){
        checkNotNull(name, value);
        if(value < min || value > max){
            throw new RuntimeException(name +"=[" + value + "]必须在["+min+"-"+max+"]范围内");
        }
    }
}
