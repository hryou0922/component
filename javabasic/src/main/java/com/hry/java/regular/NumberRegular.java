package com.hry.java.regular;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 从字符串中过滤出数字，或相反的操作
 */
public class NumberRegular {

    public static void main(String[] args){
        String content = "阅读(170)";

        // 获取内容的数字
        System.out.println("getNumber()=" + getNumber(content));
        System.out.println("getNumber2()=" + getNumber2(content));

        // 去除内容中的数字
        System.out.println("getNotNumber()=" + getNotNumber(content));
        System.out.println("getNotNumber2()=" + getNotNumber2(content));

        // 批量获取数字
        String conents = "阅读(170)QQ是448992353手机是13989467023";
        System.out.println("=========批量获取数==========");
        getNumberArray(conents).forEach(o -> {
           System.out.println(o);
        });
    }

    /**
     * 判断一个字符是不是数字
     * @param str
     * @return
     */
    public static boolean isDigit(String str){
        return str.matches("[0-9]{1,}");
    }

    /**
     * 判断一个字符是不是数字
     * @param str
     * @return
     */
    public static boolean isDigitByReg(String str){
        Pattern pattern = Pattern.compile("[0-9]{1,}");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * 从文本中截取数字
     * @param str
     * @return
     */
    public static String getNumber(String str){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            return matcher.group();
        }
        return "";
    }

    /**
     * 使用替换的方法，从文本中截取数字
     * @param str
     * @return
     */
    public static String getNumber2(String str){
        String dest = "";
        if(str != null){
            dest = str.replaceAll("[^0-9]","");
        }
        return dest;
    }

    /**
     * 批量获取数字组
     * @param str
     * @return
     */
    public static List<String> getNumberArray(String str){
        List<String> arrayList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            arrayList.add(matcher.group());
        }
        return arrayList;
    }



    /**
     * 截取非数字的内容
     *  这个方法的获取会有问题，不推荐使用
     * @param str
     * @return
     */
    @Deprecated
    public static String getNotNumber(String str){
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            return matcher.group();
        }
        return "";
    }

    /**
     * 使用替换的方法获取所有的非数字内容
     * @param str
     * @return
     */
    public static String getNotNumber2(String str){
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll("").trim();
    }


}
