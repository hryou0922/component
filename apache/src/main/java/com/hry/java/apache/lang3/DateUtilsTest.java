package com.hry.java.apache.lang3;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

public class DateUtilsTest {
	public static void main(String[] arg) throws ParseException{
		// 生成Date对象  
		Date date = DateUtils.parseDate("2010/01/01 11:22:33", new String[]{"yyyy/MM/dd HH:mm:ss"});  
		  
		// 10天后  
		Date tenDaysAfter = DateUtils.addDays(date, 10); // => 2010/01/11 11:22:33  
		System.out.println(DateFormatUtils.format(tenDaysAfter, "yyyy/MM/dd HH:mm:ss"));  
		  
		// 前一个月  
		Date prevMonth = DateUtils.addMonths(date, -1); // => 2009/12/01 11:22:33  
		System.out.println(DateFormatUtils.format(prevMonth, "yyyy/MM/dd HH:mm:ss"));  
		  
		// 判断是否是同一天  
		Date date1 = DateUtils.parseDate("2010/01/01 11:22:33", new String[]{"yyyy/MM/dd HH:mm:ss"});  
		Date date2 = DateUtils.parseDate("2010/01/01 22:33:44", new String[]{"yyyy/MM/dd HH:mm:ss"});  
		System.out.println(DateUtils.isSameDay(date1, date2));// true  
		  
		// 日期格式化  
		System.out.println(DateFormatUtils.format(new Date(), "yyyy/MM/dd HH:mm:ss"));  
	}
}	
