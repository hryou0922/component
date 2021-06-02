package com.hry.component.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2021/6/1 11:08
 */
public enum WeekEnum {
    /**
     * 枚举类
     */
    SUNDAY("Sunday", "星期日"),
    SATURDAY("Saturday", "星期六"),
    FRIDAY("Friday", "星期五"),
    THURSDAY("Thursday", "星期四"),
    WEDNESDAY("Wednesday", "星期三"),
    TUESDAY("Tuesday", "星期二"),
    MONDAY("Monday", "星期一");

    @EnumValue
    private String value;
    private String name;

    private WeekEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }
}
