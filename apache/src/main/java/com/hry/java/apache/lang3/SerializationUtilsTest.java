package com.hry.java.apache.lang3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.hry.java.apache.lang3.support.SerializationVO;
import org.apache.commons.lang3.SerializationUtils;



public class SerializationUtilsTest {

	public static void main(String[] args) throws FileNotFoundException {
		String name = "a.txt";

//		File root = new File(System.getProperty("user.dir") + "/tess4j/src/main/resources/com/hry/java/tess4j/pdf/");

		String filePath = System.getProperty("user.dir") +"/" + name;
		
		SerializationVO vo = new SerializationVO();
		vo.setName("name");
		vo.setValue("value");
		System.out.println("==== 序列化 ======");
		SerializationUtils.serialize(vo, new FileOutputStream(new File(filePath)));
		
		System.out.println("==== 反序列化 ======");
		SerializationVO newVo = SerializationUtils.deserialize(new FileInputStream(new File(filePath)));
		System.out.println(newVo.getName());
		System.out.println(newVo.getValue());
	}

}
