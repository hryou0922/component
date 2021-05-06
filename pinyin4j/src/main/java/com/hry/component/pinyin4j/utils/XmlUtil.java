package com.hry.component.pinyin4j.utils;

import com.hry.component.pinyin4j.vo.RubyVo;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * 单个节点：
 *  <ruby>
 *     这是一个汉字
 *     <rp>(zhè shì yī gè hàn zì)</rp>
 *     <rt>zhè shì yī gè hàn zì</rt>
 * </ruby>
 *
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/1 15:25
 */
public class XmlUtil {

    /**
     * 生成xml
     * @param rubyVoList
     * @return
     */
    public static void saveXmlFile(List<RubyVo> rubyVoList, String saveFile){
        if(rubyVoList == null){
            return;
        }
        Document document = DocumentHelper.createDocument();
        Element rootEle = document.addElement("html");
        for(RubyVo rubyVo : rubyVoList){
            Element rubyEle = rootEle.addElement("ruby");
            rubyEle.addText(rubyVo.getText());
            rubyEle.addElement("rp").addText(rubyVo.getRp());
            rubyEle.addElement("rt").addText(rubyVo.getRt());
            // 添加br
            rootEle.addElement("br");

          //  System.out.println(rubyVo.getText() + " " + rubyVo.getRp());
        }

        write(document, saveFile);
    }

    private static void write(Document document, String saveFile){
        // 指定文件
        XMLWriter writer = null;
        try {
            // 美化格式
            OutputFormat format = OutputFormat.createPrettyPrint();
            // writer = new XMLWriter( new FileWriter(saveFile), format );
            writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(saveFile),"utf-8"),format);
            writer.write( document );
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
