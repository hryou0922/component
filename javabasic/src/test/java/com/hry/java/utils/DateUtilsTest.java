package com.hry.java.utils;

import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtilsTest {

    @Test
    public void testParserYYYYMMddHHmmss(){
        Date testDate = Calendar.getInstance().getTime();
        String dataString = DateUtils.formatYYYYMMddHHmmss(testDate);
        System.out.println("dataString = " + dataString);
        Date parserDate = DateUtils.parserYYYYMMddHHmmss(dataString);
        System.out.println("parserDate = " + parserDate);
        // 判断两个时间相同
        Assert.assertEquals(true, DateUtils.isSameDay(testDate,parserDate));
        System.out.println(DateUtils.parserYYYYMMddHHmmss(""));
        System.out.println(DateUtils.parserYYYYMMddHHmmss("22"));
    }

    @Test
    public void createDate() throws ParseException {
        System.out.println(DateUtils.createDate(2018,11,12));
        System.out.println(DateUtils.createDate(2018,11,12, 23, 9, 0));
    }
    @Test
    public void testLenient() throws ParseException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        // 如果设置lenient为false，则解析33/12/2011失败
        // 如果设置lenient为true，则解析成功，值： Mon Jan 02 00:00:00 CST 2012
        format.setLenient(true);
        Date date = format.parse("33/12/2011");
        System.out.println(date);
    }

}
