package com.hry.component.httpclient.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Administrator on 2017/7/27.
 */
public class UnsafeDemo {

    /**
     * 获取unsafe的对象
     * 在使用Unsafe之前,我们需要创建Unsafe对象的实例.这并不像Unsafe unsafe = new Unsafe()这么简单,
     * 因为Unsafe的构造器是私有的.它也有一个静态的getUnsafe()方法,但如果你直接调用Unsafe.getUnsafe(),你可能会得到SecurityException异常.
     * 只能从受信任的代码中使用这个方法.
     * 所以需要以反射的方式获取此对象
     *
     * @return
     */
    public Unsafe getUnsafe(){
        Unsafe unsafe = null;
        Field f = null;
        try {
            f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  unsafe;
    }

    public void test(){
        Unsafe unsafe = getUnsafe();
        try {
            // objectFieldOffset(成员变量的所有对象的相对位置), staticFieldOffset 用法
            long nameObjectFieldOffset = unsafe.objectFieldOffset(Student.class.getDeclaredField("name"));
            long ageObjectFieldOffset = unsafe.objectFieldOffset(Student.class.getDeclaredField("age"));
            long typeStaticFieldOffset = unsafe.staticFieldOffset(Student.class.getDeclaredField("TYPE_TEACHER"));
            System.out.println("nameObjectFieldOffset=" +  nameObjectFieldOffset + " ageObjectFieldOffset = " + ageObjectFieldOffset
                + " typeStaticFieldOffset=" + typeStaticFieldOffset);

            // 返回一个class
            Object object = unsafe.staticFieldBase(Student.class.getDeclaredField("TYPE_TEACHER"));
            System.out.println(object);

            // 获取所有的属性
            Class c =  Student.class;
            while (c != Object.class) {
                for (Field f : c.getDeclaredFields()) {
                    if ((f.getModifiers() & Modifier.STATIC) == 0) {
                        System.out.println(f.getName() + "= " + unsafe.objectFieldOffset( Student.class.getDeclaredField(f.getName() ) ));
                    }else{
                        System.out.println(f.getName() + "= " + unsafe.staticFieldOffset( Student.class.getDeclaredField(f.getName() ) ));
                    }
                }
                c = c.getSuperclass();
            }

            System.out.println(unsafe.allocateMemory(100 * 1));

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }



}

class Student{
    private static final int TYPE_TEACHER = 1;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}