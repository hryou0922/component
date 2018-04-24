package com.hry.java.apache.lang3;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {

	public static void main(String[] args) {
        //StringUtils.isEmpty(String str) 字符串空判断  
        System.out.println("==========isEmpty============");  
        System.out.println(StringUtils.isEmpty(null));//true  
        System.out.println(StringUtils.isEmpty(""));//true  
        System.out.println(StringUtils.isEmpty(" "));//false  
        System.out.println(StringUtils.isEmpty("    "));//false  
        System.out.println(StringUtils.isEmpty("abc"));//false  
        System.out.println(StringUtils.isEmpty(" abc "));//false  
                  
                     
        //StringUtils.isBlank(String str) 判断字符串是否为空和空字符   
        System.out.println("==========isBlank============");  
        System.out.println(StringUtils.isBlank(null));//true  
        System.out.println(StringUtils.isBlank(""));//true  
        System.out.println(StringUtils.isBlank(" "));//true  
        System.out.println(StringUtils.isBlank("   "));//true  
        System.out.println(StringUtils.isBlank("\n\t"));//true  
        System.out.println(StringUtils.isBlank("abc"));//false  
        System.out.println(StringUtils.isBlank(" abc "));//false  
          
          
        //StringUtils.trim(String str) 参数为null则返回null否则去头和尾的空格  
        System.out.println("==========trim============");  
        System.out.println(StringUtils.trim(null));//null  
        System.out.println(StringUtils.trim(""));//""  
        System.out.println(StringUtils.trim("   "));//""  
        System.out.println(StringUtils.trim("abc"));//"abc"  
        System.out.println(StringUtils.trim("   abc   "));//"abc"  
        System.out.println(StringUtils.trim("   a b c   "));//"a b c"  
          
          
        //StringUtils.substring(str, start)  
        //StringUtils.substring(str, start, end)  
        System.out.println("==========substring============");  
        System.out.println(StringUtils.substring(null, 0));//null  
        System.out.println(StringUtils.substring(null, 0, 1));//null  
        System.out.println(StringUtils.substring("", 0, 1));//""  
        System.out.println(StringUtils.substring("abcd", 4, 5));//""  
        System.out.println(StringUtils.substring("abcd", 0, 5));//abcd  
          
          
        //StringUtils.leftPad(String str, int size, String arg2)  
        //StringUtils.rightPad(String str, int size, String arg2);  
        System.out.println("==========leftPad============");  
        System.out.println(StringUtils.leftPad("abc", 10, "0"));  
        System.out.println(StringUtils.rightPad("abc", 10, "0"));  
          
          
        //StringUtils.equals(String str1, String str1)  
        //StringUtils.equalsIgnoreCase(String str1, String str1)  
        //若str1或者str2中有一个为null，则结果为false；若都为null，则结果为true；其余与String的equals方法一致。  
        System.out.println("==========equals============");  
        System.out.println(StringUtils.equals(null, null));//true  
        System.out.println(StringUtils.equals(null, "abc"));//false  
        System.out.println(StringUtils.equals("abc", "abc"));//true      
                    
  
        //StringUtils.indexOf(String seq, String searchSeq)  
        //StringUtils.indexOf(String seq, String searchSeq, int startPos)  
        //StringUtils.lastIndexOf(String seq, String searchSeq)  
        //StringUtils.lastIndexOf(String seq, String searchSeq, int startPos)  
        //若seq为null，返回-1，其余约String的indexOf方法一致。  
        System.out.println("==========indexOf============");  
        System.out.println(StringUtils.indexOf(null, "a"));//-1  
        System.out.println(StringUtils.indexOf("", "a"));//-1  
        System.out.println(StringUtils.indexOf("abcda", "a"));//0  
        System.out.println(StringUtils.indexOf("abcda", "a", 2));//4 
        
        
        System.out.println("==========join============");  
        //数组元素拼接
        String[] array = {"aaa", "bbb", "ccc"};
        String result1 = StringUtils.join(array, ","); 
        System.out.println(result1);//"aaa,bbb,ccc"
        //集合元素拼接
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        String result2 = StringUtils.join(list, ",");
        System.out.println(result2);//"aaa,bbb,ccc"
	}

}
