package com.hry.java.regular;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: huangrongyou@yixin.im
 * @Date: 2019/3/21 19:24:08
 */
public class PatternMatcherDemo {


    public void execute(){
        Pattern p = Pattern.compile("\\w+");
        // 返回正则表达式： 返回 \w+
        System.out.println(p.pattern());

        // == Pattern.split(CharSequence input)方法使用正则表达式进行分隔
        p = Pattern.compile("\\d+");
        // 返回结果 [我的QQ是:,  我的电话是:, dsfa我的邮箱是:abc@, .com]
        String[] str=p.split("我的QQ是:1232423 我的电话是:1234288dsfa我的邮箱是:abc@126.com");
        System.out.println(Arrays.toString(str));

        // == Pattern.matcher(String regex,CharSequence input)静态方法,用于快速匹配字符串, 当所有字符串都符合正则表达式才返回true
        //返回true
        boolean rtnBoolean = Pattern.matches("\\d+","1231423");
        System.out.println(rtnBoolean);
        //返回false,需要匹配到所有字符串才能返回true,
        rtnBoolean = Pattern.matches("\\d+","3143bac");
        System.out.println(rtnBoolean);
        //返回false,需要匹配到所有字符串才能返回true
        rtnBoolean = Pattern.matches("\\d+","sdafds2323");
        System.out.println(rtnBoolean);

        // == Matcher
        /**
         * Matcher类提供三个匹配操作方法
            1. matches()对整个字符串进行匹配,只有整个字符串都匹配了才返回true
            2. lookingAt()对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true
            3. find()对字符串进行匹配,匹配到的字符串可以在任何位置.
         */

        // == Matcher:matcher(CharSequence input)
        p = Pattern.compile("\\d+");
        Matcher m=p.matcher("123213asgas");
        //返回false,因为asgas不能被\d+匹配,导致整个字符串匹配未成功.
        rtnBoolean = m.matches();
        System.out.println(rtnBoolean);

        Matcher m2=p.matcher("1223");
        //返回true,因为\d+匹配到了整个字符串
        rtnBoolean = m2.matches();
        System.out.println(rtnBoolean);

        // == Matcher: lookingAt()
        p=Pattern.compile("\\d+");
        m=p.matcher("22aa23");
        //返回true,因为\d+匹配到了前面的22
        rtnBoolean = m.lookingAt();
        System.out.println(rtnBoolean);
        m2=p.matcher("bb1233");
        //返回false,因为\d+不能匹配前面的bb
        rtnBoolean = m2.lookingAt();
        System.out.println(rtnBoolean);

        // == Matcher: find()
        p=Pattern.compile("\\d+");
        m=p.matcher("22bb23");
        // 返回true
        rtnBoolean = m.find();
        System.out.println(rtnBoolean);
        m2=p.matcher("aa2223aa");
        // //返回true
        rtnBoolean = m2.find();
        System.out.println(rtnBoolean);
        Matcher m3=p.matcher("aa2223bbcc");
        //返回true
        rtnBoolean = m3.find();
        System.out.println(rtnBoolean);
        Matcher m4=p.matcher("ccaa");
        //返回false
        rtnBoolean = m4.find();
        System.out.println(rtnBoolean);

        // Mather
        /**
         当使用matches(),lookingAt(),find()执行匹配操作后,就可以利用以下三个方法得到更详细的信息.
            1. start()返回匹配到的子字符串在字符串中的索引位置.
            2. end()返回匹配到的子字符串的最后一个字符在字符串中的索引位置.
            3. group()返回匹配到的子字符串
         */
        // 执行结果：find()=[true] start()=[3] end()=[7] group()=[2223]
        matherMethodsFind("\\d+","aaa2223bb");
        // 执行结果：find()=[true] start()=[0] end()=[4] group()=[2223]
        matherMethodsLookingAt("\\d+","2223bb");
        // 执行结果：find()=[true] start()=[0] end()=[6] group()=[123456]
        matherMethodsMatches("\\d+","123456");

        // Mather: 分组方法
        // groupCount(), start(int i),end(int i),group(int i)专用于分组操作
        p=Pattern.compile("([a-z]+)(\\d+)");
        m=p.matcher("aaa2223bb");
        //返回2,因为有2组
        int groupCount =  m.groupCount();
        System.out.println("总分组数目：" + groupCount);
        // 循环打印信息
        while(m.find()){
            // 返回第N组匹配到的子字符串在字符串中的索引号
            int start = m.start();
            // 返回第N组匹配到的子字符串的最后一个字符在字符串中的索引位置.
            int end = m.end();
            //  返回aaa,返回第一组匹配到的子字符串
            String groupStr = m.group();
            System.out.println("start = [" + start +"] end = [" +end+"] group=["+groupStr+"]" );
        }
    }
    //https://www.cnblogs.com/ggjucheng/p/3423731.html

    private void matherMethodsFind(String regex, String str){
        Pattern p=Pattern.compile(regex);
        Matcher m=p.matcher(str);
        // 使用find方法后查看start(), end(0, group()方法的值
        boolean findBoolean = m.find();
        int start = m.start();
        int end = m.end();
        String group = m.group();
        System.out.println("find()=["+findBoolean+"]" + " start()=["+start+"]"+ " end()=["+end+"]"+ " group()=["+group+"]");
    }

    private void matherMethodsLookingAt(String regex, String str){
        Pattern p=Pattern.compile(regex);
        Matcher m=p.matcher(str);
        // 使用lookingAt方法后查看start(), end(0, group()方法的值
        boolean findBoolean = m.lookingAt();
        int start = m.start();
        int end = m.end();
        String group = m.group();
        System.out.println("find()=["+findBoolean+"]" + " start()=["+start+"]"+ " end()=["+end+"]"+ " group()=["+group+"]");
    }

    private void matherMethodsMatches(String regex, String str){
        Pattern p=Pattern.compile(regex);
        Matcher m=p.matcher(str);
        // 使用find方法后查看start(), end(0, group()方法的值
        boolean findBoolean = m.matches();
        int start = m.start();
        int end = m.end();
        String group = m.group();
        System.out.println("find()=["+findBoolean+"]" + " start()=["+start+"]"+ " end()=["+end+"]"+ " group()=["+group+"]");
    }

}
