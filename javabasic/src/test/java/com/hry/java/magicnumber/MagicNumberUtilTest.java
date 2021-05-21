package com.hry.java.magicnumber;

import org.junit.Assert;
import org.junit.Test;
import sun.net.www.content.image.png;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/21 14:26
 */
public class MagicNumberUtilTest {

    @Test
    public void execute(){
        checkFileSuf("jpg.jpg", "jpg");
        checkFileSuf("png.png", "png");
    }

    /**
     * 根据魔数检查文件的类型
     * @param fileName
     * @param fileSuf
     */
    private void checkFileSuf(String fileName, String fileSuf) {
        File f = new File("src/main/resources/com/hry/java/magicnumber/" + fileName);
        try {
            FileInputStream fileInputStream = new FileInputStream(f);
            Assert.assertEquals(fileSuf, MagicNumberUtil.getFileType(fileInputStream));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
