package com.hry.component.thumbnailator.simple;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

/**
 *
 * 官方的例子：
 *  https://github.com/coobird/thumbnailator/wiki/Examples
 * Created by huangrongyou@yixin.im on 2018/4/3.
 */
public class SimpleExample {
    private String imgDir; // 测试图片的目录
    private String imgFile;   // 测试图片地址
    private String waterImgFile; // 水印图片地址
    private String saveDir;  // 保存的目录

    public SimpleExample(String saveDir) throws IOException {
        // 测试图片地址
   //     imgFile =  Thread.currentThread().getContextClassLoader().getResource("").getPath() + "/com/hry/component/thumbnailator/simple/airplane.jpg";
        File f = new File("src");
        this.imgDir = f.getAbsolutePath() + "/main/resources/com/hry/component/thumbnailator/simple/";
        imgFile =  imgDir + "airplane.jpg";
        waterImgFile = imgDir + "water.jpg";

        // 保存的目录
        if(StringUtils.isEmpty(saveDir)){
            this.saveDir = "d:/tmp";
        }else {
            this.saveDir = saveDir;
        }
        printlnImageInfo(imgFile);
        System.out.println("\r\n\n");
    }

    /**
     * 按照指定大小进行缩放
     */
    public void reSize() throws IOException {
        /*
         * 若图片横比200小，高比300小，不变
         * 若图片横比200小，高比300大，高缩小到300，图片比例不变
         * 若图片横比200大，高比300小，横缩小到200，图片比例不变
         * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
         *
         *
         */
        System.out.println("==========按照指定大小进行缩放============");
        String destFile = saveDir + "/reSize-small.jpg";
        Thumbnails.of(imgFile)
                .size(200, 300) //  如果在size()指定比例和原图片大小比例不一致，会自动进行调准，如这里实际输出的大小为 200 * 160
                .toFile(destFile);
        printlnImageInfo(destFile);

        destFile = saveDir + "/reSize-big.jpg";
        Thumbnails.of(imgFile)
                .size(2560, 2048) // 如果在size()指定比例和原图片大小比例不一致，会自动进行调准，如这里实际输出的大小为 2560 * 2048
                .toFile(destFile);
        printlnImageInfo(destFile);
        System.out.println("\r\n");
    }

    /**
     * 按照指定比例进行缩放
     */
    public void scale() throws IOException {
        System.out.println("==========按照指定比例进行缩放============");
        String destFile = saveDir + "/scale-small.jpg";
        Thumbnails.of(imgFile)
                .scale(0.25f)
                .toFile(destFile);
        printlnImageInfo(destFile);

        destFile = saveDir + "/scale-big.jpg";
        Thumbnails.of(imgFile)
                .scale(2.0f)
                .toFile(destFile);
        printlnImageInfo(destFile);
        System.out.println("\r\n");
    }

    /**
     * 不按照比例，强制指定大小进行缩放
     *  这里和reSize()方法不同的地方
     */
    public void forceReSize() throws IOException {
        System.out.println("==========不按照比例，强制指定大小进行缩放 ============");
        String destFile = saveDir + "/forceReSize-small.jpg";
        Thumbnails.of(imgFile)
                .size(200, 300) //  不按照比例，强制指定大小进行缩放，如这里实际输出的大小为 200 * 300
                .keepAspectRatio(false)
                .toFile(destFile);
        printlnImageInfo(destFile);

        destFile = saveDir + "/forceReSize-big.jpg";
        Thumbnails.of(imgFile)
                .size(2560, 2048) // 不按照比例，强制指定大小进行缩放，如这里实际输出的大小为 2560 * 2048
                .keepAspectRatio(false)
                .toFile(destFile);
        printlnImageInfo(destFile);
        System.out.println("\r\n");
    }

    /**
     * 对图片进行旋转
     * rotate(角度),正数：顺时针 负数：逆时针
     * @throws IOException
     */
    public void rotate() throws IOException {
        System.out.println("==========对图片进行旋转============");
        String destFile = saveDir + "/rotate-small.jpg";
        Thumbnails.of(imgFile)
                .scale(0.25f)
                .rotate(180)
                .toFile(destFile);
        printlnImageInfo(destFile);

        destFile = saveDir + "/rotate-big.jpg";
        Thumbnails.of(imgFile)
                .scale(2.0f)
                .rotate(-90)
                .toFile(destFile);
        printlnImageInfo(destFile);
        System.out.println("\r\n");
    }

    /**
     * 为图片增加水印: 位置，水印图，透明度
     * @throws IOException
     */
    public void watermark() throws IOException {
        System.out.println("==========为图片增加水印============");
        String destFile = saveDir + "/water-small.jpg";
        Thumbnails.of(imgFile)
                .scale(0.25f)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(waterImgFile)), 0.5f)
                .outputQuality(0.8f)
                .toFile(destFile);
        printlnImageInfo(destFile);

        destFile = saveDir + "/water-big.jpg";
        Thumbnails.of(imgFile)
                .scale(2.0f)
                .watermark(Positions.CENTER, ImageIO.read(new File(waterImgFile)), 0.5f)
                .outputQuality(0.8f)
                .toFile(destFile);
        printlnImageInfo(destFile);
        System.out.println("\r\n");
    }

    /**
     * 对图片进行裁剪
     * @throws IOException
     */
    public void sourceRegion() throws IOException {
        System.out.println("========== 对图片进行裁剪============");
        String destFile = saveDir + "/sourceRegion-center.jpg";
        Thumbnails.of(imgFile)
                .sourceRegion(Positions.CENTER, 100,100)
                .size(200, 200)
                .keepAspectRatio(false)
                .toFile(destFile);
        printlnImageInfo(destFile);

        destFile = saveDir + "/sourceRegion-right.jpg";
        Thumbnails.of(imgFile)
                .sourceRegion(Positions.BOTTOM_RIGHT, 100,100)
                .size(200, 200)
                .keepAspectRatio(false)
                .toFile(destFile);
        printlnImageInfo(destFile);

        destFile = saveDir + "/sourceRegion-custom.jpg";
        Thumbnails.of(imgFile)
                .sourceRegion(200, 300, 100, 100)
                .size(200, 200)
                .keepAspectRatio(false)
                .toFile(destFile);
        printlnImageInfo(destFile);


        System.out.println("\r\n");
    }

    /**
     * 转化图片格式
     * 支持的图片格式有：
     *   1 = "jpg"
         2 = "bmp"
         3 = "BMP"
         4 = "gif"
         5 = "GIF"
         6 = "WBMP"
         7 = "png"
         8 = "PNG"
         9 = "jpeg"
         10 = "wbmp"
         11 = "JPEG"
     * @throws IOException
     */
    public void outputFormat() throws IOException {
        System.out.println("==========转化图片格式============");
        //  size = 120 = "JPG"

        String destFile = saveDir + "/outputFormat.png";
        Thumbnails.of(imgFile)
                .scale(1.0f)
                .outputFormat("png")
                .toFile(destFile);
        printlnImageInfo(destFile);

        System.out.println("\r\n");
    }

    /**
     * 对文件夹所有图片进行操作
     * @throws IOException
     */
    public void listFilesChange() throws IOException {
        System.out.println("==========对文件夹所有图片进行操作============");
        Thumbnails.of(new File(imgDir).listFiles())
                .scale(1.0f)
                .outputFormat("png")
                .toFiles(new File(saveDir),Rename.PREFIX_DOT_THUMBNAIL); // 生成文件的前缘为thumbnail

        System.out.println("\r\n");
    }

    /**
     * 打印图片信息
     * @param imgFile
     * @throws IOException
     */
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
