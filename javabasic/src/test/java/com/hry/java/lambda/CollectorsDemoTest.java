package com.hry.java.lambda;

import com.hry.java.lambda.model.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectorsDemoTest {
    private CollectorsDemo collectorsDemo;
    private  List<Student> studentList; // 测试数据
    private List<Integer> nums;

    @Before
    public void init(){
        collectorsDemo = new CollectorsDemo();
        // 数据
        studentList = new ArrayList<Student>();
        studentList.add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
        studentList.add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
        studentList.add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
        studentList.add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
        studentList.add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
        studentList.add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
        studentList.add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
        studentList.add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
        studentList.add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
        studentList.add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));

        //
        nums = Arrays.asList(1,2,3,4,5,6,7,8);
    }


//    @Test
//    public void test(){
//        collectorsDemo.test(studentList);
//    }

    @Test
    public void filter(){
        collectorsDemo.filter(studentList, nums);
    }

    @Test
    public void map(){
        collectorsDemo.map(studentList);
    }

    @Test
    public void match(){
        collectorsDemo.match(studentList);
    }

    @Test
    public void reduce(){
        collectorsDemo.reduce(studentList);
    }

    @Test
    public void collect_reduce(){
        collectorsDemo.collect_reduce(studentList);
    }

    @Test
    public void collect_group(){
        collectorsDemo.collect_group(studentList);
    }

    @Test
    public void collect_partitioning(){
        collectorsDemo.collect_partitioning(studentList);
    }
}
