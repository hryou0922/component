package com.hry.java.xml.demo2;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * XML中字符中和Java对象的转化对象
 */
public class DateXmlAdapter extends XmlAdapter<String, Date> {
    // 时间
    private static final ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocalYYYYMMDD = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    @Override
    public Date unmarshal(String v) throws Exception {
        System.out.println(v);
        return simpleDateFormatThreadLocalYYYYMMDD.get().parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        System.out.println(v);
        return simpleDateFormatThreadLocalYYYYMMDD.get().format(v);
    }
}
