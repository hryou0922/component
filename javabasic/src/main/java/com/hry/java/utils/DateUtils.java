package com.hry.java.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * DateFormat 和 SimpleDateFormat 类不都是线程安全的，要注意多线程问题
 */
public class DateUtils {

    // 时间
    private static final ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocalYYYYMMDDHHSS = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    /**
     * 格式化时间：yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String formatYYYYMMddHHmmss(Date date){
        return simpleDateFormatThreadLocalYYYYMMDDHHSS.get().format(date);
    }

    /**
     * 解析：yyyy-MM-dd HH:mm:ss
     *  如果解析失败，则返回null
     * @param dateStr
     * @return
     */
    public static Date parserYYYYMMddHHmmss(String dateStr){
        if(Objects.isNull(dateStr)){
            return null;
        }
        try {
            return simpleDateFormatThreadLocalYYYYMMDDHHSS.get().parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
