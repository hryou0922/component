package com.hry.mock.dto;

/**
 * Mock dto的对象
 * @author: huangrongyou@yixin.im
 * @date: 2019/10/8 19:22
 */
public class MockDto {
    private int age;
    private String name;

    public MockDto(){}

    public MockDto(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
