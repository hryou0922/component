package com.hry.java.tess4j.v4.my;


import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageIOHelper;
import net.sourceforge.tess4j.util.PdfUtilities;
import org.apache.commons.io.FileUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PdfUtilitiesTest {


    public static void main(String[] args) throws TesseractException, IOException {
        String work = "C:\\Users\\hry\\Desktop\\tmp\\other\\ocr-1\\";
//        PdfUtilities.splitPdf(work+"netty2.pdf", work+"netty2-1.pdf", "408", "439");

//        File file = PdfUtilities.convertPdf2Tiff(new File(work+"netty2-1.pdf"));
//        FileUtils.copyFile(file, new File(work+"netty2-4.pdf"));

        List<BufferedImage> bufferedImageList = ImageIOHelper.getImageList(new File(work+"netty2-4.tiff"));
        for(BufferedImage bufferedImage : bufferedImageList){
            System.out.println(bufferedImage.getHeight() + "  " + bufferedImage.getWidth());
        }
    }
}
