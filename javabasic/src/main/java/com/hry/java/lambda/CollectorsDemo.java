package com.hry.java.lambda;

import com.hry.java.lambda.model.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 过滤：按照给定的要求对集合进行筛选满足条件的元素，java8提供的筛选操作包括：filter、distinct、limit、skip
 * 映射：仅输出需要的字段数据。主要包含两类映射操作：map和flatMap。
 *  map:扩展方法有mapToDouble、mapToInt、mapToLong
 *  flatMap:与map的区别在于 flatMap是将一个流中的每个值都转成一个个流，然后再将这些流扁平化成为一个流
 *      扩展方法：flatMapToDouble、flatMapToInt、flatMapToLong
 *  查找：match。allMatch、anyMatch、noneMatch、findFirst、findAny
 *  归约: reduce。对经过参数化操作后的集合进行进一步的运算
 * collect 归约操作
 *      简单的收集操作，是对处理结果的封装：Collectors.toList、Collectors.toSet、Collectors.toMap
 *      计算列表数量：Collectors.counting() 或stream().count()
 *      最大年龄：(Collectors.maxBy
 *      最小年龄：Collectors.minBy
 *      列表值相加：Collectors.summingInt
 *      一次性得到元素个数、总和、均值、最大值、最小值: IntSummaryStatistics
 *      字符串拼接：Collectors.joining()
 * collect 分组 操作
 *      对列表进行分组，并可对分组进行操作：Collectors.groupingBy
 * collect 分区 操作
 *      分区可以看做是分组的一种特殊情况，在分区中key只有两种情况：true或false：Collectors.partitioningBy
 *
 */
public class CollectorsDemo {


    /**
     * 按照给定的要求对集合进行筛选满足条件的元素，java8提供的筛选操作包括：filter、distinct、limit、skip
     * @param students
     */
    public void filter(List<Student> students, List<Integer> nums){
        // filter 定义筛选条件
        List<Student> whuStudents = students.stream()
                .filter(student -> "武汉大学".equals(student.getSchool()))
                .collect(Collectors.toList());
        System.out.println("filter武汉大学:" + whuStudents);

        // distinct: distinct操作类似于我们在写SQL语句时，添加的DISTINCT关键字，用于去重处理
        List<Integer> evens = nums.stream()
                .filter(num -> num % 2 == 0).distinct()
                .collect(Collectors.toList());
        System.out.println("DISTINCT唯一值 :" + evens);

        // limit操作也类似于SQL语句中的LIMIT关键字，不过相对功能较弱，limit返回包含前n个元素的流，当集合大小小于n时，则返回实际长度
        List<Student> civilStudents = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor())).limit(2)
                .collect(Collectors.toList());
        System.out.println("limit 2: " + civilStudents);

        // skip操作与limit操作相反，是跳过前n个元素，比如我们希望找出排序在2之后的土木工程专业的学生
        List<Student> civilStudentSkips = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor()))
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("skip 2: " + civilStudentSkips);
    }

    /**
     * 映射
     * 仅输出需要的字段数据
     * 主要包含两类映射操作：map和flatMap
     * @param students
     */
    public void map(List<Student> students){
        // map 假设我们希望筛选出所有专业为计算机科学的学生姓名，那么我们可以在filter筛选的基础之上，通过map将学生实体映射成为学生姓名字符串。还有其他 mapToDouble(ToDoubleFunction<? super T> mapper)，mapToInt(ToIntFunction<? super T> mapper)，mapToLong(ToLongFunction<? super T> mapper)
        List<String> names = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getName).collect(Collectors.toList());
        System.out.println("map: " + names);

        // 将Student按照年龄直接映射为IntStream，调用提供的sum()进行总和计算
        int totalAge = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .mapToInt(Student::getAge).sum();
        System.out.println("mapToInt totalAge: " + totalAge);

        // flatMap: flatMap与map的区别在于 flatMap是将一个流中的每个值都转成一个个流，然后再将这些流扁平化成为一个流
        String[] strs = {"java8", "is", "easy", "to", "use"};
        // 输出构成这一数组的所有非重复字符
        List<String> distinctStrs = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>
                .flatMap(Arrays::stream)  // 扁平化为Stream<String>
                .distinct()
                .collect(Collectors.toList());
        System.out.println("flatMap: distinctStrs" + distinctStrs);
        // flatMap将由map映射得到的Stream<String[]>，转换成由各个字符串数组映射成的流Stream<String>，再将这些小的流扁平化成为一个由所有字符串构成的大流Steam<String>，从而能够达到我们的目的。与map类似，flatMap也提供了针对特定类型的映射操作：flatMapToDouble(Function<? super T,? extends DoubleStream> mapper)，flatMapToInt(Function<? super T,? extends IntStream> mapper)，flatMapToLong(Function<? super T,? extends LongStream> mapper)。

    }

    /**
     * 查找操作
     * @param students
     */
    public void match(List<Student> students){
        // allMatch用于检测是否全部都满足指定的参数行为，如果全部满足则返回true
        boolean isAdult = students.stream().allMatch(student -> student.getAge() >= 18);
        System.out.println("allMatch： isAdult " + isAdult);

        // anyMatch则是检测是否存在一个或多个满足指定的参数行为，如果满足则返回true
        boolean hasWhu = students.stream().anyMatch(student -> "武汉大学".equals(student.getSchool()));
        System.out.println("anyMatch： hasWhu " + hasWhu);

        // noneMatch用于检测是否不存在满足指定行为的元素，如果不存在则返回true
        boolean noneCs = students.stream().noneMatch(student -> "计算机科学".equals(student.getMajor()));
        System.out.println("noneMatch： noneCs " + noneCs);

        // findFirst用于返回满足条件的第一个元素
        Optional<Student> optStu = students.stream().filter(student -> "土木工程".equals(student.getMajor())).findFirst();
        System.out.println("findFirst: " + optStu);

        // findAny相对于findFirst的区别在于，findAny不一定返回第一个，而是返回任意一个
        Optional<Student> optStu2 = students.stream().filter(student -> "土木工程".equals(student.getMajor())).findAny();
        System.out.println("findAny: " + optStu2);
    }


    /**
     * 归约: reduce
     *  对经过参数化操作后的集合进行进一步的运算，那么我们可用对集合实施归约操作
     * @param students
     */
    public void reduce(List<Student> students){
        // 归约操作
        int totalAge = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getAge)
                .reduce(0, (a, b) -> a + b);
        System.out.println("reduce: totalAge=" + totalAge);
        // 进一步简化
        int totalAge2 = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getAge)
                .reduce(0, Integer::sum);
        System.out.println("reduce: totalAge2=" + totalAge2);

        // 采用无初始值的重载版本，需要注意返回Optional
        Optional<Integer> totalAge3 = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getAge)
                .reduce(Integer::sum);  // 去掉初始值
        System.out.println("reduce: totalAge3=" + totalAge3);

    }

    /**
     * collect 归约 操作
     *  一个简单的收集操作，是对处理结果的封装，对应的还有toSet、toMap，以满足我们对于结果组织的需求。这些方法均来自于java.util.stream.Collectors，我们可以称之为收集器
     * @param students
     */
    public void collect_reduce(List<Student> students){
        // 归约: 收集器也提供了相应的归约操作，但是与reduce在内部实现上是有区别的，收集器更加适用于可变容器上的归约操作，这些收集器广义上均基于Collectors.reducing()实现

        // 求学生的总人数
        long count = students.stream().collect(Collectors.counting());
        // 进一步简化
        // long count = students.stream().count();
        System.out.println("Collectors.counting(): " + count);

        // 求最大年龄
        Optional<Student> olderStudent = students.stream().collect(Collectors.maxBy((s1, s2) -> s1.getAge() - s2.getAge()));
        System.out.println("Collectors.maxBy " + olderStudent);
        // 进一步简化
        Optional<Student> olderStudent2 = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));
        System.out.println("Collectors.maxBy "  + olderStudent2);
        // 求最小年龄
        Optional<Student> olderStudent3 = students.stream().collect(Collectors.minBy(Comparator.comparing(Student::getAge)));
        System.out.println("Collectors.minBy " + olderStudent3);

        // 求年龄总和
        int totalAge4 = students.stream().collect(Collectors.summingInt(Student::getAge));
        System.out.println("Collectors.summingInt " + totalAge4);

        // 求年龄的平均值
        double avgAge = students.stream().collect(Collectors.averagingInt(Student::getAge));
        System.out.println("Collectors.averagingInt " + avgAge);

        // 一次性得到元素个数、总和、均值、最大值、最小值: IntSummaryStatistics{count=10, sum=220, min=20, average=22.000000, max=24}
        IntSummaryStatistics statistics = students.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println("Collectors.summarizingInt " + statistics);

        // 字符串拼接
        // // 输出：孔明伯约玄德云长翼德元直奉孝仲谋鲁肃丁奉
        String names = students.stream().map(Student::getName).collect(Collectors.joining());
        System.out.println("Collectors.joining() " + names);
        // 输出：孔明, 伯约, 玄德, 云长, 翼德, 元直, 奉孝, 仲谋, 鲁肃, 丁奉
        String names2 = students.stream().map(Student::getName).collect(Collectors.joining(", "));
        System.out.println("Collectors.joining() " + names2);


    }

    /**
     * collect 分组 操作
     *  Collectors.groupingBy来操作集合
     * @param students
     */
    public void collect_group(List<Student> students){
        //按学校对上面的学生进行分组
        Map<String, List<Student>> groups = students.stream().collect(Collectors.groupingBy(Student::getSchool));
        System.out.println("Collectors.groupingBy " + groups);

        // 自定义分类器来实现需要的分类效果。上面演示的是一级分组，我们还可以定义多个分类器实现 多级分组，比如我们希望在按学校分组的基础之上再按照专业进行分组
        Map<String, Map<String, List<Student>>> groups2 = students.stream().collect(
                Collectors.groupingBy(Student::getSchool,  // 一级分组，按学校
                        Collectors.groupingBy(Student::getMajor)));  // 二级分组，按专业
        System.out.println("Collectors.groupingBy * 2" + groups2);

        // 实际上在groupingBy的第二个参数不是只能传递groupingBy，还可以传递任意Collector类型，比如我们可以传递一个Collector.counting，用以统计每个组的个数
        Map<String, Long> groups3 = students.stream().collect(Collectors.groupingBy(Student::getSchool, Collectors.counting()));
        System.out.println("Collectors.groupingBy " + groups3);

    }

    /**
     *  collect 分区 操作
     *      分区可以看做是分组的一种特殊情况，在分区中key只有两种情况：true或false，目的是将待分区集合按照条件一分为二，java8的流式处理利用ollectors.partitioningBy()方法实现分区
     * @param students
     */
    public void collect_partitioning(List<Student> students){
        // 分区相对分组的优势在于，我们可以同时得到两类结果，在一些应用场景下可以一步得到我们需要的所有结果，比如将数组分为奇数和偶数
        Map<Boolean, List<Student>> partition = students.stream().collect(Collectors.partitioningBy(student -> "武汉大学".equals(student.getSchool())));
        System.out.println("Collectors.partitioningBy " + partition);
    }

}
