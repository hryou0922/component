package com.hry.java.apache.lang3;

import org.apache.commons.lang3.StringEscapeUtils;

public class StringEscapeUtilsTest {
	
	public static void main(String[] args){
		System.out.println(StringEscapeUtils.escapeCsv("测试测试哦"));//"测试测试哦"  
		System.out.println(StringEscapeUtils.escapeCsv("测试,测试哦"));//"\"测试,测试哦\""  
		System.out.println(StringEscapeUtils.escapeCsv("测试\n测试哦"));//"\"测试\n测试哦\""  
		  
		System.out.println(StringEscapeUtils.escapeHtml4("测试测试哦  "));//"<p>测试测试哦</p>"  
		System.out.println(StringEscapeUtils.escapeJava("\"rensaninng\"，欢迎您！"));//"\"rensaninng\"\uFF0C\u6B22\u8FCE\u60A8\uFF01"  
		  
		System.out.println(StringEscapeUtils.escapeEcmaScript("测试'测试哦"));//"\u6D4B\u8BD5\'\u6D4B\u8BD5\u54E6" 
		
		System.out.println(StringEscapeUtils.escapeJson("{'a':'value', 'number': 1}"));
	}
}
