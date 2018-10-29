package com.hry.java.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * DateFormat 和 SimpleDateFormat 类不都是线程安全的，要注意多线程问题
 *
 * 部分方法源码来自：
 *   org.apache.commons.lang3.time.DateUtils
 */
public class DateUtils {
    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
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
            logger.error("解析[{}]时间失败", dateStr);
            return null;
        }
    }

    // ================== 创建指定时间 begin================

    /**
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date createDate(int year, int month, int day){
        // getInstance() returns a new object, so this method is thread safe.
        final Calendar c = Calendar.getInstance();
        // 严格解析
        c.setLenient(false);
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month -1);  // 月份需要-1
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date createDate(int year, int month, int day, int hh, int mm, int ss ){
        // getInstance() returns a new object, so this method is thread safe.
        final Calendar c = Calendar.getInstance();
        // 严格解析
        c.setLenient(false);
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month-1);  // 月份需要-1
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.HOUR_OF_DAY, hh);
        c.set(Calendar.MINUTE, mm);
        c.set(Calendar.SECOND, ss);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    // ================== 创建指定时间 begin================

    // ================== 时间比较操作 begin================
    /**
     * 判断这两天是否是同一天
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(final Date date1, final Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        final Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        final Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return isSameDay(cal1, cal2);
    }

    public static boolean isSameDay(final Calendar cal1, final Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }
    // ================== 时间比较操作 end================

    // ================== add begin 操作 ================
    public static Date addYears(final Date date, final int amount) {
        return add(date, Calendar.YEAR, amount);
    }
    public static Date addMonths(final Date date, final int amount) {
        return add(date, Calendar.MONTH, amount);
    }
    public static Date addWeeks(final Date date, final int amount) {
        return add(date, Calendar.WEEK_OF_YEAR, amount);
    }
    public static Date addDays(final Date date, final int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }
    public static Date addHours(final Date date, final int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }
    public static Date addMinutes(final Date date, final int amount) {
        return add(date, Calendar.MINUTE, amount);
    }
    public static Date addSeconds(final Date date, final int amount) {
        return add(date, Calendar.SECOND, amount);
    }
    public static Date addMilliseconds(final Date date, final int amount) {
        return add(date, Calendar.MILLISECOND, amount);
    }
    private static Date add(final Date date, final int calendarField, final int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    // ================== add end 操作 ================

    // ================== set begin 操作 ================
    public static Date setYears(final Date date, final int amount) {
        return set(date, Calendar.YEAR, amount);
    }
    public static Date setMonths(final Date date, final int amount) {
        return set(date, Calendar.MONTH, amount);
    }
    public static Date setDays(final Date date, final int amount) {
        return set(date, Calendar.DAY_OF_MONTH, amount);
    }
    public static Date setHours(final Date date, final int amount) {
        return set(date, Calendar.HOUR_OF_DAY, amount);
    }
    public static Date setMinutes(final Date date, final int amount) {
        return set(date, Calendar.MINUTE, amount);
    }
    public static Date setSeconds(final Date date, final int amount) {
        return set(date, Calendar.SECOND, amount);
    }
    public static Date setMilliseconds(final Date date, final int amount) {
        return set(date, Calendar.MILLISECOND, amount);
    }
    private static Date set(final Date date, final int calendarField, final int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        // getInstance() returns a new object, so this method is thread safe.
        final Calendar c = Calendar.getInstance();
        c.setLenient(false);
        c.setTime(date);
        c.set(calendarField, amount);
        return c.getTime();
    }
    // ================== set end 操作 ================
}
