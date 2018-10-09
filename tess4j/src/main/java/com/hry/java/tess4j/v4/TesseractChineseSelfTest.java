package com.hry.java.tess4j.v4;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * 中文识别
 * @author Administrator
 *
 */
public class TesseractChineseSelfTest {
	public static void main(String[] args) {
		// user.dir = D:\eclipse_study\simpletool
		File root = new File("C:\\Users\\Administrator\\Desktop\\tmp\\other\\ocr");
		System.out.println(root.getAbsolutePath());
		Tesseract tessreact = new Tesseract();
		
		/**
		 * 设置语言库: 
		 * 下载地址：https://github.com/tesseract-ocr/tessdata
		 * 
		 */
        tessreact.setDatapath(System.getProperty("user.dir") + "/tess4j/src/main/resources/com/hry/java/tess4j/tessdata/");
        // 设置识别语言，默认为英文
        tessreact.setLanguage("chi_sim");

		try {
			File[] files = root.listFiles();
			for (File file : files) {
				String result = tessreact.doOCR(file);
				String fileName = file.toString().substring(
						file.toString().lastIndexOf("\\") + 1);
				System.out.println("图片名：" + fileName + " 识别结果：" + result);
			}
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}
	}
}
