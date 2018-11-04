package com.hry.java.xml.demo2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlAccessorType(value = XmlAccessType.FIELD)
public class StudentModel2 {

    @XmlAttribute(name = "id")
    private int id; // 学号
    @XmlAttribute(name = "name")
    private String name; // 名称
    @XmlAttribute(name = "sex")
    private String sex; // 性别

    @XmlAttribute(name = "birthDate")
    @XmlJavaTypeAdapter(value = DateXmlAdapter.class) // 配置日期转化器
    private Date birthDate; // 生日


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
