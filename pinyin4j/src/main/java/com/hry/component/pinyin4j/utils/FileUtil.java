package com.hry.component.pinyin4j.utils;

import com.hry.component.pinyin4j.vo.FileVo;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/1 15:38
 */
public class FileUtil {

    /**
     * 读取文件
     * @param filePath
     * @return
     */
    public static FileVo readFile(String filePath){
        if(filePath == null || filePath.trim().equalsIgnoreCase("")){
            return null;
        }
        File f = new File(filePath);
        if(!f.isFile()){
            System.out.println(filePath + " not file");
            return null;
        }

        FileVo fileVo = new FileVo();


        try {
            String name = f.getName();
            String parentDir = f.getParent();
            String suffix = "";
            int dotIndex = name.lastIndexOf(".");
            if(dotIndex >= 0){
                suffix = name.substring(dotIndex);
                name = name.substring(0, dotIndex);
            }
            List<String> lineList = FileUtils.readLines(f, "utf-8");

            fileVo.setName(name);
            fileVo.setSuffix(suffix);
            fileVo.setContentList(lineList);
            fileVo.setParentDir(parentDir);
        } catch (IOException e) {
            System.out.println(filePath + " not file. parser error");
        }

        return fileVo;
    }

}
