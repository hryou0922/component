package com.hry.component.springboot.springel;

import com.hry.component.springboot.springel.support.Person;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ''：包围字符串
 * #：获取变量值
 * T: 类类型
 *
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/18 9:56
 */
public class SpringEl {

    public static void execute(){
        // 1. 文字表达式
        System.out.println("文字表达式");
        textEl();
        System.out.println();

        // 2.  变量 variable：通过 # 获取变量值
        System.out.println("通过 # 获取变量值");
        variableEl();
        System.out.println();

        // 3. 通过new 创建对象
        System.out.println("通过new 创建对象");
        el("new String('aaa')", String.class);
        System.out.println();

        // 4. 对象、Map、List、数组的属性的获取以及方法的调用： #
        System.out.println("对象、Map、List、数组的属性的获取以及方法的调用");
        instanceMapListArrayEl();
        System.out.println();

        // 5. 调用类的静态方法: T
        System.out.println("调用类的静态方法");
        el("T(java.lang.Math).abs(-1)", int.class);
        System.out.println();

        // 6. 操作符
        System.out.println("操作符");
        operatorEl();
        System.out.println();

        // 7. 避免空指针 ?
        System.out.println("避免空指针");
        el("#name?.toUpperCase()", String.class);
        System.out.println();

        // 8. #this变量: 有个特殊的变量#this来表示当前的对象. 常用于集合的过滤
        System.out.println("#this变量");
        el("{1, 3, 5, 7}.?[#this > 3]", String.class);
        System.out.println();

        // 9. list/数组/map集合操作及数据过滤：
        System.out.println(" list/数组/map集合数据过滤");
        listMapArrayFilterEl();
        System.out.println();

        // 10 模板表达式：模板表达式允许文字和表达式混合使用, TemplateParserContext 一般选择使用#{}作为一个定界符:
        Person person = new Person("Ming", 18); // 一个普通的POJO
        EvaluationContext context = new StandardEvaluationContext();  // 表达式的上下文,
        context.setVariable("person", person);
        el("他的名字为#{#person.name}", String.class, context, new TemplateParserContext());

        // 8.5.12 函数: 在该调用用户自定义函数扩展SpEL 表达式字符串  http://itmyhome.com/spring/expressions.html#expressions-example-classes

    }

    /**
     * list/数组/map集合数据过滤：
     */
    private static void listMapArrayFilterEl() {
        /**
         * ?[expression]: 选择符合条件的元素
         * ^[expression]: 选择符合条件的第一个元素
         * $[expression]: 选择符合条件的最后一个元素
         * ![expression]: 可对集合中的元素挨个进行处理
         */

        // List 列表生成
        el("{1,2,3,4}", List.class);
        el("{{'a','b'},{'x','y'}}", List.class);

        // map 列表生成
        el("{name:'Nikola',dob:'10-July-1856'}", Map.class);
        el("{name:{first:'Nikola',last:'Tesla'},dob:{day:10,month:'July',year:1856}}", Map.class);

        // array 生成
        el("new int[]{1,2,3}", int[].class);

        // 对于集合可以配合#this变量进行过滤, 对于map, 可分别对keySet及valueSet分别使用key和value关键字;
        el("{1, 3, 5, 7}.?[#this > 3]", String.class);
        el("{1, 3, 5, 7}.^[#this > 3]", String.class);
        el("{1, 3, 5, 7}.$[#this > 3]", String.class);
        el("{1, 3, 5, 7}.![#this + 1]", String.class);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("map", map);
        // map
        el("#map.?[key > 3]", String.class, context);
        el("#map.?[value == 'A']", String.class, context);
        el("#map.?[key > 2 and key < 4]", String.class, context);

    }

    /**
     * 操作符：
     * 关系操作符, 包括: eq(==), ne(!=), lt()<, le(<=), gt(>), ge(>=)
     * 逻辑运算符, 包括: and(&&), or(||), not(!)
     * 数学操作符, 包括: 加(+), 减(-), 乘(*), 除(/), 取模(%), 幂指数(^)
     * 其他操作符, 如: 三元操作符, instanceof, 赋值(=), 正则匹配
     *
     */
    private static void operatorEl() {
        // 对象
        Person person = new Person("Ming", 18); // 一个普通的POJO
        EvaluationContext context = new StandardEvaluationContext();  // 表达式的上下文,
        context.setVariable("person", person);                        // 为了让表达式可以访问该对象, 先把对象放到上下文中

        // 关系操作符, 包括: eq(==), ne(!=), lt()<, le(<=), gt(>), ge(>=)
        el("1 > -1", Boolean.class);
        el("1 gt -1", Boolean.class);

        // 逻辑运算符, 包括: and(&&), or(||), not(!)
        el("true or true", Boolean.class);
        el("true || true", Boolean.class);

        // 数学操作符, 包括: 加(+), 减(-), 乘(*), 除(/), 取模(%), 幂指数(^)
        el("2 ^ 3", Integer.class);
        el("true ? true : false", Boolean.class);

        // 其他操作符, 如: 三元操作符, instanceof, 赋值(=), 正则匹配
        el("#name ?: 'default'",  String.class);
        // instanceof,
        el("1 instanceof T(Integer)", Boolean.class);
        // 正则匹配
        el("'5.00' matches '^-?\\d+(\\.\\d{2})?$'", Boolean.class);
         // 赋值操作： = 赋值操作
        el("#person.name", String.class, context);
        el("#person.name = 'Jim'", String.class, context);
        el("#person.name", String.class, context);
    }

    /**
     * 属性可直接使用属性名,属性名首字母大小写均可(只有首字母可不区分大小写);
     * 数组、列表可直接通过下表形式(list[index])访问;
     * map可以直接把key当成索引来访问(map[key]);
     * 方法可以直接访问;
     *
     */
    private static void instanceMapListArrayEl() {
        // 对象
        Person person = new Person("Ming", 18); // 一个普通的POJO
        // 列表
        List<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        // 数组
        String[] array = new String[]{"aa", "bb"};
        // Map
        Map<String, String> map = new HashMap<>();
        map.put("A", "1");
        map.put("B", "2");

        EvaluationContext context = new StandardEvaluationContext();  // 表达式的上下文,
        context.setVariable("person", person);                        // 为了让表达式可以访问该对象, 先把对象放到上下文中
        context.setVariable("map", map);
        context.setVariable("list", list);
        context.setVariable("array", array);

        // 读取对象属性：  属性访问
        el("#person.name", String.class, context);
        el("#person.Name", String.class, context);
        // 调用属性的方法
        el("#person.getAge()", Integer.class, context);

        // 读取列表值
        el("#list[0]", String.class, context);
        // 读取数组的值
        el("#array[0]", String.class, context);
        // 读取map值
        el("#map[A]", String.class, context);
        // 读取map的大小
        el("#map.size()", String.class, context);

        // 使用字符串的方法
        el("'Hello World'.concat('!')", String.class);
    }

    /**
     *  获取变量值：通过 # 获取变量值
     */
    private static void variableEl() {
        String val = "hello";
        EvaluationContext context = new StandardEvaluationContext();  // 表达式的上下文,
        context.setVariable("val", val);                        // 为了让表达式可以访问该对象, 先把对象放到上下文中
        ExpressionParser parser = new SpelExpressionParser();
        // 访问变量
        String msg = parser.parseExpression("#val").getValue(context, String.class);   // Tom , 使用变量
        System.out.println("原始数据 #val  --> "  + msg);
    }

    /**
     * 文字表达式
     */
    private static void textEl() {
        // 纯字符串，带使用单引号('')包围，只有字符串是带''，其他的表达式不带''
        el("'Hello World'", String.class);
        // 两个字符串使用 + 拼接
        el("'Hello World' + ' pingjie'", String.class);

        // 指数形式
        el("6.0221415E+23", double.class);
        el("1.024E+3", double.class);
        // 十六进制
        el("0xFFFF", int.class);
        // 布尔值
        el("true", boolean.class);
        // null
        el("null", Object.class);
    }

    public static  <T>  void el(String originalText, T a){
        el(originalText, a, null);
    }
    public static  <T>  void el(String originalText, T a,  EvaluationContext context ){
        el(originalText, a, context, null);
    }
    public static  <T>  void el(String originalText, T a,  EvaluationContext context, ParserContext pc){
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = null;
        if(pc != null) {
            exp = parser.parseExpression(originalText, pc);
        }else {
            exp = parser.parseExpression(originalText);
        }

        T message;
        if(context != null){
            message = (T) exp.getValue(context);
        }else{
            message = (T) exp.getValue();
        }

        System.out.println("原始数据 " + originalText + " --> "  + message);
    }

}
