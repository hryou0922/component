package com.hry.java.img;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Char2Img {
    public static void main(String[] args) throws Exception {
        String rootPath = "C:\\Users\\hry\\Desktop\\tmp\\other\\char2img";
//        createImage("前两年，接诊一个患者。这个患者三十岁，女性，因为发烧一天不退，所以来就诊。我给她仔细检查之后，便开了处方，让她回家服用，多喝水，随时观察变化，如果没有好转再来找我看。因为是个小诊所嘛，护士妹子照着处方就给她拿药。没想到，她一挥手，拿出手机，从处方录到我，又从我录到护士拿着药的手。最后，又专门录了下药品上面的生产日期和批号。正在我纳闷的时候，她对着手机说了一句话：“老公，你记住我是在这家诊所看的病啊！万一我吃药吃死了，你记得拿着视频告他们！”", new Font("宋体", Font.PLAIN, 100), Paths.get(rootPath, "b" + 4000 + ".png").toFile());

        createImage("前两年，接诊一个患者。这个患者三十岁，女性，因为发烧一天不退，所以来就诊。我给她仔细检查之后，便开了处方，让她回家服用，多喝水，随时观察变化，如果没有好转再来找我看。因为是个小诊所嘛，护士妹子照着处方就给她拿药。没想到，她一挥手，拿出手机，从处方录到我，又从我录到护士拿着药的手。最后，又专门录了下药品上面的生产日期和批号。正在我纳闷的时候，她对着手机说了一句话：“老公，你记住我是在这家诊所看的病啊！万一我吃药吃死了，你记得拿着视频告他们！", 32, new File("C:\\Users\\hry\\Desktop\\tmp\\other\\char2img\\a.png"), 640);

    }

    // 根据str,font的样式以及输出文件目录
    public static void createImage(String str, int fontSize, File outFile,
                                   Integer width) throws Exception {

        Font font = new Font("微软雅黑", Font.PLAIN, fontSize);
        // 每个行的字个数
        int charPerLine = (width / 32) ;
        // 行数
        int lineNum = str.length() / charPerLine + 1;
        int height = fontSize * lineNum + 10;
        System.out.println("width : " + width + " , height = " + height + " lineNum = " + lineNum);
        // 创建图片
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.setClip(0, 0, width, height);
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);// 先用黑色填充整张图片,也就是背景
        g.setColor(Color.black);// 在换成黑色
        g.setFont(font);// 设置画笔字体
        /** 用于获得垂直居中y */
        for (int y = 0; y < lineNum; y++) {
            g.drawString(str.substring( y * charPerLine, Math.min((y+1) * charPerLine,str.length())), 0, (y+ 1)* fontSize);// 画出字符串
        }
//        Rectangle clip = g.getClipBounds();
//        FontMetrics fm = g.getFontMetrics(font);
//        int ascent = fm.getAscent();
//        int descent = fm.getDescent();
//        int y = (clip.height - (ascent + descent)) / 2 + ascent;
//        for (int i = 0; i < 6; i++) {// 256 340 0 680
//            g.drawString(str, i * 680, y);// 画出字符串
//        }
        g.dispose();
        ImageIO.write(image, "png", outFile);// 输出png图片
    }


//    private static int[] getWidthAndHeight(String text, Font font) {
//        Rectangle2D r = font.getStringBounds(text, new FontRenderContext(
//                AffineTransform.getScaleInstance(1, 1), false, false));
//        int unitHeight = (int) Math.floor(r.getHeight());//
//        // 获取整个str用了font样式的宽度这里用四舍五入后+1保证宽度绝对能容纳这个字符串作为图片的宽度
//        int width = (int) Math.round(r.getWidth()) + 1;
//        // 把单个字符的高度+3保证高度绝对能容纳字符串作为图片的高度
//        int height = unitHeight + 3;
//        System.out.println("width:" + width + ", height:" + height);
//        return new int[]{width, height};
//    }
//
//    // 根据str,font的样式以及输出文件目录
//    public static void createImage(String text, Font font, File outFile)
//            throws Exception {
//        // 获取font的样式应用在str上的整个矩形
//        int[] arr = getWidthAndHeight(text, font);
//        int width = arr[0];
//        int height = arr[1];
//        // 创建图片
//        BufferedImage image = new BufferedImage(width, height,
//                BufferedImage.TYPE_INT_BGR);//创建图片画布
//        Graphics g = image.getGraphics();
//        g.setColor(Color.WHITE); // 先用白色填充整张图片,也就是背景
//        g.fillRect(0, 0, width, height);//画出矩形区域，以便于在矩形区域内写入文字
//        g.setColor(Color.black);// 再换成黑色，以便于写入文字
//        g.setFont(font);// 设置画笔字体
//        g.drawString(text, 0, font.getSize());// 画出一行字符串
//        g.drawString(text, 0, 2 * font.getSize());// 画出第二行字符串，注意y轴坐标需要变动
//        g.dispose();
//        ImageIO.write(image, "png", outFile);// 输出png图片
//    }
}
