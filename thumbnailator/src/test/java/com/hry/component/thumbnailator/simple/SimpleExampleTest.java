package com.hry.component.thumbnailator.simple;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by huangrongyou@yixin.im on 2018/4/3.
 */
public class SimpleExampleTest {
    private static SimpleExample  simpleExample;

    @BeforeClass
    public static void init() throws IOException {
        String saveDir = "d:/tmp";
        simpleExample = new SimpleExample(saveDir);
    }

    @Test
    public void reSize() throws IOException {
        // 指定大小进行缩放
        simpleExample.reSize();
    }

    @Test
    public void scale() throws IOException {
        // 按照指定比例进行缩放
        simpleExample.scale();
    }

    @Test
    public void forceReSize() throws IOException {
        // 不按照比例，强制指定大小进行缩放
        simpleExample.forceReSize();
    }

    @Test
    public void rotate() throws IOException {
        // 对图片进行旋转
        simpleExample.rotate();
    }

    @Test
    public void watermark() throws IOException {
        // 为图片增加水印
        simpleExample.watermark();
    }

    @Test
    public void sourceRegion() throws IOException {
        //  对图片进行裁剪
        simpleExample.sourceRegion();
    }


    @Test
    public void outputFormat() throws IOException {
        // 转化图片格式
        simpleExample.outputFormat();
    }

    @Test
    public void listFilesChange() throws IOException {
        // 对文件夹所有图片进行操作
        simpleExample.listFilesChange();
    }
}
