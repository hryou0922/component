package com.hry.component.apache.lang3;

import org.apache.commons.lang3.Validate;

public class ValidateTest {

	public static void main(String[] args) {
		System.out.println("===== 对输入条件进行判断，如果不合法要求，则抛出异常。也可以对异常信息进行自定义  =====");
		
		System.out.println("===== 判断输入值是否在输入范围内，分为有无包括临界值两个方法 =====");
		Validate.exclusiveBetween(0, 100, 2);
		Validate.inclusiveBetween(0, 100, 100);
		Validate.exclusiveBetween(0, 2, 1, "Not in boundaries");
		
		System.out.println("===== 判断类是不是某个类的子类 =====");
		Validate.isAssignableFrom(Object.class, String.class);
	//	Validate.isAssignableFrom(superType, type, message, values);
		
		System.out.println("===== 判断类对象是不是某个类 =====");
		Validate.isInstanceOf(String.class, "a");
		Validate.isInstanceOf(String.class, "a", "Wrong class, object is of class %s",
				"a".getClass().getName());
		
		System.out.println("===== 根据正则表达式判断 =====");
		Validate.matchesPattern("hi", "[a-z]*");
		
		// 其他略
		
	}

}
