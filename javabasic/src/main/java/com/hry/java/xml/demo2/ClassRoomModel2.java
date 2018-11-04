package com.hry.java.xml.demo2;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * 教师
 */
@XmlRootElement(name = "classRoom")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ClassRoomModel2 {
    @XmlElement(name="name")
    private String name;

    @XmlElement(name="student")
    private List<StudentModel2> studentModelList;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentModel2> getStudentModelList() {
        return studentModelList;
    }

    public void setStudentModelList(List<StudentModel2> studentModelList) {
        this.studentModelList = studentModelList;
    }
}
