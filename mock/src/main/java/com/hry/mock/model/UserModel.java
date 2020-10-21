package com.hry.mock.model;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2020/10/21 13:43
 */
public class UserModel {
    private String id;

    private String name;

    private String sex;

    public UserModel() {
    }
    public UserModel(String id) {
        this.id = id;
    }

    public UserModel(String id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(id)
            .append(" ").append(this.hashCode());
        return sb.toString();
    }
}
