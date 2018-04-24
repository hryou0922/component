package com.hry.java.cls;

import java.lang.reflect.Field;

public class ClassReflect {
	
	public static void declaredFields() throws IllegalArgumentException, IllegalAccessException{
		VO vo = new VO();
		
		System.out.println("=== 获取所有的私有变量 ===");
		Field[] fieldArr = VO.class.getDeclaredFields();
		for(Field f : fieldArr){
			System.out.println("=====================");
			System.out.println(" name:" + f.getName());
			System.out.println(" modifiers: " + f.getModifiers());
			System.out.println(" type: " + f.getType());
			System.out.println(" isAccessible "  + f.isAccessible());
			
			f.setAccessible(true); // 设置可访问
			System.out.println(" value : " + f.get(vo));
				
		}
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		declaredFields();
		
	}
	
}
