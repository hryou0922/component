package com.hry.java.xml.demo1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 教师
 */
@XmlRootElement(name = "classRoom")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ClassRoomModel {
    @XmlElement(name="name")
    private String name;

    @XmlElement(name="student")
    private List<StudentModel> studentModelList;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentModel> getStudentModelList() {
        return studentModelList;
    }

    public void setStudentModelList(List<StudentModel> studentModelList) {
        this.studentModelList = studentModelList;
    }
}
