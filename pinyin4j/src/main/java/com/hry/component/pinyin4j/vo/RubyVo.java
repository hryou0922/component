package com.hry.component.pinyin4j.vo;

/**
 *
 * <ruby>
 *     这是一个汉字
 *     <rp>(zhè shì yī gè hàn zì)</rp>
 *     <rt>zhè shì yī gè hàn zì</rt>
 * </ruby>
 *
 *
 *
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/1 15:22
 */
public class RubyVo {
    private String text;
    private String rp;
    private String rt;

    public RubyVo(String text, String rt) {
        this.text = text;
        this.rp = "(" + rt + ")";
        this.rt = rt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRp() {
        return rp;
    }

    public void setRp(String rp) {
        this.rp = rp;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }
}
