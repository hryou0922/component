package com.hry.java.utils;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class DateUtilsTest {

    @Test
    public void testDate(){
        Date testDate = Calendar.getInstance().getTime();
        String dataString = DateUtils.formatYYYYMMddHHmmss(testDate);
        System.out.println("dataString = " + dataString);
        Date parserDate = DateUtils.parserYYYYMMddHHmmss(dataString);
        System.out.println("parserDate = " + parserDate);
//        Assert.assertEquals(true, testDate.equals(parserDate));

        System.out.println(DateUtils.parserYYYYMMddHHmmss(""));
        System.out.println(DateUtils.parserYYYYMMddHHmmss("22"));
    }

}
