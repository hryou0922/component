package com.hry.component.httpclient.path;

import java.io.File;
import java.io.IOException;

/**
 * 
 * Java路径相关处理类
 * 	当前工程目录：D:\eclipse_study\simpletool
 * 		
 * 
 * @author Administrator
 *
 */
public class JavaBasePathMain {
	
	public static void main(String[] args) throws IOException{
		// ################################# System #########################################
		System.out.println("##################################################################");
		System.out.println("user.dir指定了当前的路径 :" + System.getProperty("user.dir"));//user.dir指定了当前的路径

		// ################################# File #########################################
		// 对于getCanonicalPath()函数，“."就表示当前的文件夹，而”..“则表示当前文件夹的上一级文件夹
		// 对于getAbsolutePath()函数，则不管”.”、“..”，返回当前的路径加上你在new File()时设定的路径
		// 至于getPath()函数，得到的只是你在new File()时设定的路径
		// 比如当前的路径为D:\eclipse_study\simpletool：
		System.out.println("##################################################################");
		File directory2 = new File("src");
		System.out.println("getCanonicalPath:" + directory2.getCanonicalPath()); //得到的是 D:\eclipse_study\simpletool\src
		System.out.println("getAbsolutePath:" + directory2.getAbsolutePath());    //得到的是 D:\eclipse_study\simpletool\src
		System.out.println("getPath:" + directory2.getPath());                    //得到的是 src

		File directory3 = new File(".");
		System.out.println("getCanonicalPath:" + directory3.getCanonicalPath()); //得到的是 D:\eclipse_study\simpletool
		System.out.println("getAbsolutePath:" + directory3.getAbsolutePath());    //得到的是 D:\eclipse_study\simpletool\.
		System.out.println("getPath:" + directory3.getPath());                    //得到的是 .

		File directory4 = new File("..");
		System.out.println("getCanonicalPath:" + directory4.getCanonicalPath()); //得到的是 D:\eclipse_study
		System.out.println("getAbsolutePath:" + directory4.getAbsolutePath());    //得到的是 D:\eclipse_study\simpletool\..
		System.out.println("getPath:" + directory4.getPath());                    //得到的是..
		
		// 默认情况下new File("/") 代表当前盘的根目录
		File directory5 = new File("/");
		System.out.println("getCanonicalPath:" + directory5.getCanonicalPath()); //得到的是 D:\
		System.out.println("getAbsolutePath:" + directory5.getAbsolutePath());    //得到的是 D:\
		System.out.println("getPath:" + directory5.getPath());                    //得到的是 \
		
		// ################################# Resouce #########################################
		// 其他：有关于Resource的操作，但是没有执行成功，暂时记录： http://blog.csdn.net/wpydaguan/article/details/42455659
		// 这将获取 到classes目录的全路径
		System.out.println("##################################################################");
		System.out.println("获取 到classes目录的全路径:" + Thread.currentThread().getContextClassLoader().getResource(""));   
		System.out.println("获取 到classes目录的全路径:" + JavaBasePathMain.class.getClassLoader().getResource(""));
        System.out.println("获取 到classes目录的全路径:" + ClassLoader.class.getResource("/")); 
		
		// 例如 : E:\eclipseM9/workspace/tree/WEB-INF/classes/
		
	}
}
