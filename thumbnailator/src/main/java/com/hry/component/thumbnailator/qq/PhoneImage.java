package com.hry.component.thumbnailator.qq;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PhoneImage {
    private static final int num = 16;
    private static final List<Future> futureList = new ArrayList<Future>(num);
    private static final ExecutorService executorService = Executors.newFixedThreadPool(num);

    public static void execute(String imgDir) throws IOException {
        File[] dir = new File(imgDir).listFiles();
        for(File file : dir){
            if(file.getAbsolutePath().endsWith("rar")
                    || file.getAbsolutePath().endsWith("swf")){
                continue;
            }
            if(file.isDirectory()){
                execute(file.getAbsolutePath());
            }else{
                Future future = executorService.submit(()-> {
                    try {
                        printlnImageInfo(file.getAbsolutePath());
                        String outFile = file.getAbsolutePath().replaceAll("input","output");

                        File out = new File(outFile);
                        out.getParentFile().mkdirs();
                        Thumbnails.of(file)
                                // .size(1024, 1024)
                                .scale(0.6)
                                .toFile(out);
                        printlnImageInfo(outFile);
                        System.out.println();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                futureList.add(future);

                if(futureList.size() > num){
                    while (true) {
                        try {
                            Iterator<Future> futureIterator = futureList.iterator();
                            while (futureIterator.hasNext()) {
                                Future newFuture = futureIterator.next();
                                if (newFuture.isDone()) {
                                    futureIterator.remove();
                                }
                            }
                            if (futureList.size() > num) {
                                Thread.sleep(500);
                            }else {
                                break;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String imgDir; // 测试图片的目录
        imgDir = "C:/Users/hry/Desktop/tmp/today/input/";

        execute(imgDir);

    }

    public static void printlnImageInfo(String imgFile) throws IOException {
        System.out.println("= 文件[" + imgFile + "]信息如下:=");
        File srcFileJPG = new File(imgFile);
        long srcFileSizeJPG = srcFileJPG.length();
        // 计算宽高
        BufferedImage bim = ImageIO.read(srcFileJPG);
        int srcWdith = bim.getWidth();
        int srcHeigth = bim.getHeight();
        System.out.println("width = " + srcWdith+ " heigh = " + srcHeigth + " 文件大小 = " + srcFileSizeJPG/1024 + "k");
    }
}
