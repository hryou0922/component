package com.hry.java.tess4j.v4;

import net.sourceforge.tess4j.util.ImageHelper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by huangrongyou@yixin.im on 2018/10/9.
 */
public class TesseractUtil {

    /**
     * 优化图片
     * @param filePath
     * @return
     * @throws IOException
     */
    public static BufferedImage optimizeImage(String filePath){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(filePath));
            //按指定宽高创建一个图像副本
            //image = ImageHelper.getSubImage(image, 0, 0, image.getWidth(), image.getHeight());
            //图像转换成灰度的简单方法 - 黑白处理
            image = ImageHelper.convertImageToGrayscale(image);
            // 图片放大倍数,增强识别率 - 放大n倍图像
            image = ImageHelper.getScaledInstance(image, image.getWidth() * 3, image.getHeight() * 3);
            // 图片锐化
            image = ImageHelper.convertImageToBinary(image);

//        Tesseract instance = new Tesseract();
//        instance.setDatapath(System.getProperty("user.dir"));//设置训练库的位置
//        instance.setLanguage("chi_sim");//中文识别
//        //instance.setLanguage("eng");//英文识别
//        result = instance.doOCR(textImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
