package com.hry.java.apache.lang3;

import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayUtilsTest {

	public static void main(String[] args) {
		// 追加元素到数组尾部  
		int[] array1 = {1, 2};  
		array1 = ArrayUtils.add(array1, 3); // => [1, 2, 3]  
		System.out.println(array1.length);//3  
		System.out.println(array1[2]);//3  
		  
		// 删除指定位置的元素  
		int[] array2 = {1, 2, 3};  
		array2 = ArrayUtils.remove(array2, 2); // => [1, 2]  
		System.out.println(array2.length);//2  
		  
		// 截取部分元素  
		int[] array3 = {1, 2, 3, 4};  
		array3 = ArrayUtils.subarray(array3, 1, 3); // => [2, 3]  
		System.out.println(array3.length);//2  
		  
		// 数组拷贝  
		String[] array4 = {"aaa", "bbb", "ccc"};  
		String[] copied = (String[]) ArrayUtils.clone(array4); // => {"aaa", "bbb", "ccc"}  
		System.out.println(copied.length);//3         
		  
		// 判断是否包含某元素  
		String[] array5 = {"aaa", "bbb", "ccc", "bbb"};  
		boolean result1 = ArrayUtils.contains(array5, "bbb"); // => true       
		System.out.println(result1);//true  
		  
		// 判断某元素在数组中出现的位置（从前往后，没有返回-1）  
		int result2 = ArrayUtils.indexOf(array5, "bbb"); // => 1       
		System.out.println(result2);//1  
		  
		// 判断某元素在数组中出现的位置（从后往前，没有返回-1）  
		int result3 = ArrayUtils.lastIndexOf(array5, "bbb"); // => 3  
		System.out.println(result3);//3  
		  
		// 数组转Map  
		Map<Object, Object> map = ArrayUtils.toMap(new String[][]{  
		    {"key1", "value1"},  
		    {"key2", "value2"}  
		});  
		System.out.println(map.get("key1"));//"value1"  
		System.out.println(map.get("key2"));//"value2"  
		  
		// 判断数组是否为空  
		Object[] array61 = new Object[0];  
		Object[] array62 = null;  
		Object[] array63 = new Object[]{"aaa"};  
		  
		System.out.println(ArrayUtils.isEmpty(array61));//true  
		System.out.println(ArrayUtils.isEmpty(array62));//true  
		System.out.println(ArrayUtils.isNotEmpty(array63));//true  
		  
		// 判断数组长度是否相等  
		Object[] array71 = new Object[]{"aa", "bb", "cc"};  
		Object[] array72 = new Object[]{"dd", "ee", "ff"};  
		  
		System.out.println(ArrayUtils.isSameLength(array71, array72));//true  
		  
		// 判断数组元素内容是否相等  
		Object[] array81 = new Object[]{"aa", "bb", "cc"};  
		Object[] array82 = new Object[]{"aa", "bb", "cc"};  
		  
		System.out.println(ArrayUtils.isEquals(array81, array82));  
		  
		// Integer[] 转化为 int[]  
		Integer[] array9 = new Integer[]{1, 2};  
		int[] result = ArrayUtils.toPrimitive(array9);  
		  
		System.out.println(result.length);//2  
		System.out.println(result[0]);//1  
		  
		// int[] 转化为 Integer[]   
		int[] array10 = new int[]{1, 2};  
		Integer[] result10 = ArrayUtils.toObject(array10);  
		  
		System.out.println(result.length);//2  
		System.out.println(result10[0].intValue());//1  
		
	}

}
