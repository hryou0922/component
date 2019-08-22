## 这个工程使用的Spring Boot 2 以上的版本

## 算法
- com.hry.algorithm
    - recursive 递归算法
        - NQueen/NQueenII： 八皇后问题
    - sort：八大排序算法： https://cloud.tencent.com/developer/article/1114692
        - letcode: https://leetcode.com/problems/sort-an-array/submissions/
        - 插入排序:InsertSort （队列分为两部分，左边是已经排序好的，从右边未排序队列中获取值，并按照顺序插入左边队列中）
        - 希尔排序: ShellSort （记录按下标的一定增量分组，对每组使用直接插入排序算法排序）
        - 选择排序: SelectionSort（从未排序的队列中选取一个最小/大值）
        - 冒泡排序: BubbleSort（重复比较相邻的两个值）
        - 归并排序
        - 快速排序
        - 堆排序
        - 基数排序
          

## apache: apache中通用的组件用法
- com.hry.java.apache
	- beanutils
		- BeanUtilTest：BeanUtil的常用操作方法
		- ConstructorUtilsTest：预留
		- ConverterTest：注册转换类
		- PropertyUtilsTest：类似BeanUtil
    - io: io操作demo
        - FilenameUtilsDemo: 对文件名、文件路径、文件扩展名操作的封装
        - FileUtils：对文件操作
            - 文件：复制、移动
            - 文件：把字符串列表、字符串、字节数组写入文件；读取文件到字符串列表、字符串、字节数组
            - 文件夹：创建、复制、删除、清空
            - 其他：获取临时文件、文件夹、文件大小、文件的修改时间修改和比较
    - lang3
		- ArrayUtilsTest：对数组进行操作类
	    - DateUtilsTest: 日期操作工具类
		- RandomStringUtilsTest：生成随机字符串
		- RandomUtilsTest：生成随机数字
		- SerializationUtilsTest: 序列化操作
		- StringEscapeUtilsTest: 对各种语言中的非法字符串进行加密解密
		- StringUtilsTest：对字符串操作
		- SystemUtilsTest：获取环境变量，包括预先定义的Java的环境变量
		- ValidateTest: 对输入的数据进行合法性检查

## fastjson
- com.hry.java.fastjson
    - serializer
	    - VO：序列化和各种注解使用; 序列化; 定义key名称，定义字段顺序，格式化时间
	- simple
		- SimpleMain：最简单的应用
## guava : guava的基本用法
    
## javabasic: jdk的基本用法 
- com.hry.java
    - cls: class的反射用法
    - consistencyhash: 一致性哈希散列函数的实现
    - concurrent: 多线程用法
        - Semaphore信号量用法
    - lambda: lambda的用法 
        - CollectorsDemo
            - 过滤：按照给定的要求对集合进行筛选满足条件的元素，java8提供的筛选操作包括：filter、distinct、limit、skip
            - 映射：仅输出需要的字段数据。主要包含两类映射操作：map和flatMap。
                - map:扩展方法有mapToDouble、mapToInt、mapToLong
                - flatMap:与map的区别在于 flatMap是将一个流中的每个值都转成一个个流，然后再将这些流扁平化成为一个流
                    - 扩展方法：flatMapToDouble、flatMapToInt、flatMapToLong
            - 查找：match。allMatch、anyMatch、noneMatch、findFirst、findAny
            - 归约: reduce。对经过参数化操作后的集合进行进一步的运算
            - collect 归约操作
                - 简单的收集操作，是对处理结果的封装：Collectors.toList、Collectors.toSet、Collectors.toMap
                -  计算列表数量：Collectors.counting() 或stream().count()
                -  最大年龄：(Collectors.maxBy
                -  最小年龄：Collectors.minBy
                -  列表值相加：Collectors.summingInt
                -  一次性得到元素个数、总和、均值、最大值、最小值: IntSummaryStatistics
                -  字符串拼接：Collectors.joining()
            - collect 分组 操作
                - 对列表进行分组，并可对分组进行操作：Collectors.groupingBy
            - collect 分区 操作
                - 分区可以看做是分组的一种特殊情况，在分区中key只有两种情况：true或false：Collectors.partitioningBy
        - StreamsEffectivenessDemo：测试串行和并行stream的执行时间，两者相差一倍
    - path：java中各类路径用法
        - JavaBasePathMain: Java获取本地路径的多种方式
    - regular: 正则表达式的用法
        - NumberRegular： 从字符串中过滤出数字，或相反的操作
        - PatternDemo:  Pattern实例是不可变的，可线程安全; Matcher不支持并发请求
    - unsafe
        - Unsafe类的用法演示
    - utils: 工作类
        - DateUtils：时间格式化操作类，时间操作类
    - xml: JAXB：实现xml和java对象互转
        - JAXBManager：基本用法，演示@XmlRootElement，@XmlAccessorType，@XmlElement用法
        - JAXBManager：演示 @XmlAttribute， @XmlJavaTypeAdapter，XmlAdapter用法
## httpclient: httpclient的用法
- com.hry.java.httpclient.
    - example
        - CloseableHttpClientGetTest: 模拟get请求
        - CloseableHttpClientGetWithParameterTest: 带参数的get请求
        - CloseableHttpClientPostTest: 模拟post请求 -- 未实现
        - 异常HttpAsyncClients、https、Post、Get的方法的应用
    - httpclient45
    	- example：官方例子
    	- 其他后续再做：requestConfig、连接池、cookie、模拟登录、代理、Chunk、Credentials、POST/GET、form, request、SSL、文件上传
## jsoup: jsoup用法 
- 详细的用法见博客[Jsoup使用总结](https://blog.csdn.net/hry2015/article/details/72904416)
## lua：lua的脚本用法

## netty: netty的用法总结
- com.hry.java.netty
    - 通过客户端和服务端模拟netty通信
## tess4j:  文字、图片的文字识别
- com.hry.java.tess4j:
    - TesseractChinesePdfTest: OCR解析PDF中文文档
	- TesseractChineseTest: OCR解析中文图片截图
	- TesseractPdfTest：OCR解析pdf英文文档
	- TesseractTest：OCR解析图片
# thumbnailator:生成图像缩略图
- thumbnailator是一个用来生成图像缩略图的Java类库
- com.hry.java.thumbnailator.simple： 演示组件对图片如下的操作
    - 指定大小进行缩放
    - 按照指定比例进行缩放
    - 不按照比例，强制指定大小进行缩放
    - 对图片进行旋转
    - 为图片增加水印
    - 对图片进行裁剪
    - 转化图片格式
    - 对文件夹所有图片进行操作
## zookeeper: zookeeper的用法
- com.hry.java.zookeeper：暂时没试试
    - 1


