package com.hry.java.apache.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hry.java.apache.beanutils.support.BeanVO;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;


/**
 * 
 * 自定义类型转换器
 * 
 * @author Administrator
 *
 */
public class ConverterTest {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		// 自定义转换器
		ConvertUtils.register(new Converter() {
			// type为转换的类型 value为转换的值: 用于将一个value转换成另一个类型为type的Object
			public Object convert(Class type, Object value) {
				if (value == null) {
					return null;
				}
				SimpleDateFormat sdi = new SimpleDateFormat("yyyy-MM-dd");
				Date dt = null;
				try {
					dt = sdi.parse((String) value);
				} catch (ParseException e) {
					throw new ConversionException("日期格式转换有问题....");
				}
				return dt;
			}
		}, Date.class);
		BeanVO vo = new BeanVO();
		BeanUtils.setProperty(vo, "date", "1997-11-12");	
		System.out.println("Converter : " + vo); 
		System.out.println(BeanUtils.getProperty(vo, "date"));
		
		
	}
}
