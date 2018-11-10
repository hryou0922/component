package com.hry.java.regular;

import java.util.regex.Pattern;

/**
 * Pattern的用法：在并发环境里使用
 */
public class PatternDemo {

    // Pattern全局并发: Pattern类的实例是不可变的，可供多个并发线程安全使用。
    private static final Pattern fixedPhonePattern = Pattern
            .compile("^(\\+?0*86-?)?(0+)?([0-9]{2,3})?([2-8][60-9]{6,7})([0-9]{1,4})?$");

    public boolean isFixedPhone(String str) {
        // mathcer是个变量: Matcher不支持并发请求
        return fixedPhonePattern.matcher(str).matches();
    }
}
