package com.hry.java.xml.demo1;

import com.alibaba.fastjson.JSON;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;

public class JAXBManager {

    public static void main(String[] args){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ClassRoomModel.class);

            // 从xml文件中读取，并转化为java对象
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            InputStream classRoomInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/hry/java/xml/classroom.xml");
            System.out.println(JAXBManager.class.getClassLoader().getResource(""));
            System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));

            ClassRoomModel classRoomModel = (ClassRoomModel)unmarshaller.unmarshal(classRoomInputStream);
            System.out.println(JSON.toJSONString(classRoomModel));

            // 保存文件，将Java对象转化为xml文件
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(classRoomModel, new File("classroon-save.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

}
