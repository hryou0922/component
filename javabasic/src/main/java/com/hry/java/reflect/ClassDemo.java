package com.hry.java.reflect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangrongyou@yixin.im on 2018/11/8.
 */
public class ClassDemo {

    public void classTest (){

        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());


        // Arrays: [interface java.lang.Cloneable, interface java.io.Serializable]
        String[] arrays = new String[1];
        System.out.println(Arrays.toString(arrays.getClass().getInterfaces()));
        // null
        System.out.println(arrays.getClass().getPackage());
        // null
        System.out.println(arrays.getClass().getDeclaringClass());

        // Map
        Map<String,Object> map = new HashMap<>();
        //
        System.out.println(Arrays.toString(map.getClass().getGenericInterfaces()));
        // package java.util, Java Platform API Specification, version 1.8
        System.out.println(map.getClass().getPackage());
        // null
        System.out.println(map.getClass().getDeclaringClass());
        // [K, V]
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        // java.util.AbstractMap<K, V>
        System.out.println(map.getClass().getGenericSuperclass());

    }
}
