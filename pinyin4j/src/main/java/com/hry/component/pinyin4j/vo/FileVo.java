package com.hry.component.pinyin4j.vo;

import java.util.List;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/1 15:57
 */
public class FileVo {
    /**
     * 文件名称
     */
    private String name;
    /**
     * 文件后缀
     */
    private String suffix;
    /**
     * 父目录
     */
    private String parentDir;
    /**
     * 文件内容
     */
    private List<String> contentList;


    public FileVo() {
        this.name = "";
        this.suffix = "";
        this.contentList = null;
        this.parentDir = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public List<String> getContentList() {
        return contentList;
    }

    public void setContentList(List<String> contentList) {
        this.contentList = contentList;
    }

    public String getParentDir() {
        return parentDir;
    }

    public void setParentDir(String parentDir) {
        this.parentDir = parentDir;
    }
}
