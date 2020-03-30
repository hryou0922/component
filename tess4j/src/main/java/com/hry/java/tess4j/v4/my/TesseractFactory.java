package com.hry.java.tess4j.v4.my;

import net.sourceforge.tess4j.Tesseract;

public class TesseractFactory {


    public static Tesseract createTesseract(){
        Tesseract tessreact = new Tesseract();

        /**
         * 设置语言库:
         * 下载地址：https://github.com/tesseract-ocr/tessdata
         *
         */
        tessreact.setDatapath(System.getProperty("user.dir") + "/tess4j/src/main/resources/com/hry/java/tess4j/v4/tessdata/");
        // 设置识别语言，默认为英文：可配置多个语言版本，如
        tessreact.setLanguage("chi_sim");

        System.out.println(System.getProperty("user.dir") + "/tess4j/src/main/resources/com/hry/java/tess4j/v4/tessdata/");
        return tessreact;

    }

}
