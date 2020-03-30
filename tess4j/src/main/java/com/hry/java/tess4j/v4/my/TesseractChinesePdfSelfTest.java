package com.hry.java.tess4j.v4.my;

import com.hry.java.tess4j.v4.TesseractUtil;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageIOHelper;
import net.sourceforge.tess4j.util.PdfUtilities;
import org.apache.commons.io.FileUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 中文识别
 * @author Administrator
 *
 */
public class TesseractChinesePdfSelfTest {
	public static void main(String[] args) {
		// user.dir = D:\eclipse_study\simpletool
	//	File root = new File("C:\\Users\\Administrator\\Desktop\\tmp\\other\\ocr");
		File root = new File("C:\\Users\\hry\\Desktop\\tmp\\other\\ocr");
		System.out.println(root.getAbsolutePath());

		Tesseract tesseract = TesseractFactory.createTesseract();
		try {
			List<String> arrayList = new ArrayList<>();
			File[] files = root.listFiles();
			for (File file : files) {
				System.out.println("==" + file.getAbsolutePath());
				File[] pngFileList = PdfUtilities.convertPdf2Png(file);
				for(File pngFile : pngFileList){
					System.out.println("==1--" + pngFile.getAbsolutePath());
					BufferedImage bufferedImage = TesseractUtil.optimizeImage(pngFile.getAbsolutePath());
					String result = tesseract.doOCR(bufferedImage);
					System.out.println("result" + result);

					String fileName = file.toString().substring(
							file.toString().lastIndexOf("\\") + 1);
					result = result.replaceAll(" ","").replaceAll("\\r","")
							.replaceAll("\\n","");
							System.out.println("图片名：" + fileName + " 识别结果：" );
							System.out.println();
					arrayList.add(result);
					arrayList.add("\\n");
				}
			}

			File saveFile = new File("C:\\Users\\hry\\Desktop\\tmp\\today\\ocr.txt");
			FileUtils.writeLines(saveFile, arrayList);
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
