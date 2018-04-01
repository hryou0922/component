package com.hry.component.apache.lang3;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringUtilsTest {

	public static void main(String[] args) {
		// 10位英字  
		System.out.println(RandomStringUtils.randomAlphabetic(10));  
		  
		// 10位英数  
		System.out.println(RandomStringUtils.randomAlphanumeric(10));  
		  
		// 10位ASCII码  
		System.out.println(RandomStringUtils.randomAscii(10));  
		  
		// 指定文字10位  
		System.out.println(RandomStringUtils.random(10, "abcde")); 
		
		System.out.println(RandomStringUtils.random(20, 0, 0, true, true));
	}

}
