package com.hry.component.apache.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hry.component.apache.beanutils.support.BeanVO;
import org.apache.commons.beanutils.BeanUtils;


public class BeanUtilTest {

	public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		// 实现浅复制
		BeanVO vo = new BeanVO();
		vo.setAge(12);
		vo.setName("name");
		BeanVO voNew = (BeanVO) BeanUtils.cloneBean(vo);
		System.out.println("cloneBean : " + voNew.toString());
		
		// 复制一个对象的所有属性到另一个对象里
		BeanVO vo_2 = new BeanVO();
		vo_2.setAge(22);
		vo_2.setName("name_2");
		List<String> list_2 = new ArrayList<String>();
		list_2.add("aaa");
		vo_2.setList(list_2);
		System.out.println("copyProperties origin : " + vo_2.toString());
		BeanUtils.copyProperties(vo_2, vo);
		System.out.println("copyProperties : " + vo_2.toString());
		
		// 为某个对象的属性赋值
		BeanVO vo_3 = new BeanVO();
		BeanUtils.copyProperty(vo_3, "name", "copy_name");
		System.out.println("copyProperties : " + vo_3.toString());
		
		// 把书写的属性转换成一个map
		Map<String,String> map = BeanUtils.describe(vo);
		System.out.println("describe = " + map);
		
		// 获取属性里的某个值
		String value = BeanUtils.getProperty(vo, "age");	   
		System.out.println("getProperty:" + value); 
		
		// 通过map对对象执行填充
		BeanVO vo_4 = new BeanVO();
		Map<String,Object> properties = new HashMap<String, Object>();
		properties.put("name", "name");
		properties.put("list", list_2);
		properties.put("age", 223);
		properties.put("date", new Date());
		BeanUtils.populate(vo_4, properties);
		System.out.println("populate:" + vo_4); 
		
		//获取Bean的数组集合字段值 : 数组和列表
		BeanVO vo_5 = new BeanVO();  
		vo_5.setArray(new String[]{"a", "b", "c"});  
		List<String> list0 = new ArrayList<String>();  
		list0.add("d");  
		list0.add("e");  
		list0.add("f");  
		vo_5.setList(list0);  
		String[] array = BeanUtils.getArrayProperty(vo_5, "array");  
		System.out.println("array-getArrayProperty : " + Arrays.toString(array));
		String[] list = BeanUtils.getArrayProperty(vo_5, "list");  
		System.out.println("list-getArrayProperty : " + Arrays.toString(list));
		System.out.println("array-getProperty :"+ BeanUtils.getProperty(vo_5, "array[1]"));//"b"  
		System.out.println("array-getIndexedProperty: " + BeanUtils.getIndexedProperty(vo_5, "array", 2));//"c"  
		
		// 获取Bean的Map字段值
		BeanVO vo_6 = new BeanVO();  
		Map<String, String> map_2 = new HashMap<String, String>();  
		map_2.put("key1", "value1");  
		map_2.put("key2", "value2");  
		vo_6.setMap(map_2);  
		String value1 = BeanUtils.getMappedProperty(vo_6, "map", "key1");  
		System.out.println("getMappedProperty : key1 " + value1);//"value1"  
		String value2 = BeanUtils.getMappedProperty(vo_6, "map", "key2");  
		System.out.println(value2);//"value2"  
		System.out.println("getMappedProperty : map.key1: " + BeanUtils.getProperty(vo_6, "map.key1"));//"value1"  
		
//		BeanVO bean9 = new BeanVO();  
//		DateConverter converter = new DateConverter();  
//		converter.setPattern("yyyy/MM/dd HH:mm:ss");  
//		ConvertUtils.register(converter, Date.class);  
//		ConvertUtils.register(converter, String.class);  
//		BeanUtils.setProperty(bean9, "date", "2010/12/19 23:40:00");  	  
//		String value9 = BeanUtils.getProperty(bean9, "date");  
//		System.out.println(value9);//"2010/12/19 23:40:00" 
	}

}
