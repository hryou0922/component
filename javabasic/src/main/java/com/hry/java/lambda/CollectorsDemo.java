package com.hry.java.lambda;

import com.hry.java.lambda.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 归约
 * collect(Collectors.toList())
 */
public class CollectorsDemo {

    public void test(List<Student> students){
        // 计算总数
        List<String> names = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getName).collect(Collectors.toList());
        System.out.println("names" + names);

        // 归约操作
        int totalAge = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getAge)
                .reduce(0, (a, b) -> a + b);
        System.out.println("totalAge="+totalAge);
        // 进一步简化
        int totalAge2 = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getAge)
                .reduce(0, Integer::sum);

        // 采用无初始值的重载版本，需要注意返回Optional
        Optional<Integer> totalAge3 = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getAge)
                .reduce(Integer::sum);  // 去掉初始值
    }




}
