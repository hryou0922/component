package com.hry.java.apache.io;

import org.junit.Test;

public class FilenameUtilsDemoTest {

    @Test
    public void functionShow(){
        String fileDirectory = "D:/aa/bb/cc";
        String fileName = "file.txt";
        FilenameUtilsDemo.functionShow(fileDirectory, fileName);
    }

    @Test
    public void functionShow2(){
        String fileDirectory = "D:/aa/bb/cc";
        String fileName = "file";
        FilenameUtilsDemo.functionShow(fileDirectory, fileName);
    }
}
