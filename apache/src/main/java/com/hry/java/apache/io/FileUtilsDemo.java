package com.hry.java.apache.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 FileUtils用法：
 文件夹操作：
 1. 复制文件夹
 FileUtils.copyDirectory
 FileUtils.copyDirectoryToDirectory

 2. 清空和删除文件夹
 // 删除一个文件夹，包括文件夹和文件夹里面所有的文件
 FileUtils.deleteDirectory
 // 清空一个文件夹里面的所有的内容
 FileUtils.cleanDirectory
 // 如果file是文件夹，就删除文件夹及文件夹里面所有的内容。如果file是文件，就删除。如果某个文件/文件夹由于某些原因无法被删除，会抛出异常
 FileUtils.forceDelete
 // 删除一个文件，没有任何异常抛出, 如果file是文件夹，就删除文件夹及文件夹里面所有的内容。如果file是文件，就删除。
 FileUtils.deleteQuietly

 3. 创建文件夹
 // 参数为目录，此方法创建对应的目录
 FileUtils.forceMkdir
 // 参数为文件，此方法创建对应文件的父目录
 FileUtils.forceMkdirParent

 4. 文件操作：
 1). 复制文件
 //复制文件到另外一个文件或输出流
 FileUtils.copyFile
 //复制文件到一个指定的目录
 FileUtils.copyFileToDirectory
 //把输入流里面的内容复制到指定文件
 FileUtils.copyInputStreamToFile
 //把URL里面内容复制到文件。可以下载文件。可设计连接/读取超时时间
 FileUtils.copyURLToFile

 2). 文件移动
 //文件夹移动，文件夹在内的所有文件都将移动
 FileUtils.moveDirectory
 //文件夹移动到另外一个文件内部。boolean createDestDir：如果destDir文件夹不存在，是否要创建一个
 FileUtils.moveDirectoryToDirectory
 // 移动文件
 FileUtils.moveFile
 //把文件移动到另外一个文件内部。boolean createDestDir：如果destDir文件夹不存在，是否要创建一个
 FileUtils.moveFileToDirectory
 //移动文件或者目录到指定的文件夹内。 boolean createDestDir：如果destDir文件夹不存在，是否要创建一个
 FileUtils.moveToDirectory

 3). 把字符串列表、字符串、字节数组写入文件
 // 把字符串写入文件, 参数1：需要写入的文件，如果文件不存在，将自动创建。  参数2：需要写入的内容, 参数3：编码格式     参数4：是否为追加模式（ ture: 追加模式，把字符串追加到原内容后面）
 FileUtils.writeStringToFile
 // 把集合里面的内容写入文件. 参数1：目标文件，参数2：内容集合，参数3：是否为追加模式，参数4：编码方式，比如"UTF-8" ， 参数5：lineEnding每一行以什么结尾
 FileUtils.writeLines
 // 把字节数组写入文件，参数1：字节数组，参数2：是否为追加模式，参数3：数组开始写入的位置，参数4：写入的长度
 FileUtils.writeByteArrayToFile
 // 往文件里面写CharSequence内容。参数1：目标文件; 参数2：要写入的内容; 参数3:编码格式; 参数4：是否为追加模式
 FileUtils.write

 4). 读取文件
 //把文件读取到字节数组里面
 FileUtils.readFileToByteArray
 //把文件读取成字符串 ；Charset encoding：编码格式
 FileUtils.readFileToString
 //把文件读取成字符串 ；String encoding：编码格式
 FileUtils.readLines


 5.文件获取输入/输出流
 //获取输入流
 FileUtils.openInputStream
 //获取输出流
 FileUtils.openOutputStream

 6.测试两个文件的修改时间那个比较新/老
 // 判断file文件的修改是否比指定reference文件/date日期/timeMillis 毫秒值/新
 FileUtils.isFileNewer
 // 判断file文件的修改是否比指定reference文件/date日期/timeMillis 毫秒值/老
 FileUtils.isFileOlder


 7.其他
 //判断文件夹内是否包含某个文件或者文件夹
 FileUtils.directoryContains
 //获取文件或者文件夹的大小
 FileUtils.sizeOf
 //获取临时目录文件
 FileUtils.getTempDirectory
 //获取临时目录路径
 FileUtils.getTempDirectoryPath
 //获取用户目录文件
 FileUtils.getUserDirectory
 //获取用户目录路径
 FileUtils.getUserDirectoryPath
 //如果不存在,新建文件或者创建单级目录或者多级目录,如果存在,修改文件修改时间
 FileUtils.touch
 //比较两个文件内容是否相同
 FileUtils.contentEquals

 *
 *   参考文献：
 *      https://blog.csdn.net/zhaoyanjun6/article/details/54972773
 */
public class FileUtilsDemo {

    public static void directoryFunction(String directory, String file) throws IOException {
        //=== 创建文件夹,创建一个文件夹，如果由于某些原因导致不能创建，则抛出异常一次可以创建单级或者多级目录
        // 参数为目录，此方法创建对应的目录
        FileUtils.forceMkdir(new File(directory));
        // 参数为文件，此方法创建对应文件的父目录
        FileUtils.forceMkdirParent(new File(file));

        // === 复制文件夹
//        //复制文件夹（文件夹里面的文件内容也会复制），file1和file2平级。//参数1：文件夹； 参数2：文件夹
//        FileUtils.copyDirectory(file1, file2);
//        //复制文件夹到另一个文件夹。 file1是file2的子文件夹. 参数1：文件夹； 参数2：文件夹
//        FileUtils.copyDirectoryToDirectory(file1 , file2 );
//        //复制文件夹，带有文件过滤功能
//        FileUtils.copyDirectory(File srcDir, File destDir, FileFilter filter);

        // 清空和删除文件夹

    }
}
