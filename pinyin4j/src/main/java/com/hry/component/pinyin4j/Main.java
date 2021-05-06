package com.hry.component.pinyin4j;

import com.hry.component.pinyin4j.utils.FileUtil;
import com.hry.component.pinyin4j.utils.PinyinUtil;
import com.hry.component.pinyin4j.utils.XmlUtil;
import com.hry.component.pinyin4j.vo.FileVo;
import com.hry.component.pinyin4j.vo.RubyVo;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/1 15:07
 */
public class Main {
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("请输入要解析文本文件的目录");
            return;
        }
    //    String filePath = "D:\\desktop\\tmp\\today\\古诗.txt";
        String filePath = args[0];

        List<RubyVo> rubyVoList = new ArrayList<>();
        FileVo fileVo = FileUtil.readFile(filePath);
        if(fileVo == null){
            System.out.println(filePath + "文件为空或者解析文件失败.");
            return;
        }

        List<String> lineList =  fileVo.getContentList();
        if(lineList == null || lineList.size() == 0){
            System.out.println(filePath + "文件为空或者解析文件失败.");
            return;
        }

        String suffix = fileVo.getSuffix();
        if(suffix != null && "txt".equalsIgnoreCase(suffix)){
            System.out.println(filePath + " 文件格式必须为txt");
            return;
        }


        for(String line : lineList) {
            line = line.trim();
            if(!"".equalsIgnoreCase(line)) {
                RubyVo rubyVo = PinyinUtil.getPinyin(line, " ");
                rubyVoList.add(rubyVo);
            }
        }
        // 保存目录
        String saveXmlFile = fileVo.getParentDir() + File.separator + fileVo.getName() + ".html";
        XmlUtil.saveXmlFile(rubyVoList, saveXmlFile);
    }
}
