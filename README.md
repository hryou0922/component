## 这个工程使用的Spring Boot 2 以上的版本

## apache: apache中通用的组件用法
- com.hry.component.apache
	- beanutils
		- BeanUtilTest：BeanUtil的常用操作方法
		- ConstructorUtilsTest：预留
		- ConverterTest：注册转换类
		- PropertyUtilsTest：类似BeanUtil
    - io: io操作demo
        - TODO
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
- com.hry.component.fastjson
    - serializer
	    - VO：序列化和各种注解使用; 序列化; 定义key名称，定义字段顺序，格式化时间
	- simple
		- SimpleMain：最简单的应用
## javabasic: jdk的基本用法 
- com.hry.java
    - cls: class的反射用法
    - consistencyhash: 一致性哈希散列函数的实现
    - multithread: 多线程用法
        - Semaphore信号量用法
    - path：java中各类路径用法
        - JavaBasePathMain: Java获取本地路径的多种方式
    - regular: 正则表达式的用法
        - NumberRegular： 从字符串中过滤出数字，或相反的操作
    - unsafe
        - Unsafe类的用法演示
## httpclient: httpclient的用法
- com.hry.component.httpclient.
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
- com.hry.component.netty
    - 通过客户端和服务端模拟netty通信
## tess4j:  文字、图片的文字识别
- com.hry.component.tess4j:
    - TesseractChinesePdfTest: OCR解析PDF中文文档
	- TesseractChineseTest: OCR解析中文图片截图
	- TesseractPdfTest：OCR解析pdf英文文档
	- TesseractTest：OCR解析图片
## zookeeper: zookeeper的用法
- com.hry.component.zookeeper：暂时没试试
    - 1


